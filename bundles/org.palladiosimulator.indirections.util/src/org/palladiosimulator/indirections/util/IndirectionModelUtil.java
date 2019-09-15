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

	public static DataChannel getConnectedSinkDataChannel(AssemblyContext assemblyContext, DataSourceRole sourceRole) {
		EList<Connector> connectors = assemblyContext.getParentStructure__AssemblyContext()
				.getConnectors__ComposedStructure();
		List<DataChannelSourceConnector> dataChannelSourceConnectors = connectors.stream()
				.filter(DataChannelSourceConnector.class::isInstance).map(DataChannelSourceConnector.class::cast)
				.collect(Collectors.toList());

		return dataChannelSourceConnectors.stream().filter(it -> it.getSourceRole().equals(sourceRole)).findAny()
				.orElseThrow(
						() -> new IllegalStateException("Could not find data channel for source role " + sourceRole))
				.getDataChannel();
	}

	public static DataChannelSinkConnector getSinkConnectorForRole(AssemblyContext assemblyContext, DataSinkRole sinkRole) {
		EList<Connector> connectors = assemblyContext.getParentStructure__AssemblyContext()
				.getConnectors__ComposedStructure();
		List<DataChannelSinkConnector> dataChannelSinkConnectors = connectors.stream()
				.filter(DataChannelSinkConnector.class::isInstance).map(DataChannelSinkConnector.class::cast)
				.collect(Collectors.toList());

		DataChannelSinkConnector sinkConnectorForRole = dataChannelSinkConnectors.stream()
				.filter(it -> it.getDataSinkRole().equals(sinkRole)).findAny().orElseThrow(
						() -> new IllegalStateException("Could not find data channel for sink role " + sinkRole));

		return sinkConnectorForRole;
	}

	public static DataChannel getConnectedSourceDataChannel(AssemblyContext assemblyContext, DataSinkRole sinkRole) {
		return getSinkConnectorForRole(assemblyContext, sinkRole).getDataChannel();
	}	
}
