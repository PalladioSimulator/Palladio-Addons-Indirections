package org.palladiosimulator.indirections.scheduler.operators;

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
        Map<P, List<IndirectionDate>> collect = group.getDataInGroup().stream()
                .collect(Collectors.groupingBy(this::getPartition));

        emit(new PartitionedIndirectionDate<P, T>(collect));
    }

    protected abstract P getPartition(IndirectionDate date);
}