package org.palladiosimulator.indirections.scheduler.implementations;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitchFactory;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class AnyToAllPushingDataChannel extends AbstractSimDataChannelResource {
    protected final Map<DataSourceRole, Queue<IndirectionDate>> data;

    public AnyToAllPushingDataChannel(DataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext context, SchedulerModel model,
            RepositoryComponentSwitchFactory repositoryComponentSwitchFactory) {
        super(dataChannel, assemblyContext, context, model, repositoryComponentSwitchFactory);

        data = new HashMap<>();
        for (var connector : dataChannel.getDataSourceRoles()) {
            data.put(connector, new ArrayDeque<>());
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

    @Override
    protected IndirectionDate provideDataAndAdvance(DataSourceRole role) {
        return data.get(role)
                .remove();
    }

}
