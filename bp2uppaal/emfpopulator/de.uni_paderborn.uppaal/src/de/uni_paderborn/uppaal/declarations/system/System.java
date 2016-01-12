/**
 */
package de.uni_paderborn.uppaal.declarations.system;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A system contains declarations of template instantiations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.system.System#getInstantiationList <em>Instantiation List</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.declarations.system.SystemPackage#getSystem()
 * @model extendedMetaData="name='System' kind='elementOnly'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL EachTemplateReferencedAtMostOnce='self.instantiationList->collect(template)->isUnique(t : templates::AbstractTemplate | t)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='EachTemplateReferencedAtMostOnce'"
 * @generated
 */
public interface System extends EObject {
	/**
	 * Returns the value of the '<em><b>Instantiation List</b></em>' containment reference list.
	 * The list contents are of type {@link de.uni_paderborn.uppaal.declarations.system.InstantiationList}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of process instantiation sublists, ordered by decreasing priority. The templates referenced inside the sublists are instantiated to be part of the system at runtime.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instantiation List</em>' containment reference list.
	 * @see de.uni_paderborn.uppaal.declarations.system.SystemPackage#getSystem_InstantiationList()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<InstantiationList> getInstantiationList();

} // System
