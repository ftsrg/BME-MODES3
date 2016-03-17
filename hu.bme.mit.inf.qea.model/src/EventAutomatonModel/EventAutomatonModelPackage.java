/**
 */
package EventAutomatonModel;

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
 * @see EventAutomatonModel.EventAutomatonModelFactory
 * @model kind="package"
 * @generated
 */
public interface EventAutomatonModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "EventAutomatonModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/EventAutomatonModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "EventAutomatonModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventAutomatonModelPackage eINSTANCE = EventAutomatonModel.impl.EventAutomatonModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.AutomatonImpl <em>Automaton</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.AutomatonImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getAutomaton()
	 * @generated
	 */
	int AUTOMATON = 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATON__STATES = 0;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATON__TOKENS = 1;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATON__INITIAL_STATE = 2;

	/**
	 * The feature id for the '<em><b>Symbolic Token Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATON__SYMBOLIC_TOKEN_PARAMETERS = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATON__NAME = 4;

	/**
	 * The feature id for the '<em><b>Timers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATON__TIMERS = 5;

	/**
	 * The feature id for the '<em><b>Trap State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATON__TRAP_STATE = 6;

	/**
	 * The number of structural features of the '<em>Automaton</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATON_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Automaton</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATON_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.BindingImpl <em>Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.BindingImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getBinding()
	 * @generated
	 */
	int BINDING = 15;

	/**
	 * The feature id for the '<em><b>Binds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__BINDS = 0;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.TokenParameterBindingImpl <em>Token Parameter Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.TokenParameterBindingImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getTokenParameterBinding()
	 * @generated
	 */
	int TOKEN_PARAMETER_BINDING = 1;

	/**
	 * The feature id for the '<em><b>Binds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_PARAMETER_BINDING__BINDS = BINDING__BINDS;

	/**
	 * The feature id for the '<em><b>Bound To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_PARAMETER_BINDING__BOUND_TO = BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Token Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_PARAMETER_BINDING_FEATURE_COUNT = BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Token Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_PARAMETER_BINDING_OPERATION_COUNT = BINDING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.ActionImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 19;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.TimerActionImpl <em>Timer Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.TimerActionImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getTimerAction()
	 * @generated
	 */
	int TIMER_ACTION = 17;

	/**
	 * The feature id for the '<em><b>Timer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_ACTION__TIMER = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Timer Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Timer Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_ACTION_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.ResetTimerActionImpl <em>Reset Timer Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.ResetTimerActionImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getResetTimerAction()
	 * @generated
	 */
	int RESET_TIMER_ACTION = 2;

	/**
	 * The feature id for the '<em><b>Timer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_TIMER_ACTION__TIMER = TIMER_ACTION__TIMER;

	/**
	 * The number of structural features of the '<em>Reset Timer Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_TIMER_ACTION_FEATURE_COUNT = TIMER_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reset Timer Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_TIMER_ACTION_OPERATION_COUNT = TIMER_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.SymbolicEventImpl <em>Symbolic Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.SymbolicEventImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSymbolicEvent()
	 * @generated
	 */
	int SYMBOLIC_EVENT = 7;

	/**
	 * The feature id for the '<em><b>Symbolic Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_EVENT__SYMBOLIC_PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Symbolic Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_EVENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Symbolic Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_EVENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.SymbolicInputEventImpl <em>Symbolic Input Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.SymbolicInputEventImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSymbolicInputEvent()
	 * @generated
	 */
	int SYMBOLIC_INPUT_EVENT = 3;

	/**
	 * The feature id for the '<em><b>Symbolic Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_INPUT_EVENT__SYMBOLIC_PARAMETERS = SYMBOLIC_EVENT__SYMBOLIC_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_INPUT_EVENT__NAME = SYMBOLIC_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Symbolic Input Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_INPUT_EVENT_FEATURE_COUNT = SYMBOLIC_EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Symbolic Input Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_INPUT_EVENT_OPERATION_COUNT = SYMBOLIC_EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.SymbolicTimerImpl <em>Symbolic Timer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.SymbolicTimerImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSymbolicTimer()
	 * @generated
	 */
	int SYMBOLIC_TIMER = 4;

	/**
	 * The feature id for the '<em><b>Timeout Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_TIMER__TIMEOUT_EVENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_TIMER__NAME = 1;

	/**
	 * The number of structural features of the '<em>Symbolic Timer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_TIMER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Symbolic Timer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_TIMER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.SymbolicParameterImpl <em>Symbolic Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.SymbolicParameterImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSymbolicParameter()
	 * @generated
	 */
	int SYMBOLIC_PARAMETER = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_PARAMETER__NAME = 0;

	/**
	 * The number of structural features of the '<em>Symbolic Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_PARAMETER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Symbolic Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.SymbolicTokenParameterImpl <em>Symbolic Token Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.SymbolicTokenParameterImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSymbolicTokenParameter()
	 * @generated
	 */
	int SYMBOLIC_TOKEN_PARAMETER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_TOKEN_PARAMETER__NAME = SYMBOLIC_PARAMETER__NAME;

	/**
	 * The number of structural features of the '<em>Symbolic Token Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_TOKEN_PARAMETER_FEATURE_COUNT = SYMBOLIC_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Symbolic Token Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_TOKEN_PARAMETER_OPERATION_COUNT = SYMBOLIC_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.ComplexEventProcessorImpl <em>Complex Event Processor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.ComplexEventProcessorImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getComplexEventProcessor()
	 * @generated
	 */
	int COMPLEX_EVENT_PROCESSOR = 6;

	/**
	 * The feature id for the '<em><b>Automata</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PROCESSOR__AUTOMATA = 0;

	/**
	 * The feature id for the '<em><b>Symbolic Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PROCESSOR__SYMBOLIC_EVENTS = 1;

	/**
	 * The number of structural features of the '<em>Complex Event Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PROCESSOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Complex Event Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PROCESSOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.ParameterImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.StateImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getState()
	 * @generated
	 */
	int STATE = 9;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__TOKENS = 0;

	/**
	 * The feature id for the '<em><b>Acceptor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ACCEPTOR = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ID = 2;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INCOMING_TRANSITIONS = 3;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTGOING_TRANSITIONS = 4;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.ConstantBindingImpl <em>Constant Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.ConstantBindingImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getConstantBinding()
	 * @generated
	 */
	int CONSTANT_BINDING = 10;

	/**
	 * The feature id for the '<em><b>Binds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BINDING__BINDS = BINDING__BINDS;

	/**
	 * The feature id for the '<em><b>Bound To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BINDING__BOUND_TO = BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constant Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BINDING_FEATURE_COUNT = BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constant Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BINDING_OPERATION_COUNT = BINDING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.SymbolicEventParameterImpl <em>Symbolic Event Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.SymbolicEventParameterImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSymbolicEventParameter()
	 * @generated
	 */
	int SYMBOLIC_EVENT_PARAMETER = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_EVENT_PARAMETER__NAME = SYMBOLIC_PARAMETER__NAME;

	/**
	 * The number of structural features of the '<em>Symbolic Event Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_EVENT_PARAMETER_FEATURE_COUNT = SYMBOLIC_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Symbolic Event Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_EVENT_PARAMETER_OPERATION_COUNT = SYMBOLIC_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.FreeParameterImpl <em>Free Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.FreeParameterImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getFreeParameter()
	 * @generated
	 */
	int FREE_PARAMETER = 12;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_PARAMETER__TYPE = PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Excluded Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_PARAMETER__EXCLUDED_VALUES = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Free Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Free Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.SetTimerActionImpl <em>Set Timer Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.SetTimerActionImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSetTimerAction()
	 * @generated
	 */
	int SET_TIMER_ACTION = 13;

	/**
	 * The feature id for the '<em><b>Timer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TIMER_ACTION__TIMER = TIMER_ACTION__TIMER;

	/**
	 * The feature id for the '<em><b>To Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TIMER_ACTION__TO_VALUE = TIMER_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Timer Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TIMER_ACTION_FEATURE_COUNT = TIMER_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Set Timer Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TIMER_ACTION_OPERATION_COUNT = TIMER_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.SymbolicTimeoutEventImpl <em>Symbolic Timeout Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.SymbolicTimeoutEventImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSymbolicTimeoutEvent()
	 * @generated
	 */
	int SYMBOLIC_TIMEOUT_EVENT = 14;

	/**
	 * The feature id for the '<em><b>Symbolic Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_TIMEOUT_EVENT__SYMBOLIC_PARAMETERS = SYMBOLIC_EVENT__SYMBOLIC_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Timer</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_TIMEOUT_EVENT__TIMER = SYMBOLIC_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Symbolic Timeout Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_TIMEOUT_EVENT_FEATURE_COUNT = SYMBOLIC_EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Symbolic Timeout Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLIC_TIMEOUT_EVENT_OPERATION_COUNT = SYMBOLIC_EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.FixParameterImpl <em>Fix Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.FixParameterImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getFixParameter()
	 * @generated
	 */
	int FIX_PARAMETER = 16;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIX_PARAMETER__TYPE = PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIX_PARAMETER__VALUE = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fix Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIX_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Fix Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIX_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.AbstractTransitionImpl <em>Abstract Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.AbstractTransitionImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getAbstractTransition()
	 * @generated
	 */
	int ABSTRACT_TRANSITION = 25;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TRANSITION__TO = 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TRANSITION__FROM = 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TRANSITION__ACTIONS = 2;

	/**
	 * The number of structural features of the '<em>Abstract Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TRANSITION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Abstract Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TRANSITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.EpsilonTransitionImpl <em>Epsilon Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.EpsilonTransitionImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getEpsilonTransition()
	 * @generated
	 */
	int EPSILON_TRANSITION = 18;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPSILON_TRANSITION__TO = ABSTRACT_TRANSITION__TO;

	/**
	 * The feature id for the '<em><b>From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPSILON_TRANSITION__FROM = ABSTRACT_TRANSITION__FROM;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPSILON_TRANSITION__ACTIONS = ABSTRACT_TRANSITION__ACTIONS;

	/**
	 * The number of structural features of the '<em>Epsilon Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPSILON_TRANSITION_FEATURE_COUNT = ABSTRACT_TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Epsilon Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPSILON_TRANSITION_OPERATION_COUNT = ABSTRACT_TRANSITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.EventImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 21;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__PARAMETERS = 1;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.TokenImpl <em>Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.TokenImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getToken()
	 * @generated
	 */
	int TOKEN = 22;

	/**
	 * The feature id for the '<em><b>On</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__ON = 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__PARAMETERS = 1;

	/**
	 * The number of structural features of the '<em>Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.TransitionImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 23;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TO = ABSTRACT_TRANSITION__TO;

	/**
	 * The feature id for the '<em><b>From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__FROM = ABSTRACT_TRANSITION__FROM;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ACTIONS = ABSTRACT_TRANSITION__ACTIONS;

	/**
	 * The feature id for the '<em><b>Eventguard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EVENTGUARD = ABSTRACT_TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = ABSTRACT_TRANSITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = ABSTRACT_TRANSITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EventAutomatonModel.impl.EventGuardImpl <em>Event Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EventAutomatonModel.impl.EventGuardImpl
	 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getEventGuard()
	 * @generated
	 */
	int EVENT_GUARD = 24;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_GUARD__BINDINGS = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_GUARD__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Event Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_GUARD_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Event Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_GUARD_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.Automaton <em>Automaton</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Automaton</em>'.
	 * @see EventAutomatonModel.Automaton
	 * @generated
	 */
	EClass getAutomaton();

	/**
	 * Returns the meta object for the containment reference list '{@link EventAutomatonModel.Automaton#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see EventAutomatonModel.Automaton#getStates()
	 * @see #getAutomaton()
	 * @generated
	 */
	EReference getAutomaton_States();

	/**
	 * Returns the meta object for the reference list '{@link EventAutomatonModel.Automaton#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tokens</em>'.
	 * @see EventAutomatonModel.Automaton#getTokens()
	 * @see #getAutomaton()
	 * @generated
	 */
	EReference getAutomaton_Tokens();

	/**
	 * Returns the meta object for the reference '{@link EventAutomatonModel.Automaton#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial State</em>'.
	 * @see EventAutomatonModel.Automaton#getInitialState()
	 * @see #getAutomaton()
	 * @generated
	 */
	EReference getAutomaton_InitialState();

	/**
	 * Returns the meta object for the containment reference list '{@link EventAutomatonModel.Automaton#getSymbolicTokenParameters <em>Symbolic Token Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Symbolic Token Parameters</em>'.
	 * @see EventAutomatonModel.Automaton#getSymbolicTokenParameters()
	 * @see #getAutomaton()
	 * @generated
	 */
	EReference getAutomaton_SymbolicTokenParameters();

	/**
	 * Returns the meta object for the attribute '{@link EventAutomatonModel.Automaton#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see EventAutomatonModel.Automaton#getName()
	 * @see #getAutomaton()
	 * @generated
	 */
	EAttribute getAutomaton_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link EventAutomatonModel.Automaton#getTimers <em>Timers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Timers</em>'.
	 * @see EventAutomatonModel.Automaton#getTimers()
	 * @see #getAutomaton()
	 * @generated
	 */
	EReference getAutomaton_Timers();

	/**
	 * Returns the meta object for the reference '{@link EventAutomatonModel.Automaton#getTrapState <em>Trap State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Trap State</em>'.
	 * @see EventAutomatonModel.Automaton#getTrapState()
	 * @see #getAutomaton()
	 * @generated
	 */
	EReference getAutomaton_TrapState();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.TokenParameterBinding <em>Token Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token Parameter Binding</em>'.
	 * @see EventAutomatonModel.TokenParameterBinding
	 * @generated
	 */
	EClass getTokenParameterBinding();

	/**
	 * Returns the meta object for the reference '{@link EventAutomatonModel.TokenParameterBinding#getBoundTo <em>Bound To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bound To</em>'.
	 * @see EventAutomatonModel.TokenParameterBinding#getBoundTo()
	 * @see #getTokenParameterBinding()
	 * @generated
	 */
	EReference getTokenParameterBinding_BoundTo();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.ResetTimerAction <em>Reset Timer Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reset Timer Action</em>'.
	 * @see EventAutomatonModel.ResetTimerAction
	 * @generated
	 */
	EClass getResetTimerAction();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.SymbolicInputEvent <em>Symbolic Input Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbolic Input Event</em>'.
	 * @see EventAutomatonModel.SymbolicInputEvent
	 * @generated
	 */
	EClass getSymbolicInputEvent();

	/**
	 * Returns the meta object for the attribute '{@link EventAutomatonModel.SymbolicInputEvent#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see EventAutomatonModel.SymbolicInputEvent#getName()
	 * @see #getSymbolicInputEvent()
	 * @generated
	 */
	EAttribute getSymbolicInputEvent_Name();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.SymbolicTimer <em>Symbolic Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbolic Timer</em>'.
	 * @see EventAutomatonModel.SymbolicTimer
	 * @generated
	 */
	EClass getSymbolicTimer();

	/**
	 * Returns the meta object for the containment reference '{@link EventAutomatonModel.SymbolicTimer#getTimeoutEvent <em>Timeout Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Timeout Event</em>'.
	 * @see EventAutomatonModel.SymbolicTimer#getTimeoutEvent()
	 * @see #getSymbolicTimer()
	 * @generated
	 */
	EReference getSymbolicTimer_TimeoutEvent();

	/**
	 * Returns the meta object for the attribute '{@link EventAutomatonModel.SymbolicTimer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see EventAutomatonModel.SymbolicTimer#getName()
	 * @see #getSymbolicTimer()
	 * @generated
	 */
	EAttribute getSymbolicTimer_Name();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.SymbolicTokenParameter <em>Symbolic Token Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbolic Token Parameter</em>'.
	 * @see EventAutomatonModel.SymbolicTokenParameter
	 * @generated
	 */
	EClass getSymbolicTokenParameter();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.ComplexEventProcessor <em>Complex Event Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Event Processor</em>'.
	 * @see EventAutomatonModel.ComplexEventProcessor
	 * @generated
	 */
	EClass getComplexEventProcessor();

	/**
	 * Returns the meta object for the containment reference list '{@link EventAutomatonModel.ComplexEventProcessor#getAutomata <em>Automata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Automata</em>'.
	 * @see EventAutomatonModel.ComplexEventProcessor#getAutomata()
	 * @see #getComplexEventProcessor()
	 * @generated
	 */
	EReference getComplexEventProcessor_Automata();

	/**
	 * Returns the meta object for the containment reference list '{@link EventAutomatonModel.ComplexEventProcessor#getSymbolicEvents <em>Symbolic Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Symbolic Events</em>'.
	 * @see EventAutomatonModel.ComplexEventProcessor#getSymbolicEvents()
	 * @see #getComplexEventProcessor()
	 * @generated
	 */
	EReference getComplexEventProcessor_SymbolicEvents();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.SymbolicEvent <em>Symbolic Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbolic Event</em>'.
	 * @see EventAutomatonModel.SymbolicEvent
	 * @generated
	 */
	EClass getSymbolicEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link EventAutomatonModel.SymbolicEvent#getSymbolicParameters <em>Symbolic Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Symbolic Parameters</em>'.
	 * @see EventAutomatonModel.SymbolicEvent#getSymbolicParameters()
	 * @see #getSymbolicEvent()
	 * @generated
	 */
	EReference getSymbolicEvent_SymbolicParameters();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see EventAutomatonModel.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '{@link EventAutomatonModel.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see EventAutomatonModel.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Type();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see EventAutomatonModel.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the containment reference list '{@link EventAutomatonModel.State#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outgoing Transitions</em>'.
	 * @see EventAutomatonModel.State#getOutgoingTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OutgoingTransitions();

	/**
	 * Returns the meta object for the reference list '{@link EventAutomatonModel.State#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Transitions</em>'.
	 * @see EventAutomatonModel.State#getIncomingTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_IncomingTransitions();

	/**
	 * Returns the meta object for the containment reference list '{@link EventAutomatonModel.State#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tokens</em>'.
	 * @see EventAutomatonModel.State#getTokens()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Tokens();

	/**
	 * Returns the meta object for the attribute '{@link EventAutomatonModel.State#isAcceptor <em>Acceptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Acceptor</em>'.
	 * @see EventAutomatonModel.State#isAcceptor()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Acceptor();

	/**
	 * Returns the meta object for the attribute '{@link EventAutomatonModel.State#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see EventAutomatonModel.State#getId()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Id();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.ConstantBinding <em>Constant Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Binding</em>'.
	 * @see EventAutomatonModel.ConstantBinding
	 * @generated
	 */
	EClass getConstantBinding();

	/**
	 * Returns the meta object for the containment reference '{@link EventAutomatonModel.ConstantBinding#getBoundTo <em>Bound To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bound To</em>'.
	 * @see EventAutomatonModel.ConstantBinding#getBoundTo()
	 * @see #getConstantBinding()
	 * @generated
	 */
	EReference getConstantBinding_BoundTo();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.SymbolicEventParameter <em>Symbolic Event Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbolic Event Parameter</em>'.
	 * @see EventAutomatonModel.SymbolicEventParameter
	 * @generated
	 */
	EClass getSymbolicEventParameter();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.FreeParameter <em>Free Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Free Parameter</em>'.
	 * @see EventAutomatonModel.FreeParameter
	 * @generated
	 */
	EClass getFreeParameter();

	/**
	 * Returns the meta object for the attribute list '{@link EventAutomatonModel.FreeParameter#getExcludedValues <em>Excluded Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Excluded Values</em>'.
	 * @see EventAutomatonModel.FreeParameter#getExcludedValues()
	 * @see #getFreeParameter()
	 * @generated
	 */
	EAttribute getFreeParameter_ExcludedValues();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.SetTimerAction <em>Set Timer Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Timer Action</em>'.
	 * @see EventAutomatonModel.SetTimerAction
	 * @generated
	 */
	EClass getSetTimerAction();

	/**
	 * Returns the meta object for the attribute '{@link EventAutomatonModel.SetTimerAction#getToValue <em>To Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Value</em>'.
	 * @see EventAutomatonModel.SetTimerAction#getToValue()
	 * @see #getSetTimerAction()
	 * @generated
	 */
	EAttribute getSetTimerAction_ToValue();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.SymbolicTimeoutEvent <em>Symbolic Timeout Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbolic Timeout Event</em>'.
	 * @see EventAutomatonModel.SymbolicTimeoutEvent
	 * @generated
	 */
	EClass getSymbolicTimeoutEvent();

	/**
	 * Returns the meta object for the container reference '{@link EventAutomatonModel.SymbolicTimeoutEvent#getTimer <em>Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Timer</em>'.
	 * @see EventAutomatonModel.SymbolicTimeoutEvent#getTimer()
	 * @see #getSymbolicTimeoutEvent()
	 * @generated
	 */
	EReference getSymbolicTimeoutEvent_Timer();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see EventAutomatonModel.Binding
	 * @generated
	 */
	EClass getBinding();

	/**
	 * Returns the meta object for the reference '{@link EventAutomatonModel.Binding#getBinds <em>Binds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binds</em>'.
	 * @see EventAutomatonModel.Binding#getBinds()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_Binds();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.FixParameter <em>Fix Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fix Parameter</em>'.
	 * @see EventAutomatonModel.FixParameter
	 * @generated
	 */
	EClass getFixParameter();

	/**
	 * Returns the meta object for the attribute '{@link EventAutomatonModel.FixParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see EventAutomatonModel.FixParameter#getValue()
	 * @see #getFixParameter()
	 * @generated
	 */
	EAttribute getFixParameter_Value();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.TimerAction <em>Timer Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timer Action</em>'.
	 * @see EventAutomatonModel.TimerAction
	 * @generated
	 */
	EClass getTimerAction();

	/**
	 * Returns the meta object for the reference '{@link EventAutomatonModel.TimerAction#getTimer <em>Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Timer</em>'.
	 * @see EventAutomatonModel.TimerAction#getTimer()
	 * @see #getTimerAction()
	 * @generated
	 */
	EReference getTimerAction_Timer();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.EpsilonTransition <em>Epsilon Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Epsilon Transition</em>'.
	 * @see EventAutomatonModel.EpsilonTransition
	 * @generated
	 */
	EClass getEpsilonTransition();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.AbstractTransition <em>Abstract Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Transition</em>'.
	 * @see EventAutomatonModel.AbstractTransition
	 * @generated
	 */
	EClass getAbstractTransition();

	/**
	 * Returns the meta object for the container reference '{@link EventAutomatonModel.AbstractTransition#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>From</em>'.
	 * @see EventAutomatonModel.AbstractTransition#getFrom()
	 * @see #getAbstractTransition()
	 * @generated
	 */
	EReference getAbstractTransition_From();

	/**
	 * Returns the meta object for the containment reference list '{@link EventAutomatonModel.AbstractTransition#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see EventAutomatonModel.AbstractTransition#getActions()
	 * @see #getAbstractTransition()
	 * @generated
	 */
	EReference getAbstractTransition_Actions();

	/**
	 * Returns the meta object for the reference '{@link EventAutomatonModel.AbstractTransition#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see EventAutomatonModel.AbstractTransition#getTo()
	 * @see #getAbstractTransition()
	 * @generated
	 */
	EReference getAbstractTransition_To();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see EventAutomatonModel.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.SymbolicParameter <em>Symbolic Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbolic Parameter</em>'.
	 * @see EventAutomatonModel.SymbolicParameter
	 * @generated
	 */
	EClass getSymbolicParameter();

	/**
	 * Returns the meta object for the attribute '{@link EventAutomatonModel.SymbolicParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see EventAutomatonModel.SymbolicParameter#getName()
	 * @see #getSymbolicParameter()
	 * @generated
	 */
	EAttribute getSymbolicParameter_Name();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see EventAutomatonModel.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the reference '{@link EventAutomatonModel.Event#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see EventAutomatonModel.Event#getType()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link EventAutomatonModel.Event#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see EventAutomatonModel.Event#getParameters()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Parameters();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.Token <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token</em>'.
	 * @see EventAutomatonModel.Token
	 * @generated
	 */
	EClass getToken();

	/**
	 * Returns the meta object for the container reference '{@link EventAutomatonModel.Token#getOn <em>On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>On</em>'.
	 * @see EventAutomatonModel.Token#getOn()
	 * @see #getToken()
	 * @generated
	 */
	EReference getToken_On();

	/**
	 * Returns the meta object for the containment reference list '{@link EventAutomatonModel.Token#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see EventAutomatonModel.Token#getParameters()
	 * @see #getToken()
	 * @generated
	 */
	EReference getToken_Parameters();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see EventAutomatonModel.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the containment reference '{@link EventAutomatonModel.Transition#getEventguard <em>Eventguard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Eventguard</em>'.
	 * @see EventAutomatonModel.Transition#getEventguard()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Eventguard();

	/**
	 * Returns the meta object for class '{@link EventAutomatonModel.EventGuard <em>Event Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Guard</em>'.
	 * @see EventAutomatonModel.EventGuard
	 * @generated
	 */
	EClass getEventGuard();

	/**
	 * Returns the meta object for the containment reference list '{@link EventAutomatonModel.EventGuard#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see EventAutomatonModel.EventGuard#getBindings()
	 * @see #getEventGuard()
	 * @generated
	 */
	EReference getEventGuard_Bindings();

	/**
	 * Returns the meta object for the reference '{@link EventAutomatonModel.EventGuard#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see EventAutomatonModel.EventGuard#getType()
	 * @see #getEventGuard()
	 * @generated
	 */
	EReference getEventGuard_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EventAutomatonModelFactory getEventAutomatonModelFactory();

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
		 * The meta object literal for the '{@link EventAutomatonModel.impl.AutomatonImpl <em>Automaton</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.AutomatonImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getAutomaton()
		 * @generated
		 */
		EClass AUTOMATON = eINSTANCE.getAutomaton();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTOMATON__STATES = eINSTANCE.getAutomaton_States();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTOMATON__TOKENS = eINSTANCE.getAutomaton_Tokens();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTOMATON__INITIAL_STATE = eINSTANCE.getAutomaton_InitialState();

		/**
		 * The meta object literal for the '<em><b>Symbolic Token Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTOMATON__SYMBOLIC_TOKEN_PARAMETERS = eINSTANCE.getAutomaton_SymbolicTokenParameters();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTOMATON__NAME = eINSTANCE.getAutomaton_Name();

		/**
		 * The meta object literal for the '<em><b>Timers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTOMATON__TIMERS = eINSTANCE.getAutomaton_Timers();

		/**
		 * The meta object literal for the '<em><b>Trap State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTOMATON__TRAP_STATE = eINSTANCE.getAutomaton_TrapState();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.TokenParameterBindingImpl <em>Token Parameter Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.TokenParameterBindingImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getTokenParameterBinding()
		 * @generated
		 */
		EClass TOKEN_PARAMETER_BINDING = eINSTANCE.getTokenParameterBinding();

		/**
		 * The meta object literal for the '<em><b>Bound To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOKEN_PARAMETER_BINDING__BOUND_TO = eINSTANCE.getTokenParameterBinding_BoundTo();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.ResetTimerActionImpl <em>Reset Timer Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.ResetTimerActionImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getResetTimerAction()
		 * @generated
		 */
		EClass RESET_TIMER_ACTION = eINSTANCE.getResetTimerAction();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.SymbolicInputEventImpl <em>Symbolic Input Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.SymbolicInputEventImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSymbolicInputEvent()
		 * @generated
		 */
		EClass SYMBOLIC_INPUT_EVENT = eINSTANCE.getSymbolicInputEvent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYMBOLIC_INPUT_EVENT__NAME = eINSTANCE.getSymbolicInputEvent_Name();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.SymbolicTimerImpl <em>Symbolic Timer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.SymbolicTimerImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSymbolicTimer()
		 * @generated
		 */
		EClass SYMBOLIC_TIMER = eINSTANCE.getSymbolicTimer();

		/**
		 * The meta object literal for the '<em><b>Timeout Event</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYMBOLIC_TIMER__TIMEOUT_EVENT = eINSTANCE.getSymbolicTimer_TimeoutEvent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYMBOLIC_TIMER__NAME = eINSTANCE.getSymbolicTimer_Name();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.SymbolicTokenParameterImpl <em>Symbolic Token Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.SymbolicTokenParameterImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSymbolicTokenParameter()
		 * @generated
		 */
		EClass SYMBOLIC_TOKEN_PARAMETER = eINSTANCE.getSymbolicTokenParameter();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.ComplexEventProcessorImpl <em>Complex Event Processor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.ComplexEventProcessorImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getComplexEventProcessor()
		 * @generated
		 */
		EClass COMPLEX_EVENT_PROCESSOR = eINSTANCE.getComplexEventProcessor();

		/**
		 * The meta object literal for the '<em><b>Automata</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_EVENT_PROCESSOR__AUTOMATA = eINSTANCE.getComplexEventProcessor_Automata();

		/**
		 * The meta object literal for the '<em><b>Symbolic Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_EVENT_PROCESSOR__SYMBOLIC_EVENTS = eINSTANCE.getComplexEventProcessor_SymbolicEvents();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.SymbolicEventImpl <em>Symbolic Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.SymbolicEventImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSymbolicEvent()
		 * @generated
		 */
		EClass SYMBOLIC_EVENT = eINSTANCE.getSymbolicEvent();

		/**
		 * The meta object literal for the '<em><b>Symbolic Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYMBOLIC_EVENT__SYMBOLIC_PARAMETERS = eINSTANCE.getSymbolicEvent_SymbolicParameters();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.ParameterImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.StateImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Outgoing Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OUTGOING_TRANSITIONS = eINSTANCE.getState_OutgoingTransitions();

		/**
		 * The meta object literal for the '<em><b>Incoming Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__INCOMING_TRANSITIONS = eINSTANCE.getState_IncomingTransitions();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__TOKENS = eINSTANCE.getState_Tokens();

		/**
		 * The meta object literal for the '<em><b>Acceptor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__ACCEPTOR = eINSTANCE.getState_Acceptor();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__ID = eINSTANCE.getState_Id();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.ConstantBindingImpl <em>Constant Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.ConstantBindingImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getConstantBinding()
		 * @generated
		 */
		EClass CONSTANT_BINDING = eINSTANCE.getConstantBinding();

		/**
		 * The meta object literal for the '<em><b>Bound To</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTANT_BINDING__BOUND_TO = eINSTANCE.getConstantBinding_BoundTo();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.SymbolicEventParameterImpl <em>Symbolic Event Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.SymbolicEventParameterImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSymbolicEventParameter()
		 * @generated
		 */
		EClass SYMBOLIC_EVENT_PARAMETER = eINSTANCE.getSymbolicEventParameter();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.FreeParameterImpl <em>Free Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.FreeParameterImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getFreeParameter()
		 * @generated
		 */
		EClass FREE_PARAMETER = eINSTANCE.getFreeParameter();

		/**
		 * The meta object literal for the '<em><b>Excluded Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FREE_PARAMETER__EXCLUDED_VALUES = eINSTANCE.getFreeParameter_ExcludedValues();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.SetTimerActionImpl <em>Set Timer Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.SetTimerActionImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSetTimerAction()
		 * @generated
		 */
		EClass SET_TIMER_ACTION = eINSTANCE.getSetTimerAction();

		/**
		 * The meta object literal for the '<em><b>To Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TIMER_ACTION__TO_VALUE = eINSTANCE.getSetTimerAction_ToValue();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.SymbolicTimeoutEventImpl <em>Symbolic Timeout Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.SymbolicTimeoutEventImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSymbolicTimeoutEvent()
		 * @generated
		 */
		EClass SYMBOLIC_TIMEOUT_EVENT = eINSTANCE.getSymbolicTimeoutEvent();

		/**
		 * The meta object literal for the '<em><b>Timer</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYMBOLIC_TIMEOUT_EVENT__TIMER = eINSTANCE.getSymbolicTimeoutEvent_Timer();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.BindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.BindingImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getBinding()
		 * @generated
		 */
		EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '<em><b>Binds</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING__BINDS = eINSTANCE.getBinding_Binds();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.FixParameterImpl <em>Fix Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.FixParameterImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getFixParameter()
		 * @generated
		 */
		EClass FIX_PARAMETER = eINSTANCE.getFixParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIX_PARAMETER__VALUE = eINSTANCE.getFixParameter_Value();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.TimerActionImpl <em>Timer Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.TimerActionImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getTimerAction()
		 * @generated
		 */
		EClass TIMER_ACTION = eINSTANCE.getTimerAction();

		/**
		 * The meta object literal for the '<em><b>Timer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMER_ACTION__TIMER = eINSTANCE.getTimerAction_Timer();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.EpsilonTransitionImpl <em>Epsilon Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.EpsilonTransitionImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getEpsilonTransition()
		 * @generated
		 */
		EClass EPSILON_TRANSITION = eINSTANCE.getEpsilonTransition();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.AbstractTransitionImpl <em>Abstract Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.AbstractTransitionImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getAbstractTransition()
		 * @generated
		 */
		EClass ABSTRACT_TRANSITION = eINSTANCE.getAbstractTransition();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TRANSITION__FROM = eINSTANCE.getAbstractTransition_From();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TRANSITION__ACTIONS = eINSTANCE.getAbstractTransition_Actions();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TRANSITION__TO = eINSTANCE.getAbstractTransition_To();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.ActionImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.SymbolicParameterImpl <em>Symbolic Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.SymbolicParameterImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getSymbolicParameter()
		 * @generated
		 */
		EClass SYMBOLIC_PARAMETER = eINSTANCE.getSymbolicParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYMBOLIC_PARAMETER__NAME = eINSTANCE.getSymbolicParameter_Name();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.EventImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__TYPE = eINSTANCE.getEvent_Type();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__PARAMETERS = eINSTANCE.getEvent_Parameters();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.TokenImpl <em>Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.TokenImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getToken()
		 * @generated
		 */
		EClass TOKEN = eINSTANCE.getToken();

		/**
		 * The meta object literal for the '<em><b>On</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOKEN__ON = eINSTANCE.getToken_On();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOKEN__PARAMETERS = eINSTANCE.getToken_Parameters();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.TransitionImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Eventguard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__EVENTGUARD = eINSTANCE.getTransition_Eventguard();

		/**
		 * The meta object literal for the '{@link EventAutomatonModel.impl.EventGuardImpl <em>Event Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EventAutomatonModel.impl.EventGuardImpl
		 * @see EventAutomatonModel.impl.EventAutomatonModelPackageImpl#getEventGuard()
		 * @generated
		 */
		EClass EVENT_GUARD = eINSTANCE.getEventGuard();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_GUARD__BINDINGS = eINSTANCE.getEventGuard_Bindings();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_GUARD__TYPE = eINSTANCE.getEventGuard_Type();

	}

} //EventAutomatonModelPackage
