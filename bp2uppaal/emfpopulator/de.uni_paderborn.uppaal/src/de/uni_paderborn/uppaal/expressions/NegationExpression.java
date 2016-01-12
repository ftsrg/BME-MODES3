/**
 */
package de.uni_paderborn.uppaal.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Negation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A negation of an expression.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.NegationExpression#getNegatedExpression <em>Negated Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getNegationExpression()
 * @model
 * @generated
 */
public interface NegationExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Negated Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression negated by this negation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Negated Expression</em>' containment reference.
	 * @see #setNegatedExpression(Expression)
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getNegationExpression_NegatedExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getNegatedExpression();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.expressions.NegationExpression#getNegatedExpression <em>Negated Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Negated Expression</em>' containment reference.
	 * @see #getNegatedExpression()
	 * @generated
	 */
	void setNegatedExpression(Expression value);

} // NegationExpression
