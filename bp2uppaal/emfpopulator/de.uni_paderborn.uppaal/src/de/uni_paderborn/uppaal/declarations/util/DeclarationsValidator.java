/**
 */
package de.uni_paderborn.uppaal.declarations.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uni_paderborn.uppaal.core.util.CoreValidator;
import de.uni_paderborn.uppaal.declarations.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage
 * @generated
 */
public class DeclarationsValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final DeclarationsValidator INSTANCE = new DeclarationsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uni_paderborn.uppaal.declarations";

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
	protected CoreValidator coreValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclarationsValidator() {
		super();
		coreValidator = CoreValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return DeclarationsPackage.eINSTANCE;
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
			case DeclarationsPackage.DECLARATIONS:
				return validateDeclarations((Declarations)value, diagnostics, context);
			case DeclarationsPackage.GLOBAL_DECLARATIONS:
				return validateGlobalDeclarations((GlobalDeclarations)value, diagnostics, context);
			case DeclarationsPackage.LOCAL_DECLARATIONS:
				return validateLocalDeclarations((LocalDeclarations)value, diagnostics, context);
			case DeclarationsPackage.SYSTEM_DECLARATIONS:
				return validateSystemDeclarations((SystemDeclarations)value, diagnostics, context);
			case DeclarationsPackage.DECLARATION:
				return validateDeclaration((Declaration)value, diagnostics, context);
			case DeclarationsPackage.VARIABLE_DECLARATION:
				return validateVariableDeclaration((VariableDeclaration)value, diagnostics, context);
			case DeclarationsPackage.CHANNEL_VARIABLE_DECLARATION:
				return validateChannelVariableDeclaration((ChannelVariableDeclaration)value, diagnostics, context);
			case DeclarationsPackage.CLOCK_VARIABLE_DECLARATION:
				return validateClockVariableDeclaration((ClockVariableDeclaration)value, diagnostics, context);
			case DeclarationsPackage.DATA_VARIABLE_DECLARATION:
				return validateDataVariableDeclaration((DataVariableDeclaration)value, diagnostics, context);
			case DeclarationsPackage.FUNCTION_DECLARATION:
				return validateFunctionDeclaration((FunctionDeclaration)value, diagnostics, context);
			case DeclarationsPackage.FUNCTION:
				return validateFunction((Function)value, diagnostics, context);
			case DeclarationsPackage.TYPE_DECLARATION:
				return validateTypeDeclaration((TypeDeclaration)value, diagnostics, context);
			case DeclarationsPackage.VARIABLE:
				return validateVariable((Variable)value, diagnostics, context);
			case DeclarationsPackage.INDEX:
				return validateIndex((Index)value, diagnostics, context);
			case DeclarationsPackage.VALUE_INDEX:
				return validateValueIndex((ValueIndex)value, diagnostics, context);
			case DeclarationsPackage.TYPE_INDEX:
				return validateTypeIndex((TypeIndex)value, diagnostics, context);
			case DeclarationsPackage.VARIABLE_CONTAINER:
				return validateVariableContainer((VariableContainer)value, diagnostics, context);
			case DeclarationsPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case DeclarationsPackage.INITIALIZER:
				return validateInitializer((Initializer)value, diagnostics, context);
			case DeclarationsPackage.EXPRESSION_INITIALIZER:
				return validateExpressionInitializer((ExpressionInitializer)value, diagnostics, context);
			case DeclarationsPackage.ARRAY_INITIALIZER:
				return validateArrayInitializer((ArrayInitializer)value, diagnostics, context);
			case DeclarationsPackage.DATA_VARIABLE_PREFIX:
				return validateDataVariablePrefix((DataVariablePrefix)value, diagnostics, context);
			case DeclarationsPackage.CALL_TYPE:
				return validateCallType((CallType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeclarations(Declarations declarations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(declarations, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(declarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(declarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(declarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(declarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(declarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(declarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(declarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(declarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeclarations_UniqueFunctionNames(declarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeclarations_UniqueVariableNames(declarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeclarations_UniqueTypeNames(declarations, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the UniqueFunctionNames constraint of '<em>Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String DECLARATIONS__UNIQUE_FUNCTION_NAMES__EEXPRESSION = "self.declaration->select(oclIsKindOf(FunctionDeclaration)).oclAsType(FunctionDeclaration)->collect(function)->isUnique(name)";

	/**
	 * Validates the UniqueFunctionNames constraint of '<em>Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeclarations_UniqueFunctionNames(Declarations declarations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.DECLARATIONS,
				 declarations,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "UniqueFunctionNames",
				 DECLARATIONS__UNIQUE_FUNCTION_NAMES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the UniqueVariableNames constraint of '<em>Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String DECLARATIONS__UNIQUE_VARIABLE_NAMES__EEXPRESSION = "self.declaration->select(oclIsKindOf(VariableDeclaration)).oclAsType(VariableDeclaration)->collect(variable)->isUnique(name)";

	/**
	 * Validates the UniqueVariableNames constraint of '<em>Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeclarations_UniqueVariableNames(Declarations declarations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.DECLARATIONS,
				 declarations,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "UniqueVariableNames",
				 DECLARATIONS__UNIQUE_VARIABLE_NAMES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the UniqueTypeNames constraint of '<em>Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String DECLARATIONS__UNIQUE_TYPE_NAMES__EEXPRESSION = "self.declaration->select(oclIsKindOf(TypeDeclaration)).oclAsType(TypeDeclaration)->collect(type)->isUnique(name)";

	/**
	 * Validates the UniqueTypeNames constraint of '<em>Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeclarations_UniqueTypeNames(Declarations declarations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.DECLARATIONS,
				 declarations,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "UniqueTypeNames",
				 DECLARATIONS__UNIQUE_TYPE_NAMES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalDeclarations(GlobalDeclarations globalDeclarations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(globalDeclarations, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(globalDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(globalDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(globalDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(globalDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(globalDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(globalDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(globalDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(globalDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeclarations_UniqueFunctionNames(globalDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeclarations_UniqueVariableNames(globalDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeclarations_UniqueTypeNames(globalDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateGlobalDeclarations_NoTemplateDeclarations(globalDeclarations, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the NoTemplateDeclarations constraint of '<em>Global Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String GLOBAL_DECLARATIONS__NO_TEMPLATE_DECLARATIONS__EEXPRESSION = "not self.declaration->exists(oclIsKindOf(system::TemplateDeclaration))";

	/**
	 * Validates the NoTemplateDeclarations constraint of '<em>Global Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalDeclarations_NoTemplateDeclarations(GlobalDeclarations globalDeclarations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.GLOBAL_DECLARATIONS,
				 globalDeclarations,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "NoTemplateDeclarations",
				 GLOBAL_DECLARATIONS__NO_TEMPLATE_DECLARATIONS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalDeclarations(LocalDeclarations localDeclarations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(localDeclarations, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(localDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(localDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(localDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(localDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(localDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(localDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(localDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(localDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeclarations_UniqueFunctionNames(localDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeclarations_UniqueVariableNames(localDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeclarations_UniqueTypeNames(localDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalDeclarations_NoTemplateDeclarations(localDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalDeclarations_NoChannelDeclarations(localDeclarations, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the NoTemplateDeclarations constraint of '<em>Local Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String LOCAL_DECLARATIONS__NO_TEMPLATE_DECLARATIONS__EEXPRESSION = "not self.declaration->exists(oclIsKindOf(system::TemplateDeclaration))";

	/**
	 * Validates the NoTemplateDeclarations constraint of '<em>Local Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalDeclarations_NoTemplateDeclarations(LocalDeclarations localDeclarations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.LOCAL_DECLARATIONS,
				 localDeclarations,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "NoTemplateDeclarations",
				 LOCAL_DECLARATIONS__NO_TEMPLATE_DECLARATIONS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the NoChannelDeclarations constraint of '<em>Local Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String LOCAL_DECLARATIONS__NO_CHANNEL_DECLARATIONS__EEXPRESSION = "not self.declaration->exists(oclIsKindOf(ChannelVariableDeclaration))";

	/**
	 * Validates the NoChannelDeclarations constraint of '<em>Local Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalDeclarations_NoChannelDeclarations(LocalDeclarations localDeclarations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.LOCAL_DECLARATIONS,
				 localDeclarations,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "NoChannelDeclarations",
				 LOCAL_DECLARATIONS__NO_CHANNEL_DECLARATIONS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemDeclarations(SystemDeclarations systemDeclarations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(systemDeclarations, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(systemDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(systemDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(systemDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(systemDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(systemDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(systemDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(systemDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(systemDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeclarations_UniqueFunctionNames(systemDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeclarations_UniqueVariableNames(systemDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeclarations_UniqueTypeNames(systemDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateSystemDeclarations_UniqueTemplateNames(systemDeclarations, diagnostics, context);
		if (result || diagnostics != null) result &= validateSystemDeclarations_NoChannelDeclarations(systemDeclarations, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the UniqueTemplateNames constraint of '<em>System Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String SYSTEM_DECLARATIONS__UNIQUE_TEMPLATE_NAMES__EEXPRESSION = "self.declaration->select(oclIsKindOf(system::TemplateDeclaration)).oclAsType(system::TemplateDeclaration)->collect(declaredTemplate)->isUnique(name)";

	/**
	 * Validates the UniqueTemplateNames constraint of '<em>System Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemDeclarations_UniqueTemplateNames(SystemDeclarations systemDeclarations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.SYSTEM_DECLARATIONS,
				 systemDeclarations,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "UniqueTemplateNames",
				 SYSTEM_DECLARATIONS__UNIQUE_TEMPLATE_NAMES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the NoChannelDeclarations constraint of '<em>System Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String SYSTEM_DECLARATIONS__NO_CHANNEL_DECLARATIONS__EEXPRESSION = "not self.declaration->exists(oclIsKindOf(ChannelVariableDeclaration))";

	/**
	 * Validates the NoChannelDeclarations constraint of '<em>System Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemDeclarations_NoChannelDeclarations(SystemDeclarations systemDeclarations, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.SYSTEM_DECLARATIONS,
				 systemDeclarations,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "NoChannelDeclarations",
				 SYSTEM_DECLARATIONS__NO_CHANNEL_DECLARATIONS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeclaration(Declaration declaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(declaration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableDeclaration(VariableDeclaration variableDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(variableDeclaration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableContainer_NoVoidVariables(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableContainer_UniqueVariableNames(variableDeclaration, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChannelVariableDeclaration(ChannelVariableDeclaration channelVariableDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(channelVariableDeclaration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(channelVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(channelVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(channelVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(channelVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(channelVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(channelVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(channelVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(channelVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableContainer_NoVoidVariables(channelVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableContainer_UniqueVariableNames(channelVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateChannelVariableDeclaration_MatchingType(channelVariableDeclaration, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the MatchingType constraint of '<em>Channel Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CHANNEL_VARIABLE_DECLARATION__MATCHING_TYPE__EEXPRESSION = "(not self.typeDefinition.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"self.typeDefinition.baseType = types::BuiltInType::CHAN";

	/**
	 * Validates the MatchingType constraint of '<em>Channel Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChannelVariableDeclaration_MatchingType(ChannelVariableDeclaration channelVariableDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.CHANNEL_VARIABLE_DECLARATION,
				 channelVariableDeclaration,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "MatchingType",
				 CHANNEL_VARIABLE_DECLARATION__MATCHING_TYPE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClockVariableDeclaration(ClockVariableDeclaration clockVariableDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(clockVariableDeclaration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(clockVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(clockVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(clockVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(clockVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(clockVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(clockVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(clockVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(clockVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableContainer_NoVoidVariables(clockVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableContainer_UniqueVariableNames(clockVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateClockVariableDeclaration_MatchingType(clockVariableDeclaration, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the MatchingType constraint of '<em>Clock Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CLOCK_VARIABLE_DECLARATION__MATCHING_TYPE__EEXPRESSION = "(not self.typeDefinition.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"self.typeDefinition.baseType = types::BuiltInType::CLOCK";

	/**
	 * Validates the MatchingType constraint of '<em>Clock Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClockVariableDeclaration_MatchingType(ClockVariableDeclaration clockVariableDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.CLOCK_VARIABLE_DECLARATION,
				 clockVariableDeclaration,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "MatchingType",
				 CLOCK_VARIABLE_DECLARATION__MATCHING_TYPE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataVariableDeclaration(DataVariableDeclaration dataVariableDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dataVariableDeclaration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(dataVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dataVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dataVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dataVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dataVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dataVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dataVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dataVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableContainer_NoVoidVariables(dataVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableContainer_UniqueVariableNames(dataVariableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataVariableDeclaration_MatchingType(dataVariableDeclaration, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the MatchingType constraint of '<em>Data Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String DATA_VARIABLE_DECLARATION__MATCHING_TYPE__EEXPRESSION = "(not self.typeDefinition.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"(self.typeDefinition.baseType <> types::BuiltInType::CHAN\r\n" +
		"and\r\n" +
		"self.typeDefinition.baseType <> types::BuiltInType::CLOCK)";

	/**
	 * Validates the MatchingType constraint of '<em>Data Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataVariableDeclaration_MatchingType(DataVariableDeclaration dataVariableDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.DATA_VARIABLE_DECLARATION,
				 dataVariableDeclaration,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "MatchingType",
				 DATA_VARIABLE_DECLARATION__MATCHING_TYPE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionDeclaration(FunctionDeclaration functionDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(functionDeclaration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(function, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(function, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoWhitespace(function, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoDigitStart(function, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunction_ValidReturnType(function, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunction_UniqueParameterNames(function, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the ValidReturnType constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String FUNCTION__VALID_RETURN_TYPE__EEXPRESSION = "(not returnType.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"(returnType.baseType = types::BuiltInType::VOID or\r\n" +
		" returnType.baseType = types::BuiltInType::INT or\r\n" +
		" returnType.baseType = types::BuiltInType::BOOL)";

	/**
	 * Validates the ValidReturnType constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction_ValidReturnType(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.FUNCTION,
				 function,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "ValidReturnType",
				 FUNCTION__VALID_RETURN_TYPE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the UniqueParameterNames constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String FUNCTION__UNIQUE_PARAMETER_NAMES__EEXPRESSION = "self.parameter->collect(variableDeclaration)->collect(variable)->isUnique(name)";

	/**
	 * Validates the UniqueParameterNames constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction_UniqueParameterNames(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.FUNCTION,
				 function,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "UniqueParameterNames",
				 FUNCTION__UNIQUE_PARAMETER_NAMES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeDeclaration(TypeDeclaration typeDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeDeclaration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(typeDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typeDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typeDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(typeDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(typeDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(typeDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(typeDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typeDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypeDeclaration_UniqueTypeNames(typeDeclaration, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the UniqueTypeNames constraint of '<em>Type Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TYPE_DECLARATION__UNIQUE_TYPE_NAMES__EEXPRESSION = "self.type->isUnique(name)";

	/**
	 * Validates the UniqueTypeNames constraint of '<em>Type Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeDeclaration_UniqueTypeNames(TypeDeclaration typeDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.TYPE_DECLARATION,
				 typeDeclaration,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "UniqueTypeNames",
				 TYPE_DECLARATION__UNIQUE_TYPE_NAMES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariable(Variable variable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(variable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variable, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoWhitespace(variable, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoDigitStart(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariable_NoInitializerForClockAndChannelVariables(variable, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the NoInitializerForClockAndChannelVariables constraint of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String VARIABLE__NO_INITIALIZER_FOR_CLOCK_AND_CHANNEL_VARIABLES__EEXPRESSION = "((not self.typeDefinition.oclIsUndefined()) and\r\n" +
		"(self.typeDefinition.baseType = types::BuiltInType::CHAN or\r\n" +
		" self.typeDefinition.baseType = types::BuiltInType::CLOCK))\r\n" +
		" implies self.initializer.oclIsUndefined()";

	/**
	 * Validates the NoInitializerForClockAndChannelVariables constraint of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariable_NoInitializerForClockAndChannelVariables(Variable variable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.VARIABLE,
				 variable,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "NoInitializerForClockAndChannelVariables",
				 VARIABLE__NO_INITIALIZER_FOR_CLOCK_AND_CHANNEL_VARIABLES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIndex(Index index, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(index, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueIndex(ValueIndex valueIndex, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(valueIndex, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeIndex(TypeIndex typeIndex, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeIndex, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(typeIndex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typeIndex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typeIndex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(typeIndex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(typeIndex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(typeIndex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(typeIndex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typeIndex, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypeIndex_IntegerBasedIndex(typeIndex, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the IntegerBasedIndex constraint of '<em>Type Index</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TYPE_INDEX__INTEGER_BASED_INDEX__EEXPRESSION = "(not self.typeDefinition.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"self.typeDefinition.baseType = types::BuiltInType::INT";

	/**
	 * Validates the IntegerBasedIndex constraint of '<em>Type Index</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeIndex_IntegerBasedIndex(TypeIndex typeIndex, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.TYPE_INDEX,
				 typeIndex,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "IntegerBasedIndex",
				 TYPE_INDEX__INTEGER_BASED_INDEX__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableContainer(VariableContainer variableContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(variableContainer, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(variableContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variableContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variableContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(variableContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(variableContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(variableContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(variableContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variableContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableContainer_NoVoidVariables(variableContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableContainer_UniqueVariableNames(variableContainer, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the NoVoidVariables constraint of '<em>Variable Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String VARIABLE_CONTAINER__NO_VOID_VARIABLES__EEXPRESSION = "(not self.typeDefinition.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"self.typeDefinition.baseType <> types::BuiltInType::VOID";

	/**
	 * Validates the NoVoidVariables constraint of '<em>Variable Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableContainer_NoVoidVariables(VariableContainer variableContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.VARIABLE_CONTAINER,
				 variableContainer,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "NoVoidVariables",
				 VARIABLE_CONTAINER__NO_VOID_VARIABLES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the UniqueVariableNames constraint of '<em>Variable Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String VARIABLE_CONTAINER__UNIQUE_VARIABLE_NAMES__EEXPRESSION = "self.variable->isUnique(name)";

	/**
	 * Validates the UniqueVariableNames constraint of '<em>Variable Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableContainer_UniqueVariableNames(VariableContainer variableContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.VARIABLE_CONTAINER,
				 variableContainer,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "UniqueVariableNames",
				 VARIABLE_CONTAINER__UNIQUE_VARIABLE_NAMES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(parameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateParameter_SingleVariable(parameter, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the SingleVariable constraint of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PARAMETER__SINGLE_VARIABLE__EEXPRESSION = "(not self.variableDeclaration.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"self.variableDeclaration.variable->size() <= 1";

	/**
	 * Validates the SingleVariable constraint of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter_SingleVariable(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DeclarationsPackage.Literals.PARAMETER,
				 parameter,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "SingleVariable",
				 PARAMETER__SINGLE_VARIABLE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInitializer(Initializer initializer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(initializer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionInitializer(ExpressionInitializer expressionInitializer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expressionInitializer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArrayInitializer(ArrayInitializer arrayInitializer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(arrayInitializer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataVariablePrefix(DataVariablePrefix dataVariablePrefix, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallType(CallType callType, DiagnosticChain diagnostics, Map<Object, Object> context) {
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

} //DeclarationsValidator
