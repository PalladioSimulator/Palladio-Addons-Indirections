package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.calculators.scheduler.ContextAwareTimeSpanCalculator;
import org.palladiosimulator.indirections.calculators.scheduler.TriggerableCountingCalculator;
import org.palladiosimulator.indirections.calculators.scheduler.TriggerableTimeSpanCalculator;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.scheduler.CallbackUserFactory.CallbackUser;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.scheduling.SuspendableSchedulerEntity;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.util.IndirectionModelUtil;
import org.palladiosimulator.indirections.util.StreamUtil;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitch;
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.resources.active.IResourceTableManager;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;

public abstract class AbstractSimDataChannelResource implements IDataChannelResource {
    protected TriggerableTimeSpanCalculator afterAcceptingAgeCalculator;
    protected TriggerableTimeSpanCalculator beforeProvidingAgeCalculator;
    private boolean canGetNewData = false;

    private boolean canPutNewData = false;
    protected InterpreterDefaultContext context;

    private double currentWatermarkedTime = Double.NEGATIVE_INFINITY;
    protected DataChannel dataChannel;

    protected TriggerableTimeSpanCalculator discardedAgeCalculator;
    protected String id;

    protected SimuComModel model;
    protected String name;

    protected TriggerableCountingCalculator numberOfDiscardedIncomingElementsCalculator;

    protected TriggerableCountingCalculator numberOfDiscardedOutgoingElementsCalculator;

    protected TriggerableCountingCalculator numberOfStoredIncomingElementsCalculator;

    protected TriggerableCountingCalculator numberOfStoredOutgoingElementsCalculator;

    private boolean postponeNotification = false;

    protected Map<DataSourceRole, Queue<ProcessWaitingToGet>> processesWaitingToGet;

    protected Map<DataSinkRole, Queue<ProcessWaitingToPut>> processesWaitingToPut;

    private PeriodicallyTriggeredSimulationEntity scheduledFlush;

    private Map<DataSourceRole, CallbackUserFactory> sourceRoleUserFactories = new HashMap<>();
    protected ContextAwareTimeSpanCalculator<ProcessWaitingToGet> waitingToGetTimeCalculator;
    protected ContextAwareTimeSpanCalculator<ProcessWaitingToPut> waitingToPutTimeCalculator;
    private Allocation allocation;

    protected final IResourceTableManager resourceTableManager;
    protected final AssemblyContext assemblyContext;
    protected final RepositoryComponentSwitch.Factory repositoryComponentSwitchFactory;
	protected final InterpreterDefaultContext mainContext;

    public AbstractSimDataChannelResource(DataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext context, SchedulerModel model,
            RepositoryComponentSwitch.Factory repositoryComponentSwitchFactory,
            InterpreterDefaultContext mainContext) {
        if (!(model instanceof SimuComModel)) {
            throw new IllegalArgumentException(
                    "Currently only works with " + SimuComModel.class.getName() + ", got " + model.getClass()
                        .getName());
        }

        this.dataChannel = dataChannel;
        this.assemblyContext = assemblyContext;

        this.id = dataChannel.getId() + "_" + UUID.randomUUID()
            .toString();
        this.name = dataChannel.getEntityName() + "_" + this.getClass()
            .getSimpleName();

        this.model = (SimuComModel) model;
        this.context = context;
        this.mainContext = mainContext;

       
        this.allocation = context.getLocalPCMModelAtContextCreation()
            .getAllocation();

        this.resourceTableManager = context.getResourceTableManager();
        this.repositoryComponentSwitchFactory = repositoryComponentSwitchFactory;
        
        this.initializeQueues();
        this.createPushingUserFactories();

        this.setupCalculators();
    }

    protected abstract void acceptData(DataSinkRole role, IndirectionDate date);

    private void activateIfWaiting(SuspendableSchedulerEntity process) {
        if (process.isWaiting()) {
            process.activate();
        }
    }

