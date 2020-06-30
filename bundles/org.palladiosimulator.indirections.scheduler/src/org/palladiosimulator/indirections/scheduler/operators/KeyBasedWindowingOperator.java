package org.palladiosimulator.indirections.scheduler.operators;

import java.util.List;
import java.util.Optional;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;

public class KeyBasedWindowingOperator<T extends IndirectionDate> extends WindowingOperator<T> {
    public KeyBasedWindowingOperator(final boolean emitEmptyWindows, final double size, final double shift,
            final double gracePeriod) {
        super(emitEmptyWindows, size, shift, gracePeriod);
    }

    @Override
    public void accept(final T indirectionDate) {
        super.accept(indirectionDate);

        final Double time = indirectionDate.getTime();
        final Optional<List<Window>> windowsToEmit = this.windowEmitter.accept(time);
        windowsToEmit.ifPresent(this::emitWindows);
    }
}