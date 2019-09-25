package org.palladiosimulator.indirections.simulizar.measurements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

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
    private static Map<NumericalBaseMetricDescription, NumericalBaseMetricDescription> metricToAveragingMetric = new HashMap<>();
    private static Map<NumericalBaseMetricDescription, NumericalBaseMetricDescription> metricToSummingMetric = new HashMap<>();
    private static Map<NumericalBaseMetricDescription, MetricSetDescription> triggeredNumericalBaseMetricToMetricSet = new HashMap<>();
    private static Map<NumericalBaseMetricDescription, MetricSetDescription> eventNumericalBaseMetricToMetricSet = new HashMap<>();

    public static void reset() {
        metricToAveragingMetric = new HashMap<>();
        metricToSummingMetric = new HashMap<>();
        triggeredNumericalBaseMetricToMetricSet = new HashMap<>();
        eventNumericalBaseMetricToMetricSet = new HashMap<>();
    }

    public static NumericalBaseMetricDescription getNonPointInTimeNumericalBaseMetric(
            final MetricDescription metricDesciption) {
        return (NumericalBaseMetricDescription) Arrays
                .stream(MetricDescriptionUtility.toBaseMetricDescriptions(metricDesciption))
                .filter(it -> it != MetricDescriptionConstants.POINT_IN_TIME_METRIC)
                .reduce(StreamUtil.reduceToMaximumOne()).get();
    }

    private static NumericalBaseMetricDescription createAveragingMetric(NumericalBaseMetricDescription baseMetric) {
        return MetricspecBuilders.newNumericalBaseMetricDescriptionBuilder(baseMetric).id(EcoreUtil.generateUUID())
                .captureType(CaptureType.REAL_NUMBER).name(baseMetric.getName() + " Average").build();
    }

    public static NumericalBaseMetricDescription getOrCreateAveragingMetric(NumericalBaseMetricDescription baseMetric) {
        return metricToAveragingMetric.computeIfAbsent(baseMetric, MetricDescriptionUtil::createAveragingMetric);
    }

    private static NumericalBaseMetricDescription createSummingMetric(NumericalBaseMetricDescription baseMetric) {
        return MetricspecBuilders.newNumericalBaseMetricDescriptionBuilder(baseMetric).id(EcoreUtil.generateUUID())
                .name(baseMetric.getName() + " Sum").build();
    }

    public static NumericalBaseMetricDescription getOrCreateSummingMetric(NumericalBaseMetricDescription baseMetric) {
        return metricToSummingMetric.computeIfAbsent(baseMetric, MetricDescriptionUtil::createSummingMetric);
    }

    private static MetricSetDescription createTriggeredBaseMetricDescriptionWithTime(
            NumericalBaseMetricDescription baseMetricDescription) {
        return MetricSetDescriptionBuilder.newMetricSetDescriptionBuilder()
                .name(baseMetricDescription.getName() + " over Time")
                .textualDescription(baseMetricDescription.getName() + " over Time").id(EcoreUtil.generateUUID())
                .subsumedMetrics(Arrays.asList(MetricDescriptionConstants.POINT_IN_TIME_METRIC, baseMetricDescription))
                .build();
    }

    public static MetricSetDescription getOrCreateTriggeredBaseMetricDescriptionWithTime(
            NumericalBaseMetricDescription baseMetricDescription) {
        return triggeredNumericalBaseMetricToMetricSet.computeIfAbsent(baseMetricDescription,
                MetricDescriptionUtil::createTriggeredBaseMetricDescriptionWithTime);
    }

    private static MetricSetDescription createEventBaseMetricDescriptionWithTime(
            NumericalBaseMetricDescription baseMetricDescription) {
        return MetricSetDescriptionBuilder.newMetricSetDescriptionBuilder()
                .name(baseMetricDescription.getName() + " over Time")
                .textualDescription(baseMetricDescription.getName() + " over Time").id(EcoreUtil.generateUUID())
                .subsumedMetrics(Arrays.asList(baseMetricDescription, MetricDescriptionConstants.POINT_IN_TIME_METRIC))
                .build();
    }

    public static MetricSetDescription getOrCreateEventBaseMetricDescriptionWithTime(
            NumericalBaseMetricDescription baseMetricDescription) {
        return eventNumericalBaseMetricToMetricSet.computeIfAbsent(baseMetricDescription,
                MetricDescriptionUtil::createEventBaseMetricDescriptionWithTime);
    }

    public static <EventSourceType, V, Q extends Quantity> EventProbeList deriveSummingProbe(
            NumericalBaseMetricDescription baseMetricDescription, ISimulationControl simulationControl,
            Consumer<Consumer<IMeasureProvider>> register) {
        final NumericalBaseMetricDescription summingMetric = MetricDescriptionUtil
                .getOrCreateSummingMetric(baseMetricDescription);
        final MetricSetDescription summingMetricOverTime = MetricDescriptionUtil
                .getOrCreateEventBaseMetricDescriptionWithTime(summingMetric);

        EventProbeList result = CalculatorHelper.getEventProbeSetWithCurrentTime(summingMetricOverTime,
                simulationControl, new BasicEventProbe<IMetricEntity, Double, Q>(null, summingMetric) {
                    private double sum = 0.d;

                    @SuppressWarnings("unchecked")
                    public void notify_(double value) {
                        notify((Measure<Double, Q>) Measure.valueOf(value, summingMetric.getDefaultUnit()));
                    }

                    @Override
                    protected void registerListener() {
                        register.accept((newMeasurement) -> {
                            final Measure<Object, Quantity> measure = newMeasurement
                                    .getMeasureForMetric(baseMetricDescription);
                            sum += measure.doubleValue(summingMetric.getDefaultUnit());
                            notify_(sum);
                        });
                    }
                });

        return result;
    }

    public static Consumer<Consumer<IMeasureProvider>> attachToProbe(final Probe probe) {
        final Consumer<Consumer<IMeasureProvider>> register = it -> probe.addObserver(new IProbeListener() {
            @Override
            public void newProbeMeasurementAvailable(ProbeMeasurement probeMeasurement) {
                it.accept(probeMeasurement.getMeasureProvider());
            }
        });
        return register;
    }

    public static <EventSourceType, V, Q extends Quantity> EventProbeList deriveAverageProbe(
            NumericalBaseMetricDescription metricDesciption, ISimulationControl simulationControl,
            Consumer<Consumer<IMeasureProvider>> register) {
        final NumericalBaseMetricDescription averagingMetric = MetricDescriptionUtil
                .getOrCreateAveragingMetric(metricDesciption);
        final MetricSetDescription averagingMetricOverTime = MetricDescriptionUtil
                .getOrCreateEventBaseMetricDescriptionWithTime(averagingMetric);

        EventProbeList result = CalculatorHelper.getEventProbeSetWithCurrentTime(averagingMetricOverTime,
                simulationControl, new BasicEventProbe<IMetricEntity, Double, Q>(null, averagingMetric) {
                    @SuppressWarnings("unchecked")
                    public void notify_(double value) {
                        notify((Measure<Double, Q>) Measure.valueOf(value, averagingMetric.getDefaultUnit()));
                    }

                    @Override
                    protected void registerListener() {
                        register.accept((newMeasurement) -> {
                            final Measure<Object, Quantity> measure = newMeasurement
                                    .getMeasureForMetric(metricDesciption);
                            double currentTime = simulationControl.getCurrentSimulationTime();
                            if (currentTime >= 1.d) {
                                notify_(measure.doubleValue(averagingMetric.getDefaultUnit()) / currentTime);
                            }
                        });
                    }
                });

        return result;
    }

    public static <V, Q extends Quantity> void observeProbeRawTo(Probe probe, Consumer<Measure<V, Q>> consumer) {
        NumericalBaseMetricDescription baseMetricDescription = (NumericalBaseMetricDescription) MetricDescriptionUtility
                .toBaseMetricDescriptions(probe.getMetricDesciption())[1];

        probe.addObserver((probeMeasurement) -> {
            Measure<V, Q> measure = probeMeasurement.getMeasureProvider().getMeasureForMetric(baseMetricDescription);
            consumer.accept(measure);
        });
    }
}