/**
 */
package hu.bme.mit.ftsrg.qea.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token Parameter Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.TokenParameterBinding#getBoundTo <em>Bound To</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getTokenParameterBinding()
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
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getTokenParameterBinding_BoundTo()
	 * @model required="true"
	 * @generated
	 */
	SymbolicTokenParameter getBoundTo();

	/**
	 * Sets the value of the '{@link hu.bme.mit.ftsrg.qea.model.TokenParameterBinding#getBoundTo <em>Bound To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound To</em>' reference.
	 * @see #getBoundTo()
	 * @generated
	 */
	void setBoundTo(SymbolicTokenParameter value);

} // TokenParameterBinding
