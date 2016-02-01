/**
 */
package hu.bme.mit.kv.model.railroadmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Turnout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.kv.model.railroadmodel.Turnout#getNotConnectedSection <em>Not Connected Section</em>}</li>
 *   <li>{@link hu.bme.mit.kv.model.railroadmodel.Turnout#isTwoSectionsInClockwiseDirection <em>Two Sections In Clockwise Direction</em>}</li>
 *   <li>{@link hu.bme.mit.kv.model.railroadmodel.Turnout#getRectangle <em>Rectangle</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.kv.model.railroadmodel.ModelPackage#getTurnout()
 * @model
 * @generated
 */
public interface Turnout extends Section {
	/**
	 * Returns the value of the '<em><b>Not Connected Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not Connected Section</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Connected Section</em>' reference.
	 * @see #setNotConnectedSection(Section)
	 * @see hu.bme.mit.kv.model.railroadmodel.ModelPackage#getTurnout_NotConnectedSection()
	 * @model required="true"
	 * @generated
	 */
	Section getNotConnectedSection();

	/**
	 * Sets the value of the '{@link hu.bme.mit.kv.model.railroadmodel.Turnout#getNotConnectedSection <em>Not Connected Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Connected Section</em>' reference.
	 * @see #getNotConnectedSection()
	 * @generated
	 */
	void setNotConnectedSection(Section value);

	/**
	 * Returns the value of the '<em><b>Two Sections In Clockwise Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Two Sections In Clockwise Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Two Sections In Clockwise Direction</em>' attribute.
	 * @see #setTwoSectionsInClockwiseDirection(boolean)
	 * @see hu.bme.mit.kv.model.railroadmodel.ModelPackage#getTurnout_TwoSectionsInClockwiseDirection()
	 * @model required="true"
	 * @generated
	 */
	boolean isTwoSectionsInClockwiseDirection();

	/**
	 * Sets the value of the '{@link hu.bme.mit.kv.model.railroadmodel.Turnout#isTwoSectionsInClockwiseDirection <em>Two Sections In Clockwise Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Two Sections In Clockwise Direction</em>' attribute.
	 * @see #isTwoSectionsInClockwiseDirection()
	 * @generated
	 */
	void setTwoSectionsInClockwiseDirection(boolean value);

	/**
	 * Returns the value of the '<em><b>Rectangle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rectangle</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rectangle</em>' containment reference.
	 * @see #setRectangle(Rectangle)
	 * @see hu.bme.mit.kv.model.railroadmodel.ModelPackage#getTurnout_Rectangle()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Rectangle getRectangle();

	/**
	 * Sets the value of the '{@link hu.bme.mit.kv.model.railroadmodel.Turnout#getRectangle <em>Rectangle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rectangle</em>' containment reference.
	 * @see #getRectangle()
	 * @generated
	 */
	void setRectangle(Rectangle value);

} // Turnout
