/**
 */
package de.uni_paderborn.uppaal.statements.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uni_paderborn.uppaal.declarations.util.DeclarationsValidator;
import de.uni_paderborn.uppaal.statements.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uni_paderborn.uppaal.statements.StatementsPackage
 * @generated
 */
public class StatementsValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final StatementsValidator INSTANCE = new StatementsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uni_paderborn.uppaal.statements";

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
	public StatementsValidator() {
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
	  return StatementsPackage.eINSTANCE;
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
			case StatementsPackage.STATEMENT:
				return validateStatement((Statement)value, diagnostics, context);
			case StatementsPackage.BLOCK:
				return validateBlock((Block)value, diagnostics, context);
			case StatementsPackage.EMPTY_STATEMENT:
				return validateEmptyStatement((EmptyStatement)value, diagnostics, context);
			case StatementsPackage.FOR_LOOP:
				return validateForLoop((ForLoop)value, diagnostics, context);
			case StatementsPackage.ITERATION:
				return validateIteration((Iteration)value, diagnostics, context);
			case StatementsPackage.WHILE_LOOP:
				return validateWhileLoop((WhileLoop)value, diagnostics, context);
			case StatementsPackage.DO_WHILE_LOOP:
				return validateDoWhileLoop((DoWhileLoop)value, diagnostics, context);
			case StatementsPackage.IF_STATEMENT:
				return validateIfStatement((IfStatement)value, diagnostics, context);
			case StatementsPackage.RETURN_STATEMENT:
				return validateReturnStatement((ReturnStatement)value, diagnostics, context);
			case StatementsPackage.EXPRESSION_STATEMENT:
				return validateExpressionStatement((ExpressionStatement)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStatement(Statement statement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(statement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlock(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(block, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(block, diagnostics, context);
		if (result || diagnostics != null) result &= validateBlock_DataVariableDeclarationsOnly(block, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the DataVariableDeclarationsOnly constraint of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BLOCK__DATA_VARIABLE_DECLARATIONS_ONLY__EEXPRESSION = "(not self.declarations.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"(self.declarations.declaration->forAll(oclIsKindOf(declarations::DataVariableDeclaration)))";

	/**
	 * Validates the DataVariableDeclarationsOnly constraint of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlock_DataVariableDeclarationsOnly(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(StatementsPackage.Literals.BLOCK,
				 block,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "DataVariableDeclarationsOnly",
				 BLOCK__DATA_VARIABLE_DECLARATIONS_ONLY__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEmptyStatement(EmptyStatement emptyStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(emptyStatement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForLoop(ForLoop forLoop, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(forLoop, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteration(Iteration iteration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(iteration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= declarationsValidator.validateVariableContainer_NoVoidVariables(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= declarationsValidator.validateVariableContainer_UniqueVariableNames(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteration_SingleVariable(iteration, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the SingleVariable constraint of '<em>Iteration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ITERATION__SINGLE_VARIABLE__EEXPRESSION = "self.variable->size() <= 1";

	/**
	 * Validates the SingleVariable constraint of '<em>Iteration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteration_SingleVariable(Iteration iteration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(StatementsPackage.Literals.ITERATION,
				 iteration,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "SingleVariable",
				 ITERATION__SINGLE_VARIABLE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWhileLoop(WhileLoop whileLoop, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(whileLoop, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDoWhileLoop(DoWhileLoop doWhileLoop, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(doWhileLoop, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfStatement(IfStatement ifStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(ifStatement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReturnStatement(ReturnStatement returnStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(returnStatement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionStatement(ExpressionStatement expressionStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expressionStatement, diagnostics, context);
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

} //StatementsValidator
