package org.palladiosimulator.indirections.scheduler.implementations.smarthome;

import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.getDoubleParameter;
import static org.palladiosimulator.indirections.util.ObjectUtil.forceCast;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.data.PartitionedIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.indirections.util.IndirectionModelUtil;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

// holdback with timer
public class ______3_TimedHoldBackDistributingChannel extends AbstractSimDataChannelResource {
    public static final String WINDOW_SHIFT_PARAMETER_NAME = "windowShift";
    public static final String WINDOW_SIZE_PARAMETER_NAME = "windowSize";
    public static final String GRACE_PERIOD_PARAMETER_NAME = "gracePeriod";

    private final Map<Window, List<PartitionedIndirectionDate<Integer, IndirectionDate>>> dataIn;
    private final Map<DataChannelSourceConnector, Queue<PartitionedIndirectionDate<Window, PartitionedIndirectionDate<Integer, IndirectionDate>>>> dataOut;

    private final double windowShift;
    private final double windowSize;
    private final double gracePeriod;

    public ______3_TimedHoldBackDistributingChannel(final JavaClassDataChannel dataChannel,
            final InterpreterDefaultContext context, final SchedulerModel model) {
        super(dataChannel, context, model);

        this.dataIn = new HashMap<>();
        this.dataOut = new HashMap<>();

        var connectors = IndirectionModelUtil.getAllConnectorsFromSourceRoles(dataChannel);
        for (var connector : connectors)
            dataOut.put(connector, new ArrayDeque<>());

        this.windowShift = getDoubleParameter(dataChannel, WINDOW_SHIFT_PARAMETER_NAME);
        this.windowSize = getDoubleParameter(dataChannel, WINDOW_SIZE_PARAMETER_NAME);
        this.gracePeriod = getDoubleParameter(dataChannel, GRACE_PERIOD_PARAMETER_NAME);

        // flushes data every INTERVAL time units
        this.scheduleAdvance(findNextWindowEnd(this.model.getSimulationControl()
            .getCurrentSimulationTime()), windowShift, gracePeriod);
    }

    // TODO remove duplicated code (SlidingWindowChannel)
    private double findNextWindowEnd(double currentSimulationTime) {
        return Math.ceil(currentSimulationTime / windowShift) * windowShift + windowSize;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void acceptData(final DataChannelSinkConnector connector, final IndirectionDate date) {
        // input: plug -> readings
        PartitionedIndirectionDate<Integer, IndirectionDate> partitionedDate = forceCast(date,
                PartitionedIndirectionDate.class);
        var window = (Window) partitionedDate.evaluate(_2_WindowPartitionByPlugChannel.WINDOW_VALUE_NAME);

        // target type: PartitionedData<House, Reading>

        if (window.end < getCurrentWatermarkedTime()) {
            discardIncomingDate(date);
            return;
        }

        dataIn.computeIfAbsent(window, (it) -> new ArrayList<>())
            .add(partitionedDate);
        
        notifyProcessesCanGetNewData();
    }

    @Override
    protected boolean canAcceptData(final DataChannelSinkConnector connector) {
        return true;
    }

    @Override
    protected boolean canProvideData(final DataChannelSourceConnector connector) {
        return this.dataOut.get(connector)
            .size() > 0;
    }

    @Override
    protected void handleCannotProceedToGet(final ProcessWaitingToGet process) {
        this.blockUntilCanGet(process);
    }

    @Override
    protected void handleCannotProceedToPut(final ProcessWaitingToPut process) {
        throw new PCMModelInterpreterException("This should not happen.");
    }

    @Override
    protected void handleNewWatermarkedTime(final double oldWatermarkTime, final double watermarkTime) {
        boolean newData = false;
        Collection<Window> windowsToRemove = new HashSet<>();

        for (var entry : this.dataIn.entrySet()) {
            Window window = entry.getKey();
            List<PartitionedIndirectionDate<Integer, IndirectionDate>> dataInWindow = entry.getValue()
                .stream()
                .flatMap(it -> it.getDataInGroup()
                    .stream()
                    .map(date -> (PartitionedIndirectionDate<Integer, IndirectionDate>) date))
                .collect(Collectors.toList());

            if (window.end + gracePeriod < watermarkTime) {
                // PartitionedIndirectionDate<Window, IndirectionDate>
                dataOut.forEach((connector, queue) -> queue
                    .add(new PartitionedIndirectionDate<Window, PartitionedIndirectionDate<Integer, IndirectionDate>>(
                            window, dataInWindow, Collections.emptyMap())));
                newData = true;
                windowsToRemove.add(window);
            }
        }

        windowsToRemove.forEach(dataIn::remove);
        if (newData)
            this.notifyProcessesCanGetNewData();
    }

    @Override
    protected IndirectionDate provideDataAndAdvance(final DataChannelSourceConnector connector) {
        return this.dataOut.get(connector)
            .remove();
    }

}
