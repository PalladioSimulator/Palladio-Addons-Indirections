package org.palladiosimulator.indirections.scheduler.scheduling;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.entities.SchedulerEntity;

public class SuspendableSchedulerEntity extends SchedulerEntity {
    public final ISchedulableProcess schedulableProcess;
    private boolean isWaiting;

    protected SuspendableSchedulerEntity(final SchedulerModel model, final ISchedulableProcess schedulableProcess,
            final String name) {
        super(model, name);

        this.schedulableProcess = schedulableProcess;
    }

    public void activate() {
        if (!this.isWaiting) {
            throw new IllegalStateException("process is not waiting");
        }

        this.isWaiting = false;
        this.schedulableProcess.activate();
    }

    public void passivate() {
        if (this.isWaiting) {
            throw new IllegalStateException("process is already waiting");
        }

        this.isWaiting = true;
        this.schedulableProcess.passivate();
    }

    public boolean isWaiting() {
        return this.isWaiting;
    }
}