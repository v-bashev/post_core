package su.nsk.iae.post.ui.wizard;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.wizard.template.AbstractFileTemplate;
import org.eclipse.xtext.ui.wizard.template.FileTemplate;
import org.eclipse.xtext.ui.wizard.template.IFileGenerator;

@FileTemplate(label = "Empty File", icon = "PoST_file.png", description = "Create an empty poST file.")
@SuppressWarnings("all")
public final class EmptyFile extends AbstractFileTemplate {
  @Override
  public void generateFiles(final IFileGenerator generator) {
    StringConcatenation _builder = new StringConcatenation();
    String _folder = this.getFolder();
    _builder.append(_folder);
    _builder.append("/");
    String _name = this.getName();
    _builder.append(_name);
    _builder.append(".post");
    StringConcatenation _builder_1 = new StringConcatenation();
    generator.generate(_builder, _builder_1);
  }
}
