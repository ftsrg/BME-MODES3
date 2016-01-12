/**
 */
package de.uni_paderborn.uppaal.declarations.global;

import org.eclipse.emf.common.util.EList;

import de.uni_paderborn.uppaal.expressions.IdentifierExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Channel List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A list of synchronization channel variables, used to assign these channels a common priority.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.global.ChannelList#getChannelExpression <em>Channel Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.declarations.global.GlobalPackage#getChannelList()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ChannelVariablesOnly='self.channelExpression->forAll(\r\n\t(not identifier.typeDefinition.oclIsUndefined()) implies identifier.typeDefinition.baseType = types::BuiltInType::CHAN\r\n)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ChannelVariablesOnly'"
 * @generated
 */
public interface ChannelList extends ChannelPriorityItem {
	/**
	 * Returns the value of the '<em><b>Channel Expression</b></em>' reference list.
	 * The list contents are of type {@link de.uni_paderborn.uppaal.expressions.IdentifierExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The variable expressions representing the synchronization channels inside the channel list.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Channel Expression</em>' reference list.
	 * @see de.uni_paderborn.uppaal.declarations.global.GlobalPackage#getChannelList_ChannelExpression()
	 * @model required="true"
	 * @generated
	 */
	EList<IdentifierExpression> getChannelExpression();

} // ChannelList
