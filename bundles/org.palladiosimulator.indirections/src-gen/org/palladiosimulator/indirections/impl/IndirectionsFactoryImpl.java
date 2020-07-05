/**
 */
package org.palladiosimulator.indirections.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.indirections.IndirectionsFactory;
import org.palladiosimulator.indirections.IndirectionsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class IndirectionsFactoryImpl extends EFactoryImpl implements IndirectionsFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static IndirectionsFactory init() {
        try {
            final IndirectionsFactory theIndirectionsFactory = (IndirectionsFactory) EPackage.Registry.INSTANCE
                .getEFactory(IndirectionsPackage.eNS_URI);
            if (theIndirectionsFactory != null) {
                return theIndirectionsFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new IndirectionsFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public IndirectionsFactoryImpl() {
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
    public IndirectionsPackage getIndirectionsPackage() {
        return (IndirectionsPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static IndirectionsPackage getPackage() {
        return IndirectionsPackage.eINSTANCE;
    }

} // IndirectionsFactoryImpl
