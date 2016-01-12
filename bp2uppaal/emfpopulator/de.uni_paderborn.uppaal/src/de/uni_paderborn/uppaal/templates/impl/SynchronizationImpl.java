/**
 */
package de.uni_paderborn.uppaal.templates.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import de.uni_paderborn.uppaal.expressions.IdentifierExpression;
import de.uni_paderborn.uppaal.templates.Synchronization;
import de.uni_paderborn.uppaal.templates.SynchronizationKind;
import de.uni_paderborn.uppaal.templates.TemplatesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Synchronization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.SynchronizationImpl#getChannelExpression <em>Channel Expression</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.SynchronizationImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SynchronizationImpl extends MinimalEObjectImpl.Container implements Synchronization {
	/**
	 * The cached value of the '{@link #getChannelExpression() <em>Channel Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelExpression()
	 * @generated
	 * @ordered
	 */
	protected IdentifierExpression channelExpression;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final SynchronizationKind KIND_EDEFAULT = SynchronizationKind.RECEIVE;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected SynchronizationKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SynchronizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatesPackage.Literals.SYNCHRONIZATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierExpression getChannelExpression() {
		return channelExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChannelExpression(IdentifierExpression newChannelExpression, NotificationChain msgs) {
		IdentifierExpression oldChannelExpression = channelExpression;
		channelExpression = newChannelExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatesPackage.SYNCHRONIZATION__CHANNEL_EXPRESSION, oldChannelExpression, newChannelExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannelExpression(IdentifierExpression newChannelExpression) {
		if (newChannelExpression != channelExpression) {
			NotificationChain msgs = null;
			if (channelExpression != null)
				msgs = ((InternalEObject)channelExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatesPackage.SYNCHRONIZATION__CHANNEL_EXPRESSION, null, msgs);
			if (newChannelExpression != null)
				msgs = ((InternalEObject)newChannelExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatesPackage.SYNCHRONIZATION__CHANNEL_EXPRESSION, null, msgs);
			msgs = basicSetChannelExpression(newChannelExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.SYNCHRONIZATION__CHANNEL_EXPRESSION, newChannelExpression, newChannelExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronizationKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(SynchronizationKind newKind) {
		SynchronizationKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.SYNCHRONIZATION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatesPackage.SYNCHRONIZATION__CHANNEL_EXPRESSION:
				return basicSetChannelExpression(null, msgs);
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
			case TemplatesPackage.SYNCHRONIZATION__CHANNEL_EXPRESSION:
				return getChannelExpression();
			case TemplatesPackage.SYNCHRONIZATION__KIND:
				return getKind();
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
			case TemplatesPackage.SYNCHRONIZATION__CHANNEL_EXPRESSION:
				setChannelExpression((IdentifierExpression)newValue);
				return;
			case TemplatesPackage.SYNCHRONIZATION__KIND:
				setKind((SynchronizationKind)newValue);
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
			case TemplatesPackage.SYNCHRONIZATION__CHANNEL_EXPRESSION:
				setChannelExpression((IdentifierExpression)null);
				return;
			case TemplatesPackage.SYNCHRONIZATION__KIND:
				setKind(KIND_EDEFAULT);
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
			case TemplatesPackage.SYNCHRONIZATION__CHANNEL_EXPRESSION:
				return channelExpression != null;
			case TemplatesPackage.SYNCHRONIZATION__KIND:
				return kind != KIND_EDEFAULT;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //SynchronizationImpl
