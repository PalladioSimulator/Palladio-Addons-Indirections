/**
 */
package org.palladiosimulator.indirections.datatypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Scheduling</b></em>', and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.indirections.datatypes.DatatypesPackage#getScheduling()
 * @model
 * @generated
 */
public enum Scheduling implements Enumerator {
    /**
     * The '<em><b>First In First Out</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #FIRST_IN_FIRST_OUT_VALUE
     * @generated
     * @ordered
     */
    FIRST_IN_FIRST_OUT(0, "FirstInFirstOut", "FirstInFirstOut"),

    /**
     * The '<em><b>Last In First Out</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #LAST_IN_FIRST_OUT_VALUE
     * @generated
     * @ordered
     */
    LAST_IN_FIRST_OUT(1, "LastInFirstOut", "LastInFirstOut"),

    /**
     * The '<em><b>Priority</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #PRIORITY_VALUE
     * @generated
     * @ordered
     */
    PRIORITY(2, "Priority", "Priority"),

    /**
     * The '<em><b>Random</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #RANDOM_VALUE
     * @generated
     * @ordered
     */
    RANDOM(3, "Random", "Random");

    /**
     * The '<em><b>First In First Out</b></em>' literal value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #FIRST_IN_FIRST_OUT
     * @model name="FirstInFirstOut"
     * @generated
     * @ordered
     */
    public static final int FIRST_IN_FIRST_OUT_VALUE = 0;

    /**
     * The '<em><b>Last In First Out</b></em>' literal value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #LAST_IN_FIRST_OUT
     * @model name="LastInFirstOut"
     * @generated
     * @ordered
     */
    public static final int LAST_IN_FIRST_OUT_VALUE = 1;

    /**
     * The '<em><b>Priority</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #PRIORITY
     * @model name="Priority"
     * @generated
     * @ordered
     */
    public static final int PRIORITY_VALUE = 2;

    /**
     * The '<em><b>Random</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #RANDOM
     * @model name="Random"
     * @generated
     * @ordered
     */
    public static final int RANDOM_VALUE = 3;

    /**
     * An array of all the '<em><b>Scheduling</b></em>' enumerators. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    private static final Scheduling[] VALUES_ARRAY = new Scheduling[] { FIRST_IN_FIRST_OUT, LAST_IN_FIRST_OUT, PRIORITY,
            RANDOM, };

    /**
     * A public read-only list of all the '<em><b>Scheduling</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final List<Scheduling> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Scheduling</b></em>' literal with the specified literal value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param literal
     *            the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static Scheduling get(final String literal) {
        for (final Scheduling result : VALUES_ARRAY) {
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Scheduling</b></em>' literal with the specified name. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param name
     *            the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static Scheduling getByName(final String name) {
        for (final Scheduling result : VALUES_ARRAY) {
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Scheduling</b></em>' literal with the specified integer value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static Scheduling get(final int value) {
        switch (value) {
        case FIRST_IN_FIRST_OUT_VALUE:
            return FIRST_IN_FIRST_OUT;
        case LAST_IN_FIRST_OUT_VALUE:
            return LAST_IN_FIRST_OUT;
        case PRIORITY_VALUE:
            return PRIORITY;
        case RANDOM_VALUE:
            return RANDOM;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private Scheduling(final int value, final String name, final String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getValue() {
        return this.value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getLiteral() {
        return this.literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        return this.literal;
    }

} // Scheduling
