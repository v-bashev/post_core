package su.nsk.iae.post.generator;

import org.eclipse.xtext.generator.IGenerator2;
import su.nsk.iae.post.poST.Model;

@SuppressWarnings("all")
public interface IPoSTGenerator extends IGenerator2 {
  void setModel(final Model model);
}
