/**
 */
package hu.bme.mit.ftsrg.ptregex.regularExpression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Event#getFunctor <em>Functor</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Event#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getEvent()
 * @model
 * @generated
 */
public interface Event extends Expression
{
  /**
   * Returns the value of the '<em><b>Functor</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Functor</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functor</em>' reference.
   * @see #setFunctor(Functor)
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getEvent_Functor()
   * @model
   * @generated
   */
  Functor getFunctor();

  /**
   * Sets the value of the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Event#getFunctor <em>Functor</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Functor</em>' reference.
   * @see #getFunctor()
   * @generated
   */
  void setFunctor(Functor value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.ftsrg.ptregex.regularExpression.Parameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getEvent_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParameters();

} // Event
