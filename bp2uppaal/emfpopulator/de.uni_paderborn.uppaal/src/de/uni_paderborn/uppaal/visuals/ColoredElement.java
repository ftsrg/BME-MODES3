/**
 */
package de.uni_paderborn.uppaal.visuals;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Colored Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A model element that has an optional color.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.visuals.ColoredElement#getColor <em>Color</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.visuals.ColoredElement#getColorCode <em>Color Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.visuals.VisualsPackage#getColoredElement()
 * @model abstract="true"
 * @generated
 */
public interface ColoredElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uni_paderborn.uppaal.visuals.ColorKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The color of the model element. It is either a standard uppaal color (default, white, light grey, dark grey, black, blue, cyan, green, magenta, orange, pink, red, yellow) or a self-defined color. Edges should not be white.
	 * 
	 * \todosd{We need an OCL-Constraint: Edges should not be white.}
	 * \todosd{We need an OCL-Constraint: If self defined is choosen then a color code must be specified.}
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see de.uni_paderborn.uppaal.visuals.ColorKind
	 * @see #setColor(ColorKind)
	 * @see de.uni_paderborn.uppaal.visuals.VisualsPackage#getColoredElement_Color()
	 * @model
	 * @generated
	 */
	ColorKind getColor();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.visuals.ColoredElement#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see de.uni_paderborn.uppaal.visuals.ColorKind
	 * @see #getColor()
	 * @generated
	 */
	void setColor(ColorKind value);

	/**
	 * Returns the value of the '<em><b>Color Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The hexadecimal color code of the model element that must be defined if a self-defined color should be used.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Color Code</em>' attribute.
	 * @see #setColorCode(String)
	 * @see de.uni_paderborn.uppaal.visuals.VisualsPackage#getColoredElement_ColorCode()
	 * @model
	 * @generated
	 */
	String getColorCode();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.visuals.ColoredElement#getColorCode <em>Color Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Code</em>' attribute.
	 * @see #getColorCode()
	 * @generated
	 */
	void setColorCode(String value);

} // ColoredElement
