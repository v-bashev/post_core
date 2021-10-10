package su.nsk.iae.post.generator;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import su.nsk.iae.post.poST.Model;

@SuppressWarnings("all")
public class PoSTGenerator extends AbstractGenerator {
  private static final String EXTENSION_ID = "su.nsk.iae.post.post_extension";
  
  private static final List<IPoSTGenerator> generators = new ArrayList<IPoSTGenerator>();
  
  public static void initGenerators() {
    try {
      final IConfigurationElement[] configuration = Platform.getExtensionRegistry().getConfigurationElementsFor(PoSTGenerator.EXTENSION_ID);
      for (final IConfigurationElement el : configuration) {
        {
          final Object obj = el.createExecutableExtension("class");
          if ((obj instanceof IPoSTGenerator)) {
            PoSTGenerator.generators.add(((IPoSTGenerator)obj));
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void beforeGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    boolean _isEmpty = IteratorExtensions.isEmpty(resource.getAllContents());
    if (_isEmpty) {
      return;
    }
    final Model model = ((Model[])Conversions.unwrapArray((Iterables.<Model>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Model.class)), Model.class))[0];
    boolean _isEmpty_1 = PoSTGenerator.generators.isEmpty();
    if (_isEmpty_1) {
      PoSTGenerator.initGenerators();
    }
    for (final IPoSTGenerator g : PoSTGenerator.generators) {
      {
        g.setModel(model);
        g.beforeGenerate(resource, fsa, context);
      }
    }
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    for (final IPoSTGenerator g : PoSTGenerator.generators) {
      g.doGenerate(resource, fsa, context);
    }
  }
  
  @Override
  public void afterGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    for (final IPoSTGenerator g : PoSTGenerator.generators) {
      g.afterGenerate(resource, fsa, context);
    }
  }
}
