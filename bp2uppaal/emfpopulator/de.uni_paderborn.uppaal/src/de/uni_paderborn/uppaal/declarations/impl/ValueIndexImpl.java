/**
 */
package de.uni_paderborn.uppaal.declarations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uni_paderborn.uppaal.declarations.DeclarationsPackage;
import de.uni_paderborn.uppaal.declarations.ValueIndex;
import de.uni_paderborn.uppaal.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Index</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.impl.ValueIndexImpl#getSizeExpression <em>Size Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueIndexImpl extends IndexImpl implements ValueIndex {
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
	protected ValueIndexImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeclarationsPackage.Literals.VALUE_INDEX;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeclarationsPackage.VALUE_INDEX__SIZE_EXPRESSION, oldSizeExpression, newSizeExpression);
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
				msgs = ((InternalEObject)sizeExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DeclarationsPackage.VALUE_INDEX__SIZE_EXPRESSION, null, msgs);
			if (newSizeExpression != null)
				msgs = ((InternalEObject)newSizeExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DeclarationsPackage.VALUE_INDEX__SIZE_EXPRESSION, null, msgs);
			msgs = basicSetSizeExpression(newSizeExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeclarationsPackage.VALUE_INDEX__SIZE_EXPRESSION, newSizeExpression, newSizeExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeclarationsPackage.VALUE_INDEX__SIZE_EXPRESSION:
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
			case DeclarationsPackage.VALUE_INDEX__SIZE_EXPRESSION:
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
			case DeclarationsPackage.VALUE_INDEX__SIZE_EXPRESSION:
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
			case DeclarationsPackage.VALUE_INDEX__SIZE_EXPRESSION:
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
			case DeclarationsPackage.VALUE_INDEX__SIZE_EXPRESSION:
				return sizeExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //ValueIndexImpl
