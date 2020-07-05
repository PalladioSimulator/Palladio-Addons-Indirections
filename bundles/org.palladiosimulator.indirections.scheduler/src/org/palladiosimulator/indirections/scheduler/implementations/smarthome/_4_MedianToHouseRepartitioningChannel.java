package org.palladiosimulator.indirections.scheduler.implementations.smarthome;

import static org.palladiosimulator.indirections.util.ObjectUtil.forceCast;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.data.PartitionedIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class _4_MedianToHouseRepartitioningChannel extends AbstractSimDataChannelResource {
    public static final String HOUSE_ID_VALUE_NAME = "houseId.VALUE";

    public Queue<PartitionedIndirectionDate<Window, IndirectionDate>> dataOut;

    public _4_MedianToHouseRepartitioningChannel(DataChannel dataChannel, InterpreterDefaultContext context,
            SchedulerModel model) {
        super(dataChannel, context, model);

        IndirectionSimulationUtil.requireExactNumberOfSinkSourceRoles(dataChannel, 1, 1);
        dataOut = new ArrayDeque<>();
    }

    @Override
    protected void acceptData(DataChannelSinkConnector connector, IndirectionDate date) {
        PartitionedIndirectionDate<Window, PartitionedIndirectionDate<String, IndirectionDate>> partitionedDate = forceCast(
                date, PartitionedIndirectionDate.class);

        var window = partitionedDate.getPartition();
        List<PartitionedIndirectionDate<String, IndirectionDate>> innerData = partitionedDate.getDataInGroup();
        
        innerData.stream()
            .flatMap(it -> it.getDataInGroup()
                .stream()) // take all data in the collection
            .collect(Collectors.groupingBy(it -> it.evaluate(HOUSE_ID_VALUE_NAME))) // and regroup
                                                                                    // it by houses
            .forEach((houseId, indirectionDates) -> dataOut.add(new PartitionedIndirectionDate<Window, IndirectionDate>(
                    window, indirectionDates, Map.of(HOUSE_ID_VALUE_NAME, houseId))));

        notifyProcessesCanGetNewData();
    }

    @Override
    protected boolean canAcceptData(DataChannelSinkConnector connector) {
        return true;
    }

    @Override
    protected boolean canProvideData(DataChannelSourceConnector connector) {
        return dataOut.size() > 0;
    }

    @Override
    protected void handleCannotProceedToGet(ProcessWaitingToGet process) {
        blockUntilCanGet(process);
    }

    @Override
    protected void handleCannotProceedToPut(ProcessWaitingToPut process) {
        throw new PCMModelInterpreterException("This should not happen.");
    }

    @Override
    protected void handleNewWatermarkedTime(double oldWatermarkTime, double watermarkTime) {
        // do nothing, restructuring is done immediately on arrival
    }

    @Override
    protected IndirectionDate provideDataAndAdvance(DataChannelSourceConnector connector) {
        return this.dataOut.remove();
    }

}
