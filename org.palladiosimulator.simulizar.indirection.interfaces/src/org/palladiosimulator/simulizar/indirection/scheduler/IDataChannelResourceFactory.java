package org.palladiosimulator.simulizar.indirection.scheduler;

import org.palladiosimulator.simulizar.indirection.system.DataChannel;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public interface IDataChannelResourceFactory {
	public IDataChannelResource createDataChannelResource(DataChannel dataChannel, final SchedulerModel model) ;
}
