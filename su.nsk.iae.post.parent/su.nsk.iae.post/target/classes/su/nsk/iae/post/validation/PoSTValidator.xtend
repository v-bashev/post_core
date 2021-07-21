package su.nsk.iae.post.validation

import java.util.ArrayList
import java.util.HashSet
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.validation.Check
import su.nsk.iae.post.poST.AssignmentStatement
import su.nsk.iae.post.poST.AssignmentType
import su.nsk.iae.post.poST.AttachVariableConfElement
import su.nsk.iae.post.poST.Configuration
import su.nsk.iae.post.poST.ErrorProcessStatement
import su.nsk.iae.post.poST.ExternalVarDeclaration
import su.nsk.iae.post.poST.ExternalVarInitDeclaration
import su.nsk.iae.post.poST.FunctionBlock
import su.nsk.iae.post.poST.GlobalVarDeclaration
import su.nsk.iae.post.poST.GlobalVarInitDeclaration
import su.nsk.iae.post.poST.InputOutputVarDeclaration
import su.nsk.iae.post.poST.InputVarDeclaration
import su.nsk.iae.post.poST.Model
import su.nsk.iae.post.poST.OutputVarDeclaration
import su.nsk.iae.post.poST.PoSTPackage
import su.nsk.iae.post.poST.Process
import su.nsk.iae.post.poST.ProcessStatusExpression
import su.nsk.iae.post.poST.Program
import su.nsk.iae.post.poST.ProgramConfiguration
import su.nsk.iae.post.poST.Resource
import su.nsk.iae.post.poST.SetStateStatement
import su.nsk.iae.post.poST.SimpleSpecificationInit
import su.nsk.iae.post.poST.StartProcessStatement
import su.nsk.iae.post.poST.Statement
import su.nsk.iae.post.poST.StopProcessStatement
import su.nsk.iae.post.poST.SymbolicVariable
import su.nsk.iae.post.poST.Task
import su.nsk.iae.post.poST.TempVarDeclaration
import su.nsk.iae.post.poST.TemplateProcessConfElement
import su.nsk.iae.post.poST.TimeoutStatement
import su.nsk.iae.post.poST.VarDeclaration
import su.nsk.iae.post.poST.VarInitDeclaration

import static extension org.eclipse.xtext.EcoreUtil2.*

class PoSTValidator extends AbstractPoSTValidator {
	
	val ePackage = PoSTPackage.eINSTANCE
	
/* ======================= START Variables Checks ======================= */

	@Check
	def checkSymbolicVariable_NameConflicts(SymbolicVariable ele) {
		val process = ele.getContainerOfType(Process)
		if ((process !== null) && process.checkNameRepetition(ele)) {
			error("Name error: Process already has a variable with this name",
					ePackage.symbolicVariable_Name)
			return
		}
		val program = ele.getContainerOfType(Program)
		if ((program !== null) && program.checkNameRepetition(ele)) {
			error("Name error: Program already has a variable with this name",
					ePackage.symbolicVariable_Name)
			return
		}
		val resource = ele.getContainerOfType(Resource)
		if ((resource !== null) && resource.checkNameRepetition(ele)) {
			error("Name error: Resource already has a variable with this name",
					ePackage.symbolicVariable_Name)
			return
		}
		val configuration = ele.getContainerOfType(Configuration)
		if ((configuration !== null) && configuration.checkNameRepetition(ele)) {
			error("Name error: Configuration already has a variable with this name",
					ePackage.symbolicVariable_Name)
			return
		}
		val model = ele.getContainerOfType(Model)
		if (model.checkNameRepetition(ele)) {
			error("Name error: Conflict with the name of a global variable",
					ePackage.symbolicVariable_Name)
			return
		}
	}
	
	@Check
	def checkSymbolicVariable_NeverUse(SymbolicVariable ele) {
		val model = ele.getContainerOfType(Model)
		if (!hasCrossReferences(model, ele)) {
			warning("Variable is never use", ePackage.symbolicVariable_Name)
		}
	}
	
