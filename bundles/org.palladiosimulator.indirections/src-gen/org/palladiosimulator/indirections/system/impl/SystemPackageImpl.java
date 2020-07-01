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

import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;

import org.palladiosimulator.indirections.composition.abstract_.impl.AbstractPackageImpl;

import org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl;

import org.palladiosimulator.indirections.repository.RepositoryPackage;

import org.palladiosimulator.indirections.repository.impl.RepositoryPackageImpl;

import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.indirections.system.SystemFactory;
import org.palladiosimulator.indirections.system.SystemPackage;

import org.palladiosimulator.pcm.PcmPackage;

import org.palladiosimulator.pcm.core.entity.EntityPackage;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaClassDataChannelEClass = null;

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);
		CompositionPackageImpl theCompositionPackage = (CompositionPackageImpl) (registeredPackage instanceof CompositionPackageImpl
				? registeredPackage
				: CompositionPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(AbstractPackage.eNS_URI);
		AbstractPackageImpl theAbstractPackage = (AbstractPackageImpl) (registeredPackage instanceof AbstractPackageImpl
				? registeredPackage
				: AbstractPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl) (registeredPackage instanceof RepositoryPackageImpl
				? registeredPackage
				: RepositoryPackage.eINSTANCE);

		// Create package meta-data objects
		theSystemPackage.createPackageContents();
		theActionsPackage.createPackageContents();
		theCompositionPackage.createPackageContents();
		theAbstractPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();

		// Initialize created meta-data
		theSystemPackage.initializePackageContents();
		theActionsPackage.initializePackageContents();
		theCompositionPackage.initializePackageContents();
		theAbstractPackage.initializePackageContents();
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
	public EReference getDataChannel_DataSinkRoles() {
		return (EReference) dataChannelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataChannel_DataSourceRoles() {
		return (EReference) dataChannelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJavaClassDataChannel() {
		return javaClassDataChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJavaClassDataChannel_RealizingClassFqn() {
		return (EAttribute) javaClassDataChannelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJavaClassDataChannel_ConfigEntries() {
		return (EAttribute) javaClassDataChannelEClass.getEStructuralFeatures().get(1);
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
		createEReference(dataChannelEClass, DATA_CHANNEL__DATA_SINK_ROLES);
		createEReference(dataChannelEClass, DATA_CHANNEL__DATA_SOURCE_ROLES);

		javaClassDataChannelEClass = createEClass(JAVA_CLASS_DATA_CHANNEL);
		createEAttribute(javaClassDataChannelEClass, JAVA_CLASS_DATA_CHANNEL__REALIZING_CLASS_FQN);
		createEAttribute(javaClassDataChannelEClass, JAVA_CLASS_DATA_CHANNEL__CONFIG_ENTRIES);
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
		EntityPackage theEntityPackage = (EntityPackage) EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
				.getEPackage(RepositoryPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dataChannelEClass.getESuperTypes().add(theEntityPackage.getInterfaceProvidingRequiringEntity());
		javaClassDataChannelEClass.getESuperTypes().add(this.getDataChannel());

		// Initialize classes and features; add operations and parameters
		initEClass(dataChannelEClass, DataChannel.class, "DataChannel", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataChannel_DataSinkRoles(), theRepositoryPackage.getDataSinkRole(), null, "dataSinkRoles",
				null, 0, -1, DataChannel.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDataChannel_DataSourceRoles(), theRepositoryPackage.getDataSourceRole(), null,
				"dataSourceRoles", null, 0, -1, DataChannel.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(javaClassDataChannelEClass, JavaClassDataChannel.class, "JavaClassDataChannel", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaClassDataChannel_RealizingClassFqn(), ecorePackage.getEString(), "realizingClassFqn",
				null, 1, 1, JavaClassDataChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaClassDataChannel_ConfigEntries(), ecorePackage.getEString(), "configEntries", null, 0, -1,
				JavaClassDataChannel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SystemPackageImpl
