package su.nsk.iae.post.validation;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import su.nsk.iae.post.poST.ArrayInterval;
import su.nsk.iae.post.poST.ArraySpecification;
import su.nsk.iae.post.poST.AssignmentStatement;
import su.nsk.iae.post.poST.AssignmentType;
import su.nsk.iae.post.poST.AttachVariableConfElement;
import su.nsk.iae.post.poST.Configuration;
import su.nsk.iae.post.poST.ErrorProcessStatement;
import su.nsk.iae.post.poST.Expression;
import su.nsk.iae.post.poST.ExternalVarDeclaration;
import su.nsk.iae.post.poST.ExternalVarInitDeclaration;
import su.nsk.iae.post.poST.FunctionBlock;
import su.nsk.iae.post.poST.GlobalVarDeclaration;
import su.nsk.iae.post.poST.GlobalVarInitDeclaration;
import su.nsk.iae.post.poST.InputOutputVarDeclaration;
import su.nsk.iae.post.poST.InputVarDeclaration;
import su.nsk.iae.post.poST.Model;
import su.nsk.iae.post.poST.OutputVarDeclaration;
import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.ProcessStatusExpression;
import su.nsk.iae.post.poST.ProcessVarDeclaration;
import su.nsk.iae.post.poST.ProcessVarInitDeclaration;
import su.nsk.iae.post.poST.ProcessVariable;
import su.nsk.iae.post.poST.Program;
import su.nsk.iae.post.poST.ProgramConfElement;
import su.nsk.iae.post.poST.ProgramConfElements;
import su.nsk.iae.post.poST.ProgramConfiguration;
import su.nsk.iae.post.poST.Resource;
import su.nsk.iae.post.poST.SetStateStatement;
import su.nsk.iae.post.poST.SimpleSpecificationInit;
import su.nsk.iae.post.poST.StartProcessStatement;
import su.nsk.iae.post.poST.Statement;
import su.nsk.iae.post.poST.StopProcessStatement;
import su.nsk.iae.post.poST.SymbolicVariable;
import su.nsk.iae.post.poST.Task;
import su.nsk.iae.post.poST.TempVarDeclaration;
import su.nsk.iae.post.poST.TemplateProcessConfElement;
import su.nsk.iae.post.poST.TimeoutStatement;
import su.nsk.iae.post.poST.VarDeclaration;
import su.nsk.iae.post.poST.VarInitDeclaration;
import su.nsk.iae.post.poST.Variable;

@SuppressWarnings("all")
public class PoSTValidator extends AbstractPoSTValidator {
  private final PoSTPackage ePackage = PoSTPackage.eINSTANCE;
  
  /**
   * ======================= START Variables Checks =======================
   */
  @Check
  public void checkSymbolicVariable_NameConflicts(final SymbolicVariable ele) {
    final Program program = EcoreUtil2.<Program>getContainerOfType(ele, Program.class);
    if ((program != null)) {
      final su.nsk.iae.post.poST.Process process = EcoreUtil2.<su.nsk.iae.post.poST.Process>getContainerOfType(ele, su.nsk.iae.post.poST.Process.class);
      if (((process != null) && this.checkNameRepetition(process, ele))) {
        this.error("Name error: Process already has a Variable with this name", this.ePackage.getVariable_Name());
        return;
      }
      boolean _checkNameRepetition = this.checkNameRepetition(program, ele);
      if (_checkNameRepetition) {
        this.error("Name error: Program already has a Variable with this name", this.ePackage.getVariable_Name());
        return;
      }
    }
    final Configuration configuration = EcoreUtil2.<Configuration>getContainerOfType(ele, Configuration.class);
    if ((configuration != null)) {
      final Resource resource = EcoreUtil2.<Resource>getContainerOfType(ele, Resource.class);
      if (((resource != null) && this.checkNameRepetition(resource, ele))) {
        this.error("Name error: Resource already has a Variable with this name", this.ePackage.getVariable_Name());
        return;
      }
      boolean _checkNameRepetition_1 = this.checkNameRepetition(configuration, ele);
      if (_checkNameRepetition_1) {
        this.error("Name error: Configuration already has a Variable with this name", this.ePackage.getVariable_Name());
        return;
      }
    }
    final Model model = EcoreUtil2.<Model>getContainerOfType(ele, Model.class);
    boolean _checkNameRepetition_2 = this.checkNameRepetition(model, ele);
    if (_checkNameRepetition_2) {
      this.error("Name error: Conflict with the name of a global Variable", this.ePackage.getVariable_Name());
      return;
    }
    if (((program != null) && (model.getConf() != null))) {
      boolean _checkNameRepetition_3 = this.checkNameRepetition(model.getConf(), ele);
      if (_checkNameRepetition_3) {
        this.error("Name error: Configuration already has a Variable with this name", this.ePackage.getVariable_Name());
        return;
      }
      final Predicate<Resource> _function = (Resource r) -> {
        return this.checkNameRepetition(r, ele);
      };
      boolean _anyMatch = model.getConf().getResources().stream().anyMatch(_function);
      if (_anyMatch) {
        this.error("Name error: Resource already has a Variable with this name", this.ePackage.getVariable_Name());
      }
    }
  }
  
