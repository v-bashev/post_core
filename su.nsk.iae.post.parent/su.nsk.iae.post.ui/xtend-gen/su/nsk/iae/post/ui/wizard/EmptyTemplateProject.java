package su.nsk.iae.post.ui.wizard;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.ProjectFactory;
import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;
import org.eclipse.xtext.ui.wizard.template.IProjectGenerator;
import org.eclipse.xtext.ui.wizard.template.ProjectTemplate;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ProjectTemplate(label = "Template Project", icon = "project_template.png", description = "<p><b>Template poST Project</b></p>\r\n<p>Creates a poST project with process-oriented template.</p>")
@SuppressWarnings("all")
public final class EmptyTemplateProject extends AbstractProjectTemplate {
  @Override
  public void generateProjects(final IProjectGenerator generator) {
    ProjectFactory _projectFactory = new ProjectFactory();
    final Procedure1<ProjectFactory> _function = (ProjectFactory it) -> {
      it.setProjectName(this.getProjectInfo().getProjectName());
      it.setLocation(this.getProjectInfo().getLocationPath());
      List<String> _projectNatures = it.getProjectNatures();
      _projectNatures.add(XtextProjectHelper.NATURE_ID);
      List<String> _builderIds = it.getBuilderIds();
      _builderIds.add(XtextProjectHelper.BUILDER_ID);
      List<String> _folders = it.getFolders();
      _folders.add("src");
      List<String> _folders_1 = it.getFolders();
      _folders_1.add("src-gen");
      List<String> _folders_2 = it.getFolders();
      _folders_2.add("Tool Library");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("src/template.post");
      this.addFile(it, _builder, PoSTProgramCodeUtil.getTeplateProgram());
    };
    ProjectFactory _doubleArrow = ObjectExtensions.<ProjectFactory>operator_doubleArrow(_projectFactory, _function);
    generator.generate(_doubleArrow);
  }
}
