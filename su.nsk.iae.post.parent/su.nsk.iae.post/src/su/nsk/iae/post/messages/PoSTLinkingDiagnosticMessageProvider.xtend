package su.nsk.iae.post.messages

import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.diagnostics.DiagnosticMessage
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider

class PoSTLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {
	
	override getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		if (context.reference.EReferenceType.name.equals("SymbolicVariable")) {
			var name = context.linkText
			val msg = "Couldn't resolve reference to variable '" + name + "'.";
		return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
		}
		return super.getUnresolvedProxyMessage(context)
	}
	
}