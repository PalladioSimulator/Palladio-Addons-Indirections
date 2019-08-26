/**
 */
package org.palladiosimulator.simulizar.indirection.partitioning.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.pcm.core.PCMRandomVariable;

import org.palladiosimulator.pcm.core.entity.impl.NamedElementImpl;

import org.palladiosimulator.simulizar.indirection.partitioning.Partitioning;
import org.palladiosimulator.simulizar.indirection.partitioning.PartitioningPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partitioning</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.partitioning.impl.PartitioningImpl#getSpecification <em>Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PartitioningImpl extends NamedElementImpl implements Partitioning {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartitioningImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PartitioningPackage.Literals.PARTITIONING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<PCMRandomVariable> getSpecification() {
		return (EList<PCMRandomVariable>) eDynamicGet(PartitioningPackage.PARTITIONING__SPECIFICATION,
				PartitioningPackage.Literals.PARTITIONING__SPECIFICATION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case PartitioningPackage.PARTITIONING__SPECIFICATION:
			return ((InternalEList<?>) getSpecification()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case PartitioningPackage.PARTITIONING__SPECIFICATION:
			return getSpecification();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case PartitioningPackage.PARTITIONING__SPECIFICATION:
			getSpecification().clear();
			getSpecification().addAll((Collection<? extends PCMRandomVariable>) newValue);
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
		case PartitioningPackage.PARTITIONING__SPECIFICATION:
			getSpecification().clear();
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
		case PartitioningPackage.PARTITIONING__SPECIFICATION:
			return !getSpecification().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PartitioningImpl
