/**
 */
package org.palladiosimulator.indirections.actions;

import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.repository.SinkRole;

import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.CallReturnAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consume Data Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getEventType <em>Event Type</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getSinkRole <em>Sink Role</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getConsumeDataAction()
 * @model
 * @generated
 */
public interface ConsumeDataAction extends AbstractAction, CallReturnAction {
	/**
	 * Returns the value of the '<em><b>Event Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Type</em>' reference.
	 * @see #setEventType(EventType)
	 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getConsumeDataAction_EventType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EventType getEventType();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getEventType <em>Event Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Type</em>' reference.
	 * @see #getEventType()
	 * @generated
	 */
	void setEventType(EventType value);

	/**
	 * Returns the value of the '<em><b>Sink Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sink Role</em>' reference.
	 * @see #setSinkRole(SinkRole)
	 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getConsumeDataAction_SinkRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SinkRole getSinkRole();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getSinkRole <em>Sink Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sink Role</em>' reference.
	 * @see #getSinkRole()
	 * @generated
	 */
	void setSinkRole(SinkRole value);

} // ConsumeDataAction
