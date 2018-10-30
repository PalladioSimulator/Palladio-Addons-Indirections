package org.palladiosimulator.simulizar.indirection.resources;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.PassiveResource;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.processes.IWaitingProcess;
import de.uka.ipd.sdq.scheduler.processes.SimpleWaitingProcess;
import de.uka.ipd.sdq.scheduler.resources.AbstractSimResource;
import de.uka.ipd.sdq.scheduler.resources.passive.PassiveResourceObservee;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;
import de.uka.ipd.sdq.simucomframework.resources.SimSimpleFairPassiveResource;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStack;

/**
 * See {@link SimSimpleFairPassiveResource}.
 * 
 * @author Dominik Werle
 */
public class SimIndirectionResource extends AbstractSimResource implements IPassiveResource {
    public final static String CHARACTERISTIC_PREFIX = "__CR__";

    protected Queue<IWaitingProcessAndStack> waitingQueue;
    private final SchedulerModel myModel;
    private final String passiveResourceID;

    // provides observer functionality to this resource
    private final PassiveResourceObservee observee;
    private final PassiveResource resource;
    private final AssemblyContext assemblyContext;

    // we currently do not use a more specific collection, because
    // the discipline can change in the future or be customizable.
    private final SimulatedQueue<List<Map<String, Object>>> availableInformation;

    private final static class IWaitingProcessAndStack {
        public final IWaitingProcess process;
        public final SimulatedStack<Object> stack;

        public IWaitingProcessAndStack(IWaitingProcess process, SimulatedStack<Object> stack) {
            this.process = process;
            this.stack = stack;
        }
    }

    public SimIndirectionResource(final PassiveResource resource, final AssemblyContext assemblyContext,
            final SchedulerModel model, final Long capacity) {
        super(model, capacity, resource.getEntityName(), resource.getId() + ":" + assemblyContext.getId());
        this.resource = resource;
        this.assemblyContext = assemblyContext;

        this.waitingQueue = new ArrayDeque<IWaitingProcessAndStack>();
        this.myModel = model;
        this.passiveResourceID = resource.getId();
        this.observee = new PassiveResourceObservee();

        if (capacity != 0)
            throw new IllegalArgumentException("Capacities greater than 0 are not allowed (was " + capacity + ".");

        // TODO: change according to queueing discipline
        this.availableInformation = new FairSimulatedQueue<List<Map<String, Object>>>();
    }

    private int available() {
        return this.availableInformation.size();
    }

    private List<Map<String, Object>> findCharacteristics(SimulatedStack<Object> stack) {
        try {
            List<Map<String, Object>> contents = (List<Map<String, Object>>) stack.rootFrame()
                    .getValue(CHARACTERISTIC_PREFIX);
            return deepCopy(contents);
        } catch (ValueNotInFrameException e) {
            throw new IllegalStateException("No characteristics found.");
        }
    }

    private List<Map<String, Object>> deepCopy(List<Map<String, Object>> contents) {
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, Object> c : contents) {
            result.add(new HashMap<String, Object>(c));
        }
        return result;
    }

    private void addInformationToStack(List<Map<String, Object>> info, SimulatedStack<Object> stack) {
        List<Map<String, Object>> contents;
        try {
            contents = (List<Map<String, Object>>) stack.rootFrame().getValue(CHARACTERISTIC_PREFIX);
        } catch (ValueNotInFrameException e) {
            throw new IllegalStateException("No characteristics found.");
        }
        contents.addAll(deepCopy(info));
    }

    // TODO: depends on queueing strategy
    private List<Map<String, Object>> removeInformation() {
        return availableInformation.pop();
    }

    // TODO: depends on queueing strategy
    private void addInformation(SimulatedStack<Object> stack) {
        List<Map<String, Object>> characteristics = findCharacteristics(stack);
        availableInformation.push(deepCopy(characteristics));
    }

    private boolean canProceed(final ISchedulableProcess process, final long num) {
        return (waitingQueue.isEmpty() || waitingQueue.peek().process.getProcess().equals(process))
                && num <= available();
    }

    private final static Pattern ACQUIRE_PATTERN = Pattern.compile("ACQUIRE_(\\d+)");
    private final static Pattern RELEASE_PATTERN = Pattern.compile("RELEASE_(\\d+)");

    private int getAcquireCount() {
        Matcher matcher = ACQUIRE_PATTERN.matcher(this.resource.getEntityName());
        if (matcher.find()) {
            return Integer.valueOf(matcher.group(1));
        }
        return 1;
    }

    private int getReleaseCount() {
        Matcher matcher = RELEASE_PATTERN.matcher(this.resource.getEntityName());
        if (matcher.find()) {
            return Integer.valueOf(matcher.group(1));
        }
        return 1;

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
        waitingQueue.forEach(it -> result.add(it.process));
        return result;
    }

    private void grantAccess(SimulatedStack<Object> stack, final ISchedulableProcess process, final long num) {
        LoggingWrapper.log("Process " + process + " acquires " + num + " of " + this);
        for (int i = 0; i < num; i++) {
            List<Map<String, Object>> info = removeInformation();
            addInformationToStack(info, stack);
        }
        observee.fireAquire(process, num);
        assert available() >= 0 : "More resource than available have been acquired!";
    }

    /**
     * replacement for release. this is very dirty and should not be one like this (see: refused
     * bequest, knows of derived, etc.)
     */

    public boolean acquireInContext(SimulatedStack<Object> stack, ISchedulableProcess schedulableProcess) {
        int num = getAcquireCount();
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
        observee.fireRequest(schedulableProcess, num);
        if (canProceed(schedulableProcess, num)) {
            grantAccess(stack, schedulableProcess, num);
            return true;
        } else {
            LoggingWrapper.log("Process " + schedulableProcess + " is waiting for " + num + " of " + this);
            final SimpleWaitingProcess process = new SimpleWaitingProcess(myModel, schedulableProcess, num);
            waitingQueue.add(new IWaitingProcessAndStack(process, stack));
            schedulableProcess.passivate();
            return false;
        }
    }

    /**
     * replacement for release. this is very dirty and should not be one like this (see: refused
     * bequest, knows of derived, etc.)
     */
    public void releaseInContext(SimulatedStack<Object> stack, ISchedulableProcess schedulableProcess) {
        int num = getReleaseCount();
        // AM: Copied from AbstractActiveResource: If simulation is stopped,
        // allow all processes to finish
        if (!myModel.getSimulationControl().isRunning()) {
            // Do nothing, but allows calling process to complete
            return;
        }

        LoggingWrapper.log("Process " + schedulableProcess + " releases " + num + " of " + this);
        for (int i = 0; i < num; i++) {
            this.addInformation(stack);
        }
        observee.fireRelease(schedulableProcess, num);
        notifyWaitingProcesses();
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

    private void notifyWaitingProcesses() {
        IWaitingProcessAndStack waitingProcessAndStack = waitingQueue.peek();
        SimpleWaitingProcess waitingProcess = waitingProcessAndStack == null ? null
                : (SimpleWaitingProcess) waitingProcessAndStack.process;
        while (waitingProcess != null && canProceed(waitingProcess.getProcess(), waitingProcess.getNumRequested())) {
            grantAccess(waitingProcessAndStack.stack, waitingProcess.getProcess(), waitingProcess.getNumRequested());
            waitingQueue.remove();
            waitingProcess.getProcess().activate();

            waitingProcessAndStack = waitingQueue.peek();
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
        return available();
    }
}