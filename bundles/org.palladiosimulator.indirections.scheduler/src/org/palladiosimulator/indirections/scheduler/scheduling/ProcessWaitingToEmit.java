package org.palladiosimulator.indirections.scheduler.scheduling;

import java.util.Map;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class ProcessWaitingToEmit extends SuspendableSchedulerEntity {
	public final Map<String, Object> frame;

	public ProcessWaitingToEmit(SchedulerModel model, ISchedulableProcess schedulableProcess, Map<String, Object> frame) {
		super(model, schedulableProcess, ProcessWaitingToEmit.class.getName());
		
		this.frame = frame;
	}
}