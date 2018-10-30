package org.palladiosimulator.simulizar.indirection.resources;

import java.util.ArrayList;
import java.util.List;

public class FairSimulatedQueue<T> implements SimulatedQueue<T> {
    private List<T> backing;

    public FairSimulatedQueue() {
        this.backing = new ArrayList<T>();
    }

    @Override
    public int size() {
        return this.backing.size();
    }

    @Override
    public T pop() {
        return this.backing.remove(0);
    }

    @Override
    public void push(T element) {
        this.backing.add(element);
    }

}
