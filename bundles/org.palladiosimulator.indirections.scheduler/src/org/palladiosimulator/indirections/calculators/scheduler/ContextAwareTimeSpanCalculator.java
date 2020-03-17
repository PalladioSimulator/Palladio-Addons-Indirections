package org.palladiosimulator.indirections.calculators.scheduler;

import java.util.HashMap;
import java.util.Map;

import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public class ContextAwareTimeSpanCalculator<C> extends TriggerableTimeSpanCalculator {
    public ContextAwareTimeSpanCalculator(String name, BaseMetricDescription baseMetric, MetricSetDescription metricSet,
            InterpreterDefaultContext context) {
        super(name, baseMetric, metricSet, context);
    }

    private Map<C, Double> activeMeasurements = new HashMap<>();

    public void startMeasurement(C c) {
        if (activeMeasurements.containsKey(c)) {
            throw new PCMModelInterpreterException("Cannot start measurement for " + c.toString()
                    + ", already started at " + activeMeasurements.get(c));
        }

        activeMeasurements.put(c, model.getSimulationControl().getCurrentSimulationTime());
    }

    public void endMeasurement(C c) {
        if (!activeMeasurements.containsKey(c)) {
            throw new PCMModelInterpreterException(
                    "Cannot end measurement for " + c.toString() + ", no measurement start present");
        }

        double timeSpan = model.getSimulationControl().getCurrentSimulationTime() - activeMeasurements.get(c);
        doMeasure(timeSpan);
    }
}