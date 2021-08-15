package su.nsk.iae.post.ui.wizard

import java.nio.file.Files
import java.nio.file.Paths
import org.eclipse.core.runtime.FileLocator
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Platform
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.util.ProjectFactory
import org.eclipse.xtext.ui.wizard.template.IProjectGenerator
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider
import org.eclipse.xtext.ui.wizard.template.ProjectTemplate

class PoSTProjectTemplateProvider implements IProjectTemplateProvider {
	
	public static String srcFolder = "src"
	public static String genFolder = "src-gen"
	public static String libFolder = "Tool Library"
	
	
	override getProjectTemplates() {
		#[new EmptyProject, new EmptyTemplateProject, new HandDryerProject]
	}
}

@ProjectTemplate(label="Empty Project", icon="project_template.png", description="<p><b>Empty poST Project</b></p>
<p>Creates an empty poST project without files.</p>")
final class EmptyProject {
	override generateProjects(IProjectGenerator generator) {
		generator.generate(new ProjectFactory => [
			projectName = projectInfo.projectName
			location = projectInfo.locationPath
			projectNatures += XtextProjectHelper.NATURE_ID
			builderIds += XtextProjectHelper.BUILDER_ID
			folders += PoSTProjectTemplateProvider.srcFolder
			folders += PoSTProjectTemplateProvider.genFolder
			folders += PoSTProjectTemplateProvider.libFolder
			
			val bundle = Platform.getBundle("su.nsk.iae.post.ui")
			val libUrl = FileLocator.resolve(FileLocator.find(bundle, new Path("/resources/library"), null))
			Files.walk(Paths.get(libUrl.toURI)).filter([dir | Files.isDirectory(dir)]).forEach([dir |
				Files.walk(dir).filter([file | Files.isRegularFile(file)]).forEach([file |
					addFile('''«PoSTProjectTemplateProvider.libFolder»/«file.getName(file.size - 2)»/«file.last»''', Files.readString(file))
				])
			])
		])
	}
}

@ProjectTemplate(label="Template Project", icon="project_template.png", description="<p><b>Template poST Project</b></p>
<p>Creates a poST project with process-oriented template.</p>")
final class EmptyTemplateProject {
	override generateProjects(IProjectGenerator generator) {
		generator.generate(new ProjectFactory => [
			projectName = projectInfo.projectName
			location = projectInfo.locationPath
			projectNatures += XtextProjectHelper.NATURE_ID
			builderIds += XtextProjectHelper.BUILDER_ID
			folders += PoSTProjectTemplateProvider.srcFolder
			folders += PoSTProjectTemplateProvider.genFolder
			folders += PoSTProjectTemplateProvider.libFolder
			
			val bundle = Platform.getBundle("su.nsk.iae.post.ui")
			val templateUrl = FileLocator.resolve(FileLocator.find(bundle, new Path("/resources/examples/Template.post"), null))
			addFile('''«PoSTProjectTemplateProvider.srcFolder»/template.post''', Files.readString(Paths.get(templateUrl.toURI)))
			val libUrl = FileLocator.resolve(FileLocator.find(bundle, new Path("/resources/library"), null))
			Files.walk(Paths.get(libUrl.toURI)).filter([dir | Files.isDirectory(dir)]).forEach([dir |
				Files.walk(dir).filter([file | Files.isRegularFile(file)]).forEach([file |
					addFile('''«PoSTProjectTemplateProvider.libFolder»/«file.getName(file.size - 2)»/«file.last»''', Files.readString(file))
				])
			])
		])
	}
}

@ProjectTemplate(label="Hand Dryer Project", icon="project_template.png", description="<p><b>Hand Dryer poST Project</b></p>
<p>Creates a poST project with Hand Dryer program.</p>")
final class HandDryerProject {
	override generateProjects(IProjectGenerator generator) {
		generator.generate(new ProjectFactory => [
			projectName = projectInfo.projectName
			location = projectInfo.locationPath
			projectNatures += XtextProjectHelper.NATURE_ID
			builderIds += XtextProjectHelper.BUILDER_ID
			folders += PoSTProjectTemplateProvider.srcFolder
			folders += PoSTProjectTemplateProvider.genFolder
			folders += PoSTProjectTemplateProvider.libFolder
			
			val bundle = Platform.getBundle("su.nsk.iae.post.ui")
			val handDryerUrl = FileLocator.resolve(FileLocator.find(bundle, new Path("/resources/examples/HandDryer.post"), null))
			addFile('''«PoSTProjectTemplateProvider.srcFolder»/handDryer.post''', Files.readString(Paths.get(handDryerUrl.toURI)))
			val libUrl = FileLocator.resolve(FileLocator.find(bundle, new Path("/resources/library"), null))
			Files.walk(Paths.get(libUrl.toURI)).filter([dir | Files.isDirectory(dir)]).forEach([dir |
				Files.walk(dir).filter([file | Files.isRegularFile(file)]).forEach([file |
					addFile('''«PoSTProjectTemplateProvider.libFolder»/«file.getName(file.size - 2)»/«file.last»''', Files.readString(file))
				])
			])
		])
	}
}
