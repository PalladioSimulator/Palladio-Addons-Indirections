package org.palladiosimulator.simulizar.indirection.resources;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.simulizar.indirection.characteristics.Characteristic;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.entities.SchedulerEntity;
import de.uka.ipd.sdq.scheduler.processes.IWaitingProcess;
import de.uka.ipd.sdq.scheduler.processes.SimpleWaitingProcess;
import de.uka.ipd.sdq.scheduler.resources.AbstractSimResource;
import de.uka.ipd.sdq.scheduler.resources.passive.PassiveResourceObservee;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;
import de.uka.ipd.sdq.simucomframework.resources.SimSimpleFairPassiveResource;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStack;

/**
 * See {@link SimSimpleFairPassiveResource}.
 * 
 * @author Dominik Werle
 */
public class SimIndirectionResource extends AbstractSimResource implements IPassiveResource {
    protected Queue<IndirectionWaitingProcess> waitingToPollQueue;
    protected Queue<IndirectionWaitingProcess> waitingToOfferQueue;
    private final SchedulerModel myModel;
    private final String passiveResourceID;

    // provides observer functionality to this resource
    private final PassiveResourceObservee observee;
    private final PassiveResource resource;
    private final AssemblyContext assemblyContext;

    private final SimulatedQueue<Frame> availableInformation;

    final class IndirectionWaitingProcess extends SchedulerEntity {
        public IndirectionWaitingProcess(ISchedulableProcess process, Characteristic characteristic, long num,
                SimulatedStack<Object> stack) {
            super(myModel, "IndirectionWaiting-" + passiveResourceID);
            this.process = process;
            this.characteristic = characteristic;
            this.num = num;
            this.stack = stack;
        }

        public final ISchedulableProcess process;
        public final Characteristic characteristic;
        public final long num;
        public final SimulatedStack<Object> stack;
    }

    public SimIndirectionResource(final PassiveResource resource, final AssemblyContext assemblyContext,
            final SchedulerModel model, final Long capacity) {
        super(model, capacity, resource.getEntityName(), resource.getId() + ":" + assemblyContext.getId());

        this.resource = resource;
        this.assemblyContext = assemblyContext;

        this.waitingToPollQueue = new ArrayDeque<IndirectionWaitingProcess>();
        this.waitingToOfferQueue = new ArrayDeque<IndirectionWaitingProcess>();
        
        this.myModel = model;
        this.passiveResourceID = resource.getId();
        this.observee = new PassiveResourceObservee();

        if (capacity != 0)
            throw new IllegalArgumentException("Capacities greater than 0 are not allowed (was " + capacity + ".");

        // TODO: change according to queueing discipline
        this.availableInformation = new FairSimulatedQueue<Frame>();
    }

    private int availableToPoll() {
        return this.availableInformation.size();
    }

    private int availableToOffer() {
        return Math.toIntExact(this.capacity - this.availableInformation.size());
    }

    private boolean canProceedToPoll(final ISchedulableProcess process, final long num) {
        return (waitingToPollQueue.isEmpty() || waitingToPollQueue.peek().process.equals(process))
                && num <= availableToPoll();
    }

    private boolean canProceedToOffer(final ISchedulableProcess process, final long num) {
        return (waitingToOfferQueue.isEmpty() || waitingToOfferQueue.peek().process.equals(process))
                && num <= availableToOffer();
    }

    @Override
    public PassiveResource getResource() {
        return this.resource;
    }

    @Override
    public AssemblyContext getAssemblyContext() {
        return this.assemblyContext;
    }

    @Override
    public Queue<IWaitingProcess> getWaitingProcesses() {
        Queue<IWaitingProcess> result = new ArrayDeque<IWaitingProcess>();
        waitingToPollQueue.forEach(it -> result.add(new SimpleWaitingProcess(this.myModel, it.process, it.num)));
        waitingToOfferQueue.forEach(it -> result.add(new SimpleWaitingProcess(this.myModel, it.process, it.num)));
        return result;
    }

    private void allowToPoll(SimulatedStack<Object> stack, final ISchedulableProcess process,
            Characteristic characteristic, final long num) {
        LoggingWrapper.log("Process " + process + " polls " + num + " of " + this);
        for (int i = 0; i < num; i++) {
            CharacteristicsContainer.find(stack).add(availableInformation.pop());
        }
        observee.fireAquire(process, num);
        assert availableToPoll() <= 0 : "More resource than available have been polled!";
        notifyProcessesWaitingToOffer();
    }

    private void allowToOffer(SimulatedStack<Object> stack, final ISchedulableProcess process,
            Characteristic characteristic, final long num) {
        LoggingWrapper.log("Process " + process + " offers " + num + " of " + this);
        for (int i = 0; i < num; i++) {
            availableInformation.push(CharacteristicsContainer.find(stack).frames(characteristic).get(0));
        }
        observee.fireRelease(process, num);
        assert availableToOffer() <= 0 : "More resource than available have been offered!";
        notifyProcessesWaitingToPoll();
    }


