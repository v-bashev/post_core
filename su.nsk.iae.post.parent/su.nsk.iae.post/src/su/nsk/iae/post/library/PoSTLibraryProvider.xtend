package su.nsk.iae.post.library

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.ArrayList
import java.util.Collections
import java.util.List
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.ecore.EObject
import org.w3c.dom.Element
import su.nsk.iae.post.poST.Function
import su.nsk.iae.post.poST.FunctionBlock
import su.nsk.iae.post.poST.InputOutputVarDeclaration
import su.nsk.iae.post.poST.InputVarDeclaration
import su.nsk.iae.post.poST.OutputVarDeclaration
import su.nsk.iae.post.poST.PoSTFactory
import su.nsk.iae.post.poST.PoSTPackage
import su.nsk.iae.post.poST.VarInitDeclaration
import su.nsk.iae.post.poST.impl.FunctionBlockImpl
import su.nsk.iae.post.poST.impl.FunctionImpl
import su.nsk.iae.post.poST.impl.InputOutputVarDeclarationImpl
import su.nsk.iae.post.poST.impl.InputVarDeclarationImpl
import su.nsk.iae.post.poST.impl.OutputVarDeclarationImpl
import su.nsk.iae.post.poST.impl.VarListImpl

class PoSTLibraryProvider {
	
	static final String libDirName = "Tool Library"
	static final String pouTag = "pou"
	static final String pouNameAttribute = "name"
	static final String pouTypeAttribute = "pouType"
	static final String inVarTag = "inputVars"
	static final String outVarTag = "outputVars"
	static final String inOutVarTag = "inOutVars"
	static final String varTag = "variable"
	static final String varNameAttribute = "name"
	static final String varTypeTag = "type"
	static final String functionReturnTypeTag = "type"
	static final String functionAttributeValue = "function"
	static final String functionBlockAttributeValue = "functionBlock"
	
	IFolder libDir = null
	Path libDirPath = null
	long hash = 0

	PoSTFactory eFactory = PoSTFactory.eINSTANCE
	DocumentBuilder db = DocumentBuilderFactory.newInstance.newDocumentBuilder
	
	List<Function> functions = new ArrayList
	List<FunctionBlock> functionBlocks = new ArrayList
		
	def List<Function> getLibraryFunctions(EObject context) {
		context.parseLibrary
		return functions
	}
	
	def List<FunctionBlock> getLibraryFunctionBlocks(EObject context) {
		context.parseLibrary
		return functionBlocks
	}
	
	private def void parseLibrary(EObject context) {
		if (libDir === null) {
			context.initLibDirPath
		}
		if (libDir.exists && check—hanges) {
			parseLibrary
		}
	}
	
	private def void parseLibrary() {
		Files.walk(libDirPath).filter([file | Files.isRegularFile(file)]).forEach([file |
			file.parseFile
		])
	}
	
	private def void parseFile(Path file) {
		 val doc = db.parse(file.toString)
		 val pouList = doc.getElementsByTagName(pouTag)
		 for (var i = 0; i < pouList.length; i++) {
		 	val pou = pouList.item(i) as Element
		 	val name = pou.getAttribute(pouNameAttribute)
		 	val pouType = pou.getAttribute(pouTypeAttribute)
		 	
			val inVars = parseInVars(pou)
		 	val outVars = parseOutVars(pou)
		 	val inOutVars = parseInOutVars(pou)
		 	
		 	if (pouType == functionAttributeValue) {
		 		val retType = (pou.getElementsByTagName(functionReturnTypeTag).item(0) as Element).getElementsByTagName("*").item(0).nodeName
		 		val function = eFactory.createFunction()
		 		(function as FunctionImpl).eSet(PoSTPackage.FUNCTION__NAME, name)
		 		(function as FunctionImpl).eSet(PoSTPackage.FUNCTION__TYPE, retType)
		 		(function as FunctionImpl).eSet(PoSTPackage.FUNCTION__FUN_IN_VARS, Collections.singletonList(inVars))
		 		(function as FunctionImpl).eSet(PoSTPackage.FUNCTION__FUN_OUT_VARS, Collections.singletonList(outVars))
		 		(function as FunctionImpl).eSet(PoSTPackage.FUNCTION__FUN_IN_OUT_VARS, Collections.singletonList(inOutVars))
		 		functions.add(function)
		 	} else if (pouType == functionBlockAttributeValue) {
		 		val fb = eFactory.createFunctionBlock()
		 		(fb as FunctionBlockImpl).eSet(PoSTPackage.FUNCTION_BLOCK__NAME, name)
		 		(fb as FunctionBlockImpl).eSet(PoSTPackage.FUNCTION_BLOCK__FB_IN_VARS, Collections.singletonList(inVars))
		 		(fb as FunctionBlockImpl).eSet(PoSTPackage.FUNCTION_BLOCK__FB_OUT_VARS, Collections.singletonList(outVars))
		 		(fb as FunctionBlockImpl).eSet(PoSTPackage.FUNCTION_BLOCK__FB_IN_OUT_VARS, Collections.singletonList(inOutVars))
		 		functionBlocks.add(fb)
		 	}
		 }
	}
	
