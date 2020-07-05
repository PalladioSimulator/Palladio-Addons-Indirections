/**
 */
package org.palladiosimulator.indirections.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.indirections.IndirectionsFactory;
import org.palladiosimulator.indirections.IndirectionsPackage;
import org.palladiosimulator.indirections.JavaClassRealization;
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
public class IndirectionsPackageImpl extends EPackageImpl implements IndirectionsPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass javaClassRealizationEClass = null;

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
     * @see org.palladiosimulator.indirections.IndirectionsPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private IndirectionsPackageImpl() {
        super(eNS_URI, IndirectionsFactory.eINSTANCE);
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
     * This method is used to initialize {@link IndirectionsPackage#eINSTANCE} when that field is
     * accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static IndirectionsPackage init() {
        if (isInited) {
            return (IndirectionsPackage) EPackage.Registry.INSTANCE.getEPackage(IndirectionsPackage.eNS_URI);
        }

        // Obtain or create and register package
        final Object registeredIndirectionsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        final IndirectionsPackageImpl theIndirectionsPackage = registeredIndirectionsPackage instanceof IndirectionsPackageImpl
                ? (IndirectionsPackageImpl) registeredIndirectionsPackage
                : new IndirectionsPackageImpl();

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
        theIndirectionsPackage.createPackageContents();
        theActionsPackage.createPackageContents();
        theSystemPackage.createPackageContents();
        theCompositionPackage.createPackageContents();
        theAbstractPackage.createPackageContents();
        theRepositoryPackage.createPackageContents();
        theAllocationPackage.createPackageContents();

        // Initialize created meta-data
        theIndirectionsPackage.initializePackageContents();
        theActionsPackage.initializePackageContents();
        theSystemPackage.initializePackageContents();
        theCompositionPackage.initializePackageContents();
        theAbstractPackage.initializePackageContents();
        theRepositoryPackage.initializePackageContents();
        theAllocationPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theIndirectionsPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(IndirectionsPackage.eNS_URI, theIndirectionsPackage);
        return theIndirectionsPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getJavaClassRealization() {
        return this.javaClassRealizationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getJavaClassRealization_RealizingClassFqn() {
        return (EAttribute) this.javaClassRealizationEClass.getEStructuralFeatures()
            .get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getJavaClassRealization_ConfigEntries() {
        return (EAttribute) this.javaClassRealizationEClass.getEStructuralFeatures()
            .get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public IndirectionsFactory getIndirectionsFactory() {
        return (IndirectionsFactory) this.getEFactoryInstance();
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
        this.javaClassRealizationEClass = this.createEClass(JAVA_CLASS_REALIZATION);
        this.createEAttribute(this.javaClassRealizationEClass, JAVA_CLASS_REALIZATION__REALIZING_CLASS_FQN);
        this.createEAttribute(this.javaClassRealizationEClass, JAVA_CLASS_REALIZATION__CONFIG_ENTRIES);
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
        final ActionsPackage theActionsPackage = (ActionsPackage) EPackage.Registry.INSTANCE
            .getEPackage(ActionsPackage.eNS_URI);
        final SystemPackage theSystemPackage = (SystemPackage) EPackage.Registry.INSTANCE
            .getEPackage(SystemPackage.eNS_URI);
        final CompositionPackage theCompositionPackage = (CompositionPackage) EPackage.Registry.INSTANCE
            .getEPackage(CompositionPackage.eNS_URI);
        final RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
            .getEPackage(RepositoryPackage.eNS_URI);
        final AllocationPackage theAllocationPackage = (AllocationPackage) EPackage.Registry.INSTANCE
            .getEPackage(AllocationPackage.eNS_URI);

        // Add subpackages
        this.getESubpackages()
            .add(theActionsPackage);
        this.getESubpackages()
            .add(theSystemPackage);
        this.getESubpackages()
            .add(theCompositionPackage);
        this.getESubpackages()
            .add(theRepositoryPackage);
        this.getESubpackages()
            .add(theAllocationPackage);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.javaClassRealizationEClass, JavaClassRealization.class, "JavaClassRealization",
                IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getJavaClassRealization_RealizingClassFqn(), this.ecorePackage.getEString(),
                "realizingClassFqn", null, 1, 1, JavaClassRealization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getJavaClassRealization_ConfigEntries(), this.ecorePackage.getEString(),
                "configEntries", null, 0, -1, JavaClassRealization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // IndirectionsPackageImpl
