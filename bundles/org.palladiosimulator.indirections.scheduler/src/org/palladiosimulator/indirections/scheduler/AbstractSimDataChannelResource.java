package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.calculators.scheduler.ContextAwareTimeSpanCalculator;
import org.palladiosimulator.indirections.calculators.scheduler.TriggerableCountingCalculator;
import org.palladiosimulator.indirections.calculators.scheduler.TriggerableTimeSpanCalculator;
import org.palladiosimulator.indirections.composition.DataChannelToAssemblyContextConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.scheduler.CallbackUserFactory.CallbackUser;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.scheduling.SuspendableSchedulerEntity;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.util.IndirectionModelUtil;
import org.palladiosimulator.indirections.util.IterableUtil;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class AbstractSimDataChannelResource implements IDataChannelResource {
    protected TriggerableTimeSpanCalculator afterAcceptingAgeCalculator;
    protected TriggerableTimeSpanCalculator beforePuttingAgeCalculator;
    private boolean canGetNewData = false;

    private boolean canPutNewData = false;
    protected final InterpreterDefaultContext context;

    private double currentWatermarkedTime = Double.NEGATIVE_INFINITY;
    protected DataChannel dataChannel;

    protected TriggerableTimeSpanCalculator discardedAgeCalculator;
    protected final String id;

    protected SimuComModel model;
    protected final String name;

    protected TriggerableCountingCalculator numberOfDiscardedIncomingElementsCalculator;

    protected TriggerableCountingCalculator numberOfDiscardedOutgoingElementsCalculator;

    protected TriggerableCountingCalculator numberOfStoredIncomingElementsCalculator;

    protected TriggerableCountingCalculator numberOfStoredOutgoingElementsCalculator;

    private boolean postponeNotification = false;

    protected Map<DataSourceRole, Queue<ProcessWaitingToGet>> processesWaitingToGet;

    protected Map<DataSinkRole, Queue<ProcessWaitingToPut>> processesWaitingToPut;

    private PeriodicallyTriggeredSimulationEntity scheduledFlush;

    private final Map<DataChannelToAssemblyContextConnector, CallbackUserFactory> sourceConnectorUserFactories = new HashMap<>();
    protected ContextAwareTimeSpanCalculator<ProcessWaitingToGet> waitingToGetTimeCalculator;
    protected ContextAwareTimeSpanCalculator<ProcessWaitingToPut> waitingToPutTimeCalculator;
    public AbstractSimDataChannelResource(final DataChannel dataChannel, final InterpreterDefaultContext context,
            final SchedulerModel model) {
        if (!(model instanceof SimuComModel)) {
            throw new IllegalArgumentException(
                    "Currently only works with " + SimuComModel.class.getName() + ", got " + model.getClass()
                        .getName());
        }

        this.dataChannel = dataChannel;

        this.id = dataChannel.getId() + "_" + UUID.randomUUID()
            .toString();
        this.name = dataChannel.getEntityName() + "_" + this.getClass()
            .getSimpleName();

        this.model = (SimuComModel) model;
        this.context = context;

        this.initializeQueues();
        this.createPushingUserFactories();

        this.setupCalculators();
    }
    protected abstract void acceptData(DataChannelSinkConnector connector, IndirectionDate date);
    private void activateIfWaiting(final SuspendableSchedulerEntity process) {
        if (process.isWaiting()) {
            process.activate();
        }
    }
    @Override
    public final void advance(final double watermarkTime) {
        final var oldWatermarkTime = watermarkTime;
        if (watermarkTime < this.currentWatermarkedTime) {
            System.out
                .println("Not advancing backward. Requested: " + this.currentWatermarkedTime + " to " + watermarkTime);
            return;
        }

        this.currentWatermarkedTime = watermarkTime;

        this.handleNewWatermarkedTime(oldWatermarkTime, watermarkTime);
    }
    private void allowToGetAndActivate(final ProcessWaitingToGet process) {
        this.collectAndPostponeNotification(() -> {
            this.waitingToGetTimeCalculator.endMeasurement(process);

            final IndirectionDate providedData = this.provideDataAndAdvance(process.connector);
            IndirectionSimulationUtil.getDataAgeRecursive(providedData)
                .forEach(this.beforePuttingAgeCalculator::doMeasureUntilNow);
            process.callback.accept(providedData);

            this.activateIfWaiting(process);
        });
    }
    private void allowToPutAndActivate(final ProcessWaitingToPut process) {
        this.collectAndPostponeNotification(() -> {
            this.waitingToPutTimeCalculator.endMeasurement(process);

            this.acceptData(process.connector, process.date);

            IndirectionSimulationUtil.getDataAgeRecursive(process.date)
                .forEach(this.afterAcceptingAgeCalculator::doMeasureUntilNow);

            this.activateIfWaiting(process);
        });
    }

    protected final void blockUntilCanGet(final ProcessWaitingToGet process) {
        this.processesWaitingToGet.get(process.connector.getDataSourceRole())
            .add(process);
        process.passivate();
    }

    protected final void blockUntilCanPut(final ProcessWaitingToPut process) {
        this.processesWaitingToPut.get(process.connector.getDataSinkRole())
            .add(process);
        process.passivate();
    }

    protected abstract boolean canAcceptData(DataChannelSinkConnector connector);

    private boolean canProceedToGet(final ProcessWaitingToGet process) {
        final DataSourceRole role = process.connector.getDataSourceRole();

        final boolean isNextProcess = this.processesWaitingToGet.isEmpty() || this.processesWaitingToGet.get(role)
            .peek().schedulableProcess.equals(process.schedulableProcess);

        return isNextProcess && this.canProvideData(process.connector);
    }

    private boolean canProceedToPut(final ProcessWaitingToPut process) {
        final DataSinkRole role = process.connector.getDataSinkRole();

        final boolean isNextProcess = this.processesWaitingToPut.isEmpty() || this.processesWaitingToPut.get(role)
            .peek().schedulableProcess.equals(process.schedulableProcess);

        return isNextProcess && this.canAcceptData(process.connector);
    }
    protected abstract boolean canProvideData(DataChannelSourceConnector connector);

    private Collection<DataChannelToAssemblyContextConnector> claimDataChannelToAssemblyContextConnectors() {
        return IterableUtil.claimType(IndirectionModelUtil.getAllConnectorsFromSourceRoles(this.dataChannel),
                DataChannelToAssemblyContextConnector.class);
    }

    /**
     * Sets a flag to collect notification information, runs the given block and afterwards checks
     * whether new data is available and acts accordingly.
     *
     * @param block
     */
    private void collectAndPostponeNotification(final Runnable block) {
        final var initialPostponeState = this.postponeNotification;
        this.postponeNotification = true;
        block.run();
        this.postponeNotification = initialPostponeState;
        this.handleNotifications();
    }

    protected final void continueWithoutData(final ProcessWaitingToGet process) {
        // this does not put data on the stack (i.e., does not call the callback)
        this.waitingToGetTimeCalculator.endMeasurement(process);
        this.activateIfWaiting(process);
    }

    private void createPushingUserFactories() {
        if (!this.sourceConnectorUserFactories.isEmpty()) {
            throw new IllegalStateException("User factories already created.");
        }

        for (final DataChannelToAssemblyContextConnector connector : this
            .claimDataChannelToAssemblyContextConnectors()) {
            this.sourceConnectorUserFactories.put(connector,
                    CallbackUserFactory.createPushingUserFactory(this.model, connector));
        }
    }

    protected final void discardDataAndContinue(final ProcessWaitingToPut process) {
        this.waitingToPutTimeCalculator.endMeasurement(process);

        final IndirectionDate dateToDiscard = process.date;
        IndirectionSimulationUtil.getDataAgeRecursive(dateToDiscard)
            .forEach(this.discardedAgeCalculator::doMeasureUntilNow);

        this.numberOfDiscardedIncomingElementsCalculator.change(1);

        this.activateIfWaiting(process);
    }

    @Override
    public boolean get(final ISchedulableProcess schedulableProcess, final DataChannelSourceConnector connector,
            final Consumer<IndirectionDate> callback) {
        if (!this.model.getSimulationControl()
            .isRunning()) {
            return true;
        }

        if (IndirectionModelUtil.isPushingRole(connector.getDataSourceRole())) {
            throw new IllegalStateException("Cannot pull data over pushing role.");
        }

        final ProcessWaitingToGet process = new ProcessWaitingToGet(this.model, schedulableProcess, connector,
                callback);

        this.waitingToGetTimeCalculator.startMeasurement(process);

        if (this.canProceedToGet(process)) {
            this.allowToGetAndActivate(process);
            return true;
        } else {
            this.handleCannotProceedToGet(process);
            return false;
        }
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
        for (final DataSourceRole role : this.dataChannel.getDataSourceRoles()) {
            this.processesWaitingToGet.put(role, new ArrayDeque<>());
        }

        this.processesWaitingToPut = new HashMap<>();
        for (final DataSinkRole role : this.dataChannel.getDataSinkRoles()) {
            this.processesWaitingToPut.put(role, new ArrayDeque<>());
        }
    }

    protected final void notifyProcessesCanGetNewData() {
        this.canGetNewData = true;
        this.handleNotifications();
    }

    protected final void notifyProcessesCanPutNewData() {
        this.canPutNewData = true;
        this.handleNotifications();
    }

    private void notifyProcessesWaitingToGet() {
        for (final var entry : this.processesWaitingToGet.entrySet()) {
            final var processes = entry.getValue();

            ProcessWaitingToGet waitingProcess = processes.peek();
            while (waitingProcess != null && this.canProceedToGet(waitingProcess)) {
                this.allowToGetAndActivate(waitingProcess);
                processes.remove();
                waitingProcess = processes.peek();
            }
        }
    }

    private void notifyProcessesWaitingToPut() {
        for (final var entry : this.processesWaitingToPut.entrySet()) {
            final var processes = entry.getValue();

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
        for (final DataChannelSourceConnector connector : IndirectionModelUtil
            .getAllConnectorsFromSourceRoles(this.dataChannel)) {
            if (IndirectionModelUtil.isPushingRole(connector.getDataSourceRole())) {
                while (this.canProvideData(connector)) {
                    // the method directly takes the data, thus it should not be an infinite loop
                    this.spawnNewConsumerUser(connector);
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
    protected abstract IndirectionDate provideDataAndAdvance(DataChannelSourceConnector connector);

    @Override
    public boolean put(final ISchedulableProcess schedulableProcess, final DataChannelSinkConnector connector,
            final IndirectionDate date) {
        IndirectionSimulationUtil.validateIndirectionDateStructure(date, connector.getDataSourceRole()
            .getEventGroup());

        if (!this.model.getSimulationControl()
            .isRunning()) {
            return true;
        }

        final ProcessWaitingToPut process = new ProcessWaitingToPut(this.model, schedulableProcess, connector, date);

        this.waitingToPutTimeCalculator.startMeasurement(process);

        if (this.canProceedToPut(process)) {
            this.allowToPutAndActivate(process);
            return true;
        } else {
            this.handleCannotProceedToPut(process);
            return false;
        }
    }

    protected final void scheduleAdvance(final double firstOccurence, final double delay,
            final double lagBehindRealTime) {
        if (this.scheduledFlush != null) {
            throw new PCMModelInterpreterException("Cannot schedule advance for " + this + ", already scheduled.");
        }

        this.scheduledFlush = IndirectionSimulationUtil.triggerPeriodically(this.model, firstOccurence, delay, () -> {
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
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, this.context);
        this.waitingToPutTimeCalculator = new ContextAwareTimeSpanCalculator<ProcessWaitingToPut>(
                "Waiting time to put (" + this.name + ")", MetricDescriptionConstants.WAITING_TIME_METRIC,
                MetricDescriptionConstants.WAITING_TIME_METRIC_TUPLE, this.context);
        this.numberOfDiscardedOutgoingElementsCalculator = new TriggerableCountingCalculator(
                "Discarded outgoing elements (" + this.name + ")",
                "Total discarded outgoing elements (" + this.name + ")",
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC,
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC_TUPLE,
                IndirectionsMetricDescriptionConstants.TOTAL_NUMBER_OF_ELEMENTS_METRIC_TUPLE, this.context);
        this.numberOfStoredOutgoingElementsCalculator = new TriggerableCountingCalculator(
                "Stored outgoing elements (" + this.name + ")", "Total stored outgoing elements (" + this.name + ")",
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC,
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC_TUPLE,
                IndirectionsMetricDescriptionConstants.TOTAL_NUMBER_OF_ELEMENTS_METRIC_TUPLE, this.context);
    }

    private void setupSourceCalculators() {
        this.beforePuttingAgeCalculator = new TriggerableTimeSpanCalculator(
                "Data age before putting (" + this.name + ")", IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, this.context);
        this.waitingToGetTimeCalculator = new ContextAwareTimeSpanCalculator<ProcessWaitingToGet>(
                "Waiting time to get (" + this.name + ")", MetricDescriptionConstants.WAITING_TIME_METRIC,
                MetricDescriptionConstants.WAITING_TIME_METRIC_TUPLE, this.context);
        this.numberOfDiscardedIncomingElementsCalculator = new TriggerableCountingCalculator(
                "Discarded incoming elements (" + this.name + ")",
                "Total discarded incoming elements (" + this.name + ")",
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC,
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC_TUPLE,
                IndirectionsMetricDescriptionConstants.TOTAL_NUMBER_OF_ELEMENTS_METRIC_TUPLE, this.context);
        this.discardedAgeCalculator = new TriggerableTimeSpanCalculator(
                "Data age before discarding (" + this.name + ")",
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, this.context);
        this.numberOfStoredIncomingElementsCalculator = new TriggerableCountingCalculator(
                "Stored incoming elements (" + this.name + ")", "Total stored incoming elements (" + this.name + ")",
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC,
                IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC_TUPLE,
                IndirectionsMetricDescriptionConstants.TOTAL_NUMBER_OF_ELEMENTS_METRIC_TUPLE, this.context);
    }

    private void spawnNewConsumerUser(final DataChannelSourceConnector connector) {
        final IndirectionDate date = this.provideDataAndAdvance(connector);
        this.beforePuttingAgeCalculator.doMeasure(date.getTime());

        final String parameterName = IndirectionSimulationUtil.getOneParameter(connector.getDataSinkRole()
            .getEventGroup())
            .getParameterName();

        final CallbackUser user = this.sourceConnectorUserFactories.get(connector)
            .createUser();

        final InterpreterDefaultContext newContext = new InterpreterDefaultContext(this.context.getRuntimeState()
            .getMainContext(), user);

        user.setDataAndStartUserLife(parameterName, date, newContext);
    }

    protected final void unscheduleAdvance() {
        if (this.scheduledFlush != null) {
            throw new PCMModelInterpreterException("Cannot unschedule advance for " + this + ", not scheduled.");
        }

        this.scheduledFlush.stopScheduling();
        this.scheduledFlush = null;
    }

}
