/**
 */
package de.uni_paderborn.uppaal.declarations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uni_paderborn.uppaal.declarations.DeclarationsPackage;
import de.uni_paderborn.uppaal.declarations.SystemDeclarations;
import de.uni_paderborn.uppaal.declarations.system.ProgressMeasure;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Declarations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.impl.SystemDeclarationsImpl#getSystem <em>System</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.declarations.impl.SystemDeclarationsImpl#getProgressMeasure <em>Progress Measure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemDeclarationsImpl extends DeclarationsImpl implements SystemDeclarations {
	/**
	 * The cached value of the '{@link #getSystem() <em>System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystem()
	 * @generated
	 * @ordered
	 */
	protected de.uni_paderborn.uppaal.declarations.system.System system;

	/**
	 * The cached value of the '{@link #getProgressMeasure() <em>Progress Measure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProgressMeasure()
	 * @generated
	 * @ordered
	 */
	protected ProgressMeasure progressMeasure;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemDeclarationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeclarationsPackage.Literals.SYSTEM_DECLARATIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.uni_paderborn.uppaal.declarations.system.System getSystem() {
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem(de.uni_paderborn.uppaal.declarations.system.System newSystem, NotificationChain msgs) {
		de.uni_paderborn.uppaal.declarations.system.System oldSystem = system;
		system = newSystem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeclarationsPackage.SYSTEM_DECLARATIONS__SYSTEM, oldSystem, newSystem);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem(de.uni_paderborn.uppaal.declarations.system.System newSystem) {
		if (newSystem != system) {
			NotificationChain msgs = null;
			if (system != null)
				msgs = ((InternalEObject)system).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DeclarationsPackage.SYSTEM_DECLARATIONS__SYSTEM, null, msgs);
			if (newSystem != null)
				msgs = ((InternalEObject)newSystem).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DeclarationsPackage.SYSTEM_DECLARATIONS__SYSTEM, null, msgs);
			msgs = basicSetSystem(newSystem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeclarationsPackage.SYSTEM_DECLARATIONS__SYSTEM, newSystem, newSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgressMeasure getProgressMeasure() {
		return progressMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProgressMeasure(ProgressMeasure newProgressMeasure, NotificationChain msgs) {
		ProgressMeasure oldProgressMeasure = progressMeasure;
		progressMeasure = newProgressMeasure;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeclarationsPackage.SYSTEM_DECLARATIONS__PROGRESS_MEASURE, oldProgressMeasure, newProgressMeasure);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProgressMeasure(ProgressMeasure newProgressMeasure) {
		if (newProgressMeasure != progressMeasure) {
			NotificationChain msgs = null;
			if (progressMeasure != null)
				msgs = ((InternalEObject)progressMeasure).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DeclarationsPackage.SYSTEM_DECLARATIONS__PROGRESS_MEASURE, null, msgs);
			if (newProgressMeasure != null)
				msgs = ((InternalEObject)newProgressMeasure).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DeclarationsPackage.SYSTEM_DECLARATIONS__PROGRESS_MEASURE, null, msgs);
			msgs = basicSetProgressMeasure(newProgressMeasure, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeclarationsPackage.SYSTEM_DECLARATIONS__PROGRESS_MEASURE, newProgressMeasure, newProgressMeasure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeclarationsPackage.SYSTEM_DECLARATIONS__SYSTEM:
				return basicSetSystem(null, msgs);
			case DeclarationsPackage.SYSTEM_DECLARATIONS__PROGRESS_MEASURE:
				return basicSetProgressMeasure(null, msgs);
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
			case DeclarationsPackage.SYSTEM_DECLARATIONS__SYSTEM:
				return getSystem();
			case DeclarationsPackage.SYSTEM_DECLARATIONS__PROGRESS_MEASURE:
				return getProgressMeasure();
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
			case DeclarationsPackage.SYSTEM_DECLARATIONS__SYSTEM:
				setSystem((de.uni_paderborn.uppaal.declarations.system.System)newValue);
				return;
			case DeclarationsPackage.SYSTEM_DECLARATIONS__PROGRESS_MEASURE:
				setProgressMeasure((ProgressMeasure)newValue);
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
			case DeclarationsPackage.SYSTEM_DECLARATIONS__SYSTEM:
				setSystem((de.uni_paderborn.uppaal.declarations.system.System)null);
				return;
			case DeclarationsPackage.SYSTEM_DECLARATIONS__PROGRESS_MEASURE:
				setProgressMeasure((ProgressMeasure)null);
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
			case DeclarationsPackage.SYSTEM_DECLARATIONS__SYSTEM:
				return system != null;
			case DeclarationsPackage.SYSTEM_DECLARATIONS__PROGRESS_MEASURE:
				return progressMeasure != null;
		}
		return super.eIsSet(featureID);
	}

} //SystemDeclarationsImpl
