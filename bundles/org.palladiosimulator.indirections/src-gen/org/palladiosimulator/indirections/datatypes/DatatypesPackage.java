/**
 */
package org.palladiosimulator.indirections.datatypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.palladiosimulator.indirections.datatypes.DatatypesFactory
 * @model kind="package"
 * @generated
 */
public interface DatatypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "datatypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://palladiosimulator.org/Indirections/Datatypes/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.palladiosimulator.indirections.datatypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DatatypesPackage eINSTANCE = org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.datatypes.TimeGrouping <em>Time Grouping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.datatypes.TimeGrouping
	 * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getTimeGrouping()
	 * @generated
	 */
	int TIME_GROUPING = 0;

	/**
	 * The number of structural features of the '<em>Time Grouping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_GROUPING_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.datatypes.impl.WindowingImpl <em>Windowing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.datatypes.impl.WindowingImpl
	 * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getWindowing()
	 * @generated
	 */
	int WINDOWING = 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWING__SIZE = TIME_GROUPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shift</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWING__SHIFT = TIME_GROUPING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Grace Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWING__GRACE_PERIOD = TIME_GROUPING_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Windowing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWING_FEATURE_COUNT = TIME_GROUPING_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.datatypes.Scheduling <em>Scheduling</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.datatypes.Scheduling
	 * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getScheduling()
	 * @generated
	 */
	int SCHEDULING = 2;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.datatypes.EmitToChannelPolicy <em>Emit To Channel Policy</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.datatypes.EmitToChannelPolicy
	 * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getEmitToChannelPolicy()
	 * @generated
	 */
	int EMIT_TO_CHANNEL_POLICY = 3;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.datatypes.ConsumeFromChannelPolicy <em>Consume From Channel Policy</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.datatypes.ConsumeFromChannelPolicy
	 * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getConsumeFromChannelPolicy()
	 * @generated
	 */
	int CONSUME_FROM_CHANNEL_POLICY = 4;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.datatypes.NumberOfElements <em>Number Of Elements</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.datatypes.NumberOfElements
	 * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getNumberOfElements()
	 * @generated
	 */
	int NUMBER_OF_ELEMENTS = 5;

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.datatypes.TimeGrouping <em>Time Grouping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Grouping</em>'.
	 * @see org.palladiosimulator.indirections.datatypes.TimeGrouping
	 * @generated
	 */
	EClass getTimeGrouping();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.datatypes.Windowing <em>Windowing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windowing</em>'.
	 * @see org.palladiosimulator.indirections.datatypes.Windowing
	 * @generated
	 */
	EClass getWindowing();

	/**
	 * Returns the meta object for the attribute '{@link org.palladiosimulator.indirections.datatypes.Windowing#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.palladiosimulator.indirections.datatypes.Windowing#getSize()
	 * @see #getWindowing()
	 * @generated
	 */
	EAttribute getWindowing_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.palladiosimulator.indirections.datatypes.Windowing#getShift <em>Shift</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shift</em>'.
	 * @see org.palladiosimulator.indirections.datatypes.Windowing#getShift()
	 * @see #getWindowing()
	 * @generated
	 */
	EAttribute getWindowing_Shift();

	/**
	 * Returns the meta object for the attribute '{@link org.palladiosimulator.indirections.datatypes.Windowing#getGracePeriod <em>Grace Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grace Period</em>'.
	 * @see org.palladiosimulator.indirections.datatypes.Windowing#getGracePeriod()
	 * @see #getWindowing()
	 * @generated
	 */
	EAttribute getWindowing_GracePeriod();

	/**
	 * Returns the meta object for enum '{@link org.palladiosimulator.indirections.datatypes.Scheduling <em>Scheduling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Scheduling</em>'.
	 * @see org.palladiosimulator.indirections.datatypes.Scheduling
	 * @generated
	 */
	EEnum getScheduling();

	/**
	 * Returns the meta object for enum '{@link org.palladiosimulator.indirections.datatypes.EmitToChannelPolicy <em>Emit To Channel Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Emit To Channel Policy</em>'.
	 * @see org.palladiosimulator.indirections.datatypes.EmitToChannelPolicy
	 * @generated
	 */
	EEnum getEmitToChannelPolicy();

	/**
	 * Returns the meta object for enum '{@link org.palladiosimulator.indirections.datatypes.ConsumeFromChannelPolicy <em>Consume From Channel Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Consume From Channel Policy</em>'.
	 * @see org.palladiosimulator.indirections.datatypes.ConsumeFromChannelPolicy
	 * @generated
	 */
	EEnum getConsumeFromChannelPolicy();

	/**
	 * Returns the meta object for enum '{@link org.palladiosimulator.indirections.datatypes.NumberOfElements <em>Number Of Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Number Of Elements</em>'.
	 * @see org.palladiosimulator.indirections.datatypes.NumberOfElements
	 * @generated
	 */
	EEnum getNumberOfElements();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DatatypesFactory getDatatypesFactory();

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
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.datatypes.TimeGrouping <em>Time Grouping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.datatypes.TimeGrouping
		 * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getTimeGrouping()
		 * @generated
		 */
		EClass TIME_GROUPING = eINSTANCE.getTimeGrouping();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.datatypes.impl.WindowingImpl <em>Windowing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.datatypes.impl.WindowingImpl
		 * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getWindowing()
		 * @generated
		 */
		EClass WINDOWING = eINSTANCE.getWindowing();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWING__SIZE = eINSTANCE.getWindowing_Size();

		/**
		 * The meta object literal for the '<em><b>Shift</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWING__SHIFT = eINSTANCE.getWindowing_Shift();

		/**
		 * The meta object literal for the '<em><b>Grace Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWING__GRACE_PERIOD = eINSTANCE.getWindowing_GracePeriod();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.datatypes.Scheduling <em>Scheduling</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.datatypes.Scheduling
		 * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getScheduling()
		 * @generated
		 */
		EEnum SCHEDULING = eINSTANCE.getScheduling();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.datatypes.EmitToChannelPolicy <em>Emit To Channel Policy</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.datatypes.EmitToChannelPolicy
		 * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getEmitToChannelPolicy()
		 * @generated
		 */
		EEnum EMIT_TO_CHANNEL_POLICY = eINSTANCE.getEmitToChannelPolicy();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.datatypes.ConsumeFromChannelPolicy <em>Consume From Channel Policy</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.datatypes.ConsumeFromChannelPolicy
		 * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getConsumeFromChannelPolicy()
		 * @generated
		 */
		EEnum CONSUME_FROM_CHANNEL_POLICY = eINSTANCE.getConsumeFromChannelPolicy();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.datatypes.NumberOfElements <em>Number Of Elements</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.datatypes.NumberOfElements
		 * @see org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl#getNumberOfElements()
		 * @generated
		 */
		EEnum NUMBER_OF_ELEMENTS = eINSTANCE.getNumberOfElements();

	}

} //DatatypesPackage
