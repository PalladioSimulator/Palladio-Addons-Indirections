/**
 */
package org.palladiosimulator.simulizar.indirection.system;

import org.eclipse.emf.common.util.EList;

import org.palladiosimulator.pcm.core.composition.EventChannel;

import org.palladiosimulator.pcm.repository.EventGroup;

import org.palladiosimulator.simulizar.indirection.composition.DataChannelSinkConnector;
import org.palladiosimulator.simulizar.indirection.composition.DataChannelSourceConnector;

import org.palladiosimulator.simulizar.indirection.partitioning.Partitioning;
import org.palladiosimulator.simulizar.indirection.partitioning.TimeGrouping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Channel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.system.DataChannel#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.system.DataChannel#getSourceEventGroup <em>Source Event Group</em>}</li>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.system.DataChannel#getSinkEventGroup <em>Sink Event Group</em>}</li>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.system.DataChannel#getDataChannelSourceConnector <em>Data Channel Source Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.system.DataChannel#getDataChannelSinkConnector <em>Data Channel Sink Connector</em>}</li>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.system.DataChannel#getPartitioning <em>Partitioning</em>}</li>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.system.DataChannel#getTimeGrouping <em>Time Grouping</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.simulizar.indirection.system.SystemPackage#getDataChannel()
 * @model
 * @generated
 */
public interface DataChannel extends EventChannel {
	/**
	 * Returns the value of the '<em><b>Capacity</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity</em>' attribute.
	 * @see #setCapacity(int)
	 * @see org.palladiosimulator.simulizar.indirection.system.SystemPackage#getDataChannel_Capacity()
	 * @model default="-1" required="true" transient="true"
	 * @generated
	 */
	int getCapacity();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.simulizar.indirection.system.DataChannel#getCapacity <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity</em>' attribute.
	 * @see #getCapacity()
	 * @generated
	 */
	void setCapacity(int value);

	/**
	 * Returns the value of the '<em><b>Source Event Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Event Group</em>' reference.
	 * @see #setSourceEventGroup(EventGroup)
	 * @see org.palladiosimulator.simulizar.indirection.system.SystemPackage#getDataChannel_SourceEventGroup()
	 * @model required="true"
	 * @generated
	 */
	EventGroup getSourceEventGroup();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.simulizar.indirection.system.DataChannel#getSourceEventGroup <em>Source Event Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Event Group</em>' reference.
	 * @see #getSourceEventGroup()
	 * @generated
	 */
	void setSourceEventGroup(EventGroup value);

	/**
	 * Returns the value of the '<em><b>Sink Event Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sink Event Group</em>' reference.
	 * @see #setSinkEventGroup(EventGroup)
	 * @see org.palladiosimulator.simulizar.indirection.system.SystemPackage#getDataChannel_SinkEventGroup()
	 * @model required="true"
	 * @generated
	 */
	EventGroup getSinkEventGroup();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.simulizar.indirection.system.DataChannel#getSinkEventGroup <em>Sink Event Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sink Event Group</em>' reference.
	 * @see #getSinkEventGroup()
	 * @generated
	 */
	void setSinkEventGroup(EventGroup value);

	/**
	 * Returns the value of the '<em><b>Data Channel Source Connector</b></em>' reference list.
	 * The list contents are of type {@link org.palladiosimulator.simulizar.indirection.composition.DataChannelSourceConnector}.
	 * It is bidirectional and its opposite is '{@link org.palladiosimulator.simulizar.indirection.composition.DataChannelSourceConnector#getDataChannel <em>Data Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Channel Source Connector</em>' reference list.
	 * @see org.palladiosimulator.simulizar.indirection.system.SystemPackage#getDataChannel_DataChannelSourceConnector()
	 * @see org.palladiosimulator.simulizar.indirection.composition.DataChannelSourceConnector#getDataChannel
	 * @model opposite="dataChannel" ordered="false"
	 * @generated
	 */
	EList<DataChannelSourceConnector> getDataChannelSourceConnector();

	/**
	 * Returns the value of the '<em><b>Data Channel Sink Connector</b></em>' reference list.
	 * The list contents are of type {@link org.palladiosimulator.simulizar.indirection.composition.DataChannelSinkConnector}.
	 * It is bidirectional and its opposite is '{@link org.palladiosimulator.simulizar.indirection.composition.DataChannelSinkConnector#getDataChannel <em>Data Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Channel Sink Connector</em>' reference list.
	 * @see org.palladiosimulator.simulizar.indirection.system.SystemPackage#getDataChannel_DataChannelSinkConnector()
	 * @see org.palladiosimulator.simulizar.indirection.composition.DataChannelSinkConnector#getDataChannel
	 * @model opposite="dataChannel" ordered="false"
	 * @generated
	 */
	EList<DataChannelSinkConnector> getDataChannelSinkConnector();

	/**
	 * Returns the value of the '<em><b>Partitioning</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partitioning</em>' containment reference.
	 * @see #setPartitioning(Partitioning)
	 * @see org.palladiosimulator.simulizar.indirection.system.SystemPackage#getDataChannel_Partitioning()
	 * @model containment="true"
	 * @generated
	 */
	Partitioning getPartitioning();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.simulizar.indirection.system.DataChannel#getPartitioning <em>Partitioning</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partitioning</em>' containment reference.
	 * @see #getPartitioning()
	 * @generated
	 */
	void setPartitioning(Partitioning value);

	/**
	 * Returns the value of the '<em><b>Time Grouping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Grouping</em>' containment reference.
	 * @see #setTimeGrouping(TimeGrouping)
	 * @see org.palladiosimulator.simulizar.indirection.system.SystemPackage#getDataChannel_TimeGrouping()
	 * @model containment="true"
	 * @generated
	 */
	TimeGrouping getTimeGrouping();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.simulizar.indirection.system.DataChannel#getTimeGrouping <em>Time Grouping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Grouping</em>' containment reference.
	 * @see #getTimeGrouping()
	 * @generated
	 */
	void setTimeGrouping(TimeGrouping value);

} // DataChannel
