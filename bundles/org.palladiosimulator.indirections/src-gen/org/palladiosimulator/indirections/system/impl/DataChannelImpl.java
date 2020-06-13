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
import org.palladiosimulator.indirections.datatypes.OutgoingDistribution;
import org.palladiosimulator.indirections.datatypes.PutPolicy;
import org.palladiosimulator.indirections.datatypes.Scheduling;
import org.palladiosimulator.indirections.partitioning.Joining;
import org.palladiosimulator.indirections.partitioning.Partitioning;
import org.palladiosimulator.indirections.partitioning.TimeGrouping;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.system.SystemPackage;
import org.palladiosimulator.pcm.core.composition.impl.EventChannelImpl;
import org.palladiosimulator.pcm.repository.EventGroup;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Data Channel</b></em>'.
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
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getPartitioning <em>Partitioning</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getTimeGrouping <em>Time Grouping</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getJoins <em>Joins</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getOutgoingDistribution <em>Outgoing Distribution</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getScheduling <em>Scheduling</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl#getPutPolicy <em>Put Policy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataChannelImpl extends EventChannelImpl implements DataChannel {
	/**
	 * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final int CAPACITY_EDEFAULT = -1;

	/**
	 * The default value of the '{@link #getOutgoingDistribution() <em>Outgoing Distribution</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOutgoingDistribution()
	 * @generated
	 * @ordered
	 */
	protected static final OutgoingDistribution OUTGOING_DISTRIBUTION_EDEFAULT = OutgoingDistribution.DISTRIBUTE_TO_ALL;

	/**
	 * The default value of the '{@link #getScheduling() <em>Scheduling</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getScheduling()
	 * @generated
	 * @ordered
	 */
	protected static final Scheduling SCHEDULING_EDEFAULT = Scheduling.FIRST_IN_FIRST_OUT;

	/**
	 * The default value of the '{@link #getPutPolicy() <em>Put Policy</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getPutPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final PutPolicy PUT_POLICY_EDEFAULT = PutPolicy.BLOCKING;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DataChannelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystemPackage.Literals.DATA_CHANNEL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCapacity() {
		return (Integer) eDynamicGet(SystemPackage.DATA_CHANNEL__CAPACITY,
				SystemPackage.Literals.DATA_CHANNEL__CAPACITY, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCapacity(int newCapacity) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__CAPACITY, SystemPackage.Literals.DATA_CHANNEL__CAPACITY, newCapacity);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventGroup getSourceEventGroup() {
		return (EventGroup) eDynamicGet(SystemPackage.DATA_CHANNEL__SOURCE_EVENT_GROUP,
				SystemPackage.Literals.DATA_CHANNEL__SOURCE_EVENT_GROUP, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EventGroup basicGetSourceEventGroup() {
		return (EventGroup) eDynamicGet(SystemPackage.DATA_CHANNEL__SOURCE_EVENT_GROUP,
				SystemPackage.Literals.DATA_CHANNEL__SOURCE_EVENT_GROUP, false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceEventGroup(EventGroup newSourceEventGroup) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__SOURCE_EVENT_GROUP,
				SystemPackage.Literals.DATA_CHANNEL__SOURCE_EVENT_GROUP, newSourceEventGroup);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventGroup getSinkEventGroup() {
		return (EventGroup) eDynamicGet(SystemPackage.DATA_CHANNEL__SINK_EVENT_GROUP,
				SystemPackage.Literals.DATA_CHANNEL__SINK_EVENT_GROUP, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EventGroup basicGetSinkEventGroup() {
		return (EventGroup) eDynamicGet(SystemPackage.DATA_CHANNEL__SINK_EVENT_GROUP,
				SystemPackage.Literals.DATA_CHANNEL__SINK_EVENT_GROUP, false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSinkEventGroup(EventGroup newSinkEventGroup) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__SINK_EVENT_GROUP, SystemPackage.Literals.DATA_CHANNEL__SINK_EVENT_GROUP,
				newSinkEventGroup);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<DataChannelSinkConnector> getDataChannelSinkConnector() {
		return (EList<DataChannelSinkConnector>) eDynamicGet(SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR,
				SystemPackage.Literals.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Partitioning getPartitioning() {
		return (Partitioning) eDynamicGet(SystemPackage.DATA_CHANNEL__PARTITIONING,
				SystemPackage.Literals.DATA_CHANNEL__PARTITIONING, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPartitioning(Partitioning newPartitioning, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newPartitioning, SystemPackage.DATA_CHANNEL__PARTITIONING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPartitioning(Partitioning newPartitioning) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__PARTITIONING, SystemPackage.Literals.DATA_CHANNEL__PARTITIONING,
				newPartitioning);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TimeGrouping getTimeGrouping() {
		return (TimeGrouping) eDynamicGet(SystemPackage.DATA_CHANNEL__TIME_GROUPING,
				SystemPackage.Literals.DATA_CHANNEL__TIME_GROUPING, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeGrouping(TimeGrouping newTimeGrouping, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newTimeGrouping, SystemPackage.DATA_CHANNEL__TIME_GROUPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeGrouping(TimeGrouping newTimeGrouping) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__TIME_GROUPING, SystemPackage.Literals.DATA_CHANNEL__TIME_GROUPING,
				newTimeGrouping);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Joining> getJoins() {
		return (EList<Joining>) eDynamicGet(SystemPackage.DATA_CHANNEL__JOINS,
				SystemPackage.Literals.DATA_CHANNEL__JOINS, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OutgoingDistribution getOutgoingDistribution() {
		return (OutgoingDistribution) eDynamicGet(SystemPackage.DATA_CHANNEL__OUTGOING_DISTRIBUTION,
				SystemPackage.Literals.DATA_CHANNEL__OUTGOING_DISTRIBUTION, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutgoingDistribution(OutgoingDistribution newOutgoingDistribution) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__OUTGOING_DISTRIBUTION,
				SystemPackage.Literals.DATA_CHANNEL__OUTGOING_DISTRIBUTION, newOutgoingDistribution);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Scheduling getScheduling() {
		return (Scheduling) eDynamicGet(SystemPackage.DATA_CHANNEL__SCHEDULING,
				SystemPackage.Literals.DATA_CHANNEL__SCHEDULING, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduling(Scheduling newScheduling) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__SCHEDULING, SystemPackage.Literals.DATA_CHANNEL__SCHEDULING,
				newScheduling);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PutPolicy getPutPolicy() {
		return (PutPolicy) eDynamicGet(SystemPackage.DATA_CHANNEL__PUT_POLICY,
				SystemPackage.Literals.DATA_CHANNEL__PUT_POLICY, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPutPolicy(PutPolicy newPutPolicy) {
		eDynamicSet(SystemPackage.DATA_CHANNEL__PUT_POLICY, SystemPackage.Literals.DATA_CHANNEL__PUT_POLICY,
				newPutPolicy);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR:
			return ((InternalEList<?>) getDataChannelSourceConnector()).basicRemove(otherEnd, msgs);
		case SystemPackage.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR:
			return ((InternalEList<?>) getDataChannelSinkConnector()).basicRemove(otherEnd, msgs);
		case SystemPackage.DATA_CHANNEL__PARTITIONING:
			return basicSetPartitioning(null, msgs);
		case SystemPackage.DATA_CHANNEL__TIME_GROUPING:
			return basicSetTimeGrouping(null, msgs);
		case SystemPackage.DATA_CHANNEL__JOINS:
			return ((InternalEList<?>) getJoins()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		case SystemPackage.DATA_CHANNEL__PARTITIONING:
			return getPartitioning();
		case SystemPackage.DATA_CHANNEL__TIME_GROUPING:
			return getTimeGrouping();
		case SystemPackage.DATA_CHANNEL__JOINS:
			return getJoins();
		case SystemPackage.DATA_CHANNEL__OUTGOING_DISTRIBUTION:
			return getOutgoingDistribution();
		case SystemPackage.DATA_CHANNEL__SCHEDULING:
			return getScheduling();
		case SystemPackage.DATA_CHANNEL__PUT_POLICY:
			return getPutPolicy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		case SystemPackage.DATA_CHANNEL__PARTITIONING:
			setPartitioning((Partitioning) newValue);
			return;
		case SystemPackage.DATA_CHANNEL__TIME_GROUPING:
			setTimeGrouping((TimeGrouping) newValue);
			return;
		case SystemPackage.DATA_CHANNEL__JOINS:
			getJoins().clear();
			getJoins().addAll((Collection<? extends Joining>) newValue);
			return;
		case SystemPackage.DATA_CHANNEL__OUTGOING_DISTRIBUTION:
			setOutgoingDistribution((OutgoingDistribution) newValue);
			return;
		case SystemPackage.DATA_CHANNEL__SCHEDULING:
			setScheduling((Scheduling) newValue);
			return;
		case SystemPackage.DATA_CHANNEL__PUT_POLICY:
			setPutPolicy((PutPolicy) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		case SystemPackage.DATA_CHANNEL__PARTITIONING:
			setPartitioning((Partitioning) null);
			return;
		case SystemPackage.DATA_CHANNEL__TIME_GROUPING:
			setTimeGrouping((TimeGrouping) null);
			return;
		case SystemPackage.DATA_CHANNEL__JOINS:
			getJoins().clear();
			return;
		case SystemPackage.DATA_CHANNEL__OUTGOING_DISTRIBUTION:
			setOutgoingDistribution(OUTGOING_DISTRIBUTION_EDEFAULT);
			return;
		case SystemPackage.DATA_CHANNEL__SCHEDULING:
			setScheduling(SCHEDULING_EDEFAULT);
			return;
		case SystemPackage.DATA_CHANNEL__PUT_POLICY:
			setPutPolicy(PUT_POLICY_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		case SystemPackage.DATA_CHANNEL__PARTITIONING:
			return getPartitioning() != null;
		case SystemPackage.DATA_CHANNEL__TIME_GROUPING:
			return getTimeGrouping() != null;
		case SystemPackage.DATA_CHANNEL__JOINS:
			return !getJoins().isEmpty();
		case SystemPackage.DATA_CHANNEL__OUTGOING_DISTRIBUTION:
			return getOutgoingDistribution() != OUTGOING_DISTRIBUTION_EDEFAULT;
		case SystemPackage.DATA_CHANNEL__SCHEDULING:
			return getScheduling() != SCHEDULING_EDEFAULT;
		case SystemPackage.DATA_CHANNEL__PUT_POLICY:
			return getPutPolicy() != PUT_POLICY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} // DataChannelImpl
