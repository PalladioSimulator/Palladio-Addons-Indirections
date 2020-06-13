/**
 */
package org.palladiosimulator.indirections.actions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.CreateDataAction;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.seff.impl.AbstractActionImpl;

import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Create Data
 * Action</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.CreateDataActionImpl#getVariableReference <em>Variable Reference</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.CreateDataActionImpl#getVariableUsages <em>Variable Usages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CreateDataActionImpl extends AbstractActionImpl implements CreateDataAction {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateDataActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionsPackage.Literals.CREATE_DATA_ACTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableReference getVariableReference() {
		return (VariableReference) eDynamicGet(ActionsPackage.CREATE_DATA_ACTION__VARIABLE_REFERENCE,
				ActionsPackage.Literals.CREATE_DATA_ACTION__VARIABLE_REFERENCE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableReference(VariableReference newVariableReference, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newVariableReference,
				ActionsPackage.CREATE_DATA_ACTION__VARIABLE_REFERENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariableReference(VariableReference newVariableReference) {
		eDynamicSet(ActionsPackage.CREATE_DATA_ACTION__VARIABLE_REFERENCE,
				ActionsPackage.Literals.CREATE_DATA_ACTION__VARIABLE_REFERENCE, newVariableReference);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<VariableUsage> getVariableUsages() {
		return (EList<VariableUsage>) eDynamicGet(ActionsPackage.CREATE_DATA_ACTION__VARIABLE_USAGES,
				ActionsPackage.Literals.CREATE_DATA_ACTION__VARIABLE_USAGES, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ActionsPackage.CREATE_DATA_ACTION__VARIABLE_REFERENCE:
			return basicSetVariableReference(null, msgs);
		case ActionsPackage.CREATE_DATA_ACTION__VARIABLE_USAGES:
			return ((InternalEList<?>) getVariableUsages()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ActionsPackage.CREATE_DATA_ACTION__VARIABLE_REFERENCE:
			return getVariableReference();
		case ActionsPackage.CREATE_DATA_ACTION__VARIABLE_USAGES:
			return getVariableUsages();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ActionsPackage.CREATE_DATA_ACTION__VARIABLE_REFERENCE:
			setVariableReference((VariableReference) newValue);
			return;
		case ActionsPackage.CREATE_DATA_ACTION__VARIABLE_USAGES:
			getVariableUsages().clear();
			getVariableUsages().addAll((Collection<? extends VariableUsage>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ActionsPackage.CREATE_DATA_ACTION__VARIABLE_REFERENCE:
			setVariableReference((VariableReference) null);
			return;
		case ActionsPackage.CREATE_DATA_ACTION__VARIABLE_USAGES:
			getVariableUsages().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ActionsPackage.CREATE_DATA_ACTION__VARIABLE_REFERENCE:
			return getVariableReference() != null;
		case ActionsPackage.CREATE_DATA_ACTION__VARIABLE_USAGES:
			return !getVariableUsages().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // CreateDataActionImpl
