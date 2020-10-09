package org.palladiosimulator.indirections.scheduler;

import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;

import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.indirections.util.simulizar.DataChannelRegistry;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.pcm.usagemodel.UsagemodelFactory;
import org.palladiosimulator.probeframework.probes.TriggeredProbe;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitch;
import org.palladiosimulator.simulizar.interpreter.UsageScenarioSwitch;

import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.usage.AbstractWorkloadUserFactory;
import de.uka.ipd.sdq.simucomframework.usage.IUser;

public class CallbackUserFactory extends AbstractWorkloadUserFactory {
    /**
     * @param <T>
     *            type of the data
     */
    private abstract class AbstractCallbackUser<T> extends SimuComSimProcess implements IUser {
        protected InterpreterDefaultContext context;
        protected String dataId = null;
        protected T date = null;

        protected AbstractCallbackUser(final SimuComModel model, final String name) {
            super(model, name);
        }

        @Override
        protected void internalLifeCycle() {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(this.getName() + " started! I'm alive!!!");
            }
            // update session id
            this.updateNewSessionID();
            try {
                // TODO: Fixme and provide a new solution
                // blackboardGarbageCollector.enterRegion(getRequestContext()
                // .rootContext());
                ((TriggeredProbe) CallbackUserFactory.this.usageStartStopProbes.get(0))
                    .takeMeasurement(this.getRequestContext());
                this.scenarioRunner(this);
                ((TriggeredProbe) CallbackUserFactory.this.usageStartStopProbes.get(1))
                    .takeMeasurement(this.getRequestContext());
                if (this.getModel()
                    .getConfiguration()
                    .getSimulateFailures()) {
                    this.getModel()
                        .getFailureStatistics()
                        .recordSuccess();
                }
            } catch (final FailureException exception) {
                if (this.getModel()
                    .getConfiguration()
                    .getSimulateFailures()) {
                    this.getModel()
                        .getFailureStatistics()
                        .increaseUnhandledFailureCounter(exception.getFailureType(), this.currentSessionId);
                }
            } catch (final Exception e) {
                e.printStackTrace();
            } finally {
                // Increase measurements counter manually as usage scenario run is
                // not finished:
                this.getModel()
                    .increaseMainMeasurementsCount();

                // TODO: Fixme and provide a new solution
                // blackboardGarbageCollector.leaveRegion(getRequestContext()
                // .rootContext());
            }
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(this.getName() + " done! I'm dying!!!");
            }
        }

        public void setDataAndStartUserLife(final String dataId, final T date,
                final InterpreterDefaultContext context) {
            this.dataId = dataId;
            this.date = date;
            this.context = context;

            this.startUserLife();
        }

        @Override
        public void startUserLife() {
            this.scheduleAt(0);
        }
    }

    public class CallbackIteratingUser extends AbstractCallbackUser<List<IndirectionDate>> {
        public CallbackIteratingUser(final SimuComModel owner, final String name) {
            super(owner, name);
        }

        @Override
        public void scenarioRunner(final SimuComSimProcess thread) {
            final var simulationCall = getCallInvocation(CallbackUserFactory.this.connector);

            for (final IndirectionDate currentDate : this.date) {
                // TODO: fix helper method to handle data on stack
                this.context.getStack()
                    .createAndPushNewStackFrame();
                final String parameterName = CallbackUserFactory.this.connector.getDataSinkRole()
                    .getDataInterface()
                    .getDataSignature()
                    .getParameter()
                    .getParameterName();

                IndirectionSimulationUtil.createNewDataOnStack(this.context.getStack(), parameterName,
                        Objects.requireNonNull(currentDate));
                IndirectionSimulationUtil.flattenDataOnStack(this.context.getStack(), parameterName, currentDate);

                simulationCall.accept(this.context, parameterName);
            }
        }
    }

    public class CallbackUser extends AbstractCallbackUser<IndirectionDate> {
        private final String parameterName;
        private final BiConsumer<InterpreterDefaultContext, String> simulationCall;

        public CallbackUser(final SimuComModel owner, final String name) {
            super(owner, name);

            parameterName = CallbackUserFactory.this.connector.getDataSinkRole()
                .getDataInterface()
                .getDataSignature()
                .getParameter()
                .getParameterName();

            simulationCall = getCallInvocation(CallbackUserFactory.this.connector);
        }

        @Override
        public void scenarioRunner(final SimuComSimProcess thread) {
            // TODO: fix helper method to handle data on stack
            this.context.getStack()
                .createAndPushNewStackFrame();

            IndirectionSimulationUtil.createNewDataOnStack(this.context.getStack(), parameterName,
                    Objects.requireNonNull(this.date));
            IndirectionSimulationUtil.flattenDataOnStack(this.context.getStack(), parameterName, this.date);

            simulationCall.accept(this.context, parameterName);
        }
    }

    public static CallbackUserFactory createPushingUserFactory(final SimuComModel model,
            final DataChannelSourceConnector connector) {
        return new CallbackUserFactory(model, connector);
    }

    private static BiConsumer<InterpreterDefaultContext, String> getCallInvocation(
            final DataChannelSourceConnector connector) {
        if (connector instanceof DataChannelSinkConnector) {
            return (context, parameterName) -> simulateDataChannelCall(context, (DataChannelSinkConnector) connector,
                    parameterName);
        } else if (connector instanceof AssemblyContextSinkConnector) {
            return (context, parameterName) -> simulateComponentCall(context, (AssemblyContextSinkConnector) connector,
                    parameterName);
        } else {
            throw new PCMModelInterpreterException(
                    "Unknown connector type for pushing: " + connector.getClass() + " (" + connector + ")");
        }
    }

    private static UsageScenario initNewUsageScenario(final DataChannelSourceConnector connector) {
        final UsageScenario usageScenario = UsagemodelFactory.eINSTANCE.createUsageScenario();
        usageScenario.setEntityName(connector.getEntityName() + "_pushing_UsageScenario");
        return usageScenario;
    }

    /**
     * @see UsageScenarioSwitch#caseEntryLevelSystemCall(EntryLevelSystemCall)
     * @param context
     * @param connector
     */
    private static void simulateComponentCall(final InterpreterDefaultContext context,
            final AssemblyContextSinkConnector connector, String parameterName) {
        final DataSinkRole sinkRole = connector.getDataSinkRole();

        final RepositoryComponentSwitch providedDelegationSwitch = new RepositoryComponentSwitch(context,
                connector.getSinkAssemblyContext(), connector.getPushesTo(), sinkRole);

        providedDelegationSwitch.doSwitch(sinkRole);
        context.getStack()
            .removeStackFrame();
    }

    private static void simulateDataChannelCall(final InterpreterDefaultContext context,
            final DataChannelSinkConnector connector, String parameterName) {

        final DataSinkRole sinkRole = connector.getDataSinkRole();
        final DataChannel dataChannel = connector.getSinkDataChannel();

        final IDataChannelResource dataChannelResource = DataChannelRegistry.getInstanceFor(context)
            .getOrCreateDataChannelResource(dataChannel);

        IndirectionDate date = IndirectionSimulationUtil.claimDataFromStack(context.getStack(), parameterName);
        dataChannelResource.put(context.getThread(), connector, date);
    }

    private final DataChannelSourceConnector connector;

    public CallbackUserFactory(final SimuComModel model, final DataChannelSourceConnector connector) {
        super(model, initNewUsageScenario(connector));
        this.connector = connector;
    }

    public CallbackIteratingUser createIteratingUser() {
        return new CallbackIteratingUser(this.model, "CallbackIteratingUser");
    }

    @Override
    public CallbackUser createUser() {
        return new CallbackUser(this.model, "CallbackUser");
    }
}