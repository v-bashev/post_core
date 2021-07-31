package su.nsk.iae.post.scoping

import com.google.common.base.Function
import java.util.stream.Collectors
import java.util.stream.Stream
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import su.nsk.iae.post.naming.PoSTQualifiedNameProvider
import su.nsk.iae.post.poST.PoSTPackage
import su.nsk.iae.post.poST.Process
import su.nsk.iae.post.poST.Program
import su.nsk.iae.post.poST.ProgramConfiguration
import su.nsk.iae.post.poST.TemplateProcessConfElement

import static extension org.eclipse.xtext.EcoreUtil2.*
import su.nsk.iae.post.poST.Model
import org.eclipse.emf.common.util.EList
import su.nsk.iae.post.poST.GlobalVarDeclaration

class PoSTScopeProvider extends AbstractPoSTScopeProvider {
	
	val ePackage = PoSTPackage.eINSTANCE
	
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
		if (reference == ePackage.attachVariableConfElement_ProgramVar) {
			val programConf = context.getContainerOfType(ProgramConfiguration)
			return scopeForVar(programConf.program.programInOutVar, simple)
		}
		if (reference == ePackage.templateProcessAttachVariableConfElement_ProgramVar) {
			val processConf = context.getContainerOfType(TemplateProcessConfElement)
			return scopeForVar(processConf.process.processTemplateVar, simple)
		}
		if (reference == ePackage.templateProcessConfElement_Process) {
			val programConf = context.getContainerOfType(ProgramConfiguration)
			return scopeSuper(context, reference, programConf.program.processList, simple)
		}
		if (reference == ePackage.assignmentStatement_Variable) {
			val process = context.getContainerOfType(Process)
			if (process !== null) {
				val program = process.getContainerOfType(Program)
				val model = program.getContainerOfType(Model)
				return scopeForVar(getAvailableVar(model, program, process), simple)
			}
		}
		return null
	}
	
	def IScope scopeForVar(Iterable<? extends EObject> elements, boolean simple) {
		if (simple) {
			return Scopes.scopeFor(elements)
		}
		return Scopes.scopeFor(elements, new PoSTScope, IScope.NULLSCOPE)
	}
	
	def IScope scopeSuper(EObject context, EReference reference, Iterable<? extends EObject> elements, boolean simple) {
		if (simple) {
			return Scopes.scopeFor(elements)
		}
		return super.getScope(context, reference)
	}
	
	private def getProcessList(Program program) {
		return program.processes.stream
				.filter([x | !x.procInVars.empty || !x.procOutVars.empty || !x.procInOutVars.empty || !x.procProcessVars.empty])
				.collect(Collectors.toList)
	}
	
	private def getAvailableVar(Model model, Program program, Process process) {
		val conf = model.conf
		val resources = model.conf.resources
		return Stream.concat(
			Stream.concat(
				Stream.concat(
					process.processInOutVar.stream,
					process.processVar.stream
				),
				Stream.concat(
					program.programInOutVar.stream,
					program.programVar.stream
				)
			),
			Stream.concat(
				model.globVars.globalVars.stream,
				Stream.concat(
					conf.confGlobVars.globalVars.stream,
					resources.stream.map([x | x.resGlobVars.globalVars]).flatMap([x | x.stream])
				)
			)
		).collect(Collectors.toList)
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
