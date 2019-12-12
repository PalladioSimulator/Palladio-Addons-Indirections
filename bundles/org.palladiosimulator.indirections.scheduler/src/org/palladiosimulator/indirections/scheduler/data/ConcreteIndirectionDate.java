package org.palladiosimulator.indirections.scheduler.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.pcm.core.PCMRandomVariable;

public class ConcreteIndirectionDate implements IndirectionDate {
    private final Map<String, Object> data;
    private final double time;
    public final UUID uuid = UUID.randomUUID();

    public ConcreteIndirectionDate(Map<String, Object> data, double time) {
        this.data = Collections.unmodifiableMap(new HashMap<>(data));
        this.time = time;
    }

    @Override
    public Map<String, Object> getData() {
        return data;
    }

    @Override
    public Double getTime() {
        return time;
    }

    @Override
    public String toString() {
        String dataToString = data.entrySet().stream().map(it -> it.getKey() + "->" + it.getValue())
                .collect(Collectors.joining(","));
        return "<" + this.getClass().getSimpleName() + " (" + uuid + "): " + dataToString + ">";
    }

    @Override
    public Object evaluate(PCMRandomVariable expression) {
        throw new UnsupportedOperationException();
    }
}
