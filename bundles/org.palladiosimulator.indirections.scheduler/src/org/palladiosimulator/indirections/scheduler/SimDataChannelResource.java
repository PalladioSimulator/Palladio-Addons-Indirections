package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.partitioning.CollectWithHoldback;
import org.palladiosimulator.indirections.partitioning.ConsumeAllAvailable;
import org.palladiosimulator.indirections.partitioning.Partitioning;
import org.palladiosimulator.indirections.partitioning.Windowing;
import org.palladiosimulator.indirections.scheduler.Emitters.EqualityCollectorWithHoldback;
import org.palladiosimulator.indirections.scheduler.Emitters.StatefulEmitter;
import org.palladiosimulator.indirections.scheduler.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.Emitters.WindowEmitter;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.scheduler.util.IndirectionUtil;
import org.palladiosimulator.indirections.scheduler.util.IterableUtil;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import com.google.common.base.Optional;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

public class SimDataChannelResource implements IDataChannelResource {
	protected final Queue<ProcessWaitingToConsume> waitingToGetQueue;
	protected final Queue<ProcessWaitingToEmit> waitingToPutQueue;
	protected final List<KeyedFrame> incomingQueue;
	protected final Queue<Map<String, Object>> outgoingQueue;

	private final SimuComModel model;
	private final int capacity;
	private final Windowing windowing;
	private final Partitioning partitioning;
	private PeriodicallyTriggeredSimulationEntity windowingTrigger;
	private final DataChannel dataChannel;

	private boolean collectAll;
	private StatefulEmitter<KeyedFrame, List<KeyedFrame>> outgoingEmitter;
	private WindowEmitter windowEmitter;
	private CollectWithHoldback collectWithHoldback;

	private long lastCheckedFrameId = -1L;
	private long numberOfFramesCreated = 0L;

	public class KeyedFrame {
		public final Object key;
		public final Map<String, Object> frame;
		public final long id;

		public KeyedFrame(Map<String, Object> frame) {
			if (SimDataChannelResource.this.isWindowingTriggeredPeriodically()) {
				this.key = SimDataChannelResource.this.model.getSimulationControl().getCurrentSimulationTime();
			} else {
				SimulatedStackframe<Object> simulatedStackframe = SimulatedStackHelper.createFromMap(frame);

				Object keyValue = null;
				try {
					keyValue = simulatedStackframe.getValue(SimDataChannelResource.this.collectWithHoldback.getKey());
				} catch (ValueNotInFrameException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.key = keyValue;
			}
			this.frame = frame;
			this.id = numberOfFramesCreated += 1;
		}

		@Override
		public String toString() {
			return "KeyedFrame[id=" + id + ", key=" + key + ", frame=" + frame + "]";
		}

	}

	// takes elements of type T and emits something of type U if the state
	// necessitates

	public SimDataChannelResource(DataChannel dataChannel, final SchedulerModel model) {
		if (!(model instanceof SimuComModel)) {
			throw new IllegalArgumentException("Currently only works with " + SimuComModel.class.getName() + ", got "
					+ model.getClass().getName());
		}

		this.model = (SimuComModel) model;
		waitingToGetQueue = new ArrayDeque<>();
		waitingToPutQueue = new ArrayDeque<>();
		incomingQueue = new ArrayList<>();
		outgoingQueue = new ArrayDeque<>();
		this.dataChannel = dataChannel;
		this.capacity = dataChannel.getCapacity();

		this.windowing = dataChannel.getTimeGrouping() instanceof Windowing ? (Windowing) dataChannel.getTimeGrouping()
				: null;
		this.collectWithHoldback = dataChannel.getTimeGrouping() instanceof CollectWithHoldback
				? (CollectWithHoldback) dataChannel.getTimeGrouping()
				: null;
		this.collectAll = dataChannel.getTimeGrouping() instanceof ConsumeAllAvailable;

		this.partitioning = dataChannel.getPartitioning();

		if (isWindowingTriggeredOnIncoming()) {
			this.outgoingEmitter = new EqualityCollectorWithHoldback<KeyedFrame, Object>((it) -> it.key,
					this.collectWithHoldback.getHoldback());
		} else if (isWindowingTriggeredPeriodically()) {
			if (isWindowingTriggeredPeriodically()) {
				this.windowEmitter = new WindowEmitter(windowing.getShift(), windowing.getShift());
				this.windowingTrigger = new PeriodicallyTriggeredSimulationEntity(this.model, 0, windowing.getShift()) {
					@Override
					protected void triggerInternal() {
						createAllCurrentlyOutgoingElements();
					}
				};
			}
		}

		if (collectAll) {
			this.outgoingQueue.add(createCollectionFrame());
		}
	}

	private final static Object DUMMY_KEY = UUID.randomUUID();

