/**
 */
package org.palladiosimulator.simulizar.indirection.actions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.palladiosimulator.simulizar.indirection.actions.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionsFactoryImpl extends EFactoryImpl implements ActionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActionsFactory init() {
		try {
			ActionsFactory theActionsFactory = (ActionsFactory) EPackage.Registry.INSTANCE
					.getEFactory(ActionsPackage.eNS_URI);
			if (theActionsFactory != null) {
				return theActionsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ActionsPackage.ANALYSE_STACK_ACTION:
			return createAnalyseStackAction();
		case ActionsPackage.CONSUME_EVENT_ACTION:
			return createConsumeEventAction();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnalyseStackAction createAnalyseStackAction() {
		AnalyseStackActionImpl analyseStackAction = new AnalyseStackActionImpl();
		return analyseStackAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConsumeEventAction createConsumeEventAction() {
		ConsumeEventActionImpl consumeEventAction = new ConsumeEventActionImpl();
		return consumeEventAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActionsPackage getActionsPackage() {
		return (ActionsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ActionsPackage getPackage() {
		return ActionsPackage.eINSTANCE;
	}

} //ActionsFactoryImpl
