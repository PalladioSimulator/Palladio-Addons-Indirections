package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.CreateBirthDateAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.actions.util.ActionsSwitch;
import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.simulizar.measurements.IndirectionMeasuringPointRegistry;
import org.palladiosimulator.indirections.simulizar.measurements.TriggeredProxyProbe;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.util.IndirectionModelUtil;
import org.palladiosimulator.indirections.util.IterableUtil;
import org.palladiosimulator.indirections.util.MapUtil;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.parameter.VariableCharacterisation;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.ExplicitDispatchComposedSwitch;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.runtimestate.SimulatedBasicComponentInstance;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.analyser.visitors.StoExPrettyPrintVisitor;

public class IndirectionsAwareRDSeffSwitch extends ActionsSwitch<Object> {
    private static final Logger LOGGER = Logger.getLogger(IndirectionsAwareRDSeffSwitch.class);

    public final static String DEFAULT_BIRTH_DATE_REFERENCE_NAME = "__BIRTH__";

    private final InterpreterDefaultContext context;
    private final SimulatedBasicComponentInstance basicComponentInstance;
    private ExplicitDispatchComposedSwitch<Object> parentSwitch;
    private final Allocation allocation;
    private final SimulatedStackframe<Object> resultStackFrame;

    private final DataChannelRegistry dataChannelRegistry;
    private final IndirectionMeasuringPointRegistry indirectionMeasuringPointRegistry;

    /**
     * copied from
     * {@link org.palladiosimulator.simulizar.interpreter.RDSeffSwitch#RDSeffSwitch(InterpreterDefaultContext, SimulatedBasicComponentInstance)}
     * 
     * @param context
     * @param basicComponentInstance
     */
    public IndirectionsAwareRDSeffSwitch(final InterpreterDefaultContext context,
            final SimulatedBasicComponentInstance basicComponentInstance) {
        super();
        this.context = context;
        this.allocation = context.getLocalPCMModelAtContextCreation().getAllocation();
        this.resultStackFrame = new SimulatedStackframe<Object>();
        this.basicComponentInstance = basicComponentInstance;

        this.dataChannelRegistry = DataChannelRegistry.getInstanceFor(context);
        this.indirectionMeasuringPointRegistry = IndirectionMeasuringPointRegistry.getInstanceFor(context);
    }

    public IndirectionsAwareRDSeffSwitch(final InterpreterDefaultContext context,
            final SimulatedBasicComponentInstance basicComponentInstance,
            final ExplicitDispatchComposedSwitch<Object> parentSwitch) {
        this(context, basicComponentInstance);
        this.parentSwitch = parentSwitch;
    }

