/**
 */
package org.palladiosimulator.indirections.system;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.datatypes.OutgoingDistribution;
import org.palladiosimulator.indirections.datatypes.PutPolicy;
import org.palladiosimulator.indirections.datatypes.Scheduling;
import org.palladiosimulator.indirections.partitioning.Joining;
import org.palladiosimulator.indirections.partitioning.Partitioning;
import org.palladiosimulator.indirections.partitioning.TimeGrouping;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.repository.EventGroup;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Data Channel</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.system.DataChannel#getCapacity
 * <em>Capacity</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.DataChannel#getSourceEventGroup <em>Source
 * Event Group</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.DataChannel#getSinkEventGroup <em>Sink Event
 * Group</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.DataChannel#getDataChannelSourceConnector
 * <em>Data Channel Source Connector</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.DataChannel#getDataChannelSinkConnector
 * <em>Data Channel Sink Connector</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.DataChannel#getPartitioning
 * <em>Partitioning</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.DataChannel#getTimeGrouping <em>Time
 * Grouping</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.DataChannel#getJoins <em>Joins</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.DataChannel#getOutgoingDistribution
 * <em>Outgoing Distribution</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.DataChannel#getScheduling
 * <em>Scheduling</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.DataChannel#getPutPolicy <em>Put
 * Policy</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel()
 * @model
 * @generated
 */
public interface DataChannel extends Entity {
    /**
     * Returns the value of the '<em><b>Capacity</b></em>' attribute. The default value is
     * <code>"-1"</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Capacity</em>' attribute.
     * @see #setCapacity(int)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel_Capacity()
     * @model default="-1" required="true" transient="true"
     * @generated
     */
    int getCapacity();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.DataChannel#getCapacity <em>Capacity</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Capacity</em>' attribute.
     * @see #getCapacity()
     * @generated
     */
    void setCapacity(int value);

    /**
     * Returns the value of the '<em><b>Source Event Group</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Source Event Group</em>' reference.
     * @see #setSourceEventGroup(EventGroup)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel_SourceEventGroup()
     * @model required="true"
     * @generated
     */
    EventGroup getSourceEventGroup();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.DataChannel#getSourceEventGroup <em>Source
     * Event Group</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Source Event Group</em>' reference.
     * @see #getSourceEventGroup()
     * @generated
     */
    void setSourceEventGroup(EventGroup value);

    /**
     * Returns the value of the '<em><b>Sink Event Group</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Sink Event Group</em>' reference.
     * @see #setSinkEventGroup(EventGroup)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel_SinkEventGroup()
     * @model required="true"
     * @generated
     */
    EventGroup getSinkEventGroup();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.DataChannel#getSinkEventGroup <em>Sink
     * Event Group</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Sink Event Group</em>' reference.
     * @see #getSinkEventGroup()
     * @generated
     */
    void setSinkEventGroup(EventGroup value);

    /**
     * Returns the value of the '<em><b>Data Channel Source Connector</b></em>' reference list. The
     * list contents are of type
     * {@link org.palladiosimulator.indirections.composition.DataChannelSourceConnector}. It is
     * bidirectional and its opposite is
     * '{@link org.palladiosimulator.indirections.composition.DataChannelSourceConnector#getDataChannel
     * <em>Data Channel</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Data Channel Source Connector</em>' reference list.
     * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel_DataChannelSourceConnector()
     * @see org.palladiosimulator.indirections.composition.DataChannelSourceConnector#getDataChannel
     * @model opposite="dataChannel" ordered="false"
     * @generated
     */
    EList<DataChannelSourceConnector> getDataChannelSourceConnector();

    /**
     * Returns the value of the '<em><b>Data Channel Sink Connector</b></em>' reference list. The
     * list contents are of type
     * {@link org.palladiosimulator.indirections.composition.DataChannelSinkConnector}. It is
     * bidirectional and its opposite is
     * '{@link org.palladiosimulator.indirections.composition.DataChannelSinkConnector#getDataChannel
     * <em>Data Channel</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Data Channel Sink Connector</em>' reference list.
     * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel_DataChannelSinkConnector()
     * @see org.palladiosimulator.indirections.composition.DataChannelSinkConnector#getDataChannel
     * @model opposite="dataChannel" ordered="false"
     * @generated
     */
    EList<DataChannelSinkConnector> getDataChannelSinkConnector();

