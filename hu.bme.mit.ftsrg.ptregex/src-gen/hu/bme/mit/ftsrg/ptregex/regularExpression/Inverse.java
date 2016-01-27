/**
 */
package hu.bme.mit.ftsrg.ptregex.regularExpression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inverse</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Inverse#getExcludes <em>Excludes</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getInverse()
 * @model
 * @generated
 */
public interface Inverse extends Expression
{
  /**
   * Returns the value of the '<em><b>Excludes</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.ftsrg.ptregex.regularExpression.Event}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Excludes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Excludes</em>' containment reference list.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getInverse_Excludes()
   * @model containment="true"
   * @generated
   */
  EList<Event> getExcludes();

} // Inverse
