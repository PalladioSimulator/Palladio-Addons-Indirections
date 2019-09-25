/**
 */
package org.palladiosimulator.indirections.partitioning;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Windowing</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.partitioning.Windowing#getSize <em>Size</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.partitioning.Windowing#getShift
 * <em>Shift</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage#getWindowing()
 * @model
 * @generated
 */
public interface Windowing extends TimeGrouping {
    /**
     * Returns the value of the '<em><b>Size</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the value of the '<em>Size</em>' attribute.
     * @see #setSize(double)
     * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage#getWindowing_Size()
     * @model
     * @generated
     */
    double getSize();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.partitioning.Windowing#getSize <em>Size</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Size</em>' attribute.
     * @see #getSize()
     * @generated
     */
    void setSize(double value);

    /**
     * Returns the value of the '<em><b>Shift</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the value of the '<em>Shift</em>' attribute.
     * @see #setShift(double)
     * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage#getWindowing_Shift()
     * @model
     * @generated
     */
    double getShift();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.partitioning.Windowing#getShift <em>Shift</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Shift</em>' attribute.
     * @see #getShift()
     * @generated
     */
    void setShift(double value);

} // Windowing
