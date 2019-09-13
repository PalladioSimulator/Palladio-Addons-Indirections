package org.palladiosimulator.indirections.scheduler.scheduling;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.entities.SchedulerEntity;

public class SuspendableSchedulerEntity extends SchedulerEntity {
	public final ISchedulableProcess schedulableProcess;
	private boolean isWaiting;
	
	protected SuspendableSchedulerEntity(SchedulerModel model, ISchedulableProcess schedulableProcess, String name) {
		super(model, name);
		
		this.schedulableProcess = schedulableProcess;
	}
	
	public void activate() {
		if (!isWaiting) {
			throw new IllegalStateException("process is not waiting");
		}
		
		isWaiting = false;
		schedulableProcess.activate();
	}
	
	public void passivate() {
		if (isWaiting) {
			throw new IllegalStateException("process is already waiting");
		}
		
		isWaiting = true;
		schedulableProcess.passivate();
	}
	
	public boolean isWaiting() {
		return isWaiting;
	}
}