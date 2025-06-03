package org.palladiosimulator.indirections.calculators.scheduler;

import java.util.List;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint;
import org.palladiosimulator.indirections.monitoring.simulizar.IndirectionMeasuringPointRegistry;
import org.palladiosimulator.indirections.monitoring.simulizar.MeasuringUtil;
import org.palladiosimulator.indirections.monitoring.simulizar.TriggeredCombiningProbe;
import org.palladiosimulator.indirections.monitoring.simulizar.TriggeredProxyProbe;
import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.probeframework.calculator.ICalculatorFactory;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.simucomframework.core.model.SimuComModel;

public class TriggerableCalculator<V, Q extends Quantity> {
    protected final SimuComModel model;
    protected final TriggeredCombiningProbe<V, Q> probeList;
    protected final TriggeredProxyProbe<V, Q> proxyProbe;
    protected final IndirectionMeasuringPointRegistry registry;

    public TriggerableCalculator(final String name, final BaseMetricDescription baseMetric,
            final MetricSetDescription metricSet, final InterpreterDefaultContext mainContext) {

        this.model = mainContext.getModel();
        this.registry = IndirectionMeasuringPointRegistry.getInstanceFor(mainContext);

        final StringMeasuringPoint measuringPoint = MeasuringUtil
            .createStringMeasuringPoint(IndirectionMeasuringPointRegistry.MEASURING_POINT_REPOSITORY, name);

        this.proxyProbe = new TriggeredProxyProbe<V, Q>(baseMetric);
        this.probeList = new TriggeredCombiningProbe<V, Q>(metricSet, List.of(this.registry.timeProbe, this.proxyProbe),
                this.proxyProbe);

        final ICalculatorFactory calculatorFactory = this.model.getProbeFrameworkContext()
            .getCalculatorFactory();
        calculatorFactory.buildExecutionResultCalculator(measuringPoint, this.probeList);
    }

    public void doMeasure(final Measure<V, Q> measure) {
        this.proxyProbe.doMeasure(measure);
    }
}