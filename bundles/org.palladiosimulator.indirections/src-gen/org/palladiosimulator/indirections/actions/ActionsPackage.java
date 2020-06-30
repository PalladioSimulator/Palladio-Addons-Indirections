/**
 */
package org.palladiosimulator.indirections.actions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.palladiosimulator.pcm.seff.SeffPackage;

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
 * @see org.palladiosimulator.indirections.actions.ActionsFactory
 * @model kind="package"
 * @generated
 */
public interface ActionsPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "actions";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://palladiosimulator.org/Indirections/Actions/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_PREFIX = "org.palladiosimulator.indirections.actions";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    ActionsPackage eINSTANCE = org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl.init();

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.actions.impl.AnalyseStackActionImpl <em>Analyse
     * Stack Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.actions.impl.AnalyseStackActionImpl
     * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getAnalyseStackAction()
     * @generated
     */
    int ANALYSE_STACK_ACTION = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ANALYSE_STACK_ACTION__ID = SeffPackage.ABSTRACT_ACTION__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ANALYSE_STACK_ACTION__ENTITY_NAME = SeffPackage.ABSTRACT_ACTION__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ANALYSE_STACK_ACTION__PREDECESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ANALYSE_STACK_ACTION__SUCCESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Resource Demanding Behaviour Abstract Action</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ANALYSE_STACK_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Variable Reference</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ANALYSE_STACK_ACTION__VARIABLE_REFERENCE = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Measurement Identification Key</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ANALYSE_STACK_ACTION__MEASUREMENT_IDENTIFICATION_KEY = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Analyse Stack Action</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ANALYSE_STACK_ACTION_FEATURE_COUNT = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl <em>Consume
     * Data Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl
     * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getConsumeDataAction()
     * @generated
     */
    int CONSUME_DATA_ACTION = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUME_DATA_ACTION__ID = SeffPackage.ABSTRACT_ACTION__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUME_DATA_ACTION__ENTITY_NAME = SeffPackage.ABSTRACT_ACTION__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUME_DATA_ACTION__PREDECESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUME_DATA_ACTION__SUCCESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Resource Demanding Behaviour Abstract Action</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUME_DATA_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Data Sink Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUME_DATA_ACTION__DATA_SINK_ROLE = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Variable Reference</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUME_DATA_ACTION__VARIABLE_REFERENCE = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Consume Data Action</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUME_DATA_ACTION_FEATURE_COUNT = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl <em>Emit Data
     * Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl
     * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getEmitDataAction()
     * @generated
     */
    int EMIT_DATA_ACTION = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EMIT_DATA_ACTION__ID = SeffPackage.ABSTRACT_ACTION__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EMIT_DATA_ACTION__ENTITY_NAME = SeffPackage.ABSTRACT_ACTION__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EMIT_DATA_ACTION__PREDECESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EMIT_DATA_ACTION__SUCCESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Resource Demanding Behaviour Abstract Action</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EMIT_DATA_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Data Source Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EMIT_DATA_ACTION__DATA_SOURCE_ROLE = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Variable Reference</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EMIT_DATA_ACTION__VARIABLE_REFERENCE = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Emit Data Action</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EMIT_DATA_ACTION_FEATURE_COUNT = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.actions.impl.CreateDateActionImpl <em>Create Date
     * Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.actions.impl.CreateDateActionImpl
     * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getCreateDateAction()
     * @generated
     */
    int CREATE_DATE_ACTION = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CREATE_DATE_ACTION__ID = SeffPackage.ABSTRACT_ACTION__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CREATE_DATE_ACTION__ENTITY_NAME = SeffPackage.ABSTRACT_ACTION__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CREATE_DATE_ACTION__PREDECESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CREATE_DATE_ACTION__SUCCESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Resource Demanding Behaviour Abstract Action</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CREATE_DATE_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Variable Reference</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CREATE_DATE_ACTION__VARIABLE_REFERENCE = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Variable Usages</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CREATE_DATE_ACTION__VARIABLE_USAGES = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Create Date Action</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CREATE_DATE_ACTION_FEATURE_COUNT = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.actions.impl.AddToDateActionImpl <em>Add To Date
     * Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.actions.impl.AddToDateActionImpl
     * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getAddToDateAction()
     * @generated
     */
    int ADD_TO_DATE_ACTION = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADD_TO_DATE_ACTION__ID = SeffPackage.ABSTRACT_ACTION__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADD_TO_DATE_ACTION__ENTITY_NAME = SeffPackage.ABSTRACT_ACTION__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADD_TO_DATE_ACTION__PREDECESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADD_TO_DATE_ACTION__SUCCESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Resource Demanding Behaviour Abstract Action</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADD_TO_DATE_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Variable Reference</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADD_TO_DATE_ACTION__VARIABLE_REFERENCE = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Variable Usages</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADD_TO_DATE_ACTION__VARIABLE_USAGES = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Add To Date Action</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADD_TO_DATE_ACTION_FEATURE_COUNT = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.actions.impl.DataIteratorActionImpl <em>Data
     * Iterator Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.actions.impl.DataIteratorActionImpl
     * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getDataIteratorAction()
     * @generated
     */
    int DATA_ITERATOR_ACTION = 5;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_ITERATOR_ACTION__ID = SeffPackage.ABSTRACT_LOOP_ACTION__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_ITERATOR_ACTION__ENTITY_NAME = SeffPackage.ABSTRACT_LOOP_ACTION__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_ITERATOR_ACTION__PREDECESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_LOOP_ACTION__PREDECESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_ITERATOR_ACTION__SUCCESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_LOOP_ACTION__SUCCESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Resource Demanding Behaviour Abstract Action</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_ITERATOR_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_LOOP_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_ITERATOR_ACTION__RESOURCE_DEMAND_ACTION = SeffPackage.ABSTRACT_LOOP_ACTION__RESOURCE_DEMAND_ACTION;

    /**
     * The feature id for the '<em><b>Infrastructure Call Action</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_ITERATOR_ACTION__INFRASTRUCTURE_CALL_ACTION = SeffPackage.ABSTRACT_LOOP_ACTION__INFRASTRUCTURE_CALL_ACTION;

    /**
     * The feature id for the '<em><b>Resource Call Action</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_ITERATOR_ACTION__RESOURCE_CALL_ACTION = SeffPackage.ABSTRACT_LOOP_ACTION__RESOURCE_CALL_ACTION;

    /**
     * The feature id for the '<em><b>Body Behaviour Loop</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_ITERATOR_ACTION__BODY_BEHAVIOUR_LOOP = SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP;

    /**
     * The feature id for the '<em><b>Variable Reference</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_ITERATOR_ACTION__VARIABLE_REFERENCE = SeffPackage.ABSTRACT_LOOP_ACTION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Data Iterator Action</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_ITERATOR_ACTION_FEATURE_COUNT = SeffPackage.ABSTRACT_LOOP_ACTION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.actions.impl.PutTimeOnStackActionImpl <em>Put Time
     * On Stack Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.actions.impl.PutTimeOnStackActionImpl
     * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getPutTimeOnStackAction()
     * @generated
     */
    int PUT_TIME_ON_STACK_ACTION = 6;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PUT_TIME_ON_STACK_ACTION__ID = SeffPackage.ABSTRACT_ACTION__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PUT_TIME_ON_STACK_ACTION__ENTITY_NAME = SeffPackage.ABSTRACT_ACTION__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PUT_TIME_ON_STACK_ACTION__PREDECESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PUT_TIME_ON_STACK_ACTION__SUCCESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Resource Demanding Behaviour Abstract Action</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PUT_TIME_ON_STACK_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Variable Reference</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PUT_TIME_ON_STACK_ACTION__VARIABLE_REFERENCE = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Put Time On Stack Action</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PUT_TIME_ON_STACK_ACTION_FEATURE_COUNT = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 1;

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.actions.AnalyseStackAction <em>Analyse Stack
     * Action</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Analyse Stack Action</em>'.
     * @see org.palladiosimulator.indirections.actions.AnalyseStackAction
     * @generated
     */
    EClass getAnalyseStackAction();

    /**
     * Returns the meta object for the containment reference
     * '{@link org.palladiosimulator.indirections.actions.AnalyseStackAction#getVariableReference
     * <em>Variable Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference '<em>Variable Reference</em>'.
     * @see org.palladiosimulator.indirections.actions.AnalyseStackAction#getVariableReference()
     * @see #getAnalyseStackAction()
     * @generated
     */
    EReference getAnalyseStackAction_VariableReference();

    /**
     * Returns the meta object for the attribute
     * '{@link org.palladiosimulator.indirections.actions.AnalyseStackAction#getMeasurementIdentificationKey
     * <em>Measurement Identification Key</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Measurement Identification Key</em>'.
     * @see org.palladiosimulator.indirections.actions.AnalyseStackAction#getMeasurementIdentificationKey()
     * @see #getAnalyseStackAction()
     * @generated
     */
    EAttribute getAnalyseStackAction_MeasurementIdentificationKey();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.actions.ConsumeDataAction <em>Consume Data
     * Action</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Consume Data Action</em>'.
     * @see org.palladiosimulator.indirections.actions.ConsumeDataAction
     * @generated
     */
    EClass getConsumeDataAction();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getDataSinkRole <em>Data
     * Sink Role</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Data Sink Role</em>'.
     * @see org.palladiosimulator.indirections.actions.ConsumeDataAction#getDataSinkRole()
     * @see #getConsumeDataAction()
     * @generated
     */
    EReference getConsumeDataAction_DataSinkRole();

    /**
     * Returns the meta object for the containment reference
     * '{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getVariableReference
     * <em>Variable Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference '<em>Variable Reference</em>'.
     * @see org.palladiosimulator.indirections.actions.ConsumeDataAction#getVariableReference()
     * @see #getConsumeDataAction()
     * @generated
     */
    EReference getConsumeDataAction_VariableReference();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.actions.EmitDataAction <em>Emit Data
     * Action</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Emit Data Action</em>'.
     * @see org.palladiosimulator.indirections.actions.EmitDataAction
     * @generated
     */
    EClass getEmitDataAction();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.actions.EmitDataAction#getDataSourceRole <em>Data
     * Source Role</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Data Source Role</em>'.
     * @see org.palladiosimulator.indirections.actions.EmitDataAction#getDataSourceRole()
     * @see #getEmitDataAction()
     * @generated
     */
    EReference getEmitDataAction_DataSourceRole();

    /**
     * Returns the meta object for the containment reference
     * '{@link org.palladiosimulator.indirections.actions.EmitDataAction#getVariableReference
     * <em>Variable Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference '<em>Variable Reference</em>'.
     * @see org.palladiosimulator.indirections.actions.EmitDataAction#getVariableReference()
     * @see #getEmitDataAction()
     * @generated
     */
    EReference getEmitDataAction_VariableReference();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.actions.CreateDateAction <em>Create Date
     * Action</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Create Date Action</em>'.
     * @see org.palladiosimulator.indirections.actions.CreateDateAction
     * @generated
     */
    EClass getCreateDateAction();

    /**
     * Returns the meta object for the containment reference
     * '{@link org.palladiosimulator.indirections.actions.CreateDateAction#getVariableReference
     * <em>Variable Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference '<em>Variable Reference</em>'.
     * @see org.palladiosimulator.indirections.actions.CreateDateAction#getVariableReference()
     * @see #getCreateDateAction()
     * @generated
     */
    EReference getCreateDateAction_VariableReference();

    /**
     * Returns the meta object for the containment reference list
     * '{@link org.palladiosimulator.indirections.actions.CreateDateAction#getVariableUsages
     * <em>Variable Usages</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '<em>Variable Usages</em>'.
     * @see org.palladiosimulator.indirections.actions.CreateDateAction#getVariableUsages()
     * @see #getCreateDateAction()
     * @generated
     */
    EReference getCreateDateAction_VariableUsages();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.actions.AddToDateAction <em>Add To Date
     * Action</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Add To Date Action</em>'.
     * @see org.palladiosimulator.indirections.actions.AddToDateAction
     * @generated
     */
    EClass getAddToDateAction();

    /**
     * Returns the meta object for the containment reference
     * '{@link org.palladiosimulator.indirections.actions.AddToDateAction#getVariableReference
     * <em>Variable Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference '<em>Variable Reference</em>'.
     * @see org.palladiosimulator.indirections.actions.AddToDateAction#getVariableReference()
     * @see #getAddToDateAction()
     * @generated
     */
    EReference getAddToDateAction_VariableReference();

    /**
     * Returns the meta object for the containment reference list
     * '{@link org.palladiosimulator.indirections.actions.AddToDateAction#getVariableUsages
     * <em>Variable Usages</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '<em>Variable Usages</em>'.
     * @see org.palladiosimulator.indirections.actions.AddToDateAction#getVariableUsages()
     * @see #getAddToDateAction()
     * @generated
     */
    EReference getAddToDateAction_VariableUsages();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.actions.DataIteratorAction <em>Data Iterator
     * Action</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Data Iterator Action</em>'.
     * @see org.palladiosimulator.indirections.actions.DataIteratorAction
     * @generated
     */
    EClass getDataIteratorAction();

    /**
     * Returns the meta object for the containment reference
     * '{@link org.palladiosimulator.indirections.actions.DataIteratorAction#getVariableReference
     * <em>Variable Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference '<em>Variable Reference</em>'.
     * @see org.palladiosimulator.indirections.actions.DataIteratorAction#getVariableReference()
     * @see #getDataIteratorAction()
     * @generated
     */
    EReference getDataIteratorAction_VariableReference();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.actions.PutTimeOnStackAction <em>Put Time On Stack
     * Action</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Put Time On Stack Action</em>'.
     * @see org.palladiosimulator.indirections.actions.PutTimeOnStackAction
     * @generated
     */
    EClass getPutTimeOnStackAction();

    /**
     * Returns the meta object for the containment reference
     * '{@link org.palladiosimulator.indirections.actions.PutTimeOnStackAction#getVariableReference
     * <em>Variable Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference '<em>Variable Reference</em>'.
     * @see org.palladiosimulator.indirections.actions.PutTimeOnStackAction#getVariableReference()
     * @see #getPutTimeOnStackAction()
     * @generated
     */
    EReference getPutTimeOnStackAction_VariableReference();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ActionsFactory getActionsFactory();

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
         * '{@link org.palladiosimulator.indirections.actions.impl.AnalyseStackActionImpl
         * <em>Analyse Stack Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.actions.impl.AnalyseStackActionImpl
         * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getAnalyseStackAction()
         * @generated
         */
        EClass ANALYSE_STACK_ACTION = eINSTANCE.getAnalyseStackAction();

        /**
         * The meta object literal for the '<em><b>Variable Reference</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference ANALYSE_STACK_ACTION__VARIABLE_REFERENCE = eINSTANCE.getAnalyseStackAction_VariableReference();

        /**
         * The meta object literal for the '<em><b>Measurement Identification Key</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ANALYSE_STACK_ACTION__MEASUREMENT_IDENTIFICATION_KEY = eINSTANCE
            .getAnalyseStackAction_MeasurementIdentificationKey();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl <em>Consume
         * Data Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl
         * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getConsumeDataAction()
         * @generated
         */
        EClass CONSUME_DATA_ACTION = eINSTANCE.getConsumeDataAction();

        /**
         * The meta object literal for the '<em><b>Data Sink Role</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference CONSUME_DATA_ACTION__DATA_SINK_ROLE = eINSTANCE.getConsumeDataAction_DataSinkRole();

        /**
         * The meta object literal for the '<em><b>Variable Reference</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference CONSUME_DATA_ACTION__VARIABLE_REFERENCE = eINSTANCE.getConsumeDataAction_VariableReference();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl <em>Emit Data
         * Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl
         * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getEmitDataAction()
         * @generated
         */
        EClass EMIT_DATA_ACTION = eINSTANCE.getEmitDataAction();

        /**
         * The meta object literal for the '<em><b>Data Source Role</b></em>' reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference EMIT_DATA_ACTION__DATA_SOURCE_ROLE = eINSTANCE.getEmitDataAction_DataSourceRole();

        /**
         * The meta object literal for the '<em><b>Variable Reference</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference EMIT_DATA_ACTION__VARIABLE_REFERENCE = eINSTANCE.getEmitDataAction_VariableReference();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.actions.impl.CreateDateActionImpl <em>Create
         * Date Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.actions.impl.CreateDateActionImpl
         * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getCreateDateAction()
         * @generated
         */
        EClass CREATE_DATE_ACTION = eINSTANCE.getCreateDateAction();

        /**
         * The meta object literal for the '<em><b>Variable Reference</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference CREATE_DATE_ACTION__VARIABLE_REFERENCE = eINSTANCE.getCreateDateAction_VariableReference();

        /**
         * The meta object literal for the '<em><b>Variable Usages</b></em>' containment reference
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference CREATE_DATE_ACTION__VARIABLE_USAGES = eINSTANCE.getCreateDateAction_VariableUsages();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.actions.impl.AddToDateActionImpl <em>Add To
         * Date Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.actions.impl.AddToDateActionImpl
         * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getAddToDateAction()
         * @generated
         */
        EClass ADD_TO_DATE_ACTION = eINSTANCE.getAddToDateAction();

        /**
         * The meta object literal for the '<em><b>Variable Reference</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference ADD_TO_DATE_ACTION__VARIABLE_REFERENCE = eINSTANCE.getAddToDateAction_VariableReference();

        /**
         * The meta object literal for the '<em><b>Variable Usages</b></em>' containment reference
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference ADD_TO_DATE_ACTION__VARIABLE_USAGES = eINSTANCE.getAddToDateAction_VariableUsages();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.actions.impl.DataIteratorActionImpl <em>Data
         * Iterator Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.actions.impl.DataIteratorActionImpl
         * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getDataIteratorAction()
         * @generated
         */
        EClass DATA_ITERATOR_ACTION = eINSTANCE.getDataIteratorAction();

        /**
         * The meta object literal for the '<em><b>Variable Reference</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference DATA_ITERATOR_ACTION__VARIABLE_REFERENCE = eINSTANCE.getDataIteratorAction_VariableReference();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.actions.impl.PutTimeOnStackActionImpl <em>Put
         * Time On Stack Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.actions.impl.PutTimeOnStackActionImpl
         * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getPutTimeOnStackAction()
         * @generated
         */
        EClass PUT_TIME_ON_STACK_ACTION = eINSTANCE.getPutTimeOnStackAction();

        /**
         * The meta object literal for the '<em><b>Variable Reference</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference PUT_TIME_ON_STACK_ACTION__VARIABLE_REFERENCE = eINSTANCE.getPutTimeOnStackAction_VariableReference();

    }

} // ActionsPackage
