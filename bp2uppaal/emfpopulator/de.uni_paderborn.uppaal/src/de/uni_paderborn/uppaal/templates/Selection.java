/**
 */
package de.uni_paderborn.uppaal.templates;

import de.uni_paderborn.uppaal.declarations.VariableContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A non-deterministic selection of a value from a range. The range is specified by a bounded type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.templates.Selection#getSelectStatement <em>Select Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.templates.TemplatesPackage#getSelection()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL SingleVariable='self.variable->size() <= 1' IntegerBasedType='(not self.typeDefinition.oclIsUndefined())\r\nimplies\r\nself.typeDefinition.baseType = types::BuiltInType::INT'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SingleVariable IntegerBasedType'"
 * @generated
 */
public interface Selection extends VariableContainer {

	/**
	 * Returns the value of the '<em><b>Select Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Select Statement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Select Statement</em>' attribute.
	 * @see #setSelectStatement(String)
	 * @see de.uni_paderborn.uppaal.templates.TemplatesPackage#getSelection_SelectStatement()
	 * @model
	 * @generated
	 */
	String getSelectStatement();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.templates.Selection#getSelectStatement <em>Select Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Select Statement</em>' attribute.
	 * @see #getSelectStatement()
	 * @generated
	 */
	void setSelectStatement(String value);
} // Selection
