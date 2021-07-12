package su.nsk.iae.post;

import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;

import su.nsk.iae.post.linking.PoSTLinkingService;
import su.nsk.iae.post.naming.PoSTQualifiedNameProvider;

public class PoSTRuntimeModule extends AbstractPoSTRuntimeModule {
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return PoSTQualifiedNameProvider.class;
	}
	
	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return PoSTLinkingService.class;
	}
}
