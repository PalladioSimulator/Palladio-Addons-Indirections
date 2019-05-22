package org.palladiosimulator.simulizar.indirection.resources;

import java.util.Map;
import java.util.Set;

import org.palladiosimulator.simulizar.indirection.characteristics.Characteristic;

public class Frame {
    public final Double birth;
    private final Map<Characteristic, Double> manifestations;

    public Frame(Double birth, Map<Characteristic, String> specifications) {
        this.birth = birth;
        this.manifestations = CharacteristicsUtil.evaluateSpecification(specifications);
    }   

    public Double birth() {
        return this.birth;
    }

    public Map<Characteristic, Double> manifestations() {
        return manifestations;
    }
    
    public Set<Characteristic> characteristics() {
        return manifestations.keySet();
    }

}