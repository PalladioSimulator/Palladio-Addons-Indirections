package org.palladiosimulator.indirections.scheduler.implementations;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

// Additionally has an upper capacity
public class AllToAllDataChannelResourceWithCapacity extends AllToAllDataChannelResource {
    public final int CAPACITY = 20;

    public AllToAllDataChannelResourceWithCapacity(final DataChannel dataChannel,
            final InterpreterDefaultContext context, final SchedulerModel model) {
        super(dataChannel, context, model);
    }

    @Override
    protected boolean canAcceptData(final DataChannelSinkConnector connector) {
        return this.data.size() < this.CAPACITY;
    }

    @Override
    protected void handleCannotProceedToGet(final ProcessWaitingToGet process) {
        this.blockUntilCanGet(process);
    }

    @Override
    protected void handleCannotProceedToPut(final ProcessWaitingToPut process) {
        this.blockUntilCanPut(process);
    }

    @Override
    protected IndirectionDate provideDataAndAdvance(final DataChannelSourceConnector connector) {
        final IndirectionDate date = this.data.remove();
        this.notifyProcessesCanPutNewData();
        return date;
    }
}