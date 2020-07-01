/**
 */
package org.palladiosimulator.indirections.composition.abstract_;

import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;

import org.palladiosimulator.pcm.core.composition.Connector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Source Sink Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Connector between a source and a sink of data.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector#getDataSourceRole <em>Data Source Role</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector#getDataSinkRole <em>Data Sink Role</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage#getDataSourceSinkConnector()
 * @model abstract="true"
 * @generated
 */
public interface DataSourceSinkConnector extends Connector {
	/**
	 * Returns the value of the '<em><b>Data Source Role</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.palladiosimulator.indirections.repository.DataSourceRole#getDataSourceSinkConnectors <em>Data Source Sink Connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source Role</em>' reference.
	 * @see #setDataSourceRole(DataSourceRole)
	 * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage#getDataSourceSinkConnector_DataSourceRole()
	 * @see org.palladiosimulator.indirections.repository.DataSourceRole#getDataSourceSinkConnectors
	 * @model opposite="dataSourceSinkConnectors" required="true" ordered="false"
	 * @generated
	 */
	DataSourceRole getDataSourceRole();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector#getDataSourceRole <em>Data Source Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source Role</em>' reference.
	 * @see #getDataSourceRole()
	 * @generated
	 */
	void setDataSourceRole(DataSourceRole value);

	/**
	 * Returns the value of the '<em><b>Data Sink Role</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.palladiosimulator.indirections.repository.DataSinkRole#getDataSourceSinkConnectors <em>Data Source Sink Connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Sink Role</em>' reference.
	 * @see #setDataSinkRole(DataSinkRole)
	 * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage#getDataSourceSinkConnector_DataSinkRole()
	 * @see org.palladiosimulator.indirections.repository.DataSinkRole#getDataSourceSinkConnectors
	 * @model opposite="dataSourceSinkConnectors" required="true" ordered="false"
	 * @generated
	 */
	DataSinkRole getDataSinkRole();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector#getDataSinkRole <em>Data Sink Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Sink Role</em>' reference.
	 * @see #getDataSinkRole()
	 * @generated
	 */
	void setDataSinkRole(DataSinkRole value);

} // DataSourceSinkConnector
