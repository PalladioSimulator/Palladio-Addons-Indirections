/**
 */
package org.palladiosimulator.indirections.partitioning.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.palladiosimulator.indirections.partitioning.CollectWithHoldback;
import org.palladiosimulator.indirections.partitioning.PartitioningPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collect With Holdback</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.partitioning.impl.CollectWithHoldbackImpl#getHoldback <em>Holdback</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.partitioning.impl.CollectWithHoldbackImpl#getKey <em>Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectWithHoldbackImpl extends CDOObjectImpl implements CollectWithHoldback {
	/**
	 * The default value of the '{@link #getHoldback() <em>Holdback</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHoldback()
	 * @generated
	 * @ordered
	 */
	protected static final int HOLDBACK_EDEFAULT = 1;

	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectWithHoldbackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PartitioningPackage.Literals.COLLECT_WITH_HOLDBACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHoldback() {
		return (Integer) eDynamicGet(PartitioningPackage.COLLECT_WITH_HOLDBACK__HOLDBACK,
				PartitioningPackage.Literals.COLLECT_WITH_HOLDBACK__HOLDBACK, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHoldback(int newHoldback) {
		eDynamicSet(PartitioningPackage.COLLECT_WITH_HOLDBACK__HOLDBACK,
				PartitioningPackage.Literals.COLLECT_WITH_HOLDBACK__HOLDBACK, newHoldback);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getKey() {
		return (String) eDynamicGet(PartitioningPackage.COLLECT_WITH_HOLDBACK__KEY,
				PartitioningPackage.Literals.COLLECT_WITH_HOLDBACK__KEY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKey(String newKey) {
		eDynamicSet(PartitioningPackage.COLLECT_WITH_HOLDBACK__KEY,
				PartitioningPackage.Literals.COLLECT_WITH_HOLDBACK__KEY, newKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case PartitioningPackage.COLLECT_WITH_HOLDBACK__HOLDBACK:
			return getHoldback();
		case PartitioningPackage.COLLECT_WITH_HOLDBACK__KEY:
			return getKey();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case PartitioningPackage.COLLECT_WITH_HOLDBACK__HOLDBACK:
			setHoldback((Integer) newValue);
			return;
		case PartitioningPackage.COLLECT_WITH_HOLDBACK__KEY:
			setKey((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case PartitioningPackage.COLLECT_WITH_HOLDBACK__HOLDBACK:
			setHoldback(HOLDBACK_EDEFAULT);
			return;
		case PartitioningPackage.COLLECT_WITH_HOLDBACK__KEY:
			setKey(KEY_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case PartitioningPackage.COLLECT_WITH_HOLDBACK__HOLDBACK:
			return getHoldback() != HOLDBACK_EDEFAULT;
		case PartitioningPackage.COLLECT_WITH_HOLDBACK__KEY:
			return KEY_EDEFAULT == null ? getKey() != null : !KEY_EDEFAULT.equals(getKey());
		}
		return super.eIsSet(featureID);
	}

} //CollectWithHoldbackImpl
