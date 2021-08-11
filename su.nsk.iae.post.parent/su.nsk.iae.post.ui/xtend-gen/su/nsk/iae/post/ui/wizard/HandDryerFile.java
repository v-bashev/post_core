package su.nsk.iae.post.ui.wizard;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.wizard.template.AbstractFileTemplate;
import org.eclipse.xtext.ui.wizard.template.FileTemplate;
import org.eclipse.xtext.ui.wizard.template.IFileGenerator;

@FileTemplate(label = "Hand Dryer Program", icon = "file_template.png", description = "Create a Hand Dryer poST program.")
@SuppressWarnings("all")
public final class HandDryerFile extends AbstractFileTemplate {
  @Override
  public void generateFiles(final IFileGenerator generator) {
    StringConcatenation _builder = new StringConcatenation();
    String _folder = this.getFolder();
    _builder.append(_folder);
    _builder.append("/");
    String _name = this.getName();
    _builder.append(_name);
    _builder.append(".post");
    generator.generate(_builder, PoSTProgramCodeUtil.getHandDryerProgram());
  }
}
