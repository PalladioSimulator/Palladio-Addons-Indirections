package org.palladiosimulator.indirections.scheduler.operators.dev;

import java.util.List;
import java.util.Optional;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;

public class KeyBasedWindowingOperator<T extends IndirectionDate> extends WindowingOperator<T> {
    public KeyBasedWindowingOperator(boolean emitEmptyWindows, double size, double shift, double gracePeriod) {
        super(emitEmptyWindows, size, shift, gracePeriod);
    }

    @Override
    public void accept(T indirectionDate) {
        super.accept(indirectionDate);

        Double time = indirectionDate.getTime();
        Optional<List<Window>> windowsToEmit = windowEmitter.accept(time);
        windowsToEmit.ifPresent(this::emitWindows);
    }
}
