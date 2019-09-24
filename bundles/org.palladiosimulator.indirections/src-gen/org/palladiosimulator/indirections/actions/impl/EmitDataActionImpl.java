/**
 */
package org.palladiosimulator.indirections.actions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.seff.CallAction;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.seff.impl.AbstractActionImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Emit Data Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl#getInputVariableUsages__CallAction
 * <em>Input Variable Usages Call Action</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl#getEventType
 * <em>Event Type</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl#getDataSourceRole
 * <em>Data Source Role</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EmitDataActionImpl extends AbstractActionImpl implements EmitDataAction {
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
    @SuppressWarnings("unchecked")
    @Override
    public EList<VariableUsage> getInputVariableUsages__CallAction() {
        return (EList<VariableUsage>) this.eDynamicGet(
                ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION,
                SeffPackage.Literals.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EventType getEventType() {
        return (EventType) this.eDynamicGet(ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE,
                ActionsPackage.Literals.EMIT_DATA_ACTION__EVENT_TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EventType basicGetEventType() {
        return (EventType) this.eDynamicGet(ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE,
                ActionsPackage.Literals.EMIT_DATA_ACTION__EVENT_TYPE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEventType(final EventType newEventType) {
        this.eDynamicSet(ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE,
                ActionsPackage.Literals.EMIT_DATA_ACTION__EVENT_TYPE,
                newEventType);
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
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getInputVariableUsages__CallAction())
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
        case ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            return ((InternalEList<?>) this.getInputVariableUsages__CallAction()).basicRemove(otherEnd, msgs);
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
        case ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            return this.getInputVariableUsages__CallAction();
        case ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE:
            if (resolve) {
                return this.getEventType();
            }
            return this.basicGetEventType();
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
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            this.getInputVariableUsages__CallAction().clear();
            this.getInputVariableUsages__CallAction().addAll((Collection<? extends VariableUsage>) newValue);
            return;
        case ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE:
            this.setEventType((EventType) newValue);
            return;
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
        case ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            this.getInputVariableUsages__CallAction().clear();
            return;
        case ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE:
            this.setEventType((EventType) null);
            return;
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
        case ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            return !this.getInputVariableUsages__CallAction().isEmpty();
        case ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE:
            return this.basicGetEventType() != null;
        case ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE:
            return this.basicGetDataSourceRole() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(final int derivedFeatureID, final Class<?> baseClass) {
        if (baseClass == CallAction.class) {
            switch (derivedFeatureID) {
            case ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
                return SeffPackage.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(final int baseFeatureID, final Class<?> baseClass) {
        if (baseClass == CallAction.class) {
            switch (baseFeatureID) {
            case SeffPackage.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
                return ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // EmitDataActionImpl