  @Check
  public void checkProcessVariable_NameConflicts(final ProcessVariable ele) {
    final su.nsk.iae.post.poST.Process process = EcoreUtil2.<su.nsk.iae.post.poST.Process>getContainerOfType(ele, su.nsk.iae.post.poST.Process.class);
    if (((process != null) && this.checkNameRepetition(process, ele))) {
      this.error("Name error: Process already has a Process Variable with this name", this.ePackage.getVariable_Name());
    }
  }
  
  @Check
  public void checkSymbolicVariable_NeverUse(final SymbolicVariable ele) {
    final Model model = EcoreUtil2.<Model>getContainerOfType(ele, Model.class);
    boolean _hasCrossReferences = this.hasCrossReferences(model, ele);
    boolean _not = (!_hasCrossReferences);
    if (_not) {
      this.warning("Variable is never use", this.ePackage.getVariable_Name());
    }
  }
  
  @Check
  public void checkSimpleSpecificationInit_NeverUse(final SimpleSpecificationInit ele) {
    Expression _value = ele.getValue();
    boolean _tripleNotEquals = (_value != null);
    if (_tripleNotEquals) {
      boolean _checkContainer = this.<InputVarDeclaration>checkContainer(ele, InputVarDeclaration.class);
      if (_checkContainer) {
        this.error("Initialization error: Input Variable cannot be initialized", 
          this.ePackage.getSimpleSpecificationInit_Value());
        return;
      }
      boolean _checkContainer_1 = this.<OutputVarDeclaration>checkContainer(ele, OutputVarDeclaration.class);
      if (_checkContainer_1) {
        this.error("Initialization error: Output Variable cannot be initialized", 
          this.ePackage.getSimpleSpecificationInit_Value());
        return;
      }
      boolean _checkContainer_2 = this.<InputOutputVarDeclaration>checkContainer(ele, InputOutputVarDeclaration.class);
      if (_checkContainer_2) {
        this.error("Initialization error: InputOutput Variable cannot be initialized", 
          this.ePackage.getSimpleSpecificationInit_Value());
        return;
      }
    }
  }
  
  @Check
  public void checkArraySpecification_Star(final ArraySpecification ele) {
    ArrayInterval _interval = ele.getInterval();
    boolean _tripleEquals = (_interval == null);
    if (_tripleEquals) {
      if (((!this.<InputVarDeclaration>checkContainer(ele, InputVarDeclaration.class)) && (!this.<InputOutputVarDeclaration>checkContainer(ele, InputOutputVarDeclaration.class)))) {
        this.error("Definition error: Arrays with variable length available only in VAR_INPUT", null);
      }
    }
  }
  
  /**
   * ======================= START Configuration Checks =======================
   */
  @Check
  public void checkResource_NameConflicts(final Resource ele) {
    final Configuration configuration = EcoreUtil2.<Configuration>getContainerOfType(ele, Configuration.class);
    if (((configuration != null) && this.checkNameRepetition(configuration, ele))) {
      this.error("Name error: Configuration already has a Resource with this name", 
        this.ePackage.getResource_Name());
    }
  }
  
  @Check
  public void checkTask_NameConflicts(final Task ele) {
    final Resource resource = EcoreUtil2.<Resource>getContainerOfType(ele, Resource.class);
    if (((resource != null) && this.checkNameRepetition(resource, ele))) {
      this.error("Name error: Resource already has a Task with this name", 
        this.ePackage.getTask_Name());
    }
  }
  
  @Check
  public void checkProgramConfiguration_NameConflicts(final ProgramConfiguration ele) {
    final Resource resource = EcoreUtil2.<Resource>getContainerOfType(ele, Resource.class);
    if (((resource != null) && this.checkNameRepetition(resource, ele))) {
      this.error("Name error: Resource already has a Attached Program with this name", 
        this.ePackage.getProgramConfiguration_Name());
    }
  }
  
  @Check
  public void checkTemplateProcessConfElement_NameConflicts(final TemplateProcessConfElement ele) {
    final ProgramConfiguration rogramConf = EcoreUtil2.<ProgramConfiguration>getContainerOfType(ele, ProgramConfiguration.class);
    if (((rogramConf != null) && this.checkNameRepetition(rogramConf, ele))) {
      this.error("Name error: Program already has a Template Process with this name", 
        this.ePackage, this.ePackage.getVariable_Name());
    }
  }
  
