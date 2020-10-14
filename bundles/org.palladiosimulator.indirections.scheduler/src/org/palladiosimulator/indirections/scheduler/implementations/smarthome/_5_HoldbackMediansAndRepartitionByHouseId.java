package org.palladiosimulator.indirections.scheduler.implementations.smarthome;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.PartitionedIndirectionDate;
import org.palladiosimulator.indirections.scheduler.implementations.windowing.HoldbackWindowedDataWithGracePeriodChannel;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class _5_HoldbackMediansAndRepartitionByHouseId extends HoldbackWindowedDataWithGracePeriodChannel {
    public static final String HOUSE_ID_VALUE_NAME = "PARTITION.houseId.VALUE";

    public _5_HoldbackMediansAndRepartitionByHouseId(JavaClassDataChannel dataChannel,
            InterpreterDefaultContext context, SchedulerModel model) {
        super(dataChannel, context, model);
    }

    @Override
    protected Window getWindowValue(IndirectionDate date) {
        return (Window) date.evaluate(_2_WindowPartitionByPlugChannel.WINDOW_VALUE_NAME);
    }

    @Override
    protected List<IndirectionDate> createOutputDataForWindow(List<IndirectionDate> dataInWindow, Window window) {
        var result = new ArrayList<IndirectionDate>();
        dataInWindow.stream()
            .collect(Collectors.groupingBy(it -> it.evaluate(HOUSE_ID_VALUE_NAME))) // regroup it by
                                                                                    // houses
            .forEach((houseId, indirectionDates) -> result
                .add(new PartitionedIndirectionDate<>(window, indirectionDates, Map.of(HOUSE_ID_VALUE_NAME, houseId))));

        return result;
    }
}
