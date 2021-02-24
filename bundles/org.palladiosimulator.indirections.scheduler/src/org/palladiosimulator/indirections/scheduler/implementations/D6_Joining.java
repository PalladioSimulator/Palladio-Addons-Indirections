package org.palladiosimulator.indirections.scheduler.implementations;

import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.getDoubleParameter;
import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.getStringParameter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.data.GenericJoinedDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.util.DataChannelResourceRegistry;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.di.component.interfaces.SimulatedThreadComponent;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitch;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.entities.SimuComEntity;

public class D6_Joining extends AbstractSimDataChannelResource {
    public static final String GRACE_PERIOD_PARAMETER_NAME = "gracePeriod";
    private final double gracePeriod;

    public static final String MEDIAN_WINDOW_PER_HOUSE_ROLE_ID_PARAMETER_NAME = "medianWindowPerHouseRoleId";
    private final String medianWindowPerHouseRoleId;
    private final DataSinkRole medianWindowPerHouseRole;

    public static final String MEDIAN_AVERAGE_ROLE_ID_PARAMETER_NAME = "medianAverageRoleId";
    private final String medianAverageRoleId;
    private final DataSinkRole medianAverageRole;

    protected final Map<DataSinkRole, Map<Window, List<IndirectionDate>>> roleToWindowToDates;
    private final Map<Window, SimuComEntity> scheduledToEmit;
    private Queue<IndirectionDate> data;

    public D6_Joining(JavaClassDataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext mainContext, SchedulerModel model,
            SimulatedThreadComponent.Factory simulatedThreadComponentFactory, DataChannelResourceRegistry dataChannelResourceRegistry) {
        super(dataChannel, assemblyContext, mainContext, model, simulatedThreadComponentFactory, dataChannelResourceRegistry);

        this.gracePeriod = getDoubleParameter(dataChannel, GRACE_PERIOD_PARAMETER_NAME);
        this.medianWindowPerHouseRoleId = getStringParameter(dataChannel,
                MEDIAN_WINDOW_PER_HOUSE_ROLE_ID_PARAMETER_NAME);
        this.medianAverageRoleId = getStringParameter(dataChannel, MEDIAN_AVERAGE_ROLE_ID_PARAMETER_NAME);

        this.medianWindowPerHouseRole = dataChannel.getDataSinkRoles()
            .stream()
            .filter(it -> it.getId()
                .equals(medianWindowPerHouseRoleId))
            .findFirst()
            .get();
        this.medianAverageRole = dataChannel.getDataSinkRoles()
            .stream()
            .filter(it -> it.getId()
                .equals(medianAverageRoleId))
            .findFirst()
            .get();

        this.roleToWindowToDates = new HashMap<>();
        for (var role : dataChannel.getDataSinkRoles()) {
            this.roleToWindowToDates.put(role, new HashMap<>());
        }

        this.scheduledToEmit = new HashMap<>();
        this.data = new ArrayDeque<>();
    }

    private double timeToEmit(Window window) {
        return window.end + this.gracePeriod;
    }

    @Override
    protected void acceptData(DataSinkRole role, IndirectionDate date) {
        System.out.println(dataChannel.getEntityName() + ": Accepting data to " + role.getEntityName() + " (" + role.getId() + "): " + date + ", now="
                + this.model.getSimulationControl()
                    .getCurrentSimulationTime());

        var windowToDates = roleToWindowToDates.get(role);

        Window window = (Window) date.getData()
            .get("window.VALUE");

        double timeToEmit = timeToEmit(window);
        double timeNow = this.model.getSimulationControl()
            .getCurrentSimulationTime();
        double delay = timeToEmit - timeNow;

        if (delay <= 0) {
            throw new PCMModelInterpreterException("Data is too late, window already emitted: " + window + ", now: "
                    + timeNow + ", emitted at: " + timeToEmit);
        }

        if (!windowToDates.containsKey(window))
            windowToDates.put(window, new ArrayList<>());
        var dates = windowToDates.get(window);

        dates.add(date);

        if (!scheduledToEmit.containsKey(window)) {
            scheduledToEmit.put(window, IndirectionSimulationUtil.triggerOnce(model, delay, () -> {
                System.out.println(
                        dataChannel.getEntityName() + ": emitting " + window + ", now = " + model.getSimulationControl()
                            .getCurrentSimulationTime());
                emit(window);

                var process = scheduledToEmit.remove(window);
            }));
        }
    }

    protected void emit(Window window) {
        var medianWindowsPerHouse = roleToWindowToDates.get(medianWindowPerHouseRole)
            .remove(window);
        var medianAverages = roleToWindowToDates.get(medianAverageRole)
            .remove(window);
        
        if (medianAverages == null) {
            System.out.println("Error, no average found for " + window);
            return;
        }
        
        if (medianWindowsPerHouse == null) {
            System.out.println("Error, no house medians found for " + window);
            return;
        }

        if (medianAverages.size() != 1) {
            System.out.println("Expected exactly one average for " + window + ", got: " + medianAverages.size());
            return;
        }

        if (medianWindowsPerHouse.isEmpty()) {
            System.out.println("Didn't find any house medians for " + window);
            return;
        }

        for (var medianAverage : medianAverages) {
            for (var medianWindowPerHouse : medianWindowsPerHouse) {
                var joinedDate = GenericJoinedDate
                    .of(Map.of("medianAverage", medianAverage, "medianWindowPerHouse", medianWindowPerHouse));

                data.add(joinedDate);
            }
        }
        notifyProcessesCanGetNewData();
    }

    @Override
    protected boolean canAcceptData(DataSinkRole role) {
        return true;
    }

    @Override
    protected boolean canProvideData(DataSourceRole role) {
        return this.data.size() > 0;
    }

    @Override
    protected boolean isPushingRole(DataSourceRole role) {
        return true;
    }

    @Override
    protected void handleCannotProceedToGet(ProcessWaitingToGet process) {
        throw new AssertionError("");
    }

    @Override
    protected void handleCannotProceedToPut(ProcessWaitingToPut process) {
        throw new AssertionError("");
    }

    @Override
    protected void handleNewWatermarkedTime(double oldWatermarkTime, double watermarkTime) {
        //
    }

    @Override
    protected void provideDataAndAdvance(DataSourceRole role, Consumer<IndirectionDate> continuation) {
        IndirectionDate dataToProvide = data.remove();
        System.out.println(dataChannel.getEntityName() + ": Providing data " + dataToProvide + ", now="
                + this.model.getSimulationControl()
                    .getCurrentSimulationTime());
        continuation.accept(dataToProvide);
    }

}
