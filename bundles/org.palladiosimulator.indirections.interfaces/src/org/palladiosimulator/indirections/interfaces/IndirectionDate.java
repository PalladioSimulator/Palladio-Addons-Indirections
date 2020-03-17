package org.palladiosimulator.indirections.interfaces;

import java.util.Map;
import java.util.Map.Entry;

import org.palladiosimulator.pcm.core.PCMRandomVariable;

public interface IndirectionDate {
    Map<String, Object> getData();
    Double getTime();
    Object evaluate(PCMRandomVariable expression);
    void addDate(String key, Object value);
    
	default void addData(Map<String, Object> newEntries) {
		for (Entry<String, Object> entry : newEntries.entrySet()) {
			addDate(entry.getKey(), entry.getValue());
		}
	}
}
