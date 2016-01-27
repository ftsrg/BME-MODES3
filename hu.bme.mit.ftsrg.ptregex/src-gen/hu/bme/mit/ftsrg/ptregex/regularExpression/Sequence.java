/**
 */
package hu.bme.mit.ftsrg.ptregex.regularExpression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Sequence#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getSequence()
 * @model
 * @generated
 */
public interface Sequence extends Expression
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
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getSequence_Elements()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getElements();

} // Sequence
