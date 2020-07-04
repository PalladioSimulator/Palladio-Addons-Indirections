/**
 */
package org.palladiosimulator.indirections.composition.abstract_;

import org.palladiosimulator.indirections.system.DataChannel;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Data Channel Source
 * Connector</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> Connector that has a DataChannel as its source. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector#getSourceDataChannel
 * <em>Source Data Channel</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage#getDataChannelSourceConnector()
 * @model abstract="true"
 * @generated
 */
public interface DataChannelSourceConnector extends DataSourceSinkConnector {
    /**
     * Returns the value of the '<em><b>Source Data Channel</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Source Data Channel</em>' reference.
     * @see #setSourceDataChannel(DataChannel)
     * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage#getDataChannelSourceConnector_SourceDataChannel()
     * @model required="true" ordered="false"
     * @generated
     */
    DataChannel getSourceDataChannel();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector#getSourceDataChannel
     * <em>Source Data Channel</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Source Data Channel</em>' reference.
     * @see #getSourceDataChannel()
     * @generated
     */
    void setSourceDataChannel(DataChannel value);

} // DataChannelSourceConnector
