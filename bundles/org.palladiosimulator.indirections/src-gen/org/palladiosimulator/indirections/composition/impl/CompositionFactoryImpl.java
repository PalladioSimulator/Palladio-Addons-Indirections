/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.indirections.composition.AssemblyContextToAssemblyContextConnector;
import org.palladiosimulator.indirections.composition.AssemblyContextToDataChannelConnector;
import org.palladiosimulator.indirections.composition.CompositionFactory;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.DataChannelToAssemblyContextConnector;
import org.palladiosimulator.indirections.composition.DataChannelToDataChannelConnector;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class CompositionFactoryImpl extends EFactoryImpl implements CompositionFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static CompositionFactory init() {
        try {
            final CompositionFactory theCompositionFactory = (CompositionFactory) EPackage.Registry.INSTANCE
                .getEFactory(CompositionPackage.eNS_URI);
            if (theCompositionFactory != null) {
                return theCompositionFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new CompositionFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public CompositionFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR:
            return this.createDataChannelToAssemblyContextConnector();
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR:
            return this.createAssemblyContextToDataChannelConnector();
        case CompositionPackage.DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR:
            return this.createDataChannelToDataChannelConnector();
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR:
            return this.createAssemblyContextToAssemblyContextConnector();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DataChannelToAssemblyContextConnector createDataChannelToAssemblyContextConnector() {
        final DataChannelToAssemblyContextConnectorImpl dataChannelToAssemblyContextConnector = new DataChannelToAssemblyContextConnectorImpl();
        return dataChannelToAssemblyContextConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContextToDataChannelConnector createAssemblyContextToDataChannelConnector() {
        final AssemblyContextToDataChannelConnectorImpl assemblyContextToDataChannelConnector = new AssemblyContextToDataChannelConnectorImpl();
        return assemblyContextToDataChannelConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DataChannelToDataChannelConnector createDataChannelToDataChannelConnector() {
        final DataChannelToDataChannelConnectorImpl dataChannelToDataChannelConnector = new DataChannelToDataChannelConnectorImpl();
        return dataChannelToDataChannelConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContextToAssemblyContextConnector createAssemblyContextToAssemblyContextConnector() {
        final AssemblyContextToAssemblyContextConnectorImpl assemblyContextToAssemblyContextConnector = new AssemblyContextToAssemblyContextConnectorImpl();
        return assemblyContextToAssemblyContextConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public CompositionPackage getCompositionPackage() {
        return (CompositionPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static CompositionPackage getPackage() {
        return CompositionPackage.eINSTANCE;
    }

} // CompositionFactoryImpl
