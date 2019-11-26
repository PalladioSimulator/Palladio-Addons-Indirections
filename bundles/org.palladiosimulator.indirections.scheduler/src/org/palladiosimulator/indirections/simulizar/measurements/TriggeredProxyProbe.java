package org.palladiosimulator.indirections.simulizar.measurements;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.probeframework.measurement.RequestContext;
import org.palladiosimulator.probeframework.probes.BasicTriggeredProbe;

public class TriggeredProxyProbe<V, Q extends Quantity> extends BasicTriggeredProbe<V, Q> {
    Measure<V, Q> currentMeasure = null;

    protected TriggeredProxyProbe(BaseMetricDescription metricDescription) {
        super(metricDescription);
    }

    @Override
    protected Measure<V, Q> getBasicMeasure(RequestContext measurementContext) {
        return currentMeasure;
    }

    public void setCurrentMeasure(Measure<V, Q> currentMeasure) {
        this.currentMeasure = currentMeasure;
    }

    public void doMeasure(Measure<V, Q> newCurrentMeasure) {
        this.currentMeasure = newCurrentMeasure;
        notifyMeasurementSourceListener(doMeasure(RequestContext.EMPTY_REQUEST_CONTEXT));
    }

}