/**
 */
package org.palladiosimulator.indirections.composition.abstract_.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.repository.RepositoryPackage;
import org.palladiosimulator.pcm.core.composition.impl.ConnectorImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Data Source Sink
 * Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.composition.abstract_.impl.DataSourceSinkConnectorImpl#getDataSourceRole
 * <em>Data Source Role</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.abstract_.impl.DataSourceSinkConnectorImpl#getDataSinkRole
 * <em>Data Sink Role</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DataSourceSinkConnectorImpl extends ConnectorImpl implements DataSourceSinkConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected DataSourceSinkConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AbstractPackage.Literals.DATA_SOURCE_SINK_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DataSourceRole getDataSourceRole() {
        return (DataSourceRole) this.eDynamicGet(AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE,
                AbstractPackage.Literals.DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public DataSourceRole basicGetDataSourceRole() {
        return (DataSourceRole) this.eDynamicGet(AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE,
                AbstractPackage.Literals.DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetDataSourceRole(final DataSourceRole newDataSourceRole, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newDataSourceRole,
                AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDataSourceRole(final DataSourceRole newDataSourceRole) {
        this.eDynamicSet(AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE,
                AbstractPackage.Literals.DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE, newDataSourceRole);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DataSinkRole getDataSinkRole() {
        return (DataSinkRole) this.eDynamicGet(AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE,
                AbstractPackage.Literals.DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public DataSinkRole basicGetDataSinkRole() {
        return (DataSinkRole) this.eDynamicGet(AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE,
                AbstractPackage.Literals.DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetDataSinkRole(final DataSinkRole newDataSinkRole, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newDataSinkRole,
                AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDataSinkRole(final DataSinkRole newDataSinkRole) {
        this.eDynamicSet(AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE,
                AbstractPackage.Literals.DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE, newDataSinkRole);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE:
            final DataSourceRole dataSourceRole = this.basicGetDataSourceRole();
            if (dataSourceRole != null) {
                msgs = ((InternalEObject) dataSourceRole).eInverseRemove(this,
                        RepositoryPackage.DATA_SOURCE_ROLE__DATA_SOURCE_SINK_CONNECTORS, DataSourceRole.class, msgs);
            }
            return this.basicSetDataSourceRole((DataSourceRole) otherEnd, msgs);
        case AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE:
            final DataSinkRole dataSinkRole = this.basicGetDataSinkRole();
            if (dataSinkRole != null) {
                msgs = ((InternalEObject) dataSinkRole).eInverseRemove(this,
                        RepositoryPackage.DATA_SINK_ROLE__DATA_SOURCE_SINK_CONNECTORS, DataSinkRole.class, msgs);
            }
            return this.basicSetDataSinkRole((DataSinkRole) otherEnd, msgs);
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
        case AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE:
            return this.basicSetDataSourceRole(null, msgs);
        case AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE:
            return this.basicSetDataSinkRole(null, msgs);
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
        case AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE:
            if (resolve) {
                return this.getDataSourceRole();
            }
            return this.basicGetDataSourceRole();
        case AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE:
            if (resolve) {
                return this.getDataSinkRole();
            }
            return this.basicGetDataSinkRole();
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
        case AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE:
            this.setDataSourceRole((DataSourceRole) newValue);
            return;
        case AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE:
            this.setDataSinkRole((DataSinkRole) newValue);
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
        case AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE:
            this.setDataSourceRole((DataSourceRole) null);
            return;
        case AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE:
            this.setDataSinkRole((DataSinkRole) null);
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
        case AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE:
            return this.basicGetDataSourceRole() != null;
        case AbstractPackage.DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE:
            return this.basicGetDataSinkRole() != null;
        }
        return super.eIsSet(featureID);
    }

} // DataSourceSinkConnectorImpl
