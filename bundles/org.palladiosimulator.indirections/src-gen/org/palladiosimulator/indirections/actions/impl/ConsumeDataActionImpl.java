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
import org.palladiosimulator.indirections.actions.ConsumeDataAction;

import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.pcm.parameter.VariableUsage;

import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.seff.CallAction;
import org.palladiosimulator.pcm.seff.CallReturnAction;
import org.palladiosimulator.pcm.seff.SeffPackage;

import org.palladiosimulator.pcm.seff.impl.AbstractActionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Consume Data Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl#getInputVariableUsages__CallAction <em>Input Variable Usages Call Action</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl#getReturnVariableUsage__CallReturnAction <em>Return Variable Usage Call Return Action</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl#getEventType <em>Event Type</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl#getDataSinkRole <em>Data Sink Role</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsumeDataActionImpl extends AbstractActionImpl implements ConsumeDataAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConsumeDataActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionsPackage.Literals.CONSUME_DATA_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<VariableUsage> getInputVariableUsages__CallAction() {
		return (EList<VariableUsage>) eDynamicGet(ActionsPackage.CONSUME_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION,
				SeffPackage.Literals.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<VariableUsage> getReturnVariableUsage__CallReturnAction() {
		return (EList<VariableUsage>) eDynamicGet(
				ActionsPackage.CONSUME_DATA_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION,
				SeffPackage.Literals.CALL_RETURN_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventType getEventType() {
		return (EventType) eDynamicGet(ActionsPackage.CONSUME_DATA_ACTION__EVENT_TYPE,
				ActionsPackage.Literals.CONSUME_DATA_ACTION__EVENT_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventType basicGetEventType() {
		return (EventType) eDynamicGet(ActionsPackage.CONSUME_DATA_ACTION__EVENT_TYPE,
				ActionsPackage.Literals.CONSUME_DATA_ACTION__EVENT_TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEventType(EventType newEventType) {
		eDynamicSet(ActionsPackage.CONSUME_DATA_ACTION__EVENT_TYPE,
				ActionsPackage.Literals.CONSUME_DATA_ACTION__EVENT_TYPE, newEventType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataSinkRole getDataSinkRole() {
		return (DataSinkRole) eDynamicGet(ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE,
				ActionsPackage.Literals.CONSUME_DATA_ACTION__DATA_SINK_ROLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSinkRole basicGetDataSinkRole() {
		return (DataSinkRole) eDynamicGet(ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE,
				ActionsPackage.Literals.CONSUME_DATA_ACTION__DATA_SINK_ROLE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataSinkRole(DataSinkRole newDataSinkRole) {
		eDynamicSet(ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE,
				ActionsPackage.Literals.CONSUME_DATA_ACTION__DATA_SINK_ROLE, newDataSinkRole);
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
		case ActionsPackage.CONSUME_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInputVariableUsages__CallAction())
					.basicAdd(otherEnd, msgs);
		case ActionsPackage.CONSUME_DATA_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getReturnVariableUsage__CallReturnAction())
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
		case ActionsPackage.CONSUME_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
			return ((InternalEList<?>) getInputVariableUsages__CallAction()).basicRemove(otherEnd, msgs);
		case ActionsPackage.CONSUME_DATA_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
			return ((InternalEList<?>) getReturnVariableUsage__CallReturnAction()).basicRemove(otherEnd, msgs);
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
		case ActionsPackage.CONSUME_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
			return getInputVariableUsages__CallAction();
		case ActionsPackage.CONSUME_DATA_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
			return getReturnVariableUsage__CallReturnAction();
		case ActionsPackage.CONSUME_DATA_ACTION__EVENT_TYPE:
			if (resolve)
				return getEventType();
			return basicGetEventType();
		case ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE:
			if (resolve)
				return getDataSinkRole();
			return basicGetDataSinkRole();
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
		case ActionsPackage.CONSUME_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
			getInputVariableUsages__CallAction().clear();
			getInputVariableUsages__CallAction().addAll((Collection<? extends VariableUsage>) newValue);
			return;
		case ActionsPackage.CONSUME_DATA_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
			getReturnVariableUsage__CallReturnAction().clear();
			getReturnVariableUsage__CallReturnAction().addAll((Collection<? extends VariableUsage>) newValue);
			return;
		case ActionsPackage.CONSUME_DATA_ACTION__EVENT_TYPE:
			setEventType((EventType) newValue);
			return;
		case ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE:
			setDataSinkRole((DataSinkRole) newValue);
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
		case ActionsPackage.CONSUME_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
			getInputVariableUsages__CallAction().clear();
			return;
		case ActionsPackage.CONSUME_DATA_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
			getReturnVariableUsage__CallReturnAction().clear();
			return;
		case ActionsPackage.CONSUME_DATA_ACTION__EVENT_TYPE:
			setEventType((EventType) null);
			return;
		case ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE:
			setDataSinkRole((DataSinkRole) null);
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
		case ActionsPackage.CONSUME_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
			return !getInputVariableUsages__CallAction().isEmpty();
		case ActionsPackage.CONSUME_DATA_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
			return !getReturnVariableUsage__CallReturnAction().isEmpty();
		case ActionsPackage.CONSUME_DATA_ACTION__EVENT_TYPE:
			return basicGetEventType() != null;
		case ActionsPackage.CONSUME_DATA_ACTION__DATA_SINK_ROLE:
			return basicGetDataSinkRole() != null;
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
			case ActionsPackage.CONSUME_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
				return SeffPackage.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION;
			default:
				return -1;
			}
		}
		if (baseClass == CallReturnAction.class) {
			switch (derivedFeatureID) {
			case ActionsPackage.CONSUME_DATA_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
				return SeffPackage.CALL_RETURN_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION;
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
				return ActionsPackage.CONSUME_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION;
			default:
				return -1;
			}
		}
		if (baseClass == CallReturnAction.class) {
			switch (baseFeatureID) {
			case SeffPackage.CALL_RETURN_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
				return ActionsPackage.CONSUME_DATA_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ConsumeDataActionImpl
