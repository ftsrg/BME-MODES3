/**
 */
package de.uni_paderborn.uppaal.types.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uni_paderborn.uppaal.expressions.Expression;
import de.uni_paderborn.uppaal.types.ScalarTypeSpecification;
import de.uni_paderborn.uppaal.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scalar Type Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.types.impl.ScalarTypeSpecificationImpl#getSizeExpression <em>Size Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScalarTypeSpecificationImpl extends TypeSpecificationImpl implements ScalarTypeSpecification {
	/**
	 * The cached value of the '{@link #getSizeExpression() <em>Size Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression sizeExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScalarTypeSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.SCALAR_TYPE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getSizeExpression() {
		return sizeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSizeExpression(Expression newSizeExpression, NotificationChain msgs) {
		Expression oldSizeExpression = sizeExpression;
		sizeExpression = newSizeExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.SCALAR_TYPE_SPECIFICATION__SIZE_EXPRESSION, oldSizeExpression, newSizeExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeExpression(Expression newSizeExpression) {
		if (newSizeExpression != sizeExpression) {
			NotificationChain msgs = null;
			if (sizeExpression != null)
				msgs = ((InternalEObject)sizeExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.SCALAR_TYPE_SPECIFICATION__SIZE_EXPRESSION, null, msgs);
			if (newSizeExpression != null)
				msgs = ((InternalEObject)newSizeExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.SCALAR_TYPE_SPECIFICATION__SIZE_EXPRESSION, null, msgs);
			msgs = basicSetSizeExpression(newSizeExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.SCALAR_TYPE_SPECIFICATION__SIZE_EXPRESSION, newSizeExpression, newSizeExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.SCALAR_TYPE_SPECIFICATION__SIZE_EXPRESSION:
				return basicSetSizeExpression(null, msgs);
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
			case TypesPackage.SCALAR_TYPE_SPECIFICATION__SIZE_EXPRESSION:
				return getSizeExpression();
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
			case TypesPackage.SCALAR_TYPE_SPECIFICATION__SIZE_EXPRESSION:
				setSizeExpression((Expression)newValue);
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
			case TypesPackage.SCALAR_TYPE_SPECIFICATION__SIZE_EXPRESSION:
				setSizeExpression((Expression)null);
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
			case TypesPackage.SCALAR_TYPE_SPECIFICATION__SIZE_EXPRESSION:
				return sizeExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //ScalarTypeSpecificationImpl