	@Check
	def checkSimpleSpecificationInit_NeverUse(SimpleSpecificationInit ele) {
		if (ele.value !== null) {
			if (ele.checkContainer(InputVarDeclaration)) {
				error("Initialization error: Input variable cannot be initialized",
						ePackage.simpleSpecificationInit_Value)
				return
			}
			
			if (ele.checkContainer(OutputVarDeclaration)) {
				error("Initialization error: Output variable cannot be initialized",
						ePackage.simpleSpecificationInit_Value)
				return
			}
			
			if (ele.checkContainer(InputOutputVarDeclaration)) {
				error("Initialization error: InputOutput variable cannot be initialized",
						ePackage.simpleSpecificationInit_Value)
				return
			}
		}
	}
	

/* ======================= END Variables Checks ======================= */

/* ======================= START Configuration Checks ======================= */

	@Check
	def checkResource_NameConflicts(Resource ele) {
		val configuration = ele.getContainerOfType(Configuration)
		if ((configuration !== null) && configuration.checkNameRepetition(ele)) {
			error("Name error: Configuration already has a Resource with this name",
					ePackage.resource_Name)
		}
	}
	
	@Check
	def checkTask_NameConflicts(Task ele) {
		val resource = ele.getContainerOfType(Resource)
		if ((resource !== null) && resource.checkNameRepetition(ele)) {
			error("Name error: Resource already has a Task with this name",
					ePackage.task_Name)
		}
	}
	
	@Check
	def checkProgramConfiguration_NameConflicts(ProgramConfiguration ele) {
		val resource = ele.getContainerOfType(Resource)
		if ((resource !== null) && resource.checkNameRepetition(ele)) {
			error("Name error: Resource already has a Attached Program with this name",
					ePackage.programConfiguration_Name)
		}
	}
	
	@Check
	def checkTemplateProcessConfElement_NameConflicts(TemplateProcessConfElement ele) {
		val rogramConf = ele.getContainerOfType(ProgramConfiguration)
		if ((rogramConf !== null) && rogramConf.checkNameRepetition(ele)) {
			error("Name error: Program already has a Template Process with this name",
					ePackage.templateProcessConfElement_Name)
		}
	}
	
	@Check
	def checkProgramConfiguration_NumberOfArgs(ProgramConfiguration ele) {
		if (ele.args === null) {
			return
		}
		val program = ele.program
		val attachVars = 
			program.progInVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream]).count +
			program.progOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream]).count +
			program.progInOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream]).count
		val programVars = 
			ele.args.elements.stream.filter([x | x instanceof AttachVariableConfElement]).count
		if (attachVars != programVars) {
			error("Attached error: Not all input and output variables are used",
					ePackage.programConfiguration_Name)
		}
	}
	
	@Check
	def checkAttachVariableConfElement_AttachType(AttachVariableConfElement ele) {
		if ((ele.assig == AssignmentType.IN) && !ele.programVar.checkContainer(InputVarDeclaration)) {
			error("Attached error: Must be a input variable",
					ePackage.attachVariableConfElement_ProgramVar);
			return
		} 
		if ((ele.assig == AssignmentType.OUT) && !ele.programVar.checkContainer(OutputVarDeclaration)) {
			error("Attached error: Must be a output variable",
					ePackage.attachVariableConfElement_ProgramVar)
		}
	}

/* ======================= END Configuration Checks ======================= */

