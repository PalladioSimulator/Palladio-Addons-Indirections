package org.palladiosimulator.indirections.scheduler.implementations.generic;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.util.DataChannelResourceRegistry;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.di.component.interfaces.SimulatedThreadComponent;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class AnyToAllChannel extends AbstractSimDataChannelResource {

    protected final Map<DataSourceRole, Queue<IndirectionDate>> data;

    public AnyToAllChannel(DataChannel dataChannel, AssemblyContext assemblyContext, InterpreterDefaultContext mainContext,
            SchedulerModel model, SimulatedThreadComponent.Factory simulatedThreadComponentFactory, DataChannelResourceRegistry dataChannelResourceRegistry) {
        super(dataChannel, assemblyContext, mainContext, model, simulatedThreadComponentFactory, dataChannelResourceRegistry);

        IndirectionSimulationUtil.requireNumberOfSinkSourceRoles(dataChannel, it -> it == 1, "== 1", it -> it >= 1,
                ">= 1");

        this.data = new HashMap<>();
        for (var sourceRole : dataChannel.getDataSourceRoles()) {
            data.put(sourceRole, new ArrayDeque<>());
        }

    }

    @Override
    protected void acceptData(DataSinkRole role, IndirectionDate date) {
        data.values()
            .forEach(it -> it.add(date));
        this.notifyProcessesCanGetNewData();
    }

    @Override
    protected boolean canAcceptData(DataSinkRole role) {
        return true;
    }

    @Override
    protected boolean canProvideData(DataSourceRole role) {
        return data.get(role)
            .size() > 0;
    }

    @Override
    protected boolean isPushingRole(DataSourceRole role) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void handleCannotProceedToGet(ProcessWaitingToGet process) {
        throw new AssertionError("This should never happen, since the channel only supports pushing.");
    }

    @Override
    protected void handleCannotProceedToPut(ProcessWaitingToPut process) {
        throw new AssertionError("This should never happen, since the channel always returns true for canAcceptData");
    }

    @Override
    protected void handleNewWatermarkedTime(double oldWatermarkTime, double watermarkTime) {
        // do nothing. everything will be emitted immediately
    }

    @Override
    protected void provideDataAndAdvance(DataSourceRole role, Consumer<IndirectionDate> continuation) {
        IndirectionDate date = data.get(role)
            .remove();
        continuation.accept(date);
    }

}
