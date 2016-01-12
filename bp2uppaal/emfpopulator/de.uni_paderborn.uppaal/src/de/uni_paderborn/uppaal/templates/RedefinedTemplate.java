/**
 */
package de.uni_paderborn.uppaal.templates;

import de.uni_paderborn.uppaal.declarations.system.TemplateDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Redefined Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A template resulting from redefinition of another referred template, altering its name and parametrization.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.templates.RedefinedTemplate#getReferredTemplate <em>Referred Template</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.RedefinedTemplate#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.templates.TemplatesPackage#getRedefinedTemplate()
 * @model
 * @generated
 */
public interface RedefinedTemplate extends AbstractTemplate {
	/**
	 * Returns the value of the '<em><b>Referred Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The template that serves as basis for redefinition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Template</em>' reference.
	 * @see #setReferredTemplate(AbstractTemplate)
	 * @see de.uni_paderborn.uppaal.templates.TemplatesPackage#getRedefinedTemplate_ReferredTemplate()
	 * @model required="true"
	 * @generated
	 */
	AbstractTemplate getReferredTemplate();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.templates.RedefinedTemplate#getReferredTemplate <em>Referred Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Template</em>' reference.
	 * @see #getReferredTemplate()
	 * @generated
	 */
	void setReferredTemplate(AbstractTemplate value);

	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uni_paderborn.uppaal.declarations.system.TemplateDeclaration#getDeclaredTemplate <em>Declared Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The declaration of this template.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Declaration</em>' container reference.
	 * @see #setDeclaration(TemplateDeclaration)
	 * @see de.uni_paderborn.uppaal.templates.TemplatesPackage#getRedefinedTemplate_Declaration()
	 * @see de.uni_paderborn.uppaal.declarations.system.TemplateDeclaration#getDeclaredTemplate
	 * @model opposite="declaredTemplate" required="true" transient="false"
	 * @generated
	 */
	TemplateDeclaration getDeclaration();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.templates.RedefinedTemplate#getDeclaration <em>Declaration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' container reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(TemplateDeclaration value);

} // RedefinedTemplate
