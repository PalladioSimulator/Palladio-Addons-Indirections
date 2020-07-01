/**
 */
package org.palladiosimulator.indirections.composition.util;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.palladiosimulator.indirections.composition.*;

import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;

import org.palladiosimulator.pcm.core.composition.Connector;

import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.core.entity.NamedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.indirections.composition.CompositionPackage
 * @generated
 */
public class CompositionSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CompositionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionSwitch() {
		if (modelPackage == null) {
			modelPackage = CompositionPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR: {
			DataChannelToAssemblyContextConnector dataChannelToAssemblyContextConnector = (DataChannelToAssemblyContextConnector) theEObject;
			T result = caseDataChannelToAssemblyContextConnector(dataChannelToAssemblyContextConnector);
			if (result == null)
				result = caseDataChannelSourceConnector(dataChannelToAssemblyContextConnector);
			if (result == null)
				result = caseAssemblyContextSinkConnector(dataChannelToAssemblyContextConnector);
			if (result == null)
				result = caseDataSourceSinkConnector(dataChannelToAssemblyContextConnector);
			if (result == null)
				result = caseConnector(dataChannelToAssemblyContextConnector);
			if (result == null)
				result = caseEntity(dataChannelToAssemblyContextConnector);
			if (result == null)
				result = caseIdentifier(dataChannelToAssemblyContextConnector);
			if (result == null)
				result = caseNamedElement(dataChannelToAssemblyContextConnector);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CompositionPackage.ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR: {
			AssemblyContextToDataChannelConnector assemblyContextToDataChannelConnector = (AssemblyContextToDataChannelConnector) theEObject;
			T result = caseAssemblyContextToDataChannelConnector(assemblyContextToDataChannelConnector);
			if (result == null)
				result = caseAssemblyContextSourceConnector(assemblyContextToDataChannelConnector);
			if (result == null)
				result = caseDataChannelSinkConnector(assemblyContextToDataChannelConnector);
			if (result == null)
				result = caseDataSourceSinkConnector(assemblyContextToDataChannelConnector);
			if (result == null)
				result = caseConnector(assemblyContextToDataChannelConnector);
			if (result == null)
				result = caseEntity(assemblyContextToDataChannelConnector);
			if (result == null)
				result = caseIdentifier(assemblyContextToDataChannelConnector);
			if (result == null)
				result = caseNamedElement(assemblyContextToDataChannelConnector);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CompositionPackage.DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR: {
			DataChannelToDataChannelConnector dataChannelToDataChannelConnector = (DataChannelToDataChannelConnector) theEObject;
			T result = caseDataChannelToDataChannelConnector(dataChannelToDataChannelConnector);
			if (result == null)
				result = caseDataChannelSourceConnector(dataChannelToDataChannelConnector);
			if (result == null)
				result = caseDataChannelSinkConnector(dataChannelToDataChannelConnector);
			if (result == null)
				result = caseDataSourceSinkConnector(dataChannelToDataChannelConnector);
			if (result == null)
				result = caseConnector(dataChannelToDataChannelConnector);
			if (result == null)
				result = caseEntity(dataChannelToDataChannelConnector);
			if (result == null)
				result = caseIdentifier(dataChannelToDataChannelConnector);
			if (result == null)
				result = caseNamedElement(dataChannelToDataChannelConnector);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR: {
			AssemblyContextToAssemblyContextConnector assemblyContextToAssemblyContextConnector = (AssemblyContextToAssemblyContextConnector) theEObject;
			T result = caseAssemblyContextToAssemblyContextConnector(assemblyContextToAssemblyContextConnector);
			if (result == null)
				result = caseAssemblyContextSourceConnector(assemblyContextToAssemblyContextConnector);
			if (result == null)
				result = caseAssemblyContextSinkConnector(assemblyContextToAssemblyContextConnector);
			if (result == null)
				result = caseDataSourceSinkConnector(assemblyContextToAssemblyContextConnector);
			if (result == null)
				result = caseConnector(assemblyContextToAssemblyContextConnector);
			if (result == null)
				result = caseEntity(assemblyContextToAssemblyContextConnector);
			if (result == null)
				result = caseIdentifier(assemblyContextToAssemblyContextConnector);
			if (result == null)
				result = caseNamedElement(assemblyContextToAssemblyContextConnector);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Channel To Assembly Context Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Channel To Assembly Context Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataChannelToAssemblyContextConnector(DataChannelToAssemblyContextConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assembly Context To Data Channel Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assembly Context To Data Channel Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssemblyContextToDataChannelConnector(AssemblyContextToDataChannelConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Channel To Data Channel Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Channel To Data Channel Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataChannelToDataChannelConnector(DataChannelToDataChannelConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assembly Context To Assembly Context Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assembly Context To Assembly Context Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssemblyContextToAssemblyContextConnector(AssemblyContextToAssemblyContextConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnector(Connector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Source Sink Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Source Sink Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSourceSinkConnector(DataSourceSinkConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Channel Source Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Channel Source Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataChannelSourceConnector(DataChannelSourceConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assembly Context Sink Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assembly Context Sink Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssemblyContextSinkConnector(AssemblyContextSinkConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assembly Context Source Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assembly Context Source Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssemblyContextSourceConnector(AssemblyContextSourceConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Channel Sink Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Channel Sink Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataChannelSinkConnector(DataChannelSinkConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //CompositionSwitch