  @Check
  public void checkProgramConfiguration_NumberOfArgs(final ProgramConfiguration ele) {
    ProgramConfElements _args = ele.getArgs();
    boolean _tripleEquals = (_args == null);
    if (_tripleEquals) {
      return;
    }
    final Program program = ele.getProgram();
    final Function<InputVarDeclaration, EList<VarInitDeclaration>> _function = (InputVarDeclaration x) -> {
      return x.getVars();
    };
    final Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_1 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final Function<VarInitDeclaration, EList<SymbolicVariable>> _function_2 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_3 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    long _count = program.getProgInVars().stream().<EList<VarInitDeclaration>>map(_function).<VarInitDeclaration>flatMap(_function_1).<EList<SymbolicVariable>>map(_function_2).<SymbolicVariable>flatMap(_function_3).count();
    final Function<OutputVarDeclaration, EList<VarInitDeclaration>> _function_4 = (OutputVarDeclaration x) -> {
      return x.getVars();
    };
    final Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_5 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final Function<VarInitDeclaration, EList<SymbolicVariable>> _function_6 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_7 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    long _count_1 = program.getProgOutVars().stream().<EList<VarInitDeclaration>>map(_function_4).<VarInitDeclaration>flatMap(_function_5).<EList<SymbolicVariable>>map(_function_6).<SymbolicVariable>flatMap(_function_7).count();
    long _plus = (_count + _count_1);
    final Function<InputOutputVarDeclaration, EList<VarInitDeclaration>> _function_8 = (InputOutputVarDeclaration x) -> {
      return x.getVars();
    };
    final Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_9 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final Function<VarInitDeclaration, EList<SymbolicVariable>> _function_10 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_11 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    long _count_2 = program.getProgInOutVars().stream().<EList<VarInitDeclaration>>map(_function_8).<VarInitDeclaration>flatMap(_function_9).<EList<SymbolicVariable>>map(_function_10).<SymbolicVariable>flatMap(_function_11).count();
    final long attachVars = (_plus + _count_2);
    final Predicate<ProgramConfElement> _function_12 = (ProgramConfElement x) -> {
      return (x instanceof AttachVariableConfElement);
    };
    final long programVars = ele.getArgs().getElements().stream().filter(_function_12).count();
    if ((attachVars != programVars)) {
      this.error("Attached error: Not all input and output Variables are used", 
        this.ePackage.getProgramConfiguration_Name());
    }
  }
  
  @Check
  public void checkAttachVariableConfElement_AttachType(final AttachVariableConfElement ele) {
    if ((Objects.equal(ele.getAssig(), AssignmentType.IN) && (!this.<InputVarDeclaration>checkContainer(ele.getProgramVar(), InputVarDeclaration.class)))) {
      this.error("Attached error: Must be a input Variable", 
        this.ePackage.getAttachVariableConfElement_ProgramVar());
      return;
    }
    if ((Objects.equal(ele.getAssig(), AssignmentType.OUT) && (!this.<OutputVarDeclaration>checkContainer(ele.getProgramVar(), OutputVarDeclaration.class)))) {
      this.error("Attached error: Must be a output Variable", 
        this.ePackage.getAttachVariableConfElement_ProgramVar());
    }
  }
  
  /**
   * ======================= START poST Checks =======================
   */
  @Check
  public void checkProgram_NameConflicts(final Program ele) {
    final Model model = EcoreUtil2.<Model>getContainerOfType(ele, Model.class);
    boolean _checkNameRepetition = this.checkNameRepetition(model, ele);
    if (_checkNameRepetition) {
      this.error("Name error: Process or FunctionBlock with this name already exists", this.ePackage.getProgram_Name());
    }
  }
  
  @Check
  public void checkFunctionBlock_NameConflicts(final FunctionBlock ele) {
    final Model model = EcoreUtil2.<Model>getContainerOfType(ele, Model.class);
    boolean _checkNameRepetition = this.checkNameRepetition(model, ele);
    if (_checkNameRepetition) {
      this.error("Name error: Process or FunctionBlock with this name already exists", this.ePackage.getFunctionBlock_Name());
    }
  }
  
  @Check
  public void checkProgram_Empty(final Program ele) {
    boolean _isEmpty = ele.getProcesses().isEmpty();
    if (_isEmpty) {
      this.error("Statement error: Program can\'t be empty", this.ePackage.getProgram_Name());
    }
  }
  
  @Check
  public void checkFunctionBlock_Empty(final FunctionBlock ele) {
    boolean _isEmpty = ele.getProcesses().isEmpty();
    if (_isEmpty) {
      this.error("Statement error: FunctionBlock can\'t be empty", this.ePackage.getFunctionBlock_Name());
    }
  }
  
