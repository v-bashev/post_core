package su.nsk.iae.post.ui.wizard

import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.util.ProjectFactory
import org.eclipse.xtext.ui.wizard.template.IProjectGenerator
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider
import org.eclipse.xtext.ui.wizard.template.ProjectTemplate

import static su.nsk.iae.post.ui.wizard.PoSTProgramCodeUtil.*
import java.nio.file.Files
import java.nio.file.Paths
import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate
import java.util.List
import java.io.File
import org.eclipse.core.runtime.FileLocator
import org.eclipse.core.runtime.Platform
import org.eclipse.core.runtime.Path

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
			val url = FileLocator.resolve(FileLocator.find(bundle, new Path("/resources/library"), null))
			Files.walk(Paths.get(url.toURI)).filter([dir | Files.isDirectory(dir)]).forEach([dir |
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
			addFile('''«PoSTProjectTemplateProvider.srcFolder»/template.post''', teplateProgram)
			
			val bundle = Platform.getBundle("su.nsk.iae.post.ui")
			val url = FileLocator.resolve(FileLocator.find(bundle, new Path("/resources/library"), null))
			Files.walk(Paths.get(url.toURI)).filter([dir | Files.isDirectory(dir)]).forEach([dir |
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
			addFile('''«PoSTProjectTemplateProvider.srcFolder»/handDryer.post''', handDryerProgram)
			
			val bundle = Platform.getBundle("su.nsk.iae.post.ui")
			val url = FileLocator.resolve(FileLocator.find(bundle, new Path("/resources/library"), null))
			Files.walk(Paths.get(url.toURI)).filter([dir | Files.isDirectory(dir)]).forEach([dir |
				Files.walk(dir).filter([file | Files.isRegularFile(file)]).forEach([file |
					addFile('''«PoSTProjectTemplateProvider.libFolder»/«file.getName(file.size - 2)»/«file.last»''', Files.readString(file))
				])
			])
		])
	}
}
