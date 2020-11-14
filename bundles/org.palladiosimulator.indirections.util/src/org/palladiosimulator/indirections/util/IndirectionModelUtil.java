package org.palladiosimulator.indirections.util;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.composition.AssemblyDataConnector;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.util.simulizar.DataChannelRegistry;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitchFactory;

public final class IndirectionModelUtil {
    private IndirectionModelUtil() {

    }

    public static Stream<AssemblyDataConnector> getAllAssemblyDataConnectors(AssemblyContext assemblyContext) {
        return assemblyContext //
            .getParentStructure__AssemblyContext()
            .getConnectors__ComposedStructure()
            .stream()
            .filter(AssemblyDataConnector.class::isInstance)
            .map(AssemblyDataConnector.class::cast);
    }

    public static AssemblyDataConnector getExactlyOneAssemblyDataConnector(AssemblyContext assemblyContext,
            DataSinkRole dataSinkRole) {
        // XXX Dominik: This needs to be encapsulated into a switch like
        // org.palladiosimulator.simulizar.interpreter.ComposedStructureInnerSwitch
        // org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitch
        // to allow more types of connections. Currently, only direct connections between
        // BasicComponents and DataChannels and vice versa are allowed.
        return IterableUtil.claimOne(getAllAssemblyDataConnectors(assemblyContext).filter(it -> it.getDataSinkRole()
            .equals(dataSinkRole))
            .collect(Collectors.toList()));
    }

    public static AssemblyDataConnector getExactlyOneAssemblyDataConnector(AssemblyContext assemblyContext,
            DataSourceRole dataSourceRole) {
        return IterableUtil.claimOne(getAllAssemblyDataConnectors(assemblyContext).filter(it -> it.getDataSourceRole()
            .equals(dataSourceRole))
            .collect(Collectors.toList()));
    }

    public static IDataChannelResource getDataChannelResource(InterpreterDefaultContext context,
            RepositoryComponentSwitchFactory repositoryComponentSwitchFactory, AssemblyContext assemblyContext,
            ConsumeDataAction action) {
        final DataChannel dataChannel = claimDataChannelToConsumeFrom(action);
        final IDataChannelResource dataChannelResource = DataChannelRegistry
            .getInstanceFor(context, repositoryComponentSwitchFactory)
            .getOrCreateDataChannelResource(dataChannel, assemblyContext);
        return dataChannelResource;
    }

    public static IDataChannelResource getDataChannelResource(InterpreterDefaultContext context,
            RepositoryComponentSwitchFactory repositoryComponentSwitchFactory, AssemblyContext assemblyContext,
            EmitDataAction action) {
        final DataChannel dataChannel = claimDataChannelToEmitTo(action);
        final IDataChannelResource dataChannelResource = DataChannelRegistry
            .getInstanceFor(context, repositoryComponentSwitchFactory)
            .getOrCreateDataChannelResource(dataChannel, assemblyContext);
        return dataChannelResource;
    }

    private static DataChannel claimDataChannelToEmitTo(EmitDataAction action) {
        return ObjectUtil.forceCast(action.getDataSourceRole()
            .getRequiringEntity_RequiredRole(), DataChannel.class);
    }

    private static DataChannel claimDataChannelToConsumeFrom(ConsumeDataAction action) {
        return ObjectUtil.forceCast(action.getDataSinkRole()
            .getProvidingEntity_ProvidedRole(), DataChannel.class);
    }
}
