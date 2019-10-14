package org.palladiosimulator.indirections.scheduler.data;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class ConcreteGroupingIndirectionDate<T extends IndirectionDate> implements GroupingIndirectionDate<T> {
    private final List<T> dataInGroup;

    public ConcreteGroupingIndirectionDate(List<T> dataInGroup) {
        this.dataInGroup = dataInGroup;
    }

    @Override
    public List<T> getDataInGroup() {
        return Collections.unmodifiableList(dataInGroup);
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
