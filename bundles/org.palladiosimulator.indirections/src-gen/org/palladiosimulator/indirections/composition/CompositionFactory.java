/**
 */
package org.palladiosimulator.indirections.composition;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.indirections.composition.CompositionPackage
 * @generated
 */
public interface CompositionFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    CompositionFactory eINSTANCE = org.palladiosimulator.indirections.composition.impl.CompositionFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Data Channel To Assembly Context Connector</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Data Channel To Assembly Context Connector</em>'.
     * @generated
     */
    DataChannelToAssemblyContextConnector createDataChannelToAssemblyContextConnector();

    /**
     * Returns a new object of class '<em>Assembly Context To Data Channel Connector</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Assembly Context To Data Channel Connector</em>'.
     * @generated
     */
    AssemblyContextToDataChannelConnector createAssemblyContextToDataChannelConnector();

    /**
     * Returns a new object of class '<em>Data Channel To Data Channel Connector</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Data Channel To Data Channel Connector</em>'.
     * @generated
     */
    DataChannelToDataChannelConnector createDataChannelToDataChannelConnector();

    /**
     * Returns a new object of class '<em>Assembly Context To Assembly Context Connector</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Assembly Context To Assembly Context Connector</em>'.
     * @generated
     */
    AssemblyContextToAssemblyContextConnector createAssemblyContextToAssemblyContextConnector();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    CompositionPackage getCompositionPackage();

} // CompositionFactory
