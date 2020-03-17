/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;

import org.palladiosimulator.indirections.repository.DataSourceRole;

import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.system.SystemPackage;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;

import org.palladiosimulator.pcm.core.composition.impl.ConnectorImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Channel Source Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.composition.impl.DataChannelSourceConnectorImpl#getDataSourceRole <em>Data Source Role</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.composition.impl.DataChannelSourceConnectorImpl#getAssemblyContext <em>Assembly Context</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.composition.impl.DataChannelSourceConnectorImpl#getDataChannel <em>Data Channel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataChannelSourceConnectorImpl extends ConnectorImpl implements DataChannelSourceConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataChannelSourceConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataSourceRole getDataSourceRole() {
		return (DataSourceRole) eDynamicGet(CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE,
				CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSourceRole basicGetDataSourceRole() {
		return (DataSourceRole) eDynamicGet(CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE,
				CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataSourceRole(DataSourceRole newDataSourceRole) {
		eDynamicSet(CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE,
				CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE, newDataSourceRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssemblyContext getAssemblyContext() {
		return (AssemblyContext) eDynamicGet(CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT,
				CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext() {
		return (AssemblyContext) eDynamicGet(CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT,
				CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAssemblyContext(AssemblyContext newAssemblyContext) {
		eDynamicSet(CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT,
				CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT, newAssemblyContext);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataChannel getDataChannel() {
		return (DataChannel) eDynamicGet(CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL,
				CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataChannel basicGetDataChannel() {
		return (DataChannel) eDynamicGet(CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL,
				CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataChannel(DataChannel newDataChannel, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newDataChannel,
				CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataChannel(DataChannel newDataChannel) {
		eDynamicSet(CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL,
				CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL, newDataChannel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL:
			DataChannel dataChannel = basicGetDataChannel();
			if (dataChannel != null)
				msgs = ((InternalEObject) dataChannel).eInverseRemove(this,
						SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR, DataChannel.class, msgs);
			return basicSetDataChannel((DataChannel) otherEnd, msgs);
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
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL:
			return basicSetDataChannel(null, msgs);
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
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE:
			if (resolve)
				return getDataSourceRole();
			return basicGetDataSourceRole();
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT:
			if (resolve)
				return getAssemblyContext();
			return basicGetAssemblyContext();
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL:
			if (resolve)
				return getDataChannel();
			return basicGetDataChannel();
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
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE:
			setDataSourceRole((DataSourceRole) newValue);
			return;
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT:
			setAssemblyContext((AssemblyContext) newValue);
			return;
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL:
			setDataChannel((DataChannel) newValue);
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
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE:
			setDataSourceRole((DataSourceRole) null);
			return;
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT:
			setAssemblyContext((AssemblyContext) null);
			return;
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL:
			setDataChannel((DataChannel) null);
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
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE:
			return basicGetDataSourceRole() != null;
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT:
			return basicGetAssemblyContext() != null;
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL:
			return basicGetDataChannel() != null;
		}
		return super.eIsSet(featureID);
	}

} //DataChannelSourceConnectorImpl
