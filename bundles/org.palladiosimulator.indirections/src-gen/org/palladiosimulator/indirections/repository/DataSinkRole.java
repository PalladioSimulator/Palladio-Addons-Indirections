/**
 */
package org.palladiosimulator.indirections.repository;

import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.ProvidedRole;

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
 * <li>{@link org.palladiosimulator.indirections.repository.DataSinkRole#isIsPushing <em>Is
 * Pushing</em>}</li>
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
     * Returns the value of the '<em><b>Is Pushing</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the value of the '<em>Is Pushing</em>' attribute.
     * @see #setIsPushing(boolean)
     * @see org.palladiosimulator.indirections.repository.RepositoryPackage#getDataSinkRole_IsPushing()
     * @model
     * @generated
     */
    boolean isIsPushing();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.repository.DataSinkRole#isIsPushing <em>Is
     * Pushing</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Is Pushing</em>' attribute.
     * @see #isIsPushing()
     * @generated
     */
    void setIsPushing(boolean value);
} // DataSinkRole
