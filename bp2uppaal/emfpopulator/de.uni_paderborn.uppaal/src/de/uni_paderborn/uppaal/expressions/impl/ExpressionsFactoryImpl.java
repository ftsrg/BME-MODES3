/**
 */
package de.uni_paderborn.uppaal.expressions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uni_paderborn.uppaal.expressions.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsFactoryImpl extends EFactoryImpl implements ExpressionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExpressionsFactory init() {
		try {
			ExpressionsFactory theExpressionsFactory = (ExpressionsFactory)EPackage.Registry.INSTANCE.getEFactory(ExpressionsPackage.eNS_URI);
			if (theExpressionsFactory != null) {
				return theExpressionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExpressionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExpressionsPackage.NEGATION_EXPRESSION: return createNegationExpression();
			case ExpressionsPackage.PLUS_EXPRESSION: return createPlusExpression();
			case ExpressionsPackage.MINUS_EXPRESSION: return createMinusExpression();
			case ExpressionsPackage.ASSIGNMENT_EXPRESSION: return createAssignmentExpression();
			case ExpressionsPackage.IDENTIFIER_EXPRESSION: return createIdentifierExpression();
			case ExpressionsPackage.LITERAL_EXPRESSION: return createLiteralExpression();
			case ExpressionsPackage.ARITHMETIC_EXPRESSION: return createArithmeticExpression();
			case ExpressionsPackage.LOGICAL_EXPRESSION: return createLogicalExpression();
			case ExpressionsPackage.FUNCTION_CALL_EXPRESSION: return createFunctionCallExpression();
			case ExpressionsPackage.COMPARE_EXPRESSION: return createCompareExpression();
			case ExpressionsPackage.CONDITION_EXPRESSION: return createConditionExpression();
			case ExpressionsPackage.SCOPED_IDENTIFIER_EXPRESSION: return createScopedIdentifierExpression();
			case ExpressionsPackage.QUANTIFICATION_EXPRESSION: return createQuantificationExpression();
			case ExpressionsPackage.INCREMENT_DECREMENT_EXPRESSION: return createIncrementDecrementExpression();
			case ExpressionsPackage.BIT_SHIFT_EXPRESSION: return createBitShiftExpression();
			case ExpressionsPackage.MIN_MAX_EXPRESSION: return createMinMaxExpression();
			case ExpressionsPackage.BITWISE_EXPRESSION: return createBitwiseExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ExpressionsPackage.ASSIGNMENT_OPERATOR:
				return createAssignmentOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.ARITHMETIC_OPERATOR:
				return createArithmeticOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.LOGICAL_OPERATOR:
				return createLogicalOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.COMPARE_OPERATOR:
				return createCompareOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.QUANTIFIER:
				return createQuantifierFromString(eDataType, initialValue);
			case ExpressionsPackage.INCREMENT_DECREMENT_OPERATOR:
				return createIncrementDecrementOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.INCREMENT_DECREMENT_POSITION:
				return createIncrementDecrementPositionFromString(eDataType, initialValue);
			case ExpressionsPackage.BIT_SHIFT_OPERATOR:
				return createBitShiftOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.MIN_MAX_OPERATOR:
				return createMinMaxOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.BITWISE_OPERATOR:
				return createBitwiseOperatorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ExpressionsPackage.ASSIGNMENT_OPERATOR:
				return convertAssignmentOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.ARITHMETIC_OPERATOR:
				return convertArithmeticOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.LOGICAL_OPERATOR:
				return convertLogicalOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.COMPARE_OPERATOR:
				return convertCompareOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.QUANTIFIER:
				return convertQuantifierToString(eDataType, instanceValue);
			case ExpressionsPackage.INCREMENT_DECREMENT_OPERATOR:
				return convertIncrementDecrementOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.INCREMENT_DECREMENT_POSITION:
				return convertIncrementDecrementPositionToString(eDataType, instanceValue);
			case ExpressionsPackage.BIT_SHIFT_OPERATOR:
				return convertBitShiftOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.MIN_MAX_OPERATOR:
				return convertMinMaxOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.BITWISE_OPERATOR:
				return convertBitwiseOperatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NegationExpression createNegationExpression() {
		NegationExpressionImpl negationExpression = new NegationExpressionImpl();
		return negationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlusExpression createPlusExpression() {
		PlusExpressionImpl plusExpression = new PlusExpressionImpl();
		return plusExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinusExpression createMinusExpression() {
		MinusExpressionImpl minusExpression = new MinusExpressionImpl();
		return minusExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignmentExpression createAssignmentExpression() {
		AssignmentExpressionImpl assignmentExpression = new AssignmentExpressionImpl();
		return assignmentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierExpression createIdentifierExpression() {
		IdentifierExpressionImpl identifierExpression = new IdentifierExpressionImpl();
		return identifierExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralExpression createLiteralExpression() {
		LiteralExpressionImpl literalExpression = new LiteralExpressionImpl();
		return literalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithmeticExpression createArithmeticExpression() {
		ArithmeticExpressionImpl arithmeticExpression = new ArithmeticExpressionImpl();
		return arithmeticExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalExpression createLogicalExpression() {
		LogicalExpressionImpl logicalExpression = new LogicalExpressionImpl();
		return logicalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionCallExpression createFunctionCallExpression() {
		FunctionCallExpressionImpl functionCallExpression = new FunctionCallExpressionImpl();
		return functionCallExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompareExpression createCompareExpression() {
		CompareExpressionImpl compareExpression = new CompareExpressionImpl();
		return compareExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionExpression createConditionExpression() {
		ConditionExpressionImpl conditionExpression = new ConditionExpressionImpl();
		return conditionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopedIdentifierExpression createScopedIdentifierExpression() {
		ScopedIdentifierExpressionImpl scopedIdentifierExpression = new ScopedIdentifierExpressionImpl();
		return scopedIdentifierExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuantificationExpression createQuantificationExpression() {
		QuantificationExpressionImpl quantificationExpression = new QuantificationExpressionImpl();
		return quantificationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncrementDecrementExpression createIncrementDecrementExpression() {
		IncrementDecrementExpressionImpl incrementDecrementExpression = new IncrementDecrementExpressionImpl();
		return incrementDecrementExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BitShiftExpression createBitShiftExpression() {
		BitShiftExpressionImpl bitShiftExpression = new BitShiftExpressionImpl();
		return bitShiftExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinMaxExpression createMinMaxExpression() {
		MinMaxExpressionImpl minMaxExpression = new MinMaxExpressionImpl();
		return minMaxExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BitwiseExpression createBitwiseExpression() {
		BitwiseExpressionImpl bitwiseExpression = new BitwiseExpressionImpl();
		return bitwiseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignmentOperator createAssignmentOperatorFromString(EDataType eDataType, String initialValue) {
		AssignmentOperator result = AssignmentOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssignmentOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithmeticOperator createArithmeticOperatorFromString(EDataType eDataType, String initialValue) {
		ArithmeticOperator result = ArithmeticOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArithmeticOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalOperator createLogicalOperatorFromString(EDataType eDataType, String initialValue) {
		LogicalOperator result = LogicalOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLogicalOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompareOperator createCompareOperatorFromString(EDataType eDataType, String initialValue) {
		CompareOperator result = CompareOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompareOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quantifier createQuantifierFromString(EDataType eDataType, String initialValue) {
		Quantifier result = Quantifier.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQuantifierToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncrementDecrementOperator createIncrementDecrementOperatorFromString(EDataType eDataType, String initialValue) {
		IncrementDecrementOperator result = IncrementDecrementOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIncrementDecrementOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncrementDecrementPosition createIncrementDecrementPositionFromString(EDataType eDataType, String initialValue) {
		IncrementDecrementPosition result = IncrementDecrementPosition.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIncrementDecrementPositionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BitShiftOperator createBitShiftOperatorFromString(EDataType eDataType, String initialValue) {
		BitShiftOperator result = BitShiftOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBitShiftOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinMaxOperator createMinMaxOperatorFromString(EDataType eDataType, String initialValue) {
		MinMaxOperator result = MinMaxOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMinMaxOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BitwiseOperator createBitwiseOperatorFromString(EDataType eDataType, String initialValue) {
		BitwiseOperator result = BitwiseOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBitwiseOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsPackage getExpressionsPackage() {
		return (ExpressionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExpressionsPackage getPackage() {
		return ExpressionsPackage.eINSTANCE;
	}

} //ExpressionsFactoryImpl
