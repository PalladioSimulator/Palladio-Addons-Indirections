/**
 */
package org.palladiosimulator.simulizar.indirection.composition.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;

import org.palladiosimulator.pcm.core.composition.impl.ConnectorImpl;

import org.palladiosimulator.pcm.repository.SinkRole;

import org.palladiosimulator.simulizar.indirection.composition.CompositionPackage;
import org.palladiosimulator.simulizar.indirection.composition.DataChannelSinkConnector;

import org.palladiosimulator.simulizar.indirection.system.DataChannel;
import org.palladiosimulator.simulizar.indirection.system.SystemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Channel Sink Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.composition.impl.DataChannelSinkConnectorImpl#getSinkRole <em>Sink Role</em>}</li>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.composition.impl.DataChannelSinkConnectorImpl#getAssemblyContext <em>Assembly Context</em>}</li>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.composition.impl.DataChannelSinkConnectorImpl#getDataChannel <em>Data Channel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataChannelSinkConnectorImpl extends ConnectorImpl implements DataChannelSinkConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataChannelSinkConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SinkRole getSinkRole() {
		return (SinkRole) eDynamicGet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_ROLE,
				CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__SINK_ROLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SinkRole basicGetSinkRole() {
		return (SinkRole) eDynamicGet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_ROLE,
				CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__SINK_ROLE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSinkRole(SinkRole newSinkRole) {
		eDynamicSet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_ROLE,
				CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__SINK_ROLE, newSinkRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssemblyContext getAssemblyContext() {
		return (AssemblyContext) eDynamicGet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT,
				CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext() {
		return (AssemblyContext) eDynamicGet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT,
				CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAssemblyContext(AssemblyContext newAssemblyContext) {
		eDynamicSet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT,
				CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT, newAssemblyContext);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataChannel getDataChannel() {
		return (DataChannel) eDynamicGet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL,
				CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataChannel basicGetDataChannel() {
		return (DataChannel) eDynamicGet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL,
				CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataChannel(DataChannel newDataChannel, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newDataChannel,
				CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataChannel(DataChannel newDataChannel) {
		eDynamicSet(CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL,
				CompositionPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL, newDataChannel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL:
			DataChannel dataChannel = basicGetDataChannel();
			if (dataChannel != null)
				msgs = ((InternalEObject) dataChannel).eInverseRemove(this,
						SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR, DataChannel.class, msgs);
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
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL:
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
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_ROLE:
			if (resolve)
				return getSinkRole();
			return basicGetSinkRole();
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT:
			if (resolve)
				return getAssemblyContext();
			return basicGetAssemblyContext();
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL:
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
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_ROLE:
			setSinkRole((SinkRole) newValue);
			return;
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT:
			setAssemblyContext((AssemblyContext) newValue);
			return;
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL:
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
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_ROLE:
			setSinkRole((SinkRole) null);
			return;
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT:
			setAssemblyContext((AssemblyContext) null);
			return;
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL:
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
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_ROLE:
			return basicGetSinkRole() != null;
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT:
			return basicGetAssemblyContext() != null;
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL:
			return basicGetDataChannel() != null;
		}
		return super.eIsSet(featureID);
	}

} //DataChannelSinkConnectorImpl
