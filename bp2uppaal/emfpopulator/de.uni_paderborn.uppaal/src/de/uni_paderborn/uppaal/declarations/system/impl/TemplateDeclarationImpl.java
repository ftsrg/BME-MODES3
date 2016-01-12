/**
 */
package de.uni_paderborn.uppaal.declarations.system.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uni_paderborn.uppaal.declarations.impl.DeclarationImpl;
import de.uni_paderborn.uppaal.declarations.system.SystemPackage;
import de.uni_paderborn.uppaal.declarations.system.TemplateDeclaration;
import de.uni_paderborn.uppaal.expressions.Expression;
import de.uni_paderborn.uppaal.templates.RedefinedTemplate;
import de.uni_paderborn.uppaal.templates.TemplatesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.system.impl.TemplateDeclarationImpl#getDeclaredTemplate <em>Declared Template</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.system.impl.TemplateDeclarationImpl#getArgument <em>Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateDeclarationImpl extends DeclarationImpl implements TemplateDeclaration {
	/**
	 * The cached value of the '{@link #getDeclaredTemplate() <em>Declared Template</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredTemplate()
	 * @generated
	 * @ordered
	 */
	protected RedefinedTemplate declaredTemplate;

	/**
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> argument;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystemPackage.Literals.TEMPLATE_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedefinedTemplate getDeclaredTemplate() {
		return declaredTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaredTemplate(RedefinedTemplate newDeclaredTemplate, NotificationChain msgs) {
		RedefinedTemplate oldDeclaredTemplate = declaredTemplate;
		declaredTemplate = newDeclaredTemplate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SystemPackage.TEMPLATE_DECLARATION__DECLARED_TEMPLATE, oldDeclaredTemplate, newDeclaredTemplate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaredTemplate(RedefinedTemplate newDeclaredTemplate) {
		if (newDeclaredTemplate != declaredTemplate) {
			NotificationChain msgs = null;
			if (declaredTemplate != null)
				msgs = ((InternalEObject)declaredTemplate).eInverseRemove(this, TemplatesPackage.REDEFINED_TEMPLATE__DECLARATION, RedefinedTemplate.class, msgs);
			if (newDeclaredTemplate != null)
				msgs = ((InternalEObject)newDeclaredTemplate).eInverseAdd(this, TemplatesPackage.REDEFINED_TEMPLATE__DECLARATION, RedefinedTemplate.class, msgs);
			msgs = basicSetDeclaredTemplate(newDeclaredTemplate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.TEMPLATE_DECLARATION__DECLARED_TEMPLATE, newDeclaredTemplate, newDeclaredTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getArgument() {
		if (argument == null) {
			argument = new EObjectContainmentEList<Expression>(Expression.class, this, SystemPackage.TEMPLATE_DECLARATION__ARGUMENT);
		}
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemPackage.TEMPLATE_DECLARATION__DECLARED_TEMPLATE:
				if (declaredTemplate != null)
					msgs = ((InternalEObject)declaredTemplate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SystemPackage.TEMPLATE_DECLARATION__DECLARED_TEMPLATE, null, msgs);
				return basicSetDeclaredTemplate((RedefinedTemplate)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemPackage.TEMPLATE_DECLARATION__DECLARED_TEMPLATE:
				return basicSetDeclaredTemplate(null, msgs);
			case SystemPackage.TEMPLATE_DECLARATION__ARGUMENT:
				return ((InternalEList<?>)getArgument()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SystemPackage.TEMPLATE_DECLARATION__DECLARED_TEMPLATE:
				return getDeclaredTemplate();
			case SystemPackage.TEMPLATE_DECLARATION__ARGUMENT:
				return getArgument();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SystemPackage.TEMPLATE_DECLARATION__DECLARED_TEMPLATE:
				setDeclaredTemplate((RedefinedTemplate)newValue);
				return;
			case SystemPackage.TEMPLATE_DECLARATION__ARGUMENT:
				getArgument().clear();
				getArgument().addAll((Collection<? extends Expression>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SystemPackage.TEMPLATE_DECLARATION__DECLARED_TEMPLATE:
				setDeclaredTemplate((RedefinedTemplate)null);
				return;
			case SystemPackage.TEMPLATE_DECLARATION__ARGUMENT:
				getArgument().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SystemPackage.TEMPLATE_DECLARATION__DECLARED_TEMPLATE:
				return declaredTemplate != null;
			case SystemPackage.TEMPLATE_DECLARATION__ARGUMENT:
				return argument != null && !argument.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TemplateDeclarationImpl
