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
import de.uni_paderborn.uppaal.expressions.PlusExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plus Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.impl.PlusExpressionImpl#getConfirmedExpression <em>Confirmed Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlusExpressionImpl extends ExpressionImpl implements PlusExpression {
	/**
	 * The cached value of the '{@link #getConfirmedExpression() <em>Confirmed Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfirmedExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression confirmedExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlusExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.PLUS_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getConfirmedExpression() {
		return confirmedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfirmedExpression(Expression newConfirmedExpression, NotificationChain msgs) {
		Expression oldConfirmedExpression = confirmedExpression;
		confirmedExpression = newConfirmedExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.PLUS_EXPRESSION__CONFIRMED_EXPRESSION, oldConfirmedExpression, newConfirmedExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfirmedExpression(Expression newConfirmedExpression) {
		if (newConfirmedExpression != confirmedExpression) {
			NotificationChain msgs = null;
			if (confirmedExpression != null)
				msgs = ((InternalEObject)confirmedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.PLUS_EXPRESSION__CONFIRMED_EXPRESSION, null, msgs);
			if (newConfirmedExpression != null)
				msgs = ((InternalEObject)newConfirmedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.PLUS_EXPRESSION__CONFIRMED_EXPRESSION, null, msgs);
			msgs = basicSetConfirmedExpression(newConfirmedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.PLUS_EXPRESSION__CONFIRMED_EXPRESSION, newConfirmedExpression, newConfirmedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.PLUS_EXPRESSION__CONFIRMED_EXPRESSION:
				return basicSetConfirmedExpression(null, msgs);
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
			case ExpressionsPackage.PLUS_EXPRESSION__CONFIRMED_EXPRESSION:
				return getConfirmedExpression();
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
			case ExpressionsPackage.PLUS_EXPRESSION__CONFIRMED_EXPRESSION:
				setConfirmedExpression((Expression)newValue);
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
			case ExpressionsPackage.PLUS_EXPRESSION__CONFIRMED_EXPRESSION:
				setConfirmedExpression((Expression)null);
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
			case ExpressionsPackage.PLUS_EXPRESSION__CONFIRMED_EXPRESSION:
				return confirmedExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //PlusExpressionImpl
