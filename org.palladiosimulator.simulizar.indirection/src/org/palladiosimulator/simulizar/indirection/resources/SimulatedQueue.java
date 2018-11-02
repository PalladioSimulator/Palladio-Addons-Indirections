package org.palladiosimulator.simulizar.indirection.resources;

public interface SimulatedQueue<T> {

    int size();

    T pop();

    void push(T deepCopy);
}
