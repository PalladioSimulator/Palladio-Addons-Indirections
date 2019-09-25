/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.system.SystemPackage;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.impl.ConnectorImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Data Channel Sink
 * Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.DataChannelSinkConnectorImpl#getDataSinkRole
 * <em>Data Sink Role</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.DataChannelSinkConnectorImpl#getAssemblyContext
 * <em>Assembly Context</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.DataChannelSinkConnectorImpl#getDataChannel
 * <em>Data Channel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataChannelSinkConnectorImpl extends ConnectorImpl implements DataChannelSinkConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DataChannelSinkConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DataSinkRole getDataSinkRole() {
        return (DataSinkRole) this.eDynamicGet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_SINK_ROLE,
                CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__DATA_SINK_ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DataSinkRole basicGetDataSinkRole() {
        return (DataSinkRole) this.eDynamicGet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_SINK_ROLE,
                CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__DATA_SINK_ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDataSinkRole(final DataSinkRole newDataSinkRole) {
        this.eDynamicSet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_SINK_ROLE,
                CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__DATA_SINK_ROLE, newDataSinkRole);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext() {
        return (AssemblyContext) this.eDynamicGet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT,
                CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext() {
        return (AssemblyContext) this.eDynamicGet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT,
                CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAssemblyContext(final AssemblyContext newAssemblyContext) {
        this.eDynamicSet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT,
                CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT, newAssemblyContext);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DataChannel getDataChannel() {
        return (DataChannel) this.eDynamicGet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL,
                CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DataChannel basicGetDataChannel() {
        return (DataChannel) this.eDynamicGet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL,
                CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetDataChannel(final DataChannel newDataChannel, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newDataChannel,
                CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDataChannel(final DataChannel newDataChannel) {
        this.eDynamicSet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL,
                CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL, newDataChannel);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL:
            final DataChannel dataChannel = this.basicGetDataChannel();
            if (dataChannel != null) {
                msgs = ((InternalEObject) dataChannel).eInverseRemove(this,
                        SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR, DataChannel.class, msgs);
            }
            return this.basicSetDataChannel((DataChannel) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL:
            return this.basicSetDataChannel(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_SINK_ROLE:
            if (resolve) {
                return this.getDataSinkRole();
            }
            return this.basicGetDataSinkRole();
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT:
            if (resolve) {
                return this.getAssemblyContext();
            }
            return this.basicGetAssemblyContext();
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL:
            if (resolve) {
                return this.getDataChannel();
            }
            return this.basicGetDataChannel();
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
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_SINK_ROLE:
            this.setDataSinkRole((DataSinkRole) newValue);
            return;
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT:
            this.setAssemblyContext((AssemblyContext) newValue);
            return;
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL:
            this.setDataChannel((DataChannel) newValue);
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
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_SINK_ROLE:
            this.setDataSinkRole((DataSinkRole) null);
            return;
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT:
            this.setAssemblyContext((AssemblyContext) null);
            return;
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL:
            this.setDataChannel((DataChannel) null);
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
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_SINK_ROLE:
            return this.basicGetDataSinkRole() != null;
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT:
            return this.basicGetAssemblyContext() != null;
        case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL:
            return this.basicGetDataChannel() != null;
        }
        return super.eIsSet(featureID);
    }

} // DataChannelSinkConnectorImpl
