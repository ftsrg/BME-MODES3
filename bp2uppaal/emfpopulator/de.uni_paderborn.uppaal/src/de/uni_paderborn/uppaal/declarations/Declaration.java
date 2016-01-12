/**
 */
package de.uni_paderborn.uppaal.declarations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Abstract base class representing a variable, function, or type declaration.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.Declaration#getExp <em>Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface Declaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp</em>' attribute.
	 * @see #setExp(String)
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getDeclaration_Exp()
	 * @model
	 * @generated
	 */
	String getExp();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.declarations.Declaration#getExp <em>Exp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp</em>' attribute.
	 * @see #getExp()
	 * @generated
	 */
	void setExp(String value);

} // Declaration
