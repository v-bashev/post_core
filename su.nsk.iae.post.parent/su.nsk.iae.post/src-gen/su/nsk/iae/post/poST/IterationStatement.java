/**
 * generated by Xtext 2.25.0
 */
package su.nsk.iae.post.poST;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iteration Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link su.nsk.iae.post.poST.IterationStatement#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @see su.nsk.iae.post.poST.PoSTPackage#getIterationStatement()
 * @model
 * @generated
 */
public interface IterationStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement</em>' containment reference.
   * @see #setStatement(StatementList)
   * @see su.nsk.iae.post.poST.PoSTPackage#getIterationStatement_Statement()
   * @model containment="true"
   * @generated
   */
  StatementList getStatement();

  /**
   * Sets the value of the '{@link su.nsk.iae.post.poST.IterationStatement#getStatement <em>Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statement</em>' containment reference.
   * @see #getStatement()
   * @generated
   */
  void setStatement(StatementList value);

} // IterationStatement
