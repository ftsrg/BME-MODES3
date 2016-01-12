/**
 */
package de.uni_paderborn.uppaal.types;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uni_paderborn.uppaal.types.TypesPackage
 * @generated
 */
public interface TypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesFactory eINSTANCE = de.uni_paderborn.uppaal.types.impl.TypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Predefined Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Predefined Type</em>'.
	 * @generated
	 */
	PredefinedType createPredefinedType();

	/**
	 * Returns a new object of class '<em>Declared Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Declared Type</em>'.
	 * @generated
	 */
	DeclaredType createDeclaredType();

	/**
	 * Returns a new object of class '<em>Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Reference</em>'.
	 * @generated
	 */
	TypeReference createTypeReference();

	/**
	 * Returns a new object of class '<em>Scalar Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scalar Type Specification</em>'.
	 * @generated
	 */
	ScalarTypeSpecification createScalarTypeSpecification();

	/**
	 * Returns a new object of class '<em>Struct Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Struct Type Specification</em>'.
	 * @generated
	 */
	StructTypeSpecification createStructTypeSpecification();

	/**
	 * Returns a new object of class '<em>Range Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Range Type Specification</em>'.
	 * @generated
	 */
	RangeTypeSpecification createRangeTypeSpecification();

	/**
	 * Returns a new object of class '<em>Integer Bounds</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Bounds</em>'.
	 * @generated
	 */
	IntegerBounds createIntegerBounds();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TypesPackage getTypesPackage();

} //TypesFactory
