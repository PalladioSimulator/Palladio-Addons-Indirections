/**
 */
package org.palladiosimulator.indirections.actions.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.repository.DataSourceRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Emit Data Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl#getDataSourceRole
 * <em>Data Source Role</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EmitDataActionImpl extends DataActionImpl implements EmitDataAction {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected EmitDataActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ActionsPackage.Literals.EMIT_DATA_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DataSourceRole getDataSourceRole() {
        return (DataSourceRole) this.eDynamicGet(ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE,
                ActionsPackage.Literals.EMIT_DATA_ACTION__DATA_SOURCE_ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public DataSourceRole basicGetDataSourceRole() {
        return (DataSourceRole) this.eDynamicGet(ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE,
                ActionsPackage.Literals.EMIT_DATA_ACTION__DATA_SOURCE_ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDataSourceRole(final DataSourceRole newDataSourceRole) {
        this.eDynamicSet(ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE,
                ActionsPackage.Literals.EMIT_DATA_ACTION__DATA_SOURCE_ROLE, newDataSourceRole);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE:
            if (resolve) {
                return this.getDataSourceRole();
            }
            return this.basicGetDataSourceRole();
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
        case ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE:
            this.setDataSourceRole((DataSourceRole) newValue);
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
        case ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE:
            this.setDataSourceRole((DataSourceRole) null);
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
        case ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE:
            return this.basicGetDataSourceRole() != null;
        }
        return super.eIsSet(featureID);
    }

} // EmitDataActionImpl
