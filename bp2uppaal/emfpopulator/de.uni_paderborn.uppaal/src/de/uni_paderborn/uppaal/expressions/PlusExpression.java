/**
 */
package de.uni_paderborn.uppaal.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plus Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A confirmation of an integer-based expression using the '+' token.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.PlusExpression#getConfirmedExpression <em>Confirmed Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getPlusExpression()
 * @model
 * @generated
 */
public interface PlusExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Confirmed Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression negated by this negation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Confirmed Expression</em>' containment reference.
	 * @see #setConfirmedExpression(Expression)
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getPlusExpression_ConfirmedExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getConfirmedExpression();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.expressions.PlusExpression#getConfirmedExpression <em>Confirmed Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confirmed Expression</em>' containment reference.
	 * @see #getConfirmedExpression()
	 * @generated
	 */
	void setConfirmedExpression(Expression value);

} // PlusExpression
