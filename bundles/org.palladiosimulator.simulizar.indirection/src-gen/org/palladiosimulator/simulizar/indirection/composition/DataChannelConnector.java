/**
 */
package org.palladiosimulator.simulizar.indirection.composition;

import org.palladiosimulator.pcm.core.composition.Connector;

import org.palladiosimulator.simulizar.indirection.system.DataChannel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Channel Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.composition.DataChannelConnector#getSource <em>Source</em>}</li>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.composition.DataChannelConnector#getSink <em>Sink</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.simulizar.indirection.composition.CompositionPackage#getDataChannelConnector()
 * @model
 * @generated
 */
public interface DataChannelConnector extends Connector {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(DataChannel)
	 * @see org.palladiosimulator.simulizar.indirection.composition.CompositionPackage#getDataChannelConnector_Source()
	 * @model required="true"
	 * @generated
	 */
	DataChannel getSource();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.simulizar.indirection.composition.DataChannelConnector#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(DataChannel value);

	/**
	 * Returns the value of the '<em><b>Sink</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sink</em>' reference.
	 * @see #setSink(DataChannel)
	 * @see org.palladiosimulator.simulizar.indirection.composition.CompositionPackage#getDataChannelConnector_Sink()
	 * @model required="true"
	 * @generated
	 */
	DataChannel getSink();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.simulizar.indirection.composition.DataChannelConnector#getSink <em>Sink</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sink</em>' reference.
	 * @see #getSink()
	 * @generated
	 */
	void setSink(DataChannel value);

} // DataChannelConnector
