package org.palladiosimulator.indirections.scheduler.implementations.smarthome;

import java.util.List;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.implementations.windowing.HoldbackWindowedDataWithGracePeriodChannel;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class _4_HoldbackMediansToGroupChannel extends HoldbackWindowedDataWithGracePeriodChannel {
    public _4_HoldbackMediansToGroupChannel(JavaClassDataChannel dataChannel, InterpreterDefaultContext context,
            SchedulerModel model) {
        super(dataChannel, context, model);
    }

    @Override
    protected Window getWindowValue(IndirectionDate date) {
        return (Window) date.evaluate(_2_WindowPartitionByPlugChannel.WINDOW_VALUE_NAME);
    }
    
    @Override
    protected List<IndirectionDate> createOutputDataForWindow(List<IndirectionDate> dataInWindow, Window window) {
        return super.createOutputDataForWindow(dataInWindow, window);
    }
}
