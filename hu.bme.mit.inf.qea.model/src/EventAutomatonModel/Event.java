/**
 */
package EventAutomatonModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.Event#getType <em>Type</em>}</li>
 *   <li>{@link EventAutomatonModel.Event#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see EventAutomatonModel.EventAutomatonModelPackage#getEvent()
 * @model
 * @generated
 */
public interface Event extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(SymbolicEvent)
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getEvent_Type()
	 * @model required="true"
	 * @generated
	 */
	SymbolicEvent getType();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.Event#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(SymbolicEvent value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link EventAutomatonModel.FixParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getEvent_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<FixParameter> getParameters();

} // Event
