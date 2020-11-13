/**
 */
package org.palladiosimulator.indirectionsmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.indirectionsmeasuringpoint.AbstractActionDataMeasuringPoint;
import org.palladiosimulator.indirectionsmeasuringpoint.IndirectionsmeasuringpointFactory;
import org.palladiosimulator.indirectionsmeasuringpoint.IndirectionsmeasuringpointPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class IndirectionsmeasuringpointFactoryImpl extends EFactoryImpl implements IndirectionsmeasuringpointFactory {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static IndirectionsmeasuringpointPackage getPackage() {
        return IndirectionsmeasuringpointPackage.eINSTANCE;
    }

    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static IndirectionsmeasuringpointFactory init() {
        try {
            final IndirectionsmeasuringpointFactory theIndirectionsmeasuringpointFactory = (IndirectionsmeasuringpointFactory) EPackage.Registry.INSTANCE
                .getEFactory(IndirectionsmeasuringpointPackage.eNS_URI);
            if (theIndirectionsmeasuringpointFactory != null) {
                return theIndirectionsmeasuringpointFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new IndirectionsmeasuringpointFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public IndirectionsmeasuringpointFactoryImpl() {
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
        case IndirectionsmeasuringpointPackage.ABSTRACT_ACTION_DATA_MEASURING_POINT:
            return this.createAbstractActionDataMeasuringPoint();
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
    public AbstractActionDataMeasuringPoint createAbstractActionDataMeasuringPoint() {
        final AbstractActionDataMeasuringPointImpl abstractActionDataMeasuringPoint = new AbstractActionDataMeasuringPointImpl();
        return abstractActionDataMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public IndirectionsmeasuringpointPackage getIndirectionsmeasuringpointPackage() {
        return (IndirectionsmeasuringpointPackage) this.getEPackage();
    }

} // IndirectionsmeasuringpointFactoryImpl
