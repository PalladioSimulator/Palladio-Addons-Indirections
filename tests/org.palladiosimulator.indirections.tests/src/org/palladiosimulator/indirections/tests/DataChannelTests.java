package org.palladiosimulator.indirections.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.measure.unit.SI;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.palladiosimulator.simulizar.test.commons.annotation.LoadPCMInstanceFromBundle;
import org.palladiosimulator.simulizar.test.commons.util.MeasurementTestUtils;

import tools.mdsd.junit5utils.annotations.PluginTestOnly;

@PluginTestOnly
public class DataChannelTests {
    @BeforeAll
    static void beforeAll() {
        //var c = IFileEditorInput.class;
        //System.out.println(c);
    }
    
/*    @Test
    @LoadPCMInstanceFromBundle(bundleName = "org.palladiosimulator.indirections.minimumindirectionexample", basePath = "000_minimum-channel", modelFiles = {
            "000_minimum-channel.allocation", "000_minimum-channel.measuringpoint",
            "000_minimum-channel.monitorrepository", "000_minimum-channel.repository",
            "000_minimum-channel.resourceenvironment", "000_minimum-channel.slo", "000_minimum-channel.system",
            "000_minimum-channel.usagemodel" })
    @RunSimuLizarWithIndirections
    void testDataPassesThroughSimpleDataChannel(ExperimentRun expRun, ResourceEnvironment resourceEnvironment) {
        var delayResource = resourceEnvironment.getResourceContainer_ResourceEnvironment()
            .stream()
            .flatMap(it -> it.getActiveResourceSpecifications_ResourceContainer()
                .stream())
            .filter(it -> it.getActiveResourceType_ActiveResourceSpecification()
                .getEntityName()
                .equals("DELAY"))
            .findAny()
            .get();

        var measurement = MeasurementTestUtils.getMeasurementOfAt(expRun.getMeasurement(),
                MetricDescriptionConstants.RESOURCE_DEMAND_METRIC_TUPLE, delayResource);

        assertTrue(measurement.isPresent());

        // must be equal to 42 because:
        // * it is given in the first component, packaged into a date.
        // * it is then sent via the channel.
        // * the second component takes the value and creates a resource demand from the value.
        MeasurementTestUtils.allDoubleMeasurementValuesMatch(measurement.get(),
                MetricDescriptionConstants.RESOURCE_DEMAND_METRIC, SI.SECOND, equalTo(42.0));
    }*/

}
