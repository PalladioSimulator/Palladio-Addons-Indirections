/**
 */
package org.palladiosimulator.indirections.repository;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;
import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.RequiredRole;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Data Source Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.repository.DataSourceRole#getEventGroup <em>Event
 * Group</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.repository.DataSourceRole#getDataSourceSinkConnectors
 * <em>Data Source Sink Connectors</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.repository.RepositoryPackage#getDataSourceRole()
 * @model abstract="true"
 * @generated
 */
public interface DataSourceRole extends RequiredRole {
    /**
     * Returns the value of the '<em><b>Event Group</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Event Group</em>' reference.
     * @see #setEventGroup(EventGroup)
     * @see org.palladiosimulator.indirections.repository.RepositoryPackage#getDataSourceRole_EventGroup()
     * @model
     * @generated
     */
    EventGroup getEventGroup();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.repository.DataSourceRole#getEventGroup <em>Event
     * Group</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Event Group</em>' reference.
     * @see #getEventGroup()
     * @generated
     */
    void setEventGroup(EventGroup value);

    /**
     * Returns the value of the '<em><b>Data Source Sink Connectors</b></em>' reference list. The
     * list contents are of type
     * {@link org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector}. It
     * is bidirectional and its opposite is
     * '{@link org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector#getDataSourceRole
     * <em>Data Source Role</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Data Source Sink Connectors</em>' reference list.
     * @see org.palladiosimulator.indirections.repository.RepositoryPackage#getDataSourceRole_DataSourceSinkConnectors()
     * @see org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector#getDataSourceRole
     * @model opposite="dataSourceRole"
     * @generated
     */
    EList<DataSourceSinkConnector> getDataSourceSinkConnectors();

} // DataSourceRole
