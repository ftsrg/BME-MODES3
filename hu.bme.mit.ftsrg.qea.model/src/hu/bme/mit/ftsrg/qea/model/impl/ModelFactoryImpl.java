/**
 */
package hu.bme.mit.ftsrg.qea.model.impl;

import hu.bme.mit.ftsrg.qea.model.*;

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
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelFactory init() {
		try {
			ModelFactory theModelFactory = (ModelFactory)EPackage.Registry.INSTANCE.getEFactory(ModelPackage.eNS_URI);
			if (theModelFactory != null) {
				return theModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactoryImpl() {
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
			case ModelPackage.AUTOMATON: return createAutomaton();
			case ModelPackage.STATE: return createState();
			case ModelPackage.EVENT: return createEvent();
			case ModelPackage.TOKEN: return createToken();
			case ModelPackage.FIX_PARAMETER: return createFixParameter();
			case ModelPackage.FREE_PARAMETER: return createFreeParameter();
			case ModelPackage.COMPLEX_EVENT_PROCESSOR: return createComplexEventProcessor();
			case ModelPackage.EVENT_GUARD: return createEventGuard();
			case ModelPackage.CONSTANT_BINDING: return createConstantBinding();
			case ModelPackage.TOKEN_PARAMETER_BINDING: return createTokenParameterBinding();
			case ModelPackage.EPSILON_TRANSITION: return createEpsilonTransition();
			case ModelPackage.SET_TIMER_ACTION: return createSetTimerAction();
			case ModelPackage.RESET_TIMER_ACTION: return createResetTimerAction();
			case ModelPackage.SYMBOLIC_TIMER: return createSymbolicTimer();
			case ModelPackage.TRANSITION: return createTransition();
			case ModelPackage.SYMBOLIC_TOKEN_PARAMETER: return createSymbolicTokenParameter();
			case ModelPackage.SYMBOLIC_EVENT_PARAMETER: return createSymbolicEventParameter();
			case ModelPackage.SYMBOLIC_INPUT_EVENT: return createSymbolicInputEvent();
			case ModelPackage.SYMBOLIC_TIMEOUT_EVENT: return createSymbolicTimeoutEvent();
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
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
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
	public FixParameter createFixParameter() {
		FixParameterImpl fixParameter = new FixParameterImpl();
		return fixParameter;
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
	public ComplexEventProcessor createComplexEventProcessor() {
		ComplexEventProcessorImpl complexEventProcessor = new ComplexEventProcessorImpl();
		return complexEventProcessor;
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
	public ConstantBinding createConstantBinding() {
		ConstantBindingImpl constantBinding = new ConstantBindingImpl();
		return constantBinding;
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
	public EpsilonTransition createEpsilonTransition() {
		EpsilonTransitionImpl epsilonTransition = new EpsilonTransitionImpl();
		return epsilonTransition;
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
	public ResetTimerAction createResetTimerAction() {
		ResetTimerActionImpl resetTimerAction = new ResetTimerActionImpl();
		return resetTimerAction;
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
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
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
	public SymbolicEventParameter createSymbolicEventParameter() {
		SymbolicEventParameterImpl symbolicEventParameter = new SymbolicEventParameterImpl();
		return symbolicEventParameter;
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
	public SymbolicTimeoutEvent createSymbolicTimeoutEvent() {
		SymbolicTimeoutEventImpl symbolicTimeoutEvent = new SymbolicTimeoutEventImpl();
		return symbolicTimeoutEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelPackage getModelPackage() {
		return (ModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelPackage getPackage() {
		return ModelPackage.eINSTANCE;
	}

} //ModelFactoryImpl
