package org.palladiosimulator.indirections.scheduler;

import java.util.Map;
import java.util.function.Consumer;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class ProcessWaitingToGet extends SuspendableSchedulerEntity {
	public final Consumer<Map<String, Object>> callback;

	protected ProcessWaitingToGet(SchedulerModel model, ISchedulableProcess schedulableProcess, Consumer<Map<String, Object>> callback) {
		super(model, schedulableProcess, ProcessWaitingToGet.class.getName());
		
		this.callback = callback;
	}
	
}