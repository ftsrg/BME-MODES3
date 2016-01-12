/**
 */
package de.uni_paderborn.uppaal.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uni_paderborn.uppaal.expressions.BinaryExpression;
import de.uni_paderborn.uppaal.expressions.Expression;
import de.uni_paderborn.uppaal.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.impl.BinaryExpressionImpl#getFirstExpr <em>First Expr</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.impl.BinaryExpressionImpl#getSecondExpr <em>Second Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BinaryExpressionImpl extends ExpressionImpl implements BinaryExpression {
	/**
	 * The cached value of the '{@link #getFirstExpr() <em>First Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstExpr()
	 * @generated
	 * @ordered
	 */
	protected Expression firstExpr;

	/**
	 * The cached value of the '{@link #getSecondExpr() <em>Second Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondExpr()
	 * @generated
	 * @ordered
	 */
	protected Expression secondExpr;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.BINARY_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getFirstExpr() {
		return firstExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstExpr(Expression newFirstExpr, NotificationChain msgs) {
		Expression oldFirstExpr = firstExpr;
		firstExpr = newFirstExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.BINARY_EXPRESSION__FIRST_EXPR, oldFirstExpr, newFirstExpr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstExpr(Expression newFirstExpr) {
		if (newFirstExpr != firstExpr) {
			NotificationChain msgs = null;
			if (firstExpr != null)
				msgs = ((InternalEObject)firstExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.BINARY_EXPRESSION__FIRST_EXPR, null, msgs);
			if (newFirstExpr != null)
				msgs = ((InternalEObject)newFirstExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.BINARY_EXPRESSION__FIRST_EXPR, null, msgs);
			msgs = basicSetFirstExpr(newFirstExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.BINARY_EXPRESSION__FIRST_EXPR, newFirstExpr, newFirstExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getSecondExpr() {
		return secondExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecondExpr(Expression newSecondExpr, NotificationChain msgs) {
		Expression oldSecondExpr = secondExpr;
		secondExpr = newSecondExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.BINARY_EXPRESSION__SECOND_EXPR, oldSecondExpr, newSecondExpr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondExpr(Expression newSecondExpr) {
		if (newSecondExpr != secondExpr) {
			NotificationChain msgs = null;
			if (secondExpr != null)
				msgs = ((InternalEObject)secondExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.BINARY_EXPRESSION__SECOND_EXPR, null, msgs);
			if (newSecondExpr != null)
				msgs = ((InternalEObject)newSecondExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.BINARY_EXPRESSION__SECOND_EXPR, null, msgs);
			msgs = basicSetSecondExpr(newSecondExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.BINARY_EXPRESSION__SECOND_EXPR, newSecondExpr, newSecondExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.BINARY_EXPRESSION__FIRST_EXPR:
				return basicSetFirstExpr(null, msgs);
			case ExpressionsPackage.BINARY_EXPRESSION__SECOND_EXPR:
				return basicSetSecondExpr(null, msgs);
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
			case ExpressionsPackage.BINARY_EXPRESSION__FIRST_EXPR:
				return getFirstExpr();
			case ExpressionsPackage.BINARY_EXPRESSION__SECOND_EXPR:
				return getSecondExpr();
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
			case ExpressionsPackage.BINARY_EXPRESSION__FIRST_EXPR:
				setFirstExpr((Expression)newValue);
				return;
			case ExpressionsPackage.BINARY_EXPRESSION__SECOND_EXPR:
				setSecondExpr((Expression)newValue);
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
			case ExpressionsPackage.BINARY_EXPRESSION__FIRST_EXPR:
				setFirstExpr((Expression)null);
				return;
			case ExpressionsPackage.BINARY_EXPRESSION__SECOND_EXPR:
				setSecondExpr((Expression)null);
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
			case ExpressionsPackage.BINARY_EXPRESSION__FIRST_EXPR:
				return firstExpr != null;
			case ExpressionsPackage.BINARY_EXPRESSION__SECOND_EXPR:
				return secondExpr != null;
		}
		return super.eIsSet(featureID);
	}

} //BinaryExpressionImpl
