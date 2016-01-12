/**
 */
package de.uni_paderborn.uppaal.statements;

import de.uni_paderborn.uppaal.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Return Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A statement used to return from a function's body, optionally carrying a return value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.statements.ReturnStatement#getReturnExpression <em>Return Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.statements.StatementsPackage#getReturnStatement()
 * @model
 * @generated
 */
public interface ReturnStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Return Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression representing the return value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Return Expression</em>' containment reference.
	 * @see #setReturnExpression(Expression)
	 * @see de.uni_paderborn.uppaal.statements.StatementsPackage#getReturnStatement_ReturnExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getReturnExpression();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.statements.ReturnStatement#getReturnExpression <em>Return Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Expression</em>' containment reference.
	 * @see #getReturnExpression()
	 * @generated
	 */
	void setReturnExpression(Expression value);

} // ReturnStatement
