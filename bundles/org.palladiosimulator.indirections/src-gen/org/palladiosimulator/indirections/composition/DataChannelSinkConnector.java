/**
 */
package org.palladiosimulator.indirections.composition;

import org.palladiosimulator.indirections.repository.DataSinkRole;

import org.palladiosimulator.indirections.system.DataChannel;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.Connector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Channel Sink Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.composition.DataChannelSinkConnector#getDataSinkRole <em>Data Sink Role</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.composition.DataChannelSinkConnector#getAssemblyContext <em>Assembly Context</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.composition.DataChannelSinkConnector#getDataChannel <em>Data Channel</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.composition.CompositionPackage#getDataChannelSinkConnector()
 * @model
 * @generated
 */
public interface DataChannelSinkConnector extends Connector {
	/**
	 * Returns the value of the '<em><b>Data Sink Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Sink Role</em>' reference.
	 * @see #setDataSinkRole(DataSinkRole)
	 * @see org.palladiosimulator.indirections.composition.CompositionPackage#getDataChannelSinkConnector_DataSinkRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataSinkRole getDataSinkRole();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.composition.DataChannelSinkConnector#getDataSinkRole <em>Data Sink Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Sink Role</em>' reference.
	 * @see #getDataSinkRole()
	 * @generated
	 */
	void setDataSinkRole(DataSinkRole value);

	/**
	 * Returns the value of the '<em><b>Assembly Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context</em>' reference.
	 * @see #setAssemblyContext(AssemblyContext)
	 * @see org.palladiosimulator.indirections.composition.CompositionPackage#getDataChannelSinkConnector_AssemblyContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.composition.DataChannelSinkConnector#getAssemblyContext <em>Assembly Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context</em>' reference.
	 * @see #getAssemblyContext()
	 * @generated
	 */
	void setAssemblyContext(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Data Channel</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.palladiosimulator.indirections.system.DataChannel#getDataChannelSinkConnector <em>Data Channel Sink Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Channel</em>' reference.
	 * @see #setDataChannel(DataChannel)
	 * @see org.palladiosimulator.indirections.composition.CompositionPackage#getDataChannelSinkConnector_DataChannel()
	 * @see org.palladiosimulator.indirections.system.DataChannel#getDataChannelSinkConnector
	 * @model opposite="dataChannelSinkConnector" required="true" ordered="false"
	 * @generated
	 */
	DataChannel getDataChannel();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.composition.DataChannelSinkConnector#getDataChannel <em>Data Channel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Channel</em>' reference.
	 * @see #getDataChannel()
	 * @generated
	 */
	void setDataChannel(DataChannel value);

} // DataChannelSinkConnector
