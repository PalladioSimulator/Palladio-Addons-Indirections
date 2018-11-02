package org.palladiosimulator.simulizar.indirection.resources;

import org.palladiosimulator.simulizar.indirection.characteristics.Characteristic;

public class Frame {
    public final Characteristic characteristic;
    public final Double birth;

    public Frame(Characteristic characteristic, Double birth) {
        this.characteristic = characteristic;
        this.birth = birth;
    }
    

    public Characteristic characteristic() {
        return this.characteristic;
    }
    
    public Double birth() {
        return this.birth();
    }
}