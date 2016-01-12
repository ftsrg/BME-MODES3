/**
 */
package de.uni_paderborn.uppaal.types;

import de.uni_paderborn.uppaal.declarations.TypeDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declared Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A user-declared type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.types.DeclaredType#getTypeDeclaration <em>Type Declaration</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.types.DeclaredType#getTypeDefinition <em>Type Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.types.TypesPackage#getDeclaredType()
 * @model
 * @generated
 */
public interface DeclaredType extends Type {
	/**
	 * Returns the value of the '<em><b>Type Declaration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uni_paderborn.uppaal.declarations.TypeDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The declaration that declares this type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Declaration</em>' container reference.
	 * @see #setTypeDeclaration(TypeDeclaration)
	 * @see de.uni_paderborn.uppaal.types.TypesPackage#getDeclaredType_TypeDeclaration()
	 * @see de.uni_paderborn.uppaal.declarations.TypeDeclaration#getType
	 * @model opposite="type" required="true" transient="false"
	 * @generated
	 */
	TypeDeclaration getTypeDeclaration();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.types.DeclaredType#getTypeDeclaration <em>Type Declaration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Declaration</em>' container reference.
	 * @see #getTypeDeclaration()
	 * @generated
	 */
	void setTypeDeclaration(TypeDeclaration value);

	/**
	 * Returns the value of the '<em><b>Type Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The definition of the declared type. Usually a type specification, but can also be a type reference to a "renamed" type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Definition</em>' reference.
	 * @see de.uni_paderborn.uppaal.types.TypesPackage#getDeclaredType_TypeDefinition()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='if self.typeDeclaration.oclIsUndefined()\r\nthen null\r\nelse self.typeDeclaration.typeDefinition\r\nendif'"
	 * @generated
	 */
	TypeDefinition getTypeDefinition();

} // DeclaredType
