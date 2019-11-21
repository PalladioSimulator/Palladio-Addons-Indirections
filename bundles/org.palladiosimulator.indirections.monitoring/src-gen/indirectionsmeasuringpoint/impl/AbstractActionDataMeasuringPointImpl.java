/**
 */
package indirectionsmeasuringpoint.impl;

import indirectionsmeasuringpoint.AbstractActionDataMeasuringPoint;
import indirectionsmeasuringpoint.IndirectionsmeasuringpointPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;

import org.palladiosimulator.pcm.seff.AbstractAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Action Data Measuring Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link indirectionsmeasuringpoint.impl.AbstractActionDataMeasuringPointImpl#getAbstractAction <em>Abstract Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractActionDataMeasuringPointImpl extends MeasuringPointImpl implements AbstractActionDataMeasuringPoint {
    /**
     * The cached value of the '{@link #getAbstractAction() <em>Abstract Action</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAbstractAction()
     * @generated
     * @ordered
     */
    protected AbstractAction abstractAction;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AbstractActionDataMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IndirectionsmeasuringpointPackage.Literals.ABSTRACT_ACTION_DATA_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public AbstractAction getAbstractAction() {
        if (abstractAction != null && ((EObject)abstractAction).eIsProxy()) {
            InternalEObject oldAbstractAction = (InternalEObject)abstractAction;
            abstractAction = (AbstractAction)eResolveProxy(oldAbstractAction);
            if (abstractAction != oldAbstractAction) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, IndirectionsmeasuringpointPackage.ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION, oldAbstractAction, abstractAction));
            }
        }
        return abstractAction;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AbstractAction basicGetAbstractAction() {
        return abstractAction;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setAbstractAction(AbstractAction newAbstractAction) {
        AbstractAction oldAbstractAction = abstractAction;
        abstractAction = newAbstractAction;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IndirectionsmeasuringpointPackage.ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION, oldAbstractAction, abstractAction));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case IndirectionsmeasuringpointPackage.ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION:
                if (resolve) return getAbstractAction();
                return basicGetAbstractAction();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case IndirectionsmeasuringpointPackage.ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION:
                setAbstractAction((AbstractAction)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case IndirectionsmeasuringpointPackage.ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION:
                setAbstractAction((AbstractAction)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case IndirectionsmeasuringpointPackage.ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION:
                return abstractAction != null;
        }
        return super.eIsSet(featureID);
    }

} //AbstractActionDataMeasuringPointImpl
