/**
 */
package de.uni_paderborn.uppaal.visuals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Color Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The color kinds of an element. They are the standard colors of uppaal or a self-defined color.
 * <!-- end-model-doc -->
 * @see de.uni_paderborn.uppaal.visuals.VisualsPackage#getColorKind()
 * @model
 * @generated
 */
public enum ColorKind implements Enumerator {
	/**
	 * The '<em><b>DEFAULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEFAULT_VALUE
	 * @generated
	 * @ordered
	 */
	DEFAULT(0, "DEFAULT", "Default"),

	/**
	 * The '<em><b>WHITE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WHITE_VALUE
	 * @generated
	 * @ordered
	 */
	WHITE(1, "WHITE", "White"),

	/**
	 * The '<em><b>LIGHTGREY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIGHTGREY_VALUE
	 * @generated
	 * @ordered
	 */
	LIGHTGREY(2, "LIGHTGREY", "LightGrey"),

	/**
	 * The '<em><b>DARKGREY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DARKGREY_VALUE
	 * @generated
	 * @ordered
	 */
	DARKGREY(3, "DARKGREY", "DarkGrey"),

	/**
	 * The '<em><b>BLACK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLACK_VALUE
	 * @generated
	 * @ordered
	 */
	BLACK(4, "BLACK", "Black"),

	/**
	 * The '<em><b>BLUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLUE_VALUE
	 * @generated
	 * @ordered
	 */
	BLUE(5, "BLUE", "Blue"),

	/**
	 * The '<em><b>CYAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CYAN_VALUE
	 * @generated
	 * @ordered
	 */
	CYAN(6, "CYAN", "Cyan"),

	/**
	 * The '<em><b>GREEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREEN_VALUE
	 * @generated
	 * @ordered
	 */
	GREEN(7, "GREEN", "Green"),

	/**
	 * The '<em><b>MAGENTA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAGENTA_VALUE
	 * @generated
	 * @ordered
	 */
	MAGENTA(8, "MAGENTA", "Magenta"),

	/**
	 * The '<em><b>ORANGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ORANGE_VALUE
	 * @generated
	 * @ordered
	 */
	ORANGE(9, "ORANGE", "Orange"),

	/**
	 * The '<em><b>PINK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PINK_VALUE
	 * @generated
	 * @ordered
	 */
	PINK(10, "PINK", "Pink"),

	/**
	 * The '<em><b>RED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RED_VALUE
	 * @generated
	 * @ordered
	 */
	RED(11, "RED", "Red"),

	/**
	 * The '<em><b>YELLOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YELLOW_VALUE
	 * @generated
	 * @ordered
	 */
	YELLOW(12, "YELLOW", "Yellow"),

	/**
	 * The '<em><b>SELF DEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SELF_DEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	SELF_DEFINED(13, "SELF_DEFINED", "Self_Defined");

	/**
	 * The '<em><b>DEFAULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEFAULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEFAULT
	 * @model literal="Default"
	 * @generated
	 * @ordered
	 */
	public static final int DEFAULT_VALUE = 0;

	/**
	 * The '<em><b>WHITE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WHITE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WHITE
	 * @model literal="White"
	 * @generated
	 * @ordered
	 */
	public static final int WHITE_VALUE = 1;

	/**
	 * The '<em><b>LIGHTGREY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIGHTGREY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIGHTGREY
	 * @model literal="LightGrey"
	 * @generated
	 * @ordered
	 */
	public static final int LIGHTGREY_VALUE = 2;

	/**
	 * The '<em><b>DARKGREY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DARKGREY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DARKGREY
	 * @model literal="DarkGrey"
	 * @generated
	 * @ordered
	 */
	public static final int DARKGREY_VALUE = 3;

	/**
	 * The '<em><b>BLACK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BLACK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLACK
	 * @model literal="Black"
	 * @generated
	 * @ordered
	 */
	public static final int BLACK_VALUE = 4;

	/**
	 * The '<em><b>BLUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BLUE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLUE
	 * @model literal="Blue"
	 * @generated
	 * @ordered
	 */
	public static final int BLUE_VALUE = 5;

	/**
	 * The '<em><b>CYAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CYAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CYAN
	 * @model literal="Cyan"
	 * @generated
	 * @ordered
	 */
	public static final int CYAN_VALUE = 6;

	/**
	 * The '<em><b>GREEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GREEN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREEN
	 * @model literal="Green"
	 * @generated
	 * @ordered
	 */
	public static final int GREEN_VALUE = 7;

	/**
	 * The '<em><b>MAGENTA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAGENTA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAGENTA
	 * @model literal="Magenta"
	 * @generated
	 * @ordered
	 */
	public static final int MAGENTA_VALUE = 8;

	/**
	 * The '<em><b>ORANGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ORANGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ORANGE
	 * @model literal="Orange"
	 * @generated
	 * @ordered
	 */
	public static final int ORANGE_VALUE = 9;

	/**
	 * The '<em><b>PINK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PINK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PINK
	 * @model literal="Pink"
	 * @generated
	 * @ordered
	 */
	public static final int PINK_VALUE = 10;

	/**
	 * The '<em><b>RED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RED
	 * @model literal="Red"
	 * @generated
	 * @ordered
	 */
	public static final int RED_VALUE = 11;

	/**
	 * The '<em><b>YELLOW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>YELLOW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #YELLOW
	 * @model literal="Yellow"
	 * @generated
	 * @ordered
	 */
	public static final int YELLOW_VALUE = 12;

	/**
	 * The '<em><b>SELF DEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SELF DEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SELF_DEFINED
	 * @model literal="Self_Defined"
	 * @generated
	 * @ordered
	 */
	public static final int SELF_DEFINED_VALUE = 13;

	/**
	 * An array of all the '<em><b>Color Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ColorKind[] VALUES_ARRAY =
		new ColorKind[] {
			DEFAULT,
			WHITE,
			LIGHTGREY,
			DARKGREY,
			BLACK,
			BLUE,
			CYAN,
			GREEN,
			MAGENTA,
			ORANGE,
			PINK,
			RED,
			YELLOW,
			SELF_DEFINED,
		};

	/**
	 * A public read-only list of all the '<em><b>Color Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ColorKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Color Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ColorKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ColorKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Color Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ColorKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ColorKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Color Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ColorKind get(int value) {
		switch (value) {
			case DEFAULT_VALUE: return DEFAULT;
			case WHITE_VALUE: return WHITE;
			case LIGHTGREY_VALUE: return LIGHTGREY;
			case DARKGREY_VALUE: return DARKGREY;
			case BLACK_VALUE: return BLACK;
			case BLUE_VALUE: return BLUE;
			case CYAN_VALUE: return CYAN;
			case GREEN_VALUE: return GREEN;
			case MAGENTA_VALUE: return MAGENTA;
			case ORANGE_VALUE: return ORANGE;
			case PINK_VALUE: return PINK;
			case RED_VALUE: return RED;
			case YELLOW_VALUE: return YELLOW;
			case SELF_DEFINED_VALUE: return SELF_DEFINED;
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
	private ColorKind(int value, String name, String literal) {
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
	
} //ColorKind
