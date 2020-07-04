/**
 */
package org.palladiosimulator.indirections.repository.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.impl.ProvidedRoleImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Data Sink Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.repository.impl.DataSinkRoleImpl#getEventGroup
 * <em>Event Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataSinkRoleImpl extends ProvidedRoleImpl implements DataSinkRole {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected DataSinkRoleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.DATA_SINK_ROLE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EventGroup getEventGroup() {
        return (EventGroup) this.eDynamicGet(RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP,
                RepositoryPackage.Literals.DATA_SINK_ROLE__EVENT_GROUP, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public EventGroup basicGetEventGroup() {
        return (EventGroup) this.eDynamicGet(RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP,
                RepositoryPackage.Literals.DATA_SINK_ROLE__EVENT_GROUP, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setEventGroup(final EventGroup newEventGroup) {
        this.eDynamicSet(RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP,
                RepositoryPackage.Literals.DATA_SINK_ROLE__EVENT_GROUP, newEventGroup);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP:
            if (resolve) {
                return this.getEventGroup();
            }
            return this.basicGetEventGroup();
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
        case RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP:
            this.setEventGroup((EventGroup) newValue);
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
        case RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP:
            this.setEventGroup((EventGroup) null);
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
        case RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP:
            return this.basicGetEventGroup() != null;
        }
        return super.eIsSet(featureID);
    }

} // DataSinkRoleImpl
