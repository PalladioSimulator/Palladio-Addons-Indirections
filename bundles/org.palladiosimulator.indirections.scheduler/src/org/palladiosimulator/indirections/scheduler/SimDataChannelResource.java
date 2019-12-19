package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.unit.Unit;

import org.apache.log4j.Logger;
import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.datatypes.OutgoingDistribution;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.indirections.partitioning.CollectWithHoldback;
import org.palladiosimulator.indirections.partitioning.ConsumeAllAvailable;
import org.palladiosimulator.indirections.partitioning.Joining;
import org.palladiosimulator.indirections.partitioning.Partitioning;
import org.palladiosimulator.indirections.partitioning.TimeGrouping;
import org.palladiosimulator.indirections.partitioning.Windowing;
import org.palladiosimulator.indirections.scheduler.data.ConcreteGroupingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.DataWithSource;
import org.palladiosimulator.indirections.scheduler.data.GroupingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.EqualityCollectorWithHoldback;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.EqualityCollectorWithHoldback.HeldBackList;
import org.palladiosimulator.indirections.scheduler.operators.JoiningOperator;
import org.palladiosimulator.indirections.scheduler.operators.PartitioningOperator;
import org.palladiosimulator.indirections.scheduler.operators.SpecificationPartitioningOperator;
import org.palladiosimulator.indirections.scheduler.operators.TimeBasedWindowingOperator;
import org.palladiosimulator.indirections.scheduler.operators.WindowingOperator;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Variability that needs to be handled by a {@link SimDataChannelResource}:
 * <ul>
 * <li>How is data ingress handled: FCFS, LIFO, Priorities, etc.</li>
 * <li>How is data grouped, etc.</li>
 * <li>How is data distributed.</li>
 * </ul>
 * 
 * <p>
 * 
 * The {@link AbstractSimDataChannelResource}, <strong>not</strong> {@link SimDataChannelResource}
 * handles:
 * <ul>
 * <li>Blocking/unblocking processes</li>
 * <li>Creating new pushing processes</li>
 * </ul>
 * 
 * 
 * Who decides what data is given to which connector?
 * 
 * @implNote It might make sense to implement this as a strategy (composition over inheritance)
 *           instead of inheriting from {@link AbstractSimDataChannelResource}.
 * 
 */
public class SimDataChannelResource extends AbstractSimDataChannelResource {
    private static final Logger LOGGER = Logger.getLogger(SimDataChannelResource.class);

    private Map<DataChannelSinkConnector, Queue<IndirectionDate>> outQueues = new HashMap<>();
    private Deque<DataWithSource<IndirectionDate>> dataBeforeJoiningQueue = new ArrayDeque<>();
    private Deque<IndirectionDate> dataAfterJoiningQueue = new ArrayDeque<>();

    private final Partitioning partitioning;
    private final TimeGrouping timeGrouping;
    private final List<Joining> joins;

    private PartitioningOperator<Object, IndirectionDate> partitioningOperator;
    private WindowingOperator<IndirectionDate> windowingOperator;
    private EqualityCollectorWithHoldback<IndirectionDate, Object> holdbackOperator;
    private JoiningOperator<IndirectionDate> joinOperator;

