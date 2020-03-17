/**
 */
package org.palladiosimulator.indirections.composition;

import org.palladiosimulator.indirections.repository.DataSourceRole;

import org.palladiosimulator.indirections.system.DataChannel;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.Connector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Channel Source Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.composition.DataChannelSourceConnector#getDataSourceRole <em>Data Source Role</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.composition.DataChannelSourceConnector#getAssemblyContext <em>Assembly Context</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.composition.DataChannelSourceConnector#getDataChannel <em>Data Channel</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.composition.CompositionPackage#getDataChannelSourceConnector()
 * @model
 * @generated
 */
public interface DataChannelSourceConnector extends Connector {
	/**
	 * Returns the value of the '<em><b>Data Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source Role</em>' reference.
	 * @see #setDataSourceRole(DataSourceRole)
	 * @see org.palladiosimulator.indirections.composition.CompositionPackage#getDataChannelSourceConnector_DataSourceRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataSourceRole getDataSourceRole();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.composition.DataChannelSourceConnector#getDataSourceRole <em>Data Source Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source Role</em>' reference.
	 * @see #getDataSourceRole()
	 * @generated
	 */
	void setDataSourceRole(DataSourceRole value);

	/**
	 * Returns the value of the '<em><b>Assembly Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context</em>' reference.
	 * @see #setAssemblyContext(AssemblyContext)
	 * @see org.palladiosimulator.indirections.composition.CompositionPackage#getDataChannelSourceConnector_AssemblyContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.composition.DataChannelSourceConnector#getAssemblyContext <em>Assembly Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context</em>' reference.
	 * @see #getAssemblyContext()
	 * @generated
	 */
	void setAssemblyContext(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Data Channel</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.palladiosimulator.indirections.system.DataChannel#getDataChannelSourceConnector <em>Data Channel Source Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Channel</em>' reference.
	 * @see #setDataChannel(DataChannel)
	 * @see org.palladiosimulator.indirections.composition.CompositionPackage#getDataChannelSourceConnector_DataChannel()
	 * @see org.palladiosimulator.indirections.system.DataChannel#getDataChannelSourceConnector
	 * @model opposite="dataChannelSourceConnector" required="true" ordered="false"
	 * @generated
	 */
	DataChannel getDataChannel();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.composition.DataChannelSourceConnector#getDataChannel <em>Data Channel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Channel</em>' reference.
	 * @see #getDataChannel()
	 * @generated
	 */
	void setDataChannel(DataChannel value);

} // DataChannelSourceConnector
