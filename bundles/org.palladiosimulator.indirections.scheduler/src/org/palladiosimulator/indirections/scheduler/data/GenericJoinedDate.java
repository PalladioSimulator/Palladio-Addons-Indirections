package org.palladiosimulator.indirections.scheduler.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

/**
 * A joined date that retains information about where elements come from in form of tags.
 *
 * @param <T>
 *            the type of the resulting date
 * @param <TAG>
 *            type of the information about the source of the data
 */
public class GenericJoinedDate<T extends IndirectionDate, TAG> implements GroupingIndirectionDate<T> {
    public Map<TAG, TaggedDate<T, TAG>> data;
    protected final Map<String, Object> extraData;

    public GenericJoinedDate(final Map<TAG, TaggedDate<T, TAG>> dataMap) {
        this.data = dataMap;
        this.extraData = new HashMap<>();
    }

    public static <T extends IndirectionDate, TAG> GenericJoinedDate<T, TAG> of(Collection<TaggedDate<T, TAG>> data) {
        var dataMap = data.stream()
            .collect(Collectors.toMap(it -> it.tag, Function.identity()));
        return new GenericJoinedDate<>(dataMap);
    }

    public static <T extends IndirectionDate, TAG> GenericJoinedDate<T, TAG> of(Map<TAG, T> data) {
        var dataMap = data.entrySet()
            .stream()
            .collect(Collectors.toMap(it -> it.getKey(), it -> new TaggedDate<>(it.getKey(), it.getValue())));
        return new GenericJoinedDate<>(dataMap);
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
        return this.data.values()
            .stream()
            .map(it -> it.date)
            .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<Double> getTime() {
        return this.getDataInGroup()
            .stream()
            .flatMap(it -> it.getTime()
                .stream())
            .collect(Collectors.toList());
    }
}
