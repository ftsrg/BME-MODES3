/**
 */
package de.uni_paderborn.uppaal.declarations;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * Support for all kinds of declarations, e.g. types, functions, or variables.
 * <!-- end-model-doc -->
 * @see de.uni_paderborn.uppaal.declarations.DeclarationsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface DeclarationsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "declarations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.uni-paderborn.de/uppaal/declarations/0.4.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "declarations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DeclarationsPackage eINSTANCE = de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.DeclarationsImpl <em>Declarations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getDeclarations()
	 * @generated
	 */
	int DECLARATIONS = 0;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATIONS__DECLARATION = 0;

	/**
	 * The number of structural features of the '<em>Declarations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATIONS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Declarations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.GlobalDeclarationsImpl <em>Global Declarations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.GlobalDeclarationsImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getGlobalDeclarations()
	 * @generated
	 */
	int GLOBAL_DECLARATIONS = 1;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_DECLARATIONS__DECLARATION = DECLARATIONS__DECLARATION;

	/**
	 * The feature id for the '<em><b>Channel Priority</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_DECLARATIONS__CHANNEL_PRIORITY = DECLARATIONS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Global Declarations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_DECLARATIONS_FEATURE_COUNT = DECLARATIONS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Global Declarations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_DECLARATIONS_OPERATION_COUNT = DECLARATIONS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.LocalDeclarationsImpl <em>Local Declarations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.LocalDeclarationsImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getLocalDeclarations()
	 * @generated
	 */
	int LOCAL_DECLARATIONS = 2;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DECLARATIONS__DECLARATION = DECLARATIONS__DECLARATION;

	/**
	 * The number of structural features of the '<em>Local Declarations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DECLARATIONS_FEATURE_COUNT = DECLARATIONS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Local Declarations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DECLARATIONS_OPERATION_COUNT = DECLARATIONS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.SystemDeclarationsImpl <em>System Declarations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.SystemDeclarationsImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getSystemDeclarations()
	 * @generated
	 */
	int SYSTEM_DECLARATIONS = 3;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_DECLARATIONS__DECLARATION = DECLARATIONS__DECLARATION;

	/**
	 * The feature id for the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_DECLARATIONS__SYSTEM = DECLARATIONS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Progress Measure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_DECLARATIONS__PROGRESS_MEASURE = DECLARATIONS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>System Declarations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_DECLARATIONS_FEATURE_COUNT = DECLARATIONS_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>System Declarations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_DECLARATIONS_OPERATION_COUNT = DECLARATIONS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.DeclarationImpl <em>Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getDeclaration()
	 * @generated
	 */
	int DECLARATION = 4;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION__EXP = 0;

	/**
	 * The number of structural features of the '<em>Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.VariableDeclarationImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 5;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__EXP = DECLARATION__EXP;

	/**
	 * The feature id for the '<em><b>Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE_DEFINITION = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__VARIABLE = DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_OPERATION_COUNT = DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.ChannelVariableDeclarationImpl <em>Channel Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.ChannelVariableDeclarationImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getChannelVariableDeclaration()
	 * @generated
	 */
	int CHANNEL_VARIABLE_DECLARATION = 6;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_VARIABLE_DECLARATION__EXP = VARIABLE_DECLARATION__EXP;

	/**
	 * The feature id for the '<em><b>Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_VARIABLE_DECLARATION__TYPE_DEFINITION = VARIABLE_DECLARATION__TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_VARIABLE_DECLARATION__VARIABLE = VARIABLE_DECLARATION__VARIABLE;

	/**
	 * The feature id for the '<em><b>Urgent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_VARIABLE_DECLARATION__URGENT = VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Broadcast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_VARIABLE_DECLARATION__BROADCAST = VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Channel Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_VARIABLE_DECLARATION_FEATURE_COUNT = VARIABLE_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Channel Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_VARIABLE_DECLARATION_OPERATION_COUNT = VARIABLE_DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.ClockVariableDeclarationImpl <em>Clock Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.ClockVariableDeclarationImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getClockVariableDeclaration()
	 * @generated
	 */
	int CLOCK_VARIABLE_DECLARATION = 7;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_VARIABLE_DECLARATION__EXP = VARIABLE_DECLARATION__EXP;

	/**
	 * The feature id for the '<em><b>Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_VARIABLE_DECLARATION__TYPE_DEFINITION = VARIABLE_DECLARATION__TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_VARIABLE_DECLARATION__VARIABLE = VARIABLE_DECLARATION__VARIABLE;

	/**
	 * The number of structural features of the '<em>Clock Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_VARIABLE_DECLARATION_FEATURE_COUNT = VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Clock Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_VARIABLE_DECLARATION_OPERATION_COUNT = VARIABLE_DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.DataVariableDeclarationImpl <em>Data Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.DataVariableDeclarationImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getDataVariableDeclaration()
	 * @generated
	 */
	int DATA_VARIABLE_DECLARATION = 8;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DECLARATION__EXP = VARIABLE_DECLARATION__EXP;

	/**
	 * The feature id for the '<em><b>Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DECLARATION__TYPE_DEFINITION = VARIABLE_DECLARATION__TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DECLARATION__VARIABLE = VARIABLE_DECLARATION__VARIABLE;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DECLARATION__PREFIX = VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DECLARATION_FEATURE_COUNT = VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DECLARATION_OPERATION_COUNT = VARIABLE_DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.FunctionDeclarationImpl <em>Function Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.FunctionDeclarationImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getFunctionDeclaration()
	 * @generated
	 */
	int FUNCTION_DECLARATION = 9;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION__EXP = DECLARATION__EXP;

	/**
	 * The feature id for the '<em><b>Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION__FUNCTION = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Function Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Function Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION_OPERATION_COUNT = DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.FunctionImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = CorePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__RETURN_TYPE = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__BLOCK = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PARAMETER = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_OPERATION_COUNT = CorePackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.TypeDeclarationImpl <em>Type Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.TypeDeclarationImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getTypeDeclaration()
	 * @generated
	 */
	int TYPE_DECLARATION = 11;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECLARATION__EXP = DECLARATION__EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECLARATION__TYPE = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECLARATION__TYPE_DEFINITION = DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECLARATION_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Type Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECLARATION_OPERATION_COUNT = DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.VariableImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = CorePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__INDEX = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__CONTAINER = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE_DEFINITION = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__INITIALIZER = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = CorePackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.IndexImpl <em>Index</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.IndexImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getIndex()
	 * @generated
	 */
	int INDEX = 13;

	/**
	 * The number of structural features of the '<em>Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.ValueIndexImpl <em>Value Index</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.ValueIndexImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getValueIndex()
	 * @generated
	 */
	int VALUE_INDEX = 14;

	/**
	 * The feature id for the '<em><b>Size Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_INDEX__SIZE_EXPRESSION = INDEX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_INDEX_FEATURE_COUNT = INDEX_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Value Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_INDEX_OPERATION_COUNT = INDEX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.TypeIndexImpl <em>Type Index</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.TypeIndexImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getTypeIndex()
	 * @generated
	 */
	int TYPE_INDEX = 15;

	/**
	 * The feature id for the '<em><b>Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INDEX__TYPE_DEFINITION = INDEX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INDEX_FEATURE_COUNT = INDEX_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INDEX_OPERATION_COUNT = INDEX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.VariableContainerImpl <em>Variable Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.VariableContainerImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getVariableContainer()
	 * @generated
	 */
	int VARIABLE_CONTAINER = 16;

	/**
	 * The feature id for the '<em><b>Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CONTAINER__TYPE_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CONTAINER__VARIABLE = 1;

	/**
	 * The number of structural features of the '<em>Variable Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Variable Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.ParameterImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 17;

	/**
	 * The feature id for the '<em><b>Variable Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VARIABLE_DECLARATION = 0;

	/**
	 * The feature id for the '<em><b>Call Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__CALL_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.InitializerImpl <em>Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.InitializerImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getInitializer()
	 * @generated
	 */
	int INITIALIZER = 18;

	/**
	 * The number of structural features of the '<em>Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.ExpressionInitializerImpl <em>Expression Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.ExpressionInitializerImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getExpressionInitializer()
	 * @generated
	 */
	int EXPRESSION_INITIALIZER = 19;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_INITIALIZER__EXPRESSION = INITIALIZER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_INITIALIZER_FEATURE_COUNT = INITIALIZER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Expression Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_INITIALIZER_OPERATION_COUNT = INITIALIZER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.impl.ArrayInitializerImpl <em>Array Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.impl.ArrayInitializerImpl
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getArrayInitializer()
	 * @generated
	 */
	int ARRAY_INITIALIZER = 20;

	/**
	 * The feature id for the '<em><b>Initializer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_INITIALIZER__INITIALIZER = INITIALIZER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_INITIALIZER_FEATURE_COUNT = INITIALIZER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Array Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_INITIALIZER_OPERATION_COUNT = INITIALIZER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.DataVariablePrefix <em>Data Variable Prefix</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.DataVariablePrefix
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getDataVariablePrefix()
	 * @generated
	 */
	int DATA_VARIABLE_PREFIX = 21;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.CallType <em>Call Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.CallType
	 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getCallType()
	 * @generated
	 */
	int CALL_TYPE = 22;


	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.Declarations <em>Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declarations</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Declarations
	 * @generated
	 */
	EClass getDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.declarations.Declarations#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declaration</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Declarations#getDeclaration()
	 * @see #getDeclarations()
	 * @generated
	 */
	EReference getDeclarations_Declaration();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.GlobalDeclarations <em>Global Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Declarations</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.GlobalDeclarations
	 * @generated
	 */
	EClass getGlobalDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.declarations.GlobalDeclarations#getChannelPriority <em>Channel Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channel Priority</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.GlobalDeclarations#getChannelPriority()
	 * @see #getGlobalDeclarations()
	 * @generated
	 */
	EReference getGlobalDeclarations_ChannelPriority();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.LocalDeclarations <em>Local Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Declarations</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.LocalDeclarations
	 * @generated
	 */
	EClass getLocalDeclarations();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.SystemDeclarations <em>System Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Declarations</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.SystemDeclarations
	 * @generated
	 */
	EClass getSystemDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.declarations.SystemDeclarations#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>System</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.SystemDeclarations#getSystem()
	 * @see #getSystemDeclarations()
	 * @generated
	 */
	EReference getSystemDeclarations_System();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.declarations.SystemDeclarations#getProgressMeasure <em>Progress Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Progress Measure</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.SystemDeclarations#getProgressMeasure()
	 * @see #getSystemDeclarations()
	 * @generated
	 */
	EReference getSystemDeclarations_ProgressMeasure();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.Declaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declaration</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Declaration
	 * @generated
	 */
	EClass getDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.declarations.Declaration#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exp</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Declaration#getExp()
	 * @see #getDeclaration()
	 * @generated
	 */
	EAttribute getDeclaration_Exp();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.ChannelVariableDeclaration <em>Channel Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel Variable Declaration</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.ChannelVariableDeclaration
	 * @generated
	 */
	EClass getChannelVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.declarations.ChannelVariableDeclaration#isUrgent <em>Urgent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Urgent</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.ChannelVariableDeclaration#isUrgent()
	 * @see #getChannelVariableDeclaration()
	 * @generated
	 */
	EAttribute getChannelVariableDeclaration_Urgent();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.declarations.ChannelVariableDeclaration#isBroadcast <em>Broadcast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broadcast</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.ChannelVariableDeclaration#isBroadcast()
	 * @see #getChannelVariableDeclaration()
	 * @generated
	 */
	EAttribute getChannelVariableDeclaration_Broadcast();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.ClockVariableDeclaration <em>Clock Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock Variable Declaration</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.ClockVariableDeclaration
	 * @generated
	 */
	EClass getClockVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.DataVariableDeclaration <em>Data Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Variable Declaration</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.DataVariableDeclaration
	 * @generated
	 */
	EClass getDataVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.declarations.DataVariableDeclaration#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.DataVariableDeclaration#getPrefix()
	 * @see #getDataVariableDeclaration()
	 * @generated
	 */
	EAttribute getDataVariableDeclaration_Prefix();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.FunctionDeclaration <em>Function Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Declaration</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.FunctionDeclaration
	 * @generated
	 */
	EClass getFunctionDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.declarations.FunctionDeclaration#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Function</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.FunctionDeclaration#getFunction()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	EReference getFunctionDeclaration_Function();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.declarations.Function#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Function#getReturnType()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_ReturnType();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.declarations.Function#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Block</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Function#getBlock()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Block();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.declarations.Function#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Function#getParameter()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Parameter();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.TypeDeclaration <em>Type Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Declaration</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.TypeDeclaration
	 * @generated
	 */
	EClass getTypeDeclaration();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.declarations.TypeDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.TypeDeclaration#getType()
	 * @see #getTypeDeclaration()
	 * @generated
	 */
	EReference getTypeDeclaration_Type();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.declarations.TypeDeclaration#getTypeDefinition <em>Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Definition</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.TypeDeclaration#getTypeDefinition()
	 * @see #getTypeDeclaration()
	 * @generated
	 */
	EReference getTypeDeclaration_TypeDefinition();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.declarations.Variable#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Index</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Variable#getIndex()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Index();

	/**
	 * Returns the meta object for the container reference '{@link de.uni_paderborn.uppaal.declarations.Variable#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Variable#getContainer()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Container();

	/**
	 * Returns the meta object for the reference '{@link de.uni_paderborn.uppaal.declarations.Variable#getTypeDefinition <em>Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Definition</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Variable#getTypeDefinition()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_TypeDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.declarations.Variable#getInitializer <em>Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initializer</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Variable#getInitializer()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Initializer();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.Index <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Index
	 * @generated
	 */
	EClass getIndex();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.ValueIndex <em>Value Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Index</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.ValueIndex
	 * @generated
	 */
	EClass getValueIndex();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.declarations.ValueIndex#getSizeExpression <em>Size Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Size Expression</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.ValueIndex#getSizeExpression()
	 * @see #getValueIndex()
	 * @generated
	 */
	EReference getValueIndex_SizeExpression();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.TypeIndex <em>Type Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Index</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.TypeIndex
	 * @generated
	 */
	EClass getTypeIndex();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.declarations.TypeIndex#getTypeDefinition <em>Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Definition</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.TypeIndex#getTypeDefinition()
	 * @see #getTypeIndex()
	 * @generated
	 */
	EReference getTypeIndex_TypeDefinition();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.VariableContainer <em>Variable Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Container</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.VariableContainer
	 * @generated
	 */
	EClass getVariableContainer();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.declarations.VariableContainer#getTypeDefinition <em>Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Definition</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.VariableContainer#getTypeDefinition()
	 * @see #getVariableContainer()
	 * @generated
	 */
	EReference getVariableContainer_TypeDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.declarations.VariableContainer#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.VariableContainer#getVariable()
	 * @see #getVariableContainer()
	 * @generated
	 */
	EReference getVariableContainer_Variable();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.declarations.Parameter#getVariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Declaration</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Parameter#getVariableDeclaration()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_VariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.declarations.Parameter#getCallType <em>Call Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Call Type</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Parameter#getCallType()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_CallType();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.Initializer <em>Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initializer</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.Initializer
	 * @generated
	 */
	EClass getInitializer();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.ExpressionInitializer <em>Expression Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Initializer</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.ExpressionInitializer
	 * @generated
	 */
	EClass getExpressionInitializer();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.declarations.ExpressionInitializer#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.ExpressionInitializer#getExpression()
	 * @see #getExpressionInitializer()
	 * @generated
	 */
	EReference getExpressionInitializer_Expression();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.ArrayInitializer <em>Array Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Initializer</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.ArrayInitializer
	 * @generated
	 */
	EClass getArrayInitializer();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.declarations.ArrayInitializer#getInitializer <em>Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Initializer</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.ArrayInitializer#getInitializer()
	 * @see #getArrayInitializer()
	 * @generated
	 */
	EReference getArrayInitializer_Initializer();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.declarations.DataVariablePrefix <em>Data Variable Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Variable Prefix</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.DataVariablePrefix
	 * @generated
	 */
	EEnum getDataVariablePrefix();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.declarations.CallType <em>Call Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Call Type</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.CallType
	 * @generated
	 */
	EEnum getCallType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DeclarationsFactory getDeclarationsFactory();

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
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.DeclarationsImpl <em>Declarations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getDeclarations()
		 * @generated
		 */
		EClass DECLARATIONS = eINSTANCE.getDeclarations();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECLARATIONS__DECLARATION = eINSTANCE.getDeclarations_Declaration();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.GlobalDeclarationsImpl <em>Global Declarations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.GlobalDeclarationsImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getGlobalDeclarations()
		 * @generated
		 */
		EClass GLOBAL_DECLARATIONS = eINSTANCE.getGlobalDeclarations();

		/**
		 * The meta object literal for the '<em><b>Channel Priority</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL_DECLARATIONS__CHANNEL_PRIORITY = eINSTANCE.getGlobalDeclarations_ChannelPriority();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.LocalDeclarationsImpl <em>Local Declarations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.LocalDeclarationsImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getLocalDeclarations()
		 * @generated
		 */
		EClass LOCAL_DECLARATIONS = eINSTANCE.getLocalDeclarations();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.SystemDeclarationsImpl <em>System Declarations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.SystemDeclarationsImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getSystemDeclarations()
		 * @generated
		 */
		EClass SYSTEM_DECLARATIONS = eINSTANCE.getSystemDeclarations();

		/**
		 * The meta object literal for the '<em><b>System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_DECLARATIONS__SYSTEM = eINSTANCE.getSystemDeclarations_System();

		/**
		 * The meta object literal for the '<em><b>Progress Measure</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_DECLARATIONS__PROGRESS_MEASURE = eINSTANCE.getSystemDeclarations_ProgressMeasure();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.DeclarationImpl <em>Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getDeclaration()
		 * @generated
		 */
		EClass DECLARATION = eINSTANCE.getDeclaration();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECLARATION__EXP = eINSTANCE.getDeclaration_Exp();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.VariableDeclarationImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.ChannelVariableDeclarationImpl <em>Channel Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.ChannelVariableDeclarationImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getChannelVariableDeclaration()
		 * @generated
		 */
		EClass CHANNEL_VARIABLE_DECLARATION = eINSTANCE.getChannelVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Urgent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANNEL_VARIABLE_DECLARATION__URGENT = eINSTANCE.getChannelVariableDeclaration_Urgent();

		/**
		 * The meta object literal for the '<em><b>Broadcast</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANNEL_VARIABLE_DECLARATION__BROADCAST = eINSTANCE.getChannelVariableDeclaration_Broadcast();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.ClockVariableDeclarationImpl <em>Clock Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.ClockVariableDeclarationImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getClockVariableDeclaration()
		 * @generated
		 */
		EClass CLOCK_VARIABLE_DECLARATION = eINSTANCE.getClockVariableDeclaration();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.DataVariableDeclarationImpl <em>Data Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.DataVariableDeclarationImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getDataVariableDeclaration()
		 * @generated
		 */
		EClass DATA_VARIABLE_DECLARATION = eINSTANCE.getDataVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE_DECLARATION__PREFIX = eINSTANCE.getDataVariableDeclaration_Prefix();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.FunctionDeclarationImpl <em>Function Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.FunctionDeclarationImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getFunctionDeclaration()
		 * @generated
		 */
		EClass FUNCTION_DECLARATION = eINSTANCE.getFunctionDeclaration();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DECLARATION__FUNCTION = eINSTANCE.getFunctionDeclaration_Function();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.FunctionImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__RETURN_TYPE = eINSTANCE.getFunction_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__BLOCK = eINSTANCE.getFunction_Block();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__PARAMETER = eINSTANCE.getFunction_Parameter();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.TypeDeclarationImpl <em>Type Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.TypeDeclarationImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getTypeDeclaration()
		 * @generated
		 */
		EClass TYPE_DECLARATION = eINSTANCE.getTypeDeclaration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_DECLARATION__TYPE = eINSTANCE.getTypeDeclaration_Type();

		/**
		 * The meta object literal for the '<em><b>Type Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_DECLARATION__TYPE_DEFINITION = eINSTANCE.getTypeDeclaration_TypeDefinition();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.VariableImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__INDEX = eINSTANCE.getVariable_Index();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__CONTAINER = eINSTANCE.getVariable_Container();

		/**
		 * The meta object literal for the '<em><b>Type Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__TYPE_DEFINITION = eINSTANCE.getVariable_TypeDefinition();

		/**
		 * The meta object literal for the '<em><b>Initializer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__INITIALIZER = eINSTANCE.getVariable_Initializer();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.IndexImpl <em>Index</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.IndexImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getIndex()
		 * @generated
		 */
		EClass INDEX = eINSTANCE.getIndex();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.ValueIndexImpl <em>Value Index</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.ValueIndexImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getValueIndex()
		 * @generated
		 */
		EClass VALUE_INDEX = eINSTANCE.getValueIndex();

		/**
		 * The meta object literal for the '<em><b>Size Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_INDEX__SIZE_EXPRESSION = eINSTANCE.getValueIndex_SizeExpression();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.TypeIndexImpl <em>Type Index</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.TypeIndexImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getTypeIndex()
		 * @generated
		 */
		EClass TYPE_INDEX = eINSTANCE.getTypeIndex();

		/**
		 * The meta object literal for the '<em><b>Type Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_INDEX__TYPE_DEFINITION = eINSTANCE.getTypeIndex_TypeDefinition();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.VariableContainerImpl <em>Variable Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.VariableContainerImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getVariableContainer()
		 * @generated
		 */
		EClass VARIABLE_CONTAINER = eINSTANCE.getVariableContainer();

		/**
		 * The meta object literal for the '<em><b>Type Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CONTAINER__TYPE_DEFINITION = eINSTANCE.getVariableContainer_TypeDefinition();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CONTAINER__VARIABLE = eINSTANCE.getVariableContainer_Variable();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.ParameterImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Variable Declaration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__VARIABLE_DECLARATION = eINSTANCE.getParameter_VariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Call Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__CALL_TYPE = eINSTANCE.getParameter_CallType();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.InitializerImpl <em>Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.InitializerImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getInitializer()
		 * @generated
		 */
		EClass INITIALIZER = eINSTANCE.getInitializer();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.ExpressionInitializerImpl <em>Expression Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.ExpressionInitializerImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getExpressionInitializer()
		 * @generated
		 */
		EClass EXPRESSION_INITIALIZER = eINSTANCE.getExpressionInitializer();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_INITIALIZER__EXPRESSION = eINSTANCE.getExpressionInitializer_Expression();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.impl.ArrayInitializerImpl <em>Array Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.impl.ArrayInitializerImpl
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getArrayInitializer()
		 * @generated
		 */
		EClass ARRAY_INITIALIZER = eINSTANCE.getArrayInitializer();

		/**
		 * The meta object literal for the '<em><b>Initializer</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_INITIALIZER__INITIALIZER = eINSTANCE.getArrayInitializer_Initializer();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.DataVariablePrefix <em>Data Variable Prefix</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.DataVariablePrefix
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getDataVariablePrefix()
		 * @generated
		 */
		EEnum DATA_VARIABLE_PREFIX = eINSTANCE.getDataVariablePrefix();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.CallType <em>Call Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.CallType
		 * @see de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl#getCallType()
		 * @generated
		 */
		EEnum CALL_TYPE = eINSTANCE.getCallType();

	}

} //DeclarationsPackage
