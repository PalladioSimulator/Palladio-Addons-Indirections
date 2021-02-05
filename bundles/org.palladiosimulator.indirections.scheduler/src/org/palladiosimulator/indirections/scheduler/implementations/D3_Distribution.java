package org.palladiosimulator.indirections.scheduler.implementations;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.di.component.interfaces.SimulatedThreadComponent;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class D3_Distribution extends AnyToAllPushingDataChannel {

    public D3_Distribution(JavaClassDataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext mainContext, SchedulerModel model,
            SimulatedThreadComponent.Factory simulatedThreadComponentFactory) {
        super(dataChannel, assemblyContext, mainContext, model, simulatedThreadComponentFactory);
    }

    @Override
    protected void acceptData(DataSinkRole role, IndirectionDate date) {
        if (discardDateIfTooOld(date))
            return;

        super.acceptData(role, date);
    }
}
