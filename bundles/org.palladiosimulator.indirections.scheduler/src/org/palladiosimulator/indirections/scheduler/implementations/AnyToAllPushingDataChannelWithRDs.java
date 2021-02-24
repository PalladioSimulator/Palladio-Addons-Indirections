package org.palladiosimulator.indirections.scheduler.implementations;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.util.DataChannelResourceRegistry;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.di.component.interfaces.SimulatedThreadComponent;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class AnyToAllPushingDataChannelWithRDs extends AbstractSimDataChannelResource {
    public static final String CPU_ID = "_oro4gG3fEdy4YaaT-RYrLQ"; // from Palladio.resourcetype

    protected final Map<DataSourceRole, Queue<IndirectionDate>> data;

    private static final String ACCEPT_RESOURCE_DEMAND_PARAMETER_NAME = "acceptResourceDemand";
    private static final String EMIT_RESOURCE_DEMAND_PARAMETER_NAME = "emitResourceDemand";

    private final String acceptResourceDemand;
    private final String emitResourceDemand;

    public AnyToAllPushingDataChannelWithRDs(JavaClassDataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext mainContext, SchedulerModel model,
            SimulatedThreadComponent.Factory simulatedThreadComponentFactory, DataChannelResourceRegistry dataChannelResourceRegistry) {
        super(dataChannel, assemblyContext, mainContext, model, simulatedThreadComponentFactory, dataChannelResourceRegistry);

        data = new HashMap<>();
        for (var connector : dataChannel.getDataSourceRoles()) {
            data.put(connector, new ArrayDeque<>());
        }

        this.acceptResourceDemand = IndirectionSimulationUtil.getStringParameter(dataChannel,
                ACCEPT_RESOURCE_DEMAND_PARAMETER_NAME);
        this.emitResourceDemand = IndirectionSimulationUtil.getStringParameter(dataChannel,
                EMIT_RESOURCE_DEMAND_PARAMETER_NAME);
    }

    @Override
    protected void acceptData(DataSinkRole role, IndirectionDate date) {
        scheduleDemand(CPU_ID, acceptResourceDemand, date, (indirectionDate) -> {
            data.values()
                .forEach(it -> it.add(indirectionDate));
            this.notifyProcessesCanGetNewData();
        });
    }

    @Override
    protected void provideDataAndAdvance(DataSourceRole role, Consumer<IndirectionDate> continuation) {
        var date = data.get(role)
            .remove();
        scheduleDemand(CPU_ID, emitResourceDemand, date, continuation);
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
        return true;
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
}
