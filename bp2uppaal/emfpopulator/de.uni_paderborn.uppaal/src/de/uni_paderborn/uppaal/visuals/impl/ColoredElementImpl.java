/**
 */
package de.uni_paderborn.uppaal.visuals.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import de.uni_paderborn.uppaal.visuals.ColorKind;
import de.uni_paderborn.uppaal.visuals.ColoredElement;
import de.uni_paderborn.uppaal.visuals.VisualsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Colored Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.visuals.impl.ColoredElementImpl#getColor <em>Color</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.visuals.impl.ColoredElementImpl#getColorCode <em>Color Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ColoredElementImpl extends MinimalEObjectImpl.Container implements ColoredElement {
	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final ColorKind COLOR_EDEFAULT = ColorKind.DEFAULT;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected ColorKind color = COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getColorCode() <em>Color Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorCode()
	 * @generated
	 * @ordered
	 */
	protected static final String COLOR_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColorCode() <em>Color Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorCode()
	 * @generated
	 * @ordered
	 */
	protected String colorCode = COLOR_CODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColoredElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VisualsPackage.Literals.COLORED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorKind getColor() {
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor(ColorKind newColor) {
		ColorKind oldColor = color;
		color = newColor == null ? COLOR_EDEFAULT : newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualsPackage.COLORED_ELEMENT__COLOR, oldColor, color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColorCode() {
		return colorCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColorCode(String newColorCode) {
		String oldColorCode = colorCode;
		colorCode = newColorCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualsPackage.COLORED_ELEMENT__COLOR_CODE, oldColorCode, colorCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VisualsPackage.COLORED_ELEMENT__COLOR:
				return getColor();
			case VisualsPackage.COLORED_ELEMENT__COLOR_CODE:
				return getColorCode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VisualsPackage.COLORED_ELEMENT__COLOR:
				setColor((ColorKind)newValue);
				return;
			case VisualsPackage.COLORED_ELEMENT__COLOR_CODE:
				setColorCode((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VisualsPackage.COLORED_ELEMENT__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case VisualsPackage.COLORED_ELEMENT__COLOR_CODE:
				setColorCode(COLOR_CODE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VisualsPackage.COLORED_ELEMENT__COLOR:
				return color != COLOR_EDEFAULT;
			case VisualsPackage.COLORED_ELEMENT__COLOR_CODE:
				return COLOR_CODE_EDEFAULT == null ? colorCode != null : !COLOR_CODE_EDEFAULT.equals(colorCode);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (color: ");
		result.append(color);
		result.append(", colorCode: ");
		result.append(colorCode);
		result.append(')');
		return result.toString();
	}

} //ColoredElementImpl
