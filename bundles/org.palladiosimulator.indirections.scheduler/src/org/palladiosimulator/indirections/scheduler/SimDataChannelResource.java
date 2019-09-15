package org.palladiosimulator.indirections.scheduler;

import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.system.DataChannel;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class SimDataChannelResource extends AbstractDistributingSimDataChannelResource {
    public SimDataChannelResource(final DataChannel dataChannel, final SchedulerModel model) {
        super(dataChannel, model);
    }

    @Override
    protected void allowToGet(final ProcessWaitingToConsume process) {
    }

    @Override
    protected void allowToPut(final ProcessWaitingToEmit process) {
    }
}
