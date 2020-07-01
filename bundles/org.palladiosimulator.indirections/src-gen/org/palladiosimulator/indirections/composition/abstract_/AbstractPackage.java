/**
 */
package org.palladiosimulator.indirections.composition.abstract_;

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
 * @see org.palladiosimulator.indirections.composition.abstract_.AbstractFactory
 * @model kind="package"
 * @generated
 */
public interface AbstractPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "abstract";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://palladiosimulator.org/Indirections/Composition/Abstract/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.palladiosimulator.indirections.composition.abstract";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AbstractPackage eINSTANCE = org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.composition.abstract_.impl.DataSourceSinkConnectorImpl <em>Data Source Sink Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.composition.abstract_.impl.DataSourceSinkConnectorImpl
	 * @see org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl#getDataSourceSinkConnector()
	 * @generated
	 */
	int DATA_SOURCE_SINK_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_SINK_CONNECTOR__ID = CompositionPackage.CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_SINK_CONNECTOR__ENTITY_NAME = CompositionPackage.CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_SINK_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Data Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE = CompositionPackage.CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Sink Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE = CompositionPackage.CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Source Sink Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_SINK_CONNECTOR_FEATURE_COUNT = CompositionPackage.CONNECTOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.composition.abstract_.impl.DataChannelSourceConnectorImpl <em>Data Channel Source Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.composition.abstract_.impl.DataChannelSourceConnectorImpl
	 * @see org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl#getDataChannelSourceConnector()
	 * @generated
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR__ID = DATA_SOURCE_SINK_CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR__ENTITY_NAME = DATA_SOURCE_SINK_CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = DATA_SOURCE_SINK_CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Data Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE = DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE;

	/**
	 * The feature id for the '<em><b>Data Sink Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SINK_ROLE = DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE;

	/**
	 * The feature id for the '<em><b>Source Data Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL = DATA_SOURCE_SINK_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Channel Source Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SOURCE_CONNECTOR_FEATURE_COUNT = DATA_SOURCE_SINK_CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.composition.abstract_.impl.DataChannelSinkConnectorImpl <em>Data Channel Sink Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.composition.abstract_.impl.DataChannelSinkConnectorImpl
	 * @see org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl#getDataChannelSinkConnector()
	 * @generated
	 */
	int DATA_CHANNEL_SINK_CONNECTOR = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SINK_CONNECTOR__ID = DATA_SOURCE_SINK_CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SINK_CONNECTOR__ENTITY_NAME = DATA_SOURCE_SINK_CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SINK_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = DATA_SOURCE_SINK_CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Data Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SINK_CONNECTOR__DATA_SOURCE_ROLE = DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE;

	/**
	 * The feature id for the '<em><b>Data Sink Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SINK_CONNECTOR__DATA_SINK_ROLE = DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE;

	/**
	 * The feature id for the '<em><b>Sink Data Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL = DATA_SOURCE_SINK_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Channel Sink Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHANNEL_SINK_CONNECTOR_FEATURE_COUNT = DATA_SOURCE_SINK_CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.composition.abstract_.impl.AssemblyContextSourceConnectorImpl <em>Assembly Context Source Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.composition.abstract_.impl.AssemblyContextSourceConnectorImpl
	 * @see org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl#getAssemblyContextSourceConnector()
	 * @generated
	 */
	int ASSEMBLY_CONTEXT_SOURCE_CONNECTOR = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__ID = DATA_SOURCE_SINK_CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__ENTITY_NAME = DATA_SOURCE_SINK_CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = DATA_SOURCE_SINK_CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Data Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__DATA_SOURCE_ROLE = DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE;

	/**
	 * The feature id for the '<em><b>Data Sink Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__DATA_SINK_ROLE = DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE;

	/**
	 * The feature id for the '<em><b>Source Assembly Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT = DATA_SOURCE_SINK_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Assembly Context Source Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SOURCE_CONNECTOR_FEATURE_COUNT = DATA_SOURCE_SINK_CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.composition.abstract_.impl.AssemblyContextSinkConnectorImpl <em>Assembly Context Sink Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.composition.abstract_.impl.AssemblyContextSinkConnectorImpl
	 * @see org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl#getAssemblyContextSinkConnector()
	 * @generated
	 */
	int ASSEMBLY_CONTEXT_SINK_CONNECTOR = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SINK_CONNECTOR__ID = DATA_SOURCE_SINK_CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SINK_CONNECTOR__ENTITY_NAME = DATA_SOURCE_SINK_CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SINK_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = DATA_SOURCE_SINK_CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Data Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SINK_CONNECTOR__DATA_SOURCE_ROLE = DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE;

	/**
	 * The feature id for the '<em><b>Data Sink Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SINK_CONNECTOR__DATA_SINK_ROLE = DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE;

	/**
	 * The feature id for the '<em><b>Sink Assembly Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT = DATA_SOURCE_SINK_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pushes To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO = DATA_SOURCE_SINK_CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pushing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHING = DATA_SOURCE_SINK_CONNECTOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assembly Context Sink Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_SINK_CONNECTOR_FEATURE_COUNT = DATA_SOURCE_SINK_CONNECTOR_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector <em>Data Source Sink Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Source Sink Connector</em>'.
	 * @see org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector
	 * @generated
	 */
	EClass getDataSourceSinkConnector();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector#getDataSourceRole <em>Data Source Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Source Role</em>'.
	 * @see org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector#getDataSourceRole()
	 * @see #getDataSourceSinkConnector()
	 * @generated
	 */
	EReference getDataSourceSinkConnector_DataSourceRole();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector#getDataSinkRole <em>Data Sink Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Sink Role</em>'.
	 * @see org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector#getDataSinkRole()
	 * @see #getDataSourceSinkConnector()
	 * @generated
	 */
	EReference getDataSourceSinkConnector_DataSinkRole();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector <em>Data Channel Source Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Channel Source Connector</em>'.
	 * @see org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector
	 * @generated
	 */
	EClass getDataChannelSourceConnector();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector#getSourceDataChannel <em>Source Data Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Data Channel</em>'.
	 * @see org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector#getSourceDataChannel()
	 * @see #getDataChannelSourceConnector()
	 * @generated
	 */
	EReference getDataChannelSourceConnector_SourceDataChannel();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector <em>Data Channel Sink Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Channel Sink Connector</em>'.
	 * @see org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector
	 * @generated
	 */
	EClass getDataChannelSinkConnector();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector#getSinkDataChannel <em>Sink Data Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sink Data Channel</em>'.
	 * @see org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector#getSinkDataChannel()
	 * @see #getDataChannelSinkConnector()
	 * @generated
	 */
	EReference getDataChannelSinkConnector_SinkDataChannel();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector <em>Assembly Context Source Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assembly Context Source Connector</em>'.
	 * @see org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector
	 * @generated
	 */
	EClass getAssemblyContextSourceConnector();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector#getSourceAssemblyContext <em>Source Assembly Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Assembly Context</em>'.
	 * @see org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector#getSourceAssemblyContext()
	 * @see #getAssemblyContextSourceConnector()
	 * @generated
	 */
	EReference getAssemblyContextSourceConnector_SourceAssemblyContext();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector <em>Assembly Context Sink Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assembly Context Sink Connector</em>'.
	 * @see org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector
	 * @generated
	 */
	EClass getAssemblyContextSinkConnector();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector#getSinkAssemblyContext <em>Sink Assembly Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sink Assembly Context</em>'.
	 * @see org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector#getSinkAssemblyContext()
	 * @see #getAssemblyContextSinkConnector()
	 * @generated
	 */
	EReference getAssemblyContextSinkConnector_SinkAssemblyContext();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector#getPushesTo <em>Pushes To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pushes To</em>'.
	 * @see org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector#getPushesTo()
	 * @see #getAssemblyContextSinkConnector()
	 * @generated
	 */
	EReference getAssemblyContextSinkConnector_PushesTo();

	/**
	 * Returns the meta object for the attribute '{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector#isPushing <em>Pushing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pushing</em>'.
	 * @see org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector#isPushing()
	 * @see #getAssemblyContextSinkConnector()
	 * @generated
	 */
	EAttribute getAssemblyContextSinkConnector_Pushing();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AbstractFactory getAbstractFactory();

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
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.composition.abstract_.impl.DataSourceSinkConnectorImpl <em>Data Source Sink Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.composition.abstract_.impl.DataSourceSinkConnectorImpl
		 * @see org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl#getDataSourceSinkConnector()
		 * @generated
		 */
		EClass DATA_SOURCE_SINK_CONNECTOR = eINSTANCE.getDataSourceSinkConnector();

		/**
		 * The meta object literal for the '<em><b>Data Source Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE = eINSTANCE.getDataSourceSinkConnector_DataSourceRole();

		/**
		 * The meta object literal for the '<em><b>Data Sink Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE = eINSTANCE.getDataSourceSinkConnector_DataSinkRole();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.composition.abstract_.impl.DataChannelSourceConnectorImpl <em>Data Channel Source Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.composition.abstract_.impl.DataChannelSourceConnectorImpl
		 * @see org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl#getDataChannelSourceConnector()
		 * @generated
		 */
		EClass DATA_CHANNEL_SOURCE_CONNECTOR = eINSTANCE.getDataChannelSourceConnector();

		/**
		 * The meta object literal for the '<em><b>Source Data Channel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL = eINSTANCE
				.getDataChannelSourceConnector_SourceDataChannel();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.composition.abstract_.impl.DataChannelSinkConnectorImpl <em>Data Channel Sink Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.composition.abstract_.impl.DataChannelSinkConnectorImpl
		 * @see org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl#getDataChannelSinkConnector()
		 * @generated
		 */
		EClass DATA_CHANNEL_SINK_CONNECTOR = eINSTANCE.getDataChannelSinkConnector();

		/**
		 * The meta object literal for the '<em><b>Sink Data Channel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL = eINSTANCE
				.getDataChannelSinkConnector_SinkDataChannel();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.composition.abstract_.impl.AssemblyContextSourceConnectorImpl <em>Assembly Context Source Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.composition.abstract_.impl.AssemblyContextSourceConnectorImpl
		 * @see org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl#getAssemblyContextSourceConnector()
		 * @generated
		 */
		EClass ASSEMBLY_CONTEXT_SOURCE_CONNECTOR = eINSTANCE.getAssemblyContextSourceConnector();

		/**
		 * The meta object literal for the '<em><b>Source Assembly Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT = eINSTANCE
				.getAssemblyContextSourceConnector_SourceAssemblyContext();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.composition.abstract_.impl.AssemblyContextSinkConnectorImpl <em>Assembly Context Sink Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.composition.abstract_.impl.AssemblyContextSinkConnectorImpl
		 * @see org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl#getAssemblyContextSinkConnector()
		 * @generated
		 */
		EClass ASSEMBLY_CONTEXT_SINK_CONNECTOR = eINSTANCE.getAssemblyContextSinkConnector();

		/**
		 * The meta object literal for the '<em><b>Sink Assembly Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT = eINSTANCE
				.getAssemblyContextSinkConnector_SinkAssemblyContext();

		/**
		 * The meta object literal for the '<em><b>Pushes To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO = eINSTANCE.getAssemblyContextSinkConnector_PushesTo();

		/**
		 * The meta object literal for the '<em><b>Pushing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHING = eINSTANCE.getAssemblyContextSinkConnector_Pushing();

	}

} //AbstractPackage
