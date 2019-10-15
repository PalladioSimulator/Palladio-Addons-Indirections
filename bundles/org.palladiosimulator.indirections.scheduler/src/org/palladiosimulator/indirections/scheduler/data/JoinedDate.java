package org.palladiosimulator.indirections.scheduler.data;

import java.util.List;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.JoiningOperator.Channel;

public class JoinedDate<T extends IndirectionDate> implements GroupingIndirectionDate<T> {
    public JoinedDate(Map<Channel<DataWithSource<T>>, T> dataMap) {
        super();
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
        // TODO Auto-generated method stub
        return null;
    }

}
