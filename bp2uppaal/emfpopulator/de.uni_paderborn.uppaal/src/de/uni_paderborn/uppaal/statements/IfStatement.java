/**
 */
package de.uni_paderborn.uppaal.statements;

import de.uni_paderborn.uppaal.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An if-then-else statement.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.statements.IfStatement#getIfExpression <em>If Expression</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.statements.IfStatement#getThenStatement <em>Then Statement</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.statements.IfStatement#getElseStatement <em>Else Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.statements.StatementsPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>If Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The boolean if-expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>If Expression</em>' containment reference.
	 * @see #setIfExpression(Expression)
	 * @see de.uni_paderborn.uppaal.statements.StatementsPackage#getIfStatement_IfExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getIfExpression();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.statements.IfStatement#getIfExpression <em>If Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If Expression</em>' containment reference.
	 * @see #getIfExpression()
	 * @generated
	 */
	void setIfExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Then Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The then-statement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Then Statement</em>' containment reference.
	 * @see #setThenStatement(Statement)
	 * @see de.uni_paderborn.uppaal.statements.StatementsPackage#getIfStatement_ThenStatement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Statement getThenStatement();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.statements.IfStatement#getThenStatement <em>Then Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Statement</em>' containment reference.
	 * @see #getThenStatement()
	 * @generated
	 */
	void setThenStatement(Statement value);

	/**
	 * Returns the value of the '<em><b>Else Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The else-statement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Else Statement</em>' containment reference.
	 * @see #setElseStatement(Statement)
	 * @see de.uni_paderborn.uppaal.statements.StatementsPackage#getIfStatement_ElseStatement()
	 * @model containment="true"
	 * @generated
	 */
	Statement getElseStatement();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.statements.IfStatement#getElseStatement <em>Else Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Statement</em>' containment reference.
	 * @see #getElseStatement()
	 * @generated
	 */
	void setElseStatement(Statement value);

} // IfStatement
