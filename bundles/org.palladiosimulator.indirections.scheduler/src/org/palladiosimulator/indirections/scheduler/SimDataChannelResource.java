package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.Emitters.WindowEmitter;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.system.DataChannel;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class SimDataChannelResource extends AbstractDistributingSimDataChannelResource {
    public SimDataChannelResource(DataChannel dataChannel, SchedulerModel model) {
        super(dataChannel, model);
    }

    public abstract class SimStatefulOperator implements Consumer<IndirectionDate> {
        private final List<Consumer<IndirectionDate>> emitsTo;

        public SimStatefulOperator(List<Consumer<IndirectionDate>> emitsTo) {
            this.emitsTo = new ArrayList<>(emitsTo);
        }

        protected final void emit(IndirectionDate date) {
            emitsTo.forEach(it -> it.accept(date));
        }
    }

    public class WindowingOperator extends SimStatefulOperator {
        private final boolean emitEmptyWindows;
        private final WindowEmitter windowEmitter;

        public List<IndirectionDate> emittableIndirectionDates;

        public WindowingOperator(List<Consumer<IndirectionDate>> emitsTo, boolean emitEmptyWindows, double size,
                double shift) {
            super(emitsTo);
            this.emitEmptyWindows = emitEmptyWindows;
            this.windowEmitter = new WindowEmitter(size, shift);
            this.emittableIndirectionDates = new ArrayList<>();
        }

        @Override
        public void accept(IndirectionDate indirectionDate) {
            emittableIndirectionDates.add(indirectionDate);
            Double time = indirectionDate.getTime();

            Optional<List<Window>> windowsToEmit = windowEmitter.accept(time);
            windowsToEmit.ifPresent(this::emitWindows);
        }

        private void emitWindows(List<Window> windows) {
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

    public class PartitioningOperator extends SimStatefulOperator {
        public PartitioningOperator(List<Consumer<IndirectionDate>> emitsTo) {
            super(emitsTo);
        }

        @Override
        public void accept(IndirectionDate t) {
            // TODO Auto-generated method stub

        }
    }

    public class JoiningOperator extends SimStatefulOperator {
        public JoiningOperator(List<Consumer<IndirectionDate>> emitsTo) {
            super(emitsTo);
        }

        @Override
        public void accept(IndirectionDate t) {
            // TODO Auto-generated method stub

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
