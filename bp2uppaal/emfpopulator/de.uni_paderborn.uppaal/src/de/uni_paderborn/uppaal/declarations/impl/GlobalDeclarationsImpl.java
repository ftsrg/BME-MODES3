/**
 */
package de.uni_paderborn.uppaal.declarations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uni_paderborn.uppaal.declarations.DeclarationsPackage;
import de.uni_paderborn.uppaal.declarations.GlobalDeclarations;
import de.uni_paderborn.uppaal.declarations.global.ChannelPriority;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Declarations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.impl.GlobalDeclarationsImpl#getChannelPriority <em>Channel Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GlobalDeclarationsImpl extends DeclarationsImpl implements GlobalDeclarations {
	/**
	 * The cached value of the '{@link #getChannelPriority() <em>Channel Priority</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelPriority()
	 * @generated
	 * @ordered
	 */
	protected ChannelPriority channelPriority;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalDeclarationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeclarationsPackage.Literals.GLOBAL_DECLARATIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelPriority getChannelPriority() {
		return channelPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChannelPriority(ChannelPriority newChannelPriority, NotificationChain msgs) {
		ChannelPriority oldChannelPriority = channelPriority;
		channelPriority = newChannelPriority;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeclarationsPackage.GLOBAL_DECLARATIONS__CHANNEL_PRIORITY, oldChannelPriority, newChannelPriority);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannelPriority(ChannelPriority newChannelPriority) {
		if (newChannelPriority != channelPriority) {
			NotificationChain msgs = null;
			if (channelPriority != null)
				msgs = ((InternalEObject)channelPriority).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DeclarationsPackage.GLOBAL_DECLARATIONS__CHANNEL_PRIORITY, null, msgs);
			if (newChannelPriority != null)
				msgs = ((InternalEObject)newChannelPriority).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DeclarationsPackage.GLOBAL_DECLARATIONS__CHANNEL_PRIORITY, null, msgs);
			msgs = basicSetChannelPriority(newChannelPriority, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeclarationsPackage.GLOBAL_DECLARATIONS__CHANNEL_PRIORITY, newChannelPriority, newChannelPriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeclarationsPackage.GLOBAL_DECLARATIONS__CHANNEL_PRIORITY:
				return basicSetChannelPriority(null, msgs);
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
			case DeclarationsPackage.GLOBAL_DECLARATIONS__CHANNEL_PRIORITY:
				return getChannelPriority();
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
			case DeclarationsPackage.GLOBAL_DECLARATIONS__CHANNEL_PRIORITY:
				setChannelPriority((ChannelPriority)newValue);
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
			case DeclarationsPackage.GLOBAL_DECLARATIONS__CHANNEL_PRIORITY:
				setChannelPriority((ChannelPriority)null);
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
			case DeclarationsPackage.GLOBAL_DECLARATIONS__CHANNEL_PRIORITY:
				return channelPriority != null;
		}
		return super.eIsSet(featureID);
	}

} //GlobalDeclarationsImpl
