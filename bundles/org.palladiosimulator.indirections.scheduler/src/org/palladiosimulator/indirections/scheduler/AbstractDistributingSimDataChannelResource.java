package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.scheduler.DeprecatedSimDataChannelResource.KeyedFrame;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.util.IndirectionUtil;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class AbstractDistributingSimDataChannelResource implements IDataChannelResource {
    protected final Queue<ProcessWaitingToEmit> waitingToPutQueue;
    protected final List<KeyedFrame> incomingQueue;

    protected Map<DataChannelSinkConnector, OutgoingQueue> outgoingQueues;
    protected DataChannel dataChannel;
    protected SimuComModel model;

    protected final String name;
    protected final String id;
    protected final int capacity;

    protected class OutgoingQueue {
        public final Queue<Map<String, Object>> elements;
        public final Queue<ProcessWaitingToConsume> processes;

        public OutgoingQueue() {
            this.elements = new ArrayDeque<>();
            this.processes = new ArrayDeque<>();
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public AbstractDistributingSimDataChannelResource(final DataChannel dataChannel, final SchedulerModel model) {
        if (!(model instanceof SimuComModel)) {
            throw new IllegalArgumentException("Currently only works with " + SimuComModel.class.getName() + ", got "
                    + model.getClass().getName());
        }

        this.dataChannel = dataChannel;

        this.id = dataChannel.getId() + "_" + UUID.randomUUID().toString();
        this.name = dataChannel.getEntityName() + "_" + this.getClass().getSimpleName();

        this.capacity = dataChannel.getCapacity();

        this.model = (SimuComModel) model;

        this.waitingToPutQueue = new ArrayDeque<>();
        this.incomingQueue = new ArrayList<>();

        this.initializeOutgoingQueues();
    }

    private void initializeOutgoingQueues() {
        this.outgoingQueues = new HashMap<>();
        this.dataChannel.getDataChannelSinkConnector().stream()
                .forEach(it -> this.outgoingQueues.put(it, new OutgoingQueue()));
    }

    private void notifyProcessesWaitingToGet() {
        for (final OutgoingQueue queue : this.outgoingQueues.values()) {
            this.notifyProcesses(queue.processes, p -> p.schedulableProcess, this::canProceedToGet, this::allowToGet,
                    this::notifyProcessesWaitingToPut);
        }
    }

    private void notifyProcessesWaitingToPut() {
        this.notifyProcesses(this.waitingToPutQueue, p -> p.schedulableProcess, this::canProceedToPut, this::allowToPut,
                this::notifyProcessesWaitingToGet);
    }

    private <T> void notifyProcesses(final Queue<T> processes, final Function<T, ISchedulableProcess> processExtractor,
            final Predicate<T> canProceed, final Consumer<T> allow, final Runnable callAfterAllowing) {

        T waitingProcess = processes.peek();
        while (waitingProcess != null && canProceed.test(waitingProcess)) {
            allow.accept(waitingProcess);
            callAfterAllowing.run();
            processes.remove();
            waitingProcess = processes.peek();
        }
    }

    @Override
    public boolean put(final ISchedulableProcess schedulableProcess, final Map<String, Object> eventStackframe) {
        IndirectionUtil.validateStackframeStructure(eventStackframe, this.getIncomingParameterName());

        if (!this.model.getSimulationControl().isRunning()) {
            return true;
        }

        final ProcessWaitingToEmit process = new ProcessWaitingToEmit(this.model, schedulableProcess, eventStackframe);
        if (this.canProceedToPut(process)) {
            this.allowToPut(process);
            this.notifyProcessesWaitingToGet();
            return true;
        } else {
            this.waitingToPutQueue.add(process);
            process.passivate();
            return false;
        }
    }

    @Override
    public boolean get(final ISchedulableProcess schedulableProcess, final DataChannelSinkConnector sinkConnector,
            final Consumer<Map<String, Object>> callback) {
        if (!this.model.getSimulationControl().isRunning()) {
            return true;
        }

        if (sinkConnector.getDataSinkRole().isIsPushing()) {
            throw new IllegalStateException("Cannot pull data over pushing connector " + sinkConnector.toString()
                    + ", SinkRole: " + sinkConnector.getDataSinkRole().toString());
        }

        final ProcessWaitingToConsume process = new ProcessWaitingToConsume(this.model, schedulableProcess,
                sinkConnector, callback);
        if (this.canProceedToGet(process)) {
            this.allowToGet(process);
            this.notifyProcessesWaitingToPut();
            return true;
        } else {
            this.outgoingQueues.get(sinkConnector).processes.add(process);
            process.passivate();
            return false;
        }
    }

    private boolean canProceedToPut(final ProcessWaitingToEmit process) {
        final boolean isNextProcess = this.waitingToPutQueue.isEmpty()
                || this.waitingToPutQueue.peek().schedulableProcess.equals(process.schedulableProcess);
        if (this.capacity == -1) {
            return isNextProcess;
        } else {
            final long acceptableCount = this.capacity - this.incomingQueue.size();
            return isNextProcess && (acceptableCount > 0);
        }
    }

    private boolean canProceedToGet(final ProcessWaitingToConsume process) {
        final Queue<ProcessWaitingToConsume> waitingToGetQueue = this.outgoingQueues
                .get(process.sinkConnector).processes;
        final boolean isNextProcess = waitingToGetQueue.isEmpty()
                || waitingToGetQueue.peek().schedulableProcess.equals(process.schedulableProcess);
        final long providableCount = this.outgoingQueues.get(process.sinkConnector).elements.size();
        return isNextProcess && (providableCount > 0);
    }

    @Override
    public long getCapacity() {
        return this.capacity;
    }

    @Override
    public long getAvailable() {
        return this.capacity - this.incomingQueue.size();
    }

    protected abstract void allowToGet(ProcessWaitingToConsume process);

    protected abstract void allowToPut(ProcessWaitingToEmit process);

    protected String getOutgoingParameterName() {
        return IndirectionUtil.getOneParameter(this.dataChannel.getSourceEventGroup()).getParameterName();
    }

    protected String getIncomingParameterName() {
        return IndirectionUtil.getOneParameter(this.dataChannel.getSinkEventGroup()).getParameterName();
    }
}