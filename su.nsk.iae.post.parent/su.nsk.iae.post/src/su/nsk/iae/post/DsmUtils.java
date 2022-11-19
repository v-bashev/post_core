package su.nsk.iae.post;

import java.util.LinkedHashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import com.google.common.collect.Iterables;

import su.nsk.iae.post.deserialization.ModelDeserializer;
import su.nsk.iae.post.poST.Model;

/*
 * Utility class to help with DSM request
 */
public class DsmUtils {
	/*
	 * Returns project root from request
	 */
	public static String getRoot(LinkedHashMap<String, Object> request) {
		return (String) request.get("root");
	}

	/*
	 * Returns poST source file name from request
	 */
	public static String getFileName(LinkedHashMap<String, Object> request) {
		return (String) request.get("fileName");
	}

	/*
	 * Returns EMF resource form request
	 */
	public static Resource getResource(LinkedHashMap<String, Object> request) {
		return ModelDeserializer.deserializeFromXMI((String) request.get("fileName"));
	}

	/*
	 * Returns poST Model (root of AST) from EMF resource
	 */
	public static Model getModel(final Resource resource) {
		return ((Model[]) Conversions.unwrapArray((Iterables
				.<Model>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Model.class)),
				Model.class))[0];
	}
}
