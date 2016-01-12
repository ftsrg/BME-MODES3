/**
 */
package de.uni_paderborn.uppaal.statements.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uni_paderborn.uppaal.expressions.Expression;
import de.uni_paderborn.uppaal.statements.IfStatement;
import de.uni_paderborn.uppaal.statements.Statement;
import de.uni_paderborn.uppaal.statements.StatementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.statements.impl.IfStatementImpl#getIfExpression <em>If Expression</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.statements.impl.IfStatementImpl#getThenStatement <em>Then Statement</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.statements.impl.IfStatementImpl#getElseStatement <em>Else Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfStatementImpl extends StatementImpl implements IfStatement {
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
	 * The cached value of the '{@link #getThenStatement() <em>Then Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenStatement()
	 * @generated
	 * @ordered
	 */
	protected Statement thenStatement;

	/**
	 * The cached value of the '{@link #getElseStatement() <em>Else Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseStatement()
	 * @generated
	 * @ordered
	 */
	protected Statement elseStatement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatementsPackage.Literals.IF_STATEMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementsPackage.IF_STATEMENT__IF_EXPRESSION, oldIfExpression, newIfExpression);
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
				msgs = ((InternalEObject)ifExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementsPackage.IF_STATEMENT__IF_EXPRESSION, null, msgs);
			if (newIfExpression != null)
				msgs = ((InternalEObject)newIfExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementsPackage.IF_STATEMENT__IF_EXPRESSION, null, msgs);
			msgs = basicSetIfExpression(newIfExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementsPackage.IF_STATEMENT__IF_EXPRESSION, newIfExpression, newIfExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getThenStatement() {
		return thenStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThenStatement(Statement newThenStatement, NotificationChain msgs) {
		Statement oldThenStatement = thenStatement;
		thenStatement = newThenStatement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementsPackage.IF_STATEMENT__THEN_STATEMENT, oldThenStatement, newThenStatement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThenStatement(Statement newThenStatement) {
		if (newThenStatement != thenStatement) {
			NotificationChain msgs = null;
			if (thenStatement != null)
				msgs = ((InternalEObject)thenStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementsPackage.IF_STATEMENT__THEN_STATEMENT, null, msgs);
			if (newThenStatement != null)
				msgs = ((InternalEObject)newThenStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementsPackage.IF_STATEMENT__THEN_STATEMENT, null, msgs);
			msgs = basicSetThenStatement(newThenStatement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementsPackage.IF_STATEMENT__THEN_STATEMENT, newThenStatement, newThenStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getElseStatement() {
		return elseStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseStatement(Statement newElseStatement, NotificationChain msgs) {
		Statement oldElseStatement = elseStatement;
		elseStatement = newElseStatement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementsPackage.IF_STATEMENT__ELSE_STATEMENT, oldElseStatement, newElseStatement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseStatement(Statement newElseStatement) {
		if (newElseStatement != elseStatement) {
			NotificationChain msgs = null;
			if (elseStatement != null)
				msgs = ((InternalEObject)elseStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementsPackage.IF_STATEMENT__ELSE_STATEMENT, null, msgs);
			if (newElseStatement != null)
				msgs = ((InternalEObject)newElseStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementsPackage.IF_STATEMENT__ELSE_STATEMENT, null, msgs);
			msgs = basicSetElseStatement(newElseStatement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementsPackage.IF_STATEMENT__ELSE_STATEMENT, newElseStatement, newElseStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatementsPackage.IF_STATEMENT__IF_EXPRESSION:
				return basicSetIfExpression(null, msgs);
			case StatementsPackage.IF_STATEMENT__THEN_STATEMENT:
				return basicSetThenStatement(null, msgs);
			case StatementsPackage.IF_STATEMENT__ELSE_STATEMENT:
				return basicSetElseStatement(null, msgs);
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
			case StatementsPackage.IF_STATEMENT__IF_EXPRESSION:
				return getIfExpression();
			case StatementsPackage.IF_STATEMENT__THEN_STATEMENT:
				return getThenStatement();
			case StatementsPackage.IF_STATEMENT__ELSE_STATEMENT:
				return getElseStatement();
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
			case StatementsPackage.IF_STATEMENT__IF_EXPRESSION:
				setIfExpression((Expression)newValue);
				return;
			case StatementsPackage.IF_STATEMENT__THEN_STATEMENT:
				setThenStatement((Statement)newValue);
				return;
			case StatementsPackage.IF_STATEMENT__ELSE_STATEMENT:
				setElseStatement((Statement)newValue);
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
			case StatementsPackage.IF_STATEMENT__IF_EXPRESSION:
				setIfExpression((Expression)null);
				return;
			case StatementsPackage.IF_STATEMENT__THEN_STATEMENT:
				setThenStatement((Statement)null);
				return;
			case StatementsPackage.IF_STATEMENT__ELSE_STATEMENT:
				setElseStatement((Statement)null);
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
			case StatementsPackage.IF_STATEMENT__IF_EXPRESSION:
				return ifExpression != null;
			case StatementsPackage.IF_STATEMENT__THEN_STATEMENT:
				return thenStatement != null;
			case StatementsPackage.IF_STATEMENT__ELSE_STATEMENT:
				return elseStatement != null;
		}
		return super.eIsSet(featureID);
	}

} //IfStatementImpl
