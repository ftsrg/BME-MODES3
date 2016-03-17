/**
 */
package EventAutomatonModel.util;

import EventAutomatonModel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see EventAutomatonModel.EventAutomatonModelPackage
 * @generated
 */
public class EventAutomatonModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EventAutomatonModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventAutomatonModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EventAutomatonModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventAutomatonModelSwitch<Adapter> modelSwitch =
		new EventAutomatonModelSwitch<Adapter>() {
			@Override
			public Adapter caseAutomaton(Automaton object) {
				return createAutomatonAdapter();
			}
			@Override
			public Adapter caseTokenParameterBinding(TokenParameterBinding object) {
				return createTokenParameterBindingAdapter();
			}
			@Override
			public Adapter caseResetTimerAction(ResetTimerAction object) {
				return createResetTimerActionAdapter();
			}
			@Override
			public Adapter caseSymbolicInputEvent(SymbolicInputEvent object) {
				return createSymbolicInputEventAdapter();
			}
			@Override
			public Adapter caseSymbolicTimer(SymbolicTimer object) {
				return createSymbolicTimerAdapter();
			}
			@Override
			public Adapter caseSymbolicTokenParameter(SymbolicTokenParameter object) {
				return createSymbolicTokenParameterAdapter();
			}
			@Override
			public Adapter caseComplexEventProcessor(ComplexEventProcessor object) {
				return createComplexEventProcessorAdapter();
			}
			@Override
			public Adapter caseSymbolicEvent(SymbolicEvent object) {
				return createSymbolicEventAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseState(State object) {
				return createStateAdapter();
			}
			@Override
			public Adapter caseConstantBinding(ConstantBinding object) {
				return createConstantBindingAdapter();
			}
			@Override
			public Adapter caseSymbolicEventParameter(SymbolicEventParameter object) {
				return createSymbolicEventParameterAdapter();
			}
			@Override
			public Adapter caseFreeParameter(FreeParameter object) {
				return createFreeParameterAdapter();
			}
			@Override
			public Adapter caseSetTimerAction(SetTimerAction object) {
				return createSetTimerActionAdapter();
			}
			@Override
			public Adapter caseSymbolicTimeoutEvent(SymbolicTimeoutEvent object) {
				return createSymbolicTimeoutEventAdapter();
			}
			@Override
			public Adapter caseBinding(Binding object) {
				return createBindingAdapter();
			}
			@Override
			public Adapter caseFixParameter(FixParameter object) {
				return createFixParameterAdapter();
			}
			@Override
			public Adapter caseTimerAction(TimerAction object) {
				return createTimerActionAdapter();
			}
			@Override
			public Adapter caseEpsilonTransition(EpsilonTransition object) {
				return createEpsilonTransitionAdapter();
			}
			@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@Override
			public Adapter caseSymbolicParameter(SymbolicParameter object) {
				return createSymbolicParameterAdapter();
			}
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter caseToken(Token object) {
				return createTokenAdapter();
			}
			@Override
			public Adapter caseTransition(Transition object) {
				return createTransitionAdapter();
			}
			@Override
			public Adapter caseEventGuard(EventGuard object) {
				return createEventGuardAdapter();
			}
			@Override
			public Adapter caseAbstractTransition(AbstractTransition object) {
				return createAbstractTransitionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.Automaton <em>Automaton</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.Automaton
	 * @generated
	 */
	public Adapter createAutomatonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.TokenParameterBinding <em>Token Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.TokenParameterBinding
	 * @generated
	 */
	public Adapter createTokenParameterBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.ResetTimerAction <em>Reset Timer Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.ResetTimerAction
	 * @generated
	 */
	public Adapter createResetTimerActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.SymbolicInputEvent <em>Symbolic Input Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.SymbolicInputEvent
	 * @generated
	 */
	public Adapter createSymbolicInputEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.SymbolicTimer <em>Symbolic Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.SymbolicTimer
	 * @generated
	 */
	public Adapter createSymbolicTimerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.SymbolicTokenParameter <em>Symbolic Token Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.SymbolicTokenParameter
	 * @generated
	 */
	public Adapter createSymbolicTokenParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.ComplexEventProcessor <em>Complex Event Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.ComplexEventProcessor
	 * @generated
	 */
	public Adapter createComplexEventProcessorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.SymbolicEvent <em>Symbolic Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.SymbolicEvent
	 * @generated
	 */
	public Adapter createSymbolicEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.ConstantBinding <em>Constant Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.ConstantBinding
	 * @generated
	 */
	public Adapter createConstantBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.SymbolicEventParameter <em>Symbolic Event Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.SymbolicEventParameter
	 * @generated
	 */
	public Adapter createSymbolicEventParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.FreeParameter <em>Free Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.FreeParameter
	 * @generated
	 */
	public Adapter createFreeParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.SetTimerAction <em>Set Timer Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.SetTimerAction
	 * @generated
	 */
	public Adapter createSetTimerActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.SymbolicTimeoutEvent <em>Symbolic Timeout Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.SymbolicTimeoutEvent
	 * @generated
	 */
	public Adapter createSymbolicTimeoutEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.Binding
	 * @generated
	 */
	public Adapter createBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.FixParameter <em>Fix Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.FixParameter
	 * @generated
	 */
	public Adapter createFixParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.TimerAction <em>Timer Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.TimerAction
	 * @generated
	 */
	public Adapter createTimerActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.EpsilonTransition <em>Epsilon Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.EpsilonTransition
	 * @generated
	 */
	public Adapter createEpsilonTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.AbstractTransition <em>Abstract Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.AbstractTransition
	 * @generated
	 */
	public Adapter createAbstractTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.SymbolicParameter <em>Symbolic Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.SymbolicParameter
	 * @generated
	 */
	public Adapter createSymbolicParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.Token <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.Token
	 * @generated
	 */
	public Adapter createTokenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.Transition
	 * @generated
	 */
	public Adapter createTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EventAutomatonModel.EventGuard <em>Event Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EventAutomatonModel.EventGuard
	 * @generated
	 */
	public Adapter createEventGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EventAutomatonModelAdapterFactory
