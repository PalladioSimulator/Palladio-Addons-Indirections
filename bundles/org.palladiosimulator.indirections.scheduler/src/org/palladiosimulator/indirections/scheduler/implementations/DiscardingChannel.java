package org.palladiosimulator.indirections.scheduler.implementations;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class DiscardingChannel extends AbstractSimDataChannelResource {
	public DiscardingChannel(final JavaClassDataChannel dataChannel,
			final InterpreterDefaultContext context, final SchedulerModel model) {
		super(dataChannel, context, model);
	}

	@Override
	protected void acceptData(final DataChannelSinkConnector connector, final IndirectionDate date) {
		throw new AssertionError("canAcceptData is constant false");
	}

	@Override
	protected boolean canAcceptData(final DataChannelSinkConnector connector) {
		return false;
	}

	@Override
	protected boolean canProvideData(final DataChannelSourceConnector connector) {
		return false;
	}

	@Override
	protected void handleCannotProceedToGet(final ProcessWaitingToGet process) {
		this.continueWithoutData(process);
	}

	@Override
	protected void handleCannotProceedToPut(final ProcessWaitingToPut process) {
		this.discardDataAndContinue(process);
	}

	@Override
	protected void handleNewWatermarkedTime(final double oldSimulationTime, final double simulationTime) {
		// do nothing. everything is discarded immediately
	}

	@Override
	protected IndirectionDate provideDataAndAdvance(final DataChannelSourceConnector connector) {
		throw new AssertionError("canProvideData is constant false");
	}

}
