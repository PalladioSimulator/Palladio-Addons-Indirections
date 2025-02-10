package org.palladiosimulator.indirections.monitoring.simulizar;

import jakarta.measure.quantity.Dimensionless;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPointRepository;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint;
import org.palladiosimulator.metricspec.CaptureType;
import org.palladiosimulator.metricspec.Scale;
import org.palladiosimulator.metricspec.util.builder.NumericalBaseMetricDescriptionBuilder;

public final class MeasuringUtil {
    public static NumericalBaseMetricDescriptionBuilder createBaseMetricDescription(final String name) {
        return createBaseMetricDescription(name, name);
    }

    public static NumericalBaseMetricDescriptionBuilder createBaseMetricDescription(final String name,
            final String textualDescription) {
        return NumericalBaseMetricDescriptionBuilder.newNumericalBaseMetricDescriptionBuilder()
            .id(EcoreUtil.generateUUID())
            .name(name)
            .textualDescription(textualDescription)
            .scale(Scale.RATIO)
            .defaultUnit(Dimensionless.UNIT)
            .captureType(CaptureType.REAL_NUMBER);
    }

    public static StringMeasuringPoint createStringMeasuringPoint(
            final MeasuringPointRepository measuringPointRepository, final String value) {
        final StringMeasuringPoint newStringMeasuringPoint = MeasuringpointFactory.eINSTANCE
            .createStringMeasuringPoint();
        newStringMeasuringPoint.setMeasuringPoint(value);
        measuringPointRepository.getMeasuringPoints()
            .add(newStringMeasuringPoint);
        return newStringMeasuringPoint;
    }

    private MeasuringUtil() {
    }
}
