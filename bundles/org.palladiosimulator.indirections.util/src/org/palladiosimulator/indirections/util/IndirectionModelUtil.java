package org.palladiosimulator.indirections.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.composition.AssemblyContextToDataChannelConnector;
import org.palladiosimulator.indirections.composition.DataChannelToAssemblyContextConnector;
import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.system.IndirectionsAwareSystem;
import org.palladiosimulator.indirections.util.simulizar.DataChannelRegistry;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.Connector;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public final class IndirectionModelUtil {
    public static Collection<DataChannelSourceConnector> getAllConnectorsFromSourceRoles(
            final DataChannel dataChannel) {
        var system = getSystem(dataChannel);
        return dataChannel.getDataSourceRoles()
            .stream()
            .flatMap(it -> getDataSourceSinkConnectors(it, system).stream())
            .map(it -> (DataChannelSourceConnector) it)
            .collect(Collectors.toList());
    }

    public static IndirectionsAwareSystem getSystem(final DataChannel dataChannel) {
        EObject container = dataChannel.eContainer();
        return ObjectUtil.forceCast(container, IndirectionsAwareSystem.class,
                () -> new PCMModelInterpreterException("Unexpected container for data channel " + dataChannel + ": "
                        + container + ", expected " + IndirectionsAwareSystem.class));
    }

    private static Collection<DataChannelSourceConnector> getDataSourceSinkConnectors(DataSourceRole role,
            IndirectionsAwareSystem system) {
        return system.getConnectors__ComposedStructure()
            .stream()
            .filter(DataChannelSourceConnector.class::isInstance)
            .map(DataChannelSourceConnector.class::cast)
            .filter(it -> it.getDataSourceRole()
                .equals(role))
            .collect(Collectors.toList());
    }

    public static DataChannel getConnectedSinkDataChannel(final AssemblyContext assemblyContext,
            final DataSourceRole sourceRole) {

        final EList<Connector> connectors = assemblyContext.getParentStructure__AssemblyContext()
            .getConnectors__ComposedStructure();
        final List<DataChannelSourceConnector> dataChannelSourceConnectors = connectors.stream()
            .filter(DataChannelSourceConnector.class::isInstance)
            .map(DataChannelSourceConnector.class::cast)
            .collect(Collectors.toList());

        return dataChannelSourceConnectors.stream()
            .filter(it -> it.getDataSourceRole()
                .equals(sourceRole))
            .findAny()
            .orElseThrow(() -> new IllegalStateException("Could not find data channel for source role " + sourceRole))
            .getSourceDataChannel();
    }

    public static DataChannel getConnectedSourceDataChannel(final AssemblyContext assemblyContext,
            final DataSinkRole sinkRole) {
        final AssemblyContextToDataChannelConnector sinkConnectorForRole = ObjectUtil.forceCast(
                getSinkConnectorForRole(assemblyContext, sinkRole), AssemblyContextToDataChannelConnector.class,
                () -> new PCMModelInterpreterException("No " + AssemblyContextToDataChannelConnector.class.getName()
                        + " found for " + assemblyContext + ", " + sinkRole));

        return sinkConnectorForRole.getSinkDataChannel();
    }

    public static IDataChannelResource getDataChannelResource(final InterpreterDefaultContext context,
            final ConsumeDataAction action) {
        final DataChannel dataChannel = getSinkConnector(context, action).getSourceDataChannel();
        final IDataChannelResource dataChannelResource = DataChannelRegistry.getInstanceFor(context)
            .getOrCreateDataChannelResource(dataChannel);
        return dataChannelResource;
    }

    public static IDataChannelResource getDataChannelResource(final InterpreterDefaultContext context,
            final EmitDataAction action) {
        var sourceConnector = getSourceConnector(context, action);
        AssemblyContextToDataChannelConnector connector = ObjectUtil.forceCast(sourceConnector,
                AssemblyContextToDataChannelConnector.class, () -> new PCMModelInterpreterException(
                        "Not a " + AssemblyContextToDataChannelConnector.class + ": " + sourceConnector));

        final DataChannel dataChannel = connector.getSinkDataChannel();
        final IDataChannelResource dataChannelResource = DataChannelRegistry.getInstanceFor(context)
            .getOrCreateDataChannelResource(dataChannel);
        return dataChannelResource;
    }

    public static DataChannelToAssemblyContextConnector getSinkConnector(final InterpreterDefaultContext context,
            final ConsumeDataAction action) {
        final AssemblyContext assemblyContext = context.getAssemblyContextStack()
            .peek();
        final DataSinkRole sinkRole = action.getDataSinkRole();

        final AssemblyContextSinkConnector sinkConnectorForRole = getSinkConnectorForRole(assemblyContext, sinkRole);
        final DataChannelToAssemblyContextConnector connector = ObjectUtil.forceCast(sinkConnectorForRole,
                DataChannelToAssemblyContextConnector.class, () -> new PCMModelInterpreterException(
                        "Not a " + DataChannelToAssemblyContextConnector.class + ": " + sinkConnectorForRole));

        return connector;
    }

    public static AssemblyContextSinkConnector getSinkConnectorForRole(final AssemblyContext assemblyContext,
            final DataSinkRole sinkRole) {

        final EList<Connector> connectors = assemblyContext.getParentStructure__AssemblyContext()
            .getConnectors__ComposedStructure();

        final Stream<AssemblyContextSinkConnector> dataChannelSinkConnectors = connectors.stream()
            .filter(AssemblyContextSinkConnector.class::isInstance)
            .map(AssemblyContextSinkConnector.class::cast);

        final AssemblyContextSinkConnector sinkConnectorForRole = dataChannelSinkConnectors
            .filter(it -> it.getDataSinkRole()
                .equals(sinkRole))
            .findAny()
            .orElseThrow(() -> new IllegalStateException("Could not find data channel for sink role " + sinkRole));

        return sinkConnectorForRole;
    }

    public static AssemblyContextSourceConnector getSourceConnector(final InterpreterDefaultContext context,
            final EmitDataAction action) {
        final AssemblyContext assemblyContext = context.getAssemblyContextStack()
            .peek();
        final DataSourceRole sinkRole = action.getDataSourceRole();
        final AssemblyContextSourceConnector sourceConnectorForRole = getAssemblyContextSourceConnectorForRole(
                assemblyContext, sinkRole);
        return sourceConnectorForRole;
    }

    /*
     * final AssemblyContextToDataChannelConnector connector =
     * ObjectUtil.tryCast(sourceConnectorForRole, AssemblyContextToDataChannelConnector.class, () ->
     * new PCMModelInterpreterException("Not an " +
     * AssemblyContextToDataChannelConnector.class.getName() + ": " + sourceConnectorForRole));
     * 
     * return connector;
     * 
     */

    public static AssemblyContextSourceConnector getAssemblyContextSourceConnectorForRole(
            final AssemblyContext assemblyContext, final DataSourceRole sourceRole) {
        final EList<Connector> connectors = assemblyContext.getParentStructure__AssemblyContext()
            .getConnectors__ComposedStructure();

        final Stream<AssemblyContextSourceConnector> dataChannelSourceConnectors = connectors.stream()
            .filter(AssemblyContextSourceConnector.class::isInstance)
            .map(AssemblyContextSourceConnector.class::cast);

        var dataChannelSourceConnectorsList = dataChannelSourceConnectors.collect(Collectors.toList());

        final AssemblyContextSourceConnector sourceConnectorForRole = dataChannelSourceConnectorsList.stream()
            .filter(it -> it.getDataSourceRole()
                .equals(sourceRole))
            .findAny()
            .orElseThrow(() -> new IllegalStateException("Could not find data channel for source role " + sourceRole));

        return sourceConnectorForRole;
    }

    /*
     * public static AssemblyContextToDataChannelConnector getSourceConnector(final
     * InterpreterDefaultContext context, final EmitDataAction action) { final AssemblyContext
     * assemblyContext = context.getAssemblyContextStack() .peek(); final DataSourceRole sinkRole =
     * action.getDataSourceRole(); final AssemblyContextSourceConnector sourceConnectorForRole =
     * getSourceConnectorForRole(assemblyContext, sinkRole); final
     * AssemblyContextToDataChannelConnector connector = ObjectUtil.tryCast(sourceConnectorForRole,
     * AssemblyContextToDataChannelConnector.class, () -> new PCMModelInterpreterException("Not an "
     * + AssemblyContextToDataChannelConnector.class.getName() + ": " + sourceConnectorForRole));
     * 
     * return connector; }
     */

    /*
     * public static AssemblyContextSourceConnector getAssemblyContextSourceConnectorForRole(final
     * AssemblyContext assemblyContext, final DataSourceRole sourceRole) { final EList<Connector>
     * connectors = assemblyContext.getParentStructure__AssemblyContext()
     * .getConnectors__ComposedStructure();
     * 
     * final Stream<AssemblyContextSourceConnector> dataChannelSourceConnectors =
     * connectors.stream() .filter(AssemblyContextSourceConnector.class::isInstance)
     * .map(AssemblyContextSourceConnector.class::cast);
     * 
     * var dataChannelSourceConnectorsList =
     * dataChannelSourceConnectors.collect(Collectors.toList());
     * 
     * final AssemblyContextSourceConnector sourceConnectorForRole =
     * dataChannelSourceConnectorsList.stream() .filter(it -> it.getDataSourceRole()
     * .equals(sourceRole)) .findAny() .orElseThrow(() -> new
     * IllegalStateException("Could not find data channel for source role " + sourceRole));
     * 
     * return sourceConnectorForRole; }
     */

    public static boolean isPushingRole(final DataSourceRole role, final IndirectionsAwareSystem system) {
        return getDataSourceSinkConnectors(role, system).stream()
            .allMatch(IndirectionModelUtil::isPushingConnector);
    }

    private static boolean isPushingConnector(DataChannelSourceConnector connector) {
        if ((connector instanceof AssemblyContextSinkConnector)
                && ((AssemblyContextSinkConnector) connector).isPushing())
            return true;
        if ((connector instanceof DataChannelSinkConnector))
            return true;

        return false;
    }

    private IndirectionModelUtil() {

    }
}
