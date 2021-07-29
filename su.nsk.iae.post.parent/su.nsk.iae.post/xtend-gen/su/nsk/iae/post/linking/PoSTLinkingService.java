package su.nsk.iae.post.linking;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.common.base.Objects;
import com.google.inject.Inject;

import su.nsk.iae.post.naming.PoSTQualifiedNameProvider;
import su.nsk.iae.post.poST.FunctionBlock;
import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.Program;
import su.nsk.iae.post.poST.ProgramConfiguration;
import su.nsk.iae.post.poST.StatementList;
import su.nsk.iae.post.poST.TemplateProcessConfElement;
import su.nsk.iae.post.scoping.PoSTScopeProvider;

@SuppressWarnings("all")
public class PoSTLinkingService extends DefaultLinkingService {
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Inject
  @LinkingScopeProviderBinding
  private IScopeProvider scopeProvider;
  
  private final PoSTPackage ePackage = PoSTPackage.eINSTANCE;
  
  @Override
  public List<EObject> getLinkedObjects(final EObject context, final EReference ref, final INode node) throws IllegalNodeException {
    final EClass requiredType = ref.getEReferenceType();
    if ((requiredType == null)) {
      return Collections.<EObject>emptyList();
    }
    final String crossRefString = this.getCrossRefNodeAsString(context, ref, node);
    if (((crossRefString == null) || crossRefString.equals(""))) {
      return Collections.<EObject>emptyList();
    }
    IScope scope = ((PoSTScopeProvider) this.scopeProvider).getPoSTScope(context, ref);
    if ((scope == null)) {
      scope = this.getScope(context, ref);
      if ((scope == null)) {
        String _name = this.scopeProvider.getClass().getName();
        String _plus = ("Scope provider " + _name);
        String _plus_1 = (_plus + " must not return null for context ");
        String _plus_2 = (_plus_1 + context);
        String _plus_3 = (_plus_2 + ", reference ");
        String _plus_4 = (_plus_3 + ref);
        String _plus_5 = (_plus_4 + "! Consider to return IScope.NULLSCOPE instead.");
        throw new AssertionError(_plus_5);
      }
    }
    final QualifiedName qualifiedLinkName = this.qualifiedNameConverter.toQualifiedName(crossRefString);
    IEObjectDescription eObjectDescription = scope.getSingleElement(qualifiedLinkName);
    if ((eObjectDescription == null)) {
      return Collections.<EObject>emptyList();
    }
    final EObject result = eObjectDescription.getEObjectOrProxy();
    return Collections.<EObject>singletonList(result);
  }
  
  private String getCrossRefNodeAsString(final EObject context, final EReference ref, final INode node) throws IllegalNodeException {
    String _xblockexpression = null;
    {
      final StatementList statementContext = EcoreUtil2.<StatementList>getContainerOfType(context, StatementList.class);
      if ((statementContext != null)) {
        final String res = this.getStatementVarName(context, node);
        if ((res != null)) {
          return res;
        }
      }
      final TemplateProcessConfElement processAttachContext = EcoreUtil2.<TemplateProcessConfElement>getContainerOfType(context, TemplateProcessConfElement.class);
      if ((processAttachContext != null)) {
        final String res_1 = this.getProcessAttachVarName(processAttachContext, ref, node);
        if ((res_1 != null)) {
          return res_1;
        }
      }
      final ProgramConfiguration programAttachContext = EcoreUtil2.<ProgramConfiguration>getContainerOfType(context, ProgramConfiguration.class);
      if ((programAttachContext != null)) {
        final String res_2 = this.getProgramAttachVarName(programAttachContext, ref, node);
        if ((res_2 != null)) {
          return res_2;
        }
      }
      _xblockexpression = super.getCrossRefNodeAsString(node);
    }
    return _xblockexpression;
  }
  
