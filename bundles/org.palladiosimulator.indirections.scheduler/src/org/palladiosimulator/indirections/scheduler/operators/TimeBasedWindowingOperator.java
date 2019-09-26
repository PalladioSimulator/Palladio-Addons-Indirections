package org.palladiosimulator.indirections.scheduler.operators;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class TimeBasedWindowingOperator extends WindowingOperator {
    private PeriodicallyTriggeredSimulationEntity windowingTrigger;

    public TimeBasedWindowingOperator(List<Consumer<WindowingIndirectionDate>> emitsTo, boolean emitEmptyWindows,
            double size, double shift, SimuComModel model) {
        super(emitsTo, emitEmptyWindows, size, shift);

        this.windowingTrigger = IndirectionSimulationUtil.triggerPeriodically(model, 0, shift, () -> {
            Optional<List<Window>> windowsToEmit = windowEmitter.accept(null);
            windowsToEmit.ifPresent(this::emitWindows);
        });
    }
}