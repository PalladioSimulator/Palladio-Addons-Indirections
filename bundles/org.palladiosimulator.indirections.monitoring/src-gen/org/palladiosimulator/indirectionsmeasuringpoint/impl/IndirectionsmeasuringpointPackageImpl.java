/**
 */
package org.palladiosimulator.indirectionsmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataPackage;
import org.palladiosimulator.edp2.models.Repository.RepositoryPackage;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;
import org.palladiosimulator.indirectionsmeasuringpoint.AbstractActionDataMeasuringPoint;
import org.palladiosimulator.indirectionsmeasuringpoint.IndirectionsmeasuringpointFactory;
import org.palladiosimulator.indirectionsmeasuringpoint.IndirectionsmeasuringpointPackage;
import org.palladiosimulator.metricspec.MetricSpecPackage;
import org.palladiosimulator.pcm.PcmPackage;
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
public class IndirectionsmeasuringpointPackageImpl extends EPackageImpl implements IndirectionsmeasuringpointPackage {
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
     * This method is used to initialize {@link IndirectionsmeasuringpointPackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead, they should simply
     * access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static IndirectionsmeasuringpointPackage init() {
        if (isInited) {
            return (IndirectionsmeasuringpointPackage) EPackage.Registry.INSTANCE
                .getEPackage(IndirectionsmeasuringpointPackage.eNS_URI);
        }

        // Obtain or create and register package
        final Object registeredIndirectionsmeasuringpointPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        final IndirectionsmeasuringpointPackageImpl theIndirectionsmeasuringpointPackage = registeredIndirectionsmeasuringpointPackage instanceof IndirectionsmeasuringpointPackageImpl
                ? (IndirectionsmeasuringpointPackageImpl) registeredIndirectionsmeasuringpointPackage
                : new IndirectionsmeasuringpointPackageImpl();

        isInited = true;

        // Initialize simple dependencies
        ExperimentDataPackage.eINSTANCE.eClass();
        RepositoryPackage.eINSTANCE.eClass();
        MeasuringpointPackage.eINSTANCE.eClass();
        IdentifierPackage.eINSTANCE.eClass();
        MetricSpecPackage.eINSTANCE.eClass();
        PcmPackage.eINSTANCE.eClass();
        ProbfunctionPackage.eINSTANCE.eClass();
        StoexPackage.eINSTANCE.eClass();
        UnitsPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theIndirectionsmeasuringpointPackage.createPackageContents();

        // Initialize created meta-data
        theIndirectionsmeasuringpointPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theIndirectionsmeasuringpointPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(IndirectionsmeasuringpointPackage.eNS_URI, theIndirectionsmeasuringpointPackage);
        return theIndirectionsmeasuringpointPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass abstractActionDataMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isCreated = false;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isInitialized = false;

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
     * @see org.palladiosimulator.indirectionsmeasuringpoint.IndirectionsmeasuringpointPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private IndirectionsmeasuringpointPackageImpl() {
        super(eNS_URI, IndirectionsmeasuringpointFactory.eINSTANCE);
    }

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
        this.abstractActionDataMeasuringPointEClass = this.createEClass(ABSTRACT_ACTION_DATA_MEASURING_POINT);
        this.createEReference(this.abstractActionDataMeasuringPointEClass,
                ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAbstractActionDataMeasuringPoint() {
        return this.abstractActionDataMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAbstractActionDataMeasuringPoint_AbstractAction() {
        return (EReference) this.abstractActionDataMeasuringPointEClass.getEStructuralFeatures()
            .get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public IndirectionsmeasuringpointFactory getIndirectionsmeasuringpointFactory() {
        return (IndirectionsmeasuringpointFactory) this.getEFactoryInstance();
    }

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
        final MeasuringpointPackage theMeasuringpointPackage = (MeasuringpointPackage) EPackage.Registry.INSTANCE
            .getEPackage(MeasuringpointPackage.eNS_URI);
        final SeffPackage theSeffPackage = (SeffPackage) EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.abstractActionDataMeasuringPointEClass.getESuperTypes()
            .add(theMeasuringpointPackage.getMeasuringPoint());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.abstractActionDataMeasuringPointEClass, AbstractActionDataMeasuringPoint.class,
                "AbstractActionDataMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getAbstractActionDataMeasuringPoint_AbstractAction(),
                theSeffPackage.getAbstractAction(), null, "abstractAction", null, 1, 1,
                AbstractActionDataMeasuringPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // IndirectionsmeasuringpointPackageImpl
