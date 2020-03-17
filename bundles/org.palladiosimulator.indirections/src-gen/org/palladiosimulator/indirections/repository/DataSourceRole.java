/**
 */
package org.palladiosimulator.indirections.repository;

import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.RequiredRole;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Source Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.repository.DataSourceRole#getEventGroup <em>Event Group</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.repository.RepositoryPackage#getDataSourceRole()
 * @model
 * @generated
 */
public interface DataSourceRole extends RequiredRole {
	/**
	 * Returns the value of the '<em><b>Event Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Group</em>' reference.
	 * @see #setEventGroup(EventGroup)
	 * @see org.palladiosimulator.indirections.repository.RepositoryPackage#getDataSourceRole_EventGroup()
	 * @model
	 * @generated
	 */
	EventGroup getEventGroup();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.repository.DataSourceRole#getEventGroup <em>Event Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Group</em>' reference.
	 * @see #getEventGroup()
	 * @generated
	 */
	void setEventGroup(EventGroup value);

} // DataSourceRole
