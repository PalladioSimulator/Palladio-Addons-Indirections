package org.palladiosimulator.indirections.calculators.scheduler;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public class TriggerableCountingCalculator {
	private final TriggerableCalculator<Long, Dimensionless> calculatorTotal;
	private final TriggerableCalculator<Long, Dimensionless> calculatorSingle;

	long count = 0;

	public TriggerableCountingCalculator(String nameSingle, String nameTotal, BaseMetricDescription baseMetric,
			MetricSetDescription metricSetSingle, MetricSetDescription metricSetTotal,
			InterpreterDefaultContext context) {

		calculatorSingle = new TriggerableCalculator<Long, Dimensionless>(nameSingle, baseMetric, metricSetSingle,
				context);
		calculatorTotal = new TriggerableCalculator<Long, Dimensionless>(nameTotal, baseMetric, metricSetTotal,
				context);

		calculatorTotal.doMeasure(Measure.valueOf(0L, Dimensionless.UNIT));
	}

	public void change(long number) {
		if (number != 0) {
			count += number;
			calculatorSingle.doMeasure(Measure.valueOf(number, Dimensionless.UNIT));
			calculatorTotal.doMeasure(Measure.valueOf(count, Dimensionless.UNIT));
		}
	}
}