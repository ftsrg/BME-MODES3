/**
 */
package de.uni_paderborn.uppaal.statements;

import org.eclipse.emf.common.util.EList;

import de.uni_paderborn.uppaal.declarations.LocalDeclarations;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A block of one or more statements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.statements.Block#getDeclarations <em>Declarations</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.statements.Block#getStatement <em>Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.statements.StatementsPackage#getBlock()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL DataVariableDeclarationsOnly='(not self.declarations.oclIsUndefined())\r\nimplies\r\n(self.declarations.declaration->forAll(oclIsKindOf(declarations::DataVariableDeclaration)))'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='DataVariableDeclarationsOnly'"
 * @generated
 */
public interface Block extends Statement {
	/**
	 * Returns the value of the '<em><b>Declarations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The local declarations for the function's body.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Declarations</em>' containment reference.
	 * @see #setDeclarations(LocalDeclarations)
	 * @see de.uni_paderborn.uppaal.statements.StatementsPackage#getBlock_Declarations()
	 * @model containment="true"
	 * @generated
	 */
	LocalDeclarations getDeclarations();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.statements.Block#getDeclarations <em>Declarations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declarations</em>' containment reference.
	 * @see #getDeclarations()
	 * @generated
	 */
	void setDeclarations(LocalDeclarations value);

	/**
	 * Returns the value of the '<em><b>Statement</b></em>' containment reference list.
	 * The list contents are of type {@link de.uni_paderborn.uppaal.statements.Statement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The statements inside the funtion's body.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Statement</em>' containment reference list.
	 * @see de.uni_paderborn.uppaal.statements.StatementsPackage#getBlock_Statement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Statement> getStatement();

} // Block
