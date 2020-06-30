/**
 */
package org.palladiosimulator.indirections.actions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.indirections.actions.ActionsFactory;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.AddToDateAction;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.CreateDateAction;
import org.palladiosimulator.indirections.actions.DataIteratorAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.actions.PutTimeOnStackAction;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl;
import org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl;
import org.palladiosimulator.indirections.repository.RepositoryPackage;
import org.palladiosimulator.indirections.repository.impl.RepositoryPackageImpl;
import org.palladiosimulator.indirections.system.SystemPackage;
import org.palladiosimulator.indirections.system.impl.SystemPackageImpl;
import org.palladiosimulator.pcm.PcmPackage;
import org.palladiosimulator.pcm.parameter.ParameterPackage;
import org.palladiosimulator.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.units.UnitsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class ActionsPackageImpl extends EPackageImpl implements ActionsPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass analyseStackActionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass consumeDataActionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass emitDataActionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass createDateActionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass addToDateActionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass dataIteratorActionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass putTimeOnStackActionEClass = null;

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
     * @see org.palladiosimulator.indirections.actions.ActionsPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ActionsPackageImpl() {
        super(eNS_URI, ActionsFactory.eINSTANCE);
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
     * This method is used to initialize {@link ActionsPackage#eINSTANCE} when that field is
     * accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ActionsPackage init() {
        if (isInited) {
            return (ActionsPackage) EPackage.Registry.INSTANCE.getEPackage(ActionsPackage.eNS_URI);
        }

        // Obtain or create and register package
        final Object registeredActionsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        final ActionsPackageImpl theActionsPackage = registeredActionsPackage instanceof ActionsPackageImpl
                ? (ActionsPackageImpl) registeredActionsPackage
                : new ActionsPackageImpl();

        isInited = true;

        // Initialize simple dependencies
        IdentifierPackage.eINSTANCE.eClass();
        PcmPackage.eINSTANCE.eClass();
        ProbfunctionPackage.eINSTANCE.eClass();
        StoexPackage.eINSTANCE.eClass();
        UnitsPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);
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

        // Create package meta-data objects
        theActionsPackage.createPackageContents();
        theSystemPackage.createPackageContents();
        theCompositionPackage.createPackageContents();
        theAbstractPackage.createPackageContents();
        theRepositoryPackage.createPackageContents();

        // Initialize created meta-data
        theActionsPackage.initializePackageContents();
        theSystemPackage.initializePackageContents();
        theCompositionPackage.initializePackageContents();
        theAbstractPackage.initializePackageContents();
        theRepositoryPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theActionsPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ActionsPackage.eNS_URI, theActionsPackage);
        return theActionsPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAnalyseStackAction() {
        return this.analyseStackActionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAnalyseStackAction_VariableReference() {
        return (EReference) this.analyseStackActionEClass.getEStructuralFeatures()
            .get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getAnalyseStackAction_MeasurementIdentificationKey() {
        return (EAttribute) this.analyseStackActionEClass.getEStructuralFeatures()
            .get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getConsumeDataAction() {
        return this.consumeDataActionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getConsumeDataAction_DataSinkRole() {
        return (EReference) this.consumeDataActionEClass.getEStructuralFeatures()
            .get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getConsumeDataAction_VariableReference() {
        return (EReference) this.consumeDataActionEClass.getEStructuralFeatures()
            .get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getEmitDataAction() {
        return this.emitDataActionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getEmitDataAction_DataSourceRole() {
        return (EReference) this.emitDataActionEClass.getEStructuralFeatures()
            .get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getEmitDataAction_VariableReference() {
        return (EReference) this.emitDataActionEClass.getEStructuralFeatures()
            .get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getCreateDateAction() {
        return this.createDateActionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCreateDateAction_VariableReference() {
        return (EReference) this.createDateActionEClass.getEStructuralFeatures()
            .get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCreateDateAction_VariableUsages() {
        return (EReference) this.createDateActionEClass.getEStructuralFeatures()
            .get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAddToDateAction() {
        return this.addToDateActionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAddToDateAction_VariableReference() {
        return (EReference) this.addToDateActionEClass.getEStructuralFeatures()
            .get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAddToDateAction_VariableUsages() {
        return (EReference) this.addToDateActionEClass.getEStructuralFeatures()
            .get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getDataIteratorAction() {
        return this.dataIteratorActionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getDataIteratorAction_VariableReference() {
        return (EReference) this.dataIteratorActionEClass.getEStructuralFeatures()
            .get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPutTimeOnStackAction() {
        return this.putTimeOnStackActionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPutTimeOnStackAction_VariableReference() {
        return (EReference) this.putTimeOnStackActionEClass.getEStructuralFeatures()
            .get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ActionsFactory getActionsFactory() {
        return (ActionsFactory) this.getEFactoryInstance();
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
        this.analyseStackActionEClass = this.createEClass(ANALYSE_STACK_ACTION);
        this.createEReference(this.analyseStackActionEClass, ANALYSE_STACK_ACTION__VARIABLE_REFERENCE);
        this.createEAttribute(this.analyseStackActionEClass, ANALYSE_STACK_ACTION__MEASUREMENT_IDENTIFICATION_KEY);

        this.consumeDataActionEClass = this.createEClass(CONSUME_DATA_ACTION);
        this.createEReference(this.consumeDataActionEClass, CONSUME_DATA_ACTION__DATA_SINK_ROLE);
        this.createEReference(this.consumeDataActionEClass, CONSUME_DATA_ACTION__VARIABLE_REFERENCE);

        this.emitDataActionEClass = this.createEClass(EMIT_DATA_ACTION);
        this.createEReference(this.emitDataActionEClass, EMIT_DATA_ACTION__DATA_SOURCE_ROLE);
        this.createEReference(this.emitDataActionEClass, EMIT_DATA_ACTION__VARIABLE_REFERENCE);

        this.createDateActionEClass = this.createEClass(CREATE_DATE_ACTION);
        this.createEReference(this.createDateActionEClass, CREATE_DATE_ACTION__VARIABLE_REFERENCE);
        this.createEReference(this.createDateActionEClass, CREATE_DATE_ACTION__VARIABLE_USAGES);

        this.addToDateActionEClass = this.createEClass(ADD_TO_DATE_ACTION);
        this.createEReference(this.addToDateActionEClass, ADD_TO_DATE_ACTION__VARIABLE_REFERENCE);
        this.createEReference(this.addToDateActionEClass, ADD_TO_DATE_ACTION__VARIABLE_USAGES);

        this.dataIteratorActionEClass = this.createEClass(DATA_ITERATOR_ACTION);
        this.createEReference(this.dataIteratorActionEClass, DATA_ITERATOR_ACTION__VARIABLE_REFERENCE);

        this.putTimeOnStackActionEClass = this.createEClass(PUT_TIME_ON_STACK_ACTION);
        this.createEReference(this.putTimeOnStackActionEClass, PUT_TIME_ON_STACK_ACTION__VARIABLE_REFERENCE);
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
        final SeffPackage theSeffPackage = (SeffPackage) EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
        final StoexPackage theStoexPackage = (StoexPackage) EPackage.Registry.INSTANCE
            .getEPackage(StoexPackage.eNS_URI);
        final RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
            .getEPackage(RepositoryPackage.eNS_URI);
        final ParameterPackage theParameterPackage = (ParameterPackage) EPackage.Registry.INSTANCE
            .getEPackage(ParameterPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.analyseStackActionEClass.getESuperTypes()
            .add(theSeffPackage.getAbstractAction());
        this.consumeDataActionEClass.getESuperTypes()
            .add(theSeffPackage.getAbstractAction());
        this.emitDataActionEClass.getESuperTypes()
            .add(theSeffPackage.getAbstractAction());
        this.createDateActionEClass.getESuperTypes()
            .add(theSeffPackage.getAbstractAction());
        this.addToDateActionEClass.getESuperTypes()
            .add(theSeffPackage.getAbstractAction());
        this.dataIteratorActionEClass.getESuperTypes()
            .add(theSeffPackage.getAbstractLoopAction());
        this.putTimeOnStackActionEClass.getESuperTypes()
            .add(theSeffPackage.getAbstractAction());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.analyseStackActionEClass, AnalyseStackAction.class, "AnalyseStackAction", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getAnalyseStackAction_VariableReference(), theStoexPackage.getVariableReference(),
                null, "variableReference", null, 1, 1, AnalyseStackAction.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getAnalyseStackAction_MeasurementIdentificationKey(), this.ecorePackage.getEString(),
                "measurementIdentificationKey", null, 0, 1, AnalyseStackAction.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.consumeDataActionEClass, ConsumeDataAction.class, "ConsumeDataAction", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getConsumeDataAction_DataSinkRole(), theRepositoryPackage.getDataSinkRole(), null,
                "dataSinkRole", null, 1, 1, ConsumeDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getConsumeDataAction_VariableReference(), theStoexPackage.getVariableReference(), null,
                "variableReference", null, 1, 1, ConsumeDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.emitDataActionEClass, EmitDataAction.class, "EmitDataAction", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getEmitDataAction_DataSourceRole(), theRepositoryPackage.getDataSourceRole(), null,
                "dataSourceRole", null, 1, 1, EmitDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getEmitDataAction_VariableReference(), theStoexPackage.getVariableReference(), null,
                "variableReference", null, 1, 1, EmitDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.createDateActionEClass, CreateDateAction.class, "CreateDateAction", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getCreateDateAction_VariableReference(), theStoexPackage.getVariableReference(), null,
                "variableReference", null, 1, 1, CreateDateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getCreateDateAction_VariableUsages(), theParameterPackage.getVariableUsage(), null,
                "variableUsages", null, 0, -1, CreateDateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.addToDateActionEClass, AddToDateAction.class, "AddToDateAction", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getAddToDateAction_VariableReference(), theStoexPackage.getVariableReference(), null,
                "variableReference", null, 1, 1, AddToDateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getAddToDateAction_VariableUsages(), theParameterPackage.getVariableUsage(), null,
                "variableUsages", null, 0, -1, AddToDateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.dataIteratorActionEClass, DataIteratorAction.class, "DataIteratorAction", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getDataIteratorAction_VariableReference(), theStoexPackage.getVariableReference(),
                null, "variableReference", null, 1, 1, DataIteratorAction.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.putTimeOnStackActionEClass, PutTimeOnStackAction.class, "PutTimeOnStackAction",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPutTimeOnStackAction_VariableReference(), theStoexPackage.getVariableReference(),
                null, "variableReference", null, 1, 1, PutTimeOnStackAction.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // ActionsPackageImpl
