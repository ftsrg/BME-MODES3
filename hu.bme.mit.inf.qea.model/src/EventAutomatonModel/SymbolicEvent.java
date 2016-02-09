/**
 */
package EventAutomatonModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbolic Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.SymbolicEvent#getSymbolicParameters <em>Symbolic Parameters</em>}</li>
 * </ul>
 *
 * @see EventAutomatonModel.EventAutomatonModelPackage#getSymbolicEvent()
 * @model abstract="true"
 * @generated
 */
public interface SymbolicEvent extends EObject {
	/**
	 * Returns the value of the '<em><b>Symbolic Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link EventAutomatonModel.SymbolicParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbolic Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbolic Parameters</em>' containment reference list.
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getSymbolicEvent_SymbolicParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<SymbolicParameter> getSymbolicParameters();

} // SymbolicEvent
