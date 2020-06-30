package org.palladiosimulator.indirections.monitoring.simulizar;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.probeframework.measurement.RequestContext;
import org.palladiosimulator.probeframework.probes.BasicTriggeredProbe;

public class TriggeredProxyProbe<V, Q extends Quantity> extends BasicTriggeredProbe<V, Q> {
    Measure<V, Q> currentMeasure = null;

    public TriggeredProxyProbe(final BaseMetricDescription metricDescription) {
        super(metricDescription);
    }

    public void doMeasure(final Measure<V, Q> newCurrentMeasure) {
        this.currentMeasure = newCurrentMeasure;
        this.notifyMeasurementSourceListener(this.doMeasure(RequestContext.EMPTY_REQUEST_CONTEXT));
    }

    @Override
    protected Measure<V, Q> getBasicMeasure(final RequestContext measurementContext) {
        return this.currentMeasure;
    }

    public void setCurrentMeasure(final Measure<V, Q> currentMeasure) {
        this.currentMeasure = currentMeasure;
    }

}