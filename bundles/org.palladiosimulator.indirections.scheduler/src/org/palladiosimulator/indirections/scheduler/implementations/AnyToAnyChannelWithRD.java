package org.palladiosimulator.indirections.scheduler.implementations;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class AnyToAnyChannelWithRD extends AnyToAnyBlockingChannelWithCapacity {
    public static final String CPU_ID = "_oro4gG3fEdy4YaaT-RYrLQ"; // from Palladio.resourcetype
    private static final String ACCEPT_RESOURCE_DEMAND_PARAMETER_NAME = "acceptResourceDemand";
    private final String acceptResourceDemand;
    
    private int waitingData = 0;

    public AnyToAnyChannelWithRD(JavaClassDataChannel dataChannel, InterpreterDefaultContext context,
            SchedulerModel model) {
        super(dataChannel, context, model);

        this.acceptResourceDemand = IndirectionSimulationUtil.getStringParameter(dataChannel,
                ACCEPT_RESOURCE_DEMAND_PARAMETER_NAME);
    }

    @Override
    protected void acceptData(DataChannelSinkConnector connector, IndirectionDate date) {
        waitingData += 1;
        scheduleDemand(CPU_ID, acceptResourceDemand, date, () -> {
            super.acceptData(connector, date);
            waitingData -= 1;
        });
    }
    
    @Override
    protected boolean canAcceptData(DataChannelSinkConnector connector) {
        return this.data.size() + waitingData < this.capacity;
    }
}
