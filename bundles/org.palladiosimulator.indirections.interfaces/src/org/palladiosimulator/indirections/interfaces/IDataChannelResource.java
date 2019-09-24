package org.palladiosimulator.indirections.interfaces;

import java.util.Map;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

public interface IDataChannelResource {
    public abstract boolean put(ISchedulableProcess process, DataChannelSourceConnector sourceConnector,
            Map<String, Object> frame);

    public abstract boolean get(ISchedulableProcess process, DataChannelSinkConnector sinkConnector,
            Consumer<IndirectionDate> callback);

    /**
     * Name of the resource.
     * 
     * @return
     */
    public String getName();

    /**
     * Unique identifier of the resource.
     * 
     * @return
     */
    public String getId();
}
