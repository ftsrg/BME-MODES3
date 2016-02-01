/**
 */
package hu.bme.mit.kv.model.railroadmodel.impl;

import hu.bme.mit.kv.model.railroadmodel.ModelPackage;
import hu.bme.mit.kv.model.railroadmodel.Rectangle;
import hu.bme.mit.kv.model.railroadmodel.Section;
import hu.bme.mit.kv.model.railroadmodel.Turnout;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Turnout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.kv.model.railroadmodel.impl.TurnoutImpl#getNotConnectedSection <em>Not Connected Section</em>}</li>
 *   <li>{@link hu.bme.mit.kv.model.railroadmodel.impl.TurnoutImpl#isTwoSectionsInClockwiseDirection <em>Two Sections In Clockwise Direction</em>}</li>
 *   <li>{@link hu.bme.mit.kv.model.railroadmodel.impl.TurnoutImpl#getRectangle <em>Rectangle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TurnoutImpl extends SectionImpl implements Turnout {
	/**
	 * The cached value of the '{@link #getNotConnectedSection() <em>Not Connected Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotConnectedSection()
	 * @generated
	 * @ordered
	 */
	protected Section notConnectedSection;

	/**
	 * The default value of the '{@link #isTwoSectionsInClockwiseDirection() <em>Two Sections In Clockwise Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTwoSectionsInClockwiseDirection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TWO_SECTIONS_IN_CLOCKWISE_DIRECTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTwoSectionsInClockwiseDirection() <em>Two Sections In Clockwise Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTwoSectionsInClockwiseDirection()
	 * @generated
	 * @ordered
	 */
	protected boolean twoSectionsInClockwiseDirection = TWO_SECTIONS_IN_CLOCKWISE_DIRECTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRectangle() <em>Rectangle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRectangle()
	 * @generated
	 * @ordered
	 */
	protected Rectangle rectangle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TurnoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.TURNOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section getNotConnectedSection() {
		if (notConnectedSection != null && notConnectedSection.eIsProxy()) {
			InternalEObject oldNotConnectedSection = (InternalEObject)notConnectedSection;
			notConnectedSection = (Section)eResolveProxy(oldNotConnectedSection);
			if (notConnectedSection != oldNotConnectedSection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.TURNOUT__NOT_CONNECTED_SECTION, oldNotConnectedSection, notConnectedSection));
			}
		}
		return notConnectedSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section basicGetNotConnectedSection() {
		return notConnectedSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotConnectedSection(Section newNotConnectedSection) {
		Section oldNotConnectedSection = notConnectedSection;
		notConnectedSection = newNotConnectedSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TURNOUT__NOT_CONNECTED_SECTION, oldNotConnectedSection, notConnectedSection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTwoSectionsInClockwiseDirection() {
		return twoSectionsInClockwiseDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTwoSectionsInClockwiseDirection(boolean newTwoSectionsInClockwiseDirection) {
		boolean oldTwoSectionsInClockwiseDirection = twoSectionsInClockwiseDirection;
		twoSectionsInClockwiseDirection = newTwoSectionsInClockwiseDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TURNOUT__TWO_SECTIONS_IN_CLOCKWISE_DIRECTION, oldTwoSectionsInClockwiseDirection, twoSectionsInClockwiseDirection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rectangle getRectangle() {
		return rectangle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRectangle(Rectangle newRectangle, NotificationChain msgs) {
		Rectangle oldRectangle = rectangle;
		rectangle = newRectangle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.TURNOUT__RECTANGLE, oldRectangle, newRectangle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRectangle(Rectangle newRectangle) {
		if (newRectangle != rectangle) {
			NotificationChain msgs = null;
			if (rectangle != null)
				msgs = ((InternalEObject)rectangle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.TURNOUT__RECTANGLE, null, msgs);
			if (newRectangle != null)
				msgs = ((InternalEObject)newRectangle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.TURNOUT__RECTANGLE, null, msgs);
			msgs = basicSetRectangle(newRectangle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TURNOUT__RECTANGLE, newRectangle, newRectangle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.TURNOUT__RECTANGLE:
				return basicSetRectangle(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.TURNOUT__NOT_CONNECTED_SECTION:
				if (resolve) return getNotConnectedSection();
				return basicGetNotConnectedSection();
			case ModelPackage.TURNOUT__TWO_SECTIONS_IN_CLOCKWISE_DIRECTION:
				return isTwoSectionsInClockwiseDirection();
			case ModelPackage.TURNOUT__RECTANGLE:
				return getRectangle();
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
			case ModelPackage.TURNOUT__NOT_CONNECTED_SECTION:
				setNotConnectedSection((Section)newValue);
				return;
			case ModelPackage.TURNOUT__TWO_SECTIONS_IN_CLOCKWISE_DIRECTION:
				setTwoSectionsInClockwiseDirection((Boolean)newValue);
				return;
			case ModelPackage.TURNOUT__RECTANGLE:
				setRectangle((Rectangle)newValue);
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
			case ModelPackage.TURNOUT__NOT_CONNECTED_SECTION:
				setNotConnectedSection((Section)null);
				return;
			case ModelPackage.TURNOUT__TWO_SECTIONS_IN_CLOCKWISE_DIRECTION:
				setTwoSectionsInClockwiseDirection(TWO_SECTIONS_IN_CLOCKWISE_DIRECTION_EDEFAULT);
				return;
			case ModelPackage.TURNOUT__RECTANGLE:
				setRectangle((Rectangle)null);
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
			case ModelPackage.TURNOUT__NOT_CONNECTED_SECTION:
				return notConnectedSection != null;
			case ModelPackage.TURNOUT__TWO_SECTIONS_IN_CLOCKWISE_DIRECTION:
				return twoSectionsInClockwiseDirection != TWO_SECTIONS_IN_CLOCKWISE_DIRECTION_EDEFAULT;
			case ModelPackage.TURNOUT__RECTANGLE:
				return rectangle != null;
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
		result.append(" (twoSectionsInClockwiseDirection: ");
		result.append(twoSectionsInClockwiseDirection);
		result.append(')');
		return result.toString();
	}

} //TurnoutImpl
