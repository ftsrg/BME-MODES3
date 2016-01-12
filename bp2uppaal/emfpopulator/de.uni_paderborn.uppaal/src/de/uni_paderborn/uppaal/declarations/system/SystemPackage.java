/**
 */
package de.uni_paderborn.uppaal.declarations.system;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uni_paderborn.uppaal.declarations.DeclarationsPackage;

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
 * Contains special classes that are relevant for the system declarations.
 * <!-- end-model-doc -->
 * @see de.uni_paderborn.uppaal.declarations.system.SystemFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface SystemPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "system";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.uni-paderborn.de/uppaal/declarations/system";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "system";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SystemPackage eINSTANCE = de.uni_paderborn.uppaal.declarations.system.impl.SystemPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.system.impl.TemplateDeclarationImpl <em>Template Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.system.impl.TemplateDeclarationImpl
	 * @see de.uni_paderborn.uppaal.declarations.system.impl.SystemPackageImpl#getTemplateDeclaration()
	 * @generated
	 */
	int TEMPLATE_DECLARATION = 0;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_DECLARATION__EXP = DeclarationsPackage.DECLARATION__EXP;

	/**
	 * The feature id for the '<em><b>Declared Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_DECLARATION__DECLARED_TEMPLATE = DeclarationsPackage.DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_DECLARATION__ARGUMENT = DeclarationsPackage.DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_DECLARATION_FEATURE_COUNT = DeclarationsPackage.DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Template Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_DECLARATION_OPERATION_COUNT = DeclarationsPackage.DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.system.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.system.impl.SystemImpl
	 * @see de.uni_paderborn.uppaal.declarations.system.impl.SystemPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 1;

	/**
	 * The feature id for the '<em><b>Instantiation List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__INSTANTIATION_LIST = 0;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.system.impl.InstantiationListImpl <em>Instantiation List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.system.impl.InstantiationListImpl
	 * @see de.uni_paderborn.uppaal.declarations.system.impl.SystemPackageImpl#getInstantiationList()
	 * @generated
	 */
	int INSTANTIATION_LIST = 2;

	/**
	 * The feature id for the '<em><b>Template</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_LIST__TEMPLATE = 0;

	/**
	 * The number of structural features of the '<em>Instantiation List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_LIST_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Instantiation List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_LIST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.system.impl.ProgressMeasureImpl <em>Progress Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.system.impl.ProgressMeasureImpl
	 * @see de.uni_paderborn.uppaal.declarations.system.impl.SystemPackageImpl#getProgressMeasure()
	 * @generated
	 */
	int PROGRESS_MEASURE = 3;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS_MEASURE__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Progress Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS_MEASURE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Progress Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS_MEASURE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.system.TemplateDeclaration <em>Template Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Declaration</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.system.TemplateDeclaration
	 * @generated
	 */
	EClass getTemplateDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.declarations.system.TemplateDeclaration#getDeclaredTemplate <em>Declared Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declared Template</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.system.TemplateDeclaration#getDeclaredTemplate()
	 * @see #getTemplateDeclaration()
	 * @generated
	 */
	EReference getTemplateDeclaration_DeclaredTemplate();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.declarations.system.TemplateDeclaration#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.system.TemplateDeclaration#getArgument()
	 * @see #getTemplateDeclaration()
	 * @generated
	 */
	EReference getTemplateDeclaration_Argument();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.system.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.system.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.declarations.system.System#getInstantiationList <em>Instantiation List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instantiation List</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.system.System#getInstantiationList()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_InstantiationList();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.system.InstantiationList <em>Instantiation List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instantiation List</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.system.InstantiationList
	 * @generated
	 */
	EClass getInstantiationList();

	/**
	 * Returns the meta object for the reference list '{@link de.uni_paderborn.uppaal.declarations.system.InstantiationList#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Template</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.system.InstantiationList#getTemplate()
	 * @see #getInstantiationList()
	 * @generated
	 */
	EReference getInstantiationList_Template();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.system.ProgressMeasure <em>Progress Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Progress Measure</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.system.ProgressMeasure
	 * @generated
	 */
	EClass getProgressMeasure();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.declarations.system.ProgressMeasure#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expression</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.system.ProgressMeasure#getExpression()
	 * @see #getProgressMeasure()
	 * @generated
	 */
	EReference getProgressMeasure_Expression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SystemFactory getSystemFactory();

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
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.system.impl.TemplateDeclarationImpl <em>Template Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.system.impl.TemplateDeclarationImpl
		 * @see de.uni_paderborn.uppaal.declarations.system.impl.SystemPackageImpl#getTemplateDeclaration()
		 * @generated
		 */
		EClass TEMPLATE_DECLARATION = eINSTANCE.getTemplateDeclaration();

		/**
		 * The meta object literal for the '<em><b>Declared Template</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_DECLARATION__DECLARED_TEMPLATE = eINSTANCE.getTemplateDeclaration_DeclaredTemplate();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_DECLARATION__ARGUMENT = eINSTANCE.getTemplateDeclaration_Argument();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.system.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.system.impl.SystemImpl
		 * @see de.uni_paderborn.uppaal.declarations.system.impl.SystemPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Instantiation List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__INSTANTIATION_LIST = eINSTANCE.getSystem_InstantiationList();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.system.impl.InstantiationListImpl <em>Instantiation List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.system.impl.InstantiationListImpl
		 * @see de.uni_paderborn.uppaal.declarations.system.impl.SystemPackageImpl#getInstantiationList()
		 * @generated
		 */
		EClass INSTANTIATION_LIST = eINSTANCE.getInstantiationList();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION_LIST__TEMPLATE = eINSTANCE.getInstantiationList_Template();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.system.impl.ProgressMeasureImpl <em>Progress Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.system.impl.ProgressMeasureImpl
		 * @see de.uni_paderborn.uppaal.declarations.system.impl.SystemPackageImpl#getProgressMeasure()
		 * @generated
		 */
		EClass PROGRESS_MEASURE = eINSTANCE.getProgressMeasure();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRESS_MEASURE__EXPRESSION = eINSTANCE.getProgressMeasure_Expression();

	}

} //SystemPackage
