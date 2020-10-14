package org.palladiosimulator.indirections.scheduler.implementations.windowing;

import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.getDoubleParameter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.indirections.util.IndirectionModelUtil;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public abstract class HoldbackWindowedDataWithGracePeriodChannel extends AbstractSimDataChannelResource {
    public static final String WINDOW_SHIFT_PARAMETER_NAME = "windowShift";
    public static final String WINDOW_SIZE_PARAMETER_NAME = "windowSize";
    public static final String GRACE_PERIOD_PARAMETER_NAME = "gracePeriod";

    protected final Map<Window, List<IndirectionDate>> dataIn;
    protected final Map<DataChannelSourceConnector, Queue<IndirectionDate>> dataOut;

    private final double windowShift;
    private final double windowSize;
    private final double gracePeriod;

    public HoldbackWindowedDataWithGracePeriodChannel(final JavaClassDataChannel dataChannel,
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

    protected abstract Window getWindowValue(IndirectionDate date);

    @SuppressWarnings("unchecked")
    @Override
    protected void acceptData(final DataChannelSinkConnector connector, final IndirectionDate date) {
        var window = getWindowValue(date);

        if (window.end < getCurrentWatermarkedTime()) {
            discardIncomingDate(date);
            return;
        }

        dataIn.computeIfAbsent(window, (it) -> new ArrayList<>())
            .add(date);

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

    protected List<IndirectionDate> createOutputDataForWindow(List<IndirectionDate> dataInWindow, Window window) {
        return Collections.singletonList(new WindowingIndirectionDate<>(dataInWindow, window));
    }

    @Override
    protected void handleNewWatermarkedTime(final double oldWatermarkTime, final double watermarkTime) {
        boolean newData = false;
        Collection<Window> windowsToRemove = new HashSet<>();

        for (var entry : this.dataIn.entrySet()) {
            Window window = entry.getKey();

            if (window.end + gracePeriod < watermarkTime) {
                List<IndirectionDate> dataInWindow = entry.getValue();

                var outputData = createOutputDataForWindow(dataInWindow, window);

                dataOut.forEach((connector, queue) -> outputData.forEach(queue::add));
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