  @Check
  public void checkProcess_NameConflicts(final su.nsk.iae.post.poST.Process ele) {
    final Program program = EcoreUtil2.<Program>getContainerOfType(ele, Program.class);
    if (((program != null) && this.checkNameRepetition(program, ele))) {
      this.error("Name error: Program already has a Process with this name", this.ePackage.getVariable_Name());
      return;
    }
    final FunctionBlock fb = EcoreUtil2.<FunctionBlock>getContainerOfType(ele, FunctionBlock.class);
    boolean _checkNameRepetition = this.checkNameRepetition(fb, ele);
    if (_checkNameRepetition) {
      this.error("Name error: FunctionBlock already has a Process with this name", this.ePackage.getVariable_Name());
    }
  }
  
  @Check
  public void checkProcess_Empty(final su.nsk.iae.post.poST.Process ele) {
    boolean _isEmpty = ele.getStates().isEmpty();
    if (_isEmpty) {
      this.error("Statement error: Process can\'t be empty", this.ePackage.getVariable_Name());
    }
  }
  
  @Check
  public void checkProcess_Unreachable(final su.nsk.iae.post.poST.Process ele) {
    final Program program = EcoreUtil2.<Program>getContainerOfType(ele, Program.class);
    if ((program != null)) {
      int _indexOf = program.getProcesses().indexOf(ele);
      boolean _tripleEquals = (_indexOf == 0);
      if (_tripleEquals) {
        return;
      }
      boolean _checkProcessStart = this.<Statement>checkProcessStart(program.getProcesses(), ele);
      boolean _not = (!_checkProcessStart);
      if (_not) {
        this.warning("Process is unreachable", this.ePackage.getVariable_Name());
      }
      return;
    }
    final FunctionBlock fb = EcoreUtil2.<FunctionBlock>getContainerOfType(ele, FunctionBlock.class);
    int _indexOf_1 = fb.getProcesses().indexOf(ele);
    boolean _tripleEquals_1 = (_indexOf_1 == 0);
    if (_tripleEquals_1) {
      return;
    }
    boolean _checkProcessStart_1 = this.<Statement>checkProcessStart(fb.getProcesses(), ele);
    boolean _not_1 = (!_checkProcessStart_1);
    if (_not_1) {
      this.warning("Process is unreachable", this.ePackage.getVariable_Name());
    }
  }
  
  @Check
  public void checkProcess_NameConflicts(final su.nsk.iae.post.poST.State ele) {
    final su.nsk.iae.post.poST.Process process = EcoreUtil2.<su.nsk.iae.post.poST.Process>getContainerOfType(ele, su.nsk.iae.post.poST.Process.class);
    boolean _checkNameRepetition = this.checkNameRepetition(process, ele);
    if (_checkNameRepetition) {
      this.error("Name error: Process already has a State with this name", this.ePackage.getState_Name());
    }
  }
  
  @Check
  public void checkProcess_Empty(final su.nsk.iae.post.poST.State ele) {
    if ((ele.getStatement().getStatements().isEmpty() && (ele.getTimeout() == null))) {
      this.error("Statement error: State can\'t be empty", this.ePackage.getState_Name());
    }
  }
  
  @Check
  public void checkProcess_Unreachable(final su.nsk.iae.post.poST.State ele) {
    final su.nsk.iae.post.poST.Process process = EcoreUtil2.<su.nsk.iae.post.poST.Process>getContainerOfType(ele, su.nsk.iae.post.poST.Process.class);
    final int stateIndex = process.getStates().indexOf(ele);
    if ((((stateIndex == 0) || 
      this.<Statement>checkStateSet(process.getStates(), ele)) || 
      this.<Statement>checkStateSetNext(process.getStates(), (stateIndex - 1)))) {
      return;
    }
    this.warning("State is unreachable", this.ePackage.getState_Name());
  }
  
  @Check
  public void checkProcess_Looped(final su.nsk.iae.post.poST.State ele) {
    boolean check = (((this.<SetStateStatement>containsType(ele, SetStateStatement.class) || 
      this.<StartProcessStatement>containsType(ele, StartProcessStatement.class)) || 
      this.<StopProcessStatement>containsType(ele, StopProcessStatement.class)) || 
      this.<ErrorProcessStatement>containsType(ele, ErrorProcessStatement.class));
    TimeoutStatement _timeout = ele.getTimeout();
    boolean _tripleNotEquals = (_timeout != null);
    if (_tripleNotEquals) {
      check = (check || this.<SetStateStatement>containsType(ele.getTimeout(), SetStateStatement.class));
    }
    boolean _isLooped = ele.isLooped();
    if (_isLooped) {
      if (check) {
        this.warning("State mustn\'t be LOOPED", this.ePackage.getState_Name());
      }
    } else {
      if ((!check)) {
        this.warning("State must be LOOPED", this.ePackage.getState_Name());
      }
    }
  }
  
