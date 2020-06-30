/**
 */
package org.palladiosimulator.indirections.composition.abstract_;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assembly Context Source Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Connector that has an AssemblyContext as its source.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector#getSourceAssemblyContext <em>Source Assembly Context</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage#getAssemblyContextSourceConnector()
 * @model abstract="true"
 * @generated
 */
public interface AssemblyContextSourceConnector extends DataSourceSinkConnector {
	/**
	 * Returns the value of the '<em><b>Source Assembly Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Assembly Context</em>' reference.
	 * @see #setSourceAssemblyContext(AssemblyContext)
	 * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage#getAssemblyContextSourceConnector_SourceAssemblyContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getSourceAssemblyContext();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector#getSourceAssemblyContext <em>Source Assembly Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Assembly Context</em>' reference.
	 * @see #getSourceAssemblyContext()
	 * @generated
	 */
	void setSourceAssemblyContext(AssemblyContext value);

} // AssemblyContextSourceConnector
