/**
 */
package org.palladiosimulator.indirections.actions.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.DataAction;
import org.palladiosimulator.pcm.seff.impl.AbstractActionImpl;

import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Data Action</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.actions.impl.DataActionImpl#getVariableReference
 * <em>Variable Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DataActionImpl extends AbstractActionImpl implements DataAction {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected DataActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ActionsPackage.Literals.DATA_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public VariableReference getVariableReference() {
        return (VariableReference) this.eDynamicGet(ActionsPackage.DATA_ACTION__VARIABLE_REFERENCE,
                ActionsPackage.Literals.DATA_ACTION__VARIABLE_REFERENCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetVariableReference(final VariableReference newVariableReference,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newVariableReference,
                ActionsPackage.DATA_ACTION__VARIABLE_REFERENCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setVariableReference(final VariableReference newVariableReference) {
        this.eDynamicSet(ActionsPackage.DATA_ACTION__VARIABLE_REFERENCE,
                ActionsPackage.Literals.DATA_ACTION__VARIABLE_REFERENCE, newVariableReference);
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
        case ActionsPackage.DATA_ACTION__VARIABLE_REFERENCE:
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
        case ActionsPackage.DATA_ACTION__VARIABLE_REFERENCE:
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
        case ActionsPackage.DATA_ACTION__VARIABLE_REFERENCE:
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
        case ActionsPackage.DATA_ACTION__VARIABLE_REFERENCE:
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
        case ActionsPackage.DATA_ACTION__VARIABLE_REFERENCE:
            return this.getVariableReference() != null;
        }
        return super.eIsSet(featureID);
    }

} // DataActionImpl
