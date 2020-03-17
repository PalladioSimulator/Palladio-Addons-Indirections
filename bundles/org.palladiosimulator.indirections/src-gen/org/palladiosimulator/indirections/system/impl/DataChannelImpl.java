/**
 */
package org.palladiosimulator.indirections.system.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;

import org.palladiosimulator.indirections.datatypes.ConsumeFromChannelPolicy;
import org.palladiosimulator.indirections.datatypes.EmitToChannelPolicy;
import org.palladiosimulator.indirections.datatypes.NumberOfElements;
import org.palladiosimulator.indirections.datatypes.Scheduling;

import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.system.SystemPackage;

import org.palladiosimulator.pcm.core.composition.impl.EventChannelImpl;

import org.palladiosimulator.pcm.repository.EventGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Channel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getSourceEventGroup <em>Source Event Group</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getSinkEventGroup <em>Sink Event Group</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getDataChannelSourceConnector <em>Data Channel Source Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getDataChannelSinkConnector <em>Data Channel Sink Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getScheduling <em>Scheduling</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getEmitToChannelPolicy <em>Emit To Channel Policy</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getNumberOfElementsToEmit <em>Number Of Elements To Emit</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getConsumeFromChannelPolicy <em>Consume From Channel Policy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataChannelImpl extends EventChannelImpl implements DataChannel {
	/**
	 * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final int CAPACITY_EDEFAULT = -1;

	/**
	 * The default value of the '{@link #getScheduling() <em>Scheduling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScheduling()
	 * @generated
	 * @ordered
	 */
	protected static final Scheduling SCHEDULING_EDEFAULT = Scheduling.FIRST_IN_FIRST_OUT;

	/**
	 * The default value of the '{@link #getEmitToChannelPolicy() <em>Emit To Channel Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmitToChannelPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final EmitToChannelPolicy EMIT_TO_CHANNEL_POLICY_EDEFAULT = EmitToChannelPolicy.BLOCK_IF_FULL;

	/**
	 * The default value of the '{@link #getNumberOfElementsToEmit() <em>Number Of Elements To Emit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfElementsToEmit()
	 * @generated
	 * @ordered
	 */
	protected static final NumberOfElements NUMBER_OF_ELEMENTS_TO_EMIT_EDEFAULT = NumberOfElements.ANY_NUMBER;

	/**
	 * The default value of the '{@link #getConsumeFromChannelPolicy() <em>Consume From Channel Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsumeFromChannelPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final ConsumeFromChannelPolicy CONSUME_FROM_CHANNEL_POLICY_EDEFAULT = ConsumeFromChannelPolicy.REMOVE;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataChannelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystemPackage.Literals.DATA_CHANNEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCapacity() {
		return (Integer) eDynamicGet(SystemPackage.DATA_CHANNEL__CAPACITY,
				SystemPackage.Literals.DATA_CHANNEL__CAPACITY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCapacity(int newCapacity) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__CAPACITY, SystemPackage.Literals.DATA_CHANNEL__CAPACITY, newCapacity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventGroup getSourceEventGroup() {
		return (EventGroup) eDynamicGet(SystemPackage.DATA_CHANNEL__SOURCE_EVENT_GROUP,
				SystemPackage.Literals.DATA_CHANNEL__SOURCE_EVENT_GROUP, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventGroup basicGetSourceEventGroup() {
		return (EventGroup) eDynamicGet(SystemPackage.DATA_CHANNEL__SOURCE_EVENT_GROUP,
				SystemPackage.Literals.DATA_CHANNEL__SOURCE_EVENT_GROUP, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceEventGroup(EventGroup newSourceEventGroup) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__SOURCE_EVENT_GROUP,
				SystemPackage.Literals.DATA_CHANNEL__SOURCE_EVENT_GROUP, newSourceEventGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventGroup getSinkEventGroup() {
		return (EventGroup) eDynamicGet(SystemPackage.DATA_CHANNEL__SINK_EVENT_GROUP,
				SystemPackage.Literals.DATA_CHANNEL__SINK_EVENT_GROUP, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventGroup basicGetSinkEventGroup() {
		return (EventGroup) eDynamicGet(SystemPackage.DATA_CHANNEL__SINK_EVENT_GROUP,
				SystemPackage.Literals.DATA_CHANNEL__SINK_EVENT_GROUP, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSinkEventGroup(EventGroup newSinkEventGroup) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__SINK_EVENT_GROUP, SystemPackage.Literals.DATA_CHANNEL__SINK_EVENT_GROUP,
				newSinkEventGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<DataChannelSourceConnector> getDataChannelSourceConnector() {
		return (EList<DataChannelSourceConnector>) eDynamicGet(
				SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR,
				SystemPackage.Literals.DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<DataChannelSinkConnector> getDataChannelSinkConnector() {
		return (EList<DataChannelSinkConnector>) eDynamicGet(SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR,
				SystemPackage.Literals.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Scheduling getScheduling() {
		return (Scheduling) eDynamicGet(SystemPackage.DATA_CHANNEL__SCHEDULING,
				SystemPackage.Literals.DATA_CHANNEL__SCHEDULING, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduling(Scheduling newScheduling) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__SCHEDULING, SystemPackage.Literals.DATA_CHANNEL__SCHEDULING,
				newScheduling);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EmitToChannelPolicy getEmitToChannelPolicy() {
		return (EmitToChannelPolicy) eDynamicGet(SystemPackage.DATA_CHANNEL__EMIT_TO_CHANNEL_POLICY,
				SystemPackage.Literals.DATA_CHANNEL__EMIT_TO_CHANNEL_POLICY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEmitToChannelPolicy(EmitToChannelPolicy newEmitToChannelPolicy) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__EMIT_TO_CHANNEL_POLICY,
				SystemPackage.Literals.DATA_CHANNEL__EMIT_TO_CHANNEL_POLICY, newEmitToChannelPolicy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NumberOfElements getNumberOfElementsToEmit() {
		return (NumberOfElements) eDynamicGet(SystemPackage.DATA_CHANNEL__NUMBER_OF_ELEMENTS_TO_EMIT,
				SystemPackage.Literals.DATA_CHANNEL__NUMBER_OF_ELEMENTS_TO_EMIT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumberOfElementsToEmit(NumberOfElements newNumberOfElementsToEmit) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__NUMBER_OF_ELEMENTS_TO_EMIT,
				SystemPackage.Literals.DATA_CHANNEL__NUMBER_OF_ELEMENTS_TO_EMIT, newNumberOfElementsToEmit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConsumeFromChannelPolicy getConsumeFromChannelPolicy() {
		return (ConsumeFromChannelPolicy) eDynamicGet(SystemPackage.DATA_CHANNEL__CONSUME_FROM_CHANNEL_POLICY,
				SystemPackage.Literals.DATA_CHANNEL__CONSUME_FROM_CHANNEL_POLICY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConsumeFromChannelPolicy(ConsumeFromChannelPolicy newConsumeFromChannelPolicy) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__CONSUME_FROM_CHANNEL_POLICY,
				SystemPackage.Literals.DATA_CHANNEL__CONSUME_FROM_CHANNEL_POLICY, newConsumeFromChannelPolicy);
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
		case SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDataChannelSourceConnector())
					.basicAdd(otherEnd, msgs);
		case SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDataChannelSinkConnector())
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
		case SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR:
			return ((InternalEList<?>) getDataChannelSourceConnector()).basicRemove(otherEnd, msgs);
		case SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR:
			return ((InternalEList<?>) getDataChannelSinkConnector()).basicRemove(otherEnd, msgs);
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
		case SystemPackage.DATA_CHANNEL__CAPACITY:
			return getCapacity();
		case SystemPackage.DATA_CHANNEL__SOURCE_EVENT_GROUP:
			if (resolve)
				return getSourceEventGroup();
			return basicGetSourceEventGroup();
		case SystemPackage.DATA_CHANNEL__SINK_EVENT_GROUP:
			if (resolve)
				return getSinkEventGroup();
			return basicGetSinkEventGroup();
		case SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR:
			return getDataChannelSourceConnector();
		case SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR:
			return getDataChannelSinkConnector();
		case SystemPackage.DATA_CHANNEL__SCHEDULING:
			return getScheduling();
		case SystemPackage.DATA_CHANNEL__EMIT_TO_CHANNEL_POLICY:
			return getEmitToChannelPolicy();
		case SystemPackage.DATA_CHANNEL__NUMBER_OF_ELEMENTS_TO_EMIT:
			return getNumberOfElementsToEmit();
		case SystemPackage.DATA_CHANNEL__CONSUME_FROM_CHANNEL_POLICY:
			return getConsumeFromChannelPolicy();
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
		case SystemPackage.DATA_CHANNEL__CAPACITY:
			setCapacity((Integer) newValue);
			return;
		case SystemPackage.DATA_CHANNEL__SOURCE_EVENT_GROUP:
			setSourceEventGroup((EventGroup) newValue);
			return;
		case SystemPackage.DATA_CHANNEL__SINK_EVENT_GROUP:
			setSinkEventGroup((EventGroup) newValue);
			return;
		case SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR:
			getDataChannelSourceConnector().clear();
			getDataChannelSourceConnector().addAll((Collection<? extends DataChannelSourceConnector>) newValue);
			return;
		case SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR:
			getDataChannelSinkConnector().clear();
			getDataChannelSinkConnector().addAll((Collection<? extends DataChannelSinkConnector>) newValue);
			return;
		case SystemPackage.DATA_CHANNEL__SCHEDULING:
			setScheduling((Scheduling) newValue);
			return;
		case SystemPackage.DATA_CHANNEL__EMIT_TO_CHANNEL_POLICY:
			setEmitToChannelPolicy((EmitToChannelPolicy) newValue);
			return;
		case SystemPackage.DATA_CHANNEL__NUMBER_OF_ELEMENTS_TO_EMIT:
			setNumberOfElementsToEmit((NumberOfElements) newValue);
			return;
		case SystemPackage.DATA_CHANNEL__CONSUME_FROM_CHANNEL_POLICY:
			setConsumeFromChannelPolicy((ConsumeFromChannelPolicy) newValue);
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
		case SystemPackage.DATA_CHANNEL__CAPACITY:
			setCapacity(CAPACITY_EDEFAULT);
			return;
		case SystemPackage.DATA_CHANNEL__SOURCE_EVENT_GROUP:
			setSourceEventGroup((EventGroup) null);
			return;
		case SystemPackage.DATA_CHANNEL__SINK_EVENT_GROUP:
			setSinkEventGroup((EventGroup) null);
			return;
		case SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR:
			getDataChannelSourceConnector().clear();
			return;
		case SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR:
			getDataChannelSinkConnector().clear();
			return;
		case SystemPackage.DATA_CHANNEL__SCHEDULING:
			setScheduling(SCHEDULING_EDEFAULT);
			return;
		case SystemPackage.DATA_CHANNEL__EMIT_TO_CHANNEL_POLICY:
			setEmitToChannelPolicy(EMIT_TO_CHANNEL_POLICY_EDEFAULT);
			return;
		case SystemPackage.DATA_CHANNEL__NUMBER_OF_ELEMENTS_TO_EMIT:
			setNumberOfElementsToEmit(NUMBER_OF_ELEMENTS_TO_EMIT_EDEFAULT);
			return;
		case SystemPackage.DATA_CHANNEL__CONSUME_FROM_CHANNEL_POLICY:
			setConsumeFromChannelPolicy(CONSUME_FROM_CHANNEL_POLICY_EDEFAULT);
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
		case SystemPackage.DATA_CHANNEL__CAPACITY:
			return getCapacity() != CAPACITY_EDEFAULT;
		case SystemPackage.DATA_CHANNEL__SOURCE_EVENT_GROUP:
			return basicGetSourceEventGroup() != null;
		case SystemPackage.DATA_CHANNEL__SINK_EVENT_GROUP:
			return basicGetSinkEventGroup() != null;
		case SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR:
			return !getDataChannelSourceConnector().isEmpty();
		case SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR:
			return !getDataChannelSinkConnector().isEmpty();
		case SystemPackage.DATA_CHANNEL__SCHEDULING:
			return getScheduling() != SCHEDULING_EDEFAULT;
		case SystemPackage.DATA_CHANNEL__EMIT_TO_CHANNEL_POLICY:
			return getEmitToChannelPolicy() != EMIT_TO_CHANNEL_POLICY_EDEFAULT;
		case SystemPackage.DATA_CHANNEL__NUMBER_OF_ELEMENTS_TO_EMIT:
			return getNumberOfElementsToEmit() != NUMBER_OF_ELEMENTS_TO_EMIT_EDEFAULT;
		case SystemPackage.DATA_CHANNEL__CONSUME_FROM_CHANNEL_POLICY:
			return getConsumeFromChannelPolicy() != CONSUME_FROM_CHANNEL_POLICY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //DataChannelImpl
