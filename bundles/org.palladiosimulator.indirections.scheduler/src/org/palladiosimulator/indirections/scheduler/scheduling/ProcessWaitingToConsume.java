package org.palladiosimulator.indirections.scheduler.scheduling;

import java.util.Map;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class ProcessWaitingToConsume extends SuspendableSchedulerEntity {
	public final Consumer<Map<String, Object>> callback;
	public final DataChannelSinkConnector sinkConnector;

	public ProcessWaitingToConsume(SchedulerModel model, ISchedulableProcess schedulableProcess, DataChannelSinkConnector sinkConnector, Consumer<Map<String, Object>> callback) {
		super(model, schedulableProcess, ProcessWaitingToConsume.class.getName());
		
		this.callback = callback;
		this.sinkConnector = sinkConnector;
	}
	
}