    @Override
    public void advance(double watermarkTime) {
        var oldWatermarkTime = watermarkTime;
        if (watermarkTime < this.currentWatermarkedTime) {
            System.out
                .println("Not advancing backward. Requested: " + this.currentWatermarkedTime + " to " + watermarkTime);
            return;
        }

        this.currentWatermarkedTime = watermarkTime;

        this.handleNewWatermarkedTime(oldWatermarkTime, watermarkTime);
    }

    private void allowToGetAndActivate(ProcessWaitingToGet process) {
        this.collectAndPostponeNotification(() -> {
            this.waitingToGetTimeCalculator.endMeasurement(process);

            this.numberOfStoredOutgoingElementsCalculator.change(1);

            this.provideDataAndAdvance(process.role, (providedData) -> {
                providedData.getTime()
                    .forEach(this.beforeProvidingAgeCalculator::doMeasureUntilNow);
                process.callback.accept(providedData);
    
                this.activateIfWaiting(process);
            });
        });
    }

    private void allowToPutAndActivate(ProcessWaitingToPut process) {
        this.collectAndPostponeNotification(() -> {
            this.waitingToPutTimeCalculator.endMeasurement(process);

            this.numberOfStoredIncomingElementsCalculator.change(1);
            this.acceptData(process.role, process.date);

            process.date.getTime()
                .forEach(this.afterAcceptingAgeCalculator::doMeasureUntilNow);

            this.activateIfWaiting(process);
        });
    }

    protected void blockUntilCanGet(ProcessWaitingToGet process) {
        this.processesWaitingToGet.get(process.role)
            .add(process);
        process.passivate();
    }

    protected void blockUntilCanPut(ProcessWaitingToPut process) {
        this.processesWaitingToPut.get(process.role)
            .add(process);
        process.passivate();
    }

    protected abstract boolean canAcceptData(DataSinkRole role);

    private boolean canProceedToGet(ProcessWaitingToGet process) {
        DataSourceRole role = process.role;

        Queue<ProcessWaitingToGet> processQueue = this.processesWaitingToGet.get(role);
        boolean isNextProcess = processQueue.isEmpty()
                || processQueue.peek().schedulableProcess.equals(process.schedulableProcess);

        return isNextProcess && this.canProvideData(role);
    }

    private boolean canProceedToPut(ProcessWaitingToPut process) {
        DataSinkRole role = process.role;

        Queue<ProcessWaitingToPut> processQueue = this.processesWaitingToPut.get(role);
        boolean isNextProcess = processQueue.isEmpty()
                || processQueue.peek().schedulableProcess.equals(process.schedulableProcess);

        return isNextProcess && this.canAcceptData(role);
    }

    protected abstract boolean canProvideData(DataSourceRole role);

    /**
     * Sets a flag to collect notification information, runs the given block and afterwards checks
     * whether new data is available and acts accordingly.
     *
     * @param block
     */
    private void collectAndPostponeNotification(Runnable block) {
        var initialPostponeState = this.postponeNotification;
        this.postponeNotification = true;
        block.run();
        this.postponeNotification = initialPostponeState;
        this.handleNotifications();
    }

    protected void continueWithoutData(ProcessWaitingToGet process) {
        // this does not put data on the stack (i.e., does not call the callback)
        this.waitingToGetTimeCalculator.endMeasurement(process);
        this.activateIfWaiting(process);
    }

    private void createPushingUserFactories() {
        if (!this.sourceRoleUserFactories.isEmpty()) {
            throw new IllegalStateException("User factories already created.");
        }

        for (DataSourceRole sourceRole : dataChannel.getDataSourceRoles()) {
            var assemblyDataConnector = IndirectionModelUtil.getExactlyOneAssemblyDataConnector(assemblyContext,
                    sourceRole);
            var sinkRole = assemblyDataConnector.getDataSinkRole();

            this.sourceRoleUserFactories.put(sourceRole,
                    CallbackUserFactory.createPushingUserFactory(this.model, sourceRole, sinkRole,
                            assemblyDataConnector.getSinkAssemblyContext(), resourceTableManager,
                            repositoryComponentSwitchFactory));
        }
    }

