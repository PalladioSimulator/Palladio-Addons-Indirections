/**
 */
package org.palladiosimulator.indirections;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Java Class
 * Realization</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.JavaClassRealization#getRealizingClassFqn
 * <em>Realizing Class Fqn</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.JavaClassRealization#getConfigEntries <em>Config
 * Entries</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.IndirectionsPackage#getJavaClassRealization()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface JavaClassRealization extends CDOObject {
    /**
     * Returns the value of the '<em><b>Realizing Class Fqn</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Realizing Class Fqn</em>' attribute.
     * @see #setRealizingClassFqn(String)
     * @see org.palladiosimulator.indirections.IndirectionsPackage#getJavaClassRealization_RealizingClassFqn()
     * @model required="true"
     * @generated
     */
    String getRealizingClassFqn();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.JavaClassRealization#getRealizingClassFqn
     * <em>Realizing Class Fqn</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Realizing Class Fqn</em>' attribute.
     * @see #getRealizingClassFqn()
     * @generated
     */
    void setRealizingClassFqn(String value);

    /**
     * Returns the value of the '<em><b>Config Entries</b></em>' attribute list. The list contents
     * are of type {@link java.lang.String}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Config Entries</em>' attribute list.
     * @see org.palladiosimulator.indirections.IndirectionsPackage#getJavaClassRealization_ConfigEntries()
     * @model
     * @generated
     */
    EList<String> getConfigEntries();

} // JavaClassRealization
