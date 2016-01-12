/**
 */
package de.uni_paderborn.uppaal.expressions;

import org.eclipse.emf.common.util.EList;

import de.uni_paderborn.uppaal.core.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression referring to a variable.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.IdentifierExpression#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.expressions.IdentifierExpression#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getIdentifierExpression()
 * @model
 * @generated
 */
public interface IdentifierExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referred variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Identifier</em>' reference.
	 * @see #setIdentifier(NamedElement)
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getIdentifierExpression_Identifier()
	 * @model required="true"
	 * @generated
	 */
	NamedElement getIdentifier();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.expressions.IdentifierExpression#getIdentifier <em>Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' reference.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' containment reference list.
	 * The list contents are of type {@link de.uni_paderborn.uppaal.expressions.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A set of expressions that refer to the array indexes of the variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Index</em>' containment reference list.
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getIdentifierExpression_Index()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getIndex();

} // IdentifierExpression
