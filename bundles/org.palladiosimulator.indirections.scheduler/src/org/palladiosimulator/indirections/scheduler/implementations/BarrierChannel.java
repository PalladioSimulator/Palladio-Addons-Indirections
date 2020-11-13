package org.palladiosimulator.indirections.scheduler.implementations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

// holds back elements for some time before making them available for consumption
public class BarrierChannel extends AbstractSimDataChannelResource {
    public static final String INTERVAL_PARAMETER_NAME = "interval";

    private final List<IndirectionDate> dataIn;
    private final Queue<IndirectionDate> dataOut;

    private double interval;

    public BarrierChannel(final JavaClassDataChannel dataChannel, final InterpreterDefaultContext context,
            final SchedulerModel model) {
        super(dataChannel, context, model);

        this.dataIn = new ArrayList<>();
        this.dataOut = new ArrayDeque<>();

        this.interval = IndirectionSimulationUtil.getDoubleParameter(dataChannel, INTERVAL_PARAMETER_NAME);

        // flushes data every INTERVAL time units
        this.scheduleAdvance(this.model.getSimulationControl()
            .getCurrentSimulationTime(), interval, 0);
    }

    @Override
    protected void acceptData(final DataChannelSinkConnector connector, final IndirectionDate date) {
        this.dataIn.add(date);
    }

    @Override
    protected boolean canAcceptData(final DataChannelSinkConnector connector) {
        return true;
    }

    @Override
    protected boolean canProvideData(final DataChannelSourceConnector connector) {
        return this.dataOut.size() > 0;
    }

    @Override
    protected void handleCannotProceedToGet(final ProcessWaitingToGet process) {
        this.blockUntilCanGet(process);
    }

    @Override
    protected void handleCannotProceedToPut(final ProcessWaitingToPut process) {
        this.blockUntilCanPut(process);
    }

    @Override
    protected void handleNewWatermarkedTime(final double oldWatermarkTime, final double watermarkTime) {
        boolean newData = false;
        for (final var iter = this.dataIn.iterator(); iter.hasNext();) {
            final var date = iter.next();
            if (date.getTime().stream().allMatch(it -> it <= watermarkTime)) {
                this.dataOut.add(date);
                iter.remove();
                newData = true;
            }
        }

        if (newData) {
            this.notifyProcessesCanGetNewData();
        }
    }

    @Override
    protected IndirectionDate provideDataAndAdvance(final DataChannelSourceConnector connector) {
        return this.dataOut.remove();
    }

}
