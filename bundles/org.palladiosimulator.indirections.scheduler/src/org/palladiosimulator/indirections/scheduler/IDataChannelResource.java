package org.palladiosimulator.indirections.scheduler;

import java.util.function.Consumer;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

/**
 * Implementations have to have a constructor that accepts a SimulationControl
 */
public interface IDataChannelResource {
    void advance(double simulationTime);

    boolean get(ISchedulableProcess process, DataSourceRole sourceRole, Consumer<IndirectionDate> callback);

    /**
     * Unique identifier of the resource.
     * 
     * @return
     */
    String getId();

    /**
     * Name of the resource.
     * 
     * @return
     */
    String getName();

    boolean put(ISchedulableProcess process, DataSinkRole sinkRole, IndirectionDate date);
}
