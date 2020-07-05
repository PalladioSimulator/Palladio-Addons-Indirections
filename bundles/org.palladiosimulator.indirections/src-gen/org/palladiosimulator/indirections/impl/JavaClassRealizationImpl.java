/**
 */
package org.palladiosimulator.indirections.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.indirections.IndirectionsPackage;
import org.palladiosimulator.indirections.JavaClassRealization;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Java Class
 * Realization</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.impl.JavaClassRealizationImpl#getRealizingClassFqn
 * <em>Realizing Class Fqn</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.impl.JavaClassRealizationImpl#getConfigEntries
 * <em>Config Entries</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class JavaClassRealizationImpl extends CDOObjectImpl implements JavaClassRealization {
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
    protected JavaClassRealizationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IndirectionsPackage.Literals.JAVA_CLASS_REALIZATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getRealizingClassFqn() {
        return (String) this.eDynamicGet(IndirectionsPackage.JAVA_CLASS_REALIZATION__REALIZING_CLASS_FQN,
                IndirectionsPackage.Literals.JAVA_CLASS_REALIZATION__REALIZING_CLASS_FQN, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRealizingClassFqn(final String newRealizingClassFqn) {
        this.eDynamicSet(IndirectionsPackage.JAVA_CLASS_REALIZATION__REALIZING_CLASS_FQN,
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
        return (EList<String>) this.eDynamicGet(IndirectionsPackage.JAVA_CLASS_REALIZATION__CONFIG_ENTRIES,
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
        case IndirectionsPackage.JAVA_CLASS_REALIZATION__REALIZING_CLASS_FQN:
            return this.getRealizingClassFqn();
        case IndirectionsPackage.JAVA_CLASS_REALIZATION__CONFIG_ENTRIES:
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
        case IndirectionsPackage.JAVA_CLASS_REALIZATION__REALIZING_CLASS_FQN:
            this.setRealizingClassFqn((String) newValue);
            return;
        case IndirectionsPackage.JAVA_CLASS_REALIZATION__CONFIG_ENTRIES:
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
        case IndirectionsPackage.JAVA_CLASS_REALIZATION__REALIZING_CLASS_FQN:
            this.setRealizingClassFqn(REALIZING_CLASS_FQN_EDEFAULT);
            return;
        case IndirectionsPackage.JAVA_CLASS_REALIZATION__CONFIG_ENTRIES:
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
        case IndirectionsPackage.JAVA_CLASS_REALIZATION__REALIZING_CLASS_FQN:
            return REALIZING_CLASS_FQN_EDEFAULT == null ? this.getRealizingClassFqn() != null
                    : !REALIZING_CLASS_FQN_EDEFAULT.equals(this.getRealizingClassFqn());
        case IndirectionsPackage.JAVA_CLASS_REALIZATION__CONFIG_ENTRIES:
            return !this.getConfigEntries()
                .isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // JavaClassRealizationImpl
