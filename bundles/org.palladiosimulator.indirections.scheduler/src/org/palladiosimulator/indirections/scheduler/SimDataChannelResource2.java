package org.palladiosimulator.indirections.scheduler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Variability that needs to be handled by a {@link SimDataChannelResource2}:
 * <ul>
 * <li>How is data ingress handled: FCFS, LIFO, Priorities, etc.</li>
 * <li>How is data grouped, etc.</li>
 * <li>How is data distributed.</li>
 * </ul>
 * 
 * <p>
 * 
 * The {@link AbstractSimDataChannelResource}, <strong>not</strong> {@link SimDataChannelResource2}
 * handles:
 * <ul>
 * <li>Blocking/unblocking processes</li>
 * <li>Creating new pushing processes</li>
 * </ul>
 * 
 * 
 * Who decides what data is given to which connector?
 * 
 * @implNote It might make sense to implement this as a strategy (composition over inheritance)
 *           instead of inheriting from {@link AbstractSimDataChannelResource}.
 * 
 */
public class SimDataChannelResource2 extends AbstractSimDataChannelResource {
    private Map<DataChannelSinkConnector, Queue<IndirectionDate>> outQueues = new HashMap<>();

    public SimDataChannelResource2(DataChannel dataChannel, InterpreterDefaultContext context, SchedulerModel model) {
        super(dataChannel, context, model);

        if (!(model instanceof SimuComModel)) {
            throw new PCMModelInterpreterException("Unsupported type of model: " + model.getClass().getName()
                    + ", expected: " + SimuComModel.class.getName());
        }

        SimuComModel simuComModel = (SimuComModel) model;
    }

    private Iterable<Queue<IndirectionDate>> getQueuesToSendTo(IndirectionDate date) {
        return outQueues.values();
    }

    private Queue<IndirectionDate> getQueueToReadFrom(DataChannelSinkConnector sinkConnector) {
        return outQueues.get(sinkConnector);
    }

    private void emit(IndirectionDate date) {
        getQueuesToSendTo(date).forEach(it -> it.add(date));
        processDataAvailableToGet();
    }

    @Override
    protected boolean canProvideDataFor(DataChannelSinkConnector sinkConnector) {
        return !getQueueToReadFrom(sinkConnector).isEmpty();
    }

    @Override
    protected Iterable<IndirectionDate> provideDataFor(DataChannelSinkConnector sinkConnector) {
        return Collections.singletonList(getQueueToReadFrom(sinkConnector).remove());
    }

    @Override
    protected boolean canAcceptDataFrom(DataChannelSourceConnector sourceConnector) {
        return true;
    }

    @Override
    protected void acceptDataFrom(DataChannelSourceConnector sourceConnector, IndirectionDate date) {
        processDataAvailableToGet();
    }
}
