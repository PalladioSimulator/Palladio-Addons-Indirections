/**
 */
package org.palladiosimulator.indirections.system.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.indirections.system.SystemFactory;
import org.palladiosimulator.indirections.system.SystemPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class SystemFactoryImpl extends EFactoryImpl implements SystemFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static SystemFactory init() {
        try {
            final SystemFactory theSystemFactory = (SystemFactory) EPackage.Registry.INSTANCE
                .getEFactory(SystemPackage.eNS_URI);
            if (theSystemFactory != null) {
                return theSystemFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SystemFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SystemFactoryImpl() {
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
        case SystemPackage.JAVA_CLASS_DATA_CHANNEL:
            return this.createJavaClassDataChannel();
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
    public JavaClassDataChannel createJavaClassDataChannel() {
        final JavaClassDataChannelImpl javaClassDataChannel = new JavaClassDataChannelImpl();
        return javaClassDataChannel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SystemPackage getSystemPackage() {
        return (SystemPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static SystemPackage getPackage() {
        return SystemPackage.eINSTANCE;
    }

} // SystemFactoryImpl
