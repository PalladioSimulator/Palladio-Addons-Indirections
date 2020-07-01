package org.palladiosimulator.indirections.scheduler.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class GenericJoinedDate<T extends IndirectionDate, TAG, TAGGED extends TaggedDate<T, TAG>>
        implements GroupingIndirectionDate<T> {
    public Map<TAG, TAGGED> data;
    protected final Map<String, Object> extraData;

    public GenericJoinedDate(final Map<TAG, TAGGED> dataMap) {
        this.data = dataMap;
        this.extraData = new HashMap<>();
    }

    @Override
    public void addDate(final String key, final Object value) {
        this.extraData.put(key, value);
    }

    @Override
    public Map<String, Object> getData() {
        final Map<String, Object> result = new HashMap<String, Object>();

        for (var t : this.data.entrySet()) {
            for (final String key : t.getValue().date.getData()
                .keySet()) {
                final String newKey = t.getKey()
                    .toString() + "." + key;
                if (result.containsKey(newKey)) {
                    throw new IllegalStateException();
                }
                result.put(newKey, t.getValue().date.getData()
                    .get(key));
            }
        }

        return result;
    }

    @Override
    public List<T> getDataInGroup() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Double getTime() {
        throw new UnsupportedOperationException();
    }
}
