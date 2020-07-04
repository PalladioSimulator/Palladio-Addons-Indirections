package org.palladiosimulator.indirections.scheduler.implementations.smarthome;

import static org.palladiosimulator.indirections.util.ObjectUtil.forceCast;

import java.util.ArrayDeque;
import java.util.Queue;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.data.GroupingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.PartitionedIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class _4_MedianToHouseRepartitioningChannel extends AbstractSimDataChannelResource {
    public Queue<PartitionedIndirectionDate<Window, PartitionedIndirectionDate<String, IndirectionDate>>> dataOut;

    public _4_MedianToHouseRepartitioningChannel(DataChannel dataChannel, InterpreterDefaultContext context,
            SchedulerModel model) {
        super(dataChannel, context, model);

        IndirectionSimulationUtil.requireExactNumberOfSinkSourceRoles(dataChannel, 1, 1);
        dataOut = new ArrayDeque<>();
    }

    @Override
    protected void acceptData(DataChannelSinkConnector connector, IndirectionDate date) {
        GroupingIndirectionDate<WindowingIndirectionDate<IndirectionDate>> groupingDate = forceCast(date,
                GroupingIndirectionDate.class);
    }

    @Override
    protected boolean canAcceptData(DataChannelSinkConnector connector) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected boolean canProvideData(DataChannelSourceConnector connector) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void handleCannotProceedToGet(ProcessWaitingToGet process) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void handleCannotProceedToPut(ProcessWaitingToPut process) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void handleNewWatermarkedTime(double oldWatermarkTime, double watermarkTime) {
        // TODO Auto-generated method stub

    }

    @Override
    protected IndirectionDate provideDataAndAdvance(DataChannelSourceConnector connector) {
        // TODO Auto-generated method stub
        return null;
    }

}
