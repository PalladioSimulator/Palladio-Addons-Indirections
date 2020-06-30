/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.DataChannelToDataChannelConnector;
import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.impl.DataChannelSourceConnectorImpl;
import org.palladiosimulator.indirections.system.DataChannel;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Data Channel To Data
 * Channel Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.DataChannelToDataChannelConnectorImpl#getSinkDataChannel
 * <em>Sink Data Channel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataChannelToDataChannelConnectorImpl extends DataChannelSourceConnectorImpl
        implements DataChannelToDataChannelConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected DataChannelToDataChannelConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DataChannel getSinkDataChannel() {
        return (DataChannel) this.eDynamicGet(
                CompositionPackage.DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL,
                AbstractPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public DataChannel basicGetSinkDataChannel() {
        return (DataChannel) this.eDynamicGet(
                CompositionPackage.DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL,
                AbstractPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSinkDataChannel(final DataChannel newSinkDataChannel) {
        this.eDynamicSet(CompositionPackage.DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL,
                AbstractPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL, newSinkDataChannel);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CompositionPackage.DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL:
            if (resolve) {
                return this.getSinkDataChannel();
            }
            return this.basicGetSinkDataChannel();
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
        case CompositionPackage.DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL:
            this.setSinkDataChannel((DataChannel) newValue);
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
        case CompositionPackage.DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL:
            this.setSinkDataChannel((DataChannel) null);
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
        case CompositionPackage.DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL:
            return this.basicGetSinkDataChannel() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(final int derivedFeatureID, final Class<?> baseClass) {
        if (baseClass == DataChannelSinkConnector.class) {
            switch (derivedFeatureID) {
            case CompositionPackage.DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL:
                return AbstractPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(final int baseFeatureID, final Class<?> baseClass) {
        if (baseClass == DataChannelSinkConnector.class) {
            switch (baseFeatureID) {
            case AbstractPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL:
                return CompositionPackage.DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // DataChannelToDataChannelConnectorImpl
