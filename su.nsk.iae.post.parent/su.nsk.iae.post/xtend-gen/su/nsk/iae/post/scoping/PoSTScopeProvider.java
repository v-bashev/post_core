package su.nsk.iae.post.scoping;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import su.nsk.iae.post.naming.PoSTQualifiedNameProvider;
import su.nsk.iae.post.poST.Configuration;
import su.nsk.iae.post.poST.ExternalVarDeclaration;
import su.nsk.iae.post.poST.ExternalVarInitDeclaration;
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
  public static class PoSTScope<T extends EObject> implements Function<T, QualifiedName> {
    private static final PoSTQualifiedNameProvider qualifiedNameProvider = new PoSTQualifiedNameProvider();
    
    @Override
    public QualifiedName apply(final T ele) {
      return PoSTScopeProvider.PoSTScope.qualifiedNameProvider.qualifiedPoSTName(ele);
    }
  }
  
  private final PoSTPackage ePackage = PoSTPackage.eINSTANCE;
  
  public IScope getPoSTScope(final EObject context, final EReference reference) {
    return this.getScope(context, reference, false);
  }
  
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    final IScope scope = this.getScope(context, reference, true);
    if ((scope != null)) {
      return scope;
    }
    return super.getScope(context, reference);
  }
  
  public IScope getScope(final EObject context, final EReference reference, final boolean simple) {
    boolean _matched = false;
    EReference _assignmentStatement_Variable = this.ePackage.getAssignmentStatement_Variable();
    if (Objects.equal(reference, _assignmentStatement_Variable)) {
      _matched=true;
    }
    if (!_matched) {
      EReference _primaryExpression_Variable = this.ePackage.getPrimaryExpression_Variable();
      if (Objects.equal(reference, _primaryExpression_Variable)) {
        _matched=true;
      }
    }
    if (_matched) {
      return this.scopeForAssignmentStatementAndPrimaryExpression_Variable(context, reference, simple);
    }
    if (!_matched) {
      EReference _functionCall_Function = this.ePackage.getFunctionCall_Function();
      if (Objects.equal(reference, _functionCall_Function)) {
        _matched=true;
        return this.scopeForFunctionCall_Function(context, reference, simple);
      }
    }
    if (!_matched) {
      EReference _attachVariableConfElement_ProgramVar = this.ePackage.getAttachVariableConfElement_ProgramVar();
      if (Objects.equal(reference, _attachVariableConfElement_ProgramVar)) {
        _matched=true;
        return this.scopeForAttachVariableConfElement_ProgramVar(context, reference, simple);
      }
    }
    if (!_matched) {
      EReference _templateProcessAttachVariableConfElement_ProgramVar = this.ePackage.getTemplateProcessAttachVariableConfElement_ProgramVar();
      if (Objects.equal(reference, _templateProcessAttachVariableConfElement_ProgramVar)) {
        _matched=true;
        return this.scopeForTemplateProcessAttachVariableConfElement_ProgramVar(context, reference, simple);
      }
    }
    if (!_matched) {
      EReference _templateProcessConfElement_Process = this.ePackage.getTemplateProcessConfElement_Process();
      if (Objects.equal(reference, _templateProcessConfElement_Process)) {
        _matched=true;
        return this.scopeForTemplateProcessConfElement_Process(context, reference, simple);
      }
    }
    return null;
  }
  
  private IScope scopeForVar(final Iterable<? extends EObject> elements, final boolean simple) {
    if (simple) {
      return Scopes.scopeFor(elements);
    }
    PoSTScopeProvider.PoSTScope<EObject> _poSTScope = new PoSTScopeProvider.PoSTScope<EObject>();
    return Scopes.<EObject>scopeFor(elements, _poSTScope, IScope.NULLSCOPE);
  }
  
  private IScope scopeSuper(final EObject context, final EReference reference, final Iterable<? extends EObject> elements, final boolean simple) {
    if (simple) {
      return Scopes.scopeFor(elements);
    }
    return super.getScope(context, reference);
  }
  
  private IScope scopeForAssignmentStatementAndPrimaryExpression_Variable(final EObject context, final EReference reference, final boolean simple) {
    final su.nsk.iae.post.poST.Process process = EcoreUtil2.<su.nsk.iae.post.poST.Process>getContainerOfType(context, su.nsk.iae.post.poST.Process.class);
    if ((process != null)) {
      final Program program = EcoreUtil2.<Program>getContainerOfType(process, Program.class);
      final Model model = EcoreUtil2.<Model>getContainerOfType(program, Model.class);
      return this.scopeForVar(this.getAvailableVar(model, program, process), simple);
    }
    return null;
  }
  
  private IScope scopeForFunctionCall_Function(final EObject context, final EReference reference, final boolean simple) {
    final ProgramConfiguration programConf = EcoreUtil2.<ProgramConfiguration>getContainerOfType(context, ProgramConfiguration.class);
    return this.scopeForVar(PoSTScopeProvider.getProgramInOutVar(programConf.getProgram()), simple);
  }
  
  private IScope scopeForAttachVariableConfElement_ProgramVar(final EObject context, final EReference reference, final boolean simple) {
    final ProgramConfiguration programConf = EcoreUtil2.<ProgramConfiguration>getContainerOfType(context, ProgramConfiguration.class);
    return this.scopeForVar(PoSTScopeProvider.getProgramInOutVar(programConf.getProgram()), simple);
  }
  
  private IScope scopeForTemplateProcessAttachVariableConfElement_ProgramVar(final EObject context, final EReference reference, final boolean simple) {
    final TemplateProcessConfElement processConf = EcoreUtil2.<TemplateProcessConfElement>getContainerOfType(context, TemplateProcessConfElement.class);
    return this.scopeForVar(PoSTScopeProvider.getProcessTemplateVar(processConf.getProcess()), simple);
  }
  
  private IScope scopeForTemplateProcessConfElement_Process(final EObject context, final EReference reference, final boolean simple) {
    final ProgramConfiguration programConf = EcoreUtil2.<ProgramConfiguration>getContainerOfType(context, ProgramConfiguration.class);
    return this.scopeSuper(context, reference, programConf.getProgram().getProcesses(), simple);
  }
  
  private List<SymbolicVariable> getAvailableVar(final Model model, final Program program, final su.nsk.iae.post.poST.Process process) {
    Stream<SymbolicVariable> res = Stream.<SymbolicVariable>concat(
      Stream.<SymbolicVariable>concat(
        PoSTScopeProvider.getProcessInOutVar(process).stream(), 
        PoSTScopeProvider.getProcessVar(process).stream()), 
      Stream.<SymbolicVariable>concat(
        PoSTScopeProvider.getProgramInOutVar(program).stream(), 
        PoSTScopeProvider.getProgramVar(program).stream()));
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
    return Stream.<Variable>concat(
      PoSTScopeProvider.getProcessInOutVar(process).stream(), 
      process.getProcProcessVars().stream().<EList<ProcessVarInitDeclaration>>map(_function).<ProcessVarInitDeclaration>flatMap(_function_1).<EList<ProcessVariable>>map(_function_2).<ProcessVariable>flatMap(_function_3)).collect(Collectors.<Variable>toList());
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
