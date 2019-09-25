/**
 */
package org.palladiosimulator.indirections.actions;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.seff.AbstractAction;

import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Create Data
 * Action</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.actions.CreateDataAction#getVariableReference
 * <em>Variable Reference</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.actions.CreateDataAction#getVariableUsages
 * <em>Variable Usages</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getCreateDataAction()
 * @model
 * @generated
 */
public interface CreateDataAction extends AbstractAction {
    /**
     * Returns the value of the '<em><b>Variable Reference</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Variable Reference</em>' containment reference.
     * @see #setVariableReference(VariableReference)
     * @see org.palladiosimulator.indirections.actions.ActionsPackage#getCreateDataAction_VariableReference()
     * @model containment="true" required="true"
     * @generated
     */
    VariableReference getVariableReference();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.actions.CreateDataAction#getVariableReference
     * <em>Variable Reference</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Variable Reference</em>' containment reference.
     * @see #getVariableReference()
     * @generated
     */
    void setVariableReference(VariableReference value);

    /**
     * Returns the value of the '<em><b>Variable Usages</b></em>' containment reference list. The
     * list contents are of type {@link org.palladiosimulator.pcm.parameter.VariableUsage}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Variable Usages</em>' containment reference list.
     * @see org.palladiosimulator.indirections.actions.ActionsPackage#getCreateDataAction_VariableUsages()
     * @model containment="true"
     * @generated
     */
    EList<VariableUsage> getVariableUsages();

} // CreateDataAction
