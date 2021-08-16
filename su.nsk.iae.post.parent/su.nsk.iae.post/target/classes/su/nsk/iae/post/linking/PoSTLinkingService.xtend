package su.nsk.iae.post.linking

import java.util.Collections
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.linking.impl.DefaultLinkingService
import org.eclipse.xtext.linking.impl.IllegalNodeException
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.IEObjectDescription

class PoSTLinkingService extends DefaultLinkingService {
	
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
		val qualifiedLinkName = QualifiedName.create(crossRefString)
		var eObjectDescription = getSingleElement(scope.allElements, qualifiedLinkName)
		if (eObjectDescription === null) {
			return Collections.emptyList()
		}
		val result = eObjectDescription.getEObjectOrProxy()
		return Collections.singletonList(result)
	}
	
	private def IEObjectDescription getSingleElement(Iterable<IEObjectDescription> elements, QualifiedName name) {
		for (e : elements) {
			if (e.qualifiedName.segments.last == name.segments.head) {
				return e
			}
		}
		return null
	}
	
	private def String getCrossRefNodeAsString(EObject context, EReference ref, INode node) throws IllegalNodeException {
		return node.text
	}
	
}