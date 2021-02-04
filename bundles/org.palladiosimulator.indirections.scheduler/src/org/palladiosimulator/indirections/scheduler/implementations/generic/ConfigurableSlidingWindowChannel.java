package org.palladiosimulator.indirections.scheduler.implementations.generic;

import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.getBooleanParameter;
import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.getDoubleParameter;

import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitch;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class ConfigurableSlidingWindowChannel extends SlidingWindowChannel {
    public static final String WINDOW_SIZE_PARAMETER_NAME = "windowSize";
    public static final String WINDOW_SHIFT_PARAMETER_NAME = "windowShift";
    public static final String GRACE_PERIOD_PARAMETER_NAME = "gracePeriod";
    public static final String SCHEDULED_ADVANCE_PARAMETER_NAME = "scheduledAdvance";
    public static final String ADVANCE_ON_DATA_PARAMETER_NAME = "advanceOnData";
    public static final String EMIT_EMPTY_WINDOWS_PARAMETER_NAME = "emitEmptyWindows";

    public ConfigurableSlidingWindowChannel(JavaClassDataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext context, SchedulerModel model,
            RepositoryComponentSwitch.Factory repositoryComponentSwitchFactory, InterpreterDefaultContext mainContext) {
        super(dataChannel, assemblyContext, context, model, repositoryComponentSwitchFactory, mainContext,
                getDoubleParameter(dataChannel, WINDOW_SIZE_PARAMETER_NAME),
                getDoubleParameter(dataChannel, WINDOW_SHIFT_PARAMETER_NAME),
                getDoubleParameter(dataChannel, GRACE_PERIOD_PARAMETER_NAME),
                getBooleanParameter(dataChannel, SCHEDULED_ADVANCE_PARAMETER_NAME),
                getBooleanParameter(dataChannel, ADVANCE_ON_DATA_PARAMETER_NAME),
                getBooleanParameter(dataChannel, EMIT_EMPTY_WINDOWS_PARAMETER_NAME));
    }

    @Override
    protected boolean isPushingRole(DataSourceRole role) {
        return true;
    }
}
