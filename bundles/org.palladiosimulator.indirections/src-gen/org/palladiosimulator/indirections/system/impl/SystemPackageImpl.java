/**
 */
package org.palladiosimulator.indirections.system.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

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

import org.palladiosimulator.indirections.repository.RepositoryPackage;

import org.palladiosimulator.indirections.repository.impl.RepositoryPackageImpl;

import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.system.SystemFactory;
import org.palladiosimulator.indirections.system.SystemPackage;

import org.palladiosimulator.pcm.PcmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemPackageImpl extends EPackageImpl implements SystemPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataChannelEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.palladiosimulator.indirections.system.SystemPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SystemPackageImpl() {
		super(eNS_URI, SystemFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link SystemPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SystemPackage init() {
		if (isInited)
			return (SystemPackage) EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSystemPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SystemPackageImpl theSystemPackage = registeredSystemPackage instanceof SystemPackageImpl
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
		ActionsPackageImpl theActionsPackage = (ActionsPackageImpl) (registeredPackage instanceof ActionsPackageImpl
				? registeredPackage
				: ActionsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);
		DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl) (registeredPackage instanceof DatatypesPackageImpl
				? registeredPackage
				: DatatypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);
		CompositionPackageImpl theCompositionPackage = (CompositionPackageImpl) (registeredPackage instanceof CompositionPackageImpl
				? registeredPackage
				: CompositionPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl) (registeredPackage instanceof RepositoryPackageImpl
				? registeredPackage
				: RepositoryPackage.eINSTANCE);

		// Create package meta-data objects
		theSystemPackage.createPackageContents();
		theActionsPackage.createPackageContents();
		theDatatypesPackage.createPackageContents();
		theCompositionPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();

		// Initialize created meta-data
		theSystemPackage.initializePackageContents();
		theActionsPackage.initializePackageContents();
		theDatatypesPackage.initializePackageContents();
		theCompositionPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSystemPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SystemPackage.eNS_URI, theSystemPackage);
		return theSystemPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataChannel() {
		return dataChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataChannel_Capacity() {
		return (EAttribute) dataChannelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataChannel_SourceEventGroup() {
		return (EReference) dataChannelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataChannel_SinkEventGroup() {
		return (EReference) dataChannelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataChannel_DataChannelSourceConnector() {
		return (EReference) dataChannelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataChannel_DataChannelSinkConnector() {
		return (EReference) dataChannelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataChannel_Scheduling() {
		return (EAttribute) dataChannelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataChannel_EmitToChannelPolicy() {
		return (EAttribute) dataChannelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataChannel_NumberOfElementsToEmit() {
		return (EAttribute) dataChannelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataChannel_ConsumeFromChannelPolicy() {
		return (EAttribute) dataChannelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SystemFactory getSystemFactory() {
		return (SystemFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		dataChannelEClass = createEClass(DATA_CHANNEL);
		createEAttribute(dataChannelEClass, DATA_CHANNEL__CAPACITY);
		createEReference(dataChannelEClass, DATA_CHANNEL__SOURCE_EVENT_GROUP);
		createEReference(dataChannelEClass, DATA_CHANNEL__SINK_EVENT_GROUP);
		createEReference(dataChannelEClass, DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR);
		createEReference(dataChannelEClass, DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR);
		createEAttribute(dataChannelEClass, DATA_CHANNEL__SCHEDULING);
		createEAttribute(dataChannelEClass, DATA_CHANNEL__EMIT_TO_CHANNEL_POLICY);
		createEAttribute(dataChannelEClass, DATA_CHANNEL__NUMBER_OF_ELEMENTS_TO_EMIT);
		createEAttribute(dataChannelEClass, DATA_CHANNEL__CONSUME_FROM_CHANNEL_POLICY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		org.palladiosimulator.pcm.core.composition.CompositionPackage theCompositionPackage_1 = (org.palladiosimulator.pcm.core.composition.CompositionPackage) EPackage.Registry.INSTANCE
				.getEPackage(org.palladiosimulator.pcm.core.composition.CompositionPackage.eNS_URI);
		org.palladiosimulator.pcm.repository.RepositoryPackage theRepositoryPackage_1 = (org.palladiosimulator.pcm.repository.RepositoryPackage) EPackage.Registry.INSTANCE
				.getEPackage(org.palladiosimulator.pcm.repository.RepositoryPackage.eNS_URI);
		CompositionPackage theCompositionPackage = (CompositionPackage) EPackage.Registry.INSTANCE
				.getEPackage(CompositionPackage.eNS_URI);
		DatatypesPackage theDatatypesPackage = (DatatypesPackage) EPackage.Registry.INSTANCE
				.getEPackage(DatatypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dataChannelEClass.getESuperTypes().add(theCompositionPackage_1.getEventChannel());

		// Initialize classes and features; add operations and parameters
		initEClass(dataChannelEClass, DataChannel.class, "DataChannel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataChannel_Capacity(), ecorePackage.getEInt(), "capacity", "-1", 1, 1, DataChannel.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataChannel_SourceEventGroup(), theRepositoryPackage_1.getEventGroup(), null,
				"sourceEventGroup", null, 1, 1, DataChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataChannel_SinkEventGroup(), theRepositoryPackage_1.getEventGroup(), null, "sinkEventGroup",
				null, 1, 1, DataChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataChannel_DataChannelSourceConnector(),
				theCompositionPackage.getDataChannelSourceConnector(),
				theCompositionPackage.getDataChannelSourceConnector_DataChannel(), "dataChannelSourceConnector", null,
				0, -1, DataChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataChannel_DataChannelSinkConnector(), theCompositionPackage.getDataChannelSinkConnector(),
				theCompositionPackage.getDataChannelSinkConnector_DataChannel(), "dataChannelSinkConnector", null, 0,
				-1, DataChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDataChannel_Scheduling(), theDatatypesPackage.getScheduling(), "scheduling", null, 0, 1,
				DataChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataChannel_EmitToChannelPolicy(), theDatatypesPackage.getEmitToChannelPolicy(),
				"emitToChannelPolicy", null, 1, 1, DataChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataChannel_NumberOfElementsToEmit(), theDatatypesPackage.getNumberOfElements(),
				"numberOfElementsToEmit", null, 0, 1, DataChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataChannel_ConsumeFromChannelPolicy(), theDatatypesPackage.getConsumeFromChannelPolicy(),
				"consumeFromChannelPolicy", null, 1, 1, DataChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SystemPackageImpl
