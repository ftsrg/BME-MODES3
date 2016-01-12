/**
 */
package de.uni_paderborn.uppaal.types.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uni_paderborn.uppaal.declarations.DeclarationsPackage;
import de.uni_paderborn.uppaal.declarations.TypeDeclaration;
import de.uni_paderborn.uppaal.types.DeclaredType;
import de.uni_paderborn.uppaal.types.TypeDefinition;
import de.uni_paderborn.uppaal.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declared Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.types.impl.DeclaredTypeImpl#getTypeDeclaration <em>Type Declaration</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.types.impl.DeclaredTypeImpl#getTypeDefinition <em>Type Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeclaredTypeImpl extends TypeImpl implements DeclaredType {
	/**
	 * The cached setting delegate for the '{@link #getTypeDefinition() <em>Type Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeDefinition()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate TYPE_DEFINITION__ESETTING_DELEGATE = ((EStructuralFeature.Internal)TypesPackage.Literals.DECLARED_TYPE__TYPE_DEFINITION).getSettingDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclaredTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.DECLARED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeDeclaration getTypeDeclaration() {
		if (eContainerFeatureID() != TypesPackage.DECLARED_TYPE__TYPE_DECLARATION) return null;
		return (TypeDeclaration)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeDeclaration(TypeDeclaration newTypeDeclaration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTypeDeclaration, TypesPackage.DECLARED_TYPE__TYPE_DECLARATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeDeclaration(TypeDeclaration newTypeDeclaration) {
		if (newTypeDeclaration != eInternalContainer() || (eContainerFeatureID() != TypesPackage.DECLARED_TYPE__TYPE_DECLARATION && newTypeDeclaration != null)) {
			if (EcoreUtil.isAncestor(this, newTypeDeclaration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTypeDeclaration != null)
				msgs = ((InternalEObject)newTypeDeclaration).eInverseAdd(this, DeclarationsPackage.TYPE_DECLARATION__TYPE, TypeDeclaration.class, msgs);
			msgs = basicSetTypeDeclaration(newTypeDeclaration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.DECLARED_TYPE__TYPE_DECLARATION, newTypeDeclaration, newTypeDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeDefinition getTypeDefinition() {
		return (TypeDefinition)TYPE_DEFINITION__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeDefinition basicGetTypeDefinition() {
		return (TypeDefinition)TYPE_DEFINITION__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.DECLARED_TYPE__TYPE_DECLARATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTypeDeclaration((TypeDeclaration)otherEnd, msgs);
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
			case TypesPackage.DECLARED_TYPE__TYPE_DECLARATION:
				return basicSetTypeDeclaration(null, msgs);
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
			case TypesPackage.DECLARED_TYPE__TYPE_DECLARATION:
				return eInternalContainer().eInverseRemove(this, DeclarationsPackage.TYPE_DECLARATION__TYPE, TypeDeclaration.class, msgs);
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
			case TypesPackage.DECLARED_TYPE__TYPE_DECLARATION:
				return getTypeDeclaration();
			case TypesPackage.DECLARED_TYPE__TYPE_DEFINITION:
				if (resolve) return getTypeDefinition();
				return basicGetTypeDefinition();
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
			case TypesPackage.DECLARED_TYPE__TYPE_DECLARATION:
				setTypeDeclaration((TypeDeclaration)newValue);
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
			case TypesPackage.DECLARED_TYPE__TYPE_DECLARATION:
				setTypeDeclaration((TypeDeclaration)null);
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
			case TypesPackage.DECLARED_TYPE__TYPE_DECLARATION:
				return getTypeDeclaration() != null;
			case TypesPackage.DECLARED_TYPE__TYPE_DEFINITION:
				return TYPE_DEFINITION__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

} //DeclaredTypeImpl
