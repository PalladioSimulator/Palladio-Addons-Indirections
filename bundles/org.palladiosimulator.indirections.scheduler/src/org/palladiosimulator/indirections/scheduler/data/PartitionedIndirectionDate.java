package org.palladiosimulator.indirections.scheduler.data;

import java.util.List;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class PartitionedIndirectionDate<T> implements GroupingIndirectionDate {
    private Map<T, List<IndirectionDate>> partitions;

    public PartitionedIndirectionDate(Map<T, List<IndirectionDate>> partitions) {
        this.partitions = partitions;
    }

    @Override
    public Map<String, Object> getData() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Double getTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<IndirectionDate> getDataInGroup() {
        throw new UnsupportedOperationException();
    }

}
