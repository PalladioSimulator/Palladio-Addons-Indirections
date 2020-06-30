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
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class AbstractSimDataChannelResource implements IDataChannelResource {
	protected Map<DataSourceRole, Queue<ProcessWaitingToConsume>> processesWaitingToConsume;
	protected Map<DataSinkRole, Queue<ProcessWaitingToEmit>> processesWaitingToEmit;
	protected DataChannel dataChannel;

	protected final InterpreterDefaultContext context;
	protected SimuComModel model;

	protected final String name;
	protected final String id;
	
	private PeriodicallyTriggeredSimulationEntity scheduledFlush;
	private double currentSimulationTime = Double.NEGATIVE_INFINITY;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getId() {
		return this.id;
	}

	public AbstractSimDataChannelResource(DataChannel dataChannel, InterpreterDefaultContext context,
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

		setupCalculators();
	}
		
	protected final void scheduleAdvance(double firstOccurence, double delay) {
		if (scheduledFlush != null) {
			throw new PCMModelInterpreterException("Cannot schedule advance for " + this + ", already scheduled.");
		}
		
		scheduledFlush = IndirectionSimulationUtil.triggerPeriodically(model, firstOccurence, delay, () -> {
			this.advance(model.getSimulationControl().getCurrentSimulationTime());
		});
	}
	
	protected final void unscheduleAdvance() {
		if (scheduledFlush != null) {
			throw new PCMModelInterpreterException("Cannot unschedule advance for " + this + ", not scheduled.");
		}
		
		scheduledFlush.stopScheduling();
		scheduledFlush = null;
	}
	
	@Override
	public final void advance(double simulationTime) {
		var oldSimulationTime = simulationTime;
		if (simulationTime < currentSimulationTime) {
			throw new PCMModelInterpreterException("Cannot go back in time from " + currentSimulationTime + " to " + simulationTime);
		}
		
		currentSimulationTime = simulationTime;
		
		handleNewSimulationTime(oldSimulationTime, simulationTime);
	}
	
	protected abstract void handleNewSimulationTime(double oldSimulationTime, double simulationTime);

	public double getCurrentSimulationTime() {
		return this.currentSimulationTime;
	}

	protected TriggerableTimeSpanCalculator afterAcceptingAgeCalculator;
	protected TriggerableTimeSpanCalculator beforeEmittingAgeCalculator;
	protected TriggerableTimeSpanCalculator discardedAgeCalculator;
	protected TriggerableCountingCalculator numberOfDiscardedIncomingElementsCalculator;
	protected TriggerableCountingCalculator numberOfStoredIncomingElementsCalculator;
	protected TriggerableCountingCalculator numberOfDiscardedOutgoingElementsCalculator;
	protected TriggerableCountingCalculator numberOfStoredOutgoingElementsCalculator;
	protected ContextAwareTimeSpanCalculator<ProcessWaitingToEmit> waitingToEmitTimeCalculator;
	protected ContextAwareTimeSpanCalculator<ProcessWaitingToConsume> waitingToConsumeTimeCalculator;

	private void setupCalculators() {
		setupSourceCalculators();
		setupSinkCalculators();
	}
	
	private void setupSourceCalculators() {
		this.beforeEmittingAgeCalculator = new TriggerableTimeSpanCalculator("Data age before emitting (" + name + ")",
				IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
				IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, context);
		this.waitingToConsumeTimeCalculator = new ContextAwareTimeSpanCalculator<ProcessWaitingToConsume>(
				"Waiting time to consume (" + name + ")", MetricDescriptionConstants.WAITING_TIME_METRIC,
				MetricDescriptionConstants.WAITING_TIME_METRIC_TUPLE, context);
		this.numberOfDiscardedIncomingElementsCalculator = new TriggerableCountingCalculator(
				"Discarded incoming elements (" + name + ")", "Total discarded incoming elements (" + name + ")",
				IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC,
				IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC_TUPLE,
				IndirectionsMetricDescriptionConstants.TOTAL_NUMBER_OF_ELEMENTS_METRIC_TUPLE, context);
		this.discardedAgeCalculator = new TriggerableTimeSpanCalculator("Data age before discarding (" + name + ")",
				IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
				IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, context);
		this.numberOfStoredIncomingElementsCalculator = new TriggerableCountingCalculator(
				"Stored incoming elements (" + name + ")", "Total stored incoming elements (" + name + ")",
				IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC,
				IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC_TUPLE,
				IndirectionsMetricDescriptionConstants.TOTAL_NUMBER_OF_ELEMENTS_METRIC_TUPLE, context);
	}
	
	private void setupSinkCalculators() {
		this.afterAcceptingAgeCalculator = new TriggerableTimeSpanCalculator(
				"Data age after accepting date (" + name + ")", IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
				IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, context);	
		this.waitingToEmitTimeCalculator = new ContextAwareTimeSpanCalculator<ProcessWaitingToEmit>(
				"Waiting time to emit (" + name + ")", MetricDescriptionConstants.WAITING_TIME_METRIC,
				MetricDescriptionConstants.WAITING_TIME_METRIC_TUPLE, context);
		this.numberOfDiscardedOutgoingElementsCalculator = new TriggerableCountingCalculator(
				"Discarded outgoing elements (" + name + ")", "Total discarded outgoing elements (" + name + ")",
				IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC,
				IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC_TUPLE,
				IndirectionsMetricDescriptionConstants.TOTAL_NUMBER_OF_ELEMENTS_METRIC_TUPLE, context);
		this.numberOfStoredOutgoingElementsCalculator = new TriggerableCountingCalculator(
				"Stored outgoing elements (" + name + ")", "Total stored outgoing elements (" + name + ")",
				IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC,
				IndirectionsMetricDescriptionConstants.NUMBER_OF_ELEMENTS_METRIC_TUPLE,
				IndirectionsMetricDescriptionConstants.TOTAL_NUMBER_OF_ELEMENTS_METRIC_TUPLE, context);
	}

	private void initializeQueues() {
		processesWaitingToConsume = new HashMap<>();
		for (DataSourceRole role : dataChannel.getDataSourceRoles())
			processesWaitingToConsume.put(role, new ArrayDeque<>());

		processesWaitingToEmit = new HashMap<>();
		for (DataSinkRole role : dataChannel.getDataSinkRoles())
			processesWaitingToEmit.put(role, new ArrayDeque<>());
	}

	protected void processDataAvailableToGet() {
		for (DataSourceRole dataSourceRole : dataChannel.getDataSourceRoles()) {
			if (canProvideData(dataSourceRole)) {
				if (IndirectionModelUtil.isPushingRole(dataSourceRole)) {
					spawnNewConsumerUsers(dataSourceRole);
				} else {
					notifyProcessesWaitingToGet(dataSourceRole);
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

	private void spawnNewConsumerUsers(DataSourceRole dataSourceRole) {
		IndirectionDate date = provideData(dataSourceRole);
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
			handleCannotProceedToPut(process);

			return false;
		}
	}
	
	protected final void blockUntilCanEmit(ProcessWaitingToEmit process) {
		processesWaitingToEmit.get(process.connector.getDataSinkRole()).add(process);
		process.passivate();
	}
	
	protected final void discardDataAndContinue(ProcessWaitingToEmit process) {
		waitingToEmitTimeCalculator.endMeasurement(process);
		
		IndirectionDate dateToDiscard = process.date;
		IndirectionSimulationUtil.getDataAgeRecursive(dateToDiscard)
			.forEach(discardedAgeCalculator::doMeasureUntilNow);
		
		numberOfDiscardedIncomingElementsCalculator.change(1);
		
		activateIfWaiting(process);
	}

	/* might be sensible to default this to blockUntilCanEmit */
	protected abstract void handleCannotProceedToPut(ProcessWaitingToEmit process);


	@Override
	public boolean get(ISchedulableProcess schedulableProcess, DataChannelSourceConnector connector,
			Consumer<IndirectionDate> callback) {
		if (!this.model.getSimulationControl().isRunning()) {
			return true;
		}

		if (IndirectionModelUtil.isPushingRole(connector.getDataSourceRole())) {
			throw new IllegalStateException("Cannot pull data over pushing role.");
		}

		ProcessWaitingToConsume process = new ProcessWaitingToConsume(this.model, schedulableProcess, connector,
				callback);

		this.waitingToConsumeTimeCalculator.startMeasurement(process);

		if (this.canProceedToGet(process)) {
			allowToGetAndActivate(process);
			notifyProcessesWaitingToPut();
			return true;
		} else {
			handleCannotProceedToGet(process);
			return false;
		}
	}
	
	protected final void blockUntilCanConsume(ProcessWaitingToConsume process) {
		processesWaitingToConsume.get(process.connector.getDataSourceRole()).add(process);
		process.passivate();
	}
	
	protected final void continueWithoutData(ProcessWaitingToConsume process) {
		// this does not put data on the stack (i.e., does not call the callback)
		waitingToConsumeTimeCalculator.endMeasurement(process);
		activateIfWaiting(process);
	}

	/* might be sensible to default this to blockUntilCanConsume */
	protected abstract void handleCannotProceedToGet(ProcessWaitingToConsume process);

	private void activateIfWaiting(SuspendableSchedulerEntity process) {
		if (process.isWaiting()) {
			process.activate();
		}
	}

	private boolean canProceedToPut(ProcessWaitingToEmit process) {
		DataSinkRole role = process.connector.getDataSinkRole();

		boolean isNextProcess = processesWaitingToEmit.isEmpty()
				|| processesWaitingToEmit.get(role).peek().schedulableProcess.equals(process.schedulableProcess);

		return isNextProcess && canAcceptData(role);
	}

	protected abstract boolean canAcceptData(DataSinkRole role);

	protected abstract boolean canProvideData(DataSourceRole role);

	private boolean canProceedToGet(ProcessWaitingToConsume process) {
		DataSourceRole role = process.connector.getDataSourceRole();

		boolean isNextProcess = processesWaitingToConsume.isEmpty()
				|| processesWaitingToConsume.get(role).peek().schedulableProcess.equals(process.schedulableProcess);

		return isNextProcess && canProvideData(role);
	}

	protected abstract IndirectionDate provideData(DataSourceRole role);

	protected abstract void acceptData(DataSinkRole role, IndirectionDate date);

	private void allowToGetAndActivate(ProcessWaitingToConsume process) {
		this.waitingToConsumeTimeCalculator.endMeasurement(process);

		IndirectionDate dateToEmit = provideData(process.connector.getDataSourceRole());
		IndirectionSimulationUtil.getDataAgeRecursive(dateToEmit)
				.forEach(beforeEmittingAgeCalculator::doMeasureUntilNow);
		process.callback.accept(dateToEmit);
		activateIfWaiting(process);
	}

	private void allowToPutAndActivate(ProcessWaitingToEmit process) {
		this.waitingToEmitTimeCalculator.endMeasurement(process);

		acceptData(process.connector.getDataSinkRole(), process.date);

		IndirectionSimulationUtil.getDataAgeRecursive(process.date)
				.forEach(afterAcceptingAgeCalculator::doMeasureUntilNow);

		activateIfWaiting(process);
	}
}
