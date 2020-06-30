package org.palladiosimulator.indirections.scheduler.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.JoiningOperator.KeyedChannel;

public class JoinedDate<T extends IndirectionDate> implements GroupingIndirectionDate<T> {
    public Map<KeyedChannel<DateWithConnector<T>, Object>, T> data;
    protected final Map<String, T> extraData;

    public JoinedDate(final Map<KeyedChannel<DateWithConnector<T>, Object>, T> dataMap) {
        this.data = dataMap;
        this.extraData = new HashMap<>();
    }

    @Override
    public void addDate(final String key, final Object value) {
        this.extraData.put(key, (T) value);
    }

    @Override
    public Map<String, Object> getData() {
        final Map<String, Object> result = new HashMap<String, Object>();

        for (final Entry<KeyedChannel<DateWithConnector<T>, Object>, T> t : this.data.entrySet()) {
            for (final String key : t.getValue()
                .getData()
                .keySet()) {
                final String newKey = t.getKey()
                    .toString() + "." + key;
                if (result.containsKey(newKey)) {
                    throw new IllegalStateException();
                }
                result.put(newKey, t.getValue()
                    .getData()
                    .get(key));
            }
        }

        return result;
    }

    @Override
    public List<T> getDataInGroup() {
        return Stream.concat(this.data.values()
            .stream(),
                this.extraData.values()
                    .stream())
            .collect(Collectors.toList());
    }

    @Override
    public Double getTime() {
        throw new UnsupportedOperationException();
    }
}
