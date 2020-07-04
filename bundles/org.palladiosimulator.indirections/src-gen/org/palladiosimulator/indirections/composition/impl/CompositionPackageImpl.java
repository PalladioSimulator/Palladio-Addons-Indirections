/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl;
import org.palladiosimulator.indirections.allocation.AllocationPackage;
import org.palladiosimulator.indirections.allocation.impl.AllocationPackageImpl;
import org.palladiosimulator.indirections.composition.AssemblyContextToAssemblyContextConnector;
import org.palladiosimulator.indirections.composition.AssemblyContextToDataChannelConnector;
import org.palladiosimulator.indirections.composition.CompositionFactory;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.DataChannelToAssemblyContextConnector;
import org.palladiosimulator.indirections.composition.DataChannelToDataChannelConnector;
import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl;
import org.palladiosimulator.indirections.repository.RepositoryPackage;
import org.palladiosimulator.indirections.repository.impl.RepositoryPackageImpl;
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
public class CompositionPackageImpl extends EPackageImpl implements CompositionPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass dataChannelToAssemblyContextConnectorEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass assemblyContextToDataChannelConnectorEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass dataChannelToDataChannelConnectorEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass assemblyContextToAssemblyContextConnectorEClass = null;

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
     * @see org.palladiosimulator.indirections.composition.CompositionPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private CompositionPackageImpl() {
        super(eNS_URI, CompositionFactory.eINSTANCE);
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
     * This method is used to initialize {@link CompositionPackage#eINSTANCE} when that field is
     * accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static CompositionPackage init() {
        if (isInited) {
            return (CompositionPackage) EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);
        }

        // Obtain or create and register package
        final Object registeredCompositionPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        final CompositionPackageImpl theCompositionPackage = registeredCompositionPackage instanceof CompositionPackageImpl
                ? (CompositionPackageImpl) registeredCompositionPackage
                : new CompositionPackageImpl();

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
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);
        final SystemPackageImpl theSystemPackage = (SystemPackageImpl) (registeredPackage instanceof SystemPackageImpl
                ? registeredPackage
                : SystemPackage.eINSTANCE);
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
        theCompositionPackage.createPackageContents();
        theActionsPackage.createPackageContents();
        theSystemPackage.createPackageContents();
        theAbstractPackage.createPackageContents();
        theRepositoryPackage.createPackageContents();
        theAllocationPackage.createPackageContents();

        // Initialize created meta-data
        theCompositionPackage.initializePackageContents();
        theActionsPackage.initializePackageContents();
        theSystemPackage.initializePackageContents();
        theAbstractPackage.initializePackageContents();
        theRepositoryPackage.initializePackageContents();
        theAllocationPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theCompositionPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(CompositionPackage.eNS_URI, theCompositionPackage);
        return theCompositionPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getDataChannelToAssemblyContextConnector() {
        return this.dataChannelToAssemblyContextConnectorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAssemblyContextToDataChannelConnector() {
        return this.assemblyContextToDataChannelConnectorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getDataChannelToDataChannelConnector() {
        return this.dataChannelToDataChannelConnectorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAssemblyContextToAssemblyContextConnector() {
        return this.assemblyContextToAssemblyContextConnectorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public CompositionFactory getCompositionFactory() {
        return (CompositionFactory) this.getEFactoryInstance();
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
        this.dataChannelToAssemblyContextConnectorEClass = this
            .createEClass(DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR);

        this.assemblyContextToDataChannelConnectorEClass = this
            .createEClass(ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR);

        this.dataChannelToDataChannelConnectorEClass = this.createEClass(DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR);

        this.assemblyContextToAssemblyContextConnectorEClass = this
            .createEClass(ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR);
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
        final AbstractPackage theAbstractPackage = (AbstractPackage) EPackage.Registry.INSTANCE
            .getEPackage(AbstractPackage.eNS_URI);

        // Add subpackages
        this.getESubpackages()
            .add(theAbstractPackage);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.dataChannelToAssemblyContextConnectorEClass.getESuperTypes()
            .add(theAbstractPackage.getDataChannelSourceConnector());
        this.dataChannelToAssemblyContextConnectorEClass.getESuperTypes()
            .add(theAbstractPackage.getAssemblyContextSinkConnector());
        this.assemblyContextToDataChannelConnectorEClass.getESuperTypes()
            .add(theAbstractPackage.getAssemblyContextSourceConnector());
        this.assemblyContextToDataChannelConnectorEClass.getESuperTypes()
            .add(theAbstractPackage.getDataChannelSinkConnector());
        this.dataChannelToDataChannelConnectorEClass.getESuperTypes()
            .add(theAbstractPackage.getDataChannelSourceConnector());
        this.dataChannelToDataChannelConnectorEClass.getESuperTypes()
            .add(theAbstractPackage.getDataChannelSinkConnector());
        this.assemblyContextToAssemblyContextConnectorEClass.getESuperTypes()
            .add(theAbstractPackage.getAssemblyContextSourceConnector());
        this.assemblyContextToAssemblyContextConnectorEClass.getESuperTypes()
            .add(theAbstractPackage.getAssemblyContextSinkConnector());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.dataChannelToAssemblyContextConnectorEClass, DataChannelToAssemblyContextConnector.class,
                "DataChannelToAssemblyContextConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.assemblyContextToDataChannelConnectorEClass, AssemblyContextToDataChannelConnector.class,
                "AssemblyContextToDataChannelConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.dataChannelToDataChannelConnectorEClass, DataChannelToDataChannelConnector.class,
                "DataChannelToDataChannelConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.assemblyContextToAssemblyContextConnectorEClass,
                AssemblyContextToAssemblyContextConnector.class, "AssemblyContextToAssemblyContextConnector",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        this.createResource(eNS_URI);
    }

} // CompositionPackageImpl
