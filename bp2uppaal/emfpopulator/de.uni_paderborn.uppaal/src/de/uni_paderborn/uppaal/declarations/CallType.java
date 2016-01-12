/**
 */
package de.uni_paderborn.uppaal.declarations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Call Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Represents call-by-value or call-by-reference parameters.
 * <!-- end-model-doc -->
 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#getCallType()
 * @model
 * @generated
 */
public enum CallType implements Enumerator {
	/**
	 * The '<em><b>CALL BY VALUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CALL_BY_VALUE_VALUE
	 * @generated
	 * @ordered
	 */
	CALL_BY_VALUE(0, "CALL_BY_VALUE", "CALL_BY_VALUE"),

	/**
	 * The '<em><b>CALL BY REFERENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CALL_BY_REFERENCE_VALUE
	 * @generated
	 * @ordered
	 */
	CALL_BY_REFERENCE(1, "CALL_BY_REFERENCE", "CALL_BY_REFERENCE");

	/**
	 * The '<em><b>CALL BY VALUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CALL BY VALUE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CALL_BY_VALUE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CALL_BY_VALUE_VALUE = 0;

	/**
	 * The '<em><b>CALL BY REFERENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CALL BY REFERENCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CALL_BY_REFERENCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CALL_BY_REFERENCE_VALUE = 1;

	/**
	 * An array of all the '<em><b>Call Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CallType[] VALUES_ARRAY =
		new CallType[] {
			CALL_BY_VALUE,
			CALL_BY_REFERENCE,
		};

	/**
	 * A public read-only list of all the '<em><b>Call Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CallType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Call Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CallType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CallType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Call Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CallType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CallType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Call Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CallType get(int value) {
		switch (value) {
			case CALL_BY_VALUE_VALUE: return CALL_BY_VALUE;
			case CALL_BY_REFERENCE_VALUE: return CALL_BY_REFERENCE;
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
	private CallType(int value, String name, String literal) {
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
	
} //CallType
