/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.indirections.composition.AssemblyContextToAssemblyContextConnector;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.impl.AssemblyContextSourceConnectorImpl;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.Signature;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Assembly Context To
 * Assembly Context Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.AssemblyContextToAssemblyContextConnectorImpl#getSinkAssemblyContext
 * <em>Sink Assembly Context</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.AssemblyContextToAssemblyContextConnectorImpl#getPushesTo
 * <em>Pushes To</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.AssemblyContextToAssemblyContextConnectorImpl#isPushing
 * <em>Pushing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssemblyContextToAssemblyContextConnectorImpl extends AssemblyContextSourceConnectorImpl
        implements AssemblyContextToAssemblyContextConnector {
    /**
     * The default value of the '{@link #isPushing() <em>Pushing</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #isPushing()
     * @generated
     * @ordered
     */
    protected static final boolean PUSHING_EDEFAULT = false;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AssemblyContextToAssemblyContextConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContext getSinkAssemblyContext() {
        return (AssemblyContext) this.eDynamicGet(
                CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT,
                AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetSinkAssemblyContext() {
        return (AssemblyContext) this.eDynamicGet(
                CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT,
                AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSinkAssemblyContext(final AssemblyContext newSinkAssemblyContext) {
        this.eDynamicSet(CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT,
                AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT,
                newSinkAssemblyContext);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Signature getPushesTo() {
        return (Signature) this.eDynamicGet(
                CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO,
                AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Signature basicGetPushesTo() {
        return (Signature) this.eDynamicGet(
                CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO,
                AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPushesTo(final Signature newPushesTo) {
        this.eDynamicSet(CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO,
                AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO, newPushesTo);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean isPushing() {
        return (this.getPushesTo() != null);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPushing(final boolean newPushing) {
        // TODO: implement this method to set the 'Pushing' attribute
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
            if (resolve) {
                return this.getSinkAssemblyContext();
            }
            return this.basicGetSinkAssemblyContext();
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO:
            if (resolve) {
                return this.getPushesTo();
            }
            return this.basicGetPushesTo();
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHING:
            return this.isPushing();
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
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
            this.setSinkAssemblyContext((AssemblyContext) newValue);
            return;
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO:
            this.setPushesTo((Signature) newValue);
            return;
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHING:
            this.setPushing((Boolean) newValue);
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
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
            this.setSinkAssemblyContext((AssemblyContext) null);
            return;
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO:
            this.setPushesTo((Signature) null);
            return;
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHING:
            this.setPushing(PUSHING_EDEFAULT);
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
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
            return this.basicGetSinkAssemblyContext() != null;
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO:
            return this.basicGetPushesTo() != null;
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHING:
            return this.isPushing() != PUSHING_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(final int derivedFeatureID, final Class<?> baseClass) {
        if (baseClass == AssemblyContextSinkConnector.class) {
            switch (derivedFeatureID) {
            case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
                return AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT;
            case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO:
                return AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO;
            case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHING:
                return AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHING;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(final int baseFeatureID, final Class<?> baseClass) {
        if (baseClass == AssemblyContextSinkConnector.class) {
            switch (baseFeatureID) {
            case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT:
                return CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__SINK_ASSEMBLY_CONTEXT;
            case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO:
                return CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHES_TO;
            case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHING:
                return CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR__PUSHING;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // AssemblyContextToAssemblyContextConnectorImpl
