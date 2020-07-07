/**
 */
package org.palladiosimulator.indirections.allocation;

import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Data Channel Allocation
 * Context</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.allocation.DataChannelAllocationContext#getDataChannel
 * <em>Data Channel</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.allocation.DataChannelAllocationContext#getResourceContainer
 * <em>Resource Container</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.allocation.AllocationPackage#getDataChannelAllocationContext()
 * @model
 * @generated
 */
public interface DataChannelAllocationContext extends Entity {
    /**
     * Returns the value of the '<em><b>Data Channel</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Data Channel</em>' reference.
     * @see #setDataChannel(DataChannel)
     * @see org.palladiosimulator.indirections.allocation.AllocationPackage#getDataChannelAllocationContext_DataChannel()
     * @model required="true"
     * @generated
     */
    DataChannel getDataChannel();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.allocation.DataChannelAllocationContext#getDataChannel
     * <em>Data Channel</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Data Channel</em>' reference.
     * @see #getDataChannel()
     * @generated
     */
    void setDataChannel(DataChannel value);

    /**
     * Returns the value of the '<em><b>Resource Container</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Resource Container</em>' reference.
     * @see #setResourceContainer(ResourceContainer)
     * @see org.palladiosimulator.indirections.allocation.AllocationPackage#getDataChannelAllocationContext_ResourceContainer()
     * @model required="true"
     * @generated
     */
    ResourceContainer getResourceContainer();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.allocation.DataChannelAllocationContext#getResourceContainer
     * <em>Resource Container</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Resource Container</em>' reference.
     * @see #getResourceContainer()
     * @generated
     */
    void setResourceContainer(ResourceContainer value);

} // DataChannelAllocationContext
