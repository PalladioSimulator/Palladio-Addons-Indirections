package org.palladiosimulator.indirections.scheduler.operators.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.WindowEmitter;
import org.palladiosimulator.indirections.scheduler.operators.SimStatefulOperator;

public abstract class WindowingOperator<T extends IndirectionDate>
        extends SimStatefulOperator<T, WindowingIndirectionDate<T>> {
    protected final boolean emitEmptyWindows;
    protected final WindowEmitter windowEmitter;

    public List<T> emittableIndirectionDates;

    public WindowingOperator(boolean emitEmptyWindows, double size, double shift, double gracePeriod) {
        this.emitEmptyWindows = emitEmptyWindows;
        this.windowEmitter = new WindowEmitter(size, shift, gracePeriod);
        this.emittableIndirectionDates = new ArrayList<>();
    }

    @Override
    public void accept(T indirectionDate) {
        emittableIndirectionDates.add(indirectionDate);
    }

    protected final void emitWindows(List<Window> windows) {
        for (Window w : windows) {
            List<T> dataInWindow = emittableIndirectionDates.stream().filter(it -> w.contains(it.getTime()))
                    .collect(Collectors.toList());
            if (emitEmptyWindows || !dataInWindow.isEmpty()) {
                emit(new WindowingIndirectionDate<T>(dataInWindow, w));
            }
        }
    }
}
