package su.nsk.iae.post.library;

import com.google.common.base.Objects;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import su.nsk.iae.post.poST.Function;
import su.nsk.iae.post.poST.FunctionBlock;
import su.nsk.iae.post.poST.InputOutputVarDeclaration;
import su.nsk.iae.post.poST.InputVarDeclaration;
import su.nsk.iae.post.poST.OutputVarDeclaration;
import su.nsk.iae.post.poST.PoSTFactory;
import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.SimpleSpecificationInit;
import su.nsk.iae.post.poST.SymbolicVariable;
import su.nsk.iae.post.poST.VarInitDeclaration;
import su.nsk.iae.post.poST.VarList;
import su.nsk.iae.post.poST.impl.FunctionBlockImpl;
import su.nsk.iae.post.poST.impl.FunctionImpl;
import su.nsk.iae.post.poST.impl.InputOutputVarDeclarationImpl;
import su.nsk.iae.post.poST.impl.InputVarDeclarationImpl;
import su.nsk.iae.post.poST.impl.OutputVarDeclarationImpl;
import su.nsk.iae.post.poST.impl.VarListImpl;

@SuppressWarnings("all")
public class PoSTLibraryProvider {
  private static final String libDirName = "Tool Library";
  
  private static final String pouTag = "pou";
  
  private static final String pouNameAttribute = "name";
  
  private static final String pouTypeAttribute = "pouType";
  
  private static final String inVarTag = "inputVars";
  
  private static final String outVarTag = "outputVars";
  
  private static final String inOutVarTag = "inOutVars";
  
  private static final String varTag = "variable";
  
  private static final String varNameAttribute = "name";
  
  private static final String varTypeTag = "type";
  
  private static final String functionAttributeValue = "function";
  
  private static final String functionBlockAttributeValue = "functionBlock";
  
  private IFolder libDir = null;
  
  private Path libDirPath = null;
  
  private long hash = 0;
  
  private PoSTFactory eFactory = PoSTFactory.eINSTANCE;
  
