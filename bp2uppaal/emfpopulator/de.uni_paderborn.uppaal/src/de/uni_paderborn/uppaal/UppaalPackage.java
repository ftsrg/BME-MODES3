/**
 */
package de.uni_paderborn.uppaal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uni_paderborn.uppaal.core.CorePackage;

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
 * Contains Uppaal-specific sub-packages.
 * <!-- end-model-doc -->
 * @see de.uni_paderborn.uppaal.UppaalFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface UppaalPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "uppaal";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.uni-paderborn.de/uppaal/0.4.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "uppaal";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UppaalPackage eINSTANCE = de.uni_paderborn.uppaal.impl.UppaalPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.impl.NTAImpl <em>NTA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.impl.NTAImpl
	 * @see de.uni_paderborn.uppaal.impl.UppaalPackageImpl#getNTA()
	 * @generated
	 */
	int NTA = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NTA__NAME = CorePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NTA__COMMENT = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Global Declarations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NTA__GLOBAL_DECLARATIONS = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Template</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NTA__TEMPLATE = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>System Declarations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NTA__SYSTEM_DECLARATIONS = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Int</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NTA__INT = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Bool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NTA__BOOL = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Clock</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NTA__CLOCK = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Chan</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NTA__CHAN = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Void</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NTA__VOID = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>NTA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NTA_FEATURE_COUNT = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>NTA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NTA_OPERATION_COUNT = CorePackage.NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.NTA <em>NTA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NTA</em>'.
	 * @see de.uni_paderborn.uppaal.NTA
	 * @generated
	 */
	EClass getNTA();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.NTA#getGlobalDeclarations <em>Global Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Global Declarations</em>'.
	 * @see de.uni_paderborn.uppaal.NTA#getGlobalDeclarations()
	 * @see #getNTA()
	 * @generated
	 */
	EReference getNTA_GlobalDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.NTA#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Template</em>'.
	 * @see de.uni_paderborn.uppaal.NTA#getTemplate()
	 * @see #getNTA()
	 * @generated
	 */
	EReference getNTA_Template();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.NTA#getSystemDeclarations <em>System Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>System Declarations</em>'.
	 * @see de.uni_paderborn.uppaal.NTA#getSystemDeclarations()
	 * @see #getNTA()
	 * @generated
	 */
	EReference getNTA_SystemDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.NTA#getInt <em>Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Int</em>'.
	 * @see de.uni_paderborn.uppaal.NTA#getInt()
	 * @see #getNTA()
	 * @generated
	 */
	EReference getNTA_Int();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.NTA#getBool <em>Bool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bool</em>'.
	 * @see de.uni_paderborn.uppaal.NTA#getBool()
	 * @see #getNTA()
	 * @generated
	 */
	EReference getNTA_Bool();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.NTA#getClock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Clock</em>'.
	 * @see de.uni_paderborn.uppaal.NTA#getClock()
	 * @see #getNTA()
	 * @generated
	 */
	EReference getNTA_Clock();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.NTA#getChan <em>Chan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Chan</em>'.
	 * @see de.uni_paderborn.uppaal.NTA#getChan()
	 * @see #getNTA()
	 * @generated
	 */
	EReference getNTA_Chan();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.NTA#getVoid <em>Void</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Void</em>'.
	 * @see de.uni_paderborn.uppaal.NTA#getVoid()
	 * @see #getNTA()
	 * @generated
	 */
	EReference getNTA_Void();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UppaalFactory getUppaalFactory();

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
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.impl.NTAImpl <em>NTA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.impl.NTAImpl
		 * @see de.uni_paderborn.uppaal.impl.UppaalPackageImpl#getNTA()
		 * @generated
		 */
		EClass NTA = eINSTANCE.getNTA();

		/**
		 * The meta object literal for the '<em><b>Global Declarations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NTA__GLOBAL_DECLARATIONS = eINSTANCE.getNTA_GlobalDeclarations();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NTA__TEMPLATE = eINSTANCE.getNTA_Template();

		/**
		 * The meta object literal for the '<em><b>System Declarations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NTA__SYSTEM_DECLARATIONS = eINSTANCE.getNTA_SystemDeclarations();

		/**
		 * The meta object literal for the '<em><b>Int</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NTA__INT = eINSTANCE.getNTA_Int();

		/**
		 * The meta object literal for the '<em><b>Bool</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NTA__BOOL = eINSTANCE.getNTA_Bool();

		/**
		 * The meta object literal for the '<em><b>Clock</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NTA__CLOCK = eINSTANCE.getNTA_Clock();

		/**
		 * The meta object literal for the '<em><b>Chan</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NTA__CHAN = eINSTANCE.getNTA_Chan();

		/**
		 * The meta object literal for the '<em><b>Void</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NTA__VOID = eINSTANCE.getNTA_Void();

	}

} //UppaalPackage