    /**
     * Returns the value of the '<em><b>Partitioning</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Partitioning</em>' containment reference.
     * @see #setPartitioning(Partitioning)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel_Partitioning()
     * @model containment="true"
     * @generated
     */
    Partitioning getPartitioning();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.DataChannel#getPartitioning
     * <em>Partitioning</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Partitioning</em>' containment reference.
     * @see #getPartitioning()
     * @generated
     */
    void setPartitioning(Partitioning value);

    /**
     * Returns the value of the '<em><b>Time Grouping</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Time Grouping</em>' containment reference.
     * @see #setTimeGrouping(TimeGrouping)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel_TimeGrouping()
     * @model containment="true"
     * @generated
     */
    TimeGrouping getTimeGrouping();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.DataChannel#getTimeGrouping <em>Time
     * Grouping</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Time Grouping</em>' containment reference.
     * @see #getTimeGrouping()
     * @generated
     */
    void setTimeGrouping(TimeGrouping value);

    /**
     * Returns the value of the '<em><b>Joins</b></em>' reference list. The list contents are of
     * type {@link org.palladiosimulator.indirections.partitioning.Joining}. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Joins</em>' reference list.
     * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel_Joins()
     * @model
     * @generated
     */
    EList<Joining> getJoins();

    /**
     * Returns the value of the '<em><b>Outgoing Distribution</b></em>' attribute. The literals are
     * from the enumeration
     * {@link org.palladiosimulator.indirections.datatypes.OutgoingDistribution}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Outgoing Distribution</em>' attribute.
     * @see org.palladiosimulator.indirections.datatypes.OutgoingDistribution
     * @see #setOutgoingDistribution(OutgoingDistribution)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel_OutgoingDistribution()
     * @model
     * @generated
     */
    OutgoingDistribution getOutgoingDistribution();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.DataChannel#getOutgoingDistribution
     * <em>Outgoing Distribution</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Outgoing Distribution</em>' attribute.
     * @see org.palladiosimulator.indirections.datatypes.OutgoingDistribution
     * @see #getOutgoingDistribution()
     * @generated
     */
    void setOutgoingDistribution(OutgoingDistribution value);

    /**
     * Returns the value of the '<em><b>Scheduling</b></em>' attribute. The literals are from the
     * enumeration {@link org.palladiosimulator.indirections.datatypes.Scheduling}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Scheduling</em>' attribute.
     * @see org.palladiosimulator.indirections.datatypes.Scheduling
     * @see #setScheduling(Scheduling)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel_Scheduling()
     * @model
     * @generated
     */
    Scheduling getScheduling();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.DataChannel#getScheduling
     * <em>Scheduling</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Scheduling</em>' attribute.
     * @see org.palladiosimulator.indirections.datatypes.Scheduling
     * @see #getScheduling()
     * @generated
     */
    void setScheduling(Scheduling value);

    /**
     * Returns the value of the '<em><b>Put Policy</b></em>' attribute. The literals are from the
     * enumeration {@link org.palladiosimulator.indirections.datatypes.PutPolicy}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Put Policy</em>' attribute.
     * @see org.palladiosimulator.indirections.datatypes.PutPolicy
     * @see #setPutPolicy(PutPolicy)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel_PutPolicy()
     * @model
     * @generated
     */
    PutPolicy getPutPolicy();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.DataChannel#getPutPolicy <em>Put
     * Policy</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Put Policy</em>' attribute.
     * @see org.palladiosimulator.indirections.datatypes.PutPolicy
     * @see #getPutPolicy()
     * @generated
     */
    void setPutPolicy(PutPolicy value);

} // DataChannel
