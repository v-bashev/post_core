/**
 * generated by Xtext 2.25.0
 */
package su.nsk.iae.post.poST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import su.nsk.iae.post.poST.Constant;
import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.TaskInitialization;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Initialization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link su.nsk.iae.post.poST.impl.TaskInitializationImpl#getSingle <em>Single</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.TaskInitializationImpl#getInterval <em>Interval</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.TaskInitializationImpl#getPriority <em>Priority</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaskInitializationImpl extends MinimalEObjectImpl.Container implements TaskInitialization
{
  /**
   * The cached value of the '{@link #getSingle() <em>Single</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSingle()
   * @generated
   * @ordered
   */
  protected Constant single;

  /**
   * The cached value of the '{@link #getInterval() <em>Interval</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterval()
   * @generated
   * @ordered
   */
  protected Constant interval;

  /**
   * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected static final int PRIORITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected int priority = PRIORITY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TaskInitializationImpl()
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
    return PoSTPackage.Literals.TASK_INITIALIZATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Constant getSingle()
  {
    return single;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSingle(Constant newSingle, NotificationChain msgs)
  {
    Constant oldSingle = single;
    single = newSingle;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PoSTPackage.TASK_INITIALIZATION__SINGLE, oldSingle, newSingle);
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
  public void setSingle(Constant newSingle)
  {
    if (newSingle != single)
    {
      NotificationChain msgs = null;
      if (single != null)
        msgs = ((InternalEObject)single).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PoSTPackage.TASK_INITIALIZATION__SINGLE, null, msgs);
      if (newSingle != null)
        msgs = ((InternalEObject)newSingle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PoSTPackage.TASK_INITIALIZATION__SINGLE, null, msgs);
      msgs = basicSetSingle(newSingle, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.TASK_INITIALIZATION__SINGLE, newSingle, newSingle));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Constant getInterval()
  {
    return interval;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInterval(Constant newInterval, NotificationChain msgs)
  {
    Constant oldInterval = interval;
    interval = newInterval;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PoSTPackage.TASK_INITIALIZATION__INTERVAL, oldInterval, newInterval);
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
  public void setInterval(Constant newInterval)
  {
    if (newInterval != interval)
    {
      NotificationChain msgs = null;
      if (interval != null)
        msgs = ((InternalEObject)interval).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PoSTPackage.TASK_INITIALIZATION__INTERVAL, null, msgs);
      if (newInterval != null)
        msgs = ((InternalEObject)newInterval).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PoSTPackage.TASK_INITIALIZATION__INTERVAL, null, msgs);
      msgs = basicSetInterval(newInterval, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.TASK_INITIALIZATION__INTERVAL, newInterval, newInterval));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getPriority()
  {
    return priority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPriority(int newPriority)
  {
    int oldPriority = priority;
    priority = newPriority;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.TASK_INITIALIZATION__PRIORITY, oldPriority, priority));
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
      case PoSTPackage.TASK_INITIALIZATION__SINGLE:
        return basicSetSingle(null, msgs);
      case PoSTPackage.TASK_INITIALIZATION__INTERVAL:
        return basicSetInterval(null, msgs);
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
      case PoSTPackage.TASK_INITIALIZATION__SINGLE:
        return getSingle();
      case PoSTPackage.TASK_INITIALIZATION__INTERVAL:
        return getInterval();
      case PoSTPackage.TASK_INITIALIZATION__PRIORITY:
        return getPriority();
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
      case PoSTPackage.TASK_INITIALIZATION__SINGLE:
        setSingle((Constant)newValue);
        return;
      case PoSTPackage.TASK_INITIALIZATION__INTERVAL:
        setInterval((Constant)newValue);
        return;
      case PoSTPackage.TASK_INITIALIZATION__PRIORITY:
        setPriority((Integer)newValue);
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
      case PoSTPackage.TASK_INITIALIZATION__SINGLE:
        setSingle((Constant)null);
        return;
      case PoSTPackage.TASK_INITIALIZATION__INTERVAL:
        setInterval((Constant)null);
        return;
      case PoSTPackage.TASK_INITIALIZATION__PRIORITY:
        setPriority(PRIORITY_EDEFAULT);
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
      case PoSTPackage.TASK_INITIALIZATION__SINGLE:
        return single != null;
      case PoSTPackage.TASK_INITIALIZATION__INTERVAL:
        return interval != null;
      case PoSTPackage.TASK_INITIALIZATION__PRIORITY:
        return priority != PRIORITY_EDEFAULT;
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
    result.append(" (priority: ");
    result.append(priority);
    result.append(')');
    return result.toString();
  }

} //TaskInitializationImpl
