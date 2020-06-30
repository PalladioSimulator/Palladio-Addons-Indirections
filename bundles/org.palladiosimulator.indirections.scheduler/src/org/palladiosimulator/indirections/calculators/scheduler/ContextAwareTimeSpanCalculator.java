package org.palladiosimulator.indirections.calculators.scheduler;

import java.util.HashMap;
import java.util.Map;

import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public class ContextAwareTimeSpanCalculator<C> extends TriggerableTimeSpanCalculator {
    private final Map<C, Double> activeMeasurements = new HashMap<>();

    public ContextAwareTimeSpanCalculator(final String name, final BaseMetricDescription baseMetric,
            final MetricSetDescription metricSet, final InterpreterDefaultContext context) {
        super(name, baseMetric, metricSet, context);
    }

    public void endMeasurement(final C c) {
        if (!this.activeMeasurements.containsKey(c)) {
            throw new PCMModelInterpreterException(
                    "Cannot end measurement for " + c.toString() + ", no measurement start present");
        }

        final double timeSpan = this.model.getSimulationControl()
            .getCurrentSimulationTime() - this.activeMeasurements.get(c);
        this.doMeasure(timeSpan);
    }

    public void startMeasurement(final C c) {
        if (this.activeMeasurements.containsKey(c)) {
            throw new PCMModelInterpreterException("Cannot start measurement for " + c.toString()
                    + ", already started at " + this.activeMeasurements.get(c));
        }

        this.activeMeasurements.put(c, this.model.getSimulationControl()
            .getCurrentSimulationTime());
    }
}