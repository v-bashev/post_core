package su.nsk.iae.post.ui.wizard

import com.google.common.collect.Lists
import java.util.List
import java.util.stream.Collectors
import org.eclipse.core.runtime.FileLocator
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Platform
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.util.ProjectFactory
import org.eclipse.xtext.ui.wizard.template.IProjectGenerator
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider
import org.eclipse.xtext.ui.wizard.template.ProjectTemplate
import org.eclipse.xtext.util.Files

class PoSTProjectTemplateProvider implements IProjectTemplateProvider {
	
	public static String srcFolder = "src"
	public static String genFolder = "src-gen"
	public static String libFolder = "Tool Library"
	
	public static List<String> arithmetic = Lists.newArrayList("arithmetic/F_ADD.xml", "arithmetic/F_ADD_3.xml", "arithmetic/F_ADD_DT_TIME.xml", "arithmetic/F_ADD_TOD_TIME.xml", "arithmetic/F_DIV.xml", "arithmetic/F_DIVTIME.xml", "arithmetic/F_EXPT.xml", "arithmetic/F_MOD.xml", "arithmetic/F_MOVE.xml", "arithmetic/F_MUL.xml", "arithmetic/F_MULTIME.xml", "arithmetic/F_SUB.xml", "arithmetic/F_SUB_DATE_DATE.xml", "arithmetic/F_SUB_DT_DT.xml", "arithmetic/F_SUB_DT_TIME.xml", "arithmetic/F_SUB_TOD_TIME.xml", "arithmetic/F_SUB_TOD_TOD.xml", "arithmetic/F_TRUNC.xml")
	public static List<String> timers = Lists.newArrayList("timers/FB_TOF.xml", "timers/FB_TON.xml", "timers/FB_TP.xml")
	
	public static List<String> libFiles = Lists.newArrayList(arithmetic, timers).stream.flatMap([x | x.stream]).collect(Collectors.toList)
	
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
			for (lib : PoSTProjectTemplateProvider.libFiles) {
				val libStream = FileLocator.resolve(FileLocator.find(bundle, new Path("/resources/library/" + lib), null)).openStream
				addFile('''«PoSTProjectTemplateProvider.libFolder»/«lib»''', Files.readStreamIntoString(libStream))
			}
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
			val templateStream = FileLocator.resolve(FileLocator.find(bundle, new Path("/resources/examples/Template.post"), null)).openStream
			addFile('''«PoSTProjectTemplateProvider.srcFolder»/template.post''', Files.readStreamIntoString(templateStream))
			for (lib : PoSTProjectTemplateProvider.libFiles) {
				val libStream = FileLocator.resolve(FileLocator.find(bundle, new Path("/resources/library/" + lib), null)).openStream
				addFile('''«PoSTProjectTemplateProvider.libFolder»/«lib»''', Files.readStreamIntoString(libStream))
			}
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
			val handDryerStream = FileLocator.resolve(FileLocator.find(bundle, new Path("/resources/examples/HandDryer.post"), null)).openStream
			addFile('''«PoSTProjectTemplateProvider.srcFolder»/handDryer.post''', Files.readStreamIntoString(handDryerStream))
			for (lib : PoSTProjectTemplateProvider.libFiles) {
				val libStream = FileLocator.resolve(FileLocator.find(bundle, new Path("/resources/library/" + lib), null)).openStream
				addFile('''«PoSTProjectTemplateProvider.libFolder»/«lib»''', Files.readStreamIntoString(libStream))
			}
		])
	}
}
