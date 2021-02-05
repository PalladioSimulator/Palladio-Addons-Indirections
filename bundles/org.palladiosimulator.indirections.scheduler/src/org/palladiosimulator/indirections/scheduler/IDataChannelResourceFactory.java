package org.palladiosimulator.indirections.scheduler;

import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.indirections.scheduler.util.DataChannelResourceRegistry;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.di.component.interfaces.SimulatedThreadComponent;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitch;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public interface IDataChannelResourceFactory {
    public IDataChannelResource createDataChannelResource(DataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext context, SchedulerModel model,
            SimulatedThreadComponent.Factory simulatedThreadComponentFactory,
            DataChannelResourceRegistry dataChannelResourceRegistry);
}
