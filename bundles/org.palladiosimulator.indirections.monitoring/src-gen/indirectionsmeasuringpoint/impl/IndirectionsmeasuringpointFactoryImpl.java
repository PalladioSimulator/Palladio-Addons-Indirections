/**
 */
package indirectionsmeasuringpoint.impl;

import indirectionsmeasuringpoint.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IndirectionsmeasuringpointFactoryImpl extends EFactoryImpl implements IndirectionsmeasuringpointFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static IndirectionsmeasuringpointFactory init() {
        try {
            IndirectionsmeasuringpointFactory theIndirectionsmeasuringpointFactory = (IndirectionsmeasuringpointFactory)EPackage.Registry.INSTANCE.getEFactory(IndirectionsmeasuringpointPackage.eNS_URI);
            if (theIndirectionsmeasuringpointFactory != null) {
                return theIndirectionsmeasuringpointFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new IndirectionsmeasuringpointFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IndirectionsmeasuringpointFactoryImpl() {
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
            case IndirectionsmeasuringpointPackage.ABSTRACT_ACTION_DATA_MEASURING_POINT: return createAbstractActionDataMeasuringPoint();
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
    public AbstractActionDataMeasuringPoint createAbstractActionDataMeasuringPoint() {
        AbstractActionDataMeasuringPointImpl abstractActionDataMeasuringPoint = new AbstractActionDataMeasuringPointImpl();
        return abstractActionDataMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IndirectionsmeasuringpointPackage getIndirectionsmeasuringpointPackage() {
        return (IndirectionsmeasuringpointPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static IndirectionsmeasuringpointPackage getPackage() {
        return IndirectionsmeasuringpointPackage.eINSTANCE;
    }

} //IndirectionsmeasuringpointFactoryImpl
