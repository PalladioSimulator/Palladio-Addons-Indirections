/**
 */
package org.palladiosimulator.indirections.composition.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.indirections.composition.CompositionPackage
 * @generated
 */
public class CompositionAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static CompositionPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public CompositionAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = CompositionPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc
     * --> This implementation returns <code>true</code> if the object is either the model's package
     * or is an instance object of the model. <!-- end-user-doc -->
     *
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(final Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass()
                .getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected CompositionSwitch<Adapter> modelSwitch = new CompositionSwitch<Adapter>() {
        @Override
        public Adapter caseDataChannelToAssemblyContextConnector(final DataChannelToAssemblyContextConnector object) {
            return CompositionAdapterFactory.this.createDataChannelToAssemblyContextConnectorAdapter();
        }

        @Override
        public Adapter caseAssemblyContextToDataChannelConnector(final AssemblyContextToDataChannelConnector object) {
            return CompositionAdapterFactory.this.createAssemblyContextToDataChannelConnectorAdapter();
        }

        @Override
        public Adapter caseDataChannelToDataChannelConnector(final DataChannelToDataChannelConnector object) {
            return CompositionAdapterFactory.this.createDataChannelToDataChannelConnectorAdapter();
        }

        @Override
        public Adapter caseAssemblyContextToAssemblyContextConnector(
                final AssemblyContextToAssemblyContextConnector object) {
            return CompositionAdapterFactory.this.createAssemblyContextToAssemblyContextConnectorAdapter();
        }

        @Override
        public Adapter caseIdentifier(final Identifier object) {
            return CompositionAdapterFactory.this.createIdentifierAdapter();
        }

        @Override
        public Adapter caseNamedElement(final NamedElement object) {
            return CompositionAdapterFactory.this.createNamedElementAdapter();
        }

        @Override
        public Adapter caseEntity(final Entity object) {
            return CompositionAdapterFactory.this.createEntityAdapter();
        }

        @Override
        public Adapter caseConnector(final Connector object) {
            return CompositionAdapterFactory.this.createConnectorAdapter();
        }

        @Override
        public Adapter caseDataSourceSinkConnector(final DataSourceSinkConnector object) {
            return CompositionAdapterFactory.this.createDataSourceSinkConnectorAdapter();
        }

        @Override
        public Adapter caseDataChannelSourceConnector(final DataChannelSourceConnector object) {
            return CompositionAdapterFactory.this.createDataChannelSourceConnectorAdapter();
        }

        @Override
        public Adapter caseAssemblyContextSinkConnector(final AssemblyContextSinkConnector object) {
            return CompositionAdapterFactory.this.createAssemblyContextSinkConnectorAdapter();
        }

        @Override
        public Adapter caseAssemblyContextSourceConnector(final AssemblyContextSourceConnector object) {
            return CompositionAdapterFactory.this.createAssemblyContextSourceConnectorAdapter();
        }

        @Override
        public Adapter caseDataChannelSinkConnector(final DataChannelSinkConnector object) {
            return CompositionAdapterFactory.this.createDataChannelSinkConnectorAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return CompositionAdapterFactory.this.createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(final Notifier target) {
        return this.modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.composition.DataChannelToAssemblyContextConnector
     * <em>Data Channel To Assembly Context Connector</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.composition.DataChannelToAssemblyContextConnector
     * @generated
     */
    public Adapter createDataChannelToAssemblyContextConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.composition.AssemblyContextToDataChannelConnector
     * <em>Assembly Context To Data Channel Connector</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.composition.AssemblyContextToDataChannelConnector
     * @generated
     */
    public Adapter createAssemblyContextToDataChannelConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.composition.DataChannelToDataChannelConnector
     * <em>Data Channel To Data Channel Connector</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.composition.DataChannelToDataChannelConnector
     * @generated
     */
    public Adapter createDataChannelToDataChannelConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.composition.AssemblyContextToAssemblyContextConnector
     * <em>Assembly Context To Assembly Context Connector</em>}'. <!-- begin-user-doc --> This
     * default implementation returns null so that we can easily ignore cases; it's useful to ignore
     * a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.composition.AssemblyContextToAssemblyContextConnector
     * @generated
     */
    public Adapter createAssemblyContextToAssemblyContextConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier
     * <em>Identifier</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.uka.ipd.sdq.identifier.Identifier
     * @generated
     */
    public Adapter createIdentifierAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.pcm.core.entity.NamedElement <em>Named Element</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.NamedElement
     * @generated
     */
    public Adapter createNamedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.pcm.core.entity.Entity <em>Entity</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.Entity
     * @generated
     */
    public Adapter createEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.pcm.core.composition.Connector <em>Connector</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.composition.Connector
     * @generated
     */
    public Adapter createConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector
     * <em>Data Source Sink Connector</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector
     * @generated
     */
    public Adapter createDataSourceSinkConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector
     * <em>Data Channel Source Connector</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector
     * @generated
     */
    public Adapter createDataChannelSourceConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector
     * <em>Assembly Context Sink Connector</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector
     * @generated
     */
    public Adapter createAssemblyContextSinkConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector
     * <em>Assembly Context Source Connector</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector
     * @generated
     */
    public Adapter createAssemblyContextSourceConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector
     * <em>Data Channel Sink Connector</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector
     * @generated
     */
    public Adapter createDataChannelSinkConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // CompositionAdapterFactory
