package su.nsk.iae.post.ui.wizard;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider;

@SuppressWarnings("all")
public class PoSTProjectTemplateProvider implements IProjectTemplateProvider {
  public static String srcFolder = "src";
  
  public static String genFolder = "src-gen";
  
  public static String libFolder = "Tool Library";
  
  public static List<String> arithmetic = Lists.<String>newArrayList("arithmetic/F_ADD.xml", "arithmetic/F_ADD_3.xml", "arithmetic/F_ADD_DT_TIME.xml", "arithmetic/F_ADD_TOD_TIME.xml", "arithmetic/F_DIV.xml", "arithmetic/F_DIVTIME.xml", "arithmetic/F_EXPT.xml", "arithmetic/F_MOD.xml", "arithmetic/F_MOVE.xml", "arithmetic/F_MUL.xml", "arithmetic/F_MULTIME.xml", "arithmetic/F_SUB.xml", "arithmetic/F_SUB_DATE_DATE.xml", "arithmetic/F_SUB_DT_DT.xml", "arithmetic/F_SUB_DT_TIME.xml", "arithmetic/F_SUB_TOD_TIME.xml", "arithmetic/F_SUB_TOD_TOD.xml", "arithmetic/F_TRUNC.xml");
  
  public static List<String> timers = Lists.<String>newArrayList("timers/FB_TOF.xml", "timers/FB_TON.xml", "timers/FB_TP.xml");
  
  public static List<String> libFiles = Lists.<List<String>>newArrayList(PoSTProjectTemplateProvider.arithmetic, PoSTProjectTemplateProvider.timers).stream().<String>flatMap(((Function<List<String>, Stream<String>>) (List<String> x) -> {
    return x.stream();
  })).collect(Collectors.<String>toList());
  
  @Override
  public AbstractProjectTemplate[] getProjectTemplates() {
    EmptyProject _emptyProject = new EmptyProject();
    EmptyTemplateProject _emptyTemplateProject = new EmptyTemplateProject();
    HandDryerProject _handDryerProject = new HandDryerProject();
    return new AbstractProjectTemplate[] { _emptyProject, _emptyTemplateProject, _handDryerProject };
  }
}
