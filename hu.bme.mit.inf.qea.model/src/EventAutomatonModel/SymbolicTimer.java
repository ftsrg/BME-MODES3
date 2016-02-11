/**
 */
package EventAutomatonModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbolic Timer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.SymbolicTimer#getTimeoutEvent <em>Timeout Event</em>}</li>
 *   <li>{@link EventAutomatonModel.SymbolicTimer#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see EventAutomatonModel.EventAutomatonModelPackage#getSymbolicTimer()
 * @model
 * @generated
 */
public interface SymbolicTimer extends EObject {
	/**
	 * Returns the value of the '<em><b>Timeout Event</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link EventAutomatonModel.SymbolicTimeoutEvent#getTimer <em>Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeout Event</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout Event</em>' containment reference.
	 * @see #setTimeoutEvent(SymbolicTimeoutEvent)
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getSymbolicTimer_TimeoutEvent()
	 * @see EventAutomatonModel.SymbolicTimeoutEvent#getTimer
	 * @model opposite="timer" containment="true" required="true"
	 * @generated
	 */
	SymbolicTimeoutEvent getTimeoutEvent();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.SymbolicTimer#getTimeoutEvent <em>Timeout Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout Event</em>' containment reference.
	 * @see #getTimeoutEvent()
	 * @generated
	 */
	void setTimeoutEvent(SymbolicTimeoutEvent value);

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
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getSymbolicTimer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.SymbolicTimer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // SymbolicTimer
