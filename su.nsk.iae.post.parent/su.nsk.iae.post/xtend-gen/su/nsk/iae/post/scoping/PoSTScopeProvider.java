package su.nsk.iae.post.scoping;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import su.nsk.iae.post.poST.InputVarDeclaration;
import su.nsk.iae.post.poST.Model;
import su.nsk.iae.post.poST.OutputVarDeclaration;
import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.ProcessTemplateElements;
import su.nsk.iae.post.poST.Program;
import su.nsk.iae.post.poST.ProgramConfElements;
import su.nsk.iae.post.poST.ProgramConfiguration;
import su.nsk.iae.post.poST.TemplateProcessConfElement;
import su.nsk.iae.post.poST.VarInitDeclaration;

@SuppressWarnings("all")
public class PoSTScopeProvider extends AbstractPoSTScopeProvider {
  private final PoSTPackage ePackage = PoSTPackage.eINSTANCE;
  
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    if ((((context instanceof TemplateProcessConfElement) || (context instanceof ProcessTemplateElements)) && Objects.equal(reference, this.ePackage.getAttachVariableConfElement_ProgramVar()))) {
      final Model model = EcoreUtil2.<Model>getContainerOfType(context, Model.class);
      final ArrayList<EObject> candidates = new ArrayList<EObject>();
      this.getProcessInOutVar(candidates, model);
      return Scopes.scopeFor(candidates);
    }
    if ((((context instanceof ProgramConfiguration) || (context instanceof ProgramConfElements)) && Objects.equal(reference, this.ePackage.getAttachVariableConfElement_ProgramVar()))) {
      final Model model_1 = EcoreUtil2.<Model>getContainerOfType(context, Model.class);
      final ArrayList<EObject> candidates_1 = new ArrayList<EObject>();
      this.getProgramInOutVar(candidates_1, model_1);
      return Scopes.scopeFor(candidates_1);
    }
    return super.getScope(context, reference);
  }
  
  public void getProgramInOutVar(final List<EObject> candidates, final Model model) {
    EList<Program> _programs = model.getPrograms();
    for (final Program program : _programs) {
      {
        EList<InputVarDeclaration> _progInVars = program.getProgInVars();
        for (final InputVarDeclaration inDecl : _progInVars) {
          EList<VarInitDeclaration> _vars = inDecl.getVars();
          for (final VarInitDeclaration varList : _vars) {
            candidates.addAll(varList.getVarList().getVars());
          }
        }
        EList<OutputVarDeclaration> _progOutVars = program.getProgOutVars();
        for (final OutputVarDeclaration outDecl : _progOutVars) {
          EList<VarInitDeclaration> _vars_1 = outDecl.getVars();
          for (final VarInitDeclaration varList_1 : _vars_1) {
            candidates.addAll(varList_1.getVarList().getVars());
          }
        }
      }
    }
  }
  
  public void getProcessInOutVar(final List<EObject> candidates, final Model model) {
    EList<Program> _programs = model.getPrograms();
    for (final Program program : _programs) {
      EList<su.nsk.iae.post.poST.Process> _processes = program.getProcesses();
      for (final su.nsk.iae.post.poST.Process process : _processes) {
        {
          EList<InputVarDeclaration> _procInVars = process.getProcInVars();
          for (final InputVarDeclaration inDecl : _procInVars) {
            EList<VarInitDeclaration> _vars = inDecl.getVars();
            for (final VarInitDeclaration varList : _vars) {
              candidates.addAll(varList.getVarList().getVars());
            }
          }
          EList<OutputVarDeclaration> _procOutVars = process.getProcOutVars();
          for (final OutputVarDeclaration outDecl : _procOutVars) {
            EList<VarInitDeclaration> _vars_1 = outDecl.getVars();
            for (final VarInitDeclaration varList_1 : _vars_1) {
              candidates.addAll(varList_1.getVarList().getVars());
            }
          }
        }
      }
    }
  }
}
