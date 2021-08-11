package su.nsk.iae.post.ui.wizard

import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.util.ProjectFactory
import org.eclipse.xtext.ui.wizard.template.IProjectGenerator
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider
import org.eclipse.xtext.ui.wizard.template.ProjectTemplate

import static su.nsk.iae.post.ui.wizard.PoSTProgramCodeUtil.*

class PoSTProjectTemplateProvider implements IProjectTemplateProvider {
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
			folders += "src"
			folders += "src-gen"
			folders += "Tool Library"
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
			folders += "src"
			folders += "src-gen"
			folders += "Tool Library"
			addFile('''src/template.post''', teplateProgram)
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
			folders += "src"
			folders += "src-gen"
			folders += "Tool Library"
			addFile('''src/handDryer.post''', handDryerProgram)
		])
	}
}