/* ======================= START poST Checks ======================= */

	@Check
	def checkProgram_NameConflicts(Program ele) {
		val model = ele.getContainerOfType(Model)
		if (model.checkNameRepetition(ele)) {
			error("Name error: Process or FunctionBlock with this name already exists", ePackage.program_Name)
		}
	}
	
	@Check
	def checkFunctionBlock_NameConflicts(FunctionBlock ele) {
		val model = ele.getContainerOfType(Model)
		if (model.checkNameRepetition(ele)) {
			error("Name error: Process or FunctionBlock with this name already exists", ePackage.functionBlock_Name)
		}
	}

	@Check
	def checkProgram_Empty(Program ele) {
		if (ele.processes.empty) {
			error("Statement error: Program can't be empty", ePackage.program_Name)
		}
	}
	
	@Check
	def checkFunctionBlock_Empty(FunctionBlock ele) {
		if (ele.processes.empty) {
			error("Statement error: FunctionBlock can't be empty", ePackage.functionBlock_Name)
		}
	}
	
	@Check
	def checkProcess_NameConflicts(Process ele) {
		val program = ele.getContainerOfType(Program)
		if ((program !== null) && program.checkNameRepetition(ele)) {
			error("Name error: Program already has a Process with this name", ePackage.process_Name)
			return
		}
		val fb = ele.getContainerOfType(FunctionBlock)
		if (fb.checkNameRepetition(ele)) {
			error("Name error: FunctionBlock already has a Process with this name", ePackage.process_Name)
		}
	}
	
	@Check
	def checkProcess_Empty(Process ele) {
		if (ele.states.empty) {
			error("Statement error: Process can't be empty", ePackage.process_Name)
		}
	}
	
	@Check
	def checkProcess_Unreachable(Process ele) {
		val program = ele.getContainerOfType(Program)
		if (program !== null) {
			if (program.processes.indexOf(ele) === 0) {
				return
			}
			if (!program.processes.checkProcessStart(ele)) {
				warning("Process is unreachable", ePackage.process_Name)
			}
			return
		}
		val fb = ele.getContainerOfType(FunctionBlock)
		if (fb.processes.indexOf(ele) === 0) {
			return
		}
		if (!fb.processes.checkProcessStart(ele)) {
			warning("Process is unreachable", ePackage.process_Name)
		}
	}
	
	@Check
	def checkProcess_NameConflicts(su.nsk.iae.post.poST.State ele) {
		val process = ele.getContainerOfType(Process)
		if (process.checkNameRepetition(ele)) {
			error("Name error: Process already has a State with this name", ePackage.state_Name)
		}
	}
	
	@Check
	def checkProcess_Empty(su.nsk.iae.post.poST.State ele) {
		if (ele.statement.statements.empty && (ele.timeout === null)) {
			error("Statement error: State can't be empty", ePackage.state_Name)
		}
	}
	
	@Check
	def checkProcess_Unreachable(su.nsk.iae.post.poST.State ele) {
		val process = ele.getContainerOfType(Process)
		val stateIndex = process.states.indexOf(ele)
		if (stateIndex === 0 ||
			process.states.checkStateSet(ele) ||
			process.states.checkStateSetNext(stateIndex - 1)
		) {
			return
		}
		warning("State is unreachable", ePackage.state_Name)
	}
	
	@Check
	def checkProcess_Looped(su.nsk.iae.post.poST.State ele) {
		var check = ele.containsType(SetStateStatement)
		if (ele.timeout !== null) {
			check = check || ele.timeout.containsType(SetStateStatement)
		}
		if (ele.looped) {
			if (check) {
				warning("State mustn't be LOOPED", ePackage.state_Name)
			}
		}/* else {
			if (!check) {
				warning("State must be LOOPED", ePackage.state_Name)
			}
		}*/
	}
	
	@Check
	def checkSetStateStatement_NameConflicts(SetStateStatement ele) {
		if (ele.next) {
			return
		}
		val process = ele.getContainerOfType(Process)
		if (!process.states.contains(ele.state)) {
			error("Name error: Process does not contain a State with this name", ePackage.setStateStatement_State)
			return
		}
		val state = ele.getContainerOfType(su.nsk.iae.post.poST.State)
		if (state === ele.state) {
			warning("Useless statement, use RESET TIMER", ePackage.setStateStatement_State)
		}
	}
	
	@Check
	def checkSetStateStatement_Next(SetStateStatement ele) {
		if (!ele.next) {
			return
		}
		val process = ele.getContainerOfType(Process)
		val state = ele.getContainerOfType(su.nsk.iae.post.poST.State)
		if (process.states.last === state) {
			error("Invalid statement: No next state in the Process", ePackage.setStateStatement_Next)
		}
	}
	
	@Check
	def checkStartProcessStatement_NameConflicts(StartProcessStatement ele) {
		if (ele.process === null) {
			return
		}
		val program = ele.getContainerOfType(Program)
		if (!program.processes.contains(ele.process)) {
			error("Name error: Program does not contain a Process with this name", ePackage.processStatements_Process)
		}
	}
	
	@Check
	def checkStopProcessStatement_NameConflicts(StopProcessStatement ele) {
		if (ele.process === null) {
			return
		}
		val program = ele.getContainerOfType(Program)
		if (!program.processes.contains(ele.process)) {
			error("Name error: Program does not contain a Process with this name", ePackage.processStatements_Process)
		}
	}
	
	@Check
	def checkErrorProcessStatement_NameConflicts(ErrorProcessStatement ele) {
		if (ele.process === null) {
			return
		}
		val program = ele.getContainerOfType(Program)
		if (!program.processes.contains(ele.process)) {
			error("Name error: Program does not contain a Process with this name", ePackage.processStatements_Process)
		}
	}
	
	@Check
	def checkProcessStatusExpression_NameConflicts(ProcessStatusExpression ele) {
		val program = ele.getContainerOfType(Program)
		if (!program.processes.contains(ele.process)) {
			error("Name error: Program does not contain a Process with this name", ePackage.processStatusExpression_Process)
		}
	}
	
	@Check
	def checkTimeoutStatement_Empty(TimeoutStatement ele) {
		if (ele.statement.statements.empty) {
			error("Statement error: No reaction on timeout", ePackage.timeoutStatement_Statement)
		}
	}
	
