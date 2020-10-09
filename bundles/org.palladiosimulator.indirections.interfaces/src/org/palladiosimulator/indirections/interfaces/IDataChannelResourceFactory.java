package org.palladiosimulator.indirections.interfaces;

import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public interface IDataChannelResourceFactory {
    public IDataChannelResource createDataChannelResource(DataChannel dataChannel, InterpreterDefaultContext context,
            final SchedulerModel model);
}
