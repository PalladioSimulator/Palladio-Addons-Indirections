/**
 */
package org.palladiosimulator.indirections.datatypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Put
 * Policy</b></em>', and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.indirections.datatypes.DatatypesPackage#getPutPolicy()
 * @model
 * @generated
 */
public enum PutPolicy implements Enumerator {
    /**
     * The '<em><b>Blocking</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #BLOCKING_VALUE
     * @generated
     * @ordered
     */
    BLOCKING(0, "Blocking", ""),

    /**
     * The '<em><b>Discard First In</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #DISCARD_FIRST_IN_VALUE
     * @generated
     * @ordered
     */
    DISCARD_FIRST_IN(1, "DiscardFirstIn", "DiscardFirstIn"),

    /**
     * The '<em><b>Discard Last In</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #DISCARD_LAST_IN_VALUE
     * @generated
     * @ordered
     */
    DISCARD_LAST_IN(2, "DiscardLastIn", "DiscardLastIn"),

    /**
     * The '<em><b>Discard Incoming</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #DISCARD_INCOMING_VALUE
     * @generated
     * @ordered
     */
    DISCARD_INCOMING(3, "DiscardIncoming", "DiscardIncoming");

    /**
     * The '<em><b>Blocking</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #BLOCKING
     * @model name="Blocking" literal=""
     * @generated
     * @ordered
     */
    public static final int BLOCKING_VALUE = 0;

    /**
     * The '<em><b>Discard First In</b></em>' literal value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #DISCARD_FIRST_IN
     * @model name="DiscardFirstIn"
     * @generated
     * @ordered
     */
    public static final int DISCARD_FIRST_IN_VALUE = 1;

    /**
     * The '<em><b>Discard Last In</b></em>' literal value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #DISCARD_LAST_IN
     * @model name="DiscardLastIn"
     * @generated
     * @ordered
     */
    public static final int DISCARD_LAST_IN_VALUE = 2;

    /**
     * The '<em><b>Discard Incoming</b></em>' literal value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #DISCARD_INCOMING
     * @model name="DiscardIncoming"
     * @generated
     * @ordered
     */
    public static final int DISCARD_INCOMING_VALUE = 3;

    /**
     * An array of all the '<em><b>Put Policy</b></em>' enumerators. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    private static final PutPolicy[] VALUES_ARRAY = new PutPolicy[] { BLOCKING, DISCARD_FIRST_IN, DISCARD_LAST_IN,
            DISCARD_INCOMING, };

    /**
     * A public read-only list of all the '<em><b>Put Policy</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final List<PutPolicy> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Put Policy</b></em>' literal with the specified literal value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param literal
     *            the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PutPolicy get(final String literal) {
        for (final PutPolicy result : VALUES_ARRAY) {
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Put Policy</b></em>' literal with the specified name. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param name
     *            the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PutPolicy getByName(final String name) {
        for (final PutPolicy result : VALUES_ARRAY) {
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Put Policy</b></em>' literal with the specified integer value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PutPolicy get(final int value) {
        switch (value) {
        case BLOCKING_VALUE:
            return BLOCKING;
        case DISCARD_FIRST_IN_VALUE:
            return DISCARD_FIRST_IN;
        case DISCARD_LAST_IN_VALUE:
            return DISCARD_LAST_IN;
        case DISCARD_INCOMING_VALUE:
            return DISCARD_INCOMING;
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
    private PutPolicy(final int value, final String name, final String literal) {
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

} // PutPolicy
