package org.palladiosimulator.indirections.util;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.palladiosimulator.indirections.composition.AssemblyDataConnector;
import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;

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

    /*
     * public static IDataChannelResource getDataChannelResource(InterpreterDefaultContext context,
     * RepositoryComponentSwitch.Factory repositoryComponentSwitchFactory, AssemblyContext
     * assemblyContext) { final DataChannel dataChannel = getDataChannel(assemblyContext); final
     * IDataChannelResource dataChannelResource = DataChannelRegistry .getInstanceFor(context,
     * repositoryComponentSwitchFactory) .getOrCreateDataChannelResource(dataChannel,
     * assemblyContext); return dataChannelResource; }
     */

    public static DataChannel getDataChannel(AssemblyContext assemblyContext) {
        final DataChannel dataChannel = ObjectUtil
            .forceCast(assemblyContext.getEncapsulatedComponent__AssemblyContext(), DataChannel.class);
        return dataChannel;
    }
}
