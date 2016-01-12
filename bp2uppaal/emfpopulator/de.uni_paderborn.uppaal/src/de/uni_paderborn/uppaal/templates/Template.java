/**
 */
package de.uni_paderborn.uppaal.templates;

import org.eclipse.emf.common.util.EList;

import de.uni_paderborn.uppaal.declarations.LocalDeclarations;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An Uppaal template representing a single timed automaton.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.templates.Template#getDeclarations <em>Declarations</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.Template#getLocation <em>Location</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.Template#getEdge <em>Edge</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.Template#getInit <em>Init</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.templates.TemplatesPackage#getTemplate()
 * @model extendedMetaData="name='Template' kind='elementOnly'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL UniqueLocationNames='self.location->isUnique(name)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UniqueLocationNames'"
 * @generated
 */
public interface Template extends AbstractTemplate {
	/**
	 * Returns the value of the '<em><b>Declarations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The local declarations of the template.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Declarations</em>' containment reference.
	 * @see #setDeclarations(LocalDeclarations)
	 * @see de.uni_paderborn.uppaal.templates.TemplatesPackage#getTemplate_Declarations()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='declarations'"
	 * @generated
	 */
	LocalDeclarations getDeclarations();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.templates.Template#getDeclarations <em>Declarations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declarations</em>' containment reference.
	 * @see #getDeclarations()
	 * @generated
	 */
	void setDeclarations(LocalDeclarations value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' containment reference list.
	 * The list contents are of type {@link de.uni_paderborn.uppaal.templates.Location}.
	 * It is bidirectional and its opposite is '{@link de.uni_paderborn.uppaal.templates.Location#getParentTemplate <em>Parent Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The locations inside this template.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Location</em>' containment reference list.
	 * @see de.uni_paderborn.uppaal.templates.TemplatesPackage#getTemplate_Location()
	 * @see de.uni_paderborn.uppaal.templates.Location#getParentTemplate
	 * @model opposite="parentTemplate" containment="true" required="true"
	 *        extendedMetaData="kind='element' name='location'"
	 * @generated
	 */
	EList<Location> getLocation();

	/**
	 * Returns the value of the '<em><b>Edge</b></em>' containment reference list.
	 * The list contents are of type {@link de.uni_paderborn.uppaal.templates.Edge}.
	 * It is bidirectional and its opposite is '{@link de.uni_paderborn.uppaal.templates.Edge#getParentTemplate <em>Parent Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The edges inside this template.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Edge</em>' containment reference list.
	 * @see de.uni_paderborn.uppaal.templates.TemplatesPackage#getTemplate_Edge()
	 * @see de.uni_paderborn.uppaal.templates.Edge#getParentTemplate
	 * @model opposite="parentTemplate" containment="true"
	 *        extendedMetaData="kind='element' name='edge'"
	 * @generated
	 */
	EList<Edge> getEdge();

	/**
	 * Returns the value of the '<em><b>Init</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The initial location of this template.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Init</em>' reference.
	 * @see #setInit(Location)
	 * @see de.uni_paderborn.uppaal.templates.TemplatesPackage#getTemplate_Init()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute' name='init'"
	 * @generated
	 */
	Location getInit();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.templates.Template#getInit <em>Init</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init</em>' reference.
	 * @see #getInit()
	 * @generated
	 */
	void setInit(Location value);

} // Template
