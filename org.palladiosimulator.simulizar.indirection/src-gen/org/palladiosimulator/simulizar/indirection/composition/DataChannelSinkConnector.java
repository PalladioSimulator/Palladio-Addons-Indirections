/**
 */
package org.palladiosimulator.simulizar.indirection.composition;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.Connector;

import org.palladiosimulator.pcm.repository.SinkRole;

import org.palladiosimulator.simulizar.indirection.system.DataChannel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Channel Sink Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.composition.DataChannelSinkConnector#getSinkRole <em>Sink Role</em>}</li>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.composition.DataChannelSinkConnector#getAssemblyContext <em>Assembly Context</em>}</li>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.composition.DataChannelSinkConnector#getDataChannel <em>Data Channel</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.simulizar.indirection.composition.CompositionPackage#getDataChannelSinkConnector()
 * @model
 * @generated
 */
public interface DataChannelSinkConnector extends Connector {
	/**
	 * Returns the value of the '<em><b>Sink Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sink Role</em>' reference.
	 * @see #setSinkRole(SinkRole)
	 * @see org.palladiosimulator.simulizar.indirection.composition.CompositionPackage#getDataChannelSinkConnector_SinkRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SinkRole getSinkRole();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.simulizar.indirection.composition.DataChannelSinkConnector#getSinkRole <em>Sink Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sink Role</em>' reference.
	 * @see #getSinkRole()
	 * @generated
	 */
	void setSinkRole(SinkRole value);

	/**
	 * Returns the value of the '<em><b>Assembly Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context</em>' reference.
	 * @see #setAssemblyContext(AssemblyContext)
	 * @see org.palladiosimulator.simulizar.indirection.composition.CompositionPackage#getDataChannelSinkConnector_AssemblyContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.simulizar.indirection.composition.DataChannelSinkConnector#getAssemblyContext <em>Assembly Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context</em>' reference.
	 * @see #getAssemblyContext()
	 * @generated
	 */
	void setAssemblyContext(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Data Channel</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.palladiosimulator.simulizar.indirection.system.DataChannel#getDataChannelSinkConnector <em>Data Channel Sink Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Channel</em>' reference.
	 * @see #setDataChannel(DataChannel)
	 * @see org.palladiosimulator.simulizar.indirection.composition.CompositionPackage#getDataChannelSinkConnector_DataChannel()
	 * @see org.palladiosimulator.simulizar.indirection.system.DataChannel#getDataChannelSinkConnector
	 * @model opposite="dataChannelSinkConnector" required="true" ordered="false"
	 * @generated
	 */
	DataChannel getDataChannel();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.simulizar.indirection.composition.DataChannelSinkConnector#getDataChannel <em>Data Channel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Channel</em>' reference.
	 * @see #getDataChannel()
	 * @generated
	 */
	void setDataChannel(DataChannel value);

} // DataChannelSinkConnector
