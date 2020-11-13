/**
 */
package org.palladiosimulator.indirectionsmeasuringpoint;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.indirectionsmeasuringpoint.IndirectionsmeasuringpointPackage
 * @generated
 */
public interface IndirectionsmeasuringpointFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    IndirectionsmeasuringpointFactory eINSTANCE = org.palladiosimulator.indirectionsmeasuringpoint.impl.IndirectionsmeasuringpointFactoryImpl
        .init();

    /**
     * Returns a new object of class '<em>Abstract Action Data Measuring Point</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Abstract Action Data Measuring Point</em>'.
     * @generated
     */
    AbstractActionDataMeasuringPoint createAbstractActionDataMeasuringPoint();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    IndirectionsmeasuringpointPackage getIndirectionsmeasuringpointPackage();

} // IndirectionsmeasuringpointFactory
