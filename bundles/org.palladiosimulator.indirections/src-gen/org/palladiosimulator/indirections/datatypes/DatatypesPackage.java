/**
 */
package org.palladiosimulator.indirections.datatypes;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.indirections.datatypes.DatatypesFactory
 * @model kind="package"
 * @generated
 */
public interface DatatypesPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "datatypes";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://palladiosimulator.org/Indirections/Datatypes/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "org.palladiosimulator.indirections.datatypes";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    DatatypesPackage eINSTANCE = org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl.init();

    /**
     * The meta object id for the '{@link org.palladiosimulator.indirections.datatypes.Scheduling
     * <em>Scheduling</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.palladiosimulator.indirections.datatypes.Scheduling
     * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getScheduling()
     * @generated
     */
    int SCHEDULING = 0;

    /**
     * The meta object id for the '{@link org.palladiosimulator.indirections.datatypes.PutPolicy
     * <em>Put Policy</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.palladiosimulator.indirections.datatypes.PutPolicy
     * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getPutPolicy()
     * @generated
     */
    int PUT_POLICY = 1;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.datatypes.OutgoingDistribution <em>Outgoing
     * Distribution</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.palladiosimulator.indirections.datatypes.OutgoingDistribution
     * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getOutgoingDistribution()
     * @generated
     */
    int OUTGOING_DISTRIBUTION = 2;

    /**
     * Returns the meta object for enum
     * '{@link org.palladiosimulator.indirections.datatypes.Scheduling <em>Scheduling</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Scheduling</em>'.
     * @see org.palladiosimulator.indirections.datatypes.Scheduling
     * @generated
     */
    EEnum getScheduling();

    /**
     * Returns the meta object for enum
     * '{@link org.palladiosimulator.indirections.datatypes.PutPolicy <em>Put Policy</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Put Policy</em>'.
     * @see org.palladiosimulator.indirections.datatypes.PutPolicy
     * @generated
     */
    EEnum getPutPolicy();

    /**
     * Returns the meta object for enum
     * '{@link org.palladiosimulator.indirections.datatypes.OutgoingDistribution <em>Outgoing
     * Distribution</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Outgoing Distribution</em>'.
     * @see org.palladiosimulator.indirections.datatypes.OutgoingDistribution
     * @generated
     */
    EEnum getOutgoingDistribution();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    DatatypesFactory getDatatypesFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.datatypes.Scheduling <em>Scheduling</em>}'
         * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.palladiosimulator.indirections.datatypes.Scheduling
         * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getScheduling()
         * @generated
         */
        EEnum SCHEDULING = eINSTANCE.getScheduling();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.datatypes.PutPolicy <em>Put Policy</em>}'
         * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.palladiosimulator.indirections.datatypes.PutPolicy
         * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getPutPolicy()
         * @generated
         */
        EEnum PUT_POLICY = eINSTANCE.getPutPolicy();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.datatypes.OutgoingDistribution <em>Outgoing
         * Distribution</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.palladiosimulator.indirections.datatypes.OutgoingDistribution
         * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getOutgoingDistribution()
         * @generated
         */
        EEnum OUTGOING_DISTRIBUTION = eINSTANCE.getOutgoingDistribution();

    }

} // DatatypesPackage
