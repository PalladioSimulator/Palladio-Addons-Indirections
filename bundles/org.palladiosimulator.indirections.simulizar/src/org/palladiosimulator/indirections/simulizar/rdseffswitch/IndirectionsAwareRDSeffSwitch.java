package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import java.util.List;
import java.util.Map;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.indirections.actions.AddToDateAction;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.CreateDateAction;
import org.palladiosimulator.indirections.actions.DataIteratorAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.actions.PutTimeOnStackAction;
import org.palladiosimulator.indirections.actions.util.ActionsSwitch;
import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.simulizar.IndirectionMeasuringPointRegistry;
import org.palladiosimulator.indirections.monitoring.simulizar.TriggeredProxyProbe;
import org.palladiosimulator.indirections.scheduler.data.GroupingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.util.IndirectionModelUtil;
import org.palladiosimulator.indirections.util.simulizar.DataChannelRegistry;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.exceptions.SimulatedStackAccessException;
import org.palladiosimulator.simulizar.interpreter.ExplicitDispatchComposedSwitch;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.runtimestate.SimulatedBasicComponentInstance;

import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

public class IndirectionsAwareRDSeffSwitch extends ActionsSwitch<Object> {
    private static final Logger LOGGER = Logger.getLogger(IndirectionsAwareRDSeffSwitch.class);

    private final Allocation allocation;
    private final AssemblyContext assemblyContext;
    private final SimulatedBasicComponentInstance basicComponentInstance;
    private final InterpreterDefaultContext context;
    private final DataChannelRegistry dataChannelRegistry;
    private final IndirectionMeasuringPointRegistry indirectionMeasuringPointRegistry;

    private ExplicitDispatchComposedSwitch<Object> parentSwitch;
    private final SimulatedStackframe<Object> resultStackFrame;

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
        this.allocation = context.getLocalPCMModelAtContextCreation()
            .getAllocation();
        this.assemblyContext = context.getAssemblyContextStack()
            .lastElement();
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
    public Object caseAddToDateAction(final AddToDateAction action) {
        LOGGER.trace("Adding to date: " + action.getEntityName());

        final String referenceName = action.getVariableReference()
            .getReferenceName();

        final IndirectionDate date = IndirectionSimulationUtil.claimDataFromStack(this.context.getStack(),
                referenceName);

        final Map<String, Object> newEntries = IndirectionSimulationUtil.createDataEntries(this.context.getStack(),
                action.getVariableUsages());

        date.addData(newEntries);

        return true;
    }

    @Override
    public Object caseAnalyseStackAction(final AnalyseStackAction action) {
        LOGGER.trace("Analyzing data: " + action.getEntityName());

        final String referenceName = action.getVariableReference()
            .getReferenceName();

        final IndirectionDate data = IndirectionSimulationUtil.claimDataFromStack(this.context.getStack(),
                referenceName);

        data.getTime().forEach(it -> this.measureDataAge(action, it));

        return true;
    }

    @Override
    public Object caseConsumeDataAction(final ConsumeDataAction action) {
        LOGGER.trace("Consume data action: " + action.getEntityName());

        final DataChannelSourceConnector dataChannelSinkConnector = IndirectionModelUtil.getSinkConnector(this.context,
                action);
        final IDataChannelResource dataChannelResource = IndirectionModelUtil.getDataChannelResource(this.context,
                action);

        final String threadName = Thread.currentThread()
            .getName();

        LOGGER.trace("Trying to get (" + threadName + ")");

        // might block
        final boolean result = dataChannelResource.get(this.context.getThread(), dataChannelSinkConnector, (date) -> {
            this.context.getStack()
                .currentStackFrame()
                .addValue(action.getVariableReference()
                    .getReferenceName(), date);
            IndirectionSimulationUtil.makeDateInformationAvailableOnStack(this.context.getStack(),
                    action.getVariableReference()
                        .getReferenceName());
        });

        LOGGER.trace("Continuing with " + this.context.getStack()
            .currentStackFrame() + " (" + threadName + ")");

        return result;
    }

