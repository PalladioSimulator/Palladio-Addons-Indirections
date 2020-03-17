/**
 */
package org.palladiosimulator.indirections.actions.impl;

import de.uka.ipd.sdq.stoex.VariableReference;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;

import org.palladiosimulator.pcm.seff.impl.AbstractActionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analyse Stack Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.AnalyseStackActionImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.AnalyseStackActionImpl#getVariableReference <em>Variable Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnalyseStackActionImpl extends AbstractActionImpl implements AnalyseStackAction {
	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalyseStackActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionsPackage.Literals.ANALYSE_STACK_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getKey() {
		return (String) eDynamicGet(ActionsPackage.ANALYSE_STACK_ACTION__KEY,
				ActionsPackage.Literals.ANALYSE_STACK_ACTION__KEY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKey(String newKey) {
		eDynamicSet(ActionsPackage.ANALYSE_STACK_ACTION__KEY, ActionsPackage.Literals.ANALYSE_STACK_ACTION__KEY,
				newKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableReference getVariableReference() {
		return (VariableReference) eDynamicGet(ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE,
				ActionsPackage.Literals.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableReference(VariableReference newVariableReference, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newVariableReference,
				ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariableReference(VariableReference newVariableReference) {
		eDynamicSet(ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE,
				ActionsPackage.Literals.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE, newVariableReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE:
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
		case ActionsPackage.ANALYSE_STACK_ACTION__KEY:
			return getKey();
		case ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE:
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
		case ActionsPackage.ANALYSE_STACK_ACTION__KEY:
			setKey((String) newValue);
			return;
		case ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE:
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
		case ActionsPackage.ANALYSE_STACK_ACTION__KEY:
			setKey(KEY_EDEFAULT);
			return;
		case ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE:
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
		case ActionsPackage.ANALYSE_STACK_ACTION__KEY:
			return KEY_EDEFAULT == null ? getKey() != null : !KEY_EDEFAULT.equals(getKey());
		case ActionsPackage.ANALYSE_STACK_ACTION__VARIABLE_REFERENCE:
			return getVariableReference() != null;
		}
		return super.eIsSet(featureID);
	}

} //AnalyseStackActionImpl
