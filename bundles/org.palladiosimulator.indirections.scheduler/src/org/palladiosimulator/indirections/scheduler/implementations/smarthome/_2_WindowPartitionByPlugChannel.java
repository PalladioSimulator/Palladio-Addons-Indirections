package org.palladiosimulator.indirections.scheduler.implementations.smarthome;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.data.PartitionedIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class _2_WindowPartitionByPlugChannel extends AbstractSimDataChannelResource {
    public static final String WINDOW_VALUE_NAME = "WINDOW.VALUE";
    public static final String PLUG_ID_VALUE_NAME = "plugId.VALUE";

    private final Queue<PartitionedIndirectionDate<Integer, IndirectionDate>> dataOut;

    public _2_WindowPartitionByPlugChannel(JavaClassDataChannel dataChannel, InterpreterDefaultContext context,
            SchedulerModel model) {
        super(dataChannel, context, model);

        IndirectionSimulationUtil.requireExactNumberOfSinkSourceRoles(this.dataChannel, 1, 1);

        dataOut = new ArrayDeque<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void acceptData(DataChannelSinkConnector connector, IndirectionDate date) {
        var windowingIndirectionDate = (WindowingIndirectionDate<IndirectionDate>) date;

        var plugIdToWindowedElements = windowingIndirectionDate.getDataInGroup()
            .stream()
            .collect(Collectors.<IndirectionDate, Integer> groupingBy(
                    (IndirectionDate it) -> (Integer) it.evaluate(PLUG_ID_VALUE_NAME)));

        Window window = windowingIndirectionDate.window;
        // plugIdToWindowedElements.forEach((plugId, data) -> data.add(new
        // WindowingIndirectionDate<>(data, window)));
        for (var entry : plugIdToWindowedElements.entrySet()) {
            var plugId = entry.getKey();
            var<IndirectionDate> data = entry.getValue();

            this.dataOut.add(new PartitionedIndirectionDate<>(plugId, data, Map.of(WINDOW_VALUE_NAME, window)));
        }

        notifyProcessesCanGetNewData();
    }

    @Override
    protected boolean canAcceptData(DataChannelSinkConnector connector) {
        return true;
    }

    @Override
    protected boolean canProvideData(DataChannelSourceConnector connector) {
        return dataOut.size() > 0;
    }

    @Override
    protected void handleCannotProceedToGet(ProcessWaitingToGet process) {
        blockUntilCanGet(process);
    }

    @Override
    protected void handleCannotProceedToPut(ProcessWaitingToPut process) {
        throw new PCMModelInterpreterException("This should not happen.");
    }

    @Override
    protected void handleNewWatermarkedTime(double oldWatermarkTime, double watermarkTime) {
        // do nothing
    }

    @Override
    protected IndirectionDate provideDataAndAdvance(DataChannelSourceConnector connector) {
        return dataOut.remove();
    }
}
