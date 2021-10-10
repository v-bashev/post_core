package su.nsk.iae.post.scoping;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import su.nsk.iae.post.library.PoSTLibraryProvider;
import su.nsk.iae.post.poST.Configuration;
import su.nsk.iae.post.poST.ExternalVarDeclaration;
import su.nsk.iae.post.poST.ExternalVarInitDeclaration;
import su.nsk.iae.post.poST.FBInvocation;
import su.nsk.iae.post.poST.FunctionBlock;
import su.nsk.iae.post.poST.FunctionCall;
import su.nsk.iae.post.poST.GlobalVarDeclaration;
import su.nsk.iae.post.poST.GlobalVarInitDeclaration;
import su.nsk.iae.post.poST.InputOutputVarDeclaration;
import su.nsk.iae.post.poST.InputVarDeclaration;
import su.nsk.iae.post.poST.Model;
import su.nsk.iae.post.poST.OutputVarDeclaration;
import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.ProcessVarDeclaration;
import su.nsk.iae.post.poST.ProcessVarInitDeclaration;
import su.nsk.iae.post.poST.ProcessVariable;
import su.nsk.iae.post.poST.Program;
import su.nsk.iae.post.poST.ProgramConfiguration;
import su.nsk.iae.post.poST.Resource;
import su.nsk.iae.post.poST.SymbolicVariable;
import su.nsk.iae.post.poST.TempVarDeclaration;
import su.nsk.iae.post.poST.TemplateProcessConfElement;
import su.nsk.iae.post.poST.VarDeclaration;
import su.nsk.iae.post.poST.VarInitDeclaration;
import su.nsk.iae.post.poST.Variable;

@SuppressWarnings("all")
public class PoSTScopeProvider extends AbstractPoSTScopeProvider {
  private final PoSTPackage ePackage = PoSTPackage.eINSTANCE;
  
  private final PoSTLibraryProvider libraryProvider = new PoSTLibraryProvider();
  
