package org.palladiosimulator.simulizar.indirection.resources.manipulation;

import org.palladiosimulator.simulizar.indirection.characteristics.Characteristic;
import org.palladiosimulator.simulizar.indirection.resources.CharacteristicsContainer;
import org.palladiosimulator.simulizar.indirection.resources.Frame;

public class Aggregate {
    public static void average(CharacteristicsContainer container, String stringCount) {
        int count = Integer.valueOf(stringCount);

        Double averageBirth = container.frames.stream().limit(count).mapToDouble(Frame::birth).average().getAsDouble();
        Double averageSpecification = container.frames.stream().limit(count).mapToDouble(Frame::specification).average().getAsDouble();
        
        Characteristic c = null;
        for (int i = 0; i < count; i++) {
            Frame f = container.frames.remove(0);
            if (c != null) { // ensure that all have the same characteristic
                if (c != f.characteristic) {
                    throw new IllegalStateException("Stack manipulation failed because different characteristics were found");
                }
            } else {
                c = f.characteristic;
            }
        }
        
        container.add(new Frame(c, averageBirth, averageSpecification));
    }
}
