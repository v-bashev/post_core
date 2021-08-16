package su.nsk.iae.post.ui.wizard;

import java.io.InputStream;
import java.util.List;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.ProjectFactory;
import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;
import org.eclipse.xtext.ui.wizard.template.IProjectGenerator;
import org.eclipse.xtext.ui.wizard.template.ProjectTemplate;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.osgi.framework.Bundle;

@ProjectTemplate(label = "Hand Dryer Project", icon = "project_template.png", description = "<p><b>Hand Dryer poST Project</b></p>\r\n<p>Creates a poST project with Hand Dryer program.</p>")
@SuppressWarnings("all")
public final class HandDryerProject extends AbstractProjectTemplate {
  @Override
  public void generateProjects(final IProjectGenerator generator) {
    ProjectFactory _projectFactory = new ProjectFactory();
    final Procedure1<ProjectFactory> _function = (ProjectFactory it) -> {
      try {
        it.setProjectName(this.getProjectInfo().getProjectName());
        it.setLocation(this.getProjectInfo().getLocationPath());
        List<String> _projectNatures = it.getProjectNatures();
        _projectNatures.add(XtextProjectHelper.NATURE_ID);
        List<String> _builderIds = it.getBuilderIds();
        _builderIds.add(XtextProjectHelper.BUILDER_ID);
        List<String> _folders = it.getFolders();
        _folders.add(PoSTProjectTemplateProvider.srcFolder);
        List<String> _folders_1 = it.getFolders();
        _folders_1.add(PoSTProjectTemplateProvider.genFolder);
        List<String> _folders_2 = it.getFolders();
        _folders_2.add(PoSTProjectTemplateProvider.libFolder);
        final Bundle bundle = Platform.getBundle("su.nsk.iae.post.ui");
        Path _path = new Path("/resources/examples/HandDryer.post");
        final InputStream handDryerStream = FileLocator.resolve(FileLocator.find(bundle, _path, null)).openStream();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(PoSTProjectTemplateProvider.srcFolder);
        _builder.append("/handDryer.post");
        this.addFile(it, _builder, Files.readStreamIntoString(handDryerStream));
        for (final String lib : PoSTProjectTemplateProvider.libFiles) {
          {
            Path _path_1 = new Path(("/resources/library/" + lib));
            final InputStream libStream = FileLocator.resolve(FileLocator.find(bundle, _path_1, null)).openStream();
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append(PoSTProjectTemplateProvider.libFolder);
            _builder_1.append("/");
            _builder_1.append(lib);
            this.addFile(it, _builder_1, Files.readStreamIntoString(libStream));
          }
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    ProjectFactory _doubleArrow = ObjectExtensions.<ProjectFactory>operator_doubleArrow(_projectFactory, _function);
    generator.generate(_doubleArrow);
  }
}