    private boolean tryIndirectionOrPassivate() {
        return false;
    }
    
    /**
     * replacement for release. this is very dirty and should not be one like this (see: refused
     * bequest, knows of derived, etc.)
     */
    public boolean poll(SimulatedStack<Object> stack, ISchedulableProcess schedulableProcess,
            Characteristic characteristic, final long num) {
        // AM: Copied from AbstractActiveResource: If simulation is stopped,
        // allow all processes to finish
        if (!myModel.getSimulationControl().isRunning()) {
            // Do nothing, but allows calling process to complete
            return true;
        }
        // TODO
        // Do we need some logic here to check if the simulation has stopped?
        // In this case, this method should not block, but return in order to
        // allow processes to complete
//        observee.fireRequest(schedulableProcess, num);
        if (canProceedToPoll(schedulableProcess, num)) {
            allowToPoll(stack, schedulableProcess, characteristic, num);
            return true;
        } else {
            LoggingWrapper.log("Process " + schedulableProcess + " is waiting to poll " + num + " of " + characteristic
                    + " from " + this);
            IndirectionWaitingProcess process = new IndirectionWaitingProcess(schedulableProcess, characteristic, num,
                    stack);
            waitingToPollQueue.add(process);
            schedulableProcess.passivate();
            return false;
        }
    }

    /**
     * replacement for release. this is very dirty and should not be done like this (see: refused
     * bequest, knows of derived, etc.)
     */
    public boolean offer(SimulatedStack<Object> stack, ISchedulableProcess schedulableProcess,
            Characteristic characteristic, long num) {
        // AM: Copied from AbstractActiveResource: If simulation is stopped,
        // allow all processes to finish
        if (!myModel.getSimulationControl().isRunning()) {
            // Do nothing, but allows calling process to complete
            return true;
        }

        if (canProceedToOffer(schedulableProcess, num)) {
            allowToOffer(stack, schedulableProcess, characteristic, num);
            return true;
        } else {
            LoggingWrapper.log("Process " + schedulableProcess + " is waiting to offer " + num + " of " + characteristic
                    + " to " + this);
            final IndirectionWaitingProcess process = new IndirectionWaitingProcess(schedulableProcess, characteristic,
                    num, stack);
            waitingToPollQueue.add(process);
            schedulableProcess.passivate();
            return false;
        }
    }

    @Override
    public boolean acquire(final ISchedulableProcess schedulableProcess, final long num, final boolean timeout,
            final double timeoutValue) {
        // very bad style. should be integrated more cleanly into the process.
        throw new IllegalStateException();
    }

    /**
     * Retrieves the passive resource ID.
     *
     * @return the passive resource ID
     */
    protected String getPassiveResourceID() {
        return passiveResourceID;
    }

    @Override
    public void release(final ISchedulableProcess schedulableProcess, final long num) {
        // very bad style. should be integrated more cleanly into the process.
        throw new IllegalStateException();
    }

    private void notifyProcessesWaitingToPoll() {
        notifyProcesses(waitingToPollQueue, it -> canProceedToPoll(it.process, it.num),
                it -> allowToPoll(it.stack, it.process, it.characteristic, it.num));
    }

    private void notifyProcessesWaitingToOffer() {
        notifyProcesses(waitingToOfferQueue, it -> canProceedToOffer(it.process, it.num),
                it -> allowToOffer(it.stack, it.process, it.characteristic, it.num));
    }

    private void notifyProcesses(Queue<IndirectionWaitingProcess> processes,
            Predicate<IndirectionWaitingProcess> canProceed, Consumer<IndirectionWaitingProcess> allow) {
        IndirectionWaitingProcess waitingProcessAndStack = processes.peek();
        SimpleWaitingProcess waitingProcess = waitingProcessAndStack == null ? null
                : (SimpleWaitingProcess) waitingProcessAndStack.process;
        while (waitingProcess != null && canProceed.test(waitingProcessAndStack)) {
            allow.accept(waitingProcessAndStack);
            processes.remove();
            waitingProcess.getProcess().activate();

            waitingProcessAndStack = processes.peek();
            waitingProcess = waitingProcessAndStack == null ? null
                    : (SimpleWaitingProcess) waitingProcessAndStack.process;
        }
    }

    @Override
    public void addObserver(final IPassiveResourceSensor observer) {
        observee.addObserver(observer);
    }

    @Override
    public void removeObserver(final IPassiveResourceSensor observer) {
        observee.removeObserver(observer);
    }

    @Override
    public long getAvailable() {
        return availableToPoll();
    }
}