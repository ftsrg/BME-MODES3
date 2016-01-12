/**
 */
package de.uni_paderborn.uppaal.expressions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Introduces all kinds of expressions.
 * <!-- end-model-doc -->
 * @see de.uni_paderborn.uppaal.expressions.ExpressionsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface ExpressionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expressions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.uni-paderborn.de/uppaal/expressions/0.4.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "expressions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionsPackage eINSTANCE = de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EXP = 0;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.NegationExpressionImpl <em>Negation Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.NegationExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getNegationExpression()
	 * @generated
	 */
	int NEGATION_EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATION_EXPRESSION__EXP = EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>Negated Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATION_EXPRESSION__NEGATED_EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Negation Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Negation Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATION_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.PlusExpressionImpl <em>Plus Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.PlusExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getPlusExpression()
	 * @generated
	 */
	int PLUS_EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_EXPRESSION__EXP = EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>Confirmed Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_EXPRESSION__CONFIRMED_EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Plus Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Plus Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.MinusExpressionImpl <em>Minus Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.MinusExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getMinusExpression()
	 * @generated
	 */
	int MINUS_EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_EXPRESSION__EXP = EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>Inverted Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_EXPRESSION__INVERTED_EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Minus Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Minus Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.BinaryExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getBinaryExpression()
	 * @generated
	 */
	int BINARY_EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__EXP = EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>First Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__FIRST_EXPR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Second Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__SECOND_EXPR = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.AssignmentExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getAssignmentExpression()
	 * @generated
	 */
	int ASSIGNMENT_EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION__EXP = BINARY_EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>First Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION__FIRST_EXPR = BINARY_EXPRESSION__FIRST_EXPR;

	/**
	 * The feature id for the '<em><b>Second Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION__SECOND_EXPR = BINARY_EXPRESSION__SECOND_EXPR;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION__OPERATOR = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Assignment Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Assignment Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.IdentifierExpressionImpl <em>Identifier Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.IdentifierExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getIdentifierExpression()
	 * @generated
	 */
	int IDENTIFIER_EXPRESSION = 6;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_EXPRESSION__EXP = EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_EXPRESSION__IDENTIFIER = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_EXPRESSION__INDEX = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Identifier Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Identifier Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.LiteralExpressionImpl <em>Literal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.LiteralExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getLiteralExpression()
	 * @generated
	 */
	int LITERAL_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION__EXP = EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION__TEXT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.ArithmeticExpressionImpl <em>Arithmetic Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.ArithmeticExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getArithmeticExpression()
	 * @generated
	 */
	int ARITHMETIC_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_EXPRESSION__EXP = BINARY_EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>First Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_EXPRESSION__FIRST_EXPR = BINARY_EXPRESSION__FIRST_EXPR;

	/**
	 * The feature id for the '<em><b>Second Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_EXPRESSION__SECOND_EXPR = BINARY_EXPRESSION__SECOND_EXPR;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_EXPRESSION__OPERATOR = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Arithmetic Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Arithmetic Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.LogicalExpressionImpl <em>Logical Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.LogicalExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getLogicalExpression()
	 * @generated
	 */
	int LOGICAL_EXPRESSION = 9;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_EXPRESSION__EXP = BINARY_EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>First Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_EXPRESSION__FIRST_EXPR = BINARY_EXPRESSION__FIRST_EXPR;

	/**
	 * The feature id for the '<em><b>Second Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_EXPRESSION__SECOND_EXPR = BINARY_EXPRESSION__SECOND_EXPR;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_EXPRESSION__OPERATOR = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Logical Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Logical Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.FunctionCallExpressionImpl <em>Function Call Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.FunctionCallExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getFunctionCallExpression()
	 * @generated
	 */
	int FUNCTION_CALL_EXPRESSION = 10;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL_EXPRESSION__EXP = EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL_EXPRESSION__FUNCTION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL_EXPRESSION__ARGUMENT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function Call Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Function Call Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.CompareExpressionImpl <em>Compare Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.CompareExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getCompareExpression()
	 * @generated
	 */
	int COMPARE_EXPRESSION = 11;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_EXPRESSION__EXP = BINARY_EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>First Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_EXPRESSION__FIRST_EXPR = BINARY_EXPRESSION__FIRST_EXPR;

	/**
	 * The feature id for the '<em><b>Second Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_EXPRESSION__SECOND_EXPR = BINARY_EXPRESSION__SECOND_EXPR;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_EXPRESSION__OPERATOR = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compare Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Compare Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.ConditionExpressionImpl <em>Condition Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.ConditionExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getConditionExpression()
	 * @generated
	 */
	int CONDITION_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXPRESSION__EXP = EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>If Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXPRESSION__IF_EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXPRESSION__THEN_EXPRESSION = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXPRESSION__ELSE_EXPRESSION = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Condition Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Condition Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.ScopedIdentifierExpressionImpl <em>Scoped Identifier Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.ScopedIdentifierExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getScopedIdentifierExpression()
	 * @generated
	 */
	int SCOPED_IDENTIFIER_EXPRESSION = 13;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_IDENTIFIER_EXPRESSION__EXP = EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_IDENTIFIER_EXPRESSION__SCOPE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_IDENTIFIER_EXPRESSION__IDENTIFIER = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Scoped Identifier Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_IDENTIFIER_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Scoped Identifier Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_IDENTIFIER_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.QuantificationExpressionImpl <em>Quantification Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.QuantificationExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getQuantificationExpression()
	 * @generated
	 */
	int QUANTIFICATION_EXPRESSION = 14;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFICATION_EXPRESSION__EXP = EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFICATION_EXPRESSION__TYPE_DEFINITION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFICATION_EXPRESSION__VARIABLE = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Quantifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFICATION_EXPRESSION__QUANTIFIER = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFICATION_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Quantification Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFICATION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Quantification Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFICATION_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.IncrementDecrementExpressionImpl <em>Increment Decrement Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.IncrementDecrementExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getIncrementDecrementExpression()
	 * @generated
	 */
	int INCREMENT_DECREMENT_EXPRESSION = 15;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_DECREMENT_EXPRESSION__EXP = EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_DECREMENT_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_DECREMENT_EXPRESSION__POSITION = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_DECREMENT_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Increment Decrement Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_DECREMENT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Increment Decrement Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_DECREMENT_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.BitShiftExpressionImpl <em>Bit Shift Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.BitShiftExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getBitShiftExpression()
	 * @generated
	 */
	int BIT_SHIFT_EXPRESSION = 16;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT_SHIFT_EXPRESSION__EXP = BINARY_EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>First Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT_SHIFT_EXPRESSION__FIRST_EXPR = BINARY_EXPRESSION__FIRST_EXPR;

	/**
	 * The feature id for the '<em><b>Second Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT_SHIFT_EXPRESSION__SECOND_EXPR = BINARY_EXPRESSION__SECOND_EXPR;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT_SHIFT_EXPRESSION__OPERATOR = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bit Shift Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT_SHIFT_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Bit Shift Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT_SHIFT_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.MinMaxExpressionImpl <em>Min Max Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.MinMaxExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getMinMaxExpression()
	 * @generated
	 */
	int MIN_MAX_EXPRESSION = 17;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_MAX_EXPRESSION__EXP = BINARY_EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>First Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_MAX_EXPRESSION__FIRST_EXPR = BINARY_EXPRESSION__FIRST_EXPR;

	/**
	 * The feature id for the '<em><b>Second Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_MAX_EXPRESSION__SECOND_EXPR = BINARY_EXPRESSION__SECOND_EXPR;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_MAX_EXPRESSION__OPERATOR = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Min Max Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_MAX_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Min Max Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_MAX_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.impl.BitwiseExpressionImpl <em>Bitwise Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.impl.BitwiseExpressionImpl
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getBitwiseExpression()
	 * @generated
	 */
	int BITWISE_EXPRESSION = 18;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_EXPRESSION__EXP = BINARY_EXPRESSION__EXP;

	/**
	 * The feature id for the '<em><b>First Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_EXPRESSION__FIRST_EXPR = BINARY_EXPRESSION__FIRST_EXPR;

	/**
	 * The feature id for the '<em><b>Second Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_EXPRESSION__SECOND_EXPR = BINARY_EXPRESSION__SECOND_EXPR;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_EXPRESSION__OPERATOR = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bitwise Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Bitwise Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.AssignmentOperator <em>Assignment Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.AssignmentOperator
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getAssignmentOperator()
	 * @generated
	 */
	int ASSIGNMENT_OPERATOR = 19;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.ArithmeticOperator <em>Arithmetic Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.ArithmeticOperator
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getArithmeticOperator()
	 * @generated
	 */
	int ARITHMETIC_OPERATOR = 20;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.LogicalOperator <em>Logical Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.LogicalOperator
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getLogicalOperator()
	 * @generated
	 */
	int LOGICAL_OPERATOR = 21;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.CompareOperator <em>Compare Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.CompareOperator
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getCompareOperator()
	 * @generated
	 */
	int COMPARE_OPERATOR = 22;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.Quantifier <em>Quantifier</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.Quantifier
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getQuantifier()
	 * @generated
	 */
	int QUANTIFIER = 23;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementOperator <em>Increment Decrement Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.IncrementDecrementOperator
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getIncrementDecrementOperator()
	 * @generated
	 */
	int INCREMENT_DECREMENT_OPERATOR = 24;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementPosition <em>Increment Decrement Position</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.IncrementDecrementPosition
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getIncrementDecrementPosition()
	 * @generated
	 */
	int INCREMENT_DECREMENT_POSITION = 25;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.BitShiftOperator <em>Bit Shift Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.BitShiftOperator
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getBitShiftOperator()
	 * @generated
	 */
	int BIT_SHIFT_OPERATOR = 26;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.MinMaxOperator <em>Min Max Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.MinMaxOperator
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getMinMaxOperator()
	 * @generated
	 */
	int MIN_MAX_OPERATOR = 27;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.expressions.BitwiseOperator <em>Bitwise Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.expressions.BitwiseOperator
	 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getBitwiseOperator()
	 * @generated
	 */
	int BITWISE_OPERATOR = 28;


	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.expressions.Expression#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exp</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.Expression#getExp()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Exp();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.NegationExpression <em>Negation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Negation Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.NegationExpression
	 * @generated
	 */
	EClass getNegationExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.expressions.NegationExpression#getNegatedExpression <em>Negated Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Negated Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.NegationExpression#getNegatedExpression()
	 * @see #getNegationExpression()
	 * @generated
	 */
	EReference getNegationExpression_NegatedExpression();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.PlusExpression <em>Plus Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plus Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.PlusExpression
	 * @generated
	 */
	EClass getPlusExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.expressions.PlusExpression#getConfirmedExpression <em>Confirmed Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Confirmed Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.PlusExpression#getConfirmedExpression()
	 * @see #getPlusExpression()
	 * @generated
	 */
	EReference getPlusExpression_ConfirmedExpression();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.MinusExpression <em>Minus Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Minus Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.MinusExpression
	 * @generated
	 */
	EClass getMinusExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.expressions.MinusExpression#getInvertedExpression <em>Inverted Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inverted Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.MinusExpression#getInvertedExpression()
	 * @see #getMinusExpression()
	 * @generated
	 */
	EReference getMinusExpression_InvertedExpression();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.BinaryExpression <em>Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.BinaryExpression
	 * @generated
	 */
	EClass getBinaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.expressions.BinaryExpression#getFirstExpr <em>First Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First Expr</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.BinaryExpression#getFirstExpr()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_FirstExpr();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.expressions.BinaryExpression#getSecondExpr <em>Second Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Second Expr</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.BinaryExpression#getSecondExpr()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_SecondExpr();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.AssignmentExpression <em>Assignment Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.AssignmentExpression
	 * @generated
	 */
	EClass getAssignmentExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.expressions.AssignmentExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.AssignmentExpression#getOperator()
	 * @see #getAssignmentExpression()
	 * @generated
	 */
	EAttribute getAssignmentExpression_Operator();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.IdentifierExpression <em>Identifier Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.IdentifierExpression
	 * @generated
	 */
	EClass getIdentifierExpression();

	/**
	 * Returns the meta object for the reference '{@link de.uni_paderborn.uppaal.expressions.IdentifierExpression#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifier</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.IdentifierExpression#getIdentifier()
	 * @see #getIdentifierExpression()
	 * @generated
	 */
	EReference getIdentifierExpression_Identifier();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.expressions.IdentifierExpression#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Index</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.IdentifierExpression#getIndex()
	 * @see #getIdentifierExpression()
	 * @generated
	 */
	EReference getIdentifierExpression_Index();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.LiteralExpression <em>Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.LiteralExpression
	 * @generated
	 */
	EClass getLiteralExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.expressions.LiteralExpression#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.LiteralExpression#getText()
	 * @see #getLiteralExpression()
	 * @generated
	 */
	EAttribute getLiteralExpression_Text();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.ArithmeticExpression <em>Arithmetic Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arithmetic Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.ArithmeticExpression
	 * @generated
	 */
	EClass getArithmeticExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.expressions.ArithmeticExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.ArithmeticExpression#getOperator()
	 * @see #getArithmeticExpression()
	 * @generated
	 */
	EAttribute getArithmeticExpression_Operator();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.LogicalExpression <em>Logical Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.LogicalExpression
	 * @generated
	 */
	EClass getLogicalExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.expressions.LogicalExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.LogicalExpression#getOperator()
	 * @see #getLogicalExpression()
	 * @generated
	 */
	EAttribute getLogicalExpression_Operator();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.FunctionCallExpression <em>Function Call Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Call Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.FunctionCallExpression
	 * @generated
	 */
	EClass getFunctionCallExpression();

	/**
	 * Returns the meta object for the reference '{@link de.uni_paderborn.uppaal.expressions.FunctionCallExpression#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.FunctionCallExpression#getFunction()
	 * @see #getFunctionCallExpression()
	 * @generated
	 */
	EReference getFunctionCallExpression_Function();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.expressions.FunctionCallExpression#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.FunctionCallExpression#getArgument()
	 * @see #getFunctionCallExpression()
	 * @generated
	 */
	EReference getFunctionCallExpression_Argument();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.CompareExpression <em>Compare Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compare Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.CompareExpression
	 * @generated
	 */
	EClass getCompareExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.expressions.CompareExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.CompareExpression#getOperator()
	 * @see #getCompareExpression()
	 * @generated
	 */
	EAttribute getCompareExpression_Operator();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.ConditionExpression <em>Condition Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.ConditionExpression
	 * @generated
	 */
	EClass getConditionExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.expressions.ConditionExpression#getIfExpression <em>If Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.ConditionExpression#getIfExpression()
	 * @see #getConditionExpression()
	 * @generated
	 */
	EReference getConditionExpression_IfExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.expressions.ConditionExpression#getThenExpression <em>Then Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.ConditionExpression#getThenExpression()
	 * @see #getConditionExpression()
	 * @generated
	 */
	EReference getConditionExpression_ThenExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.expressions.ConditionExpression#getElseExpression <em>Else Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.ConditionExpression#getElseExpression()
	 * @see #getConditionExpression()
	 * @generated
	 */
	EReference getConditionExpression_ElseExpression();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.ScopedIdentifierExpression <em>Scoped Identifier Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scoped Identifier Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.ScopedIdentifierExpression
	 * @generated
	 */
	EClass getScopedIdentifierExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.expressions.ScopedIdentifierExpression#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scope</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.ScopedIdentifierExpression#getScope()
	 * @see #getScopedIdentifierExpression()
	 * @generated
	 */
	EReference getScopedIdentifierExpression_Scope();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.expressions.ScopedIdentifierExpression#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.ScopedIdentifierExpression#getIdentifier()
	 * @see #getScopedIdentifierExpression()
	 * @generated
	 */
	EReference getScopedIdentifierExpression_Identifier();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.QuantificationExpression <em>Quantification Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quantification Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.QuantificationExpression
	 * @generated
	 */
	EClass getQuantificationExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.expressions.QuantificationExpression#getQuantifier <em>Quantifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantifier</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.QuantificationExpression#getQuantifier()
	 * @see #getQuantificationExpression()
	 * @generated
	 */
	EAttribute getQuantificationExpression_Quantifier();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.expressions.QuantificationExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.QuantificationExpression#getExpression()
	 * @see #getQuantificationExpression()
	 * @generated
	 */
	EReference getQuantificationExpression_Expression();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression <em>Increment Decrement Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Increment Decrement Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression
	 * @generated
	 */
	EClass getIncrementDecrementExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression#getExpression()
	 * @see #getIncrementDecrementExpression()
	 * @generated
	 */
	EReference getIncrementDecrementExpression_Expression();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression#getPosition()
	 * @see #getIncrementDecrementExpression()
	 * @generated
	 */
	EAttribute getIncrementDecrementExpression_Position();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression#getOperator()
	 * @see #getIncrementDecrementExpression()
	 * @generated
	 */
	EAttribute getIncrementDecrementExpression_Operator();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.BitShiftExpression <em>Bit Shift Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bit Shift Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.BitShiftExpression
	 * @generated
	 */
	EClass getBitShiftExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.expressions.BitShiftExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.BitShiftExpression#getOperator()
	 * @see #getBitShiftExpression()
	 * @generated
	 */
	EAttribute getBitShiftExpression_Operator();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.MinMaxExpression <em>Min Max Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Min Max Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.MinMaxExpression
	 * @generated
	 */
	EClass getMinMaxExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.expressions.MinMaxExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.MinMaxExpression#getOperator()
	 * @see #getMinMaxExpression()
	 * @generated
	 */
	EAttribute getMinMaxExpression_Operator();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.expressions.BitwiseExpression <em>Bitwise Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bitwise Expression</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.BitwiseExpression
	 * @generated
	 */
	EClass getBitwiseExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.expressions.BitwiseExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.BitwiseExpression#getOperator()
	 * @see #getBitwiseExpression()
	 * @generated
	 */
	EAttribute getBitwiseExpression_Operator();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.expressions.AssignmentOperator <em>Assignment Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Assignment Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.AssignmentOperator
	 * @generated
	 */
	EEnum getAssignmentOperator();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.expressions.ArithmeticOperator <em>Arithmetic Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Arithmetic Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.ArithmeticOperator
	 * @generated
	 */
	EEnum getArithmeticOperator();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.expressions.LogicalOperator <em>Logical Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Logical Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.LogicalOperator
	 * @generated
	 */
	EEnum getLogicalOperator();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.expressions.CompareOperator <em>Compare Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Compare Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.CompareOperator
	 * @generated
	 */
	EEnum getCompareOperator();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.expressions.Quantifier <em>Quantifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Quantifier</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.Quantifier
	 * @generated
	 */
	EEnum getQuantifier();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementOperator <em>Increment Decrement Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Increment Decrement Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.IncrementDecrementOperator
	 * @generated
	 */
	EEnum getIncrementDecrementOperator();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementPosition <em>Increment Decrement Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Increment Decrement Position</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.IncrementDecrementPosition
	 * @generated
	 */
	EEnum getIncrementDecrementPosition();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.expressions.BitShiftOperator <em>Bit Shift Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Bit Shift Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.BitShiftOperator
	 * @generated
	 */
	EEnum getBitShiftOperator();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.expressions.MinMaxOperator <em>Min Max Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Min Max Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.MinMaxOperator
	 * @generated
	 */
	EEnum getMinMaxOperator();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.expressions.BitwiseOperator <em>Bitwise Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Bitwise Operator</em>'.
	 * @see de.uni_paderborn.uppaal.expressions.BitwiseOperator
	 * @generated
	 */
	EEnum getBitwiseOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionsFactory getExpressionsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__EXP = eINSTANCE.getExpression_Exp();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.NegationExpressionImpl <em>Negation Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.NegationExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getNegationExpression()
		 * @generated
		 */
		EClass NEGATION_EXPRESSION = eINSTANCE.getNegationExpression();

		/**
		 * The meta object literal for the '<em><b>Negated Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEGATION_EXPRESSION__NEGATED_EXPRESSION = eINSTANCE.getNegationExpression_NegatedExpression();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.PlusExpressionImpl <em>Plus Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.PlusExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getPlusExpression()
		 * @generated
		 */
		EClass PLUS_EXPRESSION = eINSTANCE.getPlusExpression();

		/**
		 * The meta object literal for the '<em><b>Confirmed Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUS_EXPRESSION__CONFIRMED_EXPRESSION = eINSTANCE.getPlusExpression_ConfirmedExpression();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.MinusExpressionImpl <em>Minus Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.MinusExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getMinusExpression()
		 * @generated
		 */
		EClass MINUS_EXPRESSION = eINSTANCE.getMinusExpression();

		/**
		 * The meta object literal for the '<em><b>Inverted Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MINUS_EXPRESSION__INVERTED_EXPRESSION = eINSTANCE.getMinusExpression_InvertedExpression();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.BinaryExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getBinaryExpression()
		 * @generated
		 */
		EClass BINARY_EXPRESSION = eINSTANCE.getBinaryExpression();

		/**
		 * The meta object literal for the '<em><b>First Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__FIRST_EXPR = eINSTANCE.getBinaryExpression_FirstExpr();

		/**
		 * The meta object literal for the '<em><b>Second Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__SECOND_EXPR = eINSTANCE.getBinaryExpression_SecondExpr();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.AssignmentExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getAssignmentExpression()
		 * @generated
		 */
		EClass ASSIGNMENT_EXPRESSION = eINSTANCE.getAssignmentExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT_EXPRESSION__OPERATOR = eINSTANCE.getAssignmentExpression_Operator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.IdentifierExpressionImpl <em>Identifier Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.IdentifierExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getIdentifierExpression()
		 * @generated
		 */
		EClass IDENTIFIER_EXPRESSION = eINSTANCE.getIdentifierExpression();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER_EXPRESSION__IDENTIFIER = eINSTANCE.getIdentifierExpression_Identifier();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER_EXPRESSION__INDEX = eINSTANCE.getIdentifierExpression_Index();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.LiteralExpressionImpl <em>Literal Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.LiteralExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getLiteralExpression()
		 * @generated
		 */
		EClass LITERAL_EXPRESSION = eINSTANCE.getLiteralExpression();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_EXPRESSION__TEXT = eINSTANCE.getLiteralExpression_Text();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.ArithmeticExpressionImpl <em>Arithmetic Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.ArithmeticExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getArithmeticExpression()
		 * @generated
		 */
		EClass ARITHMETIC_EXPRESSION = eINSTANCE.getArithmeticExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARITHMETIC_EXPRESSION__OPERATOR = eINSTANCE.getArithmeticExpression_Operator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.LogicalExpressionImpl <em>Logical Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.LogicalExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getLogicalExpression()
		 * @generated
		 */
		EClass LOGICAL_EXPRESSION = eINSTANCE.getLogicalExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGICAL_EXPRESSION__OPERATOR = eINSTANCE.getLogicalExpression_Operator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.FunctionCallExpressionImpl <em>Function Call Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.FunctionCallExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getFunctionCallExpression()
		 * @generated
		 */
		EClass FUNCTION_CALL_EXPRESSION = eINSTANCE.getFunctionCallExpression();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_CALL_EXPRESSION__FUNCTION = eINSTANCE.getFunctionCallExpression_Function();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_CALL_EXPRESSION__ARGUMENT = eINSTANCE.getFunctionCallExpression_Argument();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.CompareExpressionImpl <em>Compare Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.CompareExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getCompareExpression()
		 * @generated
		 */
		EClass COMPARE_EXPRESSION = eINSTANCE.getCompareExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARE_EXPRESSION__OPERATOR = eINSTANCE.getCompareExpression_Operator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.ConditionExpressionImpl <em>Condition Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.ConditionExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getConditionExpression()
		 * @generated
		 */
		EClass CONDITION_EXPRESSION = eINSTANCE.getConditionExpression();

		/**
		 * The meta object literal for the '<em><b>If Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_EXPRESSION__IF_EXPRESSION = eINSTANCE.getConditionExpression_IfExpression();

		/**
		 * The meta object literal for the '<em><b>Then Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_EXPRESSION__THEN_EXPRESSION = eINSTANCE.getConditionExpression_ThenExpression();

		/**
		 * The meta object literal for the '<em><b>Else Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_EXPRESSION__ELSE_EXPRESSION = eINSTANCE.getConditionExpression_ElseExpression();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.ScopedIdentifierExpressionImpl <em>Scoped Identifier Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.ScopedIdentifierExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getScopedIdentifierExpression()
		 * @generated
		 */
		EClass SCOPED_IDENTIFIER_EXPRESSION = eINSTANCE.getScopedIdentifierExpression();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPED_IDENTIFIER_EXPRESSION__SCOPE = eINSTANCE.getScopedIdentifierExpression_Scope();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPED_IDENTIFIER_EXPRESSION__IDENTIFIER = eINSTANCE.getScopedIdentifierExpression_Identifier();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.QuantificationExpressionImpl <em>Quantification Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.QuantificationExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getQuantificationExpression()
		 * @generated
		 */
		EClass QUANTIFICATION_EXPRESSION = eINSTANCE.getQuantificationExpression();

		/**
		 * The meta object literal for the '<em><b>Quantifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUANTIFICATION_EXPRESSION__QUANTIFIER = eINSTANCE.getQuantificationExpression_Quantifier();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUANTIFICATION_EXPRESSION__EXPRESSION = eINSTANCE.getQuantificationExpression_Expression();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.IncrementDecrementExpressionImpl <em>Increment Decrement Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.IncrementDecrementExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getIncrementDecrementExpression()
		 * @generated
		 */
		EClass INCREMENT_DECREMENT_EXPRESSION = eINSTANCE.getIncrementDecrementExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCREMENT_DECREMENT_EXPRESSION__EXPRESSION = eINSTANCE.getIncrementDecrementExpression_Expression();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCREMENT_DECREMENT_EXPRESSION__POSITION = eINSTANCE.getIncrementDecrementExpression_Position();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCREMENT_DECREMENT_EXPRESSION__OPERATOR = eINSTANCE.getIncrementDecrementExpression_Operator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.BitShiftExpressionImpl <em>Bit Shift Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.BitShiftExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getBitShiftExpression()
		 * @generated
		 */
		EClass BIT_SHIFT_EXPRESSION = eINSTANCE.getBitShiftExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIT_SHIFT_EXPRESSION__OPERATOR = eINSTANCE.getBitShiftExpression_Operator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.MinMaxExpressionImpl <em>Min Max Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.MinMaxExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getMinMaxExpression()
		 * @generated
		 */
		EClass MIN_MAX_EXPRESSION = eINSTANCE.getMinMaxExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIN_MAX_EXPRESSION__OPERATOR = eINSTANCE.getMinMaxExpression_Operator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.impl.BitwiseExpressionImpl <em>Bitwise Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.impl.BitwiseExpressionImpl
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getBitwiseExpression()
		 * @generated
		 */
		EClass BITWISE_EXPRESSION = eINSTANCE.getBitwiseExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BITWISE_EXPRESSION__OPERATOR = eINSTANCE.getBitwiseExpression_Operator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.AssignmentOperator <em>Assignment Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.AssignmentOperator
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getAssignmentOperator()
		 * @generated
		 */
		EEnum ASSIGNMENT_OPERATOR = eINSTANCE.getAssignmentOperator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.ArithmeticOperator <em>Arithmetic Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.ArithmeticOperator
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getArithmeticOperator()
		 * @generated
		 */
		EEnum ARITHMETIC_OPERATOR = eINSTANCE.getArithmeticOperator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.LogicalOperator <em>Logical Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.LogicalOperator
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getLogicalOperator()
		 * @generated
		 */
		EEnum LOGICAL_OPERATOR = eINSTANCE.getLogicalOperator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.CompareOperator <em>Compare Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.CompareOperator
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getCompareOperator()
		 * @generated
		 */
		EEnum COMPARE_OPERATOR = eINSTANCE.getCompareOperator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.Quantifier <em>Quantifier</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.Quantifier
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getQuantifier()
		 * @generated
		 */
		EEnum QUANTIFIER = eINSTANCE.getQuantifier();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementOperator <em>Increment Decrement Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.IncrementDecrementOperator
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getIncrementDecrementOperator()
		 * @generated
		 */
		EEnum INCREMENT_DECREMENT_OPERATOR = eINSTANCE.getIncrementDecrementOperator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.IncrementDecrementPosition <em>Increment Decrement Position</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.IncrementDecrementPosition
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getIncrementDecrementPosition()
		 * @generated
		 */
		EEnum INCREMENT_DECREMENT_POSITION = eINSTANCE.getIncrementDecrementPosition();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.BitShiftOperator <em>Bit Shift Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.BitShiftOperator
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getBitShiftOperator()
		 * @generated
		 */
		EEnum BIT_SHIFT_OPERATOR = eINSTANCE.getBitShiftOperator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.MinMaxOperator <em>Min Max Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.MinMaxOperator
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getMinMaxOperator()
		 * @generated
		 */
		EEnum MIN_MAX_OPERATOR = eINSTANCE.getMinMaxOperator();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.expressions.BitwiseOperator <em>Bitwise Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.expressions.BitwiseOperator
		 * @see de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl#getBitwiseOperator()
		 * @generated
		 */
		EEnum BITWISE_OPERATOR = eINSTANCE.getBitwiseOperator();

	}

} //ExpressionsPackage
