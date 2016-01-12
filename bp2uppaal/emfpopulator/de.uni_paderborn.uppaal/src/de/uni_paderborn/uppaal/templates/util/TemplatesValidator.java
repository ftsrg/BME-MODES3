/**
 */
package de.uni_paderborn.uppaal.templates.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uni_paderborn.uppaal.core.util.CoreValidator;
import de.uni_paderborn.uppaal.declarations.util.DeclarationsValidator;
import de.uni_paderborn.uppaal.templates.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uni_paderborn.uppaal.templates.TemplatesPackage
 * @generated
 */
public class TemplatesValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final TemplatesValidator INSTANCE = new TemplatesValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uni_paderborn.uppaal.templates";

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
	public TemplatesValidator() {
		super();
		coreValidator = CoreValidator.INSTANCE;
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
	  return TemplatesPackage.eINSTANCE;
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
			case TemplatesPackage.ABSTRACT_TEMPLATE:
				return validateAbstractTemplate((AbstractTemplate)value, diagnostics, context);
			case TemplatesPackage.TEMPLATE:
				return validateTemplate((Template)value, diagnostics, context);
			case TemplatesPackage.REDEFINED_TEMPLATE:
				return validateRedefinedTemplate((RedefinedTemplate)value, diagnostics, context);
			case TemplatesPackage.LOCATION:
				return validateLocation((Location)value, diagnostics, context);
			case TemplatesPackage.EDGE:
				return validateEdge((Edge)value, diagnostics, context);
			case TemplatesPackage.SYNCHRONIZATION:
				return validateSynchronization((Synchronization)value, diagnostics, context);
			case TemplatesPackage.SELECTION:
				return validateSelection((Selection)value, diagnostics, context);
			case TemplatesPackage.LOCATION_KIND:
				return validateLocationKind((LocationKind)value, diagnostics, context);
			case TemplatesPackage.SYNCHRONIZATION_KIND:
				return validateSynchronizationKind((SynchronizationKind)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractTemplate(AbstractTemplate abstractTemplate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(abstractTemplate, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(abstractTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(abstractTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(abstractTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(abstractTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(abstractTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(abstractTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(abstractTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(abstractTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoWhitespace(abstractTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoDigitStart(abstractTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractTemplate_UniqueParameterNames(abstractTemplate, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the UniqueParameterNames constraint of '<em>Abstract Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ABSTRACT_TEMPLATE__UNIQUE_PARAMETER_NAMES__EEXPRESSION = "self.parameter->collect(variableDeclaration)->collect(variable)->isUnique(name)";

	/**
	 * Validates the UniqueParameterNames constraint of '<em>Abstract Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractTemplate_UniqueParameterNames(AbstractTemplate abstractTemplate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(TemplatesPackage.Literals.ABSTRACT_TEMPLATE,
				 abstractTemplate,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "UniqueParameterNames",
				 ABSTRACT_TEMPLATE__UNIQUE_PARAMETER_NAMES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplate(Template template, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(template, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(template, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(template, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(template, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(template, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(template, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(template, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(template, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(template, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoWhitespace(template, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoDigitStart(template, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractTemplate_UniqueParameterNames(template, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplate_UniqueLocationNames(template, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the UniqueLocationNames constraint of '<em>Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TEMPLATE__UNIQUE_LOCATION_NAMES__EEXPRESSION = "self.location->isUnique(name)";

	/**
	 * Validates the UniqueLocationNames constraint of '<em>Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplate_UniqueLocationNames(Template template, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(TemplatesPackage.Literals.TEMPLATE,
				 template,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "UniqueLocationNames",
				 TEMPLATE__UNIQUE_LOCATION_NAMES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRedefinedTemplate(RedefinedTemplate redefinedTemplate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(redefinedTemplate, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(redefinedTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(redefinedTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(redefinedTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(redefinedTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(redefinedTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(redefinedTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(redefinedTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(redefinedTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoWhitespace(redefinedTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoDigitStart(redefinedTemplate, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractTemplate_UniqueParameterNames(redefinedTemplate, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocation(Location location, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(location, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(location, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(location, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(location, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(location, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(location, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(location, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(location, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(location, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoWhitespace(location, diagnostics, context);
		if (result || diagnostics != null) result &= coreValidator.validateNamedElement_NoDigitStart(location, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEdge(Edge edge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(edge, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(edge, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(edge, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(edge, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(edge, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(edge, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(edge, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(edge, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(edge, diagnostics, context);
		if (result || diagnostics != null) result &= validateEdge_UniqueParentTemplate(edge, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the UniqueParentTemplate constraint of '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String EDGE__UNIQUE_PARENT_TEMPLATE__EEXPRESSION = "(not (self.source.oclIsUndefined() or self.target.oclIsUndefined()))\r\n" +
		"implies\r\n" +
		"self.source.parentTemplate = self.target.parentTemplate";

	/**
	 * Validates the UniqueParentTemplate constraint of '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEdge_UniqueParentTemplate(Edge edge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(TemplatesPackage.Literals.EDGE,
				 edge,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "UniqueParentTemplate",
				 EDGE__UNIQUE_PARENT_TEMPLATE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSynchronization(Synchronization synchronization, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(synchronization, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validateSynchronization_ChannelVariablesOnly(synchronization, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the ChannelVariablesOnly constraint of '<em>Synchronization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String SYNCHRONIZATION__CHANNEL_VARIABLES_ONLY__EEXPRESSION = "(not self.channelExpression.oclIsUndefined())\r\n" +
		"and\r\n" +
		"(not self.channelExpression.identifier.oclIsUndefined())\r\n" +
		"and\r\n" +
		"(self.channelExpression.identifier.oclIsKindOf(declarations::Variable))\r\n" +
		"and\r\n" +
		"(not self.channelExpression.identifier.oclAsType(declarations::Variable).typeDefinition.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"self.channelExpression.identifier.oclAsType(declarations::Variable).typeDefinition.baseType = types::BuiltInType::CHAN";

	/**
	 * Validates the ChannelVariablesOnly constraint of '<em>Synchronization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSynchronization_ChannelVariablesOnly(Synchronization synchronization, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(TemplatesPackage.Literals.SYNCHRONIZATION,
				 synchronization,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "ChannelVariablesOnly",
				 SYNCHRONIZATION__CHANNEL_VARIABLES_ONLY__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSelection(Selection selection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(selection, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(selection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(selection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(selection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(selection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(selection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(selection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(selection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(selection, diagnostics, context);
		if (result || diagnostics != null) result &= declarationsValidator.validateVariableContainer_NoVoidVariables(selection, diagnostics, context);
		if (result || diagnostics != null) result &= declarationsValidator.validateVariableContainer_UniqueVariableNames(selection, diagnostics, context);
		if (result || diagnostics != null) result &= validateSelection_SingleVariable(selection, diagnostics, context);
		if (result || diagnostics != null) result &= validateSelection_IntegerBasedType(selection, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the SingleVariable constraint of '<em>Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String SELECTION__SINGLE_VARIABLE__EEXPRESSION = "self.variable->size() <= 1";

	/**
	 * Validates the SingleVariable constraint of '<em>Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSelection_SingleVariable(Selection selection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(TemplatesPackage.Literals.SELECTION,
				 selection,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "SingleVariable",
				 SELECTION__SINGLE_VARIABLE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the IntegerBasedType constraint of '<em>Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String SELECTION__INTEGER_BASED_TYPE__EEXPRESSION = "(not self.typeDefinition.oclIsUndefined())\r\n" +
		"implies\r\n" +
		"self.typeDefinition.baseType = types::BuiltInType::INT";

	/**
	 * Validates the IntegerBasedType constraint of '<em>Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSelection_IntegerBasedType(Selection selection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(TemplatesPackage.Literals.SELECTION,
				 selection,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "IntegerBasedType",
				 SELECTION__INTEGER_BASED_TYPE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocationKind(LocationKind locationKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSynchronizationKind(SynchronizationKind synchronizationKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
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

} //TemplatesValidator