  @Inject
  private IQualifiedNameProvider qualifiedNameProvider;
  
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    boolean _matched = false;
    EReference _primaryExpression_Variable = this.ePackage.getPrimaryExpression_Variable();
    if (Objects.equal(reference, _primaryExpression_Variable)) {
      _matched=true;
    }
    if (!_matched) {
      EReference _assignmentStatement_Variable = this.ePackage.getAssignmentStatement_Variable();
      if (Objects.equal(reference, _assignmentStatement_Variable)) {
        _matched=true;
      }
    }
    if (!_matched) {
      EReference _arrayVariable_Variable = this.ePackage.getArrayVariable_Variable();
      if (Objects.equal(reference, _arrayVariable_Variable)) {
        _matched=true;
      }
    }
    if (!_matched) {
      EReference _forStatement_Variable = this.ePackage.getForStatement_Variable();
      if (Objects.equal(reference, _forStatement_Variable)) {
        _matched=true;
      }
    }
    if (_matched) {
      return this.scopeForStatementExpression_Variable(context);
    }
    if (!_matched) {
      EReference _functionCall_Function = this.ePackage.getFunctionCall_Function();
      if (Objects.equal(reference, _functionCall_Function)) {
        _matched=true;
        return this.scopeForFunctionCall_Function(context);
      }
    }
    if (!_matched) {
      EReference _varInitDeclaration_Fb = this.ePackage.getVarInitDeclaration_Fb();
      if (Objects.equal(reference, _varInitDeclaration_Fb)) {
        _matched=true;
        return this.scopeForVarInitDeclaration_Fb(context);
      }
    }
    if (!_matched) {
      EReference _paramAssignment_Variable = this.ePackage.getParamAssignment_Variable();
      if (Objects.equal(reference, _paramAssignment_Variable)) {
        _matched=true;
        return this.scopeForParamAssignment_Variable(context);
      }
    }
    if (!_matched) {
      EReference _attachVariableConfElement_ProgramVar = this.ePackage.getAttachVariableConfElement_ProgramVar();
      if (Objects.equal(reference, _attachVariableConfElement_ProgramVar)) {
        _matched=true;
        return this.scopeForAttachVariableConfElement_ProgramVar(context);
      }
    }
    if (!_matched) {
      EReference _templateProcessAttachVariableConfElement_ProgramVar = this.ePackage.getTemplateProcessAttachVariableConfElement_ProgramVar();
      if (Objects.equal(reference, _templateProcessAttachVariableConfElement_ProgramVar)) {
        _matched=true;
        return this.scopeForTemplateProcessAttachVariableConfElement_ProgramVar(context);
      }
    }
    if (!_matched) {
      EReference _templateProcessConfElement_Process = this.ePackage.getTemplateProcessConfElement_Process();
      if (Objects.equal(reference, _templateProcessConfElement_Process)) {
        _matched=true;
        return this.scopeForTemplateProcessConfElement_Process(context);
      }
    }
    if (!_matched) {
      EReference _processStatements_Process = this.ePackage.getProcessStatements_Process();
      if (Objects.equal(reference, _processStatements_Process)) {
        _matched=true;
      }
      if (!_matched) {
        EReference _processStatusExpression_Process = this.ePackage.getProcessStatusExpression_Process();
        if (Objects.equal(reference, _processStatusExpression_Process)) {
          _matched=true;
        }
      }
      if (_matched) {
        return this.scopeForProcessStatements_Process(context);
      }
    }
    if (!_matched) {
      EReference _setStateStatement_State = this.ePackage.getSetStateStatement_State();
      if (Objects.equal(reference, _setStateStatement_State)) {
        _matched=true;
        return this.scopeForSetStateStatement_State(context);
      }
    }
    if (!_matched) {
      EReference _programConfiguration_Task = this.ePackage.getProgramConfiguration_Task();
      if (Objects.equal(reference, _programConfiguration_Task)) {
        _matched=true;
        return this.scopeForProgramConfiguration_Task(context);
      }
    }
    return super.getScope(context, reference);
  }
  
  private IScope scopeFor(final Iterable<? extends EObject> elements) {
    final Function<EObject, QualifiedName> _function = (EObject x) -> {
      return this.qualifiedNameProvider.getFullyQualifiedName(x);
    };
    return Scopes.<EObject>scopeFor(elements, _function, IScope.NULLSCOPE);
  }
  
  private IScope scopeForStatementExpression_Variable(final EObject context) {
    final Model model = EcoreUtil2.<Model>getContainerOfType(context, Model.class);
    final Program program = EcoreUtil2.<Program>getContainerOfType(context, Program.class);
    final su.nsk.iae.post.poST.Process process = EcoreUtil2.<su.nsk.iae.post.poST.Process>getContainerOfType(context, su.nsk.iae.post.poST.Process.class);
    return this.scopeFor(this.getAvailableVar(model, program, process));
  }
  
  private IScope scopeForFunctionCall_Function(final EObject context) {
    final Model model = EcoreUtil2.<Model>getContainerOfType(context, Model.class);
    final List<su.nsk.iae.post.poST.Function> res = Stream.<su.nsk.iae.post.poST.Function>concat(
      model.getFuns().stream(), 
      this.libraryProvider.getLibraryFunctions(context).stream()).collect(Collectors.<su.nsk.iae.post.poST.Function>toList());
    return this.scopeFor(res);
  }
  
  private IScope scopeForVarInitDeclaration_Fb(final EObject context) {
    final Model model = EcoreUtil2.<Model>getContainerOfType(context, Model.class);
    final List<FunctionBlock> res = Stream.<FunctionBlock>concat(
      model.getFbs().stream(), 
      this.libraryProvider.getLibraryFunctionBlocks(context).stream()).collect(Collectors.<FunctionBlock>toList());
    return this.scopeFor(res);
  }
  
  private IScope scopeForParamAssignment_Variable(final EObject context) {
    FunctionCall _containerOfType = EcoreUtil2.<FunctionCall>getContainerOfType(context, FunctionCall.class);
    boolean _tripleNotEquals = (_containerOfType != null);
    if (_tripleNotEquals) {
      final su.nsk.iae.post.poST.Function function = EcoreUtil2.<FunctionCall>getContainerOfType(context, FunctionCall.class).getFunction();
      return this.scopeFor(PoSTScopeProvider.getFunctionInOutVar(function));
    }
    final SymbolicVariable fbDecl = EcoreUtil2.<FBInvocation>getContainerOfType(context, FBInvocation.class).getFb();
    final FunctionBlock fb = EcoreUtil2.<VarInitDeclaration>getContainerOfType(fbDecl, VarInitDeclaration.class).getFb();
    if ((fb != null)) {
      return this.scopeFor(PoSTScopeProvider.getFunctionBlockInOutVar(fb));
    }
    return this.scopeFor(Collections.<EObject>emptyList());
  }
  
  private IScope scopeForAttachVariableConfElement_ProgramVar(final EObject context) {
    final ProgramConfiguration programConf = EcoreUtil2.<ProgramConfiguration>getContainerOfType(context, ProgramConfiguration.class);
    return this.scopeFor(PoSTScopeProvider.getProgramInOutVar(programConf.getProgram()));
  }
  
  private IScope scopeForTemplateProcessAttachVariableConfElement_ProgramVar(final EObject context) {
    final TemplateProcessConfElement processConf = EcoreUtil2.<TemplateProcessConfElement>getContainerOfType(context, TemplateProcessConfElement.class);
    return this.scopeFor(PoSTScopeProvider.getProcessTemplateVar(processConf.getProcess()));
  }
  
  private IScope scopeForTemplateProcessConfElement_Process(final EObject context) {
    final ProgramConfiguration programConf = EcoreUtil2.<ProgramConfiguration>getContainerOfType(context, ProgramConfiguration.class);
    return this.scopeFor(programConf.getProgram().getProcesses());
  }
  
  private IScope scopeForProcessStatements_Process(final EObject context) {
    final su.nsk.iae.post.poST.Process process = EcoreUtil2.<su.nsk.iae.post.poST.Process>getContainerOfType(context, su.nsk.iae.post.poST.Process.class);
    final Program program = EcoreUtil2.<Program>getContainerOfType(process, Program.class);
    final List<Variable> res = Stream.<Variable>concat(
      PoSTScopeProvider.getProcessProcessVar(process).stream(), 
      program.getProcesses().stream()).collect(Collectors.<Variable>toList());
    return this.scopeFor(res);
  }
  
  private IScope scopeForSetStateStatement_State(final EObject context) {
    final su.nsk.iae.post.poST.Process process = EcoreUtil2.<su.nsk.iae.post.poST.Process>getContainerOfType(context, su.nsk.iae.post.poST.Process.class);
    return this.scopeFor(process.getStates());
  }
  
  private IScope scopeForProgramConfiguration_Task(final EObject context) {
    final Resource res = EcoreUtil2.<Resource>getContainerOfType(context, Resource.class);
    return this.scopeFor(res.getResStatement().getTasks());
  }
  
  private List<SymbolicVariable> getAvailableVar(final Model model, final Program program, final su.nsk.iae.post.poST.Process process) {
    Stream<SymbolicVariable> res = Stream.<SymbolicVariable>of();
    if ((process != null)) {
      res = Stream.<SymbolicVariable>concat(res, 
        Stream.<SymbolicVariable>concat(
          PoSTScopeProvider.getProcessInOutVar(process).stream(), 
          PoSTScopeProvider.getProcessVar(process).stream()));
    }
    if ((program != null)) {
      res = Stream.<SymbolicVariable>concat(res, 
        Stream.<SymbolicVariable>concat(
          PoSTScopeProvider.getProgramInOutVar(program).stream(), 
          PoSTScopeProvider.getProgramVar(program).stream()));
    }
    res = Stream.<SymbolicVariable>concat(res, PoSTScopeProvider.getGlobalVars(model.getGlobVars()).stream());
    final Configuration conf = model.getConf();
    if ((conf != null)) {
      final EList<Resource> resources = model.getConf().getResources();
      final java.util.function.Function<Resource, List<SymbolicVariable>> _function = (Resource x) -> {
        return PoSTScopeProvider.getGlobalVars(x.getResGlobVars());
      };
      final java.util.function.Function<List<SymbolicVariable>, Stream<SymbolicVariable>> _function_1 = (List<SymbolicVariable> x) -> {
        return x.stream();
      };
      res = Stream.<SymbolicVariable>concat(res, 
        Stream.<SymbolicVariable>concat(
          PoSTScopeProvider.getGlobalVars(conf.getConfGlobVars()).stream(), 
          resources.stream().<List<SymbolicVariable>>map(_function).<SymbolicVariable>flatMap(_function_1)));
    }
    return res.collect(Collectors.<SymbolicVariable>toList());
  }
  
  private static List<SymbolicVariable> getGlobalVars(final EList<GlobalVarDeclaration> list) {
    final java.util.function.Function<GlobalVarDeclaration, EList<VarInitDeclaration>> _function = (GlobalVarDeclaration x) -> {
      return x.getVarsSimple();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_1 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_2 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<GlobalVarDeclaration, EList<GlobalVarInitDeclaration>> _function_3 = (GlobalVarDeclaration x) -> {
      return x.getVarsAs();
    };
    final java.util.function.Function<EList<GlobalVarInitDeclaration>, Stream<GlobalVarInitDeclaration>> _function_4 = (EList<GlobalVarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<GlobalVarInitDeclaration, EList<SymbolicVariable>> _function_5 = (GlobalVarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_6 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    return Stream.<EList<SymbolicVariable>>concat(
      list.stream().<EList<VarInitDeclaration>>map(_function).<VarInitDeclaration>flatMap(_function_1).<EList<SymbolicVariable>>map(_function_2), 
      list.stream().<EList<GlobalVarInitDeclaration>>map(_function_3).<GlobalVarInitDeclaration>flatMap(_function_4).<EList<SymbolicVariable>>map(_function_5)).<SymbolicVariable>flatMap(_function_6).collect(Collectors.<SymbolicVariable>toList());
  }
  
  private static List<SymbolicVariable> getProgramInOutVar(final Program program) {
    final java.util.function.Function<InputVarDeclaration, EList<VarInitDeclaration>> _function = (InputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_1 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_2 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<OutputVarDeclaration, EList<VarInitDeclaration>> _function_3 = (OutputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_4 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_5 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<InputOutputVarDeclaration, EList<VarInitDeclaration>> _function_6 = (InputOutputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_7 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_8 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_9 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    return Stream.<EList<SymbolicVariable>>concat(
      program.getProgInVars().stream().<EList<VarInitDeclaration>>map(_function).<VarInitDeclaration>flatMap(_function_1).<EList<SymbolicVariable>>map(_function_2), 
      Stream.<EList<SymbolicVariable>>concat(
        program.getProgOutVars().stream().<EList<VarInitDeclaration>>map(_function_3).<VarInitDeclaration>flatMap(_function_4).<EList<SymbolicVariable>>map(_function_5), 
        program.getProgInOutVars().stream().<EList<VarInitDeclaration>>map(_function_6).<VarInitDeclaration>flatMap(_function_7).<EList<SymbolicVariable>>map(_function_8))).<SymbolicVariable>flatMap(_function_9).collect(Collectors.<SymbolicVariable>toList());
  }
  
  private static List<SymbolicVariable> getFunctionBlockInOutVar(final FunctionBlock fb) {
    final java.util.function.Function<InputVarDeclaration, EList<VarInitDeclaration>> _function = (InputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_1 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_2 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<OutputVarDeclaration, EList<VarInitDeclaration>> _function_3 = (OutputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_4 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_5 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<InputOutputVarDeclaration, EList<VarInitDeclaration>> _function_6 = (InputOutputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_7 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_8 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_9 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    return Stream.<EList<SymbolicVariable>>concat(
      fb.getFbInVars().stream().<EList<VarInitDeclaration>>map(_function).<VarInitDeclaration>flatMap(_function_1).<EList<SymbolicVariable>>map(_function_2), 
      Stream.<EList<SymbolicVariable>>concat(
        fb.getFbOutVars().stream().<EList<VarInitDeclaration>>map(_function_3).<VarInitDeclaration>flatMap(_function_4).<EList<SymbolicVariable>>map(_function_5), 
        fb.getFbInOutVars().stream().<EList<VarInitDeclaration>>map(_function_6).<VarInitDeclaration>flatMap(_function_7).<EList<SymbolicVariable>>map(_function_8))).<SymbolicVariable>flatMap(_function_9).collect(Collectors.<SymbolicVariable>toList());
  }
  
  private static List<SymbolicVariable> getFunctionInOutVar(final su.nsk.iae.post.poST.Function function) {
    final java.util.function.Function<InputVarDeclaration, EList<VarInitDeclaration>> _function = (InputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_1 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_2 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<OutputVarDeclaration, EList<VarInitDeclaration>> _function_3 = (OutputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_4 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_5 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<InputOutputVarDeclaration, EList<VarInitDeclaration>> _function_6 = (InputOutputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_7 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_8 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_9 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    return Stream.<EList<SymbolicVariable>>concat(
      function.getFunInVars().stream().<EList<VarInitDeclaration>>map(_function).<VarInitDeclaration>flatMap(_function_1).<EList<SymbolicVariable>>map(_function_2), 
      Stream.<EList<SymbolicVariable>>concat(
        function.getFunOutVars().stream().<EList<VarInitDeclaration>>map(_function_3).<VarInitDeclaration>flatMap(_function_4).<EList<SymbolicVariable>>map(_function_5), 
        function.getFunInOutVars().stream().<EList<VarInitDeclaration>>map(_function_6).<VarInitDeclaration>flatMap(_function_7).<EList<SymbolicVariable>>map(_function_8))).<SymbolicVariable>flatMap(_function_9).collect(Collectors.<SymbolicVariable>toList());
  }
  
  private static List<SymbolicVariable> getProgramVar(final Program program) {
    final java.util.function.Function<VarDeclaration, EList<VarInitDeclaration>> _function = (VarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_1 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_2 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<TempVarDeclaration, EList<VarInitDeclaration>> _function_3 = (TempVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_4 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_5 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<ExternalVarDeclaration, EList<ExternalVarInitDeclaration>> _function_6 = (ExternalVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<ExternalVarInitDeclaration>, Stream<ExternalVarInitDeclaration>> _function_7 = (EList<ExternalVarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<ExternalVarInitDeclaration, EList<SymbolicVariable>> _function_8 = (ExternalVarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_9 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    return Stream.<EList<SymbolicVariable>>concat(
      program.getProgVars().stream().<EList<VarInitDeclaration>>map(_function).<VarInitDeclaration>flatMap(_function_1).<EList<SymbolicVariable>>map(_function_2), 
      Stream.<EList<SymbolicVariable>>concat(
        program.getProgTempVars().stream().<EList<VarInitDeclaration>>map(_function_3).<VarInitDeclaration>flatMap(_function_4).<EList<SymbolicVariable>>map(_function_5), 
        program.getProgExternVars().stream().<EList<ExternalVarInitDeclaration>>map(_function_6).<ExternalVarInitDeclaration>flatMap(_function_7).<EList<SymbolicVariable>>map(_function_8))).<SymbolicVariable>flatMap(_function_9).collect(Collectors.<SymbolicVariable>toList());
  }
  
  private static List<Variable> getProcessTemplateVar(final su.nsk.iae.post.poST.Process process) {
    return Stream.<Variable>concat(
      PoSTScopeProvider.getProcessInOutVar(process).stream(), 
      PoSTScopeProvider.getProcessProcessVar(process).stream()).collect(Collectors.<Variable>toList());
  }
  
  private static List<ProcessVariable> getProcessProcessVar(final su.nsk.iae.post.poST.Process process) {
    final java.util.function.Function<ProcessVarDeclaration, EList<ProcessVarInitDeclaration>> _function = (ProcessVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<ProcessVarInitDeclaration>, Stream<ProcessVarInitDeclaration>> _function_1 = (EList<ProcessVarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<ProcessVarInitDeclaration, EList<ProcessVariable>> _function_2 = (ProcessVarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<EList<ProcessVariable>, Stream<ProcessVariable>> _function_3 = (EList<ProcessVariable> x) -> {
      return x.stream();
    };
    return process.getProcProcessVars().stream().<EList<ProcessVarInitDeclaration>>map(_function).<ProcessVarInitDeclaration>flatMap(_function_1).<EList<ProcessVariable>>map(_function_2).<ProcessVariable>flatMap(_function_3).collect(Collectors.<ProcessVariable>toList());
  }
  
  private static List<SymbolicVariable> getProcessInOutVar(final su.nsk.iae.post.poST.Process process) {
    final java.util.function.Function<InputVarDeclaration, EList<VarInitDeclaration>> _function = (InputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_1 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_2 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<OutputVarDeclaration, EList<VarInitDeclaration>> _function_3 = (OutputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_4 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_5 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<InputOutputVarDeclaration, EList<VarInitDeclaration>> _function_6 = (InputOutputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_7 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_8 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_9 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    return Stream.<EList<SymbolicVariable>>concat(
      process.getProcInVars().stream().<EList<VarInitDeclaration>>map(_function).<VarInitDeclaration>flatMap(_function_1).<EList<SymbolicVariable>>map(_function_2), 
      Stream.<EList<SymbolicVariable>>concat(
        process.getProcOutVars().stream().<EList<VarInitDeclaration>>map(_function_3).<VarInitDeclaration>flatMap(_function_4).<EList<SymbolicVariable>>map(_function_5), 
        process.getProcInOutVars().stream().<EList<VarInitDeclaration>>map(_function_6).<VarInitDeclaration>flatMap(_function_7).<EList<SymbolicVariable>>map(_function_8))).<SymbolicVariable>flatMap(_function_9).collect(Collectors.<SymbolicVariable>toList());
  }
  
  private static List<SymbolicVariable> getProcessVar(final su.nsk.iae.post.poST.Process process) {
    final java.util.function.Function<VarDeclaration, EList<VarInitDeclaration>> _function = (VarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_1 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_2 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<TempVarDeclaration, EList<VarInitDeclaration>> _function_3 = (TempVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_4 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_5 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_6 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    return Stream.<EList<SymbolicVariable>>concat(
      process.getProcVars().stream().<EList<VarInitDeclaration>>map(_function).<VarInitDeclaration>flatMap(_function_1).<EList<SymbolicVariable>>map(_function_2), 
      process.getProcTempVars().stream().<EList<VarInitDeclaration>>map(_function_3).<VarInitDeclaration>flatMap(_function_4).<EList<SymbolicVariable>>map(_function_5)).<SymbolicVariable>flatMap(_function_6).collect(Collectors.<SymbolicVariable>toList());
  }
}
