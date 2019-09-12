package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.indirections.partitioning.Windowing;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

public class SimNoRDDataChannelResourceWithoutWindowing implements IDataChannelResource {
	protected final Queue<ProcessWaitingToGet> waitingToGetQueue;
    protected final Queue<ProcessWaitingToPut> waitingToPutQueue;
    protected final Queue<Map<String, Object>> queue;
    
    private final SimuComModel model;
	private final int capacity;
	
	public SimNoRDDataChannelResourceWithoutWindowing(DataChannel dataChannel, final SchedulerModel model) {
		this.model = (SimuComModel) model;
		waitingToGetQueue = new ArrayDeque<>();
		waitingToPutQueue = new ArrayDeque<>();
		queue = new ArrayDeque<>();
		this.capacity = dataChannel.getCapacity();
		
		if (dataChannel.getTimeGrouping() != null) {
			throw new IllegalArgumentException("Cannot handle time grouping.");
		}
	}

	private void allowToPut(ProcessWaitingToPut process) {
		queue.add(process.frame);
		if (process.isWaiting())
			process.activate();
		notifyProcessesWaitingToGet();
	}
	
	private void allowToGet(ProcessWaitingToGet process) {
		process.callback.accept(queue.remove());
		if (process.isWaiting())
			process.activate();
		notifyProcessesWaitingToPut();
	}
	
    private void notifyProcessesWaitingToGet() {
        notifyProcesses(waitingToGetQueue, p -> p.schedulableProcess, this::canProceedToGet, this::allowToGet);
    }

    private void notifyProcessesWaitingToPut() {
    	notifyProcesses(waitingToPutQueue, p -> p.schedulableProcess, this::canProceedToPut, this::allowToPut);
    }

    private <T> void notifyProcesses(Queue<T> processes, Function<T, ISchedulableProcess> processExtractor,
            Predicate<T> canProceed, Consumer<T> allow) {
    	
        T waitingProcess = processes.peek();
        while (waitingProcess != null && canProceed.test(waitingProcess)) {
            allow.accept(waitingProcess);
            processes.remove();
            processExtractor.apply(waitingProcess).activate();

            waitingProcess = processes.peek();
        }
    }
	
	@Override
	public boolean put(ISchedulableProcess schedulableProcess, Map<String, Object> eventStackframe) {
		if (!model.getSimulationControl().isRunning()) {
			return true;
		}
		
		final ProcessWaitingToPut process = new ProcessWaitingToPut(model, schedulableProcess, eventStackframe);
		if (canProceedToPut(process)) {
			allowToPut(process);
			return true;
		} else {
			waitingToPutQueue.add(process);
			process.passivate();
			return false;
		}
	}

	@Override
	public boolean get(ISchedulableProcess schedulableProcess, Consumer<Map<String, Object>> callback) {
        if (!model.getSimulationControl().isRunning()) {
            return true;
        }

        final ProcessWaitingToGet process = new ProcessWaitingToGet(model, schedulableProcess, callback);
        if (canProceedToGet(process)) {
        	allowToGet(process);
        	return true;
        } else {
            waitingToGetQueue.add(process);
            process.passivate();
            return false;
        }
	}
	
	private boolean canProceedToPut(final ProcessWaitingToPut process) {
    	boolean isNextProcess = waitingToPutQueue.isEmpty()
                || waitingToPutQueue.peek().schedulableProcess.equals(process.schedulableProcess);
    	if (capacity == -1) {
    		return isNextProcess;
    	} else {
	    	long acceptableCount = capacity - queue.size();
	        return isNextProcess && (acceptableCount > 0);
    	}
    }
	
    private boolean canProceedToGet(final ProcessWaitingToGet process) {
    	boolean isNextProcess = waitingToGetQueue.isEmpty()
                || waitingToGetQueue.peek().schedulableProcess.equals(process.schedulableProcess);
        long providableCount = queue.size();
        return isNextProcess && (providableCount > 0);
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
		return this.capacity;
	}

	@Override
	public long getAvailable() {
		return capacity - this.queue.size();
	}

//	@Override
//	public void addObserver(IPassiveResourceSensor observer) {
//		System.out.println("ADDING OBSERVER " + observer.toString());
//	}

//	@Override
//	public void removeObserver(IPassiveResourceSensor observer) {
//		System.out.println("REMOVE OBSERVER " + observer.toString());
//	}

//	@Override
//	public Queue<SchedulableStackframeAndProcess> getWaitingProcesses() {
//		return waitingQueue;
//	}

}
