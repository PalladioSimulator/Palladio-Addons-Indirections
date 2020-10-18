package org.palladiosimulator.indirections.scheduler.implementations.smarthome;

import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.requireExactNumberOfSinkSourceRoles;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.implementations.windowing.ConfigurableSlidingWindowChannel;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

/**
 * This channel collects data points in sliding windows. The data points are not yet separated in
 * any way, not partitioned or grouped.
 * 
 * @author Dominik Werle
 *
 */
public class _1_ReadingsToWindowChannel extends ConfigurableSlidingWindowChannel {
    public _1_ReadingsToWindowChannel(JavaClassDataChannel dataChannel, InterpreterDefaultContext context,
            SchedulerModel model) {
        super(dataChannel, context, model);

        requireExactNumberOfSinkSourceRoles(dataChannel, 1, 1);
    }

    @Override
    protected void acceptData(DataChannelSinkConnector connector, IndirectionDate date) {
        super.acceptData(connector, date);
    }
}
