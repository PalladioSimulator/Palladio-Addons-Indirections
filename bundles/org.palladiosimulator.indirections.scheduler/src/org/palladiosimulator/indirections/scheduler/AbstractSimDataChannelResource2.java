package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.Collection;
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
import org.palladiosimulator.indirections.composition.DataChannelToAssemblyContextConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.scheduler.CallbackUserFactory.CallbackUser;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.scheduler.scheduling.SuspendableSchedulerEntity;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.util.IndirectionModelUtil;
import org.palladiosimulator.indirections.util.IterableUtil;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
/*
public abstract class AbstractSimDataChannelResource2 implements IDataChannelResource {
	protected Queue<ProcessWaitingToConsume> processesWaitingToConsume;
	protected Queue<ProcessWaitingToEmit> processesWaitingToEmit;
	protected DataChannel dataChannel;

	protected final InterpreterDefaultContext context;
	protected SimuComModel model;

	protected final String name;
	protected final String id;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getId() {
		return this.id;
	}

	public AbstractSimDataChannelResource2(DataChannel dataChannel, InterpreterDefaultContext context,
			SchedulerModel model) {
		if (!(model instanceof SimuComModel)) {
			throw new IllegalArgumentException("Currently only works with " + SimuComModel.class.getName() + ", got "
					+ model.getClass().getName());
		}

		this.dataChannel = dataChannel;

		this.id = dataChannel.getId() + "_" + UUID.randomUUID().toString();
		this.name = dataChannel.getEntityName() + "_" + this.getClass().getSimpleName();

		this.model = (SimuComModel) model;
		this.context = context;

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
		for (DataSourceRole dataSourceRole : dataChannel.getDataSourceRoles()) {
			if (canProvideData(dataSourceRole)) {
				for (DataChannelSourceConnector connector : IterableUtil
						.claimType(dataSourceRole.getDataSourceSinkConnectors(), DataChannelSourceConnector.class)) {
					if (IndirectionModelUtil.isPushingConnector(connector)) {
						spawnNewConsumerUsers(connector);
					} else {
						notifyProcessesWaitingToGet();
					}
				}
			}
		}
	}

	private Map<DataChannelToAssemblyContextConnector, CallbackUserFactory> sourceConnectorUserFactories = new HashMap<>();

	private Collection<DataChannelToAssemblyContextConnector> claimDataChannelToAssemblyContextConnectors() {
		return IterableUtil.claimType(IndirectionModelUtil.getAllConnectorsFromSourceRoles(dataChannel),
				DataChannelToAssemblyContextConnector.class);
	}

	private void createPushingUserFactories() {
		if (!sourceConnectorUserFactories.isEmpty()) {
			throw new IllegalStateException("User factories already created.");
		}

		for (DataChannelToAssemblyContextConnector connector : claimDataChannelToAssemblyContextConnectors()) {
			sourceConnectorUserFactories.put(connector, CallbackUserFactory.createPushingUserFactory(model, connector));
		}
	}

	private void spawnNewConsumerUsers() {
		IndirectionDate date = provideData();
		beforeEmittingAgeCalculator.doMeasure(date.getTime());

		for (DataChannelSourceConnector connector : claimDataChannelToAssemblyContextConnectors()) {
			String parameterName = IndirectionSimulationUtil
					.getOneParameter(connector.getDataSinkRole().getEventGroup()).getParameterName();

			CallbackUser user = sourceConnectorUserFactories.get(connector).createUser();

			InterpreterDefaultContext newContext = new InterpreterDefaultContext(
					context.getRuntimeState().getMainContext(), user);

			user.setDataAndStartUserLife(parameterName, date, newContext);
		}

	}

	private void notifyProcessesWaitingToGet() {
		this.notifyProcesses(processesWaitingToConsume, p -> p.schedulableProcess, this::canProceedToGet,
				this::allowToGetAndActivate, p -> notifyProcessesWaitingToPut());
	}

	protected void notifyProcessesWaitingToPut() {
		this.notifyProcesses(processesWaitingToEmit, p -> p.schedulableProcess, this::canProceedToPut,
				this::allowToPutAndActivate, this::processDataAvailableToGet);
	}

	private <T> void notifyProcesses(Queue<T> processes, Function<T, ISchedulableProcess> processExtractor,
			Predicate<T> canProceed, Consumer<T> allow, Consumer<T> callAfterAllowing) {

		T waitingProcess = processes.peek();
		while (waitingProcess != null && canProceed.test(waitingProcess)) {
			allow.accept(waitingProcess);
			callAfterAllowing.accept(waitingProcess);
			processes.remove();
			waitingProcess = processes.peek();
		}
	}

	@Override
	public boolean put(ISchedulableProcess schedulableProcess, DataChannelSinkConnector connector,
			IndirectionDate date) {
		IndirectionSimulationUtil.validateIndirectionDateStructure(date, connector.getDataSourceRole().getEventGroup());

		if (!this.model.getSimulationControl().isRunning()) {
			return true;
		}

		ProcessWaitingToEmit process = new ProcessWaitingToEmit(this.model, schedulableProcess, connector, date);

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
	public boolean get(ISchedulableProcess schedulableProcess, DataChannelSourceConnector connector,
			Consumer<IndirectionDate> callback) {
		if (!this.model.getSimulationControl().isRunning()) {
			return true;
		}

		if (IndirectionModelUtil.isPushingConnector(connector)) {
			throw new IllegalStateException("Cannot pull data over pushing data channel.");
		}

		ProcessWaitingToConsume process = new ProcessWaitingToConsume(this.model, schedulableProcess, connector,
				callback);

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

	private boolean canProceedToPut(ProcessWaitingToEmit process) {
		boolean isNextProcess = processesWaitingToEmit.isEmpty()
				|| processesWaitingToEmit.peek().schedulableProcess.equals(process.schedulableProcess);

		return isNextProcess && canAcceptData(process.sourceConnector.getDataSinkRole());
	}

	protected abstract boolean canAcceptData(DataSinkRole role);

	protected abstract boolean canProvideData(DataSourceRole role);

	private boolean canProceedToGet(ProcessWaitingToConsume process) {
		boolean isNextProcess = processesWaitingToConsume.isEmpty()
				|| processesWaitingToConsume.peek().schedulableProcess.equals(process.schedulableProcess);

		return isNextProcess && canProvideData(process.sinkConnector.getDataSourceRole());
	}

	protected abstract IndirectionDate provideData(DataSourceRole role);

	protected abstract void acceptData(DataSinkRole role, IndirectionDate date);

	private void allowToGetAndActivate(ProcessWaitingToConsume process) {
		this.waitingToConsumeTimeCalculator.endMeasurement(process);

		IndirectionDate dateToEmit = this.provideData(process.sinkConnector.getDataSourceRole());
		IndirectionSimulationUtil.getDataAgeRecursive(dateToEmit)
				.forEach(beforeEmittingAgeCalculator::doMeasureUntilNow);
		process.callback.accept(dateToEmit);
		activateIfWaiting(process);
	}

	private void allowToPutAndActivate(ProcessWaitingToEmit process) {
		this.waitingToEmitTimeCalculator.endMeasurement(process);

		acceptData(process.sourceConnector.getDataSinkRole(), process.date);

		IndirectionSimulationUtil.getDataAgeRecursive(process.date)
				.forEach(afterAcceptingAgeCalculator::doMeasureUntilNow);

		activateIfWaiting(process);
	}
}
*/