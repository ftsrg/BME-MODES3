/**
 */
package hu.bme.mit.ftsrg.qea.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.AbstractTransition#getFrom <em>From</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.AbstractTransition#getTo <em>To</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.AbstractTransition#getActions <em>Actions</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.AbstractTransition#getEventguard <em>Eventguard</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getAbstractTransition()
 * @model abstract="true"
 * @generated
 */
public interface AbstractTransition extends EObject {
	/**
	 * Returns the value of the '<em><b>From</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.ftsrg.qea.model.State#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' container reference.
	 * @see #setFrom(State)
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getAbstractTransition_From()
	 * @see hu.bme.mit.ftsrg.qea.model.State#getOutgoingTransitions
	 * @model opposite="outgoingTransitions" required="true" transient="false"
	 * @generated
	 */
	State getFrom();

	/**
	 * Sets the value of the '{@link hu.bme.mit.ftsrg.qea.model.AbstractTransition#getFrom <em>From</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' container reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(State value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.ftsrg.qea.model.State#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(State)
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getAbstractTransition_To()
	 * @see hu.bme.mit.ftsrg.qea.model.State#getIncomingTransitions
	 * @model opposite="incomingTransitions" required="true"
	 * @generated
	 */
	State getTo();

	/**
	 * Sets the value of the '{@link hu.bme.mit.ftsrg.qea.model.AbstractTransition#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(State value);

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.ftsrg.qea.model.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getAbstractTransition_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getActions();

	/**
	 * Returns the value of the '<em><b>Eventguard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eventguard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eventguard</em>' containment reference.
	 * @see #setEventguard(EventGuard)
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getAbstractTransition_Eventguard()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EventGuard getEventguard();

	/**
	 * Sets the value of the '{@link hu.bme.mit.ftsrg.qea.model.AbstractTransition#getEventguard <em>Eventguard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eventguard</em>' containment reference.
	 * @see #getEventguard()
	 * @generated
	 */
	void setEventguard(EventGuard value);

} // AbstractTransition
