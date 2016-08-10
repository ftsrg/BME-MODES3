/**
 */
package hu.bme.mit.inf.safetylogic.model.railroadmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "railroadmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://hu.bme.mit.inf.safetylogic.railroadmodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "railroadmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.TrainImpl <em>Train</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.TrainImpl
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getTrain()
	 * @generated
	 */
	int TRAIN = 0;

	/**
	 * The feature id for the '<em><b>Currently On</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAIN__CURRENTLY_ON = 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAIN__X = 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAIN__Y = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAIN__ID = 3;

	/**
	 * The feature id for the '<em><b>Previously On</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAIN__PREVIOUSLY_ON = 4;

	/**
	 * The number of structural features of the '<em>Train</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAIN_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Train</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAIN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RailRoadElementImpl <em>Rail Road Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RailRoadElementImpl
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getRailRoadElement()
	 * @generated
	 */
	int RAIL_ROAD_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAIL_ROAD_ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAIL_ROAD_ELEMENT__POINTS = 1;

	/**
	 * The number of structural features of the '<em>Rail Road Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAIL_ROAD_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Rail Road Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAIL_ROAD_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.TurnoutImpl <em>Turnout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.TurnoutImpl
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getTurnout()
	 * @generated
	 */
	int TURNOUT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURNOUT__ID = RAIL_ROAD_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURNOUT__POINTS = RAIL_ROAD_ELEMENT__POINTS;

	/**
	 * The feature id for the '<em><b>Rectangle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURNOUT__RECTANGLE = RAIL_ROAD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Top</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURNOUT__TOP = RAIL_ROAD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Straight</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURNOUT__STRAIGHT = RAIL_ROAD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Divergent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURNOUT__DIVERGENT = RAIL_ROAD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Divergent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURNOUT__IS_DIVERGENT = RAIL_ROAD_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Turnout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURNOUT_FEATURE_COUNT = RAIL_ROAD_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Turnout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURNOUT_OPERATION_COUNT = RAIL_ROAD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.PointImpl <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.PointImpl
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 3;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__Y = 1;

	/**
	 * The number of structural features of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RailRoadModelImpl <em>Rail Road Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RailRoadModelImpl
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getRailRoadModel()
	 * @generated
	 */
	int RAIL_ROAD_MODEL = 4;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAIL_ROAD_MODEL__SECTIONS = 0;

	/**
	 * The feature id for the '<em><b>Trains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAIL_ROAD_MODEL__TRAINS = 1;

	/**
	 * The number of structural features of the '<em>Rail Road Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAIL_ROAD_MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Rail Road Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAIL_ROAD_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RectangleImpl <em>Rectangle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RectangleImpl
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getRectangle()
	 * @generated
	 */
	int RECTANGLE = 5;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__ORIGIN = 0;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__SIZE = 1;

	/**
	 * The feature id for the '<em><b>Inverse Matrix</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__INVERSE_MATRIX = 2;

	/**
	 * The number of structural features of the '<em>Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.DimensionImpl <em>Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.DimensionImpl
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getDimension()
	 * @generated
	 */
	int DIMENSION = 6;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__WIDTH = 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__HEIGHT = 1;

	/**
	 * The number of structural features of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.SegmentImpl <em>Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.SegmentImpl
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getSegment()
	 * @generated
	 */
	int SEGMENT = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__ID = RAIL_ROAD_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__POINTS = RAIL_ROAD_ELEMENT__POINTS;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__IS_ENABLED = RAIL_ROAD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Connected To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__CONNECTED_TO = RAIL_ROAD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT_FEATURE_COUNT = RAIL_ROAD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT_OPERATION_COUNT = RAIL_ROAD_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Train <em>Train</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Train</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Train
	 * @generated
	 */
	EClass getTrain();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Train#getCurrentlyOn <em>Currently On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Currently On</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Train#getCurrentlyOn()
	 * @see #getTrain()
	 * @generated
	 */
	EReference getTrain_CurrentlyOn();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Train#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Train#getX()
	 * @see #getTrain()
	 * @generated
	 */
	EAttribute getTrain_X();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Train#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Train#getY()
	 * @see #getTrain()
	 * @generated
	 */
	EAttribute getTrain_Y();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Train#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Train#getId()
	 * @see #getTrain()
	 * @generated
	 */
	EAttribute getTrain_Id();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Train#getPreviouslyOn <em>Previously On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previously On</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Train#getPreviouslyOn()
	 * @see #getTrain()
	 * @generated
	 */
	EReference getTrain_PreviouslyOn();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement <em>Rail Road Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rail Road Element</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement
	 * @generated
	 */
	EClass getRailRoadElement();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement#getId()
	 * @see #getRailRoadElement()
	 * @generated
	 */
	EAttribute getRailRoadElement_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement#getPoints <em>Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Points</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement#getPoints()
	 * @see #getRailRoadElement()
	 * @generated
	 */
	EReference getRailRoadElement_Points();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout <em>Turnout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Turnout</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout
	 * @generated
	 */
	EClass getTurnout();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout#getRectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rectangle</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout#getRectangle()
	 * @see #getTurnout()
	 * @generated
	 */
	EReference getTurnout_Rectangle();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout#getTop <em>Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Top</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout#getTop()
	 * @see #getTurnout()
	 * @generated
	 */
	EReference getTurnout_Top();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout#getStraight <em>Straight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Straight</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout#getStraight()
	 * @see #getTurnout()
	 * @generated
	 */
	EReference getTurnout_Straight();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout#getDivergent <em>Divergent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Divergent</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout#getDivergent()
	 * @see #getTurnout()
	 * @generated
	 */
	EReference getTurnout_Divergent();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout#isIsDivergent <em>Is Divergent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Divergent</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout#isIsDivergent()
	 * @see #getTurnout()
	 * @generated
	 */
	EAttribute getTurnout_IsDivergent();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Point
	 * @generated
	 */
	EClass getPoint();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Point#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Point#getX()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_X();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Point#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Point#getY()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_Y();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadModel <em>Rail Road Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rail Road Model</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadModel
	 * @generated
	 */
	EClass getRailRoadModel();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadModel#getSections <em>Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sections</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadModel#getSections()
	 * @see #getRailRoadModel()
	 * @generated
	 */
	EReference getRailRoadModel_Sections();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadModel#getTrains <em>Trains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trains</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadModel#getTrains()
	 * @see #getRailRoadModel()
	 * @generated
	 */
	EReference getRailRoadModel_Trains();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Rectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rectangle</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Rectangle
	 * @generated
	 */
	EClass getRectangle();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Rectangle#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Origin</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Rectangle#getOrigin()
	 * @see #getRectangle()
	 * @generated
	 */
	EReference getRectangle_Origin();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Rectangle#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Size</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Rectangle#getSize()
	 * @see #getRectangle()
	 * @generated
	 */
	EReference getRectangle_Size();

	/**
	 * Returns the meta object for the attribute list '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Rectangle#getInverseMatrix <em>Inverse Matrix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Inverse Matrix</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Rectangle#getInverseMatrix()
	 * @see #getRectangle()
	 * @generated
	 */
	EAttribute getRectangle_InverseMatrix();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Dimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Dimension
	 * @generated
	 */
	EClass getDimension();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Dimension#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Dimension#getWidth()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Width();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Dimension#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Dimension#getHeight()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Height();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Segment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Segment</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Segment
	 * @generated
	 */
	EClass getSegment();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Segment#isIsEnabled <em>Is Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enabled</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Segment#isIsEnabled()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_IsEnabled();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Segment#getConnectedTo <em>Connected To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connected To</em>'.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.Segment#getConnectedTo()
	 * @see #getSegment()
	 * @generated
	 */
	EReference getSegment_ConnectedTo();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.TrainImpl <em>Train</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.TrainImpl
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getTrain()
		 * @generated
		 */
		EClass TRAIN = eINSTANCE.getTrain();

		/**
		 * The meta object literal for the '<em><b>Currently On</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRAIN__CURRENTLY_ON = eINSTANCE.getTrain_CurrentlyOn();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRAIN__X = eINSTANCE.getTrain_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRAIN__Y = eINSTANCE.getTrain_Y();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRAIN__ID = eINSTANCE.getTrain_Id();

		/**
		 * The meta object literal for the '<em><b>Previously On</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRAIN__PREVIOUSLY_ON = eINSTANCE.getTrain_PreviouslyOn();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RailRoadElementImpl <em>Rail Road Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RailRoadElementImpl
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getRailRoadElement()
		 * @generated
		 */
		EClass RAIL_ROAD_ELEMENT = eINSTANCE.getRailRoadElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAIL_ROAD_ELEMENT__ID = eINSTANCE.getRailRoadElement_Id();

		/**
		 * The meta object literal for the '<em><b>Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAIL_ROAD_ELEMENT__POINTS = eINSTANCE.getRailRoadElement_Points();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.TurnoutImpl <em>Turnout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.TurnoutImpl
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getTurnout()
		 * @generated
		 */
		EClass TURNOUT = eINSTANCE.getTurnout();

		/**
		 * The meta object literal for the '<em><b>Rectangle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TURNOUT__RECTANGLE = eINSTANCE.getTurnout_Rectangle();

		/**
		 * The meta object literal for the '<em><b>Top</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TURNOUT__TOP = eINSTANCE.getTurnout_Top();

		/**
		 * The meta object literal for the '<em><b>Straight</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TURNOUT__STRAIGHT = eINSTANCE.getTurnout_Straight();

		/**
		 * The meta object literal for the '<em><b>Divergent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TURNOUT__DIVERGENT = eINSTANCE.getTurnout_Divergent();

		/**
		 * The meta object literal for the '<em><b>Is Divergent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TURNOUT__IS_DIVERGENT = eINSTANCE.getTurnout_IsDivergent();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.PointImpl <em>Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.PointImpl
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getPoint()
		 * @generated
		 */
		EClass POINT = eINSTANCE.getPoint();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__X = eINSTANCE.getPoint_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__Y = eINSTANCE.getPoint_Y();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RailRoadModelImpl <em>Rail Road Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RailRoadModelImpl
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getRailRoadModel()
		 * @generated
		 */
		EClass RAIL_ROAD_MODEL = eINSTANCE.getRailRoadModel();

		/**
		 * The meta object literal for the '<em><b>Sections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAIL_ROAD_MODEL__SECTIONS = eINSTANCE.getRailRoadModel_Sections();

		/**
		 * The meta object literal for the '<em><b>Trains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAIL_ROAD_MODEL__TRAINS = eINSTANCE.getRailRoadModel_Trains();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RectangleImpl <em>Rectangle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RectangleImpl
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getRectangle()
		 * @generated
		 */
		EClass RECTANGLE = eINSTANCE.getRectangle();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECTANGLE__ORIGIN = eINSTANCE.getRectangle_Origin();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECTANGLE__SIZE = eINSTANCE.getRectangle_Size();

		/**
		 * The meta object literal for the '<em><b>Inverse Matrix</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTANGLE__INVERSE_MATRIX = eINSTANCE.getRectangle_InverseMatrix();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.DimensionImpl <em>Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.DimensionImpl
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getDimension()
		 * @generated
		 */
		EClass DIMENSION = eINSTANCE.getDimension();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__WIDTH = eINSTANCE.getDimension_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__HEIGHT = eINSTANCE.getDimension_Height();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.SegmentImpl <em>Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.SegmentImpl
		 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.ModelPackageImpl#getSegment()
		 * @generated
		 */
		EClass SEGMENT = eINSTANCE.getSegment();

		/**
		 * The meta object literal for the '<em><b>Is Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__IS_ENABLED = eINSTANCE.getSegment_IsEnabled();

		/**
		 * The meta object literal for the '<em><b>Connected To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEGMENT__CONNECTED_TO = eINSTANCE.getSegment_ConnectedTo();

	}

} //ModelPackage
