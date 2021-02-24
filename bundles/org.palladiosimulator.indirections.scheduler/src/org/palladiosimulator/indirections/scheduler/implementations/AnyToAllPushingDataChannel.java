package org.palladiosimulator.indirections.scheduler.implementations;

import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.indirections.scheduler.implementations.generic.AbstractAnyToAllChannel;
import org.palladiosimulator.indirections.scheduler.util.DataChannelResourceRegistry;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.di.component.interfaces.SimulatedThreadComponent;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class AnyToAllPushingDataChannel extends AbstractAnyToAllChannel {
    public AnyToAllPushingDataChannel(JavaClassDataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext mainContext, SchedulerModel model,
            SimulatedThreadComponent.Factory simulatedThreadComponentFactory,
            DataChannelResourceRegistry dataChannelResourceRegistry) {
        super(dataChannel, assemblyContext, mainContext, model, simulatedThreadComponentFactory,
                dataChannelResourceRegistry);
    }

    @Override
    protected boolean isPushingRole(DataSourceRole role) {
        return true;
    }
}
