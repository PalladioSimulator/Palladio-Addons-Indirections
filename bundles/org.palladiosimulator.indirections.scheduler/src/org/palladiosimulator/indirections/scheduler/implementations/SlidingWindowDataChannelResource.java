package org.palladiosimulator.indirections.scheduler.implementations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.AbstractSimDataChannelResource;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToGet;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToPut;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

// holds back elements for some time before making them available for consumption
public class SlidingWindowDataChannelResource extends AbstractSimDataChannelResource {
    public static final String WINDOW_SIZE_PARAMETER_NAME = "windowSize";
    public static final String WINDOW_SHIFT_PARAMETER_NAME = "windowShift";
    public static final String GRACE_PERIOD_PARAMETER_NAME = "gracePeriod";

    private final double windowSize;
    private final double windowShift;
    private final double gracePeriod;

    private final List<IndirectionDate> dataIn;
    private final Queue<IndirectionDate> dataOut;

    public SlidingWindowDataChannelResource(final JavaClassDataChannel dataChannel,
            final InterpreterDefaultContext context, final SchedulerModel model, final String[] configEntries) {
        super(dataChannel, context, model);

        if (true)
            throw new UnsupportedOperationException();

        IndirectionSimulationUtil.requireNumberOfSinkSourceRoles(dataChannel, it -> it == 1, "== 1", it -> it == 1,
                "== 1");

        this.dataIn = new ArrayList<>();
        this.dataOut = new ArrayDeque<>();

        this.windowSize = IndirectionSimulationUtil.getDoubleParameter(dataChannel, WINDOW_SIZE_PARAMETER_NAME);
        this.windowShift = IndirectionSimulationUtil.getDoubleParameter(dataChannel, WINDOW_SHIFT_PARAMETER_NAME);
        this.gracePeriod = IndirectionSimulationUtil.getDoubleParameter(dataChannel, GRACE_PERIOD_PARAMETER_NAME);

        // flushes data every INTERVAL time units
        this.scheduleAdvance(findNextWindowStart(this.model.getSimulationControl()
            .getCurrentSimulationTime()), windowShift, gracePeriod);
    }

    private double findNextWindowStart(double currentSimulationTime) {
        return Math.ceil(currentSimulationTime / windowShift) * windowShift;
    }

    @Override
    protected void acceptData(final DataChannelSinkConnector connector, final IndirectionDate date) {
        discardDateIfTooOld(date);
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
            if (date.getTime() <= watermarkTime) {
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
