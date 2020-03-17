package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.datatypes.Scheduling;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Resource that can only get and put data. Does not do any collective operations.
 * <p>
 * Data is distributed to the consumer that wants data in a FIFO + FCFS manner.
 * 
 * @author Dominik Werle
 */
public class SimBasicDataChannelResource extends AbstractSimDataChannelResource {
    public SimBasicDataChannelResource(DataChannel dataChannel, InterpreterDefaultContext context,
            SchedulerModel model) {
        super(dataChannel, context, model);

        if (!(model instanceof SimuComModel)) {
            throw new PCMModelInterpreterException("Unsupported type of model: " + model.getClass().getName()
                    + ", expected: " + SimuComModel.class.getName());
        }

        SimuComModel simuComModel = (SimuComModel) model;

        if (dataChannel.getScheduling() != Scheduling.FIRST_IN_FIRST_OUT)
            throw new IllegalArgumentException("Data channel " + name + " is not basic (is not FIFO).");

        capacity = dataChannel.getCapacity();

        setupCalculators();
    }

    public class DataWithTime<T extends IndirectionDate> {
        public final T date;
        public final double time;

        public DataWithTime(T date) {
            super();
            this.date = date;
            this.time = model.getSimulationControl().getCurrentSimulationTime();
        }
    }

    private Queue<DataWithTime<IndirectionDate>> data = new ArrayDeque<>();
    private int capacity;

    private TriggerableTimeSpanCalculator holdingTimeCalculator;
    private TriggerableTimeSpanCalculator dataAgeAfterPuttingCalculator;
    private TriggerableTimeSpanCalculator dataAgeBeforeGettingCalculator;

    private void setupCalculators() {
        this.holdingTimeCalculator = new TriggerableTimeSpanCalculator("Holding time for " + name,
                MetricDescriptionConstants.HOLDING_TIME_METRIC, MetricDescriptionConstants.HOLDING_TIME_METRIC_TUPLE);
        this.dataAgeAfterPuttingCalculator = new TriggerableTimeSpanCalculator("Data age after putting into " + name,
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE);
        this.dataAgeBeforeGettingCalculator = new TriggerableTimeSpanCalculator("Data age before getting from " + name,
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE);
    }

    @Override
    protected boolean canAcceptDataFrom(DataChannelSourceConnector sourceConnector) {
        return capacity == -1 || (data.size() < capacity);
    }

    @Override
    protected boolean canProvideDataFor(DataChannelSinkConnector sinkConnector) {
        return data.size() > 0;
    }

    @Override
    protected Iterable<IndirectionDate> provideDataFor(DataChannelSinkConnector sinkConnector) {
        DataWithTime<IndirectionDate> nextData = data.remove();
        holdingTimeCalculator.doMeasureUntilNow(nextData.time);

        IndirectionSimulationUtil.getDataAgeRecursive(nextData.date).forEach(dataAgeBeforeGettingCalculator::doMeasure);

        return Collections.singleton(nextData.date);
    }

    @Override
    protected void acceptDataFrom(DataChannelSourceConnector sourceConnector, IndirectionDate date) {
        IndirectionSimulationUtil.getDataAgeRecursive(date).forEach(dataAgeAfterPuttingCalculator::doMeasure);

        data.add(new DataWithTime<IndirectionDate>(date));
    }

}
