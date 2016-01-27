/**
 */
package hu.bme.mit.ftsrg.qea.model.impl;

import hu.bme.mit.ftsrg.qea.model.AbstractTransition;
import hu.bme.mit.ftsrg.qea.model.Action;
import hu.bme.mit.ftsrg.qea.model.EventGuard;
import hu.bme.mit.ftsrg.qea.model.ModelPackage;
import hu.bme.mit.ftsrg.qea.model.State;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.impl.AbstractTransitionImpl#getFrom <em>From</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.impl.AbstractTransitionImpl#getTo <em>To</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.impl.AbstractTransitionImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.impl.AbstractTransitionImpl#getEventguard <em>Eventguard</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractTransitionImpl extends MinimalEObjectImpl.Container implements AbstractTransition {
	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected State to;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * The cached value of the '{@link #getEventguard() <em>Eventguard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventguard()
	 * @generated
	 * @ordered
	 */
	protected EventGuard eventguard;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ABSTRACT_TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getFrom() {
		if (eContainerFeatureID() != ModelPackage.ABSTRACT_TRANSITION__FROM) return null;
		return (State)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFrom(State newFrom, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFrom, ModelPackage.ABSTRACT_TRANSITION__FROM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(State newFrom) {
		if (newFrom != eInternalContainer() || (eContainerFeatureID() != ModelPackage.ABSTRACT_TRANSITION__FROM && newFrom != null)) {
			if (EcoreUtil.isAncestor(this, newFrom))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFrom != null)
				msgs = ((InternalEObject)newFrom).eInverseAdd(this, ModelPackage.STATE__OUTGOING_TRANSITIONS, State.class, msgs);
			msgs = basicSetFrom(newFrom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_TRANSITION__FROM, newFrom, newFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getTo() {
		if (to != null && to.eIsProxy()) {
			InternalEObject oldTo = (InternalEObject)to;
			to = (State)eResolveProxy(oldTo);
			if (to != oldTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ABSTRACT_TRANSITION__TO, oldTo, to));
			}
		}
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTo(State newTo, NotificationChain msgs) {
		State oldTo = to;
		to = newTo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_TRANSITION__TO, oldTo, newTo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(State newTo) {
		if (newTo != to) {
			NotificationChain msgs = null;
			if (to != null)
				msgs = ((InternalEObject)to).eInverseRemove(this, ModelPackage.STATE__INCOMING_TRANSITIONS, State.class, msgs);
			if (newTo != null)
				msgs = ((InternalEObject)newTo).eInverseAdd(this, ModelPackage.STATE__INCOMING_TRANSITIONS, State.class, msgs);
			msgs = basicSetTo(newTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_TRANSITION__TO, newTo, newTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<Action>(Action.class, this, ModelPackage.ABSTRACT_TRANSITION__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventGuard getEventguard() {
		return eventguard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventguard(EventGuard newEventguard, NotificationChain msgs) {
		EventGuard oldEventguard = eventguard;
		eventguard = newEventguard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_TRANSITION__EVENTGUARD, oldEventguard, newEventguard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventguard(EventGuard newEventguard) {
		if (newEventguard != eventguard) {
			NotificationChain msgs = null;
			if (eventguard != null)
				msgs = ((InternalEObject)eventguard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ABSTRACT_TRANSITION__EVENTGUARD, null, msgs);
			if (newEventguard != null)
				msgs = ((InternalEObject)newEventguard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ABSTRACT_TRANSITION__EVENTGUARD, null, msgs);
			msgs = basicSetEventguard(newEventguard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_TRANSITION__EVENTGUARD, newEventguard, newEventguard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ABSTRACT_TRANSITION__FROM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFrom((State)otherEnd, msgs);
			case ModelPackage.ABSTRACT_TRANSITION__TO:
				if (to != null)
					msgs = ((InternalEObject)to).eInverseRemove(this, ModelPackage.STATE__INCOMING_TRANSITIONS, State.class, msgs);
				return basicSetTo((State)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ABSTRACT_TRANSITION__FROM:
				return basicSetFrom(null, msgs);
			case ModelPackage.ABSTRACT_TRANSITION__TO:
				return basicSetTo(null, msgs);
			case ModelPackage.ABSTRACT_TRANSITION__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
			case ModelPackage.ABSTRACT_TRANSITION__EVENTGUARD:
				return basicSetEventguard(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ModelPackage.ABSTRACT_TRANSITION__FROM:
				return eInternalContainer().eInverseRemove(this, ModelPackage.STATE__OUTGOING_TRANSITIONS, State.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ABSTRACT_TRANSITION__FROM:
				return getFrom();
			case ModelPackage.ABSTRACT_TRANSITION__TO:
				if (resolve) return getTo();
				return basicGetTo();
			case ModelPackage.ABSTRACT_TRANSITION__ACTIONS:
				return getActions();
			case ModelPackage.ABSTRACT_TRANSITION__EVENTGUARD:
				return getEventguard();
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
			case ModelPackage.ABSTRACT_TRANSITION__FROM:
				setFrom((State)newValue);
				return;
			case ModelPackage.ABSTRACT_TRANSITION__TO:
				setTo((State)newValue);
				return;
			case ModelPackage.ABSTRACT_TRANSITION__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case ModelPackage.ABSTRACT_TRANSITION__EVENTGUARD:
				setEventguard((EventGuard)newValue);
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
			case ModelPackage.ABSTRACT_TRANSITION__FROM:
				setFrom((State)null);
				return;
			case ModelPackage.ABSTRACT_TRANSITION__TO:
				setTo((State)null);
				return;
			case ModelPackage.ABSTRACT_TRANSITION__ACTIONS:
				getActions().clear();
				return;
			case ModelPackage.ABSTRACT_TRANSITION__EVENTGUARD:
				setEventguard((EventGuard)null);
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
			case ModelPackage.ABSTRACT_TRANSITION__FROM:
				return getFrom() != null;
			case ModelPackage.ABSTRACT_TRANSITION__TO:
				return to != null;
			case ModelPackage.ABSTRACT_TRANSITION__ACTIONS:
				return actions != null && !actions.isEmpty();
			case ModelPackage.ABSTRACT_TRANSITION__EVENTGUARD:
				return eventguard != null;
		}
		return super.eIsSet(featureID);
	}

} //AbstractTransitionImpl
