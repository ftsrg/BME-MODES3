/**
 */
package EventAutomatonModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.Binding#getBinds <em>Binds</em>}</li>
 * </ul>
 *
 * @see EventAutomatonModel.EventAutomatonModelPackage#getBinding()
 * @model abstract="true"
 * @generated
 */
public interface Binding extends EObject {
	/**
	 * Returns the value of the '<em><b>Binds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binds</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binds</em>' reference.
	 * @see #setBinds(SymbolicEventParameter)
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getBinding_Binds()
	 * @model required="true"
	 * @generated
	 */
	SymbolicEventParameter getBinds();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.Binding#getBinds <em>Binds</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binds</em>' reference.
	 * @see #getBinds()
	 * @generated
	 */
	void setBinds(SymbolicEventParameter value);

} // Binding
