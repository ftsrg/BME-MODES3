/**
 */
package de.uni_paderborn.uppaal.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uni_paderborn.uppaal.expressions.ConditionExpression;
import de.uni_paderborn.uppaal.expressions.Expression;
import de.uni_paderborn.uppaal.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.impl.ConditionExpressionImpl#getIfExpression <em>If Expression</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.impl.ConditionExpressionImpl#getThenExpression <em>Then Expression</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.impl.ConditionExpressionImpl#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionExpressionImpl extends ExpressionImpl implements ConditionExpression {
	/**
	 * The cached value of the '{@link #getIfExpression() <em>If Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression ifExpression;

	/**
	 * The cached value of the '{@link #getThenExpression() <em>Then Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression thenExpression;

	/**
	 * The cached value of the '{@link #getElseExpression() <em>Else Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression elseExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.CONDITION_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getIfExpression() {
		return ifExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIfExpression(Expression newIfExpression, NotificationChain msgs) {
		Expression oldIfExpression = ifExpression;
		ifExpression = newIfExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CONDITION_EXPRESSION__IF_EXPRESSION, oldIfExpression, newIfExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfExpression(Expression newIfExpression) {
		if (newIfExpression != ifExpression) {
			NotificationChain msgs = null;
			if (ifExpression != null)
				msgs = ((InternalEObject)ifExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CONDITION_EXPRESSION__IF_EXPRESSION, null, msgs);
			if (newIfExpression != null)
				msgs = ((InternalEObject)newIfExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CONDITION_EXPRESSION__IF_EXPRESSION, null, msgs);
			msgs = basicSetIfExpression(newIfExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CONDITION_EXPRESSION__IF_EXPRESSION, newIfExpression, newIfExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getThenExpression() {
		return thenExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThenExpression(Expression newThenExpression, NotificationChain msgs) {
		Expression oldThenExpression = thenExpression;
		thenExpression = newThenExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CONDITION_EXPRESSION__THEN_EXPRESSION, oldThenExpression, newThenExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThenExpression(Expression newThenExpression) {
		if (newThenExpression != thenExpression) {
			NotificationChain msgs = null;
			if (thenExpression != null)
				msgs = ((InternalEObject)thenExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CONDITION_EXPRESSION__THEN_EXPRESSION, null, msgs);
			if (newThenExpression != null)
				msgs = ((InternalEObject)newThenExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CONDITION_EXPRESSION__THEN_EXPRESSION, null, msgs);
			msgs = basicSetThenExpression(newThenExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CONDITION_EXPRESSION__THEN_EXPRESSION, newThenExpression, newThenExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getElseExpression() {
		return elseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseExpression(Expression newElseExpression, NotificationChain msgs) {
		Expression oldElseExpression = elseExpression;
		elseExpression = newElseExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CONDITION_EXPRESSION__ELSE_EXPRESSION, oldElseExpression, newElseExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseExpression(Expression newElseExpression) {
		if (newElseExpression != elseExpression) {
			NotificationChain msgs = null;
			if (elseExpression != null)
				msgs = ((InternalEObject)elseExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CONDITION_EXPRESSION__ELSE_EXPRESSION, null, msgs);
			if (newElseExpression != null)
				msgs = ((InternalEObject)newElseExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CONDITION_EXPRESSION__ELSE_EXPRESSION, null, msgs);
			msgs = basicSetElseExpression(newElseExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CONDITION_EXPRESSION__ELSE_EXPRESSION, newElseExpression, newElseExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.CONDITION_EXPRESSION__IF_EXPRESSION:
				return basicSetIfExpression(null, msgs);
			case ExpressionsPackage.CONDITION_EXPRESSION__THEN_EXPRESSION:
				return basicSetThenExpression(null, msgs);
			case ExpressionsPackage.CONDITION_EXPRESSION__ELSE_EXPRESSION:
				return basicSetElseExpression(null, msgs);
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
			case ExpressionsPackage.CONDITION_EXPRESSION__IF_EXPRESSION:
				return getIfExpression();
			case ExpressionsPackage.CONDITION_EXPRESSION__THEN_EXPRESSION:
				return getThenExpression();
			case ExpressionsPackage.CONDITION_EXPRESSION__ELSE_EXPRESSION:
				return getElseExpression();
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
			case ExpressionsPackage.CONDITION_EXPRESSION__IF_EXPRESSION:
				setIfExpression((Expression)newValue);
				return;
			case ExpressionsPackage.CONDITION_EXPRESSION__THEN_EXPRESSION:
				setThenExpression((Expression)newValue);
				return;
			case ExpressionsPackage.CONDITION_EXPRESSION__ELSE_EXPRESSION:
				setElseExpression((Expression)newValue);
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
			case ExpressionsPackage.CONDITION_EXPRESSION__IF_EXPRESSION:
				setIfExpression((Expression)null);
				return;
			case ExpressionsPackage.CONDITION_EXPRESSION__THEN_EXPRESSION:
				setThenExpression((Expression)null);
				return;
			case ExpressionsPackage.CONDITION_EXPRESSION__ELSE_EXPRESSION:
				setElseExpression((Expression)null);
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
			case ExpressionsPackage.CONDITION_EXPRESSION__IF_EXPRESSION:
				return ifExpression != null;
			case ExpressionsPackage.CONDITION_EXPRESSION__THEN_EXPRESSION:
				return thenExpression != null;
			case ExpressionsPackage.CONDITION_EXPRESSION__ELSE_EXPRESSION:
				return elseExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //ConditionExpressionImpl
