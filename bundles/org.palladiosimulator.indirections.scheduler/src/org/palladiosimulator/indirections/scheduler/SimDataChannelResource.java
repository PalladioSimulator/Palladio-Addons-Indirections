package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.Emitters.WindowEmitter;
import org.palladiosimulator.indirections.scheduler.data.GroupingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.util.IndirectionUtil;
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimDataChannelResource extends AbstractDistributingSimDataChannelResource {
    public SimDataChannelResource(DataChannel dataChannel, SchedulerModel model) {
        super(dataChannel, model);
    }

    public abstract class SimStatefulOperator<T extends IndirectionDate, U extends IndirectionDate>
            implements Consumer<T> {
        private final List<Consumer<U>> emitsTo;

        public SimStatefulOperator(List<Consumer<U>> emitsTo) {
            this.emitsTo = new ArrayList<>(emitsTo);
        }

        protected final void emit(U date) {
            emitsTo.forEach(it -> it.accept(date));
        }
    }

    public abstract class WindowingOperator extends SimStatefulOperator<IndirectionDate, WindowingIndirectionDate> {
        protected final boolean emitEmptyWindows;
        protected final WindowEmitter windowEmitter;

        public List<IndirectionDate> emittableIndirectionDates;

        public WindowingOperator(List<Consumer<WindowingIndirectionDate>> emitsTo, boolean emitEmptyWindows,
                double size,
                double shift) {
            super(emitsTo);
            this.emitEmptyWindows = emitEmptyWindows;
            this.windowEmitter = new WindowEmitter(size, shift);
            this.emittableIndirectionDates = new ArrayList<>();
        }

        @Override
        public void accept(IndirectionDate indirectionDate) {
            emittableIndirectionDates.add(indirectionDate);
        }

        protected final void emitWindows(List<Window> windows) {
            for (Window w : windows) {
                List<IndirectionDate> dataInWindow = emittableIndirectionDates.stream()
                        .filter(it -> w.contains(it.getTime()))
                        .collect(Collectors.toList());

                if (emitEmptyWindows || !dataInWindow.isEmpty()) {
                    emit(new WindowingIndirectionDate(dataInWindow));
                }
            }
        }
    }

    public class KeyBasedWindowingOperator extends WindowingOperator {
        public KeyBasedWindowingOperator(List<Consumer<WindowingIndirectionDate>> emitsTo, boolean emitEmptyWindows,
                double size, double shift) {
            super(emitsTo, emitEmptyWindows, size, shift);
        }

        @Override
        public void accept(IndirectionDate indirectionDate) {
            super.accept(indirectionDate);

            Double time = indirectionDate.getTime();
            Optional<List<Window>> windowsToEmit = windowEmitter.accept(time);
            windowsToEmit.ifPresent(this::emitWindows);
        }
    }

    public class TimeBasedWindowingOperator extends WindowingOperator {
        private PeriodicallyTriggeredSimulationEntity windowingTrigger;

        public TimeBasedWindowingOperator(List<Consumer<WindowingIndirectionDate>> emitsTo, boolean emitEmptyWindows,
                double size, double shift, SimuComModel model) {
            super(emitsTo, emitEmptyWindows, size, shift);

            this.windowingTrigger = IndirectionUtil.triggerPeriodically(model, 0, shift, () -> {
                Optional<List<Window>> windowsToEmit = windowEmitter.accept(null);
                windowsToEmit.ifPresent(this::emitWindows);
            });
        }
    }

    public class PartitioningOperator extends SimStatefulOperator<GroupingIndirectionDate, GroupingIndirectionDate> {
        public PartitioningOperator(List<Consumer<GroupingIndirectionDate>> emitsTo) {
            super(emitsTo);
        }

        @Override
        public void accept(GroupingIndirectionDate t) {
            throw new UnsupportedOperationException();
        }
    }

    public class JoiningOperator extends SimStatefulOperator<IndirectionDate, IndirectionDate> {
        public JoiningOperator(List<Consumer<IndirectionDate>> emitsTo) {
            super(emitsTo);
        }

        @Override
        public void accept(IndirectionDate t) {
        }
    }

    @Override
    protected boolean canAcceptDataFrom(ProcessWaitingToEmit process) {
        return false;
    }

    @Override
    protected boolean canProvideDataFor(ProcessWaitingToConsume process) {
        return false;
    }

    @Override
    protected List<IndirectionDate> provideDataFor(ProcessWaitingToConsume process) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void acceptDataFrom(ProcessWaitingToEmit process) {
        // TODO Auto-generated method stub

    }
}
