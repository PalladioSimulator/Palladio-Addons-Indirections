package org.palladiosimulator.indirections.scheduler.util;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.core.model.SimuComModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;

public class OneShotSimulationEvent extends AbstractSimEventDelegator<OneShotSimulationEntity> {

    private static final Logger LOGGER = Logger.getLogger(OneShotSimulationEvent.class);

    public OneShotSimulationEvent(final SimuComModel model) {
        super(model, "PeriodicSimulationEvent");
    }

    @Override
    public void eventRoutine(OneShotSimulationEntity who) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Periodic event " + this.getName() + " occurred at simulation time "
                    + this.getModel().getSimulationControl().getCurrentSimulationTime());
        }
        if (this.getModel().getSimulationControl().isRunning()) {
            who.trigger();
        }
    }
}
