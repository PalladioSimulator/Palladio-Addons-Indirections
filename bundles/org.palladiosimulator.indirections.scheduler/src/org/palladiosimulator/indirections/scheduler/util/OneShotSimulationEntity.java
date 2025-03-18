package org.palladiosimulator.indirections.scheduler.util;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.core.entities.SimuComEntity;
import de.uka.ipd.sdq.simucomframework.core.model.SimuComModel;

public class OneShotSimulationEntity extends SimuComEntity {

    private OneShotSimulationEvent myTriggerEvent;
    private static final Logger LOGGER = Logger.getLogger(OneShotSimulationEntity.class);

    public OneShotSimulationEntity(final SimuComModel model, final double firstOccurrence) {
        super(model, "PeriodicallyTriggeredSimulationEntity");
        this.myTriggerEvent = new OneShotSimulationEvent(model);
        this.myTriggerEvent.schedule(this, firstOccurrence);
    }

    public final void trigger() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Periodic trigger for entity " + this.getName() + " occurred at simulation time "
                    + this.getModel().getSimulationControl().getCurrentSimulationTime());
        }
        this.triggerInternal();
    }

    public double getSimulationTimeOfNextEventTrigger() {
        return this.myTriggerEvent.scheduledAtTime();
    }

    public void setDelayAndReinitialize(final double nextOccurrence, final double delay) {
        this.removeEvent();
        this.myTriggerEvent = new OneShotSimulationEvent(this.getModel());
        this.myTriggerEvent.schedule(this, nextOccurrence);
    }

    public void stopScheduling() {
        this.removeEvent();
    }

    protected void triggerInternal() {
    }

    protected void removeEvent() {
        this.myTriggerEvent.removeEvent();
    }

}
