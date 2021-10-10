package su.nsk.iae.post.messages;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;

@SuppressWarnings("all")
public class PoSTLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {
  @Override
  public DiagnosticMessage getUnresolvedProxyMessage(final ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context) {
    boolean _equals = context.getReference().getEReferenceType().getName().equals("SymbolicVariable");
    if (_equals) {
      String name = context.getLinkText();
      final String msg = (("Couldn\'t resolve reference to Variable \'" + name) + "\'.");
      return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
    }
    if ((context.getReference().getEReferenceType().getName().equals("ProcessVariable") || 
      context.getReference().getEReferenceType().getName().equals("ProcessStatementElement"))) {
      String name_1 = context.getLinkText();
      final String msg_1 = (("Couldn\'t resolve reference to Process Variable \'" + name_1) + "\'.");
      return new DiagnosticMessage(msg_1, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
    }
    return super.getUnresolvedProxyMessage(context);
  }
}
