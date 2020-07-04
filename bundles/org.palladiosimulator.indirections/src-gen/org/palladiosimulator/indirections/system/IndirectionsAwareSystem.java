/**
 */
package org.palladiosimulator.indirections.system;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Indirections Aware
 * System</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.system.IndirectionsAwareSystem#getDataChannels
 * <em>Data Channels</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.system.SystemPackage#getIndirectionsAwareSystem()
 * @model
 * @generated
 */
public interface IndirectionsAwareSystem extends org.palladiosimulator.pcm.system.System {
    /**
     * Returns the value of the '<em><b>Data Channels</b></em>' containment reference list. The list
     * contents are of type {@link org.palladiosimulator.indirections.system.DataChannel}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Data Channels</em>' containment reference list.
     * @see org.palladiosimulator.indirections.system.SystemPackage#getIndirectionsAwareSystem_DataChannels()
     * @model containment="true"
     * @generated
     */
    EList<DataChannel> getDataChannels();

} // IndirectionsAwareSystem
