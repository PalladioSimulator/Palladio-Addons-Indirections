package org.palladiosimulator.indirections.scheduler.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.GroupingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.WindowEmitter;

public abstract class WindowingOperator<T extends IndirectionDate>
        extends SimStatefulOperator<GroupingIndirectionDate<T>, WindowingIndirectionDate<GroupingIndirectionDate<T>>> {
    protected final boolean emitEmptyWindows;
    protected final WindowEmitter windowEmitter;

    public List<GroupingIndirectionDate<T>> emittableIndirectionDates;

    public WindowingOperator(boolean emitEmptyWindows, double size, double shift) {
        this.emitEmptyWindows = emitEmptyWindows;
        this.windowEmitter = new WindowEmitter(size, shift);
        this.emittableIndirectionDates = new ArrayList<>();
    }

    @Override
    public void accept(GroupingIndirectionDate<T> indirectionDate) {
        emittableIndirectionDates.add(indirectionDate);
    }

    protected final void emitWindows(List<Window> windows) {
        for (Window w : windows) {
            List<GroupingIndirectionDate<T>> dataInWindow = emittableIndirectionDates.stream()
                    .filter(it -> w.contains(it.getTime())).collect(Collectors.toList());
            if (emitEmptyWindows || !dataInWindow.isEmpty()) {
                emit(new WindowingIndirectionDate<GroupingIndirectionDate<T>>(dataInWindow));
            }
        }
    }
}