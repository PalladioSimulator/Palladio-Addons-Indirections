/**
 */
package org.palladiosimulator.indirections.repository.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.impl.ProvidedRoleImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Data Sink Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.repository.impl.DataSinkRoleImpl#getEventGroup
 * <em>Event Group</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.repository.impl.DataSinkRoleImpl#getDataSourceSinkConnectors
 * <em>Data Source Sink Connectors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataSinkRoleImpl extends ProvidedRoleImpl implements DataSinkRole {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected DataSinkRoleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.DATA_SINK_ROLE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EventGroup getEventGroup() {
        return (EventGroup) this.eDynamicGet(RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP,
                RepositoryPackage.Literals.DATA_SINK_ROLE__EVENT_GROUP, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public EventGroup basicGetEventGroup() {
        return (EventGroup) this.eDynamicGet(RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP,
                RepositoryPackage.Literals.DATA_SINK_ROLE__EVENT_GROUP, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setEventGroup(final EventGroup newEventGroup) {
        this.eDynamicSet(RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP,
                RepositoryPackage.Literals.DATA_SINK_ROLE__EVENT_GROUP, newEventGroup);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<DataSourceSinkConnector> getDataSourceSinkConnectors() {
        return (EList<DataSourceSinkConnector>) this.eDynamicGet(
                RepositoryPackage.DATA_SINK_ROLE__DATA_SOURCE_SINK_CONNECTORS,
                RepositoryPackage.Literals.DATA_SINK_ROLE__DATA_SOURCE_SINK_CONNECTORS, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.DATA_SINK_ROLE__DATA_SOURCE_SINK_CONNECTORS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getDataSourceSinkConnectors())
                .basicAdd(otherEnd, msgs);
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
        case RepositoryPackage.DATA_SINK_ROLE__DATA_SOURCE_SINK_CONNECTORS:
            return ((InternalEList<?>) this.getDataSourceSinkConnectors()).basicRemove(otherEnd, msgs);
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
        case RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP:
            if (resolve) {
                return this.getEventGroup();
            }
            return this.basicGetEventGroup();
        case RepositoryPackage.DATA_SINK_ROLE__DATA_SOURCE_SINK_CONNECTORS:
            return this.getDataSourceSinkConnectors();
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
        case RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP:
            this.setEventGroup((EventGroup) newValue);
            return;
        case RepositoryPackage.DATA_SINK_ROLE__DATA_SOURCE_SINK_CONNECTORS:
            this.getDataSourceSinkConnectors()
                .clear();
            this.getDataSourceSinkConnectors()
                .addAll((Collection<? extends DataSourceSinkConnector>) newValue);
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
        case RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP:
            this.setEventGroup((EventGroup) null);
            return;
        case RepositoryPackage.DATA_SINK_ROLE__DATA_SOURCE_SINK_CONNECTORS:
            this.getDataSourceSinkConnectors()
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
        case RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP:
            return this.basicGetEventGroup() != null;
        case RepositoryPackage.DATA_SINK_ROLE__DATA_SOURCE_SINK_CONNECTORS:
            return !this.getDataSourceSinkConnectors()
                .isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // DataSinkRoleImpl
