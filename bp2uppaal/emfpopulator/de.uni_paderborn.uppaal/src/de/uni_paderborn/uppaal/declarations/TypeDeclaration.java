/**
 */
package de.uni_paderborn.uppaal.declarations;

import org.eclipse.emf.common.util.EList;

import de.uni_paderborn.uppaal.types.DeclaredType;
import de.uni_paderborn.uppaal.types.TypeDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A declaration of one or more types.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.TypeDeclaration#getType <em>Type</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.TypeDeclaration#getTypeDefinition <em>Type Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getTypeDeclaration()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL UniqueTypeNames='self.type->isUnique(name)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UniqueTypeNames'"
 * @generated
 */
public interface TypeDeclaration extends Declaration {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference list.
	 * The list contents are of type {@link de.uni_paderborn.uppaal.types.DeclaredType}.
	 * It is bidirectional and its opposite is '{@link de.uni_paderborn.uppaal.types.DeclaredType#getTypeDeclaration <em>Type Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The types declared by this type declaration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' containment reference list.
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getTypeDeclaration_Type()
	 * @see de.uni_paderborn.uppaal.types.DeclaredType#getTypeDeclaration
	 * @model opposite="typeDeclaration" containment="true" required="true"
	 * @generated
	 */
	EList<DeclaredType> getType();

	/**
	 * Returns the value of the '<em><b>Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type definition for declared types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Definition</em>' containment reference.
	 * @see #setTypeDefinition(TypeDefinition)
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getTypeDeclaration_TypeDefinition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypeDefinition getTypeDefinition();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.declarations.TypeDeclaration#getTypeDefinition <em>Type Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Definition</em>' containment reference.
	 * @see #getTypeDefinition()
	 * @generated
	 */
	void setTypeDefinition(TypeDefinition value);

} // TypeDeclaration
