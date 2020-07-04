/**
 */
package org.palladiosimulator.indirections.allocation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.indirections.allocation.AllocationPackage;
import org.palladiosimulator.indirections.allocation.DataChannelAllocationContext;
import org.palladiosimulator.indirections.allocation.IndirectionsAwareAllocation;
import org.palladiosimulator.pcm.allocation.impl.AllocationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Indirections Aware
 * Allocation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.allocation.impl.IndirectionsAwareAllocationImpl#getDataChannelAllocationContexts
 * <em>Data Channel Allocation Contexts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndirectionsAwareAllocationImpl extends AllocationImpl implements IndirectionsAwareAllocation {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected IndirectionsAwareAllocationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AllocationPackage.Literals.INDIRECTIONS_AWARE_ALLOCATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<DataChannelAllocationContext> getDataChannelAllocationContexts() {
        return (EList<DataChannelAllocationContext>) this.eDynamicGet(
                AllocationPackage.INDIRECTIONS_AWARE_ALLOCATION__DATA_CHANNEL_ALLOCATION_CONTEXTS,
                AllocationPackage.Literals.INDIRECTIONS_AWARE_ALLOCATION__DATA_CHANNEL_ALLOCATION_CONTEXTS, true, true);
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
        case AllocationPackage.INDIRECTIONS_AWARE_ALLOCATION__DATA_CHANNEL_ALLOCATION_CONTEXTS:
            return ((InternalEList<?>) this.getDataChannelAllocationContexts()).basicRemove(otherEnd, msgs);
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
        case AllocationPackage.INDIRECTIONS_AWARE_ALLOCATION__DATA_CHANNEL_ALLOCATION_CONTEXTS:
            return this.getDataChannelAllocationContexts();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case AllocationPackage.INDIRECTIONS_AWARE_ALLOCATION__DATA_CHANNEL_ALLOCATION_CONTEXTS:
            this.getDataChannelAllocationContexts()
                .clear();
            this.getDataChannelAllocationContexts()
                .addAll((Collection<? extends DataChannelAllocationContext>) newValue);
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
        case AllocationPackage.INDIRECTIONS_AWARE_ALLOCATION__DATA_CHANNEL_ALLOCATION_CONTEXTS:
            this.getDataChannelAllocationContexts()
                .clear();
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
        case AllocationPackage.INDIRECTIONS_AWARE_ALLOCATION__DATA_CHANNEL_ALLOCATION_CONTEXTS:
            return !this.getDataChannelAllocationContexts()
                .isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // IndirectionsAwareAllocationImpl
