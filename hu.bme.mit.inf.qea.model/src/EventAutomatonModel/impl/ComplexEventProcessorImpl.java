/**
 */
package EventAutomatonModel.impl;

import EventAutomatonModel.Automaton;
import EventAutomatonModel.ComplexEventProcessor;
import EventAutomatonModel.EventAutomatonModelPackage;
import EventAutomatonModel.SymbolicInputEvent;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Event Processor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.impl.ComplexEventProcessorImpl#getAutomata <em>Automata</em>}</li>
 *   <li>{@link EventAutomatonModel.impl.ComplexEventProcessorImpl#getSymbolicEvents <em>Symbolic Events</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexEventProcessorImpl extends MinimalEObjectImpl.Container implements ComplexEventProcessor {
	/**
	 * The cached value of the '{@link #getAutomata() <em>Automata</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutomata()
	 * @generated
	 * @ordered
	 */
	protected EList<Automaton> automata;

	/**
	 * The cached value of the '{@link #getSymbolicEvents() <em>Symbolic Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbolicEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<SymbolicInputEvent> symbolicEvents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexEventProcessorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventAutomatonModelPackage.Literals.COMPLEX_EVENT_PROCESSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Automaton> getAutomata() {
		if (automata == null) {
			automata = new EObjectContainmentEList<Automaton>(Automaton.class, this, EventAutomatonModelPackage.COMPLEX_EVENT_PROCESSOR__AUTOMATA);
		}
		return automata;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SymbolicInputEvent> getSymbolicEvents() {
		if (symbolicEvents == null) {
			symbolicEvents = new EObjectContainmentEList<SymbolicInputEvent>(SymbolicInputEvent.class, this, EventAutomatonModelPackage.COMPLEX_EVENT_PROCESSOR__SYMBOLIC_EVENTS);
		}
		return symbolicEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventAutomatonModelPackage.COMPLEX_EVENT_PROCESSOR__AUTOMATA:
				return ((InternalEList<?>)getAutomata()).basicRemove(otherEnd, msgs);
			case EventAutomatonModelPackage.COMPLEX_EVENT_PROCESSOR__SYMBOLIC_EVENTS:
				return ((InternalEList<?>)getSymbolicEvents()).basicRemove(otherEnd, msgs);
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
			case EventAutomatonModelPackage.COMPLEX_EVENT_PROCESSOR__AUTOMATA:
				return getAutomata();
			case EventAutomatonModelPackage.COMPLEX_EVENT_PROCESSOR__SYMBOLIC_EVENTS:
				return getSymbolicEvents();
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
			case EventAutomatonModelPackage.COMPLEX_EVENT_PROCESSOR__AUTOMATA:
				getAutomata().clear();
				getAutomata().addAll((Collection<? extends Automaton>)newValue);
				return;
			case EventAutomatonModelPackage.COMPLEX_EVENT_PROCESSOR__SYMBOLIC_EVENTS:
				getSymbolicEvents().clear();
				getSymbolicEvents().addAll((Collection<? extends SymbolicInputEvent>)newValue);
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
			case EventAutomatonModelPackage.COMPLEX_EVENT_PROCESSOR__AUTOMATA:
				getAutomata().clear();
				return;
			case EventAutomatonModelPackage.COMPLEX_EVENT_PROCESSOR__SYMBOLIC_EVENTS:
				getSymbolicEvents().clear();
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
			case EventAutomatonModelPackage.COMPLEX_EVENT_PROCESSOR__AUTOMATA:
				return automata != null && !automata.isEmpty();
			case EventAutomatonModelPackage.COMPLEX_EVENT_PROCESSOR__SYMBOLIC_EVENTS:
				return symbolicEvents != null && !symbolicEvents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComplexEventProcessorImpl
