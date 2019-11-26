package org.palladiosimulator.indirections.monitoring.simulizar;

import java.util.LinkedList;
import java.util.List;

import javax.measure.quantity.Quantity;

import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.measurementframework.measureprovider.IMeasureProvider;
import org.palladiosimulator.measurementframework.measureprovider.MeasurementListMeasureProvider;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.probeframework.measurement.ProbeMeasurement;
import org.palladiosimulator.probeframework.measurement.RequestContext;
import org.palladiosimulator.probeframework.probes.Probe;
import org.palladiosimulator.probeframework.probes.TriggeredProbe;
import org.palladiosimulator.probeframework.probes.listener.IProbeListener;

public class TriggeredCombiningProbe<V, Q extends Quantity> extends Probe implements IProbeListener {
    private final List<TriggeredProbe> subsumedProbes;
    private TriggeredProbe triggerProbe;

    protected TriggeredCombiningProbe(MetricDescription metricDesciption, List<TriggeredProbe> subsumedProbes,
            TriggeredProbe triggerProbe) {
        super(metricDesciption);
        this.subsumedProbes = subsumedProbes;
        this.triggerProbe = triggerProbe;

        if (!subsumedProbes.contains(triggerProbe)) {
            throw new IllegalArgumentException("Subsumed probes must contain triggered probe.");
        }

        triggerProbe.addObserver(this);
    }

    @Override
    public void newProbeMeasurementAvailable(ProbeMeasurement triggerMeasurement) {
        RequestContext measurementContext = triggerMeasurement.getProbeAndContext().getRequestContext();

        final List<MeasuringValue> childMeasurements = new LinkedList<MeasuringValue>();

        for (final TriggeredProbe childProbe : subsumedProbes) {
            if (childProbe.equals(triggerProbe)) {
                childMeasurements.add((MeasuringValue) triggerMeasurement.getMeasureProvider());
                continue;
            }

            final IMeasureProvider subsumedMeasureProvider = childProbe.takeMeasurement(measurementContext)
                    .getMeasureProvider();

            if (!(subsumedMeasureProvider instanceof MeasuringValue)) {
                throw new IllegalArgumentException("Subsumed measure providers have to be measurements");
            }

            // TODO Actually, we should recursively resolve subsumed measurements here because the
            // subsumed measurement could be a TupleMeasurement. [Lehrig]
            childMeasurements.add((MeasuringValue) subsumedMeasureProvider);
        }

        final IMeasureProvider measureProvider = new MeasurementListMeasureProvider(childMeasurements);
        ProbeMeasurement newMeasurement = new ProbeMeasurement(measureProvider, this, measurementContext);

        notifyMeasurementSourceListener(newMeasurement);
    }
}
