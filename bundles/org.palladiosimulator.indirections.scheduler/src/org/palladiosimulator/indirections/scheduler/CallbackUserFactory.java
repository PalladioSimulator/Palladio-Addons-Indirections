package org.palladiosimulator.indirections.scheduler;

import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.initName;

import java.util.List;
import java.util.Objects;

import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.pcm.core.CoreFactory;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.parameter.ParameterFactory;
import org.palladiosimulator.pcm.parameter.VariableCharacterisation;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import org.palladiosimulator.pcm.usagemodel.Start;
import org.palladiosimulator.pcm.usagemodel.Stop;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.pcm.usagemodel.UsagemodelFactory;
import org.palladiosimulator.probeframework.probes.TriggeredProbe;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.UsageScenarioSwitch;

import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.usage.AbstractWorkloadUserFactory;
import de.uka.ipd.sdq.simucomframework.usage.IUser;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.VariableReference;

public class CallbackUserFactory extends AbstractWorkloadUserFactory {
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

	public class CallbackIteratingUser extends AbstractCallbackUser<List<IndirectionDate>> {
		public CallbackIteratingUser(SimuComModel owner, String name) {
			super(owner, name);
		}

		@Override
		public void scenarioRunner(SimuComSimProcess thread) {
			for (IndirectionDate currentDate : this.date) {
				final InterpreterDefaultContext newContext = new InterpreterDefaultContext(
						context.getRuntimeState().getMainContext(), thread);

				// TODO: fix helper method to handle data on stack
				context.getStack().createAndPushNewStackFrame();
				IndirectionSimulationUtil.createNewDataOnStack(context.getStack(), Objects.requireNonNull(dataId),
						Objects.requireNonNull(currentDate));

				new UsageScenarioSwitch<Object>(newContext).doSwitch(usageScenario);
			}
		}
	}

	public class CallbackUser extends AbstractCallbackUser<IndirectionDate> {
		public CallbackUser(SimuComModel owner, String name) {
			super(owner, name);
		}

		@Override
		public void scenarioRunner(SimuComSimProcess thread) {
			final InterpreterDefaultContext newContext = new InterpreterDefaultContext(
					context.getRuntimeState().getMainContext(), thread);

			// TODO: fix helper method to handle data on stack
			context.getStack().createAndPushNewStackFrame();
			IndirectionSimulationUtil.createNewDataOnStack(context.getStack(), Objects.requireNonNull(dataId),
					Objects.requireNonNull(date));

			new UsageScenarioSwitch<Object>(newContext).doSwitch(usageScenario);
		}
	}

	private final UsageScenario usageScenario;

	public CallbackUserFactory(SimuComModel model, UsageScenario usageScenario) {
		super(model, usageScenario);
		this.usageScenario = usageScenario;
	}

	public CallbackUser createUser() {
		return new CallbackUser(model, "CallbackUser");
	}

	public CallbackIteratingUser createIteratingUser() {
		return new CallbackIteratingUser(model, "CallbackIteratingUser");
	}

	public static CallbackUserFactory createPushingUserFactory(DataChannelSinkConnector sinkConnector,
			SimuComModel model) {

		final DataSinkRole sinkRole = sinkConnector.getDataSinkRole();

		UsagemodelFactory factory = UsagemodelFactory.eINSTANCE;
		ParameterFactory parameterFactory = ParameterFactory.eINSTANCE;
		StoexFactory stoexFactory = StoexFactory.eINSTANCE;
		CoreFactory coreFactory = CoreFactory.eINSTANCE;

		final String baseName = sinkConnector.getEntityName() + ".Generated";
		final String parameterName = IndirectionSimulationUtil.getOneParameter(sinkRole.getEventGroup())
				.getParameterName();

		UsageScenario usageScenario = initName(factory.createUsageScenario(), baseName + ".UsageScenario");
		ScenarioBehaviour scenarioBehaviour = initName(factory.createScenarioBehaviour(),
				baseName + ".UsageScenario.Behaviour");

		EntryLevelSystemCall elsc = initName(factory.createEntryLevelSystemCall(), baseName + ".UsageScenario.ELSC");

		PCMRandomVariable pcmRandomVariable = coreFactory.createPCMRandomVariable();
		pcmRandomVariable.setSpecification(parameterName);

		VariableCharacterisation variableCharacterisation = parameterFactory.createVariableCharacterisation();
		variableCharacterisation.setSpecification_VariableCharacterisation(pcmRandomVariable);

		VariableReference variableReference = stoexFactory.createVariableReference();
		variableReference.setReferenceName(parameterName);

		VariableUsage variableUsage = parameterFactory.createVariableUsage();
		variableUsage.setEntryLevelSystemCall_InputParameterUsage(elsc);
		variableUsage.setNamedReference__VariableUsage(variableReference);
		variableUsage.getVariableCharacterisation_VariableUsage().add(variableCharacterisation);

		variableUsage.setNamedReference__VariableUsage(variableReference);

		elsc.getInputParameterUsages_EntryLevelSystemCall().add(variableUsage);

		Start startAction = initName(factory.createStart(), baseName + ".UsageScenario.Start");
		Stop stopAction = initName(factory.createStop(), baseName + ".UsageScenario.Stop");

		startAction.setSuccessor(elsc);
		elsc.setSuccessor(stopAction);

		scenarioBehaviour.getActions_ScenarioBehaviour().addAll(List.of(startAction, elsc, stopAction));

		usageScenario.setScenarioBehaviour_UsageScenario(scenarioBehaviour);

		CallbackUserFactory userFactory = new CallbackUserFactory(model, usageScenario);

		return userFactory;
	}
}