package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import java.util.Optional;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.apache.log4j.Logger;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.CreateBirthDateAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.actions.util.ActionsSwitch;
import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.simulizar.measurements.IndirectionMeasuringPointRegistry;
import org.palladiosimulator.indirections.simulizar.measurements.TriggeredProxyProbe;
import org.palladiosimulator.indirections.util.IndirectionModelUtil;
import org.palladiosimulator.indirections.util.IndirectionUtil;
import org.palladiosimulator.indirections.util.IterableUtil;
import org.palladiosimulator.indirections.util.MapUtil;
import org.palladiosimulator.indirections.util.simulizar.DataChannelRegistry;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.ExplicitDispatchComposedSwitch;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.runtimestate.SimulatedBasicComponentInstance;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

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

    @Override
    public Object caseEmitDataAction(final EmitDataAction action) {
        LOGGER.trace("Emit event action: " + action.getEntityName());

        final DataChannelSourceConnector dataChannelSourceConnecoor = IndirectionModelUtil.getSourceConnector(context,
                action);
        final IDataChannelResource dataChannelResource = IndirectionModelUtil.getDataChannelResource(context, action);

        final SimulatedStackframe<Object> eventStackframe = new SimulatedStackframe<Object>();
        final String parameterName = IterableUtil
                .claimOne(action.getDataSourceRole().getEventGroup().getEventTypes__EventGroup())
                .getParameter__EventType().getParameterName();
        IndirectionUtil.addParameterToStackFrameWithCopying(this.context.getStack().currentStackFrame(),
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

        final DataChannelSinkConnector dataChannelSinkConnector = IndirectionModelUtil.getSinkConnector(context,
                action);
        final IDataChannelResource dataChannelResource = IndirectionModelUtil.getDataChannelResource(context, action);

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
                    IndirectionUtil.addParameterToStackFrameWithCopying(contextStackframe,
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
}
