/**
 */
package EventAutomatonModel.impl;

import EventAutomatonModel.EventAutomatonModelPackage;
import EventAutomatonModel.SymbolicTimeoutEvent;
import EventAutomatonModel.SymbolicTimer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Symbolic Timeout Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.impl.SymbolicTimeoutEventImpl#getTimer <em>Timer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SymbolicTimeoutEventImpl extends SymbolicEventImpl implements SymbolicTimeoutEvent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SymbolicTimeoutEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventAutomatonModelPackage.Literals.SYMBOLIC_TIMEOUT_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolicTimer getTimer() {
		if (eContainerFeatureID() != EventAutomatonModelPackage.SYMBOLIC_TIMEOUT_EVENT__TIMER) return null;
		return (SymbolicTimer)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimer(SymbolicTimer newTimer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTimer, EventAutomatonModelPackage.SYMBOLIC_TIMEOUT_EVENT__TIMER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimer(SymbolicTimer newTimer) {
		if (newTimer != eInternalContainer() || (eContainerFeatureID() != EventAutomatonModelPackage.SYMBOLIC_TIMEOUT_EVENT__TIMER && newTimer != null)) {
			if (EcoreUtil.isAncestor(this, newTimer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTimer != null)
				msgs = ((InternalEObject)newTimer).eInverseAdd(this, EventAutomatonModelPackage.SYMBOLIC_TIMER__TIMEOUT_EVENT, SymbolicTimer.class, msgs);
			msgs = basicSetTimer(newTimer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventAutomatonModelPackage.SYMBOLIC_TIMEOUT_EVENT__TIMER, newTimer, newTimer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventAutomatonModelPackage.SYMBOLIC_TIMEOUT_EVENT__TIMER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTimer((SymbolicTimer)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventAutomatonModelPackage.SYMBOLIC_TIMEOUT_EVENT__TIMER:
				return basicSetTimer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case EventAutomatonModelPackage.SYMBOLIC_TIMEOUT_EVENT__TIMER:
				return eInternalContainer().eInverseRemove(this, EventAutomatonModelPackage.SYMBOLIC_TIMER__TIMEOUT_EVENT, SymbolicTimer.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventAutomatonModelPackage.SYMBOLIC_TIMEOUT_EVENT__TIMER:
				return getTimer();
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
			case EventAutomatonModelPackage.SYMBOLIC_TIMEOUT_EVENT__TIMER:
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
			case EventAutomatonModelPackage.SYMBOLIC_TIMEOUT_EVENT__TIMER:
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
			case EventAutomatonModelPackage.SYMBOLIC_TIMEOUT_EVENT__TIMER:
				return getTimer() != null;
		}
		return super.eIsSet(featureID);
	}

} //SymbolicTimeoutEventImpl
