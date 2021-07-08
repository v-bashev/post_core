package su.nsk.iae.post.scoping

import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.Scopes
import su.nsk.iae.post.poST.Model
import su.nsk.iae.post.poST.PoSTPackage
import su.nsk.iae.post.poST.ProgramConfiguration
import su.nsk.iae.post.poST.TemplateProcessConfElement

import static extension org.eclipse.xtext.EcoreUtil2.*
import su.nsk.iae.post.poST.ProcessTemplateElements
import su.nsk.iae.post.poST.ProgramConfElements

class PoSTScopeProvider extends AbstractPoSTScopeProvider {
	val ePackage = PoSTPackage.eINSTANCE

	override getScope(EObject context, EReference reference) {
		if (((context instanceof TemplateProcessConfElement) || (context instanceof ProcessTemplateElements)) 
			&& (reference == ePackage.attachVariableConfElement_ProgramVar)) {
			val model = context.getContainerOfType(Model)
			val candidates = new ArrayList<EObject>
			candidates.getProcessInOutVar(model)
			return Scopes.scopeFor(candidates)
		}
		if (((context instanceof ProgramConfiguration) || (context instanceof ProgramConfElements)) 
			&& (reference == ePackage.attachVariableConfElement_ProgramVar)) {
			val model = context.getContainerOfType(Model)
			val candidates = new ArrayList<EObject>
			candidates.getProgramInOutVar(model)
			return Scopes.scopeFor(candidates)
		}

		return super.getScope(context, reference)
	}

	def getProgramInOutVar(List<EObject> candidates, Model model) {
		for (program : model.programs) {
			for (inDecl : program.progInVars) {
				for (varList : inDecl.vars) {
					candidates.addAll(varList.varList.vars)
				}
			}
			for (outDecl : program.progOutVars) {
				for (varList : outDecl.vars) {
					candidates.addAll(varList.varList.vars)
				}
			}
		}
	}

	def getProcessInOutVar(List<EObject> candidates, Model model) {
		for (program : model.programs) {
			for (process : program.processes) {
				for (inDecl : process.procInVars) {
					for (varList : inDecl.vars) {
						candidates.addAll(varList.varList.vars)
					}
				}
				for (outDecl : process.procOutVars) {
					for (varList : outDecl.vars) {
						candidates.addAll(varList.varList.vars)
					}
				}
			}
		}
	}
}
