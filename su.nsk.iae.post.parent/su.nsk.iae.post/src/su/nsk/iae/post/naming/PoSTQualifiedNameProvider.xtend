package su.nsk.iae.post.naming

import java.util.stream.Stream
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import su.nsk.iae.post.poST.FunctionBlock
import su.nsk.iae.post.poST.Process
import su.nsk.iae.post.poST.Program
import su.nsk.iae.post.poST.SymbolicVariable
import su.nsk.iae.post.poST.VarInitDeclaration

import static extension org.eclipse.xtext.EcoreUtil2.*

class PoSTQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	def QualifiedName qualifiedPoSTName(Object ele) {
		return qualifiedName(ele)
	}
	
	override protected QualifiedName qualifiedName(Object ele) {
		if (ele instanceof SymbolicVariable) {
			if (ele.checkVarInitDeclaration) {
				return ele.varInitDeclarationQualifiedName
			}
		}
		if (ele instanceof Process) {
			ele.processQualifiedName
		}
		return super.qualifiedName(ele)	
	}
	
	private def boolean checkVarInitDeclaration(EObject ele) {
		return ele.getContainerOfType(VarInitDeclaration) !== null
	}
	
	private def QualifiedName varInitDeclarationQualifiedName(SymbolicVariable ele) {
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
	
	private def QualifiedName processQualifiedName(Process ele) {
		val program = ele.getContainerOfType(Program)
		return QualifiedName.create(program.name, ele.name)
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