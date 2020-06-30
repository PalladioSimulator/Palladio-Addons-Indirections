package org.palladiosimulator.indirections.scheduler.implementations;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class TestDataChannelResource extends AbstractSimDataChannelResource {

	public TestDataChannelResource(DataChannel dataChannel, InterpreterDefaultContext context, SchedulerModel model) {
		super(dataChannel, context, model);
		
		scheduleAdvance(10, 10);
	}

	@Override
	protected void handleCannotProceedToPut(ProcessWaitingToEmit process) {
		blockUntilCanEmit(process);
	}

	@Override
	protected void handleCannotProceedToGet(ProcessWaitingToConsume process) {
		blockUntilCanConsume(process);
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
	protected IndirectionDate provideData(DataSourceRole role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void acceptData(DataSinkRole role, IndirectionDate date) {
		advance(date.getTime());
	}

	@Override
	protected void handleNewSimulationTime(double oldSimulationTime, double simulationTime) {
		System.out.println("Advancing in time from " + oldSimulationTime + " to " + simulationTime);
		
	}

}
