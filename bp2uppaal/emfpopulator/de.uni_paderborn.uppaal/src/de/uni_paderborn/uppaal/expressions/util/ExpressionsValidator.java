/**
 */
package de.uni_paderborn.uppaal.expressions.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uni_paderborn.uppaal.declarations.util.DeclarationsValidator;
import de.uni_paderborn.uppaal.expressions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ExpressionsValidator INSTANCE = new ExpressionsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uni_paderborn.uppaal.expressions";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclarationsValidator declarationsValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsValidator() {
		super();
		declarationsValidator = DeclarationsValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return ExpressionsPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case ExpressionsPackage.EXPRESSION:
				return validateExpression((Expression)value, diagnostics, context);
			case ExpressionsPackage.NEGATION_EXPRESSION:
				return validateNegationExpression((NegationExpression)value, diagnostics, context);
			case ExpressionsPackage.PLUS_EXPRESSION:
				return validatePlusExpression((PlusExpression)value, diagnostics, context);
			case ExpressionsPackage.MINUS_EXPRESSION:
				return validateMinusExpression((MinusExpression)value, diagnostics, context);
			case ExpressionsPackage.BINARY_EXPRESSION:
				return validateBinaryExpression((BinaryExpression)value, diagnostics, context);
			case ExpressionsPackage.ASSIGNMENT_EXPRESSION:
				return validateAssignmentExpression((AssignmentExpression)value, diagnostics, context);
			case ExpressionsPackage.IDENTIFIER_EXPRESSION:
				return validateIdentifierExpression((IdentifierExpression)value, diagnostics, context);
			case ExpressionsPackage.LITERAL_EXPRESSION:
				return validateLiteralExpression((LiteralExpression)value, diagnostics, context);
			case ExpressionsPackage.ARITHMETIC_EXPRESSION:
				return validateArithmeticExpression((ArithmeticExpression)value, diagnostics, context);
			case ExpressionsPackage.LOGICAL_EXPRESSION:
				return validateLogicalExpression((LogicalExpression)value, diagnostics, context);
			case ExpressionsPackage.FUNCTION_CALL_EXPRESSION:
				return validateFunctionCallExpression((FunctionCallExpression)value, diagnostics, context);
			case ExpressionsPackage.COMPARE_EXPRESSION:
				return validateCompareExpression((CompareExpression)value, diagnostics, context);
			case ExpressionsPackage.CONDITION_EXPRESSION:
				return validateConditionExpression((ConditionExpression)value, diagnostics, context);
			case ExpressionsPackage.SCOPED_IDENTIFIER_EXPRESSION:
				return validateScopedIdentifierExpression((ScopedIdentifierExpression)value, diagnostics, context);
			case ExpressionsPackage.QUANTIFICATION_EXPRESSION:
				return validateQuantificationExpression((QuantificationExpression)value, diagnostics, context);
			case ExpressionsPackage.INCREMENT_DECREMENT_EXPRESSION:
				return validateIncrementDecrementExpression((IncrementDecrementExpression)value, diagnostics, context);
			case ExpressionsPackage.BIT_SHIFT_EXPRESSION:
				return validateBitShiftExpression((BitShiftExpression)value, diagnostics, context);
			case ExpressionsPackage.MIN_MAX_EXPRESSION:
				return validateMinMaxExpression((MinMaxExpression)value, diagnostics, context);
			case ExpressionsPackage.BITWISE_EXPRESSION:
				return validateBitwiseExpression((BitwiseExpression)value, diagnostics, context);
			case ExpressionsPackage.ASSIGNMENT_OPERATOR:
				return validateAssignmentOperator((AssignmentOperator)value, diagnostics, context);
			case ExpressionsPackage.ARITHMETIC_OPERATOR:
				return validateArithmeticOperator((ArithmeticOperator)value, diagnostics, context);
			case ExpressionsPackage.LOGICAL_OPERATOR:
				return validateLogicalOperator((LogicalOperator)value, diagnostics, context);
			case ExpressionsPackage.COMPARE_OPERATOR:
				return validateCompareOperator((CompareOperator)value, diagnostics, context);
			case ExpressionsPackage.QUANTIFIER:
				return validateQuantifier((Quantifier)value, diagnostics, context);
			case ExpressionsPackage.INCREMENT_DECREMENT_OPERATOR:
				return validateIncrementDecrementOperator((IncrementDecrementOperator)value, diagnostics, context);
			case ExpressionsPackage.INCREMENT_DECREMENT_POSITION:
				return validateIncrementDecrementPosition((IncrementDecrementPosition)value, diagnostics, context);
			case ExpressionsPackage.BIT_SHIFT_OPERATOR:
				return validateBitShiftOperator((BitShiftOperator)value, diagnostics, context);
			case ExpressionsPackage.MIN_MAX_OPERATOR:
				return validateMinMaxOperator((MinMaxOperator)value, diagnostics, context);
			case ExpressionsPackage.BITWISE_OPERATOR:
				return validateBitwiseOperator((BitwiseOperator)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpression(Expression expression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNegationExpression(NegationExpression negationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(negationExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlusExpression(PlusExpression plusExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(plusExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMinusExpression(MinusExpression minusExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(minusExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryExpression(BinaryExpression binaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(binaryExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(assignmentExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIdentifierExpression(IdentifierExpression identifierExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(identifierExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteralExpression(LiteralExpression literalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(literalExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArithmeticExpression(ArithmeticExpression arithmeticExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(arithmeticExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLogicalExpression(LogicalExpression logicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(logicalExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionCallExpression(FunctionCallExpression functionCallExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(functionCallExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(functionCallExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(functionCallExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(functionCallExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(functionCallExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(functionCallExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(functionCallExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(functionCallExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(functionCallExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunctionCallExpression_NumberOfArgumentsMatchesDeclaration(functionCallExpression, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the NumberOfArgumentsMatchesDeclaration constraint of '<em>Function Call Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String FUNCTION_CALL_EXPRESSION__NUMBER_OF_ARGUMENTS_MATCHES_DECLARATION__EEXPRESSION = "(not self.function.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"self.argument->size() = self.function.parameter->size()";

	/**
	 * Validates the NumberOfArgumentsMatchesDeclaration constraint of '<em>Function Call Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionCallExpression_NumberOfArgumentsMatchesDeclaration(FunctionCallExpression functionCallExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(ExpressionsPackage.Literals.FUNCTION_CALL_EXPRESSION,
				 functionCallExpression,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "NumberOfArgumentsMatchesDeclaration",
				 FUNCTION_CALL_EXPRESSION__NUMBER_OF_ARGUMENTS_MATCHES_DECLARATION__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompareExpression(CompareExpression compareExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(compareExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionExpression(ConditionExpression conditionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(conditionExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScopedIdentifierExpression(ScopedIdentifierExpression scopedIdentifierExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(scopedIdentifierExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQuantificationExpression(QuantificationExpression quantificationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(quantificationExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(quantificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(quantificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(quantificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(quantificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(quantificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(quantificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(quantificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(quantificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= declarationsValidator.validateVariableContainer_NoVoidVariables(quantificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= declarationsValidator.validateVariableContainer_UniqueVariableNames(quantificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateQuantificationExpression_SingleVariable(quantificationExpression, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the SingleVariable constraint of '<em>Quantification Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String QUANTIFICATION_EXPRESSION__SINGLE_VARIABLE__EEXPRESSION = "self.variable->size() <= 1";

	/**
	 * Validates the SingleVariable constraint of '<em>Quantification Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQuantificationExpression_SingleVariable(QuantificationExpression quantificationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(ExpressionsPackage.Literals.QUANTIFICATION_EXPRESSION,
				 quantificationExpression,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "SingleVariable",
				 QUANTIFICATION_EXPRESSION__SINGLE_VARIABLE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementDecrementExpression(IncrementDecrementExpression incrementDecrementExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(incrementDecrementExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBitShiftExpression(BitShiftExpression bitShiftExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(bitShiftExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMinMaxExpression(MinMaxExpression minMaxExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(minMaxExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBitwiseExpression(BitwiseExpression bitwiseExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(bitwiseExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentOperator(AssignmentOperator assignmentOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArithmeticOperator(ArithmeticOperator arithmeticOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLogicalOperator(LogicalOperator logicalOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompareOperator(CompareOperator compareOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQuantifier(Quantifier quantifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementDecrementOperator(IncrementDecrementOperator incrementDecrementOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementDecrementPosition(IncrementDecrementPosition incrementDecrementPosition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBitShiftOperator(BitShiftOperator bitShiftOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMinMaxOperator(MinMaxOperator minMaxOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBitwiseOperator(BitwiseOperator bitwiseOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //ExpressionsValidator
