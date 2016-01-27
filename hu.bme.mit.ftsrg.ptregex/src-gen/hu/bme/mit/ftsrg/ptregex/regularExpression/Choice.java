/**
 */
package hu.bme.mit.ftsrg.ptregex.regularExpression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Choice#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getChoice()
 * @model
 * @generated
 */
public interface Choice extends Expression
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.ftsrg.ptregex.regularExpression.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getChoice_Elements()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getElements();

} // Choice
