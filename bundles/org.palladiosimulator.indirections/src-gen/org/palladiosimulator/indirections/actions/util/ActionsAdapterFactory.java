/**
 */
package org.palladiosimulator.indirections.actions.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.AddToDateAction;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.CreateDateAction;
import org.palladiosimulator.indirections.actions.DataAction;
import org.palladiosimulator.indirections.actions.DataIteratorAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.actions.JavaClassRegroupDataAction;
import org.palladiosimulator.indirections.actions.PutTimeOnStackAction;
import org.palladiosimulator.indirections.actions.RegroupDataAction;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.core.entity.NamedElement;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.AbstractInternalControlFlowAction;
import org.palladiosimulator.pcm.seff.AbstractLoopAction;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.indirections.actions.ActionsPackage
 * @generated
 */
public class ActionsAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static ActionsPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ActionsAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ActionsPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc
     * --> This implementation returns <code>true</code> if the object is either the model's package
     * or is an instance object of the model. <!-- end-user-doc -->
     *
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(final Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass()
                .getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected ActionsSwitch<Adapter> modelSwitch = new ActionsSwitch<Adapter>() {
        @Override
        public Adapter caseAnalyseStackAction(final AnalyseStackAction object) {
            return ActionsAdapterFactory.this.createAnalyseStackActionAdapter();
        }

        @Override
        public Adapter caseConsumeDataAction(final ConsumeDataAction object) {
            return ActionsAdapterFactory.this.createConsumeDataActionAdapter();
        }

        @Override
        public Adapter caseEmitDataAction(final EmitDataAction object) {
            return ActionsAdapterFactory.this.createEmitDataActionAdapter();
        }

        @Override
        public Adapter caseCreateDateAction(final CreateDateAction object) {
            return ActionsAdapterFactory.this.createCreateDateActionAdapter();
        }

        @Override
        public Adapter caseAddToDateAction(final AddToDateAction object) {
            return ActionsAdapterFactory.this.createAddToDateActionAdapter();
        }

        @Override
        public Adapter caseDataIteratorAction(final DataIteratorAction object) {
            return ActionsAdapterFactory.this.createDataIteratorActionAdapter();
        }

        @Override
        public Adapter casePutTimeOnStackAction(final PutTimeOnStackAction object) {
            return ActionsAdapterFactory.this.createPutTimeOnStackActionAdapter();
        }

        @Override
        public Adapter caseRegroupDataAction(final RegroupDataAction object) {
            return ActionsAdapterFactory.this.createRegroupDataActionAdapter();
        }

        @Override
        public Adapter caseJavaClassRegroupDataAction(final JavaClassRegroupDataAction object) {
            return ActionsAdapterFactory.this.createJavaClassRegroupDataActionAdapter();
        }

        @Override
        public Adapter caseDataAction(final DataAction object) {
            return ActionsAdapterFactory.this.createDataActionAdapter();
        }

        @Override
        public Adapter caseIdentifier(final Identifier object) {
            return ActionsAdapterFactory.this.createIdentifierAdapter();
        }

        @Override
        public Adapter caseNamedElement(final NamedElement object) {
            return ActionsAdapterFactory.this.createNamedElementAdapter();
        }

        @Override
        public Adapter caseEntity(final Entity object) {
            return ActionsAdapterFactory.this.createEntityAdapter();
        }

        @Override
        public Adapter caseAbstractAction(final AbstractAction object) {
            return ActionsAdapterFactory.this.createAbstractActionAdapter();
        }

        @Override
        public Adapter caseAbstractInternalControlFlowAction(final AbstractInternalControlFlowAction object) {
            return ActionsAdapterFactory.this.createAbstractInternalControlFlowActionAdapter();
        }

        @Override
        public Adapter caseAbstractLoopAction(final AbstractLoopAction object) {
            return ActionsAdapterFactory.this.createAbstractLoopActionAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return ActionsAdapterFactory.this.createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(final Notifier target) {
        return this.modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.actions.AnalyseStackAction <em>Analyse Stack
     * Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.actions.AnalyseStackAction
     * @generated
     */
    public Adapter createAnalyseStackActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.actions.ConsumeDataAction <em>Consume Data
     * Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.actions.ConsumeDataAction
     * @generated
     */
    public Adapter createConsumeDataActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.actions.EmitDataAction <em>Emit Data
     * Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.actions.EmitDataAction
     * @generated
     */
    public Adapter createEmitDataActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.actions.CreateDateAction <em>Create Date
     * Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.actions.CreateDateAction
     * @generated
     */
    public Adapter createCreateDateActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.actions.AddToDateAction <em>Add To Date
     * Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.actions.AddToDateAction
     * @generated
     */
    public Adapter createAddToDateActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.actions.DataIteratorAction <em>Data Iterator
     * Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.actions.DataIteratorAction
     * @generated
     */
    public Adapter createDataIteratorActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.actions.PutTimeOnStackAction <em>Put Time On Stack
     * Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.actions.PutTimeOnStackAction
     * @generated
     */
    public Adapter createPutTimeOnStackActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.actions.RegroupDataAction <em>Regroup Data
     * Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.actions.RegroupDataAction
     * @generated
     */
    public Adapter createRegroupDataActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.actions.JavaClassRegroupDataAction <em>Java Class
     * Regroup Data Action</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.actions.JavaClassRegroupDataAction
     * @generated
     */
    public Adapter createJavaClassRegroupDataActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.actions.DataAction <em>Data Action</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.actions.DataAction
     * @generated
     */
    public Adapter createDataActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier
     * <em>Identifier</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.uka.ipd.sdq.identifier.Identifier
     * @generated
     */
    public Adapter createIdentifierAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.pcm.core.entity.NamedElement <em>Named Element</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.NamedElement
     * @generated
     */
    public Adapter createNamedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.pcm.core.entity.Entity <em>Entity</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.Entity
     * @generated
     */
    public Adapter createEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.pcm.seff.AbstractAction <em>Abstract Action</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.seff.AbstractAction
     * @generated
     */
    public Adapter createAbstractActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.pcm.seff.AbstractInternalControlFlowAction <em>Abstract
     * Internal Control Flow Action</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.seff.AbstractInternalControlFlowAction
     * @generated
     */
    public Adapter createAbstractInternalControlFlowActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.pcm.seff.AbstractLoopAction <em>Abstract Loop Action</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.seff.AbstractLoopAction
     * @generated
     */
    public Adapter createAbstractLoopActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // ActionsAdapterFactory
