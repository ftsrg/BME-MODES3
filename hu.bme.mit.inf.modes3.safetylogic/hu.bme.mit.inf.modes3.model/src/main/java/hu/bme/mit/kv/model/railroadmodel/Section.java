/**
 */
package hu.bme.mit.kv.model.railroadmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.kv.model.railroadmodel.Section#getClockwise <em>Clockwise</em>}</li>
 *   <li>{@link hu.bme.mit.kv.model.railroadmodel.Section#getCounterClockwise <em>Counter Clockwise</em>}</li>
 *   <li>{@link hu.bme.mit.kv.model.railroadmodel.Section#getId <em>Id</em>}</li>
 *   <li>{@link hu.bme.mit.kv.model.railroadmodel.Section#getPoints <em>Points</em>}</li>
 *   <li>{@link hu.bme.mit.kv.model.railroadmodel.Section#isEnabled <em>Enabled</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.kv.model.railroadmodel.ModelPackage#getSection()
 * @model
 * @generated
 */
public interface Section extends EObject {
	/**
	 * Returns the value of the '<em><b>Clockwise</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clockwise</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clockwise</em>' reference.
	 * @see #setClockwise(Section)
	 * @see hu.bme.mit.kv.model.railroadmodel.ModelPackage#getSection_Clockwise()
	 * @model required="true"
	 * @generated
	 */
	Section getClockwise();

	/**
	 * Sets the value of the '{@link hu.bme.mit.kv.model.railroadmodel.Section#getClockwise <em>Clockwise</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clockwise</em>' reference.
	 * @see #getClockwise()
	 * @generated
	 */
	void setClockwise(Section value);

	/**
	 * Returns the value of the '<em><b>Counter Clockwise</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Counter Clockwise</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Counter Clockwise</em>' reference.
	 * @see #setCounterClockwise(Section)
	 * @see hu.bme.mit.kv.model.railroadmodel.ModelPackage#getSection_CounterClockwise()
	 * @model required="true"
	 * @generated
	 */
	Section getCounterClockwise();

	/**
	 * Sets the value of the '{@link hu.bme.mit.kv.model.railroadmodel.Section#getCounterClockwise <em>Counter Clockwise</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Counter Clockwise</em>' reference.
	 * @see #getCounterClockwise()
	 * @generated
	 */
	void setCounterClockwise(Section value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see hu.bme.mit.kv.model.railroadmodel.ModelPackage#getSection_Id()
	 * @model id="true" required="true"
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link hu.bme.mit.kv.model.railroadmodel.Section#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Points</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.kv.model.railroadmodel.Point}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Points</em>' containment reference list.
	 * @see hu.bme.mit.kv.model.railroadmodel.ModelPackage#getSection_Points()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<Point> getPoints();

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see hu.bme.mit.kv.model.railroadmodel.ModelPackage#getSection_Enabled()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link hu.bme.mit.kv.model.railroadmodel.Section#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

} // Section
