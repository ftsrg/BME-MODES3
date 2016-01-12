/**
 */
package de.uni_paderborn.uppaal.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Abstract base class for all binary expressions connecting two sub-expressions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.BinaryExpression#getFirstExpr <em>First Expr</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.BinaryExpression#getSecondExpr <em>Second Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getBinaryExpression()
 * @model abstract="true"
 * @generated
 */
public interface BinaryExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>First Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The first sub-expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>First Expr</em>' containment reference.
	 * @see #setFirstExpr(Expression)
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getBinaryExpression_FirstExpr()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getFirstExpr();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.expressions.BinaryExpression#getFirstExpr <em>First Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Expr</em>' containment reference.
	 * @see #getFirstExpr()
	 * @generated
	 */
	void setFirstExpr(Expression value);

	/**
	 * Returns the value of the '<em><b>Second Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The second sub-expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Second Expr</em>' containment reference.
	 * @see #setSecondExpr(Expression)
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getBinaryExpression_SecondExpr()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getSecondExpr();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.expressions.BinaryExpression#getSecondExpr <em>Second Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Expr</em>' containment reference.
	 * @see #getSecondExpr()
	 * @generated
	 */
	void setSecondExpr(Expression value);

} // BinaryExpression
