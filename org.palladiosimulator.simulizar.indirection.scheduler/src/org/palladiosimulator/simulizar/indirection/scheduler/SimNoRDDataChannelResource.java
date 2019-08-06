package org.palladiosimulator.simulizar.indirection.scheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.simulizar.indirection.datatypes.WindowingTimeMode;
import org.palladiosimulator.simulizar.indirection.partitioning.ConsumeAllAvailable;
import org.palladiosimulator.simulizar.indirection.partitioning.Partitioning;
import org.palladiosimulator.simulizar.indirection.partitioning.Windowing;
import org.palladiosimulator.simulizar.indirection.system.DataChannel;
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import com.google.common.base.Optional;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimNoRDDataChannelResource implements IDataChannelResource {
	protected final Queue<ProcessWaitingToGet> waitingToGetQueue;
	protected final Queue<ProcessWaitingToPut> waitingToPutQueue;
	protected final List<TimestampedFrame> incomingQueue;
	protected final Queue<Map<String, Object>> outgoingQueue;

	private final SimuComModel model;
	private final int capacity;
	private final Windowing windowing;
	private final Partitioning partitioning;
	private PeriodicallyTriggeredSimulationEntity windowingTrigger;
	private final DataChannel dataChannel;

	public WindowGenerator windowGenerator;
	private boolean collectAll;

	public class TimestampedFrame {
		public final double timestamp;
		public final Map<String, Object> frame;

		public TimestampedFrame(Map<String, Object> frame) {
			this.timestamp = SimNoRDDataChannelResource.this.model.getSimulationControl().getCurrentSimulationTime();
			this.frame = frame;
		}

	}

	public class WindowGenerator {
		public double size;
		public double shift;

		public Window currentWindow;
		public Window emittedWindow;

		public WindowGenerator(double size, double shift) {
			super();
			this.size = size;
			this.shift = shift;
		}

		public Window next() {
			Window nextWindow = createNextWindow();
			if (currentWindow != null) {
				currentWindow.next = nextWindow;
				nextWindow.previous = currentWindow;
			}
			currentWindow = nextWindow;

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

	public class Window {
		public Window previous;
		public Window next;

		public final double start;
		public final double end;

		public Window(double start, double end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "W[start=" + start + ", end=" + end + ", previous="
					+ Optional.fromNullable(previous).transform(Window::startAndEndToString).or("null") + ", next="
					+ Optional.fromNullable(next).transform(Window::startAndEndToString).or("null") + "]";
		}

		private String startAndEndToString() {
			return "W[start=" + start + ", end=" + end + "]";
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
		this.collectAll = dataChannel.getTimeGrouping() instanceof ConsumeAllAvailable;
		
		this.partitioning = dataChannel.getPartitioning();
		if (windowing != null && windowing.getTimeMode() != WindowingTimeMode.WALL_CLOCK) {
			throw new IllegalArgumentException(
					"Currently, only the WindowingTimeMode " + WindowingTimeMode.WALL_CLOCK + " can be simulated.");
		}

		if (windowing != null) {
			this.windowGenerator = new WindowGenerator(windowing.getSize(), windowing.getShift());
			this.windowingTrigger = new PeriodicallyTriggeredSimulationEntity(this.model, 0, windowing.getShift()) {
				@Override
				protected void triggerInternal() {
					createOutgoingElements();
				}
			};
		}
		
		if (collectAll) {
			this.outgoingQueue.add(createCollectionFrame());
		}
	}

	private final static Object DUMMY_KEY = UUID.randomUUID();

	/**
	 * Creates outgoing elements from the currently queued items. Respects windowing
	 * and partitioning.
	 */
	protected void createOutgoingElements() {
		List<Window> windows = windowGenerator.advanceUntil(model.getSimulationControl().getCurrentSimulationTime());

		for (Window window : windows) {
			System.out.println("Creating window " + window.toString() + " (at "
					+ model.getSimulationControl().getCurrentSimulationTime() + ")");
			Map<String, Object> windowFrame = createCollectionFrame();

			// TODO: take timestamp from element instead of "current simulation time"?
			Map<Object, Map<String, List<Object>>> partitionToWindowedVariableToValues = new HashMap<>();
			for (TimestampedFrame frame : incomingElementsInWindow(window)) {
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
	}

	private Object getPartition(Map<String, Object> map) {
		return partitioning == null ? DUMMY_KEY
				: Context.evaluateStatic(partitioning.getSpecification().getSpecification(),
						SimulatedStackHelper.createFromMap(map));
	}

	private void discardIncomingElementsOlderThan(double start) {
		incomingQueue.removeIf(it -> it.timestamp < start);
	}

	private List<TimestampedFrame> incomingElementsInWindow(Window window) {
		return incomingQueue.stream().filter(it -> window.contains(it.timestamp)).collect(Collectors.toList());
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
			addToOutgoingFrame(process.frame);
		} else if (windowing == null) {
			outgoingQueue.add(process.frame);
		} else {
			incomingQueue.add(new TimestampedFrame(process.frame));
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
			allow.accept(waitingProcess);
			processes.remove();
			processExtractor.apply(waitingProcess).activate();

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
		if (!model.getSimulationControl().isRunning()) {
			return true;
		}

		final ProcessWaitingToGet process = new ProcessWaitingToGet(model, schedulableProcess, callback);
		if (canProceedToGet(process)) {
			allowToGet(process);
			return true;
		} else {
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
