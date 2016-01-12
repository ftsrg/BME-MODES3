/**
 */
package de.uni_paderborn.uppaal.types;

import org.eclipse.emf.common.util.EList;

import de.uni_paderborn.uppaal.core.NamedElement;
import de.uni_paderborn.uppaal.declarations.Index;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Abstract base class for all types.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.types.Type#getIndex <em>Index</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.types.Type#getBaseType <em>Base Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.types.TypesPackage#getType()
 * @model abstract="true"
 * @generated
 */
public interface Type extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Index</b></em>' containment reference list.
	 * The list contents are of type {@link de.uni_paderborn.uppaal.declarations.Index}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A set of array indexes for the type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Index</em>' containment reference list.
	 * @see de.uni_paderborn.uppaal.types.TypesPackage#getType_Index()
	 * @model containment="true"
	 * @generated
	 */
	EList<Index> getIndex();

	/**
	 * Returns the value of the '<em><b>Base Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uni_paderborn.uppaal.types.BuiltInType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Type</em>' attribute.
	 * @see de.uni_paderborn.uppaal.types.BuiltInType
	 * @see de.uni_paderborn.uppaal.types.TypesPackage#getType_BaseType()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='if self.oclIsKindOf(DeclaredType)\r\nthen \r\n\tif self.oclAsType(DeclaredType).typeDefinition.oclIsUndefined()\r\n\tthen null\r\n\telse self.oclAsType(DeclaredType).typeDefinition.baseType\r\n\tendif\r\nelse \r\n\tif self.oclIsKindOf(PredefinedType)\r\n\tthen self.oclAsType(PredefinedType).type\r\n\telse null\r\n\tendif\r\nendif'"
	 * @generated
	 */
	BuiltInType getBaseType();

} // Type
