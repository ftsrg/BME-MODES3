/**
 */
package de.uni_paderborn.uppaal.expressions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage
 * @generated
 */
public interface ExpressionsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionsFactory eINSTANCE = de.uni_paderborn.uppaal.expressions.impl.ExpressionsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Negation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Negation Expression</em>'.
	 * @generated
	 */
	NegationExpression createNegationExpression();

	/**
	 * Returns a new object of class '<em>Plus Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plus Expression</em>'.
	 * @generated
	 */
	PlusExpression createPlusExpression();

	/**
	 * Returns a new object of class '<em>Minus Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Minus Expression</em>'.
	 * @generated
	 */
	MinusExpression createMinusExpression();

	/**
	 * Returns a new object of class '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment Expression</em>'.
	 * @generated
	 */
	AssignmentExpression createAssignmentExpression();

	/**
	 * Returns a new object of class '<em>Identifier Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifier Expression</em>'.
	 * @generated
	 */
	IdentifierExpression createIdentifierExpression();

	/**
	 * Returns a new object of class '<em>Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Expression</em>'.
	 * @generated
	 */
	LiteralExpression createLiteralExpression();

	/**
	 * Returns a new object of class '<em>Arithmetic Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arithmetic Expression</em>'.
	 * @generated
	 */
	ArithmeticExpression createArithmeticExpression();

	/**
	 * Returns a new object of class '<em>Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical Expression</em>'.
	 * @generated
	 */
	LogicalExpression createLogicalExpression();

	/**
	 * Returns a new object of class '<em>Function Call Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Call Expression</em>'.
	 * @generated
	 */
	FunctionCallExpression createFunctionCallExpression();

	/**
	 * Returns a new object of class '<em>Compare Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compare Expression</em>'.
	 * @generated
	 */
	CompareExpression createCompareExpression();

	/**
	 * Returns a new object of class '<em>Condition Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition Expression</em>'.
	 * @generated
	 */
	ConditionExpression createConditionExpression();

	/**
	 * Returns a new object of class '<em>Scoped Identifier Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scoped Identifier Expression</em>'.
	 * @generated
	 */
	ScopedIdentifierExpression createScopedIdentifierExpression();

	/**
	 * Returns a new object of class '<em>Quantification Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quantification Expression</em>'.
	 * @generated
	 */
	QuantificationExpression createQuantificationExpression();

	/**
	 * Returns a new object of class '<em>Increment Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Increment Decrement Expression</em>'.
	 * @generated
	 */
	IncrementDecrementExpression createIncrementDecrementExpression();

	/**
	 * Returns a new object of class '<em>Bit Shift Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bit Shift Expression</em>'.
	 * @generated
	 */
	BitShiftExpression createBitShiftExpression();

	/**
	 * Returns a new object of class '<em>Min Max Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Min Max Expression</em>'.
	 * @generated
	 */
	MinMaxExpression createMinMaxExpression();

	/**
	 * Returns a new object of class '<em>Bitwise Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bitwise Expression</em>'.
	 * @generated
	 */
	BitwiseExpression createBitwiseExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExpressionsPackage getExpressionsPackage();

} //ExpressionsFactory
