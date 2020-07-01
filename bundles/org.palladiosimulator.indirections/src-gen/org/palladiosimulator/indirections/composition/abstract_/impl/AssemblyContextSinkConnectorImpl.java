/**
 */
package org.palladiosimulator.indirections.composition.abstract_.impl;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;

import org.palladiosimulator.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assembly Context Sink Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.composition.abstract_.impl.AssemblyContextSinkConnectorImpl#getSinkAssemblyContext <em>Sink Assembly Context</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.composition.abstract_.impl.AssemblyContextSinkConnectorImpl#getPushesTo <em>Pushes To</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.composition.abstract_.impl.AssemblyContextSinkConnectorImpl#isPushing <em>Pushing</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AssemblyContextSinkConnectorImpl extends DataSourceSinkConnectorImpl
		implements AssemblyContextSinkConnector {
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
	protected AssemblyContextSinkConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssemblyContext getSinkAssemblyContext() {
		return (AssemblyContext) eDynamicGet(AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT,
				AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetSinkAssemblyContext() {
		return (AssemblyContext) eDynamicGet(AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT,
				AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSinkAssemblyContext(AssemblyContext newSinkAssemblyContext) {
		eDynamicSet(AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT,
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
		return (Signature) eDynamicGet(AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO,
				AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature basicGetPushesTo() {
		return (Signature) eDynamicGet(AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO,
				AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPushesTo(Signature newPushesTo) {
		eDynamicSet(AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO,
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
		case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
			if (resolve)
				return getSinkAssemblyContext();
			return basicGetSinkAssemblyContext();
		case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO:
			if (resolve)
				return getPushesTo();
			return basicGetPushesTo();
		case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHING:
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
		case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
			setSinkAssemblyContext((AssemblyContext) newValue);
			return;
		case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO:
			setPushesTo((Signature) newValue);
			return;
		case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHING:
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
		case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
			setSinkAssemblyContext((AssemblyContext) null);
			return;
		case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO:
			setPushesTo((Signature) null);
			return;
		case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHING:
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
		case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
			return basicGetSinkAssemblyContext() != null;
		case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO:
			return basicGetPushesTo() != null;
		case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHING:
			return isPushing() != PUSHING_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //AssemblyContextSinkConnectorImpl
