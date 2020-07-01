package org.palladiosimulator.indirections.scheduler.implementations;

import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class AnyToAnyBlockingChannel extends AnyToAnyChannel {
    public AnyToAnyBlockingChannel(JavaClassDataChannel dataChannel, InterpreterDefaultContext context,
            SchedulerModel model) {
        super(dataChannel, context, model);
    }

    @Override
    protected void handleCannotProceedToGet(final ProcessWaitingToGet process) {
        this.blockUntilCanGet(process);
    }
}
