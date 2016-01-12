/**
 */
package de.uni_paderborn.uppaal.templates;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uni_paderborn.uppaal.core.CorePackage;
import de.uni_paderborn.uppaal.declarations.DeclarationsPackage;
import de.uni_paderborn.uppaal.visuals.VisualsPackage;

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
 * Support for Timed Automata templates consisting of locations and edges.
 * <!-- end-model-doc -->
 * @see de.uni_paderborn.uppaal.templates.TemplatesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface TemplatesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "templates";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.uni-paderborn.de/uppaal/templates/0.4.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "templates";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TemplatesPackage eINSTANCE = de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.templates.impl.AbstractTemplateImpl <em>Abstract Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.templates.impl.AbstractTemplateImpl
	 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getAbstractTemplate()
	 * @generated
	 */
	int ABSTRACT_TEMPLATE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEMPLATE__NAME = CorePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEMPLATE__COMMENT = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEMPLATE__PARAMETER = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEMPLATE_FEATURE_COUNT = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Abstract Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEMPLATE_OPERATION_COUNT = CorePackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.templates.impl.TemplateImpl <em>Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.templates.impl.TemplateImpl
	 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getTemplate()
	 * @generated
	 */
	int TEMPLATE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__NAME = ABSTRACT_TEMPLATE__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__COMMENT = ABSTRACT_TEMPLATE__COMMENT;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__PARAMETER = ABSTRACT_TEMPLATE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Declarations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__DECLARATIONS = ABSTRACT_TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__LOCATION = ABSTRACT_TEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__EDGE = ABSTRACT_TEMPLATE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Init</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__INIT = ABSTRACT_TEMPLATE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FEATURE_COUNT = ABSTRACT_TEMPLATE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_OPERATION_COUNT = ABSTRACT_TEMPLATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.templates.impl.RedefinedTemplateImpl <em>Redefined Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.templates.impl.RedefinedTemplateImpl
	 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getRedefinedTemplate()
	 * @generated
	 */
	int REDEFINED_TEMPLATE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDEFINED_TEMPLATE__NAME = ABSTRACT_TEMPLATE__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDEFINED_TEMPLATE__COMMENT = ABSTRACT_TEMPLATE__COMMENT;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDEFINED_TEMPLATE__PARAMETER = ABSTRACT_TEMPLATE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Referred Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDEFINED_TEMPLATE__REFERRED_TEMPLATE = ABSTRACT_TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDEFINED_TEMPLATE__DECLARATION = ABSTRACT_TEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Redefined Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDEFINED_TEMPLATE_FEATURE_COUNT = ABSTRACT_TEMPLATE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Redefined Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDEFINED_TEMPLATE_OPERATION_COUNT = ABSTRACT_TEMPLATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.templates.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.templates.impl.LocationImpl
	 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__NAME = CorePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__COMMENT = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__POSITION = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__COLOR = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Color Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__COLOR_CODE = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parent Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__PARENT_TEMPLATE = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Invariant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__INVARIANT = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Location Time Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__LOCATION_TIME_KIND = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = CorePackage.NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_OPERATION_COUNT = CorePackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.templates.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.templates.impl.EdgeImpl
	 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 4;

	/**
	 * The feature id for the '<em><b>Bend Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__BEND_POINT = VisualsPackage.LINEAR_ELEMENT__BEND_POINT;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__COMMENT = VisualsPackage.LINEAR_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__COLOR = VisualsPackage.LINEAR_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Color Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__COLOR_CODE = VisualsPackage.LINEAR_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SOURCE = VisualsPackage.LINEAR_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET = VisualsPackage.LINEAR_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Parent Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__PARENT_TEMPLATE = VisualsPackage.LINEAR_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__GUARD = VisualsPackage.LINEAR_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Update</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__UPDATE = VisualsPackage.LINEAR_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Synchronization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SYNCHRONIZATION = VisualsPackage.LINEAR_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SELECTION = VisualsPackage.LINEAR_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = VisualsPackage.LINEAR_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OPERATION_COUNT = VisualsPackage.LINEAR_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.templates.impl.SynchronizationImpl <em>Synchronization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.templates.impl.SynchronizationImpl
	 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getSynchronization()
	 * @generated
	 */
	int SYNCHRONIZATION = 5;

	/**
	 * The feature id for the '<em><b>Channel Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION__CHANNEL_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION__KIND = 1;

	/**
	 * The number of structural features of the '<em>Synchronization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Synchronization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.templates.impl.SelectionImpl <em>Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.templates.impl.SelectionImpl
	 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getSelection()
	 * @generated
	 */
	int SELECTION = 6;

	/**
	 * The feature id for the '<em><b>Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION__TYPE_DEFINITION = DeclarationsPackage.VARIABLE_CONTAINER__TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION__VARIABLE = DeclarationsPackage.VARIABLE_CONTAINER__VARIABLE;

	/**
	 * The feature id for the '<em><b>Select Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION__SELECT_STATEMENT = DeclarationsPackage.VARIABLE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_FEATURE_COUNT = DeclarationsPackage.VARIABLE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_OPERATION_COUNT = DeclarationsPackage.VARIABLE_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.templates.LocationKind <em>Location Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.templates.LocationKind
	 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getLocationKind()
	 * @generated
	 */
	int LOCATION_KIND = 7;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.templates.SynchronizationKind <em>Synchronization Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.templates.SynchronizationKind
	 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getSynchronizationKind()
	 * @generated
	 */
	int SYNCHRONIZATION_KIND = 8;


	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.templates.AbstractTemplate <em>Abstract Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Template</em>'.
	 * @see de.uni_paderborn.uppaal.templates.AbstractTemplate
	 * @generated
	 */
	EClass getAbstractTemplate();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.templates.AbstractTemplate#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see de.uni_paderborn.uppaal.templates.AbstractTemplate#getParameter()
	 * @see #getAbstractTemplate()
	 * @generated
	 */
	EReference getAbstractTemplate_Parameter();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.templates.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Template
	 * @generated
	 */
	EClass getTemplate();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.templates.Template#getDeclarations <em>Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declarations</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Template#getDeclarations()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_Declarations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.templates.Template#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Location</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Template#getLocation()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_Location();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.templates.Template#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edge</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Template#getEdge()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_Edge();

	/**
	 * Returns the meta object for the reference '{@link de.uni_paderborn.uppaal.templates.Template#getInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Init</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Template#getInit()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_Init();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.templates.RedefinedTemplate <em>Redefined Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Redefined Template</em>'.
	 * @see de.uni_paderborn.uppaal.templates.RedefinedTemplate
	 * @generated
	 */
	EClass getRedefinedTemplate();

	/**
	 * Returns the meta object for the reference '{@link de.uni_paderborn.uppaal.templates.RedefinedTemplate#getReferredTemplate <em>Referred Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Template</em>'.
	 * @see de.uni_paderborn.uppaal.templates.RedefinedTemplate#getReferredTemplate()
	 * @see #getRedefinedTemplate()
	 * @generated
	 */
	EReference getRedefinedTemplate_ReferredTemplate();

	/**
	 * Returns the meta object for the container reference '{@link de.uni_paderborn.uppaal.templates.RedefinedTemplate#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declaration</em>'.
	 * @see de.uni_paderborn.uppaal.templates.RedefinedTemplate#getDeclaration()
	 * @see #getRedefinedTemplate()
	 * @generated
	 */
	EReference getRedefinedTemplate_Declaration();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.templates.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for the container reference '{@link de.uni_paderborn.uppaal.templates.Location#getParentTemplate <em>Parent Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Template</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Location#getParentTemplate()
	 * @see #getLocation()
	 * @generated
	 */
	EReference getLocation_ParentTemplate();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.templates.Location#getInvariant <em>Invariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Invariant</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Location#getInvariant()
	 * @see #getLocation()
	 * @generated
	 */
	EReference getLocation_Invariant();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.templates.Location#getLocationTimeKind <em>Location Time Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location Time Kind</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Location#getLocationTimeKind()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_LocationTimeKind();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.templates.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link de.uni_paderborn.uppaal.templates.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Edge#getSource()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link de.uni_paderborn.uppaal.templates.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Edge#getTarget()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Target();

	/**
	 * Returns the meta object for the container reference '{@link de.uni_paderborn.uppaal.templates.Edge#getParentTemplate <em>Parent Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Template</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Edge#getParentTemplate()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_ParentTemplate();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.templates.Edge#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Edge#getGuard()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Guard();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.templates.Edge#getUpdate <em>Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Update</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Edge#getUpdate()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Update();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.templates.Edge#getSynchronization <em>Synchronization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Synchronization</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Edge#getSynchronization()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Synchronization();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.templates.Edge#getSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Selection</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Edge#getSelection()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Selection();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.templates.Synchronization <em>Synchronization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Synchronization</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Synchronization
	 * @generated
	 */
	EClass getSynchronization();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.templates.Synchronization#getChannelExpression <em>Channel Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channel Expression</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Synchronization#getChannelExpression()
	 * @see #getSynchronization()
	 * @generated
	 */
	EReference getSynchronization_ChannelExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.templates.Synchronization#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Synchronization#getKind()
	 * @see #getSynchronization()
	 * @generated
	 */
	EAttribute getSynchronization_Kind();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.templates.Selection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Selection
	 * @generated
	 */
	EClass getSelection();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.templates.Selection#getSelectStatement <em>Select Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Select Statement</em>'.
	 * @see de.uni_paderborn.uppaal.templates.Selection#getSelectStatement()
	 * @see #getSelection()
	 * @generated
	 */
	EAttribute getSelection_SelectStatement();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.templates.LocationKind <em>Location Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Location Kind</em>'.
	 * @see de.uni_paderborn.uppaal.templates.LocationKind
	 * @generated
	 */
	EEnum getLocationKind();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.templates.SynchronizationKind <em>Synchronization Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Synchronization Kind</em>'.
	 * @see de.uni_paderborn.uppaal.templates.SynchronizationKind
	 * @generated
	 */
	EEnum getSynchronizationKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TemplatesFactory getTemplatesFactory();

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
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.templates.impl.AbstractTemplateImpl <em>Abstract Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.templates.impl.AbstractTemplateImpl
		 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getAbstractTemplate()
		 * @generated
		 */
		EClass ABSTRACT_TEMPLATE = eINSTANCE.getAbstractTemplate();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TEMPLATE__PARAMETER = eINSTANCE.getAbstractTemplate_Parameter();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.templates.impl.TemplateImpl <em>Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.templates.impl.TemplateImpl
		 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getTemplate()
		 * @generated
		 */
		EClass TEMPLATE = eINSTANCE.getTemplate();

		/**
		 * The meta object literal for the '<em><b>Declarations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__DECLARATIONS = eINSTANCE.getTemplate_Declarations();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__LOCATION = eINSTANCE.getTemplate_Location();

		/**
		 * The meta object literal for the '<em><b>Edge</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__EDGE = eINSTANCE.getTemplate_Edge();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__INIT = eINSTANCE.getTemplate_Init();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.templates.impl.RedefinedTemplateImpl <em>Redefined Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.templates.impl.RedefinedTemplateImpl
		 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getRedefinedTemplate()
		 * @generated
		 */
		EClass REDEFINED_TEMPLATE = eINSTANCE.getRedefinedTemplate();

		/**
		 * The meta object literal for the '<em><b>Referred Template</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REDEFINED_TEMPLATE__REFERRED_TEMPLATE = eINSTANCE.getRedefinedTemplate_ReferredTemplate();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REDEFINED_TEMPLATE__DECLARATION = eINSTANCE.getRedefinedTemplate_Declaration();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.templates.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.templates.impl.LocationImpl
		 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getLocation()
		 * @generated
		 */
		EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '<em><b>Parent Template</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION__PARENT_TEMPLATE = eINSTANCE.getLocation_ParentTemplate();

		/**
		 * The meta object literal for the '<em><b>Invariant</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION__INVARIANT = eINSTANCE.getLocation_Invariant();

		/**
		 * The meta object literal for the '<em><b>Location Time Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__LOCATION_TIME_KIND = eINSTANCE.getLocation_LocationTimeKind();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.templates.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.templates.impl.EdgeImpl
		 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SOURCE = eINSTANCE.getEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TARGET = eINSTANCE.getEdge_Target();

		/**
		 * The meta object literal for the '<em><b>Parent Template</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__PARENT_TEMPLATE = eINSTANCE.getEdge_ParentTemplate();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__GUARD = eINSTANCE.getEdge_Guard();

		/**
		 * The meta object literal for the '<em><b>Update</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__UPDATE = eINSTANCE.getEdge_Update();

		/**
		 * The meta object literal for the '<em><b>Synchronization</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SYNCHRONIZATION = eINSTANCE.getEdge_Synchronization();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SELECTION = eINSTANCE.getEdge_Selection();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.templates.impl.SynchronizationImpl <em>Synchronization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.templates.impl.SynchronizationImpl
		 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getSynchronization()
		 * @generated
		 */
		EClass SYNCHRONIZATION = eINSTANCE.getSynchronization();

		/**
		 * The meta object literal for the '<em><b>Channel Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNCHRONIZATION__CHANNEL_EXPRESSION = eINSTANCE.getSynchronization_ChannelExpression();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNCHRONIZATION__KIND = eINSTANCE.getSynchronization_Kind();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.templates.impl.SelectionImpl <em>Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.templates.impl.SelectionImpl
		 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getSelection()
		 * @generated
		 */
		EClass SELECTION = eINSTANCE.getSelection();

		/**
		 * The meta object literal for the '<em><b>Select Statement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTION__SELECT_STATEMENT = eINSTANCE.getSelection_SelectStatement();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.templates.LocationKind <em>Location Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.templates.LocationKind
		 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getLocationKind()
		 * @generated
		 */
		EEnum LOCATION_KIND = eINSTANCE.getLocationKind();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.templates.SynchronizationKind <em>Synchronization Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.templates.SynchronizationKind
		 * @see de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl#getSynchronizationKind()
		 * @generated
		 */
		EEnum SYNCHRONIZATION_KIND = eINSTANCE.getSynchronizationKind();

	}

} //TemplatesPackage
