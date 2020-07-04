/**
 */
package org.palladiosimulator.indirections.composition.abstract_.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Assembly Context Source
 * Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.composition.abstract_.impl.AssemblyContextSourceConnectorImpl#getSourceAssemblyContext
 * <em>Source Assembly Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AssemblyContextSourceConnectorImpl extends DataSourceSinkConnectorImpl
        implements AssemblyContextSourceConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AssemblyContextSourceConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AbstractPackage.Literals.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContext getSourceAssemblyContext() {
        return (AssemblyContext) this.eDynamicGet(
                AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT,
                AbstractPackage.Literals.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetSourceAssemblyContext() {
        return (AssemblyContext) this.eDynamicGet(
                AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT,
                AbstractPackage.Literals.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSourceAssemblyContext(final AssemblyContext newSourceAssemblyContext) {
        this.eDynamicSet(AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT,
                AbstractPackage.Literals.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT,
                newSourceAssemblyContext);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT:
            if (resolve) {
                return this.getSourceAssemblyContext();
            }
            return this.basicGetSourceAssemblyContext();
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
        case AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT:
            this.setSourceAssemblyContext((AssemblyContext) newValue);
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
        case AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT:
            this.setSourceAssemblyContext((AssemblyContext) null);
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
        case AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT:
            return this.basicGetSourceAssemblyContext() != null;
        }
        return super.eIsSet(featureID);
    }

} // AssemblyContextSourceConnectorImpl
