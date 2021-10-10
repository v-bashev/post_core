package su.nsk.iae.post;

import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

import su.nsk.iae.post.linking.PoSTLinkingService;
import su.nsk.iae.post.messages.PoSTLinkingDiagnosticMessageProvider;
import su.nsk.iae.post.naming.PoSTQualifiedNameProvider;

public class PoSTRuntimeModule extends AbstractPoSTRuntimeModule {
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bindConstant().annotatedWith(Names.named(org.eclipse.xtext.validation.CompositeEValidator.USE_EOBJECT_VALIDATOR)).to(false);
	}
	
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return PoSTQualifiedNameProvider.class;
	}
	
	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return PoSTLinkingService.class;
	}
	
	public Class<? extends ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
	    return PoSTLinkingDiagnosticMessageProvider.class;
	}
}
