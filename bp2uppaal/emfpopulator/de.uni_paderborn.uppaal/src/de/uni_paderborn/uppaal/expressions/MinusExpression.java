/**
 */
package de.uni_paderborn.uppaal.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Minus Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An inversion of an integer-based expression using the '-' token.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.MinusExpression#getInvertedExpression <em>Inverted Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getMinusExpression()
 * @model
 * @generated
 */
public interface MinusExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Inverted Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression negated by this negation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inverted Expression</em>' containment reference.
	 * @see #setInvertedExpression(Expression)
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getMinusExpression_InvertedExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getInvertedExpression();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.expressions.MinusExpression#getInvertedExpression <em>Inverted Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inverted Expression</em>' containment reference.
	 * @see #getInvertedExpression()
	 * @generated
	 */
	void setInvertedExpression(Expression value);

} // MinusExpression
