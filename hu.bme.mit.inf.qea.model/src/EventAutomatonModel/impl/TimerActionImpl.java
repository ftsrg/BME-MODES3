/**
 */
package EventAutomatonModel.impl;

import EventAutomatonModel.EventAutomatonModelPackage;
import EventAutomatonModel.SymbolicTimer;
import EventAutomatonModel.TimerAction;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timer Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.impl.TimerActionImpl#getTimer <em>Timer</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TimerActionImpl extends ActionImpl implements TimerAction {
	/**
	 * The cached value of the '{@link #getTimer() <em>Timer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimer()
	 * @generated
	 * @ordered
	 */
	protected SymbolicTimer timer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimerActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventAutomatonModelPackage.Literals.TIMER_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolicTimer getTimer() {
		if (timer != null && timer.eIsProxy()) {
			InternalEObject oldTimer = (InternalEObject)timer;
			timer = (SymbolicTimer)eResolveProxy(oldTimer);
			if (timer != oldTimer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventAutomatonModelPackage.TIMER_ACTION__TIMER, oldTimer, timer));
			}
		}
		return timer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolicTimer basicGetTimer() {
		return timer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimer(SymbolicTimer newTimer) {
		SymbolicTimer oldTimer = timer;
		timer = newTimer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventAutomatonModelPackage.TIMER_ACTION__TIMER, oldTimer, timer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventAutomatonModelPackage.TIMER_ACTION__TIMER:
				if (resolve) return getTimer();
				return basicGetTimer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EventAutomatonModelPackage.TIMER_ACTION__TIMER:
				setTimer((SymbolicTimer)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case EventAutomatonModelPackage.TIMER_ACTION__TIMER:
				setTimer((SymbolicTimer)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EventAutomatonModelPackage.TIMER_ACTION__TIMER:
				return timer != null;
		}
		return super.eIsSet(featureID);
	}

} //TimerActionImpl
