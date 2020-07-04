/**
 */
package org.palladiosimulator.indirections.system.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl;
import org.palladiosimulator.indirections.allocation.AllocationPackage;
import org.palladiosimulator.indirections.allocation.impl.AllocationPackageImpl;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl;
import org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl;
import org.palladiosimulator.indirections.repository.RepositoryPackage;
import org.palladiosimulator.indirections.repository.impl.RepositoryPackageImpl;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.system.IndirectionsAwareSystem;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.indirections.system.SystemFactory;
import org.palladiosimulator.indirections.system.SystemPackage;
import org.palladiosimulator.pcm.PcmPackage;
import org.palladiosimulator.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.units.UnitsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class SystemPackageImpl extends EPackageImpl implements SystemPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass dataChannelEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass javaClassDataChannelEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass indirectionsAwareSystemEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
     * value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init
     * init()}, which also performs initialization of the package, or returns the registered
     * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.palladiosimulator.indirections.system.SystemPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private SystemPackageImpl() {
        super(eNS_URI, SystemFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
     * upon which it depends.
     *
     * <p>
     * This method is used to initialize {@link SystemPackage#eINSTANCE} when that field is
     * accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static SystemPackage init() {
        if (isInited) {
            return (SystemPackage) EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);
        }

        // Obtain or create and register package
        final Object registeredSystemPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        final SystemPackageImpl theSystemPackage = registeredSystemPackage instanceof SystemPackageImpl
                ? (SystemPackageImpl) registeredSystemPackage
                : new SystemPackageImpl();

        isInited = true;

        // Initialize simple dependencies
        IdentifierPackage.eINSTANCE.eClass();
        PcmPackage.eINSTANCE.eClass();
        ProbfunctionPackage.eINSTANCE.eClass();
        StoexPackage.eINSTANCE.eClass();
        UnitsPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ActionsPackage.eNS_URI);
        final ActionsPackageImpl theActionsPackage = (ActionsPackageImpl) (registeredPackage instanceof ActionsPackageImpl
                ? registeredPackage
                : ActionsPackage.eINSTANCE);
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);
        final CompositionPackageImpl theCompositionPackage = (CompositionPackageImpl) (registeredPackage instanceof CompositionPackageImpl
                ? registeredPackage
                : CompositionPackage.eINSTANCE);
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(AbstractPackage.eNS_URI);
        final AbstractPackageImpl theAbstractPackage = (AbstractPackageImpl) (registeredPackage instanceof AbstractPackageImpl
                ? registeredPackage
                : AbstractPackage.eINSTANCE);
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
        final RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl) (registeredPackage instanceof RepositoryPackageImpl
                ? registeredPackage
                : RepositoryPackage.eINSTANCE);
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI);
        final AllocationPackageImpl theAllocationPackage = (AllocationPackageImpl) (registeredPackage instanceof AllocationPackageImpl
                ? registeredPackage
                : AllocationPackage.eINSTANCE);

        // Create package meta-data objects
        theSystemPackage.createPackageContents();
        theActionsPackage.createPackageContents();
        theCompositionPackage.createPackageContents();
        theAbstractPackage.createPackageContents();
        theRepositoryPackage.createPackageContents();
        theAllocationPackage.createPackageContents();

        // Initialize created meta-data
        theSystemPackage.initializePackageContents();
        theActionsPackage.initializePackageContents();
        theCompositionPackage.initializePackageContents();
        theAbstractPackage.initializePackageContents();
        theRepositoryPackage.initializePackageContents();
        theAllocationPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theSystemPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(SystemPackage.eNS_URI, theSystemPackage);
        return theSystemPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getDataChannel() {
        return this.dataChannelEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getDataChannel_DataSinkRoles() {
        return (EReference) this.dataChannelEClass.getEStructuralFeatures()
            .get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getDataChannel_DataSourceRoles() {
        return (EReference) this.dataChannelEClass.getEStructuralFeatures()
            .get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getJavaClassDataChannel() {
        return this.javaClassDataChannelEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getJavaClassDataChannel_RealizingClassFqn() {
        return (EAttribute) this.javaClassDataChannelEClass.getEStructuralFeatures()
            .get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getJavaClassDataChannel_ConfigEntries() {
        return (EAttribute) this.javaClassDataChannelEClass.getEStructuralFeatures()
            .get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getIndirectionsAwareSystem() {
        return this.indirectionsAwareSystemEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getIndirectionsAwareSystem_DataChannels() {
        return (EReference) this.indirectionsAwareSystemEClass.getEStructuralFeatures()
            .get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SystemFactory getSystemFactory() {
        return (SystemFactory) this.getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on
     * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void createPackageContents() {
        if (this.isCreated) {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.dataChannelEClass = this.createEClass(DATA_CHANNEL);
        this.createEReference(this.dataChannelEClass, DATA_CHANNEL__DATA_SINK_ROLES);
        this.createEReference(this.dataChannelEClass, DATA_CHANNEL__DATA_SOURCE_ROLES);

        this.javaClassDataChannelEClass = this.createEClass(JAVA_CLASS_DATA_CHANNEL);
        this.createEAttribute(this.javaClassDataChannelEClass, JAVA_CLASS_DATA_CHANNEL__REALIZING_CLASS_FQN);
        this.createEAttribute(this.javaClassDataChannelEClass, JAVA_CLASS_DATA_CHANNEL__CONFIG_ENTRIES);

        this.indirectionsAwareSystemEClass = this.createEClass(INDIRECTIONS_AWARE_SYSTEM);
        this.createEReference(this.indirectionsAwareSystemEClass, INDIRECTIONS_AWARE_SYSTEM__DATA_CHANNELS);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have
     * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void initializePackageContents() {
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        this.setName(eNAME);
        this.setNsPrefix(eNS_PREFIX);
        this.setNsURI(eNS_URI);

        // Obtain other dependent packages
        final EntityPackage theEntityPackage = (EntityPackage) EPackage.Registry.INSTANCE
            .getEPackage(EntityPackage.eNS_URI);
        final RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
            .getEPackage(RepositoryPackage.eNS_URI);
        final org.palladiosimulator.pcm.system.SystemPackage theSystemPackage_1 = (org.palladiosimulator.pcm.system.SystemPackage) EPackage.Registry.INSTANCE
            .getEPackage(org.palladiosimulator.pcm.system.SystemPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.dataChannelEClass.getESuperTypes()
            .add(theEntityPackage.getInterfaceProvidingRequiringEntity());
        this.javaClassDataChannelEClass.getESuperTypes()
            .add(this.getDataChannel());
        this.indirectionsAwareSystemEClass.getESuperTypes()
            .add(theSystemPackage_1.getSystem());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.dataChannelEClass, DataChannel.class, "DataChannel", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getDataChannel_DataSinkRoles(), theRepositoryPackage.getDataSinkRole(), null,
                "dataSinkRoles", null, 0, -1, DataChannel.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getDataChannel_DataSourceRoles(), theRepositoryPackage.getDataSourceRole(), null,
                "dataSourceRoles", null, 0, -1, DataChannel.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        this.initEClass(this.javaClassDataChannelEClass, JavaClassDataChannel.class, "JavaClassDataChannel",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getJavaClassDataChannel_RealizingClassFqn(), this.ecorePackage.getEString(),
                "realizingClassFqn", null, 1, 1, JavaClassDataChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getJavaClassDataChannel_ConfigEntries(), this.ecorePackage.getEString(),
                "configEntries", null, 0, -1, JavaClassDataChannel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.indirectionsAwareSystemEClass, IndirectionsAwareSystem.class, "IndirectionsAwareSystem",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getIndirectionsAwareSystem_DataChannels(), this.getDataChannel(), null, "dataChannels",
                null, 0, -1, IndirectionsAwareSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // SystemPackageImpl
