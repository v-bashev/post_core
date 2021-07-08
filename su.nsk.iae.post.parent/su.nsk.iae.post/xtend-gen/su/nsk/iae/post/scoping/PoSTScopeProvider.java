package su.nsk.iae.post.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import su.nsk.iae.post.poST.PoSTPackage;

/**
 * This class contains custom scoping description.
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
@SuppressWarnings("all")
public class PoSTScopeProvider extends AbstractPoSTScopeProvider {
  private final PoSTPackage ePackage = PoSTPackage.eINSTANCE;
  
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    return super.getScope(context, reference);
  }
}
