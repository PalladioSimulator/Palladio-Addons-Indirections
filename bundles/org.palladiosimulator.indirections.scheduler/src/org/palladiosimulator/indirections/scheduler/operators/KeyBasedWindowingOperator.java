package org.palladiosimulator.indirections.scheduler.operators;

import java.util.List;
import java.util.Optional;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.GroupingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;

public class KeyBasedWindowingOperator<T extends IndirectionDate> extends WindowingOperator<T> {
    public KeyBasedWindowingOperator(boolean emitEmptyWindows, double size, double shift) {
        super(emitEmptyWindows, size, shift);
    }

    @Override
    public void accept(GroupingIndirectionDate<T> indirectionDate) {
        super.accept(indirectionDate);

        Double time = indirectionDate.getTime();
        Optional<List<Window>> windowsToEmit = windowEmitter.accept(time);
        windowsToEmit.ifPresent(this::emitWindows);
    }
}