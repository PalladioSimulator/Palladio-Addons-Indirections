package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.system.DataChannel;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

// Currently: mock interface (all public methods)
public class SimDataChannelResource extends AbstractDistributingSimDataChannelResource {
    public SimDataChannelResource(DataChannel dataChannel, SchedulerModel model) {
        super(dataChannel, model);
    }

    public abstract class SimStatefulOperator implements Consumer<IndirectionDate> {
        private final List<Consumer<IndirectionDate>> emitsTo;

        public SimStatefulOperator(List<Consumer<IndirectionDate>> emitsTo) {
            this.emitsTo = new ArrayList<>(emitsTo);
        }
    }

    @Override
    protected boolean canAcceptDataFrom(ProcessWaitingToEmit process) {
        return false;
    }

    @Override
    protected boolean canProvideDataFor(ProcessWaitingToConsume process) {
        return false;
    }

    @Override
    protected List<IndirectionDate> provideDataFor(ProcessWaitingToConsume process) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void acceptDataFrom(ProcessWaitingToEmit process) {
        // TODO Auto-generated method stub
        
    }
}
