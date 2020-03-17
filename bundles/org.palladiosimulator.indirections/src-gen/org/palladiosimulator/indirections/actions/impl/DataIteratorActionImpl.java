/**
 */
package org.palladiosimulator.indirections.actions.impl;

import de.uka.ipd.sdq.stoex.VariableReference;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.DataIteratorAction;

import org.palladiosimulator.pcm.seff.impl.AbstractLoopActionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Iterator Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.DataIteratorActionImpl#getVariableReference <em>Variable Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataIteratorActionImpl extends AbstractLoopActionImpl implements DataIteratorAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataIteratorActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionsPackage.Literals.DATA_ITERATOR_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableReference getVariableReference() {
		return (VariableReference) eDynamicGet(ActionsPackage.DATA_ITERATOR_ACTION__VARIABLE_REFERENCE,
				ActionsPackage.Literals.DATA_ITERATOR_ACTION__VARIABLE_REFERENCE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableReference(VariableReference newVariableReference, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newVariableReference,
				ActionsPackage.DATA_ITERATOR_ACTION__VARIABLE_REFERENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariableReference(VariableReference newVariableReference) {
		eDynamicSet(ActionsPackage.DATA_ITERATOR_ACTION__VARIABLE_REFERENCE,
				ActionsPackage.Literals.DATA_ITERATOR_ACTION__VARIABLE_REFERENCE, newVariableReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ActionsPackage.DATA_ITERATOR_ACTION__VARIABLE_REFERENCE:
			return basicSetVariableReference(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ActionsPackage.DATA_ITERATOR_ACTION__VARIABLE_REFERENCE:
			return getVariableReference();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ActionsPackage.DATA_ITERATOR_ACTION__VARIABLE_REFERENCE:
			setVariableReference((VariableReference) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ActionsPackage.DATA_ITERATOR_ACTION__VARIABLE_REFERENCE:
			setVariableReference((VariableReference) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ActionsPackage.DATA_ITERATOR_ACTION__VARIABLE_REFERENCE:
			return getVariableReference() != null;
		}
		return super.eIsSet(featureID);
	}

} //DataIteratorActionImpl