  @Check
  public void checkSetStateStatement_NameConflicts(final SetStateStatement ele) {
    boolean _isNext = ele.isNext();
    if (_isNext) {
      return;
    }
    final su.nsk.iae.post.poST.Process process = EcoreUtil2.<su.nsk.iae.post.poST.Process>getContainerOfType(ele, su.nsk.iae.post.poST.Process.class);
    boolean _contains = process.getStates().contains(ele.getState());
    boolean _not = (!_contains);
    if (_not) {
      this.error("Name error: Process does not contain a State with this name", this.ePackage.getSetStateStatement_State());
      return;
    }
    final su.nsk.iae.post.poST.State state = EcoreUtil2.<su.nsk.iae.post.poST.State>getContainerOfType(ele, su.nsk.iae.post.poST.State.class);
    su.nsk.iae.post.poST.State _state = ele.getState();
    boolean _tripleEquals = (state == _state);
    if (_tripleEquals) {
      this.warning("Useless statement, use RESET TIMER", this.ePackage.getSetStateStatement_State());
    }
  }
  
  @Check
  public void checkSetStateStatement_Next(final SetStateStatement ele) {
    boolean _isNext = ele.isNext();
    boolean _not = (!_isNext);
    if (_not) {
      return;
    }
    final su.nsk.iae.post.poST.Process process = EcoreUtil2.<su.nsk.iae.post.poST.Process>getContainerOfType(ele, su.nsk.iae.post.poST.Process.class);
    final su.nsk.iae.post.poST.State state = EcoreUtil2.<su.nsk.iae.post.poST.State>getContainerOfType(ele, su.nsk.iae.post.poST.State.class);
    su.nsk.iae.post.poST.State _last = IterableExtensions.<su.nsk.iae.post.poST.State>last(process.getStates());
    boolean _tripleEquals = (_last == state);
    if (_tripleEquals) {
      this.error("Invalid statement: No next state in the Process", this.ePackage.getSetStateStatement_Next());
    }
  }
  
  @Check
  public void checkStartProcessStatement_NameConflicts(final StartProcessStatement ele) {
    this.checkProcessStatement_NameConflicts(ele, ele.getProcess());
  }
  
  @Check
  public void checkStopProcessStatement_NameConflicts(final StopProcessStatement ele) {
    this.checkProcessStatement_NameConflicts(ele, ele.getProcess());
  }
  
  @Check
  public void checkErrorProcessStatement_NameConflicts(final ErrorProcessStatement ele) {
    this.checkProcessStatement_NameConflicts(ele, ele.getProcess());
  }
  
  @Check
  public void checkProcessStatusExpression_NameConflicts(final ProcessStatusExpression ele) {
    this.checkProcessStatement_NameConflicts(ele, ele.getProcess());
  }
  
  @Check
  public void checkTimeoutStatement_Empty(final TimeoutStatement ele) {
    boolean _isEmpty = ele.getStatement().getStatements().isEmpty();
    if (_isEmpty) {
      this.error("Statement error: No reaction on timeout", this.ePackage.getTimeoutStatement_Statement());
    }
  }
  
  private void checkProcessStatement_NameConflicts(final EObject context, final Variable ele) {
    if ((ele == null)) {
      return;
    }
    if ((ele instanceof su.nsk.iae.post.poST.Process)) {
      final Program program = EcoreUtil2.<Program>getContainerOfType(ele, Program.class);
      boolean _contains = program.getProcesses().contains(ele);
      boolean _not = (!_contains);
      if (_not) {
        this.error("Name error: Program does not contain a Process with this name", this.ePackage.getProcessStatements_Process());
        return;
      }
    }
  }
  
  /**
   * ======================= START ST Checks =======================
   */
  @Check
  public void checkAssignmentStatement_Modify(final AssignmentStatement ele) {
    final SymbolicVariable varEle = ele.getVariable();
    boolean _checkContainer = this.<InputVarDeclaration>checkContainer(varEle, InputVarDeclaration.class);
    if (_checkContainer) {
      this.warning("Modification of input Variable", this.ePackage.getAssignmentStatement_Variable());
      return;
    }
    final VarDeclaration varDecl = EcoreUtil2.<VarDeclaration>getContainerOfType(varEle, VarDeclaration.class);
    final GlobalVarDeclaration globDecl = EcoreUtil2.<GlobalVarDeclaration>getContainerOfType(varEle, GlobalVarDeclaration.class);
    final ExternalVarDeclaration extDecl = EcoreUtil2.<ExternalVarDeclaration>getContainerOfType(varEle, ExternalVarDeclaration.class);
    if (((((varDecl != null) && varDecl.isConst()) || ((globDecl != null) && globDecl.isConst())) || ((extDecl != null) && extDecl.isConst()))) {
      this.error("Assignment error: Couldn\'t modify constant Variable", this.ePackage.getAssignmentStatement_Variable());
    }
  }
  
