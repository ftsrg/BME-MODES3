/**
 */
package hu.bme.mit.ftsrg.ptregex.regularExpression;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration#getVars <em>Vars</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getExpressionDeclaration()
 * @model
 * @generated
 */
public interface ExpressionDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getExpressionDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Vars</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.ftsrg.ptregex.regularExpression.Var}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vars</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vars</em>' containment reference list.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getExpressionDeclaration_Vars()
   * @model containment="true"
   * @generated
   */
  EList<Var> getVars();

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
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getExpressionDeclaration_Body()
   * @model containment="true"
   * @generated
   */
  Expression getBody();

  /**
   * Sets the value of the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(Expression value);

} // ExpressionDeclaration
