/**
 */
package de.uni_paderborn.uppaal.declarations;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Declarations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Local declarations inside a template or block of statements.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getLocalDeclarations()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL NoTemplateDeclarations='not self.declaration->exists(oclIsKindOf(system::TemplateDeclaration))' NoChannelDeclarations='not self.declaration->exists(oclIsKindOf(ChannelVariableDeclaration))'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NoTemplateDeclarations NoChannelDeclarations'"
 * @generated
 */
public interface LocalDeclarations extends Declarations {
} // LocalDeclarations
