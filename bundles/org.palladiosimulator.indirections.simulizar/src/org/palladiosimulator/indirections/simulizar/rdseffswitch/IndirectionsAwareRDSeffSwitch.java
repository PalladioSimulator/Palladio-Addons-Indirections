package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import java.util.Map;

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
import org.palladiosimulator.indirections.scheduler.data.ConcreteGroupingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.ConcreteIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.DataWithSource;
import org.palladiosimulator.indirections.scheduler.data.JoinedDate;
import org.palladiosimulator.indirections.scheduler.data.PartitionedIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.JoiningOperator;
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

import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.stoex.VariableReference;

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
        System.out.println("Emit event action: " + action.getEntityName());

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

            if (action.getEntityName().equals("calculateOutlier.consumeGroupAndAverage")) {
                System.out.println(date);
                JoinedDate<IndirectionDate> jdate = (JoinedDate<IndirectionDate>) date;

                for (Map.Entry<JoiningOperator.Channel<DataWithSource<IndirectionDate>>, IndirectionDate> entry : jdate.data
                        .entrySet()) {
                    if (entry.getValue() instanceof ConcreteGroupingIndirectionDate) {
                        ConcreteGroupingIndirectionDate<PartitionedIndirectionDate<Map<String, Object>, ConcreteIndirectionDate>> cgid = (ConcreteGroupingIndirectionDate<PartitionedIndirectionDate<Map<String, Object>, ConcreteIndirectionDate>>) entry
                                .getValue();

                        for (PartitionedIndirectionDate<Map<String, Object>, ConcreteIndirectionDate> pid : cgid
                                .getDataInGroup()) {
                            for (ConcreteIndirectionDate concreteDate : pid.getDataInGroup()) {
                                String csvLine = context.getModel().getSimulationControl().getCurrentSimulationTime()
                                        + "," + concreteDate.uuid.toString() + "," + concreteDate.getTime();

                                ModelObserver.measure(
                                        context.getModel().getSimulationControl().getCurrentSimulationTime(),
                                        concreteDate.uuid.toString(), concreteDate.getTime());
                                System.out.println(csvLine);
                            }
                            System.out.println();
                        }
                    }
                }
            }
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

        VariableReference variableReference = (VariableReference) action.getVariableUsages().get(0)
                .getNamedReference__VariableUsage();

        System.out.println("Variable reference: " + variableReference.getReferenceName());

        if (variableReference.getReferenceName().equals("NUMBER_OF_ELEMENTS_0")) {
            System.out.println("Putting number of elements on stack.");

            PartitionedIndirectionDate<Map<String, Object>, IndirectionDate> median = null;
            SimulatedStackframe<Object> currentStackFrame = context.getStack().currentStackFrame();
            try {
                median = (PartitionedIndirectionDate<Map<String, Object>, IndirectionDate>) currentStackFrame
                        .getValue("median");
            } catch (ValueNotInFrameException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            currentStackFrame.addValue("median.NUMBER_OF_ELEMENTS", median.getDataInGroup().size());

            return true;
        }

        if (variableReference.getReferenceName().equals("NUMBER_OF_ELEMENTS_1")) {
            System.out.println("Putting number of elements on stack.");

            PartitionedIndirectionDate<Map<String, Object>, PartitionedIndirectionDate<Map<String, Object>, ConcreteIndirectionDate>> medianGroup = null;
            SimulatedStackframe<Object> currentStackFrame = context.getStack().currentStackFrame();
            try {
                medianGroup = (PartitionedIndirectionDate<Map<String, Object>, PartitionedIndirectionDate<Map<String, Object>, ConcreteIndirectionDate>>) currentStackFrame
                        .getValue("mediansPerHousehold");
            } catch (ValueNotInFrameException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Partition: " + medianGroup.getPartition().toString() + ", "
                    + medianGroup.getDataInGroup().get(0).getPartition().toString());

            int noe = medianGroup.getDataInGroup().get(0).getDataInGroup().size();

            currentStackFrame.addValue("mediansPerHousehold.NUMBER_OF_ELEMENTS", noe);

            return true;
        }

        if (variableReference.getReferenceName().equals("NUMBER_OF_ELEMENTS_2")) {
            System.out.println("Putting number of elements on stack.");

            ConcreteGroupingIndirectionDate<PartitionedIndirectionDate<Map<String, Object>, ConcreteIndirectionDate>> medianGroup = null;
            SimulatedStackframe<Object> currentStackFrame = context.getStack().currentStackFrame();
            try {
                medianGroup = (ConcreteGroupingIndirectionDate<PartitionedIndirectionDate<Map<String, Object>, ConcreteIndirectionDate>>) currentStackFrame
                        .getValue("averageAll");
            } catch (ValueNotInFrameException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            int noe = medianGroup.getDataInGroup().stream().mapToInt(it -> it.getDataInGroup().size()).sum();
            medianGroup.getDataInGroup().forEach(it -> System.out.println("NOE2, Partition: " + it.getPartition()));

            currentStackFrame.addValue("averageAll.NUMBER_OF_ELEMENTS", noe);

            return true;
        }

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
