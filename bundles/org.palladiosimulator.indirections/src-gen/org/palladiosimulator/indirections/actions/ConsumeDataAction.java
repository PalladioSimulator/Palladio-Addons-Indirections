/**
 */
package org.palladiosimulator.indirections.actions;

import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.seff.AbstractAction;

import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Consume Data
 * Action</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getEventType <em>Event
 * Type</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getDataSinkRole <em>Data
 * Sink Role</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getVariableReference
 * <em>Variable Reference</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getConsumeDataAction()
 * @model
 * @generated
 */
public interface ConsumeDataAction extends AbstractAction {
    /**
     * Returns the value of the '<em><b>Event Type</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the value of the '<em>Event Type</em>' reference.
     * @see #setEventType(EventType)
     * @see org.palladiosimulator.indirections.actions.ActionsPackage#getConsumeDataAction_EventType()
     * @model required="true" ordered="false"
     * @generated
     */
    EventType getEventType();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getEventType <em>Event
     * Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Event Type</em>' reference.
     * @see #getEventType()
     * @generated
     */
    void setEventType(EventType value);

    /**
     * Returns the value of the '<em><b>Data Sink Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Data Sink Role</em>' reference.
     * @see #setDataSinkRole(DataSinkRole)
     * @see org.palladiosimulator.indirections.actions.ActionsPackage#getConsumeDataAction_DataSinkRole()
     * @model required="true" ordered="false"
     * @generated
     */
    DataSinkRole getDataSinkRole();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getDataSinkRole <em>Data
     * Sink Role</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Data Sink Role</em>' reference.
     * @see #getDataSinkRole()
     * @generated
     */
    void setDataSinkRole(DataSinkRole value);

    /**
     * Returns the value of the '<em><b>Variable Reference</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Variable Reference</em>' containment reference.
     * @see #setVariableReference(VariableReference)
     * @see org.palladiosimulator.indirections.actions.ActionsPackage#getConsumeDataAction_VariableReference()
     * @model containment="true" required="true"
     * @generated
     */
    VariableReference getVariableReference();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getVariableReference
     * <em>Variable Reference</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Variable Reference</em>' containment reference.
     * @see #getVariableReference()
     * @generated
     */
    void setVariableReference(VariableReference value);

} // ConsumeDataAction
