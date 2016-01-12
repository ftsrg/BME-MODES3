/**
 */
package de.uni_paderborn.uppaal.declarations.global;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Contains special classes that are relevant for the global declarations.
 * <!-- end-model-doc -->
 * @see de.uni_paderborn.uppaal.declarations.global.GlobalFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface GlobalPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "global";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.uni-paderborn.de/uppaal/declarations/global";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "global";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GlobalPackage eINSTANCE = de.uni_paderborn.uppaal.declarations.global.impl.GlobalPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.global.impl.ChannelPriorityImpl <em>Channel Priority</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.global.impl.ChannelPriorityImpl
	 * @see de.uni_paderborn.uppaal.declarations.global.impl.GlobalPackageImpl#getChannelPriority()
	 * @generated
	 */
	int CHANNEL_PRIORITY = 0;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_PRIORITY__ITEM = 0;

	/**
	 * The number of structural features of the '<em>Channel Priority</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_PRIORITY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Channel Priority</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_PRIORITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.global.impl.ChannelPriorityItemImpl <em>Channel Priority Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.global.impl.ChannelPriorityItemImpl
	 * @see de.uni_paderborn.uppaal.declarations.global.impl.GlobalPackageImpl#getChannelPriorityItem()
	 * @generated
	 */
	int CHANNEL_PRIORITY_ITEM = 1;

	/**
	 * The number of structural features of the '<em>Channel Priority Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_PRIORITY_ITEM_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Channel Priority Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_PRIORITY_ITEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.global.impl.ChannelListImpl <em>Channel List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.global.impl.ChannelListImpl
	 * @see de.uni_paderborn.uppaal.declarations.global.impl.GlobalPackageImpl#getChannelList()
	 * @generated
	 */
	int CHANNEL_LIST = 2;

	/**
	 * The feature id for the '<em><b>Channel Expression</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LIST__CHANNEL_EXPRESSION = CHANNEL_PRIORITY_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Channel List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LIST_FEATURE_COUNT = CHANNEL_PRIORITY_ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Channel List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LIST_OPERATION_COUNT = CHANNEL_PRIORITY_ITEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.declarations.global.impl.DefaultChannelPriorityImpl <em>Default Channel Priority</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.declarations.global.impl.DefaultChannelPriorityImpl
	 * @see de.uni_paderborn.uppaal.declarations.global.impl.GlobalPackageImpl#getDefaultChannelPriority()
	 * @generated
	 */
	int DEFAULT_CHANNEL_PRIORITY = 3;

	/**
	 * The number of structural features of the '<em>Default Channel Priority</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CHANNEL_PRIORITY_FEATURE_COUNT = CHANNEL_PRIORITY_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Default Channel Priority</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CHANNEL_PRIORITY_OPERATION_COUNT = CHANNEL_PRIORITY_ITEM_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.global.ChannelPriority <em>Channel Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel Priority</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.global.ChannelPriority
	 * @generated
	 */
	EClass getChannelPriority();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.declarations.global.ChannelPriority#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Item</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.global.ChannelPriority#getItem()
	 * @see #getChannelPriority()
	 * @generated
	 */
	EReference getChannelPriority_Item();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.global.ChannelPriorityItem <em>Channel Priority Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel Priority Item</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.global.ChannelPriorityItem
	 * @generated
	 */
	EClass getChannelPriorityItem();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.global.ChannelList <em>Channel List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel List</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.global.ChannelList
	 * @generated
	 */
	EClass getChannelList();

	/**
	 * Returns the meta object for the reference list '{@link de.uni_paderborn.uppaal.declarations.global.ChannelList#getChannelExpression <em>Channel Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Channel Expression</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.global.ChannelList#getChannelExpression()
	 * @see #getChannelList()
	 * @generated
	 */
	EReference getChannelList_ChannelExpression();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.declarations.global.DefaultChannelPriority <em>Default Channel Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Channel Priority</em>'.
	 * @see de.uni_paderborn.uppaal.declarations.global.DefaultChannelPriority
	 * @generated
	 */
	EClass getDefaultChannelPriority();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GlobalFactory getGlobalFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.global.impl.ChannelPriorityImpl <em>Channel Priority</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.global.impl.ChannelPriorityImpl
		 * @see de.uni_paderborn.uppaal.declarations.global.impl.GlobalPackageImpl#getChannelPriority()
		 * @generated
		 */
		EClass CHANNEL_PRIORITY = eINSTANCE.getChannelPriority();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL_PRIORITY__ITEM = eINSTANCE.getChannelPriority_Item();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.global.impl.ChannelPriorityItemImpl <em>Channel Priority Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.global.impl.ChannelPriorityItemImpl
		 * @see de.uni_paderborn.uppaal.declarations.global.impl.GlobalPackageImpl#getChannelPriorityItem()
		 * @generated
		 */
		EClass CHANNEL_PRIORITY_ITEM = eINSTANCE.getChannelPriorityItem();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.global.impl.ChannelListImpl <em>Channel List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.global.impl.ChannelListImpl
		 * @see de.uni_paderborn.uppaal.declarations.global.impl.GlobalPackageImpl#getChannelList()
		 * @generated
		 */
		EClass CHANNEL_LIST = eINSTANCE.getChannelList();

		/**
		 * The meta object literal for the '<em><b>Channel Expression</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL_LIST__CHANNEL_EXPRESSION = eINSTANCE.getChannelList_ChannelExpression();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.declarations.global.impl.DefaultChannelPriorityImpl <em>Default Channel Priority</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.declarations.global.impl.DefaultChannelPriorityImpl
		 * @see de.uni_paderborn.uppaal.declarations.global.impl.GlobalPackageImpl#getDefaultChannelPriority()
		 * @generated
		 */
		EClass DEFAULT_CHANNEL_PRIORITY = eINSTANCE.getDefaultChannelPriority();

	}

} //GlobalPackage
