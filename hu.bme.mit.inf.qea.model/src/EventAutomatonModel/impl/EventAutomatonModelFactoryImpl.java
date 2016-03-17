/**
 */
package EventAutomatonModel.impl;

import EventAutomatonModel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventAutomatonModelFactoryImpl extends EFactoryImpl implements EventAutomatonModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventAutomatonModelFactory init() {
		try {
			EventAutomatonModelFactory theEventAutomatonModelFactory = (EventAutomatonModelFactory)EPackage.Registry.INSTANCE.getEFactory(EventAutomatonModelPackage.eNS_URI);
			if (theEventAutomatonModelFactory != null) {
				return theEventAutomatonModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EventAutomatonModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventAutomatonModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EventAutomatonModelPackage.AUTOMATON: return createAutomaton();
			case EventAutomatonModelPackage.TOKEN_PARAMETER_BINDING: return createTokenParameterBinding();
			case EventAutomatonModelPackage.RESET_TIMER_ACTION: return createResetTimerAction();
			case EventAutomatonModelPackage.SYMBOLIC_INPUT_EVENT: return createSymbolicInputEvent();
			case EventAutomatonModelPackage.SYMBOLIC_TIMER: return createSymbolicTimer();
			case EventAutomatonModelPackage.SYMBOLIC_TOKEN_PARAMETER: return createSymbolicTokenParameter();
			case EventAutomatonModelPackage.COMPLEX_EVENT_PROCESSOR: return createComplexEventProcessor();
			case EventAutomatonModelPackage.STATE: return createState();
			case EventAutomatonModelPackage.CONSTANT_BINDING: return createConstantBinding();
			case EventAutomatonModelPackage.SYMBOLIC_EVENT_PARAMETER: return createSymbolicEventParameter();
			case EventAutomatonModelPackage.FREE_PARAMETER: return createFreeParameter();
			case EventAutomatonModelPackage.SET_TIMER_ACTION: return createSetTimerAction();
			case EventAutomatonModelPackage.SYMBOLIC_TIMEOUT_EVENT: return createSymbolicTimeoutEvent();
			case EventAutomatonModelPackage.FIX_PARAMETER: return createFixParameter();
			case EventAutomatonModelPackage.EPSILON_TRANSITION: return createEpsilonTransition();
			case EventAutomatonModelPackage.EVENT: return createEvent();
			case EventAutomatonModelPackage.TOKEN: return createToken();
			case EventAutomatonModelPackage.TRANSITION: return createTransition();
			case EventAutomatonModelPackage.EVENT_GUARD: return createEventGuard();
			case EventAutomatonModelPackage.ABSTRACT_TRANSITION: return createAbstractTransition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Automaton createAutomaton() {
		AutomatonImpl automaton = new AutomatonImpl();
		return automaton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TokenParameterBinding createTokenParameterBinding() {
		TokenParameterBindingImpl tokenParameterBinding = new TokenParameterBindingImpl();
		return tokenParameterBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResetTimerAction createResetTimerAction() {
		ResetTimerActionImpl resetTimerAction = new ResetTimerActionImpl();
		return resetTimerAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolicInputEvent createSymbolicInputEvent() {
		SymbolicInputEventImpl symbolicInputEvent = new SymbolicInputEventImpl();
		return symbolicInputEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolicTimer createSymbolicTimer() {
		SymbolicTimerImpl symbolicTimer = new SymbolicTimerImpl();
		return symbolicTimer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolicTokenParameter createSymbolicTokenParameter() {
		SymbolicTokenParameterImpl symbolicTokenParameter = new SymbolicTokenParameterImpl();
		return symbolicTokenParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexEventProcessor createComplexEventProcessor() {
		ComplexEventProcessorImpl complexEventProcessor = new ComplexEventProcessorImpl();
		return complexEventProcessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantBinding createConstantBinding() {
		ConstantBindingImpl constantBinding = new ConstantBindingImpl();
		return constantBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolicEventParameter createSymbolicEventParameter() {
		SymbolicEventParameterImpl symbolicEventParameter = new SymbolicEventParameterImpl();
		return symbolicEventParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FreeParameter createFreeParameter() {
		FreeParameterImpl freeParameter = new FreeParameterImpl();
		return freeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetTimerAction createSetTimerAction() {
		SetTimerActionImpl setTimerAction = new SetTimerActionImpl();
		return setTimerAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolicTimeoutEvent createSymbolicTimeoutEvent() {
		SymbolicTimeoutEventImpl symbolicTimeoutEvent = new SymbolicTimeoutEventImpl();
		return symbolicTimeoutEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixParameter createFixParameter() {
		FixParameterImpl fixParameter = new FixParameterImpl();
		return fixParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpsilonTransition createEpsilonTransition() {
		EpsilonTransitionImpl epsilonTransition = new EpsilonTransitionImpl();
		return epsilonTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Token createToken() {
		TokenImpl token = new TokenImpl();
		return token;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventGuard createEventGuard() {
		EventGuardImpl eventGuard = new EventGuardImpl();
		return eventGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTransition createAbstractTransition() {
		AbstractTransitionImpl abstractTransition = new AbstractTransitionImpl();
		return abstractTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventAutomatonModelPackage getEventAutomatonModelPackage() {
		return (EventAutomatonModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EventAutomatonModelPackage getPackage() {
		return EventAutomatonModelPackage.eINSTANCE;
	}

} //EventAutomatonModelFactoryImpl
