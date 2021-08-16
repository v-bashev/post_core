package su.nsk.iae.post.ui.wizard;

import org.eclipse.xtext.ui.wizard.template.AbstractFileTemplate;
import org.eclipse.xtext.ui.wizard.template.IFileTemplateProvider;

@SuppressWarnings("all")
public class PoSTFileTemplateProvider implements IFileTemplateProvider {
  @Override
  public AbstractFileTemplate[] getFileTemplates() {
    EmptyFile _emptyFile = new EmptyFile();
    EmptyTemplateFile _emptyTemplateFile = new EmptyTemplateFile();
    HandDryerFile _handDryerFile = new HandDryerFile();
    return new AbstractFileTemplate[] { _emptyFile, _emptyTemplateFile, _handDryerFile };
  }
}
