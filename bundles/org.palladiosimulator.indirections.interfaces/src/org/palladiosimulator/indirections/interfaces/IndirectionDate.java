package org.palladiosimulator.indirections.interfaces;

import java.util.HashMap;
import java.util.Map;

public class IndirectionDate {
    public final Map<String, Object> data;
    
    public IndirectionDate() {
        data = new HashMap<>();
    }

    public IndirectionDate(Map<String, Object> map) {
        this();
        data.putAll(map);
    }
}
