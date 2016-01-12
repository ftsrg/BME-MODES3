/**
 */
package de.uni_paderborn.uppaal.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uni_paderborn.uppaal.*;
import de.uni_paderborn.uppaal.core.util.CoreValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uni_paderborn.uppaal.UppaalPackage
 * @generated
 */
public class UppaalValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final UppaalValidator INSTANCE = new UppaalValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uni_paderborn.uppaal";

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
	public UppaalValidator() {
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
	  return UppaalPackage.eINSTANCE;
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
			case UppaalPackage.NTA:
				return validateNTA((NTA)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNTA(NTA nta, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(nta, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(nta, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(nta, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(nta, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(nta, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(nta, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(nta, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(nta, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(nta, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoWhitespace(nta, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoDigitStart(nta, diagnostics, context);
		if (result || diagnostics != null) result &= validateNTA_MatchingIntDetails(nta, diagnostics, context);
		if (result || diagnostics != null) result &= validateNTA_MatchingBoolDetails(nta, diagnostics, context);
		if (result || diagnostics != null) result &= validateNTA_MatchingClockDetails(nta, diagnostics, context);
		if (result || diagnostics != null) result &= validateNTA_MatchingChanDetails(nta, diagnostics, context);
		if (result || diagnostics != null) result &= validateNTA_MatchingVoidDetails(nta, diagnostics, context);
		if (result || diagnostics != null) result &= validateNTA_UniqueTemplateNames(nta, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the MatchingIntDetails constraint of '<em>NTA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String NTA__MATCHING_INT_DETAILS__EEXPRESSION = "(not self.int.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"((self.int.type = types::BuiltInType::INT) and (self.int.name.equalsIgnoreCase('int')))";

	/**
	 * Validates the MatchingIntDetails constraint of '<em>NTA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNTA_MatchingIntDetails(NTA nta, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(UppaalPackage.Literals.NTA,
				 nta,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "MatchingIntDetails",
				 NTA__MATCHING_INT_DETAILS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the MatchingBoolDetails constraint of '<em>NTA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String NTA__MATCHING_BOOL_DETAILS__EEXPRESSION = "(not self.bool.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"((self.bool.type = types::BuiltInType::BOOL) and (self.bool.name.equalsIgnoreCase('bool')))";

	/**
	 * Validates the MatchingBoolDetails constraint of '<em>NTA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNTA_MatchingBoolDetails(NTA nta, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(UppaalPackage.Literals.NTA,
				 nta,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "MatchingBoolDetails",
				 NTA__MATCHING_BOOL_DETAILS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the MatchingClockDetails constraint of '<em>NTA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String NTA__MATCHING_CLOCK_DETAILS__EEXPRESSION = "(not self.clock.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"((self.clock.type = types::BuiltInType::CLOCK) and (self.clock.name.equalsIgnoreCase('clock')))";

	/**
	 * Validates the MatchingClockDetails constraint of '<em>NTA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNTA_MatchingClockDetails(NTA nta, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(UppaalPackage.Literals.NTA,
				 nta,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "MatchingClockDetails",
				 NTA__MATCHING_CLOCK_DETAILS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the MatchingChanDetails constraint of '<em>NTA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String NTA__MATCHING_CHAN_DETAILS__EEXPRESSION = "(not self.chan.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"((self.chan.type = types::BuiltInType::CHAN) and (self.chan.name.equalsIgnoreCase('chan')))";

	/**
	 * Validates the MatchingChanDetails constraint of '<em>NTA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNTA_MatchingChanDetails(NTA nta, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(UppaalPackage.Literals.NTA,
				 nta,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "MatchingChanDetails",
				 NTA__MATCHING_CHAN_DETAILS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the MatchingVoidDetails constraint of '<em>NTA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String NTA__MATCHING_VOID_DETAILS__EEXPRESSION = "(not self.void.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"((self.void.type = types::BuiltInType::VOID) and (self.void.name.equalsIgnoreCase('void')))";

	/**
	 * Validates the MatchingVoidDetails constraint of '<em>NTA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNTA_MatchingVoidDetails(NTA nta, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(UppaalPackage.Literals.NTA,
				 nta,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "MatchingVoidDetails",
				 NTA__MATCHING_VOID_DETAILS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the UniqueTemplateNames constraint of '<em>NTA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String NTA__UNIQUE_TEMPLATE_NAMES__EEXPRESSION = "self.template->isUnique(name)";

	/**
	 * Validates the UniqueTemplateNames constraint of '<em>NTA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNTA_UniqueTemplateNames(NTA nta, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(UppaalPackage.Literals.NTA,
				 nta,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "UniqueTemplateNames",
				 NTA__UNIQUE_TEMPLATE_NAMES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
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

} //UppaalValidator
