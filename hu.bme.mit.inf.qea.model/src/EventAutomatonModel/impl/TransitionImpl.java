/**
 */
package EventAutomatonModel.impl;

import EventAutomatonModel.EventAutomatonModelPackage;
import EventAutomatonModel.EventGuard;
import EventAutomatonModel.Transition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.impl.TransitionImpl#getEventguard <em>Eventguard</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends AbstractTransitionImpl implements Transition {
	/**
	 * The cached value of the '{@link #getEventguard() <em>Eventguard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventguard()
	 * @generated
	 * @ordered
	 */
	protected EventGuard eventguard;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventAutomatonModelPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventGuard getEventguard() {
		return eventguard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventguard(EventGuard newEventguard, NotificationChain msgs) {
		EventGuard oldEventguard = eventguard;
		eventguard = newEventguard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventAutomatonModelPackage.TRANSITION__EVENTGUARD, oldEventguard, newEventguard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventguard(EventGuard newEventguard) {
		if (newEventguard != eventguard) {
			NotificationChain msgs = null;
			if (eventguard != null)
				msgs = ((InternalEObject)eventguard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventAutomatonModelPackage.TRANSITION__EVENTGUARD, null, msgs);
			if (newEventguard != null)
				msgs = ((InternalEObject)newEventguard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventAutomatonModelPackage.TRANSITION__EVENTGUARD, null, msgs);
			msgs = basicSetEventguard(newEventguard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventAutomatonModelPackage.TRANSITION__EVENTGUARD, newEventguard, newEventguard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventAutomatonModelPackage.TRANSITION__EVENTGUARD:
				return basicSetEventguard(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventAutomatonModelPackage.TRANSITION__EVENTGUARD:
				return getEventguard();
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
			case EventAutomatonModelPackage.TRANSITION__EVENTGUARD:
				setEventguard((EventGuard)newValue);
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
			case EventAutomatonModelPackage.TRANSITION__EVENTGUARD:
				setEventguard((EventGuard)null);
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
			case EventAutomatonModelPackage.TRANSITION__EVENTGUARD:
				return eventguard != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
