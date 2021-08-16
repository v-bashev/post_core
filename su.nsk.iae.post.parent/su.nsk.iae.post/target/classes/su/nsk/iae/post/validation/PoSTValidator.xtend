package su.nsk.iae.post.validation

import java.util.ArrayList
import java.util.HashSet
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.validation.Check
import su.nsk.iae.post.poST.ArraySpecification
import su.nsk.iae.post.poST.AssignmentStatement
import su.nsk.iae.post.poST.AssignmentType
import su.nsk.iae.post.poST.AttachVariableConfElement
import su.nsk.iae.post.poST.CaseElement
import su.nsk.iae.post.poST.Configuration
import su.nsk.iae.post.poST.ErrorProcessStatement
import su.nsk.iae.post.poST.ExternalVarDeclaration
import su.nsk.iae.post.poST.ExternalVarInitDeclaration
import su.nsk.iae.post.poST.FBInvocation
import su.nsk.iae.post.poST.ForStatement
import su.nsk.iae.post.poST.FunctionBlock
import su.nsk.iae.post.poST.FunctionCall
import su.nsk.iae.post.poST.GlobalVarDeclaration
import su.nsk.iae.post.poST.GlobalVarInitDeclaration
import su.nsk.iae.post.poST.IfStatement
import su.nsk.iae.post.poST.InputOutputVarDeclaration
import su.nsk.iae.post.poST.InputVarDeclaration
import su.nsk.iae.post.poST.Model
import su.nsk.iae.post.poST.OutputVarDeclaration
import su.nsk.iae.post.poST.PoSTPackage
import su.nsk.iae.post.poST.Process
import su.nsk.iae.post.poST.ProcessStatusExpression
import su.nsk.iae.post.poST.ProcessVarDeclaration
import su.nsk.iae.post.poST.ProcessVarInitDeclaration
import su.nsk.iae.post.poST.ProcessVariable
import su.nsk.iae.post.poST.Program
import su.nsk.iae.post.poST.ProgramConfiguration
import su.nsk.iae.post.poST.RepeatStatement
import su.nsk.iae.post.poST.Resource
import su.nsk.iae.post.poST.SetStateStatement
import su.nsk.iae.post.poST.SimpleSpecificationInit
import su.nsk.iae.post.poST.StartProcessStatement
import su.nsk.iae.post.poST.Statement
import su.nsk.iae.post.poST.StopProcessStatement
import su.nsk.iae.post.poST.SymbolicVariable
import su.nsk.iae.post.poST.Task
import su.nsk.iae.post.poST.TempVarDeclaration
import su.nsk.iae.post.poST.TemplateProcessAttachVariableConfElement
import su.nsk.iae.post.poST.TemplateProcessConfElement
import su.nsk.iae.post.poST.TimeoutStatement
import su.nsk.iae.post.poST.VarDeclaration
import su.nsk.iae.post.poST.VarInitDeclaration
import su.nsk.iae.post.poST.Variable
import su.nsk.iae.post.poST.WhileStatement

import static extension java.lang.Character.isLowerCase
import static extension java.lang.Character.isUpperCase
import static extension org.eclipse.xtext.EcoreUtil2.*

class PoSTValidator extends AbstractPoSTValidator {
	
	val ePackage = PoSTPackage.eINSTANCE
	
/* ======================= START Variables Checks ======================= */

	@Check
	def checkSymbolicVariable_NameConflicts(SymbolicVariable ele) {
		val program = ele.getContainerOfType(Program)
		if (program !== null) {
			val process = ele.getContainerOfType(Process)
			if ((process !== null) && process.checkNameRepetition(ele)) {
				error("Name error: Process already has a Variable with this name", ePackage.variable_Name)
				return
			}
			if (program.checkNameRepetition(ele)) {
				error("Name error: Program already has a Variable with this name", ePackage.variable_Name)
				return
			}
		}
		val configuration = ele.getContainerOfType(Configuration)
		if (configuration !== null) {
			val resource = ele.getContainerOfType(Resource)
			if ((resource !== null) && resource.checkNameRepetition(ele)) {
				error("Name error: Resource already has a Variable with this name", ePackage.variable_Name)
				return
			}
			if (configuration.checkNameRepetition(ele)) {
				error("Name error: Configuration already has a Variable with this name", ePackage.variable_Name)
				return
			}
		}
		val model = ele.getContainerOfType(Model)
		if (model.checkNameRepetition(ele)) {
			error("Name error: Conflict with the name of a global Variable", ePackage.variable_Name)
			return
		}
		if ((program !== null) && (model.conf !== null)) {
			if (model.conf.checkNameRepetition(ele)) {
				error("Name error: Configuration already has a Variable with this name", ePackage.variable_Name)
				return
			}
			if (model.conf.resources.stream.anyMatch([r | r.checkNameRepetition(ele)])) {
				error("Name error: Resource already has a Variable with this name", ePackage.variable_Name)
			}
		}
	}
	
