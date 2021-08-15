package su.nsk.iae.post.linking

import com.google.inject.Inject
import java.util.Collections
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.linking.LinkingScopeProviderBinding
import org.eclipse.xtext.linking.impl.DefaultLinkingService
import org.eclipse.xtext.linking.impl.IllegalNodeException
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScopeProvider
import su.nsk.iae.post.poST.FunctionBlock
import su.nsk.iae.post.poST.PoSTPackage
import su.nsk.iae.post.poST.Process
import su.nsk.iae.post.poST.ProcessVariable
import su.nsk.iae.post.poST.Program
import su.nsk.iae.post.poST.ProgramConfiguration
import su.nsk.iae.post.poST.Resource
import su.nsk.iae.post.poST.TemplateProcessAttachVariableConfElement
import su.nsk.iae.post.poST.TemplateProcessConfElement

import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension su.nsk.iae.post.naming.PoSTQualifiedNameProvider.*

class PoSTLinkingService extends DefaultLinkingService {
	
	@Inject
	IQualifiedNameConverter qualifiedNameConverter
	
	@Inject
	@LinkingScopeProviderBinding
	IScopeProvider scopeProvider
	
	val ePackage = PoSTPackage.eINSTANCE
	
	override getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
		val requiredType = ref.getEReferenceType()
		if (requiredType === null) {
			return Collections.<EObject>emptyList()
		}
		val crossRefString = getCrossRefNodeAsString(context, ref, node)
		if (crossRefString === null || crossRefString.equals("")) {
			return Collections.<EObject>emptyList();
		}
		var scope = getScope(context, ref)
		//val qualifiedLinkName = qualifiedNameConverter.toQualifiedName(crossRefString)
		val qualifiedLinkName = QualifiedName.create(crossRefString)
		//var eObjectDescription = scope.getSingleElement(qualifiedLinkName)
		var eObjectDescription = getSingleElement(scope.allElements, qualifiedLinkName)
		if (eObjectDescription === null) {
			return Collections.emptyList()
		}
		val result = eObjectDescription.getEObjectOrProxy()
		return Collections.singletonList(result)
	}
	
	private def IEObjectDescription getSingleElement(Iterable<IEObjectDescription> elements, QualifiedName name) {
		val strName = name.segments.join(".")
		for (e : elements) {
			val strEle = e.qualifiedName.segments.join(".")
			if (strName == strEle) {
				return e
			}
		}
		return null
	}
	
	private def String getCrossRefNodeAsString(EObject context, EReference ref, INode node) throws IllegalNodeException {
		switch ref {
			case ePackage.primaryExpression_Variable,
			case ePackage.assignmentStatement_Variable,
			case ePackage.arrayVariable_Variable,
			case ePackage.forStatement_Variable:
				return context.getVarName(node)
			case ePackage.functionCall_Function:
				return context.getGlobalName(node)
			case ePackage.templateProcessConfElement_Process:
				return context.getTemplateProcessConfElement_Process(node)
			case ePackage.templateProcessAttachVariableConfElement_ProgramVar:
				return context.getTemplateProcessAttachVariableConfElement_ProgramVar(node)
			case ePackage.templateProcessAttachVariableConfElement_AttVar:
				return context.getTemplateProcessAttachVariableConfElement_AttVar(node)
			case ePackage.programConfiguration_Program:
				return context.getGlobalName(node)
			case ePackage.attachVariableConfElement_ProgramVar:
				return context.getAttachVariableConfElement_ProgramVar(node)
			case ePackage.attachVariableConfElement_AttVar:
				return context.getGlobalName(node)
			case ePackage.processVarInitDeclaration_Process:
				return context.getProcessVarInitDeclaration_Process(node)
			case ePackage.processStatements_Process,
			case ePackage.processStatusExpression_Process,
			case ePackage.setStateStatement_State:
				return context.getProcessStatements_Process(node)
			case ePackage.programConfiguration_Task:
				return context.getProgramConfiguration_Task(node)
		}
		super.getCrossRefNodeAsString(node)
	}
	
	private def String getVarName(EObject context, INode node) {
		val name = node.text
		val process = context.getContainerOfType(Process)
		val program = process.getContainerOfType(Program)
		val fb = process.getContainerOfType(FunctionBlock)
		if ((process !== null) && process.checkProcessVars(name)) {
			return (program !== null ? program.name : fb.name) + "." + process.name + "." + name
		}
		if ((program !== null) && program.checkProgramVars(name)) {
			return program.name + "." + name
		}
		if ((fb !== null) && fb.checkFBVars(name)) {
			return fb.name + "." + name
		}
		return name
	}
	
	private def String getTemplateProcessConfElement_Process(EObject context, INode node) {
		val program = context.getContainerOfType(ProgramConfiguration).program
		return program.name + "." + node.text
	}
	
	private def String getTemplateProcessAttachVariableConfElement_ProgramVar(EObject context, INode node) {
		val program = context.getContainerOfType(ProgramConfiguration).program
		val process = context.getContainerOfType(TemplateProcessConfElement).process
		return program.name + "." + process.name + "." + node.text
	}
	
	private def String getTemplateProcessAttachVariableConfElement_AttVar(EObject context, INode node) {
		val processConfAtt = context.getContainerOfType(TemplateProcessAttachVariableConfElement)
		if (processConfAtt.programVar instanceof ProcessVariable) {
			val res = context.getContainerOfType(Resource)
			val programConf = context.getContainerOfType(ProgramConfiguration)
			return res.name + "." + programConf.name + "." + node.text
		}
		return context.getGlobalName(node)
	}
	
	private def String getAttachVariableConfElement_ProgramVar(EObject context, INode node) {
		val program = context.getContainerOfType(ProgramConfiguration).program
		return program.name + "." + node.text
	}
	
	private def String getProcessVarInitDeclaration_Process(EObject context, INode node) {
		val program = context.getContainerOfType(Program)
		return program.name + "." + node.text
	}
	
	private def String getProcessStatements_Process(EObject context, INode node) {
		val process = context.getContainerOfType(Process)
		val program = process.getContainerOfType(Program)
		return program.name + "." + process.name + "." + node.text
	}
	
	private def String getProgramConfiguration_Task(EObject context, INode node) {
		val res = context.getContainerOfType(Resource)
		return res.name + "." + node.text
	}
	
	private def String getGlobalName(EObject context, INode node) {
		return node.text
	}
	
}