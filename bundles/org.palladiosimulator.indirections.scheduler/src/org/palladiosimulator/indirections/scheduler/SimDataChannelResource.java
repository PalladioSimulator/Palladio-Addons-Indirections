package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.Emitters.WindowEmitter;
import org.palladiosimulator.indirections.scheduler.data.GroupingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.PartitionedIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

public class SimDataChannelResource extends AbstractDistributingSimDataChannelResource {
    private Queue<IndirectionDate> dataQueue = new ArrayDeque<>();
    private Consumer<IndirectionDate> processor;

    public SimDataChannelResource(DataChannel dataChannel, SchedulerModel model) {
        super(dataChannel, model);

        this.processor = new DirectTransferOperator<IndirectionDate>(List.of(this::emit));
    }

    private void emit(IndirectionDate date) {
        dataQueue.add(date);
        notifyProcessesWaitingToGet();
    }

    @Override
    protected boolean canAcceptDataFrom(ProcessWaitingToEmit process) {
        return true;
    }

    @Override
    protected boolean canProvideDataFor(ProcessWaitingToConsume process) {
        return !dataQueue.isEmpty();
    }

    @Override
    protected List<IndirectionDate> provideDataFor(ProcessWaitingToConsume process) {
        return Collections.singletonList(dataQueue.remove());
    }

    @Override
    protected void acceptDataFrom(ProcessWaitingToEmit process) {
        processor.accept(process.frame);
        notifyProcessesWaitingToGet();
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

    public class DirectTransferOperator<T extends IndirectionDate> extends SimStatefulOperator<T, T> {

        public DirectTransferOperator(List<Consumer<T>> emitsTo) {
            super(emitsTo);
        }

        @Override
        public void accept(T t) {
            this.emit(t);
        }

    }

    public abstract class WindowingOperator extends SimStatefulOperator<IndirectionDate, WindowingIndirectionDate> {
        protected final boolean emitEmptyWindows;
        protected final WindowEmitter windowEmitter;

        public List<IndirectionDate> emittableIndirectionDates;

        public WindowingOperator(List<Consumer<WindowingIndirectionDate>> emitsTo, boolean emitEmptyWindows,
                double size, double shift) {
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
                        .filter(it -> w.contains(it.getTime())).collect(Collectors.toList());
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

            this.windowingTrigger = IndirectionSimulationUtil.triggerPeriodically(model, 0, shift, () -> {
                Optional<List<Window>> windowsToEmit = windowEmitter.accept(null);
                windowsToEmit.ifPresent(this::emitWindows);
            });
        }
    }

    public abstract class PartitioningOperator<T>
            extends SimStatefulOperator<GroupingIndirectionDate, PartitionedIndirectionDate<T>> {
        public PartitioningOperator(List<Consumer<PartitionedIndirectionDate<T>>> emitsTo) {
            super(emitsTo);
        }

        @Override
        public void accept(GroupingIndirectionDate group) {
            Map<T, List<IndirectionDate>> collect = group.getDataInGroup().stream()
                    .collect(Collectors.groupingBy(this::getPartition));

            emit(new PartitionedIndirectionDate<T>(collect));
        }

        protected abstract T getPartition(IndirectionDate date);
    }

    public class SpecificationPartitioningOperator extends PartitioningOperator<Object> {
        private List<PCMRandomVariable> specification;

        public SpecificationPartitioningOperator(List<Consumer<PartitionedIndirectionDate<Object>>> emitsTo,
                List<PCMRandomVariable> specification) {
            super(emitsTo);

            this.specification = specification;
        }

        @Override
        protected Object getPartition(IndirectionDate date) {
            final SimulatedStackframe<Object> stack = SimulatedStackHelper.createFromMap(date.getData());

            return specification.stream().collect(Collectors.toMap(it -> it.getSpecification(),
                    it -> StackContext.evaluateStatic(it.getSpecification(), stack)));

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
}
