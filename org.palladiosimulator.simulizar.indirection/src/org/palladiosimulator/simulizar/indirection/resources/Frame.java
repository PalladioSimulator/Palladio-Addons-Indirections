package org.palladiosimulator.simulizar.indirection.resources;

import org.palladiosimulator.simulizar.indirection.characteristics.Characteristic;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;

public class Frame {
    public final Characteristic characteristic;
    public final Double birth;
    public final Double specification;

    public Frame(Characteristic characteristic, Double birth) {
        this.characteristic = characteristic;
        this.birth = birth;
        this.specification = (Double) StackContext.evaluateStatic(characteristic.getSpecification());
    }
    

    public Frame(Characteristic characteristic, Double birth, Double specification) {
        this.characteristic = characteristic;
        this.birth = birth;
        this.specification = specification;
    }


    public Characteristic characteristic() {
        return this.characteristic;
    }
    
    public Double birth() {
        return this.birth;
    }
    
    public Double specification() {
        return this.specification;
    }
}