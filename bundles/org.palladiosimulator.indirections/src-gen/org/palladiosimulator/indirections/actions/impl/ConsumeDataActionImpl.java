/**
 */
package org.palladiosimulator.indirections.actions.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.repository.DataSinkRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Consume Data
 * Action</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl#getDataSinkRole
 * <em>Data Sink Role</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsumeDataActionImpl extends DataActionImpl implements ConsumeDataAction {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ConsumeDataActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ActionsPackage.Literals.CONSUME_DATA_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DataSinkRole getDataSinkRole() {
        return (DataSinkRole) this.eDynamicGet(ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE,
                ActionsPackage.Literals.CONSUME_DATA_ACTION__DATA_SINK_ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public DataSinkRole basicGetDataSinkRole() {
        return (DataSinkRole) this.eDynamicGet(ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE,
                ActionsPackage.Literals.CONSUME_DATA_ACTION__DATA_SINK_ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDataSinkRole(final DataSinkRole newDataSinkRole) {
        this.eDynamicSet(ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE,
                ActionsPackage.Literals.CONSUME_DATA_ACTION__DATA_SINK_ROLE, newDataSinkRole);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE:
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
        case ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE:
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
        case ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE:
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
        case ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE:
            return this.basicGetDataSinkRole() != null;
        }
        return super.eIsSet(featureID);
    }

} // ConsumeDataActionImpl
