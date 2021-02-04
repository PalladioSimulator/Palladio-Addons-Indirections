package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.indirections.actions.AddToDateAction;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.CreateDateAction;
import org.palladiosimulator.indirections.actions.DataIteratorAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.actions.PutTimeOnStackAction;
import org.palladiosimulator.indirections.actions.util.ActionsSwitch;
import org.palladiosimulator.indirections.composition.AssemblyDataConnector;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.simulizar.IndirectionMeasuringPointRegistry;
import org.palladiosimulator.indirections.monitoring.simulizar.TriggeredProxyProbe;
import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.indirections.scheduler.data.GroupingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.util.IndirectionModelUtil;
import org.palladiosimulator.indirections.util.simulizar.DataChannelRegistry;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.exceptions.SimulatedStackAccessException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RDSeffSwitchContributionFactory;
import org.palladiosimulator.simulizar.interpreter.RDSeffSwitchContributionFactory.RDSeffElementDispatcher;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitch;
import org.palladiosimulator.simulizar.interpreter.result.InterpretationIssue;
import org.palladiosimulator.simulizar.interpreter.result.InterpreterResult;

import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

public class IndirectionsRDSeffSwitch extends ActionsSwitch<InterpreterResult> {
	@AssistedFactory
	public interface Factory extends RDSeffSwitchContributionFactory {
		IndirectionsRDSeffSwitch create(InterpreterDefaultContext context, RDSeffElementDispatcher parentSwitch);

		@Override
		default Switch<InterpreterResult> createRDSeffSwitch(InterpreterDefaultContext context,
				RDSeffElementDispatcher parentSwitch) {
			return create(context, parentSwitch);
		}
	}

	private RDSeffElementDispatcher parentSwitch;

	private static final Logger LOGGER = Logger.getLogger(IndirectionsRDSeffSwitch.class);

	private final Allocation allocation;
	private final AssemblyContext assemblyContext;
	private final InterpreterDefaultContext context;
	private final DataChannelRegistry dataChannelRegistry;
	private final IndirectionMeasuringPointRegistry indirectionMeasuringPointRegistry;

	private final SimulatedStackframe<Object> resultStackFrame;

	private final RepositoryComponentSwitch.Factory repositoryComponentSwitchFactory;

	@AssistedInject
	public IndirectionsRDSeffSwitch(@Assisted InterpreterDefaultContext context,
			@Assisted RDSeffElementDispatcher parentSwitch,
			RepositoryComponentSwitch.Factory repositoryComponentSwitchFactory, InterpreterDefaultContext mainContext) {
		super();

		this.parentSwitch = parentSwitch;

		this.context = context;
        this.repositoryComponentSwitchFactory = repositoryComponentSwitchFactory;
		this.allocation = context.getLocalPCMModelAtContextCreation().getAllocation();
		this.assemblyContext = context.getAssemblyContextStack().lastElement();
		this.resultStackFrame = new SimulatedStackframe<Object>();

		this.dataChannelRegistry = DataChannelRegistry.getInstanceFor(context, repositoryComponentSwitchFactory);
        this.indirectionMeasuringPointRegistry = IndirectionMeasuringPointRegistry.getInstanceFor(mainContext);
	}

	@Override
	public InterpreterResult caseAddToDateAction(final AddToDateAction action) {
		LOGGER.trace("Adding to date: " + action.getEntityName());

		final String referenceName = action.getVariableReference().getReferenceName();

		final IndirectionDate date = IndirectionSimulationUtil.claimDataFromStack(this.context.getStack(),
				referenceName);

		final Map<String, Object> newEntries = IndirectionSimulationUtil.createDataEntries(this.context.getStack(),
				action.getVariableUsages());

		date.addData(newEntries);

		return InterpreterResult.OK;
	}

	@Override
	public InterpreterResult caseAnalyseStackAction(final AnalyseStackAction action) {
		LOGGER.trace("Analyzing data: " + action.getEntityName());

		final String referenceName = action.getVariableReference().getReferenceName();

		final IndirectionDate data = IndirectionSimulationUtil.claimDataFromStack(this.context.getStack(),
				referenceName);

		data.getTime().forEach(it -> this.measureDataAge(action, it));

		return InterpreterResult.OK;
	}

