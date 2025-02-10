package org.palladiosimulator.indirections.calculators.scheduler;

import jakarta.measure.Measure;
import jakarta.measure.quantity.Dimensionless;

import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public class TriggerableCountingCalculator {
    private final TriggerableCalculator<Long, Dimensionless> calculatorSingle;
    private final TriggerableCalculator<Long, Dimensionless> calculatorTotal;

    long count = 0;

    public TriggerableCountingCalculator(final String nameSingle, final String nameTotal,
            final BaseMetricDescription baseMetric, final MetricSetDescription metricSetSingle,
            final MetricSetDescription metricSetTotal, final InterpreterDefaultContext context) {

        this.calculatorSingle = new TriggerableCalculator<Long, Dimensionless>(nameSingle, baseMetric, metricSetSingle,
                context);
        this.calculatorTotal = new TriggerableCalculator<Long, Dimensionless>(nameTotal, baseMetric, metricSetTotal,
                context);

        this.calculatorTotal.doMeasure(Measure.valueOf(0L, Dimensionless.UNIT));
    }

    public void change(final long number) {
        if (number != 0) {
            this.count += number;
            this.calculatorSingle.doMeasure(Measure.valueOf(number, Dimensionless.UNIT));
            this.calculatorTotal.doMeasure(Measure.valueOf(this.count, Dimensionless.UNIT));
        }
    }
}