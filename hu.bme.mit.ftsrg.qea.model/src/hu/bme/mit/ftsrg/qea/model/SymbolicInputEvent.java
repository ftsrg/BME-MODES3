/**
 */
package hu.bme.mit.ftsrg.qea.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbolic Input Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.SymbolicInputEvent#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getSymbolicInputEvent()
 * @model
 * @generated
 */
public interface SymbolicInputEvent extends SymbolicEvent {
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
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getSymbolicInputEvent_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link hu.bme.mit.ftsrg.qea.model.SymbolicInputEvent#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // SymbolicInputEvent
