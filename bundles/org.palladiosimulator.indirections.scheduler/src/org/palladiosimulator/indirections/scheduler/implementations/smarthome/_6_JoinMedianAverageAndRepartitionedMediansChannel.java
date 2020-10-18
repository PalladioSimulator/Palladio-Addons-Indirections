package org.palladiosimulator.indirections.scheduler.implementations.smarthome;

import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.getDoubleParameter;
import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.getStringParameter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.data.ConcreteIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.GenericJoinedDate;
import org.palladiosimulator.indirections.scheduler.data.PartitionedIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.TaggedDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class _6_JoinMedianAverageAndRepartitionedMediansChannel extends AbstractSimDataChannelResource {
    private static final Logger logger = LogManager.getLogger(_6_JoinMedianAverageAndRepartitionedMediansChannel.class);

    public static final String WINDOW_SHIFT_PARAMETER_NAME = "windowShift";
    public static final String WINDOW_SIZE_PARAMETER_NAME = "windowSize";
    public static final String GRACE_PERIOD_PARAMETER_NAME = "gracePeriod";

    public static final String MEDIAN_AVERAGE_CONNECTOR_ID_PARAMETER_NAME = "medianAverageConnectorId";
    public static final String MEDIAN_WINDOW_CONNECTOR_ID_PARAMETER_NAME = "medianWindowConnectorId";

    public static final String MEDIAN_AVERAGE_DATA_FIELD_NAME = "medianAverage";
    public static final String MEDIAN_WINDOW_DATA_FIELD_NAME = "medianWindow";

    private final Map<Window, IndirectionDate> windowToMedianAverageIn;
    private final Map<Window, Collection<IndirectionDate>> windowToMedianWindowIn;

    private final Queue<IndirectionDate> dataOut;

    private final double windowShift;
    private final double windowSize;
    private final double gracePeriod;

    private final String medianWindowConnectorId;
    private final String medianAverageConnectorId;

    public _6_JoinMedianAverageAndRepartitionedMediansChannel(JavaClassDataChannel dataChannel,
            InterpreterDefaultContext context, SchedulerModel model) {
        super(dataChannel, context, model);

        EList<DataSinkRole> dataSinkRoles = dataChannel.getDataSinkRoles();
        if (dataSinkRoles.size() <= 1)
            throw new PCMModelInterpreterException(this.getClass()
                .getName() + " has to have more than one sink role. Found " + dataSinkRoles.size());
        EList<DataSourceRole> dataSourceRoles = dataChannel.getDataSourceRoles();
        if (dataSourceRoles.size() != 1)
            throw new PCMModelInterpreterException(this.getClass()
                .getName() + " has to have exactly one source role. Found " + dataSourceRoles.size());

        // prepare input data
        windowToMedianAverageIn = new HashMap<>();
        windowToMedianWindowIn = new HashMap<>();

        this.windowShift = getDoubleParameter(dataChannel, WINDOW_SHIFT_PARAMETER_NAME);
        this.windowSize = getDoubleParameter(dataChannel, WINDOW_SIZE_PARAMETER_NAME);
        this.gracePeriod = getDoubleParameter(dataChannel, GRACE_PERIOD_PARAMETER_NAME);

        this.medianWindowConnectorId = getStringParameter(dataChannel, MEDIAN_WINDOW_CONNECTOR_ID_PARAMETER_NAME);
        this.medianAverageConnectorId = getStringParameter(dataChannel, MEDIAN_AVERAGE_CONNECTOR_ID_PARAMETER_NAME);

        System.out.println("" + model.getSimulationControl()
        .getCurrentSimulationTime() + ": creating "
            + this.getClass()
                .getSimpleName()
            + " (" + this.getName() + "), shift: " + this.windowShift + ", size: " + this.windowSize
            + ", grace period: " + this.gracePeriod);

        // flushes data every INTERVAL time units
        double nextWindowEnd = findNextWindowEnd(this.model.getSimulationControl()
            .getCurrentSimulationTime());
        System.out.println("-- Next window end: " + nextWindowEnd);
        this.scheduleAdvance(nextWindowEnd + gracePeriod, windowShift, gracePeriod);
        
        dataOut = new ArrayDeque<>();
    }

    // TODO remove duplicated code (SlidingWindowChannel)
    private double findNextWindowEnd(double currentSimulationTime) {
        double currentWindowEnd = windowSize;
        while (currentSimulationTime > currentWindowEnd + gracePeriod)
            currentWindowEnd += windowShift;
        return currentWindowEnd;
    }

    @Override
    protected boolean shouldDataBeDiscarded(double timeToCheck, double currentTime) {
        return (timeToCheck < currentTime);
    }

    @Override
    protected void acceptData(DataChannelSinkConnector connector, IndirectionDate date) {
        if (discardDateIfTooOld(date))
            return;

        if ((date instanceof PartitionedIndirectionDate) && isMedianWindowConnector(connector)) {
            var partitionedDate = (PartitionedIndirectionDate<Window, IndirectionDate>) date;
            acceptMedianWindowDate(partitionedDate);
        } else if ((date instanceof ConcreteIndirectionDate) && isMedianAverageConnector(connector)) {
            acceptMedianAverageDate(date);
        } else {
            throw new PCMModelInterpreterException(
                    "Unexpected connector and sink role: " + connector + ", " + connector.getDataSinkRole());
        }
    }

    private void acceptMedianWindowDate(PartitionedIndirectionDate<Window, IndirectionDate> date) {
        var window = date.getPartition();

        Collection<IndirectionDate> data = windowToMedianWindowIn.computeIfAbsent(window, (it) -> new ArrayList<>());
        data.add(date);
    }

    private void acceptMedianAverageDate(IndirectionDate date) {
        Window window = (Window) date.getData()
            .get("WINDOW.VALUE");
        if (windowToMedianAverageIn.containsKey(window)) {
            discardIncomingDate(date);
            logger.error("Unexpected MedianAverage date: " + date + ", date already present for window " + window + ": "
                    + windowToMedianAverageIn.get(window));
            return;
        }

        windowToMedianAverageIn.put(window, date);
    }

    private boolean isMedianAverageConnector(DataChannelSinkConnector connector) {
        return connector.getDataSinkRole()
            .getId()
            .equals(medianAverageConnectorId);
    }

    private boolean isMedianWindowConnector(DataChannelSinkConnector connector) {
        return connector.getDataSinkRole()
            .getId()
            .equals(medianWindowConnectorId);
    }

    @Override
    protected boolean canAcceptData(DataChannelSinkConnector connector) {
        return true;
    }

    @Override
    protected boolean canProvideData(DataChannelSourceConnector connector) {
        return dataOut.size() > 0;
    }

    @Override
    protected void handleCannotProceedToGet(ProcessWaitingToGet process) {
        blockUntilCanGet(process);
    }

    @Override
    protected void handleCannotProceedToPut(ProcessWaitingToPut process) {
        throw new AssertionError("This should never happen.");
    }

    @Override
    protected IndirectionDate provideDataAndAdvance(DataChannelSourceConnector connector) {
        return dataOut.remove();
    }

    @Override
    protected void handleNewWatermarkedTime(double oldWatermarkTime, double watermarkTime) {
        System.out.println("" + this.model.getSimulationControl()
            .getCurrentSimulationTime() + ": Advancing " + this.getName() + " from " + oldWatermarkTime + " to "
                + watermarkTime);
        boolean newData = false;
        Collection<Window> windowsToRemove = new HashSet<>();

        // we could only check one, since both have to be present for eviction, but we want to clean
        // up properly and do error handling.
        var emittableWindows = Stream.concat(windowToMedianAverageIn.keySet()
            .stream(),
                windowToMedianWindowIn.keySet()
                    .stream())
            .filter(it -> it.end <= watermarkTime) // TODO IMPORTANT: check whether
                                                   // this always works and is the
                                                   // intended meaning. Is
                                                   // watermark time be enough?
            .collect(Collectors.toSet());

        for (var window : emittableWindows) {
            System.out.println("-- outputting " + window.toString());
            IndirectionDate averageAll = windowToMedianAverageIn.get(window);
            if (averageAll == null) {
                logger.error("No average all present for " + window);
                continue;
            }

            Collection<IndirectionDate> grouped = windowToMedianWindowIn.get(window);
            if (grouped == null || grouped.isEmpty()) {
                logger.error("No grouped data for " + window);
                continue;
            }

            var taggedMedianAverage = new TaggedDate<IndirectionDate, String>(medianAverageConnectorId, averageAll);
            PartitionedIndirectionDate<Window, IndirectionDate> newPartitionedMedianWindow = new PartitionedIndirectionDate<>(
                    window, new ArrayList<>(grouped), Collections.emptyMap());
            indirectionDependencyMeasurements.recordGeneration(newPartitionedMedianWindow.getUUID());
            var taggedMedianWindow = new TaggedDate<IndirectionDate, String>(medianWindowConnectorId,
                    newPartitionedMedianWindow);

            var mappedData = new HashMap<String, TaggedDate<IndirectionDate, String>>();
            mappedData.put(MEDIAN_AVERAGE_DATA_FIELD_NAME, taggedMedianAverage);
            mappedData.put(MEDIAN_WINDOW_DATA_FIELD_NAME, taggedMedianWindow);

            windowsToRemove.add(window);
            GenericJoinedDate<IndirectionDate, String> newJoinedDate = new GenericJoinedDate<IndirectionDate, String>(
                    mappedData);
            indirectionDependencyMeasurements.recordGeneration(newJoinedDate.getUUID());
            dataOut.add(newJoinedDate);
            newData = true;
        }

        for (var window : windowsToRemove) {
            windowToMedianAverageIn.remove(window);
            windowToMedianWindowIn.remove(window);
        }

        if (newData)
            this.notifyProcessesCanGetNewData();
    }
}
