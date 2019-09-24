package org.palladiosimulator.indirections.scheduler.data;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class ConcreteGroupingIndirectionDate implements GroupingIndirectionDate {
    private final List<IndirectionDate> dataInGroup;

    public ConcreteGroupingIndirectionDate(List<IndirectionDate> dataInGroup) {
        this.dataInGroup = dataInGroup;
    }

    public List<IndirectionDate> getDataInGroup() {
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
