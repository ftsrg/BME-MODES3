/**
 */
package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Path;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModelPackage;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rail Road Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelImpl#getSections <em>Sections</em>}</li>
 *   <li>{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelImpl#getTrains <em>Trains</em>}</li>
 *   <li>{@link hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.impl.RailRoadModelImpl#getPaths <em>Paths</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RailRoadModelImpl extends MinimalEObjectImpl.Container implements RailRoadModel {
	/**
	 * The cached value of the '{@link #getSections() <em>Sections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSections()
	 * @generated
	 * @ordered
	 */
	protected EList<RailRoadElement> sections;

	/**
	 * The cached value of the '{@link #getTrains() <em>Trains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrains()
	 * @generated
	 * @ordered
	 */
	protected EList<Train> trains;

	/**
	 * The cached value of the '{@link #getPaths() <em>Paths</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<Path> paths;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RailRoadModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RailRoadModelPackage.Literals.RAIL_ROAD_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RailRoadElement> getSections() {
		if (sections == null) {
			sections = new EObjectContainmentEList<RailRoadElement>(RailRoadElement.class, this, RailRoadModelPackage.RAIL_ROAD_MODEL__SECTIONS);
		}
		return sections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Train> getTrains() {
		if (trains == null) {
			trains = new EObjectContainmentEList<Train>(Train.class, this, RailRoadModelPackage.RAIL_ROAD_MODEL__TRAINS);
		}
		return trains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Path> getPaths() {
		if (paths == null) {
			paths = new EObjectContainmentEList<Path>(Path.class, this, RailRoadModelPackage.RAIL_ROAD_MODEL__PATHS);
		}
		return paths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RailRoadModelPackage.RAIL_ROAD_MODEL__SECTIONS:
				return ((InternalEList<?>)getSections()).basicRemove(otherEnd, msgs);
			case RailRoadModelPackage.RAIL_ROAD_MODEL__TRAINS:
				return ((InternalEList<?>)getTrains()).basicRemove(otherEnd, msgs);
			case RailRoadModelPackage.RAIL_ROAD_MODEL__PATHS:
				return ((InternalEList<?>)getPaths()).basicRemove(otherEnd, msgs);
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
			case RailRoadModelPackage.RAIL_ROAD_MODEL__SECTIONS:
				return getSections();
			case RailRoadModelPackage.RAIL_ROAD_MODEL__TRAINS:
				return getTrains();
			case RailRoadModelPackage.RAIL_ROAD_MODEL__PATHS:
				return getPaths();
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
			case RailRoadModelPackage.RAIL_ROAD_MODEL__SECTIONS:
				getSections().clear();
				getSections().addAll((Collection<? extends RailRoadElement>)newValue);
				return;
			case RailRoadModelPackage.RAIL_ROAD_MODEL__TRAINS:
				getTrains().clear();
				getTrains().addAll((Collection<? extends Train>)newValue);
				return;
			case RailRoadModelPackage.RAIL_ROAD_MODEL__PATHS:
				getPaths().clear();
				getPaths().addAll((Collection<? extends Path>)newValue);
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
			case RailRoadModelPackage.RAIL_ROAD_MODEL__SECTIONS:
				getSections().clear();
				return;
			case RailRoadModelPackage.RAIL_ROAD_MODEL__TRAINS:
				getTrains().clear();
				return;
			case RailRoadModelPackage.RAIL_ROAD_MODEL__PATHS:
				getPaths().clear();
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
			case RailRoadModelPackage.RAIL_ROAD_MODEL__SECTIONS:
				return sections != null && !sections.isEmpty();
			case RailRoadModelPackage.RAIL_ROAD_MODEL__TRAINS:
				return trains != null && !trains.isEmpty();
			case RailRoadModelPackage.RAIL_ROAD_MODEL__PATHS:
				return paths != null && !paths.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RailRoadModelImpl
