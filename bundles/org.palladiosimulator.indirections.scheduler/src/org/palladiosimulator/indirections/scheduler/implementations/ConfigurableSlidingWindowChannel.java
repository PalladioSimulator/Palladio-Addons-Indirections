package org.palladiosimulator.indirections.scheduler.implementations;

import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.getBooleanParameter;
import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.getDoubleParameter;

import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class ConfigurableSlidingWindowChannel extends SlidingWindowChannel {
    public static final String WINDOW_SIZE_PARAMETER_NAME = "windowSize";
    public static final String WINDOW_SHIFT_PARAMETER_NAME = "windowShift";
    public static final String GRACE_PERIOD_PARAMETER_NAME = "gracePeriod";
    public static final String EMIT_EMPTY_WINDOWS_PARAMETER_NAME = "emitEmptyWindows";

    public ConfigurableSlidingWindowChannel(JavaClassDataChannel dataChannel, InterpreterDefaultContext context,
            SchedulerModel model) {
        super(dataChannel, context, model, getDoubleParameter(dataChannel, WINDOW_SIZE_PARAMETER_NAME),
                getDoubleParameter(dataChannel, WINDOW_SHIFT_PARAMETER_NAME),
                getDoubleParameter(dataChannel, GRACE_PERIOD_PARAMETER_NAME),
                getBooleanParameter(dataChannel, EMIT_EMPTY_WINDOWS_PARAMETER_NAME));
    }

}