  private String getStatementVarName(final EObject context, final INode node) {
    final String name = node.getText();
    final su.nsk.iae.post.poST.Process process = EcoreUtil2.<su.nsk.iae.post.poST.Process>getContainerOfType(context, su.nsk.iae.post.poST.Process.class);
    final Program program = EcoreUtil2.<Program>getContainerOfType(process, Program.class);
    final FunctionBlock fb = EcoreUtil2.<FunctionBlock>getContainerOfType(process, FunctionBlock.class);
    if (((process != null) && PoSTQualifiedNameProvider.checkProcessVars(process, name))) {
      String _xifexpression = null;
      if ((program != null)) {
        _xifexpression = program.getName();
      } else {
        _xifexpression = fb.getName();
      }
      String _plus = (_xifexpression + ".");
      String _name = process.getName();
      String _plus_1 = (_plus + _name);
      String _plus_2 = (_plus_1 + ".");
      return (_plus_2 + name);
    }
    if (((program != null) && PoSTQualifiedNameProvider.checkProgramVars(program, name))) {
      String _name_1 = program.getName();
      String _plus_3 = (_name_1 + ".");
      return (_plus_3 + name);
    }
    if (((fb != null) && PoSTQualifiedNameProvider.checkFBVars(fb, name))) {
      String _name_2 = fb.getName();
      String _plus_4 = (_name_2 + ".");
      return (_plus_4 + name);
    }
    return null;
  }
  
  private String getProgramAttachVarName(final ProgramConfiguration context, final EReference ref, final INode node) {
    EReference _programConfiguration_Program = this.ePackage.getProgramConfiguration_Program();
    boolean _equals = Objects.equal(ref, _programConfiguration_Program);
    if (_equals) {
      return this.getGlobalName(context, ref, node);
    }
    EReference _attachVariableConfElement_ProgramVar = this.ePackage.getAttachVariableConfElement_ProgramVar();
    boolean _equals_1 = Objects.equal(ref, _attachVariableConfElement_ProgramVar);
    if (_equals_1) {
      return this.getProgramAttachVarName_ProgramVar(context, ref, node);
    }
    EReference _attachVariableConfElement_AttVar = this.ePackage.getAttachVariableConfElement_AttVar();
    boolean _equals_2 = Objects.equal(ref, _attachVariableConfElement_AttVar);
    if (_equals_2) {
      return this.getGlobalName(context, ref, node);
    }
    return null;
  }
  
  private String getProgramAttachVarName_ProgramVar(final ProgramConfiguration context, final EReference ref, final INode node) {
    String _name = context.getProgram().getName();
    String _plus = (_name + ".");
    String _text = node.getText();
    return (_plus + _text);
  }
  
  private String getProcessAttachVarName(final TemplateProcessConfElement context, final EReference ref, final INode node) {
    EReference _templateProcessConfElement_Process = this.ePackage.getTemplateProcessConfElement_Process();
    boolean _equals = Objects.equal(ref, _templateProcessConfElement_Process);
    if (_equals) {
      return this.getProcessAttachVarName_Process(context, ref, node);
    }
    EReference _attachVariableConfElement_ProgramVar = this.ePackage.getAttachVariableConfElement_ProgramVar();
    boolean _equals_1 = Objects.equal(ref, _attachVariableConfElement_ProgramVar);
    if (_equals_1) {
      return this.getProcessAttachVarName_ProgramVar(context, ref, node);
    }
    EReference _attachVariableConfElement_AttVar = this.ePackage.getAttachVariableConfElement_AttVar();
    boolean _equals_2 = Objects.equal(ref, _attachVariableConfElement_AttVar);
    if (_equals_2) {
      return this.getGlobalName(context, ref, node);
    }
    return null;
  }
  
  private String getProcessAttachVarName_Process(final TemplateProcessConfElement context, final EReference ref, final INode node) {
    final String name = node.getText();
    final Program program = EcoreUtil2.<ProgramConfiguration>getContainerOfType(context, ProgramConfiguration.class).getProgram();
    if (((program != null) && PoSTQualifiedNameProvider.checkProcesses(program, name))) {
      String _name = program.getName();
      String _plus = (_name + ".");
      String _text = node.getText();
      return (_plus + _text);
    }
    return null;
  }
  
  private String getProcessAttachVarName_ProgramVar(final TemplateProcessConfElement context, final EReference ref, final INode node) {
    final su.nsk.iae.post.poST.Process process = context.getProcess();
    final Program program = EcoreUtil2.<Program>getContainerOfType(process, Program.class);
    if ((program != null)) {
      String _name = program.getName();
      String _plus = (_name + ".");
      String _name_1 = process.getName();
      String _plus_1 = (_plus + _name_1);
      String _plus_2 = (_plus_1 + ".");
      String _text = node.getText();
      return (_plus_2 + _text);
    }
    return null;
  }
  
  private String getGlobalName(final EObject context, final EReference ref, final INode node) {
    return node.getText();
  }
}
