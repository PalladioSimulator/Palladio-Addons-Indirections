/**
 */
package org.palladiosimulator.indirections.composition.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.indirections.actions.ActionsPackage;

import org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl;

import org.palladiosimulator.indirections.composition.CompositionFactory;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.DataChannelConnector;
import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;

import org.palladiosimulator.indirections.datatypes.DatatypesPackage;

import org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl;

import org.palladiosimulator.indirections.repository.RepositoryPackage;

import org.palladiosimulator.indirections.repository.impl.RepositoryPackageImpl;

import org.palladiosimulator.indirections.system.SystemPackage;

import org.palladiosimulator.indirections.system.impl.SystemPackageImpl;

import org.palladiosimulator.pcm.PcmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositionPackageImpl extends EPackageImpl implements CompositionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataChannelSourceConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataChannelSinkConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataChannelConnectorEClass = null;

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
	 * @see org.palladiosimulator.indirections.composition.CompositionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CompositionPackageImpl() {
		super(eNS_URI, CompositionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CompositionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CompositionPackage init() {
		if (isInited)
			return (CompositionPackage) EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCompositionPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CompositionPackageImpl theCompositionPackage = registeredCompositionPackage instanceof CompositionPackageImpl
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
		ActionsPackageImpl theActionsPackage = (ActionsPackageImpl) (registeredPackage instanceof ActionsPackageImpl
				? registeredPackage
				: ActionsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);
		DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl) (registeredPackage instanceof DatatypesPackageImpl
				? registeredPackage
				: DatatypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);
		SystemPackageImpl theSystemPackage = (SystemPackageImpl) (registeredPackage instanceof SystemPackageImpl
				? registeredPackage
				: SystemPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl) (registeredPackage instanceof RepositoryPackageImpl
				? registeredPackage
				: RepositoryPackage.eINSTANCE);

		// Create package meta-data objects
		theCompositionPackage.createPackageContents();
		theActionsPackage.createPackageContents();
		theDatatypesPackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();

		// Initialize created meta-data
		theCompositionPackage.initializePackageContents();
		theActionsPackage.initializePackageContents();
		theDatatypesPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCompositionPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CompositionPackage.eNS_URI, theCompositionPackage);
		return theCompositionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataChannelSourceConnector() {
		return dataChannelSourceConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataChannelSourceConnector_DataSourceRole() {
		return (EReference) dataChannelSourceConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataChannelSourceConnector_AssemblyContext() {
		return (EReference) dataChannelSourceConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataChannelSourceConnector_DataChannel() {
		return (EReference) dataChannelSourceConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataChannelSinkConnector() {
		return dataChannelSinkConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataChannelSinkConnector_DataSinkRole() {
		return (EReference) dataChannelSinkConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataChannelSinkConnector_AssemblyContext() {
		return (EReference) dataChannelSinkConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataChannelSinkConnector_DataChannel() {
		return (EReference) dataChannelSinkConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataChannelConnector() {
		return dataChannelConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataChannelConnector_Source() {
		return (EReference) dataChannelConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataChannelConnector_Sink() {
		return (EReference) dataChannelConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositionFactory getCompositionFactory() {
		return (CompositionFactory) getEFactoryInstance();
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
		dataChannelSourceConnectorEClass = createEClass(DATA_CHANNEL_SOURCE_CONNECTOR);
		createEReference(dataChannelSourceConnectorEClass, DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE);
		createEReference(dataChannelSourceConnectorEClass, DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT);
		createEReference(dataChannelSourceConnectorEClass, DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL);

		dataChannelSinkConnectorEClass = createEClass(DATA_CHANNEL_SINK_CONNECTOR);
		createEReference(dataChannelSinkConnectorEClass, DATA_CHANNEL_SINK_CONNECTOR__DATA_SINK_ROLE);
		createEReference(dataChannelSinkConnectorEClass, DATA_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT);
		createEReference(dataChannelSinkConnectorEClass, DATA_CHANNEL_SINK_CONNECTOR__DATA_CHANNEL);

		dataChannelConnectorEClass = createEClass(DATA_CHANNEL_CONNECTOR);
		createEReference(dataChannelConnectorEClass, DATA_CHANNEL_CONNECTOR__SOURCE);
		createEReference(dataChannelConnectorEClass, DATA_CHANNEL_CONNECTOR__SINK);
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
		RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
				.getEPackage(RepositoryPackage.eNS_URI);
		SystemPackage theSystemPackage = (SystemPackage) EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dataChannelSourceConnectorEClass.getESuperTypes().add(theCompositionPackage_1.getConnector());
		dataChannelSinkConnectorEClass.getESuperTypes().add(theCompositionPackage_1.getConnector());
		dataChannelConnectorEClass.getESuperTypes().add(theCompositionPackage_1.getConnector());

		// Initialize classes and features; add operations and parameters
		initEClass(dataChannelSourceConnectorEClass, DataChannelSourceConnector.class, "DataChannelSourceConnector",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataChannelSourceConnector_DataSourceRole(), theRepositoryPackage.getDataSourceRole(), null,
				"dataSourceRole", null, 1, 1, DataChannelSourceConnector.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataChannelSourceConnector_AssemblyContext(), theCompositionPackage_1.getAssemblyContext(),
				null, "assemblyContext", null, 1, 1, DataChannelSourceConnector.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataChannelSourceConnector_DataChannel(), theSystemPackage.getDataChannel(),
				theSystemPackage.getDataChannel_DataChannelSourceConnector(), "dataChannel", null, 1, 1,
				DataChannelSourceConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataChannelSinkConnectorEClass, DataChannelSinkConnector.class, "DataChannelSinkConnector",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataChannelSinkConnector_DataSinkRole(), theRepositoryPackage.getDataSinkRole(), null,
				"dataSinkRole", null, 1, 1, DataChannelSinkConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataChannelSinkConnector_AssemblyContext(), theCompositionPackage_1.getAssemblyContext(),
				null, "assemblyContext", null, 1, 1, DataChannelSinkConnector.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataChannelSinkConnector_DataChannel(), theSystemPackage.getDataChannel(),
				theSystemPackage.getDataChannel_DataChannelSinkConnector(), "dataChannel", null, 1, 1,
				DataChannelSinkConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataChannelConnectorEClass, DataChannelConnector.class, "DataChannelConnector", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataChannelConnector_Source(), theSystemPackage.getDataChannel(), null, "source", null, 1, 1,
				DataChannelConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataChannelConnector_Sink(), theSystemPackage.getDataChannel(), null, "sink", null, 1, 1,
				DataChannelConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CompositionPackageImpl
