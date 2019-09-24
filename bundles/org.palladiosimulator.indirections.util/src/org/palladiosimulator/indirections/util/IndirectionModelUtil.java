package org.palladiosimulator.indirections.util;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.Connector;

public final class IndirectionModelUtil {
    private IndirectionModelUtil() {

    }

    public static DataChannel getConnectedSinkDataChannel(final AssemblyContext assemblyContext,
            final DataSourceRole sourceRole) {
        final EList<Connector> connectors = assemblyContext.getParentStructure__AssemblyContext()
                .getConnectors__ComposedStructure();
        final List<DataChannelSourceConnector> dataChannelSourceConnectors = connectors.stream()
                .filter(DataChannelSourceConnector.class::isInstance).map(DataChannelSourceConnector.class::cast)
                .collect(Collectors.toList());

        return dataChannelSourceConnectors.stream().filter(it -> it.getDataSourceRole().equals(sourceRole)).findAny()
                .orElseThrow(
                        () -> new IllegalStateException("Could not find data channel for source role " + sourceRole))
                .getDataChannel();
    }

    public static DataChannelSinkConnector getSinkConnectorForRole(final AssemblyContext assemblyContext,
            final DataSinkRole sinkRole) {
        final EList<Connector> connectors = assemblyContext.getParentStructure__AssemblyContext()
                .getConnectors__ComposedStructure();
        final List<DataChannelSinkConnector> dataChannelSinkConnectors = connectors.stream()
                .filter(DataChannelSinkConnector.class::isInstance).map(DataChannelSinkConnector.class::cast)
                .collect(Collectors.toList());

        final DataChannelSinkConnector sinkConnectorForRole = dataChannelSinkConnectors.stream()
                .filter(it -> it.getDataSinkRole().equals(sinkRole)).findAny()
                .orElseThrow(() -> new IllegalStateException("Could not find data channel for sink role " + sinkRole));

        return sinkConnectorForRole;
    }
    
    public static DataChannelSourceConnector getSourceConnectorForRole(final AssemblyContext assemblyContext,
            final DataSourceRole sourceRole) {
        final EList<Connector> connectors = assemblyContext.getParentStructure__AssemblyContext()
                .getConnectors__ComposedStructure();
        final List<DataChannelSourceConnector> dataChannelSourceConnectors = connectors.stream()
                .filter(DataChannelSourceConnector.class::isInstance).map(DataChannelSourceConnector.class::cast)
                .collect(Collectors.toList());

        final DataChannelSourceConnector sourceConnectorForRole = dataChannelSourceConnectors.stream()
                .filter(it -> it.getDataSourceRole().equals(sourceRole)).findAny()
                .orElseThrow(() -> new IllegalStateException("Could not find data channel for source role " + sourceRole));

        return sourceConnectorForRole;
    }

    public static DataChannel getConnectedSourceDataChannel(final AssemblyContext assemblyContext,
            final DataSinkRole sinkRole) {
        return getSinkConnectorForRole(assemblyContext, sinkRole).getDataChannel();
    }
}
