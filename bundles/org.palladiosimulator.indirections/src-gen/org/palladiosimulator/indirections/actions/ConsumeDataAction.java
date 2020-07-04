/**
 */
package org.palladiosimulator.indirections.actions;

import org.palladiosimulator.indirections.repository.DataSinkRole;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Consume Data
 * Action</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getDataSinkRole <em>Data
 * Sink Role</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getConsumeDataAction()
 * @model
 * @generated
 */
public interface ConsumeDataAction extends DataAction {
    /**
     * Returns the value of the '<em><b>Data Sink Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Data Sink Role</em>' reference.
     * @see #setDataSinkRole(DataSinkRole)
     * @see org.palladiosimulator.indirections.actions.ActionsPackage#getConsumeDataAction_DataSinkRole()
     * @model required="true" ordered="false"
     * @generated
     */
    DataSinkRole getDataSinkRole();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.actions.ConsumeDataAction#getDataSinkRole <em>Data
     * Sink Role</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Data Sink Role</em>' reference.
     * @see #getDataSinkRole()
     * @generated
     */
    void setDataSinkRole(DataSinkRole value);

} // ConsumeDataAction
