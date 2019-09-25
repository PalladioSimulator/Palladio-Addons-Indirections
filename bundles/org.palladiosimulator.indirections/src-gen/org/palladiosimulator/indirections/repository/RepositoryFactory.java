/**
 */
package org.palladiosimulator.indirections.repository;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.indirections.repository.RepositoryPackage
 * @generated
 */
public interface RepositoryFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    RepositoryFactory eINSTANCE = org.palladiosimulator.indirections.repository.impl.RepositoryFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Data Sink Role</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Data Sink Role</em>'.
     * @generated
     */
    DataSinkRole createDataSinkRole();

    /**
     * Returns a new object of class '<em>Data Source Role</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Data Source Role</em>'.
     * @generated
     */
    DataSourceRole createDataSourceRole();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    RepositoryPackage getRepositoryPackage();

} // RepositoryFactory
