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

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class TriggerableCalculator<V, Q extends Quantity> {
    protected final TriggeredProxyProbe<V, Q> proxyProbe;
    protected final TriggeredCombiningProbe<V, Q> probeList;
    protected final IndirectionMeasuringPointRegistry registry;
    protected final SimuComModel model;

    public TriggerableCalculator(String name, BaseMetricDescription baseMetric, MetricSetDescription metricSet,
            InterpreterDefaultContext context) {

        this.model = context.getModel();
        registry = IndirectionMeasuringPointRegistry.getInstanceFor(context);

        StringMeasuringPoint measuringPoint = MeasuringUtil
                .createStringMeasuringPoint(IndirectionMeasuringPointRegistry.MEASURING_POINT_REPOSITORY, name);

        proxyProbe = new TriggeredProxyProbe<V, Q>(baseMetric);
        probeList = new TriggeredCombiningProbe<V, Q>(metricSet, List.of(registry.timeProbe, proxyProbe), proxyProbe);

        ICalculatorFactory calculatorFactory = model.getProbeFrameworkContext().getCalculatorFactory();
        calculatorFactory.buildExecutionResultCalculator(measuringPoint, probeList);
    }

    public void doMeasure(Measure<V, Q> measure) {
        proxyProbe.doMeasure(measure);
    }
}