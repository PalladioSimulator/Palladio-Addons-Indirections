/**
 */
package org.palladiosimulator.indirections.system.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;

import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.system.SystemPackage;

import org.palladiosimulator.pcm.core.entity.impl.InterfaceProvidingRequiringEntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Channel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getDataSinkRoles <em>Data Sink Roles</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getDataSourceRoles <em>Data Source Roles</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DataChannelImpl extends InterfaceProvidingRequiringEntityImpl implements DataChannel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataChannelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystemPackage.Literals.DATA_CHANNEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataSinkRole> getDataSinkRoles() {
		return (EList<DataSinkRole>) ((EList<?>) getProvidedRoles_InterfaceProvidingEntity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataSourceRole> getDataSourceRoles() {
		return (EList<DataSourceRole>) ((EList<?>) getRequiredRoles_InterfaceRequiringEntity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SystemPackage.DATA_CHANNEL__DATA_SINK_ROLES:
			return getDataSinkRoles();
		case SystemPackage.DATA_CHANNEL__DATA_SOURCE_ROLES:
			return getDataSourceRoles();
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
		case SystemPackage.DATA_CHANNEL__DATA_SINK_ROLES:
			getDataSinkRoles().clear();
			getDataSinkRoles().addAll((Collection<? extends DataSinkRole>) newValue);
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
		case SystemPackage.DATA_CHANNEL__DATA_SINK_ROLES:
			getDataSinkRoles().clear();
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
		case SystemPackage.DATA_CHANNEL__DATA_SINK_ROLES:
			return !getDataSinkRoles().isEmpty();
		case SystemPackage.DATA_CHANNEL__DATA_SOURCE_ROLES:
			return !getDataSourceRoles().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataChannelImpl
