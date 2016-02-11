/**
 */
package EventAutomatonModel.impl;

import EventAutomatonModel.EventAutomatonModelPackage;
import EventAutomatonModel.SymbolicTokenParameter;
import EventAutomatonModel.TokenParameterBinding;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Token Parameter Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.impl.TokenParameterBindingImpl#getBoundTo <em>Bound To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TokenParameterBindingImpl extends BindingImpl implements TokenParameterBinding {
	/**
	 * The cached value of the '{@link #getBoundTo() <em>Bound To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundTo()
	 * @generated
	 * @ordered
	 */
	protected SymbolicTokenParameter boundTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TokenParameterBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventAutomatonModelPackage.Literals.TOKEN_PARAMETER_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolicTokenParameter getBoundTo() {
		if (boundTo != null && boundTo.eIsProxy()) {
			InternalEObject oldBoundTo = (InternalEObject)boundTo;
			boundTo = (SymbolicTokenParameter)eResolveProxy(oldBoundTo);
			if (boundTo != oldBoundTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventAutomatonModelPackage.TOKEN_PARAMETER_BINDING__BOUND_TO, oldBoundTo, boundTo));
			}
		}
		return boundTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolicTokenParameter basicGetBoundTo() {
		return boundTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundTo(SymbolicTokenParameter newBoundTo) {
		SymbolicTokenParameter oldBoundTo = boundTo;
		boundTo = newBoundTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventAutomatonModelPackage.TOKEN_PARAMETER_BINDING__BOUND_TO, oldBoundTo, boundTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventAutomatonModelPackage.TOKEN_PARAMETER_BINDING__BOUND_TO:
				if (resolve) return getBoundTo();
				return basicGetBoundTo();
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
			case EventAutomatonModelPackage.TOKEN_PARAMETER_BINDING__BOUND_TO:
				setBoundTo((SymbolicTokenParameter)newValue);
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
			case EventAutomatonModelPackage.TOKEN_PARAMETER_BINDING__BOUND_TO:
				setBoundTo((SymbolicTokenParameter)null);
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
			case EventAutomatonModelPackage.TOKEN_PARAMETER_BINDING__BOUND_TO:
				return boundTo != null;
		}
		return super.eIsSet(featureID);
	}

} //TokenParameterBindingImpl
