/**
 */
package org.palladiosimulator.indirectionsmeasuringpoint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;
import org.palladiosimulator.indirectionsmeasuringpoint.AbstractActionDataMeasuringPoint;
import org.palladiosimulator.indirectionsmeasuringpoint.IndirectionsmeasuringpointPackage;
import org.palladiosimulator.pcm.seff.AbstractAction;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Abstract Action Data
 * Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirectionsmeasuringpoint.impl.AbstractActionDataMeasuringPointImpl#getAbstractAction
 * <em>Abstract Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractActionDataMeasuringPointImpl extends MeasuringPointImpl
        implements AbstractActionDataMeasuringPoint {
    /**
     * The cached value of the '{@link #getAbstractAction() <em>Abstract Action</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAbstractAction()
     * @generated
     * @ordered
     */
    protected AbstractAction abstractAction;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AbstractActionDataMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IndirectionsmeasuringpointPackage.Literals.ABSTRACT_ACTION_DATA_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AbstractAction getAbstractAction() {
        if (this.abstractAction != null && ((EObject) this.abstractAction).eIsProxy()) {
            final InternalEObject oldAbstractAction = (InternalEObject) this.abstractAction;
            this.abstractAction = (AbstractAction) this.eResolveProxy(oldAbstractAction);
            if (this.abstractAction != oldAbstractAction) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            IndirectionsmeasuringpointPackage.ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION,
                            oldAbstractAction, this.abstractAction));
                }
            }
        }
        return this.abstractAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AbstractAction basicGetAbstractAction() {
        return this.abstractAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAbstractAction(final AbstractAction newAbstractAction) {
        final AbstractAction oldAbstractAction = this.abstractAction;
        this.abstractAction = newAbstractAction;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    IndirectionsmeasuringpointPackage.ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION,
                    oldAbstractAction, this.abstractAction));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case IndirectionsmeasuringpointPackage.ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION:
            if (resolve) {
                return this.getAbstractAction();
            }
            return this.basicGetAbstractAction();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case IndirectionsmeasuringpointPackage.ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION:
            this.setAbstractAction((AbstractAction) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case IndirectionsmeasuringpointPackage.ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION:
            this.setAbstractAction((AbstractAction) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case IndirectionsmeasuringpointPackage.ABSTRACT_ACTION_DATA_MEASURING_POINT__ABSTRACT_ACTION:
            return this.abstractAction != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractActionDataMeasuringPointImpl
