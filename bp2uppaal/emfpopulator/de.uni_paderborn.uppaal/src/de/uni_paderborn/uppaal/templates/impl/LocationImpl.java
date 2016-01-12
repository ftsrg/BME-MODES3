/**
 */
package de.uni_paderborn.uppaal.templates.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uni_paderborn.uppaal.core.CommentableElement;
import de.uni_paderborn.uppaal.core.CorePackage;
import de.uni_paderborn.uppaal.core.impl.NamedElementImpl;
import de.uni_paderborn.uppaal.expressions.Expression;
import de.uni_paderborn.uppaal.templates.Location;
import de.uni_paderborn.uppaal.templates.LocationKind;
import de.uni_paderborn.uppaal.templates.Template;
import de.uni_paderborn.uppaal.templates.TemplatesPackage;
import de.uni_paderborn.uppaal.visuals.ColorKind;
import de.uni_paderborn.uppaal.visuals.ColoredElement;
import de.uni_paderborn.uppaal.visuals.PlanarElement;
import de.uni_paderborn.uppaal.visuals.Point;
import de.uni_paderborn.uppaal.visuals.VisualsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.LocationImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.LocationImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.LocationImpl#getColor <em>Color</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.LocationImpl#getColorCode <em>Color Code</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.LocationImpl#getParentTemplate <em>Parent Template</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.LocationImpl#getInvariant <em>Invariant</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.LocationImpl#getLocationTimeKind <em>Location Time Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocationImpl extends NamedElementImpl implements Location {
	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected Point position;

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
	 * The cached value of the '{@link #getInvariant() <em>Invariant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvariant()
	 * @generated
	 * @ordered
	 */
	protected Expression invariant;

	/**
	 * The default value of the '{@link #getLocationTimeKind() <em>Location Time Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocationTimeKind()
	 * @generated
	 * @ordered
	 */
	protected static final LocationKind LOCATION_TIME_KIND_EDEFAULT = LocationKind.NORMAL;

	/**
	 * The cached value of the '{@link #getLocationTimeKind() <em>Location Time Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocationTimeKind()
	 * @generated
	 * @ordered
	 */
	protected LocationKind locationTimeKind = LOCATION_TIME_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatesPackage.Literals.LOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.LOCATION__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPosition(Point newPosition, NotificationChain msgs) {
		Point oldPosition = position;
		position = newPosition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatesPackage.LOCATION__POSITION, oldPosition, newPosition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(Point newPosition) {
		if (newPosition != position) {
			NotificationChain msgs = null;
			if (position != null)
				msgs = ((InternalEObject)position).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatesPackage.LOCATION__POSITION, null, msgs);
			if (newPosition != null)
				msgs = ((InternalEObject)newPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatesPackage.LOCATION__POSITION, null, msgs);
			msgs = basicSetPosition(newPosition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.LOCATION__POSITION, newPosition, newPosition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.LOCATION__COLOR, oldColor, color));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.LOCATION__COLOR_CODE, oldColorCode, colorCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template getParentTemplate() {
		if (eContainerFeatureID() != TemplatesPackage.LOCATION__PARENT_TEMPLATE) return null;
		return (Template)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentTemplate(Template newParentTemplate, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentTemplate, TemplatesPackage.LOCATION__PARENT_TEMPLATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentTemplate(Template newParentTemplate) {
		if (newParentTemplate != eInternalContainer() || (eContainerFeatureID() != TemplatesPackage.LOCATION__PARENT_TEMPLATE && newParentTemplate != null)) {
			if (EcoreUtil.isAncestor(this, newParentTemplate))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentTemplate != null)
				msgs = ((InternalEObject)newParentTemplate).eInverseAdd(this, TemplatesPackage.TEMPLATE__LOCATION, Template.class, msgs);
			msgs = basicSetParentTemplate(newParentTemplate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.LOCATION__PARENT_TEMPLATE, newParentTemplate, newParentTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getInvariant() {
		return invariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvariant(Expression newInvariant, NotificationChain msgs) {
		Expression oldInvariant = invariant;
		invariant = newInvariant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatesPackage.LOCATION__INVARIANT, oldInvariant, newInvariant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvariant(Expression newInvariant) {
		if (newInvariant != invariant) {
			NotificationChain msgs = null;
			if (invariant != null)
				msgs = ((InternalEObject)invariant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatesPackage.LOCATION__INVARIANT, null, msgs);
			if (newInvariant != null)
				msgs = ((InternalEObject)newInvariant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatesPackage.LOCATION__INVARIANT, null, msgs);
			msgs = basicSetInvariant(newInvariant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.LOCATION__INVARIANT, newInvariant, newInvariant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationKind getLocationTimeKind() {
		return locationTimeKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocationTimeKind(LocationKind newLocationTimeKind) {
		LocationKind oldLocationTimeKind = locationTimeKind;
		locationTimeKind = newLocationTimeKind == null ? LOCATION_TIME_KIND_EDEFAULT : newLocationTimeKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.LOCATION__LOCATION_TIME_KIND, oldLocationTimeKind, locationTimeKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatesPackage.LOCATION__PARENT_TEMPLATE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentTemplate((Template)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatesPackage.LOCATION__POSITION:
				return basicSetPosition(null, msgs);
			case TemplatesPackage.LOCATION__PARENT_TEMPLATE:
				return basicSetParentTemplate(null, msgs);
			case TemplatesPackage.LOCATION__INVARIANT:
				return basicSetInvariant(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TemplatesPackage.LOCATION__PARENT_TEMPLATE:
				return eInternalContainer().eInverseRemove(this, TemplatesPackage.TEMPLATE__LOCATION, Template.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TemplatesPackage.LOCATION__COMMENT:
				return getComment();
			case TemplatesPackage.LOCATION__POSITION:
				return getPosition();
			case TemplatesPackage.LOCATION__COLOR:
				return getColor();
			case TemplatesPackage.LOCATION__COLOR_CODE:
				return getColorCode();
			case TemplatesPackage.LOCATION__PARENT_TEMPLATE:
				return getParentTemplate();
			case TemplatesPackage.LOCATION__INVARIANT:
				return getInvariant();
			case TemplatesPackage.LOCATION__LOCATION_TIME_KIND:
				return getLocationTimeKind();
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
			case TemplatesPackage.LOCATION__COMMENT:
				setComment((String)newValue);
				return;
			case TemplatesPackage.LOCATION__POSITION:
				setPosition((Point)newValue);
				return;
			case TemplatesPackage.LOCATION__COLOR:
				setColor((ColorKind)newValue);
				return;
			case TemplatesPackage.LOCATION__COLOR_CODE:
				setColorCode((String)newValue);
				return;
			case TemplatesPackage.LOCATION__PARENT_TEMPLATE:
				setParentTemplate((Template)newValue);
				return;
			case TemplatesPackage.LOCATION__INVARIANT:
				setInvariant((Expression)newValue);
				return;
			case TemplatesPackage.LOCATION__LOCATION_TIME_KIND:
				setLocationTimeKind((LocationKind)newValue);
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
			case TemplatesPackage.LOCATION__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case TemplatesPackage.LOCATION__POSITION:
				setPosition((Point)null);
				return;
			case TemplatesPackage.LOCATION__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case TemplatesPackage.LOCATION__COLOR_CODE:
				setColorCode(COLOR_CODE_EDEFAULT);
				return;
			case TemplatesPackage.LOCATION__PARENT_TEMPLATE:
				setParentTemplate((Template)null);
				return;
			case TemplatesPackage.LOCATION__INVARIANT:
				setInvariant((Expression)null);
				return;
			case TemplatesPackage.LOCATION__LOCATION_TIME_KIND:
				setLocationTimeKind(LOCATION_TIME_KIND_EDEFAULT);
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
			case TemplatesPackage.LOCATION__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case TemplatesPackage.LOCATION__POSITION:
				return position != null;
			case TemplatesPackage.LOCATION__COLOR:
				return color != COLOR_EDEFAULT;
			case TemplatesPackage.LOCATION__COLOR_CODE:
				return COLOR_CODE_EDEFAULT == null ? colorCode != null : !COLOR_CODE_EDEFAULT.equals(colorCode);
			case TemplatesPackage.LOCATION__PARENT_TEMPLATE:
				return getParentTemplate() != null;
			case TemplatesPackage.LOCATION__INVARIANT:
				return invariant != null;
			case TemplatesPackage.LOCATION__LOCATION_TIME_KIND:
				return locationTimeKind != LOCATION_TIME_KIND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == CommentableElement.class) {
			switch (derivedFeatureID) {
				case TemplatesPackage.LOCATION__COMMENT: return CorePackage.COMMENTABLE_ELEMENT__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == PlanarElement.class) {
			switch (derivedFeatureID) {
				case TemplatesPackage.LOCATION__POSITION: return VisualsPackage.PLANAR_ELEMENT__POSITION;
				default: return -1;
			}
		}
		if (baseClass == ColoredElement.class) {
			switch (derivedFeatureID) {
				case TemplatesPackage.LOCATION__COLOR: return VisualsPackage.COLORED_ELEMENT__COLOR;
				case TemplatesPackage.LOCATION__COLOR_CODE: return VisualsPackage.COLORED_ELEMENT__COLOR_CODE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == CommentableElement.class) {
			switch (baseFeatureID) {
				case CorePackage.COMMENTABLE_ELEMENT__COMMENT: return TemplatesPackage.LOCATION__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == PlanarElement.class) {
			switch (baseFeatureID) {
				case VisualsPackage.PLANAR_ELEMENT__POSITION: return TemplatesPackage.LOCATION__POSITION;
				default: return -1;
			}
		}
		if (baseClass == ColoredElement.class) {
			switch (baseFeatureID) {
				case VisualsPackage.COLORED_ELEMENT__COLOR: return TemplatesPackage.LOCATION__COLOR;
				case VisualsPackage.COLORED_ELEMENT__COLOR_CODE: return TemplatesPackage.LOCATION__COLOR_CODE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (comment: ");
		result.append(comment);
		result.append(", color: ");
		result.append(color);
		result.append(", colorCode: ");
		result.append(colorCode);
		result.append(", locationTimeKind: ");
		result.append(locationTimeKind);
		result.append(')');
		return result.toString();
	}

} //LocationImpl
