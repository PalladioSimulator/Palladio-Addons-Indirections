/**
 */
package org.palladiosimulator.indirections.composition.abstract_.impl;

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

import org.palladiosimulator.indirections.composition.abstract_.AbstractFactory;
import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;

import org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl;

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
public class AbstractPackageImpl extends EPackageImpl implements AbstractPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSourceSinkConnectorEClass = null;

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
	private EClass assemblyContextSourceConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assemblyContextSinkConnectorEClass = null;

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
	 * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AbstractPackageImpl() {
		super(eNS_URI, AbstractFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AbstractPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AbstractPackage init() {
		if (isInited)
			return (AbstractPackage) EPackage.Registry.INSTANCE.getEPackage(AbstractPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredAbstractPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AbstractPackageImpl theAbstractPackage = registeredAbstractPackage instanceof AbstractPackageImpl
				? (AbstractPackageImpl) registeredAbstractPackage
				: new AbstractPackageImpl();

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
		theAbstractPackage.createPackageContents();
		theActionsPackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theCompositionPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();

		// Initialize created meta-data
		theAbstractPackage.initializePackageContents();
		theActionsPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theCompositionPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAbstractPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AbstractPackage.eNS_URI, theAbstractPackage);
		return theAbstractPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataSourceSinkConnector() {
		return dataSourceSinkConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataSourceSinkConnector_DataSourceRole() {
		return (EReference) dataSourceSinkConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataSourceSinkConnector_DataSinkRole() {
		return (EReference) dataSourceSinkConnectorEClass.getEStructuralFeatures().get(1);
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
	public EReference getDataChannelSourceConnector_SourceDataChannel() {
		return (EReference) dataChannelSourceConnectorEClass.getEStructuralFeatures().get(0);
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
	public EReference getDataChannelSinkConnector_SinkDataChannel() {
		return (EReference) dataChannelSinkConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssemblyContextSourceConnector() {
		return assemblyContextSourceConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssemblyContextSourceConnector_SourceAssemblyContext() {
		return (EReference) assemblyContextSourceConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssemblyContextSinkConnector() {
		return assemblyContextSinkConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssemblyContextSinkConnector_SinkAssemblyContext() {
		return (EReference) assemblyContextSinkConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssemblyContextSinkConnector_PushesTo() {
		return (EReference) assemblyContextSinkConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAssemblyContextSinkConnector_Pushing() {
		return (EAttribute) assemblyContextSinkConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractFactory getAbstractFactory() {
		return (AbstractFactory) getEFactoryInstance();
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
		dataSourceSinkConnectorEClass = createEClass(DATA_SOURCE_SINK_CONNECTOR);
		createEReference(dataSourceSinkConnectorEClass, DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE);
		createEReference(dataSourceSinkConnectorEClass, DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE);

		dataChannelSourceConnectorEClass = createEClass(DATA_CHANNEL_SOURCE_CONNECTOR);
		createEReference(dataChannelSourceConnectorEClass, DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_DATA_CHANNEL);

		dataChannelSinkConnectorEClass = createEClass(DATA_CHANNEL_SINK_CONNECTOR);
		createEReference(dataChannelSinkConnectorEClass, DATA_CHANNEL_SINK_CONNECTOR__SINK_DATA_CHANNEL);

		assemblyContextSourceConnectorEClass = createEClass(ASSEMBLY_CONTEXT_SOURCE_CONNECTOR);
		createEReference(assemblyContextSourceConnectorEClass,
				ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT);

		assemblyContextSinkConnectorEClass = createEClass(ASSEMBLY_CONTEXT_SINK_CONNECTOR);
		createEReference(assemblyContextSinkConnectorEClass, ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT);
		createEReference(assemblyContextSinkConnectorEClass, ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO);
		createEAttribute(assemblyContextSinkConnectorEClass, ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHING);
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
		org.palladiosimulator.pcm.repository.RepositoryPackage theRepositoryPackage_1 = (org.palladiosimulator.pcm.repository.RepositoryPackage) EPackage.Registry.INSTANCE
				.getEPackage(org.palladiosimulator.pcm.repository.RepositoryPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dataSourceSinkConnectorEClass.getESuperTypes().add(theCompositionPackage_1.getConnector());
		dataChannelSourceConnectorEClass.getESuperTypes().add(this.getDataSourceSinkConnector());
		dataChannelSinkConnectorEClass.getESuperTypes().add(this.getDataSourceSinkConnector());
		assemblyContextSourceConnectorEClass.getESuperTypes().add(this.getDataSourceSinkConnector());
		assemblyContextSinkConnectorEClass.getESuperTypes().add(this.getDataSourceSinkConnector());

		// Initialize classes and features; add operations and parameters
		initEClass(dataSourceSinkConnectorEClass, DataSourceSinkConnector.class, "DataSourceSinkConnector", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataSourceSinkConnector_DataSourceRole(), theRepositoryPackage.getDataSourceRole(),
				theRepositoryPackage.getDataSourceRole_DataSourceSinkConnectors(), "dataSourceRole", null, 1, 1,
				DataSourceSinkConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataSourceSinkConnector_DataSinkRole(), theRepositoryPackage.getDataSinkRole(),
				theRepositoryPackage.getDataSinkRole_DataSourceSinkConnectors(), "dataSinkRole", null, 1, 1,
				DataSourceSinkConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataChannelSourceConnectorEClass, DataChannelSourceConnector.class, "DataChannelSourceConnector",
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataChannelSourceConnector_SourceDataChannel(), theSystemPackage.getDataChannel(), null,
				"sourceDataChannel", null, 1, 1, DataChannelSourceConnector.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataChannelSinkConnectorEClass, DataChannelSinkConnector.class, "DataChannelSinkConnector",
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataChannelSinkConnector_SinkDataChannel(), theSystemPackage.getDataChannel(), null,
				"sinkDataChannel", null, 1, 1, DataChannelSinkConnector.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(assemblyContextSourceConnectorEClass, AssemblyContextSourceConnector.class,
				"AssemblyContextSourceConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssemblyContextSourceConnector_SourceAssemblyContext(),
				theCompositionPackage_1.getAssemblyContext(), null, "sourceAssemblyContext", null, 1, 1,
				AssemblyContextSourceConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(assemblyContextSinkConnectorEClass, AssemblyContextSinkConnector.class,
				"AssemblyContextSinkConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssemblyContextSinkConnector_SinkAssemblyContext(),
				theCompositionPackage_1.getAssemblyContext(), null, "sinkAssemblyContext", null, 1, 1,
				AssemblyContextSinkConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssemblyContextSinkConnector_PushesTo(), theRepositoryPackage_1.getSignature(), null,
				"pushesTo", null, 0, 1, AssemblyContextSinkConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssemblyContextSinkConnector_Pushing(), ecorePackage.getEBoolean(), "pushing", null, 1, 1,
				AssemblyContextSinkConnector.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, IS_DERIVED, IS_ORDERED);
	}

} //AbstractPackageImpl
