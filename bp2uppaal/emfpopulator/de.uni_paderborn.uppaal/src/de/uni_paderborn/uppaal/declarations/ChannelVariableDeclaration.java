/**
 */
package de.uni_paderborn.uppaal.declarations;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Channel Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A declaration of synchronization channel variables.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.ChannelVariableDeclaration#isUrgent <em>Urgent</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.ChannelVariableDeclaration#isBroadcast <em>Broadcast</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getChannelVariableDeclaration()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL MatchingType='(not self.typeDefinition.oclIsUndefined())\r\nimplies\r\nself.typeDefinition.baseType = types::BuiltInType::CHAN'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='MatchingType'"
 * @generated
 */
public interface ChannelVariableDeclaration extends VariableDeclaration {
	/**
	 * Returns the value of the '<em><b>Urgent</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the urgency of the declared synchronization channels.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Urgent</em>' attribute.
	 * @see #setUrgent(boolean)
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getChannelVariableDeclaration_Urgent()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isUrgent();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.declarations.ChannelVariableDeclaration#isUrgent <em>Urgent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Urgent</em>' attribute.
	 * @see #isUrgent()
	 * @generated
	 */
	void setUrgent(boolean value);

	/**
	 * Returns the value of the '<em><b>Broadcast</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies whether the declared synchronization channels use broadcast.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Broadcast</em>' attribute.
	 * @see #setBroadcast(boolean)
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getChannelVariableDeclaration_Broadcast()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isBroadcast();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.declarations.ChannelVariableDeclaration#isBroadcast <em>Broadcast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broadcast</em>' attribute.
	 * @see #isBroadcast()
	 * @generated
	 */
	void setBroadcast(boolean value);

} // ChannelVariableDeclaration
