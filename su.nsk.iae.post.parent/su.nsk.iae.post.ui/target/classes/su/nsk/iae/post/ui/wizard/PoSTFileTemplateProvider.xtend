package su.nsk.iae.post.ui.wizard

import org.eclipse.xtext.ui.wizard.template.FileTemplate
import org.eclipse.xtext.ui.wizard.template.IFileGenerator
import org.eclipse.xtext.ui.wizard.template.IFileTemplateProvider

import static su.nsk.iae.post.ui.wizard.PoSTProgramCodeUtil.*

class PoSTFileTemplateProvider implements IFileTemplateProvider {
	override getFileTemplates() {
		#[new EmptyFile, new EmptyTemplateFile, new HandDryerFile]
	}
}

@FileTemplate(label="Empty File", icon="PoST_file.png", description="Create an empty poST file.")
final class EmptyFile {
	override generateFiles(IFileGenerator generator) {
		generator.generate('''«folder»/«name».post''', '''''')
	}
}

@FileTemplate(label="Template Program", icon="PoST_file.png", description="Create an empty poST template.")
final class EmptyTemplateFile {
	override generateFiles(IFileGenerator generator) {
		generator.generate('''«folder»/«name».post''', teplateProgram)
	}
}

@FileTemplate(label="Hand Dryer Program", icon="PoST_file.png", description="Create a Hand Dryer poST program.")
final class HandDryerFile {
	override generateFiles(IFileGenerator generator) {
		generator.generate('''«folder»/«name».post''', handDryerProgram)
	}
}
