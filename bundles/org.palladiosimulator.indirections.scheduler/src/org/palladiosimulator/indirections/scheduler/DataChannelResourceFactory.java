package org.palladiosimulator.indirections.scheduler;

import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IDataChannelResourceFactory;
import org.palladiosimulator.indirections.system.DataChannel;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class DataChannelResourceFactory implements IDataChannelResourceFactory {

    @Override
    public IDataChannelResource createDataChannelResource(final DataChannel dataChannel, final SchedulerModel model) {
        return new SimDataChannelResource(dataChannel, model);
    }

}
