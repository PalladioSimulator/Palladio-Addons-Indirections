package org.palladiosimulator.indirections.calculators.scheduler;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public class TriggerableTimeSpanCalculator extends TriggerableCalculator<Double, Duration> {
    public TriggerableTimeSpanCalculator(String name, BaseMetricDescription baseMetric, MetricSetDescription metricSet,
            InterpreterDefaultContext context) {
        super(name, baseMetric, metricSet, context);
    }

    public void doMeasure(double timeSpan) {
        super.doMeasure(Measure.valueOf(timeSpan, SI.SECOND));
    }

    public void doMeasureUntilNow(double time) {
        doMeasure(model.getSimulationControl().getCurrentSimulationTime() - time);
    }
}