package org.palladiosimulator.simulizar.indirection.scheduler;

import java.util.Queue;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.indirection.system.DataChannel;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.processes.IWaitingProcess;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

public class SimNoRDDataChannelResource implements IDataChannelResource {

	public SimNoRDDataChannelResource(DataChannel dataChannel) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void put(ISchedulableProcess process, SimulatedStackframe<Object> eventStackframe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SimulatedStackframe<Object> get(ISchedulableProcess process) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssemblyContext getAssemblyContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getAvailable() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addObserver(IPassiveResourceSensor observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(IPassiveResourceSensor observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Queue<IWaitingProcess> getWaitingProcesses() {
		// TODO Auto-generated method stub
		return null;
	}

}
