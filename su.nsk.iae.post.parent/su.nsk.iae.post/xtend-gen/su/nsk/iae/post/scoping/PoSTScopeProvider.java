package su.nsk.iae.post.scoping;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;

import com.google.common.base.Function;
import com.google.common.base.Objects;

import su.nsk.iae.post.naming.PoSTQualifiedNameProvider;
import su.nsk.iae.post.poST.InputOutputVarDeclaration;
import su.nsk.iae.post.poST.InputVarDeclaration;
import su.nsk.iae.post.poST.OutputVarDeclaration;
import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.Program;
import su.nsk.iae.post.poST.ProgramConfiguration;
import su.nsk.iae.post.poST.SymbolicVariable;
import su.nsk.iae.post.poST.TemplateProcessConfElement;
import su.nsk.iae.post.poST.VarInitDeclaration;

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
    EReference _attachVariableConfElement_ProgramVar = this.ePackage.getAttachVariableConfElement_ProgramVar();
    boolean _equals = Objects.equal(reference, _attachVariableConfElement_ProgramVar);
    if (_equals) {
      final TemplateProcessConfElement processConf = EcoreUtil2.<TemplateProcessConfElement>getContainerOfType(context, TemplateProcessConfElement.class);
      if ((processConf != null)) {
        return this.scopeForVar(this.getProcessInOutVar(processConf.getProcess()), simple);
      }
      final ProgramConfiguration programConf = EcoreUtil2.<ProgramConfiguration>getContainerOfType(context, ProgramConfiguration.class);
      return this.scopeForVar(this.getProgramInOutVar(programConf.getProgram()), simple);
    }
    EReference _templateProcessConfElement_Process = this.ePackage.getTemplateProcessConfElement_Process();
    boolean _equals_1 = Objects.equal(reference, _templateProcessConfElement_Process);
    if (_equals_1) {
      final ProgramConfiguration programConf_1 = EcoreUtil2.<ProgramConfiguration>getContainerOfType(context, ProgramConfiguration.class);
      return this.scopeForProcess(context, reference, this.getProcessList(programConf_1.getProgram()), simple);
    }
    return null;
  }
  
  public IScope scopeForVar(final Iterable<? extends EObject> elements, final boolean simple) {
    if (simple) {
      return Scopes.scopeFor(elements);
    }
    PoSTScopeProvider.PoSTScope<EObject> _poSTScope = new PoSTScopeProvider.PoSTScope<EObject>();
    return Scopes.<EObject>scopeFor(elements, _poSTScope, IScope.NULLSCOPE);
  }
  
  public IScope scopeForProcess(final EObject context, final EReference reference, final Iterable<? extends EObject> elements, final boolean simple) {
    if (simple) {
      return Scopes.scopeFor(elements);
    }
    return super.getScope(context, reference);
  }
  
  private List<su.nsk.iae.post.poST.Process> getProcessList(final Program program) {
    final Predicate<su.nsk.iae.post.poST.Process> _function = (su.nsk.iae.post.poST.Process x) -> {
      return (((!x.getProcInVars().isEmpty()) || (!x.getProcOutVars().isEmpty())) || (!x.getProcInOutVars().isEmpty()));
    };
    return program.getProcesses().stream().filter(_function).collect(Collectors.<su.nsk.iae.post.poST.Process>toList());
  }
  
  private List<SymbolicVariable> getProgramInOutVar(final Program program) {
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
  
  private List<SymbolicVariable> getProcessInOutVar(final su.nsk.iae.post.poST.Process process) {
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
}
