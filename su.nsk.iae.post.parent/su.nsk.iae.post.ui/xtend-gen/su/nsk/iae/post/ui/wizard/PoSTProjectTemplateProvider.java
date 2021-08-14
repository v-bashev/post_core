package su.nsk.iae.post.ui.wizard;

import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider;

@SuppressWarnings("all")
public class PoSTProjectTemplateProvider implements IProjectTemplateProvider {
  public static String srcFolder = "src";
  
  public static String genFolder = "src-gen";
  
  public static String libFolder = "Tool Library";
  
  @Override
  public AbstractProjectTemplate[] getProjectTemplates() {
    EmptyProject _emptyProject = new EmptyProject();
    EmptyTemplateProject _emptyTemplateProject = new EmptyTemplateProject();
    HandDryerProject _handDryerProject = new HandDryerProject();
    return new AbstractProjectTemplate[] { _emptyProject, _emptyTemplateProject, _handDryerProject };
  }
}
