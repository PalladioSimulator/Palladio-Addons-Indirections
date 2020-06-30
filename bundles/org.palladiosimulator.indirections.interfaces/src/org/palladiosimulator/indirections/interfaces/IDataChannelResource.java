package org.palladiosimulator.indirections.interfaces;

import java.util.function.Consumer;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

/**
 * Implementations have to have a constructor that accepts a SimulationControl
 */
public interface IDataChannelResource {
	boolean put(ISchedulableProcess process, DataChannelSinkConnector sourceConnector, IndirectionDate date);

	boolean get(ISchedulableProcess process, DataChannelSourceConnector sinkConnector,
			Consumer<IndirectionDate> callback);

	void advance(double simulationTime);

	/**
	 * Name of the resource.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Unique identifier of the resource.
	 * 
	 * @return
	 */
	String getId();
}
