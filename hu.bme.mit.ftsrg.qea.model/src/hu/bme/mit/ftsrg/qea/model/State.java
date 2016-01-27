/**
 */
package hu.bme.mit.ftsrg.qea.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.State#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.State#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.State#getTokens <em>Tokens</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.State#isAcceptor <em>Acceptor</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.State#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.ftsrg.qea.model.AbstractTransition}.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.ftsrg.qea.model.AbstractTransition#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Transitions</em>' containment reference list.
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getState_OutgoingTransitions()
	 * @see hu.bme.mit.ftsrg.qea.model.AbstractTransition#getFrom
	 * @model opposite="from" containment="true"
	 * @generated
	 */
	EList<AbstractTransition> getOutgoingTransitions();

	/**
	 * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
	 * The list contents are of type {@link hu.bme.mit.ftsrg.qea.model.AbstractTransition}.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.ftsrg.qea.model.AbstractTransition#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Transitions</em>' reference list.
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getState_IncomingTransitions()
	 * @see hu.bme.mit.ftsrg.qea.model.AbstractTransition#getTo
	 * @model opposite="to"
	 * @generated
	 */
	EList<AbstractTransition> getIncomingTransitions();

	/**
	 * Returns the value of the '<em><b>Tokens</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.ftsrg.qea.model.Token}.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.ftsrg.qea.model.Token#getOn <em>On</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tokens</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens</em>' containment reference list.
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getState_Tokens()
	 * @see hu.bme.mit.ftsrg.qea.model.Token#getOn
	 * @model opposite="on" containment="true"
	 * @generated
	 */
	EList<Token> getTokens();

	/**
	 * Returns the value of the '<em><b>Acceptor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Acceptor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acceptor</em>' attribute.
	 * @see #setAcceptor(boolean)
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getState_Acceptor()
	 * @model required="true"
	 * @generated
	 */
	boolean isAcceptor();

	/**
	 * Sets the value of the '{@link hu.bme.mit.ftsrg.qea.model.State#isAcceptor <em>Acceptor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acceptor</em>' attribute.
	 * @see #isAcceptor()
	 * @generated
	 */
	void setAcceptor(boolean value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getState_Id()
	 * @model required="true"
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link hu.bme.mit.ftsrg.qea.model.State#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

} // State
