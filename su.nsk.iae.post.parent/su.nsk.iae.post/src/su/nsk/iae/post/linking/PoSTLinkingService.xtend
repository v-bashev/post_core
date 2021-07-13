package su.nsk.iae.post.linking

import com.google.inject.Inject
import java.util.Collections
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.linking.LinkingScopeProviderBinding
import org.eclipse.xtext.linking.impl.DefaultLinkingService
import org.eclipse.xtext.linking.impl.IllegalNodeException
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.scoping.IScopeProvider
import su.nsk.iae.post.poST.FunctionBlock
import su.nsk.iae.post.poST.Model
import su.nsk.iae.post.poST.PoSTPackage
import su.nsk.iae.post.poST.Process
import su.nsk.iae.post.poST.Program
import su.nsk.iae.post.poST.ProgramConfiguration
import su.nsk.iae.post.poST.StatementList
import su.nsk.iae.post.poST.TemplateProcessConfElement
import su.nsk.iae.post.scoping.PoSTScopeProvider

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
		var scope = (scopeProvider as PoSTScopeProvider).getPoSTScope(context, ref)
		if (scope === null) {
			scope = getScope(context, ref)
			if (scope === null) {
				throw new AssertionError(
					"Scope provider " + scopeProvider.getClass().getName() + " must not return null for context "
							+ context + ", reference " + ref + "! Consider to return IScope.NULLSCOPE instead.");
			}
		}
		val qualifiedLinkName = qualifiedNameConverter.toQualifiedName(crossRefString)
		var eObjectDescription = scope.getSingleElement(qualifiedLinkName)
		if (eObjectDescription === null) {
			return Collections.emptyList()
		}
		val result = eObjectDescription.getEObjectOrProxy()
		return Collections.singletonList(result)
	}
	
	private def String getCrossRefNodeAsString(EObject context, EReference ref, INode node) throws IllegalNodeException {
		val statementContext = context.getContainerOfType(StatementList)
		if (statementContext !== null) {
			val res = context.getStatementVarName(node)
			if (res !== null) {
				return res
			}
		}
		val processAttachContext = context.getContainerOfType(TemplateProcessConfElement)
		if (processAttachContext !== null) {
			val res = getProcessAttachVarName(processAttachContext, ref, node)
			if (res !== null) {
				return res
			}
		}
		val programAttachContext = context.getContainerOfType(ProgramConfiguration)
		if (programAttachContext !== null) {
			val res = getProgramAttachVarName(programAttachContext, ref, node)
			if (res !== null) {
				return res
			
			}
		}
		super.getCrossRefNodeAsString(node)
	}
	
	private def String getStatementVarName(EObject context, INode node) {
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
		return null
	}
	
	private def String getProgramAttachVarName(ProgramConfiguration context, EReference ref, INode node) {
		if (ref == ePackage.programConfiguration_Program) {
			return getGlobalName(context, ref, node)
		}
		if (ref == ePackage.attachVariableConfElement_ProgramVar) {
			return getProgramAttachVarName_ProgramVar(context, ref, node)
		}
		if (ref == ePackage.attachVariableConfElement_AttVar) {
			return getGlobalName(context, ref, node)
		}
		return null
	}
	
	private def String getProgramAttachVarName_ProgramVar(ProgramConfiguration context, EReference ref, INode node) {
		return context.program.name + "." + node.text
	}
	
	private def String getProcessAttachVarName(TemplateProcessConfElement context, EReference ref, INode node) {
		if (ref == ePackage.templateProcessConfElement_Process) {
			return getProcessAttachVarName_Process(context, ref, node)
		}
		if (ref == ePackage.attachVariableConfElement_ProgramVar) {
			return getProcessAttachVarName_ProgramVar(context, ref, node)
		}
		if (ref == ePackage.attachVariableConfElement_AttVar) {
			return getGlobalName(context, ref, node)
		}
		return null
	}
	
	private def String getProcessAttachVarName_Process(TemplateProcessConfElement context, EReference ref, INode node) {
		val name = node.text
		val program = context.getContainerOfType(ProgramConfiguration).program
		if ((program !== null) && program.checkProcesses(name)) {
			return program.name + "." + node.text
		}
		return null
	}
	
	private def String getProcessAttachVarName_ProgramVar(TemplateProcessConfElement context, EReference ref, INode node) {
		val process = context.process
		val program = process.getContainerOfType(Program)
		if (program !== null) {
			return program.name + "." + process.name + "." + node.text
		}
		return null
	}
	
	private def String getGlobalName(EObject context, EReference ref, INode node) {
		return node.text
	}
}