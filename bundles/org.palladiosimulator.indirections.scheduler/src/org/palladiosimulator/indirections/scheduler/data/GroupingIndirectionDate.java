package org.palladiosimulator.indirections.scheduler.data;

import java.util.List;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class GroupingIndirectionDate implements IndirectionDate {
    private final List<IndirectionDate> dataInGroup;

    public GroupingIndirectionDate(List<IndirectionDate> dataInGroup) {
        this.dataInGroup = dataInGroup;
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
