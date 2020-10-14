package org.palladiosimulator.indirections.scheduler.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class ConcreteGroupingIndirectionDate<T extends IndirectionDate> implements GroupingIndirectionDate<T> {
    private final List<T> dataInGroup;
    protected final Map<String, Object> extraData;
    public final UUID uuid = UUID.randomUUID();
    private final List<IndirectionDate> referencedData = new ArrayList<>();

    public ConcreteGroupingIndirectionDate(final List<T> dataInGroup) {
        this(dataInGroup, new HashMap<>());
    }

    public ConcreteGroupingIndirectionDate(final List<T> dataInGroup, final Map<String, Object> extraData) {
        this.dataInGroup = dataInGroup;
        this.extraData = new HashMap<>(extraData);
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
    public Collection<Double> getTime() {
        return this.getDataInGroup()
            .stream()
            .flatMap(it -> it.getTime()
                .stream())
            .collect(Collectors.toList());
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

    @Override
    public void addReferencedData(IndirectionDate indirectionDate) {
        this.referencedData.add(indirectionDate);
    }

    @Override
    public Collection<IndirectionDate> getReferencedData() {
        return Stream.concat(this.referencedData.stream(), this.getDataInGroup()
            .stream()
            .flatMap(it -> it.getReferencedData()
                .stream()))
            .collect(Collectors.toList());
    }
}
