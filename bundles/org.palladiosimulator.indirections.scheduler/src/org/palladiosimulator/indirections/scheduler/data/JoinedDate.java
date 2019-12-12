package org.palladiosimulator.indirections.scheduler.data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.JoiningOperator.KeyedChannel;
import org.palladiosimulator.pcm.core.PCMRandomVariable;

public class JoinedDate<T extends IndirectionDate> implements GroupingIndirectionDate<T> {
    public Map<KeyedChannel<DataWithSource<T>, Object>, T> data;

    public JoinedDate(Map<KeyedChannel<DataWithSource<T>, Object>, T> dataMap) {
        this.data = dataMap;
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
        return data.values().stream().collect(Collectors.toList());
    }

    @Override
    public Object evaluate(PCMRandomVariable expression) {
        throw new UnsupportedOperationException();
    }
}
