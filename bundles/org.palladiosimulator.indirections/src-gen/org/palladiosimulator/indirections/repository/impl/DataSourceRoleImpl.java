/**
 */
package org.palladiosimulator.indirections.repository.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;

import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.repository.RepositoryPackage;

import org.palladiosimulator.pcm.repository.EventGroup;

import org.palladiosimulator.pcm.repository.impl.RequiredRoleImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Source Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.repository.impl.DataSourceRoleImpl#getEventGroup <em>Event Group</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.repository.impl.DataSourceRoleImpl#getDataSourceSinkConnectors <em>Data Source Sink Connectors</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DataSourceRoleImpl extends RequiredRoleImpl implements DataSourceRole {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataSourceRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.DATA_SOURCE_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventGroup getEventGroup() {
		return (EventGroup) eDynamicGet(RepositoryPackage.DATA_SOURCE_ROLE__EVENT_GROUP,
				RepositoryPackage.Literals.DATA_SOURCE_ROLE__EVENT_GROUP, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventGroup basicGetEventGroup() {
		return (EventGroup) eDynamicGet(RepositoryPackage.DATA_SOURCE_ROLE__EVENT_GROUP,
				RepositoryPackage.Literals.DATA_SOURCE_ROLE__EVENT_GROUP, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEventGroup(EventGroup newEventGroup) {
		eDynamicSet(RepositoryPackage.DATA_SOURCE_ROLE__EVENT_GROUP,
				RepositoryPackage.Literals.DATA_SOURCE_ROLE__EVENT_GROUP, newEventGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<DataSourceSinkConnector> getDataSourceSinkConnectors() {
		return (EList<DataSourceSinkConnector>) eDynamicGet(
				RepositoryPackage.DATA_SOURCE_ROLE__DATA_SOURCE_SINK_CONNECTORS,
				RepositoryPackage.Literals.DATA_SOURCE_ROLE__DATA_SOURCE_SINK_CONNECTORS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RepositoryPackage.DATA_SOURCE_ROLE__DATA_SOURCE_SINK_CONNECTORS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDataSourceSinkConnectors())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RepositoryPackage.DATA_SOURCE_ROLE__DATA_SOURCE_SINK_CONNECTORS:
			return ((InternalEList<?>) getDataSourceSinkConnectors()).basicRemove(otherEnd, msgs);
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
		case RepositoryPackage.DATA_SOURCE_ROLE__EVENT_GROUP:
			if (resolve)
				return getEventGroup();
			return basicGetEventGroup();
		case RepositoryPackage.DATA_SOURCE_ROLE__DATA_SOURCE_SINK_CONNECTORS:
			return getDataSourceSinkConnectors();
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
		case RepositoryPackage.DATA_SOURCE_ROLE__EVENT_GROUP:
			setEventGroup((EventGroup) newValue);
			return;
		case RepositoryPackage.DATA_SOURCE_ROLE__DATA_SOURCE_SINK_CONNECTORS:
			getDataSourceSinkConnectors().clear();
			getDataSourceSinkConnectors().addAll((Collection<? extends DataSourceSinkConnector>) newValue);
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
		case RepositoryPackage.DATA_SOURCE_ROLE__EVENT_GROUP:
			setEventGroup((EventGroup) null);
			return;
		case RepositoryPackage.DATA_SOURCE_ROLE__DATA_SOURCE_SINK_CONNECTORS:
			getDataSourceSinkConnectors().clear();
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
		case RepositoryPackage.DATA_SOURCE_ROLE__EVENT_GROUP:
			return basicGetEventGroup() != null;
		case RepositoryPackage.DATA_SOURCE_ROLE__DATA_SOURCE_SINK_CONNECTORS:
			return !getDataSourceSinkConnectors().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataSourceRoleImpl
