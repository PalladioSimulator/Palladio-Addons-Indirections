package org.palladiosimulator.indirections.scheduler.implementations;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

// Additionally has an upper capacity
public class AnyToAnyBlockingChannelWithCapacity extends AnyToAnyBlockingChannel {
    public final String CAPACITY_PARAMETER_NAME = "capacity";

    protected final int capacity;

    public AnyToAnyBlockingChannelWithCapacity(final JavaClassDataChannel dataChannel,
            final InterpreterDefaultContext context, final SchedulerModel model) {
        super(dataChannel, context, model);

        this.capacity = IndirectionSimulationUtil.getIntegerParameter(dataChannel, CAPACITY_PARAMETER_NAME);
    }

    @Override
    protected boolean canAcceptData(final DataChannelSinkConnector connector) {
        return this.data.size() < this.capacity;
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