package org.palladiosimulator.indirections.scheduler.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    private final List<IndirectionDate> referencedData = new ArrayList<>();
    public UUID uuid = UUID.randomUUID();

    public GenericJoinedDate(final Map<TAG, TaggedDate<T, TAG>> dataMap) {
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
        return this.data.values()
            .stream()
            .map(it -> it.date)
            .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void addReferencedDate(IndirectionDate indirectionDate) {
        this.referencedData.add(indirectionDate);
    }

    @Override
    public Stream<IndirectionDate> getReferencedData() {
        return Stream.concat(this.referencedData.stream(), this.getDataInGroup()
                .stream());
    }
    
    @Override
    public UUID getUUID() {
        return uuid;
    }
}
