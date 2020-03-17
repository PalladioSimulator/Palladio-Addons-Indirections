/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.DataChannelConnector;

import org.palladiosimulator.indirections.system.DataChannel;

import org.palladiosimulator.pcm.core.composition.impl.ConnectorImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Channel Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.composition.impl.DataChannelConnectorImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.composition.impl.DataChannelConnectorImpl#getSink <em>Sink</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataChannelConnectorImpl extends ConnectorImpl implements DataChannelConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataChannelConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataChannel getSource() {
		return (DataChannel) eDynamicGet(CompositionPackage.DATA_CHANNEL_CONNECTOR__SOURCE,
				CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR__SOURCE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataChannel basicGetSource() {
		return (DataChannel) eDynamicGet(CompositionPackage.DATA_CHANNEL_CONNECTOR__SOURCE,
				CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR__SOURCE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(DataChannel newSource) {
		eDynamicSet(CompositionPackage.DATA_CHANNEL_CONNECTOR__SOURCE,
				CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR__SOURCE, newSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataChannel getSink() {
		return (DataChannel) eDynamicGet(CompositionPackage.DATA_CHANNEL_CONNECTOR__SINK,
				CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR__SINK, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataChannel basicGetSink() {
		return (DataChannel) eDynamicGet(CompositionPackage.DATA_CHANNEL_CONNECTOR__SINK,
				CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR__SINK, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSink(DataChannel newSink) {
		eDynamicSet(CompositionPackage.DATA_CHANNEL_CONNECTOR__SINK,
				CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR__SINK, newSink);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CompositionPackage.DATA_CHANNEL_CONNECTOR__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case CompositionPackage.DATA_CHANNEL_CONNECTOR__SINK:
			if (resolve)
				return getSink();
			return basicGetSink();
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
		case CompositionPackage.DATA_CHANNEL_CONNECTOR__SOURCE:
			setSource((DataChannel) newValue);
			return;
		case CompositionPackage.DATA_CHANNEL_CONNECTOR__SINK:
			setSink((DataChannel) newValue);
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
		case CompositionPackage.DATA_CHANNEL_CONNECTOR__SOURCE:
			setSource((DataChannel) null);
			return;
		case CompositionPackage.DATA_CHANNEL_CONNECTOR__SINK:
			setSink((DataChannel) null);
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
		case CompositionPackage.DATA_CHANNEL_CONNECTOR__SOURCE:
			return basicGetSource() != null;
		case CompositionPackage.DATA_CHANNEL_CONNECTOR__SINK:
			return basicGetSink() != null;
		}
		return super.eIsSet(featureID);
	}

} //DataChannelConnectorImpl
