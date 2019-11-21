/**
 */
package org.palladiosimulator.indirections.repository;

import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.Signature;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Data Sink Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.repository.DataSinkRole#getEventGroup <em>Event
 * Group</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.repository.DataSinkRole#getPushesTo <em>Pushes
 * To</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.repository.DataSinkRole#isPushing
 * <em>Pushing</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.repository.RepositoryPackage#getDataSinkRole()
 * @model
 * @generated
 */
public interface DataSinkRole extends ProvidedRole {
    /**
     * Returns the value of the '<em><b>Event Group</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Event Group</em>' reference.
     * @see #setEventGroup(EventGroup)
     * @see org.palladiosimulator.indirections.repository.RepositoryPackage#getDataSinkRole_EventGroup()
     * @model
     * @generated
     */
    EventGroup getEventGroup();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.repository.DataSinkRole#getEventGroup <em>Event
     * Group</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Event Group</em>' reference.
     * @see #getEventGroup()
     * @generated
     */
    void setEventGroup(EventGroup value);

    /**
     * Returns the value of the '<em><b>Pushes To</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Pushes To</em>' reference.
     * @see #setPushesTo(Signature)
     * @see org.palladiosimulator.indirections.repository.RepositoryPackage#getDataSinkRole_PushesTo()
     * @model
     * @generated
     */
    Signature getPushesTo();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.repository.DataSinkRole#getPushesTo <em>Pushes
     * To</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Pushes To</em>' reference.
     * @see #getPushesTo()
     * @generated
     */
    void setPushesTo(Signature value);

    /**
     * Returns the value of the '<em><b>Pushing</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Pushing</em>' attribute.
     * @see org.palladiosimulator.indirections.repository.RepositoryPackage#getDataSinkRole_Pushing()
     * @model changeable="false" volatile="true" derived="true"
     * @generated
     */
    boolean isPushing();

} // DataSinkRole
