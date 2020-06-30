package org.palladiosimulator.indirections.scheduler.implementations;

import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public abstract class OneVerySpecificDataChannelResource extends AbstractSimDataChannelResource {

	public OneVerySpecificDataChannelResource(DataChannel dataChannel, InterpreterDefaultContext context,
			SchedulerModel model) {
		super(dataChannel, context, model);
	}

}
