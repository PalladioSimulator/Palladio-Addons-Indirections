package org.palladiosimulator.indirections.interfaces;

import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitch;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public interface IDataChannelResourceFactory {
    public IDataChannelResource createDataChannelResource(DataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext context, SchedulerModel model,
            RepositoryComponentSwitch.Factory repositoryComponentSwitchFactory);
}