    protected void discardDataAndContinue(ProcessWaitingToPut process) {
        this.waitingToPutTimeCalculator.endMeasurement(process);

        IndirectionDate dateToDiscard = process.date;
        discardIncomingDate(dateToDiscard);

        this.activateIfWaiting(process);
    }

    protected void discardIncomingDate(IndirectionDate dateToDiscard) {
        dateToDiscard.getTime()
            .forEach(this.discardedAgeCalculator::doMeasureUntilNow);

        this.numberOfDiscardedIncomingElementsCalculator.change(1);
    }

    /**
     * If so, this method returns true and measurements about the discarding are recorded.
     */
    protected boolean discardDateIfTooOld(IndirectionDate dateToDiscard) {
        if (isDateTooOld(dateToDiscard)) {
            numberOfDiscardedOutgoingElementsCalculator.change(1);
            discardIncomingDate(dateToDiscard);
            return true;
        }
        return false;
    }

    
    /**
     * Finds out whether ALL data in dateToDiscard is too old for this channel.
     */
    protected boolean isDateTooOld(IndirectionDate date) {
        return date.getTime()
            .stream()
            .allMatch(it -> it < currentWatermarkedTime);
    }

    /**
     * Schedules the given demand on the given resource type. This postpones the continued
     * execution.
     * 
     * <p>
     * 
     * The demand is scheduled on the resource this data channel is allocated on.
     * 
     * <p>
     * 
     * @param resourceType
     *            the type of resource
     * @param demandSpecification
     *            a StoEx as String
     */
    protected void scheduleDemand(String resourceTypeId, String demandSpecification, IndirectionDate date,
            Consumer<IndirectionDate> andThen) {

        AllocationContext allocationContext = allocation.getAllocationContexts_Allocation()
            .stream()
            .filter(it -> it.getAssemblyContext_AllocationContext()
                .getEncapsulatedComponent__AssemblyContext()
                .equals(this.dataChannel))
            .reduce(StreamUtil.reduceToMaximumOne())
            .orElseThrow(() -> new PCMModelInterpreterException("No data channel allocation found."));

        ResourceContainer resourceContainer = allocationContext.getResourceContainer_AllocationContext();

        throw new PCMModelInterpreterException("Resource demands are currently not supported.");
        /*
         * new SimuComSimProcess(model, this.id + "-DemandContinuation") {
         * 
         * @Override protected void internalLifeCycle() { // might be necessary to also consider
         * variables from data channel. Double demand = (Double) date.evaluate(demandSpecification);
         * 
         * model.getResourceRegistry() .getResourceContainer(resourceContainer.getId())
         * .loadActiveResource(this, resourceTypeId, demand);
         * 
         * andThen.run(); } }.scheduleAt(0);
         */
    }

    @Override
    public boolean get(ISchedulableProcess schedulableProcess, DataSourceRole role,
            Consumer<IndirectionDate> callback) {
        if (!isSimulationRunning()) {
            return true;
        }

        if (isPushingRole(role)) {
            throw new IllegalStateException("Cannot pull data over pushing role.");
        }

        ProcessWaitingToGet process = new ProcessWaitingToGet(this.model, schedulableProcess, role, callback);

        this.waitingToGetTimeCalculator.startMeasurement(process);

        if (this.canProceedToGet(process)) {
            this.allowToGetAndActivate(process);
            return true;
        } else {
            this.handleCannotProceedToGet(process);
            return false;
        }
    }

    abstract protected boolean isPushingRole(DataSourceRole role);

    private boolean isSimulationRunning() {
        ISimulationControl simulationControl = this.model.getSimulationControl();
        return simulationControl.isRunning();
    }

