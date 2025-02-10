package org.palladiosimulator.indirections.calculators.scheduler;

import jakarta.measure.Measure;
import jakarta.measure.quantity.Duration;
import jakarta.measure.unit.SI;

import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public class TriggerableTimeSpanCalculator extends TriggerableCalculator<Double, Duration> {
    public TriggerableTimeSpanCalculator(final String name, final BaseMetricDescription baseMetric,
            final MetricSetDescription metricSet, final InterpreterDefaultContext context) {
        super(name, baseMetric, metricSet, context);
    }

    public void doMeasure(final double timeSpan) {
        super.doMeasure(Measure.valueOf(timeSpan, SI.SECOND));
    }

    public void doMeasureUntilNow(final double time) {
        double now = this.model.getSimulationControl()
            .getCurrentSimulationTime();
        this.doMeasure(now - time);
    }
}