/**
 */
package org.palladiosimulator.indirections.repository.impl;

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

import org.palladiosimulator.indirections.composition.CompositionPackage;

import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;

import org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl;

import org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl;

import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.repository.RepositoryFactory;
import org.palladiosimulator.indirections.repository.RepositoryPackage;

import org.palladiosimulator.indirections.system.SystemPackage;

import org.palladiosimulator.indirections.system.impl.SystemPackageImpl;

import org.palladiosimulator.pcm.PcmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RepositoryPackageImpl extends EPackageImpl implements RepositoryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSinkRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSourceRoleEClass = null;

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
	 * @see org.palladiosimulator.indirections.repository.RepositoryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RepositoryPackageImpl() {
		super(eNS_URI, RepositoryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RepositoryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RepositoryPackage init() {
		if (isInited)
			return (RepositoryPackage) EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredRepositoryPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		RepositoryPackageImpl theRepositoryPackage = registeredRepositoryPackage instanceof RepositoryPackageImpl
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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(AbstractPackage.eNS_URI);
		AbstractPackageImpl theAbstractPackage = (AbstractPackageImpl) (registeredPackage instanceof AbstractPackageImpl
				? registeredPackage
				: AbstractPackage.eINSTANCE);

		// Create package meta-data objects
		theRepositoryPackage.createPackageContents();
		theActionsPackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theCompositionPackage.createPackageContents();
		theAbstractPackage.createPackageContents();

		// Initialize created meta-data
		theRepositoryPackage.initializePackageContents();
		theActionsPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theCompositionPackage.initializePackageContents();
		theAbstractPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRepositoryPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RepositoryPackage.eNS_URI, theRepositoryPackage);
		return theRepositoryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataSinkRole() {
		return dataSinkRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataSinkRole_EventGroup() {
		return (EReference) dataSinkRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataSinkRole_DataSourceSinkConnectors() {
		return (EReference) dataSinkRoleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataSourceRole() {
		return dataSourceRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataSourceRole_EventGroup() {
		return (EReference) dataSourceRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataSourceRole_DataSourceSinkConnectors() {
		return (EReference) dataSourceRoleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RepositoryFactory getRepositoryFactory() {
		return (RepositoryFactory) getEFactoryInstance();
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
		dataSinkRoleEClass = createEClass(DATA_SINK_ROLE);
		createEReference(dataSinkRoleEClass, DATA_SINK_ROLE__EVENT_GROUP);
		createEReference(dataSinkRoleEClass, DATA_SINK_ROLE__DATA_SOURCE_SINK_CONNECTORS);

		dataSourceRoleEClass = createEClass(DATA_SOURCE_ROLE);
		createEReference(dataSourceRoleEClass, DATA_SOURCE_ROLE__EVENT_GROUP);
		createEReference(dataSourceRoleEClass, DATA_SOURCE_ROLE__DATA_SOURCE_SINK_CONNECTORS);
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
		org.palladiosimulator.pcm.repository.RepositoryPackage theRepositoryPackage_1 = (org.palladiosimulator.pcm.repository.RepositoryPackage) EPackage.Registry.INSTANCE
				.getEPackage(org.palladiosimulator.pcm.repository.RepositoryPackage.eNS_URI);
		AbstractPackage theAbstractPackage = (AbstractPackage) EPackage.Registry.INSTANCE
				.getEPackage(AbstractPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dataSinkRoleEClass.getESuperTypes().add(theRepositoryPackage_1.getProvidedRole());
		dataSourceRoleEClass.getESuperTypes().add(theRepositoryPackage_1.getRequiredRole());

		// Initialize classes and features; add operations and parameters
		initEClass(dataSinkRoleEClass, DataSinkRole.class, "DataSinkRole", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataSinkRole_EventGroup(), theRepositoryPackage_1.getEventGroup(), null, "eventGroup", null,
				0, 1, DataSinkRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataSinkRole_DataSourceSinkConnectors(), theAbstractPackage.getDataSourceSinkConnector(),
				theAbstractPackage.getDataSourceSinkConnector_DataSinkRole(), "dataSourceSinkConnectors", null, 0, -1,
				DataSinkRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataSourceRoleEClass, DataSourceRole.class, "DataSourceRole", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataSourceRole_EventGroup(), theRepositoryPackage_1.getEventGroup(), null, "eventGroup", null,
				0, 1, DataSourceRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataSourceRole_DataSourceSinkConnectors(), theAbstractPackage.getDataSourceSinkConnector(),
				theAbstractPackage.getDataSourceSinkConnector_DataSourceRole(), "dataSourceSinkConnectors", null, 0, -1,
				DataSourceRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RepositoryPackageImpl
