package org.palladiosimulator.indirections.scheduler.scheduling;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class ProcessWaitingToPut extends SuspendableSchedulerEntity {
    public final DataChannelSinkConnector connector;
    public final IndirectionDate date;

    public ProcessWaitingToPut(final SchedulerModel model, final ISchedulableProcess schedulableProcess,
            final DataChannelSinkConnector connector, final IndirectionDate frame) {
        super(model, schedulableProcess, ProcessWaitingToPut.class.getName());

        this.date = frame;
        this.connector = connector;
    }
}