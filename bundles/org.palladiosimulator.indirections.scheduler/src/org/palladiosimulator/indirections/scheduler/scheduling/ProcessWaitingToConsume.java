package org.palladiosimulator.indirections.scheduler.scheduling;

import java.util.function.Consumer;

import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class ProcessWaitingToConsume extends SuspendableSchedulerEntity {
    public final Consumer<IndirectionDate> callback;
    public final DataChannelSinkConnector sinkConnector;

    public ProcessWaitingToConsume(final SchedulerModel model, final ISchedulableProcess schedulableProcess,
            final DataChannelSinkConnector sinkConnector, final Consumer<IndirectionDate> callback) {
        super(model, schedulableProcess, ProcessWaitingToConsume.class.getName());

        this.callback = callback;
        this.sinkConnector = sinkConnector;
    }

}