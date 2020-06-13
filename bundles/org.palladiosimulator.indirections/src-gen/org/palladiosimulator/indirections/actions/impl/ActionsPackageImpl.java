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
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.CreateDataAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.actions.PutDataOnStackAction;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl;
import org.palladiosimulator.indirections.datatypes.DatatypesPackage;
import org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl;
import org.palladiosimulator.indirections.partitioning.PartitioningPackage;
import org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl;
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
 * @generated
 */
public class ActionsPackageImpl extends EPackageImpl implements ActionsPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass analyseStackActionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass consumeDataActionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emitDataActionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createDataActionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass putDataOnStackActionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ActionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ActionsPackage init() {
		if (isInited)
			return (ActionsPackage) EPackage.Registry.INSTANCE.getEPackage(ActionsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredActionsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ActionsPackageImpl theActionsPackage = registeredActionsPackage instanceof ActionsPackageImpl
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
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);
		DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl) (registeredPackage instanceof DatatypesPackageImpl
				? registeredPackage
				: DatatypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PartitioningPackage.eNS_URI);
		PartitioningPackageImpl thePartitioningPackage = (PartitioningPackageImpl) (registeredPackage instanceof PartitioningPackageImpl
				? registeredPackage
				: PartitioningPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);
		SystemPackageImpl theSystemPackage = (SystemPackageImpl) (registeredPackage instanceof SystemPackageImpl
				? registeredPackage
				: SystemPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);
		CompositionPackageImpl theCompositionPackage = (CompositionPackageImpl) (registeredPackage instanceof CompositionPackageImpl
				? registeredPackage
				: CompositionPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl) (registeredPackage instanceof RepositoryPackageImpl
				? registeredPackage
				: RepositoryPackage.eINSTANCE);

		// Create package meta-data objects
		theActionsPackage.createPackageContents();
		theDatatypesPackage.createPackageContents();
		thePartitioningPackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theCompositionPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();

		// Initialize created meta-data
		theActionsPackage.initializePackageContents();
		theDatatypesPackage.initializePackageContents();
		thePartitioningPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theCompositionPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theActionsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ActionsPackage.eNS_URI, theActionsPackage);
		return theActionsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAnalyseStackAction() {
		return analyseStackActionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAnalyseStackAction_Key() {
		return (EAttribute) analyseStackActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnalyseStackAction_VariableReference() {
		return (EReference) analyseStackActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConsumeDataAction() {
		return consumeDataActionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsumeDataAction_EventType() {
		return (EReference) consumeDataActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsumeDataAction_DataSinkRole() {
		return (EReference) consumeDataActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsumeDataAction_VariableReference() {
		return (EReference) consumeDataActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEmitDataAction() {
		return emitDataActionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEmitDataAction_EventType() {
		return (EReference) emitDataActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEmitDataAction_DataSourceRole() {
		return (EReference) emitDataActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEmitDataAction_VariableReference() {
		return (EReference) emitDataActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCreateDataAction() {
		return createDataActionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCreateDataAction_VariableReference() {
		return (EReference) createDataActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCreateDataAction_VariableUsages() {
		return (EReference) createDataActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPutDataOnStackAction() {
		return putDataOnStackActionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPutDataOnStackAction_VariableUsages() {
		return (EReference) putDataOnStackActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActionsFactory getActionsFactory() {
		return (ActionsFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		analyseStackActionEClass = createEClass(ANALYSE_STACK_ACTION);
		createEAttribute(analyseStackActionEClass, ANALYSE_STACK_ACTION__KEY);
		createEReference(analyseStackActionEClass, ANALYSE_STACK_ACTION__VARIABLE_REFERENCE);

		consumeDataActionEClass = createEClass(CONSUME_DATA_ACTION);
		createEReference(consumeDataActionEClass, CONSUME_DATA_ACTION__EVENT_TYPE);
		createEReference(consumeDataActionEClass, CONSUME_DATA_ACTION__DATA_SINK_ROLE);
		createEReference(consumeDataActionEClass, CONSUME_DATA_ACTION__VARIABLE_REFERENCE);

		emitDataActionEClass = createEClass(EMIT_DATA_ACTION);
		createEReference(emitDataActionEClass, EMIT_DATA_ACTION__EVENT_TYPE);
		createEReference(emitDataActionEClass, EMIT_DATA_ACTION__DATA_SOURCE_ROLE);
		createEReference(emitDataActionEClass, EMIT_DATA_ACTION__VARIABLE_REFERENCE);

		createDataActionEClass = createEClass(CREATE_DATA_ACTION);
		createEReference(createDataActionEClass, CREATE_DATA_ACTION__VARIABLE_REFERENCE);
		createEReference(createDataActionEClass, CREATE_DATA_ACTION__VARIABLE_USAGES);

		putDataOnStackActionEClass = createEClass(PUT_DATA_ON_STACK_ACTION);
		createEReference(putDataOnStackActionEClass, PUT_DATA_ON_STACK_ACTION__VARIABLE_USAGES);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		SeffPackage theSeffPackage = (SeffPackage) EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
		StoexPackage theStoexPackage = (StoexPackage) EPackage.Registry.INSTANCE.getEPackage(StoexPackage.eNS_URI);
		org.palladiosimulator.pcm.repository.RepositoryPackage theRepositoryPackage_1 = (org.palladiosimulator.pcm.repository.RepositoryPackage) EPackage.Registry.INSTANCE
				.getEPackage(org.palladiosimulator.pcm.repository.RepositoryPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
				.getEPackage(RepositoryPackage.eNS_URI);
		ParameterPackage theParameterPackage = (ParameterPackage) EPackage.Registry.INSTANCE
				.getEPackage(ParameterPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		analyseStackActionEClass.getESuperTypes().add(theSeffPackage.getAbstractAction());
		consumeDataActionEClass.getESuperTypes().add(theSeffPackage.getAbstractAction());
		emitDataActionEClass.getESuperTypes().add(theSeffPackage.getAbstractAction());
		createDataActionEClass.getESuperTypes().add(theSeffPackage.getAbstractAction());
		putDataOnStackActionEClass.getESuperTypes().add(theSeffPackage.getAbstractAction());

		// Initialize classes and features; add operations and parameters
		initEClass(analyseStackActionEClass, AnalyseStackAction.class, "AnalyseStackAction", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnalyseStackAction_Key(), ecorePackage.getEString(), "key", null, 0, 1,
				AnalyseStackAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getAnalyseStackAction_VariableReference(), theStoexPackage.getVariableReference(), null,
				"variableReference", null, 1, 1, AnalyseStackAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(consumeDataActionEClass, ConsumeDataAction.class, "ConsumeDataAction", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConsumeDataAction_EventType(), theRepositoryPackage_1.getEventType(), null, "eventType", null,
				1, 1, ConsumeDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConsumeDataAction_DataSinkRole(), theRepositoryPackage.getDataSinkRole(), null,
				"dataSinkRole", null, 1, 1, ConsumeDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConsumeDataAction_VariableReference(), theStoexPackage.getVariableReference(), null,
				"variableReference", null, 1, 1, ConsumeDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emitDataActionEClass, EmitDataAction.class, "EmitDataAction", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEmitDataAction_EventType(), theRepositoryPackage_1.getEventType(), null, "eventType", null, 1,
				1, EmitDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEmitDataAction_DataSourceRole(), theRepositoryPackage.getDataSourceRole(), null,
				"dataSourceRole", null, 1, 1, EmitDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEmitDataAction_VariableReference(), theStoexPackage.getVariableReference(), null,
				"variableReference", null, 1, 1, EmitDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createDataActionEClass, CreateDataAction.class, "CreateDataAction", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreateDataAction_VariableReference(), theStoexPackage.getVariableReference(), null,
				"variableReference", null, 1, 1, CreateDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateDataAction_VariableUsages(), theParameterPackage.getVariableUsage(), null,
				"variableUsages", null, 0, -1, CreateDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(putDataOnStackActionEClass, PutDataOnStackAction.class, "PutDataOnStackAction", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPutDataOnStackAction_VariableUsages(), theParameterPackage.getVariableUsage(), null,
				"variableUsages", null, 1, -1, PutDataOnStackAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // ActionsPackageImpl
