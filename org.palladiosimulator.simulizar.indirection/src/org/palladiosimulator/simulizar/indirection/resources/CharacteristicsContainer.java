package org.palladiosimulator.simulizar.indirection.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.palladiosimulator.simulizar.indirection.characteristics.Characteristic;

import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStack;

public class CharacteristicsContainer {
    private CharacteristicsContainer(SimulatedStack<Object> stack) {
        stack.rootFrame().addValue(CHARACTERISTIC_KEY, this);
    }
    
    public static CharacteristicsContainer find(SimulatedStack<Object> stack) {
        try {
            return (CharacteristicsContainer) stack.rootFrame().getValue(CHARACTERISTIC_KEY);
        } catch (ValueNotInFrameException e) {
            return new CharacteristicsContainer(stack);
        }
    }
    
    public final static String CHARACTERISTIC_KEY = "__CHARACTERISTICS__";
    
    public final Collection<Characteristic> ownCharacteristics = new HashSet<Characteristic>();
    public final List<Frame> frames = new ArrayList<Frame>();
    public void add(Frame frame) {
        this.frames.add(frame);
    }

    public List<Frame> frames(Characteristic characteristic) {
        return frames.stream().filter(it -> it.characteristic.equals(characteristic)).collect(Collectors.toList());
    }
    
    public List<Frame> frames() {
        return new ArrayList<>(this.frames);
    }
}
