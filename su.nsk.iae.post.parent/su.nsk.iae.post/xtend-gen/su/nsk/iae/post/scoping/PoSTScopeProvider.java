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
import su.nsk.iae.post.poST.FunctionBlock;
import su.nsk.iae.post.poST.InputVarDeclaration;
import su.nsk.iae.post.poST.Model;
import su.nsk.iae.post.poST.OutputVarDeclaration;
import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.Program;
import su.nsk.iae.post.poST.SymbolicVariable;
import su.nsk.iae.post.poST.TemplateProcessConfElement;
import su.nsk.iae.post.poST.VarInitDeclaration;

@SuppressWarnings("all")
public class PoSTScopeProvider extends AbstractPoSTScopeProvider {
  public static class PoSTScope implements Function<SymbolicVariable, QualifiedName> {
    private static final PoSTQualifiedNameProvider qualifiedNameProvider = new PoSTQualifiedNameProvider();
    
    @Override
    public QualifiedName apply(final SymbolicVariable ele) {
      return PoSTScopeProvider.PoSTScope.qualifiedNameProvider.qualifiedPoSTName(ele);
    }
  }
  
  private final PoSTPackage ePackage = PoSTPackage.eINSTANCE;
  
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    EReference _attachVariableConfElement_ProgramVar = this.ePackage.getAttachVariableConfElement_ProgramVar();
    boolean _equals = Objects.equal(reference, _attachVariableConfElement_ProgramVar);
    if (_equals) {
      final Model model = EcoreUtil2.<Model>getContainerOfType(context, Model.class);
      TemplateProcessConfElement _containerOfType = EcoreUtil2.<TemplateProcessConfElement>getContainerOfType(context, TemplateProcessConfElement.class);
      boolean _tripleNotEquals = (_containerOfType != null);
      if (_tripleNotEquals) {
        List<SymbolicVariable> _processInOutVar = this.getProcessInOutVar(model);
        PoSTScopeProvider.PoSTScope _poSTScope = new PoSTScopeProvider.PoSTScope();
        return Scopes.<SymbolicVariable>scopeFor(_processInOutVar, _poSTScope, IScope.NULLSCOPE);
      }
      List<SymbolicVariable> _programInOutVar = this.getProgramInOutVar(model);
      PoSTScopeProvider.PoSTScope _poSTScope_1 = new PoSTScopeProvider.PoSTScope();
      return Scopes.<SymbolicVariable>scopeFor(_programInOutVar, _poSTScope_1, IScope.NULLSCOPE);
    }
    return super.getScope(context, reference);
  }
  
  private List<SymbolicVariable> getProgramInOutVar(final Model model) {
    final java.util.function.Function<Program, EList<InputVarDeclaration>> _function = (Program x) -> {
      return x.getProgInVars();
    };
    final java.util.function.Function<EList<InputVarDeclaration>, Stream<InputVarDeclaration>> _function_1 = (EList<InputVarDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<InputVarDeclaration, EList<VarInitDeclaration>> _function_2 = (InputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_3 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_4 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<Program, EList<OutputVarDeclaration>> _function_5 = (Program x) -> {
      return x.getProgOutVars();
    };
    final java.util.function.Function<EList<OutputVarDeclaration>, Stream<OutputVarDeclaration>> _function_6 = (EList<OutputVarDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<OutputVarDeclaration, EList<VarInitDeclaration>> _function_7 = (OutputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_8 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_9 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<FunctionBlock, EList<InputVarDeclaration>> _function_10 = (FunctionBlock x) -> {
      return x.getFbInVars();
    };
    final java.util.function.Function<EList<InputVarDeclaration>, Stream<InputVarDeclaration>> _function_11 = (EList<InputVarDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<InputVarDeclaration, EList<VarInitDeclaration>> _function_12 = (InputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_13 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_14 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<FunctionBlock, EList<OutputVarDeclaration>> _function_15 = (FunctionBlock x) -> {
      return x.getFbOutVars();
    };
    final java.util.function.Function<EList<OutputVarDeclaration>, Stream<OutputVarDeclaration>> _function_16 = (EList<OutputVarDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<OutputVarDeclaration, EList<VarInitDeclaration>> _function_17 = (OutputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_18 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_19 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_20 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    return Stream.<EList<SymbolicVariable>>concat(
      model.getPrograms().stream().<EList<InputVarDeclaration>>map(_function).<InputVarDeclaration>flatMap(_function_1).<EList<VarInitDeclaration>>map(_function_2).<VarInitDeclaration>flatMap(_function_3).<EList<SymbolicVariable>>map(_function_4), 
      Stream.<EList<SymbolicVariable>>concat(
        model.getPrograms().stream().<EList<OutputVarDeclaration>>map(_function_5).<OutputVarDeclaration>flatMap(_function_6).<EList<VarInitDeclaration>>map(_function_7).<VarInitDeclaration>flatMap(_function_8).<EList<SymbolicVariable>>map(_function_9), 
        Stream.<EList<SymbolicVariable>>concat(
          model.getFbs().stream().<EList<InputVarDeclaration>>map(_function_10).<InputVarDeclaration>flatMap(_function_11).<EList<VarInitDeclaration>>map(_function_12).<VarInitDeclaration>flatMap(_function_13).<EList<SymbolicVariable>>map(_function_14), 
          model.getFbs().stream().<EList<OutputVarDeclaration>>map(_function_15).<OutputVarDeclaration>flatMap(_function_16).<EList<VarInitDeclaration>>map(_function_17).<VarInitDeclaration>flatMap(_function_18).<EList<SymbolicVariable>>map(_function_19)))).<SymbolicVariable>flatMap(_function_20).collect(Collectors.<SymbolicVariable>toList());
  }
  
  private List<SymbolicVariable> getProcessInOutVar(final Model model) {
    final java.util.function.Function<Program, EList<su.nsk.iae.post.poST.Process>> _function = (Program x) -> {
      return x.getProcesses();
    };
    final java.util.function.Function<EList<su.nsk.iae.post.poST.Process>, Stream<su.nsk.iae.post.poST.Process>> _function_1 = (EList<su.nsk.iae.post.poST.Process> x) -> {
      return x.stream();
    };
    final java.util.function.Function<su.nsk.iae.post.poST.Process, EList<InputVarDeclaration>> _function_2 = (su.nsk.iae.post.poST.Process x) -> {
      return x.getProcInVars();
    };
    final java.util.function.Function<EList<InputVarDeclaration>, Stream<InputVarDeclaration>> _function_3 = (EList<InputVarDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<InputVarDeclaration, EList<VarInitDeclaration>> _function_4 = (InputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_5 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_6 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<Program, EList<su.nsk.iae.post.poST.Process>> _function_7 = (Program x) -> {
      return x.getProcesses();
    };
    final java.util.function.Function<EList<su.nsk.iae.post.poST.Process>, Stream<su.nsk.iae.post.poST.Process>> _function_8 = (EList<su.nsk.iae.post.poST.Process> x) -> {
      return x.stream();
    };
    final java.util.function.Function<su.nsk.iae.post.poST.Process, EList<OutputVarDeclaration>> _function_9 = (su.nsk.iae.post.poST.Process x) -> {
      return x.getProcOutVars();
    };
    final java.util.function.Function<EList<OutputVarDeclaration>, Stream<OutputVarDeclaration>> _function_10 = (EList<OutputVarDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<OutputVarDeclaration, EList<VarInitDeclaration>> _function_11 = (OutputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_12 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_13 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<FunctionBlock, EList<su.nsk.iae.post.poST.Process>> _function_14 = (FunctionBlock x) -> {
      return x.getProcesses();
    };
    final java.util.function.Function<EList<su.nsk.iae.post.poST.Process>, Stream<su.nsk.iae.post.poST.Process>> _function_15 = (EList<su.nsk.iae.post.poST.Process> x) -> {
      return x.stream();
    };
    final java.util.function.Function<su.nsk.iae.post.poST.Process, EList<InputVarDeclaration>> _function_16 = (su.nsk.iae.post.poST.Process x) -> {
      return x.getProcInVars();
    };
    final java.util.function.Function<EList<InputVarDeclaration>, Stream<InputVarDeclaration>> _function_17 = (EList<InputVarDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<InputVarDeclaration, EList<VarInitDeclaration>> _function_18 = (InputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_19 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_20 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<FunctionBlock, EList<su.nsk.iae.post.poST.Process>> _function_21 = (FunctionBlock x) -> {
      return x.getProcesses();
    };
    final java.util.function.Function<EList<su.nsk.iae.post.poST.Process>, Stream<su.nsk.iae.post.poST.Process>> _function_22 = (EList<su.nsk.iae.post.poST.Process> x) -> {
      return x.stream();
    };
    final java.util.function.Function<su.nsk.iae.post.poST.Process, EList<OutputVarDeclaration>> _function_23 = (su.nsk.iae.post.poST.Process x) -> {
      return x.getProcOutVars();
    };
    final java.util.function.Function<EList<OutputVarDeclaration>, Stream<OutputVarDeclaration>> _function_24 = (EList<OutputVarDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<OutputVarDeclaration, EList<VarInitDeclaration>> _function_25 = (OutputVarDeclaration x) -> {
      return x.getVars();
    };
    final java.util.function.Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_26 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final java.util.function.Function<VarInitDeclaration, EList<SymbolicVariable>> _function_27 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final java.util.function.Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_28 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    return Stream.<EList<SymbolicVariable>>concat(
      model.getPrograms().stream().<EList<su.nsk.iae.post.poST.Process>>map(_function).<su.nsk.iae.post.poST.Process>flatMap(_function_1).<EList<InputVarDeclaration>>map(_function_2).<InputVarDeclaration>flatMap(_function_3).<EList<VarInitDeclaration>>map(_function_4).<VarInitDeclaration>flatMap(_function_5).<EList<SymbolicVariable>>map(_function_6), 
      Stream.<EList<SymbolicVariable>>concat(
        model.getPrograms().stream().<EList<su.nsk.iae.post.poST.Process>>map(_function_7).<su.nsk.iae.post.poST.Process>flatMap(_function_8).<EList<OutputVarDeclaration>>map(_function_9).<OutputVarDeclaration>flatMap(_function_10).<EList<VarInitDeclaration>>map(_function_11).<VarInitDeclaration>flatMap(_function_12).<EList<SymbolicVariable>>map(_function_13), 
        Stream.<EList<SymbolicVariable>>concat(
          model.getFbs().stream().<EList<su.nsk.iae.post.poST.Process>>map(_function_14).<su.nsk.iae.post.poST.Process>flatMap(_function_15).<EList<InputVarDeclaration>>map(_function_16).<InputVarDeclaration>flatMap(_function_17).<EList<VarInitDeclaration>>map(_function_18).<VarInitDeclaration>flatMap(_function_19).<EList<SymbolicVariable>>map(_function_20), 
          model.getFbs().stream().<EList<su.nsk.iae.post.poST.Process>>map(_function_21).<su.nsk.iae.post.poST.Process>flatMap(_function_22).<EList<OutputVarDeclaration>>map(_function_23).<OutputVarDeclaration>flatMap(_function_24).<EList<VarInitDeclaration>>map(_function_25).<VarInitDeclaration>flatMap(_function_26).<EList<SymbolicVariable>>map(_function_27)))).<SymbolicVariable>flatMap(_function_28).collect(Collectors.<SymbolicVariable>toList());
  }
}
