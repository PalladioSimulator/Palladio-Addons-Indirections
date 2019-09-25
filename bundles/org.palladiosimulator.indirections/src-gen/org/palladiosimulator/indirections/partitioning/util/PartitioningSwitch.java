/**
 */
package org.palladiosimulator.indirections.partitioning.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.indirections.partitioning.CollectWithHoldback;
import org.palladiosimulator.indirections.partitioning.ConsumeAllAvailable;
import org.palladiosimulator.indirections.partitioning.Joining;
import org.palladiosimulator.indirections.partitioning.Partitioning;
import org.palladiosimulator.indirections.partitioning.PartitioningPackage;
import org.palladiosimulator.indirections.partitioning.TimeGrouping;
import org.palladiosimulator.indirections.partitioning.Windowing;
import org.palladiosimulator.pcm.core.entity.NamedElement;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage
 * @generated
 */
public class PartitioningSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static PartitioningPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PartitioningSwitch() {
        if (modelPackage == null) {
            modelPackage = PartitioningPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param ePackage
     *            the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(final EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(final int classifierID, final EObject theEObject) {
        switch (classifierID) {
        case PartitioningPackage.PARTITIONING: {
            final Partitioning partitioning = (Partitioning) theEObject;
            T result = this.casePartitioning(partitioning);
            if (result == null) {
                result = this.caseNamedElement(partitioning);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PartitioningPackage.TIME_GROUPING: {
            final TimeGrouping timeGrouping = (TimeGrouping) theEObject;
            T result = this.caseTimeGrouping(timeGrouping);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PartitioningPackage.WINDOWING: {
            final Windowing windowing = (Windowing) theEObject;
            T result = this.caseWindowing(windowing);
            if (result == null) {
                result = this.caseTimeGrouping(windowing);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PartitioningPackage.CONSUME_ALL_AVAILABLE: {
            final ConsumeAllAvailable consumeAllAvailable = (ConsumeAllAvailable) theEObject;
            T result = this.caseConsumeAllAvailable(consumeAllAvailable);
            if (result == null) {
                result = this.caseTimeGrouping(consumeAllAvailable);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PartitioningPackage.COLLECT_WITH_HOLDBACK: {
            final CollectWithHoldback collectWithHoldback = (CollectWithHoldback) theEObject;
            T result = this.caseCollectWithHoldback(collectWithHoldback);
            if (result == null) {
                result = this.caseTimeGrouping(collectWithHoldback);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PartitioningPackage.JOINING: {
            final Joining joining = (Joining) theEObject;
            T result = this.caseJoining(joining);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        default:
            return this.defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Partitioning</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Partitioning</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePartitioning(final Partitioning object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Time Grouping</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Time Grouping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTimeGrouping(final TimeGrouping object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Windowing</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Windowing</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWindowing(final Windowing object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Consume All
     * Available</em>'. <!-- begin-user-doc --> This implementation returns null; returning a
     * non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Consume All
     *         Available</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConsumeAllAvailable(final ConsumeAllAvailable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Collect With
     * Holdback</em>'. <!-- begin-user-doc --> This implementation returns null; returning a
     * non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collect With
     *         Holdback</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCollectWithHoldback(final CollectWithHoldback object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Joining</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Joining</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJoining(final Joining object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedElement(final NamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(final EObject object) {
        return null;
    }

} // PartitioningSwitch
