/**
 */
package de.uni_paderborn.uppaal.declarations.global;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uni_paderborn.uppaal.declarations.global.GlobalPackage
 * @generated
 */
public interface GlobalFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GlobalFactory eINSTANCE = de.uni_paderborn.uppaal.declarations.global.impl.GlobalFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Channel Priority</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Channel Priority</em>'.
	 * @generated
	 */
	ChannelPriority createChannelPriority();

	/**
	 * Returns a new object of class '<em>Channel List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Channel List</em>'.
	 * @generated
	 */
	ChannelList createChannelList();

	/**
	 * Returns a new object of class '<em>Default Channel Priority</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Channel Priority</em>'.
	 * @generated
	 */
	DefaultChannelPriority createDefaultChannelPriority();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GlobalPackage getGlobalPackage();

} //GlobalFactory
