/**
 */
package EventAutomatonModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Automaton</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.Automaton#getStates <em>States</em>}</li>
 *   <li>{@link EventAutomatonModel.Automaton#getTokens <em>Tokens</em>}</li>
 *   <li>{@link EventAutomatonModel.Automaton#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link EventAutomatonModel.Automaton#getSymbolicTokenParameters <em>Symbolic Token Parameters</em>}</li>
 *   <li>{@link EventAutomatonModel.Automaton#getName <em>Name</em>}</li>
 *   <li>{@link EventAutomatonModel.Automaton#getTimers <em>Timers</em>}</li>
 *   <li>{@link EventAutomatonModel.Automaton#getTrapState <em>Trap State</em>}</li>
 * </ul>
 *
 * @see EventAutomatonModel.EventAutomatonModelPackage#getAutomaton()
 * @model
 * @generated
 */
public interface Automaton extends EObject {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link EventAutomatonModel.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getAutomaton_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Tokens</b></em>' reference list.
	 * The list contents are of type {@link EventAutomatonModel.Token}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tokens</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens</em>' reference list.
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getAutomaton_Tokens()
	 * @model
	 * @generated
	 */
	EList<Token> getTokens();

	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' reference.
	 * @see #setInitialState(State)
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getAutomaton_InitialState()
	 * @model required="true"
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.Automaton#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

	/**
	 * Returns the value of the '<em><b>Symbolic Token Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link EventAutomatonModel.SymbolicParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbolic Token Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbolic Token Parameters</em>' containment reference list.
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getAutomaton_SymbolicTokenParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<SymbolicParameter> getSymbolicTokenParameters();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getAutomaton_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.Automaton#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Timers</b></em>' containment reference list.
	 * The list contents are of type {@link EventAutomatonModel.SymbolicTimer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timers</em>' containment reference list.
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getAutomaton_Timers()
	 * @model containment="true"
	 * @generated
	 */
	EList<SymbolicTimer> getTimers();

	/**
	 * Returns the value of the '<em><b>Trap State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trap State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trap State</em>' reference.
	 * @see #setTrapState(State)
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getAutomaton_TrapState()
	 * @model required="true"
	 * @generated
	 */
	State getTrapState();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.Automaton#getTrapState <em>Trap State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trap State</em>' reference.
	 * @see #getTrapState()
	 * @generated
	 */
	void setTrapState(State value);

} // Automaton
