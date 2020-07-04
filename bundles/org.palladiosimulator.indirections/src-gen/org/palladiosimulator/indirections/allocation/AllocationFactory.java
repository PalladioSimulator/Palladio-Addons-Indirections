/**
 */
package org.palladiosimulator.indirections.allocation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.indirections.allocation.AllocationPackage
 * @generated
 */
public interface AllocationFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    AllocationFactory eINSTANCE = org.palladiosimulator.indirections.allocation.impl.AllocationFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Indirections Aware Allocation</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Indirections Aware Allocation</em>'.
     * @generated
     */
    IndirectionsAwareAllocation createIndirectionsAwareAllocation();

    /**
     * Returns a new object of class '<em>Data Channel Allocation Context</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Data Channel Allocation Context</em>'.
     * @generated
     */
    DataChannelAllocationContext createDataChannelAllocationContext();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    AllocationPackage getAllocationPackage();

} // AllocationFactory
