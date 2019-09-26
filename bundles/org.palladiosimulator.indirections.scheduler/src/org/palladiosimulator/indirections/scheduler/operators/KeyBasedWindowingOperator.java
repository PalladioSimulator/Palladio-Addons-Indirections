package org.palladiosimulator.indirections.scheduler.operators;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;

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