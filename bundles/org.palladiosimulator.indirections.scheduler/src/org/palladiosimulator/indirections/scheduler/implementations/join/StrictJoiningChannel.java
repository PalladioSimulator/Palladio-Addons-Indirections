package org.palladiosimulator.indirections.scheduler.implementations;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.data.GenericJoinedDate;
import org.palladiosimulator.indirections.scheduler.data.TaggedDate;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

// emits data together when each sink role has contributed exactly one date.
public class StrictJoiningChannel extends AbstractSimDataChannelResource {
    private Map<DataSinkRole, IndirectionDate> dataIn;

    public StrictJoiningChannel(JavaClassDataChannel dataChannel, InterpreterDefaultContext context,
            SchedulerModel model) {
        super(dataChannel, context, model);

        EList<DataSinkRole> dataSinkRoles = dataChannel.getDataSinkRoles();
        if (dataSinkRoles.size() <= 1)
            throw new PCMModelInterpreterException(this.getClass()
                .getName() + " has to have more than one sink role. Found " + dataSinkRoles.size());
        EList<DataSourceRole> dataSourceRoles = dataChannel.getDataSourceRoles();
        if (dataSourceRoles.size() != 1)
            throw new PCMModelInterpreterException(this.getClass()
                .getName() + " has to have exactly one source role. Found " + dataSourceRoles.size());

        clearInputData();
    }

    private void clearInputData() {
        EList<DataSinkRole> dataSinkRoles = dataChannel.getDataSinkRoles();
        dataIn = new HashMap<>();
        for (var role : dataSinkRoles) {
            dataIn.put(role, null);
        }
    }

    @Override
    protected void acceptData(DataChannelSinkConnector connector, IndirectionDate date) {
        dataIn.put(connector.getDataSinkRole(), date);
    }

    @Override
    protected boolean canAcceptData(DataChannelSinkConnector connector) {
        return !dataIn.containsKey(connector.getDataSinkRole());
    }

    @Override
    protected boolean canProvideData(DataChannelSourceConnector connector) {
        return dataIn.values()
            .stream()
            .allMatch(it -> it != null);
    }

    @Override
    protected void handleCannotProceedToGet(ProcessWaitingToGet process) {
        blockUntilCanGet(process);
    }

    @Override
    protected void handleCannotProceedToPut(ProcessWaitingToPut process) {
        blockUntilCanPut(process);
    }

    @Override
    protected void handleNewWatermarkedTime(double oldWatermarkTime, double watermarkTime) {
        // TODO Auto-generated method stub

    }

    @Override
    protected IndirectionDate provideDataAndAdvance(DataChannelSourceConnector connector) {
        Map<DataSinkRole, TaggedDate<IndirectionDate, DataSinkRole>> dataMap = dataIn.entrySet()
            .stream()
            .collect(Collectors.toMap(it -> it.getKey(), it -> new TaggedDate<>(it.getKey(), it.getValue())));

        var dateToReturn = new GenericJoinedDate<>(dataMap);

        clearInputData();

        notifyProcessesCanPutNewData();

        return dateToReturn;
    }
}
