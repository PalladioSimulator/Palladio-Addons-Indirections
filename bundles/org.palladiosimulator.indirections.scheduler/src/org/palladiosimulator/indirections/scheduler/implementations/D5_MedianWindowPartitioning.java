package org.palladiosimulator.indirections.scheduler.implementations;

import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.indirections.scheduler.util.DataChannelResourceRegistry;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.di.component.interfaces.SimulatedThreadComponent;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class D5_MedianWindowPartitioning extends D2_WindowedReadingRepartitioning {
    public D5_MedianWindowPartitioning(JavaClassDataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext mainContext, SchedulerModel model,
            SimulatedThreadComponent.Factory simulatedThreadComponentFactory, DataChannelResourceRegistry dataChannelResourceRegistry) {
        super(dataChannel, assemblyContext, mainContext, model, simulatedThreadComponentFactory, dataChannelResourceRegistry);
    }
}
