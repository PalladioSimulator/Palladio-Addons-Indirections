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
 * @see org.palladiosimulator.indirections.actions.ActionsPackage
 * @generated
 */
public class ActionsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static ActionsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ActionsSwitch() {
		if (modelPackage == null) {
			modelPackage = ActionsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case ActionsPackage.ANALYSE_STACK_ACTION: {
			AnalyseStackAction analyseStackAction = (AnalyseStackAction) theEObject;
			T result = caseAnalyseStackAction(analyseStackAction);
			if (result == null)
				result = caseAbstractAction(analyseStackAction);
			if (result == null)
				result = caseEntity(analyseStackAction);
			if (result == null)
				result = caseIdentifier(analyseStackAction);
			if (result == null)
				result = caseNamedElement(analyseStackAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ActionsPackage.CONSUME_DATA_ACTION: {
			ConsumeDataAction consumeDataAction = (ConsumeDataAction) theEObject;
			T result = caseConsumeDataAction(consumeDataAction);
			if (result == null)
				result = caseAbstractAction(consumeDataAction);
			if (result == null)
				result = caseEntity(consumeDataAction);
			if (result == null)
				result = caseIdentifier(consumeDataAction);
			if (result == null)
				result = caseNamedElement(consumeDataAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ActionsPackage.EMIT_DATA_ACTION: {
			EmitDataAction emitDataAction = (EmitDataAction) theEObject;
			T result = caseEmitDataAction(emitDataAction);
			if (result == null)
				result = caseAbstractAction(emitDataAction);
			if (result == null)
				result = caseEntity(emitDataAction);
			if (result == null)
				result = caseIdentifier(emitDataAction);
			if (result == null)
				result = caseNamedElement(emitDataAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ActionsPackage.CREATE_DATA_ACTION: {
			CreateDataAction createDataAction = (CreateDataAction) theEObject;
			T result = caseCreateDataAction(createDataAction);
			if (result == null)
				result = caseAbstractAction(createDataAction);
			if (result == null)
				result = caseEntity(createDataAction);
			if (result == null)
				result = caseIdentifier(createDataAction);
			if (result == null)
				result = caseNamedElement(createDataAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ActionsPackage.PUT_DATA_ON_STACK_ACTION: {
			PutDataOnStackAction putDataOnStackAction = (PutDataOnStackAction) theEObject;
			T result = casePutDataOnStackAction(putDataOnStackAction);
			if (result == null)
				result = caseAbstractAction(putDataOnStackAction);
			if (result == null)
				result = caseEntity(putDataOnStackAction);
			if (result == null)
				result = caseIdentifier(putDataOnStackAction);
			if (result == null)
				result = caseNamedElement(putDataOnStackAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Analyse Stack Action</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null
	 * result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Analyse Stack Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnalyseStackAction(AnalyseStackAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Consume Data Action</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null
	 * result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consume Data Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConsumeDataAction(ConsumeDataAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Emit Data Action</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Emit Data Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmitDataAction(EmitDataAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Data Action</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null
	 * result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Data Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateDataAction(CreateDataAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Put Data On Stack Action</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null
	 * result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Put Data On Stack Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePutDataOnStackAction(PutDataOnStackAction object) {
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
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
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
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractAction(AbstractAction object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} // ActionsSwitch
