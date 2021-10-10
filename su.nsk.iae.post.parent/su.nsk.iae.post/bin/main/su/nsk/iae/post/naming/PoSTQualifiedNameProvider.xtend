package su.nsk.iae.post.naming

import java.util.stream.Stream
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import su.nsk.iae.post.poST.Function
import su.nsk.iae.post.poST.FunctionBlock
import su.nsk.iae.post.poST.Process
import su.nsk.iae.post.poST.ProcessVarInitDeclaration
import su.nsk.iae.post.poST.Program
import su.nsk.iae.post.poST.ProgramConfiguration
import su.nsk.iae.post.poST.Resource
import su.nsk.iae.post.poST.StatementList
import su.nsk.iae.post.poST.SymbolicVariable
import su.nsk.iae.post.poST.Task
import su.nsk.iae.post.poST.TemplateProcessConfElement
import su.nsk.iae.post.poST.VarInitDeclaration

import static extension org.eclipse.xtext.EcoreUtil2.*

class PoSTQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	override protected QualifiedName qualifiedName(Object ele) {
		switch ele {
			SymbolicVariable:
				return ele.symbolicVariableQualifiedName
			TemplateProcessConfElement:
				return ele.templateProcessConfElementQualifiedName
			Task:
				return ele.taskQualifiedName
			Program:
				return QualifiedName.create(ele.name)
			FunctionBlock:
				return QualifiedName.create(ele.name)
			Function:
				return QualifiedName.create(ele.name)
		}
		return super.qualifiedName(ele)	
	}
	
	private def QualifiedName getSymbolicVariableQualifiedName(SymbolicVariable ele) {
		if (ele.checkVarInitDeclaration) {
			return ele.initVariableQualifiedName
		}
		if (ele.checkStatementList) {
			return ele.variableQualifiedName
		}
		return QualifiedName.create(ele.name)
	}
	
	private def QualifiedName getTemplateProcessConfElementQualifiedName(TemplateProcessConfElement ele) {
		val res = ele.getContainerOfType(Resource)
		val programConf = ele.getContainerOfType(ProgramConfiguration)
		return QualifiedName.create(res.name, programConf.name, ele.name)
	}
	
	private def QualifiedName getTaskQualifiedName(Task ele) {
		val res = ele.getContainerOfType(Resource)
		return QualifiedName.create(res.name, ele.name)
	}
	
	private def boolean checkVarInitDeclaration(EObject ele) {
		return (ele.getContainerOfType(VarInitDeclaration) !== null) || (ele.getContainerOfType(ProcessVarInitDeclaration) !== null)
	}
	
	private def boolean checkStatementList(EObject ele) {
		return ele.getContainerOfType(StatementList) !== null
	}
	
	private def QualifiedName getInitVariableQualifiedName(SymbolicVariable ele) {
		val program = ele.getContainerOfType(Program)
		if (program !== null) {
			val process = ele.getContainerOfType(Process)
			if (process !== null) {
				return QualifiedName.create(program.name, process.name, ele.name)
			}
			return QualifiedName.create(program.name, ele.name)
		}
		return QualifiedName.create(ele.name)
	}
	
	private def QualifiedName getVariableQualifiedName(SymbolicVariable ele) {
		val program = ele.getContainerOfType(Program)
		if (program !== null) {
			val process = ele.getContainerOfType(Process)
			if ((process !== null) && process.checkProcessVars(ele.name)) {
				return QualifiedName.create(program.name, process.name, ele.name)
			}
			if (program.checkProgramVars(ele.name)) {
				return QualifiedName.create(program.name, ele.name)
			}
		}
		return QualifiedName.create(ele.name)
	}
	
	static def boolean checkProgramVars(Program program, String eleName) {
		return Stream.concat(
			program.progVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			program.progTempVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
		).flatMap([x | x.stream]).anyMatch([x | x.name.equals(eleName)])
		|| program.checkProgramInOutVars(eleName)
	}
	
	static def boolean checkProgramInOutVars(Program program, String eleName) {
		return Stream.concat(
			program.progInVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			Stream.concat(
				program.progOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
				program.progInOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
			)
		).flatMap([x | x.stream]).anyMatch([x | x.name.equals(eleName)])
	}
	
	static def boolean checkFBVars(FunctionBlock fb, String eleName) {
		return Stream.concat(
			fb.fbVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			fb.fbTempVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
		).flatMap([x | x.stream]).anyMatch([x | x.name.equals(eleName)])
		|| fb.checkFBInOutVars(eleName)
	}
	
	static def boolean checkFBInOutVars(FunctionBlock fb, String eleName) {
		return Stream.concat(
			fb.fbInVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			Stream.concat(
				fb.fbOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
				fb.fbInOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
			)
		).flatMap([x | x.stream]).anyMatch([x | x.name.equals(eleName)])
	}
	
	static def boolean checkProcessVars(Process process, String eleName) {
		return Stream.concat(
			process.procVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			Stream.concat(
				process.procTempVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
				process.procProcessVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
			)
			
		).flatMap([x | x.stream]).anyMatch([x | x.name.equals(eleName)])
		|| process.checkProcessInOutVars(eleName)
	}
	
	static def boolean checkProcessInOutVars(Process process, String eleName) {
		return Stream.concat(
			process.procInVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			Stream.concat(
				process.procOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
				process.procInOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
			)
		).flatMap([x | x.stream]).anyMatch([x | x.name.equals(eleName)])
	}
}