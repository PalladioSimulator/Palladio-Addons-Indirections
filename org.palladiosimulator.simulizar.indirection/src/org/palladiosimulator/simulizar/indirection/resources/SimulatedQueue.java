package org.palladiosimulator.simulizar.indirection.resources;

public interface SimulatedQueue {
    Frame pop();

    void push(Frame frame);

    long totalAvailable();

    long totalCapacity();

    Frame peek(long num);

    long canProvideHowMany();

    long canAcceptHowMany();
}
