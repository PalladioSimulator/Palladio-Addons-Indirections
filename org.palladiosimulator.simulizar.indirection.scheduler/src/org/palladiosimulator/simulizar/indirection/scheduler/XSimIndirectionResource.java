package org.palladiosimulator.simulizar.indirection.scheduler;

/**
 * See {@link SimSimpleFairPassiveResource}.
 * 
 * @author Dominik Werle
 */
public class XSimIndirectionResource { // extends AbstractSimResource implements IPassiveResource {
    /*protected Queue<IndirectionWaitingProcess> waitingToPollQueue;
    protected Queue<IndirectionWaitingProcess> waitingToOfferQueue;
    private final SchedulerModel myModel;
    private final String passiveResourceID;

    // provides observer functionality to this resource
    private final PassiveResourceObservee observee;
    private final Indirection resource;
    private final AssemblyContext assemblyContext;

    private final SimulatedQueue availableInformation;
    private final Set<Characteristic> characteristicSet;

    final class IndirectionWaitingProcess extends SchedulerEntity {
        public IndirectionWaitingProcess(ISchedulableProcess process, long minCount, long maxCount,
                SimulatedStack<Object> stack) {
            super(myModel, "IndirectionWaiting-" + passiveResourceID);
            this.process = process;
            this.minCount = minCount;
            this.maxCount = maxCount;
            this.stack = stack;
        }

        public final ISchedulableProcess process;
        public final long minCount;
        public final long maxCount;
        public final SimulatedStack<Object> stack;
    }

    public SimIndirectionResource(final Indirection resource, final AssemblyContext assemblyContext,
            final SchedulerModel model, final Long capacity) {
        super(model, capacity, resource.getEntityName(), resource.getId() + ":" + assemblyContext.getId());

        this.resource = resource;
        this.characteristicSet = Collections.unmodifiableSet(new HashSet<>(this.resource.getCharacteristics()));
        this.assemblyContext = assemblyContext;

        this.waitingToPollQueue = new ArrayDeque<IndirectionWaitingProcess>();
        this.waitingToOfferQueue = new ArrayDeque<IndirectionWaitingProcess>();

        this.myModel = model;
        this.passiveResourceID = resource.getId();
        this.observee = new PassiveResourceObservee();

        if (capacity != 0)
            throw new IllegalArgumentException("Capacities greater than 0 are not allowed (was " + capacity + ".");

        // TODO: change according to queueing discipline
        this.availableInformation = SimulatedQueueFactory.INSTANCE.createQueue(resource.getScheduling(),
                Math.toIntExact(capacity));
    }

    private boolean canProceedToPoll(final IndirectionWaitingProcess process, final long minimumCount,
            final long maximumCount) {
        boolean isNextProcess = waitingToPollQueue.isEmpty()
                || waitingToPollQueue.peek().process.equals(process.process);
        long providableCount = availableInformation.canProvideHowMany();
        return isNextProcess && (minimumCount <= providableCount && providableCount <= maximumCount);
    }

    private boolean canProceedToOffer(final IndirectionWaitingProcess process, final long minimumCount,
            final long maximumCount) {
        boolean isNextProcess = waitingToOfferQueue.isEmpty()
                || waitingToOfferQueue.peek().process.equals(process.process);
        long acceptableCount = availableInformation.canAcceptHowMany();
        return isNextProcess && (minimumCount <= acceptableCount && acceptableCount <= maximumCount);
    }

    @Override
    public PassiveResource getResource() {
        return this.resource;
    }
    
    // TODO: remove method #getResource in favor of this one (altogether remove supertype)
    public Indirection getIndirection() {
       return this.resource; 
    }

    @Override
    public AssemblyContext getAssemblyContext() {
        return this.assemblyContext;
    }

    @Override
    public Queue<IWaitingProcess> getWaitingProcesses() {
        Queue<IWaitingProcess> result = new ArrayDeque<IWaitingProcess>();
        waitingToPollQueue.forEach(it -> result.add(new SimpleWaitingProcess(this.myModel, it.process, -1L)));
        waitingToOfferQueue.forEach(it -> result.add(new SimpleWaitingProcess(this.myModel, it.process, -1L)));
        return result;
    }

    private void allowToPoll(SimulatedStack<Object> stack, final IndirectionWaitingProcess process,
            final long minimumCount, final long maximumCount) {
        LoggingWrapper.log("Process " + process + " polls " + minimumCount + "-" + maximumCount + " of " + this);
        long providableCount = availableInformation.canProvideHowMany();
        if (providableCount < minimumCount) {
            throw new IllegalStateException("Less resources available than planned");
        }

        long num = Math.min(providableCount, maximumCount);
        for (int i = 0; i < num; i++) {
            CharacteristicsContainer.getOrCreate(stack).add(availableInformation.pop());
        }
        observee.fireAquire(process.process, num);
        // assert availableToPoll() <= 0 : "More resource than available have been polled!";
        notifyProcessesWaitingToOffer();
    }

    private void allowToOffer(SimulatedStack<Object> stack, final IndirectionWaitingProcess process,
            final long minimumCount, final long maximumCount) {
        LoggingWrapper.log("Process " + process + " offers " + minimumCount + "-" + maximumCount + " of " + this);

        long acceptableCount = availableInformation.canAcceptHowMany();
        if (acceptableCount < minimumCount) {
            throw new IllegalStateException("Less resources acceptable than planned");
        }

        long num = Math.min(acceptableCount, maximumCount);

        for (int i = 0; i < num; i++) {
            availableInformation.push(CharacteristicsContainer.getOrCreate(stack).frames(characteristicSet).get(0));
        }
        observee.fireRelease(process.process, num);
        // assert availableToOffer() <= 0 : "More resource than available have been offered!";
        notifyProcessesWaitingToPoll();
    }

    public boolean poll(SimulatedStack<Object> stack, ISchedulableProcess schedulableProcess, final long minimumCount,
            final long maximumCount) {
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
        // observee.fireRequest(schedulableProcess, num);
        IndirectionWaitingProcess process = new IndirectionWaitingProcess(schedulableProcess, minimumCount,
                maximumCount, stack);
        if (canProceedToPoll(process, minimumCount, maximumCount)) {
            allowToPoll(stack, process, minimumCount, maximumCount);
            return true;
        } else {
            LoggingWrapper.log("Process " + schedulableProcess + " is waiting to poll " + minimumCount + "-"
                    + maximumCount + " from " + this);
            waitingToPollQueue.add(process);
            schedulableProcess.passivate();
            return false;
        }
    }

    public boolean peek(SimulatedStack<Object> stack, ISchedulableProcess schedulableProcess, final long minimumCount,
            final long maximumCount) {
        throw new IllegalStateException();
    }

    public boolean offer(SimulatedStack<Object> stack, ISchedulableProcess schedulableProcess, final long minimumCount,
            final long maximumCount) {
        // AM: Copied from AbstractActiveResource: If simulation is stopped,
        // allow all processes to finish
        if (!myModel.getSimulationControl().isRunning()) {
            // Do nothing, but allows calling process to complete
            return true;
        }

        final IndirectionWaitingProcess process = new IndirectionWaitingProcess(schedulableProcess, minimumCount,
                maximumCount, stack);
        if (canProceedToOffer(process, minimumCount, maximumCount)) {
            allowToOffer(stack, process, minimumCount, maximumCount);
            return true;
        } else {
            LoggingWrapper.log("Process " + schedulableProcess + " is waiting to offer " + minimumCount + "-"
                    + maximumCount + " to " + this);
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

    protected String getPassiveResourceID() {
        return passiveResourceID;
    }

    @Override
    public void release(final ISchedulableProcess schedulableProcess, final long num) {
        // very bad style. should be integrated more cleanly into the process.
        throw new IllegalStateException();
    }

    private void notifyProcessesWaitingToPoll() {
        notifyProcesses(waitingToPollQueue, it -> canProceedToPoll(it, it.minCount, it.maxCount),
                it -> allowToPoll(it.stack, it, it.minCount, it.maxCount));
    }

    private void notifyProcessesWaitingToOffer() {
        notifyProcesses(waitingToOfferQueue, it -> canProceedToOffer(it, it.minCount, it.maxCount),
                it -> allowToOffer(it.stack, it, it.minCount, it.maxCount));
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
        return availableInformation.canProvideHowMany();
    }*/
}