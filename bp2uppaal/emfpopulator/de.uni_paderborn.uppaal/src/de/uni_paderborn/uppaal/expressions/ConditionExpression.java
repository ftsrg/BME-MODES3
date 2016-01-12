/**
 */
package de.uni_paderborn.uppaal.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression representing a conditional redirection to one of the sub-expressions. Uses tokens '?' and ':' for delimitation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.ConditionExpression#getIfExpression <em>If Expression</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.ConditionExpression#getThenExpression <em>Then Expression</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.ConditionExpression#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getConditionExpression()
 * @model
 * @generated
 */
public interface ConditionExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>If Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The boolean if-expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>If Expression</em>' containment reference.
	 * @see #setIfExpression(Expression)
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getConditionExpression_IfExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getIfExpression();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.expressions.ConditionExpression#getIfExpression <em>If Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If Expression</em>' containment reference.
	 * @see #getIfExpression()
	 * @generated
	 */
	void setIfExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The then-expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Then Expression</em>' containment reference.
	 * @see #setThenExpression(Expression)
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getConditionExpression_ThenExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getThenExpression();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.expressions.ConditionExpression#getThenExpression <em>Then Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Expression</em>' containment reference.
	 * @see #getThenExpression()
	 * @generated
	 */
	void setThenExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The else-expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Else Expression</em>' containment reference.
	 * @see #setElseExpression(Expression)
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getConditionExpression_ElseExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getElseExpression();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.expressions.ConditionExpression#getElseExpression <em>Else Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Expression</em>' containment reference.
	 * @see #getElseExpression()
	 * @generated
	 */
	void setElseExpression(Expression value);

} // ConditionExpression
