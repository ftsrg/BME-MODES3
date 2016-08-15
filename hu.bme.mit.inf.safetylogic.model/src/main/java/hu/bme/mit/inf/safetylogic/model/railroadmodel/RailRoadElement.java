/**
 */
package hu.bme.mit.inf.safetylogic.model.railroadmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rail Road Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement#getId <em>Id</em>}</li>
 *   <li>{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement#getPoints <em>Points</em>}</li>
 *   <li>{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement#getConnected <em>Connected</em>}</li>
 *   <li>{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement#getCurrentlyConnected <em>Currently Connected</em>}</li>
 *   <li>{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement#getViablePaths <em>Viable Paths</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelPackage#getRailRoadElement()
 * @model abstract="true"
 * @generated
 */
public interface RailRoadElement extends EObject {
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
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelPackage#getRailRoadElement_Id()
	 * @model id="true" required="true"
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Points</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Point}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Points</em>' containment reference list.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelPackage#getRailRoadElement_Points()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<Point> getPoints();

	/**
	 * Returns the value of the '<em><b>Connected</b></em>' reference list.
	 * The list contents are of type {@link hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected</em>' reference list.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelPackage#getRailRoadElement_Connected()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<RailRoadElement> getConnected();

	/**
	 * Returns the value of the '<em><b>Currently Connected</b></em>' reference list.
	 * The list contents are of type {@link hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Currently Connected</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Currently Connected</em>' reference list.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelPackage#getRailRoadElement_CurrentlyConnected()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<RailRoadElement> getCurrentlyConnected();

	/**
	 * Returns the value of the '<em><b>Viable Paths</b></em>' reference list.
	 * The list contents are of type {@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Path}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viable Paths</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viable Paths</em>' reference list.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelPackage#getRailRoadElement_ViablePaths()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Path> getViablePaths();

} // RailRoadElement
