package su.nsk.iae.post;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Interface to be implemented in any DSM-core for DSM-wrapper could invoke
 * execution of DSM-core logic
 */
public interface IDsmExecutor {
	/**
	 * Starts DSM-core logic execution
	 * 
	 * @param root     project root
	 * @param fileName poST source file name
	 * @param resource EMF resource with poST source code AST
	 * @return result message
	 */
	String execute(String root, String fileName, Resource resource);
}