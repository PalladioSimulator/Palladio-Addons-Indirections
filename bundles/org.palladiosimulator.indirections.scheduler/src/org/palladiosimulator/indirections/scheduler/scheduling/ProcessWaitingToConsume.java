package org.palladiosimulator.indirections.scheduler.scheduling;

import java.util.Map;
import java.util.function.Consumer;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class ProcessWaitingToConsume extends SuspendableSchedulerEntity {
	public final Consumer<Map<String, Object>> callback;

	public ProcessWaitingToConsume(SchedulerModel model, ISchedulableProcess schedulableProcess, Consumer<Map<String, Object>> callback) {
		super(model, schedulableProcess, ProcessWaitingToConsume.class.getName());
		
		this.callback = callback;
	}
	
}