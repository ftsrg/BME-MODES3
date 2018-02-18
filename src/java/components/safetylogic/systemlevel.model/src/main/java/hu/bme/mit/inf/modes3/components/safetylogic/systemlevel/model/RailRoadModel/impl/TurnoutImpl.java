/**
 */
package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModelPackage;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Rectangle;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout;

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
 *   <li>{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.TurnoutImpl#getRectangle <em>Rectangle</em>}</li>
 *   <li>{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.TurnoutImpl#getTop <em>Top</em>}</li>
 *   <li>{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.TurnoutImpl#getStraight <em>Straight</em>}</li>
 *   <li>{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.TurnoutImpl#getDivergent <em>Divergent</em>}</li>
 *   <li>{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.TurnoutImpl#isCurrentlyDivergent <em>Currently Divergent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TurnoutImpl extends RailRoadElementImpl implements Turnout {
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
	 * The cached value of the '{@link #getTop() <em>Top</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTop()
	 * @generated
	 * @ordered
	 */
	protected RailRoadElement top;

	/**
	 * The cached value of the '{@link #getStraight() <em>Straight</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStraight()
	 * @generated
	 * @ordered
	 */
	protected RailRoadElement straight;

	/**
	 * The cached value of the '{@link #getDivergent() <em>Divergent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDivergent()
	 * @generated
	 * @ordered
	 */
	protected RailRoadElement divergent;

	/**
	 * The default value of the '{@link #isCurrentlyDivergent() <em>Currently Divergent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCurrentlyDivergent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CURRENTLY_DIVERGENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCurrentlyDivergent() <em>Currently Divergent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCurrentlyDivergent()
	 * @generated
	 * @ordered
	 */
	protected boolean currentlyDivergent = CURRENTLY_DIVERGENT_EDEFAULT;

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
		return RailRoadModelPackage.Literals.TURNOUT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RailRoadModelPackage.TURNOUT__RECTANGLE, oldRectangle, newRectangle);
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
				msgs = ((InternalEObject)rectangle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RailRoadModelPackage.TURNOUT__RECTANGLE, null, msgs);
			if (newRectangle != null)
				msgs = ((InternalEObject)newRectangle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RailRoadModelPackage.TURNOUT__RECTANGLE, null, msgs);
			msgs = basicSetRectangle(newRectangle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RailRoadModelPackage.TURNOUT__RECTANGLE, newRectangle, newRectangle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RailRoadElement getTop() {
		if (top != null && top.eIsProxy()) {
			InternalEObject oldTop = (InternalEObject)top;
			top = (RailRoadElement)eResolveProxy(oldTop);
			if (top != oldTop) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RailRoadModelPackage.TURNOUT__TOP, oldTop, top));
			}
		}
		return top;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RailRoadElement basicGetTop() {
		return top;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTop(RailRoadElement newTop) {
		RailRoadElement oldTop = top;
		top = newTop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RailRoadModelPackage.TURNOUT__TOP, oldTop, top));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RailRoadElement getStraight() {
		if (straight != null && straight.eIsProxy()) {
			InternalEObject oldStraight = (InternalEObject)straight;
			straight = (RailRoadElement)eResolveProxy(oldStraight);
			if (straight != oldStraight) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RailRoadModelPackage.TURNOUT__STRAIGHT, oldStraight, straight));
			}
		}
		return straight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RailRoadElement basicGetStraight() {
		return straight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStraight(RailRoadElement newStraight) {
		RailRoadElement oldStraight = straight;
		straight = newStraight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RailRoadModelPackage.TURNOUT__STRAIGHT, oldStraight, straight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RailRoadElement getDivergent() {
		if (divergent != null && divergent.eIsProxy()) {
			InternalEObject oldDivergent = (InternalEObject)divergent;
			divergent = (RailRoadElement)eResolveProxy(oldDivergent);
			if (divergent != oldDivergent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RailRoadModelPackage.TURNOUT__DIVERGENT, oldDivergent, divergent));
			}
		}
		return divergent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RailRoadElement basicGetDivergent() {
		return divergent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDivergent(RailRoadElement newDivergent) {
		RailRoadElement oldDivergent = divergent;
		divergent = newDivergent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RailRoadModelPackage.TURNOUT__DIVERGENT, oldDivergent, divergent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCurrentlyDivergent() {
		return currentlyDivergent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentlyDivergent(boolean newCurrentlyDivergent) {
		boolean oldCurrentlyDivergent = currentlyDivergent;
		currentlyDivergent = newCurrentlyDivergent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RailRoadModelPackage.TURNOUT__CURRENTLY_DIVERGENT, oldCurrentlyDivergent, currentlyDivergent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RailRoadModelPackage.TURNOUT__RECTANGLE:
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
			case RailRoadModelPackage.TURNOUT__RECTANGLE:
				return getRectangle();
			case RailRoadModelPackage.TURNOUT__TOP:
				if (resolve) return getTop();
				return basicGetTop();
			case RailRoadModelPackage.TURNOUT__STRAIGHT:
				if (resolve) return getStraight();
				return basicGetStraight();
			case RailRoadModelPackage.TURNOUT__DIVERGENT:
				if (resolve) return getDivergent();
				return basicGetDivergent();
			case RailRoadModelPackage.TURNOUT__CURRENTLY_DIVERGENT:
				return isCurrentlyDivergent();
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
			case RailRoadModelPackage.TURNOUT__RECTANGLE:
				setRectangle((Rectangle)newValue);
				return;
			case RailRoadModelPackage.TURNOUT__TOP:
				setTop((RailRoadElement)newValue);
				return;
			case RailRoadModelPackage.TURNOUT__STRAIGHT:
				setStraight((RailRoadElement)newValue);
				return;
			case RailRoadModelPackage.TURNOUT__DIVERGENT:
				setDivergent((RailRoadElement)newValue);
				return;
			case RailRoadModelPackage.TURNOUT__CURRENTLY_DIVERGENT:
				setCurrentlyDivergent((Boolean)newValue);
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
			case RailRoadModelPackage.TURNOUT__RECTANGLE:
				setRectangle((Rectangle)null);
				return;
			case RailRoadModelPackage.TURNOUT__TOP:
				setTop((RailRoadElement)null);
				return;
			case RailRoadModelPackage.TURNOUT__STRAIGHT:
				setStraight((RailRoadElement)null);
				return;
			case RailRoadModelPackage.TURNOUT__DIVERGENT:
				setDivergent((RailRoadElement)null);
				return;
			case RailRoadModelPackage.TURNOUT__CURRENTLY_DIVERGENT:
				setCurrentlyDivergent(CURRENTLY_DIVERGENT_EDEFAULT);
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
			case RailRoadModelPackage.TURNOUT__RECTANGLE:
				return rectangle != null;
			case RailRoadModelPackage.TURNOUT__TOP:
				return top != null;
			case RailRoadModelPackage.TURNOUT__STRAIGHT:
				return straight != null;
			case RailRoadModelPackage.TURNOUT__DIVERGENT:
				return divergent != null;
			case RailRoadModelPackage.TURNOUT__CURRENTLY_DIVERGENT:
				return currentlyDivergent != CURRENTLY_DIVERGENT_EDEFAULT;
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
		result.append(" (currentlyDivergent: ");
		result.append(currentlyDivergent);
		result.append(')');
		return result.toString();
	}

} //TurnoutImpl
