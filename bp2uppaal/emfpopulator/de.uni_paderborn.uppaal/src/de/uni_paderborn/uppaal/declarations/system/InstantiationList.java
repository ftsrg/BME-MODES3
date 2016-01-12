/**
 */
package de.uni_paderborn.uppaal.declarations.system;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uni_paderborn.uppaal.templates.AbstractTemplate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instantiation List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents a list of templates to be instantiated using a common priority.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.system.InstantiationList#getTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.declarations.system.SystemPackage#getInstantiationList()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL OnlyLegalParamsForPartialInstantiation='self.template->forAll(\r\n\tparameter->forAll(\r\n\t\tcallType = declarations::CallType::CALL_BY_VALUE\r\n\t\tand\r\n\t\t((not variableDeclaration.oclIsUndefined())\r\n\t\t\timplies\r\n\t\t (variableDeclaration.typeDefinition.oclIsKindOf(types::RangeTypeSpecification) or\r\n\t\t  variableDeclaration.typeDefinition.oclIsKindOf(types::ScalarTypeSpecification)))\r\n\t)\r\n)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='OnlyLegalParamsForPartialInstantiation'"
 * @generated
 */
public interface InstantiationList extends EObject {
	/**
	 * Returns the value of the '<em><b>Template</b></em>' reference list.
	 * The list contents are of type {@link de.uni_paderborn.uppaal.templates.AbstractTemplate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of instantiations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Template</em>' reference list.
	 * @see de.uni_paderborn.uppaal.declarations.system.SystemPackage#getInstantiationList_Template()
	 * @model required="true"
	 * @generated
	 */
	EList<AbstractTemplate> getTemplate();

} // InstantiationList
