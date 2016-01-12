/**
 */
package de.uni_paderborn.uppaal.declarations.global.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import de.uni_paderborn.uppaal.declarations.global.ChannelList;
import de.uni_paderborn.uppaal.declarations.global.GlobalPackage;
import de.uni_paderborn.uppaal.expressions.IdentifierExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Channel List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.global.impl.ChannelListImpl#getChannelExpression <em>Channel Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChannelListImpl extends ChannelPriorityItemImpl implements ChannelList {
	/**
	 * The cached value of the '{@link #getChannelExpression() <em>Channel Expression</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelExpression()
	 * @generated
	 * @ordered
	 */
	protected EList<IdentifierExpression> channelExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChannelListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GlobalPackage.Literals.CHANNEL_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IdentifierExpression> getChannelExpression() {
		if (channelExpression == null) {
			channelExpression = new EObjectResolvingEList<IdentifierExpression>(IdentifierExpression.class, this, GlobalPackage.CHANNEL_LIST__CHANNEL_EXPRESSION);
		}
		return channelExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GlobalPackage.CHANNEL_LIST__CHANNEL_EXPRESSION:
				return getChannelExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GlobalPackage.CHANNEL_LIST__CHANNEL_EXPRESSION:
				getChannelExpression().clear();
				getChannelExpression().addAll((Collection<? extends IdentifierExpression>)newValue);
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
			case GlobalPackage.CHANNEL_LIST__CHANNEL_EXPRESSION:
				getChannelExpression().clear();
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
			case GlobalPackage.CHANNEL_LIST__CHANNEL_EXPRESSION:
				return channelExpression != null && !channelExpression.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ChannelListImpl
