package su.nsk.iae.post.linking;

import com.google.common.base.Objects;
import com.google.inject.Inject;
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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import su.nsk.iae.post.naming.PoSTQualifiedNameProvider;
import su.nsk.iae.post.poST.FunctionBlock;
import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.ProcessVariable;
import su.nsk.iae.post.poST.Program;
import su.nsk.iae.post.poST.ProgramConfiguration;
import su.nsk.iae.post.poST.Resource;
import su.nsk.iae.post.poST.TemplateProcessAttachVariableConfElement;
import su.nsk.iae.post.poST.TemplateProcessConfElement;
import su.nsk.iae.post.poST.Variable;

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
    IScope scope = this.getScope(context, ref);
    final QualifiedName qualifiedLinkName = QualifiedName.create(crossRefString);
    IEObjectDescription eObjectDescription = this.getSingleElement(scope.getAllElements(), qualifiedLinkName);
    if ((eObjectDescription == null)) {
      return Collections.<EObject>emptyList();
    }
    final EObject result = eObjectDescription.getEObjectOrProxy();
    return Collections.<EObject>singletonList(result);
  }
  
  private IEObjectDescription getSingleElement(final Iterable<IEObjectDescription> elements, final QualifiedName name) {
    final String strName = IterableExtensions.join(name.getSegments(), ".");
    for (final IEObjectDescription e : elements) {
      {
        final String strEle = IterableExtensions.join(e.getQualifiedName().getSegments(), ".");
        boolean _equals = Objects.equal(strName, strEle);
        if (_equals) {
          return e;
        }
      }
    }
    return null;
  }
  
  private String getCrossRefNodeAsString(final EObject context, final EReference ref, final INode node) throws IllegalNodeException {
    String _xblockexpression = null;
    {
      boolean _matched = false;
      EReference _primaryExpression_Variable = this.ePackage.getPrimaryExpression_Variable();
      if (Objects.equal(ref, _primaryExpression_Variable)) {
        _matched=true;
      }
      if (!_matched) {
        EReference _assignmentStatement_Variable = this.ePackage.getAssignmentStatement_Variable();
        if (Objects.equal(ref, _assignmentStatement_Variable)) {
          _matched=true;
        }
      }
      if (!_matched) {
        EReference _arrayVariable_Variable = this.ePackage.getArrayVariable_Variable();
        if (Objects.equal(ref, _arrayVariable_Variable)) {
          _matched=true;
        }
      }
      if (!_matched) {
        EReference _forStatement_Variable = this.ePackage.getForStatement_Variable();
        if (Objects.equal(ref, _forStatement_Variable)) {
          _matched=true;
        }
      }
      if (_matched) {
        return this.getVarName(context, node);
      }
      if (!_matched) {
        EReference _functionCall_Function = this.ePackage.getFunctionCall_Function();
        if (Objects.equal(ref, _functionCall_Function)) {
          _matched=true;
          return this.getGlobalName(context, node);
        }
      }
      if (!_matched) {
        EReference _templateProcessConfElement_Process = this.ePackage.getTemplateProcessConfElement_Process();
        if (Objects.equal(ref, _templateProcessConfElement_Process)) {
          _matched=true;
          return this.getTemplateProcessConfElement_Process(context, node);
        }
      }
      if (!_matched) {
        EReference _templateProcessAttachVariableConfElement_ProgramVar = this.ePackage.getTemplateProcessAttachVariableConfElement_ProgramVar();
        if (Objects.equal(ref, _templateProcessAttachVariableConfElement_ProgramVar)) {
          _matched=true;
          return this.getTemplateProcessAttachVariableConfElement_ProgramVar(context, node);
        }
      }
      if (!_matched) {
        EReference _templateProcessAttachVariableConfElement_AttVar = this.ePackage.getTemplateProcessAttachVariableConfElement_AttVar();
        if (Objects.equal(ref, _templateProcessAttachVariableConfElement_AttVar)) {
          _matched=true;
          return this.getTemplateProcessAttachVariableConfElement_AttVar(context, node);
        }
      }
      if (!_matched) {
        EReference _programConfiguration_Program = this.ePackage.getProgramConfiguration_Program();
        if (Objects.equal(ref, _programConfiguration_Program)) {
          _matched=true;
          return this.getGlobalName(context, node);
        }
      }
      if (!_matched) {
        EReference _attachVariableConfElement_ProgramVar = this.ePackage.getAttachVariableConfElement_ProgramVar();
        if (Objects.equal(ref, _attachVariableConfElement_ProgramVar)) {
          _matched=true;
          return this.getAttachVariableConfElement_ProgramVar(context, node);
        }
      }
      if (!_matched) {
        EReference _attachVariableConfElement_AttVar = this.ePackage.getAttachVariableConfElement_AttVar();
        if (Objects.equal(ref, _attachVariableConfElement_AttVar)) {
          _matched=true;
          return this.getGlobalName(context, node);
        }
      }
      if (!_matched) {
        EReference _processVarInitDeclaration_Process = this.ePackage.getProcessVarInitDeclaration_Process();
        if (Objects.equal(ref, _processVarInitDeclaration_Process)) {
          _matched=true;
          return this.getProcessVarInitDeclaration_Process(context, node);
        }
      }
      if (!_matched) {
        EReference _processStatements_Process = this.ePackage.getProcessStatements_Process();
        if (Objects.equal(ref, _processStatements_Process)) {
          _matched=true;
        }
        if (!_matched) {
          EReference _processStatusExpression_Process = this.ePackage.getProcessStatusExpression_Process();
          if (Objects.equal(ref, _processStatusExpression_Process)) {
            _matched=true;
          }
        }
        if (!_matched) {
          EReference _setStateStatement_State = this.ePackage.getSetStateStatement_State();
          if (Objects.equal(ref, _setStateStatement_State)) {
            _matched=true;
          }
        }
        if (_matched) {
          return this.getProcessStatements_Process(context, node);
        }
      }
      if (!_matched) {
        EReference _programConfiguration_Task = this.ePackage.getProgramConfiguration_Task();
        if (Objects.equal(ref, _programConfiguration_Task)) {
          _matched=true;
          return this.getProgramConfiguration_Task(context, node);
        }
      }
      _xblockexpression = super.getCrossRefNodeAsString(node);
    }
    return _xblockexpression;
  }
  
  private String getVarName(final EObject context, final INode node) {
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
    return name;
  }
  
  private String getTemplateProcessConfElement_Process(final EObject context, final INode node) {
    final Program program = EcoreUtil2.<ProgramConfiguration>getContainerOfType(context, ProgramConfiguration.class).getProgram();
    String _name = program.getName();
    String _plus = (_name + ".");
    String _text = node.getText();
    return (_plus + _text);
  }
  
  private String getTemplateProcessAttachVariableConfElement_ProgramVar(final EObject context, final INode node) {
    final Program program = EcoreUtil2.<ProgramConfiguration>getContainerOfType(context, ProgramConfiguration.class).getProgram();
    final su.nsk.iae.post.poST.Process process = EcoreUtil2.<TemplateProcessConfElement>getContainerOfType(context, TemplateProcessConfElement.class).getProcess();
    String _name = program.getName();
    String _plus = (_name + ".");
    String _name_1 = process.getName();
    String _plus_1 = (_plus + _name_1);
    String _plus_2 = (_plus_1 + ".");
    String _text = node.getText();
    return (_plus_2 + _text);
  }
  
  private String getTemplateProcessAttachVariableConfElement_AttVar(final EObject context, final INode node) {
    final TemplateProcessAttachVariableConfElement processConfAtt = EcoreUtil2.<TemplateProcessAttachVariableConfElement>getContainerOfType(context, TemplateProcessAttachVariableConfElement.class);
    Variable _programVar = processConfAtt.getProgramVar();
    if ((_programVar instanceof ProcessVariable)) {
      final Resource res = EcoreUtil2.<Resource>getContainerOfType(context, Resource.class);
      final ProgramConfiguration programConf = EcoreUtil2.<ProgramConfiguration>getContainerOfType(context, ProgramConfiguration.class);
      String _name = res.getName();
      String _plus = (_name + ".");
      String _name_1 = programConf.getName();
      String _plus_1 = (_plus + _name_1);
      String _plus_2 = (_plus_1 + ".");
      String _text = node.getText();
      return (_plus_2 + _text);
    }
    return this.getGlobalName(context, node);
  }
  
  private String getAttachVariableConfElement_ProgramVar(final EObject context, final INode node) {
    final Program program = EcoreUtil2.<ProgramConfiguration>getContainerOfType(context, ProgramConfiguration.class).getProgram();
    String _name = program.getName();
    String _plus = (_name + ".");
    String _text = node.getText();
    return (_plus + _text);
  }
  
  private String getProcessVarInitDeclaration_Process(final EObject context, final INode node) {
    final Program program = EcoreUtil2.<Program>getContainerOfType(context, Program.class);
    String _name = program.getName();
    String _plus = (_name + ".");
    String _text = node.getText();
    return (_plus + _text);
  }
  
  private String getProcessStatements_Process(final EObject context, final INode node) {
    final su.nsk.iae.post.poST.Process process = EcoreUtil2.<su.nsk.iae.post.poST.Process>getContainerOfType(context, su.nsk.iae.post.poST.Process.class);
    final Program program = EcoreUtil2.<Program>getContainerOfType(process, Program.class);
    String _name = program.getName();
    String _plus = (_name + ".");
    String _name_1 = process.getName();
    String _plus_1 = (_plus + _name_1);
    String _plus_2 = (_plus_1 + ".");
    String _text = node.getText();
    return (_plus_2 + _text);
  }
  
  private String getProgramConfiguration_Task(final EObject context, final INode node) {
    final Resource res = EcoreUtil2.<Resource>getContainerOfType(context, Resource.class);
    String _name = res.getName();
    String _plus = (_name + ".");
    String _text = node.getText();
    return (_plus + _text);
  }
  
  private String getGlobalName(final EObject context, final INode node) {
    return node.getText();
  }
}
