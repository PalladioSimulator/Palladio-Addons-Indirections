/**
 */
package org.palladiosimulator.indirections.composition.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.indirections.composition.AssemblyContextToAssemblyContextConnector;
import org.palladiosimulator.indirections.composition.AssemblyContextToDataChannelConnector;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.DataChannelToAssemblyContextConnector;
import org.palladiosimulator.indirections.composition.DataChannelToDataChannelConnector;
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
 * @see org.palladiosimulator.indirections.composition.CompositionPackage
 * @generated
 */
public class CompositionSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static CompositionPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public CompositionSwitch() {
        if (modelPackage == null) {
            modelPackage = CompositionPackage.eINSTANCE;
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
        case CompositionPackage.DATA_CHANNEL_TO_ASSEMBLY_CONTEXT_CONNECTOR: {
            final DataChannelToAssemblyContextConnector dataChannelToAssemblyContextConnector = (DataChannelToAssemblyContextConnector) theEObject;
            T result = this.caseDataChannelToAssemblyContextConnector(dataChannelToAssemblyContextConnector);
            if (result == null) {
                result = this.caseDataChannelSourceConnector(dataChannelToAssemblyContextConnector);
            }
            if (result == null) {
                result = this.caseAssemblyContextSinkConnector(dataChannelToAssemblyContextConnector);
            }
            if (result == null) {
                result = this.caseDataSourceSinkConnector(dataChannelToAssemblyContextConnector);
            }
            if (result == null) {
                result = this.caseConnector(dataChannelToAssemblyContextConnector);
            }
            if (result == null) {
                result = this.caseEntity(dataChannelToAssemblyContextConnector);
            }
            if (result == null) {
                result = this.caseIdentifier(dataChannelToAssemblyContextConnector);
            }
            if (result == null) {
                result = this.caseNamedElement(dataChannelToAssemblyContextConnector);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_DATA_CHANNEL_CONNECTOR: {
            final AssemblyContextToDataChannelConnector assemblyContextToDataChannelConnector = (AssemblyContextToDataChannelConnector) theEObject;
            T result = this.caseAssemblyContextToDataChannelConnector(assemblyContextToDataChannelConnector);
            if (result == null) {
                result = this.caseAssemblyContextSourceConnector(assemblyContextToDataChannelConnector);
            }
            if (result == null) {
                result = this.caseDataChannelSinkConnector(assemblyContextToDataChannelConnector);
            }
            if (result == null) {
                result = this.caseDataSourceSinkConnector(assemblyContextToDataChannelConnector);
            }
            if (result == null) {
                result = this.caseConnector(assemblyContextToDataChannelConnector);
            }
            if (result == null) {
                result = this.caseEntity(assemblyContextToDataChannelConnector);
            }
            if (result == null) {
                result = this.caseIdentifier(assemblyContextToDataChannelConnector);
            }
            if (result == null) {
                result = this.caseNamedElement(assemblyContextToDataChannelConnector);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case CompositionPackage.DATA_CHANNEL_TO_DATA_CHANNEL_CONNECTOR: {
            final DataChannelToDataChannelConnector dataChannelToDataChannelConnector = (DataChannelToDataChannelConnector) theEObject;
            T result = this.caseDataChannelToDataChannelConnector(dataChannelToDataChannelConnector);
            if (result == null) {
                result = this.caseDataChannelSourceConnector(dataChannelToDataChannelConnector);
            }
            if (result == null) {
                result = this.caseDataChannelSinkConnector(dataChannelToDataChannelConnector);
            }
            if (result == null) {
                result = this.caseDataSourceSinkConnector(dataChannelToDataChannelConnector);
            }
            if (result == null) {
                result = this.caseConnector(dataChannelToDataChannelConnector);
            }
            if (result == null) {
                result = this.caseEntity(dataChannelToDataChannelConnector);
            }
            if (result == null) {
                result = this.caseIdentifier(dataChannelToDataChannelConnector);
            }
            if (result == null) {
                result = this.caseNamedElement(dataChannelToDataChannelConnector);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case CompositionPackage.ASSEMBLY_CONTEXT_TO_ASSEMBLY_CONTEXT_CONNECTOR: {
            final AssemblyContextToAssemblyContextConnector assemblyContextToAssemblyContextConnector = (AssemblyContextToAssemblyContextConnector) theEObject;
            T result = this.caseAssemblyContextToAssemblyContextConnector(assemblyContextToAssemblyContextConnector);
            if (result == null) {
                result = this.caseAssemblyContextSourceConnector(assemblyContextToAssemblyContextConnector);
            }
            if (result == null) {
                result = this.caseAssemblyContextSinkConnector(assemblyContextToAssemblyContextConnector);
            }
            if (result == null) {
                result = this.caseDataSourceSinkConnector(assemblyContextToAssemblyContextConnector);
            }
            if (result == null) {
                result = this.caseConnector(assemblyContextToAssemblyContextConnector);
            }
            if (result == null) {
                result = this.caseEntity(assemblyContextToAssemblyContextConnector);
            }
            if (result == null) {
                result = this.caseIdentifier(assemblyContextToAssemblyContextConnector);
            }
            if (result == null) {
                result = this.caseNamedElement(assemblyContextToAssemblyContextConnector);
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
     * Returns the result of interpreting the object as an instance of '<em>Data Channel To Assembly
     * Context Connector</em>'. <!-- begin-user-doc --> This implementation returns null; returning
     * a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Channel To Assembly
     *         Context Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataChannelToAssemblyContextConnector(final DataChannelToAssemblyContextConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Assembly Context To Data
     * Channel Connector</em>'. <!-- begin-user-doc --> This implementation returns null; returning
     * a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Assembly Context To Data
     *         Channel Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssemblyContextToDataChannelConnector(final AssemblyContextToDataChannelConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Channel To Data
     * Channel Connector</em>'. <!-- begin-user-doc --> This implementation returns null; returning
     * a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Channel To Data
     *         Channel Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataChannelToDataChannelConnector(final DataChannelToDataChannelConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Assembly Context To
     * Assembly Context Connector</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Assembly Context To
     *         Assembly Context Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssemblyContextToAssemblyContextConnector(final AssemblyContextToAssemblyContextConnector object) {
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

} // CompositionSwitch
