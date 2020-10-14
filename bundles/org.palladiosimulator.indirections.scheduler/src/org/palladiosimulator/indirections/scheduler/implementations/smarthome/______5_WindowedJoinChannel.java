package org.palladiosimulator.indirections.scheduler.implementations.smarthome;

import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.getDoubleParameter;

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

// TODO refactor out hardcoded roles etc.
public class ______5_WindowedJoinChannel extends AbstractSimDataChannelResource {
    private static final Logger logger = LogManager.getLogger(______5_WindowedJoinChannel.class);

    public static final String AAP_ID = "AAPRole.ID";
    public static final String MEP_GROUP_ID = "MEPGroupRole.ID";

    public static final String WINDOW_SHIFT_PARAMETER_NAME = "windowShift";
    public static final String WINDOW_SIZE_PARAMETER_NAME = "windowSize";
    public static final String GRACE_PERIOD_PARAMETER_NAME = "gracePeriod";

    private final Map<DataSinkRole, Collection<IndirectionDate>> dataIn;
    private final Map<Window, PartitionedIndirectionDate<Window, IndirectionDate>> averageAllIn;
    private final Map<Window, Collection<IndirectionDate>> groupedByHouseIn;

    private final Queue<IndirectionDate> dataOut;

    private final double windowShift;
    private final double windowSize;
    private final double gracePeriod;

    public ______5_WindowedJoinChannel(JavaClassDataChannel dataChannel, InterpreterDefaultContext context,
            SchedulerModel model) {
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
        dataIn = new HashMap<>();
        for (var role : dataSinkRoles) {
            dataIn.put(role, new ArrayDeque<>());
        }

        // prepare output data
        averageAllIn = new HashMap<>();
        groupedByHouseIn = new HashMap<>();

        this.windowShift = getDoubleParameter(dataChannel, WINDOW_SHIFT_PARAMETER_NAME);
        this.windowSize = getDoubleParameter(dataChannel, WINDOW_SIZE_PARAMETER_NAME);
        this.gracePeriod = getDoubleParameter(dataChannel, GRACE_PERIOD_PARAMETER_NAME);

        // flushes data every INTERVAL time units
        this.scheduleAdvance(findNextWindowEnd(this.model.getSimulationControl()
            .getCurrentSimulationTime()), windowShift, gracePeriod);

        dataOut = new ArrayDeque<>();
    }

    // TODO remove duplicated code (SlidingWindowChannel)
    private double findNextWindowEnd(double currentSimulationTime) {
        return Math.ceil(currentSimulationTime / windowShift) * windowShift + windowSize;
    }

    @Override
    protected void acceptData(DataChannelSinkConnector connector, IndirectionDate date) {
        var partitionedDate = (PartitionedIndirectionDate<Window, IndirectionDate>) date;
        if (discardDateIfTooOld(partitionedDate))
            return;

        if (isAAPConnector(connector)) {
            acceptAAPDate(partitionedDate);
        } else if (isMEPConnector(connector)) {
            acceptMEPDate(partitionedDate);
        } else {
            throw new PCMModelInterpreterException(
                    "Unexpected connector and sink role: " + connector + ", " + connector.getDataSinkRole());
        }
    }

    private void acceptMEPDate(PartitionedIndirectionDate<Window, IndirectionDate> date) {
        var window = date.getPartition();

        Collection<IndirectionDate> data = groupedByHouseIn.computeIfAbsent(window, (it) -> new ArrayList<>());
        data.add(date);
    }

    private void acceptAAPDate(PartitionedIndirectionDate<Window, IndirectionDate> date) {
        Window window = date.getPartition();
        if (averageAllIn.containsKey(window)) {
            discardIncomingDate(date);
            logger.error("Unexpected AAP date: " + date + ", date already present for window " + window + ": "
                    + averageAllIn.get(window));
            return;
        }

        averageAllIn.put(window, date);
    }

    private boolean isMEPConnector(DataChannelSinkConnector connector) {
        return connector.getDataSinkRole()
            .getId()
            .equals(MEP_GROUP_ID);
    }

    private boolean isAAPConnector(DataChannelSinkConnector connector) {
        return connector.getDataSinkRole()
            .getId()
            .equals(AAP_ID);
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
        boolean newData = false;
        Collection<Window> windowsToRemove = new HashSet<>();

        // we could only check one, since both have to be present for eviction, but we want to clean
        // up properly and do error handling.
        var emittableWindows = Stream.concat(averageAllIn.keySet()
            .stream(),
                groupedByHouseIn.keySet()
                    .stream())
            .filter(it -> it.end + gracePeriod < watermarkTime) // TODO IMPORTANT: check whether
                                                                // this always works and is the
                                                                // intended meaning. Is
                                                                // watermark time be enough?
            .collect(Collectors.toSet());

        for (var window : emittableWindows) {
            PartitionedIndirectionDate<Window, IndirectionDate> averageAll = averageAllIn.get(window);
            if (averageAll == null) {
                logger.error("No average all present for " + window);
                continue;
            }

            Collection<IndirectionDate> grouped = groupedByHouseIn.get(window);
            if (grouped == null || grouped.isEmpty()) {
                logger.error("No grouped data for " + window);
                continue;
            }

            var taggedAverage = new TaggedDate<IndirectionDate, String>(AAP_ID, averageAll);
            var taggedMEPGroup = new TaggedDate<IndirectionDate, String>(MEP_GROUP_ID,
                    new PartitionedIndirectionDate<>(window, new ArrayList<>(grouped), Collections.emptyMap()));

            var mappedData = new HashMap<String, TaggedDate<IndirectionDate, String>>();
            mappedData.put(AAP_ID, taggedAverage);
            mappedData.put(MEP_GROUP_ID, taggedMEPGroup);

            windowsToRemove.add(window);
            dataOut.add(new GenericJoinedDate<IndirectionDate, String>(mappedData));
            newData = true;
        }

        for (var window : windowsToRemove) {
            averageAllIn.remove(window);
            groupedByHouseIn.remove(window);
        }

        if (newData)
            this.notifyProcessesCanGetNewData();
    }
}
