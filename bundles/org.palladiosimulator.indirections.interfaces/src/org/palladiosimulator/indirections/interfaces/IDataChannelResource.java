package org.palladiosimulator.indirections.interfaces;

import java.util.Map;
import java.util.function.Consumer;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

public interface IDataChannelResource {
	    public abstract boolean put(ISchedulableProcess process, Map<String, Object> frame);
	    public abstract boolean get(ISchedulableProcess process, Consumer<Map<String, Object>> callback);

	    /**
	     * Getter for the model element of the assembly context.
	     * 
	     * @return The assembly context of the passive resource.
	     */
	    public AssemblyContext getAssemblyContext();

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

	    /**
	     * Returns the maximal number of instances that can be acquired at the same time.
	     */
	    public long getCapacity();

	    /**
	     * Returns the number of remaining instances.
	     */
	    public long getAvailable();
}
