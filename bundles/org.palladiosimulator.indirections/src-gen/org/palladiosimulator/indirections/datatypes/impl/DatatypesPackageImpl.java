/**
 */
package org.palladiosimulator.indirections.datatypes.impl;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl;
import org.palladiosimulator.indirections.datatypes.DatatypesFactory;
import org.palladiosimulator.indirections.datatypes.DatatypesPackage;
import org.palladiosimulator.indirections.datatypes.OutgoingDistribution;
import org.palladiosimulator.indirections.datatypes.PutPolicy;
import org.palladiosimulator.indirections.datatypes.Scheduling;
import org.palladiosimulator.indirections.partitioning.PartitioningPackage;
import org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl;
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
 * @generated
 */
public class DatatypesPackageImpl extends EPackageImpl implements DatatypesPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum schedulingEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum putPolicyEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum outgoingDistributionEEnum = null;

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
	 * @see org.palladiosimulator.indirections.datatypes.DatatypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DatatypesPackageImpl() {
		super(eNS_URI, DatatypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DatatypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DatatypesPackage init() {
		if (isInited)
			return (DatatypesPackage) EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDatatypesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DatatypesPackageImpl theDatatypesPackage = registeredDatatypesPackage instanceof DatatypesPackageImpl
				? (DatatypesPackageImpl) registeredDatatypesPackage
				: new DatatypesPackageImpl();

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
		theDatatypesPackage.createPackageContents();
		theActionsPackage.createPackageContents();
		thePartitioningPackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theCompositionPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();

		// Initialize created meta-data
		theDatatypesPackage.initializePackageContents();
		theActionsPackage.initializePackageContents();
		thePartitioningPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theCompositionPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDatatypesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DatatypesPackage.eNS_URI, theDatatypesPackage);
		return theDatatypesPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getScheduling() {
		return schedulingEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getPutPolicy() {
		return putPolicyEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getOutgoingDistribution() {
		return outgoingDistributionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DatatypesFactory getDatatypesFactory() {
		return (DatatypesFactory) getEFactoryInstance();
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

		// Create enums
		schedulingEEnum = createEEnum(SCHEDULING);
		putPolicyEEnum = createEEnum(PUT_POLICY);
		outgoingDistributionEEnum = createEEnum(OUTGOING_DISTRIBUTION);
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

		// Initialize enums and add enum literals
		initEEnum(schedulingEEnum, Scheduling.class, "Scheduling");
		addEEnumLiteral(schedulingEEnum, Scheduling.FIRST_IN_FIRST_OUT);
		addEEnumLiteral(schedulingEEnum, Scheduling.LAST_IN_FIRST_OUT);
		addEEnumLiteral(schedulingEEnum, Scheduling.PRIORITY);
		addEEnumLiteral(schedulingEEnum, Scheduling.RANDOM);

		initEEnum(putPolicyEEnum, PutPolicy.class, "PutPolicy");
		addEEnumLiteral(putPolicyEEnum, PutPolicy.BLOCKING);
		addEEnumLiteral(putPolicyEEnum, PutPolicy.DISCARD_FIRST_IN);
		addEEnumLiteral(putPolicyEEnum, PutPolicy.DISCARD_LAST_IN);
		addEEnumLiteral(putPolicyEEnum, PutPolicy.DISCARD_INCOMING);

		initEEnum(outgoingDistributionEEnum, OutgoingDistribution.class, "OutgoingDistribution");
		addEEnumLiteral(outgoingDistributionEEnum, OutgoingDistribution.DISTRIBUTE_TO_ALL);
		addEEnumLiteral(outgoingDistributionEEnum, OutgoingDistribution.ROUND_ROBIN);

		// Create resource
		createResource(eNS_URI);
	}

} // DatatypesPackageImpl
