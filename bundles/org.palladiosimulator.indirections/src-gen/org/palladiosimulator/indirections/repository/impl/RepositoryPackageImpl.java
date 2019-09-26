/**
 */
package org.palladiosimulator.indirections.repository.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl;
import org.palladiosimulator.indirections.datatypes.DatatypesPackage;
import org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl;
import org.palladiosimulator.indirections.partitioning.PartitioningPackage;
import org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.repository.RepositoryFactory;
import org.palladiosimulator.indirections.repository.RepositoryPackage;
import org.palladiosimulator.indirections.system.SystemPackage;
import org.palladiosimulator.indirections.system.impl.SystemPackageImpl;
import org.palladiosimulator.pcm.PcmPackage;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.units.UnitsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class RepositoryPackageImpl extends EPackageImpl implements RepositoryPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dataSinkRoleEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dataSourceRoleEClass = null;

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
     * @see org.palladiosimulator.indirections.repository.RepositoryPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private RepositoryPackageImpl() {
        super(eNS_URI, RepositoryFactory.eINSTANCE);
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
     * This method is used to initialize {@link RepositoryPackage#eINSTANCE} when that field is
     * accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static RepositoryPackage init() {
        if (isInited) {
            return (RepositoryPackage) EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
        }

        // Obtain or create and register package
        final Object registeredRepositoryPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        final RepositoryPackageImpl theRepositoryPackage = registeredRepositoryPackage instanceof RepositoryPackageImpl
                ? (RepositoryPackageImpl) registeredRepositoryPackage
                : new RepositoryPackageImpl();

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
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);
        final DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl) (registeredPackage instanceof DatatypesPackageImpl
                ? registeredPackage
                : DatatypesPackage.eINSTANCE);
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PartitioningPackage.eNS_URI);
        final PartitioningPackageImpl thePartitioningPackage = (PartitioningPackageImpl) (registeredPackage instanceof PartitioningPackageImpl
                ? registeredPackage
                : PartitioningPackage.eINSTANCE);
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);
        final SystemPackageImpl theSystemPackage = (SystemPackageImpl) (registeredPackage instanceof SystemPackageImpl
                ? registeredPackage
                : SystemPackage.eINSTANCE);
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);
        final CompositionPackageImpl theCompositionPackage = (CompositionPackageImpl) (registeredPackage instanceof CompositionPackageImpl
                ? registeredPackage
                : CompositionPackage.eINSTANCE);

        // Create package meta-data objects
        theRepositoryPackage.createPackageContents();
        theActionsPackage.createPackageContents();
        theDatatypesPackage.createPackageContents();
        thePartitioningPackage.createPackageContents();
        theSystemPackage.createPackageContents();
        theCompositionPackage.createPackageContents();

        // Initialize created meta-data
        theRepositoryPackage.initializePackageContents();
        theActionsPackage.initializePackageContents();
        theDatatypesPackage.initializePackageContents();
        thePartitioningPackage.initializePackageContents();
        theSystemPackage.initializePackageContents();
        theCompositionPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theRepositoryPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(RepositoryPackage.eNS_URI, theRepositoryPackage);
        return theRepositoryPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDataSinkRole() {
        return this.dataSinkRoleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDataSinkRole_EventGroup() {
        return (EReference) this.dataSinkRoleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDataSinkRole_PushesTo() {
        return (EReference) this.dataSinkRoleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDataSinkRole_Pushing() {
        return (EAttribute) this.dataSinkRoleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDataSourceRole() {
        return this.dataSourceRoleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDataSourceRole_EventGroup() {
        return (EReference) this.dataSourceRoleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RepositoryFactory getRepositoryFactory() {
        return (RepositoryFactory) this.getEFactoryInstance();
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
        this.dataSinkRoleEClass = this.createEClass(DATA_SINK_ROLE);
        this.createEReference(this.dataSinkRoleEClass, DATA_SINK_ROLE__EVENT_GROUP);
        this.createEReference(this.dataSinkRoleEClass, DATA_SINK_ROLE__PUSHES_TO);
        this.createEAttribute(this.dataSinkRoleEClass, DATA_SINK_ROLE__PUSHING);

        this.dataSourceRoleEClass = this.createEClass(DATA_SOURCE_ROLE);
        this.createEReference(this.dataSourceRoleEClass, DATA_SOURCE_ROLE__EVENT_GROUP);
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
        final org.palladiosimulator.pcm.repository.RepositoryPackage theRepositoryPackage_1 = (org.palladiosimulator.pcm.repository.RepositoryPackage) EPackage.Registry.INSTANCE
                .getEPackage(org.palladiosimulator.pcm.repository.RepositoryPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.dataSinkRoleEClass.getESuperTypes().add(theRepositoryPackage_1.getProvidedRole());
        this.dataSourceRoleEClass.getESuperTypes().add(theRepositoryPackage_1.getRequiredRole());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.dataSinkRoleEClass, DataSinkRole.class, "DataSinkRole", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getDataSinkRole_EventGroup(), theRepositoryPackage_1.getEventGroup(), null,
                "eventGroup", null, 0, 1, DataSinkRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getDataSinkRole_PushesTo(), theRepositoryPackage_1.getSignature(), null, "pushesTo",
                null, 0, 1, DataSinkRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getDataSinkRole_Pushing(), this.ecorePackage.getEBoolean(), "pushing", null, 0, 1,
                DataSinkRole.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                IS_DERIVED, IS_ORDERED);

        this.initEClass(this.dataSourceRoleEClass, DataSourceRole.class, "DataSourceRole", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getDataSourceRole_EventGroup(), theRepositoryPackage_1.getEventGroup(), null,
                "eventGroup", null, 0, 1, DataSourceRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // RepositoryPackageImpl
