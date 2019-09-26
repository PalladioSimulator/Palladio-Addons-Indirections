package org.palladiosimulator.indirections.scheduler.scheduling;

import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class ProcessWaitingToEmit extends SuspendableSchedulerEntity {
    public final IndirectionDate date;
    public final DataChannelSourceConnector sourceConnector;

    public ProcessWaitingToEmit(final SchedulerModel model, final ISchedulableProcess schedulableProcess,
            final DataChannelSourceConnector sourceConnector, final IndirectionDate frame) {
        super(model, schedulableProcess, ProcessWaitingToEmit.class.getName());

        this.date = frame;
        this.sourceConnector = sourceConnector;
    }
}