/**
 */
package hu.bme.mit.inf.safetylogic.model.railroadmodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Dimension;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelPackage;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Point;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Rectangle;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rectangle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RectangleImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RectangleImpl#getSize <em>Size</em>}</li>
 *   <li>{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.impl.RectangleImpl#getInverseMatrix <em>Inverse Matrix</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RectangleImpl extends MinimalEObjectImpl.Container implements Rectangle {
	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected Point origin;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected Dimension size;

	/**
	 * The cached value of the '{@link #getInverseMatrix() <em>Inverse Matrix</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInverseMatrix()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> inverseMatrix;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RectangleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.RECTANGLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point getOrigin() {
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOrigin(Point newOrigin, NotificationChain msgs) {
		Point oldOrigin = origin;
		origin = newOrigin;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.RECTANGLE__ORIGIN, oldOrigin, newOrigin);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigin(Point newOrigin) {
		if (newOrigin != origin) {
			NotificationChain msgs = null;
			if (origin != null)
				msgs = ((InternalEObject)origin).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.RECTANGLE__ORIGIN, null, msgs);
			if (newOrigin != null)
				msgs = ((InternalEObject)newOrigin).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.RECTANGLE__ORIGIN, null, msgs);
			msgs = basicSetOrigin(newOrigin, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RECTANGLE__ORIGIN, newOrigin, newOrigin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSize(Dimension newSize, NotificationChain msgs) {
		Dimension oldSize = size;
		size = newSize;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.RECTANGLE__SIZE, oldSize, newSize);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(Dimension newSize) {
		if (newSize != size) {
			NotificationChain msgs = null;
			if (size != null)
				msgs = ((InternalEObject)size).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.RECTANGLE__SIZE, null, msgs);
			if (newSize != null)
				msgs = ((InternalEObject)newSize).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.RECTANGLE__SIZE, null, msgs);
			msgs = basicSetSize(newSize, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RECTANGLE__SIZE, newSize, newSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getInverseMatrix() {
		if (inverseMatrix == null) {
			inverseMatrix = new EDataTypeEList<Double>(Double.class, this, ModelPackage.RECTANGLE__INVERSE_MATRIX);
		}
		return inverseMatrix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPointInside(Point point) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.RECTANGLE__ORIGIN:
				return basicSetOrigin(null, msgs);
			case ModelPackage.RECTANGLE__SIZE:
				return basicSetSize(null, msgs);
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
			case ModelPackage.RECTANGLE__ORIGIN:
				return getOrigin();
			case ModelPackage.RECTANGLE__SIZE:
				return getSize();
			case ModelPackage.RECTANGLE__INVERSE_MATRIX:
				return getInverseMatrix();
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
			case ModelPackage.RECTANGLE__ORIGIN:
				setOrigin((Point)newValue);
				return;
			case ModelPackage.RECTANGLE__SIZE:
				setSize((Dimension)newValue);
				return;
			case ModelPackage.RECTANGLE__INVERSE_MATRIX:
				getInverseMatrix().clear();
				getInverseMatrix().addAll((Collection<? extends Double>)newValue);
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
			case ModelPackage.RECTANGLE__ORIGIN:
				setOrigin((Point)null);
				return;
			case ModelPackage.RECTANGLE__SIZE:
				setSize((Dimension)null);
				return;
			case ModelPackage.RECTANGLE__INVERSE_MATRIX:
				getInverseMatrix().clear();
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
			case ModelPackage.RECTANGLE__ORIGIN:
				return origin != null;
			case ModelPackage.RECTANGLE__SIZE:
				return size != null;
			case ModelPackage.RECTANGLE__INVERSE_MATRIX:
				return inverseMatrix != null && !inverseMatrix.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ModelPackage.RECTANGLE___IS_POINT_INSIDE__POINT:
				return isPointInside((Point)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (inverseMatrix: ");
		result.append(inverseMatrix);
		result.append(')');
		return result.toString();
	}

} //RectangleImpl