    @Override
    public Object caseCreateDateAction(final CreateDateAction action) {
        LOGGER.trace("Creating date: " + action.getEntityName());

        final String referenceName = action.getVariableReference()
            .getReferenceName();
        final double currentSimulationTime = this.context.getModel()
            .getSimulationControl()
            .getCurrentSimulationTime();

        final IndirectionDate date = IndirectionSimulationUtil.createData(this.context.getStack(),
                action.getVariableUsages(), currentSimulationTime);
        IndirectionSimulationUtil.createNewDataOnStack(this.context.getStack(), referenceName, date);

        return true;
    }

    @Override
    public Object caseDataIteratorAction(final DataIteratorAction action) {
        LOGGER.trace("Iterating over data: " + action.getEntityName());

        final String referenceName = action.getVariableReference()
            .getReferenceName();

        final IndirectionDate date = IndirectionSimulationUtil.claimDataFromStack(this.context.getStack(),
                referenceName);

        if (!(date instanceof GroupingIndirectionDate<?>)) {
            throw new PCMModelInterpreterException(
                    "Date cannot be iterated over, because it is not a grouping date: (is " + date.getClass()
                        .getName() + "): " + date.toString());
        }

        final GroupingIndirectionDate<IndirectionDate> groupingDate = (GroupingIndirectionDate<IndirectionDate>) date;
        for (final IndirectionDate iterationDate : groupingDate.getDataInGroup()) {
            LOGGER.debug("Iterating for " + iterationDate);

            final SimulatedStackframe<Object> innerVariableStackFrame = this.context.getStack()
                .createAndPushNewStackFrame(this.context.getStack()
                    .currentStackFrame());

            innerVariableStackFrame.addValue(referenceName + ".INNER", iterationDate);
            IndirectionSimulationUtil.makeDateInformationAvailableOnStack(this.context.getStack(),
                    referenceName + ".INNER");

            this.getParentSwitch()
                .doSwitch(action.getBodyBehaviour_Loop());

            if (this.context.getStack()
                .currentStackFrame() != innerVariableStackFrame) {
                throw new SimulatedStackAccessException(
                        "Inner value characterisations of inner collection variable expected");
            }

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Remove stack frame: " + innerVariableStackFrame);
            }
            this.context.getStack()
                .removeStackFrame();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Finished iteration on " + iterationDate + " (" + action + ")");
            }
        }

        return true;
    }

    @Override
    public Object caseEmitDataAction(final EmitDataAction action) {
        LOGGER.trace("Emit event action: " + action.getEntityName());

        final AssemblyContextSourceConnector sourceConnector = IndirectionModelUtil.getSourceConnector(this.context,
                action);

        if (sourceConnector instanceof DataChannelSinkConnector) {
            final IDataChannelResource dataChannelResource = IndirectionModelUtil.getDataChannelResource(this.context,
                    action);

            final String referenceName = action.getVariableReference()
                .getReferenceName();
            final IndirectionDate date = IndirectionSimulationUtil.claimDataFromStack(this.context.getStack(),
                    referenceName);

            LOGGER.trace("Trying to emit data " + date + " to " + dataChannelResource.getName() + " - "
                    + dataChannelResource.getId());

            // might block
            dataChannelResource.put(this.context.getThread(), (DataChannelSinkConnector) sourceConnector, date);

            return true;
        } else {
            throw new PCMModelInterpreterException(
                    "Unknown " + AssemblyContextSourceConnector.class.getName() + " type: " + sourceConnector);
        }
    }

    @Override
    public Object casePutTimeOnStackAction(final PutTimeOnStackAction object) {
        // TODO Auto-generated method stub
        return super.casePutTimeOnStackAction(object);
    }

    public Switch<Object> getParentSwitch() {
        if (this.parentSwitch != null) {
            return this.parentSwitch;
        }

        return this;
    }

    private void measureDataAge(final AnalyseStackAction action, final double value) {
        final TriggeredProxyProbe<Double, Duration> probe = this.indirectionMeasuringPointRegistry.getProbe(action,
                this.assemblyContext);

        final double currentSimulationTime = this.context.getModel()
            .getSimulationControl()
            .getCurrentSimulationTime();
        LOGGER.trace("Measuring age " + (currentSimulationTime - value) + " at " + currentSimulationTime);
        probe.doMeasure(Measure.valueOf(currentSimulationTime - value, SI.SECOND));
    }
}
