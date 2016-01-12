/**
 */
package de.uni_paderborn.uppaal.declarations;

import de.uni_paderborn.uppaal.types.TypeDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Index</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An index specified by a bounded integer-based type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.TypeIndex#getTypeDefinition <em>Type Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getTypeIndex()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL IntegerBasedIndex='(not self.typeDefinition.oclIsUndefined())\r\nimplies\r\nself.typeDefinition.baseType = types::BuiltInType::INT'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='IntegerBasedIndex'"
 * @generated
 */
public interface TypeIndex extends Index {
	/**
	 * Returns the value of the '<em><b>Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An integer-based type representing size and range of the indexed type or variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Definition</em>' containment reference.
	 * @see #setTypeDefinition(TypeDefinition)
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getTypeIndex_TypeDefinition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypeDefinition getTypeDefinition();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.declarations.TypeIndex#getTypeDefinition <em>Type Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Definition</em>' containment reference.
	 * @see #getTypeDefinition()
	 * @generated
	 */
	void setTypeDefinition(TypeDefinition value);

} // TypeIndex
