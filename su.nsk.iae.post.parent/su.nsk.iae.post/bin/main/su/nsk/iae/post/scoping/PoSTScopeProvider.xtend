package su.nsk.iae.post.scoping

import java.util.Collections
import java.util.stream.Collectors
import java.util.stream.Stream
import javax.inject.Inject
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import su.nsk.iae.post.library.PoSTLibraryProvider
import su.nsk.iae.post.poST.FBInvocation
import su.nsk.iae.post.poST.Function
import su.nsk.iae.post.poST.FunctionBlock
import su.nsk.iae.post.poST.FunctionCall
import su.nsk.iae.post.poST.GlobalVarDeclaration
import su.nsk.iae.post.poST.Model
import su.nsk.iae.post.poST.PoSTPackage
import su.nsk.iae.post.poST.Process
import su.nsk.iae.post.poST.Program
import su.nsk.iae.post.poST.ProgramConfiguration
import su.nsk.iae.post.poST.Resource
import su.nsk.iae.post.poST.SymbolicVariable
import su.nsk.iae.post.poST.TemplateProcessConfElement
import su.nsk.iae.post.poST.VarInitDeclaration

import static extension org.eclipse.xtext.EcoreUtil2.*

class PoSTScopeProvider extends AbstractPoSTScopeProvider {
	
	val ePackage = PoSTPackage.eINSTANCE
	val libraryProvider = new PoSTLibraryProvider
	
	@Inject
	IQualifiedNameProvider qualifiedNameProvider

	override getScope(EObject context, EReference reference) {
		switch reference {
			case ePackage.primaryExpression_Variable,
			case ePackage.assignmentStatement_Variable,
			case ePackage.arrayVariable_Variable,
			case ePackage.forStatement_Variable:
				return context.scopeForStatementExpression_Variable
			case ePackage.functionCall_Function:
				return context.scopeForFunctionCall_Function
			case ePackage.varInitDeclaration_Fb:
				return context.scopeForVarInitDeclaration_Fb
			case ePackage.paramAssignment_Variable:
				return context.scopeForParamAssignment_Variable
			case ePackage.attachVariableConfElement_ProgramVar:
				return context.scopeForAttachVariableConfElement_ProgramVar
			case ePackage.templateProcessAttachVariableConfElement_ProgramVar: 
				return context.scopeForTemplateProcessAttachVariableConfElement_ProgramVar
			case ePackage.templateProcessConfElement_Process: 
				return context.scopeForTemplateProcessConfElement_Process
			case ePackage.processStatements_Process,
			case ePackage.processStatusExpression_Process:
				return context.scopeForProcessStatements_Process
			case ePackage.setStateStatement_State:
				return context.scopeForSetStateStatement_State
			case ePackage.programConfiguration_Task:
				return context.scopeForProgramConfiguration_Task
		}
		return super.getScope(context, reference)
	}
	
	private def IScope scopeFor(Iterable<? extends EObject> elements) {
		return Scopes.scopeFor(elements, [x | qualifiedNameProvider.getFullyQualifiedName(x)], IScope.NULLSCOPE)
	}
	
	private def IScope scopeForStatementExpression_Variable(EObject context) {
		val model = context.getContainerOfType(Model)
		val program = context.getContainerOfType(Program)
		val process = context.getContainerOfType(Process)
		return scopeFor(getAvailableVar(model, program, process))
	}
	
	private def IScope scopeForFunctionCall_Function(EObject context) {
		val model = context.getContainerOfType(Model)
		val res = Stream.concat(
			model.funs.stream,
			libraryProvider.getLibraryFunctions(context).stream
		).collect(Collectors.toList)
		return scopeFor(res)
	}
	
	private def IScope scopeForVarInitDeclaration_Fb(EObject context) {
		val model = context.getContainerOfType(Model)
		val res = Stream.concat(
			model.fbs.stream,
			libraryProvider.getLibraryFunctionBlocks(context).stream
		).collect(Collectors.toList)
		return scopeFor(res)
	}
	
	private def IScope scopeForParamAssignment_Variable(EObject context) {
		if (context.getContainerOfType(FunctionCall) !== null) {
			val function = context.getContainerOfType(FunctionCall).function
			return scopeFor(function.functionInOutVar)
		}
		val fbDecl = context.getContainerOfType(FBInvocation).fb
		val fb = fbDecl.getContainerOfType(VarInitDeclaration).fb
		if (fb !== null) {
			return scopeFor(fb.functionBlockInOutVar)
		}
		return scopeFor(Collections.emptyList)
	}
	
	private def IScope scopeForAttachVariableConfElement_ProgramVar(EObject context) {
		val programConf = context.getContainerOfType(ProgramConfiguration)
		return scopeFor(programConf.program.programInOutVar)
	}
	
	private def IScope scopeForTemplateProcessAttachVariableConfElement_ProgramVar(EObject context) {
		val processConf = context.getContainerOfType(TemplateProcessConfElement)
		return scopeFor(processConf.process.processTemplateVar)
	}
	
	private def IScope scopeForTemplateProcessConfElement_Process(EObject context) {
		val programConf = context.getContainerOfType(ProgramConfiguration)
		return scopeFor(programConf.program.processes)
	}
	
	private def IScope scopeForProcessStatements_Process(EObject context) {
		val process = context.getContainerOfType(Process)
		val program = process.getContainerOfType(Program)
		val res = Stream.concat(
			process.processProcessVar.stream,
			program.processes.stream
		).collect(Collectors.toList)
		return scopeFor(res)
	}
	
	private def IScope scopeForSetStateStatement_State(EObject context) {
		val process = context.getContainerOfType(Process)
		return scopeFor(process.states)
	}
	
	private def IScope scopeForProgramConfiguration_Task(EObject context) {
		val res = context.getContainerOfType(Resource)
		return scopeFor(res.resStatement.tasks)
	}
	
	private def getAvailableVar(Model model, Program program, Process process) {
		var Stream<SymbolicVariable> res = Stream.of()
		if (process !== null) {
			res = Stream.concat(
				res,
				Stream.concat(
					process.processInOutVar.stream,
					process.processVar.stream
				)
			)
		}
		if (program !== null) {
			res = Stream.concat(
				res,
				Stream.concat(
					program.programInOutVar.stream,
					program.programVar.stream
				)
			)
		}
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
	
	private static def getFunctionBlockInOutVar(FunctionBlock fb) {
		return Stream.concat(
			fb.fbInVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			Stream.concat(
				fb.fbOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
				fb.fbInOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
			)
		).flatMap([x | x.stream]).collect(Collectors.toList)
	}
	
	private static def getFunctionInOutVar(Function function) {
		return Stream.concat(
			function.funInVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			Stream.concat(
				function.funOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
				function.funInOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
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
			process.processProcessVar.stream
		).collect(Collectors.toList)
	}
	
	private static def getProcessProcessVar(Process process) {
		return process.procProcessVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream]).collect(Collectors.toList)
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
	
}
