/**
 */
package org.palladiosimulator.indirections.datatypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Outgoing
 * Distribution</b></em>', and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.indirections.datatypes.DatatypesPackage#getOutgoingDistribution()
 * @model
 * @generated
 */
public enum OutgoingDistribution implements Enumerator {
    /**
     * The '<em><b>Distribute To All</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #DISTRIBUTE_TO_ALL_VALUE
     * @generated
     * @ordered
     */
    DISTRIBUTE_TO_ALL(0, "DistributeToAll", "DistributeToAll"),

    /**
     * The '<em><b>Round Robin</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #ROUND_ROBIN_VALUE
     * @generated
     * @ordered
     */
    ROUND_ROBIN(1, "RoundRobin", "RoundRobin");

    /**
     * The '<em><b>Distribute To All</b></em>' literal value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #DISTRIBUTE_TO_ALL
     * @model name="DistributeToAll"
     * @generated
     * @ordered
     */
    public static final int DISTRIBUTE_TO_ALL_VALUE = 0;

    /**
     * The '<em><b>Round Robin</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #ROUND_ROBIN
     * @model name="RoundRobin"
     * @generated
     * @ordered
     */
    public static final int ROUND_ROBIN_VALUE = 1;

    /**
     * An array of all the '<em><b>Outgoing Distribution</b></em>' enumerators. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static final OutgoingDistribution[] VALUES_ARRAY = new OutgoingDistribution[] { DISTRIBUTE_TO_ALL,
            ROUND_ROBIN, };

    /**
     * A public read-only list of all the '<em><b>Outgoing Distribution</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final List<OutgoingDistribution> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Outgoing Distribution</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param literal
     *            the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static OutgoingDistribution get(final String literal) {
        for (final OutgoingDistribution result : VALUES_ARRAY) {
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Outgoing Distribution</b></em>' literal with the specified name. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param name
     *            the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static OutgoingDistribution getByName(final String name) {
        for (final OutgoingDistribution result : VALUES_ARRAY) {
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Outgoing Distribution</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static OutgoingDistribution get(final int value) {
        switch (value) {
        case DISTRIBUTE_TO_ALL_VALUE:
            return DISTRIBUTE_TO_ALL;
        case ROUND_ROBIN_VALUE:
            return ROUND_ROBIN;
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
    private OutgoingDistribution(final int value, final String name, final String literal) {
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

} // OutgoingDistribution
