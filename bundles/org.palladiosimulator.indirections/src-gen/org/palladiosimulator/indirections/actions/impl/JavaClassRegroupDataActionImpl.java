/**
 */
package org.palladiosimulator.indirections.actions.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.indirections.IndirectionsPackage;
import org.palladiosimulator.indirections.JavaClassRealization;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.JavaClassRegroupDataAction;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Java Class Regroup Data
 * Action</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.actions.impl.JavaClassRegroupDataActionImpl#getRealizingClassFqn
 * <em>Realizing Class Fqn</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.actions.impl.JavaClassRegroupDataActionImpl#getConfigEntries
 * <em>Config Entries</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JavaClassRegroupDataActionImpl extends RegroupDataActionImpl implements JavaClassRegroupDataAction {
    /**
     * The default value of the '{@link #getRealizingClassFqn() <em>Realizing Class Fqn</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRealizingClassFqn()
     * @generated
     * @ordered
     */
    protected static final String REALIZING_CLASS_FQN_EDEFAULT = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected JavaClassRegroupDataActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ActionsPackage.Literals.JAVA_CLASS_REGROUP_DATA_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getRealizingClassFqn() {
        return (String) this.eDynamicGet(ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__REALIZING_CLASS_FQN,
                IndirectionsPackage.Literals.JAVA_CLASS_REALIZATION__REALIZING_CLASS_FQN, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRealizingClassFqn(final String newRealizingClassFqn) {
        this.eDynamicSet(ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__REALIZING_CLASS_FQN,
                IndirectionsPackage.Literals.JAVA_CLASS_REALIZATION__REALIZING_CLASS_FQN, newRealizingClassFqn);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<String> getConfigEntries() {
        return (EList<String>) this.eDynamicGet(ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__CONFIG_ENTRIES,
                IndirectionsPackage.Literals.JAVA_CLASS_REALIZATION__CONFIG_ENTRIES, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__REALIZING_CLASS_FQN:
            return this.getRealizingClassFqn();
        case ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__CONFIG_ENTRIES:
            return this.getConfigEntries();
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
        case ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__REALIZING_CLASS_FQN:
            this.setRealizingClassFqn((String) newValue);
            return;
        case ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__CONFIG_ENTRIES:
            this.getConfigEntries()
                .clear();
            this.getConfigEntries()
                .addAll((Collection<? extends String>) newValue);
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
        case ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__REALIZING_CLASS_FQN:
            this.setRealizingClassFqn(REALIZING_CLASS_FQN_EDEFAULT);
            return;
        case ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__CONFIG_ENTRIES:
            this.getConfigEntries()
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
        case ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__REALIZING_CLASS_FQN:
            return REALIZING_CLASS_FQN_EDEFAULT == null ? this.getRealizingClassFqn() != null
                    : !REALIZING_CLASS_FQN_EDEFAULT.equals(this.getRealizingClassFqn());
        case ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__CONFIG_ENTRIES:
            return !this.getConfigEntries()
                .isEmpty();
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
        if (baseClass == JavaClassRealization.class) {
            switch (derivedFeatureID) {
            case ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__REALIZING_CLASS_FQN:
                return IndirectionsPackage.JAVA_CLASS_REALIZATION__REALIZING_CLASS_FQN;
            case ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__CONFIG_ENTRIES:
                return IndirectionsPackage.JAVA_CLASS_REALIZATION__CONFIG_ENTRIES;
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
        if (baseClass == JavaClassRealization.class) {
            switch (baseFeatureID) {
            case IndirectionsPackage.JAVA_CLASS_REALIZATION__REALIZING_CLASS_FQN:
                return ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__REALIZING_CLASS_FQN;
            case IndirectionsPackage.JAVA_CLASS_REALIZATION__CONFIG_ENTRIES:
                return ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION__CONFIG_ENTRIES;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // JavaClassRegroupDataActionImpl
