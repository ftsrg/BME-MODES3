/**
 */
package EventAutomatonModel;

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
 *   <li>{@link EventAutomatonModel.State#getTokens <em>Tokens</em>}</li>
 *   <li>{@link EventAutomatonModel.State#isAcceptor <em>Acceptor</em>}</li>
 *   <li>{@link EventAutomatonModel.State#getId <em>Id</em>}</li>
 *   <li>{@link EventAutomatonModel.State#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link EventAutomatonModel.State#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 * </ul>
 *
 * @see EventAutomatonModel.EventAutomatonModelPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link EventAutomatonModel.AbstractTransition}.
	 * It is bidirectional and its opposite is '{@link EventAutomatonModel.AbstractTransition#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Transitions</em>' containment reference list.
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getState_OutgoingTransitions()
	 * @see EventAutomatonModel.AbstractTransition#getFrom
	 * @model opposite="from" containment="true"
	 * @generated
	 */
	EList<AbstractTransition> getOutgoingTransitions();

	/**
	 * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
	 * The list contents are of type {@link EventAutomatonModel.AbstractTransition}.
	 * It is bidirectional and its opposite is '{@link EventAutomatonModel.AbstractTransition#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Transitions</em>' reference list.
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getState_IncomingTransitions()
	 * @see EventAutomatonModel.AbstractTransition#getTo
	 * @model opposite="to"
	 * @generated
	 */
	EList<AbstractTransition> getIncomingTransitions();

	/**
	 * Returns the value of the '<em><b>Tokens</b></em>' containment reference list.
	 * The list contents are of type {@link EventAutomatonModel.Token}.
	 * It is bidirectional and its opposite is '{@link EventAutomatonModel.Token#getOn <em>On</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tokens</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens</em>' containment reference list.
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getState_Tokens()
	 * @see EventAutomatonModel.Token#getOn
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
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getState_Acceptor()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 * @generated
	 */
	boolean isAcceptor();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.State#isAcceptor <em>Acceptor</em>}' attribute.
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
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getState_Id()
	 * @model required="true"
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.State#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

} // State
