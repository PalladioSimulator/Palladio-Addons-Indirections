/**
 */
package org.palladiosimulator.indirectionsmeasuringpoint.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.indirectionsmeasuringpoint.AbstractActionDataMeasuringPoint;
import org.palladiosimulator.indirectionsmeasuringpoint.IndirectionsmeasuringpointPackage;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.indirectionsmeasuringpoint.IndirectionsmeasuringpointPackage
 * @generated
 */
public class IndirectionsmeasuringpointAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static IndirectionsmeasuringpointPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public IndirectionsmeasuringpointAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = IndirectionsmeasuringpointPackage.eINSTANCE;
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
    protected IndirectionsmeasuringpointSwitch<Adapter> modelSwitch = new IndirectionsmeasuringpointSwitch<Adapter>() {
        @Override
        public Adapter caseAbstractActionDataMeasuringPoint(final AbstractActionDataMeasuringPoint object) {
            return IndirectionsmeasuringpointAdapterFactory.this.createAbstractActionDataMeasuringPointAdapter();
        }

        @Override
        public Adapter caseMeasuringPoint(final MeasuringPoint object) {
            return IndirectionsmeasuringpointAdapterFactory.this.createMeasuringPointAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return IndirectionsmeasuringpointAdapterFactory.this.createEObjectAdapter();
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
     * '{@link org.palladiosimulator.indirectionsmeasuringpoint.AbstractActionDataMeasuringPoint
     * <em>Abstract Action Data Measuring Point</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirectionsmeasuringpoint.AbstractActionDataMeasuringPoint
     * @generated
     */
    public Adapter createAbstractActionDataMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint <em>Measuring
     * Point</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
     * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases
     * anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint
     * @generated
     */
    public Adapter createMeasuringPointAdapter() {
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

} // IndirectionsmeasuringpointAdapterFactory
