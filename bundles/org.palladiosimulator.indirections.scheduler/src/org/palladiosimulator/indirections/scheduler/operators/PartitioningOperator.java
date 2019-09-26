package org.palladiosimulator.indirections.scheduler.operators;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.GroupingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.PartitionedIndirectionDate;

public abstract class PartitioningOperator<T>
        extends SimStatefulOperator<GroupingIndirectionDate, PartitionedIndirectionDate<T>> {
    public PartitioningOperator(List<Consumer<PartitionedIndirectionDate<T>>> emitsTo) {
        super(emitsTo);
    }

    @Override
    public void accept(GroupingIndirectionDate group) {
        Map<T, List<IndirectionDate>> collect = group.getDataInGroup().stream()
                .collect(Collectors.groupingBy(this::getPartition));

        emit(new PartitionedIndirectionDate<T>(collect));
    }

    protected abstract T getPartition(IndirectionDate date);
}