package org.palladiosimulator.indirections.scheduler.data;

import java.util.List;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class PartitionedIndirectionDate<P, T extends IndirectionDate> extends ConcreteGroupingIndirectionDate<T> {
    private P partition;

    public PartitionedIndirectionDate(P partition, List<T> values, Map<String, Object> extraData) {
        super(values, extraData);
        this.extraData.put("NUMBER_OF_ELEMENTS.VALUE", values.size());
        this.extraData.put("PARTITION.VALUE", partition);
        if (partition instanceof Map) {
            Map<String, Object> partitionMap = (Map<String, Object>) partition;
            for (Map.Entry<String, Object> entry : partitionMap.entrySet()) {
                this.extraData.put("PARTITION." + entry.getKey(), entry.getValue());
            }
        }
        this.partition = partition;
    }

    public P getPartition() {
        return partition;
    }

    @Override
    public Map<String, Object> getData() {
        return super.getData();
    }

    @Override
    public Double getTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> getDataInGroup() {
        return super.getDataInGroup();
    }

}
