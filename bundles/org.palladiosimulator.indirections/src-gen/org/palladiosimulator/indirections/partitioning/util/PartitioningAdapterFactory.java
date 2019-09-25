/**
 */
package org.palladiosimulator.indirections.partitioning.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.indirections.partitioning.CollectWithHoldback;
import org.palladiosimulator.indirections.partitioning.ConsumeAllAvailable;
import org.palladiosimulator.indirections.partitioning.Joining;
import org.palladiosimulator.indirections.partitioning.Partitioning;
import org.palladiosimulator.indirections.partitioning.PartitioningPackage;
import org.palladiosimulator.indirections.partitioning.TimeGrouping;
import org.palladiosimulator.indirections.partitioning.Windowing;
import org.palladiosimulator.pcm.core.entity.NamedElement;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage
 * @generated
 */
public class PartitioningAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static PartitioningPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PartitioningAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = PartitioningPackage.eINSTANCE;
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
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected PartitioningSwitch<Adapter> modelSwitch = new PartitioningSwitch<Adapter>() {
        @Override
        public Adapter casePartitioning(final Partitioning object) {
            return PartitioningAdapterFactory.this.createPartitioningAdapter();
        }

        @Override
        public Adapter caseTimeGrouping(final TimeGrouping object) {
            return PartitioningAdapterFactory.this.createTimeGroupingAdapter();
        }

        @Override
        public Adapter caseWindowing(final Windowing object) {
            return PartitioningAdapterFactory.this.createWindowingAdapter();
        }

        @Override
        public Adapter caseConsumeAllAvailable(final ConsumeAllAvailable object) {
            return PartitioningAdapterFactory.this.createConsumeAllAvailableAdapter();
        }

        @Override
        public Adapter caseCollectWithHoldback(final CollectWithHoldback object) {
            return PartitioningAdapterFactory.this.createCollectWithHoldbackAdapter();
        }

        @Override
        public Adapter caseJoining(final Joining object) {
            return PartitioningAdapterFactory.this.createJoiningAdapter();
        }

        @Override
        public Adapter caseNamedElement(final NamedElement object) {
            return PartitioningAdapterFactory.this.createNamedElementAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return PartitioningAdapterFactory.this.createEObjectAdapter();
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
     * '{@link org.palladiosimulator.indirections.partitioning.Partitioning <em>Partitioning</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.partitioning.Partitioning
     * @generated
     */
    public Adapter createPartitioningAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.partitioning.TimeGrouping <em>Time
     * Grouping</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.partitioning.TimeGrouping
     * @generated
     */
    public Adapter createTimeGroupingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.partitioning.Windowing <em>Windowing</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.partitioning.Windowing
     * @generated
     */
    public Adapter createWindowingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.partitioning.ConsumeAllAvailable <em>Consume All
     * Available</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.partitioning.ConsumeAllAvailable
     * @generated
     */
    public Adapter createConsumeAllAvailableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.partitioning.CollectWithHoldback <em>Collect With
     * Holdback</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.partitioning.CollectWithHoldback
     * @generated
     */
    public Adapter createCollectWithHoldbackAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.partitioning.Joining <em>Joining</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.partitioning.Joining
     * @generated
     */
    public Adapter createJoiningAdapter() {
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
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // PartitioningAdapterFactory
