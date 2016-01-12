/**
 */
package de.uni_paderborn.uppaal.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uni_paderborn.uppaal.expressions.Expression;
import de.uni_paderborn.uppaal.expressions.ExpressionsPackage;
import de.uni_paderborn.uppaal.expressions.MinusExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Minus Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.impl.MinusExpressionImpl#getInvertedExpression <em>Inverted Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MinusExpressionImpl extends ExpressionImpl implements MinusExpression {
	/**
	 * The cached value of the '{@link #getInvertedExpression() <em>Inverted Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvertedExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression invertedExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MinusExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.MINUS_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getInvertedExpression() {
		return invertedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvertedExpression(Expression newInvertedExpression, NotificationChain msgs) {
		Expression oldInvertedExpression = invertedExpression;
		invertedExpression = newInvertedExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.MINUS_EXPRESSION__INVERTED_EXPRESSION, oldInvertedExpression, newInvertedExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvertedExpression(Expression newInvertedExpression) {
		if (newInvertedExpression != invertedExpression) {
			NotificationChain msgs = null;
			if (invertedExpression != null)
				msgs = ((InternalEObject)invertedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.MINUS_EXPRESSION__INVERTED_EXPRESSION, null, msgs);
			if (newInvertedExpression != null)
				msgs = ((InternalEObject)newInvertedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.MINUS_EXPRESSION__INVERTED_EXPRESSION, null, msgs);
			msgs = basicSetInvertedExpression(newInvertedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.MINUS_EXPRESSION__INVERTED_EXPRESSION, newInvertedExpression, newInvertedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.MINUS_EXPRESSION__INVERTED_EXPRESSION:
				return basicSetInvertedExpression(null, msgs);
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
			case ExpressionsPackage.MINUS_EXPRESSION__INVERTED_EXPRESSION:
				return getInvertedExpression();
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
			case ExpressionsPackage.MINUS_EXPRESSION__INVERTED_EXPRESSION:
				setInvertedExpression((Expression)newValue);
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
			case ExpressionsPackage.MINUS_EXPRESSION__INVERTED_EXPRESSION:
				setInvertedExpression((Expression)null);
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
			case ExpressionsPackage.MINUS_EXPRESSION__INVERTED_EXPRESSION:
				return invertedExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //MinusExpressionImpl
