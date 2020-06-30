package org.palladiosimulator.indirections.scheduler.operators;

import java.util.List;
import java.util.Optional;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class TimeBasedWindowingOperator<T extends IndirectionDate> extends WindowingOperator<T> {
    private final PeriodicallyTriggeredSimulationEntity windowingTrigger;

    public TimeBasedWindowingOperator(final boolean emitEmptyWindows, final double size, final double shift,
            final double gracePeriod, final SimuComModel model) {
        super(emitEmptyWindows, size, shift, gracePeriod);

        this.windowingTrigger = IndirectionSimulationUtil.triggerPeriodically(model, gracePeriod, shift, () -> {
            System.out.println("Current time: " + model.getSimulationControl()
                .getCurrentSimulationTime());
            final Optional<List<Window>> windowsToEmit = this.windowEmitter.accept(model.getSimulationControl()
                .getCurrentSimulationTime());
            windowsToEmit.ifPresent(this::emitWindows);
        });
    }
}