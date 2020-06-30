/**
 */
package org.palladiosimulator.indirections.composition.abstract_;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage
 * @generated
 */
public interface AbstractFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    AbstractFactory eINSTANCE = org.palladiosimulator.indirections.composition.abstract_.impl.AbstractFactoryImpl
        .init();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    AbstractPackage getAbstractPackage();

} // AbstractFactory
