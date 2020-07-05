/**
 */
package org.palladiosimulator.indirections;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.indirections.IndirectionsPackage
 * @generated
 */
public interface IndirectionsFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    IndirectionsFactory eINSTANCE = org.palladiosimulator.indirections.impl.IndirectionsFactoryImpl.init();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    IndirectionsPackage getIndirectionsPackage();

} // IndirectionsFactory
