/**
 * generated by Xtext 2.25.0
 */
package su.nsk.iae.post.poST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import su.nsk.iae.post.poST.InputOutputVarDeclaration;
import su.nsk.iae.post.poST.InputVarDeclaration;
import su.nsk.iae.post.poST.OutputVarDeclaration;
import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.ProcessVarDeclaration;
import su.nsk.iae.post.poST.State;
import su.nsk.iae.post.poST.TempVarDeclaration;
import su.nsk.iae.post.poST.VarDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link su.nsk.iae.post.poST.impl.ProcessImpl#getProcInVars <em>Proc In Vars</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.ProcessImpl#getProcOutVars <em>Proc Out Vars</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.ProcessImpl#getProcInOutVars <em>Proc In Out Vars</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.ProcessImpl#getProcProcessVars <em>Proc Process Vars</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.ProcessImpl#getProcVars <em>Proc Vars</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.ProcessImpl#getProcTempVars <em>Proc Temp Vars</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.ProcessImpl#getStates <em>States</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessImpl extends VariableImpl implements su.nsk.iae.post.poST.Process
{
  /**
   * The cached value of the '{@link #getProcInVars() <em>Proc In Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcInVars()
   * @generated
   * @ordered
   */
  protected EList<InputVarDeclaration> procInVars;

  /**
   * The cached value of the '{@link #getProcOutVars() <em>Proc Out Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcOutVars()
   * @generated
   * @ordered
   */
  protected EList<OutputVarDeclaration> procOutVars;

  /**
   * The cached value of the '{@link #getProcInOutVars() <em>Proc In Out Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcInOutVars()
   * @generated
   * @ordered
   */
  protected EList<InputOutputVarDeclaration> procInOutVars;

  /**
   * The cached value of the '{@link #getProcProcessVars() <em>Proc Process Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcProcessVars()
   * @generated
   * @ordered
   */
  protected EList<ProcessVarDeclaration> procProcessVars;

  /**
   * The cached value of the '{@link #getProcVars() <em>Proc Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcVars()
   * @generated
   * @ordered
   */
  protected EList<VarDeclaration> procVars;

  /**
   * The cached value of the '{@link #getProcTempVars() <em>Proc Temp Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcTempVars()
   * @generated
   * @ordered
   */
  protected EList<TempVarDeclaration> procTempVars;

  /**
   * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStates()
   * @generated
   * @ordered
   */
  protected EList<State> states;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProcessImpl()
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
    return PoSTPackage.Literals.PROCESS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<InputVarDeclaration> getProcInVars()
  {
    if (procInVars == null)
    {
      procInVars = new EObjectContainmentEList<InputVarDeclaration>(InputVarDeclaration.class, this, PoSTPackage.PROCESS__PROC_IN_VARS);
    }
    return procInVars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<OutputVarDeclaration> getProcOutVars()
  {
    if (procOutVars == null)
    {
      procOutVars = new EObjectContainmentEList<OutputVarDeclaration>(OutputVarDeclaration.class, this, PoSTPackage.PROCESS__PROC_OUT_VARS);
    }
    return procOutVars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<InputOutputVarDeclaration> getProcInOutVars()
  {
    if (procInOutVars == null)
    {
      procInOutVars = new EObjectContainmentEList<InputOutputVarDeclaration>(InputOutputVarDeclaration.class, this, PoSTPackage.PROCESS__PROC_IN_OUT_VARS);
    }
    return procInOutVars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ProcessVarDeclaration> getProcProcessVars()
  {
    if (procProcessVars == null)
    {
      procProcessVars = new EObjectContainmentEList<ProcessVarDeclaration>(ProcessVarDeclaration.class, this, PoSTPackage.PROCESS__PROC_PROCESS_VARS);
    }
    return procProcessVars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<VarDeclaration> getProcVars()
  {
    if (procVars == null)
    {
      procVars = new EObjectContainmentEList<VarDeclaration>(VarDeclaration.class, this, PoSTPackage.PROCESS__PROC_VARS);
    }
    return procVars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<TempVarDeclaration> getProcTempVars()
  {
    if (procTempVars == null)
    {
      procTempVars = new EObjectContainmentEList<TempVarDeclaration>(TempVarDeclaration.class, this, PoSTPackage.PROCESS__PROC_TEMP_VARS);
    }
    return procTempVars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<State> getStates()
  {
    if (states == null)
    {
      states = new EObjectContainmentEList<State>(State.class, this, PoSTPackage.PROCESS__STATES);
    }
    return states;
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
      case PoSTPackage.PROCESS__PROC_IN_VARS:
        return ((InternalEList<?>)getProcInVars()).basicRemove(otherEnd, msgs);
      case PoSTPackage.PROCESS__PROC_OUT_VARS:
        return ((InternalEList<?>)getProcOutVars()).basicRemove(otherEnd, msgs);
      case PoSTPackage.PROCESS__PROC_IN_OUT_VARS:
        return ((InternalEList<?>)getProcInOutVars()).basicRemove(otherEnd, msgs);
      case PoSTPackage.PROCESS__PROC_PROCESS_VARS:
        return ((InternalEList<?>)getProcProcessVars()).basicRemove(otherEnd, msgs);
      case PoSTPackage.PROCESS__PROC_VARS:
        return ((InternalEList<?>)getProcVars()).basicRemove(otherEnd, msgs);
      case PoSTPackage.PROCESS__PROC_TEMP_VARS:
        return ((InternalEList<?>)getProcTempVars()).basicRemove(otherEnd, msgs);
      case PoSTPackage.PROCESS__STATES:
        return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
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
      case PoSTPackage.PROCESS__PROC_IN_VARS:
        return getProcInVars();
      case PoSTPackage.PROCESS__PROC_OUT_VARS:
        return getProcOutVars();
      case PoSTPackage.PROCESS__PROC_IN_OUT_VARS:
        return getProcInOutVars();
      case PoSTPackage.PROCESS__PROC_PROCESS_VARS:
        return getProcProcessVars();
      case PoSTPackage.PROCESS__PROC_VARS:
        return getProcVars();
      case PoSTPackage.PROCESS__PROC_TEMP_VARS:
        return getProcTempVars();
      case PoSTPackage.PROCESS__STATES:
        return getStates();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PoSTPackage.PROCESS__PROC_IN_VARS:
        getProcInVars().clear();
        getProcInVars().addAll((Collection<? extends InputVarDeclaration>)newValue);
        return;
      case PoSTPackage.PROCESS__PROC_OUT_VARS:
        getProcOutVars().clear();
        getProcOutVars().addAll((Collection<? extends OutputVarDeclaration>)newValue);
        return;
      case PoSTPackage.PROCESS__PROC_IN_OUT_VARS:
        getProcInOutVars().clear();
        getProcInOutVars().addAll((Collection<? extends InputOutputVarDeclaration>)newValue);
        return;
      case PoSTPackage.PROCESS__PROC_PROCESS_VARS:
        getProcProcessVars().clear();
        getProcProcessVars().addAll((Collection<? extends ProcessVarDeclaration>)newValue);
        return;
      case PoSTPackage.PROCESS__PROC_VARS:
        getProcVars().clear();
        getProcVars().addAll((Collection<? extends VarDeclaration>)newValue);
        return;
      case PoSTPackage.PROCESS__PROC_TEMP_VARS:
        getProcTempVars().clear();
        getProcTempVars().addAll((Collection<? extends TempVarDeclaration>)newValue);
        return;
      case PoSTPackage.PROCESS__STATES:
        getStates().clear();
        getStates().addAll((Collection<? extends State>)newValue);
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
      case PoSTPackage.PROCESS__PROC_IN_VARS:
        getProcInVars().clear();
        return;
      case PoSTPackage.PROCESS__PROC_OUT_VARS:
        getProcOutVars().clear();
        return;
      case PoSTPackage.PROCESS__PROC_IN_OUT_VARS:
        getProcInOutVars().clear();
        return;
      case PoSTPackage.PROCESS__PROC_PROCESS_VARS:
        getProcProcessVars().clear();
        return;
      case PoSTPackage.PROCESS__PROC_VARS:
        getProcVars().clear();
        return;
      case PoSTPackage.PROCESS__PROC_TEMP_VARS:
        getProcTempVars().clear();
        return;
      case PoSTPackage.PROCESS__STATES:
        getStates().clear();
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
      case PoSTPackage.PROCESS__PROC_IN_VARS:
        return procInVars != null && !procInVars.isEmpty();
      case PoSTPackage.PROCESS__PROC_OUT_VARS:
        return procOutVars != null && !procOutVars.isEmpty();
      case PoSTPackage.PROCESS__PROC_IN_OUT_VARS:
        return procInOutVars != null && !procInOutVars.isEmpty();
      case PoSTPackage.PROCESS__PROC_PROCESS_VARS:
        return procProcessVars != null && !procProcessVars.isEmpty();
      case PoSTPackage.PROCESS__PROC_VARS:
        return procVars != null && !procVars.isEmpty();
      case PoSTPackage.PROCESS__PROC_TEMP_VARS:
        return procTempVars != null && !procTempVars.isEmpty();
      case PoSTPackage.PROCESS__STATES:
        return states != null && !states.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ProcessImpl