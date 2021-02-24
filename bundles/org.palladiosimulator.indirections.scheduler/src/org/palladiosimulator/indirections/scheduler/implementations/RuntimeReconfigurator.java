package org.palladiosimulator.indirections.scheduler.implementations;

import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcm.usagemodel.Start;
import org.palladiosimulator.pcm.usagemodel.Stop;
import org.palladiosimulator.pcm.usagemodel.UsageModel;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.runtimestate.IRuntimeStateAccessor;
import org.palladiosimulator.simulizar.runtimestate.SimuLizarRuntimeState;

public class RuntimeReconfigurator implements IRuntimeStateAccessor {
    private int getPid(String id) {
        if (!id.startsWith("Plug_") || !id.endsWith(".ID"))
            throw new PCMModelInterpreterException("???");

        return Integer.valueOf(id.substring("Plug_".length(), id.length() - 3));
    }

    private int getHouseId(String id) {
        return getPid(id) / 10_000;
    }

    private int getPlugId(String id) {
        return getPid(id) % 100;
    }

    private void applyFilter(UsageModel usageModel, int maxHouseId, int maxHouseholdId, int maxPlugId) {
        for (var usageScenario : usageModel.getUsageScenario_UsageModel()) {
            var houseId = getHouseId(usageScenario.getId());
            var plugId = getPlugId(usageScenario.getId());

            if ((houseId <= maxHouseId) && (plugId <= maxPlugId)) {
                enableUsageScenario(usageScenario);
            } else {
                disableUsageScenario(usageScenario);
            }
        }
    }

    private Start findStart(UsageScenario usageScenario) {
        return (Start) usageScenario.getScenarioBehaviour_UsageScenario()
            .getActions_ScenarioBehaviour()
            .stream()
            .filter(it -> it instanceof Start)
            .findAny()
            .get();
    }

    private Stop findStop(UsageScenario usageScenario) {
        return (Stop) usageScenario.getScenarioBehaviour_UsageScenario()
            .getActions_ScenarioBehaviour()
            .stream()
            .filter(it -> it instanceof Stop)
            .findAny()
            .get();
    }

    private EntryLevelSystemCall findELSC(UsageScenario usageScenario) {
        return (EntryLevelSystemCall) usageScenario.getScenarioBehaviour_UsageScenario()
            .getActions_ScenarioBehaviour()
            .stream()
            .filter(it -> it instanceof EntryLevelSystemCall)
            .findAny()
            .get();
    }

    private void enableUsageScenario(UsageScenario usageScenario) {
        var start = findStart(usageScenario);
        var stop = findStop(usageScenario);
        var elsc = findELSC(usageScenario);

        start.setSuccessor(elsc);
        elsc.setSuccessor(stop);
    }

    private void disableUsageScenario(UsageScenario usageScenario) {
        var start = findStart(usageScenario);
        var stop = findStop(usageScenario);
        var elsc = findELSC(usageScenario);

        start.setSuccessor(stop);
    }

    @Override
    public void setRuntimeStateModel(SimuLizarRuntimeState state) {
        var shouldUseReconfiguraiton = state.getPCMPartitionManager()
            .getLocalPCMModel()
            .getRepositories()
            .get(0)
            .getEntityName()
            .endsWith("-with-reconfiguration");
        
        if (shouldUseReconfiguraiton) {
            at(state, 0, 2, 2, 2);
            at(state, 20, 4, 4, 4);
            at(state, 40, 2, 2, 2);
            at(state, 60, 4, 4, 4);
            at(state, 80, 1, 1, 1);
            at(state, 100, 1, 1, 1);
            at(state, 120, 4, 4, 4);
            at(state, 200, 1, 1, 1);
            at(state, 300, -1, -1, -1);
        }
    }

    private void at(SimuLizarRuntimeState state, double time, int maxHouseId, int maxHouseholdId, int maxPlugId) {
        final var model = state.getPCMPartitionManager()
            .getLocalPCMModel()
            .getUsageModel();
        IndirectionSimulationUtil.triggerOnce(state.getModel(), time, () -> {
            applyFilter(model, maxHouseId, maxHouseholdId, maxPlugId);
        });
    }

}
