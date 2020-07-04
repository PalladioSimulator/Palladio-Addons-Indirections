/**
 */
package org.palladiosimulator.indirections.actions.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Analyse Stack
 * Action</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.actions.impl.AnalyseStackActionImpl#getMeasurementIdentificationKey
 * <em>Measurement Identification Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnalyseStackActionImpl extends DataActionImpl implements AnalyseStackAction {
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
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
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
        case ActionsPackage.ANALYSE_STACK_ACTION__MEASUREMENT_IDENTIFICATION_KEY:
            return MEASUREMENT_IDENTIFICATION_KEY_EDEFAULT == null ? this.getMeasurementIdentificationKey() != null
                    : !MEASUREMENT_IDENTIFICATION_KEY_EDEFAULT.equals(this.getMeasurementIdentificationKey());
        }
        return super.eIsSet(featureID);
    }

} // AnalyseStackActionImpl
