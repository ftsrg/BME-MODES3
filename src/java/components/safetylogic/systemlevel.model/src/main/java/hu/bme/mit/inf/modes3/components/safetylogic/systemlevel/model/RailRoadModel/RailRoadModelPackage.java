/**
 */
package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel;

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
 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore settingDelegates='org.eclipse.viatra.query.querybasedfeature'"
 * @generated
 */
public interface RailRoadModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "RailRoadModel";

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
	String eNS_PREFIX = "RailRoadModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RailRoadModelPackage eINSTANCE = hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.TrainImpl <em>Train</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.TrainImpl
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getTrain()
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
	 * The meta object id for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadElementImpl <em>Rail Road Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadElementImpl
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getRailRoadElement()
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
	 * The number of structural features of the '<em>Rail Road Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAIL_ROAD_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Rail Road Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAIL_ROAD_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.TurnoutImpl <em>Turnout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.TurnoutImpl
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getTurnout()
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
	 * The feature id for the '<em><b>Currently Divergent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURNOUT__CURRENTLY_DIVERGENT = RAIL_ROAD_ELEMENT_FEATURE_COUNT + 4;

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
	 * The meta object id for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.PointImpl <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.PointImpl
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getPoint()
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
	 * The meta object id for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelImpl <em>Rail Road Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelImpl
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getRailRoadModel()
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
	 * The feature id for the '<em><b>Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAIL_ROAD_MODEL__PATHS = 2;

	/**
	 * The number of structural features of the '<em>Rail Road Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAIL_ROAD_MODEL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Rail Road Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAIL_ROAD_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RectangleImpl <em>Rectangle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RectangleImpl
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getRectangle()
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
	 * The number of structural features of the '<em>Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.DimensionImpl <em>Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.DimensionImpl
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getDimension()
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
	 * The meta object id for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.SegmentImpl <em>Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.SegmentImpl
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getSegment()
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
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__POINTS = RAIL_ROAD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT_FEATURE_COUNT = RAIL_ROAD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT_OPERATION_COUNT = RAIL_ROAD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.PathImpl <em>Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.PathImpl
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getPath()
	 * @generated
	 */
	int PATH = 8;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH__FROM = 0;

	/**
	 * The feature id for the '<em><b>Via</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH__VIA = 1;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH__TO = 2;

	/**
	 * The number of structural features of the '<em>Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train <em>Train</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Train</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train
	 * @generated
	 */
	EClass getTrain();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train#getCurrentlyOn <em>Currently On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Currently On</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train#getCurrentlyOn()
	 * @see #getTrain()
	 * @generated
	 */
	EReference getTrain_CurrentlyOn();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train#getX()
	 * @see #getTrain()
	 * @generated
	 */
	EAttribute getTrain_X();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train#getY()
	 * @see #getTrain()
	 * @generated
	 */
	EAttribute getTrain_Y();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train#getId()
	 * @see #getTrain()
	 * @generated
	 */
	EAttribute getTrain_Id();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train#getPreviouslyOn <em>Previously On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previously On</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train#getPreviouslyOn()
	 * @see #getTrain()
	 * @generated
	 */
	EReference getTrain_PreviouslyOn();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement <em>Rail Road Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rail Road Element</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement
	 * @generated
	 */
	EClass getRailRoadElement();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement#getId()
	 * @see #getRailRoadElement()
	 * @generated
	 */
	EAttribute getRailRoadElement_Id();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout <em>Turnout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Turnout</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout
	 * @generated
	 */
	EClass getTurnout();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout#getRectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rectangle</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout#getRectangle()
	 * @see #getTurnout()
	 * @generated
	 */
	EReference getTurnout_Rectangle();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout#getTop <em>Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Top</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout#getTop()
	 * @see #getTurnout()
	 * @generated
	 */
	EReference getTurnout_Top();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout#getStraight <em>Straight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Straight</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout#getStraight()
	 * @see #getTurnout()
	 * @generated
	 */
	EReference getTurnout_Straight();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout#getDivergent <em>Divergent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Divergent</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout#getDivergent()
	 * @see #getTurnout()
	 * @generated
	 */
	EReference getTurnout_Divergent();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout#isCurrentlyDivergent <em>Currently Divergent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Currently Divergent</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout#isCurrentlyDivergent()
	 * @see #getTurnout()
	 * @generated
	 */
	EAttribute getTurnout_CurrentlyDivergent();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Point
	 * @generated
	 */
	EClass getPoint();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Point#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Point#getX()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_X();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Point#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Point#getY()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_Y();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel <em>Rail Road Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rail Road Model</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel
	 * @generated
	 */
	EClass getRailRoadModel();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel#getSections <em>Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sections</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel#getSections()
	 * @see #getRailRoadModel()
	 * @generated
	 */
	EReference getRailRoadModel_Sections();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel#getTrains <em>Trains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trains</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel#getTrains()
	 * @see #getRailRoadModel()
	 * @generated
	 */
	EReference getRailRoadModel_Trains();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel#getPaths <em>Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Paths</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel#getPaths()
	 * @see #getRailRoadModel()
	 * @generated
	 */
	EReference getRailRoadModel_Paths();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Rectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rectangle</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Rectangle
	 * @generated
	 */
	EClass getRectangle();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Rectangle#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Origin</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Rectangle#getOrigin()
	 * @see #getRectangle()
	 * @generated
	 */
	EReference getRectangle_Origin();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Rectangle#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Size</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Rectangle#getSize()
	 * @see #getRectangle()
	 * @generated
	 */
	EReference getRectangle_Size();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Dimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Dimension
	 * @generated
	 */
	EClass getDimension();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Dimension#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Dimension#getWidth()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Width();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Dimension#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Dimension#getHeight()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Height();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Segment</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
	 * @generated
	 */
	EClass getSegment();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment#isIsEnabled <em>Is Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enabled</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment#isIsEnabled()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_IsEnabled();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment#getConnectedTo <em>Connected To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connected To</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment#getConnectedTo()
	 * @see #getSegment()
	 * @generated
	 */
	EReference getSegment_ConnectedTo();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment#getPoints <em>Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Points</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment#getPoints()
	 * @see #getSegment()
	 * @generated
	 */
	EReference getSegment_Points();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Path <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Path
	 * @generated
	 */
	EClass getPath();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Path#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Path#getFrom()
	 * @see #getPath()
	 * @generated
	 */
	EReference getPath_From();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Path#getVia <em>Via</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Via</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Path#getVia()
	 * @see #getPath()
	 * @generated
	 */
	EReference getPath_Via();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Path#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Path#getTo()
	 * @see #getPath()
	 * @generated
	 */
	EReference getPath_To();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RailRoadModelFactory getRailRoadModelFactory();

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
		 * The meta object literal for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.TrainImpl <em>Train</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.TrainImpl
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getTrain()
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
		 * The meta object literal for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadElementImpl <em>Rail Road Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadElementImpl
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getRailRoadElement()
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
		 * The meta object literal for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.TurnoutImpl <em>Turnout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.TurnoutImpl
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getTurnout()
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
		 * The meta object literal for the '<em><b>Currently Divergent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TURNOUT__CURRENTLY_DIVERGENT = eINSTANCE.getTurnout_CurrentlyDivergent();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.PointImpl <em>Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.PointImpl
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getPoint()
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
		 * The meta object literal for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelImpl <em>Rail Road Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelImpl
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getRailRoadModel()
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
		 * The meta object literal for the '<em><b>Paths</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAIL_ROAD_MODEL__PATHS = eINSTANCE.getRailRoadModel_Paths();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RectangleImpl <em>Rectangle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RectangleImpl
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getRectangle()
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
		 * The meta object literal for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.DimensionImpl <em>Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.DimensionImpl
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getDimension()
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
		 * The meta object literal for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.SegmentImpl <em>Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.SegmentImpl
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getSegment()
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

		/**
		 * The meta object literal for the '<em><b>Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEGMENT__POINTS = eINSTANCE.getSegment_Points();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.PathImpl <em>Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.PathImpl
		 * @see hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelPackageImpl#getPath()
		 * @generated
		 */
		EClass PATH = eINSTANCE.getPath();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH__FROM = eINSTANCE.getPath_From();

		/**
		 * The meta object literal for the '<em><b>Via</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH__VIA = eINSTANCE.getPath_Via();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH__TO = eINSTANCE.getPath_To();

	}

} //RailRoadModelPackage
