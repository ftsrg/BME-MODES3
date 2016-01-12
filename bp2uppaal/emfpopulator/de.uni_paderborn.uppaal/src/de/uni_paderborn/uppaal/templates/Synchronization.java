/**
 */
package de.uni_paderborn.uppaal.templates;

import org.eclipse.emf.ecore.EObject;

import de.uni_paderborn.uppaal.expressions.IdentifierExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Synchronization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A sent or received synchronization between two templates using a specific synchronization channel.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.templates.Synchronization#getChannelExpression <em>Channel Expression</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.Synchronization#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.templates.TemplatesPackage#getSynchronization()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ChannelVariablesOnly='(not self.channelExpression.oclIsUndefined())\r\nand\r\n(not self.channelExpression.identifier.oclIsUndefined())\r\nand\r\n(self.channelExpression.identifier.oclIsKindOf(declarations::Variable))\r\nand\r\n(not self.channelExpression.identifier.oclAsType(declarations::Variable).typeDefinition.oclIsUndefined())\r\nimplies\r\nself.channelExpression.identifier.oclAsType(declarations::Variable).typeDefinition.baseType = types::BuiltInType::CHAN'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ChannelVariablesOnly'"
 * @generated
 */
public interface Synchronization extends EObject {
	/**
	 * Returns the value of the '<em><b>Channel Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An expression representing the channel variable used for synchronization.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Channel Expression</em>' containment reference.
	 * @see #setChannelExpression(IdentifierExpression)
	 * @see de.uni_paderborn.uppaal.templates.TemplatesPackage#getSynchronization_ChannelExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IdentifierExpression getChannelExpression();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.templates.Synchronization#getChannelExpression <em>Channel Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel Expression</em>' containment reference.
	 * @see #getChannelExpression()
	 * @generated
	 */
	void setChannelExpression(IdentifierExpression value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uni_paderborn.uppaal.templates.SynchronizationKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The kind of synchronization (sent or received).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see de.uni_paderborn.uppaal.templates.SynchronizationKind
	 * @see #setKind(SynchronizationKind)
	 * @see de.uni_paderborn.uppaal.templates.TemplatesPackage#getSynchronization_Kind()
	 * @model required="true"
	 * @generated
	 */
	SynchronizationKind getKind();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.templates.Synchronization#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see de.uni_paderborn.uppaal.templates.SynchronizationKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(SynchronizationKind value);

} // Synchronization
