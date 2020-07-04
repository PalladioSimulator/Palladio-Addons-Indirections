/**
 */
package org.palladiosimulator.indirections.system;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.palladiosimulator.pcm.core.entity.EntityPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.indirections.system.SystemFactory
 * @model kind="package"
 * @generated
 */
public interface SystemPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "system";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://palladiosimulator.org/Indirections/System/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_PREFIX = "org.palladiosimulator.indirections.system";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    SystemPackage eINSTANCE = org.palladiosimulator.indirections.system.impl.SystemPackageImpl.init();

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl <em>Data
     * Channel</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.system.impl.DataChannelImpl
     * @see org.palladiosimulator.indirections.system.impl.SystemPackageImpl#getDataChannel()
     * @generated
     */
    int DATA_CHANNEL = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL__ID = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL__ENTITY_NAME = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Provided Roles Interface Providing Entity</b></em>'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;

    /**
     * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring
     * Entity</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;

    /**
     * The feature id for the '<em><b>Required Roles Interface Requiring Entity</b></em>'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;

    /**
     * The feature id for the '<em><b>Data Sink Roles</b></em>' reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL__DATA_SINK_ROLES = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Data Source Roles</b></em>' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL__DATA_SOURCE_ROLES = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Data Channel</em>' class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_FEATURE_COUNT = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 2;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.system.impl.JavaClassDataChannelImpl <em>Java
     * Class Data Channel</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.system.impl.JavaClassDataChannelImpl
     * @see org.palladiosimulator.indirections.system.impl.SystemPackageImpl#getJavaClassDataChannel()
     * @generated
     */
    int JAVA_CLASS_DATA_CHANNEL = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int JAVA_CLASS_DATA_CHANNEL__ID = DATA_CHANNEL__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int JAVA_CLASS_DATA_CHANNEL__ENTITY_NAME = DATA_CHANNEL__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Provided Roles Interface Providing Entity</b></em>'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int JAVA_CLASS_DATA_CHANNEL__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = DATA_CHANNEL__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;

    /**
     * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring
     * Entity</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int JAVA_CLASS_DATA_CHANNEL__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = DATA_CHANNEL__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;

    /**
     * The feature id for the '<em><b>Required Roles Interface Requiring Entity</b></em>'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int JAVA_CLASS_DATA_CHANNEL__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = DATA_CHANNEL__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;

    /**
     * The feature id for the '<em><b>Data Sink Roles</b></em>' reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int JAVA_CLASS_DATA_CHANNEL__DATA_SINK_ROLES = DATA_CHANNEL__DATA_SINK_ROLES;

    /**
     * The feature id for the '<em><b>Data Source Roles</b></em>' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int JAVA_CLASS_DATA_CHANNEL__DATA_SOURCE_ROLES = DATA_CHANNEL__DATA_SOURCE_ROLES;

    /**
     * The feature id for the '<em><b>Realizing Class Fqn</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int JAVA_CLASS_DATA_CHANNEL__REALIZING_CLASS_FQN = DATA_CHANNEL_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Config Entries</b></em>' attribute list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int JAVA_CLASS_DATA_CHANNEL__CONFIG_ENTRIES = DATA_CHANNEL_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Java Class Data Channel</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int JAVA_CLASS_DATA_CHANNEL_FEATURE_COUNT = DATA_CHANNEL_FEATURE_COUNT + 2;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.system.impl.IndirectionsAwareSystemImpl
     * <em>Indirections Aware System</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.system.impl.IndirectionsAwareSystemImpl
     * @see org.palladiosimulator.indirections.system.impl.SystemPackageImpl#getIndirectionsAwareSystem()
     * @generated
     */
    int INDIRECTIONS_AWARE_SYSTEM = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_SYSTEM__ID = org.palladiosimulator.pcm.system.SystemPackage.SYSTEM__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_SYSTEM__ENTITY_NAME = org.palladiosimulator.pcm.system.SystemPackage.SYSTEM__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Assembly Contexts Composed Structure</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_SYSTEM__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE = org.palladiosimulator.pcm.system.SystemPackage.SYSTEM__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE;

    /**
     * The feature id for the '<em><b>Resource Required Delegation Connectors Composed
     * Structure</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_SYSTEM__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = org.palladiosimulator.pcm.system.SystemPackage.SYSTEM__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;

    /**
     * The feature id for the '<em><b>Event Channel Composed Structure</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_SYSTEM__EVENT_CHANNEL_COMPOSED_STRUCTURE = org.palladiosimulator.pcm.system.SystemPackage.SYSTEM__EVENT_CHANNEL_COMPOSED_STRUCTURE;

    /**
     * The feature id for the '<em><b>Connectors Composed Structure</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_SYSTEM__CONNECTORS_COMPOSED_STRUCTURE = org.palladiosimulator.pcm.system.SystemPackage.SYSTEM__CONNECTORS_COMPOSED_STRUCTURE;

    /**
     * The feature id for the '<em><b>Provided Roles Interface Providing Entity</b></em>'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = org.palladiosimulator.pcm.system.SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;

    /**
     * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring
     * Entity</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_SYSTEM__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = org.palladiosimulator.pcm.system.SystemPackage.SYSTEM__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;

    /**
     * The feature id for the '<em><b>Required Roles Interface Requiring Entity</b></em>'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = org.palladiosimulator.pcm.system.SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;

    /**
     * The feature id for the '<em><b>Qos Annotations System</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_SYSTEM__QOS_ANNOTATIONS_SYSTEM = org.palladiosimulator.pcm.system.SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM;

    /**
     * The feature id for the '<em><b>Data Channels</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_SYSTEM__DATA_CHANNELS = org.palladiosimulator.pcm.system.SystemPackage.SYSTEM_FEATURE_COUNT
            + 0;

    /**
     * The number of structural features of the '<em>Indirections Aware System</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_SYSTEM_FEATURE_COUNT = org.palladiosimulator.pcm.system.SystemPackage.SYSTEM_FEATURE_COUNT
            + 1;

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.system.DataChannel <em>Data Channel</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Data Channel</em>'.
     * @see org.palladiosimulator.indirections.system.DataChannel
     * @generated
     */
    EClass getDataChannel();

    /**
     * Returns the meta object for the reference list
     * '{@link org.palladiosimulator.indirections.system.DataChannel#getDataSinkRoles <em>Data Sink
     * Roles</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference list '<em>Data Sink Roles</em>'.
     * @see org.palladiosimulator.indirections.system.DataChannel#getDataSinkRoles()
     * @see #getDataChannel()
     * @generated
     */
    EReference getDataChannel_DataSinkRoles();

    /**
     * Returns the meta object for the reference list
     * '{@link org.palladiosimulator.indirections.system.DataChannel#getDataSourceRoles <em>Data
     * Source Roles</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference list '<em>Data Source Roles</em>'.
     * @see org.palladiosimulator.indirections.system.DataChannel#getDataSourceRoles()
     * @see #getDataChannel()
     * @generated
     */
    EReference getDataChannel_DataSourceRoles();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.system.JavaClassDataChannel <em>Java Class Data
     * Channel</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Java Class Data Channel</em>'.
     * @see org.palladiosimulator.indirections.system.JavaClassDataChannel
     * @generated
     */
    EClass getJavaClassDataChannel();

    /**
     * Returns the meta object for the attribute
     * '{@link org.palladiosimulator.indirections.system.JavaClassDataChannel#getRealizingClassFqn
     * <em>Realizing Class Fqn</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Realizing Class Fqn</em>'.
     * @see org.palladiosimulator.indirections.system.JavaClassDataChannel#getRealizingClassFqn()
     * @see #getJavaClassDataChannel()
     * @generated
     */
    EAttribute getJavaClassDataChannel_RealizingClassFqn();

    /**
     * Returns the meta object for the attribute list
     * '{@link org.palladiosimulator.indirections.system.JavaClassDataChannel#getConfigEntries
     * <em>Config Entries</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute list '<em>Config Entries</em>'.
     * @see org.palladiosimulator.indirections.system.JavaClassDataChannel#getConfigEntries()
     * @see #getJavaClassDataChannel()
     * @generated
     */
    EAttribute getJavaClassDataChannel_ConfigEntries();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.system.IndirectionsAwareSystem <em>Indirections
     * Aware System</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Indirections Aware System</em>'.
     * @see org.palladiosimulator.indirections.system.IndirectionsAwareSystem
     * @generated
     */
    EClass getIndirectionsAwareSystem();

    /**
     * Returns the meta object for the containment reference list
     * '{@link org.palladiosimulator.indirections.system.IndirectionsAwareSystem#getDataChannels
     * <em>Data Channels</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '<em>Data Channels</em>'.
     * @see org.palladiosimulator.indirections.system.IndirectionsAwareSystem#getDataChannels()
     * @see #getIndirectionsAwareSystem()
     * @generated
     */
    EReference getIndirectionsAwareSystem_DataChannels();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    SystemFactory getSystemFactory();

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
         * '{@link org.palladiosimulator.indirections.system.impl.DataChannelImpl <em>Data
         * Channel</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.system.impl.DataChannelImpl
         * @see org.palladiosimulator.indirections.system.impl.SystemPackageImpl#getDataChannel()
         * @generated
         */
        EClass DATA_CHANNEL = eINSTANCE.getDataChannel();

        /**
         * The meta object literal for the '<em><b>Data Sink Roles</b></em>' reference list feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference DATA_CHANNEL__DATA_SINK_ROLES = eINSTANCE.getDataChannel_DataSinkRoles();

        /**
         * The meta object literal for the '<em><b>Data Source Roles</b></em>' reference list
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference DATA_CHANNEL__DATA_SOURCE_ROLES = eINSTANCE.getDataChannel_DataSourceRoles();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.system.impl.JavaClassDataChannelImpl <em>Java
         * Class Data Channel</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.system.impl.JavaClassDataChannelImpl
         * @see org.palladiosimulator.indirections.system.impl.SystemPackageImpl#getJavaClassDataChannel()
         * @generated
         */
        EClass JAVA_CLASS_DATA_CHANNEL = eINSTANCE.getJavaClassDataChannel();

        /**
         * The meta object literal for the '<em><b>Realizing Class Fqn</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute JAVA_CLASS_DATA_CHANNEL__REALIZING_CLASS_FQN = eINSTANCE.getJavaClassDataChannel_RealizingClassFqn();

        /**
         * The meta object literal for the '<em><b>Config Entries</b></em>' attribute list feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute JAVA_CLASS_DATA_CHANNEL__CONFIG_ENTRIES = eINSTANCE.getJavaClassDataChannel_ConfigEntries();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.system.impl.IndirectionsAwareSystemImpl
         * <em>Indirections Aware System</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.system.impl.IndirectionsAwareSystemImpl
         * @see org.palladiosimulator.indirections.system.impl.SystemPackageImpl#getIndirectionsAwareSystem()
         * @generated
         */
        EClass INDIRECTIONS_AWARE_SYSTEM = eINSTANCE.getIndirectionsAwareSystem();

        /**
         * The meta object literal for the '<em><b>Data Channels</b></em>' containment reference
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference INDIRECTIONS_AWARE_SYSTEM__DATA_CHANNELS = eINSTANCE.getIndirectionsAwareSystem_DataChannels();

    }

} // SystemPackage
