/**
 */
package org.palladiosimulator.indirections.datatypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Number Of Elements</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.indirections.datatypes.DatatypesPackage#getNumberOfElements()
 * @model
 * @generated
 */
public enum NumberOfElements implements Enumerator {
	/**
	 * The '<em><b>Any Number</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns a collection. Always returns immediately, if no element is available, returns an empty collection.
	 * <!-- end-model-doc -->
	 * @see #ANY_NUMBER_VALUE
	 * @generated
	 * @ordered
	 */
	ANY_NUMBER(0, "AnyNumber", "AnyNumber"),

	/**
	 * The '<em><b>At Least One</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns a collection with all available elements. Blocks, if no elements are available. Never returns an empty collection.
	 * <!-- end-model-doc -->
	 * @see #AT_LEAST_ONE_VALUE
	 * @generated
	 * @ordered
	 */
	AT_LEAST_ONE(1, "AtLeastOne", "AtLeastOne"),

	/**
	 * The '<em><b>One Or None</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns a collection with one available element. Can return empty or with a collection with exactly one element.
	 * <!-- end-model-doc -->
	 * @see #ONE_OR_NONE_VALUE
	 * @generated
	 * @ordered
	 */
	ONE_OR_NONE(2, "OneOrNone", "OneOrNone"),

	/**
	 * The '<em><b>Exactly One</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns one element. Blocks, if no elements are available.
	 * <!-- end-model-doc -->
	 * @see #EXACTLY_ONE_VALUE
	 * @generated
	 * @ordered
	 */
	EXACTLY_ONE(3, "ExactlyOne", "ExactlyOne");

	/**
	 * The '<em><b>Any Number</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns a collection. Always returns immediately, if no element is available, returns an empty collection.
	 * <!-- end-model-doc -->
	 * @see #ANY_NUMBER
	 * @model name="AnyNumber"
	 * @generated
	 * @ordered
	 */
	public static final int ANY_NUMBER_VALUE = 0;

	/**
	 * The '<em><b>At Least One</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns a collection with all available elements. Blocks, if no elements are available. Never returns an empty collection.
	 * <!-- end-model-doc -->
	 * @see #AT_LEAST_ONE
	 * @model name="AtLeastOne"
	 * @generated
	 * @ordered
	 */
	public static final int AT_LEAST_ONE_VALUE = 1;

	/**
	 * The '<em><b>One Or None</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns a collection with one available element. Can return empty or with a collection with exactly one element.
	 * <!-- end-model-doc -->
	 * @see #ONE_OR_NONE
	 * @model name="OneOrNone"
	 * @generated
	 * @ordered
	 */
	public static final int ONE_OR_NONE_VALUE = 2;

	/**
	 * The '<em><b>Exactly One</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns one element. Blocks, if no elements are available.
	 * <!-- end-model-doc -->
	 * @see #EXACTLY_ONE
	 * @model name="ExactlyOne"
	 * @generated
	 * @ordered
	 */
	public static final int EXACTLY_ONE_VALUE = 3;

	/**
	 * An array of all the '<em><b>Number Of Elements</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final NumberOfElements[] VALUES_ARRAY = new NumberOfElements[] { ANY_NUMBER, AT_LEAST_ONE,
			ONE_OR_NONE, EXACTLY_ONE, };

	/**
	 * A public read-only list of all the '<em><b>Number Of Elements</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<NumberOfElements> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Number Of Elements</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static NumberOfElements get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			NumberOfElements result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Number Of Elements</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static NumberOfElements getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			NumberOfElements result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Number Of Elements</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static NumberOfElements get(int value) {
		switch (value) {
		case ANY_NUMBER_VALUE:
			return ANY_NUMBER;
		case AT_LEAST_ONE_VALUE:
			return AT_LEAST_ONE;
		case ONE_OR_NONE_VALUE:
			return ONE_OR_NONE;
		case EXACTLY_ONE_VALUE:
			return EXACTLY_ONE;
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
	private NumberOfElements(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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

} //NumberOfElements
