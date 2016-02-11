/**
 */
package EventAutomatonModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token Parameter Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.TokenParameterBinding#getBoundTo <em>Bound To</em>}</li>
 * </ul>
 *
 * @see EventAutomatonModel.EventAutomatonModelPackage#getTokenParameterBinding()
 * @model
 * @generated
 */
public interface TokenParameterBinding extends Binding {
	/**
	 * Returns the value of the '<em><b>Bound To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound To</em>' reference.
	 * @see #setBoundTo(SymbolicTokenParameter)
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getTokenParameterBinding_BoundTo()
	 * @model required="true"
	 * @generated
	 */
	SymbolicTokenParameter getBoundTo();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.TokenParameterBinding#getBoundTo <em>Bound To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound To</em>' reference.
	 * @see #getBoundTo()
	 * @generated
	 */
	void setBoundTo(SymbolicTokenParameter value);

} // TokenParameterBinding
