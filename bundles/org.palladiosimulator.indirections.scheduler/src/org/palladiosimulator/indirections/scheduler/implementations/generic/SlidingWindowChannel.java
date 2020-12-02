package org.palladiosimulator.indirections.scheduler.implementations.generic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.WindowCalculator;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitchFactory;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public abstract class SlidingWindowChannel extends AbstractSimDataChannelResource {
    private final double windowSize;
    private final double windowShift;
    private final double gracePeriod;

    private final List<IndirectionDate> dataIn;
    private final Queue<WindowingIndirectionDate<IndirectionDate>> dataOut;
    private final boolean emitEmptyWindows;
    private final WindowCalculator windowCalculator;

    public SlidingWindowChannel(JavaClassDataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext context, SchedulerModel model,
            RepositoryComponentSwitchFactory repositoryComponentSwitchFactory, double windowSize, double windowShift,
            double gracePeriod, boolean emitEmptyWindows) {
        super(dataChannel, assemblyContext, context, model, repositoryComponentSwitchFactory);

        IndirectionSimulationUtil.requireNumberOfSinkSourceRoles(dataChannel, it -> it == 1, "== 1", it -> it == 1,
                "== 1");

        this.dataIn = new ArrayList<>();
        this.dataOut = new ArrayDeque<>();

        this.windowSize = windowSize;
        this.windowShift = windowShift;
        this.gracePeriod = gracePeriod;

        this.emitEmptyWindows = emitEmptyWindows;

        this.windowCalculator = new WindowCalculator(windowSize, windowShift, 0);

        // flushes data every INTERVAL time units
        this.scheduleAdvance(findNextWindowEnd(this.model.getSimulationControl()
            .getCurrentSimulationTime()), windowShift, gracePeriod);
    }

    private double findNextWindowEnd(double currentSimulationTime) {
        return Math.ceil(currentSimulationTime / windowShift) * windowShift + windowSize;
    }

    @Override
    protected void acceptData(DataSinkRole role, IndirectionDate date) {
        //System.out.println("Accepting date " + date + ", now=" + this.model.getSimulationControl().getCurrentSimulationTime());
        if (discardDateIfTooOld(date))
            return;
        else
            this.dataIn.add(date);

        notifyProcessesCanGetNewData();
    }

    @Override
    protected boolean canAcceptData(DataSinkRole role) {
        return true;
    }

    @Override
    protected boolean canProvideData(DataSourceRole role) {
        return this.dataOut.size() > 0;
    }

    @Override
    protected void handleCannotProceedToGet(ProcessWaitingToGet process) {
        this.blockUntilCanGet(process);
    }

    @Override
    protected void handleCannotProceedToPut(ProcessWaitingToPut process) {
        throw new AssertionError("Channel is non-blocking");
    }

    @Override
    protected void handleNewWatermarkedTime(double oldWatermarkTime, double watermarkTime) {
        List<Window> windows = windowCalculator.advanceUntil(watermarkTime);

        boolean newData = false;
        for (var window : windows) {
            List<IndirectionDate> data = this.dataIn.stream()
                // TODO: is overlap always enough?
                .filter(it -> it.getTime()
                    .stream()
                    .anyMatch(time -> window.contains(time)))
                .collect(Collectors.toList());
            if (emitEmptyWindows || !data.isEmpty()) {
                this.dataOut.add(new WindowingIndirectionDate<>(data, window));
                newData = true;
            }
        }

        if (!windows.isEmpty()) {
            var newestWindow = windows.get(windows.size() - 1);
            dataIn.removeIf(it -> it.getTime()
                .stream()
                .allMatch(time -> time < newestWindow.start));
        }

        if (newData) {
            this.notifyProcessesCanGetNewData();
        }
    }

    @Override
    protected void provideDataAndAdvance(DataSourceRole role, Consumer<IndirectionDate> continuation) {
        WindowingIndirectionDate<IndirectionDate> dataToProvide = this.dataOut.remove();
        System.out.println(dataChannel.getEntityName() + ": Providing sliding window " + dataToProvide.window + ", now=" + this.model.getSimulationControl().getCurrentSimulationTime());
        continuation.accept(dataToProvide);
    }
}
