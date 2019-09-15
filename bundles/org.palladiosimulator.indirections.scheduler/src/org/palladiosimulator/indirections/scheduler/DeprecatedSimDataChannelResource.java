package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
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
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

@Deprecated // only use during rewrite
public class DeprecatedSimDataChannelResource {} /*extends AbstractDistributingSimDataChannelResource {
    private final Windowing windowing;
    private final Partitioning partitioning;
    private PeriodicallyTriggeredSimulationEntity windowingTrigger;

    private final boolean collectAll;
    private StatefulEmitter<KeyedFrame, List<KeyedFrame>> outgoingEmitter;
    private WindowEmitter windowEmitter;
    private final CollectWithHoldback collectWithHoldback;

    private long lastCheckedFrameId = -1L;
    private long numberOfFramesCreated = 0L;

    public class KeyedFrame {
        public final Object key;
        public final IndirectionDate frame;
        public final long id;

        public KeyedFrame(final IndirectionDate frame) {
            if (DeprecatedSimDataChannelResource.this.isWindowingTriggeredPeriodically()) {
                this.key = DeprecatedSimDataChannelResource.this.model.getSimulationControl()
                        .getCurrentSimulationTime();
            } else {
                final SimulatedStackframe<Object> simulatedStackframe = SimulatedStackHelper.createFromMap(frame.data);

                Object keyValue = null;
                try {
                    keyValue = simulatedStackframe
                            .getValue(DeprecatedSimDataChannelResource.this.collectWithHoldback.getKey());
                } catch (final ValueNotInFrameException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                this.key = keyValue;
            }
            this.frame = frame;
            this.id = DeprecatedSimDataChannelResource.this.numberOfFramesCreated += 1;
        }

        @Override
        public String toString() {
            return "KeyedFrame[id=" + this.id + ", key=" + this.key + ", frame=" + this.frame + "]";
        }

    }

    public DeprecatedSimDataChannelResource(final DataChannel dataChannel, final SchedulerModel model) {
        super(dataChannel, model);

        this.windowing = dataChannel.getTimeGrouping() instanceof Windowing ? (Windowing) dataChannel.getTimeGrouping()
                : null;
        this.collectWithHoldback = dataChannel.getTimeGrouping() instanceof CollectWithHoldback
                ? (CollectWithHoldback) dataChannel.getTimeGrouping()
                : null;
        this.collectAll = dataChannel.getTimeGrouping() instanceof ConsumeAllAvailable;

        this.partitioning = dataChannel.getPartitioning();

        if (this.isWindowingTriggeredOnIncoming()) {
            this.outgoingEmitter = new EqualityCollectorWithHoldback<KeyedFrame, Object>((it) -> it.key,
                    this.collectWithHoldback.getHoldback());
        } else if (this.isWindowingTriggeredPeriodically()) {
            if (this.isWindowingTriggeredPeriodically()) {
                this.windowEmitter = new WindowEmitter(this.windowing.getShift(), this.windowing.getShift());
                this.windowingTrigger = new PeriodicallyTriggeredSimulationEntity(this.model, 0,
                        this.windowing.getShift()) {
                    @Override
                    protected void triggerInternal() {
                        DeprecatedSimDataChannelResource.this.createAllCurrentlyOutgoingElements();
                    }
                };
            }
        }

        if (this.collectAll) {
            this.outgoingQueues.forEach((k, v) -> v.elements.add(this.createCollectionFrame()));
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
        return this.model.getSimulationControl().getCurrentSimulationTime();
    }

    private Map<Object, List<KeyedFrame>> createPartitions(final List<KeyedFrame> elements) {
        return elements.stream().collect(Collectors.groupingBy(it -> this.getPartition(it.frame)));
    }

    private List<IndirectionDate> createGroupOfOutgoingFrames(final List<KeyedFrame> elements, final Object key) {
        final Map<Object, List<KeyedFrame>> partitions = this.createPartitions(elements);
        final List<IndirectionDate> result = new ArrayList<>();
        for (final Entry<Object, List<KeyedFrame>> entry : partitions.entrySet()) {
            final IndirectionDate windowFrame = this.createCollectionFrame();
            windowFrame.data.put(this.getOutgoingParameterName() + ".PARTITION", entry.getKey());
            windowFrame.data.put(this.getOutgoingParameterName() + ".KEY", key);
            windowFrame.data.put(this.getOutgoingParameterName() + ".NUMBER_OF_ELEMENTS", entry.getValue().size());
            windowFrame.data.put(this.getOutgoingParameterName() + ".INNER", entry.getValue());
            result.add(windowFrame);
        }

        return result;
    }

    protected void createAllCurrentlyOutgoingElements() {
        final Set<KeyedFrame> flaggedForRemoval = new HashSet<KeyedFrame>();
        final List<IndirectionDate> outgoingFrames = new ArrayList<>();

        if (this.isWindowingTriggeredPeriodically()) {
            final Optional<List<Window>> windows = this.windowEmitter.accept(this.getTimeToAdvanceWindowingTo());
            if (windows.isPresent()) {
                for (final Window window : windows.get()) {
                    System.out.println("Creating window " + window.toString() + " (at "
                            + this.model.getSimulationControl().getCurrentSimulationTime() + ")");
                    final List<KeyedFrame> elementsInWindow = this.incomingElementsInWindow(window);
                    outgoingFrames.addAll(this.createGroupOfOutgoingFrames(elementsInWindow, window));
                    flaggedForRemoval.addAll(elementsInWindow);
                }
            }
        } else if (this.isWindowingTriggeredOnIncoming()) {
            System.out.println("Checking " + this.incomingQueue.size() + " elements " + "(last seen: "
                    + this.lastCheckedFrameId + ", " + "head: " + this.incomingQueue.get(0).id + ", " + "last: "
                    + this.incomingQueue.get(this.incomingQueue.size() - 1).id + ").");
            for (final KeyedFrame element : this.incomingQueue) {
                if (element.id <= this.lastCheckedFrameId) {
                    continue;
                }

                this.lastCheckedFrameId = element.id;

                final Optional<List<KeyedFrame>> result = this.outgoingEmitter.accept(element);
                if (result.isPresent()) {
                    System.out.println("Emitting grouping for " + result.get().size() + " frames (at "
                            + this.model.getSimulationControl().getCurrentSimulationTime() + "):");
                    final Object key = IterableUtil
                            .claimEqual(result.get().stream().map((it) -> it.key).collect(Collectors.toList()));
                    final List<IndirectionDate> newOutgoingFrames = this.createGroupOfOutgoingFrames(result.get(), key);
                    outgoingFrames.addAll(newOutgoingFrames);
                    newOutgoingFrames.forEach(it -> System.out.println(" - " + it));
                    flaggedForRemoval.addAll(result.get());
                }
            }
        }

        for (final KeyedFrame frameToRemove : flaggedForRemoval) {
            this.incomingQueue.remove(frameToRemove);
        }

        for (final IndirectionDate outgoingFrame : outgoingFrames) {
            this.outgoingQueues.forEach((k, v) -> v.elements.add(outgoingFrame));
        }
    }

    private Object getPartition(final IndirectionDate date) {
        if (this.partitioning == null) {
            return DUMMY_KEY;
        }

        final SimulatedStackframe<Object> stack = SimulatedStackHelper.createFromMap(date.data);

        return this.partitioning.getSpecification().stream().collect(Collectors.toMap(it -> it.getSpecification(),
                it -> StackContext.evaluateStatic(it.getSpecification(), stack)));
    }

    private List<KeyedFrame> incomingElementsInWindow(final Window window) {
        return this.incomingQueue.stream().filter(it -> window.contains((double) it.key)).collect(Collectors.toList());
    }

    @Override
    protected void acceptDataFrom(final ProcessWaitingToEmit process) {
        if (this.collectAll) {
            System.out.println("Collecting all -> adding to outgoing group.");
            this.addToOutgoingFrame(process.frame);
        } else if (this.isWindowingTriggeredOnIncoming()) {
            final KeyedFrame newFrame = new KeyedFrame(process.frame);
            this.incomingQueue.add(newFrame);
            System.out.println(
                    "Added frame @ " + newFrame.key + ": " + newFrame.frame + ". Directly triggering creation.");
            this.createAllCurrentlyOutgoingElements();
        } else if (this.isWindowingTriggeredPeriodically()) {
            final KeyedFrame newFrame = new KeyedFrame(process.frame);
            this.incomingQueue.add(newFrame);
            System.out.println("Added frame @ " + newFrame.key + ": " + newFrame.frame
                    + ". Doing nothing, waiting for timed creation.");
        } else {
            System.out.println("Added frame directly: " + process.frame);
            this.outgoingQueues.forEach((k, v) -> v.elements.add(process.frame));
        }
    }

    @Override
    protected List<IndirectionDate> provideDataFor(ProcessWaitingToConsume process) {
        return Collections.singletonList(this.getNextAvailableElement(process.sinkConnector));
    }
    
    private void addToOutgoingFrame(final IndirectionDate frame) {
        if (this.outgoingQueues.values().stream().anyMatch(it -> it.elements.size() != 1)) {
            throw new AssertionError("Queue must contain exactly one element at all times if collect all is true.");
        }

        for (final OutgoingQueue outgoingQueue : this.outgoingQueues.values()) {
            final IndirectionDate collectionFrame = outgoingQueue.elements.remove();
            this.addToCollectionFrame(collectionFrame, frame);
            outgoingQueue.elements.add(collectionFrame);
        }
    }

    private IndirectionDate createCollectionFrame() {
        final HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("data.INNER.VALUE", new ArrayList<Map<String, Object>>());
        result.put("data.INNER.NUMBER_OF_ELEMENTS", 0);

        return new IndirectionDate(result);
    }

    private void addToCollectionFrame(final IndirectionDate collectionFrame, final IndirectionDate frame) {
        final List<IndirectionDate> inner = (List<IndirectionDate>) collectionFrame.data.get("data.INNER.VALUE");
        Integer numberOfElements = (Integer) collectionFrame.data.get("data.INNER.NUMBER_OF_ELEMENTS");

        inner.add(frame);
        numberOfElements++;

        collectionFrame.data.put("data.INNER.NUMBER_OF_ELEMENTS", numberOfElements);
    }

    private IndirectionDate getNextAvailableElement(final DataChannelSinkConnector sinkConnector) {
        final IndirectionDate nextAvailableElement = this.outgoingQueues.get(sinkConnector).elements.remove();
        if (this.collectAll) {
            this.outgoingQueues.get(sinkConnector).elements.add(this.createCollectionFrame());
        }

        return nextAvailableElement;
    }

    @Override
    protected boolean canAcceptDataFrom(ProcessWaitingToEmit process) {
        return (this.capacity == -1) || (this.capacity - this.incomingQueue.size() > 0);
    }

    @Override
    protected boolean canProvideDataFor(ProcessWaitingToConsume process) {
        return this.outgoingQueues.get(process.sinkConnector).elements.size() > 0;
    }
}*/
