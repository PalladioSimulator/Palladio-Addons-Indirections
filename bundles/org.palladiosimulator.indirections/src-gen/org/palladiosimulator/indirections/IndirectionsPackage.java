/**
 */
package org.palladiosimulator.indirections;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.indirections.IndirectionsFactory
 * @model kind="package"
 * @generated
 */
public interface IndirectionsPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "indirections";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://palladiosimulator.org/Indirections/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_PREFIX = "org.palladiosimulator.indirections";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    IndirectionsPackage eINSTANCE = org.palladiosimulator.indirections.impl.IndirectionsPackageImpl.init();

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.impl.JavaClassRealizationImpl <em>Java Class
     * Realization</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.indirections.impl.JavaClassRealizationImpl
     * @see org.palladiosimulator.indirections.impl.IndirectionsPackageImpl#getJavaClassRealization()
     * @generated
     */
    int JAVA_CLASS_REALIZATION = 0;

    /**
     * The feature id for the '<em><b>Realizing Class Fqn</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int JAVA_CLASS_REALIZATION__REALIZING_CLASS_FQN = 0;

    /**
     * The feature id for the '<em><b>Config Entries</b></em>' attribute list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int JAVA_CLASS_REALIZATION__CONFIG_ENTRIES = 1;

    /**
     * The number of structural features of the '<em>Java Class Realization</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int JAVA_CLASS_REALIZATION_FEATURE_COUNT = 2;

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.JavaClassRealization <em>Java Class
     * Realization</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Java Class Realization</em>'.
     * @see org.palladiosimulator.indirections.JavaClassRealization
     * @generated
     */
    EClass getJavaClassRealization();

    /**
     * Returns the meta object for the attribute
     * '{@link org.palladiosimulator.indirections.JavaClassRealization#getRealizingClassFqn
     * <em>Realizing Class Fqn</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Realizing Class Fqn</em>'.
     * @see org.palladiosimulator.indirections.JavaClassRealization#getRealizingClassFqn()
     * @see #getJavaClassRealization()
     * @generated
     */
    EAttribute getJavaClassRealization_RealizingClassFqn();

    /**
     * Returns the meta object for the attribute list
     * '{@link org.palladiosimulator.indirections.JavaClassRealization#getConfigEntries <em>Config
     * Entries</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute list '<em>Config Entries</em>'.
     * @see org.palladiosimulator.indirections.JavaClassRealization#getConfigEntries()
     * @see #getJavaClassRealization()
     * @generated
     */
    EAttribute getJavaClassRealization_ConfigEntries();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    IndirectionsFactory getIndirectionsFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     *
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.impl.JavaClassRealizationImpl <em>Java Class
         * Realization</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.indirections.impl.JavaClassRealizationImpl
         * @see org.palladiosimulator.indirections.impl.IndirectionsPackageImpl#getJavaClassRealization()
         * @generated
         */
        EClass JAVA_CLASS_REALIZATION = eINSTANCE.getJavaClassRealization();

        /**
         * The meta object literal for the '<em><b>Realizing Class Fqn</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute JAVA_CLASS_REALIZATION__REALIZING_CLASS_FQN = eINSTANCE.getJavaClassRealization_RealizingClassFqn();

        /**
         * The meta object literal for the '<em><b>Config Entries</b></em>' attribute list feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute JAVA_CLASS_REALIZATION__CONFIG_ENTRIES = eINSTANCE.getJavaClassRealization_ConfigEntries();

    }

} // IndirectionsPackage