	@Override
	public InterpreterResult caseConsumeDataAction(final ConsumeDataAction action) {
		LOGGER.trace("Consume data action: " + action.getEntityName());

		final AssemblyDataConnector assemblyDataConnector = IndirectionModelUtil
				.getExactlyOneAssemblyDataConnector(assemblyContext, action.getDataSinkRole());

		var sourceComponent = assemblyDataConnector.getSourceAssemblyContext()
				.getEncapsulatedComponent__AssemblyContext();
		var sinkComponent = assemblyDataConnector.getSinkAssemblyContext().getEncapsulatedComponent__AssemblyContext();
		if (!(sourceComponent instanceof DataChannel)) {
			throw new PCMModelInterpreterException(
					"Currently, only direct connections between BasicComponents and DataChannels are supported. "
							+ "Found connector " + assemblyDataConnector.getId() + " that points from "
							+ sourceComponent.getId() + " (" + sourceComponent.getClass().getName() + ") to "
							+ sinkComponent.getId() + " (" + sinkComponent.getClass().getName() + ")");
		}

		var dataChannel = (DataChannel) sourceComponent;

		final IDataChannelResource dataChannelResource = IndirectionModelUtil.getDataChannelResource(context,
				repositoryComponentSwitchFactory, assemblyDataConnector.getSourceAssemblyContext());

		final String threadName = Thread.currentThread().getName();

		LOGGER.trace("Trying to get from " + dataChannel.getEntityName() + ", resource: "
				+ dataChannelResource.getName() + " (" + threadName + ")");

		// might block
		final boolean result = dataChannelResource.get(this.context.getThread(),
				assemblyDataConnector.getDataSourceRole(), (date) -> {
					this.context.getStack().currentStackFrame()
							.addValue(action.getVariableReference().getReferenceName(), date);
					IndirectionSimulationUtil.makeDateInformationAvailableOnStack(this.context.getStack(),
							action.getVariableReference().getReferenceName());
				});

		LOGGER.trace("Continuing with " + this.context.getStack().currentStackFrame() + " (" + threadName + ")");

		if (result)
			return InterpreterResult.OK;
		else {
			return new InterpreterResult() {
				@Override
				public boolean hasNoIssues() {
					return false;
				}

				@Override
				public Iterable<InterpretationIssue> getIssues() {
					return Collections.singleton(new InterpretationIssue() {
					}); // ???
				}
			};
		}
	}

	@Override
	public InterpreterResult caseEmitDataAction(final EmitDataAction action) {
		double currentSimulationTime = context.getModel().getSimulationControl().getCurrentSimulationTime();

		LOGGER.trace("Emit event action: " + action.getEntityName() + ", " + currentSimulationTime);

		final AssemblyDataConnector assemblyDataConnector = IndirectionModelUtil
				.getExactlyOneAssemblyDataConnector(assemblyContext, action.getDataSourceRole());

		var sourceComponent = assemblyDataConnector.getSourceAssemblyContext()
				.getEncapsulatedComponent__AssemblyContext();
		var sinkComponent = assemblyDataConnector.getSinkAssemblyContext().getEncapsulatedComponent__AssemblyContext();
		if (!(sinkComponent instanceof DataChannel)) {
			throw new PCMModelInterpreterException(
					"Currently, only direct connections between BasicComponents and DataChannels are supported. "
							+ "Found connector " + assemblyDataConnector.getId() + " that points from "
							+ sourceComponent.getId() + " (" + sourceComponent.getClass().getName() + ") to "
							+ sinkComponent.getId() + " (" + sinkComponent.getClass().getName() + ")");
		}

		final IDataChannelResource dataChannelResource = IndirectionModelUtil.getDataChannelResource(this.context,
				repositoryComponentSwitchFactory, assemblyDataConnector.getSinkAssemblyContext());

		final String referenceName = action.getVariableReference().getReferenceName();
		final IndirectionDate date = IndirectionSimulationUtil.claimDataFromStack(this.context.getStack(),
				referenceName);

		LOGGER.trace("Trying to emit data " + date + " to " + dataChannelResource.getName() + " - "
				+ dataChannelResource.getId());

		// might block
		dataChannelResource.put(this.context.getThread(), assemblyDataConnector.getDataSinkRole(), date);

		return InterpreterResult.OK;
	}

