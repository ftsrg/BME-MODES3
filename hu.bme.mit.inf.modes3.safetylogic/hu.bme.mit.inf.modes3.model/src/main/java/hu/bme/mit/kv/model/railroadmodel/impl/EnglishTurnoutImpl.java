/**
 */
package hu.bme.mit.kv.model.railroadmodel.impl;

import hu.bme.mit.kv.model.railroadmodel.EnglishTurnout;
import hu.bme.mit.kv.model.railroadmodel.ModelPackage;
import hu.bme.mit.kv.model.railroadmodel.Section;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>English Turnout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.kv.model.railroadmodel.impl.EnglishTurnoutImpl#getNotConnectedClockwiseSection <em>Not Connected Clockwise Section</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnglishTurnoutImpl extends TurnoutImpl implements EnglishTurnout {
	/**
	 * The cached value of the '{@link #getNotConnectedClockwiseSection() <em>Not Connected Clockwise Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotConnectedClockwiseSection()
	 * @generated
	 * @ordered
	 */
	protected Section notConnectedClockwiseSection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnglishTurnoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ENGLISH_TURNOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section getNotConnectedClockwiseSection() {
		if (notConnectedClockwiseSection != null && notConnectedClockwiseSection.eIsProxy()) {
			InternalEObject oldNotConnectedClockwiseSection = (InternalEObject)notConnectedClockwiseSection;
			notConnectedClockwiseSection = (Section)eResolveProxy(oldNotConnectedClockwiseSection);
			if (notConnectedClockwiseSection != oldNotConnectedClockwiseSection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ENGLISH_TURNOUT__NOT_CONNECTED_CLOCKWISE_SECTION, oldNotConnectedClockwiseSection, notConnectedClockwiseSection));
			}
		}
		return notConnectedClockwiseSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section basicGetNotConnectedClockwiseSection() {
		return notConnectedClockwiseSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotConnectedClockwiseSection(Section newNotConnectedClockwiseSection) {
		Section oldNotConnectedClockwiseSection = notConnectedClockwiseSection;
		notConnectedClockwiseSection = newNotConnectedClockwiseSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ENGLISH_TURNOUT__NOT_CONNECTED_CLOCKWISE_SECTION, oldNotConnectedClockwiseSection, notConnectedClockwiseSection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ENGLISH_TURNOUT__NOT_CONNECTED_CLOCKWISE_SECTION:
				if (resolve) return getNotConnectedClockwiseSection();
				return basicGetNotConnectedClockwiseSection();
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
			case ModelPackage.ENGLISH_TURNOUT__NOT_CONNECTED_CLOCKWISE_SECTION:
				setNotConnectedClockwiseSection((Section)newValue);
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
			case ModelPackage.ENGLISH_TURNOUT__NOT_CONNECTED_CLOCKWISE_SECTION:
				setNotConnectedClockwiseSection((Section)null);
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
			case ModelPackage.ENGLISH_TURNOUT__NOT_CONNECTED_CLOCKWISE_SECTION:
				return notConnectedClockwiseSection != null;
		}
		return super.eIsSet(featureID);
	}

} //EnglishTurnoutImpl