    public SimDataChannelResource(DataChannel dataChannel, InterpreterDefaultContext context, SchedulerModel model) {
        super(dataChannel, context, model);

        if (!(model instanceof SimuComModel)) {
            throw new PCMModelInterpreterException("Unsupported type of model: " + model.getClass().getName()
                    + ", expected: " + SimuComModel.class.getName());
        }

        SimuComModel simuComModel = (SimuComModel) model;

        partitioning = dataChannel.getPartitioning();
        if (partitioning != null) {
            partitioningOperator = new SpecificationPartitioningOperator<>(partitioning.getSpecification());
            partitioningOperator.addConsumer(this::emit);
            partitioningOperator.addObserver(new PartitioningOperator.Observer() {
                @Override
                public void notifyNumberOfPartitions(int size) {
                    partitionNumberCalculator.doMeasure(Measure.valueOf(Long.valueOf(size), Unit.ONE));
                }
            });
        }

        timeGrouping = dataChannel.getTimeGrouping();
        if (timeGrouping != null) {
            if (timeGrouping instanceof Windowing) {
                Windowing windowing = (Windowing) timeGrouping;
                windowingOperator = new TimeBasedWindowingOperator<>(false, windowing.getSize(), windowing.getShift(),
                        simuComModel);
                windowingOperator.addConsumer((it) -> LOGGER.trace("Created window: " + it));
                windowingOperator.addConsumer((it) -> windowSizeCalculator
                        .doMeasure(Measure.valueOf(Long.valueOf(it.getDataInGroup().size()), Unit.ONE)));
                windowingOperator.addConsumer(this::postprocessAndEmit);
            } else if (timeGrouping instanceof CollectWithHoldback) {
                collectWithHoldback = (CollectWithHoldback) timeGrouping;
                holdbackOperator = new EqualityCollectorWithHoldback<IndirectionDate, Object>(it -> {
                    return Context.evaluateStatic(collectWithHoldback.getKey(),
                            SimulatedStackHelper.createFromMap(it.getData()));
                }, collectWithHoldback.getHoldback());
            }
        }

        joins = dataChannel.getJoins();
        final List<DataChannelSourceConnector> joinSources = joins.stream().map(Joining::getSource)
                .collect(Collectors.toList());
        final List<Boolean> retainDataArray = joins.stream().map(Joining::isCanContributeMultipleTimes)
                .collect(Collectors.toList());

        final List<PCMRandomVariable> joinKeys = new ArrayList<>();
        for (Joining j : joins) {
            if (j.getKey().size() > 1)
                throw new PCMModelInterpreterException("Interpreter currently only supports maximum one key per join");
            else if (j.getKey().size() == 1)
                joinKeys.add(j.getKey().get(0));
            else
                joinKeys.add(null);
        }

        if (!joins.isEmpty()) {
            joinOperator = JoiningOperator.createWithIndices(it -> {
                int index = joinSources.indexOf(it.source);
                if (index == -1) {
                    throw new PCMModelInterpreterException("Unexpected source: " + it.source + ", sources to join: "
                            + joinSources.stream().map(js -> js.getEntityName()).collect(Collectors.joining(", ")));
                }
                return index;
            }, joinKeys, retainDataArray);
            joinOperator.addConsumer(it -> dataAfterJoiningQueue.add(it));
        }

        for (DataChannelSinkConnector dcsc : dataChannel.getDataChannelSinkConnector()) {
            outQueues.put(dcsc, new ArrayDeque<IndirectionDate>());
        }

        setupCalculators();
    }

    private TriggerableCalculator<Long, Dimensionless> windowSizeCalculator;
    private TriggerableCalculator<Long, Dimensionless> holdbackGroupSizeCalculator;
    private TriggerableCalculator<Long, Dimensionless> partitionNumberCalculator;

    private void setupCalculators() {
        if (windowingOperator != null) {
            this.windowSizeCalculator = new TriggerableCalculator<>("Window size for " + name,
                    IndirectionsMetricDescriptionConstants.SIZE_OF_GROUPED_DATE_METRIC,
                    IndirectionsMetricDescriptionConstants.SIZE_OF_GROUPED_DATE_METRIC_TUPLE);
        }
        if (holdbackOperator != null) {
            this.holdbackGroupSizeCalculator = new TriggerableCalculator<>("Holdback window size for " + name,
                    IndirectionsMetricDescriptionConstants.SIZE_OF_GROUPED_DATE_METRIC,
                    IndirectionsMetricDescriptionConstants.SIZE_OF_GROUPED_DATE_METRIC_TUPLE);
        }
        if (partitioningOperator != null) {
            this.partitionNumberCalculator = new TriggerableCalculator<>("Partition numbers for " + name,
                    IndirectionsMetricDescriptionConstants.SIZE_OF_GROUPED_DATE_METRIC,
                    IndirectionsMetricDescriptionConstants.SIZE_OF_GROUPED_DATE_METRIC_TUPLE);
        }
    }

    private Iterator<Queue<IndirectionDate>> queueIterator;
    private CollectWithHoldback collectWithHoldback;

    private Queue<IndirectionDate> getNextQueue() {
        if (dataChannel.getOutgoingDistribution().equals(OutgoingDistribution.ROUND_ROBIN))
            throw new IllegalStateException();

        if (queueIterator == null || !queueIterator.hasNext())
            queueIterator = outQueues.values().iterator();

        return queueIterator.next();
    }

