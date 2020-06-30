package org.palladiosimulator.indirections.scheduler.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.WindowEmitter;

public abstract class WindowingOperator<T extends IndirectionDate>
        extends SimStatefulOperator<T, WindowingIndirectionDate<T>> {
    protected final boolean emitEmptyWindows;
    public List<T> emittableIndirectionDates;

    protected final WindowEmitter windowEmitter;

    public WindowingOperator(final boolean emitEmptyWindows, final double size, final double shift,
            final double gracePeriod) {
        this.emitEmptyWindows = emitEmptyWindows;
        this.windowEmitter = new WindowEmitter(size, shift, gracePeriod);
        this.emittableIndirectionDates = new ArrayList<>();
    }

    @Override
    public void accept(final T indirectionDate) {
        this.emittableIndirectionDates.add(indirectionDate);
    }

    protected final void emitWindows(final List<Window> windows) {
        for (final Window w : windows) {
            final List<T> dataInWindow = this.emittableIndirectionDates.stream()
                .filter(it -> w.contains(it.getTime()))
                .collect(Collectors.toList());
            if (this.emitEmptyWindows || !dataInWindow.isEmpty()) {
                this.emit(new WindowingIndirectionDate<T>(dataInWindow, w));
            }
        }
    }
}