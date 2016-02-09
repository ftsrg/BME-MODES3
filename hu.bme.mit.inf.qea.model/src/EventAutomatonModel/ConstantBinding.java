/**
 */
package EventAutomatonModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.ConstantBinding#getBoundTo <em>Bound To</em>}</li>
 * </ul>
 *
 * @see EventAutomatonModel.EventAutomatonModelPackage#getConstantBinding()
 * @model
 * @generated
 */
public interface ConstantBinding extends Binding {
	/**
	 * Returns the value of the '<em><b>Bound To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound To</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound To</em>' containment reference.
	 * @see #setBoundTo(FixParameter)
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getConstantBinding_BoundTo()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FixParameter getBoundTo();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.ConstantBinding#getBoundTo <em>Bound To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound To</em>' containment reference.
	 * @see #getBoundTo()
	 * @generated
	 */
	void setBoundTo(FixParameter value);

} // ConstantBinding
