/**
 */
package de.uni_paderborn.uppaal.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scoped Identifier Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression used to access a scoped identifier. Uses a dot for delimination between scope and identifier.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.ScopedIdentifierExpression#getScope <em>Scope</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.ScopedIdentifierExpression#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getScopedIdentifierExpression()
 * @model
 * @generated
 */
public interface ScopedIdentifierExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An expression that refers to a certain identifier scope.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scope</em>' containment reference.
	 * @see #setScope(Expression)
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getScopedIdentifierExpression_Scope()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getScope();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.expressions.ScopedIdentifierExpression#getScope <em>Scope</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' containment reference.
	 * @see #getScope()
	 * @generated
	 */
	void setScope(Expression value);

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An expression that refers to a member of the scope.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Identifier</em>' containment reference.
	 * @see #setIdentifier(IdentifierExpression)
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getScopedIdentifierExpression_Identifier()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IdentifierExpression getIdentifier();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.expressions.ScopedIdentifierExpression#getIdentifier <em>Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' containment reference.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(IdentifierExpression value);

} // ScopedIdentifierExpression
