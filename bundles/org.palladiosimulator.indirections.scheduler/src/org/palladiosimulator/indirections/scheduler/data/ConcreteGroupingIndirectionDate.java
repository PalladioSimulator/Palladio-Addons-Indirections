package org.palladiosimulator.indirections.scheduler.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class ConcreteGroupingIndirectionDate<T extends IndirectionDate> implements GroupingIndirectionDate<T> {
    private final List<T> dataInGroup;
    protected final Map<String, Object> extraData;
    public final UUID uuid = UUID.randomUUID();

    public ConcreteGroupingIndirectionDate(final List<T> dataInGroup) {
        this(dataInGroup, new HashMap<>());
    }

    public ConcreteGroupingIndirectionDate(final List<T> dataInGroup, final Map<String, Object> extraData) {
        this.dataInGroup = dataInGroup;
        this.extraData = extraData;
    }

    @Override
    public void addDate(final String key, final Object value) {
        this.extraData.put(key, value);
    }

    @Override
    public Map<String, Object> getData() {
        final HashMap<String, Object> result = new HashMap<>(this.extraData);
        result.put("NUMBER_OF_ELEMENTS.VALUE", this.dataInGroup.size());
        result.put("INNER_ELEMENTS.VALUE", this.dataInGroup);
        return result;
    }

    @Override
    public List<T> getDataInGroup() {
        return Collections.unmodifiableList(this.dataInGroup);
    }

    @Override
    public Double getTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        final String dataToString = this.dataInGroup.stream()
            .map(it -> "(" + it.getData()
                .entrySet()
                .stream()
                .map(e -> {
                    return e.getKey() + "->" + e.getValue();
                })
                .collect(Collectors.joining(";")) + ")")
            .collect(Collectors.joining(","));
        final String extraDataString = this.extraData.entrySet()
            .stream()
            .map(it -> "(" + it.getKey() + "->" + it.getValue())
            .collect(Collectors.joining(";"));
        return "<" + this.getClass()
            .getSimpleName() + " (" + this.uuid + "): " + dataToString + ", extra: " + extraDataString + ">";
    }
}
