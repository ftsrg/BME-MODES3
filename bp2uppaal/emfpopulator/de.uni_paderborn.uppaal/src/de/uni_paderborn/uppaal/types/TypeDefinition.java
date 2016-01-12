/**
 */
package de.uni_paderborn.uppaal.types;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Abstract base class for type definitions of all typed elements. Type definitions are either references to types defined elsewhere, or in place specifications of new types.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.types.TypeDefinition#getBaseType <em>Base Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.types.TypesPackage#getTypeDefinition()
 * @model abstract="true"
 * @generated
 */
public interface TypeDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uni_paderborn.uppaal.types.BuiltInType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The built-in base type this type definition relies on. Can be 'null' in case of a 'struct' type definition involved.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base Type</em>' attribute.
	 * @see de.uni_paderborn.uppaal.types.BuiltInType
	 * @see de.uni_paderborn.uppaal.types.TypesPackage#getTypeDefinition_BaseType()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='if self.oclIsKindOf(TypeReference)\r\nthen \r\n\tif self.oclAsType(TypeReference).referredType.oclIsUndefined()\r\n\tthen null\r\n\telse self.oclAsType(TypeReference).referredType.baseType\r\n\tendif\r\nelse \r\n\tif self.oclIsKindOf(ScalarTypeSpecification) or self.oclIsKindOf(RangeTypeSpecification)\r\n\tthen BuiltInType::INT\r\n\telse null\r\n\tendif\r\nendif'"
	 * @generated
	 */
	BuiltInType getBaseType();

} // TypeDefinition
