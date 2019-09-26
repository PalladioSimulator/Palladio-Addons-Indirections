package org.palladiosimulator.indirections.scheduler.user;

import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.probeframework.measurement.RequestContext;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public class DataChannelUserFactory {
    private final InterpreterDefaultContext context;

    public DataChannelUserFactory(InterpreterDefaultContext context) {
        this.context = context;
    }

    public DataChannelConsumerUser createPassivatedUser(DataChannelSinkConnector sinkConnector) {
        DataChannelConsumerUser user = new DataChannelConsumerUser(context, "Test-User", new RequestContext("TEST!"),
                sinkConnector);
        user.passivate();

        return user;
    }

}
