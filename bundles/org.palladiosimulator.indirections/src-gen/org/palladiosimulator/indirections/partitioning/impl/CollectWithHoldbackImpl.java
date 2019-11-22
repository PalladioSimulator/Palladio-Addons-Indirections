/**
 */
package org.palladiosimulator.indirections.partitioning.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.indirections.partitioning.CollectWithHoldback;
import org.palladiosimulator.indirections.partitioning.PartitioningPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Collect With
 * Holdback</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.partitioning.impl.CollectWithHoldbackImpl#getHoldback
 * <em>Holdback</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.partitioning.impl.CollectWithHoldbackImpl#getKey
 * <em>Key</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.partitioning.impl.CollectWithHoldbackImpl#getPartitionDataName
 * <em>Partition Data Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectWithHoldbackImpl extends CDOObjectImpl implements CollectWithHoldback {
    /**
     * The default value of the '{@link #getHoldback() <em>Holdback</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getHoldback()
     * @generated
     * @ordered
     */
    protected static final int HOLDBACK_EDEFAULT = 1;

    /**
     * The default value of the '{@link #getKey() <em>Key</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getKey()
     * @generated
     * @ordered
     */
    protected static final String KEY_EDEFAULT = null;

    /**
     * The default value of the '{@link #getPartitionDataName() <em>Partition Data Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPartitionDataName()
     * @generated
     * @ordered
     */
    protected static final String PARTITION_DATA_NAME_EDEFAULT = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected CollectWithHoldbackImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PartitioningPackage.Literals.COLLECT_WITH_HOLDBACK;
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
    public int getHoldback() {
        return (Integer) this.eDynamicGet(PartitioningPackage.COLLECT_WITH_HOLDBACK__HOLDBACK,
                PartitioningPackage.Literals.COLLECT_WITH_HOLDBACK__HOLDBACK, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setHoldback(final int newHoldback) {
        this.eDynamicSet(PartitioningPackage.COLLECT_WITH_HOLDBACK__HOLDBACK,
                PartitioningPackage.Literals.COLLECT_WITH_HOLDBACK__HOLDBACK, newHoldback);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getKey() {
        return (String) this.eDynamicGet(PartitioningPackage.COLLECT_WITH_HOLDBACK__KEY,
                PartitioningPackage.Literals.COLLECT_WITH_HOLDBACK__KEY, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setKey(final String newKey) {
        this.eDynamicSet(PartitioningPackage.COLLECT_WITH_HOLDBACK__KEY,
                PartitioningPackage.Literals.COLLECT_WITH_HOLDBACK__KEY, newKey);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getPartitionDataName() {
        return (String) this.eDynamicGet(PartitioningPackage.COLLECT_WITH_HOLDBACK__PARTITION_DATA_NAME,
                PartitioningPackage.Literals.COLLECT_WITH_HOLDBACK__PARTITION_DATA_NAME, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPartitionDataName(final String newPartitionDataName) {
        this.eDynamicSet(PartitioningPackage.COLLECT_WITH_HOLDBACK__PARTITION_DATA_NAME,
                PartitioningPackage.Literals.COLLECT_WITH_HOLDBACK__PARTITION_DATA_NAME, newPartitionDataName);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PartitioningPackage.COLLECT_WITH_HOLDBACK__HOLDBACK:
            return this.getHoldback();
        case PartitioningPackage.COLLECT_WITH_HOLDBACK__KEY:
            return this.getKey();
        case PartitioningPackage.COLLECT_WITH_HOLDBACK__PARTITION_DATA_NAME:
            return this.getPartitionDataName();
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
        case PartitioningPackage.COLLECT_WITH_HOLDBACK__HOLDBACK:
            this.setHoldback((Integer) newValue);
            return;
        case PartitioningPackage.COLLECT_WITH_HOLDBACK__KEY:
            this.setKey((String) newValue);
            return;
        case PartitioningPackage.COLLECT_WITH_HOLDBACK__PARTITION_DATA_NAME:
            this.setPartitionDataName((String) newValue);
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
        case PartitioningPackage.COLLECT_WITH_HOLDBACK__HOLDBACK:
            this.setHoldback(HOLDBACK_EDEFAULT);
            return;
        case PartitioningPackage.COLLECT_WITH_HOLDBACK__KEY:
            this.setKey(KEY_EDEFAULT);
            return;
        case PartitioningPackage.COLLECT_WITH_HOLDBACK__PARTITION_DATA_NAME:
            this.setPartitionDataName(PARTITION_DATA_NAME_EDEFAULT);
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
        case PartitioningPackage.COLLECT_WITH_HOLDBACK__HOLDBACK:
            return this.getHoldback() != HOLDBACK_EDEFAULT;
        case PartitioningPackage.COLLECT_WITH_HOLDBACK__KEY:
            return KEY_EDEFAULT == null ? this.getKey() != null : !KEY_EDEFAULT.equals(this.getKey());
        case PartitioningPackage.COLLECT_WITH_HOLDBACK__PARTITION_DATA_NAME:
            return PARTITION_DATA_NAME_EDEFAULT == null ? this.getPartitionDataName() != null
                    : !PARTITION_DATA_NAME_EDEFAULT.equals(this.getPartitionDataName());
        }
        return super.eIsSet(featureID);
    }

} // CollectWithHoldbackImpl
