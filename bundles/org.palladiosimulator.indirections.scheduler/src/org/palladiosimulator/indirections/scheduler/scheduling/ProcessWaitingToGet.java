package org.palladiosimulator.indirections.scheduler.scheduling;

import java.util.function.Consumer;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class ProcessWaitingToGet extends SuspendableSchedulerEntity {
    public final Consumer<IndirectionDate> callback;
    public final DataChannelSourceConnector connector;

    public ProcessWaitingToGet(final SchedulerModel model, final ISchedulableProcess schedulableProcess,
            final DataChannelSourceConnector connector, final Consumer<IndirectionDate> callback) {
        super(model, schedulableProcess, ProcessWaitingToGet.class.getName());

        this.callback = callback;
        this.connector = connector;
    }

}