/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.indirections.composition.CompositionFactory;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.DataChannelConnector;
import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;

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
        case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR:
            return this.createDataChannelSourceConnector();
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR:
            return this.createDataChannelSinkConnector();
        case CompositionPackage.DATA_CHANNEL_CONNECTOR:
            return this.createDataChannelConnector();
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
    public DataChannelSourceConnector createDataChannelSourceConnector() {
        final DataChannelSourceConnectorImpl dataChannelSourceConnector = new DataChannelSourceConnectorImpl();
        return dataChannelSourceConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DataChannelSinkConnector createDataChannelSinkConnector() {
        final DataChannelSinkConnectorImpl dataChannelSinkConnector = new DataChannelSinkConnectorImpl();
        return dataChannelSinkConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DataChannelConnector createDataChannelConnector() {
        final DataChannelConnectorImpl dataChannelConnector = new DataChannelConnectorImpl();
        return dataChannelConnector;
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
