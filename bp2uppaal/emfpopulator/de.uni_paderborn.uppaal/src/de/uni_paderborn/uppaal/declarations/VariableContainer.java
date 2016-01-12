/**
 */
package de.uni_paderborn.uppaal.declarations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uni_paderborn.uppaal.types.TypeDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Abstract base class for objects containing variables like variable declarations, iterations, quantifications or selections.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.VariableContainer#getTypeDefinition <em>Type Definition</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.VariableContainer#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getVariableContainer()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL NoVoidVariables='(not self.typeDefinition.oclIsUndefined())\r\nimplies\r\nself.typeDefinition.baseType <> types::BuiltInType::VOID' UniqueVariableNames='self.variable->isUnique(name)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NoVoidVariables UniqueVariableNames'"
 * @generated
 */
public interface VariableContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type definition for the contained variables.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Definition</em>' containment reference.
	 * @see #setTypeDefinition(TypeDefinition)
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getVariableContainer_TypeDefinition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypeDefinition getTypeDefinition();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.declarations.VariableContainer#getTypeDefinition <em>Type Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Definition</em>' containment reference.
	 * @see #getTypeDefinition()
	 * @generated
	 */
	void setTypeDefinition(TypeDefinition value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link de.uni_paderborn.uppaal.declarations.Variable}.
	 * It is bidirectional and its opposite is '{@link de.uni_paderborn.uppaal.declarations.Variable#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The contained variables.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getVariableContainer_Variable()
	 * @see de.uni_paderborn.uppaal.declarations.Variable#getContainer
	 * @model opposite="container" containment="true" required="true"
	 *        extendedMetaData="kind='element' name='variable'"
	 * @generated
	 */
	EList<Variable> getVariable();

} // VariableContainer
