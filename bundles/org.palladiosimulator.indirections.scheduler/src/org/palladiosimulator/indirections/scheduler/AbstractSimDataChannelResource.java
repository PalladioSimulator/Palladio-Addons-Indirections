package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint;
import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.simulizar.IndirectionMeasuringPointRegistry;
import org.palladiosimulator.indirections.monitoring.simulizar.MeasuringUtil;
import org.palladiosimulator.indirections.monitoring.simulizar.TriggeredCombiningProbe;
import org.palladiosimulator.indirections.monitoring.simulizar.TriggeredProxyProbe;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.scheduler.scheduling.SuspendableSchedulerEntity;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.probeframework.calculator.ICalculatorFactory;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class AbstractSimDataChannelResource implements IDataChannelResource {
    protected Map<DataChannelSinkConnector, IndirectionQueue<ProcessWaitingToConsume>> outgoingQueues;
    protected Map<DataChannelSourceConnector, IndirectionQueue<ProcessWaitingToEmit>> incomingQueues;
    protected DataChannel dataChannel;

    protected final InterpreterDefaultContext context;
    protected SimuComModel model;

    protected final String name;
    protected final String id;
    protected final int capacity;

    protected class IndirectionQueue<T extends SuspendableSchedulerEntity> {
        public final Queue<IndirectionDate> elements;
        public final Queue<T> processes;

        public IndirectionQueue() {
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

    public AbstractSimDataChannelResource(final DataChannel dataChannel, InterpreterDefaultContext context,
            final SchedulerModel model) {
        if (!(model instanceof SimuComModel)) {
            throw new IllegalArgumentException("Currently only works with " + SimuComModel.class.getName() + ", got "
                    + model.getClass().getName());
        }

        this.dataChannel = dataChannel;

        this.id = dataChannel.getId() + "_" + UUID.randomUUID().toString();
        this.name = dataChannel.getEntityName() + "_" + this.getClass().getSimpleName();

        this.capacity = dataChannel.getCapacity();

        this.model = (SimuComModel) model;
        this.context = context;

        this.initializeQueues();

        this.setupCalculators();
    }

    private ContextAwareTimeSpanCalculator<ProcessWaitingToConsume> waitingToGetTimeCalculator;
    private ContextAwareTimeSpanCalculator<ProcessWaitingToEmit> waitingToPutTimeCalculator;

    private void setupCalculators() {
        this.waitingToGetTimeCalculator = new ContextAwareTimeSpanCalculator<>("Waiting time to get from " + name,
                MetricDescriptionConstants.WAITING_TIME_METRIC, MetricDescriptionConstants.WAITING_TIME_METRIC_TUPLE);
        this.waitingToPutTimeCalculator = new ContextAwareTimeSpanCalculator<>("Waiting time to put to " + name,
                MetricDescriptionConstants.WAITING_TIME_METRIC, MetricDescriptionConstants.WAITING_TIME_METRIC_TUPLE);
    }

    public class TriggerableTimeSpanCalculator {
        protected final TriggeredProxyProbe<Double, Duration> proxyProbe;
        protected final TriggeredCombiningProbe<Double, Duration> probeList;
        protected final IndirectionMeasuringPointRegistry registry;

        public TriggerableTimeSpanCalculator(String name, BaseMetricDescription baseMetric,
                MetricSetDescription metricSet) {

            registry = IndirectionMeasuringPointRegistry.getInstanceFor(context);

            StringMeasuringPoint measuringPoint = MeasuringUtil
                    .createStringMeasuringPoint(IndirectionMeasuringPointRegistry.MEASURING_POINT_REPOSITORY, name);

            proxyProbe = new TriggeredProxyProbe<Double, Duration>(baseMetric);
            probeList = new TriggeredCombiningProbe<Double, Duration>(metricSet,
                    List.of(registry.timeProbe, proxyProbe), proxyProbe);

            ICalculatorFactory calculatorFactory = model.getProbeFrameworkContext().getCalculatorFactory();
            calculatorFactory.buildExecutionResultCalculator(measuringPoint, probeList);
        }

        public void doMeasure(double timeSpan) {
            proxyProbe.doMeasure(Measure.valueOf(timeSpan, SI.SECOND));
        }

        public void doMeasureUntilNow(double time) {
            doMeasure(model.getSimulationControl().getCurrentSimulationTime() - time);
        }
    }

    public class ContextAwareTimeSpanCalculator<C> extends TriggerableTimeSpanCalculator {

        public ContextAwareTimeSpanCalculator(String name, BaseMetricDescription baseMetric,
                MetricSetDescription metricSet) {
            super(name, baseMetric, metricSet);
        }

        private Map<C, Double> activeMeasurements = new HashMap<>();

        public void startMeasurement(C c) {
            if (activeMeasurements.containsKey(c)) {
                throw new PCMModelInterpreterException("Cannot start measurement for " + c.toString()
                        + ", already started at " + activeMeasurements.get(c));
            }

            activeMeasurements.put(c, model.getSimulationControl().getCurrentSimulationTime());
        }

        public void endMeasurement(C c) {
            if (!activeMeasurements.containsKey(c)) {
                throw new PCMModelInterpreterException(
                        "Cannot end measurement for " + c.toString() + ", no measurement start present");
            }

            double timeSpan = model.getSimulationControl().getCurrentSimulationTime() - activeMeasurements.get(c);
            doMeasure(timeSpan);
        }
    }

    private void initializeQueues() {
        this.outgoingQueues = this.dataChannel.getDataChannelSinkConnector().stream()
                .filter(it -> !it.getDataSinkRole().isPushing())
                .collect(Collectors.toMap(Function.identity(), it -> new IndirectionQueue<ProcessWaitingToConsume>()));

        this.incomingQueues = this.dataChannel.getDataChannelSourceConnector().stream()
                .collect(Collectors.toMap(Function.identity(), it -> new IndirectionQueue<ProcessWaitingToEmit>()));
    }

    protected void processDataAvailableToGet() {
        for (DataChannelSinkConnector sinkConnector : dataChannel.getDataChannelSinkConnector()) {
            if (sinkConnector.getDataSinkRole().isPushing()) {
                spawnNewProcessThatTakesFromConnector(sinkConnector);
            } else {
                notifyProcessesWaitingToGetFromQueue(outgoingQueues.get(sinkConnector));
            }
        }
    }

    private void spawnNewProcessThatTakesFromConnector(DataChannelSinkConnector sinkConnector) {
        throw new UnsupportedOperationException();
//        DataChannelConsumerUser dataChannelConsumerUser = dataChannelUserFactory.createPassivatedUser(sinkConnector);

//        ProcessWaitingToConsume consumerProcess = new ProcessWaitingToConsume(model, dataChannelConsumerUser,
//                sinkConnector, dataChannelConsumerUser::setData);

//        allowToGetAndActivate(consumerProcess);
    }

    private void notifyProcessesWaitingToGetFromQueue(IndirectionQueue<ProcessWaitingToConsume> queue) {
        this.notifyProcesses(queue.processes, p -> p.schedulableProcess, this::canProceedToGet,
                this::allowToGetAndActivate, this::notifyProcessesWaitingToPut);
    }

    protected void notifyProcessesWaitingToPut() {
        for (final IndirectionQueue<ProcessWaitingToEmit> queue : this.incomingQueues.values()) {
            this.notifyProcesses(queue.processes, p -> p.schedulableProcess, this::canProceedToPut,
                    this::allowToPutAndActivate, this::processDataAvailableToGet);
        }
    }

    // TODO: should remove unnecessary complexity introduced with this kind of reuse and just inline
    // into two methods above
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
    public boolean put(final ISchedulableProcess schedulableProcess, final DataChannelSourceConnector sourceConnector,
            final IndirectionDate date) {
        IndirectionSimulationUtil.validateIndirectionDateStructure(date,
                sourceConnector.getDataSourceRole().getEventGroup());

        if (!this.model.getSimulationControl().isRunning()) {
            return true;
        }

        final ProcessWaitingToEmit process = new ProcessWaitingToEmit(this.model, schedulableProcess, sourceConnector,
                date);

        this.waitingToPutTimeCalculator.startMeasurement(process);

        if (this.canProceedToPut(process)) {
            this.allowToPutAndActivate(process);
            this.processDataAvailableToGet();
            return true;
        } else {
            this.incomingQueues.get(sourceConnector).processes.add(process);
            process.passivate();
            return false;
        }
    }

    @Override
    public boolean get(final ISchedulableProcess schedulableProcess, final DataChannelSinkConnector sinkConnector,
            final Consumer<IndirectionDate> callback) {
        if (!this.model.getSimulationControl().isRunning()) {
            return true;
        }

        if (sinkConnector.getDataSinkRole().isPushing()) {
            throw new IllegalStateException("Cannot pull data over pushing connector " + sinkConnector.toString()
                    + ", SinkRole: " + sinkConnector.getDataSinkRole().toString());
        }

        final ProcessWaitingToConsume process = new ProcessWaitingToConsume(this.model, schedulableProcess,
                sinkConnector, callback);

        this.waitingToGetTimeCalculator.startMeasurement(process);

        if (this.canProceedToGet(process)) {
            this.allowToGetAndActivate(process);
            this.notifyProcessesWaitingToPut();
            return true;
        } else {
            this.outgoingQueues.get(sinkConnector).processes.add(process);
            process.passivate();
            return false;
        }
    }

    private void activateIfWaiting(SuspendableSchedulerEntity process) {
        if (process.isWaiting()) {
            process.activate();
        }
    }

    private boolean canProceedToPut(final ProcessWaitingToEmit process) {
        final Queue<ProcessWaitingToEmit> waitingToPutQueue = this.incomingQueues
                .get(process.sourceConnector).processes;
        final boolean isNextProcess = waitingToPutQueue.isEmpty()
                || waitingToPutQueue.peek().schedulableProcess.equals(process.schedulableProcess);

        return isNextProcess && canAcceptDataFrom(process.sourceConnector);
    }

    protected abstract boolean canAcceptDataFrom(DataChannelSourceConnector sourceConnector);

    protected abstract boolean canProvideDataFor(DataChannelSinkConnector sinkConnector);

    private boolean canProceedToGet(final ProcessWaitingToConsume process) {
        final Queue<ProcessWaitingToConsume> waitingToGetQueue = this.outgoingQueues
                .get(process.sinkConnector).processes;
        final boolean isNextProcess = waitingToGetQueue.isEmpty()
                || waitingToGetQueue.peek().schedulableProcess.equals(process.schedulableProcess);

        return isNextProcess && canProvideDataFor(process.sinkConnector);
    }

    protected abstract Iterable<IndirectionDate> provideDataFor(DataChannelSinkConnector sinkConnector);

    protected abstract void acceptDataFrom(DataChannelSourceConnector sourceConnector, IndirectionDate date);

    private void allowToGetAndActivate(ProcessWaitingToConsume process) {
        this.waitingToGetTimeCalculator.endMeasurement(process);

        this.provideDataFor(process.sinkConnector).forEach(process.callback::accept);
        activateIfWaiting(process);
    }

    private void allowToPutAndActivate(ProcessWaitingToEmit process) {
        this.waitingToPutTimeCalculator.endMeasurement(process);

        acceptDataFrom(process.sourceConnector, process.date);
        activateIfWaiting(process);
    }

    protected String getOutgoingParameterName() {
        return IndirectionSimulationUtil.getOneParameter(this.dataChannel.getSourceEventGroup()).getParameterName();
    }

    protected String getIncomingParameterName() {
        return IndirectionSimulationUtil.getOneParameter(this.dataChannel.getSinkEventGroup()).getParameterName();
    }
}
