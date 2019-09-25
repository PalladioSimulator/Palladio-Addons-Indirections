/**
 */
package org.palladiosimulator.indirections.actions.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.CreateDataAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.actions.PutDataOnStackAction;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.core.entity.NamedElement;
import org.palladiosimulator.pcm.seff.AbstractAction;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.indirections.actions.ActionsPackage
 * @generated
 */
public class ActionsSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static ActionsPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ActionsSwitch() {
        if (modelPackage == null) {
            modelPackage = ActionsPackage.eINSTANCE;
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
        case ActionsPackage.ANALYSE_STACK_ACTION: {
            final AnalyseStackAction analyseStackAction = (AnalyseStackAction) theEObject;
            T result = this.caseAnalyseStackAction(analyseStackAction);
            if (result == null) {
                result = this.caseAbstractAction(analyseStackAction);
            }
            if (result == null) {
                result = this.caseEntity(analyseStackAction);
            }
            if (result == null) {
                result = this.caseIdentifier(analyseStackAction);
            }
            if (result == null) {
                result = this.caseNamedElement(analyseStackAction);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ActionsPackage.CONSUME_DATA_ACTION: {
            final ConsumeDataAction consumeDataAction = (ConsumeDataAction) theEObject;
            T result = this.caseConsumeDataAction(consumeDataAction);
            if (result == null) {
                result = this.caseAbstractAction(consumeDataAction);
            }
            if (result == null) {
                result = this.caseEntity(consumeDataAction);
            }
            if (result == null) {
                result = this.caseIdentifier(consumeDataAction);
            }
            if (result == null) {
                result = this.caseNamedElement(consumeDataAction);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ActionsPackage.EMIT_DATA_ACTION: {
            final EmitDataAction emitDataAction = (EmitDataAction) theEObject;
            T result = this.caseEmitDataAction(emitDataAction);
            if (result == null) {
                result = this.caseAbstractAction(emitDataAction);
            }
            if (result == null) {
                result = this.caseEntity(emitDataAction);
            }
            if (result == null) {
                result = this.caseIdentifier(emitDataAction);
            }
            if (result == null) {
                result = this.caseNamedElement(emitDataAction);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ActionsPackage.CREATE_DATA_ACTION: {
            final CreateDataAction createDataAction = (CreateDataAction) theEObject;
            T result = this.caseCreateDataAction(createDataAction);
            if (result == null) {
                result = this.caseAbstractAction(createDataAction);
            }
            if (result == null) {
                result = this.caseEntity(createDataAction);
            }
            if (result == null) {
                result = this.caseIdentifier(createDataAction);
            }
            if (result == null) {
                result = this.caseNamedElement(createDataAction);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ActionsPackage.PUT_DATA_ON_STACK_ACTION: {
            final PutDataOnStackAction putDataOnStackAction = (PutDataOnStackAction) theEObject;
            T result = this.casePutDataOnStackAction(putDataOnStackAction);
            if (result == null) {
                result = this.caseAbstractAction(putDataOnStackAction);
            }
            if (result == null) {
                result = this.caseEntity(putDataOnStackAction);
            }
            if (result == null) {
                result = this.caseIdentifier(putDataOnStackAction);
            }
            if (result == null) {
                result = this.caseNamedElement(putDataOnStackAction);
            }
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
     * Returns the result of interpreting the object as an instance of '<em>Analyse Stack
     * Action</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null
     * result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Analyse Stack
     *         Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAnalyseStackAction(final AnalyseStackAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Consume Data
     * Action</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null
     * result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Consume Data
     *         Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConsumeDataAction(final ConsumeDataAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Emit Data Action</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Emit Data Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEmitDataAction(final EmitDataAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Create Data
     * Action</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null
     * result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Create Data
     *         Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCreateDataAction(final CreateDataAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Put Data On Stack
     * Action</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null
     * result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Put Data On Stack
     *         Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePutDataOnStackAction(final PutDataOnStackAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIdentifier(final Identifier object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Entity</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEntity(final Entity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractAction(final AbstractAction object) {
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

} // ActionsSwitch
