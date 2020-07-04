/**
 */
package org.palladiosimulator.indirections.repository;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.palladiosimulator.indirections.repository.RepositoryFactory
 * @model kind="package"
 * @generated
 */
public interface RepositoryPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "repository";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://palladiosimulator.org/Indirections/Repository/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_PREFIX = "org.palladiosimulator.indirections.repository";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    RepositoryPackage eINSTANCE = org.palladiosimulator.indirections.repository.impl.RepositoryPackageImpl.init();

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.repository.impl.DataSinkRoleImpl <em>Data Sink
     * Role</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.repository.impl.DataSinkRoleImpl
     * @see org.palladiosimulator.indirections.repository.impl.RepositoryPackageImpl#getDataSinkRole()
     * @generated
     */
    int DATA_SINK_ROLE = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_SINK_ROLE__ID = org.palladiosimulator.pcm.repository.RepositoryPackage.PROVIDED_ROLE__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_SINK_ROLE__ENTITY_NAME = org.palladiosimulator.pcm.repository.RepositoryPackage.PROVIDED_ROLE__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Providing Entity Provided Role</b></em>' container reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_SINK_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE = org.palladiosimulator.pcm.repository.RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE;

    /**
     * The feature id for the '<em><b>Event Group</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_SINK_ROLE__EVENT_GROUP = org.palladiosimulator.pcm.repository.RepositoryPackage.PROVIDED_ROLE_FEATURE_COUNT
            + 0;

    /**
     * The number of structural features of the '<em>Data Sink Role</em>' class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_SINK_ROLE_FEATURE_COUNT = org.palladiosimulator.pcm.repository.RepositoryPackage.PROVIDED_ROLE_FEATURE_COUNT
            + 1;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.repository.impl.DataSourceRoleImpl <em>Data Source
     * Role</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.repository.impl.DataSourceRoleImpl
     * @see org.palladiosimulator.indirections.repository.impl.RepositoryPackageImpl#getDataSourceRole()
     * @generated
     */
    int DATA_SOURCE_ROLE = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_SOURCE_ROLE__ID = org.palladiosimulator.pcm.repository.RepositoryPackage.REQUIRED_ROLE__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_SOURCE_ROLE__ENTITY_NAME = org.palladiosimulator.pcm.repository.RepositoryPackage.REQUIRED_ROLE__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Requiring Entity Required Role</b></em>' container reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_SOURCE_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE = org.palladiosimulator.pcm.repository.RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE;

    /**
     * The feature id for the '<em><b>Event Group</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_SOURCE_ROLE__EVENT_GROUP = org.palladiosimulator.pcm.repository.RepositoryPackage.REQUIRED_ROLE_FEATURE_COUNT
            + 0;

    /**
     * The number of structural features of the '<em>Data Source Role</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_SOURCE_ROLE_FEATURE_COUNT = org.palladiosimulator.pcm.repository.RepositoryPackage.REQUIRED_ROLE_FEATURE_COUNT
            + 1;

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.repository.DataSinkRole <em>Data Sink Role</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Data Sink Role</em>'.
     * @see org.palladiosimulator.indirections.repository.DataSinkRole
     * @generated
     */
    EClass getDataSinkRole();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.repository.DataSinkRole#getEventGroup <em>Event
     * Group</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Event Group</em>'.
     * @see org.palladiosimulator.indirections.repository.DataSinkRole#getEventGroup()
     * @see #getDataSinkRole()
     * @generated
     */
    EReference getDataSinkRole_EventGroup();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.repository.DataSourceRole <em>Data Source
     * Role</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Data Source Role</em>'.
     * @see org.palladiosimulator.indirections.repository.DataSourceRole
     * @generated
     */
    EClass getDataSourceRole();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.repository.DataSourceRole#getEventGroup <em>Event
     * Group</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Event Group</em>'.
     * @see org.palladiosimulator.indirections.repository.DataSourceRole#getEventGroup()
     * @see #getDataSourceRole()
     * @generated
     */
    EReference getDataSourceRole_EventGroup();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    RepositoryFactory getRepositoryFactory();

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
         * '{@link org.palladiosimulator.indirections.repository.impl.DataSinkRoleImpl <em>Data Sink
         * Role</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.repository.impl.DataSinkRoleImpl
         * @see org.palladiosimulator.indirections.repository.impl.RepositoryPackageImpl#getDataSinkRole()
         * @generated
         */
        EClass DATA_SINK_ROLE = eINSTANCE.getDataSinkRole();

        /**
         * The meta object literal for the '<em><b>Event Group</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference DATA_SINK_ROLE__EVENT_GROUP = eINSTANCE.getDataSinkRole_EventGroup();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.repository.impl.DataSourceRoleImpl <em>Data
         * Source Role</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.repository.impl.DataSourceRoleImpl
         * @see org.palladiosimulator.indirections.repository.impl.RepositoryPackageImpl#getDataSourceRole()
         * @generated
         */
        EClass DATA_SOURCE_ROLE = eINSTANCE.getDataSourceRole();

        /**
         * The meta object literal for the '<em><b>Event Group</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference DATA_SOURCE_ROLE__EVENT_GROUP = eINSTANCE.getDataSourceRole_EventGroup();

    }

} // RepositoryPackage
