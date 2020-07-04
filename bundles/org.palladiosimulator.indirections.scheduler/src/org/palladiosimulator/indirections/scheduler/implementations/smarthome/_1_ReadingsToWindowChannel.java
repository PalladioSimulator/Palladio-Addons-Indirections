package org.palladiosimulator.indirections.scheduler.implementations.smarthome;

import org.palladiosimulator.indirections.scheduler.implementations.ConfigurableSlidingWindowChannel;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class _1_ReadingsToWindowChannel extends ConfigurableSlidingWindowChannel {
    public _1_ReadingsToWindowChannel(JavaClassDataChannel dataChannel, InterpreterDefaultContext context,
            SchedulerModel model) {
        super(dataChannel, context, model);

        IndirectionSimulationUtil.requireExactNumberOfSinkSourceRoles(dataChannel, 1, 1);
    }
}
