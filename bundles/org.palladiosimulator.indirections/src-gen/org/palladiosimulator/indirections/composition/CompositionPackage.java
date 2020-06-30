/**
 */
package org.palladiosimulator.indirections.composition;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc --> <!-- begin-model-doc --> All connectors for sink/source roles that are
 * either bound to a data channel or to an assembly context, e.g. for a Basic Component <!--
 * end-model-doc -->
 *
 * @see org.palladiosimulator.indirections.composition.CompositionFactory
 * @model kind="package"
 * @generated
 */
public interface CompositionPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "composition";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://palladiosimulator.org/Indirections/Composition/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_PREFIX = "org.palladiosimulator.indirections.composition";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    CompositionPackage eINSTANCE = org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl.init();

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.composition.impl.DataChannelToAssemblyContextConnectorImpl
     * <em>Data Channel To Assembly Context Connector</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.composition.impl.DataChannelToAssemblyContextConnectorImpl
     * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getDataChannelToAssemblyContextConnector()
     * @generated
     */
    int DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__ID = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__ENTITY_NAME = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

    /**
     * The feature id for the '<em><b>Data Source Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__DATA_SOURCE_ROLE = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE;

    /**
     * The feature id for the '<em><b>Data Sink Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__DATA_SINK_ROLE = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SINK_ROLE;

    /**
     * The feature id for the '<em><b>Source Data Channel</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__SOURCE_DATA_CHANNEL = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL;

    /**
     * The feature id for the '<em><b>Sink Assembly Context</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR_FEATURE_COUNT
            + 0;

    /**
     * The feature id for the '<em><b>Pushes To</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR_FEATURE_COUNT
            + 1;

    /**
     * The feature id for the '<em><b>Pushing</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHING = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR_FEATURE_COUNT
            + 2;

    /**
     * The number of structural features of the '<em>Data Channel To Assembly Context
     * Connector</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR_FEATURE_COUNT = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR_FEATURE_COUNT
            + 3;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.composition.impl.AssemblyContextToDataChannelConnectorImpl
     * <em>Assembly Context To Data Channel Connector</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.composition.impl.AssemblyContextToDataChannelConnectorImpl
     * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getAssemblyContextToDataChannelConnector()
     * @generated
     */
    int ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__ID = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__ENTITY_NAME = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

    /**
     * The feature id for the '<em><b>Data Source Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__DATA_SOURCE_ROLE = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__DATA_SOURCE_ROLE;

    /**
     * The feature id for the '<em><b>Data Sink Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__DATA_SINK_ROLE = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__DATA_SINK_ROLE;

    /**
     * The feature id for the '<em><b>Source Assembly Context</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT;

    /**
     * The feature id for the '<em><b>Sink Data Channel</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR_FEATURE_COUNT
            + 0;

    /**
     * The number of structural features of the '<em>Assembly Context To Data Channel
     * Connector</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR_FEATURE_COUNT = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR_FEATURE_COUNT
            + 1;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.composition.impl.DataChannelToDataChannelConnectorImpl
     * <em>Data Channel To Data Channel Connector</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.composition.impl.DataChannelToDataChannelConnectorImpl
     * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getDataChannelToDataChannelConnector()
     * @generated
     */
    int DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__ID = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__ENTITY_NAME = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

    /**
     * The feature id for the '<em><b>Data Source Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__DATA_SOURCE_ROLE = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE;

    /**
     * The feature id for the '<em><b>Data Sink Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__DATA_SINK_ROLE = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SINK_ROLE;

    /**
     * The feature id for the '<em><b>Source Data Channel</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__SOURCE_DATA_CHANNEL = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL;

    /**
     * The feature id for the '<em><b>Sink Data Channel</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR__SINK_DATA_CHANNEL = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR_FEATURE_COUNT
            + 0;

    /**
     * The number of structural features of the '<em>Data Channel To Data Channel Connector</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR_FEATURE_COUNT = AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR_FEATURE_COUNT
            + 1;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.composition.impl.AssemblyContextToAssemblyContextConnectorImpl
     * <em>Assembly Context To Assembly Context Connector</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.composition.impl.AssemblyContextToAssemblyContextConnectorImpl
     * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getAssemblyContextToAssemblyContextConnector()
     * @generated
     */
    int ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__ID = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__ENTITY_NAME = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

    /**
     * The feature id for the '<em><b>Data Source Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__DATA_SOURCE_ROLE = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__DATA_SOURCE_ROLE;

    /**
     * The feature id for the '<em><b>Data Sink Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__DATA_SINK_ROLE = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__DATA_SINK_ROLE;

    /**
     * The feature id for the '<em><b>Source Assembly Context</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT;

    /**
     * The feature id for the '<em><b>Sink Assembly Context</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR_FEATURE_COUNT
            + 0;

    /**
     * The feature id for the '<em><b>Pushes To</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR_FEATURE_COUNT
            + 1;

    /**
     * The feature id for the '<em><b>Pushing</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHING = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR_FEATURE_COUNT
            + 2;

    /**
     * The number of structural features of the '<em>Assembly Context To Assembly Context
     * Connector</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR_FEATURE_COUNT = AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR_FEATURE_COUNT
            + 3;

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.composition.DataChannelToAssemblyContextConnector
     * <em>Data Channel To Assembly Context Connector</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for class '<em>Data Channel To Assembly Context Connector</em>'.
     * @see org.palladiosimulator.indirections.composition.DataChannelToAssemblyContextConnector
     * @generated
     */
    EClass getDataChannelToAssemblyContextConnector();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.composition.AssemblyContextToDataChannelConnector
     * <em>Assembly Context To Data Channel Connector</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for class '<em>Assembly Context To Data Channel Connector</em>'.
     * @see org.palladiosimulator.indirections.composition.AssemblyContextToDataChannelConnector
     * @generated
     */
    EClass getAssemblyContextToDataChannelConnector();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.composition.DataChannelToDataChannelConnector
     * <em>Data Channel To Data Channel Connector</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for class '<em>Data Channel To Data Channel Connector</em>'.
     * @see org.palladiosimulator.indirections.composition.DataChannelToDataChannelConnector
     * @generated
     */
    EClass getDataChannelToDataChannelConnector();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.composition.AssemblyContextToAssemblyContextConnector
     * <em>Assembly Context To Assembly Context Connector</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for class '<em>Assembly Context To Assembly Context Connector</em>'.
     * @see org.palladiosimulator.indirections.composition.AssemblyContextToAssemblyContextConnector
     * @generated
     */
    EClass getAssemblyContextToAssemblyContextConnector();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    CompositionFactory getCompositionFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     *
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.composition.impl.DataChannelToAssemblyContextConnectorImpl
         * <em>Data Channel To Assembly Context Connector</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.composition.impl.DataChannelToAssemblyContextConnectorImpl
         * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getDataChannelToAssemblyContextConnector()
         * @generated
         */
        EClass DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR = eINSTANCE.getDataChannelToAssemblyContextConnector();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.composition.impl.AssemblyContextToDataChannelConnectorImpl
         * <em>Assembly Context To Data Channel Connector</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.composition.impl.AssemblyContextToDataChannelConnectorImpl
         * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getAssemblyContextToDataChannelConnector()
         * @generated
         */
        EClass ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR = eINSTANCE.getAssemblyContextToDataChannelConnector();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.composition.impl.DataChannelToDataChannelConnectorImpl
         * <em>Data Channel To Data Channel Connector</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.composition.impl.DataChannelToDataChannelConnectorImpl
         * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getDataChannelToDataChannelConnector()
         * @generated
         */
        EClass DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR = eINSTANCE.getDataChannelToDataChannelConnector();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.composition.impl.AssemblyContextToAssemblyContextConnectorImpl
         * <em>Assembly Context To Assembly Context Connector</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.composition.impl.AssemblyContextToAssemblyContextConnectorImpl
         * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getAssemblyContextToAssemblyContextConnector()
         * @generated
         */
        EClass ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR = eINSTANCE
            .getAssemblyContextToAssemblyContextConnector();

    }

} // CompositionPackage
