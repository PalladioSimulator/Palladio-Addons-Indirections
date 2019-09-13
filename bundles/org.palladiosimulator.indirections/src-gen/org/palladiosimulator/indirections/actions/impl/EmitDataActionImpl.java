/**
 */
package org.palladiosimulator.indirections.actions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.EmitDataAction;

import org.palladiosimulator.pcm.parameter.VariableUsage;

import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.repository.SourceRole;

import org.palladiosimulator.pcm.seff.CallAction;
import org.palladiosimulator.pcm.seff.SeffPackage;

import org.palladiosimulator.pcm.seff.impl.AbstractActionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Emit Data Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl#getInputVariableUsages__CallAction <em>Input Variable Usages Call Action</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl#getEventType <em>Event Type</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl#getSourceRole <em>Source Role</em>}</li>
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
	@SuppressWarnings("unchecked")
	@Override
	public EList<VariableUsage> getInputVariableUsages__CallAction() {
		return (EList<VariableUsage>) eDynamicGet(ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION,
				SeffPackage.Literals.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION, true, true);
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
	public SourceRole getSourceRole() {
		return (SourceRole) eDynamicGet(ActionsPackage.EMIT_DATA_ACTION__SOURCE_ROLE,
				ActionsPackage.Literals.EMIT_DATA_ACTION__SOURCE_ROLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceRole basicGetSourceRole() {
		return (SourceRole) eDynamicGet(ActionsPackage.EMIT_DATA_ACTION__SOURCE_ROLE,
				ActionsPackage.Literals.EMIT_DATA_ACTION__SOURCE_ROLE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceRole(SourceRole newSourceRole) {
		eDynamicSet(ActionsPackage.EMIT_DATA_ACTION__SOURCE_ROLE, ActionsPackage.Literals.EMIT_DATA_ACTION__SOURCE_ROLE,
				newSourceRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInputVariableUsages__CallAction())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
			return ((InternalEList<?>) getInputVariableUsages__CallAction()).basicRemove(otherEnd, msgs);
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
		case ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
			return getInputVariableUsages__CallAction();
		case ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE:
			if (resolve)
				return getEventType();
			return basicGetEventType();
		case ActionsPackage.EMIT_DATA_ACTION__SOURCE_ROLE:
			if (resolve)
				return getSourceRole();
			return basicGetSourceRole();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
			getInputVariableUsages__CallAction().clear();
			getInputVariableUsages__CallAction().addAll((Collection<? extends VariableUsage>) newValue);
			return;
		case ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE:
			setEventType((EventType) newValue);
			return;
		case ActionsPackage.EMIT_DATA_ACTION__SOURCE_ROLE:
			setSourceRole((SourceRole) newValue);
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
		case ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
			getInputVariableUsages__CallAction().clear();
			return;
		case ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE:
			setEventType((EventType) null);
			return;
		case ActionsPackage.EMIT_DATA_ACTION__SOURCE_ROLE:
			setSourceRole((SourceRole) null);
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
		case ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
			return !getInputVariableUsages__CallAction().isEmpty();
		case ActionsPackage.EMIT_DATA_ACTION__EVENT_TYPE:
			return basicGetEventType() != null;
		case ActionsPackage.EMIT_DATA_ACTION__SOURCE_ROLE:
			return basicGetSourceRole() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == CallAction.class) {
			switch (derivedFeatureID) {
			case ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
				return SeffPackage.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == CallAction.class) {
			switch (baseFeatureID) {
			case SeffPackage.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
				return ActionsPackage.EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //EmitDataActionImpl
