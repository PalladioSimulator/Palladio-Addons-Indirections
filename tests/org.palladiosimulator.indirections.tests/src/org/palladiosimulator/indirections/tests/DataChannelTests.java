package org.palladiosimulator.indirections.tests;

import java.util.List;

import org.junit.Test;

public class DataChannelTests extends SimuLizarRunConfigTestBase {

    @Test
    public void testMinimumDataMeasurements() {
        getSimulizarConfiguration().setUsageModelFile(
                "platform:/plugin/org.palladiosimulator.indirections.minimumindirectionexample/001_minimum/001_minimum.usagemodel");
        getSimulizarConfiguration().setAllocationFiles(List.of(
                "platform:/plugin/org.palladiosimulator.indirections.minimumindirectionexample/001_minimum/001_minimum.allocation"));
        runSuccessfulSimulation();
        System.out.println("Done");
    }

    @Test
    public void testMinimumDataChannel() {
        getSimulizarConfiguration().setUsageModelFile(
                "platform:/plugin/org.palladiosimulator.indirections.minimumindirectionexample/002_minimum_datachannel/002_minimum_datachannel.usagemodel");
        getSimulizarConfiguration().setAllocationFiles(List.of(
                "platform:/plugin/org.palladiosimulator.indirections.minimumindirectionexample/002_minimum_datachannel/002_minimum_datachannel.allocation"));
        runSuccessfulSimulation();
        System.out.println("Done");
    }

    @Test
    public void testWindowing() {
        getSimulizarConfiguration().setUsageModelFile(
                "platform:/plugin/org.palladiosimulator.indirections.minimumindirectionexample/003_datachannel_windowing/003_datachannel_windowing.usagemodel");
        getSimulizarConfiguration().setAllocationFiles(List.of(
                "platform:/plugin/org.palladiosimulator.indirections.minimumindirectionexample/003_datachannel_windowing/003_datachannel_windowing.allocation"));
        runSuccessfulSimulation();
        System.out.println("Done");
    }

}
