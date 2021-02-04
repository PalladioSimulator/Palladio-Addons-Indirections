package org.palladiosimulator.indirections.scheduler.implementations;

import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.indirections.scheduler.implementations.generic.ConfigurableSlidingWindowChannel;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitchFactory;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class D1_ReadingWindowing extends ConfigurableSlidingWindowChannel {

    public D1_ReadingWindowing(JavaClassDataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext context, SchedulerModel model,
            RepositoryComponentSwitchFactory repositoryComponentSwitchFactory) {
        super(dataChannel, assemblyContext, context, model, repositoryComponentSwitchFactory);
    }

}