	private def InputVarDeclaration parseInVars(Element pou) {
		val res = eFactory.createInputVarDeclaration()
		(res as InputVarDeclarationImpl).eSet(PoSTPackage.INPUT_VAR_DECLARATION__VARS, parseVars(pou, inVarTag))
		return res
	}
	
	private def OutputVarDeclaration parseOutVars(Element pou) {
		val res = eFactory.createOutputVarDeclaration()
		(res as OutputVarDeclarationImpl).eSet(PoSTPackage.OUTPUT_VAR_DECLARATION__VARS, parseVars(pou, outVarTag))
		return res
	}
	
	private def InputOutputVarDeclaration parseInOutVars(Element pou) {
		val res = eFactory.createInputOutputVarDeclaration()
		(res as InputOutputVarDeclarationImpl).eSet(PoSTPackage.INPUT_OUTPUT_VAR_DECLARATION__VARS, parseVars(pou, inOutVarTag))
		return res
	}
	
	private def List<VarInitDeclaration> parseVars(Element pou, String tag) {
		val List<VarInitDeclaration> res = new ArrayList
		val varsTagNode = pou.getElementsByTagName(tag)
		if (varsTagNode.length == 0) {
			return res
		}
		val varsTag = varsTagNode.item(0) as Element
		val varTags = varsTag.getElementsByTagName(varTag)
		for (var i = 0; i < varTags.length; i++) {
			val varTag = varTags.item(i) as Element
			val varName = varTag.getAttribute(varNameAttribute)
			val varType = (varTag.getElementsByTagName(varTypeTag).item(0) as Element).getElementsByTagName("*").item(0).nodeName
			res.add(constructVarInitDeclaration(varName, varType))
		}
		return res
	}
	
	private def constructVarInitDeclaration(String name, String type) {
		val symbolicVariable = eFactory.createSymbolicVariable()
		symbolicVariable.name = name
		val varList = eFactory.createVarList()
		(varList as VarListImpl).eSet(PoSTPackage.VAR_LIST__VARS, Collections.singletonList(symbolicVariable))
		val simpleSpecificationInit = eFactory.createSimpleSpecificationInit()
		simpleSpecificationInit.type = type
		val varInitDeclaration = eFactory.createVarInitDeclaration()
		varInitDeclaration.varList = varList
		varInitDeclaration.spec = simpleSpecificationInit
		return varInitDeclaration
	}
	
	private def initLibDirPath(EObject context) {
		val project = ResourcesPlugin.workspace.root.getProject(context.eResource.URI.segment(1))
		libDir = project.getFolder(libDirName)
		libDirPath = Paths.get(libDir.locationURI)
	}
	
	private def boolean check—hanges() {
		val newHash = Files.walk(libDirPath).filter([file | Files.isRegularFile(file)]).count
		if (hash != newHash) {
			hash = newHash
			return true
		}
		return false
	}
	
}
