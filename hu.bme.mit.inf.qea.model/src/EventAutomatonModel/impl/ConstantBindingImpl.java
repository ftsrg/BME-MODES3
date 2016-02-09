/**
 */
package EventAutomatonModel.impl;

import EventAutomatonModel.ConstantBinding;
import EventAutomatonModel.EventAutomatonModelPackage;
import EventAutomatonModel.FixParameter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constant Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.impl.ConstantBindingImpl#getBoundTo <em>Bound To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstantBindingImpl extends BindingImpl implements ConstantBinding {
	/**
	 * The cached value of the '{@link #getBoundTo() <em>Bound To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundTo()
	 * @generated
	 * @ordered
	 */
	protected FixParameter boundTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstantBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventAutomatonModelPackage.Literals.CONSTANT_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixParameter getBoundTo() {
		return boundTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBoundTo(FixParameter newBoundTo, NotificationChain msgs) {
		FixParameter oldBoundTo = boundTo;
		boundTo = newBoundTo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventAutomatonModelPackage.CONSTANT_BINDING__BOUND_TO, oldBoundTo, newBoundTo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundTo(FixParameter newBoundTo) {
		if (newBoundTo != boundTo) {
			NotificationChain msgs = null;
			if (boundTo != null)
				msgs = ((InternalEObject)boundTo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventAutomatonModelPackage.CONSTANT_BINDING__BOUND_TO, null, msgs);
			if (newBoundTo != null)
				msgs = ((InternalEObject)newBoundTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventAutomatonModelPackage.CONSTANT_BINDING__BOUND_TO, null, msgs);
			msgs = basicSetBoundTo(newBoundTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventAutomatonModelPackage.CONSTANT_BINDING__BOUND_TO, newBoundTo, newBoundTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventAutomatonModelPackage.CONSTANT_BINDING__BOUND_TO:
				return basicSetBoundTo(null, msgs);
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
			case EventAutomatonModelPackage.CONSTANT_BINDING__BOUND_TO:
				return getBoundTo();
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
			case EventAutomatonModelPackage.CONSTANT_BINDING__BOUND_TO:
				setBoundTo((FixParameter)newValue);
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
			case EventAutomatonModelPackage.CONSTANT_BINDING__BOUND_TO:
				setBoundTo((FixParameter)null);
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
			case EventAutomatonModelPackage.CONSTANT_BINDING__BOUND_TO:
				return boundTo != null;
		}
		return super.eIsSet(featureID);
	}

} //ConstantBindingImpl
