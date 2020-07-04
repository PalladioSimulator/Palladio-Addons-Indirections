/**
 */
package org.palladiosimulator.indirections.composition.abstract_;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.Signature;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Assembly Context Sink
 * Connector</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> Connector that has an AssemblyContext as its sink.
 * <p>
 * TODO: should check whether the given sink role fits to the pushing service <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector#getSinkAssemblyContext
 * <em>Sink Assembly Context</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector#getPushesTo
 * <em>Pushes To</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector#isPushing
 * <em>Pushing</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage#getAssemblyContextSinkConnector()
 * @model abstract="true"
 * @generated
 */
public interface AssemblyContextSinkConnector extends DataSourceSinkConnector {
    /**
     * Returns the value of the '<em><b>Sink Assembly Context</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Sink Assembly Context</em>' reference.
     * @see #setSinkAssemblyContext(AssemblyContext)
     * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage#getAssemblyContextSinkConnector_SinkAssemblyContext()
     * @model required="true" ordered="false"
     * @generated
     */
    AssemblyContext getSinkAssemblyContext();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector#getSinkAssemblyContext
     * <em>Sink Assembly Context</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Sink Assembly Context</em>' reference.
     * @see #getSinkAssemblyContext()
     * @generated
     */
    void setSinkAssemblyContext(AssemblyContext value);

    /**
     * Returns the value of the '<em><b>Pushes To</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc --> <!-- begin-model-doc --> If this is empty, then the connector does not push.
     * If it is set, the connection is pushing. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Pushes To</em>' reference.
     * @see #setPushesTo(Signature)
     * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage#getAssemblyContextSinkConnector_PushesTo()
     * @model
     * @generated
     */
    Signature getPushesTo();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector#getPushesTo
     * <em>Pushes To</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Pushes To</em>' reference.
     * @see #getPushesTo()
     * @generated
     */
    void setPushesTo(Signature value);

    /**
     * Returns the value of the '<em><b>Pushing</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Pushing</em>' attribute.
     * @see #setPushing(boolean)
     * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage#getAssemblyContextSinkConnector_Pushing()
     * @model required="true" transient="true" volatile="true" derived="true"
     * @generated
     */
    boolean isPushing();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector#isPushing
     * <em>Pushing</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Pushing</em>' attribute.
     * @see #isPushing()
     * @generated
     */
    void setPushing(boolean value);

} // AssemblyContextSinkConnector
