package org.palladiosimulator.indirections.scheduler.data;

import java.util.List;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class WindowingIndirectionDate<T extends IndirectionDate> extends ConcreteGroupingIndirectionDate<T> {
    public WindowingIndirectionDate(List<T> dataInGroup) {
        super(dataInGroup);
    }

    @Override
    public Map<String, Object> getData() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Double getTime() {
        throw new UnsupportedOperationException();
    }
}
