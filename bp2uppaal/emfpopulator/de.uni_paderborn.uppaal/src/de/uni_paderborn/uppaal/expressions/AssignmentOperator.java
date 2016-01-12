/**
 */
package de.uni_paderborn.uppaal.expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Assignment Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Representing all assignment operators.
 * <!-- end-model-doc -->
 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#getAssignmentOperator()
 * @model
 * @generated
 */
public enum AssignmentOperator implements Enumerator {
	/**
	 * The '<em><b>EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	EQUAL(0, "EQUAL", "="),

	/**
	 * The '<em><b>PLUS EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLUS_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	PLUS_EQUAL(1, "PLUS_EQUAL", "+="),

	/**
	 * The '<em><b>MINUS EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINUS_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	MINUS_EQUAL(2, "MINUS_EQUAL", "-="),

	/**
	 * The '<em><b>TIMES EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIMES_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	TIMES_EQUAL(3, "TIMES_EQUAL", "*="),

	/**
	 * The '<em><b>DIVIDE EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIVIDE_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	DIVIDE_EQUAL(4, "DIVIDE_EQUAL", "/="),

	/**
	 * The '<em><b>MODULO EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODULO_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	MODULO_EQUAL(5, "MODULO_EQUAL", "%="),

	/**
	 * The '<em><b>BIT AND EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIT_AND_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	BIT_AND_EQUAL(6, "BIT_AND_EQUAL", "&="),

	/**
	 * The '<em><b>BIT OR EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIT_OR_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	BIT_OR_EQUAL(7, "BIT_OR_EQUAL", "|="),

	/**
	 * The '<em><b>BIT LEFT EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIT_LEFT_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	BIT_LEFT_EQUAL(8, "BIT_LEFT_EQUAL", "<<="),

	/**
	 * The '<em><b>BIT RIGHT EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIT_RIGHT_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	BIT_RIGHT_EQUAL(9, "BIT_RIGHT_EQUAL", ">>="),

	/**
	 * The '<em><b>BIT XOR EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIT_XOR_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	BIT_XOR_EQUAL(10, "BIT_XOR_EQUAL", "^=");

	/**
	 * The '<em><b>EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUAL
	 * @model literal="="
	 * @generated
	 * @ordered
	 */
	public static final int EQUAL_VALUE = 0;

	/**
	 * The '<em><b>PLUS EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLUS EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLUS_EQUAL
	 * @model literal="+="
	 * @generated
	 * @ordered
	 */
	public static final int PLUS_EQUAL_VALUE = 1;

	/**
	 * The '<em><b>MINUS EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MINUS EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MINUS_EQUAL
	 * @model literal="-="
	 * @generated
	 * @ordered
	 */
	public static final int MINUS_EQUAL_VALUE = 2;

	/**
	 * The '<em><b>TIMES EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TIMES EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIMES_EQUAL
	 * @model literal="*="
	 * @generated
	 * @ordered
	 */
	public static final int TIMES_EQUAL_VALUE = 3;

	/**
	 * The '<em><b>DIVIDE EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIVIDE EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIVIDE_EQUAL
	 * @model literal="/="
	 * @generated
	 * @ordered
	 */
	public static final int DIVIDE_EQUAL_VALUE = 4;

	/**
	 * The '<em><b>MODULO EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODULO EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODULO_EQUAL
	 * @model literal="%="
	 * @generated
	 * @ordered
	 */
	public static final int MODULO_EQUAL_VALUE = 5;

	/**
	 * The '<em><b>BIT AND EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BIT AND EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BIT_AND_EQUAL
	 * @model literal="&="
	 * @generated
	 * @ordered
	 */
	public static final int BIT_AND_EQUAL_VALUE = 6;

	/**
	 * The '<em><b>BIT OR EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BIT OR EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BIT_OR_EQUAL
	 * @model literal="|="
	 * @generated
	 * @ordered
	 */
	public static final int BIT_OR_EQUAL_VALUE = 7;

	/**
	 * The '<em><b>BIT LEFT EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BIT LEFT EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BIT_LEFT_EQUAL
	 * @model literal="<<="
	 * @generated
	 * @ordered
	 */
	public static final int BIT_LEFT_EQUAL_VALUE = 8;

	/**
	 * The '<em><b>BIT RIGHT EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BIT RIGHT EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BIT_RIGHT_EQUAL
	 * @model literal=">>="
	 * @generated
	 * @ordered
	 */
	public static final int BIT_RIGHT_EQUAL_VALUE = 9;

	/**
	 * The '<em><b>BIT XOR EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BIT XOR EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BIT_XOR_EQUAL
	 * @model literal="^="
	 * @generated
	 * @ordered
	 */
	public static final int BIT_XOR_EQUAL_VALUE = 10;

	/**
	 * An array of all the '<em><b>Assignment Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AssignmentOperator[] VALUES_ARRAY =
		new AssignmentOperator[] {
			EQUAL,
			PLUS_EQUAL,
			MINUS_EQUAL,
			TIMES_EQUAL,
			DIVIDE_EQUAL,
			MODULO_EQUAL,
			BIT_AND_EQUAL,
			BIT_OR_EQUAL,
			BIT_LEFT_EQUAL,
			BIT_RIGHT_EQUAL,
			BIT_XOR_EQUAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Assignment Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AssignmentOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Assignment Operator</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AssignmentOperator get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AssignmentOperator result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Assignment Operator</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AssignmentOperator getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AssignmentOperator result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Assignment Operator</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AssignmentOperator get(int value) {
		switch (value) {
			case EQUAL_VALUE: return EQUAL;
			case PLUS_EQUAL_VALUE: return PLUS_EQUAL;
			case MINUS_EQUAL_VALUE: return MINUS_EQUAL;
			case TIMES_EQUAL_VALUE: return TIMES_EQUAL;
			case DIVIDE_EQUAL_VALUE: return DIVIDE_EQUAL;
			case MODULO_EQUAL_VALUE: return MODULO_EQUAL;
			case BIT_AND_EQUAL_VALUE: return BIT_AND_EQUAL;
			case BIT_OR_EQUAL_VALUE: return BIT_OR_EQUAL;
			case BIT_LEFT_EQUAL_VALUE: return BIT_LEFT_EQUAL;
			case BIT_RIGHT_EQUAL_VALUE: return BIT_RIGHT_EQUAL;
			case BIT_XOR_EQUAL_VALUE: return BIT_XOR_EQUAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AssignmentOperator(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //AssignmentOperator
