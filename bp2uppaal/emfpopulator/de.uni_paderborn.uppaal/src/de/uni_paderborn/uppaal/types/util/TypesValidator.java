/**
 */
package de.uni_paderborn.uppaal.types.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uni_paderborn.uppaal.core.util.CoreValidator;
import de.uni_paderborn.uppaal.types.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uni_paderborn.uppaal.types.TypesPackage
 * @generated
 */
public class TypesValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final TypesValidator INSTANCE = new TypesValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uni_paderborn.uppaal.types";

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
	public TypesValidator() {
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
	  return TypesPackage.eINSTANCE;
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
			case TypesPackage.TYPE:
				return validateType((Type)value, diagnostics, context);
			case TypesPackage.PREDEFINED_TYPE:
				return validatePredefinedType((PredefinedType)value, diagnostics, context);
			case TypesPackage.DECLARED_TYPE:
				return validateDeclaredType((DeclaredType)value, diagnostics, context);
			case TypesPackage.TYPE_DEFINITION:
				return validateTypeDefinition((TypeDefinition)value, diagnostics, context);
			case TypesPackage.TYPE_REFERENCE:
				return validateTypeReference((TypeReference)value, diagnostics, context);
			case TypesPackage.TYPE_SPECIFICATION:
				return validateTypeSpecification((TypeSpecification)value, diagnostics, context);
			case TypesPackage.SCALAR_TYPE_SPECIFICATION:
				return validateScalarTypeSpecification((ScalarTypeSpecification)value, diagnostics, context);
			case TypesPackage.STRUCT_TYPE_SPECIFICATION:
				return validateStructTypeSpecification((StructTypeSpecification)value, diagnostics, context);
			case TypesPackage.RANGE_TYPE_SPECIFICATION:
				return validateRangeTypeSpecification((RangeTypeSpecification)value, diagnostics, context);
			case TypesPackage.INTEGER_BOUNDS:
				return validateIntegerBounds((IntegerBounds)value, diagnostics, context);
			case TypesPackage.BUILT_IN_TYPE:
				return validateBuiltInType((BuiltInType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateType(Type type, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(type, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(type, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoWhitespace(type, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoDigitStart(type, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePredefinedType(PredefinedType predefinedType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(predefinedType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(predefinedType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(predefinedType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(predefinedType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(predefinedType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(predefinedType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(predefinedType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(predefinedType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(predefinedType, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoWhitespace(predefinedType, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoDigitStart(predefinedType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeclaredType(DeclaredType declaredType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(declaredType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(declaredType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(declaredType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(declaredType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(declaredType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(declaredType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(declaredType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(declaredType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(declaredType, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoWhitespace(declaredType, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoDigitStart(declaredType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeDefinition(TypeDefinition typeDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(typeDefinition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeReference(TypeReference typeReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(typeReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeSpecification(TypeSpecification typeSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(typeSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScalarTypeSpecification(ScalarTypeSpecification scalarTypeSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(scalarTypeSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructTypeSpecification(StructTypeSpecification structTypeSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(structTypeSpecification, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(structTypeSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(structTypeSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(structTypeSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(structTypeSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(structTypeSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(structTypeSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(structTypeSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(structTypeSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validateStructTypeSpecification_UniqueFieldNames(structTypeSpecification, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the UniqueFieldNames constraint of '<em>Struct Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String STRUCT_TYPE_SPECIFICATION__UNIQUE_FIELD_NAMES__EEXPRESSION = "self.declaration->collect(variable)->isUnique(name)";

	/**
	 * Validates the UniqueFieldNames constraint of '<em>Struct Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructTypeSpecification_UniqueFieldNames(StructTypeSpecification structTypeSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(TypesPackage.Literals.STRUCT_TYPE_SPECIFICATION,
				 structTypeSpecification,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "UniqueFieldNames",
				 STRUCT_TYPE_SPECIFICATION__UNIQUE_FIELD_NAMES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeTypeSpecification(RangeTypeSpecification rangeTypeSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(rangeTypeSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntegerBounds(IntegerBounds integerBounds, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(integerBounds, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBuiltInType(BuiltInType builtInType, DiagnosticChain diagnostics, Map<Object, Object> context) {
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

} //TypesValidator
