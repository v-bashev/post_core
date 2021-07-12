package su.nsk.iae.post.scoping

import com.google.common.base.Function
import java.util.stream.Collectors
import java.util.stream.Stream
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import su.nsk.iae.post.naming.PoSTQualifiedNameProvider
import su.nsk.iae.post.poST.Model
import su.nsk.iae.post.poST.PoSTPackage
import su.nsk.iae.post.poST.SymbolicVariable
import su.nsk.iae.post.poST.TemplateProcessConfElement

import static extension org.eclipse.xtext.EcoreUtil2.*

class PoSTScopeProvider extends AbstractPoSTScopeProvider {
	
	val ePackage = PoSTPackage.eINSTANCE

	override getScope(EObject context, EReference reference) {
		if ((reference == ePackage.attachVariableConfElement_ProgramVar)) {
			val model = context.getContainerOfType(Model)
			if (context.getContainerOfType(TemplateProcessConfElement) !== null) {
				return Scopes.scopeFor(model.processInOutVar, new PoSTScope, IScope.NULLSCOPE)
			}
			return Scopes.scopeFor(model.programInOutVar, new PoSTScope, IScope.NULLSCOPE)
		}
		return super.getScope(context, reference)
	}

	private def getProgramInOutVar(Model model) {
		return Stream.concat(
			model.programs.stream.map([x | x.progInVars]).flatMap([x | x.stream]).map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			Stream.concat(
				model.programs.stream.map([x | x.progOutVars]).flatMap([x | x.stream]).map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
				Stream.concat(
					model.fbs.stream.map([x | x.fbInVars]).flatMap([x | x.stream]).map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
					model.fbs.stream.map([x | x.fbOutVars]).flatMap([x | x.stream]).map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
				)
			)
			
		).flatMap([x | x.stream]).collect(Collectors.toList)
	}

	private def getProcessInOutVar(Model model) {
		return Stream.concat(
			model.programs.stream.map([x | x.processes]).flatMap([x | x.stream])
			.map([x | x.procInVars]).flatMap([x | x.stream]).map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
			Stream.concat(
				model.programs.stream.map([x | x.processes]).flatMap([x | x.stream])
				.map([x | x.procOutVars]).flatMap([x | x.stream]).map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
				Stream.concat(
					model.fbs.stream.map([x | x.processes]).flatMap([x | x.stream])
					.map([x | x.procInVars]).flatMap([x | x.stream]).map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars]),
					model.fbs.stream.map([x | x.processes]).flatMap([x | x.stream])
					.map([x | x.procOutVars]).flatMap([x | x.stream]).map([x | x.vars]).flatMap([x | x.stream]).map([x | x.varList.vars])
				)
			)
			
		).flatMap([x | x.stream]).collect(Collectors.toList)
	}
	
	static class PoSTScope implements Function<SymbolicVariable, QualifiedName> {
		static val qualifiedNameProvider = new PoSTQualifiedNameProvider;
		override apply(SymbolicVariable ele) {
			return qualifiedNameProvider.qualifiedPoSTName(ele)
		}
	}
}
