package su.nsk.iae.post.ui.wizard;

import java.io.InputStream;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.wizard.template.AbstractFileTemplate;
import org.eclipse.xtext.ui.wizard.template.FileTemplate;
import org.eclipse.xtext.ui.wizard.template.IFileGenerator;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.osgi.framework.Bundle;

@FileTemplate(label = "Hand Dryer Program", icon = "PoST_file.png", description = "Create a Hand Dryer poST program.")
@SuppressWarnings("all")
public final class HandDryerFile extends AbstractFileTemplate {
  @Override
  public void generateFiles(final IFileGenerator generator) {
    try {
      final Bundle bundle = Platform.getBundle("su.nsk.iae.post.ui");
      Path _path = new Path("/resources/examples/HandDryer.post");
      final InputStream handDryerStream = FileLocator.resolve(FileLocator.find(bundle, _path, null)).openStream();
      StringConcatenation _builder = new StringConcatenation();
      String _folder = this.getFolder();
      _builder.append(_folder);
      _builder.append("/");
      String _name = this.getName();
      _builder.append(_name);
      _builder.append(".post");
      generator.generate(_builder, Files.readStreamIntoString(handDryerStream));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
