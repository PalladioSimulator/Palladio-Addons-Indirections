/**
 */
package org.palladiosimulator.indirections.actions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.palladiosimulator.indirections.actions.*;

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
		case ActionsPackage.CONSUME_DATA_ACTION:
			return createConsumeDataAction();
		case ActionsPackage.EMIT_DATA_ACTION:
			return createEmitDataAction();
		case ActionsPackage.CREATE_DATE_ACTION:
			return createCreateDateAction();
		case ActionsPackage.ADD_TO_DATE_ACTION:
			return createAddToDateAction();
		case ActionsPackage.DATA_ITERATOR_ACTION:
			return createDataIteratorAction();
		case ActionsPackage.PUT_TIME_ON_STACK_ACTION:
			return createPutTimeOnStackAction();
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
	public ConsumeDataAction createConsumeDataAction() {
		ConsumeDataActionImpl consumeDataAction = new ConsumeDataActionImpl();
		return consumeDataAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EmitDataAction createEmitDataAction() {
		EmitDataActionImpl emitDataAction = new EmitDataActionImpl();
		return emitDataAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CreateDateAction createCreateDateAction() {
		CreateDateActionImpl createDateAction = new CreateDateActionImpl();
		return createDateAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AddToDateAction createAddToDateAction() {
		AddToDateActionImpl addToDateAction = new AddToDateActionImpl();
		return addToDateAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataIteratorAction createDataIteratorAction() {
		DataIteratorActionImpl dataIteratorAction = new DataIteratorActionImpl();
		return dataIteratorAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PutTimeOnStackAction createPutTimeOnStackAction() {
		PutTimeOnStackActionImpl putTimeOnStackAction = new PutTimeOnStackActionImpl();
		return putTimeOnStackAction;
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
