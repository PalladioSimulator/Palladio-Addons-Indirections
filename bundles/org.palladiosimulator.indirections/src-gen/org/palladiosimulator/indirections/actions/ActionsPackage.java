/**
 */
package org.palladiosimulator.indirections.actions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.palladiosimulator.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.indirections.actions.ActionsFactory
 * @model kind="package"
 * @generated
 */
public interface ActionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "actions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://palladiosimulator.org/Indirections/Actions/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.palladiosimulator.indirections.actions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionsPackage eINSTANCE = org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.actions.impl.AnalyseStackActionImpl <em>Analyse Stack Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.actions.impl.AnalyseStackActionImpl
	 * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getAnalyseStackAction()
	 * @generated
	 */
	int ANALYSE_STACK_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSE_STACK_ACTION__ID = SeffPackage.ABSTRACT_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSE_STACK_ACTION__ENTITY_NAME = SeffPackage.ABSTRACT_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSE_STACK_ACTION__PREDECESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSE_STACK_ACTION__SUCCESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demanding Behaviour Abstract Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSE_STACK_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSE_STACK_ACTION__KEY = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Analyse Stack Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSE_STACK_ACTION_FEATURE_COUNT = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl <em>Consume Data Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl
	 * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getConsumeDataAction()
	 * @generated
	 */
	int CONSUME_DATA_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_DATA_ACTION__ID = SeffPackage.ABSTRACT_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_DATA_ACTION__ENTITY_NAME = SeffPackage.ABSTRACT_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_DATA_ACTION__PREDECESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_DATA_ACTION__SUCCESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demanding Behaviour Abstract Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_DATA_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Input Variable Usages Call Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Return Variable Usage Call Return Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_DATA_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Event Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_DATA_ACTION__EVENT_TYPE = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data Sink Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_DATA_ACTION__DATA_SINK_ROLE = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Consume Data Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_DATA_ACTION_FEATURE_COUNT = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl <em>Emit Data Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl
	 * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getEmitDataAction()
	 * @generated
	 */
	int EMIT_DATA_ACTION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIT_DATA_ACTION__ID = SeffPackage.ABSTRACT_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIT_DATA_ACTION__ENTITY_NAME = SeffPackage.ABSTRACT_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIT_DATA_ACTION__PREDECESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIT_DATA_ACTION__SUCCESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demanding Behaviour Abstract Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIT_DATA_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Input Variable Usages Call Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIT_DATA_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIT_DATA_ACTION__EVENT_TYPE = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIT_DATA_ACTION__DATA_SOURCE_ROLE = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Emit Data Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIT_DATA_ACTION_FEATURE_COUNT = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.actions.AnalyseStackAction <em>Analyse Stack Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Analyse Stack Action</em>'.
	 * @see org.palladiosimulator.indirections.actions.AnalyseStackAction
	 * @generated
	 */
	EClass getAnalyseStackAction();

	/**
	 * Returns the meta object for the attribute '{@link org.palladiosimulator.indirections.actions.AnalyseStackAction#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.palladiosimulator.indirections.actions.AnalyseStackAction#getKey()
	 * @see #getAnalyseStackAction()
	 * @generated
	 */
	EAttribute getAnalyseStackAction_Key();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.actions.ConsumeDataAction <em>Consume Data Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consume Data Action</em>'.
	 * @see org.palladiosimulator.indirections.actions.ConsumeDataAction
	 * @generated
	 */
	EClass getConsumeDataAction();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getEventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Type</em>'.
	 * @see org.palladiosimulator.indirections.actions.ConsumeDataAction#getEventType()
	 * @see #getConsumeDataAction()
	 * @generated
	 */
	EReference getConsumeDataAction_EventType();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getDataSinkRole <em>Data Sink Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Sink Role</em>'.
	 * @see org.palladiosimulator.indirections.actions.ConsumeDataAction#getDataSinkRole()
	 * @see #getConsumeDataAction()
	 * @generated
	 */
	EReference getConsumeDataAction_DataSinkRole();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.actions.EmitDataAction <em>Emit Data Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Emit Data Action</em>'.
	 * @see org.palladiosimulator.indirections.actions.EmitDataAction
	 * @generated
	 */
	EClass getEmitDataAction();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.actions.EmitDataAction#getEventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Type</em>'.
	 * @see org.palladiosimulator.indirections.actions.EmitDataAction#getEventType()
	 * @see #getEmitDataAction()
	 * @generated
	 */
	EReference getEmitDataAction_EventType();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.indirections.actions.EmitDataAction#getDataSourceRole <em>Data Source Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Source Role</em>'.
	 * @see org.palladiosimulator.indirections.actions.EmitDataAction#getDataSourceRole()
	 * @see #getEmitDataAction()
	 * @generated
	 */
	EReference getEmitDataAction_DataSourceRole();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActionsFactory getActionsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.actions.impl.AnalyseStackActionImpl <em>Analyse Stack Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.actions.impl.AnalyseStackActionImpl
		 * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getAnalyseStackAction()
		 * @generated
		 */
		EClass ANALYSE_STACK_ACTION = eINSTANCE.getAnalyseStackAction();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSE_STACK_ACTION__KEY = eINSTANCE.getAnalyseStackAction_Key();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl <em>Consume Data Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.actions.impl.ConsumeDataActionImpl
		 * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getConsumeDataAction()
		 * @generated
		 */
		EClass CONSUME_DATA_ACTION = eINSTANCE.getConsumeDataAction();

		/**
		 * The meta object literal for the '<em><b>Event Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSUME_DATA_ACTION__EVENT_TYPE = eINSTANCE.getConsumeDataAction_EventType();

		/**
		 * The meta object literal for the '<em><b>Data Sink Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSUME_DATA_ACTION__DATA_SINK_ROLE = eINSTANCE.getConsumeDataAction_DataSinkRole();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl <em>Emit Data Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.actions.impl.EmitDataActionImpl
		 * @see org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl#getEmitDataAction()
		 * @generated
		 */
		EClass EMIT_DATA_ACTION = eINSTANCE.getEmitDataAction();

		/**
		 * The meta object literal for the '<em><b>Event Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMIT_DATA_ACTION__EVENT_TYPE = eINSTANCE.getEmitDataAction_EventType();

		/**
		 * The meta object literal for the '<em><b>Data Source Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMIT_DATA_ACTION__DATA_SOURCE_ROLE = eINSTANCE.getEmitDataAction_DataSourceRole();

	}

} //ActionsPackage