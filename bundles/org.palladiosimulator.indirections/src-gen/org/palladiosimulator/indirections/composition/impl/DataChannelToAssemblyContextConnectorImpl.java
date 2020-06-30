/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.DataChannelToAssemblyContextConnector;

import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector;

import org.palladiosimulator.indirections.composition.abstract_.impl.DataChannelSourceConnectorImpl;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;

import org.palladiosimulator.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Channel To Assembly Context Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.composition.impl.DataChannelToAssemblyContextConnectorImpl#getSinkAssemblyContext <em>Sink Assembly Context</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.composition.impl.DataChannelToAssemblyContextConnectorImpl#getPushesTo <em>Pushes To</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.composition.impl.DataChannelToAssemblyContextConnectorImpl#isPushing <em>Pushing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataChannelToAssemblyContextConnectorImpl extends DataChannelSourceConnectorImpl
		implements DataChannelToAssemblyContextConnector {
	/**
	 * The default value of the '{@link #isPushing() <em>Pushing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPushing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PUSHING_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataChannelToAssemblyContextConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssemblyContext getSinkAssemblyContext() {
		return (AssemblyContext) eDynamicGet(
				CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT,
				AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetSinkAssemblyContext() {
		return (AssemblyContext) eDynamicGet(
				CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT,
				AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSinkAssemblyContext(AssemblyContext newSinkAssemblyContext) {
		eDynamicSet(CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT,
				AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT,
				newSinkAssemblyContext);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Signature getPushesTo() {
		return (Signature) eDynamicGet(CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO,
				AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature basicGetPushesTo() {
		return (Signature) eDynamicGet(CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO,
				AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPushesTo(Signature newPushesTo) {
		eDynamicSet(CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO,
				AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO, newPushesTo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPushing() {
		return (this.getPushesTo() != null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPushing(boolean newPushing) {
		// TODO: implement this method to set the 'Pushing' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
			if (resolve)
				return getSinkAssemblyContext();
			return basicGetSinkAssemblyContext();
		case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO:
			if (resolve)
				return getPushesTo();
			return basicGetPushesTo();
		case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHING:
			return isPushing();
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
		case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
			setSinkAssemblyContext((AssemblyContext) newValue);
			return;
		case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO:
			setPushesTo((Signature) newValue);
			return;
		case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHING:
			setPushing((Boolean) newValue);
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
		case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
			setSinkAssemblyContext((AssemblyContext) null);
			return;
		case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO:
			setPushesTo((Signature) null);
			return;
		case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHING:
			setPushing(PUSHING_EDEFAULT);
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
		case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
			return basicGetSinkAssemblyContext() != null;
		case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO:
			return basicGetPushesTo() != null;
		case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHING:
			return isPushing() != PUSHING_EDEFAULT;
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
		if (baseClass == AssemblyContextSinkConnector.class) {
			switch (derivedFeatureID) {
			case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
				return AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT;
			case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO:
				return AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO;
			case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHING:
				return AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHING;
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
		if (baseClass == AssemblyContextSinkConnector.class) {
			switch (baseFeatureID) {
			case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
				return CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT;
			case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO:
				return CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO;
			case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHING:
				return CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHING;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //DataChannelToAssemblyContextConnectorImpl
