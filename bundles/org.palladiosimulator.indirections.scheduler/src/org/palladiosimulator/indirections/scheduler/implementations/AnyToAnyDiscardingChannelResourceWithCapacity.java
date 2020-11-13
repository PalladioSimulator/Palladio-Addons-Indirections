package org.palladiosimulator.indirections.scheduler.implementations;

import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

// Additionally has an upper capacity
public class AnyToAnyDiscardingChannelResourceWithCapacity extends AnyToAnyBlockingChannelWithCapacity {
	public AnyToAnyDiscardingChannelResourceWithCapacity(final JavaClassDataChannel dataChannel,
			final InterpreterDefaultContext context, final SchedulerModel model) {
		super(dataChannel, context, model);
	}

	@Override
	protected void handleCannotProceedToPut(final ProcessWaitingToPut process) {
		this.discardDataAndContinue(process);
	}
}