/**
 */
package org.palladiosimulator.indirections.allocation;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.pcm.allocation.Allocation;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Indirections Aware
 * Allocation</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.allocation.IndirectionsAwareAllocation#getDataChannelAllocationContexts
 * <em>Data Channel Allocation Contexts</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.allocation.AllocationPackage#getIndirectionsAwareAllocation()
 * @model
 * @generated
 */
public interface IndirectionsAwareAllocation extends Allocation {
    /**
     * Returns the value of the '<em><b>Data Channel Allocation Contexts</b></em>' containment
     * reference list. The list contents are of type
     * {@link org.palladiosimulator.indirections.allocation.DataChannelAllocationContext}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Data Channel Allocation Contexts</em>' containment reference
     *         list.
     * @see org.palladiosimulator.indirections.allocation.AllocationPackage#getIndirectionsAwareAllocation_DataChannelAllocationContexts()
     * @model containment="true"
     * @generated
     */
    EList<DataChannelAllocationContext> getDataChannelAllocationContexts();

} // IndirectionsAwareAllocation