    public double getCurrentWatermarkedTime() {
        return this.currentWatermarkedTime;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    /* might be sensible to default this to blockUntilCanGet */
    protected abstract void handleCannotProceedToGet(ProcessWaitingToGet process);

    /* might be sensible to default this to blockUntilCanPut */
    protected abstract void handleCannotProceedToPut(ProcessWaitingToPut process);

    protected abstract void handleNewWatermarkedTime(double oldWatermarkTime, double watermarkTime);

    private void handleNotifications() {
        if (!this.postponeNotification) {
            if (this.canGetNewData) {
                this.canGetNewData = false;
                this.processDataAvailableToGet();
            }
            if (this.canPutNewData) {
                this.canPutNewData = false;
                this.notifyProcessesWaitingToPut();
            }
        }
    }

    private void initializeQueues() {
        this.processesWaitingToGet = new HashMap<>();
        for (DataSourceRole role : this.dataChannel.getDataSourceRoles()) {
            this.processesWaitingToGet.put(role, new ArrayDeque<>());
        }

        this.processesWaitingToPut = new HashMap<>();
        for (DataSinkRole role : this.dataChannel.getDataSinkRoles()) {
            this.processesWaitingToPut.put(role, new ArrayDeque<>());
        }
    }

    protected void notifyProcessesCanGetNewData() {
        this.canGetNewData = true;
        this.handleNotifications();
    }

    protected void notifyProcessesCanPutNewData() {
        this.canPutNewData = true;
        this.handleNotifications();
    }

    private void notifyProcessesWaitingToGet() {
        for (var entry : this.processesWaitingToGet.entrySet()) {
            var processes = entry.getValue();

            ProcessWaitingToGet waitingProcess = processes.peek();
            while (waitingProcess != null && this.canProceedToGet(waitingProcess)) {
                this.allowToGetAndActivate(waitingProcess);
                processes.remove();
                waitingProcess = processes.peek();
            }
        }
    }

    private void notifyProcessesWaitingToPut() {
        for (var entry : this.processesWaitingToPut.entrySet()) {
            var processes = entry.getValue();

            ProcessWaitingToPut waitingProcess = processes.peek();
            while (waitingProcess != null && this.canProceedToPut(waitingProcess)) {
                this.allowToPutAndActivate(waitingProcess);
                processes.remove();
                waitingProcess = processes.peek();
            }
        }
    }

    protected void processDataAvailableToGet() {
        boolean shouldNotifyProcessesWaitingToGet = false; // we only need to call this once
        for (DataSourceRole role : dataChannel.getDataSourceRoles()) {
            if (isPushingRole(role)) {
                while (this.canProvideData(role)) {
                    // the method directly takes the data, thus it should not be an infinite loop
                    this.spawnNewConsumerUser(role);
                }
            } else {
                shouldNotifyProcessesWaitingToGet = true;
            }
        }

        if (shouldNotifyProcessesWaitingToGet) {
            this.notifyProcessesWaitingToGet();
        }
    }

    /**
     * It must hold that {@link #provideDataAndAdvance(DataChannelSourceConnector)} can be called
     * iff {@link #canProvideData(DataChannelSourceConnector)} was true immediately before the call.
     * <p>
     * Calling {@link #provideDataAndAdvance(DataChannelSourceConnector)} in a loop must eventually
     * lead to {@link #canProvideData(DataChannelSourceConnector)} returning {@code false}.
     */
    protected abstract void provideDataAndAdvance(DataSourceRole role, Consumer<IndirectionDate> continuation);

    @Override
    public boolean put(ISchedulableProcess schedulableProcess, DataSinkRole role, IndirectionDate date) {
        IndirectionSimulationUtil.validateIndirectionDateStructure(date, role.getDataInterface());

        if (!isSimulationRunning()) {
            return true;
        }

        ProcessWaitingToPut process = new ProcessWaitingToPut(this.model, schedulableProcess, role, date);

        this.waitingToPutTimeCalculator.startMeasurement(process);

        if (this.canProceedToPut(process)) {
            this.allowToPutAndActivate(process);
            return true;
        } else {
            this.handleCannotProceedToPut(process);
            return false;
        }
    }

    protected void scheduleAdvance(double firstOccurence, double delay, double lagBehindRealTime) {
        if (this.scheduledFlush != null) {
            throw new PCMModelInterpreterException("Cannot schedule advance for " + this + ", already scheduled.");
        }

        this.scheduledFlush = IndirectionSimulationUtil.triggerPeriodically(this.model, firstOccurence + lagBehindRealTime, delay, () -> {
            this.advance(this.model.getSimulationControl()
                .getCurrentSimulationTime() - lagBehindRealTime);
        });
    }

    private void setupCalculators() {
        this.setupSourceCalculators();
        this.setupSinkCalculators();
    }

    private void setupSinkCalculators() {
        this.afterAcceptingAgeCalculator = new TriggerableTimeSpanCalculator(
                "Data age after accepting date (" + this.name + ")",
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, this.mainContext);
        this.waitingToPutTimeCalculator = new ContextAwareTimeSpanCalculator<ProcessWaitingToPut>(
                "Waiting time to put (" + this.name + ")", MetricDescriptionConstants.WAITING_TIME_METRIC,
                MetricDescriptionConstants.WAITING_TIME_METRIC_TUPLE, this.mainContext);
        this.numberOfDiscardedOutgoingElementsCalculator = new TriggerableCountingCalculator(
                "Discarded outgoing elements (" + this.name + ")",
                "Total discarded outgoing elements (" + this.name + ")",
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC,
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC_TUPLE,
                IndirectionsMetricDescriptionConstants.TOTAL_NUMBER_OF_ELEMENTS_METRIC_TUPLE, this.mainContext);
        this.numberOfStoredOutgoingElementsCalculator = new TriggerableCountingCalculator(
                "Stored outgoing elements (" + this.name + ")", "Total stored outgoing elements (" + this.name + ")",
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC,
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC_TUPLE,
                IndirectionsMetricDescriptionConstants.TOTAL_NUMBER_OF_ELEMENTS_METRIC_TUPLE, this.mainContext);
    }

    private void setupSourceCalculators() {
        this.beforeProvidingAgeCalculator = new TriggerableTimeSpanCalculator(
                "Data age before providing (" + this.name + ")", IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, this.mainContext);
        this.waitingToGetTimeCalculator = new ContextAwareTimeSpanCalculator<ProcessWaitingToGet>(
                "Waiting time to get (" + this.name + ")", MetricDescriptionConstants.WAITING_TIME_METRIC,
                MetricDescriptionConstants.WAITING_TIME_METRIC_TUPLE, this.mainContext);
        this.numberOfDiscardedIncomingElementsCalculator = new TriggerableCountingCalculator(
                "Discarded incoming elements (" + this.name + ")",
                "Total discarded incoming elements (" + this.name + ")",
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC,
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC_TUPLE,
                IndirectionsMetricDescriptionConstants.TOTAL_NUMBER_OF_ELEMENTS_METRIC_TUPLE, this.mainContext);
        this.discardedAgeCalculator = new TriggerableTimeSpanCalculator(
                "Data age before discarding (" + this.name + ")",
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, this.mainContext);
        this.numberOfStoredIncomingElementsCalculator = new TriggerableCountingCalculator(
                "Stored incoming elements (" + this.name + ")", "Total stored incoming elements (" + this.name + ")",
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC,
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC_TUPLE,
                IndirectionsMetricDescriptionConstants.TOTAL_NUMBER_OF_ELEMENTS_METRIC_TUPLE, this.mainContext);
    }

    private void spawnNewConsumerUser(DataSourceRole role) {
        provideDataAndAdvance(role, (date) -> {
            date.getTime()
                .forEach(this.beforeProvidingAgeCalculator::doMeasureUntilNow);
    
            String parameterName = role.getDataInterface()
                .getDataSignature()
                .getParameter()
                .getParameterName();
    
            CallbackUser user = this.sourceRoleUserFactories.get(role)
                .createUser();
    
            InterpreterDefaultContext newContext = InterpreterDefaultContext.createChildContext(mainContext, user);
           
    
            this.numberOfStoredOutgoingElementsCalculator.change(1);
            user.setDataAndStartUserLife(parameterName, date, newContext);
        });
    }

    protected void unscheduleAdvance() {
        if (this.scheduledFlush != null) {
            throw new PCMModelInterpreterException("Cannot unschedule advance for " + this + ", not scheduled.");
        }

        this.scheduledFlush.stopScheduling();
        this.scheduledFlush = null;
    }

}
