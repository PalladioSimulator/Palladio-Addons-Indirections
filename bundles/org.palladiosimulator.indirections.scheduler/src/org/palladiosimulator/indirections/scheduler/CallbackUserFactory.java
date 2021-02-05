package org.palladiosimulator.indirections.scheduler;

import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.scheduler.util.DataChannelResourceRegistry;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.util.ObjectUtil;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.pcm.usagemodel.UsagemodelFactory;
import org.palladiosimulator.probeframework.probes.TriggeredProbe;
import org.palladiosimulator.simulizar.di.component.interfaces.SimulatedThreadComponent;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.UsageScenarioSwitch;

import de.uka.ipd.sdq.scheduler.resources.active.IResourceTableManager;
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
            super(model, name, CallbackUserFactory.this.resourceTableManager);
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
            final var simulationCall = getCallInvocation(CallbackUserFactory.this.sinkRole, thread);

            for (final IndirectionDate currentDate : this.date) {
                // TODO: fix helper method to handle data on stack
                this.context.getStack()
                    .createAndPushNewStackFrame();
                final String parameterName = CallbackUserFactory.this.sourceRole.getDataInterface()
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

            parameterName = CallbackUserFactory.this.sourceRole.getDataInterface()
                .getDataSignature()
                .getParameter()
                .getParameterName();

            simulationCall = getCallInvocation(CallbackUserFactory.this.sinkRole, this);
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

    public static CallbackUserFactory createPushingUserFactory(final SimuComModel model, DataSourceRole sourceRole,
            DataSinkRole sinkRole, AssemblyContext sinkAssemblyContext, IResourceTableManager resourceTableManager,
            DataChannelResourceRegistry dataChannelResourceRegistry,
            SimulatedThreadComponent.Factory simulatedThreadComponentFactory) {
        return new CallbackUserFactory(model, sourceRole, sinkRole, sinkAssemblyContext, resourceTableManager,
                dataChannelResourceRegistry, simulatedThreadComponentFactory);
    }

    private BiConsumer<InterpreterDefaultContext, String> getCallInvocation(DataSinkRole role, SimuComSimProcess user) {
        var providingEntity = role.getProvidingEntity_ProvidedRole();
        if (providingEntity instanceof DataChannel) {
            return (context, parameterName) -> simulateDataChannelCall(context, role, parameterName, user);
        } else if (providingEntity instanceof BasicComponent) {
            return (context, parameterName) -> simulateComponentCall(context, role, parameterName, user);
        } else {
            throw new PCMModelInterpreterException("Unknown target providing entity for pushing: "
                    + providingEntity.getClass() + " (" + providingEntity + ")");
        }
    }

    private static UsageScenario initNewUsageScenario(final DataSourceRole role) {
        final UsageScenario usageScenario = UsagemodelFactory.eINSTANCE.createUsageScenario();
        usageScenario.setEntityName(role.getEntityName() + "_pushing_UsageScenario");
        return usageScenario;
    }

    /**
     * @see UsageScenarioSwitch#caseEntryLevelSystemCall(EntryLevelSystemCall)
     * @param context
     * @param user
     * @param connector
     */
    private void simulateComponentCall(final InterpreterDefaultContext context, final DataSinkRole sinkRole,
            String parameterName, SimuComSimProcess user) {

        var simulatedThreadComponent = this.simulatedThreadComponentFactory.create(context, user);
        var repositoryComponentSwitch = simulatedThreadComponent.repositoryComponentSwitchFactory()
            .create(context, CallbackUserFactory.this.sinkAssemblyContext, sinkRole.getDataInterface()
                .getDataSignature(), sinkRole);

        repositoryComponentSwitch.doSwitch(sinkRole);
        context.getStack()
            .removeStackFrame();
    }

    private void simulateDataChannelCall(final InterpreterDefaultContext context, DataSinkRole sinkRole,
            String parameterName, SimuComSimProcess user) {

        final DataChannel dataChannel = ObjectUtil.forceCast(sinkRole.getProvidingEntity_ProvidedRole(),
                DataChannel.class);

        final IDataChannelResource dataChannelResource = dataChannelResourceRegistry
            .getOrCreateDataChannelResource(dataChannel, CallbackUserFactory.this.sinkAssemblyContext);

        IndirectionDate date = IndirectionSimulationUtil.claimDataFromStack(context.getStack(), parameterName);
        dataChannelResource.put(context.getThread(), sinkRole, date);
    }

    private final DataSourceRole sourceRole;
    private final DataSinkRole sinkRole;
    private final IResourceTableManager resourceTableManager;
    private final SimulatedThreadComponent.Factory simulatedThreadComponentFactory;
    private final AssemblyContext sinkAssemblyContext;
    private final DataChannelResourceRegistry dataChannelResourceRegistry;

    public CallbackUserFactory(SimuComModel model, DataSourceRole sourceRole, DataSinkRole sinkRole,
            AssemblyContext sinkAssemblyContext, IResourceTableManager resourceTableManager,
            DataChannelResourceRegistry dataChannelResourceRegistry,
            SimulatedThreadComponent.Factory simulatedThreadComponentFactory) {
        super(model, initNewUsageScenario(sourceRole));
        this.sourceRole = sourceRole;
        this.sinkRole = sinkRole;
        this.sinkAssemblyContext = sinkAssemblyContext;
        this.resourceTableManager = resourceTableManager;
        this.dataChannelResourceRegistry = dataChannelResourceRegistry;
        this.simulatedThreadComponentFactory = simulatedThreadComponentFactory;
    }

    public CallbackIteratingUser createIteratingUser() {
        return new CallbackIteratingUser(this.model, "CallbackIteratingUser");
    }

    @Override
    public CallbackUser createUser() {
        return new CallbackUser(this.model, "CallbackUser");
    }
}