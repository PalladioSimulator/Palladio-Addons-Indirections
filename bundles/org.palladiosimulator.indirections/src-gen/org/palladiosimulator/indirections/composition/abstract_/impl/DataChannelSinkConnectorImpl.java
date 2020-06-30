/**
 */
package org.palladiosimulator.indirections.composition.abstract_.impl;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;

import org.palladiosimulator.indirections.system.DataChannel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Channel Sink Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.composition.abstract_.impl.DataChannelSinkConnectorImpl#getSinkDataChannel <em>Sink Data Channel</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DataChannelSinkConnectorImpl extends DataSourceSinkConnectorImpl
		implements DataChannelSinkConnector {
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
		return AbstractPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataChannel getSinkDataChannel() {
		return (DataChannel) eDynamicGet(AbstractPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL,
				AbstractPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataChannel basicGetSinkDataChannel() {
		return (DataChannel) eDynamicGet(AbstractPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL,
				AbstractPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSinkDataChannel(DataChannel newSinkDataChannel) {
		eDynamicSet(AbstractPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL,
				AbstractPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL, newSinkDataChannel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case AbstractPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL:
			if (resolve)
				return getSinkDataChannel();
			return basicGetSinkDataChannel();
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
		case AbstractPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL:
			setSinkDataChannel((DataChannel) newValue);
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
		case AbstractPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL:
			setSinkDataChannel((DataChannel) null);
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
		case AbstractPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL:
			return basicGetSinkDataChannel() != null;
		}
		return super.eIsSet(featureID);
	}

} //DataChannelSinkConnectorImpl
