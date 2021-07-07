/**
 * generated by Xtext 2.25.0
 */
package su.nsk.iae.post.poST;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link su.nsk.iae.post.poST.IfStatement#getMainCond <em>Main Cond</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.IfStatement#getMainStatement <em>Main Statement</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.IfStatement#getElseIfCond <em>Else If Cond</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.IfStatement#getElseIfStatements <em>Else If Statements</em>}</li>
 * </ul>
 *
 * @see su.nsk.iae.post.poST.PoSTPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends SelectionStatement
{
  /**
   * Returns the value of the '<em><b>Main Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Main Cond</em>' containment reference.
   * @see #setMainCond(Expression)
   * @see su.nsk.iae.post.poST.PoSTPackage#getIfStatement_MainCond()
   * @model containment="true"
   * @generated
   */
  Expression getMainCond();

  /**
   * Sets the value of the '{@link su.nsk.iae.post.poST.IfStatement#getMainCond <em>Main Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Main Cond</em>' containment reference.
   * @see #getMainCond()
   * @generated
   */
  void setMainCond(Expression value);

  /**
   * Returns the value of the '<em><b>Main Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Main Statement</em>' containment reference.
   * @see #setMainStatement(StatementList)
   * @see su.nsk.iae.post.poST.PoSTPackage#getIfStatement_MainStatement()
   * @model containment="true"
   * @generated
   */
  StatementList getMainStatement();

  /**
   * Sets the value of the '{@link su.nsk.iae.post.poST.IfStatement#getMainStatement <em>Main Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Main Statement</em>' containment reference.
   * @see #getMainStatement()
   * @generated
   */
  void setMainStatement(StatementList value);

  /**
   * Returns the value of the '<em><b>Else If Cond</b></em>' containment reference list.
   * The list contents are of type {@link su.nsk.iae.post.poST.Expression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else If Cond</em>' containment reference list.
   * @see su.nsk.iae.post.poST.PoSTPackage#getIfStatement_ElseIfCond()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getElseIfCond();

  /**
   * Returns the value of the '<em><b>Else If Statements</b></em>' containment reference list.
   * The list contents are of type {@link su.nsk.iae.post.poST.StatementList}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else If Statements</em>' containment reference list.
   * @see su.nsk.iae.post.poST.PoSTPackage#getIfStatement_ElseIfStatements()
   * @model containment="true"
   * @generated
   */
  EList<StatementList> getElseIfStatements();

} // IfStatement