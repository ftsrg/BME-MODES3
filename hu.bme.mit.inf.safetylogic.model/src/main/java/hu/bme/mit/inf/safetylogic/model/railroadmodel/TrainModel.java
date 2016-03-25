/**
 */
package hu.bme.mit.inf.safetylogic.model.railroadmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Train Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.inf.safetylogic.model.railroadmodel.TrainModel#getTrains <em>Trains</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelPackage#getTrainModel()
 * @model
 * @generated
 */
public interface TrainModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Trains</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.inf.safetylogic.model.railroadmodel.Train}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trains</em>' containment reference list.
	 * @see hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelPackage#getTrainModel_Trains()
	 * @model containment="true"
	 * @generated
	 */
	EList<Train> getTrains();

} // TrainModel
