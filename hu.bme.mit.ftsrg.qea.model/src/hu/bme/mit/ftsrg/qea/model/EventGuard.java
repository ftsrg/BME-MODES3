/**
 */
package hu.bme.mit.ftsrg.qea.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.EventGuard#getBindings <em>Bindings</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.EventGuard#getType <em>Type</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.EventGuard#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getEventGuard()
 * @model
 * @generated
 */
public interface EventGuard extends EObject {
	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.ftsrg.qea.model.Binding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getEventGuard_Bindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<Binding> getBindings();

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
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getEventGuard_Type()
	 * @model
	 * @generated
	 */
	SymbolicEvent getType();

	/**
	 * Sets the value of the '{@link hu.bme.mit.ftsrg.qea.model.EventGuard#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(SymbolicEvent value);

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
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getEventGuard_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getActions();

} // EventGuard