	@Override
	public InterpreterResult caseCreateDateAction(final CreateDateAction action) {
		LOGGER.trace("Creating date: " + action.getEntityName());

		String referenceName = action.getVariableReference().getReferenceName();

		Collection<Double> time = new ArrayList<>();
		EList<PCMRandomVariable> dependsOn = action.getDependsOn();

		if (dependsOn.isEmpty()) {
			time.add(this.context.getModel().getSimulationControl().getCurrentSimulationTime());
		} else {
			var timeDependencies = dependsOn.stream().map(
					it -> StackContext.evaluateStatic(it.getSpecification(), context.getStack().currentStackFrame()))
					.collect(Collectors.toList());

			var times = IndirectionSimulationUtil.flatResolveTimes(timeDependencies);

			time.addAll(times);
		}

		IndirectionDate date = IndirectionSimulationUtil.createData(this.context.getStack(), action.getVariableUsages(),
				time);
		IndirectionSimulationUtil.createNewDataOnStack(this.context.getStack(), referenceName, date);

		return InterpreterResult.OK;
	}

	@Override
	public InterpreterResult caseDataIteratorAction(final DataIteratorAction action) {
		LOGGER.trace("Iterating over data: " + action.getEntityName());

		final String referenceName = action.getVariableReference().getReferenceName();

		final IndirectionDate date = IndirectionSimulationUtil.claimDataFromStack(this.context.getStack(),
				referenceName);

		if (!(date instanceof GroupingIndirectionDate<?>)) {
			throw new PCMModelInterpreterException(
					"Date cannot be iterated over, because it is not a grouping date: (is " + date.getClass().getName()
							+ "): " + date.toString());
		}

		final GroupingIndirectionDate<IndirectionDate> groupingDate = (GroupingIndirectionDate<IndirectionDate>) date;
		for (final IndirectionDate iterationDate : groupingDate.getDataInGroup()) {
			LOGGER.debug("Iterating for " + iterationDate);

			final SimulatedStackframe<Object> innerVariableStackFrame = this.context.getStack()
					.createAndPushNewStackFrame(this.context.getStack().currentStackFrame());

			innerVariableStackFrame.addValue(referenceName + ".INNER", iterationDate);
			IndirectionSimulationUtil.makeDateInformationAvailableOnStack(this.context.getStack(),
					referenceName + ".INNER");

			this.getParentSwitch().doSwitch(action.getBodyBehaviour_Loop());

			if (this.context.getStack().currentStackFrame() != innerVariableStackFrame) {
				throw new SimulatedStackAccessException(
						"Inner value characterisations of inner collection variable expected");
			}

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Remove stack frame: " + innerVariableStackFrame);
			}
			this.context.getStack().removeStackFrame();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Finished iteration on " + iterationDate + " (" + action + ")");
			}
		}

		return InterpreterResult.OK;
	}

	@Override
	public InterpreterResult casePutTimeOnStackAction(final PutTimeOnStackAction object) {
		// TODO Auto-generated method stub
		return super.casePutTimeOnStackAction(object);
	}

	public RDSeffElementDispatcher getParentSwitch() {
		if (this.parentSwitch != null) {
			return this.parentSwitch;
		}

		return new RDSeffElementDispatcher() {

			@Override
			public InterpreterResult doSwitch(EClass theEClass, EObject theEObject) {
				return this.doSwitch(theEClass, theEObject);
			}
		};
	}

	private void measureDataAge(final AnalyseStackAction action, final double value) {
		final TriggeredProxyProbe<Double, Duration> probe = this.indirectionMeasuringPointRegistry.getProbe(action,
				this.assemblyContext);

		final double currentSimulationTime = this.context.getModel().getSimulationControl().getCurrentSimulationTime();
		LOGGER.trace("Measuring age " + (currentSimulationTime - value) + " at " + currentSimulationTime);
		probe.doMeasure(Measure.valueOf(currentSimulationTime - value, SI.SECOND));
	}
}
