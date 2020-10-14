package org.palladiosimulator.indirections.scheduler.implementations.smarthome;

import org.palladiosimulator.indirections.scheduler.implementations.AnyToAllPushingDataChannel;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class _3_DistributingDataChannel extends AnyToAllPushingDataChannel {

    public _3_DistributingDataChannel(JavaClassDataChannel dataChannel, InterpreterDefaultContext context,
            SchedulerModel model) {
        super(dataChannel, context, model);
    }

}
