/**
 */
package org.palladiosimulator.indirections.system;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Java Class Data
 * Channel</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.system.JavaClassDataChannel#getRealizingClassFqn
 * <em>Realizing Class Fqn</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.JavaClassDataChannel#getConfigEntries
 * <em>Config Entries</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.system.SystemPackage#getJavaClassDataChannel()
 * @model
 * @generated
 */
public interface JavaClassDataChannel extends DataChannel {
    /**
     * Returns the value of the '<em><b>Realizing Class Fqn</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Realizing Class Fqn</em>' attribute.
     * @see #setRealizingClassFqn(String)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getJavaClassDataChannel_RealizingClassFqn()
     * @model required="true"
     * @generated
     */
    String getRealizingClassFqn();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.JavaClassDataChannel#getRealizingClassFqn
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
     * @see org.palladiosimulator.indirections.system.SystemPackage#getJavaClassDataChannel_ConfigEntries()
     * @model transient="true"
     * @generated
     */
    EList<String> getConfigEntries();

} // JavaClassDataChannel
