/**
 */
package org.palladiosimulator.indirections.system;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity;
import org.palladiosimulator.pcm.core.entity.ResourceInterfaceRequiringEntity;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Data Channel</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * Note that this class is also a {@link ResourceInterfaceRequiringEntity}
 * </p>
 * <p>
 * TODO: validation for derived attribute should be implemented (type must be
 * DataSinkRole/DataSourceRole)
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.system.DataChannel#getDataSinkRoles <em>Data Sink
 * Roles</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.DataChannel#getDataSourceRoles <em>Data
 * Source Roles</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel()
 * @model abstract="true"
 * @generated
 */
public interface DataChannel extends InterfaceProvidingRequiringEntity {
    /**
     * Returns the value of the '<em><b>Data Sink Roles</b></em>' reference list. The list contents
     * are of type {@link org.palladiosimulator.indirections.repository.DataSinkRole}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Data Sink Roles</em>' reference list.
     * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel_DataSinkRoles()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    EList<DataSinkRole> getDataSinkRoles();

    /**
     * Returns the value of the '<em><b>Data Source Roles</b></em>' reference list. The list
     * contents are of type {@link org.palladiosimulator.indirections.repository.DataSourceRole}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Data Source Roles</em>' reference list.
     * @see org.palladiosimulator.indirections.system.SystemPackage#getDataChannel_DataSourceRoles()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    EList<DataSourceRole> getDataSourceRoles();

} // DataChannel
