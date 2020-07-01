/**
 */
package org.palladiosimulator.indirections.composition.abstract_;

import org.palladiosimulator.indirections.system.DataChannel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Channel Sink Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Connector that has a DataChannel as its sink.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector#getSinkDataChannel <em>Sink Data Channel</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage#getDataChannelSinkConnector()
 * @model abstract="true"
 * @generated
 */
public interface DataChannelSinkConnector extends DataSourceSinkConnector {
	/**
	 * Returns the value of the '<em><b>Sink Data Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sink Data Channel</em>' reference.
	 * @see #setSinkDataChannel(DataChannel)
	 * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage#getDataChannelSinkConnector_SinkDataChannel()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataChannel getSinkDataChannel();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector#getSinkDataChannel <em>Sink Data Channel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sink Data Channel</em>' reference.
	 * @see #getSinkDataChannel()
	 * @generated
	 */
	void setSinkDataChannel(DataChannel value);

} // DataChannelSinkConnector
