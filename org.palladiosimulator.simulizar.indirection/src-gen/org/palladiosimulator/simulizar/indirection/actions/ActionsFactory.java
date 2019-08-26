/**
 */
package org.palladiosimulator.simulizar.indirection.actions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.simulizar.indirection.actions.ActionsPackage
 * @generated
 */
public interface ActionsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionsFactory eINSTANCE = org.palladiosimulator.simulizar.indirection.actions.impl.ActionsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Analyse Stack Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Analyse Stack Action</em>'.
	 * @generated
	 */
	AnalyseStackAction createAnalyseStackAction();

	/**
	 * Returns a new object of class '<em>Consume Event Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Consume Event Action</em>'.
	 * @generated
	 */
	ConsumeEventAction createConsumeEventAction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ActionsPackage getActionsPackage();

} //ActionsFactory
