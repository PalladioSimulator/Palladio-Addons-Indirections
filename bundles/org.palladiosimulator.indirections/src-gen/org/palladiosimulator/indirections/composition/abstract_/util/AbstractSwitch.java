/**
 */
package org.palladiosimulator.indirections.composition.abstract_.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;
import org.palladiosimulator.pcm.core.composition.Connector;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.core.entity.NamedElement;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.indirections.composition.abstract_.AbstractPackage
 * @generated
 */
public class AbstractSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static AbstractPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AbstractSwitch() {
        if (modelPackage == null) {
            modelPackage = AbstractPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param ePackage
     *            the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(final EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(final int classifierID, final EObject theEObject) {
        switch (classifierID) {
        case AbstractPackage.DATA_SOURCE_SINK_CONNECTOR: {
            final DataSourceSinkConnector dataSourceSinkConnector = (DataSourceSinkConnector) theEObject;
            T result = this.caseDataSourceSinkConnector(dataSourceSinkConnector);
            if (result == null) {
                result = this.caseConnector(dataSourceSinkConnector);
            }
            if (result == null) {
                result = this.caseEntity(dataSourceSinkConnector);
            }
            if (result == null) {
                result = this.caseIdentifier(dataSourceSinkConnector);
            }
            if (result == null) {
                result = this.caseNamedElement(dataSourceSinkConnector);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractPackage.DATA_CHANNEL_SOURCE_CONNECTOR: {
            final DataChannelSourceConnector dataChannelSourceConnector = (DataChannelSourceConnector) theEObject;
            T result = this.caseDataChannelSourceConnector(dataChannelSourceConnector);
            if (result == null) {
                result = this.caseDataSourceSinkConnector(dataChannelSourceConnector);
            }
            if (result == null) {
                result = this.caseConnector(dataChannelSourceConnector);
            }
            if (result == null) {
                result = this.caseEntity(dataChannelSourceConnector);
            }
            if (result == null) {
                result = this.caseIdentifier(dataChannelSourceConnector);
            }
            if (result == null) {
                result = this.caseNamedElement(dataChannelSourceConnector);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractPackage.DATA_CHANNEL_SINK_CONNECTOR: {
            final DataChannelSinkConnector dataChannelSinkConnector = (DataChannelSinkConnector) theEObject;
            T result = this.caseDataChannelSinkConnector(dataChannelSinkConnector);
            if (result == null) {
                result = this.caseDataSourceSinkConnector(dataChannelSinkConnector);
            }
            if (result == null) {
                result = this.caseConnector(dataChannelSinkConnector);
            }
            if (result == null) {
                result = this.caseEntity(dataChannelSinkConnector);
            }
            if (result == null) {
                result = this.caseIdentifier(dataChannelSinkConnector);
            }
            if (result == null) {
                result = this.caseNamedElement(dataChannelSinkConnector);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractPackage.ASSEMBLY_CONTEXT_SOURCE_CONNECTOR: {
            final AssemblyContextSourceConnector assemblyContextSourceConnector = (AssemblyContextSourceConnector) theEObject;
            T result = this.caseAssemblyContextSourceConnector(assemblyContextSourceConnector);
            if (result == null) {
                result = this.caseDataSourceSinkConnector(assemblyContextSourceConnector);
            }
            if (result == null) {
                result = this.caseConnector(assemblyContextSourceConnector);
            }
            if (result == null) {
                result = this.caseEntity(assemblyContextSourceConnector);
            }
            if (result == null) {
                result = this.caseIdentifier(assemblyContextSourceConnector);
            }
            if (result == null) {
                result = this.caseNamedElement(assemblyContextSourceConnector);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR: {
            final AssemblyContextSinkConnector assemblyContextSinkConnector = (AssemblyContextSinkConnector) theEObject;
            T result = this.caseAssemblyContextSinkConnector(assemblyContextSinkConnector);
            if (result == null) {
                result = this.caseDataSourceSinkConnector(assemblyContextSinkConnector);
            }
            if (result == null) {
                result = this.caseConnector(assemblyContextSinkConnector);
            }
            if (result == null) {
                result = this.caseEntity(assemblyContextSinkConnector);
            }
            if (result == null) {
                result = this.caseIdentifier(assemblyContextSinkConnector);
            }
            if (result == null) {
                result = this.caseNamedElement(assemblyContextSinkConnector);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        default:
            return this.defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Source Sink
     * Connector</em>'. <!-- begin-user-doc --> This implementation returns null; returning a
     * non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Source Sink
     *         Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataSourceSinkConnector(final DataSourceSinkConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Channel Source
     * Connector</em>'. <!-- begin-user-doc --> This implementation returns null; returning a
     * non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Channel Source
     *         Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataChannelSourceConnector(final DataChannelSourceConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Channel Sink
     * Connector</em>'. <!-- begin-user-doc --> This implementation returns null; returning a
     * non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Channel Sink
     *         Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataChannelSinkConnector(final DataChannelSinkConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Assembly Context Source
     * Connector</em>'. <!-- begin-user-doc --> This implementation returns null; returning a
     * non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Assembly Context Source
     *         Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssemblyContextSourceConnector(final AssemblyContextSourceConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Assembly Context Sink
     * Connector</em>'. <!-- begin-user-doc --> This implementation returns null; returning a
     * non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Assembly Context Sink
     *         Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssemblyContextSinkConnector(final AssemblyContextSinkConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIdentifier(final Identifier object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedElement(final NamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Entity</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEntity(final Entity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Connector</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConnector(final Connector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(final EObject object) {
        return null;
    }

} // AbstractSwitch
