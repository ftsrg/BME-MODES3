/**
 */
package de.uni_paderborn.uppaal.visuals;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents a point in the two-dimensional space.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.visuals.Point#getX <em>X</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.visuals.Point#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.visuals.VisualsPackage#getPoint()
 * @model
 * @generated
 */
public interface Point extends EObject {
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The horizontal component of the point.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see de.uni_paderborn.uppaal.visuals.VisualsPackage#getPoint_X()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.visuals.Point#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The vertical component of the point.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see de.uni_paderborn.uppaal.visuals.VisualsPackage#getPoint_Y()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.visuals.Point#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

} // Point
