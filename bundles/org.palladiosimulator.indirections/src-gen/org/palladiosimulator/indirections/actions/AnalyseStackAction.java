/**
 */
package org.palladiosimulator.indirections.actions;

import org.palladiosimulator.pcm.seff.AbstractAction;

import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Analyse Stack
 * Action</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.actions.AnalyseStackAction#getKey
 * <em>Key</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.actions.AnalyseStackAction#getVariableReference
 * <em>Variable Reference</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getAnalyseStackAction()
 * @model
 * @generated
 */
public interface AnalyseStackAction extends AbstractAction {
    /**
     * Returns the value of the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the value of the '<em>Key</em>' attribute.
     * @see #setKey(String)
     * @see org.palladiosimulator.indirections.actions.ActionsPackage#getAnalyseStackAction_Key()
     * @model
     * @generated
     */
    String getKey();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.actions.AnalyseStackAction#getKey <em>Key</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Key</em>' attribute.
     * @see #getKey()
     * @generated
     */
    void setKey(String value);

    /**
     * Returns the value of the '<em><b>Variable Reference</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Variable Reference</em>' containment reference.
     * @see #setVariableReference(VariableReference)
     * @see org.palladiosimulator.indirections.actions.ActionsPackage#getAnalyseStackAction_VariableReference()
     * @model containment="true" required="true"
     * @generated
     */
    VariableReference getVariableReference();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.actions.AnalyseStackAction#getVariableReference
     * <em>Variable Reference</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Variable Reference</em>' containment reference.
     * @see #getVariableReference()
     * @generated
     */
    void setVariableReference(VariableReference value);

} // AnalyseStackAction
