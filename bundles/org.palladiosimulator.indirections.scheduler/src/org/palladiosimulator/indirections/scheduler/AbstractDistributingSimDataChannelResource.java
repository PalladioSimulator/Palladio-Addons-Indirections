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

	public AbstractDistributingSimDataChannelResource(DataChannel dataChannel, final SchedulerModel model) {
		if (!(model instanceof SimuComModel)) {
			throw new IllegalArgumentException("Currently only works with " + SimuComModel.class.getName() + ", got "
					+ model.getClass().getName());
		}

		this.dataChannel = dataChannel;
		
		this.id = dataChannel.getId() + "_" + UUID.randomUUID().toString();
		this.name = dataChannel.getEntityName() + "_" + this.getClass().getSimpleName();
		
		this.capacity = dataChannel.getCapacity();

		this.model = (SimuComModel) model;

		waitingToPutQueue = new ArrayDeque<>();
		incomingQueue = new ArrayList<>();

		initializeOutgoingQueues();
	}

	private void initializeOutgoingQueues() {
		outgoingQueues = new HashMap<>();
		dataChannel.getDataChannelSinkConnector().stream().forEach(it -> outgoingQueues.put(it, new OutgoingQueue()));
	}

	private void notifyProcessesWaitingToGet() {
		for (OutgoingQueue queue : outgoingQueues.values()) {
			notifyProcesses(queue.processes, p -> p.schedulableProcess, this::canProceedToGet, this::allowToGet,
					this::notifyProcessesWaitingToPut);
		}
	}

	private void notifyProcessesWaitingToPut() {
		notifyProcesses(waitingToPutQueue, p -> p.schedulableProcess, this::canProceedToPut, this::allowToPut,
				this::notifyProcessesWaitingToGet);
	}

	private <T> void notifyProcesses(Queue<T> processes, Function<T, ISchedulableProcess> processExtractor,
			Predicate<T> canProceed, Consumer<T> allow, Runnable callAfterAllowing) {

		T waitingProcess = processes.peek();
		while (waitingProcess != null && canProceed.test(waitingProcess)) {
			allow.accept(waitingProcess);
			callAfterAllowing.run();
			processes.remove();
			waitingProcess = processes.peek();
		}
	}

	@Override
	public boolean put(ISchedulableProcess schedulableProcess, Map<String, Object> eventStackframe) {
		IndirectionUtil.validateStackframeStructure(eventStackframe, getIncomingParameterName());

		if (!model.getSimulationControl().isRunning()) {
			return true;
		}

		final ProcessWaitingToEmit process = new ProcessWaitingToEmit(model, schedulableProcess, eventStackframe);
		if (canProceedToPut(process)) {
			allowToPut(process);
			notifyProcessesWaitingToGet();
			return true;
		} else {
			waitingToPutQueue.add(process);
			process.passivate();
			return false;
		}
	}

	@Override
	public boolean get(ISchedulableProcess schedulableProcess, DataChannelSinkConnector sinkConnector,
			Consumer<Map<String, Object>> callback) {
		if (!model.getSimulationControl().isRunning()) {
			return true;
		}

		if (sinkConnector.getDataSinkRole().isIsPushing()) {
			throw new IllegalStateException("Cannot pull data over pushing connector " + sinkConnector.toString()
					+ ", SinkRole: " + sinkConnector.getDataSinkRole().toString());
		}

		final ProcessWaitingToConsume process = new ProcessWaitingToConsume(model, schedulableProcess, sinkConnector,
				callback);
		if (canProceedToGet(process)) {
			allowToGet(process);
			notifyProcessesWaitingToPut();
			return true;
		} else {
			outgoingQueues.get(sinkConnector).processes.add(process);
			process.passivate();
			return false;
		}
	}

	private boolean canProceedToPut(final ProcessWaitingToEmit process) {
		boolean isNextProcess = waitingToPutQueue.isEmpty()
				|| waitingToPutQueue.peek().schedulableProcess.equals(process.schedulableProcess);
		if (capacity == -1) {
			return isNextProcess;
		} else {
			long acceptableCount = capacity - incomingQueue.size();
			return isNextProcess && (acceptableCount > 0);
		}
	}

	private boolean canProceedToGet(final ProcessWaitingToConsume process) {
		Queue<ProcessWaitingToConsume> waitingToGetQueue = outgoingQueues.get(process.sinkConnector).processes;
		boolean isNextProcess = waitingToGetQueue.isEmpty()
				|| waitingToGetQueue.peek().schedulableProcess.equals(process.schedulableProcess);
		long providableCount = outgoingQueues.get(process.sinkConnector).elements.size();
		return isNextProcess && (providableCount > 0);
	}

	@Override
	public long getCapacity() {
		return this.capacity;
	}

	@Override
	public long getAvailable() {
		return capacity - this.incomingQueue.size();
	}

	protected abstract void allowToGet(ProcessWaitingToConsume process);

	protected abstract void allowToPut(ProcessWaitingToEmit process);

	protected String getOutgoingParameterName() {
		return IndirectionUtil.getOneParameter(dataChannel.getSourceEventGroup()).getParameterName();
	}

	protected String getIncomingParameterName() {
		return IndirectionUtil.getOneParameter(dataChannel.getSinkEventGroup()).getParameterName();
	}
}
