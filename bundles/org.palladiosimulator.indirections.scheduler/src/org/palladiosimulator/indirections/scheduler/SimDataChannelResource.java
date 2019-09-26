package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.DirectTransferOperator;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class SimDataChannelResource extends AbstractDistributingSimDataChannelResource {
    private Queue<IndirectionDate> dataQueue = new ArrayDeque<>();
    private Consumer<IndirectionDate> processor;

    public SimDataChannelResource(DataChannel dataChannel, InterpreterDefaultContext context, SchedulerModel model) {
        super(dataChannel, context, model);

        this.processor = new DirectTransferOperator<IndirectionDate>(List.of(this::emit));
    }

    private void emit(IndirectionDate date) {
        dataQueue.add(date);
        processDataAvailableToGet();
    }

    @Override
    protected boolean canAcceptDataFrom(ProcessWaitingToEmit process) {
        return true;
    }

    @Override
    protected boolean canProvideDataFor(ProcessWaitingToConsume process) {
        return !dataQueue.isEmpty();
    }

    @Override
    protected List<IndirectionDate> provideDataFor(ProcessWaitingToConsume process) {
        return Collections.singletonList(dataQueue.remove());
    }

    @Override
    protected void acceptDataFrom(ProcessWaitingToEmit process) {
        processor.accept(process.frame);
        processDataAvailableToGet();
    }
}