  /**
   * ======================= END ST Checks =======================
   */
  private boolean hasCrossReferences(final EObject context, final EObject target) {
    final HashSet<EObject> targetSet = new HashSet<EObject>();
    targetSet.add(target);
    final ArrayList<EReference> res = new ArrayList<EReference>();
    final EcoreUtil2.ElementReferenceAcceptor _function = (EObject referrer, EObject referenced, EReference reference, int index) -> {
      res.add(reference);
    };
    final EcoreUtil2.ElementReferenceAcceptor acceptor = _function;
    EcoreUtil2.findCrossReferences(context, targetSet, acceptor);
    boolean _isEmpty = res.isEmpty();
    return (!_isEmpty);
  }
  
  private <T extends EObject> boolean checkContainer(final EObject ele, final Class<T> type) {
    T _containerOfType = EcoreUtil2.<T>getContainerOfType(ele, type);
    return (_containerOfType != null);
  }
  
  private <T extends Statement> boolean checkProcessStart(final EList<su.nsk.iae.post.poST.Process> processList, final su.nsk.iae.post.poST.Process ele) {
    final Predicate<su.nsk.iae.post.poST.Process> _function = (su.nsk.iae.post.poST.Process x) -> {
      return (x != ele);
    };
    final Predicate<su.nsk.iae.post.poST.Process> _function_1 = (su.nsk.iae.post.poST.Process x) -> {
      final Predicate<StartProcessStatement> _function_2 = (StartProcessStatement xx) -> {
        Variable _process = xx.getProcess();
        return (_process == ele);
      };
      return EcoreUtil2.<StartProcessStatement>getAllContentsOfType(x, StartProcessStatement.class).stream().anyMatch(_function_2);
    };
    return processList.stream().filter(_function).anyMatch(_function_1);
  }
  
  private <T extends Statement> boolean checkStateSet(final EList<su.nsk.iae.post.poST.State> stateList, final su.nsk.iae.post.poST.State ele) {
    final Predicate<su.nsk.iae.post.poST.State> _function = (su.nsk.iae.post.poST.State x) -> {
      return (x != ele);
    };
    final Predicate<su.nsk.iae.post.poST.State> _function_1 = (su.nsk.iae.post.poST.State x) -> {
      final Predicate<SetStateStatement> _function_2 = (SetStateStatement xx) -> {
        su.nsk.iae.post.poST.State _state = xx.getState();
        return (_state == ele);
      };
      return EcoreUtil2.<SetStateStatement>getAllContentsOfType(x, SetStateStatement.class).stream().anyMatch(_function_2);
    };
    return stateList.stream().filter(_function).anyMatch(_function_1);
  }
  
  private <T extends Statement> boolean checkStateSetNext(final EList<su.nsk.iae.post.poST.State> stateList, final int index) {
    final Predicate<SetStateStatement> _function = (SetStateStatement xx) -> {
      return xx.isNext();
    };
    return EcoreUtil2.<SetStateStatement>getAllContentsOfType(stateList.get(index), SetStateStatement.class).stream().anyMatch(_function);
  }
  
  private <T extends Statement> boolean containsType(final EObject ele, final Class<T> type) {
    int _size = EcoreUtil2.<T>getAllContentsOfType(ele, type).size();
    return (_size != 0);
  }
  
  private boolean checkNameRepetition(final Model model, final Program ele) {
    return (model.getPrograms().stream().anyMatch(((Predicate<Program>) (Program x) -> {
      return ((x != ele) && x.getName().equals(ele.getName()));
    })) || 
      model.getFbs().stream().anyMatch(((Predicate<FunctionBlock>) (FunctionBlock x) -> {
        return x.getName().equals(ele.getName());
      })));
  }
  
  private boolean checkNameRepetition(final Model model, final FunctionBlock ele) {
    return (model.getPrograms().stream().anyMatch(((Predicate<Program>) (Program x) -> {
      return x.getName().equals(ele.getName());
    })) || 
      model.getFbs().stream().anyMatch(((Predicate<FunctionBlock>) (FunctionBlock x) -> {
        return ((x != ele) && x.getName().equals(ele.getName()));
      })));
  }
  
  private boolean checkNameRepetition(final Program program, final su.nsk.iae.post.poST.Process ele) {
    final Predicate<su.nsk.iae.post.poST.Process> _function = (su.nsk.iae.post.poST.Process x) -> {
      return ((x != ele) && x.getName().equals(ele.getName()));
    };
    return program.getProcesses().stream().anyMatch(_function);
  }
  
  private boolean checkNameRepetition(final su.nsk.iae.post.poST.Process process, final su.nsk.iae.post.poST.State ele) {
    final Predicate<su.nsk.iae.post.poST.State> _function = (su.nsk.iae.post.poST.State x) -> {
      return ((x != ele) && x.getName().equals(ele.getName()));
    };
    return process.getStates().stream().anyMatch(_function);
  }
  
