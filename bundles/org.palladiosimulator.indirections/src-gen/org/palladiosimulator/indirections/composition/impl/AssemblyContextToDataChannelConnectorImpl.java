/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.indirections.composition.AssemblyContextToDataChannelConnector;
import org.palladiosimulator.indirections.composition.CompositionPackage;

import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;

import org.palladiosimulator.indirections.composition.abstract_.impl.AssemblyContextSourceConnectorImpl;

import org.palladiosimulator.indirections.system.DataChannel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assembly Context To Data Channel Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.composition.impl.AssemblyContextToDataChannelConnectorImpl#getSinkDataChannel <em>Sink Data Channel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssemblyContextToDataChannelConnectorImpl extends AssemblyContextSourceConnectorImpl
		implements AssemblyContextToDataChannelConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssemblyContextToDataChannelConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataChannel getSinkDataChannel() {
		return (DataChannel) eDynamicGet(
				CompositionPackage.ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL,
				AbstractPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataChannel basicGetSinkDataChannel() {
		return (DataChannel) eDynamicGet(
				CompositionPackage.ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL,
				AbstractPackage.Literals.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSinkDataChannel(DataChannel newSinkDataChannel) {
		eDynamicSet(CompositionPackage.ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL,
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
		case CompositionPackage.ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL:
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
		case CompositionPackage.ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL:
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
		case CompositionPackage.ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL:
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
		case CompositionPackage.ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL:
			return basicGetSinkDataChannel() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DataChannelSinkConnector.class) {
			switch (derivedFeatureID) {
			case CompositionPackage.ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL:
				return AbstractPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DataChannelSinkConnector.class) {
			switch (baseFeatureID) {
			case AbstractPackage.DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL:
				return CompositionPackage.ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //AssemblyContextToDataChannelConnectorImpl
