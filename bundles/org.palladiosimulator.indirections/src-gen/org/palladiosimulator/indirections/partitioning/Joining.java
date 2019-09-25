/**
 */
package org.palladiosimulator.indirections.partitioning;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.pcm.core.PCMRandomVariable;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Joining</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.partitioning.Joining#getSource
 * <em>Source</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.partitioning.Joining#isCanContributeMultipleTimes
 * <em>Can Contribute Multiple Times</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.partitioning.Joining#getKey <em>Key</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage#getJoining()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Joining extends CDOObject {
    /**
     * Returns the value of the '<em><b>Source</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the value of the '<em>Source</em>' reference.
     * @see #setSource(DataChannelSourceConnector)
     * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage#getJoining_Source()
     * @model required="true"
     * @generated
     */
    DataChannelSourceConnector getSource();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.partitioning.Joining#getSource <em>Source</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Source</em>' reference.
     * @see #getSource()
     * @generated
     */
    void setSource(DataChannelSourceConnector value);

    /**
     * Returns the value of the '<em><b>Can Contribute Multiple Times</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Can Contribute Multiple Times</em>' attribute.
     * @see #setCanContributeMultipleTimes(boolean)
     * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage#getJoining_CanContributeMultipleTimes()
     * @model required="true"
     * @generated
     */
    boolean isCanContributeMultipleTimes();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.partitioning.Joining#isCanContributeMultipleTimes
     * <em>Can Contribute Multiple Times</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Can Contribute Multiple Times</em>' attribute.
     * @see #isCanContributeMultipleTimes()
     * @generated
     */
    void setCanContributeMultipleTimes(boolean value);

    /**
     * Returns the value of the '<em><b>Key</b></em>' containment reference list. The list contents
     * are of type {@link org.palladiosimulator.pcm.core.PCMRandomVariable}. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Key</em>' containment reference list.
     * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage#getJoining_Key()
     * @model containment="true" required="true"
     * @generated
     */
    EList<PCMRandomVariable> getKey();

} // Joining
