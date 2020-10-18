package org.palladiosimulator.indirections.monitoring.simulizar;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.runtimestate.AbstractSimuLizarRuntimeState;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public final class IndirectionDependencyMeasurements {
    private static Map<AbstractSimuLizarRuntimeState, IndirectionDependencyMeasurements> instanceRegistry = new HashMap<>();
    private final SimuComModel myModel;
    private final Map<UUID, Double> creationDates;

    private IndirectionDependencyMeasurements(SimuComModel myModel) {
        this.myModel = myModel;
        this.creationDates = new HashMap<>();
    }

    public static IndirectionDependencyMeasurements getInstanceFor(final InterpreterDefaultContext context) {
        instanceRegistry.computeIfAbsent(context.getRuntimeState(),
                (ctx) -> new IndirectionDependencyMeasurements(ctx.getModel()));

        return instanceRegistry.get(context.getRuntimeState());
    }

    public void recordGeneration(UUID uuid, Double time) {
        if (creationDates.containsKey(uuid)) {
            throw new PCMModelInterpreterException("Value for generation of UUID " + uuid.toString()
                    + " already present: " + time + ". New given time: " + time);
        }
        creationDates.put(uuid, time);
    }

    public void recordGeneration(UUID uuid) {
        double currentSimulationTime = this.myModel.getSimulationControl()
            .getCurrentSimulationTime();
        recordGeneration(uuid, currentSimulationTime);
    }

    public double claimTimeFor(UUID uuid) {
        return Objects.requireNonNull(creationDates.get(uuid),
                () -> {
                    var x = this;
                    return "No creation time for " + uuid.toString() + " present (" + x.hashCode() + ").";
                });
    }
}
