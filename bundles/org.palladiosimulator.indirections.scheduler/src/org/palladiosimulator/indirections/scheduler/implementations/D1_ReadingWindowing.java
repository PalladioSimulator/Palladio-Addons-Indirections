package org.palladiosimulator.indirections.scheduler.implementations;

import java.util.function.Consumer;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitchFactory;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class D1_ReadingWindowing extends AbstractSimDataChannelResource {

    public D1_ReadingWindowing(DataChannel dataChannel, AssemblyContext assemblyContext, InterpreterDefaultContext context,
            SchedulerModel model, RepositoryComponentSwitchFactory repositoryComponentSwitchFactory) {
        super(dataChannel, assemblyContext, context, model, repositoryComponentSwitchFactory);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void acceptData(DataSinkRole role, IndirectionDate date) {
        // TODO Auto-generated method stub

    }

    @Override
    protected boolean canAcceptData(DataSinkRole role) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected boolean canProvideData(DataSourceRole role) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected boolean isPushingRole(DataSourceRole role) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void handleCannotProceedToGet(ProcessWaitingToGet process) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void handleCannotProceedToPut(ProcessWaitingToPut process) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void handleNewWatermarkedTime(double oldWatermarkTime, double watermarkTime) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void provideDataAndAdvance(DataSourceRole role, Consumer<IndirectionDate> continuation) {
        // TODO Auto-generated method stub

    }

}
