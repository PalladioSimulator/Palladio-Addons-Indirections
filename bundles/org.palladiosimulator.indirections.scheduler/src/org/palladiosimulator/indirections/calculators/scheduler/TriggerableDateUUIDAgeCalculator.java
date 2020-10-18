package org.palladiosimulator.indirections.calculators.scheduler;

import java.util.UUID;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.palladiosimulator.indirections.monitoring.simulizar.IndirectionDependencyMeasurements;
import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public class TriggerableDateUUIDAgeCalculator extends TriggerableCalculator<Double, Duration> {
    private final IndirectionDependencyMeasurements indirectionDependencyMeasurements;

    public TriggerableDateUUIDAgeCalculator(final String name, final BaseMetricDescription baseMetric,
            final MetricSetDescription metricSet, final InterpreterDefaultContext context) {
        super(name, baseMetric, metricSet, context);
        
        this.indirectionDependencyMeasurements = IndirectionDependencyMeasurements.getInstanceFor(context);
    }
    
    public void doMeasure(final double timeSpan) {
        super.doMeasure(Measure.valueOf(timeSpan, SI.SECOND));
    }

    public void doMeasure(final UUID uuid) {
        double now = this.model.getSimulationControl()
                .getCurrentSimulationTime();
        double time = indirectionDependencyMeasurements.claimTimeFor(uuid);
        this.doMeasure(now - time);
    }
}