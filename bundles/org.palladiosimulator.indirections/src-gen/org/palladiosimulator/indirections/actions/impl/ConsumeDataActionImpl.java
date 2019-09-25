/**
 */
package org.palladiosimulator.indirections.actions.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.seff.impl.AbstractActionImpl;

import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Consume Data
 * Action</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl#getEventType
 * <em>Event Type</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl#getDataSinkRole
 * <em>Data Sink Role</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl#getVariableReference
 * <em>Variable Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsumeDataActionImpl extends AbstractActionImpl implements ConsumeDataAction {
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
    public EventType getEventType() {
        return (EventType) this.eDynamicGet(ActionsPackage.CONSUME_DATA_ACTION__EVENT_TYPE,
                ActionsPackage.Literals.CONSUME_DATA_ACTION__EVENT_TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EventType basicGetEventType() {
        return (EventType) this.eDynamicGet(ActionsPackage.CONSUME_DATA_ACTION__EVENT_TYPE,
                ActionsPackage.Literals.CONSUME_DATA_ACTION__EVENT_TYPE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEventType(final EventType newEventType) {
        this.eDynamicSet(ActionsPackage.CONSUME_DATA_ACTION__EVENT_TYPE,
                ActionsPackage.Literals.CONSUME_DATA_ACTION__EVENT_TYPE, newEventType);
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
    public VariableReference getVariableReference() {
        return (VariableReference) this.eDynamicGet(ActionsPackage.CONSUME_DATA_ACTION__VARIABLE_REFERENCE,
                ActionsPackage.Literals.CONSUME_DATA_ACTION__VARIABLE_REFERENCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetVariableReference(final VariableReference newVariableReference,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newVariableReference,
                ActionsPackage.CONSUME_DATA_ACTION__VARIABLE_REFERENCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setVariableReference(final VariableReference newVariableReference) {
        this.eDynamicSet(ActionsPackage.CONSUME_DATA_ACTION__VARIABLE_REFERENCE,
                ActionsPackage.Literals.CONSUME_DATA_ACTION__VARIABLE_REFERENCE, newVariableReference);
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
        case ActionsPackage.CONSUME_DATA_ACTION__VARIABLE_REFERENCE:
            return this.basicSetVariableReference(null, msgs);
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
        case ActionsPackage.CONSUME_DATA_ACTION__EVENT_TYPE:
            if (resolve) {
                return this.getEventType();
            }
            return this.basicGetEventType();
        case ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE:
            if (resolve) {
                return this.getDataSinkRole();
            }
            return this.basicGetDataSinkRole();
        case ActionsPackage.CONSUME_DATA_ACTION__VARIABLE_REFERENCE:
            return this.getVariableReference();
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
        case ActionsPackage.CONSUME_DATA_ACTION__EVENT_TYPE:
            this.setEventType((EventType) newValue);
            return;
        case ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE:
            this.setDataSinkRole((DataSinkRole) newValue);
            return;
        case ActionsPackage.CONSUME_DATA_ACTION__VARIABLE_REFERENCE:
            this.setVariableReference((VariableReference) newValue);
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
        case ActionsPackage.CONSUME_DATA_ACTION__EVENT_TYPE:
            this.setEventType((EventType) null);
            return;
        case ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE:
            this.setDataSinkRole((DataSinkRole) null);
            return;
        case ActionsPackage.CONSUME_DATA_ACTION__VARIABLE_REFERENCE:
            this.setVariableReference((VariableReference) null);
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
        case ActionsPackage.CONSUME_DATA_ACTION__EVENT_TYPE:
            return this.basicGetEventType() != null;
        case ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE:
            return this.basicGetDataSinkRole() != null;
        case ActionsPackage.CONSUME_DATA_ACTION__VARIABLE_REFERENCE:
            return this.getVariableReference() != null;
        }
        return super.eIsSet(featureID);
    }

} // ConsumeDataActionImpl
