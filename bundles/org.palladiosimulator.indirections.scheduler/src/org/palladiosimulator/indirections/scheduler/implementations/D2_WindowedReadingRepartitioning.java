package org.palladiosimulator.indirections.scheduler.implementations;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.data.PartitionedIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.util.ObjectUtil;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.di.component.interfaces.SimulatedThreadComponent;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class D2_WindowedReadingRepartitioning extends AbstractSimDataChannelResource {
    private final Queue<IndirectionDate> data = new ArrayDeque<IndirectionDate>();

    public D2_WindowedReadingRepartitioning(JavaClassDataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext mainContext, SchedulerModel model,
            SimulatedThreadComponent.Factory simulatedThreadComponentFactory) {
        super(dataChannel, assemblyContext, mainContext, model, simulatedThreadComponentFactory);

        IndirectionSimulationUtil.requireNumberOfSinkSourceRoles(dataChannel, it -> it == 1, "== 1", it -> it == 1,
                "== 1");
    }

    @Override
    protected void acceptData(DataSinkRole role, IndirectionDate date) {
        if (discardDateIfTooOld(date))
            return;

        System.out.println(this.dataChannel.getEntityName() + ": Accepting date " + date + ", now="
                + this.model.getSimulationControl()
                    .getCurrentSimulationTime());

        WindowingIndirectionDate<IndirectionDate> windowingDate = ObjectUtil.forceCast(date,
                WindowingIndirectionDate.class, () -> new PCMModelInterpreterException(this.getClass()
                    .getSimpleName() + " only accepts " + WindowingIndirectionDate.class.getSimpleName() + ", got: "
                        + date.getClass()
                            .getName()));

        windowingDate.getDataInGroup()
            .stream()
            .collect(Collectors.groupingBy(it -> Map.<String, Object> of("houseId.VALUE",
                    (Integer) it.evaluate("houseId.VALUE"), "plugId.VALUE", (Integer) it.evaluate("plugId.VALUE"))))
            .forEach((key, value) -> {
                var extraData = new HashMap<>(key);
                extraData.put("window.VALUE", windowingDate.window);
                var d = new PartitionedIndirectionDate<>(key, value, extraData);
                data.add(d);
            });

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
        System.out.println(this.dataChannel.getEntityName() + ": Providing data " + dataToProvide + ", now="
                + this.model.getSimulationControl()
                    .getCurrentSimulationTime());
        continuation.accept(dataToProvide);
    }

}
