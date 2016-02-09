/**
 */
package EventAutomatonModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Free Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EventAutomatonModel.FreeParameter#getExcludedValues <em>Excluded Values</em>}</li>
 * </ul>
 *
 * @see EventAutomatonModel.EventAutomatonModelPackage#getFreeParameter()
 * @model
 * @generated
 */
public interface FreeParameter extends Parameter {
	/**
	 * Returns the value of the '<em><b>Excluded Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluded Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excluded Values</em>' attribute list.
	 * @see EventAutomatonModel.EventAutomatonModelPackage#getFreeParameter_ExcludedValues()
	 * @model
	 * @generated
	 */
	EList<Object> getExcludedValues();

} // FreeParameter
