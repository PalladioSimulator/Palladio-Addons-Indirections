/**
 */
package org.palladiosimulator.indirections.system.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.indirections.system.SystemPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Java Class Data
 * Channel</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.system.impl.JavaClassDataChannelImpl#getRealizingClassFqn
 * <em>Realizing Class Fqn</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.impl.JavaClassDataChannelImpl#getConfigEntries
 * <em>Config Entries</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JavaClassDataChannelImpl extends DataChannelImpl implements JavaClassDataChannel {
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
    protected JavaClassDataChannelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SystemPackage.Literals.JAVA_CLASS_DATA_CHANNEL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getRealizingClassFqn() {
        return (String) this.eDynamicGet(SystemPackage.JAVA_CLASS_DATA_CHANNEL__REALIZING_CLASS_FQN,
                SystemPackage.Literals.JAVA_CLASS_DATA_CHANNEL__REALIZING_CLASS_FQN, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRealizingClassFqn(final String newRealizingClassFqn) {
        this.eDynamicSet(SystemPackage.JAVA_CLASS_DATA_CHANNEL__REALIZING_CLASS_FQN,
                SystemPackage.Literals.JAVA_CLASS_DATA_CHANNEL__REALIZING_CLASS_FQN, newRealizingClassFqn);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<String> getConfigEntries() {
        return (EList<String>) this.eDynamicGet(SystemPackage.JAVA_CLASS_DATA_CHANNEL__CONFIG_ENTRIES,
                SystemPackage.Literals.JAVA_CLASS_DATA_CHANNEL__CONFIG_ENTRIES, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SystemPackage.JAVA_CLASS_DATA_CHANNEL__REALIZING_CLASS_FQN:
            return this.getRealizingClassFqn();
        case SystemPackage.JAVA_CLASS_DATA_CHANNEL__CONFIG_ENTRIES:
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
        case SystemPackage.JAVA_CLASS_DATA_CHANNEL__REALIZING_CLASS_FQN:
            this.setRealizingClassFqn((String) newValue);
            return;
        case SystemPackage.JAVA_CLASS_DATA_CHANNEL__CONFIG_ENTRIES:
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
        case SystemPackage.JAVA_CLASS_DATA_CHANNEL__REALIZING_CLASS_FQN:
            this.setRealizingClassFqn(REALIZING_CLASS_FQN_EDEFAULT);
            return;
        case SystemPackage.JAVA_CLASS_DATA_CHANNEL__CONFIG_ENTRIES:
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
        case SystemPackage.JAVA_CLASS_DATA_CHANNEL__REALIZING_CLASS_FQN:
            return REALIZING_CLASS_FQN_EDEFAULT == null ? this.getRealizingClassFqn() != null
                    : !REALIZING_CLASS_FQN_EDEFAULT.equals(this.getRealizingClassFqn());
        case SystemPackage.JAVA_CLASS_DATA_CHANNEL__CONFIG_ENTRIES:
            return !this.getConfigEntries()
                .isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // JavaClassDataChannelImpl
