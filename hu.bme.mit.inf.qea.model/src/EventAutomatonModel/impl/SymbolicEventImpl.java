/**
 */
package EventAutomatonModel.impl;

import EventAutomatonModel.EventAutomatonModelPackage;
import EventAutomatonModel.SymbolicEvent;
import EventAutomatonModel.SymbolicParameter;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Symbolic Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.impl.SymbolicEventImpl#getSymbolicParameters <em>Symbolic Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SymbolicEventImpl extends MinimalEObjectImpl.Container implements SymbolicEvent {
	/**
	 * The cached value of the '{@link #getSymbolicParameters() <em>Symbolic Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbolicParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<SymbolicParameter> symbolicParameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SymbolicEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventAutomatonModelPackage.Literals.SYMBOLIC_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SymbolicParameter> getSymbolicParameters() {
		if (symbolicParameters == null) {
			symbolicParameters = new EObjectContainmentEList<SymbolicParameter>(SymbolicParameter.class, this, EventAutomatonModelPackage.SYMBOLIC_EVENT__SYMBOLIC_PARAMETERS);
		}
		return symbolicParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventAutomatonModelPackage.SYMBOLIC_EVENT__SYMBOLIC_PARAMETERS:
				return ((InternalEList<?>)getSymbolicParameters()).basicRemove(otherEnd, msgs);
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
			case EventAutomatonModelPackage.SYMBOLIC_EVENT__SYMBOLIC_PARAMETERS:
				return getSymbolicParameters();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EventAutomatonModelPackage.SYMBOLIC_EVENT__SYMBOLIC_PARAMETERS:
				getSymbolicParameters().clear();
				getSymbolicParameters().addAll((Collection<? extends SymbolicParameter>)newValue);
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
			case EventAutomatonModelPackage.SYMBOLIC_EVENT__SYMBOLIC_PARAMETERS:
				getSymbolicParameters().clear();
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
			case EventAutomatonModelPackage.SYMBOLIC_EVENT__SYMBOLIC_PARAMETERS:
				return symbolicParameters != null && !symbolicParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SymbolicEventImpl
