/**
 */
package org.palladiosimulator.indirections.repository.impl;

import org.eclipse.emf.ecore.EClass;

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
 * </ul>
 *
 * @generated
 */
public class DataSourceRoleImpl extends RequiredRoleImpl implements DataSourceRole {
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RepositoryPackage.DATA_SOURCE_ROLE__EVENT_GROUP:
			if (resolve)
				return getEventGroup();
			return basicGetEventGroup();
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
		case RepositoryPackage.DATA_SOURCE_ROLE__EVENT_GROUP:
			setEventGroup((EventGroup) newValue);
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
		}
		return super.eIsSet(featureID);
	}

} //DataSourceRoleImpl
