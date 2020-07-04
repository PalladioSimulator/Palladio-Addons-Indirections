/**
 */
package org.palladiosimulator.indirections.allocation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.indirections.allocation.AllocationFactory;
import org.palladiosimulator.indirections.allocation.AllocationPackage;
import org.palladiosimulator.indirections.allocation.DataChannelAllocationContext;
import org.palladiosimulator.indirections.allocation.IndirectionsAwareAllocation;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class AllocationFactoryImpl extends EFactoryImpl implements AllocationFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static AllocationFactory init() {
        try {
            final AllocationFactory theAllocationFactory = (AllocationFactory) EPackage.Registry.INSTANCE
                .getEFactory(AllocationPackage.eNS_URI);
            if (theAllocationFactory != null) {
                return theAllocationFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new AllocationFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AllocationFactoryImpl() {
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
        case AllocationPackage.INDIRECTIONS_AWARE_ALLOCATION:
            return this.createIndirectionsAwareAllocation();
        case AllocationPackage.DATA_CHANNEL_ALLOCATION_CONTEXT:
            return this.createDataChannelAllocationContext();
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
    public IndirectionsAwareAllocation createIndirectionsAwareAllocation() {
        final IndirectionsAwareAllocationImpl indirectionsAwareAllocation = new IndirectionsAwareAllocationImpl();
        return indirectionsAwareAllocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DataChannelAllocationContext createDataChannelAllocationContext() {
        final DataChannelAllocationContextImpl dataChannelAllocationContext = new DataChannelAllocationContextImpl();
        return dataChannelAllocationContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AllocationPackage getAllocationPackage() {
        return (AllocationPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static AllocationPackage getPackage() {
        return AllocationPackage.eINSTANCE;
    }

} // AllocationFactoryImpl
