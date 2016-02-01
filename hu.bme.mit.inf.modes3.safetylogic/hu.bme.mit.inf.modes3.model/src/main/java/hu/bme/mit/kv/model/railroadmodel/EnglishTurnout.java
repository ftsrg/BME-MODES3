/**
 */
package hu.bme.mit.kv.model.railroadmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>English Turnout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.kv.model.railroadmodel.EnglishTurnout#getNotConnectedClockwiseSection <em>Not Connected Clockwise Section</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.kv.model.railroadmodel.ModelPackage#getEnglishTurnout()
 * @model
 * @generated
 */
public interface EnglishTurnout extends Turnout {
	/**
	 * Returns the value of the '<em><b>Not Connected Clockwise Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not Connected Clockwise Section</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Connected Clockwise Section</em>' reference.
	 * @see #setNotConnectedClockwiseSection(Section)
	 * @see hu.bme.mit.kv.model.railroadmodel.ModelPackage#getEnglishTurnout_NotConnectedClockwiseSection()
	 * @model required="true"
	 * @generated
	 */
	Section getNotConnectedClockwiseSection();

	/**
	 * Sets the value of the '{@link hu.bme.mit.kv.model.railroadmodel.EnglishTurnout#getNotConnectedClockwiseSection <em>Not Connected Clockwise Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Connected Clockwise Section</em>' reference.
	 * @see #getNotConnectedClockwiseSection()
	 * @generated
	 */
	void setNotConnectedClockwiseSection(Section value);

} // EnglishTurnout
