package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.palladiosimulator.indirections.calculators.scheduler.TriggerableCountingCalculator;
import org.palladiosimulator.indirections.calculators.scheduler.TriggerableTimeSpanCalculator;
import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.datatypes.ConsumeFromChannelPolicy;
import org.palladiosimulator.indirections.datatypes.EmitToChannelPolicy;
import org.palladiosimulator.indirections.datatypes.NumberOfElements;
import org.palladiosimulator.indirections.datatypes.Scheduling;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.indirections.scheduler.CallbackUserFactory.CallbackUser;
import org.palladiosimulator.indirections.scheduler.data.ConcreteGroupingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.util.IterableUtil;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Variability that needs to be handled by a {@link SimDataChannelResource}:
 * <ul>
 * <li>How is data ingress handled: FCFS, LIFO, Priorities, etc.</li>
 * <li>How is data grouped, etc.</li>
 * <li>How is data distributed.</li>
 * </ul>
 * 
 * <p>
 * 
 * The {@link AbstractSimDataChannelResource}, <strong>not</strong>
 * {@link SimDataChannelResource} handles:
 * <ul>
 * <li>Blocking/unblocking processes</li>
 * <li>Creating new pushing processes</li>
 * </ul>
 * 
 * 
 * Who decides what data is given to which connector?
 * 
 * @implNote It might make sense to implement this as a strategy (composition
 *           over inheritance) instead of inheriting from
 *           {@link AbstractSimDataChannelResource}.
 * 
 */
public class SimDataChannelResource extends AbstractSimDataChannelResource {
	private static final Logger LOGGER = Logger.getLogger(SimDataChannelResource.class);

	private Deque<IndirectionDate> dataQueue = new ArrayDeque<>();

	public SimDataChannelResource(DataChannel dataChannel, InterpreterDefaultContext context, SchedulerModel model) {
		super(dataChannel, context, model);

		if (!(model instanceof SimuComModel)) {
			throw new PCMModelInterpreterException("Unsupported type of model: " + model.getClass().getName()
					+ ", expected: " + SimuComModel.class.getName());
		}

		SimuComModel simuComModel = (SimuComModel) model;

		if (dataChannel.getScheduling() != Scheduling.FIRST_IN_FIRST_OUT) {
			throw new PCMModelInterpreterException("Currently, only " + Scheduling.FIRST_IN_FIRST_OUT
					+ " is supported, found: " + dataChannel.getScheduling());
		}

		if (dataChannel.getNumberOfElementsToEmit() == null) {
			throw new PCMModelInterpreterException("Number of elements to emit cannot be null.");
		}
	}

	private static boolean needsElementToBePresent(NumberOfElements numberOfElements) {
		Objects.requireNonNull(numberOfElements);

		return numberOfElements == NumberOfElements.AT_LEAST_ONE || numberOfElements == NumberOfElements.EXACTLY_ONE;
	}

	@Override
	protected boolean canProvideData() {
		return !needsElementToBePresent(dataChannel.getNumberOfElementsToEmit()) || !dataQueue.isEmpty();
	}

	@Override
	protected IndirectionDate provideData() {
		if (dataChannel.getConsumeFromChannelPolicy() == ConsumeFromChannelPolicy.PEEK) {
			switch (dataChannel.getNumberOfElementsToEmit()) {
			case ANY_NUMBER:
				return new ConcreteGroupingIndirectionDate<>(new ArrayList<>(peekAllElementsFromQueue()));
			case AT_LEAST_ONE:
				return new ConcreteGroupingIndirectionDate<>(peekAtLeastOneElement());
			case EXACTLY_ONE:
				return peekExactlyOneElement();
			case ONE_OR_NONE:
				return new ConcreteGroupingIndirectionDate<>(peekOneOrNoneElements());
			}
		} else if (dataChannel.getConsumeFromChannelPolicy() == ConsumeFromChannelPolicy.REMOVE) {
			switch (dataChannel.getNumberOfElementsToEmit()) {
			case ANY_NUMBER:
				return new ConcreteGroupingIndirectionDate<>(new ArrayList<>(removeAllElementsFromQueue()));
			case AT_LEAST_ONE:
				return new ConcreteGroupingIndirectionDate<>(removeAtLeastOneElement());
			case EXACTLY_ONE:
				return removeExactlyOneElement();
			case ONE_OR_NONE:
				return new ConcreteGroupingIndirectionDate<>(removeOneOrNoneElements());
			}
		}

		throw new PCMModelInterpreterException("Unknown consume policy (" + dataChannel.getConsumeFromChannelPolicy()
				+ ") or number of elements to emit (" + dataChannel.getNumberOfElementsToEmit() + ").");
	}

	private List<IndirectionDate> peekAllElementsFromQueue() {
		return dataQueue.stream().collect(Collectors.toList());
	}

	private List<IndirectionDate> peekAtLeastOneElement() {
		return IterableUtil.claimAtLeastOne(peekAllElementsFromQueue());
	}

	private IndirectionDate peekExactlyOneElement() {
		if (dataQueue.isEmpty()) {
			throw new IllegalArgumentException("Queue is empty, although it must contain one element per assertion");
		}

		return dataQueue.peek();
	}

	private List<IndirectionDate> peekOneOrNoneElements() {
		if (dataQueue.isEmpty()) {
			return Collections.emptyList();
		} else {
			return Collections.singletonList(dataQueue.peek());
		}
	}

	private List<IndirectionDate> removeAllElementsFromQueue() {
		List<IndirectionDate> result = peekAllElementsFromQueue();
		dataQueue.clear();
		return result;
	}

	private List<IndirectionDate> removeAtLeastOneElement() {
		return IterableUtil.claimAtLeastOne(removeAllElementsFromQueue());
	}

	private IndirectionDate removeExactlyOneElement() {
		if (dataQueue.isEmpty()) {
			throw new IllegalArgumentException("Queue is empty, although it must contain one element per assertion");
		}

		return dataQueue.remove();
	}

	private List<IndirectionDate> removeOneOrNoneElements() {
		if (dataQueue.isEmpty()) {
			return Collections.emptyList();
		} else {
			return Collections.singletonList(dataQueue.remove());
		}
	}

	@Override
	protected boolean canAcceptData() {
		if (dataChannel.getEmitToChannelPolicy() == EmitToChannelPolicy.DISCARD_OLDEST_IF_FULL) {
			return true;
		} else if (dataChannel.getEmitToChannelPolicy() == EmitToChannelPolicy.BLOCK_IF_FULL) {
			return (dataChannel.getCapacity() == -1 || (dataChannel.getCapacity() > dataQueue.size()));
		} else {
			throw new PCMModelInterpreterException(
					"EmitToChannelPolicy cannot be " + dataChannel.getEmitToChannelPolicy());
		}
	}

	@Override
	protected void acceptData(IndirectionDate date) {
		dataQueue.add(date);

		if ((dataChannel.getCapacity() != -1) && (dataQueue.size() > dataChannel.getCapacity())) {
			throw new PCMModelInterpreterException(
					"Data channel size is larger than capacity. This should be possible.");
		}

		LOGGER.trace("Added date to queue: " + date);
	}
}
