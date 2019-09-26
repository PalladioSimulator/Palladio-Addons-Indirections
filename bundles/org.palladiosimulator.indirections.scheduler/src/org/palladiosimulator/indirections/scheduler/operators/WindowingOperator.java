package org.palladiosimulator.indirections.scheduler.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.WindowEmitter;

public abstract class WindowingOperator extends SimStatefulOperator<IndirectionDate, WindowingIndirectionDate> {
    protected final boolean emitEmptyWindows;
    protected final WindowEmitter windowEmitter;

    public List<IndirectionDate> emittableIndirectionDates;

    public WindowingOperator(List<Consumer<WindowingIndirectionDate>> emitsTo, boolean emitEmptyWindows, double size,
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
                    .filter(it -> w.contains(it.getTime())).collect(Collectors.toList());
            if (emitEmptyWindows || !dataInWindow.isEmpty()) {
                emit(new WindowingIndirectionDate(dataInWindow));
            }
        }
    }
}