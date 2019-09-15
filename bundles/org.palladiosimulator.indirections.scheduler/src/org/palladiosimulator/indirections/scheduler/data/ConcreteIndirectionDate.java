package org.palladiosimulator.indirections.scheduler.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class ConcreteIndirectionDate implements IndirectionDate {
    private final Map<String, Object> data;
    private final double time;

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

}
