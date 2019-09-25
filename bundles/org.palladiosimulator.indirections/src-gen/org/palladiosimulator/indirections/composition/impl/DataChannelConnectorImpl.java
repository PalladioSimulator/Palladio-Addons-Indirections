/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.DataChannelConnector;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.pcm.core.composition.impl.ConnectorImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Data Channel
 * Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.DataChannelConnectorImpl#getSource
 * <em>Source</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.DataChannelConnectorImpl#getSink
 * <em>Sink</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataChannelConnectorImpl extends ConnectorImpl implements DataChannelConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DataChannelConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DataChannel getSource() {
        return (DataChannel) this.eDynamicGet(CompositionPackage.DATA_CHANNEL_CONNECTOR__SOURCE,
                CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR__SOURCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DataChannel basicGetSource() {
        return (DataChannel) this.eDynamicGet(CompositionPackage.DATA_CHANNEL_CONNECTOR__SOURCE,
                CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR__SOURCE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSource(final DataChannel newSource) {
        this.eDynamicSet(CompositionPackage.DATA_CHANNEL_CONNECTOR__SOURCE,
                CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR__SOURCE, newSource);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DataChannel getSink() {
        return (DataChannel) this.eDynamicGet(CompositionPackage.DATA_CHANNEL_CONNECTOR__SINK,
                CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR__SINK, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DataChannel basicGetSink() {
        return (DataChannel) this.eDynamicGet(CompositionPackage.DATA_CHANNEL_CONNECTOR__SINK,
                CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR__SINK, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSink(final DataChannel newSink) {
        this.eDynamicSet(CompositionPackage.DATA_CHANNEL_CONNECTOR__SINK,
                CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR__SINK, newSink);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CompositionPackage.DATA_CHANNEL_CONNECTOR__SOURCE:
            if (resolve) {
                return this.getSource();
            }
            return this.basicGetSource();
        case CompositionPackage.DATA_CHANNEL_CONNECTOR__SINK:
            if (resolve) {
                return this.getSink();
            }
            return this.basicGetSink();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case CompositionPackage.DATA_CHANNEL_CONNECTOR__SOURCE:
            this.setSource((DataChannel) newValue);
            return;
        case CompositionPackage.DATA_CHANNEL_CONNECTOR__SINK:
            this.setSink((DataChannel) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case CompositionPackage.DATA_CHANNEL_CONNECTOR__SOURCE:
            this.setSource((DataChannel) null);
            return;
        case CompositionPackage.DATA_CHANNEL_CONNECTOR__SINK:
            this.setSink((DataChannel) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case CompositionPackage.DATA_CHANNEL_CONNECTOR__SOURCE:
            return this.basicGetSource() != null;
        case CompositionPackage.DATA_CHANNEL_CONNECTOR__SINK:
            return this.basicGetSink() != null;
        }
        return super.eIsSet(featureID);
    }

} // DataChannelConnectorImpl