	private boolean isWindowingTriggeredOnIncoming() {
		// currently we distinguish between periodically triggered and on-demand
		// windowing by:
		// "is a time provider set?"
		// could also be done by different subclasses for a TimeProvider interface
		return (this.collectWithHoldback != null);
	}

	private boolean isWindowingTriggeredPeriodically() {
		return (this.windowing != null);
	}

	private double getTimeToAdvanceWindowingTo() {
		return model.getSimulationControl().getCurrentSimulationTime();
	}

	private Map<Object, List<KeyedFrame>> createPartitions(List<KeyedFrame> elements) {
		return elements.stream().collect(Collectors.groupingBy(it -> getPartition(it.frame)));
	}

	private List<Map<String, Object>> createGroupOfOutgoingFrames(List<KeyedFrame> elements, Object key) {
		Map<Object, List<KeyedFrame>> partitions = createPartitions(elements);
		List<Map<String, Object>> result = new ArrayList<>();
		for (Entry<Object, List<KeyedFrame>> entry : partitions.entrySet()) {
			Map<String, Object> windowFrame = createCollectionFrame();
			windowFrame.put(getOutgoingParameterName() + ".PARTITION", entry.getKey());
			windowFrame.put(getOutgoingParameterName() + ".KEY", key);
			windowFrame.put(getOutgoingParameterName() + ".NUMBER_OF_ELEMENTS", entry.getValue().size());
			windowFrame.put(getOutgoingParameterName() + ".INNER", entry.getValue());
			result.add(windowFrame);
		}

		return result;
	}

	protected void createAllCurrentlyOutgoingElements() {
		Set<KeyedFrame> flaggedForRemoval = new HashSet<KeyedFrame>();
		List<Map<String, Object>> outgoingFrames = new ArrayList<>();

		if (isWindowingTriggeredPeriodically()) {
			Optional<List<Window>> windows = windowEmitter.accept(getTimeToAdvanceWindowingTo());
			if (windows.isPresent()) {
				for (Window window : windows.get()) {
					System.out.println("Creating window " + window.toString() + " (at "
							+ model.getSimulationControl().getCurrentSimulationTime() + ")");
					List<KeyedFrame> elementsInWindow = incomingElementsInWindow(window);
					outgoingFrames.addAll(createGroupOfOutgoingFrames(elementsInWindow, window));
					flaggedForRemoval.addAll(elementsInWindow);
				}
			}
		} else if (isWindowingTriggeredOnIncoming()) {
			System.out.println("Checking " + incomingQueue.size() + " elements " + "(last seen: " + lastCheckedFrameId
					+ ", " + "head: " + incomingQueue.get(0).id + ", " + "last: "
					+ incomingQueue.get(incomingQueue.size() - 1).id + ").");
			for (KeyedFrame element : incomingQueue) {
				if (element.id <= lastCheckedFrameId)
					continue;

				lastCheckedFrameId = element.id;

				Optional<List<KeyedFrame>> result = outgoingEmitter.accept(element);
				if (result.isPresent()) {
					System.out.println("Emitting grouping for " + result.get().size() + " frames (at "
							+ model.getSimulationControl().getCurrentSimulationTime() + "):");
					Object key = IterableUtil
							.claimEqual(result.get().stream().map((it) -> it.key).collect(Collectors.toList()));
					List<Map<String, Object>> newOutgoingFrames = createGroupOfOutgoingFrames(result.get(), key);
					outgoingFrames.addAll(newOutgoingFrames);
					newOutgoingFrames.forEach(it -> System.out.println(" - " + it));
					flaggedForRemoval.addAll(result.get());
				}
			}
		}

		for (KeyedFrame frameToRemove : flaggedForRemoval) {
			incomingQueue.remove(frameToRemove);
		}

		for (Map<String, Object> outgoingFrame : outgoingFrames) {
			outgoingQueue.add(outgoingFrame);
		}

		notifyProcessesWaitingToGet();
	}

	private Object getPartition(Map<String, Object> map) {
		if (partitioning == null)
			return DUMMY_KEY;

		SimulatedStackframe<Object> stack = SimulatedStackHelper.createFromMap(map);

		return partitioning.getSpecification().stream().collect(Collectors.toMap(it -> it.getSpecification(),
				it -> Context.evaluateStatic(it.getSpecification(), stack)));
	}

	private List<KeyedFrame> incomingElementsInWindow(Window window) {
		return incomingQueue.stream().filter(it -> window.contains((double) it.key)).collect(Collectors.toList());
	}

	/**
	 * Changes the prefix in the given variable name from the parameter name of the
	 * incoming event type to the one of the outgoing event type.
	 */
	private String rewriteVariableNamePrefix(String variableName) {
		if (variableName.startsWith(getIncomingParameterName())) {
			return getOutgoingParameterName() + variableName.substring(getIncomingParameterName().length());
		} else {
			throw new AssertionError("Variable '" + variableName + "' does not start with incoming paramete name: "
					+ getIncomingParameterName());
		}
	}

