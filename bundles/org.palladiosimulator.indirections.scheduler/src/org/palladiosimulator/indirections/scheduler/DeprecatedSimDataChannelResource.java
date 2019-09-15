package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
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
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.util.IterableUtil;
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

@Deprecated // only use during rewrite
public class DeprecatedSimDataChannelResource extends AbstractDistributingSimDataChannelResource {
	private final Windowing windowing;
	private final Partitioning partitioning;
	private PeriodicallyTriggeredSimulationEntity windowingTrigger;

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
			if (DeprecatedSimDataChannelResource.this.isWindowingTriggeredPeriodically()) {
				this.key = DeprecatedSimDataChannelResource.this.model.getSimulationControl().getCurrentSimulationTime();
			} else {
				SimulatedStackframe<Object> simulatedStackframe = SimulatedStackHelper.createFromMap(frame);

				Object keyValue = null;
				try {
					keyValue = simulatedStackframe.getValue(DeprecatedSimDataChannelResource.this.collectWithHoldback.getKey());
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

	public DeprecatedSimDataChannelResource(DataChannel dataChannel, final SchedulerModel model) {
		super(dataChannel, model);

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
			this.outgoingQueues.forEach((k, v) -> v.elements.add(createCollectionFrame()));
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
			outgoingQueues.forEach((k, v) -> v.elements.add(outgoingFrame));
		}
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

	@Override
	protected void allowToPut(ProcessWaitingToEmit process) {
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
			outgoingQueues.forEach((k, v) -> v.elements.add(process.frame));
		}

		if (process.isWaiting())
			process.activate();
	}

	@Override
	protected void allowToGet(ProcessWaitingToConsume process) {
		process.callback.accept(getNextAvailableElement(process.sinkConnector));
		if (process.isWaiting())
			process.activate();
	}

	private void addToOutgoingFrame(Map<String, Object> frame) {
		if (outgoingQueues.values().stream().anyMatch(it -> it.elements.size() != 1)) {
			throw new AssertionError("Queue must contain exactly one element at all times if collect all is true.");
		}

		for (OutgoingQueue outgoingQueue : outgoingQueues.values()) {
			Map<String, Object> collectionFrame = outgoingQueue.elements.remove();
			addToCollectionFrame(collectionFrame, frame);
			outgoingQueue.elements.add(collectionFrame);
		}
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

	private Map<String, Object> getNextAvailableElement(DataChannelSinkConnector sinkConnector) {
		Map<String, Object> nextAvailableElement = outgoingQueues.get(sinkConnector).elements.remove();
		if (collectAll)
			outgoingQueues.get(sinkConnector).elements.add(createCollectionFrame());

		return nextAvailableElement;
	}
}
