package org.palladiosimulator.indirections.interfaces;

import java.util.Map;

import org.palladiosimulator.pcm.core.PCMRandomVariable;

public interface IndirectionDate {
    public Map<String, Object> getData();

    public Double getTime();

    public Object evaluate(PCMRandomVariable expression);
}