	@Check
	def checkProcessVariable_NameConflicts(ProcessVariable ele) {
		val process = ele.getContainerOfType(Process)
		if ((process !== null) && process.checkNameRepetition(ele)) {
			error("Name error: Process already has a Process Variable with this name", ePackage.variable_Name)
		}
	}
	
	@Check
	def checkSymbolicVariable_NeverUse(SymbolicVariable ele) {
		val model = ele.getContainerOfType(Model)
		if (!hasCrossReferences(model, ele)) {
			warning("Variable is never use", ePackage.variable_Name)
		}
	}
	
	@Check
	def checkSimpleSpecificationInit_Init(SimpleSpecificationInit ele) {
		if (ele.value !== null) {
			if (ele.checkContainer(InputVarDeclaration)) {
				error("Initialization error: Input Variable cannot be initialized",
						ePackage.simpleSpecificationInit_Value)
				return
			}
			if (ele.checkContainer(OutputVarDeclaration)) {
				error("Initialization error: Output Variable cannot be initialized",
						ePackage.simpleSpecificationInit_Value)
				return
			}
			if (ele.checkContainer(InputOutputVarDeclaration)) {
				error("Initialization error: InputOutput Variable cannot be initialized",
						ePackage.simpleSpecificationInit_Value)
				return
			}
		}
	}
	
