package org.palladiosimulator.indirections.scheduler.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.Emitters.Window;

public class WindowingIndirectionDate<T extends IndirectionDate> extends ConcreteGroupingIndirectionDate<T> {
    public final Window window;

    public WindowingIndirectionDate(final List<T> dataInGroup, final Window window,
            final Map<String, Object> extraData) {
        super(dataInGroup, new HashMap<>(Map.of("WINDOW.VALUE", window)));
        this.extraData.putAll(extraData);
        this.window = window;
    }

    public WindowingIndirectionDate(final List<T> dataInGroup, final Window window) {
        this(dataInGroup, window, new HashMap<>());
    }
}
