/**
 */
package de.uni_paderborn.uppaal.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Increment Decrement Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression describing increment (++) or decrement (---) of an integer-based expression. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression#getPosition <em>Position</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getIncrementDecrementExpression()
 * @model
 * @generated
 */
public interface IncrementDecrementExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression to be incremented or decremented.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getIncrementDecrementExpression_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uni_paderborn.uppaal.expressions.IncrementDecrementPosition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies pre- or post-evaluation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see de.uni_paderborn.uppaal.expressions.IncrementDecrementPosition
	 * @see #setPosition(IncrementDecrementPosition)
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getIncrementDecrementExpression_Position()
	 * @model required="true"
	 * @generated
	 */
	IncrementDecrementPosition getPosition();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see de.uni_paderborn.uppaal.expressions.IncrementDecrementPosition
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(IncrementDecrementPosition value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uni_paderborn.uppaal.expressions.IncrementDecrementOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies increment or decrement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see de.uni_paderborn.uppaal.expressions.IncrementDecrementOperator
	 * @see #setOperator(IncrementDecrementOperator)
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getIncrementDecrementExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	IncrementDecrementOperator getOperator();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see de.uni_paderborn.uppaal.expressions.IncrementDecrementOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(IncrementDecrementOperator value);

} // IncrementDecrementExpression
