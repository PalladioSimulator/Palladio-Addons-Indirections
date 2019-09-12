package org.palladiosimulator.simulizar.indirection.scheduler;

import java.util.Map;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class ProcessWaitingToPut extends SuspendableSchedulerEntity {
	public final Map<String, Object> frame;

	protected ProcessWaitingToPut(SchedulerModel model, ISchedulableProcess schedulableProcess, Map<String, Object> frame) {
		super(model, schedulableProcess, ProcessWaitingToPut.class.getName());
		
		this.frame = frame;
	}
}