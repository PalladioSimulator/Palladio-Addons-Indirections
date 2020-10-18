package org.palladiosimulator.indirections.scheduler.implementations;

import static org.palladiosimulator.indirections.util.IndirectionModelUtil.getSystem;
import static org.palladiosimulator.indirections.util.IndirectionModelUtil.isPushingRole;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.indirections.util.IndirectionModelUtil;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class AnyToAllPushingDataChannel extends AbstractSimDataChannelResource {
    protected final Map<DataChannelSourceConnector, Queue<IndirectionDate>> data;

    public AnyToAllPushingDataChannel(JavaClassDataChannel dataChannel, InterpreterDefaultContext context,
            SchedulerModel model) {
        super(dataChannel, context, model);

        IndirectionSimulationUtil.requireNumberOfSinkSourceRoles(dataChannel, it -> it == 1, "== 1", it -> it == 1,
                "== 1");

        DataSourceRole sourceRole = dataChannel.getDataSourceRoles()
            .get(0);

        if (!isPushingRole(sourceRole, getSystem(dataChannel))) {
            throw new IllegalStateException("Only exactly one pushing role supported. Role is not pushing.");
        }

        var connectors = IndirectionModelUtil.getAllConnectorsFromSourceRoles(dataChannel);

        data = new HashMap<>();
        for (var connector : connectors) {
            data.put(connector, new ArrayDeque<>());
        }
    }
    
    @Override
    protected boolean shouldDataBeDiscarded(double timeToCheck, double currentTime) {
        return false;
    }

    @Override
    protected void acceptData(DataChannelSinkConnector connector, IndirectionDate date) {
        data.values()
            .forEach(it -> it.add(date));
        this.notifyProcessesCanGetNewData();
    }

    @Override
    protected boolean canAcceptData(DataChannelSinkConnector connector) {
        return true;
    }

    @Override
    protected boolean canProvideData(DataChannelSourceConnector connector) {
        return data.get(connector)
            .size() > 0;
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
    protected IndirectionDate provideDataAndAdvance(DataChannelSourceConnector connector) {
        return data.get(connector)
            .remove();
    }

}
