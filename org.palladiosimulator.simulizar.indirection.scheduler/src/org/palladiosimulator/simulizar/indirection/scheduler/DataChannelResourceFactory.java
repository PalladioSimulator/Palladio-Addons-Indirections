package org.palladiosimulator.simulizar.indirection.scheduler;

import org.palladiosimulator.simulizar.indirection.system.DataChannel;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class DataChannelResourceFactory implements IDataChannelResourceFactory {

	@Override
	public IDataChannelResource createDataChannelResource(DataChannel dataChannel, SchedulerModel model) {
		return new SimNoRDDataChannelResource(dataChannel, model);
	}

}