  private boolean checkNameRepetition(final FunctionBlock fb, final su.nsk.iae.post.poST.Process ele) {
    final Predicate<su.nsk.iae.post.poST.Process> _function = (su.nsk.iae.post.poST.Process x) -> {
      return ((x != ele) && x.getName().equals(ele.getName()));
    };
    return fb.getProcesses().stream().anyMatch(_function);
  }
  
  private boolean checkNameRepetition(final Configuration configuration, final Resource ele) {
    final Predicate<Resource> _function = (Resource x) -> {
      return ((x != ele) && x.getName().equals(ele.getName()));
    };
    return configuration.getResources().stream().anyMatch(_function);
  }
  
  private boolean checkNameRepetition(final Resource resource, final Task ele) {
    final Predicate<Task> _function = (Task x) -> {
      return ((x != ele) && x.getName().equals(ele.getName()));
    };
    return resource.getResStatement().getTasks().stream().anyMatch(_function);
  }
  
  private boolean checkNameRepetition(final Resource resource, final ProgramConfiguration ele) {
    final Predicate<ProgramConfiguration> _function = (ProgramConfiguration x) -> {
      return ((x != ele) && x.getName().equals(ele.getName()));
    };
    return resource.getResStatement().getProgramConfs().stream().anyMatch(_function);
  }
  
  private boolean checkNameRepetition(final ProgramConfiguration programConf, final TemplateProcessConfElement ele) {
    final Predicate<ProgramConfElement> _function = (ProgramConfElement x) -> {
      return (x instanceof TemplateProcessConfElement);
    };
    final Predicate<ProgramConfElement> _function_1 = (ProgramConfElement x) -> {
      return ((x != ele) && ((TemplateProcessConfElement) x).getName().equals(ele.getName()));
    };
    return programConf.getArgs().getElements().stream().filter(_function).anyMatch(_function_1);
  }
  
  private boolean checkNameRepetition(final Model model, final SymbolicVariable ele) {
    return this.checkVarRepetition_GlobalVarDeclaration(model.getGlobVars(), ele);
  }
  
  private boolean checkNameRepetition(final Configuration configuration, final SymbolicVariable ele) {
    return this.checkVarRepetition_GlobalVarDeclaration(configuration.getConfGlobVars(), ele);
  }
  
  private boolean checkNameRepetition(final Resource resource, final SymbolicVariable ele) {
    return this.checkVarRepetition_GlobalVarDeclaration(resource.getResGlobVars(), ele);
  }
  
  private boolean checkNameRepetition(final Program program, final SymbolicVariable ele) {
    return (((((this.checkVarRepetition_InputVarDeclaration(program.getProgInVars(), ele) || 
      this.checkVarRepetition_OutputVarDeclaration(program.getProgOutVars(), ele)) || 
      this.checkVarRepetition_InputOutputVarDeclaration(program.getProgInOutVars(), ele)) || 
      this.checkVarRepetition_VarDeclaration(program.getProgVars(), ele)) || 
      this.checkVarRepetition_TempVarDeclaration(program.getProgTempVars(), ele)) || 
      this.checkVarRepetition_ExternalVarDeclaration(program.getProgExternVars(), ele));
  }
  
  private boolean checkNameRepetition(final su.nsk.iae.post.poST.Process process, final SymbolicVariable ele) {
    return ((((this.checkVarRepetition_InputVarDeclaration(process.getProcInVars(), ele) || 
      this.checkVarRepetition_OutputVarDeclaration(process.getProcOutVars(), ele)) || 
      this.checkVarRepetition_InputOutputVarDeclaration(process.getProcInOutVars(), ele)) || 
      this.checkVarRepetition_VarDeclaration(process.getProcVars(), ele)) || 
      this.checkVarRepetition_TempVarDeclaration(process.getProcTempVars(), ele));
  }
  
  private boolean checkNameRepetition(final su.nsk.iae.post.poST.Process process, final ProcessVariable ele) {
    return this.checkVarRepetition_ProcessVarDeclaration(process.getProcProcessVars(), ele);
  }
  
  private boolean checkVarRepetition_InputVarDeclaration(final EList<InputVarDeclaration> varList, final SymbolicVariable ele) {
    final Predicate<InputVarDeclaration> _function = (InputVarDeclaration x) -> {
      return this.checkVarRepetition_VarInitDeclaration(x.getVars(), ele);
    };
    return varList.stream().anyMatch(_function);
  }
  
  private boolean checkVarRepetition_OutputVarDeclaration(final EList<OutputVarDeclaration> varList, final SymbolicVariable ele) {
    final Predicate<OutputVarDeclaration> _function = (OutputVarDeclaration x) -> {
      return this.checkVarRepetition_VarInitDeclaration(x.getVars(), ele);
    };
    return varList.stream().anyMatch(_function);
  }
  
  private boolean checkVarRepetition_InputOutputVarDeclaration(final EList<InputOutputVarDeclaration> varList, final SymbolicVariable ele) {
    final Predicate<InputOutputVarDeclaration> _function = (InputOutputVarDeclaration x) -> {
      return this.checkVarRepetition_VarInitDeclaration(x.getVars(), ele);
    };
    return varList.stream().anyMatch(_function);
  }
  
