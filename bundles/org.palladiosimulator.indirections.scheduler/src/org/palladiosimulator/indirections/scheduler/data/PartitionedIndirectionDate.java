package org.palladiosimulator.indirections.scheduler.data;

import java.util.List;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class PartitionedIndirectionDate<P, T extends IndirectionDate> extends ConcreteGroupingIndirectionDate<T> {
    private final P partition;

    public PartitionedIndirectionDate(final P partition, final List<T> values, final Map<String, Object> extraData) {
        super(values, extraData);
        this.extraData.put("NUMBER_OF_ELEMENTS.VALUE", values.size());
        this.extraData.put("PARTITION.VALUE", partition);
        if (partition instanceof Map) {
            final Map<String, Object> partitionMap = (Map<String, Object>) partition;
            for (final Map.Entry<String, Object> entry : partitionMap.entrySet()) {
                this.extraData.put("PARTITION." + entry.getKey(), entry.getValue());
            }
        }
        this.partition = partition;
    }

    @Override
    public Map<String, Object> getData() {
        return super.getData();
    }

    @Override
    public List<T> getDataInGroup() {
        return super.getDataInGroup();
    }

    public P getPartition() {
        return this.partition;
    }
}
