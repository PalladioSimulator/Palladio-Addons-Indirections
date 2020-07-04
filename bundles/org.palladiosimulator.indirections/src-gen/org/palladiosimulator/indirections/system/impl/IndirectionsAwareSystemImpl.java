/**
 */
package org.palladiosimulator.indirections.system.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.system.IndirectionsAwareSystem;
import org.palladiosimulator.indirections.system.SystemPackage;
import org.palladiosimulator.pcm.system.impl.SystemImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Indirections Aware
 * System</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.system.impl.IndirectionsAwareSystemImpl#getDataChannels
 * <em>Data Channels</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndirectionsAwareSystemImpl extends SystemImpl implements IndirectionsAwareSystem {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected IndirectionsAwareSystemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SystemPackage.Literals.INDIRECTIONS_AWARE_SYSTEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<DataChannel> getDataChannels() {
        return (EList<DataChannel>) this.eDynamicGet(SystemPackage.INDIRECTIONS_AWARE_SYSTEM__DATA_CHANNELS,
                SystemPackage.Literals.INDIRECTIONS_AWARE_SYSTEM__DATA_CHANNELS, true, true);
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
        case SystemPackage.INDIRECTIONS_AWARE_SYSTEM__DATA_CHANNELS:
            return ((InternalEList<?>) this.getDataChannels()).basicRemove(otherEnd, msgs);
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
        case SystemPackage.INDIRECTIONS_AWARE_SYSTEM__DATA_CHANNELS:
            return this.getDataChannels();
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
        case SystemPackage.INDIRECTIONS_AWARE_SYSTEM__DATA_CHANNELS:
            this.getDataChannels()
                .clear();
            this.getDataChannels()
                .addAll((Collection<? extends DataChannel>) newValue);
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
        case SystemPackage.INDIRECTIONS_AWARE_SYSTEM__DATA_CHANNELS:
            this.getDataChannels()
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
        case SystemPackage.INDIRECTIONS_AWARE_SYSTEM__DATA_CHANNELS:
            return !this.getDataChannels()
                .isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // IndirectionsAwareSystemImpl
