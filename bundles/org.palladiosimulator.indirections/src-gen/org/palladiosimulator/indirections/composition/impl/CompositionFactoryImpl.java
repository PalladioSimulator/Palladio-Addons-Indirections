/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.palladiosimulator.indirections.composition.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositionFactoryImpl extends EFactoryImpl implements CompositionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompositionFactory init() {
		try {
			CompositionFactory theCompositionFactory = (CompositionFactory) EPackage.Registry.INSTANCE
					.getEFactory(CompositionPackage.eNS_URI);
			if (theCompositionFactory != null) {
				return theCompositionFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CompositionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case CompositionPackage.DATA_CHANNEL_SOURCE_CONNECTOR:
			return createDataChannelSourceConnector();
		case CompositionPackage.DATA_CHANNEL_SINK_CONNECTOR:
			return createDataChannelSinkConnector();
		case CompositionPackage.DATA_CHANNEL_CONNECTOR:
			return createDataChannelConnector();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataChannelSourceConnector createDataChannelSourceConnector() {
		DataChannelSourceConnectorImpl dataChannelSourceConnector = new DataChannelSourceConnectorImpl();
		return dataChannelSourceConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataChannelSinkConnector createDataChannelSinkConnector() {
		DataChannelSinkConnectorImpl dataChannelSinkConnector = new DataChannelSinkConnectorImpl();
		return dataChannelSinkConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataChannelConnector createDataChannelConnector() {
		DataChannelConnectorImpl dataChannelConnector = new DataChannelConnectorImpl();
		return dataChannelConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositionPackage getCompositionPackage() {
		return (CompositionPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CompositionPackage getPackage() {
		return CompositionPackage.eINSTANCE;
	}

} //CompositionFactoryImpl
