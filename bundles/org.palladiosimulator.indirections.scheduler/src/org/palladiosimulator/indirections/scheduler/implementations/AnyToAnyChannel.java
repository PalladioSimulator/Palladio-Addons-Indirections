package org.palladiosimulator.indirections.scheduler.implementations;

import java.util.ArrayDeque;
import java.util.Queue;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

// simple resource that can take elements and provides them to whoever asks first.
// each element is provided exactly one time.
// consumers are blocked if no data is available
public abstract class AnyToAnyChannel extends AbstractSimDataChannelResource {
    protected final Queue<IndirectionDate> data;

    public AnyToAnyChannel(final JavaClassDataChannel dataChannel, final InterpreterDefaultContext context,
            final SchedulerModel model) {
        super(dataChannel, context, model);

        this.data = new ArrayDeque<>();
    }

    @Override
    protected void acceptData(final DataChannelSinkConnector connector, final IndirectionDate date) {
        this.data.add(date);
        this.notifyProcessesCanGetNewData();
    }

    @Override
    protected boolean canAcceptData(final DataChannelSinkConnector connector) {
        return true;
    }

    @Override
    protected boolean canProvideData(final DataChannelSourceConnector connector) {
        return this.data.size() > 0;
    }

    @Override
    protected void handleCannotProceedToPut(final ProcessWaitingToPut process) {
        throw new AssertionError("This should never happen.");
    }

    @Override
    protected void handleNewWatermarkedTime(final double oldSimulationTime, final double simulationTime) {
        // do nothing. everything will be emitted immediately
    }

    @Override
    protected IndirectionDate provideDataAndAdvance(final DataChannelSourceConnector connector) {
        return this.data.remove();
        // if the channel had a maximum capacity, we would call
        // notifyProcessesCanPutNewData();
    }

}