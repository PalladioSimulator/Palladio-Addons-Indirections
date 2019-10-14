package org.palladiosimulator.indirections.scheduler.data;

import java.util.List;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class PartitionedIndirectionDate<P, T extends IndirectionDate> implements GroupingIndirectionDate<T> {
    private Map<P, List<IndirectionDate>> partitions;

    public PartitionedIndirectionDate(Map<P, List<IndirectionDate>> partitions) {
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
    public List<T> getDataInGroup() {
        throw new UnsupportedOperationException();
    }

}
