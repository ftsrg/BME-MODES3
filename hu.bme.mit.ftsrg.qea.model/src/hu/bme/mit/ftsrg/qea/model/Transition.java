/**
 */
package hu.bme.mit.ftsrg.qea.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.Transition#getEventguard <em>Eventguard</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends AbstractTransition {
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
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getTransition_Eventguard()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EventGuard getEventguard();

	/**
	 * Sets the value of the '{@link hu.bme.mit.ftsrg.qea.model.Transition#getEventguard <em>Eventguard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eventguard</em>' containment reference.
	 * @see #getEventguard()
	 * @generated
	 */
	void setEventguard(EventGuard value);

} // Transition
