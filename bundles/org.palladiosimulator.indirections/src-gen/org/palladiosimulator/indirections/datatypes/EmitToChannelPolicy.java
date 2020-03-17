/**
 */
package org.palladiosimulator.indirections.datatypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Emit To Channel Policy</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.indirections.datatypes.DatatypesPackage#getEmitToChannelPolicy()
 * @model
 * @generated
 */
public enum EmitToChannelPolicy implements Enumerator {
	/**
	 * The '<em><b>Block If Full</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLOCK_IF_FULL_VALUE
	 * @generated
	 * @ordered
	 */
	BLOCK_IF_FULL(0, "BlockIfFull", ""),

	/**
	 * The '<em><b>Discard Oldest If Full</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISCARD_OLDEST_IF_FULL_VALUE
	 * @generated
	 * @ordered
	 */
	DISCARD_OLDEST_IF_FULL(1, "DiscardOldestIfFull", "DiscardOldestIfFull");

	/**
	 * The '<em><b>Block If Full</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLOCK_IF_FULL
	 * @model name="BlockIfFull" literal=""
	 * @generated
	 * @ordered
	 */
	public static final int BLOCK_IF_FULL_VALUE = 0;

	/**
	 * The '<em><b>Discard Oldest If Full</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISCARD_OLDEST_IF_FULL
	 * @model name="DiscardOldestIfFull"
	 * @generated
	 * @ordered
	 */
	public static final int DISCARD_OLDEST_IF_FULL_VALUE = 1;

	/**
	 * An array of all the '<em><b>Emit To Channel Policy</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EmitToChannelPolicy[] VALUES_ARRAY = new EmitToChannelPolicy[] { BLOCK_IF_FULL,
			DISCARD_OLDEST_IF_FULL, };

	/**
	 * A public read-only list of all the '<em><b>Emit To Channel Policy</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EmitToChannelPolicy> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Emit To Channel Policy</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EmitToChannelPolicy get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EmitToChannelPolicy result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Emit To Channel Policy</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EmitToChannelPolicy getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EmitToChannelPolicy result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Emit To Channel Policy</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EmitToChannelPolicy get(int value) {
		switch (value) {
		case BLOCK_IF_FULL_VALUE:
			return BLOCK_IF_FULL;
		case DISCARD_OLDEST_IF_FULL_VALUE:
			return DISCARD_OLDEST_IF_FULL;
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
	private EmitToChannelPolicy(int value, String name, String literal) {
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

} //EmitToChannelPolicy
