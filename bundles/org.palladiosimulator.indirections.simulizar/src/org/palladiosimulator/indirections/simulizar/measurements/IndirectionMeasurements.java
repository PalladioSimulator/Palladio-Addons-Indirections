package org.palladiosimulator.indirections.simulizar.measurements;

import org.apache.log4j.Logger;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPointRepository;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointFactory;
import org.palladiosimulator.simulizar.modelobserver.IModelObserver;
import org.palladiosimulator.simulizar.runtimestate.AbstractSimuLizarRuntimeState;

public final class IndirectionMeasurements implements IModelObserver {
    private static final Logger LOGGER = Logger.getLogger(IndirectionMeasurements.class);

    @Override
    public void initialize(AbstractSimuLizarRuntimeState runtimeState) {
    }

    @Override
    public void unregister() {
        // TODO implement
        LOGGER.warn("Should unregister " + this + ", but not implemented yet.");
    }
}
