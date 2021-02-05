package org.palladiosimulator.indirections.scheduler.implementations;

import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.getDoubleParameter;

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
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.di.component.interfaces.SimulatedThreadComponent;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitch;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.entities.SimuComEntity;

public class D4_MedianWindowing extends AbstractSimDataChannelResource {
    public static final String GRACE_PERIOD_PARAMETER_NAME = "gracePeriod";
    private final double gracePeriod;

    protected final Map<Window, List<IndirectionDate>> windowToDates;
    private final Map<Window, SimuComEntity> scheduledToEmit;
    protected final Queue<IndirectionDate> data;

    public D4_MedianWindowing(JavaClassDataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext mainContext, SchedulerModel model,
            SimulatedThreadComponent.Factory simulatedThreadComponentFactory) {
        super(dataChannel, assemblyContext, mainContext, model, simulatedThreadComponentFactory);

        this.gracePeriod = getDoubleParameter(dataChannel, GRACE_PERIOD_PARAMETER_NAME);
        this.windowToDates = new HashMap<>();
        this.scheduledToEmit = new HashMap<>();
        this.data = new ArrayDeque<>();
    }

    private double timeToEmit(Window window) {
        return window.end + this.gracePeriod;
    }

    @Override
    protected void acceptData(DataSinkRole role, IndirectionDate date) {
        // <ConcreteIndirectionDate (e724501e-f968-4c9b-b427-a321ca58114a):
        // houseId.VALUE->1,
        // plugId.VALUE->1,
        // window.VALUE->W[0.0->10.0]>

        System.out.println(this.dataChannel.getEntityName() + ": Accepting data to " + role.getEntityName() + " ("
                + role.getId() + "): " + date + ", now = " + model.getSimulationControl()
                    .getCurrentSimulationTime());

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
                System.out.println("Delay: " + delay + ", timeNow = " + timeNow + ", timeToEmit = " + timeToEmit);
                emit(window);

                scheduledToEmit.remove(window);
            }));
        }
    }

    protected void emit(Window window) {
        var dataInGroup = windowToDates.get(window);
        if (dataInGroup.isEmpty()) {
            System.out.println("Emitting empty window");
        }

        var dateToEmit = new WindowingIndirectionDate<>(dataInGroup, window, Map.of());
        data.add(dateToEmit);
        notifyProcessesCanGetNewData();
    }

    @Override
    protected boolean canAcceptData(DataSinkRole role) {
        return true;
    }

    @Override
    protected boolean canProvideData(DataSourceRole role) {
        return data.size() > 0;
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
        System.out.println("Moving " + this + " from " + oldWatermarkTime + " to " + watermarkTime);
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
