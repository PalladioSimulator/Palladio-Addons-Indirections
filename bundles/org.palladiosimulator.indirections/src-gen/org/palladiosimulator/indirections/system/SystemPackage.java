/**
 */
package org.palladiosimulator.indirections.system;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.palladiosimulator.pcm.core.composition.CompositionPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.indirections.system.SystemFactory
 * @model kind="package"
 * @generated
 */
public interface SystemPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "system";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://palladiosimulator.org/Indirections/System/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.palladiosimulator.indirections.system";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SystemPackage eINSTANCE = org.palladiosimulator.indirections.system.impl.SystemPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl <em>Data Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.system.impl.DataChannelImpl
	 * @see org.palladiosimulator.indirections.system.impl.SystemPackageImpl#getDataChannel()
	 * @generated
	 */
	int DATA_CHANNEL = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL__ID = CompositionPackage.EVENT_CHANNEL__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL__ENTITY_NAME = CompositionPackage.EVENT_CHANNEL__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Event Group Event Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL__EVENT_GROUP_EVENT_CHANNEL = CompositionPackage.EVENT_CHANNEL__EVENT_GROUP_EVENT_CHANNEL;

	/**
	 * The feature id for the '<em><b>Event Channel Source Connector Event Channel</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL = CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL;

	/**
	 * The feature id for the '<em><b>Event Channel Sink Connector Event Channel</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL = CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL;

	/**
	 * The feature id for the '<em><b>Parent Structure Event Channel</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL = CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL__CAPACITY = CompositionPackage.EVENT_CHANNEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Event Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL__SOURCE_EVENT_GROUP = CompositionPackage.EVENT_CHANNEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sink Event Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL__SINK_EVENT_GROUP = CompositionPackage.EVENT_CHANNEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data Channel Source Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR = CompositionPackage.EVENT_CHANNEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Data Channel Sink Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR = CompositionPackage.EVENT_CHANNEL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Partitioning</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL__PARTITIONING = CompositionPackage.EVENT_CHANNEL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Time Grouping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL__TIME_GROUPING = CompositionPackage.EVENT_CHANNEL_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Data Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_FEATURE_COUNT = CompositionPackage.EVENT_CHANNEL_FEATURE_COUNT + 7;

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.system.DataChannel <em>Data Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Channel</em>'.
	 * @see org.palladiosimulator.indirections.system.DataChannel
	 * @generated
	 */
	EClass getDataChannel();

	/**
	 * Returns the meta object for the attribute '{@link org.palladiosimulator.indirections.system.DataChannel#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see org.palladiosimulator.indirections.system.DataChannel#getCapacity()
	 * @see #getDataChannel()
	 * @generated
	 */
	EAttribute getDataChannel_Capacity();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.system.DataChannel#getSourceEventGroup <em>Source Event Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Event Group</em>'.
	 * @see org.palladiosimulator.indirections.system.DataChannel#getSourceEventGroup()
	 * @see #getDataChannel()
	 * @generated
	 */
	EReference getDataChannel_SourceEventGroup();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.system.DataChannel#getSinkEventGroup <em>Sink Event Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sink Event Group</em>'.
	 * @see org.palladiosimulator.indirections.system.DataChannel#getSinkEventGroup()
	 * @see #getDataChannel()
	 * @generated
	 */
	EReference getDataChannel_SinkEventGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.palladiosimulator.indirections.system.DataChannel#getDataChannelSourceConnector <em>Data Channel Source Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data Channel Source Connector</em>'.
	 * @see org.palladiosimulator.indirections.system.DataChannel#getDataChannelSourceConnector()
	 * @see #getDataChannel()
	 * @generated
	 */
	EReference getDataChannel_DataChannelSourceConnector();

	/**
	 * Returns the meta object for the reference list '{@link org.palladiosimulator.indirections.system.DataChannel#getDataChannelSinkConnector <em>Data Channel Sink Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data Channel Sink Connector</em>'.
	 * @see org.palladiosimulator.indirections.system.DataChannel#getDataChannelSinkConnector()
	 * @see #getDataChannel()
	 * @generated
	 */
	EReference getDataChannel_DataChannelSinkConnector();

	/**
	 * Returns the meta object for the containment reference '{@link org.palladiosimulator.indirections.system.DataChannel#getPartitioning <em>Partitioning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Partitioning</em>'.
	 * @see org.palladiosimulator.indirections.system.DataChannel#getPartitioning()
	 * @see #getDataChannel()
	 * @generated
	 */
	EReference getDataChannel_Partitioning();

	/**
	 * Returns the meta object for the containment reference '{@link org.palladiosimulator.indirections.system.DataChannel#getTimeGrouping <em>Time Grouping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Grouping</em>'.
	 * @see org.palladiosimulator.indirections.system.DataChannel#getTimeGrouping()
	 * @see #getDataChannel()
	 * @generated
	 */
	EReference getDataChannel_TimeGrouping();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SystemFactory getSystemFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl <em>Data Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.system.impl.DataChannelImpl
		 * @see org.palladiosimulator.indirections.system.impl.SystemPackageImpl#getDataChannel()
		 * @generated
		 */
		EClass DATA_CHANNEL = eINSTANCE.getDataChannel();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_CHANNEL__CAPACITY = eINSTANCE.getDataChannel_Capacity();

		/**
		 * The meta object literal for the '<em><b>Source Event Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL__SOURCE_EVENT_GROUP = eINSTANCE.getDataChannel_SourceEventGroup();

		/**
		 * The meta object literal for the '<em><b>Sink Event Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL__SINK_EVENT_GROUP = eINSTANCE.getDataChannel_SinkEventGroup();

		/**
		 * The meta object literal for the '<em><b>Data Channel Source Connector</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR = eINSTANCE.getDataChannel_DataChannelSourceConnector();

		/**
		 * The meta object literal for the '<em><b>Data Channel Sink Connector</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR = eINSTANCE.getDataChannel_DataChannelSinkConnector();

		/**
		 * The meta object literal for the '<em><b>Partitioning</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL__PARTITIONING = eINSTANCE.getDataChannel_Partitioning();

		/**
		 * The meta object literal for the '<em><b>Time Grouping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL__TIME_GROUPING = eINSTANCE.getDataChannel_TimeGrouping();

	}

} //SystemPackage
