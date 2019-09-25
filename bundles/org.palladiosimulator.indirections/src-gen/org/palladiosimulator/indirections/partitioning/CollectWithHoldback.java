/**
 */
package org.palladiosimulator.indirections.partitioning;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Collect With
 * Holdback</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.partitioning.CollectWithHoldback#getHoldback
 * <em>Holdback</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.partitioning.CollectWithHoldback#getKey
 * <em>Key</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage#getCollectWithHoldback()
 * @model
 * @generated
 */
public interface CollectWithHoldback extends TimeGrouping {
    /**
     * Returns the value of the '<em><b>Holdback</b></em>' attribute. The default value is
     * <code>"1"</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Holdback</em>' attribute.
     * @see #setHoldback(int)
     * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage#getCollectWithHoldback_Holdback()
     * @model default="1" required="true"
     * @generated
     */
    int getHoldback();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.partitioning.CollectWithHoldback#getHoldback
     * <em>Holdback</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Holdback</em>' attribute.
     * @see #getHoldback()
     * @generated
     */
    void setHoldback(int value);

    /**
     * Returns the value of the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the value of the '<em>Key</em>' attribute.
     * @see #setKey(String)
     * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage#getCollectWithHoldback_Key()
     * @model required="true"
     * @generated
     */
    String getKey();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.partitioning.CollectWithHoldback#getKey
     * <em>Key</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Key</em>' attribute.
     * @see #getKey()
     * @generated
     */
    void setKey(String value);

} // CollectWithHoldback
