package org.palladiosimulator.indirections.scheduler.data;

import java.util.List;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;

public class WindowingIndirectionDate<T extends IndirectionDate> extends ConcreteGroupingIndirectionDate<T> {
    private final Window window;

    public WindowingIndirectionDate(List<T> dataInGroup, Window window) {
        super(dataInGroup, Map.of("WINDOW.VALUE", window));
        this.window = window;
    }

    @Override
    public Double getTime() {
        throw new UnsupportedOperationException();
    }
}
