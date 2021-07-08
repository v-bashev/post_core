package su.nsk.iae.post.scoping

import su.nsk.iae.post.poST.PoSTPackage
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference

/** 
 * This class contains custom scoping description.
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class PoSTScopeProvider extends AbstractPoSTScopeProvider {
	val ePackage = PoSTPackage.eINSTANCE
	
	override getScope(EObject context, EReference reference) {
		super.getScope(context, reference)
	}
	
}
