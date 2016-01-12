/**
 */
package de.uni_paderborn.uppaal.declarations.system.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import de.uni_paderborn.uppaal.declarations.system.InstantiationList;
import de.uni_paderborn.uppaal.declarations.system.SystemPackage;
import de.uni_paderborn.uppaal.templates.AbstractTemplate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instantiation List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.system.impl.InstantiationListImpl#getTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstantiationListImpl extends MinimalEObjectImpl.Container implements InstantiationList {
	/**
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractTemplate> template;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstantiationListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystemPackage.Literals.INSTANTIATION_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractTemplate> getTemplate() {
		if (template == null) {
			template = new EObjectResolvingEList<AbstractTemplate>(AbstractTemplate.class, this, SystemPackage.INSTANTIATION_LIST__TEMPLATE);
		}
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SystemPackage.INSTANTIATION_LIST__TEMPLATE:
				return getTemplate();
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
			case SystemPackage.INSTANTIATION_LIST__TEMPLATE:
				getTemplate().clear();
				getTemplate().addAll((Collection<? extends AbstractTemplate>)newValue);
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
			case SystemPackage.INSTANTIATION_LIST__TEMPLATE:
				getTemplate().clear();
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
			case SystemPackage.INSTANTIATION_LIST__TEMPLATE:
				return template != null && !template.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InstantiationListImpl
