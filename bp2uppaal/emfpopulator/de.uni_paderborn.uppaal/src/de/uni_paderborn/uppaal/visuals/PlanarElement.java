/**
 */
package de.uni_paderborn.uppaal.visuals;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Planar Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A planar model element that has an optional position.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.visuals.PlanarElement#getPosition <em>Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.visuals.VisualsPackage#getPlanarElement()
 * @model abstract="true"
 * @generated
 */
public interface PlanarElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The planar position of the model element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Position</em>' containment reference.
	 * @see #setPosition(Point)
	 * @see de.uni_paderborn.uppaal.visuals.VisualsPackage#getPlanarElement_Position()
	 * @model containment="true"
	 * @generated
	 */
	Point getPosition();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.visuals.PlanarElement#getPosition <em>Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' containment reference.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Point value);

} // PlanarElement
