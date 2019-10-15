package org.palladiosimulator.indirections.scheduler.operators;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.GroupingIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.WindowingIndirectionDate;

public class HoldbackOperator<T extends IndirectionDate>
        extends SimStatefulOperator<GroupingIndirectionDate<T>, WindowingIndirectionDate<GroupingIndirectionDate<T>>> {

    public HoldbackOperator(String key, int holdback) {
        throw new IllegalStateException();
    }

    @Override
    public void accept(GroupingIndirectionDate<T> t) {
        throw new IllegalStateException();
    }

}
