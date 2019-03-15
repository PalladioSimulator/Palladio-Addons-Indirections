package org.palladiosimulator.simulizar.indirection.resources;

import org.palladiosimulator.simulizar.indirection.characteristics.CharacteristicFilter;

public interface SimulatedQueue {
    Frame pop(CharacteristicFilter filter);

    void push(Frame frame);

    long totalAvailable();
    long totalCapacity();

    Frame peek(CharacteristicFilter filter, long num);

    long canProvideHowManyOf(CharacteristicFilter filter);

    long canAcceptHowManyOf(CharacteristicFilter filter);

    long canProvideHowMany();
    long canAcceptHowMany();
}
