/**
 */
package org.palladiosimulator.indirectionsmeasuringpoint;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;

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
 * @see org.palladiosimulator.indirectionsmeasuringpoint.IndirectionsmeasuringpointFactory
 * @model kind="package"
 * @generated
 */
public interface IndirectionsmeasuringpointPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "indirectionsmeasuringpoint";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://palladiosimulator.org/Indirections/Measuringpoints/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "org.palladiosimulator.indirections.measuringpoints";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    IndirectionsmeasuringpointPackage eINSTANCE = org.palladiosimulator.indirectionsmeasuringpoint.impl.IndirectionsmeasuringpointPackageImpl
            .init();

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirectionsmeasuringpoint.impl.AbstractActionDataMeasuringPointImpl
     * <em>Abstract Action Data Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.palladiosimulator.indirectionsmeasuringpoint.impl.AbstractActionDataMeasuringPointImpl
     * @see org.palladiosimulator.indirectionsmeasuringpoint.impl.IndirectionsmeasuringpointPackageImpl#getAbstractActionDataMeasuringPoint()
     * @generated
     */
    int ABSTRACT_ACTION_DATA_MEASURING_POINT = 0;

    /**
     * The feature id for the '<em><b>Measuring Point Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_ACTION_DATA_MEASURING_POINT__MEASURING_POINT_REPOSITORY = MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;

    /**
     * The feature id for the '<em><b>String Representation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_ACTION_DATA_MEASURING_POINT__STRING_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Resource URI Representation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_ACTION_DATA_MEASURING_POINT__RESOURCE_URI_REPRESENTATION = MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION;

    /**
     * The feature id for the '<em><b>Abstract Action</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Abstract Action Data Measuring Point</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_ACTION_DATA_MEASURING_POINT_FEATURE_COUNT = MeasuringpointPackage.MEASURING_POINT_FEATURE_COUNT + 1;

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirectionsmeasuringpoint.AbstractActionDataMeasuringPoint
     * <em>Abstract Action Data Measuring Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for class '<em>Abstract Action Data Measuring Point</em>'.
     * @see org.palladiosimulator.indirectionsmeasuringpoint.AbstractActionDataMeasuringPoint
     * @generated
     */
    EClass getAbstractActionDataMeasuringPoint();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirectionsmeasuringpoint.AbstractActionDataMeasuringPoint#getAbstractAction
     * <em>Abstract Action</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Abstract Action</em>'.
     * @see org.palladiosimulator.indirectionsmeasuringpoint.AbstractActionDataMeasuringPoint#getAbstractAction()
     * @see #getAbstractActionDataMeasuringPoint()
     * @generated
     */
    EReference getAbstractActionDataMeasuringPoint_AbstractAction();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    IndirectionsmeasuringpointFactory getIndirectionsmeasuringpointFactory();

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
         * '{@link org.palladiosimulator.indirectionsmeasuringpoint.impl.AbstractActionDataMeasuringPointImpl
         * <em>Abstract Action Data Measuring Point</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see org.palladiosimulator.indirectionsmeasuringpoint.impl.AbstractActionDataMeasuringPointImpl
         * @see org.palladiosimulator.indirectionsmeasuringpoint.impl.IndirectionsmeasuringpointPackageImpl#getAbstractActionDataMeasuringPoint()
         * @generated
         */
        EClass ABSTRACT_ACTION_DATA_MEASURING_POINT = eINSTANCE.getAbstractActionDataMeasuringPoint();

        /**
         * The meta object literal for the '<em><b>Abstract Action</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION = eINSTANCE
                .getAbstractActionDataMeasuringPoint_AbstractAction();

    }

} // IndirectionsmeasuringpointPackage
