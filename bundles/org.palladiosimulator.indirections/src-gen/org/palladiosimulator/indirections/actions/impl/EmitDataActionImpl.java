/**
 */
package org.palladiosimulator.indirections.actions.impl;

import de.uka.ipd.sdq.stoex.VariableReference;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.EmitDataAction;

import org.palladiosimulator.indirections.repository.DataSourceRole;

import org.palladiosimulator.pcm.repository.EventType;

import org.palladiosimulator.pcm.seff.impl.AbstractActionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Emit Data Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl#getEventType <em>Event Type</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl#getDataSourceRole <em>Data Source Role</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl#getVariableReference <em>Variable Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EmitDataActionImpl extends AbstractActionImpl implements EmitDataAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmitDataActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionsPackage.Literals.EMIT_DATA_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventType getEventType() {
		return (EventType) eDynamicGet(ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE,
				ActionsPackage.Literals.EMIT_DATA_ACTION__EVENT_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventType basicGetEventType() {
		return (EventType) eDynamicGet(ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE,
				ActionsPackage.Literals.EMIT_DATA_ACTION__EVENT_TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEventType(EventType newEventType) {
		eDynamicSet(ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE, ActionsPackage.Literals.EMIT_DATA_ACTION__EVENT_TYPE,
				newEventType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataSourceRole getDataSourceRole() {
		return (DataSourceRole) eDynamicGet(ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE,
				ActionsPackage.Literals.EMIT_DATA_ACTION__DATA_SOURCE_ROLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSourceRole basicGetDataSourceRole() {
		return (DataSourceRole) eDynamicGet(ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE,
				ActionsPackage.Literals.EMIT_DATA_ACTION__DATA_SOURCE_ROLE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataSourceRole(DataSourceRole newDataSourceRole) {
		eDynamicSet(ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE,
				ActionsPackage.Literals.EMIT_DATA_ACTION__DATA_SOURCE_ROLE, newDataSourceRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableReference getVariableReference() {
		return (VariableReference) eDynamicGet(ActionsPackage.EMIT_DATA_ACTION__VARIABLE_REFERENCE,
				ActionsPackage.Literals.EMIT_DATA_ACTION__VARIABLE_REFERENCE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableReference(VariableReference newVariableReference, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newVariableReference,
				ActionsPackage.EMIT_DATA_ACTION__VARIABLE_REFERENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariableReference(VariableReference newVariableReference) {
		eDynamicSet(ActionsPackage.EMIT_DATA_ACTION__VARIABLE_REFERENCE,
				ActionsPackage.Literals.EMIT_DATA_ACTION__VARIABLE_REFERENCE, newVariableReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ActionsPackage.EMIT_DATA_ACTION__VARIABLE_REFERENCE:
			return basicSetVariableReference(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE:
			if (resolve)
				return getEventType();
			return basicGetEventType();
		case ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE:
			if (resolve)
				return getDataSourceRole();
			return basicGetDataSourceRole();
		case ActionsPackage.EMIT_DATA_ACTION__VARIABLE_REFERENCE:
			return getVariableReference();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE:
			setEventType((EventType) newValue);
			return;
		case ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE:
			setDataSourceRole((DataSourceRole) newValue);
			return;
		case ActionsPackage.EMIT_DATA_ACTION__VARIABLE_REFERENCE:
			setVariableReference((VariableReference) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE:
			setEventType((EventType) null);
			return;
		case ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE:
			setDataSourceRole((DataSourceRole) null);
			return;
		case ActionsPackage.EMIT_DATA_ACTION__VARIABLE_REFERENCE:
			setVariableReference((VariableReference) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE:
			return basicGetEventType() != null;
		case ActionsPackage.EMIT_DATA_ACTION__DATA_SOURCE_ROLE:
			return basicGetDataSourceRole() != null;
		case ActionsPackage.EMIT_DATA_ACTION__VARIABLE_REFERENCE:
			return getVariableReference() != null;
		}
		return super.eIsSet(featureID);
	}

} //EmitDataActionImpl
