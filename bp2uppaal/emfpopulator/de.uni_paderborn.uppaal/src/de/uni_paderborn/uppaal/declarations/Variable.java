/**
 */
package de.uni_paderborn.uppaal.declarations;

import org.eclipse.emf.common.util.EList;

import de.uni_paderborn.uppaal.core.NamedElement;
import de.uni_paderborn.uppaal.types.TypeDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A typed variable.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.Variable#getIndex <em>Index</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.Variable#getContainer <em>Container</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.Variable#getTypeDefinition <em>Type Definition</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.Variable#getInitializer <em>Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getVariable()
 * @model extendedMetaData="name='Variable' kind='empty'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL NoInitializerForClockAndChannelVariables='((not self.typeDefinition.oclIsUndefined()) and\r\n(self.typeDefinition.baseType = types::BuiltInType::CHAN or\r\n self.typeDefinition.baseType = types::BuiltInType::CLOCK))\r\n implies self.initializer.oclIsUndefined()'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NoInitializerForClockAndChannelVariables'"
 * @generated
 */
public interface Variable extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Index</b></em>' containment reference list.
	 * The list contents are of type {@link de.uni_paderborn.uppaal.declarations.Index}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A set of array indexes for the variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Index</em>' containment reference list.
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getVariable_Index()
	 * @model containment="true"
	 * @generated
	 */
	EList<Index> getIndex();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uni_paderborn.uppaal.declarations.VariableContainer#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The container of this variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(VariableContainer)
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getVariable_Container()
	 * @see de.uni_paderborn.uppaal.declarations.VariableContainer#getVariable
	 * @model opposite="variable" required="true" transient="false"
	 * @generated
	 */
	VariableContainer getContainer();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.declarations.Variable#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(VariableContainer value);

	/**
	 * Returns the value of the '<em><b>Type Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type definition of this variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Definition</em>' reference.
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getVariable_TypeDefinition()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='if self.container.oclIsUndefined()\r\nthen null \r\nelse \r\nself.container.typeDefinition \r\nendif'"
	 * @generated
	 */
	TypeDefinition getTypeDefinition();

	/**
	 * Returns the value of the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Represents the variable's initial value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Initializer</em>' containment reference.
	 * @see #setInitializer(Initializer)
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getVariable_Initializer()
	 * @model containment="true"
	 * @generated
	 */
	Initializer getInitializer();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.declarations.Variable#getInitializer <em>Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initializer</em>' containment reference.
	 * @see #getInitializer()
	 * @generated
	 */
	void setInitializer(Initializer value);

} // Variable
