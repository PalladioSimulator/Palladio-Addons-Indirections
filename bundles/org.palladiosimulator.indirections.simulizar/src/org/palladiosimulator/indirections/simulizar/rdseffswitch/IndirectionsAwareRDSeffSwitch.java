package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.apache.log4j.Logger;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.CreateDataAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.actions.PutDataOnStackAction;
import org.palladiosimulator.indirections.actions.util.ActionsSwitch;
import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.simulizar.measurements.IndirectionMeasuringPointRegistry;
import org.palladiosimulator.indirections.simulizar.measurements.TriggeredProxyProbe;
import org.palladiosimulator.indirections.util.IndirectionModelUtil;
import org.palladiosimulator.indirections.util.simulizar.DataChannelRegistry;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.ExplicitDispatchComposedSwitch;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.runtimestate.SimulatedBasicComponentInstance;

import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

public class IndirectionsAwareRDSeffSwitch extends ActionsSwitch<Object> {
    private static final Logger LOGGER = Logger.getLogger(IndirectionsAwareRDSeffSwitch.class);

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

        final DataChannelSourceConnector dataChannelSourceConnector = IndirectionModelUtil.getSourceConnector(context,
                action);
        final IDataChannelResource dataChannelResource = IndirectionModelUtil.getDataChannelResource(context, action);

        String referenceName = action.getVariableReference().getReferenceName();
        IndirectionDate date = IndirectionSimulationUtil.claimDataFromStack(context.getStack(), referenceName);

        LOGGER.trace("Trying to emit data " + date + " to " + dataChannelResource.getName() + " - "
                + dataChannelResource.getId());
        dataChannelResource.put(this.context.getThread(), dataChannelSourceConnector, date);

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
        final boolean result = dataChannelResource.get(this.context.getThread(), dataChannelSinkConnector, (date) -> {
            context.getStack().currentStackFrame().addValue(action.getVariableReference().getReferenceName(), date);
            LOGGER.trace("Got stack frame: " + this.context.getStack().currentStackFrame().toString());
        });

        LOGGER.trace("Continuing with " + this.context.getStack().currentStackFrame() + " (" + threadName + ")");

        return result;
    }

    @Override
    public Object caseCreateDataAction(CreateDataAction action) {
        LOGGER.trace("Creating birth date: " + action.getEntityName());

        String referenceName = action.getVariableReference().getReferenceName();
        double currentSimulationTime = context.getModel().getSimulationControl().getCurrentSimulationTime();

        IndirectionDate date = IndirectionSimulationUtil.createData(context.getStack(), action.getVariableUsages(),
                currentSimulationTime);
        IndirectionSimulationUtil.createNewDataOnStack(context.getStack(), referenceName, date);

        return true;
    }

    @Override
    public Object caseAnalyseStackAction(AnalyseStackAction action) {
        LOGGER.trace("Analyzing data: " + action.getEntityName());

        String referenceName = action.getVariableReference().getReferenceName();

        IndirectionDate data = IndirectionSimulationUtil.claimDataFromStack(context.getStack(), referenceName);
        measureDataAge(action, data.getTime());

        return true;
    }

    @Override
    public Object casePutDataOnStackAction(PutDataOnStackAction action) {
        LOGGER.trace("Putting data on stack: " + action.getEntityName());

        throw new PCMModelInterpreterException("not yet supported: " + action);

//        return true;
    }

    private void measureDataAge(AnalyseStackAction action, double value) {
        TriggeredProxyProbe<Double, Duration> probe = this.indirectionMeasuringPointRegistry.getProbe(action,
                allocation);

        double currentSimulationTime = context.getModel().getSimulationControl().getCurrentSimulationTime();
        probe.doMeasure(Measure.valueOf(currentSimulationTime - value, SI.SECOND));
    }
}
