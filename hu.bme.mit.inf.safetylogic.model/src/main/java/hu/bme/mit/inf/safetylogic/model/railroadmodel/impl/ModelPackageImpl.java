/**
 */
package hu.bme.mit.inf.safetylogic.model.railroadmodel.impl;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Dimension;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelFactory;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelPackage;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Path;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Point;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadModel;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Rectangle;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Segment;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Train;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass railRoadElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass turnoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass railRoadModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rectangleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass segmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrain() {
		return trainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrain_CurrentlyOn() {
		return (EReference)trainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrain_X() {
		return (EAttribute)trainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrain_Y() {
		return (EAttribute)trainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrain_Id() {
		return (EAttribute)trainEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrain_PreviouslyOn() {
		return (EReference)trainEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRailRoadElement() {
		return railRoadElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRailRoadElement_Id() {
		return (EAttribute)railRoadElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRailRoadElement_Points() {
		return (EReference)railRoadElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRailRoadElement_Connected() {
		return (EReference)railRoadElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRailRoadElement_CurrentlyConnected() {
		return (EReference)railRoadElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRailRoadElement_ViablePaths() {
		return (EReference)railRoadElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTurnout() {
		return turnoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTurnout_Rectangle() {
		return (EReference)turnoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTurnout_Top() {
		return (EReference)turnoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTurnout_Straight() {
		return (EReference)turnoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTurnout_Divergent() {
		return (EReference)turnoutEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTurnout_CurrentlyDivergent() {
		return (EAttribute)turnoutEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPoint() {
		return pointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoint_X() {
		return (EAttribute)pointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoint_Y() {
		return (EAttribute)pointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRailRoadModel() {
		return railRoadModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRailRoadModel_Sections() {
		return (EReference)railRoadModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRailRoadModel_Trains() {
		return (EReference)railRoadModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRailRoadModel_Paths() {
		return (EReference)railRoadModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRectangle() {
		return rectangleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRectangle_Origin() {
		return (EReference)rectangleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRectangle_Size() {
		return (EReference)rectangleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRectangle_InverseMatrix() {
		return (EAttribute)rectangleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDimension() {
		return dimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDimension_Width() {
		return (EAttribute)dimensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDimension_Height() {
		return (EAttribute)dimensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSegment() {
		return segmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSegment_IsEnabled() {
		return (EAttribute)segmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSegment_ConnectedTo() {
		return (EReference)segmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPath() {
		return pathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPath_From() {
		return (EReference)pathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPath_Via() {
		return (EReference)pathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPath_To() {
		return (EReference)pathEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		trainEClass = createEClass(TRAIN);
		createEReference(trainEClass, TRAIN__CURRENTLY_ON);
		createEAttribute(trainEClass, TRAIN__X);
		createEAttribute(trainEClass, TRAIN__Y);
		createEAttribute(trainEClass, TRAIN__ID);
		createEReference(trainEClass, TRAIN__PREVIOUSLY_ON);

		railRoadElementEClass = createEClass(RAIL_ROAD_ELEMENT);
		createEAttribute(railRoadElementEClass, RAIL_ROAD_ELEMENT__ID);
		createEReference(railRoadElementEClass, RAIL_ROAD_ELEMENT__POINTS);
		createEReference(railRoadElementEClass, RAIL_ROAD_ELEMENT__CONNECTED);
		createEReference(railRoadElementEClass, RAIL_ROAD_ELEMENT__CURRENTLY_CONNECTED);
		createEReference(railRoadElementEClass, RAIL_ROAD_ELEMENT__VIABLE_PATHS);

		turnoutEClass = createEClass(TURNOUT);
		createEReference(turnoutEClass, TURNOUT__RECTANGLE);
		createEReference(turnoutEClass, TURNOUT__TOP);
		createEReference(turnoutEClass, TURNOUT__STRAIGHT);
		createEReference(turnoutEClass, TURNOUT__DIVERGENT);
		createEAttribute(turnoutEClass, TURNOUT__CURRENTLY_DIVERGENT);

		pointEClass = createEClass(POINT);
		createEAttribute(pointEClass, POINT__X);
		createEAttribute(pointEClass, POINT__Y);

		railRoadModelEClass = createEClass(RAIL_ROAD_MODEL);
		createEReference(railRoadModelEClass, RAIL_ROAD_MODEL__SECTIONS);
		createEReference(railRoadModelEClass, RAIL_ROAD_MODEL__TRAINS);
		createEReference(railRoadModelEClass, RAIL_ROAD_MODEL__PATHS);

		rectangleEClass = createEClass(RECTANGLE);
		createEReference(rectangleEClass, RECTANGLE__ORIGIN);
		createEReference(rectangleEClass, RECTANGLE__SIZE);
		createEAttribute(rectangleEClass, RECTANGLE__INVERSE_MATRIX);

		dimensionEClass = createEClass(DIMENSION);
		createEAttribute(dimensionEClass, DIMENSION__WIDTH);
		createEAttribute(dimensionEClass, DIMENSION__HEIGHT);

		segmentEClass = createEClass(SEGMENT);
		createEAttribute(segmentEClass, SEGMENT__IS_ENABLED);
		createEReference(segmentEClass, SEGMENT__CONNECTED_TO);

		pathEClass = createEClass(PATH);
		createEReference(pathEClass, PATH__FROM);
		createEReference(pathEClass, PATH__VIA);
		createEReference(pathEClass, PATH__TO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		turnoutEClass.getESuperTypes().add(this.getRailRoadElement());
		segmentEClass.getESuperTypes().add(this.getRailRoadElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(trainEClass, Train.class, "Train", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrain_CurrentlyOn(), this.getRailRoadElement(), null, "currentlyOn", null, 1, 1, Train.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrain_X(), ecorePackage.getEDouble(), "x", null, 1, 1, Train.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrain_Y(), ecorePackage.getEDouble(), "y", null, 1, 1, Train.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrain_Id(), ecorePackage.getEInt(), "id", null, 1, 1, Train.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrain_PreviouslyOn(), this.getRailRoadElement(), null, "previouslyOn", null, 1, 1, Train.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(railRoadElementEClass, RailRoadElement.class, "RailRoadElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRailRoadElement_Id(), ecorePackage.getEInt(), "id", null, 1, 1, RailRoadElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRailRoadElement_Points(), this.getPoint(), null, "points", null, 2, -1, RailRoadElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRailRoadElement_Connected(), this.getRailRoadElement(), null, "connected", null, 0, -1, RailRoadElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRailRoadElement_CurrentlyConnected(), this.getRailRoadElement(), null, "currentlyConnected", null, 0, -1, RailRoadElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRailRoadElement_ViablePaths(), this.getPath(), null, "viablePaths", null, 0, -1, RailRoadElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(turnoutEClass, Turnout.class, "Turnout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTurnout_Rectangle(), this.getRectangle(), null, "rectangle", null, 1, 1, Turnout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTurnout_Top(), this.getRailRoadElement(), null, "top", null, 1, 1, Turnout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTurnout_Straight(), this.getRailRoadElement(), null, "straight", null, 1, 1, Turnout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTurnout_Divergent(), this.getRailRoadElement(), null, "divergent", null, 1, 1, Turnout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTurnout_CurrentlyDivergent(), theXMLTypePackage.getBoolean(), "currentlyDivergent", null, 1, 1, Turnout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pointEClass, Point.class, "Point", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPoint_X(), ecorePackage.getEDouble(), "x", null, 1, 1, Point.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPoint_Y(), ecorePackage.getEDouble(), "y", null, 1, 1, Point.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(railRoadModelEClass, RailRoadModel.class, "RailRoadModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRailRoadModel_Sections(), this.getRailRoadElement(), null, "sections", null, 0, -1, RailRoadModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRailRoadModel_Trains(), this.getTrain(), null, "trains", null, 0, -1, RailRoadModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRailRoadModel_Paths(), this.getPath(), null, "paths", null, 0, -1, RailRoadModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rectangleEClass, Rectangle.class, "Rectangle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRectangle_Origin(), this.getPoint(), null, "origin", null, 1, 1, Rectangle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRectangle_Size(), this.getDimension(), null, "size", null, 1, 1, Rectangle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRectangle_InverseMatrix(), ecorePackage.getEDouble(), "inverseMatrix", "0.0", 1, 8, Rectangle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dimensionEClass, Dimension.class, "Dimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDimension_Width(), ecorePackage.getEDouble(), "width", null, 1, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDimension_Height(), ecorePackage.getEDouble(), "height", null, 1, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(segmentEClass, Segment.class, "Segment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSegment_IsEnabled(), theXMLTypePackage.getBoolean(), "isEnabled", null, 1, 1, Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSegment_ConnectedTo(), this.getRailRoadElement(), null, "connectedTo", null, 1, 2, Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathEClass, Path.class, "Path", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPath_From(), this.getRailRoadElement(), null, "from", null, 0, 1, Path.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPath_Via(), this.getRailRoadElement(), null, "via", null, 0, 1, Path.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPath_To(), this.getRailRoadElement(), null, "to", null, 0, 1, Path.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ModelPackageImpl
