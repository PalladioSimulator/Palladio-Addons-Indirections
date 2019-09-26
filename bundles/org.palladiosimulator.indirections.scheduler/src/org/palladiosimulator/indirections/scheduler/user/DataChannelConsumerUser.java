package org.palladiosimulator.indirections.scheduler.user;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.probeframework.measurement.RequestContext;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitch;

import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.usage.IUser;

public class DataChannelConsumerUser extends SimuComSimProcess implements IUser {
    private final static Logger LOGGER = Logger.getLogger(DataChannelConsumerUser.class);

    private final DataChannelSinkConnector sinkConnector;
    private final InterpreterDefaultContext parentContext;

    private IndirectionDate data = null;

    protected DataChannelConsumerUser(InterpreterDefaultContext parentContext, String name,
            RequestContext parentRequestContext, DataChannelSinkConnector sinkConnector) {
        super(parentContext.getModel(), name, parentRequestContext);

        this.sinkConnector = sinkConnector;
        this.parentContext = parentContext;
    }

    @Override
    public void scenarioRunner(SimuComSimProcess thread) {
        InterpreterDefaultContext context = new InterpreterDefaultContext(parentContext.getRuntimeState());
        context.setSimProcess(thread);

        final RepositoryComponentSwitch providedDelegationSwitch = new RepositoryComponentSwitch(context,
                sinkConnector.getAssemblyContext(), sinkConnector.getDataSinkRole().getPushesTo(),
                sinkConnector.getDataSinkRole());

        Objects.requireNonNull(data, "No data has been set yet.");

        IndirectionSimulationUtil.createNewDataOnStack(context.getStack(), "TEST", data);

        providedDelegationSwitch.doSwitch(sinkConnector.getDataSinkRole());
    }

    @Override
    public void startUserLife() {
        LOGGER.warn("No behavior for " + DataChannelConsumerUser.class.getName() + ".startUserLife()");
    }

    @Override
    protected void internalLifeCycle() {
        LOGGER.warn("No behavior for " + DataChannelConsumerUser.class.getName() + ".internalLifeCycle()");
    }

    public void setData(IndirectionDate data) {
        if (this.data != null) {
            throw new IllegalStateException(
                    "Data has already been set to " + this.data + ", cannot overwrite with " + data);
        }

        this.data = data;
    }

}
