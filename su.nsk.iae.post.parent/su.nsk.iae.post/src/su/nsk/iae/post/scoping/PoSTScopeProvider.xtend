package su.nsk.iae.post.scoping

import com.google.common.base.Function
import java.util.stream.Collectors
import java.util.stream.Stream
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import su.nsk.iae.post.library.PoSTLibraryProvider
import su.nsk.iae.post.naming.PoSTQualifiedNameProvider
import su.nsk.iae.post.poST.GlobalVarDeclaration
import su.nsk.iae.post.poST.Model
import su.nsk.iae.post.poST.PoSTPackage
import su.nsk.iae.post.poST.Process
import su.nsk.iae.post.poST.Program
import su.nsk.iae.post.poST.ProgramConfiguration
import su.nsk.iae.post.poST.TemplateProcessConfElement

import static extension org.eclipse.xtext.EcoreUtil2.*

class PoSTScopeProvider extends AbstractPoSTScopeProvider {
	
	val ePackage = PoSTPackage.eINSTANCE
	val libraryProvider = new PoSTLibraryProvider
	
	def IScope getPoSTScope(EObject context, EReference reference) {
		return getScope(context, reference, false)
	}

	override getScope(EObject context, EReference reference) {
		val scope = getScope(context, reference, true)
		if (scope !== null) {
			return scope
		}
		return super.getScope(context, reference)
	}
	
	def IScope getScope(EObject context, EReference reference, boolean simple) {
		switch reference {
			case ePackage.assignmentStatement_Variable,
			case ePackage.primaryExpression_Variable: 
				return scopeForAssignmentStatementAndPrimaryExpression_Variable(context, reference, simple)
			case ePackage.functionCall_Function:
				return scopeForFunctionCall_Function(context, reference, simple)
			case ePackage.attachVariableConfElement_ProgramVar:
				return scopeForAttachVariableConfElement_ProgramVar(context, reference, simple)
			case ePackage.templateProcessAttachVariableConfElement_ProgramVar: 
				return scopeForTemplateProcessAttachVariableConfElement_ProgramVar(context, reference, simple)
			case ePackage.templateProcessConfElement_Process: 
				return scopeForTemplateProcessConfElement_Process(context, reference, simple)
		}
		return null
	}
	
	private def IScope scopeForVar(Iterable<? extends EObject> elements, boolean simple) {
		if (simple) {
			return Scopes.scopeFor(elements)
		}
		return Scopes.scopeFor(elements, new PoSTScope, IScope.NULLSCOPE)
	}
	
	private def IScope scopeSuper(EObject context, EReference reference, Iterable<? extends EObject> elements, boolean simple) {
		if (simple) {
			return Scopes.scopeFor(elements)
		}
		return super.getScope(context, reference)
	}
	
	private def IScope scopeForAssignmentStatementAndPrimaryExpression_Variable(EObject context, EReference reference, boolean simple) {
		val process = context.getContainerOfType(Process)
		if (process !== null) {
			val program = process.getContainerOfType(Program)
			val model = program.getContainerOfType(Model)
			return scopeForVar(getAvailableVar(model, program, process), simple)
		}
		return null
	}
	
	private def IScope scopeForFunctionCall_Function(EObject context, EReference reference, boolean simple) {
		return scopeSuper(context, reference, libraryProvider.getLibraryFunctions(context), simple)
	}
	
	private def IScope scopeForAttachVariableConfElement_ProgramVar(EObject context, EReference reference, boolean simple) {
		val programConf = context.getContainerOfType(ProgramConfiguration)
		return scopeForVar(programConf.program.programInOutVar, simple)
	}
	
	private def IScope scopeForTemplateProcessAttachVariableConfElement_ProgramVar(EObject context, EReference reference, boolean simple) {
		val processConf = context.getContainerOfType(TemplateProcessConfElement)
		return scopeForVar(processConf.process.processTemplateVar, simple)
	}
	
	private def IScope scopeForTemplateProcessConfElement_Process(EObject context, EReference reference, boolean simple) {
		val programConf = context.getContainerOfType(ProgramConfiguration)
		return scopeSuper(context, reference, programConf.program.processes, simple)
	}
	
	private def getAvailableVar(Model model, Program program, Process process) {
		var res = Stream.concat(
			Stream.concat(
				process.processInOutVar.stream,
				process.processVar.stream
			),
			Stream.concat(
				program.programInOutVar.stream,
				program.programVar.stream
			)
		)
		res = Stream.concat(res, model.globVars.globalVars.stream)
		val conf = model.conf
		if (conf !== null) {
			val resources = model.conf.resources
			res = Stream.concat(
				res,
				Stream.concat(
					conf.confGlobVars.globalVars.stream,
					resources.stream.map([x | x.resGlobVars.globalVars]).flatMap([x | x.stream])
				)
			)
		}
		return res.collect(Collectors.toList)
	}
	
	private static def getGlobalVars(EList<GlobalVarDeclaration> list) {
		return Stream.concat(
			list.stream.map([x | x.varsSimple]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			list.stream.map([x | x.varsAs]).flatMap([x | x.stream]).map([x | x.varList.vars])
		).flatMap([x | x.stream]).collect(Collectors.toList)
	}

	private static def getProgramInOutVar(Program program) {
		return Stream.concat(
			program.progInVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			Stream.concat(
				program.progOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
				program.progInOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
			)
		).flatMap([x | x.stream]).collect(Collectors.toList)
	}
	
	private static def getProgramVar(Program program) {
		return Stream.concat(
			program.progVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			Stream.concat(
				program.progTempVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
				program.progExternVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
			)
		).flatMap([x | x.stream]).collect(Collectors.toList)
	}

	private static def getProcessTemplateVar(Process process) {
		return Stream.concat(
			process.processInOutVar.stream,
			process.procProcessVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream])
		).collect(Collectors.toList)
	}
	
	private static def getProcessInOutVar(Process process) {
		return Stream.concat(
			process.procInVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			Stream.concat(
				process.procOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
				process.procInOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
			)
		).flatMap([x | x.stream]).collect(Collectors.toList)
	}
	
	private static def getProcessVar(Process process) {
		return Stream.concat(
			process.procVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			process.procTempVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
		).flatMap([x | x.stream]).collect(Collectors.toList)
	}
	
	static class PoSTScope <T extends EObject> implements Function<T, QualifiedName> {
		static val qualifiedNameProvider = new PoSTQualifiedNameProvider;
		override apply(T ele) {
			return qualifiedNameProvider.qualifiedPoSTName(ele)
		}
	}
}
