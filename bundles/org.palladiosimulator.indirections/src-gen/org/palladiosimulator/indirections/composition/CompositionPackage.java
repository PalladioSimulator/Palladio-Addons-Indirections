/**
 */
package org.palladiosimulator.indirections.composition;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.palladiosimulator.indirections.composition.CompositionFactory
 * @model kind="package"
 * @generated
 */
public interface CompositionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "composition";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://palladiosimulator.org/Indirections/Composition/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.palladiosimulator.indirections.composition";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompositionPackage eINSTANCE = org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.composition.impl.DataChannelSourceConnectorImpl <em>Data Channel Source Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.composition.impl.DataChannelSourceConnectorImpl
	 * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getDataChannelSourceConnector()
	 * @generated
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR__ID = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR__ENTITY_NAME = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Data Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
			+ 0;

	/**
	 * The feature id for the '<em><b>Assembly Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
			+ 1;

	/**
	 * The feature id for the '<em><b>Data Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
			+ 2;

	/**
	 * The number of structural features of the '<em>Data Channel Source Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR_FEATURE_COUNT = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
			+ 3;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.composition.impl.DataChannelSinkConnectorImpl <em>Data Channel Sink Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.composition.impl.DataChannelSinkConnectorImpl
	 * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getDataChannelSinkConnector()
	 * @generated
	 */
	int DATA_CHANNEL_SINK_CONNECTOR = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SINK_CONNECTOR__ID = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SINK_CONNECTOR__ENTITY_NAME = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SINK_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Data Sink Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SINK_CONNECTOR__DATA_SINK_ROLE = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
			+ 0;

	/**
	 * The feature id for the '<em><b>Assembly Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
			+ 1;

	/**
	 * The feature id for the '<em><b>Data Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
			+ 2;

	/**
	 * The number of structural features of the '<em>Data Channel Sink Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SINK_CONNECTOR_FEATURE_COUNT = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
			+ 3;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.composition.impl.DataChannelConnectorImpl <em>Data Channel Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.composition.impl.DataChannelConnectorImpl
	 * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getDataChannelConnector()
	 * @generated
	 */
	int DATA_CHANNEL_CONNECTOR = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_CONNECTOR__ID = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_CONNECTOR__ENTITY_NAME = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_CONNECTOR__SOURCE = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
			+ 0;

	/**
	 * The feature id for the '<em><b>Sink</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_CONNECTOR__SINK = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
			+ 1;

	/**
	 * The number of structural features of the '<em>Data Channel Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_CONNECTOR_FEATURE_COUNT = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
			+ 2;

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.composition.DataChannelSourceConnector <em>Data Channel Source Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Channel Source Connector</em>'.
	 * @see org.palladiosimulator.indirections.composition.DataChannelSourceConnector
	 * @generated
	 */
	EClass getDataChannelSourceConnector();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.DataChannelSourceConnector#getDataSourceRole <em>Data Source Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Source Role</em>'.
	 * @see org.palladiosimulator.indirections.composition.DataChannelSourceConnector#getDataSourceRole()
	 * @see #getDataChannelSourceConnector()
	 * @generated
	 */
	EReference getDataChannelSourceConnector_DataSourceRole();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.DataChannelSourceConnector#getAssemblyContext <em>Assembly Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly Context</em>'.
	 * @see org.palladiosimulator.indirections.composition.DataChannelSourceConnector#getAssemblyContext()
	 * @see #getDataChannelSourceConnector()
	 * @generated
	 */
	EReference getDataChannelSourceConnector_AssemblyContext();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.DataChannelSourceConnector#getDataChannel <em>Data Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Channel</em>'.
	 * @see org.palladiosimulator.indirections.composition.DataChannelSourceConnector#getDataChannel()
	 * @see #getDataChannelSourceConnector()
	 * @generated
	 */
	EReference getDataChannelSourceConnector_DataChannel();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.composition.DataChannelSinkConnector <em>Data Channel Sink Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Channel Sink Connector</em>'.
	 * @see org.palladiosimulator.indirections.composition.DataChannelSinkConnector
	 * @generated
	 */
	EClass getDataChannelSinkConnector();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.DataChannelSinkConnector#getDataSinkRole <em>Data Sink Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Sink Role</em>'.
	 * @see org.palladiosimulator.indirections.composition.DataChannelSinkConnector#getDataSinkRole()
	 * @see #getDataChannelSinkConnector()
	 * @generated
	 */
	EReference getDataChannelSinkConnector_DataSinkRole();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.DataChannelSinkConnector#getAssemblyContext <em>Assembly Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly Context</em>'.
	 * @see org.palladiosimulator.indirections.composition.DataChannelSinkConnector#getAssemblyContext()
	 * @see #getDataChannelSinkConnector()
	 * @generated
	 */
	EReference getDataChannelSinkConnector_AssemblyContext();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.DataChannelSinkConnector#getDataChannel <em>Data Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Channel</em>'.
	 * @see org.palladiosimulator.indirections.composition.DataChannelSinkConnector#getDataChannel()
	 * @see #getDataChannelSinkConnector()
	 * @generated
	 */
	EReference getDataChannelSinkConnector_DataChannel();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.composition.DataChannelConnector <em>Data Channel Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Channel Connector</em>'.
	 * @see org.palladiosimulator.indirections.composition.DataChannelConnector
	 * @generated
	 */
	EClass getDataChannelConnector();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.DataChannelConnector#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.palladiosimulator.indirections.composition.DataChannelConnector#getSource()
	 * @see #getDataChannelConnector()
	 * @generated
	 */
	EReference getDataChannelConnector_Source();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.DataChannelConnector#getSink <em>Sink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sink</em>'.
	 * @see org.palladiosimulator.indirections.composition.DataChannelConnector#getSink()
	 * @see #getDataChannelConnector()
	 * @generated
	 */
	EReference getDataChannelConnector_Sink();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CompositionFactory getCompositionFactory();

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
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.composition.impl.DataChannelSourceConnectorImpl <em>Data Channel Source Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.composition.impl.DataChannelSourceConnectorImpl
		 * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getDataChannelSourceConnector()
		 * @generated
		 */
		EClass DATA_CHANNEL_SOURCE_CONNECTOR = eINSTANCE.getDataChannelSourceConnector();

		/**
		 * The meta object literal for the '<em><b>Data Source Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE = eINSTANCE
				.getDataChannelSourceConnector_DataSourceRole();

		/**
		 * The meta object literal for the '<em><b>Assembly Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT = eINSTANCE
				.getDataChannelSourceConnector_AssemblyContext();

		/**
		 * The meta object literal for the '<em><b>Data Channel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL = eINSTANCE.getDataChannelSourceConnector_DataChannel();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.composition.impl.DataChannelSinkConnectorImpl <em>Data Channel Sink Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.composition.impl.DataChannelSinkConnectorImpl
		 * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getDataChannelSinkConnector()
		 * @generated
		 */
		EClass DATA_CHANNEL_SINK_CONNECTOR = eINSTANCE.getDataChannelSinkConnector();

		/**
		 * The meta object literal for the '<em><b>Data Sink Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL_SINK_CONNECTOR__DATA_SINK_ROLE = eINSTANCE.getDataChannelSinkConnector_DataSinkRole();

		/**
		 * The meta object literal for the '<em><b>Assembly Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT = eINSTANCE
				.getDataChannelSinkConnector_AssemblyContext();

		/**
		 * The meta object literal for the '<em><b>Data Channel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL = eINSTANCE.getDataChannelSinkConnector_DataChannel();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.composition.impl.DataChannelConnectorImpl <em>Data Channel Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.composition.impl.DataChannelConnectorImpl
		 * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getDataChannelConnector()
		 * @generated
		 */
		EClass DATA_CHANNEL_CONNECTOR = eINSTANCE.getDataChannelConnector();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL_CONNECTOR__SOURCE = eINSTANCE.getDataChannelConnector_Source();

		/**
		 * The meta object literal for the '<em><b>Sink</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL_CONNECTOR__SINK = eINSTANCE.getDataChannelConnector_Sink();

	}

} //CompositionPackage
