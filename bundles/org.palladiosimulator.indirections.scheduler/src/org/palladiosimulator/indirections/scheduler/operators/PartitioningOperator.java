package org.palladiosimulator.indirections.scheduler.operators;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.GroupingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.PartitionedIndirectionDate;

public abstract class PartitioningOperator<P, T extends IndirectionDate>
        extends SimStatefulOperator<GroupingIndirectionDate<T>, PartitionedIndirectionDate<P, T>> {

    @Override
    public void accept(GroupingIndirectionDate<T> group) {
        Map<P, List<T>> collect = group.getDataInGroup().stream().collect(Collectors.groupingBy(this::getPartition));

        this.observers.forEach(it -> it.notifyNumberOfPartitions(collect.size()));

        for (Map.Entry<P, List<T>> mapEntry : collect.entrySet()) {
            PartitionedIndirectionDate<P, T> partitionedDateToEmit = new PartitionedIndirectionDate<P, T>(
                    mapEntry.getKey(), mapEntry.getValue(), group.getData());
            emit(partitionedDateToEmit);
        }
    }

    protected abstract P getPartition(IndirectionDate date);

    public static interface Observer {
        void notifyNumberOfPartitions(int size);
    }

    private final Collection<PartitioningOperator.Observer> observers = new HashSet<PartitioningOperator.Observer>();

    public void addObserver(PartitioningOperator.Observer observer) {
        this.observers.add(observer);
    }
}