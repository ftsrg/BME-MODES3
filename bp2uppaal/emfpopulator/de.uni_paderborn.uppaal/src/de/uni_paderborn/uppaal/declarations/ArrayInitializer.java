/**
 */
package de.uni_paderborn.uppaal.declarations;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Initializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An initializer for array variables, referring to multiple sub-initializers.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.ArrayInitializer#getInitializer <em>Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getArrayInitializer()
 * @model
 * @generated
 */
public interface ArrayInitializer extends Initializer {
	/**
	 * Returns the value of the '<em><b>Initializer</b></em>' containment reference list.
	 * The list contents are of type {@link de.uni_paderborn.uppaal.declarations.Initializer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A number of sub-initializers, each one representing the initial value for one array index.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Initializer</em>' containment reference list.
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getArrayInitializer_Initializer()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Initializer> getInitializer();

} // ArrayInitializer