  private boolean checkVarRepetition_VarDeclaration(final EList<VarDeclaration> varList, final SymbolicVariable ele) {
    final Predicate<VarDeclaration> _function = (VarDeclaration x) -> {
      return this.checkVarRepetition_VarInitDeclaration(x.getVars(), ele);
    };
    return varList.stream().anyMatch(_function);
  }
  
  private boolean checkVarRepetition_TempVarDeclaration(final EList<TempVarDeclaration> varList, final SymbolicVariable ele) {
    final Predicate<TempVarDeclaration> _function = (TempVarDeclaration x) -> {
      return this.checkVarRepetition_VarInitDeclaration(x.getVars(), ele);
    };
    return varList.stream().anyMatch(_function);
  }
  
  private boolean checkVarRepetition_ExternalVarDeclaration(final EList<ExternalVarDeclaration> varList, final SymbolicVariable ele) {
    final Predicate<ExternalVarDeclaration> _function = (ExternalVarDeclaration x) -> {
      return this.checkVarRepetition_ExternalVarInitDeclaration(x.getVars(), ele);
    };
    return varList.stream().anyMatch(_function);
  }
  
  private boolean checkVarRepetition_GlobalVarDeclaration(final EList<GlobalVarDeclaration> varList, final SymbolicVariable ele) {
    return (varList.stream().anyMatch(((Predicate<GlobalVarDeclaration>) (GlobalVarDeclaration x) -> {
      return this.checkVarRepetition_VarInitDeclaration(x.getVarsSimple(), ele);
    })) || 
      varList.stream().anyMatch(((Predicate<GlobalVarDeclaration>) (GlobalVarDeclaration x) -> {
        return this.checkVarRepetition_GlobalVarInitDeclaration(x.getVarsAs(), ele);
      })));
  }
  
  private boolean checkVarRepetition_ProcessVarDeclaration(final EList<ProcessVarDeclaration> varList, final ProcessVariable ele) {
    final Predicate<ProcessVarDeclaration> _function = (ProcessVarDeclaration x) -> {
      return this.checkVarRepetition_ProcessVarInitDeclaration(x.getVars(), ele);
    };
    return varList.stream().anyMatch(_function);
  }
  
  private boolean checkVarRepetition_VarInitDeclaration(final EList<VarInitDeclaration> varList, final SymbolicVariable ele) {
    final Function<VarInitDeclaration, EList<SymbolicVariable>> _function = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_1 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    final Predicate<SymbolicVariable> _function_2 = (SymbolicVariable x) -> {
      return ((x != ele) && x.getName().equals(ele.getName()));
    };
    return varList.stream().<EList<SymbolicVariable>>map(_function).<SymbolicVariable>flatMap(_function_1).anyMatch(_function_2);
  }
  
  private boolean checkVarRepetition_ExternalVarInitDeclaration(final EList<ExternalVarInitDeclaration> varList, final SymbolicVariable ele) {
    final Function<ExternalVarInitDeclaration, EList<SymbolicVariable>> _function = (ExternalVarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_1 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    final Predicate<SymbolicVariable> _function_2 = (SymbolicVariable x) -> {
      return ((x != ele) && x.getName().equals(ele.getName()));
    };
    return varList.stream().<EList<SymbolicVariable>>map(_function).<SymbolicVariable>flatMap(_function_1).anyMatch(_function_2);
  }
  
  private boolean checkVarRepetition_GlobalVarInitDeclaration(final EList<GlobalVarInitDeclaration> varList, final SymbolicVariable ele) {
    final Function<GlobalVarInitDeclaration, EList<SymbolicVariable>> _function = (GlobalVarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_1 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    final Predicate<SymbolicVariable> _function_2 = (SymbolicVariable x) -> {
      return ((x != ele) && x.getName().equals(ele.getName()));
    };
    return varList.stream().<EList<SymbolicVariable>>map(_function).<SymbolicVariable>flatMap(_function_1).anyMatch(_function_2);
  }
  
  private boolean checkVarRepetition_ProcessVarInitDeclaration(final EList<ProcessVarInitDeclaration> varList, final ProcessVariable ele) {
    final Function<ProcessVarInitDeclaration, EList<ProcessVariable>> _function = (ProcessVarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<EList<ProcessVariable>, Stream<ProcessVariable>> _function_1 = (EList<ProcessVariable> x) -> {
      return x.stream();
    };
    final Predicate<ProcessVariable> _function_2 = (ProcessVariable x) -> {
      return ((x != ele) && x.getName().equals(ele.getName()));
    };
    return varList.stream().<EList<ProcessVariable>>map(_function).<ProcessVariable>flatMap(_function_1).anyMatch(_function_2);
  }
}
