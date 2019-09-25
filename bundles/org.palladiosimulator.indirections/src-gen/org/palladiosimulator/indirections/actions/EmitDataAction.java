/**
 */
package org.palladiosimulator.indirections.actions;

import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.CallAction;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Emit Data Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.actions.EmitDataAction#getEventType <em>Event
 * Type</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.actions.EmitDataAction#getDataSourceRole <em>Data
 * Source Role</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getEmitDataAction()
 * @model
 * @generated
 */
public interface EmitDataAction extends AbstractAction, CallAction {
    /**
     * Returns the value of the '<em><b>Event Type</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the value of the '<em>Event Type</em>' reference.
     * @see #setEventType(EventType)
     * @see org.palladiosimulator.indirections.actions.ActionsPackage#getEmitDataAction_EventType()
     * @model required="true"
     * @generated
     */
    EventType getEventType();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.actions.EmitDataAction#getEventType <em>Event
     * Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Event Type</em>' reference.
     * @see #getEventType()
     * @generated
     */
    void setEventType(EventType value);

    /**
     * Returns the value of the '<em><b>Data Source Role</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Data Source Role</em>' reference.
     * @see #setDataSourceRole(DataSourceRole)
     * @see org.palladiosimulator.indirections.actions.ActionsPackage#getEmitDataAction_DataSourceRole()
     * @model required="true"
     * @generated
     */
    DataSourceRole getDataSourceRole();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.actions.EmitDataAction#getDataSourceRole <em>Data
     * Source Role</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Data Source Role</em>' reference.
     * @see #getDataSourceRole()
     * @generated
     */
    void setDataSourceRole(DataSourceRole value);

} // EmitDataAction
