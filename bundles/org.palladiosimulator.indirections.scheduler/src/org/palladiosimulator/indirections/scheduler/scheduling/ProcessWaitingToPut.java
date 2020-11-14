package org.palladiosimulator.indirections.scheduler.scheduling;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class ProcessWaitingToPut extends SuspendableSchedulerEntity {
    public final DataSinkRole role;
    public final IndirectionDate date;

    public ProcessWaitingToPut(final SchedulerModel model, final ISchedulableProcess schedulableProcess,
            final DataSinkRole role, final IndirectionDate date) {
        super(model, schedulableProcess, ProcessWaitingToPut.class.getName());

        this.date = date;
        this.role = role;
    }
}