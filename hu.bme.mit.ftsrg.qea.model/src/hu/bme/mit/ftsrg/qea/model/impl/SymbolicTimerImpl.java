/**
 */
package hu.bme.mit.ftsrg.qea.model.impl;

import hu.bme.mit.ftsrg.qea.model.ModelPackage;
import hu.bme.mit.ftsrg.qea.model.SymbolicTimeoutEvent;
import hu.bme.mit.ftsrg.qea.model.SymbolicTimer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Symbolic Timer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.impl.SymbolicTimerImpl#getTimeoutEvent <em>Timeout Event</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.impl.SymbolicTimerImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SymbolicTimerImpl extends MinimalEObjectImpl.Container implements SymbolicTimer {
	/**
	 * The cached value of the '{@link #getTimeoutEvent() <em>Timeout Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeoutEvent()
	 * @generated
	 * @ordered
	 */
	protected SymbolicTimeoutEvent timeoutEvent;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SymbolicTimerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SYMBOLIC_TIMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolicTimeoutEvent getTimeoutEvent() {
		return timeoutEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeoutEvent(SymbolicTimeoutEvent newTimeoutEvent, NotificationChain msgs) {
		SymbolicTimeoutEvent oldTimeoutEvent = timeoutEvent;
		timeoutEvent = newTimeoutEvent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.SYMBOLIC_TIMER__TIMEOUT_EVENT, oldTimeoutEvent, newTimeoutEvent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeoutEvent(SymbolicTimeoutEvent newTimeoutEvent) {
		if (newTimeoutEvent != timeoutEvent) {
			NotificationChain msgs = null;
			if (timeoutEvent != null)
				msgs = ((InternalEObject)timeoutEvent).eInverseRemove(this, ModelPackage.SYMBOLIC_TIMEOUT_EVENT__TIMER, SymbolicTimeoutEvent.class, msgs);
			if (newTimeoutEvent != null)
				msgs = ((InternalEObject)newTimeoutEvent).eInverseAdd(this, ModelPackage.SYMBOLIC_TIMEOUT_EVENT__TIMER, SymbolicTimeoutEvent.class, msgs);
			msgs = basicSetTimeoutEvent(newTimeoutEvent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SYMBOLIC_TIMER__TIMEOUT_EVENT, newTimeoutEvent, newTimeoutEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SYMBOLIC_TIMER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.SYMBOLIC_TIMER__TIMEOUT_EVENT:
				if (timeoutEvent != null)
					msgs = ((InternalEObject)timeoutEvent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.SYMBOLIC_TIMER__TIMEOUT_EVENT, null, msgs);
				return basicSetTimeoutEvent((SymbolicTimeoutEvent)otherEnd, msgs);
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
			case ModelPackage.SYMBOLIC_TIMER__TIMEOUT_EVENT:
				return basicSetTimeoutEvent(null, msgs);
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
			case ModelPackage.SYMBOLIC_TIMER__TIMEOUT_EVENT:
				return getTimeoutEvent();
			case ModelPackage.SYMBOLIC_TIMER__NAME:
				return getName();
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
			case ModelPackage.SYMBOLIC_TIMER__TIMEOUT_EVENT:
				setTimeoutEvent((SymbolicTimeoutEvent)newValue);
				return;
			case ModelPackage.SYMBOLIC_TIMER__NAME:
				setName((String)newValue);
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
			case ModelPackage.SYMBOLIC_TIMER__TIMEOUT_EVENT:
				setTimeoutEvent((SymbolicTimeoutEvent)null);
				return;
			case ModelPackage.SYMBOLIC_TIMER__NAME:
				setName(NAME_EDEFAULT);
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
			case ModelPackage.SYMBOLIC_TIMER__TIMEOUT_EVENT:
				return timeoutEvent != null;
			case ModelPackage.SYMBOLIC_TIMER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SymbolicTimerImpl