    private Iterable<Queue<IndirectionDate>> getQueuesToSendTo(IndirectionDate date) {
        if (dataChannel.getOutgoingDistribution().equals(OutgoingDistribution.DISTRIBUTE_TO_ALL)) {
            return outQueues.values();
        } else if (dataChannel.getOutgoingDistribution().equals(OutgoingDistribution.ROUND_ROBIN)) {
            return Collections.singleton(getNextQueue());
        } else {
            throw new PCMModelInterpreterException(
                    "Unexpected type of outgoing distribution strategy: " + dataChannel.getOutgoingDistribution());
        }
    }

    private Queue<IndirectionDate> getQueueToReadFrom(DataChannelSinkConnector sinkConnector) {
        return outQueues.get(sinkConnector);
    }

    private void postprocessAndEmit(IndirectionDate date) {
        if (partitioning != null) {
            if (!(date instanceof GroupingIndirectionDate<?>)) {
                throw new PCMModelInterpreterException("Unexpected type for data for partitioning: "
                        + date.getClass().getName() + ". Expected " + GroupingIndirectionDate.class);
            }

            GroupingIndirectionDate<IndirectionDate> groupingDate = (GroupingIndirectionDate<IndirectionDate>) date;
            partitioningOperator.accept(groupingDate); // also emits via emit(date)
        } else {
            emit(date);
        }
    }

    private void emit(IndirectionDate date) {
        getQueuesToSendTo(date).forEach(it -> it.add(date));
        processDataAvailableToGet();
    }

    @Override
    protected boolean canProvideDataFor(DataChannelSinkConnector sinkConnector) {
        return !getQueueToReadFrom(sinkConnector).isEmpty();
    }

    @Override
    protected Iterable<IndirectionDate> provideDataFor(DataChannelSinkConnector sinkConnector) {
        if (timeGrouping instanceof ConsumeAllAvailable) {
            List<IndirectionDate> dataInGroup = new ArrayList<>(getQueueToReadFrom(sinkConnector));
            getQueueToReadFrom(sinkConnector).clear();
            GroupingIndirectionDate<IndirectionDate> result = new ConcreteGroupingIndirectionDate<>(dataInGroup);
            return Collections.singleton(result);
        } else {
            return Collections.singleton(getQueueToReadFrom(sinkConnector).remove());
        }
    }

    private void processDataQueue() {
        if (joinOperator != null) {
            // also emits to dataAfterJoiningQueue. should be reworked
            dataBeforeJoiningQueue.forEach(it -> joinOperator.accept(it));
            LOGGER.trace("Joining, joint all in queue.");
        } else {
            dataBeforeJoiningQueue.forEach(it -> dataAfterJoiningQueue.add(it.date));
            LOGGER.trace("Not joining, passing data.");
        }
        dataBeforeJoiningQueue.clear();

        if (windowingOperator != null) {
            LOGGER.trace("Windowing, creating windows.");
            dataAfterJoiningQueue.forEach(it -> windowingOperator.accept(it));
            dataAfterJoiningQueue.clear();
        } else if (holdbackOperator != null) {
            LOGGER.trace("Applying holdback.");
            for (IndirectionDate it : dataAfterJoiningQueue) {
                Optional<HeldBackList<Object, IndirectionDate>> result = holdbackOperator.accept(it);
                if (result.isPresent()) {
                    HeldBackList<Object, IndirectionDate> heldBackList = result.get();
                    holdbackGroupSizeCalculator
                            .doMeasure(Measure.valueOf(Long.valueOf(heldBackList.list.size()), Unit.ONE));
                    ConcreteGroupingIndirectionDate<IndirectionDate> date = new ConcreteGroupingIndirectionDate<>(
                            heldBackList.list, new HashMap<>(
                                    Map.of(collectWithHoldback.getPartitionDataName() + ".VALUE", heldBackList.key)));
                    postprocessAndEmit(date);
                }
            }
            dataAfterJoiningQueue.clear();
        } else {
            dataAfterJoiningQueue.forEach(it -> postprocessAndEmit(it));
            dataAfterJoiningQueue.clear();
        }
    }

    @Override
    protected boolean canAcceptDataFrom(DataChannelSourceConnector sourceConnector) {
        return true;
    }

    @Override
    protected void acceptDataFrom(DataChannelSourceConnector sourceConnector, IndirectionDate date) {
        DataWithSource<IndirectionDate> createdDate = new DataWithSource<>(sourceConnector, date);
        dataBeforeJoiningQueue.add(createdDate);
        LOGGER.trace("Added date to queue: " + createdDate + " from connector " + sourceConnector.getEntityName());

        processDataQueue();
    }
}
