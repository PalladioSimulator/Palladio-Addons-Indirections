/**
 */
package org.palladiosimulator.indirections.composition.abstract_.util;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.palladiosimulator.indirections.composition.abstract_.*;

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
 * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage
 * @generated
 */
public class AbstractSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AbstractPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractSwitch() {
		if (modelPackage == null) {
			modelPackage = AbstractPackage.eINSTANCE;
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
		case AbstractPackage.DATA_SOURCE_SINK_CONNECTOR: {
			DataSourceSinkConnector dataSourceSinkConnector = (DataSourceSinkConnector) theEObject;
			T result = caseDataSourceSinkConnector(dataSourceSinkConnector);
			if (result == null)
				result = caseConnector(dataSourceSinkConnector);
			if (result == null)
				result = caseEntity(dataSourceSinkConnector);
			if (result == null)
				result = caseIdentifier(dataSourceSinkConnector);
			if (result == null)
				result = caseNamedElement(dataSourceSinkConnector);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR: {
			DataChannelSourceConnector dataChannelSourceConnector = (DataChannelSourceConnector) theEObject;
			T result = caseDataChannelSourceConnector(dataChannelSourceConnector);
			if (result == null)
				result = caseDataSourceSinkConnector(dataChannelSourceConnector);
			if (result == null)
				result = caseConnector(dataChannelSourceConnector);
			if (result == null)
				result = caseEntity(dataChannelSourceConnector);
			if (result == null)
				result = caseIdentifier(dataChannelSourceConnector);
			if (result == null)
				result = caseNamedElement(dataChannelSourceConnector);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AbstractPackage.DATA_CHANNEL_SINK_CONNECTOR: {
			DataChannelSinkConnector dataChannelSinkConnector = (DataChannelSinkConnector) theEObject;
			T result = caseDataChannelSinkConnector(dataChannelSinkConnector);
			if (result == null)
				result = caseDataSourceSinkConnector(dataChannelSinkConnector);
			if (result == null)
				result = caseConnector(dataChannelSinkConnector);
			if (result == null)
				result = caseEntity(dataChannelSinkConnector);
			if (result == null)
				result = caseIdentifier(dataChannelSinkConnector);
			if (result == null)
				result = caseNamedElement(dataChannelSinkConnector);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR: {
			AssemblyContextSourceConnector assemblyContextSourceConnector = (AssemblyContextSourceConnector) theEObject;
			T result = caseAssemblyContextSourceConnector(assemblyContextSourceConnector);
			if (result == null)
				result = caseDataSourceSinkConnector(assemblyContextSourceConnector);
			if (result == null)
				result = caseConnector(assemblyContextSourceConnector);
			if (result == null)
				result = caseEntity(assemblyContextSourceConnector);
			if (result == null)
				result = caseIdentifier(assemblyContextSourceConnector);
			if (result == null)
				result = caseNamedElement(assemblyContextSourceConnector);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR: {
			AssemblyContextSinkConnector assemblyContextSinkConnector = (AssemblyContextSinkConnector) theEObject;
			T result = caseAssemblyContextSinkConnector(assemblyContextSinkConnector);
			if (result == null)
				result = caseDataSourceSinkConnector(assemblyContextSinkConnector);
			if (result == null)
				result = caseConnector(assemblyContextSinkConnector);
			if (result == null)
				result = caseEntity(assemblyContextSinkConnector);
			if (result == null)
				result = caseIdentifier(assemblyContextSinkConnector);
			if (result == null)
				result = caseNamedElement(assemblyContextSinkConnector);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
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

} //AbstractSwitch
