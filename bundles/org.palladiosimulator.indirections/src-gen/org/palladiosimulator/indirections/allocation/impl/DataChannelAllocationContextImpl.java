/**
 */
package org.palladiosimulator.indirections.allocation.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.indirections.allocation.AllocationPackage;
import org.palladiosimulator.indirections.allocation.DataChannelAllocationContext;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Data Channel Allocation
 * Context</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.allocation.impl.DataChannelAllocationContextImpl#getDataChannel
 * <em>Data Channel</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.allocation.impl.DataChannelAllocationContextImpl#getResourceEnvironment
 * <em>Resource Environment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataChannelAllocationContextImpl extends EntityImpl implements DataChannelAllocationContext {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected DataChannelAllocationContextImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AllocationPackage.Literals.DATA_CHANNEL_ALLOCATION_CONTEXT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DataChannel getDataChannel() {
        return (DataChannel) this.eDynamicGet(AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT__DATA_CHANNEL,
                AllocationPackage.Literals.DATA_CHANNEL_ALLOCATION_CONTEXT__DATA_CHANNEL, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public DataChannel basicGetDataChannel() {
        return (DataChannel) this.eDynamicGet(AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT__DATA_CHANNEL,
                AllocationPackage.Literals.DATA_CHANNEL_ALLOCATION_CONTEXT__DATA_CHANNEL, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDataChannel(final DataChannel newDataChannel) {
        this.eDynamicSet(AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT__DATA_CHANNEL,
                AllocationPackage.Literals.DATA_CHANNEL_ALLOCATION_CONTEXT__DATA_CHANNEL, newDataChannel);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceContainer getResourceEnvironment() {
        return (ResourceContainer) this.eDynamicGet(
                AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT__RESOURCE_ENVIRONMENT,
                AllocationPackage.Literals.DATA_CHANNEL_ALLOCATION_CONTEXT__RESOURCE_ENVIRONMENT, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceContainer basicGetResourceEnvironment() {
        return (ResourceContainer) this.eDynamicGet(
                AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT__RESOURCE_ENVIRONMENT,
                AllocationPackage.Literals.DATA_CHANNEL_ALLOCATION_CONTEXT__RESOURCE_ENVIRONMENT, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceEnvironment(final ResourceContainer newResourceEnvironment) {
        this.eDynamicSet(AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT__RESOURCE_ENVIRONMENT,
                AllocationPackage.Literals.DATA_CHANNEL_ALLOCATION_CONTEXT__RESOURCE_ENVIRONMENT,
                newResourceEnvironment);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT__DATA_CHANNEL:
            if (resolve) {
                return this.getDataChannel();
            }
            return this.basicGetDataChannel();
        case AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT__RESOURCE_ENVIRONMENT:
            if (resolve) {
                return this.getResourceEnvironment();
            }
            return this.basicGetResourceEnvironment();
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
        case AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT__DATA_CHANNEL:
            this.setDataChannel((DataChannel) newValue);
            return;
        case AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT__RESOURCE_ENVIRONMENT:
            this.setResourceEnvironment((ResourceContainer) newValue);
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
        case AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT__DATA_CHANNEL:
            this.setDataChannel((DataChannel) null);
            return;
        case AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT__RESOURCE_ENVIRONMENT:
            this.setResourceEnvironment((ResourceContainer) null);
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
        case AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT__DATA_CHANNEL:
            return this.basicGetDataChannel() != null;
        case AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT__RESOURCE_ENVIRONMENT:
            return this.basicGetResourceEnvironment() != null;
        }
        return super.eIsSet(featureID);
    }

} // DataChannelAllocationContextImpl
