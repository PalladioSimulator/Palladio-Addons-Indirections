/**
 */
package org.palladiosimulator.indirections.actions;

import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.repository.SourceRole;

import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.CallAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Emit Data Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.actions.EmitDataAction#getEventType <em>Event Type</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.actions.EmitDataAction#getSourceRole <em>Source Role</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getEmitDataAction()
 * @model
 * @generated
 */
public interface EmitDataAction extends AbstractAction, CallAction {
	/**
	 * Returns the value of the '<em><b>Event Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Type</em>' reference.
	 * @see #setEventType(EventType)
	 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getEmitDataAction_EventType()
	 * @model required="true"
	 * @generated
	 */
	EventType getEventType();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.actions.EmitDataAction#getEventType <em>Event Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Type</em>' reference.
	 * @see #getEventType()
	 * @generated
	 */
	void setEventType(EventType value);

	/**
	 * Returns the value of the '<em><b>Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Role</em>' reference.
	 * @see #setSourceRole(SourceRole)
	 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getEmitDataAction_SourceRole()
	 * @model required="true"
	 * @generated
	 */
	SourceRole getSourceRole();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.actions.EmitDataAction#getSourceRole <em>Source Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Role</em>' reference.
	 * @see #getSourceRole()
	 * @generated
	 */
	void setSourceRole(SourceRole value);

} // EmitDataAction
