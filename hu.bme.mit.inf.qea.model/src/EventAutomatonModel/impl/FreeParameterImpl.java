/**
 */
package EventAutomatonModel.impl;

import EventAutomatonModel.EventAutomatonModelPackage;
import EventAutomatonModel.FreeParameter;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Free Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.impl.FreeParameterImpl#getExcludedValues <em>Excluded Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FreeParameterImpl extends ParameterImpl implements FreeParameter {
	/**
	 * The cached value of the '{@link #getExcludedValues() <em>Excluded Values</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExcludedValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> excludedValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FreeParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventAutomatonModelPackage.Literals.FREE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getExcludedValues() {
		if (excludedValues == null) {
			excludedValues = new EDataTypeUniqueEList<Object>(Object.class, this, EventAutomatonModelPackage.FREE_PARAMETER__EXCLUDED_VALUES);
		}
		return excludedValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventAutomatonModelPackage.FREE_PARAMETER__EXCLUDED_VALUES:
				return getExcludedValues();
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
			case EventAutomatonModelPackage.FREE_PARAMETER__EXCLUDED_VALUES:
				getExcludedValues().clear();
				getExcludedValues().addAll((Collection<? extends Object>)newValue);
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
			case EventAutomatonModelPackage.FREE_PARAMETER__EXCLUDED_VALUES:
				getExcludedValues().clear();
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
			case EventAutomatonModelPackage.FREE_PARAMETER__EXCLUDED_VALUES:
				return excludedValues != null && !excludedValues.isEmpty();
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
		result.append(" (excludedValues: ");
		result.append(excludedValues);
		result.append(')');
		return result.toString();
	}

} //FreeParameterImpl
