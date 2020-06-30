/**
 */
package org.palladiosimulator.indirections.actions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.indirections.actions.ActionsFactory;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.AddToDateAction;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.CreateDateAction;
import org.palladiosimulator.indirections.actions.DataIteratorAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.actions.PutTimeOnStackAction;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class ActionsFactoryImpl extends EFactoryImpl implements ActionsFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static ActionsFactory init() {
        try {
            final ActionsFactory theActionsFactory = (ActionsFactory) EPackage.Registry.INSTANCE
                .getEFactory(ActionsPackage.eNS_URI);
            if (theActionsFactory != null) {
                return theActionsFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ActionsFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ActionsFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case ActionsPackage.ANALYSE_STACK_ACTION:
            return this.createAnalyseStackAction();
        case ActionsPackage.CONSUME_DATA_ACTION:
            return this.createConsumeDataAction();
        case ActionsPackage.EMIT_DATA_ACTION:
            return this.createEmitDataAction();
        case ActionsPackage.CREATE_DATE_ACTION:
            return this.createCreateDateAction();
        case ActionsPackage.ADD_TO_DATE_ACTION:
            return this.createAddToDateAction();
        case ActionsPackage.DATA_ITERATOR_ACTION:
            return this.createDataIteratorAction();
        case ActionsPackage.PUT_TIME_ON_STACK_ACTION:
            return this.createPutTimeOnStackAction();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AnalyseStackAction createAnalyseStackAction() {
        final AnalyseStackActionImpl analyseStackAction = new AnalyseStackActionImpl();
        return analyseStackAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ConsumeDataAction createConsumeDataAction() {
        final ConsumeDataActionImpl consumeDataAction = new ConsumeDataActionImpl();
        return consumeDataAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EmitDataAction createEmitDataAction() {
        final EmitDataActionImpl emitDataAction = new EmitDataActionImpl();
        return emitDataAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public CreateDateAction createCreateDateAction() {
        final CreateDateActionImpl createDateAction = new CreateDateActionImpl();
        return createDateAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AddToDateAction createAddToDateAction() {
        final AddToDateActionImpl addToDateAction = new AddToDateActionImpl();
        return addToDateAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DataIteratorAction createDataIteratorAction() {
        final DataIteratorActionImpl dataIteratorAction = new DataIteratorActionImpl();
        return dataIteratorAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PutTimeOnStackAction createPutTimeOnStackAction() {
        final PutTimeOnStackActionImpl putTimeOnStackAction = new PutTimeOnStackActionImpl();
        return putTimeOnStackAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ActionsPackage getActionsPackage() {
        return (ActionsPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ActionsPackage getPackage() {
        return ActionsPackage.eINSTANCE;
    }

} // ActionsFactoryImpl
