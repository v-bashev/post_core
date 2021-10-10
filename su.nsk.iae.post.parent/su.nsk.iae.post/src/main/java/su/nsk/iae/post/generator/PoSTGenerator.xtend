package su.nsk.iae.post.generator

import java.util.ArrayList
import java.util.List
import org.eclipse.core.runtime.Platform
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import su.nsk.iae.post.poST.Model

class PoSTGenerator extends AbstractGenerator {
	
	static final String EXTENSION_ID = "su.nsk.iae.post.post_extension"
	static final List<IPoSTGenerator> generators = new ArrayList
	
	static def void initGenerators() {
		val configuration = Platform.extensionRegistry.getConfigurationElementsFor(EXTENSION_ID)
		for (el : configuration) {
			val obj = el.createExecutableExtension("class")
			if (obj instanceof IPoSTGenerator) {
				generators.add(obj)
			}
		}
	}

	override beforeGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		if (resource.allContents.empty) {
			return
		}
		val model = resource.allContents.toIterable.filter(Model).get(0)
		if (generators.empty) {
			initGenerators()
		}
		for (g : generators) {
			g.model = model
			g.beforeGenerate(resource, fsa, context)
		}
	}

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (g : generators) {
			g.doGenerate(resource, fsa, context)
		}
	}
	
	override afterGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (g : generators) {
			g.afterGenerate(resource, fsa, context)
		}
	}
}
