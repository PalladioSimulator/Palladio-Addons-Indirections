package org.palladiosimulator.simulizar.indirection.scheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.simulizar.indirection.datatypes.WindowingTimeMode;
import org.palladiosimulator.simulizar.indirection.partitioning.Windowing;
import org.palladiosimulator.simulizar.indirection.system.DataChannel;
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import edu.kit.ipd.sdq.commons.util.java.lang.IterableUtil;
import static edu.kit.ipd.sdq.commons.util.java.lang.IterableUtil.*;

public class SimNoRDDataChannelResource implements IDataChannelResource {
	protected final Queue<ProcessWaitingToGet> waitingToGetQueue;
    protected final Queue<ProcessWaitingToPut> waitingToPutQueue;
    protected final Queue<Map<String, Object>> incomingQueue;
    protected final Queue<Map<String, Object>> outgoingQueue;
    
    private final SimuComModel model;
	private final int capacity;
	private final Windowing windowing;
	private PeriodicallyTriggeredSimulationEntity windowingTrigger;
	private final DataChannel dataChannel;
	
	public SimNoRDDataChannelResource(DataChannel dataChannel, final SchedulerModel model) {
		if (!(model instanceof SimuComModel)) {
			throw new IllegalArgumentException("Currently only works with " + SimuComModel.class.getName() + ", got " + model.getClass().getName());
		}
		
		this.model = (SimuComModel) model;
		waitingToGetQueue = new ArrayDeque<>();
		waitingToPutQueue = new ArrayDeque<>();
		incomingQueue = new ArrayDeque<>();
		outgoingQueue = new ArrayDeque<>();
		this.dataChannel = dataChannel;
		this.capacity = dataChannel.getCapacity();
		
		
		this.windowing = dataChannel.getWindowing();
		if (windowing != null && windowing.getTimeMode() != WindowingTimeMode.WALL_CLOCK) {
			throw new IllegalArgumentException("Currently, only the WindowingTimeMode " + WindowingTimeMode.WALL_CLOCK + " can be simulated.");
		}
		
		if (windowing != null) {
			this.windowingTrigger = new PeriodicallyTriggeredSimulationEntity(this.model, 0, windowing.getInterval()) {
				@Override
				protected void triggerInternal() {
					createWindow();
				}
			};
		}
	}

	protected void createWindow() {
		System.out.println("Creating window (at " + model.getSimulationControl().getCurrentSimulationTime() + ")");
		Map<String, Object> window = new HashMap<String, Object>();
		
		Map<String, List<Object>> windowedVariables = new HashMap<>();
		for (Map<String, Object> map : incomingQueue) {
			for (Entry<String, Object> entry : map.entrySet()) {
				List<Object> valuesForKey = windowedVariables.computeIfAbsent(entry.getKey(), it -> new ArrayList<Object>());
				valuesForKey.add(entry.getValue());
			}
		}
		
		window.put(getOutgoingParameterName() + ".NUMBER_OF_ELEMENTS", claimEqual(windowedVariables.values().stream().map(List::size).collect(Collectors.toList())));
		
		incomingQueue.clear();
		for (Entry<String, List<Object>> entry : windowedVariables.entrySet()) {
			String key = rewriteVariableNamePrefix(entry.getKey());
			List<Object> value = entry.getValue();
			window.put(key + ".INNER.VALUE", value);
			
			if (value.stream().allMatch(Number.class::isInstance)) {
				DoubleSummaryStatistics statistics = value.stream().mapToDouble(it -> ((Number) it).doubleValue()).summaryStatistics();
				window.put(key + ".min.VALUE", statistics.getMin());
				window.put(key + ".max.VALUE", statistics.getMax());
				window.put(key + ".average.VALUE", statistics.getAverage());
			}
		}
		
		outgoingQueue.add(window);
		notifyProcessesWaitingToGet();
	}

	/**
	 * Changes the prefix in the given variable name from the parameter name of the
	 * incoming event type to the one of the outgoing event type.
	 */
	private String rewriteVariableNamePrefix(String variableName) {
		if (variableName.startsWith(getIncomingParameterName())) {
			return getOutgoingParameterName() + variableName.substring(getIncomingParameterName().length());
		} else {
			throw new AssertionError("Variable '" + variableName  + "' does not start with incoming paramete name: " + getIncomingParameterName());
		}
	}

	private String getOutgoingParameterName() {
		return getOneParameter(dataChannel.getSourceEventGroup()).getParameterName();
	}

	private String getIncomingParameterName() {
		return getOneParameter(dataChannel.getSinkEventGroup()).getParameterName();
	}

	private void allowToPut(ProcessWaitingToPut process) {
		if (windowing == null)
			outgoingQueue.add(process.frame);
		else
			incomingQueue.add(process.frame);
		
		if (process.isWaiting())
			process.activate();
		notifyProcessesWaitingToGet();
	}
	
	private void allowToGet(ProcessWaitingToGet process) {
		process.callback.accept(getNextAvailableElement());
		if (process.isWaiting())
			process.activate();
		notifyProcessesWaitingToPut();
	}
	
    private Map<String, Object> getNextAvailableElement() {
		return outgoingQueue.remove();
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
		validateStackframeStructure(eventStackframe, getIncomingParameterName());
		
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

	private void validateStackframeStructure(Map<String, Object> dataMap, String parameterName) {
		String parameterCharacterisationPrefix = parameterName + ".";
		
		for (Entry<String, Object> entry : dataMap.entrySet()) {
			if (!entry.getKey().startsWith(parameterCharacterisationPrefix)) {
				throw new IllegalArgumentException("Invalid characteristation for data frame: " + entry.getKey() + ", expected characteristations for " + parameterName);
			}
		}
	}

	private Parameter getOneParameter(EventGroup eventGroup) {
		return IterableUtil.claimOne(eventGroup.getEventTypes__EventGroup()).getParameter__EventType();
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
	    	long acceptableCount = capacity - incomingQueue.size();
	        return isNextProcess && (acceptableCount > 0);
    	}
    }
	
    private boolean canProceedToGet(final ProcessWaitingToGet process) {
    	boolean isNextProcess = waitingToGetQueue.isEmpty()
                || waitingToGetQueue.peek().schedulableProcess.equals(process.schedulableProcess);
        long providableCount = outgoingQueue.size();
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
		return capacity - this.incomingQueue.size();
	}
}
