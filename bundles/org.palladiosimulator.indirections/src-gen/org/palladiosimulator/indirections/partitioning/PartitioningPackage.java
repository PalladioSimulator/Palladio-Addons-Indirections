/**
 */
package org.palladiosimulator.indirections.partitioning;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.palladiosimulator.pcm.core.entity.EntityPackage;

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
 * @see org.palladiosimulator.indirections.partitioning.PartitioningFactory
 * @model kind="package"
 * @generated
 */
public interface PartitioningPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "partitioning";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://palladiosimulator.org/Indirections/Partitioning/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.palladiosimulator.indirections.partitioning";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PartitioningPackage eINSTANCE = org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.partitioning.impl.PartitioningImpl <em>Partitioning</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.partitioning.impl.PartitioningImpl
	 * @see org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl#getPartitioning()
	 * @generated
	 */
	int PARTITIONING = 0;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITIONING__ENTITY_NAME = EntityPackage.NAMED_ELEMENT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITIONING__SPECIFICATION = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Partitioning</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITIONING_FEATURE_COUNT = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.partitioning.TimeGrouping <em>Time Grouping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.partitioning.TimeGrouping
	 * @see org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl#getTimeGrouping()
	 * @generated
	 */
	int TIME_GROUPING = 1;

	/**
	 * The number of structural features of the '<em>Time Grouping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_GROUPING_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.partitioning.impl.WindowingImpl <em>Windowing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.partitioning.impl.WindowingImpl
	 * @see org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl#getWindowing()
	 * @generated
	 */
	int WINDOWING = 2;

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
	 * The number of structural features of the '<em>Windowing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWING_FEATURE_COUNT = TIME_GROUPING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.partitioning.impl.ConsumeAllAvailableImpl <em>Consume All Available</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.partitioning.impl.ConsumeAllAvailableImpl
	 * @see org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl#getConsumeAllAvailable()
	 * @generated
	 */
	int CONSUME_ALL_AVAILABLE = 3;

	/**
	 * The number of structural features of the '<em>Consume All Available</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUME_ALL_AVAILABLE_FEATURE_COUNT = TIME_GROUPING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.indirections.partitioning.impl.CollectWithHoldbackImpl <em>Collect With Holdback</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.indirections.partitioning.impl.CollectWithHoldbackImpl
	 * @see org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl#getCollectWithHoldback()
	 * @generated
	 */
	int COLLECT_WITH_HOLDBACK = 4;

	/**
	 * The feature id for the '<em><b>Holdback</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECT_WITH_HOLDBACK__HOLDBACK = TIME_GROUPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECT_WITH_HOLDBACK__KEY = TIME_GROUPING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collect With Holdback</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECT_WITH_HOLDBACK_FEATURE_COUNT = TIME_GROUPING_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.partitioning.Partitioning <em>Partitioning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partitioning</em>'.
	 * @see org.palladiosimulator.indirections.partitioning.Partitioning
	 * @generated
	 */
	EClass getPartitioning();

	/**
	 * Returns the meta object for the containment reference list '{@link org.palladiosimulator.indirections.partitioning.Partitioning#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Specification</em>'.
	 * @see org.palladiosimulator.indirections.partitioning.Partitioning#getSpecification()
	 * @see #getPartitioning()
	 * @generated
	 */
	EReference getPartitioning_Specification();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.partitioning.TimeGrouping <em>Time Grouping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Grouping</em>'.
	 * @see org.palladiosimulator.indirections.partitioning.TimeGrouping
	 * @generated
	 */
	EClass getTimeGrouping();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.partitioning.Windowing <em>Windowing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windowing</em>'.
	 * @see org.palladiosimulator.indirections.partitioning.Windowing
	 * @generated
	 */
	EClass getWindowing();

	/**
	 * Returns the meta object for the attribute '{@link org.palladiosimulator.indirections.partitioning.Windowing#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.palladiosimulator.indirections.partitioning.Windowing#getSize()
	 * @see #getWindowing()
	 * @generated
	 */
	EAttribute getWindowing_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.palladiosimulator.indirections.partitioning.Windowing#getShift <em>Shift</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shift</em>'.
	 * @see org.palladiosimulator.indirections.partitioning.Windowing#getShift()
	 * @see #getWindowing()
	 * @generated
	 */
	EAttribute getWindowing_Shift();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.partitioning.ConsumeAllAvailable <em>Consume All Available</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consume All Available</em>'.
	 * @see org.palladiosimulator.indirections.partitioning.ConsumeAllAvailable
	 * @generated
	 */
	EClass getConsumeAllAvailable();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.indirections.partitioning.CollectWithHoldback <em>Collect With Holdback</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collect With Holdback</em>'.
	 * @see org.palladiosimulator.indirections.partitioning.CollectWithHoldback
	 * @generated
	 */
	EClass getCollectWithHoldback();

	/**
	 * Returns the meta object for the attribute '{@link org.palladiosimulator.indirections.partitioning.CollectWithHoldback#getHoldback <em>Holdback</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Holdback</em>'.
	 * @see org.palladiosimulator.indirections.partitioning.CollectWithHoldback#getHoldback()
	 * @see #getCollectWithHoldback()
	 * @generated
	 */
	EAttribute getCollectWithHoldback_Holdback();

	/**
	 * Returns the meta object for the attribute '{@link org.palladiosimulator.indirections.partitioning.CollectWithHoldback#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.palladiosimulator.indirections.partitioning.CollectWithHoldback#getKey()
	 * @see #getCollectWithHoldback()
	 * @generated
	 */
	EAttribute getCollectWithHoldback_Key();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PartitioningFactory getPartitioningFactory();

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
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.partitioning.impl.PartitioningImpl <em>Partitioning</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.partitioning.impl.PartitioningImpl
		 * @see org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl#getPartitioning()
		 * @generated
		 */
		EClass PARTITIONING = eINSTANCE.getPartitioning();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTITIONING__SPECIFICATION = eINSTANCE.getPartitioning_Specification();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.partitioning.TimeGrouping <em>Time Grouping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.partitioning.TimeGrouping
		 * @see org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl#getTimeGrouping()
		 * @generated
		 */
		EClass TIME_GROUPING = eINSTANCE.getTimeGrouping();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.partitioning.impl.WindowingImpl <em>Windowing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.partitioning.impl.WindowingImpl
		 * @see org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl#getWindowing()
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
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.partitioning.impl.ConsumeAllAvailableImpl <em>Consume All Available</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.partitioning.impl.ConsumeAllAvailableImpl
		 * @see org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl#getConsumeAllAvailable()
		 * @generated
		 */
		EClass CONSUME_ALL_AVAILABLE = eINSTANCE.getConsumeAllAvailable();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.indirections.partitioning.impl.CollectWithHoldbackImpl <em>Collect With Holdback</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.indirections.partitioning.impl.CollectWithHoldbackImpl
		 * @see org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl#getCollectWithHoldback()
		 * @generated
		 */
		EClass COLLECT_WITH_HOLDBACK = eINSTANCE.getCollectWithHoldback();

		/**
		 * The meta object literal for the '<em><b>Holdback</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECT_WITH_HOLDBACK__HOLDBACK = eINSTANCE.getCollectWithHoldback_Holdback();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECT_WITH_HOLDBACK__KEY = eINSTANCE.getCollectWithHoldback_Key();

	}

} //PartitioningPackage
