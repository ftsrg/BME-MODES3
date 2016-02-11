/**
 */
package EventAutomatonModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fix Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.FixParameter#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see EventAutomatonModel.EventAutomatonModelPackage#getFixParameter()
 * @model
 * @generated
 */
public interface FixParameter extends Parameter {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getFixParameter_Value()
	 * @model required="true"
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link EventAutomatonModel.FixParameter#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

} // FixParameter
