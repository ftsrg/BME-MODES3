/**
 */
package de.uni_paderborn.uppaal.declarations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uni_paderborn.uppaal.declarations.ChannelVariableDeclaration;
import de.uni_paderborn.uppaal.declarations.DeclarationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Channel Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.impl.ChannelVariableDeclarationImpl#isUrgent <em>Urgent</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.impl.ChannelVariableDeclarationImpl#isBroadcast <em>Broadcast</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChannelVariableDeclarationImpl extends VariableDeclarationImpl implements ChannelVariableDeclaration {
	/**
	 * The default value of the '{@link #isUrgent() <em>Urgent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUrgent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean URGENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUrgent() <em>Urgent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUrgent()
	 * @generated
	 * @ordered
	 */
	protected boolean urgent = URGENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isBroadcast() <em>Broadcast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBroadcast()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BROADCAST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBroadcast() <em>Broadcast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBroadcast()
	 * @generated
	 * @ordered
	 */
	protected boolean broadcast = BROADCAST_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChannelVariableDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeclarationsPackage.Literals.CHANNEL_VARIABLE_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUrgent() {
		return urgent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrgent(boolean newUrgent) {
		boolean oldUrgent = urgent;
		urgent = newUrgent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeclarationsPackage.CHANNEL_VARIABLE_DECLARATION__URGENT, oldUrgent, urgent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBroadcast() {
		return broadcast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBroadcast(boolean newBroadcast) {
		boolean oldBroadcast = broadcast;
		broadcast = newBroadcast;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeclarationsPackage.CHANNEL_VARIABLE_DECLARATION__BROADCAST, oldBroadcast, broadcast));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DeclarationsPackage.CHANNEL_VARIABLE_DECLARATION__URGENT:
				return isUrgent();
			case DeclarationsPackage.CHANNEL_VARIABLE_DECLARATION__BROADCAST:
				return isBroadcast();
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
			case DeclarationsPackage.CHANNEL_VARIABLE_DECLARATION__URGENT:
				setUrgent((Boolean)newValue);
				return;
			case DeclarationsPackage.CHANNEL_VARIABLE_DECLARATION__BROADCAST:
				setBroadcast((Boolean)newValue);
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
			case DeclarationsPackage.CHANNEL_VARIABLE_DECLARATION__URGENT:
				setUrgent(URGENT_EDEFAULT);
				return;
			case DeclarationsPackage.CHANNEL_VARIABLE_DECLARATION__BROADCAST:
				setBroadcast(BROADCAST_EDEFAULT);
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
			case DeclarationsPackage.CHANNEL_VARIABLE_DECLARATION__URGENT:
				return urgent != URGENT_EDEFAULT;
			case DeclarationsPackage.CHANNEL_VARIABLE_DECLARATION__BROADCAST:
				return broadcast != BROADCAST_EDEFAULT;
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
		result.append(" (urgent: ");
		result.append(urgent);
		result.append(", broadcast: ");
		result.append(broadcast);
		result.append(')');
		return result.toString();
	}

} //ChannelVariableDeclarationImpl
