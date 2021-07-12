package su.nsk.iae.post.naming

import java.util.stream.Stream
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import su.nsk.iae.post.poST.FunctionBlock
import su.nsk.iae.post.poST.Process
import su.nsk.iae.post.poST.Program
import su.nsk.iae.post.poST.StatementList
import su.nsk.iae.post.poST.SymbolicVariable
import su.nsk.iae.post.poST.TemplateProcessConfElement
import su.nsk.iae.post.poST.VarInitDeclaration

import static extension org.eclipse.xtext.EcoreUtil2.*

class PoSTQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	def QualifiedName qualifiedPoSTName(Object ele) {
		return qualifiedName(ele)
	}
	
	override protected QualifiedName qualifiedName(Object ele) {
		if (ele instanceof SymbolicVariable) {
			if (ele.checkVarInitDeclaration) {
				return ele.varInitDeclarationQualifiedName(ele.name)
			}
			if (ele.checkStatementList) {
				return ele.codeQualifiedName(ele.name)
			}
			if (ele.checkTemplateProcessConfElement) {
				return ele.processVarAttachQualifiedName(ele.name)
			}
		}
		return super.qualifiedName(ele)	
	}
	
	private def boolean checkStatementList(EObject ele) {
		return ele.getContainerOfType(StatementList) !== null
	}
	
	private def boolean checkVarInitDeclaration(EObject ele) {
		return ele.getContainerOfType(VarInitDeclaration) !== null
	}
	
	private def boolean checkTemplateProcessConfElement(EObject ele) {
		return ele.getContainerOfType(TemplateProcessConfElement) !== null
	}
	
	private def QualifiedName codeQualifiedName(EObject ele, String name) {
		val process = ele.getContainerOfType(Process)
		val program = process.getContainerOfType(Program)
		if (process.checkProcessVars(name)) {
			return QualifiedName.create(program.name, process.name, name)
		}
		if (program.checkProgramVars(name)) {
			return QualifiedName.create(program.name, name)
		}
		val fb = process.getContainerOfType(FunctionBlock)
		if (process.checkProcessVars(name)) {
			return QualifiedName.create(fb.name, process.name, name)
		}
		if (fb.checFBVars(name)) {
			return QualifiedName.create(fb.name, name)
		}
		return QualifiedName.create(name)
	}
	
	private def QualifiedName varInitDeclarationQualifiedName(EObject ele, String name) {
		val program = ele.getContainerOfType(Program)
		if (program !== null) {
			val process = ele.getContainerOfType(Process)
			if (process !== null) {
				return QualifiedName.create(program.name, process.name, name)
			}
			return QualifiedName.create(program.name, name)
		}
		return QualifiedName.create(name)
	}
	
	private def QualifiedName processVarAttachQualifiedName(EObject ele, String name) {
		return QualifiedName.create(name)
	}
	
	static def boolean checkProcesses(Program program, String eleName) {
		return program.processes.stream.anyMatch([x | x.name.equals(eleName)])
	}
	
	static def boolean checkProcesses(FunctionBlock program, String eleName) {
		return program.processes.stream.anyMatch([x | x.name.equals(eleName)])
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
	
	static def boolean checFBVars(FunctionBlock fb, String eleName) {
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
			process.procTempVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
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