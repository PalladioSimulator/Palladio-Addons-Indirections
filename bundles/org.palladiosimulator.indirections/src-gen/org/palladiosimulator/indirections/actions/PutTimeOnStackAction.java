/**
 */
package org.palladiosimulator.indirections.actions;

import de.uka.ipd.sdq.stoex.VariableReference;

import org.palladiosimulator.pcm.seff.AbstractAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Put Time On Stack Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.actions.PutTimeOnStackAction#getVariableReference <em>Variable Reference</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getPutTimeOnStackAction()
 * @model
 * @generated
 */
public interface PutTimeOnStackAction extends AbstractAction {
	/**
	 * Returns the value of the '<em><b>Variable Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Reference</em>' containment reference.
	 * @see #setVariableReference(VariableReference)
	 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getPutTimeOnStackAction_VariableReference()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableReference getVariableReference();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.actions.PutTimeOnStackAction#getVariableReference <em>Variable Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Reference</em>' containment reference.
	 * @see #getVariableReference()
	 * @generated
	 */
	void setVariableReference(VariableReference value);

} // PutTimeOnStackAction
