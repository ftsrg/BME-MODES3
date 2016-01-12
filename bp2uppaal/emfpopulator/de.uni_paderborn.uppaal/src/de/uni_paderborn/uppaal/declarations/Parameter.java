/**
 */
package de.uni_paderborn.uppaal.declarations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A parameter of a function or template.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.Parameter#getVariableDeclaration <em>Variable Declaration</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.Parameter#getCallType <em>Call Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getParameter()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL SingleVariable='(not self.variableDeclaration.oclIsUndefined())\r\nimplies\r\nself.variableDeclaration.variable->size() <= 1'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SingleVariable'"
 * @generated
 */
public interface Parameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A variable declaration containing the variable that represents the parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable Declaration</em>' containment reference.
	 * @see #setVariableDeclaration(VariableDeclaration)
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getParameter_VariableDeclaration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableDeclaration getVariableDeclaration();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.declarations.Parameter#getVariableDeclaration <em>Variable Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Declaration</em>' containment reference.
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	void setVariableDeclaration(VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Call Type</b></em>' attribute.
	 * The default value is <code>"CALL_BY_VALUE"</code>.
	 * The literals are from the enumeration {@link de.uni_paderborn.uppaal.declarations.CallType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies whether call-by-value or call-by-reference semantics should be applied.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Call Type</em>' attribute.
	 * @see de.uni_paderborn.uppaal.declarations.CallType
	 * @see #setCallType(CallType)
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getParameter_CallType()
	 * @model default="CALL_BY_VALUE"
	 * @generated
	 */
	CallType getCallType();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.declarations.Parameter#getCallType <em>Call Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Type</em>' attribute.
	 * @see de.uni_paderborn.uppaal.declarations.CallType
	 * @see #getCallType()
	 * @generated
	 */
	void setCallType(CallType value);

} // Parameter