/* ======================= END poST Checks ======================= */

/* ======================= START ST Checks ======================= */
	
	@Check
	def checkAssignmentStatement_Modify(AssignmentStatement ele) {
		val varEle = ele.variable
		if (varEle.checkContainer(InputVarDeclaration)) {
			warning("Modification of input variable", ePackage.assignmentStatement_Variable)
			return
		}
		val varDecl = varEle.getContainerOfType(VarDeclaration)
		val globDecl = varEle.getContainerOfType(GlobalVarDeclaration)
		val extDecl = varEle.getContainerOfType(ExternalVarDeclaration)
		if (((varDecl !== null) && varDecl.const) ||
			((globDecl !== null) && globDecl.const) ||
			((extDecl !== null) && extDecl.const)
		) {
			error("Assignment error: Couldn't modify constant variable", ePackage.assignmentStatement_Variable);
		}
	}
	
/* ======================= END ST Checks ======================= */

	private def boolean hasCrossReferences(EObject context, EObject target) {
		val targetSet = new HashSet<EObject>()
		targetSet.add(target)
		val res = new ArrayList<EReference>()
		val EcoreUtil2.ElementReferenceAcceptor acceptor = 
			[EObject referrer, EObject referenced, EReference reference, int index | {
				res.add(reference)
			}];
		context.findCrossReferences(targetSet, acceptor)
		return !res.isEmpty()
	}
	
	private def <T extends EObject> boolean checkContainer(EObject ele, Class<T> type) {
		return ele.getContainerOfType(type) !== null
	}
	
	private def <T extends Statement> boolean checkProcessStart(EList<Process> processList, Process ele) {
		return processList.stream.filter([x | x !== ele]).anyMatch([x | 
			x.getAllContentsOfType(StartProcessStatement).stream.anyMatch([xx | xx.process === ele])
		])
	}
	
	private def <T extends Statement> boolean checkStateSet(EList<su.nsk.iae.post.poST.State> stateList, su.nsk.iae.post.poST.State ele) {
		return stateList.stream.filter([x | x !== ele]).anyMatch([x | 
			x.getAllContentsOfType(SetStateStatement).stream.anyMatch([xx | xx.state === ele])
		])
	}
	
	private def <T extends Statement> boolean checkStateSetNext(EList<su.nsk.iae.post.poST.State> stateList, int index) {
		return stateList.get(index).getAllContentsOfType(SetStateStatement).stream.anyMatch([xx | xx.next])
	}
	
	private def <T extends Statement> boolean containsType(EObject ele, Class<T> type) {
		/*for (s : list.statements) {
			if (type.isInstance(type)) {
				return true
			}
			if (s instanceof IfStatement) {
				if (s.mainStatement.containsStatement(type)) {
					return true
				}
				for (ss : s.elseIfStatements) {
					if (ss.containsStatement(type)) {
						return true
					}
				}
				if ((s.elseStatement !== null) && s.elseStatement.containsStatement(type)) {
					return true
				}
			}
			if (s instanceof CaseStatement) {
				for (ss : s.caseElements) {
					if (ss.statement.containsStatement(type)) {
						return true
					}
				}
				if ((s.elseStatement !== null) && s.elseStatement.containsStatement(type)) {
					return true
				}
			}
		}
		return false*/
		return ele.getAllContentsOfType(type).size !== 0
	}
	
	private def boolean checkNameRepetition(Model model, Program ele) {
		return model.programs.stream.anyMatch([x | (x !== ele) && x.name.equals(ele.name)]) ||
			   model.fbs.stream.anyMatch([x | x.name.equals(ele.name)])
	}
	
	private def boolean checkNameRepetition(Model model, FunctionBlock ele) {
		return model.programs.stream.anyMatch([x | x.name.equals(ele.name)]) ||
			   model.fbs.stream.anyMatch([x | (x !== ele) && x.name.equals(ele.name)])
	}
	
	private def boolean checkNameRepetition(Program program, Process ele) {
		return program.processes.stream.anyMatch([x | (x !== ele) && x.name.equals(ele.name)])
	}
	
	private def boolean checkNameRepetition(Process process, su.nsk.iae.post.poST.State ele) {
		return process.states.stream.anyMatch([x | (x !== ele) && x.name.equals(ele.name)])
	}
	
	private def boolean checkNameRepetition(FunctionBlock fb, Process ele) {
		return fb.processes.stream.anyMatch([x | (x !== ele) && x.name.equals(ele.name)])
	}
	
	private def boolean checkNameRepetition(Configuration configuration, Resource ele) {
		return configuration.resources.stream.anyMatch([x | (x !== ele) && x.name.equals(ele.name)])
	}
	
	private def boolean checkNameRepetition(Resource resource, Task ele) {
		return resource.resStatement.tasks.stream.anyMatch([x | (x !== ele) && x.name.equals(ele.name)])
	}
	
	private def boolean checkNameRepetition(Resource resource, ProgramConfiguration ele) {
		return resource.resStatement.programConfs.stream.anyMatch([x | (x !== ele) && x.name.equals(ele.name)])
	}
	
	private def boolean checkNameRepetition(ProgramConfiguration programConf, TemplateProcessConfElement ele) {
		return programConf.args.elements.stream.filter([x | x instanceof TemplateProcessConfElement])
			   .anyMatch([x | (x !== ele) && (x as TemplateProcessConfElement).name.equals(ele.name)])
	}
	
	private def boolean checkNameRepetition(Model model, SymbolicVariable ele) {
		return model.globVars.checkVarRepetition_GlobalVarDeclaration(ele)
	}
	
	private def boolean checkNameRepetition(Configuration configuration, SymbolicVariable ele) {
		return configuration.confGlobVars.checkVarRepetition_GlobalVarDeclaration(ele)
	}
	
	private def boolean checkNameRepetition(Resource resource, SymbolicVariable ele) {
		return resource.resGlobVars.checkVarRepetition_GlobalVarDeclaration(ele)
	}
	
	private def boolean checkNameRepetition(Program program, SymbolicVariable ele) {
		return program.progInVars.checkVarRepetition_InputVarDeclaration(ele) ||
			   program.progOutVars.checkVarRepetition_OutputVarDeclaration(ele) ||
			   program.progInOutVars.checkVarRepetition_InputOutputVarDeclaration(ele) ||
			   program.progVars.checkVarRepetition_VarDeclaration(ele) ||
			   program.progTempVars.checkVarRepetition_TempVarDeclaration(ele) ||
			   program.progExternVars.checkVarRepetition_ExternalVarDeclaration(ele)
	}
	
	private def boolean checkNameRepetition(Process process, SymbolicVariable ele) {
		return process.procInVars.checkVarRepetition_InputVarDeclaration(ele) ||
			   process.procOutVars.checkVarRepetition_OutputVarDeclaration(ele) ||
			   process.procInOutVars.checkVarRepetition_InputOutputVarDeclaration(ele) ||
			   process.procVars.checkVarRepetition_VarDeclaration(ele) ||
			   process.procTempVars.checkVarRepetition_TempVarDeclaration(ele)
	}
	
	private def boolean checkVarRepetition_InputVarDeclaration(EList<InputVarDeclaration> varList, SymbolicVariable ele) {
		return varList.stream.anyMatch([x | x.vars.checkVarRepetition_VarInitDeclaration(ele)])
	}
	
	private def boolean checkVarRepetition_OutputVarDeclaration(EList<OutputVarDeclaration> varList, SymbolicVariable ele) {
		return varList.stream.anyMatch([x | x.vars.checkVarRepetition_VarInitDeclaration(ele)])
	}
	
	private def boolean checkVarRepetition_InputOutputVarDeclaration(EList<InputOutputVarDeclaration> varList, SymbolicVariable ele) {
		return varList.stream.anyMatch([x | x.vars.checkVarRepetition_VarInitDeclaration(ele)])
	}
	
	private def boolean checkVarRepetition_VarDeclaration(EList<VarDeclaration> varList, SymbolicVariable ele) {
		return varList.stream.anyMatch([x | x.vars.checkVarRepetition_VarInitDeclaration(ele)])
	}
	
	private def boolean checkVarRepetition_TempVarDeclaration(EList<TempVarDeclaration> varList, SymbolicVariable ele) {
		return varList.stream.anyMatch([x | x.vars.checkVarRepetition_VarInitDeclaration(ele)])
	}
	
	private def boolean checkVarRepetition_ExternalVarDeclaration(EList<ExternalVarDeclaration> varList, SymbolicVariable ele) {
		return varList.stream.anyMatch([x | x.vars.checkVarRepetition_ExternalVarInitDeclaration(ele)])
	}
	
	private def boolean checkVarRepetition_GlobalVarDeclaration(EList<GlobalVarDeclaration> varList, SymbolicVariable ele) {
		return varList.stream.anyMatch([x | x.varsSimple.checkVarRepetition_VarInitDeclaration(ele)]) || 
			   varList.stream.anyMatch([x | x.varsAs.checkVarRepetition_GlobalVarInitDeclaration(ele)])
	}

	private def boolean checkVarRepetition_VarInitDeclaration(EList<VarInitDeclaration> varList, SymbolicVariable ele) {
		varList.stream.map([x | x.varList.vars]).flatMap([x | x.stream]).anyMatch([x | (x !== ele) && x.name.equals(ele.name)])
	}

	private def boolean checkVarRepetition_ExternalVarInitDeclaration(EList<ExternalVarInitDeclaration> varList, SymbolicVariable ele) {
		varList.stream.map([x | x.varList.vars]).flatMap([x | x.stream]).anyMatch([x | (x !== ele) && x.name.equals(ele.name)])
	}
	
	private def boolean checkVarRepetition_GlobalVarInitDeclaration(EList<GlobalVarInitDeclaration> varList, SymbolicVariable ele) {
		varList.stream.map([x | x.varList.vars]).flatMap([x | x.stream]).anyMatch([x | (x !== ele) && x.name.equals(ele.name)])
	}
}
