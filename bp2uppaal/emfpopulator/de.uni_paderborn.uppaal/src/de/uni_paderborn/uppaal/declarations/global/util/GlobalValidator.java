/**
 */
package de.uni_paderborn.uppaal.declarations.global.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uni_paderborn.uppaal.declarations.global.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uni_paderborn.uppaal.declarations.global.GlobalPackage
 * @generated
 */
public class GlobalValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final GlobalValidator INSTANCE = new GlobalValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uni_paderborn.uppaal.declarations.global";

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
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return GlobalPackage.eINSTANCE;
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
			case GlobalPackage.CHANNEL_PRIORITY:
				return validateChannelPriority((ChannelPriority)value, diagnostics, context);
			case GlobalPackage.CHANNEL_PRIORITY_ITEM:
				return validateChannelPriorityItem((ChannelPriorityItem)value, diagnostics, context);
			case GlobalPackage.CHANNEL_LIST:
				return validateChannelList((ChannelList)value, diagnostics, context);
			case GlobalPackage.DEFAULT_CHANNEL_PRIORITY:
				return validateDefaultChannelPriority((DefaultChannelPriority)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChannelPriority(ChannelPriority channelPriority, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(channelPriority, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(channelPriority, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(channelPriority, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(channelPriority, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(channelPriority, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(channelPriority, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(channelPriority, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(channelPriority, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(channelPriority, diagnostics, context);
		if (result || diagnostics != null) result &= validateChannelPriority_AtMostOneDefaultItem(channelPriority, diagnostics, context);
		if (result || diagnostics != null) result &= validateChannelPriority_EachChannelContainedAtMostOnce(channelPriority, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the AtMostOneDefaultItem constraint of '<em>Channel Priority</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CHANNEL_PRIORITY__AT_MOST_ONE_DEFAULT_ITEM__EEXPRESSION = "self.item->select(oclIsKindOf(DefaultChannelPriority))->size() <= 1";

	/**
	 * Validates the AtMostOneDefaultItem constraint of '<em>Channel Priority</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChannelPriority_AtMostOneDefaultItem(ChannelPriority channelPriority, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GlobalPackage.Literals.CHANNEL_PRIORITY,
				 channelPriority,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "AtMostOneDefaultItem",
				 CHANNEL_PRIORITY__AT_MOST_ONE_DEFAULT_ITEM__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the EachChannelContainedAtMostOnce constraint of '<em>Channel Priority</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CHANNEL_PRIORITY__EACH_CHANNEL_CONTAINED_AT_MOST_ONCE__EEXPRESSION = "self.item->select(oclIsKindOf(ChannelList)).oclAsType(ChannelList)->collect(channelExpression)->isUnique(variable)";

	/**
	 * Validates the EachChannelContainedAtMostOnce constraint of '<em>Channel Priority</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChannelPriority_EachChannelContainedAtMostOnce(ChannelPriority channelPriority, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GlobalPackage.Literals.CHANNEL_PRIORITY,
				 channelPriority,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "EachChannelContainedAtMostOnce",
				 CHANNEL_PRIORITY__EACH_CHANNEL_CONTAINED_AT_MOST_ONCE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChannelPriorityItem(ChannelPriorityItem channelPriorityItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(channelPriorityItem, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChannelList(ChannelList channelList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(channelList, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(channelList, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(channelList, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(channelList, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(channelList, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(channelList, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(channelList, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(channelList, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(channelList, diagnostics, context);
		if (result || diagnostics != null) result &= validateChannelList_ChannelVariablesOnly(channelList, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the ChannelVariablesOnly constraint of '<em>Channel List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CHANNEL_LIST__CHANNEL_VARIABLES_ONLY__EEXPRESSION = "self.channelExpression->forAll(\r\n" +
		"\t(not identifier.typeDefinition.oclIsUndefined()) implies identifier.typeDefinition.baseType = types::BuiltInType::CHAN\r\n" +
		")";

	/**
	 * Validates the ChannelVariablesOnly constraint of '<em>Channel List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChannelList_ChannelVariablesOnly(ChannelList channelList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GlobalPackage.Literals.CHANNEL_LIST,
				 channelList,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "ChannelVariablesOnly",
				 CHANNEL_LIST__CHANNEL_VARIABLES_ONLY__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDefaultChannelPriority(DefaultChannelPriority defaultChannelPriority, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(defaultChannelPriority, diagnostics, context);
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

} //GlobalValidator
