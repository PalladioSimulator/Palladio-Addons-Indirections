package org.palladiosimulator.indirections.monitoring.simulizar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import jakarta.measure.Measure;
import jakarta.measure.quantity.Quantity;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.edp2.util.MetricDescriptionUtility;
import org.palladiosimulator.indirections.util.StreamUtil;
import org.palladiosimulator.measurementframework.measureprovider.IMeasureProvider;
import org.palladiosimulator.metricspec.CaptureType;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.metricspec.NumericalBaseMetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.metricspec.metricentity.IMetricEntity;
import org.palladiosimulator.metricspec.util.builder.MetricSetDescriptionBuilder;
import org.palladiosimulator.metricspec.util.builder.MetricspecBuilders;
import org.palladiosimulator.probeframework.measurement.ProbeMeasurement;
import org.palladiosimulator.probeframework.probes.BasicEventProbe;
import org.palladiosimulator.probeframework.probes.EventProbeList;
import org.palladiosimulator.probeframework.probes.Probe;
import org.palladiosimulator.probeframework.probes.listener.IProbeListener;

import de.uka.ipd.sdq.simucomframework.resources.CalculatorHelper;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;

// TODO: clean up
public final class MetricDescriptionUtil {
    private static Map<NumericalBaseMetricDescription, MetricSetDescription> eventNumericalBaseMetricToMetricSet = new HashMap<>();
    private static Map<NumericalBaseMetricDescription, NumericalBaseMetricDescription> metricToAveragingMetric = new HashMap<>();
    private static Map<NumericalBaseMetricDescription, NumericalBaseMetricDescription> metricToSummingMetric = new HashMap<>();
    private static Map<NumericalBaseMetricDescription, MetricSetDescription> triggeredNumericalBaseMetricToMetricSet = new HashMap<>();

    public static Consumer<Consumer<IMeasureProvider>> attachToProbe(final Probe probe) {
        final Consumer<Consumer<IMeasureProvider>> register = it -> probe.addObserver(new IProbeListener() {
            @Override
            public void newProbeMeasurementAvailable(final ProbeMeasurement probeMeasurement) {
                it.accept(probeMeasurement.getMeasureProvider());
            }
        });
        return register;
    }

    private static NumericalBaseMetricDescription createAveragingMetric(
            final NumericalBaseMetricDescription baseMetric) {
        return MetricspecBuilders.newNumericalBaseMetricDescriptionBuilder(baseMetric)
            .id(EcoreUtil.generateUUID())
            .captureType(CaptureType.REAL_NUMBER)
            .name(baseMetric.getName() + " Average")
            .build();
    }

    private static MetricSetDescription createEventBaseMetricDescriptionWithTime(
            final NumericalBaseMetricDescription baseMetricDescription) {
        return MetricSetDescriptionBuilder.newMetricSetDescriptionBuilder()
            .name(baseMetricDescription.getName() + " over Time")
            .textualDescription(baseMetricDescription.getName() + " over Time")
            .id(EcoreUtil.generateUUID())
            .subsumedMetrics(Arrays.asList(baseMetricDescription, MetricDescriptionConstants.POINT_IN_TIME_METRIC))
            .build();
    }

    private static NumericalBaseMetricDescription createSummingMetric(final NumericalBaseMetricDescription baseMetric) {
        return MetricspecBuilders.newNumericalBaseMetricDescriptionBuilder(baseMetric)
            .id(EcoreUtil.generateUUID())
            .name(baseMetric.getName() + " Sum")
            .build();
    }

    private static MetricSetDescription createTriggeredBaseMetricDescriptionWithTime(
            final NumericalBaseMetricDescription baseMetricDescription) {
        return MetricSetDescriptionBuilder.newMetricSetDescriptionBuilder()
            .name(baseMetricDescription.getName() + " over Time")
            .textualDescription(baseMetricDescription.getName() + " over Time")
            .id(EcoreUtil.generateUUID())
            .subsumedMetrics(Arrays.asList(MetricDescriptionConstants.POINT_IN_TIME_METRIC, baseMetricDescription))
            .build();
    }

