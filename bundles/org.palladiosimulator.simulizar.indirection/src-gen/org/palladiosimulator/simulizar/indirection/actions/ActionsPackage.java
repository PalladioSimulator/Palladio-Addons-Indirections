/**
 */
package org.palladiosimulator.simulizar.indirection.actions;

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
 * @see org.palladiosimulator.simulizar.indirection.actions.ActionsFactory
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
	String eNS_URI = "http://palladiosimulator.org/Indirection/Actions/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.palladiosimulator.simulizar.indirection.actions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionsPackage eINSTANCE = org.palladiosimulator.simulizar.indirection.actions.impl.ActionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.palladiosimulator.simulizar.indirection.actions.impl.AnalyseStackActionImpl <em>Analyse Stack Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.simulizar.indirection.actions.impl.AnalyseStackActionImpl
	 * @see org.palladiosimulator.simulizar.indirection.actions.impl.ActionsPackageImpl#getAnalyseStackAction()
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
	 * The meta object id for the '{@link org.palladiosimulator.simulizar.indirection.actions.impl.ConsumeEventActionImpl <em>Consume Event Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.simulizar.indirection.actions.impl.ConsumeEventActionImpl
	 * @see org.palladiosimulator.simulizar.indirection.actions.impl.ActionsPackageImpl#getConsumeEventAction()
	 * @generated
	 */
	int CONSUME_EVENT_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_EVENT_ACTION__ID = SeffPackage.ABSTRACT_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_EVENT_ACTION__ENTITY_NAME = SeffPackage.ABSTRACT_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_EVENT_ACTION__PREDECESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_EVENT_ACTION__SUCCESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demanding Behaviour Abstract Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_EVENT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Input Variable Usages Call Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Return Variable Usage Call Return Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_EVENT_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Event Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_EVENT_ACTION__EVENT_TYPE = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sink Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_EVENT_ACTION__SINK_ROLE = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Consume Event Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_EVENT_ACTION_FEATURE_COUNT = SeffPackage.ABSTRACT_ACTION_FEATURE_COUNT + 4;

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.simulizar.indirection.actions.AnalyseStackAction <em>Analyse Stack Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Analyse Stack Action</em>'.
	 * @see org.palladiosimulator.simulizar.indirection.actions.AnalyseStackAction
	 * @generated
	 */
	EClass getAnalyseStackAction();

	/**
	 * Returns the meta object for the attribute '{@link org.palladiosimulator.simulizar.indirection.actions.AnalyseStackAction#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.palladiosimulator.simulizar.indirection.actions.AnalyseStackAction#getKey()
	 * @see #getAnalyseStackAction()
	 * @generated
	 */
	EAttribute getAnalyseStackAction_Key();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.simulizar.indirection.actions.ConsumeEventAction <em>Consume Event Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consume Event Action</em>'.
	 * @see org.palladiosimulator.simulizar.indirection.actions.ConsumeEventAction
	 * @generated
	 */
	EClass getConsumeEventAction();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.simulizar.indirection.actions.ConsumeEventAction#getEventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Type</em>'.
	 * @see org.palladiosimulator.simulizar.indirection.actions.ConsumeEventAction#getEventType()
	 * @see #getConsumeEventAction()
	 * @generated
	 */
	EReference getConsumeEventAction_EventType();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.simulizar.indirection.actions.ConsumeEventAction#getSinkRole <em>Sink Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sink Role</em>'.
	 * @see org.palladiosimulator.simulizar.indirection.actions.ConsumeEventAction#getSinkRole()
	 * @see #getConsumeEventAction()
	 * @generated
	 */
	EReference getConsumeEventAction_SinkRole();

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
		 * The meta object literal for the '{@link org.palladiosimulator.simulizar.indirection.actions.impl.AnalyseStackActionImpl <em>Analyse Stack Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.simulizar.indirection.actions.impl.AnalyseStackActionImpl
		 * @see org.palladiosimulator.simulizar.indirection.actions.impl.ActionsPackageImpl#getAnalyseStackAction()
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
		 * The meta object literal for the '{@link org.palladiosimulator.simulizar.indirection.actions.impl.ConsumeEventActionImpl <em>Consume Event Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.simulizar.indirection.actions.impl.ConsumeEventActionImpl
		 * @see org.palladiosimulator.simulizar.indirection.actions.impl.ActionsPackageImpl#getConsumeEventAction()
		 * @generated
		 */
		EClass CONSUME_EVENT_ACTION = eINSTANCE.getConsumeEventAction();

		/**
		 * The meta object literal for the '<em><b>Event Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSUME_EVENT_ACTION__EVENT_TYPE = eINSTANCE.getConsumeEventAction_EventType();

		/**
		 * The meta object literal for the '<em><b>Sink Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSUME_EVENT_ACTION__SINK_ROLE = eINSTANCE.getConsumeEventAction_SinkRole();

	}

} //ActionsPackage
