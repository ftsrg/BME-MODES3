/**
 */
package hu.bme.mit.ftsrg.ptregex.regularExpression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Star</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Star#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getStar()
 * @model
 * @generated
 */
public interface Star extends Expression
{
  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(Expression)
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getStar_Body()
   * @model containment="true"
   * @generated
   */
  Expression getBody();

  /**
   * Sets the value of the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Star#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(Expression value);

} // Star