    public static <EventSourceType, V, Q extends Quantity> EventProbeList deriveAverageProbe(
            final NumericalBaseMetricDescription metricDesciption, final ISimulationControl simulationControl,
            final Consumer<Consumer<IMeasureProvider>> register) {
        final NumericalBaseMetricDescription averagingMetric = MetricDescriptionUtil
            .getOrCreateAveragingMetric(metricDesciption);
        final MetricSetDescription averagingMetricOverTime = MetricDescriptionUtil
            .getOrCreateEventBaseMetricDescriptionWithTime(averagingMetric);

        final EventProbeList result = CalculatorHelper.getEventProbeSetWithCurrentTime(averagingMetricOverTime,
                simulationControl, new BasicEventProbe<IMetricEntity, Double, Q>(null, averagingMetric) {
                    @SuppressWarnings("unchecked")
                    public void notify_(final double value) {
                        this.notify((Measure<Double, Q>) Measure.valueOf(value, averagingMetric.getDefaultUnit()));
                    }

                    @Override
                    protected void registerListener() {
                        register.accept((newMeasurement) -> {
                            final Measure<Object, Quantity> measure = newMeasurement
                                .getMeasureForMetric(metricDesciption);
                            final double currentTime = simulationControl.getCurrentSimulationTime();
                            if (currentTime >= 1.d) {
                                this.notify_(measure.doubleValue(averagingMetric.getDefaultUnit()) / currentTime);
                            }
                        });
                    }
                });

        return result;
    }

    public static <EventSourceType, V, Q extends Quantity> EventProbeList deriveSummingProbe(
            final NumericalBaseMetricDescription baseMetricDescription, final ISimulationControl simulationControl,
            final Consumer<Consumer<IMeasureProvider>> register) {
        final NumericalBaseMetricDescription summingMetric = MetricDescriptionUtil
            .getOrCreateSummingMetric(baseMetricDescription);
        final MetricSetDescription summingMetricOverTime = MetricDescriptionUtil
            .getOrCreateEventBaseMetricDescriptionWithTime(summingMetric);

        final EventProbeList result = CalculatorHelper.getEventProbeSetWithCurrentTime(summingMetricOverTime,
                simulationControl, new BasicEventProbe<IMetricEntity, Double, Q>(null, summingMetric) {
                    private double sum = 0.d;

                    @SuppressWarnings("unchecked")
                    public void notify_(final double value) {
                        this.notify((Measure<Double, Q>) Measure.valueOf(value, summingMetric.getDefaultUnit()));
                    }

                    @Override
                    protected void registerListener() {
                        register.accept((newMeasurement) -> {
                            final Measure<Object, Quantity> measure = newMeasurement
                                .getMeasureForMetric(baseMetricDescription);
                            this.sum += measure.doubleValue(summingMetric.getDefaultUnit());
                            this.notify_(this.sum);
                        });
                    }
                });

        return result;
    }

    public static NumericalBaseMetricDescription getNonPointInTimeNumericalBaseMetric(
            final MetricDescription metricDesciption) {
        return (NumericalBaseMetricDescription) Arrays
            .stream(MetricDescriptionUtility.toBaseMetricDescriptions(metricDesciption))
            .filter(it -> it != MetricDescriptionConstants.POINT_IN_TIME_METRIC)
            .reduce(StreamUtil.reduceToMaximumOne())
            .get();
    }

    public static NumericalBaseMetricDescription getOrCreateAveragingMetric(
            final NumericalBaseMetricDescription baseMetric) {
        return metricToAveragingMetric.computeIfAbsent(baseMetric, MetricDescriptionUtil::createAveragingMetric);
    }

    public static MetricSetDescription getOrCreateEventBaseMetricDescriptionWithTime(
            final NumericalBaseMetricDescription baseMetricDescription) {
        return eventNumericalBaseMetricToMetricSet.computeIfAbsent(baseMetricDescription,
                MetricDescriptionUtil::createEventBaseMetricDescriptionWithTime);
    }

    public static NumericalBaseMetricDescription getOrCreateSummingMetric(
            final NumericalBaseMetricDescription baseMetric) {
        return metricToSummingMetric.computeIfAbsent(baseMetric, MetricDescriptionUtil::createSummingMetric);
    }

    public static MetricSetDescription getOrCreateTriggeredBaseMetricDescriptionWithTime(
            final NumericalBaseMetricDescription baseMetricDescription) {
        return triggeredNumericalBaseMetricToMetricSet.computeIfAbsent(baseMetricDescription,
                MetricDescriptionUtil::createTriggeredBaseMetricDescriptionWithTime);
    }

    public static <V, Q extends Quantity> void observeProbeRawTo(final Probe probe,
            final Consumer<Measure<V, Q>> consumer) {
        final NumericalBaseMetricDescription baseMetricDescription = (NumericalBaseMetricDescription) MetricDescriptionUtility
            .toBaseMetricDescriptions(probe.getMetricDesciption())[1];

        probe.addObserver((probeMeasurement) -> {
            final Measure<V, Q> measure = probeMeasurement.getMeasureProvider()
                .getMeasureForMetric(baseMetricDescription);
            consumer.accept(measure);
        });
    }

    public static void reset() {
        metricToAveragingMetric = new HashMap<>();
        metricToSummingMetric = new HashMap<>();
        triggeredNumericalBaseMetricToMetricSet = new HashMap<>();
        eventNumericalBaseMetricToMetricSet = new HashMap<>();
    }
}