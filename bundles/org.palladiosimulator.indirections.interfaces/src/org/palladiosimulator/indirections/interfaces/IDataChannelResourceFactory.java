package org.palladiosimulator.indirections.interfaces;

import org.palladiosimulator.indirections.system.DataChannel;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public interface IDataChannelResourceFactory {
	public IDataChannelResource createDataChannelResource(DataChannel dataChannel, final SchedulerModel model) ;
}
