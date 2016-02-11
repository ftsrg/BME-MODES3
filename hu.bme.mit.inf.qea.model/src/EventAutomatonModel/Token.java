/**
 */
package EventAutomatonModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.Token#getOn <em>On</em>}</li>
 *   <li>{@link EventAutomatonModel.Token#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see EventAutomatonModel.EventAutomatonModelPackage#getToken()
 * @model
 * @generated
 */
public interface Token extends EObject {
	/**
	 * Returns the value of the '<em><b>On</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link EventAutomatonModel.State#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On</em>' container reference.
	 * @see #setOn(State)
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getToken_On()
	 * @see EventAutomatonModel.State#getTokens
	 * @model opposite="tokens" required="true" transient="false"
	 * @generated
	 */
	State getOn();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.Token#getOn <em>On</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On</em>' container reference.
	 * @see #getOn()
	 * @generated
	 */
	void setOn(State value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link EventAutomatonModel.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getToken_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

} // Token
