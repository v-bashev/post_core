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
		if (context.checkStatementVarName) {
			val res = context.getStatementVarName(node)
			if (res !== null) {
				return res
			}
		}
		if (context.checkProcessAttachVarName(ref)) {
			val res = getProcessAttachVarName(context, ref, node)
			if (res !== null) {
				return res
			}
		}
		if (context.checkProgramAttachVarName(ref)) {
			val res = getProgramAttachVarName(context, ref, node)
			if (res !== null) {
				return res
			
			}
		}
		super.getCrossRefNodeAsString(node)
	}
	
	private def boolean checkStatementVarName(EObject context) {
		return context.getContainerOfType(StatementList) !== null
	}
	
	private def boolean checkProcessAttachVarName(EObject context, EReference ref) {
		return context.getContainerOfType(TemplateProcessConfElement) !== null
	}
	
	private def boolean checkProgramAttachVarName(EObject context, EReference ref) {
		return context.getContainerOfType(ProgramConfiguration) !== null
	}
	
	private def String getStatementVarName(EObject ele, INode node) {
		val name = node.text
		val process = ele.getContainerOfType(Process)
		val program = process.getContainerOfType(Program)
		val fb = process.getContainerOfType(FunctionBlock)
		if ((process !== null) && process.checkProcessVars(name)) {
			return (program !== null ? program.name : fb.name) + "." + process.name + "." + name
		}
		if ((program !== null) && program.checkProgramVars(name)) {
			return program.name + "." + name
		}
		if ((fb !== null) && fb.checFBVars(name)) {
			return fb.name + "." + name
		}
		return null
	}
	
	private def String getProcessAttachVarName(EObject context, EReference ref, INode node) {
		if (ref == ePackage.attachVariableConfElement_ProgramVar) {
			return getProcessAttachVarName_ProgramVar(context, ref, node)
		}
		if (ref == ePackage.attachVariableConfElement_AttVar) {
			return getGlobalName(context, ref, node)
		}
		if (ref == ePackage.templateProcessConfElement_Process) {
			return getProcessAttachVarName_Process(context, ref, node)
		}
		return null
	}
	
	private def String getProcessAttachVarName_ProgramVar(EObject context, EReference ref, INode node) {
		val name = node.text
		val model = context.getContainerOfType(Model)
		for (program : model.programs) {
			for (process : program.processes) {
				if (process.checkProcessInOutVars(name)) {
					return program.name + "." + process.name + "." + name
				}
			}
		}
		for (fb : model.fbs) {
			for (process : fb.processes) {
				if (process.checkProcessInOutVars(name)) {
					return fb.name + "." + process.name + "." + name
				}
			}
		}
		return null
	}
	
	private def String getProcessAttachVarName_Process(EObject context, EReference ref, INode node) {
		val name = node.text
		val model = context.getContainerOfType(Model)
		for (program : model.programs) {
			if (program.checkProcesses(name)) {
				return program.name + "." + name
			}
		}
		for (fb : model.fbs) {
			if (fb.checkProcesses(name)) {
				return fb.name + "." + name
			}
		}
		return null
	}
	
	private def String getProgramAttachVarName(EObject context, EReference ref, INode node) {
		if (ref == ePackage.attachVariableConfElement_ProgramVar) {
			return getProgramAttachVarName_ProgramVar(context, ref, node)
		}
		if (ref == ePackage.attachVariableConfElement_AttVar) {
			return getGlobalName(context, ref, node)
		}
		if (ref == ePackage.programConfiguration_Program) {
			return getGlobalName(context, ref, node)
		}
		return null
	}
	
	private def String getProgramAttachVarName_ProgramVar(EObject context, EReference ref, INode node) {
		val name = node.text
		if (ref == ePackage.attachVariableConfElement_AttVar) {
			return node.text
		}
		val model = context.getContainerOfType(Model)
		for (program : model.programs) {
			if (program.checkProgramInOutVars(name)) {
				return program.name + "." + name
			}
		}
		for (fb : model.fbs) {
			if (fb.checkFBInOutVars(name)) {
				return fb.name + "." + name
			}
		}
		return null
	}
	
	private def String getGlobalName(EObject context, EReference ref, INode node) {
		return node.text
	}
}