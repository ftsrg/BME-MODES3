/**
 */
package de.uni_paderborn.uppaal.templates.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uni_paderborn.uppaal.declarations.system.SystemPackage;
import de.uni_paderborn.uppaal.declarations.system.TemplateDeclaration;
import de.uni_paderborn.uppaal.templates.AbstractTemplate;
import de.uni_paderborn.uppaal.templates.RedefinedTemplate;
import de.uni_paderborn.uppaal.templates.TemplatesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Redefined Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.RedefinedTemplateImpl#getReferredTemplate <em>Referred Template</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.RedefinedTemplateImpl#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RedefinedTemplateImpl extends AbstractTemplateImpl implements RedefinedTemplate {
	/**
	 * The cached value of the '{@link #getReferredTemplate() <em>Referred Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredTemplate()
	 * @generated
	 * @ordered
	 */
	protected AbstractTemplate referredTemplate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RedefinedTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatesPackage.Literals.REDEFINED_TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTemplate getReferredTemplate() {
		if (referredTemplate != null && referredTemplate.eIsProxy()) {
			InternalEObject oldReferredTemplate = (InternalEObject)referredTemplate;
			referredTemplate = (AbstractTemplate)eResolveProxy(oldReferredTemplate);
			if (referredTemplate != oldReferredTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TemplatesPackage.REDEFINED_TEMPLATE__REFERRED_TEMPLATE, oldReferredTemplate, referredTemplate));
			}
		}
		return referredTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTemplate basicGetReferredTemplate() {
		return referredTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredTemplate(AbstractTemplate newReferredTemplate) {
		AbstractTemplate oldReferredTemplate = referredTemplate;
		referredTemplate = newReferredTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.REDEFINED_TEMPLATE__REFERRED_TEMPLATE, oldReferredTemplate, referredTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateDeclaration getDeclaration() {
		if (eContainerFeatureID() != TemplatesPackage.REDEFINED_TEMPLATE__DECLARATION) return null;
		return (TemplateDeclaration)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaration(TemplateDeclaration newDeclaration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDeclaration, TemplatesPackage.REDEFINED_TEMPLATE__DECLARATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaration(TemplateDeclaration newDeclaration) {
		if (newDeclaration != eInternalContainer() || (eContainerFeatureID() != TemplatesPackage.REDEFINED_TEMPLATE__DECLARATION && newDeclaration != null)) {
			if (EcoreUtil.isAncestor(this, newDeclaration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDeclaration != null)
				msgs = ((InternalEObject)newDeclaration).eInverseAdd(this, SystemPackage.TEMPLATE_DECLARATION__DECLARED_TEMPLATE, TemplateDeclaration.class, msgs);
			msgs = basicSetDeclaration(newDeclaration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.REDEFINED_TEMPLATE__DECLARATION, newDeclaration, newDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatesPackage.REDEFINED_TEMPLATE__DECLARATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeclaration((TemplateDeclaration)otherEnd, msgs);
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
			case TemplatesPackage.REDEFINED_TEMPLATE__DECLARATION:
				return basicSetDeclaration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TemplatesPackage.REDEFINED_TEMPLATE__DECLARATION:
				return eInternalContainer().eInverseRemove(this, SystemPackage.TEMPLATE_DECLARATION__DECLARED_TEMPLATE, TemplateDeclaration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TemplatesPackage.REDEFINED_TEMPLATE__REFERRED_TEMPLATE:
				if (resolve) return getReferredTemplate();
				return basicGetReferredTemplate();
			case TemplatesPackage.REDEFINED_TEMPLATE__DECLARATION:
				return getDeclaration();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TemplatesPackage.REDEFINED_TEMPLATE__REFERRED_TEMPLATE:
				setReferredTemplate((AbstractTemplate)newValue);
				return;
			case TemplatesPackage.REDEFINED_TEMPLATE__DECLARATION:
				setDeclaration((TemplateDeclaration)newValue);
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
			case TemplatesPackage.REDEFINED_TEMPLATE__REFERRED_TEMPLATE:
				setReferredTemplate((AbstractTemplate)null);
				return;
			case TemplatesPackage.REDEFINED_TEMPLATE__DECLARATION:
				setDeclaration((TemplateDeclaration)null);
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
			case TemplatesPackage.REDEFINED_TEMPLATE__REFERRED_TEMPLATE:
				return referredTemplate != null;
			case TemplatesPackage.REDEFINED_TEMPLATE__DECLARATION:
				return getDeclaration() != null;
		}
		return super.eIsSet(featureID);
	}

} //RedefinedTemplateImpl