    /**
     * Same as
     * {@link SimulatedStackHelper#addParameterToStackFrame(SimulatedStackframe, EList, SimulatedStackframe)}
     * but defaults for the parameters.
     * 
     * Additionally, it can copy all characterizations for a type by specifying a reference name of:
     * input->output
     * 
     * @param parameterName
     */
    // TODO clean up and refactor
    private static final void addParameterToStackFrameWithCopying(final SimulatedStackframe<Object> contextStackFrame,
            final EList<VariableUsage> parameter, final String parameterName,
            final SimulatedStackframe<Object> targetStackFrame) {

        for (final VariableUsage variableUsage : parameter) {
            if (variableUsage.getVariableCharacterisation_VariableUsage().isEmpty()) {
                final AbstractNamedReference namedReference = variableUsage.getNamedReference__VariableUsage();
                // TODO: move from convention quick hack to better solution
                final String[] split = namedReference.getReferenceName().split("->");
                if (split.length != 2) {
                    throw new PCMModelInterpreterException(
                            "If no variable chacterisations are present, name must be of form 'input->output'. Name is: "
                                    + namedReference.getReferenceName());
                }

                final String inputPrefix = split[0] + ".";
                final String outputPrefix = split[1] + ".";

                final List<Entry<String, Object>> inputs = contextStackFrame.getContents().stream()
                        .filter(it -> it.getKey().startsWith(inputPrefix)).collect(Collectors.toList());

                if (inputs.size() == 0) {
                    throw new PCMModelInterpreterException("Nothing found on stack frame for prefix '" + inputPrefix
                            + "'. Available: " + contextStackFrame.getContents().stream().map(it -> it.getKey())
                                    .collect(Collectors.joining(", ")));
                }

                inputs.forEach(it -> targetStackFrame
                        .addValue(outputPrefix + it.getKey().substring(inputPrefix.length()), it.getValue()));
                continue;
            }

            for (final VariableCharacterisation variableCharacterisation : variableUsage
                    .getVariableCharacterisation_VariableUsage()) {

                final PCMRandomVariable randomVariable = variableCharacterisation
                        .getSpecification_VariableCharacterisation();

                final AbstractNamedReference namedReference = variableCharacterisation
                        .getVariableUsage_VariableCharacterisation().getNamedReference__VariableUsage();

                final String id = new StoExPrettyPrintVisitor().doSwitch(namedReference).toString() + "."
                        + variableCharacterisation.getType().getLiteral();

                if (SimulatedStackHelper.isInnerReference(namedReference)) {
                    targetStackFrame.addValue(id,
                            new EvaluationProxy(randomVariable.getSpecification(), contextStackFrame.copyFrame()));
                } else {
                    targetStackFrame.addValue(id,
                            StackContext.evaluateStatic(randomVariable.getSpecification(), contextStackFrame));
                }

                if (LOGGER.isDebugEnabled()) {
                    try {
                        LOGGER.debug("Added value " + targetStackFrame.getValue(id) + " for id " + id
                                + " to stackframe " + targetStackFrame);
                    } catch (final ValueNotInFrameException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Override
    public Object caseEmitDataAction(final EmitDataAction action) {
        LOGGER.trace("Emit event action: " + action.getEntityName());

        this.getSourceConnector(action);
        final DataChannelSourceConnector dataChannelSourceConnecoor = this.getSourceConnector(action);
        final IDataChannelResource dataChannelResource = this.getDataChannelResource(action);

        final SimulatedStackframe<Object> eventStackframe = new SimulatedStackframe<Object>();
        final String parameterName = IterableUtil
                .claimOne(action.getDataSourceRole().getEventGroup().getEventTypes__EventGroup())
                .getParameter__EventType().getParameterName();
        addParameterToStackFrameWithCopying(this.context.getStack().currentStackFrame(),
                action.getInputVariableUsages__CallAction(), parameterName, eventStackframe);

        // TODO: check cases in which getContents does not work
        LOGGER.trace("Trying to emit data to " + dataChannelResource.getName() + " - " + dataChannelResource.getId());
        dataChannelResource.put(this.context.getThread(), dataChannelSourceConnecoor,
                MapUtil.toMap(eventStackframe.getContents()));

        return true;
    }

    @Override
    public Object caseConsumeDataAction(final ConsumeDataAction action) {
        LOGGER.trace("Consume data action: " + action.getEntityName());

        final DataChannelSinkConnector dataChannelSinkConnector = this.getSinkConnector(action);
        final IDataChannelResource dataChannelResource = this.getDataChannelResource(action);

        final String threadName = Thread.currentThread().getName();

        LOGGER.trace("Trying to get (" + threadName + ")");
        final boolean result = dataChannelResource.get(this.context.getThread(), dataChannelSinkConnector,
                (eventMap) -> {
                    final SimulatedStackframe<Object> contextStackframe = SimulatedStackHelper
                            .createFromMap(eventMap.getData());
                    final String parameterName = IterableUtil
                            .claimOne(action.getDataSinkRole().getEventGroup().getEventTypes__EventGroup())
                            .getParameter__EventType().getParameterName();
                    LOGGER.trace("Parameter name: " + parameterName + " (thread: " + threadName + ")");
                    addParameterToStackFrameWithCopying(contextStackframe,
                            action.getReturnVariableUsage__CallReturnAction(), parameterName,
                            this.context.getStack().currentStackFrame());
                    LOGGER.trace("Got stack frame: " + this.context.getStack().currentStackFrame().toString());
                });

        LOGGER.trace("Continuing with " + this.context.getStack().currentStackFrame() + " (" + threadName + ")");

        return result;
    }

    @Override
    public Object caseCreateBirthDateAction(CreateBirthDateAction action) {
        LOGGER.trace("Creating birth date: " + action.getEntityName());

        String referenceName = action.getVariableReference().getReferenceName();

        double currentSimulationTime = context.getModel().getSimulationControl().getCurrentSimulationTime();
        SimulatedStackframe<Object> currentStackFrame = this.context.getStack().currentStackFrame();

        currentStackFrame.addValue(referenceName, currentSimulationTime);

        return true;
    }

    @Override
    public Object caseAnalyseStackAction(AnalyseStackAction action) {
        LOGGER.trace("Analyzing data: " + action.getEntityName());

        String referenceName = Optional.ofNullable(action.getVariableReference())
                .map(it -> it.getReferenceName()).orElse(DEFAULT_BIRTH_DATE_REFERENCE_NAME);

        TriggeredProxyProbe<Double, Duration> probe = this.indirectionMeasuringPointRegistry.getProbe(action,
                allocation);

        double currentSimulationTime = context.getModel().getSimulationControl().getCurrentSimulationTime();
        SimulatedStackframe<Object> currentStackFrame = this.context.getStack().currentStackFrame();

        double value;
        try {
            value = (double) currentStackFrame.getValue(referenceName);
        } catch (ValueNotInFrameException e) {
            // TODO Auto-generated catch block
            throw new PCMModelInterpreterException("Stack analysis did not find value", e);
        }
        probe.doMeasure(Measure.valueOf(currentSimulationTime - value, SI.SECOND));

        return true;
    }

    private IDataChannelResource getDataChannelResource(final EmitDataAction action) {
        final DataChannel dataChannel = this.getSourceConnector(action).getDataChannel();

        final IDataChannelResource dataChannelResource = this.dataChannelRegistry
                .getOrCreateDataChannelResource(dataChannel);
        return dataChannelResource;
    }

    private DataChannelSourceConnector getSourceConnector(final EmitDataAction action) {
        final AssemblyContext assemblyContext = this.context.getAssemblyContextStack().peek();
        final DataSourceRole sinkRole = action.getDataSourceRole();

        return IndirectionModelUtil.getSourceConnectorForRole(assemblyContext, sinkRole);
    }

    private IDataChannelResource getDataChannelResource(final ConsumeDataAction action) {
        final DataChannel dataChannel = this.getSinkConnector(action).getDataChannel();
        final IDataChannelResource dataChannelResource = this.dataChannelRegistry
                .getOrCreateDataChannelResource(dataChannel);
        return dataChannelResource;
    }

    private DataChannelSinkConnector getSinkConnector(final ConsumeDataAction action) {
        final AssemblyContext assemblyContext = this.context.getAssemblyContextStack().peek();
        final DataSinkRole sinkRole = action.getDataSinkRole();

        return IndirectionModelUtil.getSinkConnectorForRole(assemblyContext, sinkRole);
    }
}
