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

import org.palladiosimulator.indirections.calculators.scheduler.ContextAwareTimeSpanCalculator;
import org.palladiosimulator.indirections.calculators.scheduler.TriggerableCountingCalculator;
import org.palladiosimulator.indirections.calculators.scheduler.TriggerableTimeSpanCalculator;
import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.datatypes.ConsumeFromChannelPolicy;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.indirections.scheduler.CallbackUserFactory.CallbackUser;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.scheduler.scheduling.SuspendableSchedulerEntity;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.util.IterableUtil;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class AbstractSimDataChannelResource implements IDataChannelResource {
	protected Queue<ProcessWaitingToConsume> processesWaitingToConsume;
	protected Queue<ProcessWaitingToEmit> processesWaitingToEmit;
	protected DataChannel dataChannel;

	protected final InterpreterDefaultContext context;
	protected SimuComModel model;

	protected final String name;
	protected final String id;
	protected final int capacity;
	protected final boolean isPushing;

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
		
		List<Boolean> sinkRolePushingFlags = dataChannel.getDataChannelSinkConnector().stream().map(it -> it.getDataSinkRole().isPushing()).collect(Collectors.toList());
		this.isPushing = sinkRolePushingFlags.isEmpty() ? false : IterableUtil.claimEqual(sinkRolePushingFlags);
		
		if (this.isPushing != (this.dataChannel.getConsumeFromChannelPolicy() == ConsumeFromChannelPolicy.PUSHING)) {
			throw new PCMModelInterpreterException("Data channel is pushing = " + this.isPushing + " is not reflected by consume policy = " + dataChannel.getConsumeFromChannelPolicy());
		}

		this.initializeQueues();
		this.createPushingUserFactories();
		this.setupCalculators();
	}

	protected TriggerableTimeSpanCalculator afterAcceptingAgeCalculator;
	protected TriggerableTimeSpanCalculator beforeEmittingAgeCalculator;
	protected TriggerableCountingCalculator numberOfDiscardedElementsCalculator;
	protected ContextAwareTimeSpanCalculator<ProcessWaitingToEmit> waitingToEmitTimeCalculator;
	protected ContextAwareTimeSpanCalculator<ProcessWaitingToConsume> waitingToConsumeTimeCalculator;

	private void setupCalculators() {
		this.afterAcceptingAgeCalculator = new TriggerableTimeSpanCalculator(
				"Data age after accepting date (" + name + ")", IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
				IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, context);
		this.beforeEmittingAgeCalculator = new TriggerableTimeSpanCalculator("Data age before emitting (" + name + ")",
				IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
				IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, context);
		this.numberOfDiscardedElementsCalculator = new TriggerableCountingCalculator(
				"Discarded elements (" + name + ")", "Total discarded elements (" + name + ")",
				IndirectionsMetricDescriptionConstants.NUMBER_OF_DISCARDED_ELEMENTS_METRIC,
				IndirectionsMetricDescriptionConstants.NUMBER_OF_DISCARDED_ELEMENTS_METRIC_TUPLE,
				IndirectionsMetricDescriptionConstants.TOTAL_NUMBER_OF_DISCARDED_ELEMENTS_METRIC_TUPLE, context);
		this.waitingToEmitTimeCalculator = new ContextAwareTimeSpanCalculator<ProcessWaitingToEmit>(
				"Waiting time to emit (" + name + ")", MetricDescriptionConstants.WAITING_TIME_METRIC,
				MetricDescriptionConstants.WAITING_TIME_METRIC_TUPLE, context);
		this.waitingToConsumeTimeCalculator = new ContextAwareTimeSpanCalculator<ProcessWaitingToConsume>(
				"Waiting time to consume (" + name + ")", MetricDescriptionConstants.WAITING_TIME_METRIC,
				MetricDescriptionConstants.WAITING_TIME_METRIC_TUPLE, context);
	}

	private void initializeQueues() {
		processesWaitingToConsume = new ArrayDeque<ProcessWaitingToConsume>();
		processesWaitingToEmit = new ArrayDeque<ProcessWaitingToEmit>();
	}

	protected void processDataAvailableToGet() {
		if (isPushing) {
			spawnNewConsumerUsers();
		} else {
			notifyProcessesWaitingToGet();
		}
	}

	private Map<DataChannelSinkConnector,CallbackUserFactory> sinkConnectorUserFactories = new HashMap<>();

	private void createPushingUserFactories() {
		if (!sinkConnectorUserFactories.isEmpty()) {
			throw new IllegalStateException("User factories already created.");
		}

		for (DataChannelSinkConnector sinkConnector : this.dataChannel.getDataChannelSinkConnector()) {
			sinkConnectorUserFactories.put(sinkConnector, CallbackUserFactory.createPushingUserFactory(sinkConnector, model));
		}
	}

	private void spawnNewConsumerUsers() {
		IndirectionDate date = provideData();
		beforeEmittingAgeCalculator.doMeasure(date.getTime());
		
		for (DataChannelSinkConnector sinkConnector : this.dataChannel.getDataChannelSinkConnector()) {
			String parameterName = IndirectionSimulationUtil
					.getOneParameter(sinkConnector.getDataSinkRole().getEventGroup()).getParameterName();
	
			CallbackUser user = sinkConnectorUserFactories.get(sinkConnector).createUser();
			
			final InterpreterDefaultContext newContext = new InterpreterDefaultContext(
                    context.getRuntimeState().getMainContext(), user);
			
			user.setDataAndStartUserLife(parameterName, date, newContext);
		}

	}

	private void notifyProcessesWaitingToGet() {
		this.notifyProcesses(processesWaitingToConsume, p -> p.schedulableProcess, this::canProceedToGet,
				this::allowToGetAndActivate, this::notifyProcessesWaitingToPut);
	}

	protected void notifyProcessesWaitingToPut() {
		this.notifyProcesses(processesWaitingToEmit, p -> p.schedulableProcess, this::canProceedToPut,
				this::allowToPutAndActivate, this::processDataAvailableToGet);
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
	public boolean put(final ISchedulableProcess schedulableProcess, final DataChannelSourceConnector sourceConnector,
			final IndirectionDate date) {
		IndirectionSimulationUtil.validateIndirectionDateStructure(date,
				sourceConnector.getDataSourceRole().getEventGroup());

		if (!this.model.getSimulationControl().isRunning()) {
			return true;
		}

		final ProcessWaitingToEmit process = new ProcessWaitingToEmit(this.model, schedulableProcess, sourceConnector,
				date);

		this.waitingToEmitTimeCalculator.startMeasurement(process);

		if (this.canProceedToPut(process)) {
			this.allowToPutAndActivate(process);
			this.processDataAvailableToGet();
			return true;
		} else {
			this.processesWaitingToEmit.add(process);
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

		if (isPushing) {
			throw new IllegalStateException("Cannot pull data over pushing data channel.");
		}

		final ProcessWaitingToConsume process = new ProcessWaitingToConsume(this.model, schedulableProcess,
				sinkConnector, callback);

		this.waitingToConsumeTimeCalculator.startMeasurement(process);

		if (this.canProceedToGet(process)) {
			this.allowToGetAndActivate(process);
			this.notifyProcessesWaitingToPut();
			return true;
		} else {
			processesWaitingToConsume.add(process);
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
		final boolean isNextProcess = processesWaitingToEmit.isEmpty()
				|| processesWaitingToEmit.peek().schedulableProcess.equals(process.schedulableProcess);

		return isNextProcess && canAcceptData();
	}

	protected abstract boolean canAcceptData();

	protected abstract boolean canProvideData();

	private boolean canProceedToGet(final ProcessWaitingToConsume process) {
		final boolean isNextProcess = processesWaitingToConsume.isEmpty()
				|| processesWaitingToConsume.peek().schedulableProcess.equals(process.schedulableProcess);

		return isNextProcess && canProvideData();
	}

	protected abstract IndirectionDate provideData();

	protected abstract void acceptData(IndirectionDate date);

	private void allowToGetAndActivate(ProcessWaitingToConsume process) {
		this.waitingToConsumeTimeCalculator.endMeasurement(process);

		IndirectionDate dateToEmit = this.provideData();
		IndirectionSimulationUtil.getDataAgeRecursive(dateToEmit)
				.forEach(beforeEmittingAgeCalculator::doMeasureUntilNow);
		process.callback.accept(dateToEmit);
		activateIfWaiting(process);
	}

	private void allowToPutAndActivate(ProcessWaitingToEmit process) {
		this.waitingToEmitTimeCalculator.endMeasurement(process);

		acceptData(process.date);

		IndirectionSimulationUtil.getDataAgeRecursive(process.date)
				.forEach(afterAcceptingAgeCalculator::doMeasureUntilNow);

		activateIfWaiting(process);
	}

	protected String getOutgoingParameterName() {
		return IndirectionSimulationUtil.getOneParameter(this.dataChannel.getSourceEventGroup()).getParameterName();
	}

	protected String getIncomingParameterName() {
		return IndirectionSimulationUtil.getOneParameter(this.dataChannel.getSinkEventGroup()).getParameterName();
	}
}