	private String getOutgoingParameterName() {
		return IndirectionUtil.getOneParameter(dataChannel.getSourceEventGroup()).getParameterName();
	}

	private String getIncomingParameterName() {
		return IndirectionUtil.getOneParameter(dataChannel.getSinkEventGroup()).getParameterName();
	}

	private void allowToPut(ProcessWaitingToEmit process) {
		if (collectAll) {
			System.out.println("Collecting all -> adding to outgoing group.");
			addToOutgoingFrame(process.frame);
		} else if (isWindowingTriggeredOnIncoming()) {
			KeyedFrame newFrame = new KeyedFrame(process.frame);
			incomingQueue.add(newFrame);
			System.out.println(
					"Added frame @ " + newFrame.key + ": " + newFrame.frame + ". Directly triggering creation.");
			createAllCurrentlyOutgoingElements();
		} else if (isWindowingTriggeredPeriodically()) {
			KeyedFrame newFrame = new KeyedFrame(process.frame);
			incomingQueue.add(newFrame);
			System.out.println("Added frame @ " + newFrame.key + ": " + newFrame.frame
					+ ". Doing nothing, waiting for timed creation.");
		} else {
			System.out.println("Added frame directly: " + process.frame);
			outgoingQueue.add(process.frame);
		}

		if (process.isWaiting())
			process.activate();
		notifyProcessesWaitingToGet();
	}

	private void addToOutgoingFrame(Map<String, Object> frame) {
		if (outgoingQueue.size() != 1) {
			throw new AssertionError("Queue must contain exactly one element at all times if collect all is true.");
		}

		Map<String, Object> collectionFrame = outgoingQueue.remove();
		addToCollectionFrame(collectionFrame, frame);
		outgoingQueue.add(collectionFrame);
	}

	private HashMap<String, Object> createCollectionFrame() {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("data.INNER.VALUE", new ArrayList<Map<String, Object>>());
		result.put("data.INNER.NUMBER_OF_ELEMENTS", 0);

		return result;
	}

	private void addToCollectionFrame(Map<String, Object> collectionFrame, Map<String, Object> frame) {
		List<Map<String, Object>> inner = (List<Map<String, Object>>) collectionFrame.get("data.INNER.VALUE");
		Integer numberOfElements = (Integer) collectionFrame.get("data.INNER.NUMBER_OF_ELEMENTS");

		inner.add(frame);
		numberOfElements++;

		collectionFrame.put("data.INNER.NUMBER_OF_ELEMENTS", numberOfElements);
	}

	private void allowToGet(ProcessWaitingToConsume process) {
		process.callback.accept(getNextAvailableElement());
		if (process.isWaiting())
			process.activate();
		notifyProcessesWaitingToPut();
	}

	private Map<String, Object> getNextAvailableElement() {
		Map<String, Object> nextAvailableElement = outgoingQueue.remove();
		if (collectAll)
			outgoingQueue.add(createCollectionFrame());

		return nextAvailableElement;
	}

	private void notifyProcessesWaitingToGet() {
		notifyProcesses(waitingToGetQueue, p -> p.schedulableProcess, this::canProceedToGet, this::allowToGet);
	}

	private void notifyProcessesWaitingToPut() {
		notifyProcesses(waitingToPutQueue, p -> p.schedulableProcess, this::canProceedToPut, this::allowToPut);
	}

	private <T> void notifyProcesses(Queue<T> processes, Function<T, ISchedulableProcess> processExtractor,
			Predicate<T> canProceed, Consumer<T> allow) {

		T waitingProcess = processes.peek();
		while (waitingProcess != null && canProceed.test(waitingProcess)) {
//			System.out.println("Allowing waiting process.");
			allow.accept(waitingProcess);
			processes.remove();
			// processExtractor.apply(waitingProcess).activate();

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
			return true;
		} else {
			waitingToPutQueue.add(process);
			process.passivate();
			return false;
		}
	}

	@Override
	public boolean get(ISchedulableProcess schedulableProcess, Consumer<Map<String, Object>> callback) {
//		System.out.println("Process is trying to get.");
		if (!model.getSimulationControl().isRunning()) {
			return true;
		}

		final ProcessWaitingToConsume process = new ProcessWaitingToConsume(model, schedulableProcess, callback);
		if (canProceedToGet(process)) {
//			System.out.println("Can take directly.");
			allowToGet(process);
			return true;
		} else {
//			System.out.println("Adding to queue.");
			waitingToGetQueue.add(process);
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
		boolean isNextProcess = waitingToGetQueue.isEmpty()
				|| waitingToGetQueue.peek().schedulableProcess.equals(process.schedulableProcess);
		long providableCount = outgoingQueue.size();
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

	@Override
	public AssemblyContext getAssemblyContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
