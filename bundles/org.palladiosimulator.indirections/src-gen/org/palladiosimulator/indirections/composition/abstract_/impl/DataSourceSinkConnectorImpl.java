/**
 */
package org.palladiosimulator.indirections.composition.abstract_.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
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
