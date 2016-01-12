/**
 */
package de.uni_paderborn.uppaal.types;

import org.eclipse.emf.ecore.EObject;

import de.uni_paderborn.uppaal.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Bounds</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Used to restrict the 'int' type to a range of values.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.types.IntegerBounds#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.types.IntegerBounds#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.types.TypesPackage#getIntegerBounds()
 * @model extendedMetaData="name='IntegerBounds' kind='empty'"
 * @generated
 */
public interface IntegerBounds extends EObject {
	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An integer-based expression representing the lower bound.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lower Bound</em>' containment reference.
	 * @see #setLowerBound(Expression)
	 * @see de.uni_paderborn.uppaal.types.TypesPackage#getIntegerBounds_LowerBound()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getLowerBound();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.types.IntegerBounds#getLowerBound <em>Lower Bound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' containment reference.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(Expression value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An integer-based expression representing the upper bound.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Upper Bound</em>' containment reference.
	 * @see #setUpperBound(Expression)
	 * @see de.uni_paderborn.uppaal.types.TypesPackage#getIntegerBounds_UpperBound()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getUpperBound();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.types.IntegerBounds#getUpperBound <em>Upper Bound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' containment reference.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(Expression value);

} // IntegerBounds
