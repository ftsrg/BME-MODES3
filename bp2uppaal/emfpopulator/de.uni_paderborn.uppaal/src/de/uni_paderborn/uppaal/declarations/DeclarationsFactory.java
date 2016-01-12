/**
 */
package de.uni_paderborn.uppaal.declarations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage
 * @generated
 */
public interface DeclarationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DeclarationsFactory eINSTANCE = de.uni_paderborn.uppaal.declarations.impl.DeclarationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Global Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global Declarations</em>'.
	 * @generated
	 */
	GlobalDeclarations createGlobalDeclarations();

	/**
	 * Returns a new object of class '<em>Local Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Declarations</em>'.
	 * @generated
	 */
	LocalDeclarations createLocalDeclarations();

	/**
	 * Returns a new object of class '<em>System Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Declarations</em>'.
	 * @generated
	 */
	SystemDeclarations createSystemDeclarations();

	/**
	 * Returns a new object of class '<em>Channel Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Channel Variable Declaration</em>'.
	 * @generated
	 */
	ChannelVariableDeclaration createChannelVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Clock Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clock Variable Declaration</em>'.
	 * @generated
	 */
	ClockVariableDeclaration createClockVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Data Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Variable Declaration</em>'.
	 * @generated
	 */
	DataVariableDeclaration createDataVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Function Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Declaration</em>'.
	 * @generated
	 */
	FunctionDeclaration createFunctionDeclaration();

	/**
	 * Returns a new object of class '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function</em>'.
	 * @generated
	 */
	Function createFunction();

	/**
	 * Returns a new object of class '<em>Type Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Declaration</em>'.
	 * @generated
	 */
	TypeDeclaration createTypeDeclaration();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	Variable createVariable();

	/**
	 * Returns a new object of class '<em>Value Index</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Index</em>'.
	 * @generated
	 */
	ValueIndex createValueIndex();

	/**
	 * Returns a new object of class '<em>Type Index</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Index</em>'.
	 * @generated
	 */
	TypeIndex createTypeIndex();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Expression Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Initializer</em>'.
	 * @generated
	 */
	ExpressionInitializer createExpressionInitializer();

	/**
	 * Returns a new object of class '<em>Array Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Initializer</em>'.
	 * @generated
	 */
	ArrayInitializer createArrayInitializer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DeclarationsPackage getDeclarationsPackage();

} //DeclarationsFactory
