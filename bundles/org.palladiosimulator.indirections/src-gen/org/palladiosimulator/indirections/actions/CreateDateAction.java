/**
 */
package org.palladiosimulator.indirections.actions;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.pcm.parameter.VariableUsage;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Create Date
 * Action</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.actions.CreateDateAction#getVariableUsages
 * <em>Variable Usages</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getCreateDateAction()
 * @model
 * @generated
 */
public interface CreateDateAction extends DataAction {
    /**
     * Returns the value of the '<em><b>Variable Usages</b></em>' containment reference list. The
     * list contents are of type {@link org.palladiosimulator.pcm.parameter.VariableUsage}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Variable Usages</em>' containment reference list.
     * @see org.palladiosimulator.indirections.actions.ActionsPackage#getCreateDateAction_VariableUsages()
     * @model containment="true"
     * @generated
     */
    EList<VariableUsage> getVariableUsages();

} // CreateDateAction
