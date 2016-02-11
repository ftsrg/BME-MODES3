/**
 */
package EventAutomatonModel.impl;

import EventAutomatonModel.Automaton;
import EventAutomatonModel.EventAutomatonModelPackage;
import EventAutomatonModel.State;
import EventAutomatonModel.SymbolicParameter;
import EventAutomatonModel.SymbolicTimer;
import EventAutomatonModel.Token;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Automaton</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.impl.AutomatonImpl#getStates <em>States</em>}</li>
 *   <li>{@link EventAutomatonModel.impl.AutomatonImpl#getTokens <em>Tokens</em>}</li>
 *   <li>{@link EventAutomatonModel.impl.AutomatonImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link EventAutomatonModel.impl.AutomatonImpl#getSymbolicTokenParameters <em>Symbolic Token Parameters</em>}</li>
 *   <li>{@link EventAutomatonModel.impl.AutomatonImpl#getName <em>Name</em>}</li>
 *   <li>{@link EventAutomatonModel.impl.AutomatonImpl#getTimers <em>Timers</em>}</li>
 *   <li>{@link EventAutomatonModel.impl.AutomatonImpl#getTrapState <em>Trap State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AutomatonImpl extends MinimalEObjectImpl.Container implements Automaton {
	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

	/**
	 * The cached value of the '{@link #getTokens() <em>Tokens</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokens()
	 * @generated
	 * @ordered
	 */
	protected EList<Token> tokens;

	/**
	 * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialState()
	 * @generated
	 * @ordered
	 */
	protected State initialState;

	/**
	 * The cached value of the '{@link #getSymbolicTokenParameters() <em>Symbolic Token Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbolicTokenParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<SymbolicParameter> symbolicTokenParameters;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTimers() <em>Timers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimers()
	 * @generated
	 * @ordered
	 */
	protected EList<SymbolicTimer> timers;

	/**
	 * The cached value of the '{@link #getTrapState() <em>Trap State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrapState()
	 * @generated
	 * @ordered
	 */
	protected State trapState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AutomatonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventAutomatonModelPackage.Literals.AUTOMATON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, EventAutomatonModelPackage.AUTOMATON__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Token> getTokens() {
		if (tokens == null) {
			tokens = new EObjectResolvingEList<Token>(Token.class, this, EventAutomatonModelPackage.AUTOMATON__TOKENS);
		}
		return tokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getInitialState() {
		if (initialState != null && initialState.eIsProxy()) {
			InternalEObject oldInitialState = (InternalEObject)initialState;
			initialState = (State)eResolveProxy(oldInitialState);
			if (initialState != oldInitialState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventAutomatonModelPackage.AUTOMATON__INITIAL_STATE, oldInitialState, initialState));
			}
		}
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetInitialState() {
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialState(State newInitialState) {
		State oldInitialState = initialState;
		initialState = newInitialState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventAutomatonModelPackage.AUTOMATON__INITIAL_STATE, oldInitialState, initialState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SymbolicParameter> getSymbolicTokenParameters() {
		if (symbolicTokenParameters == null) {
			symbolicTokenParameters = new EObjectContainmentEList<SymbolicParameter>(SymbolicParameter.class, this, EventAutomatonModelPackage.AUTOMATON__SYMBOLIC_TOKEN_PARAMETERS);
		}
		return symbolicTokenParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventAutomatonModelPackage.AUTOMATON__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SymbolicTimer> getTimers() {
		if (timers == null) {
			timers = new EObjectContainmentEList<SymbolicTimer>(SymbolicTimer.class, this, EventAutomatonModelPackage.AUTOMATON__TIMERS);
		}
		return timers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getTrapState() {
		if (trapState != null && trapState.eIsProxy()) {
			InternalEObject oldTrapState = (InternalEObject)trapState;
			trapState = (State)eResolveProxy(oldTrapState);
			if (trapState != oldTrapState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventAutomatonModelPackage.AUTOMATON__TRAP_STATE, oldTrapState, trapState));
			}
		}
		return trapState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetTrapState() {
		return trapState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrapState(State newTrapState) {
		State oldTrapState = trapState;
		trapState = newTrapState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventAutomatonModelPackage.AUTOMATON__TRAP_STATE, oldTrapState, trapState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventAutomatonModelPackage.AUTOMATON__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case EventAutomatonModelPackage.AUTOMATON__SYMBOLIC_TOKEN_PARAMETERS:
				return ((InternalEList<?>)getSymbolicTokenParameters()).basicRemove(otherEnd, msgs);
			case EventAutomatonModelPackage.AUTOMATON__TIMERS:
				return ((InternalEList<?>)getTimers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventAutomatonModelPackage.AUTOMATON__STATES:
				return getStates();
			case EventAutomatonModelPackage.AUTOMATON__TOKENS:
				return getTokens();
			case EventAutomatonModelPackage.AUTOMATON__INITIAL_STATE:
				if (resolve) return getInitialState();
				return basicGetInitialState();
			case EventAutomatonModelPackage.AUTOMATON__SYMBOLIC_TOKEN_PARAMETERS:
				return getSymbolicTokenParameters();
			case EventAutomatonModelPackage.AUTOMATON__NAME:
				return getName();
			case EventAutomatonModelPackage.AUTOMATON__TIMERS:
				return getTimers();
			case EventAutomatonModelPackage.AUTOMATON__TRAP_STATE:
				if (resolve) return getTrapState();
				return basicGetTrapState();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EventAutomatonModelPackage.AUTOMATON__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case EventAutomatonModelPackage.AUTOMATON__TOKENS:
				getTokens().clear();
				getTokens().addAll((Collection<? extends Token>)newValue);
				return;
			case EventAutomatonModelPackage.AUTOMATON__INITIAL_STATE:
				setInitialState((State)newValue);
				return;
			case EventAutomatonModelPackage.AUTOMATON__SYMBOLIC_TOKEN_PARAMETERS:
				getSymbolicTokenParameters().clear();
				getSymbolicTokenParameters().addAll((Collection<? extends SymbolicParameter>)newValue);
				return;
			case EventAutomatonModelPackage.AUTOMATON__NAME:
				setName((String)newValue);
				return;
			case EventAutomatonModelPackage.AUTOMATON__TIMERS:
				getTimers().clear();
				getTimers().addAll((Collection<? extends SymbolicTimer>)newValue);
				return;
			case EventAutomatonModelPackage.AUTOMATON__TRAP_STATE:
				setTrapState((State)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EventAutomatonModelPackage.AUTOMATON__STATES:
				getStates().clear();
				return;
			case EventAutomatonModelPackage.AUTOMATON__TOKENS:
				getTokens().clear();
				return;
			case EventAutomatonModelPackage.AUTOMATON__INITIAL_STATE:
				setInitialState((State)null);
				return;
			case EventAutomatonModelPackage.AUTOMATON__SYMBOLIC_TOKEN_PARAMETERS:
				getSymbolicTokenParameters().clear();
				return;
			case EventAutomatonModelPackage.AUTOMATON__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EventAutomatonModelPackage.AUTOMATON__TIMERS:
				getTimers().clear();
				return;
			case EventAutomatonModelPackage.AUTOMATON__TRAP_STATE:
				setTrapState((State)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EventAutomatonModelPackage.AUTOMATON__STATES:
				return states != null && !states.isEmpty();
			case EventAutomatonModelPackage.AUTOMATON__TOKENS:
				return tokens != null && !tokens.isEmpty();
			case EventAutomatonModelPackage.AUTOMATON__INITIAL_STATE:
				return initialState != null;
			case EventAutomatonModelPackage.AUTOMATON__SYMBOLIC_TOKEN_PARAMETERS:
				return symbolicTokenParameters != null && !symbolicTokenParameters.isEmpty();
			case EventAutomatonModelPackage.AUTOMATON__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EventAutomatonModelPackage.AUTOMATON__TIMERS:
				return timers != null && !timers.isEmpty();
			case EventAutomatonModelPackage.AUTOMATON__TRAP_STATE:
				return trapState != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //AutomatonImpl
