/**
 */
package org.palladiosimulator.indirections.allocation;

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
 * @see org.palladiosimulator.indirections.allocation.AllocationFactory
 * @model kind="package"
 * @generated
 */
public interface AllocationPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "allocation";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://palladiosimulator.org/Indirections/Allocation/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_PREFIX = "org.palladiosimulator.indirections.allocation";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    AllocationPackage eINSTANCE = org.palladiosimulator.indirections.allocation.impl.AllocationPackageImpl.init();

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.allocation.impl.IndirectionsAwareAllocationImpl
     * <em>Indirections Aware Allocation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.allocation.impl.IndirectionsAwareAllocationImpl
     * @see org.palladiosimulator.indirections.allocation.impl.AllocationPackageImpl#getIndirectionsAwareAllocation()
     * @generated
     */
    int INDIRECTIONS_AWARE_ALLOCATION = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_ALLOCATION__ID = org.palladiosimulator.pcm.allocation.AllocationPackage.ALLOCATION__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_ALLOCATION__ENTITY_NAME = org.palladiosimulator.pcm.allocation.AllocationPackage.ALLOCATION__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Target Resource Environment Allocation</b></em>' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION = org.palladiosimulator.pcm.allocation.AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION;

    /**
     * The feature id for the '<em><b>System Allocation</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_ALLOCATION__SYSTEM_ALLOCATION = org.palladiosimulator.pcm.allocation.AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION;

    /**
     * The feature id for the '<em><b>Allocation Contexts Allocation</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION = org.palladiosimulator.pcm.allocation.AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION;

    /**
     * The feature id for the '<em><b>Data Channel Allocation Contexts</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_ALLOCATION__DATA_CHANNEL_ALLOCATION_CONTEXTS = org.palladiosimulator.pcm.allocation.AllocationPackage.ALLOCATION_FEATURE_COUNT
            + 0;

    /**
     * The number of structural features of the '<em>Indirections Aware Allocation</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INDIRECTIONS_AWARE_ALLOCATION_FEATURE_COUNT = org.palladiosimulator.pcm.allocation.AllocationPackage.ALLOCATION_FEATURE_COUNT
            + 1;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.allocation.impl.DataChannelAllocationContextImpl
     * <em>Data Channel Allocation Context</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see org.palladiosimulator.indirections.allocation.impl.DataChannelAllocationContextImpl
     * @see org.palladiosimulator.indirections.allocation.impl.AllocationPackageImpl#getDataChannelAllocationContext()
     * @generated
     */
    int DATA_CHANNEL_ALLOCATION_CONTEXT = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_ALLOCATION_CONTEXT__ID = EntityPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_ALLOCATION_CONTEXT__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Data Channel</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_ALLOCATION_CONTEXT__DATA_CHANNEL = EntityPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Resource Environment</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_ALLOCATION_CONTEXT__RESOURCE_ENVIRONMENT = EntityPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Data Channel Allocation Context</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_ALLOCATION_CONTEXT_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.allocation.IndirectionsAwareAllocation
     * <em>Indirections Aware Allocation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Indirections Aware Allocation</em>'.
     * @see org.palladiosimulator.indirections.allocation.IndirectionsAwareAllocation
     * @generated
     */
    EClass getIndirectionsAwareAllocation();

    /**
     * Returns the meta object for the containment reference list
     * '{@link org.palladiosimulator.indirections.allocation.IndirectionsAwareAllocation#getDataChannelAllocationContexts
     * <em>Data Channel Allocation Contexts</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '<em>Data Channel Allocation
     *         Contexts</em>'.
     * @see org.palladiosimulator.indirections.allocation.IndirectionsAwareAllocation#getDataChannelAllocationContexts()
     * @see #getIndirectionsAwareAllocation()
     * @generated
     */
    EReference getIndirectionsAwareAllocation_DataChannelAllocationContexts();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.allocation.DataChannelAllocationContext <em>Data
     * Channel Allocation Context</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Data Channel Allocation Context</em>'.
     * @see org.palladiosimulator.indirections.allocation.DataChannelAllocationContext
     * @generated
     */
    EClass getDataChannelAllocationContext();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.allocation.DataChannelAllocationContext#getDataChannel
     * <em>Data Channel</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Data Channel</em>'.
     * @see org.palladiosimulator.indirections.allocation.DataChannelAllocationContext#getDataChannel()
     * @see #getDataChannelAllocationContext()
     * @generated
     */
    EReference getDataChannelAllocationContext_DataChannel();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.allocation.DataChannelAllocationContext#getResourceEnvironment
     * <em>Resource Environment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Resource Environment</em>'.
     * @see org.palladiosimulator.indirections.allocation.DataChannelAllocationContext#getResourceEnvironment()
     * @see #getDataChannelAllocationContext()
     * @generated
     */
    EReference getDataChannelAllocationContext_ResourceEnvironment();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    AllocationFactory getAllocationFactory();

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
         * '{@link org.palladiosimulator.indirections.allocation.impl.IndirectionsAwareAllocationImpl
         * <em>Indirections Aware Allocation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see org.palladiosimulator.indirections.allocation.impl.IndirectionsAwareAllocationImpl
         * @see org.palladiosimulator.indirections.allocation.impl.AllocationPackageImpl#getIndirectionsAwareAllocation()
         * @generated
         */
        EClass INDIRECTIONS_AWARE_ALLOCATION = eINSTANCE.getIndirectionsAwareAllocation();

        /**
         * The meta object literal for the '<em><b>Data Channel Allocation Contexts</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference INDIRECTIONS_AWARE_ALLOCATION__DATA_CHANNEL_ALLOCATION_CONTEXTS = eINSTANCE
            .getIndirectionsAwareAllocation_DataChannelAllocationContexts();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.allocation.impl.DataChannelAllocationContextImpl
         * <em>Data Channel Allocation Context</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.allocation.impl.DataChannelAllocationContextImpl
         * @see org.palladiosimulator.indirections.allocation.impl.AllocationPackageImpl#getDataChannelAllocationContext()
         * @generated
         */
        EClass DATA_CHANNEL_ALLOCATION_CONTEXT = eINSTANCE.getDataChannelAllocationContext();

        /**
         * The meta object literal for the '<em><b>Data Channel</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference DATA_CHANNEL_ALLOCATION_CONTEXT__DATA_CHANNEL = eINSTANCE
            .getDataChannelAllocationContext_DataChannel();

        /**
         * The meta object literal for the '<em><b>Resource Environment</b></em>' reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference DATA_CHANNEL_ALLOCATION_CONTEXT__RESOURCE_ENVIRONMENT = eINSTANCE
            .getDataChannelAllocationContext_ResourceEnvironment();

    }

} // AllocationPackage
