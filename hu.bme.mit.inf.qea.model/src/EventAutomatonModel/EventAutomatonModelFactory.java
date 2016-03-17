/**
 */
package EventAutomatonModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see EventAutomatonModel.EventAutomatonModelPackage
 * @generated
 */
public interface EventAutomatonModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventAutomatonModelFactory eINSTANCE = EventAutomatonModel.impl.EventAutomatonModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Automaton</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Automaton</em>'.
	 * @generated
	 */
	Automaton createAutomaton();

	/**
	 * Returns a new object of class '<em>Token Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Token Parameter Binding</em>'.
	 * @generated
	 */
	TokenParameterBinding createTokenParameterBinding();

	/**
	 * Returns a new object of class '<em>Reset Timer Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reset Timer Action</em>'.
	 * @generated
	 */
	ResetTimerAction createResetTimerAction();

	/**
	 * Returns a new object of class '<em>Symbolic Input Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Symbolic Input Event</em>'.
	 * @generated
	 */
	SymbolicInputEvent createSymbolicInputEvent();

	/**
	 * Returns a new object of class '<em>Symbolic Timer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Symbolic Timer</em>'.
	 * @generated
	 */
	SymbolicTimer createSymbolicTimer();

	/**
	 * Returns a new object of class '<em>Symbolic Token Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Symbolic Token Parameter</em>'.
	 * @generated
	 */
	SymbolicTokenParameter createSymbolicTokenParameter();

	/**
	 * Returns a new object of class '<em>Complex Event Processor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Event Processor</em>'.
	 * @generated
	 */
	ComplexEventProcessor createComplexEventProcessor();

	/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

	/**
	 * Returns a new object of class '<em>Constant Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constant Binding</em>'.
	 * @generated
	 */
	ConstantBinding createConstantBinding();

	/**
	 * Returns a new object of class '<em>Symbolic Event Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Symbolic Event Parameter</em>'.
	 * @generated
	 */
	SymbolicEventParameter createSymbolicEventParameter();

	/**
	 * Returns a new object of class '<em>Free Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Free Parameter</em>'.
	 * @generated
	 */
	FreeParameter createFreeParameter();

	/**
	 * Returns a new object of class '<em>Set Timer Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Timer Action</em>'.
	 * @generated
	 */
	SetTimerAction createSetTimerAction();

	/**
	 * Returns a new object of class '<em>Symbolic Timeout Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Symbolic Timeout Event</em>'.
	 * @generated
	 */
	SymbolicTimeoutEvent createSymbolicTimeoutEvent();

	/**
	 * Returns a new object of class '<em>Fix Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fix Parameter</em>'.
	 * @generated
	 */
	FixParameter createFixParameter();

	/**
	 * Returns a new object of class '<em>Epsilon Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Epsilon Transition</em>'.
	 * @generated
	 */
	EpsilonTransition createEpsilonTransition();

	/**
	 * Returns a new object of class '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event</em>'.
	 * @generated
	 */
	Event createEvent();

	/**
	 * Returns a new object of class '<em>Token</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Token</em>'.
	 * @generated
	 */
	Token createToken();

	/**
	 * Returns a new object of class '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition</em>'.
	 * @generated
	 */
	Transition createTransition();

	/**
	 * Returns a new object of class '<em>Event Guard</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Guard</em>'.
	 * @generated
	 */
	EventGuard createEventGuard();

	/**
	 * Returns a new object of class '<em>Abstract Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Transition</em>'.
	 * @generated
	 */
	AbstractTransition createAbstractTransition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EventAutomatonModelPackage getEventAutomatonModelPackage();

} //EventAutomatonModelFactory
