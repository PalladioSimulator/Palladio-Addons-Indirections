/**
 */
package org.palladiosimulator.indirections.actions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.indirections.actions.ActionsPackage
 * @generated
 */
public interface ActionsFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    ActionsFactory eINSTANCE = org.palladiosimulator.indirections.actions.impl.ActionsFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Analyse Stack Action</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Analyse Stack Action</em>'.
     * @generated
     */
    AnalyseStackAction createAnalyseStackAction();

    /**
     * Returns a new object of class '<em>Consume Data Action</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Consume Data Action</em>'.
     * @generated
     */
    ConsumeDataAction createConsumeDataAction();

    /**
     * Returns a new object of class '<em>Emit Data Action</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Emit Data Action</em>'.
     * @generated
     */
    EmitDataAction createEmitDataAction();

    /**
     * Returns a new object of class '<em>Create Data Action</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Create Data Action</em>'.
     * @generated
     */
    CreateDataAction createCreateDataAction();

    /**
     * Returns a new object of class '<em>Put Data On Stack Action</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Put Data On Stack Action</em>'.
     * @generated
     */
    PutDataOnStackAction createPutDataOnStackAction();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    ActionsPackage getActionsPackage();

} // ActionsFactory
