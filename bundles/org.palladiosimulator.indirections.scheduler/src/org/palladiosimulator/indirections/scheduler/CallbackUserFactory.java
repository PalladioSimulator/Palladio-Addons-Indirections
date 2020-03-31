package org.palladiosimulator.indirections.scheduler;

import java.util.List;
import java.util.Objects;

import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.pcm.usagemodel.UsagemodelFactory;
import org.palladiosimulator.probeframework.probes.TriggeredProbe;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitch;
import org.palladiosimulator.simulizar.interpreter.UsageScenarioSwitch;

import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.usage.AbstractWorkloadUserFactory;
import de.uka.ipd.sdq.simucomframework.usage.IUser;

public class CallbackUserFactory extends AbstractWorkloadUserFactory {
	private DataChannelSinkConnector sinkConnector;

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
	 * @param sinkConnector
	 */
	private void simulateComponentCall(InterpreterDefaultContext context, DataChannelSinkConnector sinkConnector) {
		DataSinkRole sinkRole = sinkConnector.getDataSinkRole();

		final RepositoryComponentSwitch providedDelegationSwitch = new RepositoryComponentSwitch(context,
				sinkConnector.getAssemblyContext(), sinkRole.getPushesTo(), sinkRole);

		providedDelegationSwitch.doSwitch(sinkRole);
		context.getStack().removeStackFrame();
	}

	public class CallbackIteratingUser extends AbstractCallbackUser<List<IndirectionDate>> {
		public CallbackIteratingUser(SimuComModel owner, String name) {
			super(owner, name);
		}

		@Override
		public void scenarioRunner(SimuComSimProcess thread) {
			for (IndirectionDate currentDate : this.date) {
				// TODO: fix helper method to handle data on stack
				context.getStack().createAndPushNewStackFrame();
				String parameterName = IndirectionSimulationUtil
						.getOneParameter(sinkConnector.getDataSinkRole().getEventGroup()).getParameterName();
				IndirectionSimulationUtil.createNewDataOnStack(context.getStack(), parameterName,
						Objects.requireNonNull(currentDate));

				simulateComponentCall(context, sinkConnector);
			}
		}
	}

	public class CallbackUser extends AbstractCallbackUser<IndirectionDate> {
		public CallbackUser(SimuComModel owner, String name) {
			super(owner, name);
		}

		@Override
		public void scenarioRunner(SimuComSimProcess thread) {
			// TODO: fix helper method to handle data on stack
			context.getStack().createAndPushNewStackFrame();
			String parameterName = IndirectionSimulationUtil
					.getOneParameter(sinkConnector.getDataSinkRole().getEventGroup()).getParameterName();
			IndirectionSimulationUtil.createNewDataOnStack(context.getStack(), parameterName,
					Objects.requireNonNull(date));

			simulateComponentCall(context, sinkConnector);
		}
	}

	public CallbackUserFactory(SimuComModel model, DataChannelSinkConnector sinkConnector) {
		super(model, initNewUsageScenario(sinkConnector));
		this.sinkConnector = sinkConnector;
	}

	private static UsageScenario initNewUsageScenario(DataChannelSinkConnector sinkConnector) {
		UsageScenario usageScenario = UsagemodelFactory.eINSTANCE.createUsageScenario();
		usageScenario.setEntityName(sinkConnector.getEntityName() + "_pushing_UsageScenario");
		return usageScenario;
	}

	public CallbackUser createUser() {
		return new CallbackUser(model, "CallbackUser");
	}

	public CallbackIteratingUser createIteratingUser() {
		return new CallbackIteratingUser(model, "CallbackIteratingUser");
	}

	public static CallbackUserFactory createPushingUserFactory(DataChannelSinkConnector sinkConnector,
			SimuComModel model) {

		return new CallbackUserFactory(model, sinkConnector);

		/*
		 * 
		 * final DataSinkRole sinkRole = sinkConnector.getDataSinkRole();
		 * 
		 * UsagemodelFactory factory = UsagemodelFactory.eINSTANCE;
		 * org.palladiosimulator.indirections.usagemodel.UsagemodelFactory
		 * indirectionFactory =
		 * org.palladiosimulator.indirections.usagemodel.UsagemodelFactory.eINSTANCE;
		 * ParameterFactory parameterFactory = ParameterFactory.eINSTANCE; StoexFactory
		 * stoexFactory = StoexFactory.eINSTANCE;
		 * 
		 * CoreFactory coreFactory = CoreFactory.eINSTANCE;
		 * 
		 * final String baseName = sinkConnector.getEntityName() + ".Generated"; final
		 * String parameterName =
		 * IndirectionSimulationUtil.getOneParameter(sinkRole.getEventGroup())
		 * .getParameterName();
		 * 
		 * UsageScenario usageScenario = initName(factory.createUsageScenario(),
		 * baseName + ".UsageScenario"); ScenarioBehaviour scenarioBehaviour =
		 * initName(factory.createScenarioBehaviour(), baseName +
		 * ".UsageScenario.Behaviour");
		 * 
		 * ComponentCallAction cca =
		 * initName(indirectionFactory.createComponentCallAction(), baseName +
		 * ".UsageScenario.CCA");
		 * cca.setSignature(sinkConnector.getDataSinkRole().getPushesTo());
		 * cca.setAssemblyContext(sinkConnector.getAssemblyContext());
		 * 
		 * PCMRandomVariable pcmRandomVariable = coreFactory.createPCMRandomVariable();
		 * pcmRandomVariable.setSpecification(parameterName);
		 * 
		 * VariableCharacterisation variableCharacterisation =
		 * parameterFactory.createVariableCharacterisation();
		 * variableCharacterisation.setSpecification_VariableCharacterisation(
		 * pcmRandomVariable);
		 * 
		 * VariableReference variableReference = stoexFactory.createVariableReference();
		 * variableReference.setReferenceName(parameterName);
		 * 
		 * VariableUsage variableUsage = parameterFactory.createVariableUsage();
		 * variableUsage.setNamedReference__VariableUsage(variableReference);
		 * variableUsage.getVariableCharacterisation_VariableUsage().add(
		 * variableCharacterisation);
		 * variableUsage.setNamedReference__VariableUsage(variableReference);
		 * 
		 * cca.getInputParameterUsages().add(variableUsage);
		 * 
		 * Start startAction = initName(factory.createStart(), baseName +
		 * ".UsageScenario.Start"); Stop stopAction = initName(factory.createStop(),
		 * baseName + ".UsageScenario.Stop");
		 * 
		 * startAction.setSuccessor(cca); cca.setSuccessor(stopAction);
		 * 
		 * scenarioBehaviour.getActions_ScenarioBehaviour().addAll(List.of(startAction,
		 * cca, stopAction));
		 * 
		 * usageScenario.setScenarioBehaviour_UsageScenario(scenarioBehaviour);
		 * 
		 * CallbackUserFactory userFactory = new CallbackUserFactory(model,
		 * usageScenario);
		 * 
		 * return userFactory;
		 */
	}
}