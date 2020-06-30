package org.palladiosimulator.indirections.scheduler;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
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
	private DataChannelSourceConnector connector;

	/**
	 * @param <T> type of the data
	 */
	private abstract class AbstractCallbackUser<T> extends SimuComSimProcess implements IUser {
		protected String dataId = null;
		protected T date = null;
		protected InterpreterDefaultContext context;

		protected AbstractCallbackUser(SimuComModel model, String name) {
			super(model, name);
		}

		public void setDataAndStartUserLife(String dataId, T date, InterpreterDefaultContext context) {
			this.dataId = dataId;
			this.date = date;
			this.context = context;

			startUserLife();
		}

		@Override
		public void startUserLife() {
			this.scheduleAt(0);
		}

		@Override
		protected void internalLifeCycle() {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(getName() + " started! I'm alive!!!");
			}
			// update session id
			updateNewSessionID();
			try {
				// TODO: Fixme and provide a new solution
				// blackboardGarbageCollector.enterRegion(getRequestContext()
				// .rootContext());
				((TriggeredProbe) usageStartStopProbes.get(0)).takeMeasurement(getRequestContext());
				scenarioRunner(this);
				((TriggeredProbe) usageStartStopProbes.get(1)).takeMeasurement(getRequestContext());
				if (getModel().getConfiguration().getSimulateFailures()) {
					getModel().getFailureStatistics().recordSuccess();
				}
			} catch (final FailureException exception) {
				if (getModel().getConfiguration().getSimulateFailures()) {
					getModel().getFailureStatistics().increaseUnhandledFailureCounter(exception.getFailureType(),
							currentSessionId);
				}
			} finally {
				// Increase measurements counter manually as usage scenario run is
				// not finished:
				getModel().increaseMainMeasurementsCount();

				// TODO: Fixme and provide a new solution
				// blackboardGarbageCollector.leaveRegion(getRequestContext()
				// .rootContext());
			}
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(getName() + " done! I'm dying!!!");
			}
		}
	}

	/**
	 * @see UsageScenarioSwitch#caseEntryLevelSystemCall(EntryLevelSystemCall)
	 * @param context
	 * @param connector
	 */
	private static void simulateComponentCall(InterpreterDefaultContext context,
			AssemblyContextSinkConnector connector) {
		DataSinkRole sinkRole = connector.getDataSinkRole();

		final RepositoryComponentSwitch providedDelegationSwitch = new RepositoryComponentSwitch(context,
				connector.getSinkAssemblyContext(), connector.getPushesTo(), sinkRole);

		providedDelegationSwitch.doSwitch(sinkRole);
		context.getStack().removeStackFrame();
	}

	private static void simulateDataChannelCall(InterpreterDefaultContext context, DataChannelSinkConnector connector) {
		throw new UnsupportedOperationException();
	}

	private static Consumer<InterpreterDefaultContext> getCallInvocation(DataChannelSourceConnector connector) {
		if (connector instanceof DataChannelSinkConnector) {
			return (context) -> simulateDataChannelCall(context, (DataChannelSinkConnector) connector);
		} else if (connector instanceof AssemblyContextSinkConnector) {
			return (context) -> simulateComponentCall(context, (AssemblyContextSinkConnector) connector);
		} else {
			throw new PCMModelInterpreterException(
					"Unknown connector type for pushing: " + connector.getClass() + " (" + connector + ")");
		}
	}

	public class CallbackIteratingUser extends AbstractCallbackUser<List<IndirectionDate>> {
		public CallbackIteratingUser(SimuComModel owner, String name) {
			super(owner, name);
		}

		@Override
		public void scenarioRunner(SimuComSimProcess thread) {
			Consumer<InterpreterDefaultContext> simulationCall = getCallInvocation(connector);

			for (IndirectionDate currentDate : this.date) {
				// TODO: fix helper method to handle data on stack
				context.getStack().createAndPushNewStackFrame();
				String parameterName = IndirectionSimulationUtil
						.getOneParameter(connector.getDataSinkRole().getEventGroup()).getParameterName();

				IndirectionSimulationUtil.createNewDataOnStack(context.getStack(), parameterName,
						Objects.requireNonNull(currentDate));
				IndirectionSimulationUtil.flattenDataOnStack(this.context.getStack(), parameterName, currentDate);

				simulationCall.accept(context);
			}
		}
	}

	public class CallbackUser extends AbstractCallbackUser<IndirectionDate> {
		public CallbackUser(SimuComModel owner, String name) {
			super(owner, name);
		}

		@Override
		public void scenarioRunner(SimuComSimProcess thread) {
			Consumer<InterpreterDefaultContext> simulationCall = getCallInvocation(connector);
			
			// TODO: fix helper method to handle data on stack
			context.getStack().createAndPushNewStackFrame();
			String parameterName = IndirectionSimulationUtil
					.getOneParameter(connector.getDataSinkRole().getEventGroup()).getParameterName();

			IndirectionSimulationUtil.createNewDataOnStack(context.getStack(), parameterName,
					Objects.requireNonNull(date));
			IndirectionSimulationUtil.flattenDataOnStack(this.context.getStack(), parameterName, date);

			simulationCall.accept(context);
		}
	}

	public CallbackUserFactory(SimuComModel model, DataChannelSourceConnector connector) {
		super(model, initNewUsageScenario(connector));
		this.connector = connector;
	}

	private static UsageScenario initNewUsageScenario(DataChannelSourceConnector connector) {
		UsageScenario usageScenario = UsagemodelFactory.eINSTANCE.createUsageScenario();
		usageScenario.setEntityName(connector.getEntityName() + "_pushing_UsageScenario");
		return usageScenario;
	}

	public CallbackUser createUser() {
		return new CallbackUser(model, "CallbackUser");
	}

	public CallbackIteratingUser createIteratingUser() {
		return new CallbackIteratingUser(model, "CallbackIteratingUser");
	}

	public static CallbackUserFactory createPushingUserFactory(SimuComModel model,
			DataChannelSourceConnector connector) {
		return new CallbackUserFactory(model, connector);
	}
}