  private DocumentBuilder db = new Function0<DocumentBuilder>() {
    @Override
    public DocumentBuilder apply() {
      try {
        DocumentBuilder _newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return _newDocumentBuilder;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }.apply();
  
  private List<Function> functions = new ArrayList<Function>();
  
  private List<FunctionBlock> functionBlocks = new ArrayList<FunctionBlock>();
  
  public List<Function> getLibraryFunctions(final EObject context) {
    this.parseLibrary(context);
    return this.functions;
  }
  
  public List<FunctionBlock> getLibraryFunctionBlocks(final EObject context) {
    this.parseLibrary(context);
    return this.functionBlocks;
  }
  
  private void parseLibrary(final EObject context) {
    if ((this.libDir == null)) {
      this.initLibDirPath(context);
    }
    if ((this.libDir.exists() && this.check—hanges())) {
      this.parseLibrary();
    }
  }
  
  private void parseLibrary() {
    try {
      final Predicate<Path> _function = (Path file) -> {
        return Files.isRegularFile(file);
      };
      final Consumer<Path> _function_1 = (Path file) -> {
        this.parseFile(file);
      };
      Files.walk(this.libDirPath).filter(_function).forEach(_function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void parseFile(final Path file) {
    try {
      final Document doc = this.db.parse(file.toString());
      final NodeList pouList = doc.getElementsByTagName(PoSTLibraryProvider.pouTag);
      for (int i = 0; (i < pouList.getLength()); i++) {
        {
          Node _item = pouList.item(i);
          final Element pou = ((Element) _item);
          final String name = pou.getAttribute(PoSTLibraryProvider.pouNameAttribute);
          final String pouType = pou.getAttribute(PoSTLibraryProvider.pouTypeAttribute);
          final InputVarDeclaration inVars = this.parseInVars(pou);
          final OutputVarDeclaration outVars = this.parseOutVars(pou);
          final InputOutputVarDeclaration inOutVars = this.parseInOutVars(pou);
          boolean _equals = Objects.equal(pouType, PoSTLibraryProvider.functionAttributeValue);
          if (_equals) {
            final Function function = this.eFactory.createFunction();
            ((FunctionImpl) function).eSet(PoSTPackage.FUNCTION__NAME, name);
            ((FunctionImpl) function).eSet(PoSTPackage.FUNCTION__FUN_IN_VARS, Collections.<InputVarDeclaration>singletonList(inVars));
            ((FunctionImpl) function).eSet(PoSTPackage.FUNCTION__FUN_OUT_VARS, Collections.<OutputVarDeclaration>singletonList(outVars));
            ((FunctionImpl) function).eSet(PoSTPackage.FUNCTION__FUN_IN_OUT_VARS, Collections.<InputOutputVarDeclaration>singletonList(inOutVars));
            this.functions.add(function);
          } else {
            boolean _equals_1 = Objects.equal(pouType, PoSTLibraryProvider.functionBlockAttributeValue);
            if (_equals_1) {
              final FunctionBlock fb = this.eFactory.createFunctionBlock();
              ((FunctionBlockImpl) fb).eSet(PoSTPackage.FUNCTION_BLOCK__NAME, name);
              ((FunctionBlockImpl) fb).eSet(PoSTPackage.FUNCTION_BLOCK__FB_IN_VARS, Collections.<InputVarDeclaration>singletonList(inVars));
              ((FunctionBlockImpl) fb).eSet(PoSTPackage.FUNCTION_BLOCK__FB_OUT_VARS, Collections.<OutputVarDeclaration>singletonList(outVars));
              ((FunctionBlockImpl) fb).eSet(PoSTPackage.FUNCTION_BLOCK__FB_IN_OUT_VARS, Collections.<InputOutputVarDeclaration>singletonList(inOutVars));
              this.functionBlocks.add(fb);
            }
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private InputVarDeclaration parseInVars(final Element pou) {
    final InputVarDeclaration res = this.eFactory.createInputVarDeclaration();
    ((InputVarDeclarationImpl) res).eSet(PoSTPackage.INPUT_VAR_DECLARATION__VARS, this.parseVars(pou, PoSTLibraryProvider.inVarTag));
    return res;
  }
  
  private OutputVarDeclaration parseOutVars(final Element pou) {
    final OutputVarDeclaration res = this.eFactory.createOutputVarDeclaration();
    ((OutputVarDeclarationImpl) res).eSet(PoSTPackage.OUTPUT_VAR_DECLARATION__VARS, this.parseVars(pou, PoSTLibraryProvider.outVarTag));
    return res;
  }
  
  private InputOutputVarDeclaration parseInOutVars(final Element pou) {
    final InputOutputVarDeclaration res = this.eFactory.createInputOutputVarDeclaration();
    ((InputOutputVarDeclarationImpl) res).eSet(PoSTPackage.INPUT_OUTPUT_VAR_DECLARATION__VARS, this.parseVars(pou, PoSTLibraryProvider.inOutVarTag));
    return res;
  }
  
  private List<VarInitDeclaration> parseVars(final Element pou, final String tag) {
    final List<VarInitDeclaration> res = new ArrayList<VarInitDeclaration>();
    final NodeList varsTagNode = pou.getElementsByTagName(tag);
    int _length = varsTagNode.getLength();
    boolean _equals = (_length == 0);
    if (_equals) {
      return res;
    }
    Node _item = varsTagNode.item(0);
    final Element varsTag = ((Element) _item);
    final NodeList varTags = varsTag.getElementsByTagName(PoSTLibraryProvider.varTag);
    for (int i = 0; (i < varTags.getLength()); i++) {
      {
        Node _item_1 = varTags.item(i);
        final Element varTag = ((Element) _item_1);
        final String varName = varTag.getAttribute(PoSTLibraryProvider.varNameAttribute);
        Node _item_2 = varTag.getElementsByTagName(PoSTLibraryProvider.varTypeTag).item(0);
        final String varType = ((Element) _item_2).getElementsByTagName("*").item(0).getNodeName();
        res.add(this.constructVarInitDeclaration(varName, varType));
      }
    }
    return res;
  }
  
  private VarInitDeclaration constructVarInitDeclaration(final String name, final String type) {
    final SymbolicVariable symbolicVariable = this.eFactory.createSymbolicVariable();
    symbolicVariable.setName(name);
    final VarList varList = this.eFactory.createVarList();
    ((VarListImpl) varList).eSet(PoSTPackage.VAR_LIST__VARS, Collections.<SymbolicVariable>singletonList(symbolicVariable));
    final SimpleSpecificationInit simpleSpecificationInit = this.eFactory.createSimpleSpecificationInit();
    simpleSpecificationInit.setType(type);
    final VarInitDeclaration varInitDeclaration = this.eFactory.createVarInitDeclaration();
    varInitDeclaration.setVarList(varList);
    varInitDeclaration.setSpec(simpleSpecificationInit);
    return varInitDeclaration;
  }
  
  private Path initLibDirPath(final EObject context) {
    Path _xblockexpression = null;
    {
      final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(context.eResource().getURI().segment(1));
      this.libDir = project.getFolder(PoSTLibraryProvider.libDirName);
      _xblockexpression = this.libDirPath = Paths.get(this.libDir.getLocationURI());
    }
    return _xblockexpression;
  }
  
  private boolean check—hanges() {
    try {
      final Predicate<Path> _function = (Path file) -> {
        return Files.isRegularFile(file);
      };
      final long newHash = Files.walk(this.libDirPath).filter(_function).count();
      if ((this.hash != newHash)) {
        this.hash = newHash;
        return true;
      }
      return false;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