	@Check
	def checkArraySpecification_Star(ArraySpecification ele) {
		if (ele.interval === null) {
			if (!ele.checkContainer(InputVarDeclaration) && !ele.checkContainer(InputOutputVarDeclaration)) {
				error("Definition error: Arrays with variable length available only in VAR_INPUT", null)
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
	def checkProgramConfiguration_LowerCase(ProgramConfiguration ele) {
		if (!ele.name.charAt(0).isLowerCase) {
			warning("Template Process name should start with LowerCase", ePackage.programConfiguration_Name)
		}
	}
	
	@Check
	def checkProgramConfiguration_NumberOfArgs(ProgramConfiguration ele) {
		if (ele.args === null) {
			return
		}
		val program = ele.program
		val attachVars = program.progInVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream]).count +
						 program.progOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream]).count +
						 program.progInOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream]).count
		val programVars = ele.args.elements.stream.filter([x | x instanceof AttachVariableConfElement]).count
		if (attachVars != programVars) {
			error("Attach error: Not all input and output Variables are used",
					ePackage.programConfiguration_Name)
		}
	}
	
	@Check
	def checkAttachVariableConfElement_AttachBlockType(AttachVariableConfElement ele) {
		if ((ele.assig == AssignmentType.IN) && !ele.programVar.checkContainer(InputVarDeclaration)) {
			error("Attach error: Must be a input Variable",
					ePackage.attachVariableConfElement_ProgramVar)
			return
		} 
		if ((ele.assig == AssignmentType.OUT) && !ele.programVar.checkContainer(OutputVarDeclaration)) {
			error("Attach error: Must be a output Variable",
					ePackage.attachVariableConfElement_ProgramVar)
		}
	}
	
	@Check
	def checkAttachVariableConfElement_AttachVarType(AttachVariableConfElement ele) {
		if ((ele.programVar instanceof SymbolicVariable) && (ele.attVar instanceof SymbolicVariable)) {
			if (ele.programVar.varType != ele.attVar.varType) {
				error("Attach error: Variable must be " + ele.programVar.varType,
						ePackage.attachVariableConfElement_AttVar)
			}
		}
	}
	
	@Check
	def checkTemplateProcessConfElement_NameConflicts(TemplateProcessConfElement ele) {
		val programConf = ele.getContainerOfType(ProgramConfiguration)
		if (programConf !== null) {
			if (programConf.checkNameRepetition(ele)) {
				error("Name error: Program already has a Template Process with this name",
						ePackage.variable_Name)
			}
			if (programConf.program.checkNameRepetition(ele)) {
				error("Name error: Program already has a Process with this name",
						ePackage.variable_Name)
			}
		}
	}
	
	@Check
	def checkTemplateProcessConfElement_LowerCase(TemplateProcessConfElement ele) {
		if (!ele.name.charAt(0).isLowerCase) {
			warning("Template Process name should start with LowerCase", ePackage.variable_Name)
		}
	}
	
	@Check
	def checkTemplateProcessConfElement_NumberOfArgs(TemplateProcessConfElement ele) {
		if (ele.args === null) {
			return
		}
		val process = ele.process
		val attachVars = process.procInVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream]).count +
						 process.procOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream]).count +
						 process.procInOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream]).count +
						 process.procProcessVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream]).count
		val programVars = ele.args.elements.stream.count
		if (attachVars != programVars) {
			error("Process attach error: Not all input output and Process Variables are used",
					ePackage.templateProcessConfElement_Process)
		}
	}
	
	@Check
	def checkTemplateProcessAttachVariableConfElement_AttachBlockType(TemplateProcessAttachVariableConfElement ele) {
		val programVar = ele.programVar
		val attVar = ele.attVar
		if (programVar instanceof SymbolicVariable) {
			if ((attVar !== null) && !(attVar instanceof SymbolicVariable)) {
				error("Attach error: Attach Variable must be a Global Variable or a Constant",
						ePackage.templateProcessAttachVariableConfElement_AttVar)
				return
			}
		}
		if (programVar instanceof ProcessVariable) {
			if (attVar === null) {
				error("Process attach error: Process attach Variable can't be a Constant",
						ePackage.templateProcessAttachVariableConfElement_AttVar)
				return
			}
			if (!(attVar instanceof TemplateProcessConfElement)) {
				error("Process attach error: Process attach Variable must be a Template Process",
						ePackage.templateProcessAttachVariableConfElement_AttVar)
				return
			}
		}
	}
	
	@Check
	def checkTemplateProcessAttachVariableConfElement_AttachVarType(TemplateProcessAttachVariableConfElement ele) {
		if ((ele.programVar instanceof SymbolicVariable) && (ele.attVar instanceof SymbolicVariable)) {
			val programVar = ele.programVar as SymbolicVariable
			val attVar = ele.attVar as SymbolicVariable
			if (programVar.varType != attVar.varType) {
				error("Attach error: Process Variable must be " + programVar.varType,
						ePackage.templateProcessAttachVariableConfElement_AttVar)
			}
		}
		if ((ele.programVar instanceof ProcessVariable) && (ele.attVar instanceof TemplateProcessConfElement)) {
			val programVar = ele.programVar as ProcessVariable
			val attVar = ele.attVar as TemplateProcessConfElement
			if (programVar.getContainerOfType(ProcessVarInitDeclaration).process.name != attVar.process.name) {
				error("Attach error: Process Variable must be " + attVar.process.name,
						ePackage.templateProcessAttachVariableConfElement_AttVar)
			}
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
	def checkProgram_UpperCase(Program ele) {
		if (!ele.name.charAt(0).isUpperCase) {
			warning("Program name should start with UpperCase", ePackage.program_Name)
		}
	}
	
	@Check
	def checkProgram_Empty(Program ele) {
		if (ele.processes.empty) {
			error("Statement error: Program can't be empty", ePackage.program_Name)
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
	def checkFunctionBlock_UpperCase(FunctionBlock ele) {
		if (!ele.name.charAt(0).isUpperCase) {
			warning("FunctionBlock name should start with UpperCase", ePackage.functionBlock_Name)
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
			error("Name error: Program already has a Process with this name", ePackage.variable_Name)
			return
		}
		val fb = ele.getContainerOfType(FunctionBlock)
		if (fb.checkNameRepetition(ele)) {
			error("Name error: FunctionBlock already has a Process with this name", ePackage.variable_Name)
		}
	}
	
	@Check
	def checkProcess_UpperCase(Process ele) {
		if (!ele.name.charAt(0).isUpperCase) {
			warning("Process name should start with UpperCase", ePackage.variable_Name)
		}
	}
	
	@Check
	def checkProcess_Empty(Process ele) {
		if (ele.states.empty) {
			error("Statement error: Process can't be empty", ePackage.variable_Name)
		}
	}
	
	@Check
	def checkProcess_Unreachable(Process ele) {
		if (ele.template) {
			return
		}
		val program = ele.getContainerOfType(Program)
		if (program !== null) {
			if (program.processes.indexOf(ele) === 0) {
				return
			}
			if (!program.processes.checkProcessStart(ele)) {
				warning("Process is unreachable", ePackage.variable_Name)
			}
			return
		}
		val fb = ele.getContainerOfType(FunctionBlock)
		if (fb.processes.indexOf(ele) === 0) {
			return
		}
		if (!fb.processes.checkProcessStart(ele)) {
			warning("Process is unreachable", ePackage.variable_Name)
		}
	}
	
	@Check
	def checkState_NameConflicts(su.nsk.iae.post.poST.State ele) {
		val process = ele.getContainerOfType(Process)
		if (process.checkNameRepetition(ele)) {
			error("Name error: Process already has a State with this name", ePackage.state_Name)
		}
	}
	
	@Check
	def checkState_Empty(su.nsk.iae.post.poST.State ele) {
		if (ele.statement.statements.empty && (ele.timeout === null)) {
			error("Statement error: State can't be empty", ePackage.state_Name)
		}
	}
	
	@Check
	def checkState_Unreachable(su.nsk.iae.post.poST.State ele) {
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
	def checkState_Looped(su.nsk.iae.post.poST.State ele) {
		var check = ele.containsType(SetStateStatement) ||
					ele.containsType(StartProcessStatement) ||
					ele.containsType(StopProcessStatement) ||
					ele.containsType(ErrorProcessStatement)
		if (ele.timeout !== null) {
			check = check || ele.timeout.containsType(SetStateStatement)
		}
		if (ele.looped) {
			if (check) {
				warning("State mustn't be LOOPED", ePackage.state_Name)
			}
		} else {
			if (!check) {
				warning("State should be LOOPED", ePackage.state_Name)
			}
		}
	}
	
	@Check
	def checkSetStateStatement_InvalidArgument(SetStateStatement ele) {
		if (ele.next) {
			return
		}
		val process = ele.getContainerOfType(Process)
		if (!process.states.contains(ele.state)) {
			error("Name error: Process does not contain a State with this name", ePackage.setStateStatement_State)
			return
		}
	}
	
	@Check
	def checkSetStateStatement_Useless(SetStateStatement ele) {
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
	def checkStartProcessStatement_InvalidArgument(StartProcessStatement ele) {
		ele.checkProcessStatement_InvalidArgument(ele.process)
	}
	
	@Check
	def checkStopProcessStatement_InvalidArgument(StopProcessStatement ele) {
		ele.checkProcessStatement_InvalidArgument(ele.process)
	}
	
	@Check
	def checkErrorProcessStatement_InvalidArgument(ErrorProcessStatement ele) {
		ele.checkProcessStatement_InvalidArgument(ele.process)
	}
	
	@Check
	def checkProcessStatusExpression_InvalidArgument(ProcessStatusExpression ele) {
		ele.checkProcessStatement_InvalidArgument(ele.process)
	}
	
	@Check
	def checkTimeoutStatement_Empty(TimeoutStatement ele) {
		if (ele.statement.statements.empty) {
			error("Statement error: No reaction on timeout", ePackage.timeoutStatement_Statement)
		}
	}
	
	private def checkProcessStatement_InvalidArgument(EObject context, Variable ele) {
		if (ele === null) {
			return
		}
		if (ele instanceof Process) {
			val program = ele.getContainerOfType(Program)
			if (!program.processes.contains(ele)) {
				error("Name error: Program does not contain a Process with this name", ePackage.processStatements_Process)
				return
			}
		}
	}
	
/* ======================= END poST Checks ======================= */

/* ======================= START ST Checks ======================= */
	
	@Check
	def checkAssignmentStatement_ModifyInput(AssignmentStatement ele) {
		val varEle = ele.variable
		if (varEle.checkContainer(InputVarDeclaration)) {
			warning("Modification of input Variable", ePackage.assignmentStatement_Variable)
			return
		}
	}
	
	@Check
	def checkAssignmentStatement_ModifyConst(AssignmentStatement ele) {
		val varEle = ele.variable
		val varDecl = varEle.getContainerOfType(VarDeclaration)
		val globDecl = varEle.getContainerOfType(GlobalVarDeclaration)
		val extDecl = varEle.getContainerOfType(ExternalVarDeclaration)
		if (((varDecl !== null) && varDecl.const) ||
			((globDecl !== null) && globDecl.const) ||
			((extDecl !== null) && extDecl.const)
		) {
			error("Assignment error: Couldn't modify constant Variable", ePackage.assignmentStatement_Variable)
		}
	}
	
	@Check
	def checkIfStatement_Empty(IfStatement ele) {
		if (ele.mainStatement.statements.empty) {
			error("Statement error: IF can't be empty", ePackage.variable_Name)
		}
		for (e : ele.elseIfStatements) {
			if (e.statements.empty) {
				error("Statement error: ELSIF can't be empty", ePackage.variable_Name)
			}
		}
		if ((ele.elseStatement !== null) && ele.elseStatement.statements.empty) {
			error("Statement error: ELSE can't be empty", ePackage.variable_Name)
		}
	}
	
	@Check
	def checkCaseElement_Empty(CaseElement ele) {
		if (ele.statement.statements.empty) {
			error("Statement error: CASE can't be empty", ePackage.variable_Name)
		}
	}
	
	@Check
	def checkForStatement_Empty(ForStatement ele) {
		if (ele.statement.statements.empty) {
			error("Statement error: FOR can't be empty", ePackage.variable_Name)
		}
	}
	
	@Check
	def checkWhileStatement_Empty(WhileStatement ele) {
		if (ele.statement.statements.empty) {
			error("Statement error: WHILE can't be empty", ePackage.variable_Name)
		}
	}
	
	@Check
	def checkRepeatStatement_Empty(RepeatStatement ele) {
		if (ele.statement.statements.empty) {
			error("Statement error: REPEAT can't be empty", ePackage.variable_Name)
		}
	}
	
	@Check
	def checkFunctionCall_NumberOfArgs(FunctionCall ele) {
		val function = ele.function
		val attachVars = function.funInVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream]).count +
						 function.funOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream]).count +
						 function.funInOutVars.stream.map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]).flatMap([x | x.stream]).count
		val programVars = ele.args.elements.stream.count
		if (attachVars != programVars) {
			if (!ele.checkContainer(InputVarDeclaration) && !ele.checkContainer(InputOutputVarDeclaration)) {
				error("Attach error: Not all input and output Variables are used", ePackage.functionCall_Function)
			}
		}
	}
	
	@Check
	def checkFBInvocation_InvalidArgument(FBInvocation ele) {
		val varDecl = ele.fb.getContainerOfType(VarInitDeclaration)
		if ((varDecl === null) || (varDecl.fb === null)) {
			error("Statement error: Must be FunctionBlock", ePackage.FBInvocation_Fb)
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
			}]
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
		return ele.getAllContentsOfType(type).size !== 0
	}
	
	private def boolean isTemplate(Process process) {
		return !process.procInVars.empty || !process.procOutVars.empty || !process.procInOutVars.empty || !process.procProcessVars.empty
	}
	
	private def String getVarType(SymbolicVariable ele) {
		val simple = ele.getContainerOfType(VarInitDeclaration)
		if (simple !== null) {
			if (simple.spec !== null) {
				return simple.spec.type
			}
			return "ARRAY." + simple.arrSpec.init.type
		}
		val global = ele.getContainerOfType(GlobalVarInitDeclaration)
		if (global !== null) {
			return global.type
		}
		val ext = ele.getContainerOfType(ExternalVarInitDeclaration)
		return ext.type
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
	private def boolean checkNameRepetition(Program program, TemplateProcessConfElement ele) {
		val name = ele.name.substring(0, 1).toUpperCase + ele.name.substring(1)
		return program.processes.stream.anyMatch([x | !x.template && x.name.equals(name)])
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
	
	private def boolean checkNameRepetition(Process process, ProcessVariable ele) {
		return process.procProcessVars.checkVarRepetition_ProcessVarDeclaration(ele)
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
	
	private def boolean checkVarRepetition_ProcessVarDeclaration(EList<ProcessVarDeclaration> varList, ProcessVariable ele) {
		return varList.stream.anyMatch([x | x.vars.checkVarRepetition_ProcessVarInitDeclaration(ele)])
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
	
	private def boolean checkVarRepetition_ProcessVarInitDeclaration(EList<ProcessVarInitDeclaration> varList, ProcessVariable ele) {
		varList.stream.map([x | x.varList.vars]).flatMap([x | x.stream]).anyMatch([x | (x !== ele) && x.name.equals(ele.name)])
	}
	
}
