/**
 */
package org.palladiosimulator.simulizar.indirection.partitioning.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.palladiosimulator.pcm.core.entity.NamedElement;

import org.palladiosimulator.simulizar.indirection.partitioning.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.simulizar.indirection.partitioning.PartitioningPackage
 * @generated
 */
public class PartitioningSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PartitioningPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartitioningSwitch() {
		if (modelPackage == null) {
			modelPackage = PartitioningPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case PartitioningPackage.PARTITIONING: {
			Partitioning partitioning = (Partitioning) theEObject;
			T result = casePartitioning(partitioning);
			if (result == null)
				result = caseNamedElement(partitioning);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case PartitioningPackage.TIME_GROUPING: {
			TimeGrouping timeGrouping = (TimeGrouping) theEObject;
			T result = caseTimeGrouping(timeGrouping);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case PartitioningPackage.WINDOWING: {
			Windowing windowing = (Windowing) theEObject;
			T result = caseWindowing(windowing);
			if (result == null)
				result = caseTimeGrouping(windowing);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case PartitioningPackage.CONSUME_ALL_AVAILABLE: {
			ConsumeAllAvailable consumeAllAvailable = (ConsumeAllAvailable) theEObject;
			T result = caseConsumeAllAvailable(consumeAllAvailable);
			if (result == null)
				result = caseTimeGrouping(consumeAllAvailable);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case PartitioningPackage.COLLECT_WITH_HOLDBACK: {
			CollectWithHoldback collectWithHoldback = (CollectWithHoldback) theEObject;
			T result = caseCollectWithHoldback(collectWithHoldback);
			if (result == null)
				result = caseTimeGrouping(collectWithHoldback);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partitioning</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partitioning</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartitioning(Partitioning object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windowing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windowing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWindowing(Windowing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Grouping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Grouping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeGrouping(TimeGrouping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Consume All Available</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consume All Available</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConsumeAllAvailable(ConsumeAllAvailable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collect With Holdback</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collect With Holdback</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectWithHoldback(CollectWithHoldback object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //PartitioningSwitch
