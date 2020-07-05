package org.palladiosimulator.indirections.scheduler.implementations;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.data.GenericJoinedDate;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;


// must be able to connect 1 to n elements based on the channel
/**
 * @deprecated
 */
public abstract class AbstractGeneralJoiningChannel<T extends IndirectionDate> extends AbstractSimDataChannelResource {
    private final Map<DataSinkRole, Collection<IndirectionDate>> dataIn;
    private final Queue<T> dataOut;
    
    public AbstractGeneralJoiningChannel(DataChannel dataChannel, InterpreterDefaultContext context,
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

        // prepare input data
        dataIn = new HashMap<>();
        for (var role : dataSinkRoles) {
            dataIn.put(role, new ArrayDeque<>());
        }
        
        // prepare output data
        dataOut = new ArrayDeque<>();
    }

    @Override
    protected void acceptData(DataChannelSinkConnector connector, IndirectionDate date) {
        dataIn.get(connector.getDataSinkRole()).add(date);
        
        processData();
    }

    protected abstract void processData();

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
        throw new AssertionError("This should never happen.");
    }

    @Override
    protected IndirectionDate provideDataAndAdvance(DataChannelSourceConnector connector) {
        return dataOut.remove();
    }
}
