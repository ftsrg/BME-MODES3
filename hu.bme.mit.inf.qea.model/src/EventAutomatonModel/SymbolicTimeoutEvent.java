/**
 */
package EventAutomatonModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbolic Timeout Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.SymbolicTimeoutEvent#getTimer <em>Timer</em>}</li>
 * </ul>
 *
 * @see EventAutomatonModel.EventAutomatonModelPackage#getSymbolicTimeoutEvent()
 * @model
 * @generated
 */
public interface SymbolicTimeoutEvent extends SymbolicEvent {
	/**
	 * Returns the value of the '<em><b>Timer</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link EventAutomatonModel.SymbolicTimer#getTimeoutEvent <em>Timeout Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timer</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timer</em>' container reference.
	 * @see #setTimer(SymbolicTimer)
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getSymbolicTimeoutEvent_Timer()
	 * @see EventAutomatonModel.SymbolicTimer#getTimeoutEvent
	 * @model opposite="timeoutEvent" required="true" transient="false"
	 * @generated
	 */
	SymbolicTimer getTimer();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.SymbolicTimeoutEvent#getTimer <em>Timer</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timer</em>' container reference.
	 * @see #getTimer()
	 * @generated
	 */
	void setTimer(SymbolicTimer value);

} // SymbolicTimeoutEvent
