/**
 */
package org.palladiosimulator.simulizar.indirection.actions;

import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.repository.SinkRole;

import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.CallReturnAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consume Event Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.actions.ConsumeEventAction#getEventType <em>Event Type</em>}</li>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.actions.ConsumeEventAction#getSinkRole <em>Sink Role</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.simulizar.indirection.actions.ActionsPackage#getConsumeEventAction()
 * @model
 * @generated
 */
public interface ConsumeEventAction extends AbstractAction, CallReturnAction {
	/**
	 * Returns the value of the '<em><b>Event Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Type</em>' reference.
	 * @see #setEventType(EventType)
	 * @see org.palladiosimulator.simulizar.indirection.actions.ActionsPackage#getConsumeEventAction_EventType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EventType getEventType();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.simulizar.indirection.actions.ConsumeEventAction#getEventType <em>Event Type</em>}' reference.
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
	 * @see org.palladiosimulator.simulizar.indirection.actions.ActionsPackage#getConsumeEventAction_SinkRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SinkRole getSinkRole();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.simulizar.indirection.actions.ConsumeEventAction#getSinkRole <em>Sink Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sink Role</em>' reference.
	 * @see #getSinkRole()
	 * @generated
	 */
	void setSinkRole(SinkRole value);

} // ConsumeEventAction
