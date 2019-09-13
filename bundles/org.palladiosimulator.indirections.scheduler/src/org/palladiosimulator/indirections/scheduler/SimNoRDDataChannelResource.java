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
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import com.google.common.base.Optional;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

public class SimNoRDDataChannelResource implements IDataChannelResource {
	protected final Queue<ProcessWaitingToGet> waitingToGetQueue;
	protected final Queue<ProcessWaitingToPut> waitingToPutQueue;
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
			if (SimNoRDDataChannelResource.this.isWindowingTriggeredPeriodically()) {
				this.key = SimNoRDDataChannelResource.this.model.getSimulationControl().getCurrentSimulationTime();
			} else {
				SimulatedStackframe<Object> simulatedStackframe = SimulatedStackHelper.createFromMap(frame);
				
				Object keyValue = null;
				try {
					keyValue = simulatedStackframe.getValue(SimNoRDDataChannelResource.this.collectWithHoldback.getKey());
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
	
	// takes elements of type T and emits something of type U if the state necessitates
	public interface StatefulEmitter<T, U> {
		public Optional<U> accept(T t);
	}
	
	// R: type of the key to check equality with
	public class EqualityCollectorWithHoldback<T, R> implements StatefulEmitter<T, List<T>> {
		// length of this collection is always <= n. holdback 1 means that if a new element arrives
		// the old collection is emitted. for holdback 2, a collection is only emitted, after 2 new (distinct)
		// elements have been seen.
		
		
		public Queue<List<T>> currentCollections = new ArrayDeque<List<T>>();
		private final int holdback;
		private final Function<T, R> keyFunction;
		
		
		public EqualityCollectorWithHoldback(Function<T, R> keyFunction, int holdback) {
			this.keyFunction = keyFunction;
			this.holdback = holdback;
		}
		
		@Override
		public Optional<List<T>> accept(T t) {
			for (List<T> collection : currentCollections) {
				R collectionKey = IndirectionUtil.claimEqualKey(collection, keyFunction);
				if (collectionKey.equals(keyFunction.apply(t))) {
					collection.add(t);
					return Optional.absent();
				}
			}

			List<T> newCollection = new ArrayList<T>();
			newCollection.add(t);
			currentCollections.add(newCollection);
			
			if (currentCollections.size() > holdback) {
				return Optional.of(currentCollections.remove());
			}
			
			return Optional.absent();
		}
	}
	
	public class WindowCalculator {
		public double size;
		public double shift;

		public Window currentWindow;
		public Window emittedWindow;

		public WindowCalculator(double size, double shift) {
			super();
			this.size = size;
			this.shift = shift;
		}

		public Window next() {
			currentWindow = createNextWindow();
			return currentWindow;
		}

		public Window createNextWindow() {
			if (currentWindow == null)
				return new Window(0, size);
			else
				return new Window(currentWindow.start + shift, currentWindow.start + shift + size);
		}

		public List<Window> advanceUntil(double currentSimulationTime) {
			List<Window> result = new ArrayList<>();
			while (currentSimulationTime >= createNextWindow().end) {
				result.add(next());
			}
			return result;
		}
	}
	
	public class WindowEmitter implements StatefulEmitter<Double, List<Window>> {
		private final WindowCalculator windowCalculator;

		public WindowEmitter(double size, double shift) {
			this.windowCalculator = new WindowCalculator(size, shift);
		}
		
		@Override
		public Optional<List<Window>> accept(Double t) {
			List<Window> windows = windowCalculator.advanceUntil(t);
			return windows.isEmpty() ? Optional.absent() : Optional.of(windows);
		}
		
	}

	public class Window {
		public final double start;
		public final double end;

		public Window(double start, double end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "W[" + start + "->" + end + "]";
		}

		public boolean contains(double timestamp) {
			return (start <= timestamp) && (end > timestamp);
		}
	}

	public SimNoRDDataChannelResource(DataChannel dataChannel, final SchedulerModel model) {
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

		this.windowing = dataChannel.getTimeGrouping() instanceof Windowing ? (Windowing) dataChannel.getTimeGrouping() : null;
		this.collectWithHoldback = dataChannel.getTimeGrouping() instanceof CollectWithHoldback ? (CollectWithHoldback) dataChannel.getTimeGrouping() : null;
		this.collectAll = dataChannel.getTimeGrouping() instanceof ConsumeAllAvailable;
		
		this.partitioning = dataChannel.getPartitioning();
		
		if (isWindowingTriggeredOnIncoming()) {
			this.outgoingEmitter = new EqualityCollectorWithHoldback<KeyedFrame, Object>((it) -> it.key, this.collectWithHoldback.getHoldback());
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
		// currently we distinguish between periodically triggered and on-demand windowing by:
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
			System.out.println("Checking " + incomingQueue.size() + " elements "
					+ "(last seen: " + lastCheckedFrameId + ", "
					+ "head: " + incomingQueue.get(0).id + ", "
					+ "last: " + incomingQueue.get(incomingQueue.size() - 1).id + ").");
			for (KeyedFrame element : incomingQueue) {
				if (element.id <= lastCheckedFrameId)
					continue;
				
				lastCheckedFrameId = element.id;
				
				Optional<List<KeyedFrame>> result = outgoingEmitter.accept(element);
				if (result.isPresent()) {
					System.out.println("Emitting grouping for " + result.get().size() + " frames (at "
							+ model.getSimulationControl().getCurrentSimulationTime() + "):");
					Object key = IndirectionUtil.claimEqual(result.get().stream().map((it) -> it.key).collect(Collectors.toList()));
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
	

	/**
	 * Creates outgoing elements from the currently queued items. Respects windowing
	 * and partitioning.
	 */
/*	protected void createOutgoingElements() {
 		double timeToAdvanceWindowingTo = getTimeToAdvanceWindowingTo();
		
		Optional<List<Window>> windows = outgoingEmitter.accept(timeToAdvanceWindowingTo);
		if (!windows.isPresent())
			return;

		for (Window window : windows.get()) {
			System.out.println("Creating window " + window.toString() + " (at "
					+ model.getSimulationControl().getCurrentSimulationTime() + ")");
			Map<String, Object> windowFrame = createCollectionFrame();

			// TODO: take timestamp from element instead of "current simulation time"?
			Map<Object, Map<String, List<Object>>> partitionToWindowedVariableToValues = new HashMap<>();
			for (KeyedFrame frame : incomingElementsInWindow(window)) {
				Map<String, Object> map = frame.frame;
				Object partition = getPartition(map);
				Map<String, List<Object>> windowedVariables = partitionToWindowedVariableToValues
						.computeIfAbsent(partition, it -> new HashMap<>());
				for (Entry<String, Object> entry : map.entrySet()) {
					List<Object> valuesForKey = windowedVariables.computeIfAbsent(entry.getKey(),
							it -> new ArrayList<>());
					valuesForKey.add(entry.getValue());
				}
				discardIncomingElementsOlderThan(window.start);
			}

			for (Entry<Object, Map<String, List<Object>>> partitionEntry : partitionToWindowedVariableToValues
					.entrySet()) {
				Object partition = partitionEntry.getKey();
				Map<String, List<Object>> windowedVariables = partitionEntry.getValue();

				windowFrame.put(getOutgoingParameterName() + ".PARTITION", partition);
				windowFrame.put(getOutgoingParameterName() + ".WINDOW", window);
				windowFrame.put(getOutgoingParameterName() + ".NUMBER_OF_ELEMENTS", IndirectionUtil
						.claimEqual(windowedVariables.values().stream().map(List::size).collect(Collectors.toList())));

				for (Entry<String, List<Object>> entry : windowedVariables.entrySet()) {
					String key = rewriteVariableNamePrefix(entry.getKey());
					List<Object> value = entry.getValue();
					windowFrame.put(key + ".INNER.VALUE", value);

					if (value.stream().allMatch(Number.class::isInstance)) {
						DoubleSummaryStatistics statistics = value.stream()
								.mapToDouble(it -> ((Number) it).doubleValue()).summaryStatistics();
						windowFrame.put(key + ".min.VALUE", statistics.getMin());
						windowFrame.put(key + ".max.VALUE", statistics.getMax());
						windowFrame.put(key + ".average.VALUE", statistics.getAverage());
					}
				}

				System.out.println(windowFrame);
				outgoingQueue.add(windowFrame);
			}
		}
		notifyProcessesWaitingToGet();
	}*/

	private Object getPartition(Map<String, Object> map) {
		if (partitioning == null)
			return DUMMY_KEY;
		
		SimulatedStackframe<Object> stack = SimulatedStackHelper.createFromMap(map);
		
		return partitioning.getSpecification().stream()
				.collect(Collectors.toMap(
						it -> it.getSpecification(),
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
		return getOneParameter(dataChannel.getSourceEventGroup()).getParameterName();
	}

	private String getIncomingParameterName() {
		return getOneParameter(dataChannel.getSinkEventGroup()).getParameterName();
	}

	private void allowToPut(ProcessWaitingToPut process) {
		if (collectAll) {
			System.out.println("Collecting all -> adding to outgoing group.");
			addToOutgoingFrame(process.frame);
		} else if (isWindowingTriggeredOnIncoming()) {
			KeyedFrame newFrame = new KeyedFrame(process.frame);
			incomingQueue.add(newFrame);
			System.out.println("Added frame @ " + newFrame.key + ": " + newFrame.frame + ". Directly triggering creation.");
			createAllCurrentlyOutgoingElements();
		} else if (isWindowingTriggeredPeriodically()) {
			KeyedFrame newFrame = new KeyedFrame(process.frame);
			incomingQueue.add(newFrame);
			System.out.println("Added frame @ " + newFrame.key + ": " + newFrame.frame + ". Doing nothing, waiting for timed creation.");
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
	
	private void allowToGet(ProcessWaitingToGet process) {
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
			//processExtractor.apply(waitingProcess).activate();

			waitingProcess = processes.peek();
		}
	}

	@Override
	public boolean put(ISchedulableProcess schedulableProcess, Map<String, Object> eventStackframe) {
		validateStackframeStructure(eventStackframe, getIncomingParameterName());

		if (!model.getSimulationControl().isRunning()) {
			return true;
		}

		final ProcessWaitingToPut process = new ProcessWaitingToPut(model, schedulableProcess, eventStackframe);
		if (canProceedToPut(process)) {
			allowToPut(process);
			return true;
		} else {
			waitingToPutQueue.add(process);
			process.passivate();
			return false;
		}
	}

	private void validateStackframeStructure(Map<String, Object> dataMap, String parameterName) {
		String parameterCharacterisationPrefix = parameterName + ".";

		for (Entry<String, Object> entry : dataMap.entrySet()) {
			if (!entry.getKey().startsWith(parameterCharacterisationPrefix)) {
				throw new IllegalArgumentException("Invalid characteristation for data frame: " + entry.getKey()
						+ ", expected characteristations for " + parameterName);
			}
		}
	}

	private Parameter getOneParameter(EventGroup eventGroup) {
		return IndirectionUtil.claimOne(eventGroup.getEventTypes__EventGroup()).getParameter__EventType();
	}

	@Override
	public boolean get(ISchedulableProcess schedulableProcess, Consumer<Map<String, Object>> callback) {
//		System.out.println("Process is trying to get.");
		if (!model.getSimulationControl().isRunning()) {
			return true;
		}

		final ProcessWaitingToGet process = new ProcessWaitingToGet(model, schedulableProcess, callback);
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

	private boolean canProceedToPut(final ProcessWaitingToPut process) {
		boolean isNextProcess = waitingToPutQueue.isEmpty()
				|| waitingToPutQueue.peek().schedulableProcess.equals(process.schedulableProcess);
		if (capacity == -1) {
			return isNextProcess;
		} else {
			long acceptableCount = capacity - incomingQueue.size();
			return isNextProcess && (acceptableCount > 0);
		}
	}

	private boolean canProceedToGet(final ProcessWaitingToGet process) {
		boolean isNextProcess = waitingToGetQueue.isEmpty()
				|| waitingToGetQueue.peek().schedulableProcess.equals(process.schedulableProcess);
		long providableCount = outgoingQueue.size();
		return isNextProcess && (providableCount > 0);
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

	@Override
	public long getCapacity() {
		return this.capacity;
	}

	@Override
	public long getAvailable() {
		return capacity - this.incomingQueue.size();
	}
}
