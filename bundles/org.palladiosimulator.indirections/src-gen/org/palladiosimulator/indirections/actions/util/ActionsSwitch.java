/**
 */
package org.palladiosimulator.indirections.actions.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.AddToDateAction;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.CreateDateAction;
import org.palladiosimulator.indirections.actions.DataAction;
import org.palladiosimulator.indirections.actions.DataIteratorAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.actions.JavaClassRegroupDataAction;
import org.palladiosimulator.indirections.actions.PutTimeOnStackAction;
import org.palladiosimulator.indirections.actions.RegroupDataAction;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.core.entity.NamedElement;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.AbstractInternalControlFlowAction;
import org.palladiosimulator.pcm.seff.AbstractLoopAction;

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
                result = this.caseDataAction(analyseStackAction);
            }
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
                result = this.caseDataAction(consumeDataAction);
            }
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
                result = this.caseDataAction(emitDataAction);
            }
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
        case ActionsPackage.CREATE_DATE_ACTION: {
            final CreateDateAction createDateAction = (CreateDateAction) theEObject;
            T result = this.caseCreateDateAction(createDateAction);
            if (result == null) {
                result = this.caseDataAction(createDateAction);
            }
            if (result == null) {
                result = this.caseAbstractAction(createDateAction);
            }
            if (result == null) {
                result = this.caseEntity(createDateAction);
            }
            if (result == null) {
                result = this.caseIdentifier(createDateAction);
            }
            if (result == null) {
                result = this.caseNamedElement(createDateAction);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ActionsPackage.ADD_TO_DATE_ACTION: {
            final AddToDateAction addToDateAction = (AddToDateAction) theEObject;
            T result = this.caseAddToDateAction(addToDateAction);
            if (result == null) {
                result = this.caseDataAction(addToDateAction);
            }
            if (result == null) {
                result = this.caseAbstractAction(addToDateAction);
            }
            if (result == null) {
                result = this.caseEntity(addToDateAction);
            }
            if (result == null) {
                result = this.caseIdentifier(addToDateAction);
            }
            if (result == null) {
                result = this.caseNamedElement(addToDateAction);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ActionsPackage.DATA_ITERATOR_ACTION: {
            final DataIteratorAction dataIteratorAction = (DataIteratorAction) theEObject;
            T result = this.caseDataIteratorAction(dataIteratorAction);
            if (result == null) {
                result = this.caseAbstractLoopAction(dataIteratorAction);
            }
            if (result == null) {
                result = this.caseDataAction(dataIteratorAction);
            }
            if (result == null) {
                result = this.caseAbstractInternalControlFlowAction(dataIteratorAction);
            }
            if (result == null) {
                result = this.caseAbstractAction(dataIteratorAction);
            }
            if (result == null) {
                result = this.caseEntity(dataIteratorAction);
            }
            if (result == null) {
                result = this.caseIdentifier(dataIteratorAction);
            }
            if (result == null) {
                result = this.caseNamedElement(dataIteratorAction);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ActionsPackage.PUT_TIME_ON_STACK_ACTION: {
            final PutTimeOnStackAction putTimeOnStackAction = (PutTimeOnStackAction) theEObject;
            T result = this.casePutTimeOnStackAction(putTimeOnStackAction);
            if (result == null) {
                result = this.caseDataAction(putTimeOnStackAction);
            }
            if (result == null) {
                result = this.caseAbstractAction(putTimeOnStackAction);
            }
            if (result == null) {
                result = this.caseEntity(putTimeOnStackAction);
            }
            if (result == null) {
                result = this.caseIdentifier(putTimeOnStackAction);
            }
            if (result == null) {
                result = this.caseNamedElement(putTimeOnStackAction);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ActionsPackage.REGROUP_DATA_ACTION: {
            final RegroupDataAction regroupDataAction = (RegroupDataAction) theEObject;
            T result = this.caseRegroupDataAction(regroupDataAction);
            if (result == null) {
                result = this.caseDataAction(regroupDataAction);
            }
            if (result == null) {
                result = this.caseAbstractAction(regroupDataAction);
            }
            if (result == null) {
                result = this.caseEntity(regroupDataAction);
            }
            if (result == null) {
                result = this.caseIdentifier(regroupDataAction);
            }
            if (result == null) {
                result = this.caseNamedElement(regroupDataAction);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ActionsPackage.JAVA_CLASS_REGROUP_DATA_ACTION: {
            final JavaClassRegroupDataAction javaClassRegroupDataAction = (JavaClassRegroupDataAction) theEObject;
            T result = this.caseJavaClassRegroupDataAction(javaClassRegroupDataAction);
            if (result == null) {
                result = this.caseRegroupDataAction(javaClassRegroupDataAction);
            }
            if (result == null) {
                result = this.caseDataAction(javaClassRegroupDataAction);
            }
            if (result == null) {
                result = this.caseAbstractAction(javaClassRegroupDataAction);
            }
            if (result == null) {
                result = this.caseEntity(javaClassRegroupDataAction);
            }
            if (result == null) {
                result = this.caseIdentifier(javaClassRegroupDataAction);
            }
            if (result == null) {
                result = this.caseNamedElement(javaClassRegroupDataAction);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ActionsPackage.DATA_ACTION: {
            final DataAction dataAction = (DataAction) theEObject;
            T result = this.caseDataAction(dataAction);
            if (result == null) {
                result = this.caseAbstractAction(dataAction);
            }
            if (result == null) {
                result = this.caseEntity(dataAction);
            }
            if (result == null) {
                result = this.caseIdentifier(dataAction);
            }
            if (result == null) {
                result = this.caseNamedElement(dataAction);
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
     * Returns the result of interpreting the object as an instance of '<em>Create Date
     * Action</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null
     * result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Create Date
     *         Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCreateDateAction(final CreateDateAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Add To Date
     * Action</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null
     * result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Add To Date
     *         Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAddToDateAction(final AddToDateAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Iterator
     * Action</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null
     * result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Iterator
     *         Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataIteratorAction(final DataIteratorAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Put Time On Stack
     * Action</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null
     * result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Put Time On Stack
     *         Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePutTimeOnStackAction(final PutTimeOnStackAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Regroup Data
     * Action</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null
     * result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Regroup Data
     *         Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRegroupDataAction(final RegroupDataAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Java Class Regroup Data
     * Action</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null
     * result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Java Class Regroup Data
     *         Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJavaClassRegroupDataAction(final JavaClassRegroupDataAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Action</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataAction(final DataAction object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Abstract Internal
     * Control Flow Action</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Internal
     *         Control Flow Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractInternalControlFlowAction(final AbstractInternalControlFlowAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Loop
     * Action</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null
     * result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Loop
     *         Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractLoopAction(final AbstractLoopAction object) {
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
