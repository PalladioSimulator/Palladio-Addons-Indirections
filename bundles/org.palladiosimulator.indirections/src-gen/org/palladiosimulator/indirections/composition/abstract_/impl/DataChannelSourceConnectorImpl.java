/**
 */
package org.palladiosimulator.indirections.composition.abstract_.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.system.DataChannel;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Data Channel Source
 * Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.composition.abstract_.impl.DataChannelSourceConnectorImpl#getSourceDataChannel
 * <em>Source Data Channel</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DataChannelSourceConnectorImpl extends DataSourceSinkConnectorImpl
        implements DataChannelSourceConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected DataChannelSourceConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AbstractPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DataChannel getSourceDataChannel() {
        return (DataChannel) this.eDynamicGet(AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL,
                AbstractPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public DataChannel basicGetSourceDataChannel() {
        return (DataChannel) this.eDynamicGet(AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL,
                AbstractPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSourceDataChannel(final DataChannel newSourceDataChannel) {
        this.eDynamicSet(AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL,
                AbstractPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL, newSourceDataChannel);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL:
            if (resolve) {
                return this.getSourceDataChannel();
            }
            return this.basicGetSourceDataChannel();
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
        case AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL:
            this.setSourceDataChannel((DataChannel) newValue);
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
        case AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL:
            this.setSourceDataChannel((DataChannel) null);
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
        case AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL:
            return this.basicGetSourceDataChannel() != null;
        }
        return super.eIsSet(featureID);
    }

} // DataChannelSourceConnectorImpl
