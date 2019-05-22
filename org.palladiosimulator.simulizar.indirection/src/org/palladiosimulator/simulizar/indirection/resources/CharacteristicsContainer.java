package org.palladiosimulator.simulizar.indirection.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.palladiosimulator.simulizar.indirection.characteristics.Characteristic;

import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStack;

public class CharacteristicsContainer {
    private CharacteristicsContainer(SimulatedStack<Object> stack) {
        stack.rootFrame().addValue(CHARACTERISTIC_KEY, this);
    }

    public static CharacteristicsContainer getOrCreate(SimulatedStack<Object> stack) {
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
        return frames.stream().filter(it -> it.characteristics().contains(characteristic)).collect(Collectors.toList());
    }
    
    public List<Frame> frames(Collection<Characteristic> characteristics) {
        return frames.stream().filter(it -> it.characteristics().equals(new HashSet<>(characteristics))).collect(Collectors.toList());
    }

    public List<Frame> frames() {
        return new ArrayList<>(this.frames);
    }
}
