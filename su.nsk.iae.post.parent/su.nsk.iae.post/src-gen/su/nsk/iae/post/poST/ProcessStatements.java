/**
 * generated by Xtext 2.25.0
 */
package su.nsk.iae.post.poST;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Statements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link su.nsk.iae.post.poST.ProcessStatements#getProcess <em>Process</em>}</li>
 * </ul>
 *
 * @see su.nsk.iae.post.poST.PoSTPackage#getProcessStatements()
 * @model
 * @generated
 */
public interface ProcessStatements extends Statement
{
  /**
   * Returns the value of the '<em><b>Process</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Process</em>' reference.
   * @see #setProcess(ProcessStatementElement)
   * @see su.nsk.iae.post.poST.PoSTPackage#getProcessStatements_Process()
   * @model
   * @generated
   */
  ProcessStatementElement getProcess();

  /**
   * Sets the value of the '{@link su.nsk.iae.post.poST.ProcessStatements#getProcess <em>Process</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Process</em>' reference.
   * @see #getProcess()
   * @generated
   */
  void setProcess(ProcessStatementElement value);

} // ProcessStatements
