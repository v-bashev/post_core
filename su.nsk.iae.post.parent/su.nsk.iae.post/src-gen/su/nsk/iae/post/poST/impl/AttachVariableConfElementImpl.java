/**
 * generated by Xtext 2.25.0
 */
package su.nsk.iae.post.poST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import su.nsk.iae.post.poST.AssignmentType;
import su.nsk.iae.post.poST.AttachVariableConfElement;
import su.nsk.iae.post.poST.Constant;
import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.SymbolicVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attach Variable Conf Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link su.nsk.iae.post.poST.impl.AttachVariableConfElementImpl#getProgramVar <em>Program Var</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.AttachVariableConfElementImpl#getAssig <em>Assig</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.AttachVariableConfElementImpl#getAttVar <em>Att Var</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.AttachVariableConfElementImpl#getConst <em>Const</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttachVariableConfElementImpl extends ProgramConfElementImpl implements AttachVariableConfElement
{
  /**
   * The cached value of the '{@link #getProgramVar() <em>Program Var</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProgramVar()
   * @generated
   * @ordered
   */
  protected SymbolicVariable programVar;

  /**
   * The default value of the '{@link #getAssig() <em>Assig</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssig()
   * @generated
   * @ordered
   */
  protected static final AssignmentType ASSIG_EDEFAULT = AssignmentType.IN;

  /**
   * The cached value of the '{@link #getAssig() <em>Assig</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssig()
   * @generated
   * @ordered
   */
  protected AssignmentType assig = ASSIG_EDEFAULT;

  /**
   * The cached value of the '{@link #getAttVar() <em>Att Var</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttVar()
   * @generated
   * @ordered
   */
  protected SymbolicVariable attVar;

  /**
   * The cached value of the '{@link #getConst() <em>Const</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConst()
   * @generated
   * @ordered
   */
  protected Constant const_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttachVariableConfElementImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return PoSTPackage.Literals.ATTACH_VARIABLE_CONF_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SymbolicVariable getProgramVar()
  {
    if (programVar != null && programVar.eIsProxy())
    {
      InternalEObject oldProgramVar = (InternalEObject)programVar;
      programVar = (SymbolicVariable)eResolveProxy(oldProgramVar);
      if (programVar != oldProgramVar)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__PROGRAM_VAR, oldProgramVar, programVar));
      }
    }
    return programVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SymbolicVariable basicGetProgramVar()
  {
    return programVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProgramVar(SymbolicVariable newProgramVar)
  {
    SymbolicVariable oldProgramVar = programVar;
    programVar = newProgramVar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__PROGRAM_VAR, oldProgramVar, programVar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AssignmentType getAssig()
  {
    return assig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAssig(AssignmentType newAssig)
  {
    AssignmentType oldAssig = assig;
    assig = newAssig == null ? ASSIG_EDEFAULT : newAssig;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__ASSIG, oldAssig, assig));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SymbolicVariable getAttVar()
  {
    if (attVar != null && attVar.eIsProxy())
    {
      InternalEObject oldAttVar = (InternalEObject)attVar;
      attVar = (SymbolicVariable)eResolveProxy(oldAttVar);
      if (attVar != oldAttVar)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__ATT_VAR, oldAttVar, attVar));
      }
    }
    return attVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SymbolicVariable basicGetAttVar()
  {
    return attVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAttVar(SymbolicVariable newAttVar)
  {
    SymbolicVariable oldAttVar = attVar;
    attVar = newAttVar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__ATT_VAR, oldAttVar, attVar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Constant getConst()
  {
    return const_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConst(Constant newConst, NotificationChain msgs)
  {
    Constant oldConst = const_;
    const_ = newConst;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__CONST, oldConst, newConst);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setConst(Constant newConst)
  {
    if (newConst != const_)
    {
      NotificationChain msgs = null;
      if (const_ != null)
        msgs = ((InternalEObject)const_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__CONST, null, msgs);
      if (newConst != null)
        msgs = ((InternalEObject)newConst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__CONST, null, msgs);
      msgs = basicSetConst(newConst, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__CONST, newConst, newConst));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__CONST:
        return basicSetConst(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__PROGRAM_VAR:
        if (resolve) return getProgramVar();
        return basicGetProgramVar();
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__ASSIG:
        return getAssig();
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__ATT_VAR:
        if (resolve) return getAttVar();
        return basicGetAttVar();
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__CONST:
        return getConst();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__PROGRAM_VAR:
        setProgramVar((SymbolicVariable)newValue);
        return;
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__ASSIG:
        setAssig((AssignmentType)newValue);
        return;
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__ATT_VAR:
        setAttVar((SymbolicVariable)newValue);
        return;
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__CONST:
        setConst((Constant)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__PROGRAM_VAR:
        setProgramVar((SymbolicVariable)null);
        return;
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__ASSIG:
        setAssig(ASSIG_EDEFAULT);
        return;
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__ATT_VAR:
        setAttVar((SymbolicVariable)null);
        return;
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__CONST:
        setConst((Constant)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__PROGRAM_VAR:
        return programVar != null;
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__ASSIG:
        return assig != ASSIG_EDEFAULT;
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__ATT_VAR:
        return attVar != null;
      case PoSTPackage.ATTACH_VARIABLE_CONF_ELEMENT__CONST:
        return const_ != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (assig: ");
    result.append(assig);
    result.append(')');
    return result.toString();
  }

} //AttachVariableConfElementImpl