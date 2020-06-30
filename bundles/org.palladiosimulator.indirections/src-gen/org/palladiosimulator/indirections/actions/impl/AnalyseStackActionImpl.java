/**
 */
package org.palladiosimulator.indirections.actions.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.pcm.seff.impl.AbstractActionImpl;

import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Analyse Stack
 * Action</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.actions.impl.AnalyseStackActionImpl#getVariableReference
 * <em>Variable Reference</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.actions.impl.AnalyseStackActionImpl#getMeasurementIdentificationKey
 * <em>Measurement Identification Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnalyseStackActionImpl extends AbstractActionImpl implements AnalyseStackAction {
    /**
     * The default value of the '{@link #getMeasurementIdentificationKey() <em>Measurement
     * Identification Key</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMeasurementIdentificationKey()
     * @generated
     * @ordered
     */
    protected static final String MEASUREMENT_IDENTIFICATION_KEY_EDEFAULT = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AnalyseStackActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ActionsPackage.Literals.ANALYSE_STACK_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public VariableReference getVariableReference() {
        return (VariableReference) this.eDynamicGet(ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE,
                ActionsPackage.Literals.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetVariableReference(final VariableReference newVariableReference,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newVariableReference,
                ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setVariableReference(final VariableReference newVariableReference) {
        this.eDynamicSet(ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE,
                ActionsPackage.Literals.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE, newVariableReference);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getMeasurementIdentificationKey() {
        return (String) this.eDynamicGet(ActionsPackage.ANALYSE_STACK_ACTION__MEASUREMENT_IDENTIFICATION_KEY,
                ActionsPackage.Literals.ANALYSE_STACK_ACTION__MEASUREMENT_IDENTIFICATION_KEY, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setMeasurementIdentificationKey(final String newMeasurementIdentificationKey) {
        this.eDynamicSet(ActionsPackage.ANALYSE_STACK_ACTION__MEASUREMENT_IDENTIFICATION_KEY,
                ActionsPackage.Literals.ANALYSE_STACK_ACTION__MEASUREMENT_IDENTIFICATION_KEY,
                newMeasurementIdentificationKey);
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
        case ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE:
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
        case ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE:
            return this.getVariableReference();
        case ActionsPackage.ANALYSE_STACK_ACTION__MEASUREMENT_IDENTIFICATION_KEY:
            return this.getMeasurementIdentificationKey();
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
        case ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE:
            this.setVariableReference((VariableReference) newValue);
            return;
        case ActionsPackage.ANALYSE_STACK_ACTION__MEASUREMENT_IDENTIFICATION_KEY:
            this.setMeasurementIdentificationKey((String) newValue);
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
        case ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE:
            this.setVariableReference((VariableReference) null);
            return;
        case ActionsPackage.ANALYSE_STACK_ACTION__MEASUREMENT_IDENTIFICATION_KEY:
            this.setMeasurementIdentificationKey(MEASUREMENT_IDENTIFICATION_KEY_EDEFAULT);
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
        case ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE:
            return this.getVariableReference() != null;
        case ActionsPackage.ANALYSE_STACK_ACTION__MEASUREMENT_IDENTIFICATION_KEY:
            return MEASUREMENT_IDENTIFICATION_KEY_EDEFAULT == null ? this.getMeasurementIdentificationKey() != null
                    : !MEASUREMENT_IDENTIFICATION_KEY_EDEFAULT.equals(this.getMeasurementIdentificationKey());
        }
        return super.eIsSet(featureID);
    }

} // AnalyseStackActionImpl
