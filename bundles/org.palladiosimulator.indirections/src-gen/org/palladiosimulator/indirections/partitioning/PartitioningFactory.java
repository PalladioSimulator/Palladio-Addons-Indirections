/**
 */
package org.palladiosimulator.indirections.partitioning;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage
 * @generated
 */
public interface PartitioningFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    PartitioningFactory eINSTANCE = org.palladiosimulator.indirections.partitioning.impl.PartitioningFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Partitioning</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Partitioning</em>'.
     * @generated
     */
    Partitioning createPartitioning();

    /**
     * Returns a new object of class '<em>Windowing</em>'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return a new object of class '<em>Windowing</em>'.
     * @generated
     */
    Windowing createWindowing();

    /**
     * Returns a new object of class '<em>Consume All Available</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Consume All Available</em>'.
     * @generated
     */
    ConsumeAllAvailable createConsumeAllAvailable();

    /**
     * Returns a new object of class '<em>Collect With Holdback</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Collect With Holdback</em>'.
     * @generated
     */
    CollectWithHoldback createCollectWithHoldback();

    /**
     * Returns a new object of class '<em>Joining</em>'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return a new object of class '<em>Joining</em>'.
     * @generated
     */
    Joining createJoining();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    PartitioningPackage getPartitioningPackage();

} // PartitioningFactory
