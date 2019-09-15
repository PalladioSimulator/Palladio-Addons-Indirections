package org.palladiosimulator.indirections.scheduler;

import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.system.DataChannel;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class SimDataChannelResource extends AbstractDistributingSimDataChannelResource {
	public SimDataChannelResource(DataChannel dataChannel, SchedulerModel model) {
		super(dataChannel, model);
	}

	@Override
	protected void allowToGet(ProcessWaitingToConsume process) {
	}

	@Override
	protected void allowToPut(ProcessWaitingToEmit process) {
	}
}
