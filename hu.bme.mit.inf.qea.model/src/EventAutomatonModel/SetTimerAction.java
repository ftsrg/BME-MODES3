/**
 */
package EventAutomatonModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Timer Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.SetTimerAction#getToValue <em>To Value</em>}</li>
 * </ul>
 *
 * @see EventAutomatonModel.EventAutomatonModelPackage#getSetTimerAction()
 * @model
 * @generated
 */
public interface SetTimerAction extends TimerAction {
	/**
	 * Returns the value of the '<em><b>To Value</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Value</em>' attribute.
	 * @see #setToValue(int)
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getSetTimerAction_ToValue()
	 * @model default="100" required="true"
	 * @generated
	 */
	int getToValue();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.SetTimerAction#getToValue <em>To Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Value</em>' attribute.
	 * @see #getToValue()
	 * @generated
	 */
	void setToValue(int value);

} // SetTimerAction
