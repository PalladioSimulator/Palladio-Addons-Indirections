package org.palladiosimulator.indirections.interfaces;

import java.util.HashMap;
import java.util.Map;

public class IndirectionDate {
    public final Map<String, Object> data;
    private final Double time;
    
    public IndirectionDate(Map<String, Object> map, Double time) {
        data = new HashMap<>(map);
        this.time = time;
    }

    public Double getTime() {
        return this.time;
    }
}
