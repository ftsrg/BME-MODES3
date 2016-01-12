/**
 */
package de.uni_paderborn.uppaal.declarations.global.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uni_paderborn.uppaal.declarations.global.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GlobalFactoryImpl extends EFactoryImpl implements GlobalFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GlobalFactory init() {
		try {
			GlobalFactory theGlobalFactory = (GlobalFactory)EPackage.Registry.INSTANCE.getEFactory(GlobalPackage.eNS_URI);
			if (theGlobalFactory != null) {
				return theGlobalFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GlobalFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GlobalPackage.CHANNEL_PRIORITY: return createChannelPriority();
			case GlobalPackage.CHANNEL_LIST: return createChannelList();
			case GlobalPackage.DEFAULT_CHANNEL_PRIORITY: return createDefaultChannelPriority();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelPriority createChannelPriority() {
		ChannelPriorityImpl channelPriority = new ChannelPriorityImpl();
		return channelPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelList createChannelList() {
		ChannelListImpl channelList = new ChannelListImpl();
		return channelList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultChannelPriority createDefaultChannelPriority() {
		DefaultChannelPriorityImpl defaultChannelPriority = new DefaultChannelPriorityImpl();
		return defaultChannelPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalPackage getGlobalPackage() {
		return (GlobalPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GlobalPackage getPackage() {
		return GlobalPackage.eINSTANCE;
	}

} //GlobalFactoryImpl
