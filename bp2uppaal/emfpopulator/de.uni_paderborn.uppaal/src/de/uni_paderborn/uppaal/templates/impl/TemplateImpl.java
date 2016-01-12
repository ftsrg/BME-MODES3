/**
 */
package de.uni_paderborn.uppaal.templates.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uni_paderborn.uppaal.declarations.LocalDeclarations;
import de.uni_paderborn.uppaal.templates.Edge;
import de.uni_paderborn.uppaal.templates.Location;
import de.uni_paderborn.uppaal.templates.Template;
import de.uni_paderborn.uppaal.templates.TemplatesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.TemplateImpl#getDeclarations <em>Declarations</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.TemplateImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.TemplateImpl#getEdge <em>Edge</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.TemplateImpl#getInit <em>Init</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateImpl extends AbstractTemplateImpl implements Template {
	/**
	 * The cached value of the '{@link #getDeclarations() <em>Declarations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclarations()
	 * @generated
	 * @ordered
	 */
	protected LocalDeclarations declarations;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected EList<Location> location;

	/**
	 * The cached value of the '{@link #getEdge() <em>Edge</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdge()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edge;

	/**
	 * The cached value of the '{@link #getInit() <em>Init</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInit()
	 * @generated
	 * @ordered
	 */
	protected Location init;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatesPackage.Literals.TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalDeclarations getDeclarations() {
		return declarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclarations(LocalDeclarations newDeclarations, NotificationChain msgs) {
		LocalDeclarations oldDeclarations = declarations;
		declarations = newDeclarations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatesPackage.TEMPLATE__DECLARATIONS, oldDeclarations, newDeclarations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclarations(LocalDeclarations newDeclarations) {
		if (newDeclarations != declarations) {
			NotificationChain msgs = null;
			if (declarations != null)
				msgs = ((InternalEObject)declarations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatesPackage.TEMPLATE__DECLARATIONS, null, msgs);
			if (newDeclarations != null)
				msgs = ((InternalEObject)newDeclarations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatesPackage.TEMPLATE__DECLARATIONS, null, msgs);
			msgs = basicSetDeclarations(newDeclarations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.TEMPLATE__DECLARATIONS, newDeclarations, newDeclarations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Location> getLocation() {
		if (location == null) {
			location = new EObjectContainmentWithInverseEList<Location>(Location.class, this, TemplatesPackage.TEMPLATE__LOCATION, TemplatesPackage.LOCATION__PARENT_TEMPLATE);
		}
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getEdge() {
		if (edge == null) {
			edge = new EObjectContainmentWithInverseEList<Edge>(Edge.class, this, TemplatesPackage.TEMPLATE__EDGE, TemplatesPackage.EDGE__PARENT_TEMPLATE);
		}
		return edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getInit() {
		if (init != null && init.eIsProxy()) {
			InternalEObject oldInit = (InternalEObject)init;
			init = (Location)eResolveProxy(oldInit);
			if (init != oldInit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TemplatesPackage.TEMPLATE__INIT, oldInit, init));
			}
		}
		return init;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location basicGetInit() {
		return init;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInit(Location newInit) {
		Location oldInit = init;
		init = newInit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.TEMPLATE__INIT, oldInit, init));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatesPackage.TEMPLATE__LOCATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLocation()).basicAdd(otherEnd, msgs);
			case TemplatesPackage.TEMPLATE__EDGE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEdge()).basicAdd(otherEnd, msgs);
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
			case TemplatesPackage.TEMPLATE__DECLARATIONS:
				return basicSetDeclarations(null, msgs);
			case TemplatesPackage.TEMPLATE__LOCATION:
				return ((InternalEList<?>)getLocation()).basicRemove(otherEnd, msgs);
			case TemplatesPackage.TEMPLATE__EDGE:
				return ((InternalEList<?>)getEdge()).basicRemove(otherEnd, msgs);
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
			case TemplatesPackage.TEMPLATE__DECLARATIONS:
				return getDeclarations();
			case TemplatesPackage.TEMPLATE__LOCATION:
				return getLocation();
			case TemplatesPackage.TEMPLATE__EDGE:
				return getEdge();
			case TemplatesPackage.TEMPLATE__INIT:
				if (resolve) return getInit();
				return basicGetInit();
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
			case TemplatesPackage.TEMPLATE__DECLARATIONS:
				setDeclarations((LocalDeclarations)newValue);
				return;
			case TemplatesPackage.TEMPLATE__LOCATION:
				getLocation().clear();
				getLocation().addAll((Collection<? extends Location>)newValue);
				return;
			case TemplatesPackage.TEMPLATE__EDGE:
				getEdge().clear();
				getEdge().addAll((Collection<? extends Edge>)newValue);
				return;
			case TemplatesPackage.TEMPLATE__INIT:
				setInit((Location)newValue);
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
			case TemplatesPackage.TEMPLATE__DECLARATIONS:
				setDeclarations((LocalDeclarations)null);
				return;
			case TemplatesPackage.TEMPLATE__LOCATION:
				getLocation().clear();
				return;
			case TemplatesPackage.TEMPLATE__EDGE:
				getEdge().clear();
				return;
			case TemplatesPackage.TEMPLATE__INIT:
				setInit((Location)null);
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
			case TemplatesPackage.TEMPLATE__DECLARATIONS:
				return declarations != null;
			case TemplatesPackage.TEMPLATE__LOCATION:
				return location != null && !location.isEmpty();
			case TemplatesPackage.TEMPLATE__EDGE:
				return edge != null && !edge.isEmpty();
			case TemplatesPackage.TEMPLATE__INIT:
				return init != null;
		}
		return super.eIsSet(featureID);
	}

} //TemplateImpl
