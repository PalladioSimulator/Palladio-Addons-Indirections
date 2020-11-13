package org.palladiosimulator.indirections.scheduler.implementations.windowing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.WindowCalculator;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

// holds back elements for some time before making them available for consumption
public abstract class SlidingWindowChannel extends AbstractSimDataChannelResource {
    private final double windowSize;
    private final double windowShift;
    private final double gracePeriod;

    private final List<IndirectionDate> dataIn;
    private final Queue<WindowingIndirectionDate<IndirectionDate>> dataOut;
    private final boolean emitEmptyWindows;
    private final WindowCalculator windowCalculator;

    public SlidingWindowChannel(final JavaClassDataChannel dataChannel, final InterpreterDefaultContext context,
            final SchedulerModel model, double windowSize, double windowShift, double gracePeriod,
            boolean emitEmptyWindows) {
        super(dataChannel, context, model);

        IndirectionSimulationUtil.requireNumberOfSinkSourceRoles(dataChannel, it -> it == 1, "== 1", it -> it == 1,
                "== 1");

        this.dataIn = new ArrayList<>();
        this.dataOut = new ArrayDeque<>();

        this.windowSize = windowSize;
        this.windowShift = windowShift;
        this.gracePeriod = gracePeriod;

        this.emitEmptyWindows = emitEmptyWindows;

        this.windowCalculator = new WindowCalculator(windowSize, windowShift, gracePeriod);

        // flushes data every INTERVAL time units
        this.scheduleAdvance(findNextWindowEnd(this.model.getSimulationControl()
            .getCurrentSimulationTime()), windowShift, gracePeriod);
    }

    private double findNextWindowEnd(double currentSimulationTime) {
        return Math.ceil(currentSimulationTime / windowShift) * windowShift + windowSize;
    }

    @Override
    protected void acceptData(final DataChannelSinkConnector connector, final IndirectionDate date) {
        if (discardDateIfTooOld(date))
            return;
        else
            this.dataIn.add(date);
        
        notifyProcessesCanGetNewData();
    }

    @Override
    protected boolean canAcceptData(final DataChannelSinkConnector connector) {
        return true;
    }

    @Override
    protected boolean canProvideData(final DataChannelSourceConnector connector) {
        return this.dataOut.size() > 0;
    }

    @Override
    protected void handleCannotProceedToGet(final ProcessWaitingToGet process) {
        this.blockUntilCanGet(process);
    }

    @Override
    protected void handleCannotProceedToPut(final ProcessWaitingToPut process) {
        throw new AssertionError("Channel is non-blocking");
    }

    @Override
    protected void handleNewWatermarkedTime(final double oldWatermarkTime, final double watermarkTime) {
        List<Window> windows = windowCalculator.advanceUntil(watermarkTime);

        boolean newData = false;
        for (var window : windows) {
            List<IndirectionDate> data = this.dataIn.stream()
                    // TODO: is overlap always enough?
                .filter(it -> it.getTime().stream().anyMatch(time -> window.contains(time)))
                .collect(Collectors.toList());
            if (emitEmptyWindows || !data.isEmpty()) {
                this.dataOut.add(new WindowingIndirectionDate<>(data, window));
                newData = true;
            }
        }

        if (!windows.isEmpty()) {
            var newestWindow = windows.get(windows.size() - 1);
            dataIn.removeIf(it -> it.getTime().stream().allMatch(time -> time  + gracePeriod < newestWindow.start));
        }

        if (newData) {
            this.notifyProcessesCanGetNewData();
        }
    }

    @Override
    protected IndirectionDate provideDataAndAdvance(final DataChannelSourceConnector connector) {
        return this.dataOut.remove();
    }

}
