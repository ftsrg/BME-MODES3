/**
 */
package de.uni_paderborn.uppaal.declarations.global;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Channel Priority</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A priority ordering for synchronization channels.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.global.ChannelPriority#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.declarations.global.GlobalPackage#getChannelPriority()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL AtMostOneDefaultItem='self.item->select(oclIsKindOf(DefaultChannelPriority))->size() <= 1' EachChannelContainedAtMostOnce='self.item->select(oclIsKindOf(ChannelList)).oclAsType(ChannelList)->collect(channelExpression)->isUnique(variable)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='AtMostOneDefaultItem EachChannelContainedAtMostOnce'"
 * @generated
 */
public interface ChannelPriority extends EObject {
	/**
	 * Returns the value of the '<em><b>Item</b></em>' containment reference list.
	 * The list contents are of type {@link de.uni_paderborn.uppaal.declarations.global.ChannelPriorityItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The items of the channel priority ordering.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Item</em>' containment reference list.
	 * @see de.uni_paderborn.uppaal.declarations.global.GlobalPackage#getChannelPriority_Item()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ChannelPriorityItem> getItem();

} // ChannelPriority
